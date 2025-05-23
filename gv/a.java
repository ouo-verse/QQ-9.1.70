package gv;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static final a f403415d = new a();

    /* renamed from: a, reason: collision with root package name */
    private Handler f403416a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f403417b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f403418c;

    a() {
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("AVNetworkHandler", 0);
        this.f403418c = newFreeHandlerThread;
        newFreeHandlerThread.start();
        this.f403416a = new Handler(this.f403418c.getLooper());
        this.f403417b = new Handler(Looper.getMainLooper());
    }

    public static a a() {
        return f403415d;
    }

    public Handler b() {
        return this.f403416a;
    }

    public Looper c() {
        return this.f403418c.getLooper();
    }
}
