package c.t.m.sapp.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f30148a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public static e f30149b;

    /* renamed from: d, reason: collision with root package name */
    public HandlerThread f30151d;

    /* renamed from: e, reason: collision with root package name */
    public a f30152e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f30153f;

    /* renamed from: g, reason: collision with root package name */
    public Context f30154g;

    /* renamed from: h, reason: collision with root package name */
    public j f30155h;

    /* renamed from: c, reason: collision with root package name */
    public final String f30150c = "DexAsynchHandler";

    /* renamed from: i, reason: collision with root package name */
    public SimpleDateFormat f30156i = new SimpleDateFormat("HHmmss");

    /* renamed from: j, reason: collision with root package name */
    public SimpleDateFormat f30157j = new SimpleDateFormat("yyyyMMdd-HHmmss");

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public StringBuilder f30158a;

        public a(Looper looper) {
            super(looper);
            StringBuilder sb5 = new StringBuilder(1024);
            this.f30158a = sb5;
            sb5.setLength(0);
        }

        public void a(Message message) {
            try {
                if (message.what == 10008) {
                    q.a(e.this.f30154g);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            a(message);
        }
    }

    public e(Context context) {
        this.f30154g = context.getApplicationContext();
        this.f30155h = new j(this.f30154g);
    }

    public static e b() {
        return f30149b;
    }

    public void a() {
    }

    public void c() {
        try {
            if (this.f30153f) {
                return;
            }
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("d_thread");
            this.f30151d = baseHandlerThread;
            baseHandlerThread.start();
            a aVar = new a(this.f30151d.getLooper());
            this.f30152e = aVar;
            this.f30153f = true;
            n.a(aVar, 10008, 1000L);
        } catch (Throwable unused) {
            q.a(this.f30154g);
        }
    }

    public void a(String str, String str2) {
    }

    public static e a(Context context) {
        if (f30149b == null) {
            synchronized (e.class) {
                if (f30149b == null) {
                    f30149b = new e(context);
                }
            }
        }
        return f30149b;
    }

    public void d() {
    }
}
