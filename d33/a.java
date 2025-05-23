package d33;

import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.sso.ZplanVasBusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Ld33/a;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent request, FromServiceMsg response) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(response, "response");
        ToServiceMsg toServiceMsg = request != null ? (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName()) : null;
        if (!(toServiceMsg instanceof ToServiceMsg)) {
            toServiceMsg = null;
        }
        if (toServiceMsg == null) {
            toServiceMsg = new ToServiceMsg("", response.getUin(), response.getServiceCmd());
        } else {
            HashMap<String, Object> hashMap = response.attributes;
            Intrinsics.checkNotNullExpressionValue(hashMap, "response.attributes");
            hashMap.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(MSFServlet.TAG, 4, "onReceive, cmd[" + response.getServiceCmd() + "]");
        }
        if (response.isSuccess()) {
            int length = response.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, response.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof ToolRuntimePeak) {
            waitAppRuntime = waitAppRuntime.getAppRuntime("peak");
        } else if (waitAppRuntime instanceof VideoAppInterface) {
            waitAppRuntime = waitAppRuntime.getAppRuntime("module_video");
        }
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) waitAppRuntime).getBusinessHandler(ZplanVasBusinessHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.vas.sso.ZplanVasBusinessHandler");
        ((ZplanVasBusinessHandler) businessHandler).onReceive(toServiceMsg, response, bArr);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent request, Packet packet) {
        if (request != null && packet != null) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            if (toServiceMsg == null) {
                QLog.i(MSFServlet.TAG, 4, " onSend toMsg is null");
                return;
            }
            packet.setSSOCommand(toServiceMsg.getServiceCmd());
            byte[] wupBuffer = toServiceMsg.getWupBuffer();
            if (wupBuffer != null) {
                byte[] bArr = new byte[wupBuffer.length + 4];
                PkgTools.dWord2Byte(bArr, 0, wupBuffer.length + 4);
                PkgTools.copyData(bArr, 4, wupBuffer, wupBuffer.length);
                packet.putSendData(bArr);
            } else {
                byte[] bArr2 = new byte[4];
                PkgTools.dWord2Byte(bArr2, 0, 4L);
                packet.putSendData(bArr2);
            }
            packet.setTimeout(toServiceMsg.getTimeout());
            HashMap<String, Object> attributes = toServiceMsg.getAttributes();
            Intrinsics.checkNotNull(attributes, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
            packet.setAttributes(attributes);
            return;
        }
        QLog.i(MSFServlet.TAG, 4, " onSend request error, request: " + request + " , packet: " + packet);
    }
}
