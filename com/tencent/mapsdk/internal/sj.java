package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ew;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.internal.kq;
import com.tencent.mapsdk.internal.qs;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sj extends eu {

    /* renamed from: aa, reason: collision with root package name */
    private static final int f150244aa = 6;

    /* renamed from: ad, reason: collision with root package name */
    private static final float f150245ad = 0.7f;

    /* renamed from: ae, reason: collision with root package name */
    private static final float f150246ae = 1.3f;

    /* renamed from: f, reason: collision with root package name */
    public static final float[] f150247f = {1000000.0f, 500000.0f, 200000.0f, 100000.0f, 50000.0f, 25000.0f, 20000.0f, 10000.0f, 5000.0f, 2000.0f, 1000.0f, 500.0f, 200.0f, 100.0f, 50.0f, 20.0f, 10.0f, 5.0f, 2.0f, 1.0f};
    private volatile boolean A;
    private gd B;
    private boolean C;
    private Context D;
    private Bitmap E;
    private Bitmap F;
    private e Z;

    /* renamed from: a, reason: collision with root package name */
    public ImageView f150248a;

    /* renamed from: ab, reason: collision with root package name */
    private LinearLayout f150249ab;

    /* renamed from: af, reason: collision with root package name */
    private Animation f150251af;

    /* renamed from: ai, reason: collision with root package name */
    private kq.a f150254ai;

    /* renamed from: aj, reason: collision with root package name */
    private final tr f150255aj;

    /* renamed from: j, reason: collision with root package name */
    public float f150264j;

    /* renamed from: k, reason: collision with root package name */
    public int f150265k;

    /* renamed from: l, reason: collision with root package name */
    public double f150266l;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f150269o;

    /* renamed from: p, reason: collision with root package name */
    public final int f150270p;

    /* renamed from: u, reason: collision with root package name */
    public qs f150275u;

    /* renamed from: x, reason: collision with root package name */
    private Bitmap f150278x;

    /* renamed from: y, reason: collision with root package name */
    private Rect f150279y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f150280z;

    /* renamed from: v, reason: collision with root package name */
    private final int f150276v = 500;

    /* renamed from: w, reason: collision with root package name */
    private final int f150277w = 1000;
    private ew.b G = ew.b.RIGHT_BOTTOM;
    private ew.b H = ew.b.LEFT_BOTTOM;

    /* renamed from: b, reason: collision with root package name */
    public boolean f150257b = true;

    /* renamed from: c, reason: collision with root package name */
    public float[] f150258c = {-1.0f, -1.0f, -1.0f, -1.0f};
    private int[] I = {-1, -1, -1, -1};
    private int[] J = {-1, -1, -1, -1};
    private int[] K = new int[ew.a.values().length];
    private int[] L = new int[ew.a.values().length];
    private float[] M = {0.02f, 0.02f, 0.012f, 0.012f};
    private float[] N = {0.022f, 0.022f, 0.0125f, 0.0125f};
    private float[] O = {0.0185f, 0.0185f, 0.0104f, 0.0104f};

    /* renamed from: d, reason: collision with root package name */
    public int f150259d = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private int T = 0;
    private final List<sn> U = new CopyOnWriteArrayList();
    private final ConcurrentHashMap<String, Bitmap> V = new ConcurrentHashMap<>();
    private final List<String> W = new CopyOnWriteArrayList();
    private String X = null;

    /* renamed from: e, reason: collision with root package name */
    public int f150260e = 0;

    /* renamed from: g, reason: collision with root package name */
    public float f150261g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public String f150262h = "50\u7c73";
    private int Y = 26;

    /* renamed from: i, reason: collision with root package name */
    public int f150263i = 109;

    /* renamed from: m, reason: collision with root package name */
    public boolean f150267m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f150268n = false;

    /* renamed from: ac, reason: collision with root package name */
    private final int f150250ac = 18;

    /* renamed from: q, reason: collision with root package name */
    public float f150271q = Float.MIN_VALUE;

    /* renamed from: r, reason: collision with root package name */
    public List<c> f150272r = new ArrayList();

    /* renamed from: ag, reason: collision with root package name */
    private int f150252ag = -1;

    /* renamed from: ah, reason: collision with root package name */
    private int f150253ah = -1;

    /* renamed from: s, reason: collision with root package name */
    public int f150273s = -1;

    /* renamed from: t, reason: collision with root package name */
    public int f150274t = -1;

    /* renamed from: ak, reason: collision with root package name */
    private boolean f150256ak = true;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sj$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            tr trVar = sj.this.f150255aj;
            float f16 = sj.this.f150261g;
            TencentMap.OnScaleViewChangedListener onScaleViewChangedListener = trVar.D;
            if (onScaleViewChangedListener != null) {
                onScaleViewChangedListener.onScaleViewChanged(f16);
            }
            trVar.f151058o.f147697j.onScaleViewChanged(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sj$6, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f150289a;

        static {
            int[] iArr = new int[ew.b.values().length];
            f150289a = iArr;
            try {
                iArr[ew.b.LEFT_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f150289a[ew.b.CENTER_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f150289a[ew.b.RIGHT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f150289a[ew.b.LEFT_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f150289a[ew.b.CENTER_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f150289a[ew.b.RIGHT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends kp.g<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<sj> f150290a;

        /* renamed from: b, reason: collision with root package name */
        private String f150291b;

        /* renamed from: c, reason: collision with root package name */
        private String f150292c;

        public a(sj sjVar, String str, String str2) {
            this.f150290a = new WeakReference<>(sjVar);
            this.f150291b = str;
            this.f150292c = str2;
        }

        private Bitmap a() throws Exception {
            sj sjVar;
            WeakReference<sj> weakReference = this.f150290a;
            Bitmap bitmap = null;
            if (weakReference != null && (sjVar = weakReference.get()) != null) {
                File file = new File(sj.a(sjVar, this.f150292c));
                LogUtil.c(ky.f149117w, "Logo[" + this.f150292c + "] request url[" + this.f150291b + "]...");
                LogUtil.c(ky.f149117w, "Logo[" + this.f150292c + "] save to[" + file + "]...");
                NetResponse downloadTo = NetManager.getInstance().builder().url(this.f150291b).downloadTo(file);
                if (downloadTo != null && downloadTo.available()) {
                    byte[] bArr = downloadTo.data;
                    int length = bArr.length;
                    LogUtil.c(ky.f149117w, "Logo[" + this.f150292c + "] request url ok! bitmap size[" + length + "]...");
                    bitmap = BitmapFactory.decodeByteArray(bArr, 0, length);
                    if (bitmap != null) {
                        sjVar.V.put(this.f150292c, bitmap);
                    }
                }
            }
            return bitmap;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() throws Exception {
            sj sjVar;
            WeakReference<sj> weakReference = this.f150290a;
            Bitmap bitmap = null;
            if (weakReference != null && (sjVar = weakReference.get()) != null) {
                File file = new File(sj.a(sjVar, this.f150292c));
                LogUtil.c(ky.f149117w, "Logo[" + this.f150292c + "] request url[" + this.f150291b + "]...");
                LogUtil.c(ky.f149117w, "Logo[" + this.f150292c + "] save to[" + file + "]...");
                NetResponse downloadTo = NetManager.getInstance().builder().url(this.f150291b).downloadTo(file);
                if (downloadTo != null && downloadTo.available()) {
                    byte[] bArr = downloadTo.data;
                    int length = bArr.length;
                    LogUtil.c(ky.f149117w, "Logo[" + this.f150292c + "] request url ok! bitmap size[" + length + "]...");
                    bitmap = BitmapFactory.decodeByteArray(bArr, 0, length);
                    if (bitmap != null) {
                        sjVar.V.put(this.f150292c, bitmap);
                    }
                }
            }
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends kp.a<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<sj> f150293a;

        /* renamed from: b, reason: collision with root package name */
        private String f150294b;

        public b(sj sjVar, String str) {
            this.f150293a = new WeakReference<>(sjVar);
            this.f150294b = str;
        }

        private void a(Bitmap bitmap) {
            WeakReference<sj> weakReference;
            sj sjVar;
            if (bitmap != null && (weakReference = this.f150293a) != null && (sjVar = weakReference.get()) != null) {
                kt.a(new File(sj.a(sjVar, this.f150294b)), new File(sjVar.a(this.f150294b)));
                if (this.f150294b.equals(sjVar.X) || TextUtils.isEmpty(sjVar.X)) {
                    LogUtil.c(ky.f149117w, "Logo[" + this.f150294b + "] set from net");
                    sjVar.a(bitmap);
                }
                sjVar.W.remove(this.f150294b);
            }
        }

        @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
        public final /* synthetic */ void callback(Object obj) {
            WeakReference<sj> weakReference;
            sj sjVar;
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap != null && (weakReference = this.f150293a) != null && (sjVar = weakReference.get()) != null) {
                kt.a(new File(sj.a(sjVar, this.f150294b)), new File(sjVar.a(this.f150294b)));
                if (this.f150294b.equals(sjVar.X) || TextUtils.isEmpty(sjVar.X)) {
                    LogUtil.c(ky.f149117w, "Logo[" + this.f150294b + "] set from net");
                    sjVar.a(bitmap);
                }
                sjVar.W.remove(this.f150294b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(View view, Rect rect, boolean z16);

        void a(sj sjVar);

        void b(View view, Rect rect, boolean z16);

        void c();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final int f150295a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f150296b = 2;

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ int[] f150297c = {1, 2};

        d(String str, int i3) {
        }

        private static int[] a() {
            return (int[]) f150297c.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<sj> f150306a;

        public f(sj sjVar) {
            this.f150306a = new WeakReference<>(sjVar);
        }

        @Override // java.lang.Runnable
        public final void run() {
            sj sjVar;
            WeakReference<sj> weakReference = this.f150306a;
            if (weakReference != null && (sjVar = weakReference.get()) != null) {
                sjVar.a(sj.k(sjVar), (Bundle) null);
            }
        }
    }

    public sj(Context context, final tr trVar, int i3) {
        this.f150264j = 1.0f;
        this.D = context;
        this.f150255aj = trVar;
        this.f150270p = i3;
        this.f150264j = context.getResources().getDisplayMetrics().density;
        this.f150248a = new ImageView(context);
        this.Z = new e(this.D);
        if (this.f150264j <= 0.0f) {
            this.f150264j = 1.0f;
        }
        LinearLayout linearLayout = new LinearLayout(this.D);
        this.f150249ab = linearLayout;
        linearLayout.setOrientation(1);
        this.f150249ab.setGravity(16);
        this.f150249ab.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mapsdk.internal.sj.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (sj.this.f150254ai == null) {
                    sj sjVar = sj.this;
                    sjVar.f150254ai = kq.a(sjVar.D, null, " ", 0);
                }
                LogUtil.a(trVar.f147934f).a(sj.this.D, sj.this.f150254ai);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f150249ab.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mapsdk.internal.sj.2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                EventCollector.getInstance().onViewLongClickedBefore(view);
                boolean a16 = gq.a(trVar.d_);
                EventCollector.getInstance().onViewLongClicked(view);
                return a16;
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(this.D);
        this.f150269o = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f150269o.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.f150269o.addView(this.Z, layoutParams);
        this.f150269o.setVisibility(8);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f150251af = alphaAnimation;
        alphaAnimation.setDuration(1000L);
        this.f150251af.setStartOffset(500L);
        this.f150251af.setAnimationListener(new AnonymousClass3());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 3;
        this.f150249ab.addView(this.f150248a, layoutParams2);
        so soVar = trVar.f151054k.f150369b;
        if (soVar != null) {
            a(soVar.c());
        }
    }

    private String o() {
        return this.D.getFilesDir().getAbsolutePath() + "/tencentMapSdk/oldLogos";
    }

    private void p() {
        this.V.clear();
    }

    private FrameLayout.LayoutParams q() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout = this.f150269o;
        if (linearLayout == null) {
            return layoutParams;
        }
        int measuredWidth = linearLayout.getMeasuredWidth();
        int measuredHeight = this.f150269o.getMeasuredHeight();
        switch (AnonymousClass6.f150289a[this.H.ordinal()]) {
            case 1:
                layoutParams.gravity = 83;
                int[] iArr = this.L;
                int i3 = iArr[ew.a.BOTTOM.f148329e];
                layoutParams.bottomMargin = i3;
                int i16 = iArr[ew.a.LEFT.f148329e];
                layoutParams.leftMargin = i16;
                this.f150274t = (this.P - i3) - measuredHeight;
                this.f150273s = i16;
                return layoutParams;
            case 2:
                layoutParams.gravity = 81;
                int i17 = this.L[ew.a.BOTTOM.f148329e];
                layoutParams.bottomMargin = i17;
                this.f150274t = (this.P - i17) - measuredHeight;
                this.f150273s = (this.f150259d - measuredWidth) / 2;
                return layoutParams;
            case 3:
                layoutParams.gravity = 85;
                int[] iArr2 = this.L;
                int i18 = iArr2[ew.a.BOTTOM.f148329e];
                layoutParams.bottomMargin = i18;
                int i19 = iArr2[ew.a.RIGHT.f148329e];
                layoutParams.rightMargin = i19;
                this.f150274t = (this.P - i18) - measuredHeight;
                this.f150273s = (this.f150259d - i19) - measuredWidth;
                return layoutParams;
            case 4:
                layoutParams.gravity = 51;
                int[] iArr3 = this.L;
                int i26 = iArr3[ew.a.TOP.f148329e];
                layoutParams.topMargin = i26;
                int i27 = iArr3[ew.a.LEFT.f148329e];
                layoutParams.leftMargin = i27;
                this.f150274t = i26;
                this.f150273s = i27;
                return layoutParams;
            case 5:
                layoutParams.gravity = 49;
                int i28 = this.L[ew.a.TOP.f148329e];
                layoutParams.topMargin = i28;
                this.f150274t = i28;
                this.f150273s = (this.f150259d - measuredWidth) / 2;
                return layoutParams;
            case 6:
                layoutParams.gravity = 53;
                int[] iArr4 = this.L;
                int i29 = iArr4[ew.a.TOP.f148329e];
                layoutParams.topMargin = i29;
                int i36 = iArr4[ew.a.RIGHT.f148329e];
                layoutParams.rightMargin = i36;
                this.f150274t = i29;
                this.f150273s = (this.f150259d - i36) - measuredWidth;
                return layoutParams;
            default:
                LogUtil.d("Unknown positionScale:" + this.H);
                return layoutParams;
        }
    }

    private ew.b r() {
        return this.H;
    }

    private void s() {
        h();
    }

    private void t() {
        i();
    }

    private boolean u() {
        return this.f150267m;
    }

    private void v() {
        w();
        this.f150269o.startAnimation(this.f150251af);
    }

    private void w() {
        LinearLayout linearLayout = this.f150269o;
        if (linearLayout != null && this.f150251af != null) {
            linearLayout.clearAnimation();
            this.f150251af.reset();
        }
    }

    private void x() {
        String str;
        int width = this.f150248a.getWidth();
        if (width <= 0) {
            width = 1000;
        }
        int ceil = (int) Math.ceil(width / 4.0f);
        int ceil2 = (int) (Math.ceil((this.f150259d * 3.0f) / 8.0f) - (this.f150264j * 6.0f));
        float[] fArr = f150247f;
        int length = fArr.length;
        int i3 = this.f150265k - this.f150270p;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 >= length) {
            i3 = length - 1;
        }
        float f16 = fArr[i3];
        if (this.f150261g != f16) {
            this.f150261g = f16;
            kp.a(new AnonymousClass5());
        }
        float f17 = ceil;
        double d16 = this.f150266l;
        if (d16 != 0.0d) {
            f17 = (float) (f16 / d16);
        }
        int round = Math.round(f17);
        this.f150263i = round;
        if (round > ceil2) {
            this.f150263i = ceil2;
        } else if (round < ceil) {
            this.f150263i = ceil;
        }
        if (f16 >= 1000.0f) {
            f16 /= 1000.0f;
            str = "\u516c\u91cc";
        } else {
            str = "\u7c73";
        }
        this.f150262h = ((int) f16) + str;
    }

    private void y() {
        List<c> list = this.f150272r;
        if (list != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    private void z() {
        List<c> list = this.f150272r;
        if (list != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    public final boolean k() {
        return hs.a(this.X) || this.X.contains("tencent") || this.X.contains(sm.f150331d);
    }

    private Bitmap c(String str) {
        FileInputStream fileInputStream;
        try {
            File file = new File(a(str));
            if (!file.exists()) {
                ku.a((Closeable) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                ku.a((Closeable) fileInputStream);
                return decodeStream;
            } catch (Throwable unused) {
                ku.a((Closeable) fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    private void l() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f150251af = alphaAnimation;
        alphaAnimation.setDuration(1000L);
        this.f150251af.setStartOffset(500L);
        this.f150251af.setAnimationListener(new AnonymousClass3());
    }

    private ViewGroup m() {
        return this.f150255aj.ab();
    }

    private String n() {
        return this.D.getFilesDir().getAbsolutePath() + "/tencentMapSdk/logos";
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final ew.b d() {
        return this.G;
    }

    public final void e() {
        if (!this.f150267m) {
            d(false);
        } else if (this.f150268n) {
            d(true);
            w();
        } else {
            d(true);
            v();
        }
    }

    public final void f() {
        kp.a(new f(this));
    }

    public final void g() {
        LogUtil.c(ky.f149117w, "clearLogoCache..");
        this.V.clear();
        this.W.clear();
        try {
            File file = new File(n());
            if (file.exists()) {
                File file2 = new File(o());
                if (file.renameTo(file2)) {
                    ku.c(file2.getAbsolutePath());
                } else {
                    ku.c(file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void h() {
        if (this.f150259d == 0 || this.P == 0) {
            return;
        }
        float f16 = this.Q;
        float f17 = this.f150264j;
        int i3 = (int) ((f16 * f17) / 3.0f);
        int i16 = (int) ((this.R * f17) / 3.0f);
        int[] d16 = d(i3, i16);
        int i17 = this.S;
        int i18 = d16[0];
        if (i17 != i18 || this.T != d16[1]) {
            this.S = i18;
            this.T = d16[1];
            this.A = true;
        }
        float[] fArr = this.M;
        int i19 = this.f150259d;
        if (i19 >= 1080) {
            fArr = this.O;
        } else if (i19 >= 720) {
            fArr = this.N;
        }
        int i26 = ew.a.LEFT.f148329e;
        float f18 = fArr[i26];
        float[] fArr2 = this.f150258c;
        float f19 = fArr2[i26];
        if (f19 >= 0.0f) {
            f18 = f19;
        }
        int[] iArr = this.K;
        iArr[i26] = (int) (i19 * f18);
        if (this.f150256ak) {
            this.J[ew.a.BOTTOM.f148329e] = i16;
        }
        int[] iArr2 = this.I;
        int i27 = iArr2[i26];
        if (i27 >= 0 && i27 < i19 - i3) {
            iArr[i26] = i27;
        }
        int i28 = ew.a.RIGHT.f148329e;
        float f26 = fArr[i28];
        float f27 = fArr2[i28];
        if (f27 >= 0.0f) {
            f26 = f27;
        }
        iArr[i28] = (int) (i19 * f26);
        int i29 = iArr2[i28];
        if (i29 >= 0 && i29 < i19 - i3) {
            iArr[i28] = i29;
        }
        int i36 = ew.a.BOTTOM.f148329e;
        float f28 = fArr[i36];
        float f29 = fArr2[i36];
        if (f29 >= 0.0f) {
            f28 = f29;
        }
        int i37 = this.P;
        iArr[i36] = (int) (i37 * f28);
        int i38 = iArr2[i36];
        if (i38 >= 0 && i38 < i37 - i16) {
            iArr[i36] = i38;
        }
        int i39 = ew.a.TOP.f148329e;
        float f36 = fArr[i39];
        float f37 = fArr2[i39];
        if (f37 >= 0.0f) {
            f36 = f37;
        }
        iArr[i39] = (int) (i37 * f36);
        int i46 = iArr2[i39];
        if (i46 >= 0 && i46 < i37 - i16) {
            iArr[i39] = i46;
        }
        f();
    }

    public final void i() {
        if (this.f150259d == 0 || this.P == 0) {
            return;
        }
        int measuredHeight = this.f150269o.getMeasuredHeight();
        int measuredWidth = this.f150269o.getMeasuredWidth();
        float[] fArr = this.M;
        int i3 = this.f150259d;
        if (i3 >= 1080) {
            fArr = this.O;
        } else if (i3 >= 720) {
            fArr = this.N;
        }
        int i16 = ew.a.LEFT.f148329e;
        float f16 = fArr[i16];
        float[] fArr2 = this.f150258c;
        float f17 = fArr2[i16];
        if (f17 >= 0.0f) {
            f16 = f17;
        }
        int[] iArr = this.L;
        iArr[i16] = (int) (i3 * f16);
        int[] iArr2 = this.J;
        int i17 = iArr2[i16];
        if (i17 >= 0 && i17 < i3 - measuredWidth) {
            iArr[i16] = i17;
        }
        int i18 = ew.a.RIGHT.f148329e;
        float f18 = fArr[i18];
        float f19 = fArr2[i18];
        if (f19 >= 0.0f) {
            f18 = f19;
        }
        iArr[i18] = (int) (i3 * f18);
        int i19 = iArr2[i18];
        if (i19 >= 0 && i19 < i3 - measuredWidth) {
            iArr[i18] = i19;
        }
        int i26 = ew.a.BOTTOM.f148329e;
        float f26 = fArr[i26];
        float f27 = fArr2[i26];
        if (f27 >= 0.0f) {
            f26 = f27;
        }
        int i27 = this.P;
        iArr[i26] = (int) (i27 * f26);
        int i28 = iArr2[i26];
        if (i28 >= 0 && i28 < i27 - measuredHeight) {
            iArr[i26] = i28;
        }
        int i29 = ew.a.TOP.f148329e;
        float f28 = fArr[i29];
        float f29 = fArr2[i29];
        if (f29 >= 0.0f) {
            f28 = f29;
        }
        iArr[i29] = (int) (i27 * f28);
        int i36 = iArr2[i29];
        if (i36 >= 0 && i36 < i27 - measuredHeight) {
            iArr[i29] = i36;
        }
        f();
    }

    public final Bitmap j() {
        Drawable drawable;
        ImageView imageView = this.f150248a;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private String b(String str) {
        return a(str) + ".tmp";
    }

    private int d(ew.a aVar) {
        return this.J[aVar.f148329e];
    }

    static /* synthetic */ ViewGroup k(sj sjVar) {
        return sjVar.f150255aj.ab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z16) {
        LinearLayout linearLayout = this.f150269o;
        if (linearLayout != null) {
            linearLayout.setVisibility(z16 ? 0 : 8);
            this.f150269o.requestLayout();
            this.f150269o.invalidate();
        }
        e eVar = this.Z;
        if (eVar != null) {
            eVar.invalidate();
        }
    }

    @Override // com.tencent.mapsdk.internal.fp
    public final void b(int i3, int i16) {
        this.f150259d = i3;
        this.P = i16;
        h();
        i();
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final boolean a(ViewGroup viewGroup, Bundle bundle) {
        boolean z16;
        qs qsVar;
        if (viewGroup == null) {
            return false;
        }
        if (this.A) {
            ku.a(this.F);
            Bitmap a16 = hn.a(this.E, this.D, this.S, this.T);
            this.F = a16;
            this.f150248a.setImageBitmap(a16);
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.S;
        int i16 = this.T;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (i3 != 0 && i16 != 0) {
            switch (AnonymousClass6.f150289a[this.G.ordinal()]) {
                case 1:
                    layoutParams.gravity = 83;
                    int[] iArr = this.K;
                    int i17 = iArr[ew.a.BOTTOM.f148329e];
                    layoutParams.bottomMargin = i17;
                    int i18 = iArr[ew.a.LEFT.f148329e];
                    layoutParams.leftMargin = i18;
                    this.f150253ah = (this.P - i17) - i16;
                    this.f150252ag = i18;
                    break;
                case 2:
                    layoutParams.gravity = 81;
                    int i19 = this.K[ew.a.BOTTOM.f148329e];
                    layoutParams.bottomMargin = i19;
                    this.f150253ah = (this.P - i19) - i16;
                    this.f150252ag = (this.f150259d - i3) / 2;
                    break;
                case 3:
                    layoutParams.gravity = 85;
                    int[] iArr2 = this.K;
                    layoutParams.bottomMargin = iArr2[ew.a.BOTTOM.f148329e];
                    layoutParams.rightMargin = iArr2[ew.a.RIGHT.f148329e];
                    if (tf.f150436c.equals("wechat") && (qsVar = this.f150275u) != null) {
                        int i26 = layoutParams.bottomMargin + (i16 * 2);
                        qsVar.f149919f = i26;
                        qq qqVar = qsVar.f149914a;
                        if (qqVar != null) {
                            qqVar.post(new qs.AnonymousClass1());
                        }
                        ViewGroup ab5 = qsVar.f149918e.ab();
                        if (ab5 != null) {
                            qsVar.f149920g = ab5.getMeasuredHeight();
                        }
                        M m3 = qsVar.f149918e.e_;
                        if (m3 != 0 && ((VectorMap) m3).f151351o.f149410w != null && ((VectorMap) m3).f151351o.f149410w.f151268q != null) {
                            qsVar.f149920g = (((int) ((VectorMap) m3).f151351o.f149410w.f151268q.f148384b) - i26) * 2;
                            qsVar.f();
                        }
                    }
                    this.f150253ah = (this.P - layoutParams.bottomMargin) - i16;
                    this.f150252ag = (this.f150259d - layoutParams.rightMargin) - i3;
                    break;
                case 4:
                    layoutParams.gravity = 51;
                    int[] iArr3 = this.K;
                    int i27 = iArr3[ew.a.TOP.f148329e];
                    layoutParams.topMargin = i27;
                    int i28 = iArr3[ew.a.LEFT.f148329e];
                    layoutParams.leftMargin = i28;
                    this.f150253ah = i27;
                    this.f150252ag = i28;
                    break;
                case 5:
                    layoutParams.gravity = 49;
                    int i29 = this.K[ew.a.TOP.f148329e];
                    layoutParams.topMargin = i29;
                    this.f150253ah = i29;
                    this.f150252ag = (this.f150259d - i3) / 2;
                    break;
                case 6:
                    layoutParams.gravity = 53;
                    int[] iArr4 = this.K;
                    int i36 = iArr4[ew.a.TOP.f148329e];
                    layoutParams.topMargin = i36;
                    int i37 = iArr4[ew.a.RIGHT.f148329e];
                    layoutParams.rightMargin = i37;
                    this.f150253ah = i36;
                    this.f150252ag = (this.f150259d - i37) - i3;
                    break;
                default:
                    LogUtil.d("Unknown position:" + this.G);
                    break;
            }
        }
        if (viewGroup.indexOfChild(this.f150249ab) < 0) {
            viewGroup.addView(this.f150249ab, layoutParams);
        } else {
            viewGroup.updateViewLayout(this.f150249ab, layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout = this.f150269o;
        if (linearLayout != null) {
            int measuredWidth = linearLayout.getMeasuredWidth();
            int measuredHeight = this.f150269o.getMeasuredHeight();
            switch (AnonymousClass6.f150289a[this.H.ordinal()]) {
                case 1:
                    layoutParams2.gravity = 83;
                    int[] iArr5 = this.L;
                    int i38 = iArr5[ew.a.BOTTOM.f148329e];
                    layoutParams2.bottomMargin = i38;
                    int i39 = iArr5[ew.a.LEFT.f148329e];
                    layoutParams2.leftMargin = i39;
                    this.f150274t = (this.P - i38) - measuredHeight;
                    this.f150273s = i39;
                    break;
                case 2:
                    layoutParams2.gravity = 81;
                    int i46 = this.L[ew.a.BOTTOM.f148329e];
                    layoutParams2.bottomMargin = i46;
                    this.f150274t = (this.P - i46) - measuredHeight;
                    this.f150273s = (this.f150259d - measuredWidth) / 2;
                    break;
                case 3:
                    layoutParams2.gravity = 85;
                    int[] iArr6 = this.L;
                    int i47 = iArr6[ew.a.BOTTOM.f148329e];
                    layoutParams2.bottomMargin = i47;
                    int i48 = iArr6[ew.a.RIGHT.f148329e];
                    layoutParams2.rightMargin = i48;
                    this.f150274t = (this.P - i47) - measuredHeight;
                    this.f150273s = (this.f150259d - i48) - measuredWidth;
                    break;
                case 4:
                    layoutParams2.gravity = 51;
                    int[] iArr7 = this.L;
                    int i49 = iArr7[ew.a.TOP.f148329e];
                    layoutParams2.topMargin = i49;
                    int i56 = iArr7[ew.a.LEFT.f148329e];
                    layoutParams2.leftMargin = i56;
                    this.f150274t = i49;
                    this.f150273s = i56;
                    break;
                case 5:
                    layoutParams2.gravity = 49;
                    int i57 = this.L[ew.a.TOP.f148329e];
                    layoutParams2.topMargin = i57;
                    this.f150274t = i57;
                    this.f150273s = (this.f150259d - measuredWidth) / 2;
                    break;
                case 6:
                    layoutParams2.gravity = 53;
                    int[] iArr8 = this.L;
                    int i58 = iArr8[ew.a.TOP.f148329e];
                    layoutParams2.topMargin = i58;
                    int i59 = iArr8[ew.a.RIGHT.f148329e];
                    layoutParams2.rightMargin = i59;
                    this.f150274t = i58;
                    this.f150273s = (this.f150259d - i59) - measuredWidth;
                    break;
                default:
                    LogUtil.d("Unknown positionScale:" + this.H);
                    break;
            }
        }
        if (viewGroup.indexOfChild(this.f150269o) < 0) {
            viewGroup.addView(this.f150269o, layoutParams2);
        } else {
            viewGroup.updateViewLayout(this.f150269o, layoutParams2);
        }
        e eVar = this.Z;
        if (eVar != null) {
            this.f150269o.updateViewLayout(eVar, eVar.getLayoutParams());
            e();
        }
        this.f150248a.setVisibility(this.f150257b ? 0 : 4);
        if (this.f150272r != null) {
            this.f150249ab.requestLayout();
            this.f150269o.requestLayout();
            for (c cVar : this.f150272r) {
                if (this.f150279y != null && !this.A && this.f150280z == this.f150257b) {
                    Rect rect = this.f150279y;
                    int i65 = rect.left;
                    int i66 = this.f150252ag;
                    if (i65 == i66 && rect.top == this.f150253ah && rect.right == i66 + this.f150249ab.getMeasuredWidth() && this.f150279y.bottom == this.f150253ah + this.f150249ab.getMeasuredHeight()) {
                        cVar.b(this.f150269o, new Rect(this.f150273s, this.f150274t, 0, 0), this.f150267m);
                    }
                }
                this.f150280z = this.f150257b;
                int i67 = this.f150252ag;
                Rect rect2 = new Rect(i67, this.f150253ah, this.f150249ab.getMeasuredWidth() + i67, this.f150253ah + this.f150249ab.getMeasuredHeight());
                this.f150279y = rect2;
                cVar.a(this.f150249ab, rect2, this.f150257b);
                cVar.b(this.f150269o, new Rect(this.f150273s, this.f150274t, 0, 0), this.f150267m);
            }
        }
        this.A = !z16 && this.A;
        viewGroup.requestLayout();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e extends View {

        /* renamed from: b, reason: collision with root package name */
        private static final int f150298b = -16777216;

        /* renamed from: c, reason: collision with root package name */
        private static final int f150299c = -7368817;

        /* renamed from: d, reason: collision with root package name */
        private static final int f150300d = 35;

        /* renamed from: e, reason: collision with root package name */
        private Paint f150302e;

        /* renamed from: f, reason: collision with root package name */
        private Paint f150303f;

        /* renamed from: g, reason: collision with root package name */
        private Paint f150304g;

        /* renamed from: h, reason: collision with root package name */
        private int f150305h;

        public e(Context context) {
            super(context);
            this.f150305h = -16777216;
            Paint paint = new Paint();
            this.f150302e = paint;
            paint.setAntiAlias(true);
            this.f150302e.setStrokeWidth(sj.this.f150264j * 1.0f);
            this.f150302e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f150303f = paint2;
            paint2.setTextSize(sj.this.f150264j * 12.0f);
            this.f150303f.setAntiAlias(true);
            Paint paint3 = new Paint(65);
            this.f150304g = paint3;
            paint3.setStyle(Paint.Style.FILL);
            this.f150304g.setColor(0);
        }

        private void a(Canvas canvas, int i3) {
            int i16 = (int) (sj.this.f150264j * 6.0f);
            int i17 = (i3 / 2) + ((int) (sj.this.f150264j * 7.0f));
            float measureText = this.f150303f.measureText(sj.this.f150262h);
            canvas.drawPaint(this.f150304g);
            float f16 = i16;
            float f17 = i17;
            canvas.drawText(sj.this.f150262h, ((sj.this.f150263i / 2.0f) + f16) - (measureText / 2.0f), f17 - (sj.this.f150264j * 6.0f), this.f150303f);
            canvas.drawLine(f16, f17, sj.this.f150263i + i16, f17, this.f150302e);
            canvas.drawLine(f16, f17 - (sj.this.f150264j * 3.0f), f16, f17 + (sj.this.f150264j * 0.5f), this.f150302e);
            canvas.drawLine(sj.this.f150263i + i16, f17 - (sj.this.f150264j * 3.0f), i16 + sj.this.f150263i, f17 + (sj.this.f150264j * 0.5f), this.f150302e);
        }

        @Override // android.view.View
        public final void draw(Canvas canvas) {
            super.draw(canvas);
            this.f150302e.setColor(this.f150305h);
            this.f150303f.setColor(this.f150305h);
            int height = getHeight();
            int i3 = (int) (sj.this.f150264j * 6.0f);
            int i16 = (height / 2) + ((int) (sj.this.f150264j * 7.0f));
            float measureText = this.f150303f.measureText(sj.this.f150262h);
            canvas.drawPaint(this.f150304g);
            float f16 = i3;
            float f17 = i16;
            canvas.drawText(sj.this.f150262h, ((sj.this.f150263i / 2.0f) + f16) - (measureText / 2.0f), f17 - (sj.this.f150264j * 6.0f), this.f150303f);
            canvas.drawLine(f16, f17, sj.this.f150263i + i3, f17, this.f150302e);
            canvas.drawLine(f16, f17 - (sj.this.f150264j * 3.0f), f16, f17 + (sj.this.f150264j * 0.5f), this.f150302e);
            canvas.drawLine(sj.this.f150263i + i3, f17 - (sj.this.f150264j * 3.0f), i3 + sj.this.f150263i, f17 + (sj.this.f150264j * 0.5f), this.f150302e);
        }

        @Override // android.view.View
        protected final void onMeasure(int i3, int i16) {
            super.onMeasure(i3, i16);
            setMeasuredDimension(Math.min(Math.round(sj.this.f150263i + (sj.this.f150264j * 12.0f)), sj.this.f150259d / 2), Math.round(sj.this.Y * sj.this.f150264j));
        }

        private void a(boolean z16) {
            int i3 = z16 ? f150299c : -16777216;
            if (i3 != this.f150305h) {
                this.f150305h = i3;
            }
        }

        static /* synthetic */ void a(e eVar, boolean z16) {
            int i3 = z16 ? f150299c : -16777216;
            if (i3 != eVar.f150305h) {
                eVar.f150305h = i3;
            }
        }
    }

    public final void b(ew.b bVar) {
        if (this.H != bVar) {
            f();
        }
        this.H = bVar;
    }

    private void e(boolean z16) {
        this.f150268n = !z16;
        e();
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final void c() {
        Iterator<Map.Entry<String, Bitmap>> it = this.V.entrySet().iterator();
        while (it.hasNext()) {
            ku.a(it.next().getValue());
        }
        ku.a(this.E);
        ku.a(this.F);
    }

    private int[] d(int i3, int i16) {
        int[] iArr = new int[2];
        float f16 = this.f150271q;
        if (f16 == Float.MIN_VALUE) {
            int i17 = this.f150260e;
            f16 = i17 != -3 ? i17 != -2 ? i17 != -1 ? i17 != 1 ? 1.0f : 1.2f : 0.8333333f : 0.8f : 0.7f;
        }
        iArr[0] = (int) (i3 * f16);
        iArr[1] = (int) (i16 * f16);
        return iArr;
    }

    @Override // com.tencent.mapsdk.internal.eu
    public final View[] b() {
        return new View[]{this.f150249ab, this.f150269o};
    }

    private int b(ew.a aVar) {
        return this.I[aVar.f148329e];
    }

    private void b(boolean z16) {
        this.f150257b = z16;
        ImageView imageView = this.f150248a;
        if (imageView != null) {
            imageView.setVisibility(z16 ? 0 : 4);
        }
    }

    private int c(ew.a aVar) {
        return this.K[aVar.f148329e];
    }

    private void c(boolean z16) {
        if (this.f150267m != z16) {
            this.f150267m = z16;
            List<c> list = this.f150272r;
            if (list != null) {
                Iterator<c> it = list.iterator();
                while (it.hasNext()) {
                    it.next().b(this.f150269o, new Rect(this.f150273s, this.f150274t, 0, 0), this.f150267m);
                }
            }
        }
        e();
    }

    public final void b(ew.a aVar, int i3) {
        if (this.f150256ak) {
            this.f150256ak = false;
        }
        this.J[aVar.f148329e] = i3;
        i();
    }

    private void b(float f16) {
        if (f16 > 1.3f) {
            f16 = 1.3f;
        }
        if (f16 < 0.7f) {
            f16 = 0.7f;
        }
        this.f150260e = 0;
        this.f150271q = f16;
        h();
    }

    private void c(int i3, int i16) {
        String str;
        float[] fArr = f150247f;
        int length = fArr.length;
        int i17 = this.f150265k - this.f150270p;
        if (i17 < 0) {
            i17 = 0;
        }
        if (i17 >= length) {
            i17 = length - 1;
        }
        float f16 = fArr[i17];
        if (this.f150261g != f16) {
            this.f150261g = f16;
            kp.a(new AnonymousClass5());
        }
        float f17 = i3;
        double d16 = this.f150266l;
        if (d16 != 0.0d) {
            f17 = (float) (f16 / d16);
        }
        int round = Math.round(f17);
        this.f150263i = round;
        if (round > i16) {
            this.f150263i = i16;
        } else if (round < i3) {
            this.f150263i = i3;
        }
        if (f16 >= 1000.0f) {
            f16 /= 1000.0f;
            str = "\u516c\u91cc";
        } else {
            str = "\u7c73";
        }
        this.f150262h = ((int) f16) + str;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sj$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass3 implements Animation.AnimationListener {
        AnonymousClass3() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            sj.this.d(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            sj.this.d(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public final void a(final boolean z16) {
        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.sj.4
            @Override // java.lang.Runnable
            public final void run() {
                if (sj.this.Z == null) {
                    return;
                }
                e.a(sj.this.Z, z16);
            }
        });
    }

    public final void a(gd gdVar, boolean z16) {
        if (this.E == null || gdVar.a(this.B) || this.C != z16) {
            this.B = gdVar.clone();
            this.C = z16;
            int i3 = (int) gdVar.f148477c;
            if (i3 > 18) {
                i3 = 18;
            }
            sn snVar = null;
            for (sn snVar2 : this.U) {
                if (i3 >= snVar2.f150344a && i3 <= snVar2.f150345b) {
                    Object[] a16 = snVar2.a(gdVar, z16);
                    if (a16 != null) {
                        String str = (String) a16[0];
                        String str2 = (String) a16[1];
                        Bitmap bitmap = (Bitmap) a16[2];
                        if (bitmap != null) {
                            a(bitmap);
                            this.X = str;
                        } else if (!hs.a(str, this.X)) {
                            LogUtil.c(ky.f149117w, "Logo[" + str + "] changed! old=" + this.X + "|dark=" + z16 + "|level=" + i3);
                            Bitmap bitmap2 = this.V.get(str);
                            if (bitmap2 != null) {
                                if (!bitmap2.isRecycled()) {
                                    a(bitmap2);
                                    this.X = str;
                                    LogUtil.c(ky.f149117w, "Logo[" + str + "] set from mem cache");
                                    return;
                                }
                                this.V.remove(str);
                            }
                            Bitmap c16 = c(str);
                            if (c16 != null) {
                                this.X = str;
                                this.V.put(str, c16);
                                a(c16);
                                LogUtil.c(ky.f149117w, "Logo[" + str + "] set from file cache");
                                return;
                            }
                            this.X = null;
                            a(str2, str);
                        }
                        snVar = snVar2;
                        break;
                    }
                    snVar = snVar2;
                }
            }
            if (snVar == null) {
                Bitmap bitmap3 = this.f150278x;
                if (bitmap3 == null || bitmap3.isRecycled()) {
                    this.f150278x = hn.b(this.D, "default_tencent_map_logo.png");
                }
                Bitmap bitmap4 = this.f150278x;
                if (bitmap4 != null) {
                    a(bitmap4);
                }
            }
        }
    }

    private void a(String str, String str2) {
        if (this.W.contains(str2)) {
            LogUtil.c(ky.f149117w, "Logo[" + str2 + "] is downloading.");
            return;
        }
        this.W.add(str2);
        LogUtil.c(ky.f149117w, "Logo[" + str2 + "] start download..");
        kp.a((kp.g) new a(this, str, str2)).a((kp.b.a) null, (kp.a<kp.b.a>) new b(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        String n3 = n();
        ku.a(n3);
        return n3 + "/" + str;
    }

    public final void a(List<ss> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.U.clear();
        for (int i3 = 0; i3 < list.size(); i3++) {
            ss ssVar = list.get(i3);
            int[] iArr = ssVar.f150385a;
            this.U.add(new sn(iArr[0], iArr[1], ssVar.f150386b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        try {
            this.E = bitmap;
            if (bitmap != null) {
                this.Q = bitmap.getWidth();
                this.R = this.E.getHeight();
                this.A = true;
            }
            h();
            i();
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final void a(ew.b bVar) {
        if (this.G != bVar) {
            f();
        }
        this.G = bVar;
    }

    private void a(qs qsVar) {
        this.f150275u = qsVar;
    }

    private FrameLayout.LayoutParams a(int i3, int i16) {
        qs qsVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (i3 != 0 && i16 != 0) {
            switch (AnonymousClass6.f150289a[this.G.ordinal()]) {
                case 1:
                    layoutParams.gravity = 83;
                    int[] iArr = this.K;
                    int i17 = iArr[ew.a.BOTTOM.f148329e];
                    layoutParams.bottomMargin = i17;
                    int i18 = iArr[ew.a.LEFT.f148329e];
                    layoutParams.leftMargin = i18;
                    this.f150253ah = (this.P - i17) - i16;
                    this.f150252ag = i18;
                    break;
                case 2:
                    layoutParams.gravity = 81;
                    int i19 = this.K[ew.a.BOTTOM.f148329e];
                    layoutParams.bottomMargin = i19;
                    this.f150253ah = (this.P - i19) - i16;
                    this.f150252ag = (this.f150259d - i3) / 2;
                    break;
                case 3:
                    layoutParams.gravity = 85;
                    int[] iArr2 = this.K;
                    layoutParams.bottomMargin = iArr2[ew.a.BOTTOM.f148329e];
                    layoutParams.rightMargin = iArr2[ew.a.RIGHT.f148329e];
                    if (tf.f150436c.equals("wechat") && (qsVar = this.f150275u) != null) {
                        int i26 = layoutParams.bottomMargin + (i16 * 2);
                        qsVar.f149919f = i26;
                        qq qqVar = qsVar.f149914a;
                        if (qqVar != null) {
                            qqVar.post(new qs.AnonymousClass1());
                        }
                        ViewGroup ab5 = qsVar.f149918e.ab();
                        if (ab5 != null) {
                            qsVar.f149920g = ab5.getMeasuredHeight();
                        }
                        M m3 = qsVar.f149918e.e_;
                        if (m3 != 0 && ((VectorMap) m3).f151351o.f149410w != null && ((VectorMap) m3).f151351o.f149410w.f151268q != null) {
                            qsVar.f149920g = (((int) ((VectorMap) m3).f151351o.f149410w.f151268q.f148384b) - i26) * 2;
                            qsVar.f();
                        }
                    }
                    this.f150253ah = (this.P - layoutParams.bottomMargin) - i16;
                    this.f150252ag = (this.f150259d - layoutParams.rightMargin) - i3;
                    break;
                case 4:
                    layoutParams.gravity = 51;
                    int[] iArr3 = this.K;
                    int i27 = iArr3[ew.a.TOP.f148329e];
                    layoutParams.topMargin = i27;
                    int i28 = iArr3[ew.a.LEFT.f148329e];
                    layoutParams.leftMargin = i28;
                    this.f150253ah = i27;
                    this.f150252ag = i28;
                    break;
                case 5:
                    layoutParams.gravity = 49;
                    int i29 = this.K[ew.a.TOP.f148329e];
                    layoutParams.topMargin = i29;
                    this.f150253ah = i29;
                    this.f150252ag = (this.f150259d - i3) / 2;
                    break;
                case 6:
                    layoutParams.gravity = 53;
                    int[] iArr4 = this.K;
                    int i36 = iArr4[ew.a.TOP.f148329e];
                    layoutParams.topMargin = i36;
                    int i37 = iArr4[ew.a.RIGHT.f148329e];
                    layoutParams.rightMargin = i37;
                    this.f150253ah = i36;
                    this.f150252ag = (this.f150259d - i37) - i3;
                    break;
                default:
                    LogUtil.d("Unknown position:" + this.G);
                    break;
            }
        }
        return layoutParams;
    }

    @Override // com.tencent.mapsdk.internal.eu, com.tencent.mapsdk.internal.ew
    public final Rect a() {
        Rect rect = new Rect();
        LinearLayout linearLayout = this.f150249ab;
        if (linearLayout != null) {
            rect.left = linearLayout.getLeft();
            rect.bottom = this.f150249ab.getBottom();
            rect.right = this.f150249ab.getRight();
            rect.top = this.f150249ab.getTop();
        }
        return rect;
    }

    private void a(ew.a aVar, float f16) {
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        this.f150258c[aVar.f148329e] = f16;
        h();
    }

    private float a(ew.a aVar) {
        return this.f150258c[aVar.f148329e];
    }

    public final void a(ew.a aVar, int i3) {
        this.I[aVar.f148329e] = i3;
    }

    private void a(int i3, double d16) {
        String str;
        this.f150265k = i3;
        this.f150266l = d16;
        int width = this.f150248a.getWidth();
        if (width <= 0) {
            width = 1000;
        }
        int ceil = (int) Math.ceil(width / 4.0f);
        int ceil2 = (int) (Math.ceil((this.f150259d * 3.0f) / 8.0f) - (this.f150264j * 6.0f));
        float[] fArr = f150247f;
        int length = fArr.length;
        int i16 = this.f150265k - this.f150270p;
        if (i16 < 0) {
            i16 = 0;
        }
        if (i16 >= length) {
            i16 = length - 1;
        }
        float f16 = fArr[i16];
        if (this.f150261g != f16) {
            this.f150261g = f16;
            kp.a(new AnonymousClass5());
        }
        float f17 = ceil;
        double d17 = this.f150266l;
        if (d17 != 0.0d) {
            f17 = (float) (f16 / d17);
        }
        int round = Math.round(f17);
        this.f150263i = round;
        if (round > ceil2) {
            this.f150263i = ceil2;
        } else if (round < ceil) {
            this.f150263i = ceil;
        }
        if (f16 >= 1000.0f) {
            f16 /= 1000.0f;
            str = "\u516c\u91cc";
        } else {
            str = "\u7c73";
        }
        this.f150262h = ((int) f16) + str;
        f();
    }

    private void a(float f16) {
        if (this.f150261g != f16) {
            this.f150261g = f16;
            kp.a(new AnonymousClass5());
        }
    }

    @Deprecated
    private void a(int i3) {
        this.f150260e = i3;
        this.f150271q = Float.MIN_VALUE;
        h();
    }

    private void a(c cVar) {
        List<c> list = this.f150272r;
        if (list == null || cVar == null) {
            return;
        }
        list.add(cVar);
    }

    static /* synthetic */ String a(sj sjVar, String str) {
        return sjVar.a(str) + ".tmp";
    }
}
