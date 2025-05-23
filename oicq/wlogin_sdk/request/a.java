package oicq.wlogin_sdk.request;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.net.InetSocketAddress;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public String f422868a;

    /* renamed from: b, reason: collision with root package name */
    public int f422869b;

    /* renamed from: c, reason: collision with root package name */
    public InetSocketAddress f422870c;

    public a(String str, int i3) {
        this.f422868a = str;
        this.f422869b = i3;
    }

    public static InetSocketAddress a(String str, int i3, long j3) {
        InetSocketAddress inetSocketAddress;
        try {
            a aVar = new a(str, i3);
            BaseThread baseThread = new BaseThread(aVar);
            baseThread.start();
            baseThread.join(j3);
            synchronized (aVar) {
                inetSocketAddress = aVar.f422870c;
            }
            return inetSocketAddress;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f422868a, this.f422869b);
            synchronized (this) {
                this.f422870c = inetSocketAddress;
            }
        } catch (Exception unused) {
        }
    }
}
