package com.tencent.luggage.wxa.l1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.provider.Settings;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.l1.d;
import com.tencent.luggage.wxa.n1.b;
import com.tencent.luggage.wxa.re.e;
import com.tencent.luggage.wxa.re.k;
import com.tencent.luggage.wxa.tk.l;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.h0;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mobileqq.R;
import com.tencent.qbar.QbarNative;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends RelativeLayout implements g.d, g.b, g.c, com.tencent.luggage.wxa.re.e {
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public int H;
    public Rect I;
    public int J;
    public Size K;
    public boolean L;
    public com.tencent.luggage.wxa.re.c M;
    public com.tencent.luggage.wxa.re.b N;
    public ImageView O;
    public com.tencent.luggage.wxa.l1.d P;
    public String Q;
    public String R;
    public String S;
    public int T;
    public boolean U;
    public long V;
    public long W;

    /* renamed from: a, reason: collision with root package name */
    public Context f132860a;

    /* renamed from: a0, reason: collision with root package name */
    public WindowManager f132861a0;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f132862b;

    /* renamed from: b0, reason: collision with root package name */
    public com.tencent.luggage.wxa.l1.c f132863b0;

    /* renamed from: c, reason: collision with root package name */
    public String f132864c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f132865c0;

    /* renamed from: d, reason: collision with root package name */
    public int f132866d;

    /* renamed from: d0, reason: collision with root package name */
    public float f132867d0;

    /* renamed from: e, reason: collision with root package name */
    public g f132868e;

    /* renamed from: e0, reason: collision with root package name */
    public long f132869e0;

    /* renamed from: f, reason: collision with root package name */
    public String f132870f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f132871f0;

    /* renamed from: g, reason: collision with root package name */
    public int f132872g;

    /* renamed from: g0, reason: collision with root package name */
    public h0.a f132873g0;

    /* renamed from: h, reason: collision with root package name */
    public String f132874h;

    /* renamed from: h0, reason: collision with root package name */
    public AtomicBoolean f132875h0;

    /* renamed from: i, reason: collision with root package name */
    public String f132876i;

    /* renamed from: i0, reason: collision with root package name */
    public List f132877i0;

    /* renamed from: j, reason: collision with root package name */
    public String f132878j;

    /* renamed from: j0, reason: collision with root package name */
    public h0 f132879j0;

    /* renamed from: k, reason: collision with root package name */
    public String f132880k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f132881l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f132882m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.l1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6411a implements h0.b {
        public C6411a() {
        }

        @Override // com.tencent.luggage.wxa.uk.h0.b
        public void onFourOrientationsChange(h0.a aVar, h0.a aVar2) {
            if (a.this.h() && a.this.g()) {
                return;
            }
            h0.a aVar3 = h0.a.LANDSCAPE;
            if (aVar2 == aVar3 && a.this.f132873g0 == h0.a.REVERSE_LANDSCAPE) {
                a.this.f132873g0 = aVar2;
                a.this.d();
            }
            if (aVar2 == h0.a.REVERSE_LANDSCAPE && a.this.f132873g0 == aVar3) {
                a.this.f132873g0 = aVar2;
                a.this.d();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements d.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.l1.d.a
        public void a(byte[] bArr, int i3, int i16) {
            if (a.this.f132868e != null) {
                a.this.f132868e.a(bArr, i3, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements d.c {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.l1.d.c
        public void a() {
            w.f("MicroMsg.AppBrandCameraView", "InitErrorCallback");
            HashMap hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(a.this.f132872g));
            new com.tencent.luggage.wxa.re.h().setContext(a.this.f132862b).setData(new JSONObject(hashMap).toString()).dispatch();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements d.b {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.l1.d.b
        public void a() {
            float[] fArr;
            a.this.f132865c0 = true;
            w.d("MicroMsg.AppBrandCameraView", "InitDoneCallback");
            com.tencent.luggage.wxa.re.g gVar = new com.tencent.luggage.wxa.re.g();
            HashMap hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(a.this.f132872g));
            if (a.this.P != null) {
                fArr = a.this.P.c();
            } else {
                fArr = null;
            }
            if (fArr != null && fArr.length > 0) {
                a.this.f132867d0 = fArr[fArr.length - 1];
            }
            hashMap.put("maxZoom", Float.valueOf(a.this.f132867d0));
            gVar.setData(new JSONObject(hashMap).toString());
            a.this.f132862b.a(gVar, (int[]) null);
            if (a.this.f132877i0 != null) {
                Iterator it = a.this.f132877i0.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                a.this.f132877i0.clear();
            }
            a.this.j();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f132876i.equals("auto")) {
                a.this.P.b(3);
                return;
            }
            if (a.this.f132876i.equals("torch")) {
                a.this.P.b(4);
                return;
            }
            if (a.this.f132876i.equals("on")) {
                if (a.this.T != 2 && a.this.T != 4 && a.this.f132876i.equals("on")) {
                    a.this.P.b(2);
                    return;
                } else {
                    a.this.P.b(1);
                    return;
                }
            }
            if (a.this.f132876i.equals("torch")) {
                a.this.P.b(1);
            } else {
                a.this.P.b(2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h0.a f132888a;

        public f(h0.a aVar) {
            this.f132888a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.AppBrandCameraView", "currentOrientationRecord %s, lateOrientationState: %s", this.f132888a.toString(), a.this.f132873g0.toString());
            if (w0.e(a.this.f132869e0) >= 750 && a.this.f132875h0.get() && this.f132888a == a.this.f132873g0) {
                w.d("MicroMsg.AppBrandCameraView", "reopen camera");
                a.this.release();
                a.this.a();
            }
            a.this.f132871f0 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
        void a(boolean z16);

        void a(byte[] bArr, int i3, int i16);

        void b();

        void b(boolean z16);

        void init();

        void release();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements g {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements d.f {
            public b() {
            }

            @Override // com.tencent.luggage.wxa.l1.d.f
            public void a(boolean z16) {
                w.d("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", Boolean.valueOf(z16));
                if (a.this.P == null) {
                    w.d("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
                    h.this.a(-1, "camera is null", null, null);
                    return;
                }
                a.this.n();
                String i3 = a.this.P.i();
                if (z16) {
                    h.this.a(-1, "stop error", null, null);
                } else if (!a.this.f132882m) {
                    h.this.a(i3);
                } else {
                    h.this.b(i3);
                }
                h.this.a();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f132894a;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.l1.a$h$c$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6413a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f132896a;

                public RunnableC6413a(String str) {
                    this.f132896a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(this.f132896a);
                }
            }

            public c(String str) {
                this.f132894a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    str = com.tencent.luggage.wxa.ym.a.d(this.f132894a);
                } catch (Exception e16) {
                    w.b("MicroMsg.AppBrandCameraView", "stopRecord, remux failed, callback with origin videoexp = %s", w0.a((Throwable) e16));
                    str = null;
                }
                l.a(new RunnableC6413a(str));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        }

        public h() {
        }

        public void c() {
            w.d("MicroMsg.AppBrandCameraView", "stopRecord");
            if (a.this.P == null) {
                w.d("MicroMsg.AppBrandCameraView", "recordView is null");
                a(-1, "camera is null", null, null);
            } else if (a.this.T != 2) {
                w.f("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
                a(-1, "is not recording", null, null);
            } else if (!a.this.D) {
                a.this.D = true;
                a.this.P.a(new b());
            } else {
                w.d("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
                a(-1, "is stopping", null, null);
            }
        }

        public /* synthetic */ h(a aVar, C6411a c6411a) {
            this();
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void b(boolean z16) {
            w.d("MicroMsg.AppBrandCameraView", "takePicture.");
            if (a.this.P != null) {
                if (a.this.T != 2) {
                    if (!a.this.U && w0.e(a.this.V) >= 300) {
                        a aVar = a.this;
                        if (aVar.f132865c0) {
                            aVar.V = w0.a();
                            a.this.U = true;
                            a.this.T = 3;
                            a.this.P.a(new C6412a(z16), "on".equals(a.this.f132876i));
                            return;
                        }
                        w.f("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
                        a.this.a(-1, (String) null, "camera has not been initialized");
                        return;
                    }
                    w.d("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
                    return;
                }
                w.f("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
                return;
            }
            w.d("MicroMsg.AppBrandCameraView", "recordView is null");
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.l1.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6412a implements d.e {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f132891a;

            public C6412a(boolean z16) {
                this.f132891a = z16;
            }

            @Override // com.tencent.luggage.wxa.l1.d.e
            public void a(Bitmap bitmap) {
                if (bitmap != null) {
                    if ("front".equals(a.this.f132874h) && !this.f132891a) {
                        Bitmap a16 = h.this.a(bitmap);
                        bitmap.recycle();
                        bitmap = a16;
                    }
                    h hVar = h.this;
                    if (hVar.a(bitmap, a.this.S)) {
                        h hVar2 = h.this;
                        a aVar = a.this;
                        aVar.a(0, hVar2.a(aVar.f132862b, a.this.S), "");
                        return;
                    }
                    a.this.a(-1, (String) null, "save fail");
                    return;
                }
                a.this.a(-1, (String) null, "bitmap is null");
            }

            @Override // com.tencent.luggage.wxa.l1.d.e
            public void a() {
                a.this.a(-1, (String) null, "take picture error");
            }
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void a(byte[] bArr, int i3, int i16) {
            boolean unused = a.this.C;
        }

        public final boolean a(Bitmap bitmap, String str) {
            int i3;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a.this.G = bitmap.getWidth();
                    a.this.H = bitmap.getHeight();
                    if ("normal".equals(a.this.f132878j)) {
                        i3 = 44;
                    } else {
                        i3 = HippyImageInfo.QUALITY_LOW.equals(a.this.f132878j) ? 25 : 90;
                    }
                    com.tencent.luggage.wxa.tn.d.a(bitmap, i3, Bitmap.CompressFormat.JPEG, str, true);
                    w.d("MicroMsg.AppBrandCameraView", "bitmap filelen %s", Long.valueOf(x.e(str)));
                    return true;
                } catch (Exception e16) {
                    w.b("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", e16.getMessage());
                }
            }
            return false;
        }

        public final Bitmap a(Bitmap bitmap) {
            Matrix matrix = new Matrix();
            matrix.postScale(-1.0f, 1.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }

        public final void b(String str) {
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new c(str));
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void a(boolean z16) {
            w.d("MicroMsg.AppBrandCameraView", "startRecord.");
            if (!com.tencent.luggage.wxa.re.a.b().c()) {
                com.tencent.luggage.wxa.y9.a.makeText(a.this.f132860a, R.string.f167892e6, 1).show();
                w.f("MicroMsg.AppBrandCameraView", "no micro phone permission");
                a(-1, QCircleDaTongConstant.ElementParamValue.PERMISSION);
                return;
            }
            if (a.this.T == 2) {
                w.f("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
                a(-1, "is recording");
                return;
            }
            a aVar = a.this;
            if (aVar.f132865c0) {
                if (aVar.P.a(z16)) {
                    a.this.W = w0.a();
                    a.this.T = 2;
                    a(0, "");
                    a.this.q();
                    return;
                }
                w.f("MicroMsg.AppBrandCameraView", "startRecord fail !!");
                a(-1, "startRecord fail");
                return;
            }
            w.f("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
            a(-1, "camera has not been initialized");
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void b() {
            long e16 = w0.e(a.this.W);
            if (e16 < 1500) {
                long j3 = 1500 - e16;
                w.d("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", Long.valueOf(j3));
                c0.a(new d(), j3);
                return;
            }
            c();
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void init() {
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void release() {
        }

        public final void a(int i3, String str) {
            if (a.this.M != null) {
                a.this.M.a(i3, str);
            }
        }

        public final void a(String str) {
            if (w0.c(str)) {
                a(-1, "record file not exist", a.this.R, str);
                return;
            }
            a aVar = a.this;
            a(aVar.a(str, aVar.E, a.this.F, a.this.P.a()), a.this.R);
            a(0, "", a.this.R, str);
        }

        public final void a() {
            a.this.s();
            a.this.D = false;
        }

        public final void a(int i3, String str, String str2, String str3) {
            int i16;
            int i17;
            int i18;
            long j3;
            if (a.this.M != null) {
                if (i3 == 0) {
                    int[] iArr = new int[3];
                    a(str3, iArr);
                    int round = (int) Math.round((iArr[0] * 1.0d) / 1000.0d);
                    long e16 = x.e(str3);
                    int i19 = iArr[1];
                    i16 = round;
                    i18 = iArr[2];
                    j3 = e16;
                    i17 = i19;
                } else {
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                    j3 = 0;
                }
                a.this.M.a(i3, str, a(a.this.f132862b, str2), a(a.this.f132862b, str3), i16, j3, i17, i18);
            }
            a.this.q();
        }

        public final void a(String str, int[] iArr) {
            if (iArr != null && iArr.length >= 3) {
                if (!x.d(str)) {
                    w.d("MicroMsg.AppBrandCameraView", "getInfoFromMetaData file isn't exist, filename: %s", str);
                    return;
                }
                MediaMetadataRetriever mediaMetadataRetriever = null;
                try {
                    try {
                        try {
                            MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                            try {
                                mediaMetadataRetriever2.setDataSource(str);
                                iArr[0] = w0.a(mediaMetadataRetriever2.extractMetadata(9), 0);
                                int a16 = w0.a(mediaMetadataRetriever2.extractMetadata(24), 0);
                                if (a16 != 90 && a16 != 270) {
                                    iArr[1] = w0.a(mediaMetadataRetriever2.extractMetadata(18), 0);
                                    iArr[2] = w0.a(mediaMetadataRetriever2.extractMetadata(19), 0);
                                    mediaMetadataRetriever2.release();
                                }
                                iArr[1] = w0.a(mediaMetadataRetriever2.extractMetadata(19), 0);
                                iArr[2] = w0.a(mediaMetadataRetriever2.extractMetadata(18), 0);
                                mediaMetadataRetriever2.release();
                            } catch (Exception e16) {
                                e = e16;
                                mediaMetadataRetriever = mediaMetadataRetriever2;
                                w.b("MicroMsg.AppBrandCameraView", "getInfoFromMetaData failed", e);
                                iArr[0] = 0;
                                iArr[1] = 0;
                                iArr[2] = 0;
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                mediaMetadataRetriever = mediaMetadataRetriever2;
                                if (mediaMetadataRetriever != null) {
                                    try {
                                        mediaMetadataRetriever.release();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                } catch (IOException unused2) {
                }
            } else {
                w.d("MicroMsg.AppBrandCameraView", "getInfoFromMetaData with a array length less than 3");
            }
        }

        public final String a(com.tencent.luggage.wxa.xd.d dVar, String str) {
            if (w0.c(str)) {
                return str;
            }
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            if (dVar.getFileSystem().createTempFileFrom(new v(str), "", true, iVar) == com.tencent.luggage.wxa.rc.l.OK) {
                return (String) iVar.f141499a;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements g, b.c {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.n1.b f132899a;

        /* renamed from: b, reason: collision with root package name */
        public AtomicBoolean f132900b = new AtomicBoolean(false);

        /* renamed from: c, reason: collision with root package name */
        public int f132901c = 200;

        /* renamed from: d, reason: collision with root package name */
        public int f132902d = 200;

        /* renamed from: e, reason: collision with root package name */
        public float f132903e;

        /* renamed from: f, reason: collision with root package name */
        public int f132904f;

        /* renamed from: g, reason: collision with root package name */
        public int f132905g;

        /* renamed from: h, reason: collision with root package name */
        public Point f132906h;

        /* renamed from: i, reason: collision with root package name */
        public Rect f132907i;

        /* renamed from: j, reason: collision with root package name */
        public int f132908j;

        /* renamed from: k, reason: collision with root package name */
        public int f132909k;

        /* renamed from: l, reason: collision with root package name */
        public int f132910l;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.l1.a$i$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6414a implements Runnable {
            public RunnableC6414a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.f132900b.set(false);
            }
        }

        public i() {
            this.f132903e = (a.this.E * 1.0f) / a.this.F;
            this.f132909k = a.this.f132881l ? 1 : 0;
        }

        @Override // com.tencent.luggage.wxa.n1.b.c
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void b(boolean z16) {
            w.b("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
        }

        public final void c() {
            int i3;
            int rotation = a.this.f132861a0.getDefaultDisplay().getRotation();
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation != 3) {
                        i3 = 0;
                    } else {
                        i3 = 270;
                    }
                } else {
                    i3 = 180;
                }
            } else {
                i3 = 90;
            }
            int a16 = a.this.P.a();
            if ("front".equals(a.this.f132874h)) {
                int i16 = a16 % 360;
                this.f132908j = i16;
                this.f132908j = (360 - i16) % 360;
                return;
            }
            this.f132908j = ((a16 - i3) + 360) % 360;
        }

        public com.tencent.luggage.wxa.n1.b d() {
            return null;
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void init() {
            com.tencent.luggage.wxa.n1.b d16 = d();
            this.f132899a = d16;
            if (d16 == null) {
                return;
            }
            d16.a(a.this.f132860a);
            this.f132899a.a(this);
            a.this.T = 4;
            if (a.this.J > 0) {
                this.f132902d = 1000 / a.this.J;
            }
            this.f132910l = 0;
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void release() {
            com.tencent.luggage.wxa.n1.b bVar = this.f132899a;
            if (bVar != null) {
                bVar.b();
            }
            this.f132906h = null;
            this.f132910l = 0;
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void b() {
            w.b("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void a(byte[] bArr, int i3, int i16) {
            if (this.f132904f != a.this.E || this.f132905g != a.this.F) {
                c();
                a(i3, i16);
            }
            if (this.f132900b.get()) {
                w.a("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
            } else {
                if (this.f132899a == null || a.this.P == null) {
                    return;
                }
                this.f132899a.a(bArr, i3, i16, a.this.E, a.this.F, this.f132906h, this.f132907i, this.f132908j, this.f132909k);
            }
        }

        @Override // com.tencent.luggage.wxa.n1.b.c
        public void a(int i3, String str, int i16, byte[] bArr, QbarNative.QBarPoint qBarPoint) {
            if (this.f132900b.compareAndSet(false, true)) {
                c0.a(new RunnableC6414a(), this.f132902d);
                w.a("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", str, Integer.valueOf(i3), Integer.valueOf(i16));
                if (qBarPoint != null && this.f132910l % 4 == 0) {
                    w.d("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", Float.valueOf(qBarPoint.f342416x0), Float.valueOf(qBarPoint.f342420y0), Float.valueOf(qBarPoint.f342417x1 - qBarPoint.f342416x0), Float.valueOf(qBarPoint.f342423y3 - qBarPoint.f342420y0), Float.valueOf(qBarPoint.f342416x0), Float.valueOf(qBarPoint.f342417x1), Float.valueOf(qBarPoint.f342418x2), Float.valueOf(qBarPoint.f342419x3), Float.valueOf(qBarPoint.f342420y0), Float.valueOf(qBarPoint.f342421y1), Float.valueOf(qBarPoint.f342422y2), Float.valueOf(qBarPoint.f342423y3));
                    this.f132910l++;
                }
                if (i3 == 1) {
                    com.tencent.luggage.wxa.n1.a.a(a.this.f132862b, a.this.getCameraId(), "qrcode", i16, str, bArr, qBarPoint);
                } else if (i3 == 2) {
                    com.tencent.luggage.wxa.n1.a.a(a.this.f132862b, a.this.getCameraId(), "barcode", i16, str, bArr, qBarPoint);
                } else {
                    w.f("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
                }
            }
        }

        @Override // com.tencent.luggage.wxa.l1.a.g
        public void a(boolean z16) {
            w.b("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
        }

        public final void a(int i3, int i16) {
            if (a.this.P != null) {
                this.f132904f = a.this.E;
                this.f132905g = a.this.F;
            }
            Point a16 = a(i3, i16, a.this.E, a.this.F, this.f132908j, this.f132903e);
            this.f132906h = a16;
            if (a16 == null) {
                return;
            }
            this.f132907i = a(a.this.I, a.this.E, this.f132906h.x);
        }

        public final Point a(int i3, int i16, int i17, int i18, int i19, float f16) {
            if (i3 <= 0 || i16 <= 0) {
                return null;
            }
            if (i19 == 90 || i19 == 270) {
                f16 = 1.0f / f16;
            }
            float f17 = 1.0f / f16;
            if (!(((float) i16) * f16 < ((float) i3))) {
                this.f132909k = 1;
                int max = Math.max(i16, i3);
                int i26 = (int) (max * f17);
                if (i19 != 90 && i19 != 270) {
                    return new Point(max, i26);
                }
                return new Point(i26, max);
            }
            int min = Math.min(i16, i3);
            int i27 = (int) (min / f17);
            if (i19 != 90 && i19 != 270) {
                return new Point(i27, min);
            }
            return new Point(min, i27);
        }

        public final Rect a(Rect rect, int i3, int i16) {
            if (rect == null) {
                return null;
            }
            float f16 = (i3 * 1.0f) / i16;
            return new Rect(Math.round(rect.left / f16), Math.round(rect.top / f16), Math.round(rect.right / f16), Math.round(rect.bottom / f16));
        }

        public void a(int i3) {
            this.f132909k = i3;
        }
    }

    public a(Context context) {
        super(context);
        this.f132864c = "scanCode";
        this.f132874h = "back";
        this.f132876i = "auto";
        this.f132878j = "high";
        this.f132881l = false;
        this.f132882m = false;
        this.D = false;
        this.E = 1080;
        this.F = 1920;
        this.G = 1080;
        this.H = 1920;
        this.T = -1;
        this.U = false;
        this.V = -1L;
        this.W = -1L;
        this.f132861a0 = (WindowManager) z.c().getSystemService("window");
        this.f132873g0 = h0.a.LANDSCAPE;
        this.f132875h0 = new AtomicBoolean(false);
        this.f132879j0 = new h0(z.c(), new C6411a());
        a(context);
    }

    public abstract com.tencent.luggage.wxa.l1.d a(Context context, int i3, int i16);

    @Override // com.tencent.luggage.wxa.re.e
    public int getCameraId() {
        return this.f132872g;
    }

    public com.tencent.luggage.wxa.re.c getOperateCallBack() {
        return this.M;
    }

    public com.tencent.luggage.wxa.l1.d getRecordView() {
        return this.P;
    }

    public abstract void j();

    @Override // com.tencent.luggage.wxa.xd.g.b
    public void onBackground() {
        if (com.tencent.luggage.wxa.re.a.b().f()) {
            w.d("MicroMsg.AppBrandCameraView", "onBackground, but is requesting microphone permission");
        } else {
            k();
            o();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.g.c
    public void onDestroy() {
        com.tencent.luggage.wxa.l1.c cVar = this.f132863b0;
        if (cVar != null) {
            cVar.c(this.P);
        }
        release();
        this.f132875h0.compareAndSet(true, false);
    }

    @Override // com.tencent.luggage.wxa.xd.g.d
    public void onForeground() {
        l();
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void release() {
        w.d("MicroMsg.AppBrandCameraView", "release");
        synchronized (a.class) {
            this.f132869e0 = w0.a();
            if (i()) {
                this.f132879j0.disable();
            }
            com.tencent.luggage.wxa.l1.d dVar = this.P;
            if (dVar != null) {
                dVar.release();
                removeView(this.P.d());
                this.T = -1;
                this.P.a((d.a) null);
                this.P.a((d.c) null);
                this.P.a((d.b) null);
                this.P = null;
            }
            ImageView imageView = this.O;
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
            List list = this.f132877i0;
            if (list != null) {
                list.clear();
            }
            this.f132867d0 = 0.0f;
        }
        m();
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setAppId(String str) {
        this.f132870f = str;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setCameraId(int i3) {
        this.f132872g = i3;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setCompressRecord(boolean z16) {
        this.f132882m = z16;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setDisplayScreenSize(Size size) {
        if (size != null && size.getHeight() > 0 && size.getWidth() > 0) {
            this.K = size;
        }
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setFlash(String str) {
        if (w0.a(this.f132876i, str)) {
            return;
        }
        this.f132876i = str;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setFrameLimitSize(int i3) {
        w.d("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", Integer.valueOf(i3));
        this.f132866d = i3;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setMode(String str) {
        this.f132864c = str;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setNeedOutput(boolean z16) {
        this.C = z16;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setOperateCallBack(com.tencent.luggage.wxa.re.c cVar) {
        this.M = cVar;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setOutPutCallBack(com.tencent.luggage.wxa.re.b bVar) {
        this.N = bVar;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setPage(com.tencent.luggage.wxa.xd.f fVar) {
        this.f132862b = fVar;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setPageOrientation(boolean z16) {
        this.L = z16;
        w.d("MicroMsg.AppBrandCameraView", "setPageOrientation: %b", Boolean.valueOf(z16));
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setPreviewCenterCrop(boolean z16) {
        this.f132881l = z16;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setQuality(String str) {
        if (w0.a(this.f132878j, str)) {
            return;
        }
        this.f132878j = str;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setResolution(String str) {
        if (w0.a(this.f132880k, str)) {
            return;
        }
        w.d("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", str);
        this.f132880k = str;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setScanFreq(int i3) {
        w.d("MicroMsg.AppBrandCameraView", "scanFreq:%d", Integer.valueOf(i3));
        if (i3 <= 0) {
            w.b("MicroMsg.AppBrandCameraView", "scanFreq is err");
        } else {
            this.J = i3;
        }
    }

    public final void d() {
        if (this.f132871f0) {
            w.d("MicroMsg.AppBrandCameraView", "camera already in pre rotate mode");
            return;
        }
        this.f132871f0 = true;
        h0.a aVar = this.f132873g0;
        w.d("MicroMsg.AppBrandCameraView", "wait for another release called");
        c0.a(new f(aVar), 750L);
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void e() {
        com.tencent.luggage.wxa.l1.c cVar;
        if (this.M == null || (cVar = this.f132863b0) == null) {
            return;
        }
        cVar.c(this.P);
        this.f132863b0 = null;
    }

    public final void f() {
        w.d("MicroMsg.AppBrandCameraView", "initCamera.");
        if (!com.tencent.luggage.wxa.re.a.b().d()) {
            com.tencent.luggage.wxa.y9.a.makeText(this.f132860a, R.string.f167892e6, 1).show();
            w.f("MicroMsg.AppBrandCameraView", "no permission");
            return;
        }
        if (this.P != null) {
            w.d("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
            return;
        }
        int[] a16 = com.tencent.luggage.wxa.re.a.b().a();
        if (a16.length > 0) {
            for (int i3 : a16) {
                if (i3 != this.f132872g) {
                    com.tencent.luggage.wxa.re.a.b().a(i3, false);
                    w.d("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", Integer.valueOf(i3));
                }
            }
        }
        ImageView imageView = this.O;
        if (imageView == null) {
            ImageView imageView2 = new ImageView(this.f132860a);
            this.O = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(this.O, new ViewGroup.LayoutParams(-1, -1));
        } else {
            imageView.setImageBitmap(null);
        }
        com.tencent.luggage.wxa.l1.d a17 = a(this.f132860a, this.E, this.F);
        this.P = a17;
        if (a17 == null) {
            this.P = new com.tencent.luggage.wxa.l1.f(this.f132860a);
        }
        this.f132865c0 = false;
        addView(this.P.d());
        t();
        this.P.a(this.f132866d);
        this.P.g();
        this.P.a((this.E * 1.0f) / this.F);
        this.P.d(this.f132881l ? 1 : 0);
        this.P.a(600000, 4800000, 30, 64000, 44100);
        this.P.a(this.Q);
        this.P.d(true);
        this.P.c(true);
        this.P.setDisplayScreenSize(this.K);
        this.P.b("back".equals(this.f132874h));
        this.P.a(new b());
        this.P.a(new c());
        this.P.a(new d());
        this.P.j();
        this.P.f();
        n();
    }

    public final boolean g() {
        Context context = this.f132860a;
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return activity.getRequestedOrientation() == 0 || activity.getRequestedOrientation() == 1;
    }

    public final boolean h() {
        return Settings.System.getInt(getContext().getContentResolver(), "accelerometer_rotation", 0) == 0;
    }

    public final boolean i() {
        return this.L;
    }

    public void k() {
        Bitmap h16;
        w.d("MicroMsg.AppBrandCameraView", "onUIPause");
        if (i()) {
            this.f132879j0.disable();
        }
        if (this.T == 2) {
            w.a("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
            HashMap hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(this.f132872g));
            hashMap.put("errMsg", "stop on record");
            new k().setContext(this.f132862b).setData(new JSONObject(hashMap).toString()).dispatch();
        }
        com.tencent.luggage.wxa.l1.d dVar = this.P;
        if (dVar != null && (h16 = dVar.h()) != null) {
            this.O.setImageBitmap(h16);
        }
        com.tencent.luggage.wxa.l1.c cVar = this.f132863b0;
        if (cVar != null) {
            cVar.a(this.P);
        }
        release();
    }

    public void l() {
        w.d("MicroMsg.AppBrandCameraView", "onUIResume");
        synchronized (a.class) {
            if (i()) {
                this.f132879j0.a(60);
                this.f132879j0.enable();
            }
            if (!this.f132875h0.get()) {
                w.f("MicroMsg.AppBrandCameraView", "no execute initView");
                return;
            }
            f();
            c();
            com.tencent.luggage.wxa.l1.c cVar = this.f132863b0;
            if (cVar != null) {
                cVar.b(this.P);
            }
        }
    }

    public final void m() {
        g gVar = this.f132868e;
        if (gVar != null) {
            gVar.release();
            this.f132868e = null;
        }
    }

    public void n() {
        this.T = 1;
    }

    public final void o() {
        HashMap hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(getCameraId()));
        new com.tencent.luggage.wxa.re.i().setContext(this.f132862b).setData(new JSONObject(hashMap).toString()).dispatch();
    }

    public final void p() {
        w.d("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", this.f132864c);
        m();
        g a16 = a(this.f132864c);
        this.f132868e = a16;
        a16.init();
    }

    public final void q() {
        if (this.P == null || this.f132876i == null) {
            return;
        }
        e eVar = new e();
        if (!this.f132865c0) {
            if (this.f132877i0 == null) {
                this.f132877i0 = new ArrayList();
            }
            this.f132877i0.add(eVar);
            w.d("MicroMsg.AppBrandCameraView", "set flash mode before camera init done");
            return;
        }
        eVar.run();
    }

    public final void r() {
        String format = String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
        if (com.tencent.luggage.wxa.re.a.b().e()) {
            this.S = com.tencent.luggage.wxa.bo.b.a() + format;
            return;
        }
        this.S = com.tencent.luggage.wxa.db.a.c() + format;
    }

    public final void s() {
        String str = "Wxa_" + System.currentTimeMillis();
        this.Q = com.tencent.luggage.wxa.db.a.c() + str + ".mp4";
        if (!x.d(com.tencent.luggage.wxa.db.a.c())) {
            x.m(com.tencent.luggage.wxa.db.a.c());
        }
        this.Q = com.tencent.luggage.wxa.db.a.c() + str + ".mp4";
        this.R = com.tencent.luggage.wxa.db.a.c() + str + ".jpeg";
        com.tencent.luggage.wxa.l1.d dVar = this.P;
        if (dVar != null) {
            dVar.a(this.Q);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t() {
        int i3;
        int i16;
        char c16;
        if (!w0.c(this.f132880k)) {
            String str = this.f132880k;
            int hashCode = str.hashCode();
            if (hashCode == -1078030475) {
                if (str.equals("medium")) {
                    c16 = 2;
                    if (c16 != 0) {
                    }
                }
                c16 = '\uffff';
                if (c16 != 0) {
                }
            } else if (hashCode != 107348) {
                if (hashCode == 3202466 && str.equals("high")) {
                    c16 = 0;
                    if (c16 != 0) {
                        i3 = 1080;
                    } else if (c16 == 1) {
                        i3 = 480;
                    }
                }
                c16 = '\uffff';
                if (c16 != 0) {
                }
            } else {
                if (str.equals(HippyImageInfo.QUALITY_LOW)) {
                    c16 = 1;
                    if (c16 != 0) {
                    }
                }
                c16 = '\uffff';
                if (c16 != 0) {
                }
            }
            i16 = this.f132866d;
            if (i16 > i3) {
                w.d("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", Integer.valueOf(i16), Integer.valueOf(i3));
                i3 = this.f132866d;
            }
            this.P.c(i3);
        }
        i3 = 720;
        i16 = this.f132866d;
        if (i16 > i3) {
        }
        this.P.c(i3);
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void c() {
        if (this.P == null) {
            w.d("MicroMsg.AppBrandCameraView", "recordView is null");
        } else {
            p();
            q();
        }
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void b(boolean z16) {
        g gVar = this.f132868e;
        if (gVar != null) {
            gVar.b(z16);
        }
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void b() {
        g gVar = this.f132868e;
        if (gVar != null) {
            gVar.b();
        }
    }

    private void a(Context context) {
        this.f132860a = context;
        this.f132875h0.set(false);
        LayoutInflater.from(context).inflate(R.layout.f168227fe0, this);
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void a() {
        w.d("MicroMsg.AppBrandCameraView", "initView");
        if (com.tencent.luggage.wxa.re.a.b().d()) {
            s();
            r();
            f();
            c();
            this.f132875h0.compareAndSet(false, true);
            if (i()) {
                this.f132879j0.a(60);
                this.f132879j0.enable();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void a(String str, boolean z16) {
        com.tencent.luggage.wxa.l1.d dVar;
        if (w0.a(this.f132874h, str) || w0.a(this.f132864c, "scanCode")) {
            return;
        }
        this.f132874h = str;
        if (z16 || (dVar = this.P) == null) {
            return;
        }
        dVar.b();
    }

    @Override // com.tencent.luggage.wxa.re.e
    public View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public boolean a(int i3, int i16, boolean z16) {
        if (this.E == i3 && this.F == i16) {
            return false;
        }
        w.d("MicroMsg.AppBrandCameraView", "setViewSize");
        this.E = i3;
        this.F = i16;
        return true;
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void a(boolean z16, boolean z17) {
        a(z16);
    }

    public final void a(int i3, String str, String str2) {
        w.d("MicroMsg.AppBrandCameraView", "onTakePhoto.ret:%d, path:%s, errMsg:%s", Integer.valueOf(i3), str, str2);
        com.tencent.luggage.wxa.re.c cVar = this.M;
        if (cVar != null) {
            cVar.a(i3, str, str2, this.G, this.H);
        }
        this.U = false;
        r();
        n();
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void setCameraLife(e.a aVar) {
    }

    public g a(String str) {
        if (!w0.c(str) && str.equals("scanCode") && com.tencent.luggage.wxa.y3.a.f145414a.a()) {
            return new i();
        }
        return new h(this, null);
    }

    @Override // com.tencent.luggage.wxa.re.e
    public void a(int i3, int i16, int i17, int i18) {
        w.d("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        if (i17 <= 0 || i18 <= 0) {
            return;
        }
        this.I = new Rect(i3, i16, i17 + i3, i18 + i16);
    }

    public void a(boolean z16) {
        g gVar = this.f132868e;
        if (gVar != null) {
            gVar.a(z16);
        }
    }

    public final Bitmap a(String str, int i3, int i16, int i17) {
        if (w0.c(str)) {
            return null;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail == null) {
            w.b("MicroMsg.AppBrandCameraView", "create remux thumb bmp error, target path %s", str);
            return createVideoThumbnail;
        }
        return com.tencent.luggage.wxa.tn.d.a(createVideoThumbnail, i16, i3, true, true);
    }
}
