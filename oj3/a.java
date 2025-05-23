package oj3;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.zplan.proxy.channel.request.ChannelRequestHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Loj3/a;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent request, FromServiceMsg response) {
        long j3;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
            QLog.d("ChannelRequestServlet", 2, "onReceive cmd=" + request.getStringExtra("cmd") + ",success=" + response.isSuccess());
        } else {
            j3 = 0;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (peekAppRuntime instanceof ToolRuntimePeak) {
            peekAppRuntime = peekAppRuntime.getAppRuntime("peak");
        } else if (peekAppRuntime instanceof VideoAppInterface) {
            peekAppRuntime = peekAppRuntime.getAppRuntime("module_video");
        }
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(ChannelRequestHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.proxy.channel.request.ChannelRequestHandler");
        ((ChannelRequestHandler) businessHandler).F2(request, response, response.getWupBuffer());
        if (QLog.isColorLevel()) {
            QLog.d("ChannelRequestServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - j3));
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent request, Packet packet) {
        Intrinsics.checkNotNull(request);
        String stringExtra = request.getStringExtra("cmd");
        byte[] byteArrayExtra = request.getByteArrayExtra("data");
        long longExtra = request.getLongExtra("timeout", 30000L);
        if (!TextUtils.isEmpty(stringExtra)) {
            Intrinsics.checkNotNull(packet);
            packet.setSSOCommand(stringExtra);
            packet.setTimeout(longExtra);
            packet.putSendData(byteArrayExtra);
        }
        QLog.d("ChannelRequestServlet", 2, "onSend exit cmd=" + stringExtra);
    }
}
