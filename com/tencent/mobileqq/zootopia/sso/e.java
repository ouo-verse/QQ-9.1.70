package com.tencent.mobileqq.zootopia.sso;

import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/sso/e;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent request, FromServiceMsg response) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        ToServiceMsg toServiceMsg = (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        if (toServiceMsg == null) {
            toServiceMsg = new ToServiceMsg("", response.getUin(), response.getServiceCmd());
        }
        HashMap<String, Object> hashMap = response.attributes;
        Intrinsics.checkNotNullExpressionValue(hashMap, "response.attributes");
        hashMap.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
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
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof ToolAppRuntime) {
            peekAppRuntime = peekAppRuntime.getAppRuntime("modular_web");
        } else if (peekAppRuntime instanceof ToolRuntimePeak) {
            peekAppRuntime = peekAppRuntime.getAppRuntime("peak");
        } else if (peekAppRuntime instanceof VideoAppInterface) {
            peekAppRuntime = peekAppRuntime.getAppRuntime("module_video");
        }
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(ZootopiaBusinessHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.sso.ZootopiaBusinessHandler");
        ((ZootopiaBusinessHandler) businessHandler).onReceive(toServiceMsg, response, bArr);
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
