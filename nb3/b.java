package nb3;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.wxmini.wxacontainer.WxAppInterface;
import com.tencent.mobileqq.wxmini.wxacontainer.request.WxaSSOHandler;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lnb3/b;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "a", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent request, FromServiceMsg response) {
        ToServiceMsg toServiceMsg;
        Intrinsics.checkNotNullParameter(response, "response");
        if (request != null) {
            toServiceMsg = (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            HashMap<String, Object> hashMap = response.attributes;
            Intrinsics.checkNotNullExpressionValue(hashMap, "response.attributes");
            hashMap.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", response.getUin(), response.getServiceCmd());
        }
        if (QLog.isColorLevel()) {
            QLog.i("[wxa-q]WxaServlet", 2, "onReceive,ttt2 cmd[" + response.getServiceCmd() + ']');
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        WxAppInterface wxAppInterface = peekAppRuntime instanceof WxAppInterface ? (WxAppInterface) peekAppRuntime : null;
        if (wxAppInterface != null && toServiceMsg != null) {
            BusinessHandler businessHandler = wxAppInterface.getBusinessHandler(WxaSSOHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wxmini.wxacontainer.request.WxaSSOHandler");
            ((WxaSSOHandler) businessHandler).onReceive(toServiceMsg, response, fh.a(response.getWupBuffer()));
            return;
        }
        QLog.e("[wxa-q]WxaServlet", 1, "[onReceive] err, appInterface is " + wxAppInterface + ", toMsg is " + toServiceMsg + " !");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent request, Packet packet) {
        if (request != null) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            if (toServiceMsg != null) {
                Intrinsics.checkNotNull(packet);
                packet.setSSOCommand(toServiceMsg.getServiceCmd());
                packet.putSendData(fh.b(toServiceMsg.getWupBuffer()));
                packet.setTimeout(toServiceMsg.getTimeout());
                packet.setAttributes(toServiceMsg.getAttributes());
                if (QLog.isColorLevel()) {
                    QLog.i("[wxa-q]WxaServlet", 2, "send, cmd[" + toServiceMsg.getServiceCmd() + ']');
                    return;
                }
                return;
            }
            QLog.e("[wxa-q]WxaServlet", 1, "[onSend] toMsg is null");
            return;
        }
        QLog.e("[wxa-q]WxaServlet", 1, "[onSend] request is null");
    }
}
