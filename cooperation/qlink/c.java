package cooperation.qlink;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f390499a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private QlinkServiceProxy f390500b;

    /* renamed from: c, reason: collision with root package name */
    private QQAppInterface f390501c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a extends RemoteCommand {
        a(String str) {
            super(str);
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
        public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
            c.this.f390501c.getQQProxyForQlink().r(bundle);
            return null;
        }
    }

    public c(QQAppInterface qQAppInterface) {
        this.f390501c = qQAppInterface;
        this.f390500b = new QlinkServiceProxy(qQAppInterface);
    }

    private int h(String str, Bundle bundle, Handler handler, long j3) {
        SendMsg sendMsg = new SendMsg(str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.size() > 0) {
            sendMsg.f390487e.putAll(bundle);
        }
        int incrementAndGet = this.f390499a.incrementAndGet();
        sendMsg.c(incrementAndGet);
        if (j3 > 0) {
            sendMsg.e(j3);
        }
        try {
            this.f390500b.k(sendMsg);
            return incrementAndGet;
        } catch (Exception e16) {
            e16.printStackTrace();
            throw new RuntimeException("sendMsg is fail", e16);
        }
    }

    public boolean d(long j3, int i3, long j16, long j17, byte[] bArr, byte[] bArr2) {
        return true;
    }

    public boolean e(byte[] bArr) {
        return true;
    }

    public void f() {
        PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (pluginCommunicationHandler == null) {
            QLog.e("QlinkServiceManager", 1, "[QLINK] QQ - PluginCommunicationHandler.getInstance failed");
        } else {
            pluginCommunicationHandler.register(new a("qlink.notify"));
        }
    }

    public int g(String str, Bundle bundle) {
        try {
            return h(str, bundle, null, 0L);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public void b(long j3) {
    }

    public void c(long j3) {
    }
}
