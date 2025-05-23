package com.tencent.mobileqq.qqvideoedit.thirdparty.youtu;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.SimpleGLThread;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes17.dex */
public class YTHDR {

    /* renamed from: c, reason: collision with root package name */
    private int f276214c;

    /* renamed from: d, reason: collision with root package name */
    private a f276215d;

    /* renamed from: e, reason: collision with root package name */
    private SimpleGLThread f276216e;

    /* renamed from: f, reason: collision with root package name */
    private int f276217f;

    /* renamed from: g, reason: collision with root package name */
    private int f276218g;

    /* renamed from: h, reason: collision with root package name */
    private int f276219h;

    /* renamed from: i, reason: collision with root package name */
    private int f276220i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.a f276224m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.a f276225n;

    /* renamed from: o, reason: collision with root package name */
    private ByteBuffer f276226o;

    /* renamed from: a, reason: collision with root package name */
    private boolean f276212a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f276213b = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f276221j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f276222k = false;

    /* renamed from: l, reason: collision with root package name */
    private Object f276223l = new Object();

    public YTHDR() {
        nativeConstructor();
    }

    private void A() {
        synchronized (this.f276223l) {
            try {
                ms.a.f("YTHDR", "waitLockDone|wait hdr ...");
                this.f276223l.wait(500L);
            } catch (Exception e16) {
                ms.a.c("YTHDR", "waitLockDone|exception:" + e16.getMessage());
            }
        }
    }

    static /* bridge */ /* synthetic */ b j(YTHDR ythdr) {
        ythdr.getClass();
        return null;
    }

    private native void nativeConstructor();

    private native String nativeGetVersion();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeInit(String str, String str2, int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeProcess(ByteBuffer byteBuffer, int i3);

    private native Bitmap nativeProcess(Bitmap bitmap);

    private native byte[] nativeProcess(byte[] bArr, int i3, int i16);

    private native void nativeRelease();

    public native int nativeProcess(int i3, int i16);

    public int v() {
        return this.f276214c;
    }

    public int w(final String str, final String str2, final int i3, final int i16, final int i17, EGLContext eGLContext) {
        int nativeInit;
        boolean z16 = false;
        if (this.f276212a) {
            return 0;
        }
        Log.i("YTHDR", String.format("imgHeight: %d, imgWidth: %d, miniFlag: %d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)));
        com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.a aVar = new com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.a();
        this.f276224m = aVar;
        aVar.d();
        com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.a aVar2 = new com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.a();
        this.f276225n = aVar2;
        aVar2.e(true);
        if (eGLContext != null && this.f276215d != null) {
            if (this.f276216e == null) {
                this.f276216e = new SimpleGLThread(eGLContext, "ythdr_init_thread" + eGLContext);
            }
            this.f276216e.i(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.YTHDR.1
                @Override // java.lang.Runnable
                public void run() {
                    YTHDR.this.f276219h = SimpleGLThread.g(i16, i3);
                    YTHDR.this.f276220i = SimpleGLThread.g(i16, i3);
                    synchronized (YTHDR.class) {
                        YTHDR ythdr = YTHDR.this;
                        ythdr.f276214c = ythdr.nativeInit(str, str2, i3, i16, i17);
                    }
                    boolean z17 = true;
                    Log.i("YTHDR", String.format("GLThread initRet: %d", Integer.valueOf(YTHDR.this.f276214c)));
                    if (YTHDR.this.f276214c == 0 || YTHDR.this.f276214c == -999) {
                        YTHDR.this.f276212a = true;
                        YTHDR ythdr2 = YTHDR.this;
                        if (ythdr2.f276214c == -999) {
                            z17 = false;
                        }
                        ythdr2.f276213b = z17;
                        YTHDR.this.f276217f = i3;
                        YTHDR.this.f276218g = i16;
                        YTHDR.this.f276215d.onInitSuccess();
                        return;
                    }
                    YTHDR.this.f276215d.a(YTHDR.this.f276214c);
                }
            });
            return 0;
        }
        this.f276219h = SimpleGLThread.g(i16, i3);
        this.f276220i = SimpleGLThread.g(i16, i3);
        synchronized (YTHDR.class) {
            nativeInit = nativeInit(str, str2, i3, i16, i17);
            this.f276214c = nativeInit;
        }
        Log.i("YTHDR", String.format("initRet: %d", Integer.valueOf(nativeInit)));
        int i18 = this.f276214c;
        if (i18 == 0 || i18 == -999) {
            this.f276212a = true;
            this.f276217f = i3;
            this.f276218g = i16;
            if (i18 != -999) {
                z16 = true;
            }
            this.f276213b = z16;
        }
        return i18;
    }

    public int x(int i3, int i16) {
        synchronized (YTHDR.class) {
            if (this.f276212a) {
                if (this.f276216e != null) {
                    this.f276224m.c(i3, this.f276219h, this.f276218g, this.f276217f, true);
                    if (this.f276221j) {
                        this.f276221j = false;
                        if (i3 != i16) {
                            this.f276224m.c(i3, i16, this.f276218g, this.f276217f, false);
                        }
                    } else {
                        if (!this.f276222k) {
                            A();
                        }
                        this.f276225n.c(this.f276220i, i16, this.f276218g, this.f276217f, true);
                    }
                    this.f276222k = false;
                    this.f276216e.i(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.YTHDR.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int nativeProcess;
                            synchronized (YTHDR.this.f276223l) {
                                if (YTHDR.this.f276213b) {
                                    YTHDR ythdr = YTHDR.this;
                                    nativeProcess = ythdr.nativeProcess(ythdr.f276219h, YTHDR.this.f276220i);
                                } else {
                                    YTHDR ythdr2 = YTHDR.this;
                                    ythdr2.f276226o = SimpleGLThread.f(ythdr2.f276219h, YTHDR.this.f276218g, YTHDR.this.f276217f, YTHDR.this.f276226o);
                                    YTHDR ythdr3 = YTHDR.this;
                                    nativeProcess = ythdr3.nativeProcess(ythdr3.f276226o, YTHDR.this.f276220i);
                                }
                                YTHDR.this.f276222k = true;
                                YTHDR.this.f276223l.notifyAll();
                            }
                            if (nativeProcess == 0) {
                                YTHDR.j(YTHDR.this);
                            } else {
                                YTHDR.j(YTHDR.this);
                            }
                        }
                    });
                    return 0;
                }
                if (this.f276213b) {
                    this.f276224m.c(i3, this.f276219h, this.f276218g, this.f276217f, true);
                    int nativeProcess = nativeProcess(this.f276219h, this.f276220i);
                    if (nativeProcess == 0) {
                        this.f276225n.c(this.f276220i, i16, this.f276218g, this.f276217f, false);
                    } else {
                        return nativeProcess;
                    }
                } else {
                    ByteBuffer f16 = SimpleGLThread.f(i3, this.f276218g, this.f276217f, this.f276226o);
                    this.f276226o = f16;
                    return nativeProcess(f16, i16);
                }
            }
            return -99;
        }
    }

    public void y() {
        synchronized (YTHDR.class) {
            this.f276212a = false;
            Log.i("YTHDR", "release");
            SimpleGLThread simpleGLThread = this.f276216e;
            if (simpleGLThread != null) {
                simpleGLThread.h();
            }
            this.f276216e = null;
            if (this.f276224m != null) {
                GLES20.glDeleteTextures(2, new int[]{this.f276219h, this.f276220i}, 0);
                this.f276224m.b();
            }
            com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.a aVar = this.f276225n;
            if (aVar != null) {
                aVar.b();
            }
            nativeRelease();
        }
    }

    public void z(a aVar) {
        this.f276215d = aVar;
    }
}
