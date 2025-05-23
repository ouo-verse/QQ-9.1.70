package n43;

import android.content.Intent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Ln43/b;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "intent", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "fromServiceMsg", "onReceive", "<init>", "()V", "d", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(@NotNull Intent intent, @NotNull FromServiceMsg fromServiceMsg) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fromServiceMsg, "fromServiceMsg");
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd == null) {
            return;
        }
        QLog.d("QQSportsUserServerServlet", 2, "onReceive cmd=" + intent.getStringExtra("cmd") + ",success=" + fromServiceMsg.isSuccess());
        if (Intrinsics.areEqual(serviceCmd, "trpc.qq_sports.user_server.CommInfo.SsoUserStep")) {
            a.f418307a.b(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@NotNull Intent request, @NotNull Packet packet) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(packet, "packet");
        byte[] byteArrayExtra = request.getByteArrayExtra("data");
        String stringExtra = request.getStringExtra("cmd");
        long longExtra = request.getLongExtra("timeout", 10000L);
        packet.setSSOCommand(stringExtra);
        packet.setTimeout(longExtra);
        packet.putSendData(byteArrayExtra);
        QLog.d("QQSportsUserServerServlet", 2, "onSend exit cmd=" + stringExtra);
    }
}
