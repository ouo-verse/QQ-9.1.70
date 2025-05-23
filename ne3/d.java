package ne3;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.zplan.authorize.impl.checker.cloudmod.CloudWeakNetEvent;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lne3/d;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent request, FromServiceMsg response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (Intrinsics.areEqual(BaseConstants.CMD_GET_WEAK_NET, response.getServiceCmd())) {
            Object attribute = response.getAttribute(BaseConstants.ATTRIBUTE_KEY_GET_WEAK_NET, Boolean.FALSE);
            Intrinsics.checkNotNull(attribute, "null cannot be cast to non-null type kotlin.Boolean");
            SimpleEventBus.getInstance().dispatchEvent(new CloudWeakNetEvent(((Boolean) attribute).booleanValue()));
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent request, Packet packet) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (Intrinsics.areEqual("action_send_weak_network_pkg", request.getAction())) {
            sendToMSF(request, MsfServiceSdk.get().getWeakNetStatusMsg());
        }
    }
}
