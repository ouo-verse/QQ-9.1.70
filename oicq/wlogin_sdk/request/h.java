package oicq.wlogin_sdk.request;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.net.HttpURLConnection;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public HttpURLConnection f422893a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f422894b = false;

    public h(HttpURLConnection httpURLConnection) {
        this.f422893a = httpURLConnection;
    }

    public static boolean a(HttpURLConnection httpURLConnection, long j3) {
        try {
            h hVar = new h(httpURLConnection);
            BaseThread baseThread = new BaseThread(hVar);
            baseThread.start();
            baseThread.join(j3);
            return hVar.f422894b;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f422893a.connect();
            this.f422894b = true;
        } catch (Throwable th5) {
            util.printThrowable(th5, "");
        }
    }
}
