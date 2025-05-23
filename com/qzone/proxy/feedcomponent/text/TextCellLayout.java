package com.qzone.proxy.feedcomponent.text;

import NS_MOBILE_MATERIAL.BubbleSource;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.qzone.module.feedcomponent.detail.FeedDetailReply;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.QzoneFontManager;
import com.qzone.proxy.feedcomponent.text.c;
import com.qzone.proxy.feedcomponent.text.font.FontManager;
import com.qzone.proxy.feedcomponent.text.m;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.reborn.util.p;
import com.qzone.util.ToastUtil;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.font.api.IETFontService;
import com.tencent.mobileqq.vas.util.NinePatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.font.IFontManager;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import com.tencent.theme.TextHook;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneCrashHandler;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.Character;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TextCellLayout {

    /* renamed from: b2, reason: collision with root package name */
    public static boolean f50567b2 = false;

    /* renamed from: c2, reason: collision with root package name */
    private static boolean f50568c2 = ar.b("anzaihuang", "2024-06-06", "vas_text_cell_125230025").isEnable(true);

    /* renamed from: d2, reason: collision with root package name */
    private static final AtomicInteger f50569d2 = new AtomicInteger(1);

    /* renamed from: e2, reason: collision with root package name */
    protected static final boolean f50570e2 = false;

    /* renamed from: f2, reason: collision with root package name */
    protected static Object f50571f2 = new Object();

    /* renamed from: g2, reason: collision with root package name */
    private static final int f50572g2 = com.qzone.util.ar.d(30.0f);

    /* renamed from: h2, reason: collision with root package name */
    private static final int f50573h2 = com.qzone.util.ar.d(10.0f);

    /* renamed from: i2, reason: collision with root package name */
    private static final int f50574i2 = com.qzone.util.ar.d(40.0f);

    /* renamed from: j2, reason: collision with root package name */
    private static final int f50575j2 = com.qzone.util.ar.d(20.0f);

    /* renamed from: k2, reason: collision with root package name */
    private static final int f50576k2 = com.qzone.util.ar.d(50.0f);

    /* renamed from: l2, reason: collision with root package name */
    private static final int f50577l2 = com.qzone.util.ar.d(70.0f);

    /* renamed from: m2, reason: collision with root package name */
    private static String f50578m2;

    /* renamed from: n2, reason: collision with root package name */
    private static String f50579n2;

    /* renamed from: o2, reason: collision with root package name */
    private static boolean f50580o2;

    /* renamed from: p2, reason: collision with root package name */
    private static FeedDetailReply f50581p2;

    /* renamed from: q2, reason: collision with root package name */
    private static String f50582q2;

    /* renamed from: r2, reason: collision with root package name */
    private static long f50583r2;

    /* renamed from: s2, reason: collision with root package name */
    private static boolean f50584s2;
    private boolean A;
    private InnerOperateTextCell A0;
    private CellTextView.OnTextOperater A1;
    private int B;
    private float B0;
    private int B1;
    protected Paint C;
    private int C0;
    private k C1;
    protected int D;
    private int D0;
    private Transformation D1;
    private ArrayList<TextCell> E;
    private int E0;
    private Transformation E1;
    private boolean F;
    private int F0;
    private Drawable.Callback F1;
    private ArrayList<g> G;
    private String G0;
    private int G1;
    private ArrayList<Integer> H;
    private Drawable H0;
    private int H1;
    private boolean I;
    private long I0;
    private com.qzone.proxy.feedcomponent.text.font.a I1;
    private boolean J;
    private long J0;
    private boolean J1;
    private boolean K;
    private boolean K0;
    private boolean K1;
    private int L;
    public l L0;
    private Drawable L1;
    private int M;
    protected com.qzone.proxy.feedcomponent.text.l M0;
    private Drawable M1;
    private int N;
    public int N0;
    private long N1;
    private int O;
    public Typeface O0;
    private int O1;
    private int P;
    private Typeface P0;
    private Integer P1;
    private int Q;
    private LinearGradient Q0;
    private String Q1;
    private int R;
    private int[] R0;
    private int R1;
    private int S;
    private float[] S0;
    private boolean S1;
    private int T;
    private GradientDrawable.Orientation T0;
    private int T1;
    private int U;
    private int U0;
    private int U1;
    private int V;
    private int V0;
    private TranslateAnimation V1;
    private boolean W;
    private int W0;
    private Drawable W1;
    private int X;
    private int X0;
    private float[] X1;
    private ColorStateList Y;
    private int Y0;
    private boolean Y1;
    private ColorStateList Z;
    private boolean Z0;
    private QzoneFontManager.b Z1;

    /* renamed from: a, reason: collision with root package name */
    private boolean f50585a;

    /* renamed from: a0, reason: collision with root package name */
    private RectF f50586a0;

    /* renamed from: a1, reason: collision with root package name */
    protected Drawable f50587a1;

    /* renamed from: a2, reason: collision with root package name */
    private FontInterface.FullTypeResult f50588a2;

    /* renamed from: b, reason: collision with root package name */
    private int f50589b;

    /* renamed from: b0, reason: collision with root package name */
    private TextCell f50590b0;

    /* renamed from: b1, reason: collision with root package name */
    public Boolean f50591b1;

    /* renamed from: c, reason: collision with root package name */
    private float f50592c;

    /* renamed from: c0, reason: collision with root package name */
    private com.qzone.proxy.feedcomponent.text.g<Integer, Integer> f50593c0;

    /* renamed from: c1, reason: collision with root package name */
    public int f50594c1;

    /* renamed from: d, reason: collision with root package name */
    private float f50595d;

    /* renamed from: d0, reason: collision with root package name */
    private ArrayList<TextCell> f50596d0;

    /* renamed from: d1, reason: collision with root package name */
    private int f50597d1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f50598e;

    /* renamed from: e0, reason: collision with root package name */
    private float f50599e0;

    /* renamed from: e1, reason: collision with root package name */
    private int f50600e1;

    /* renamed from: f, reason: collision with root package name */
    private int f50601f;

    /* renamed from: f0, reason: collision with root package name */
    private float f50602f0;

    /* renamed from: f1, reason: collision with root package name */
    public boolean f50603f1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f50604g;

    /* renamed from: g0, reason: collision with root package name */
    private float f50605g0;

    /* renamed from: g1, reason: collision with root package name */
    public boolean f50606g1;

    /* renamed from: h, reason: collision with root package name */
    private int f50607h;

    /* renamed from: h0, reason: collision with root package name */
    private float f50608h0;

    /* renamed from: h1, reason: collision with root package name */
    public int f50609h1;

    /* renamed from: i, reason: collision with root package name */
    private int f50610i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f50611i0;

    /* renamed from: i1, reason: collision with root package name */
    private Integer f50612i1;

    /* renamed from: j, reason: collision with root package name */
    private int f50613j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f50614j0;

    /* renamed from: j1, reason: collision with root package name */
    public com.qzone.proxy.feedcomponent.text.c f50615j1;

    /* renamed from: k, reason: collision with root package name */
    private int f50616k;

    /* renamed from: k0, reason: collision with root package name */
    private OnCellClickListener f50617k0;

    /* renamed from: k1, reason: collision with root package name */
    public IETDecoration f50618k1;

    /* renamed from: l, reason: collision with root package name */
    private float f50619l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f50620l0;

    /* renamed from: l1, reason: collision with root package name */
    public com.qzone.proxy.feedcomponent.text.f f50621l1;

    /* renamed from: m, reason: collision with root package name */
    private int f50622m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f50623m0;

    /* renamed from: m1, reason: collision with root package name */
    private int f50624m1;

    /* renamed from: n, reason: collision with root package name */
    private int f50625n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f50626n0;

    /* renamed from: n1, reason: collision with root package name */
    private int f50627n1;

    /* renamed from: o, reason: collision with root package name */
    private int f50628o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f50629o0;

    /* renamed from: o1, reason: collision with root package name */
    public boolean f50630o1;

    /* renamed from: p, reason: collision with root package name */
    private int f50631p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f50632p0;

    /* renamed from: p1, reason: collision with root package name */
    private boolean f50633p1;

    /* renamed from: q, reason: collision with root package name */
    private int f50634q;

    /* renamed from: q0, reason: collision with root package name */
    private int f50635q0;

    /* renamed from: q1, reason: collision with root package name */
    private j f50636q1;

    /* renamed from: r, reason: collision with root package name */
    private int f50637r;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f50638r0;

    /* renamed from: r1, reason: collision with root package name */
    private j f50639r1;

    /* renamed from: s, reason: collision with root package name */
    private String f50640s;

    /* renamed from: s0, reason: collision with root package name */
    private float[] f50641s0;

    /* renamed from: s1, reason: collision with root package name */
    private int f50642s1;

    /* renamed from: t, reason: collision with root package name */
    private String f50643t;

    /* renamed from: t0, reason: collision with root package name */
    private com.qzone.proxy.feedcomponent.text.g<Integer, Float> f50644t0;

    /* renamed from: t1, reason: collision with root package name */
    private volatile boolean f50645t1;

    /* renamed from: u, reason: collision with root package name */
    private String f50646u;

    /* renamed from: u0, reason: collision with root package name */
    private com.qzone.proxy.feedcomponent.text.g<Integer, Integer> f50647u0;

    /* renamed from: u1, reason: collision with root package name */
    private ArrayList<k> f50648u1;

    /* renamed from: v, reason: collision with root package name */
    private boolean f50649v;

    /* renamed from: v0, reason: collision with root package name */
    private String f50650v0;

    /* renamed from: v1, reason: collision with root package name */
    private ArrayList<k> f50651v1;

    /* renamed from: w, reason: collision with root package name */
    private boolean f50652w;

    /* renamed from: w0, reason: collision with root package name */
    private TextCell f50653w0;

    /* renamed from: w1, reason: collision with root package name */
    private int f50654w1;

    /* renamed from: x, reason: collision with root package name */
    private int f50655x;

    /* renamed from: x0, reason: collision with root package name */
    private int f50656x0;

    /* renamed from: x1, reason: collision with root package name */
    private int f50657x1;

    /* renamed from: y, reason: collision with root package name */
    private int f50658y;

    /* renamed from: y0, reason: collision with root package name */
    private ColorTextCell f50659y0;

    /* renamed from: y1, reason: collision with root package name */
    protected volatile boolean f50660y1;

    /* renamed from: z, reason: collision with root package name */
    private int f50661z;

    /* renamed from: z0, reason: collision with root package name */
    private InnerOperateTextCell f50662z0;

    /* renamed from: z1, reason: collision with root package name */
    public TextLayoutBase f50663z1;

    /* compiled from: P */
    /* renamed from: com.qzone.proxy.feedcomponent.text.TextCellLayout$9, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass9 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnCellClickListener {
        void onClick(TextCell textCell, View view);

        boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f50670a;

        static {
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            f50670a = iArr;
            try {
                iArr[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50670a[GradientDrawable.Orientation.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50670a[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f50670a[GradientDrawable.Orientation.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f50670a[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f50670a[GradientDrawable.Orientation.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f50670a[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements CellTextView.OnTextOperater {
        b() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            TextCellLayout.this.F = false;
            TextCellLayout.this.f50663z1.invalidate();
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            TextCellLayout textCellLayout = TextCellLayout.this;
            textCellLayout.copyText(textCellLayout.getCopiedText());
            TextCellLayout.this.F = false;
            TextCellLayout.this.f50663z1.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements Drawable.Callback {
        c() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            TextCellLayout.this.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            View attachedView;
            TextLayoutBase textLayoutBase = TextCellLayout.this.f50663z1;
            if (textLayoutBase == null || (attachedView = textLayoutBase.getAttachedView()) == null) {
                return;
            }
            attachedView.scheduleDrawable(drawable, runnable, j3);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            View attachedView;
            TextLayoutBase textLayoutBase = TextCellLayout.this.f50663z1;
            if (textLayoutBase == null || (attachedView = textLayoutBase.getAttachedView()) == null) {
                return;
            }
            attachedView.unscheduleDrawable(drawable, runnable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface h {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface i {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j {

        /* renamed from: a, reason: collision with root package name */
        public int f50681a;

        public j(int i3) {
            this.f50681a = i3;
        }

        public void finalize() {
            Bitmap remove;
            if (this.f50681a <= 0 || (remove = com.qzone.proxy.feedcomponent.util.l.a().b().remove(Integer.valueOf(this.f50681a))) == null) {
                return;
            }
            remove.recycle();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface l {
        void onProgressChanged(long j3);
    }

    public TextCellLayout(TextLayoutBase textLayoutBase) {
        this(textLayoutBase, new Paint(1));
    }

    private void A(Canvas canvas) {
        com.qzone.proxy.feedcomponent.text.f fVar = this.f50621l1;
        if (fVar == null || this.f50618k1 == null) {
            return;
        }
        fVar.j();
        int i3 = this.C0;
        int i16 = this.D0;
        Bitmap G = G();
        if ((G == null || G.isRecycled()) && (G = q()) == null) {
            return;
        }
        Rect margins = this.f50618k1.getMargins();
        if (margins != null) {
            i3 += margins.left;
            i16 += margins.top;
        }
        G.eraseColor(0);
        Paint paint = this.C;
        com.qzone.proxy.feedcomponent.text.d dVar = paint instanceof com.qzone.proxy.feedcomponent.text.d ? (com.qzone.proxy.feedcomponent.text.d) paint : null;
        if (dVar != null) {
            this.f50618k1.drawBackgroundSpace(G, dVar.f(), i3, i16);
            canvas.drawBitmap(G, 0.0f, 0.0f, (Paint) null);
        }
    }

    private void B(Canvas canvas) {
        ArrayList<k> arrayList = this.f50651v1;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int N = N(this.f50648u1) + this.M + this.f50657x1;
        canvas.translate(N, 0.0f);
        Iterator<k> it = this.f50651v1.iterator();
        while (it.hasNext()) {
            k next = it.next();
            canvas.translate(0.0f, (this.O - next.f50685c.height()) / 2);
            q0(next);
            next.f50683a.draw(canvas);
            canvas.translate(0.0f, -r4);
            int width = next.f50685c.width() + this.f50657x1;
            canvas.translate(width, 0.0f);
            N += width;
        }
        canvas.translate(-N, 0.0f);
    }

    private com.qzone.proxy.feedcomponent.text.g<Integer, Integer> D(float f16, float f17) {
        if (this.f50647u0 == null) {
            this.f50647u0 = new com.qzone.proxy.feedcomponent.text.g<>(-1, -1);
        }
        int size = this.G.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.G.get(i3);
            int h16 = gVar.h();
            for (int i16 = 0; i16 < h16; i16++) {
                if (Z(f16, f17, gVar.g(i16), gVar.d(i16))) {
                    return this.f50647u0.a(Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }
        }
        return this.f50647u0.a(-1, -1);
    }

    private int K() {
        g gVar;
        Rect g16;
        int i3 = this.R;
        if (i3 > -1) {
            return i3;
        }
        this.R = 0;
        try {
            ArrayList<g> arrayList = this.G;
            if (arrayList != null && arrayList.size() > 0 && (gVar = this.G.get(0)) != null && gVar.h() > 0 && (gVar.d(0) instanceof ComboNetImageCell) && (g16 = gVar.g(0)) != null) {
                this.R = g16.right;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return this.R;
    }

    private int L() {
        if (this.f50624m1 < 0) {
            this.f50624m1 = f50569d2.addAndGet(1);
        }
        return this.f50624m1;
    }

    private int M() {
        if (this.f50627n1 < 0) {
            this.f50627n1 = f50569d2.addAndGet(1);
        }
        return this.f50627n1;
    }

    private Bitmap O(TextLayoutBase textLayoutBase) {
        Bitmap bitmap;
        if (this.f50630o1 || (bitmap = com.qzone.proxy.feedcomponent.util.l.a().b().get(Integer.valueOf(L()))) == null) {
            return null;
        }
        return bitmap;
    }

    private boolean P(MotionEvent motionEvent) {
        return false;
    }

    private boolean Q() {
        IETDecoration iETDecoration = this.f50618k1;
        return iETDecoration != null && iETDecoration.getFrameNum() > 0;
    }

    private void S(Canvas canvas, g gVar) {
        if (this.f50635q0 == 1) {
            int f16 = (this.L - gVar.f()) / 2;
            gVar.k(f16);
            canvas.translate(f16, 0.0f);
        }
        if (this.f50587a1 == null || gVar.g(0) == null) {
            return;
        }
        Rect g16 = gVar.g(0);
        int i3 = g16.bottom - g16.top;
        canvas.translate(-ViewUtils.dip2px(3.0f), 0.0f);
        this.f50587a1.setBounds(new Rect(0, g16.top + (i3 / 4), gVar.f() + ViewUtils.dip2px(6.0f), g16.top + ((i3 * 3) / 4)));
        this.f50587a1.draw(canvas);
        canvas.translate(ViewUtils.dip2px(3.0f), 0.0f);
    }

    private Drawable T(String str, int i3) {
        Drawable zipAnimationDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(zipAnimationDrawable, str, i3);
        zipAnimationDrawable.setCallback(this.F1);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(zipAnimationDrawable, com.qzone.util.ar.l() / 720.0f);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(zipAnimationDrawable);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(zipAnimationDrawable, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(zipAnimationDrawable, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(zipAnimationDrawable);
        return zipAnimationDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i3, String str, int i16) {
        com.qzone.proxy.feedcomponent.text.d dVar;
        if (!TextUtils.isEmpty(str) && i3 == this.N0) {
            Paint paint = this.C;
            if (paint instanceof com.qzone.proxy.feedcomponent.text.d) {
                dVar = (com.qzone.proxy.feedcomponent.text.d) paint;
            } else {
                dVar = new com.qzone.proxy.feedcomponent.text.d(1);
            }
            if (!dVar.j(i3, str, this.C, i16)) {
                Paint paint2 = this.C;
                if (paint2 instanceof com.qzone.proxy.feedcomponent.text.d) {
                    this.C = ((com.qzone.proxy.feedcomponent.text.d) paint2).e();
                    return;
                }
                return;
            }
            this.C = dVar;
            final View attachedView = this.f50663z1.getAttachedView();
            if (attachedView != null) {
                attachedView.post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.TextCellLayout.7
                    @Override // java.lang.Runnable
                    public void run() {
                        TextCellLayout.this.forceRequestLayout();
                        attachedView.requestLayout();
                    }
                });
            }
        }
    }

    private boolean W() {
        ArrayList<TextCell> arrayList;
        if (b0() && (arrayList = this.E) != null && arrayList.size() > 0) {
            return this.E.get(0).useDefaultFont;
        }
        return false;
    }

    private boolean X(char c16) {
        if ((c16 < 'a' || c16 > 'z') && ((c16 < 'A' || c16 > 'Z') && ((c16 < '0' || c16 > '9') && c16 != '\'' && c16 != ';' && c16 != ',' && c16 != '.' && c16 != '?' && c16 != '!' && c16 != '\"' && c16 != '_' && c16 != '-' && c16 != ':' && c16 != '@'))) {
            return false;
        }
        return true;
    }

    private Boolean a0() {
        return Boolean.valueOf((!b0() || W() || TextUtils.isEmpty(this.G0)) ? false : true);
    }

    private boolean b0() {
        return this.f50600e1 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0() {
        forceRequestLayout();
        this.f50663z1.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(FastDynamicDrawable fastDynamicDrawable) {
        Bitmap g16 = com.qzone.util.ar.g(fastDynamicDrawable, Boolean.TRUE);
        if (g16 == null) {
            return;
        }
        this.L1 = new NinePatchDrawable(g16, NinePatchUtil.getNinePatchChunk(new int[]{g16.getWidth() / 2, (g16.getWidth() / 2) + 1}, new int[]{1, g16.getHeight()}), new Rect(), null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.k
            @Override // java.lang.Runnable
            public final void run() {
                TextCellLayout.this.c0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit e0(final FastDynamicDrawable fastDynamicDrawable, com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.j
            @Override // java.lang.Runnable
            public final void run() {
                TextCellLayout.this.d0(fastDynamicDrawable);
            }
        }, 16, null, false);
        return null;
    }

    private void f0() {
        int i3;
        if (this.f50636q1 != null || (i3 = this.f50624m1) <= 0) {
            return;
        }
        this.f50636q1 = new j(i3);
    }

    public static int fontType2native(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i3 == 4) {
            return 4;
        }
        return 0;
    }

    public static String getClickSummary() {
        return f50582q2;
    }

    public static long getClickSummaryUin() {
        return f50583r2;
    }

    public static String getJumpCmtId() {
        return f50578m2;
    }

    public static FeedDetailReply getJumpRep() {
        return f50581p2;
    }

    public static String getJumpRepId() {
        return f50579n2;
    }

    private void i0(int i3) {
        int i16;
        int i17;
        int i18;
        this.H.clear();
        int i19 = 0;
        this.f50607h = 0;
        this.f50610i = this.f50613j;
        if (this.E == null) {
            return;
        }
        if (this.D == 1) {
            s0(getLargeFontSize());
        } else {
            s0(this.f50592c);
        }
        this.C.setTypeface(this.O0);
        Iterator<TextCell> it = this.E.iterator();
        while (it.hasNext()) {
            TextCell next = it.next();
            next.setDefaultShadowLayer(this.V0, this.W0, this.X0, this.Y0);
            if (!next.isUseCustomFont()) {
                next.setLinkColor(this.U);
                if (next instanceof ColorTextCell) {
                    ((ColorTextCell) next).setTextColor(this.S);
                }
                next.setFontSize(this.C, this.f50592c);
            }
        }
        if (b0() && !W()) {
            IETEngine d16 = com.qzone.proxy.feedcomponent.text.e.f().d();
            Paint paint = this.C;
            com.qzone.proxy.feedcomponent.text.d dVar = paint instanceof com.qzone.proxy.feedcomponent.text.d ? (com.qzone.proxy.feedcomponent.text.d) paint : null;
            if (this.f50612i1 == null && d16 != null && dVar != null) {
                this.f50612i1 = Integer.valueOf(d16.nativeGetHorizontalMarginThreshold(dVar.f(), i3));
            }
            if (this.f50612i1 == null) {
                this.f50612i1 = 0;
            }
            i3 -= this.f50612i1.intValue();
        }
        if (this.f50628o < 0) {
            this.f50628o = 1;
        }
        int i26 = 10;
        if (this.D == 1) {
            i16 = 5;
            i17 = 5;
        } else {
            i26 = 20;
            i16 = 8;
            i17 = 10;
        }
        if (this.f50628o != 0) {
            this.f50631p = i26;
            this.f50634q = i17;
            this.f50637r = i16;
        }
        boolean g06 = g0(i3);
        if (this.f50632p0 && g06) {
            o(0);
        }
        this.f50658y = 0;
        this.f50661z = 0;
        if (this.f50655x > 0 && this.G.size() > this.f50655x) {
            int size = this.G.size();
            int i27 = this.f50655x;
            if (size > i27 + 1 || this.H.get(i27).intValue() > 0) {
                for (int size2 = this.G.size() - 1; size2 >= this.f50655x; size2--) {
                    int i28 = this.f50658y + this.f50613j;
                    this.f50658y = i28;
                    this.f50658y = i28 + this.H.get(size2).intValue();
                    u(size2);
                }
                if (this.H.get(this.G.size() - 1).intValue() > 0) {
                    o(0);
                }
                n(i3, true);
                while (true) {
                    i18 = this.f50655x;
                    if (i19 >= i18 - 1) {
                        break;
                    }
                    this.f50661z = this.f50661z + this.H.get(i19).intValue() + this.f50613j;
                    i19++;
                }
                this.f50661z += this.H.get(i18 - 1).intValue() / 2;
                if (this.A) {
                    LpReportInfo_pf00064.allReport(209, 2, 13);
                    return;
                } else {
                    LpReportInfo_pf00064.allReport(115, 1, 1);
                    return;
                }
            }
        }
        if (this.f50628o != 0) {
            if (g06 && !this.f50632p0) {
                if (this.G.size() <= this.f50634q || this.G.size() > this.f50631p) {
                    return;
                }
                o(0);
                l0();
                if (this.Z0) {
                    return;
                }
                for (int size3 = this.G.size() - 1; size3 >= this.f50637r; size3--) {
                    u(size3);
                }
                this.f50610i -= this.f50613j;
                g o16 = o(0);
                float I = I(this.A0);
                this.f50607h = 0;
                l(o16, this.A0, I);
                return;
            }
            for (int size4 = this.G.size() - 1; size4 >= this.f50637r; size4--) {
                u(size4);
            }
            int i29 = this.f50610i;
            ArrayList<Integer> arrayList = this.H;
            this.f50610i = (i29 - arrayList.get(arrayList.size() - 1).intValue()) - this.f50613j;
            o(0);
            u0(g06);
            return;
        }
        if (!g06 || this.f50632p0) {
            m(i3);
        }
        u0(g06);
    }

    public static boolean isInMsgPage() {
        return f50584s2;
    }

    public static boolean isMoreClicked() {
        return f50580o2;
    }

    private boolean k0() {
        return this.f50633p1 && (this.C instanceof com.qzone.proxy.feedcomponent.text.d) && FontManager.enableTrueTypeFontViewCache() && this.G.size() <= 9 && this.G.size() >= 0;
    }

    private void l(g gVar, TextCell textCell, float f16) {
        int H = H(textCell);
        int intValue = this.H.get(this.G.size() - 1).intValue();
        if (H <= intValue) {
            H = intValue;
        }
        this.H.set(this.G.size() - 1, Integer.valueOf(H));
        int i3 = this.f50607h;
        int i16 = this.f50610i;
        Rect rect = new Rect(i3, i16, (int) (i3 + f16), H + i16);
        int i17 = (int) (this.f50607h + f16);
        this.f50607h = i17;
        int i18 = this.L;
        if (i17 <= i18) {
            i17 = i18;
        }
        this.L = i17;
        gVar.c(textCell, rect);
    }

    private void l0() {
        if (this.A0 == null) {
            InnerOperateTextCell innerOperateTextCell = new InnerOperateTextCell(18, this.f50640s);
            this.A0 = innerOperateTextCell;
            innerOperateTextCell.setCanCopy(false);
            InnerOperateTextCell innerOperateTextCell2 = this.A0;
            innerOperateTextCell2.useDefaultFont = true;
            innerOperateTextCell2.setFontSize(this.C, this.f50592c);
        }
        this.A0.setDefaultShadowLayer(this.V0, this.W0, this.X0, this.Y0);
        this.A0.setLinkColor(this.U);
        if (this.Z0) {
            this.A0.setText(this.f50640s);
        } else {
            this.A0.setText(this.f50643t);
        }
        int i3 = this.f50616k + 1048576;
        this.f50616k = i3;
        InnerOperateTextCell innerOperateTextCell3 = this.A0;
        innerOperateTextCell3.linebreakSeq = i3;
        if (this.f50620l0) {
            if (!this.f50585a) {
                innerOperateTextCell3.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.f157907a83));
                this.A0.setClickable(true);
            } else {
                innerOperateTextCell3.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.a7a));
                this.A0.setClickable(false);
            }
        }
        ArrayList<g> arrayList = this.G;
        g gVar = arrayList.get(arrayList.size() - 1);
        float I = I(this.A0);
        this.f50607h = 0;
        this.f50610i += this.f50613j;
        if (a0().booleanValue()) {
            this.f50610i += this.F0;
        }
        l(gVar, this.A0, I);
    }

    private void n0(com.qzone.proxy.feedcomponent.text.g<Integer, Integer> gVar) {
        if (this.f50590b0 == null) {
            return;
        }
        int size = this.G.size();
        for (int intValue = gVar.f50743a.intValue(); intValue >= 0; intValue--) {
            g gVar2 = this.G.get(intValue);
            for (int h16 = gVar2.h() - 1; h16 >= 0; h16--) {
                TextCell d16 = gVar2.d(h16);
                if (this.f50590b0.linebreakSeq == d16.linebreakSeq) {
                    d16.isPresseding = true;
                    this.f50596d0.add(d16);
                }
            }
        }
        int intValue2 = gVar.f50743a.intValue();
        while (intValue2 < size) {
            g gVar3 = this.G.get(intValue2);
            int h17 = gVar3.h();
            for (int intValue3 = intValue2 == gVar.f50743a.intValue() ? gVar.f50744b.intValue() : 0; intValue3 < h17; intValue3++) {
                TextCell d17 = gVar3.d(intValue3);
                if (this.f50590b0.linebreakSeq == d17.linebreakSeq) {
                    d17.isPresseding = true;
                    this.f50596d0.add(d17);
                }
            }
            intValue2++;
        }
        this.f50663z1.invalidate();
    }

    private Bitmap p() {
        try {
            p0();
            Bitmap createBitmap = Bitmap.createBitmap(this.L, this.O, Bitmap.Config.ARGB_8888);
            com.qzone.proxy.feedcomponent.util.l.a().b().put(Integer.valueOf(L()), createBitmap);
            f0();
            return createBitmap;
        } catch (Throwable th5) {
            this.f50633p1 = false;
            QZLog.e("TextCellLayout", "allocCacheBitmap OutOfMemoryError.errMsg = " + th5.getMessage());
            return null;
        }
    }

    private void p0() {
        Bitmap remove;
        if (this.f50624m1 <= 0 || (remove = com.qzone.proxy.feedcomponent.util.l.a().b().remove(Integer.valueOf(L()))) == null) {
            return;
        }
        remove.recycle();
    }

    private void q0(k kVar) {
        if (kVar.f50683a.getBounds().equals(kVar.f50685c)) {
            return;
        }
        kVar.f50683a.setBounds(kVar.f50685c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
    
        if ((r11 instanceof com.qzone.proxy.feedcomponent.text.DynamicImageCell) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b3, code lost:
    
        r3 = r3 + ((com.qzone.proxy.feedcomponent.text.DynamicImageCell) r11).getDrawableWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
    
        return r10.f50644t0.a(java.lang.Integer.valueOf(r1), java.lang.Float.valueOf(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.qzone.proxy.feedcomponent.text.g<Integer, Float> r(TextCell textCell, int i3) {
        String substring;
        if (this.f50644t0 == null) {
            this.f50644t0 = new com.qzone.proxy.feedcomponent.text.g<>(-1, Float.valueOf(-1.0f));
        }
        if (!textCell.canBreak()) {
            return this.f50644t0.a(Integer.valueOf(textCell.getLength()), Float.valueOf(textCell.getWidth(this.C)));
        }
        int indexOf = textCell.getText().indexOf(10);
        if (!(indexOf >= 0)) {
            substring = textCell.getText();
        } else {
            substring = textCell.getText().substring(0, indexOf + 1);
        }
        int length = substring.length();
        float f16 = 0.0f;
        int i16 = 0;
        while (true) {
            int i17 = i16 + 25;
            int i18 = (i17 >= length || !Character.isHighSurrogate(substring.charAt(i17 + (-1)))) ? 25 : 26;
            if (i16 >= length) {
                break;
            }
            if (i16 + i18 >= length) {
                i18 = length - i16;
            }
            QZoneCrashHandler.lastCrashedMeasuredText = substring;
            int widths = textCell.getWidths(this.C, i16, i18, this.f50641s0);
            QZoneCrashHandler.lastCrashedMeasuredText = null;
            int i19 = 0;
            while (i19 < widths) {
                float f17 = this.f50641s0[i19] + f16;
                if (f17 > i3) {
                    return this.f50644t0.a(Integer.valueOf(i19 + i16), Float.valueOf(f16));
                }
                i19++;
                f16 = f17;
            }
            if (widths < i18 || i18 == 0) {
                break;
            }
            i16 += i18;
        }
    }

    private void r0(float f16) {
        this.C.setTextSize(f16);
        Paint.FontMetrics fontMetrics = this.C.getFontMetrics();
        this.f50589b = (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
    }

    private boolean s(float f16, float f17) {
        float f18 = this.f50599e0;
        if (f18 >= 0.0f) {
            float f19 = this.f50602f0;
            if (f19 >= 0.0f) {
                r3 = ((f18 - f16) * (f18 - f16)) + ((f19 - f17) * (f19 - f17)) > ((float) ip.b.f408127c);
                if (r3) {
                    this.f50602f0 = -1.0f;
                    this.f50599e0 = -1.0f;
                }
            }
        }
        return r3;
    }

    public static void setClickSummary(String str, long j3) {
        f50582q2 = str;
        f50583r2 = j3;
    }

    public static void setIsInMsgPage(boolean z16) {
        f50584s2 = z16;
    }

    public static void setIsMoreClicked(boolean z16) {
        f50580o2 = z16;
    }

    public static void setJumpRep(FeedDetailReply feedDetailReply) {
        if (TextUtils.isEmpty(f50579n2)) {
            return;
        }
        f50581p2 = feedDetailReply;
    }

    private boolean t(boolean z16) {
        if (!b0()) {
            return false;
        }
        IETEngine d16 = com.qzone.proxy.feedcomponent.text.e.f().d();
        Paint paint = this.C;
        com.qzone.proxy.feedcomponent.text.d dVar = paint instanceof com.qzone.proxy.feedcomponent.text.d ? (com.qzone.proxy.feedcomponent.text.d) paint : null;
        if (d16 == null || dVar == null) {
            return false;
        }
        if (this.f50621l1 == null) {
            this.f50621l1 = new com.qzone.proxy.feedcomponent.text.f();
        }
        if (this.f50615j1 == null) {
            this.f50615j1 = new com.qzone.proxy.feedcomponent.text.c(this, Looper.getMainLooper());
        }
        int i3 = this.M;
        boolean k3 = this.f50621l1.k(this.G, i3, (this.N - this.D0) - this.F0, i3, this.f50597d1, z16, !W(), ((IETFontService) QRoute.api(IETFontService.class)).createETFont(dVar.f()));
        IETDecoration iETDecoration = this.f50618k1;
        if (iETDecoration == null) {
            this.f50618k1 = this.f50621l1.a(d16, false);
        } else if (k3) {
            iETDecoration.deleteDescriptor();
            this.f50618k1 = this.f50621l1.a(d16, false);
        }
        return k3;
    }

    private void t0(Typeface typeface) {
        if (this.C.getTypeface() != typeface) {
            this.C.setTypeface(typeface);
            this.P0 = typeface;
            requestLayout();
        }
    }

    private void u(int i3) {
        this.f50610i = (this.f50610i - this.H.get(i3).intValue()) - this.f50613j;
        this.G.remove(i3);
        this.H.remove(i3);
    }

    private void u0(boolean z16) {
        if ((!this.f50629o0 || z16) && !this.f50632p0) {
            return;
        }
        if (this.f50662z0 == null) {
            InnerOperateTextCell innerOperateTextCell = new InnerOperateTextCell(5, this.f50646u);
            this.f50662z0 = innerOperateTextCell;
            innerOperateTextCell.useDefaultFont = true;
            innerOperateTextCell.setCanCopy(false);
            InnerOperateTextCell innerOperateTextCell2 = this.f50662z0;
            Paint paint = this.C;
            float f16 = this.f50595d;
            if (f16 == 0.0f) {
                f16 = this.f50592c;
            }
            innerOperateTextCell2.setFontSize(paint, f16);
        }
        this.f50662z0.setDefaultShadowLayer(this.V0, this.W0, this.X0, this.Y0);
        this.f50662z0.setLinkColor(this.U);
        int i3 = this.f50616k + 1048576;
        this.f50616k = i3;
        InnerOperateTextCell innerOperateTextCell3 = this.f50662z0;
        innerOperateTextCell3.linebreakSeq = i3;
        if (this.f50620l0) {
            if (!this.f50585a) {
                innerOperateTextCell3.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.f157907a83));
                this.f50662z0.setClickable(true);
            } else {
                innerOperateTextCell3.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.a7a));
                this.f50662z0.setClickable(false);
            }
        }
        if (this.f50598e) {
            this.f50662z0.setClickable(false);
        }
        int i16 = this.f50601f;
        if (i16 != 0) {
            this.f50662z0.setTextColor(i16);
            this.f50662z0.setLinkColor(this.f50601f);
        }
        ArrayList<g> arrayList = this.G;
        g gVar = arrayList.get(arrayList.size() - 1);
        float I = I(this.f50662z0);
        this.f50607h = 0;
        this.f50610i += this.f50613j;
        if (a0().booleanValue()) {
            this.f50610i += this.F0;
        }
        l(gVar, this.f50662z0, I);
    }

    private boolean v(Canvas canvas) {
        com.qzone.proxy.feedcomponent.text.f fVar = this.f50621l1;
        if (fVar == null || this.f50618k1 == null || !this.f50603f1) {
            return true;
        }
        int h16 = fVar.h() + this.C0;
        int i3 = this.f50621l1.i() + this.D0;
        Bitmap G = G();
        if (G == null || G.isRecycled()) {
            return false;
        }
        canvas.drawBitmap(G, h16, i3, (Paint) null);
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x002f. Please report as an issue. */
    private void v0() {
        float f16;
        float f17;
        int i3;
        float f18;
        float f19;
        float f26;
        int i16;
        float f27;
        float f28;
        int i17;
        float f29;
        float f36;
        float f37;
        float f38;
        if (this.R0 == null || this.S0 == null) {
            return;
        }
        if (this.Q0 == null || this.U0 != this.M) {
            this.U0 = this.M;
            Rect rect = new Rect(0, 0, this.U0, this.O);
            switch (a.f50670a[this.T0.ordinal()]) {
                case 1:
                    f16 = rect.left;
                    f17 = rect.top;
                    i3 = rect.bottom;
                    f29 = i3 * 1.0f;
                    f36 = f16;
                    f37 = f36;
                    f38 = f17;
                    break;
                case 2:
                    f18 = rect.right;
                    f19 = rect.top;
                    f26 = rect.left * 1.0f;
                    i16 = rect.bottom;
                    f29 = i16 * 1.0f;
                    f36 = f18;
                    f38 = f19;
                    f37 = f26;
                    break;
                case 3:
                    f27 = rect.right;
                    f28 = rect.top;
                    i17 = rect.left;
                    f37 = i17 * 1.0f;
                    f36 = f27;
                    f38 = f28;
                    f29 = f38;
                    break;
                case 4:
                    f18 = rect.right;
                    f19 = rect.bottom;
                    f26 = rect.left * 1.0f;
                    i16 = rect.top;
                    f29 = i16 * 1.0f;
                    f36 = f18;
                    f38 = f19;
                    f37 = f26;
                    break;
                case 5:
                    f16 = rect.left;
                    f17 = rect.bottom;
                    i3 = rect.top;
                    f29 = i3 * 1.0f;
                    f36 = f16;
                    f37 = f36;
                    f38 = f17;
                    break;
                case 6:
                    f18 = rect.left;
                    f19 = rect.bottom;
                    f26 = rect.right * 1.0f;
                    i16 = rect.top;
                    f29 = i16 * 1.0f;
                    f36 = f18;
                    f38 = f19;
                    f37 = f26;
                    break;
                case 7:
                    f27 = rect.left;
                    f28 = rect.top;
                    i17 = rect.right;
                    f37 = i17 * 1.0f;
                    f36 = f27;
                    f38 = f28;
                    f29 = f38;
                    break;
                default:
                    f18 = rect.left;
                    f19 = rect.top;
                    f26 = rect.right * 1.0f;
                    i16 = rect.bottom;
                    f29 = i16 * 1.0f;
                    f36 = f18;
                    f38 = f19;
                    f37 = f26;
                    break;
            }
            this.Q0 = new LinearGradient(f36, f38, f37, f29, this.R0, this.S0, Shader.TileMode.CLAMP);
        }
    }

    private void y(Canvas canvas) {
        ArrayList<k> arrayList = this.f50648u1;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<k> it = this.f50648u1.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            k next = it.next();
            canvas.translate(0.0f, (this.O - next.f50685c.height()) / 2);
            q0(next);
            next.f50683a.draw(canvas);
            canvas.translate(0.0f, -r4);
            int width = next.f50685c.width() + this.f50657x1;
            canvas.translate(width, 0.0f);
            i3 += width;
        }
        canvas.translate(-i3, 0.0f);
    }

    private boolean z(Canvas canvas) {
        if (this.f50621l1 != null && this.f50618k1 != null && this.f50603f1) {
            int K = K();
            int i3 = this.C0 + K;
            int i16 = this.D0;
            if (a0().booleanValue()) {
                w(canvas);
            }
            Bitmap G = G();
            if (G != null && !G.isRecycled()) {
                canvas.drawBitmap(G, i3, i16, (Paint) null);
                return K <= 0;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap G() {
        Bitmap bitmap;
        if (this.f50630o1 || (bitmap = com.qzone.proxy.feedcomponent.util.l.a().b().get(Integer.valueOf(M()))) == null) {
            return null;
        }
        return bitmap;
    }

    protected int H(TextCell textCell) {
        return textCell.getHeight(this.C);
    }

    protected float I(TextCell textCell) {
        return textCell.getWidth(this.C);
    }

    public void attachView(TextLayoutBase textLayoutBase) {
        this.f50663z1 = textLayoutBase;
    }

    public boolean cloneBitmap(c.b bVar, IETEngine iETEngine, Bitmap bitmap, Bitmap bitmap2) {
        boolean z16;
        synchronized (this) {
            z16 = false;
            if (bitmap != null && bitmap2 != null) {
                if (!bitmap2.isRecycled() && bVar.f50701c == this.f50609h1) {
                    bitmap2.eraseColor(0);
                    iETEngine.nativeCloneBitmap(bitmap, bitmap2);
                    z16 = true;
                }
            }
        }
        return z16;
    }

    public void copyText(String str) {
        try {
            ((ClipboardManager) BaseApplication.getContext().getSystemService("clipboard")).setText(str);
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopyYet", "\u5df2\u590d\u5236"), 5);
        } catch (Exception unused) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopyFail", "\u590d\u5236\u5931\u8d25"), 4);
        }
    }

    public boolean draw(TextLayoutBase textLayoutBase, Canvas canvas) {
        boolean z16;
        View attachedView;
        if (this.f50660y1) {
            return false;
        }
        synchronized (this) {
            if (this.f50660y1) {
                return false;
            }
            if (b0()) {
                if (textLayoutBase != null && (attachedView = textLayoutBase.getAttachedView()) != null) {
                    attachedView.postDelayed(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.TextCellLayout.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TextCellLayout.this.startXuanDongAnimation();
                        }
                    }, 100L);
                }
                if (W()) {
                    z16 = v(canvas);
                } else {
                    if (z(canvas)) {
                        return true;
                    }
                    z16 = true;
                }
                Paint paint = this.C;
                if (paint instanceof com.qzone.proxy.feedcomponent.text.d) {
                    ((com.qzone.proxy.feedcomponent.text.d) paint).f50712d = z16;
                }
            }
            if (this.D == 1) {
                s0(getLargeFontSize());
            } else {
                s0(this.f50592c);
            }
            this.C.setTypeface(this.O0);
            int i3 = this.S;
            int i16 = this.U;
            com.qzone.proxy.feedcomponent.text.l lVar = this.M0;
            if (lVar != null) {
                if (lVar.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.D1)) {
                    postInvalidateOnAnimation();
                }
                this.S = this.M0.a();
                this.U = this.M0.a();
            }
            this.C.setTypeface(this.O0);
            this.C.setShadowLayer(this.V0, this.W0, this.X0, this.Y0);
            v0();
            LinearGradient linearGradient = this.Q0;
            if (linearGradient != null) {
                this.C.setShader(linearGradient);
            }
            if (this.f50594c1 == 1) {
                C(textLayoutBase, canvas);
                if (this.K0) {
                    postInvalidateOnFadeAnimation();
                }
            } else {
                U(textLayoutBase, canvas);
            }
            if (this.Q0 != null) {
                this.C.setShader(null);
            }
            this.S = i3;
            this.U = i16;
            return true;
        }
    }

    public String getCopiedText() {
        if (this.E == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int size = this.G.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.G.get(i3);
            int h16 = gVar.h();
            for (int i16 = 0; i16 < h16; i16++) {
                TextCell d16 = gVar.d(i16);
                TextCell textCell = this.f50590b0;
                if (textCell != null && !textCell.canCopy()) {
                    TextCell textCell2 = this.f50590b0;
                    if (textCell2.type == 3) {
                        if (d16.linebreakSeq == textCell2.linebreakSeq) {
                            sb5.append(d16.getText());
                        }
                    }
                }
                if (d16.canCopy()) {
                    sb5.append(d16.getText());
                }
            }
        }
        return sb5.toString();
    }

    public String getDisplayedText() {
        if (this.E == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        int size = this.G.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.G.get(i3);
            int h16 = gVar.h();
            for (int i16 = 0; i16 < h16; i16++) {
                sb5.append(gVar.d(i16).getText());
            }
        }
        return sb5.toString();
    }

    public int getFontHeight(float f16) {
        if (this.f50589b == 0) {
            r0(f16);
        }
        return this.f50589b;
    }

    public int getLargeFontSize() {
        if (this.Q <= 0) {
            this.Q = com.qzone.util.ar.e(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZ_CUSTOM_FONT, QzoneConfig.SECONDARY_LARGE_FONT_SIZE, 30));
        }
        return this.Q;
    }

    public int getLineCount() {
        int i3 = this.f50622m;
        if (i3 > 0) {
            int i16 = this.f50625n;
            return i16 >= i3 ? i3 : i16;
        }
        return this.B1;
    }

    public int getLineHeight() {
        if (this.H.size() > 0) {
            return this.H.get(0).intValue();
        }
        return 0;
    }

    public int getMaxCommentLine() {
        return this.f50655x;
    }

    public int getMeausredHeight() {
        return this.O;
    }

    public int getMeausredWidth() {
        return this.L;
    }

    public Paint getPaint() {
        return this.C;
    }

    public String getText() {
        if (this.E == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<TextCell> it = this.E.iterator();
        while (it.hasNext()) {
            String text = it.next().getText();
            if (text != null) {
                sb5.append(text);
            }
        }
        return sb5.toString();
    }

    public float getTextSize() {
        return this.C.getTextSize();
    }

    public int getTextWidth() {
        int size;
        if (this.G.size() > 0 && (size = this.G.get(0).f50678b.size()) > 0) {
            this.P = ((Rect) this.G.get(0).f50678b.get(size - 1)).right;
        }
        return this.P;
    }

    protected void h0(int i3, int i16) {
        if (f50570e2) {
            synchronized (f50571f2) {
                j0(i3, i16);
            }
            return;
        }
        j0(i3, i16);
    }

    public void invalidate() {
        View attachedView;
        TextLayoutBase textLayoutBase = this.f50663z1;
        if (textLayoutBase == null || (attachedView = textLayoutBase.getAttachedView()) == null) {
            return;
        }
        attachedView.invalidate();
    }

    public boolean isChinesePunctuation(char c16) {
        Character.UnicodeBlock of5 = Character.UnicodeBlock.of(c16);
        return of5 == Character.UnicodeBlock.GENERAL_PUNCTUATION || of5 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of5 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || of5 == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS || of5 == Character.UnicodeBlock.VERTICAL_FORMS;
    }

    public boolean isEnglishPunctuation(char c16) {
        if (c16 != '\'' && c16 != ';' && c16 != ',' && c16 != '.' && c16 != '?' && c16 != '!' && c16 != '\"' && c16 != '_' && c16 != '-' && c16 != ':' && c16 != '@') {
            return false;
        }
        return true;
    }

    public boolean isScroll() {
        return this.f50645t1;
    }

    public boolean isShown() {
        View attachedView;
        TextLayoutBase textLayoutBase = this.f50663z1;
        if (textLayoutBase == null || (attachedView = textLayoutBase.getAttachedView()) == null) {
            return false;
        }
        int[] iArr = new int[2];
        attachedView.getLocationOnScreen(iArr);
        int height = attachedView.getHeight();
        int i3 = iArr[1];
        return height + i3 > AreaConst.dp50 && i3 < u5.a.c() + ViewUtils.getStatusBarHeight(attachedView.getContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void j0(int i3, int i16) {
        int size;
        int intValue;
        int i17;
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (size2 <= 0) {
            size2 = u5.a.d();
        }
        int i18 = this.B;
        if (i18 > 0 && i18 < size2) {
            size2 = i18;
        }
        int i19 = this.f50625n;
        if (this.J1) {
            this.f50625n = 1;
        }
        if (this.I || this.L != size2) {
            this.I = false;
            int N = N(this.f50648u1) + N(this.f50651v1);
            int i26 = ((size2 - N) - this.C0) - this.E0;
            this.f50597d1 = i26;
            if (this.K) {
                m.b c16 = m.b().c(i26, (int) this.C.getTextSize(), getText());
                if (c16 != null && !this.J) {
                    this.H = c16.f50767b;
                    this.G = c16.f50766a;
                    this.L = c16.f50768c;
                } else {
                    i0(i26);
                    m.b().f(i26, (int) this.C.getTextSize(), getText(), new m.b(this.G, this.H, this.L));
                    this.J = false;
                }
            } else {
                i0(i26);
            }
            int i27 = this.f50591b1.booleanValue() ? this.f50613j : 0;
            this.M = this.L;
            for (int size3 = this.H.size() - 1; size3 >= 0; size3--) {
                i27 += this.H.get(size3).intValue() + this.f50613j;
            }
            if (this.f50622m > this.H.size() && this.f50628o != 0) {
                int i28 = this.f50631p;
                int i29 = this.f50622m;
                if (i28 <= i29 && i28 >= 0) {
                    size = i28 - this.H.size();
                } else {
                    size = i29 - this.H.size();
                }
                ArrayList<Integer> arrayList = this.H;
                intValue = arrayList.get(arrayList.size() - 1).intValue();
                i17 = this.f50613j;
            } else {
                if (this.f50622m > this.H.size() && this.f50628o == 0) {
                    int i36 = this.f50625n;
                    int i37 = this.f50622m;
                    if (i36 <= i37 && i36 >= 0) {
                        size = i36 - this.H.size();
                    } else {
                        size = i37 - this.H.size();
                    }
                    ArrayList<Integer> arrayList2 = this.H;
                    intValue = arrayList2.get(arrayList2.size() - 1).intValue();
                    i17 = this.f50613j;
                }
                int i38 = this.D0 + this.F0 + i27;
                this.N = i38;
                if (mode == 1073741824 && (mode != 0 || size2 <= 0)) {
                    this.L = this.L + this.E0 + this.C0 + N;
                } else {
                    this.L = size2;
                }
                this.O = Math.max(i38, this.f50654w1);
                if (this.J1) {
                    this.O = f50574i2;
                    this.f50625n = i19;
                }
                this.B1 = this.G.size();
            }
            i27 += size * (intValue + i17);
            int i382 = this.D0 + this.F0 + i27;
            this.N = i382;
            if (mode == 1073741824) {
            }
            this.L = size2;
            this.O = Math.max(i382, this.f50654w1);
            if (this.J1) {
            }
            this.B1 = this.G.size();
        }
    }

    public void measure(int i3, int i16) {
        synchronized (this) {
            this.f50660y1 = true;
            this.f50612i1 = null;
            h0(i3, i16);
            if (b0()) {
                if (W()) {
                    t(false);
                } else {
                    t(true);
                    if (this.f50618k1 == null) {
                        this.f50612i1 = 0;
                        this.I = true;
                        h0(i3, i16);
                        t(false);
                    }
                }
                if (!this.f50603f1) {
                    resetXuanDongAnimation();
                }
            }
            this.f50660y1 = false;
            if (k0() && !b0()) {
                draw(this.f50663z1, null);
            }
        }
    }

    public void onPause() {
        if (this.W1 != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.W1);
        }
    }

    public void onResume() {
        restartAnimation();
    }

    public void onStateIdle() {
        if (this.f50645t1) {
            this.f50645t1 = false;
            if (!isShown()) {
                resetXuanDongAnimation();
                stopAnimation();
            } else {
                startXuanDongAnimation();
                restartAnimation();
            }
        }
    }

    public void onStateScrolling() {
        if (b0() && this.f50606g1 && !isShown()) {
            resetXuanDongAnimation();
        }
        if (this.f50645t1) {
            return;
        }
        this.f50645t1 = true;
        stopAnimation();
    }

    public boolean onTouchEvent(MotionEvent motionEvent, Handler handler) {
        motionEvent.offsetLocation(this.C0, 0.0f);
        if (P(motionEvent)) {
            return true;
        }
        motionEvent.offsetLocation(N(this.f50648u1), 0.0f);
        if (motionEvent.getAction() == 0) {
            this.f50630o1 = true;
            clearTouchTarget();
            this.f50599e0 = motionEvent.getX();
            this.f50602f0 = motionEvent.getY();
            this.f50605g0 = motionEvent.getRawX();
            this.f50608h0 = motionEvent.getRawY();
            if (this.f50614j0 && !handler.hasMessages(0)) {
                this.f50663z1.setLongClickTrig(false);
                this.f50663z1.performCellLongClick();
            }
            if (this.f50620l0) {
                com.qzone.proxy.feedcomponent.text.g<Integer, Integer> D = D(motionEvent.getX(), motionEvent.getY());
                if (D.f50743a.intValue() != -1) {
                    this.f50593c0 = D;
                    TextCell d16 = this.G.get(D.f50743a.intValue()).d(D.f50744b.intValue());
                    if ((!this.J1 || d16.useDefaultFont || this.K1 || (d16 instanceof ComboNetImageCell)) && d16.clickable()) {
                        this.f50593c0 = D;
                        this.f50590b0 = d16;
                        n0(D);
                        return true;
                    }
                }
            }
            if (this.f50611i0) {
                this.f50663z1.setPressed(true);
                this.f50663z1.invalidate();
                return true;
            }
            if (this.f50614j0) {
                return true;
            }
            handler.removeMessages(0);
            return false;
        }
        if (motionEvent.getAction() == 2) {
            this.f50630o1 = true;
            if (this.f50663z1.isLongClickTrig()) {
                return true;
            }
            boolean s16 = s(motionEvent.getX(), motionEvent.getY());
            if (this.f50590b0 != null) {
                if (Y(motionEvent.getX(), motionEvent.getY(), this.G.get(this.f50593c0.f50743a.intValue()).g(this.f50593c0.f50744b.intValue()))) {
                    return true;
                }
                clearTouchTarget();
                handler.removeMessages(0);
                this.f50663z1.setLongClickTrig(false);
                return false;
            }
            if (!s16 && (this.f50611i0 || !this.f50663z1.isLongClickTrig())) {
                return true;
            }
        } else {
            if (motionEvent.getAction() == 1) {
                this.f50630o1 = true;
                this.f50663z1.setPressed(false);
                if (this.f50663z1.isLongClickTrig()) {
                    clearTouchTarget();
                    return true;
                }
                handler.removeMessages(0);
                this.f50663z1.setLongClickTrig(false);
                if (this.f50590b0 != null) {
                    if (Y(motionEvent.getX(), motionEvent.getY(), this.G.get(this.f50593c0.f50743a.intValue()).g(this.f50593c0.f50744b.intValue()))) {
                        m0(this.f50590b0, motionEvent);
                        clearTouchTarget();
                        return true;
                    }
                    if (this.f50649v) {
                        m0(this.f50590b0, motionEvent);
                    } else {
                        m0(null, motionEvent);
                    }
                    clearTouchTarget();
                    return false;
                }
                if (!p.a(motionEvent.getRawX(), motionEvent.getRawY(), this.f50605g0, this.f50608h0)) {
                    m0(null, motionEvent);
                }
                clearTouchTarget();
                return true;
            }
            this.f50663z1.setPressed(false);
            this.f50663z1.setLongClickTrig(false);
            handler.removeMessages(0);
            clearTouchTarget();
        }
        return false;
    }

    public void postInvalidate() {
        View attachedView;
        TextLayoutBase textLayoutBase = this.f50663z1;
        if (textLayoutBase == null || (attachedView = textLayoutBase.getAttachedView()) == null) {
            return;
        }
        attachedView.postInvalidate();
    }

    public void postInvalidateDelayed(long j3) {
        View attachedView;
        TextLayoutBase textLayoutBase = this.f50663z1;
        if (textLayoutBase == null || (attachedView = textLayoutBase.getAttachedView()) == null) {
            return;
        }
        attachedView.postInvalidateDelayed(j3);
    }

    public void postInvalidateOnAnimation() {
        View attachedView;
        TextLayoutBase textLayoutBase = this.f50663z1;
        if (textLayoutBase == null || (attachedView = textLayoutBase.getAttachedView()) == null) {
            return;
        }
        attachedView.postInvalidateDelayed(16L);
    }

    public void postInvalidateOnFadeAnimation() {
        View attachedView;
        TextLayoutBase textLayoutBase = this.f50663z1;
        if (textLayoutBase == null || (attachedView = textLayoutBase.getAttachedView()) == null) {
            return;
        }
        attachedView.postInvalidateDelayed(16L);
    }

    public int preMeasuewLine(int i3) {
        i0(i3);
        ArrayList<g> arrayList = this.G;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap q() {
        int i3;
        int i16;
        int i17;
        int i18;
        if (this.f50618k1 != null && this.f50621l1 != null) {
            if (W()) {
                i17 = this.f50621l1.g();
                i18 = this.f50621l1.f();
            } else {
                Rect margins = this.f50618k1.getMargins();
                if (margins != null) {
                    i3 = margins.left + margins.right;
                    i16 = margins.top + margins.bottom;
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                i17 = this.M + i3;
                i18 = this.N + i16;
            }
            Bitmap G = G();
            try {
                int textSize = ((int) getTextSize()) * 4;
                if (i18 < textSize) {
                    i18 = textSize;
                }
                if (G != null && (G.getHeight() < i18 || G.getWidth() < i17 || G.getHeight() > textSize + i18)) {
                    com.qzone.proxy.feedcomponent.util.l.a().b().remove(Integer.valueOf(M()));
                    G.recycle();
                    G = null;
                }
                if (G == null) {
                    G = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
                }
                G.eraseColor(0);
                com.qzone.proxy.feedcomponent.util.l.a().b().put(Integer.valueOf(M()), G);
                if (this.f50639r1 == null) {
                    this.f50639r1 = new j(M());
                }
                return G;
            } catch (Throwable th5) {
                QZLog.e("TextCellLayout", "allocCacheBitmap2XuanDong OutOfMemoryError.errMsg = " + th5.getMessage());
            }
        }
        return null;
    }

    public void recycleTextRes() {
        if (!this.f50603f1) {
            resetXuanDongAnimation();
        }
        if (this.W1 != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.W1);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.W1);
        }
    }

    public void resetDefaultFont() {
        Paint paint = this.C;
        if (paint instanceof com.qzone.proxy.feedcomponent.text.d) {
            this.C = ((com.qzone.proxy.feedcomponent.text.d) paint).e();
        }
        if (this.P0 == null) {
            this.P0 = TextHook.getInstance().getSystemDefaultFont();
        }
        this.N0 = 0;
        this.O0 = this.P0;
    }

    public void resetSideDrawables() {
        ArrayList<k> arrayList = this.f50648u1;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<k> arrayList2 = this.f50651v1;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        requestLayout();
    }

    public void resetXuanDongAnimation() {
        if (b0()) {
            com.qzone.proxy.feedcomponent.text.c cVar = this.f50615j1;
            if (cVar != null) {
                cVar.f();
                this.f50615j1.e();
            }
            this.f50603f1 = false;
            this.f50606g1 = false;
            if (Q()) {
                this.f50618k1.gotoLastFrame();
            }
        }
    }

    public void restartAnimation() {
        int i3;
        com.qzone.proxy.feedcomponent.text.l lVar = this.M0;
        if (lVar != null && (!lVar.hasStarted() || this.M0.hasEnded())) {
            this.M0.start();
            postInvalidate();
        }
        TranslateAnimation translateAnimation = this.V1;
        if (translateAnimation != null && (!translateAnimation.hasStarted() || this.V1.hasEnded())) {
            this.V1.start();
            postInvalidate();
        }
        if (this.W1 != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.W1);
            postInvalidate();
        } else {
            if (TextUtils.isEmpty(this.Q1) || (i3 = this.R1) <= 0) {
                return;
            }
            this.W1 = T(this.Q1, i3);
        }
    }

    protected void s0(float f16) {
        this.C.setTextSize(f16);
        r0(f16);
    }

    public void setAdditionEllipsizeWidth(int i3) {
        this.f50642s1 = i3;
    }

    public void setCellClickable(boolean z16) {
        this.f50620l0 = z16;
    }

    public void setClickable(boolean z16) {
        this.f50611i0 = z16;
    }

    public void setColorBackground(int i3) {
        this.X = i3;
    }

    public void setDrawBackground(boolean z16) {
        this.W = z16;
    }

    public void setDrawablePadding(int i3) {
        this.f50657x1 = i3;
    }

    public void setEllipsisStr(String str) {
        if (str == null) {
            return;
        }
        this.f50650v0 = str;
        this.f50653w0 = new TextCell(0, str);
    }

    public void setFadeAnimation(boolean z16) {
        boolean z17 = this.K0;
        if (z17 == z16) {
            return;
        }
        if (z16) {
            if (this.J0 != 0) {
                this.I0 = System.currentTimeMillis() - (this.J0 - this.I0);
            } else {
                this.I0 = System.currentTimeMillis();
            }
            this.J0 = 0L;
        } else if (z17) {
            this.J0 = System.currentTimeMillis();
        }
        this.K0 = z16;
    }

    public void setFadeAnimationProgress(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        this.J0 = currentTimeMillis;
        this.I0 = currentTimeMillis - i3;
    }

    public void setFakeFeed(boolean z16) {
        this.f50585a = z16;
    }

    public void setFont(int i3, String str, int i16) {
        setFont(i3, str, i16, null);
    }

    public void setFontBgVisible(boolean z16) {
        this.f50604g = z16;
    }

    public void setFullTypeFont(final int i3, String str, final int i16, String str2) {
        if (TextUtils.isEmpty(str)) {
            Paint paint = this.C;
            if (paint instanceof com.qzone.proxy.feedcomponent.text.d) {
                this.C = ((com.qzone.proxy.feedcomponent.text.d) paint).e();
            }
            this.N0 = 0;
            this.O0 = this.P0;
            return;
        }
        Paint paint2 = this.C;
        if ((paint2 instanceof com.qzone.proxy.feedcomponent.text.d) && str.equals(((com.qzone.proxy.feedcomponent.text.d) paint2).g())) {
            return;
        }
        this.N0 = i3;
        if (this.f50588a2 == null) {
            this.f50588a2 = new FontInterface.FullTypeResult() { // from class: com.qzone.proxy.feedcomponent.text.TextCellLayout.8
                @Override // cooperation.qzone.font.FontInterface.FullTypeResult, cooperation.qzone.font.FontInterface.FontResult
                public void result(int i17, final String str3, String str4) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.TextCellLayout.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            TextCellLayout.this.V(i3, str3, i16);
                        }
                    });
                }
            };
        }
        String fullTypeFont = ((IFontManager) QRoute.api(IFontManager.class)).getFullTypeFont(i3, str, null, this.f50588a2);
        if (!TextUtils.isEmpty(fullTypeFont)) {
            V(i3, fullTypeFont, i16);
        }
        if (TextUtils.isEmpty(str2) || W() || !b0()) {
            return;
        }
        this.G0 = str2;
    }

    public void setHasMore(boolean z16) {
        this.f50632p0 = z16;
    }

    public void setIsNeedLineSpace(Boolean bool) {
        this.f50591b1 = bool;
    }

    public void setIsSpan(boolean z16) {
        this.Z0 = z16;
    }

    public void setLetterSpacing(float f16) {
        this.f50619l = f16;
        getPaint().setLetterSpacing(this.f50619l);
    }

    public void setLineBreakInContent(boolean z16) {
        this.f50626n0 = z16;
    }

    public void setLineBreakNeeded(boolean z16) {
        this.f50623m0 = z16;
    }

    public void setLineSpace(int i3) {
        this.f50613j = i3;
    }

    public void setLongclickable(boolean z16) {
        this.f50614j0 = z16;
    }

    public void setMaxCommentLine(int i3) {
        setMaxCommentLine(i3, false);
    }

    public void setMaxLine(int i3) {
        this.f50625n = i3;
    }

    public void setMaxWidth(int i3) {
        this.B = i3;
    }

    public void setMeasuredLineLinkColor(int i3) {
        ArrayList<g> arrayList = this.G;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                g gVar = this.G.get(i16);
                int h16 = gVar.h();
                for (int i17 = 0; i17 < h16; i17++) {
                    TextCell d16 = gVar.d(i17);
                    if (d16 instanceof ColorTextCell) {
                        ((ColorTextCell) d16).setTextColor(i3);
                    }
                }
            }
        }
    }

    public void setMeasuredTextCacheEnabled(boolean z16) {
        this.K = z16;
    }

    public void setMinLine(int i3) {
        this.f50622m = i3;
    }

    public void setMoreCellColor(int i3) {
        this.f50656x0 = i3;
        this.f50659y0.textColor = i3;
    }

    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
        this.f50617k0 = onCellClickListener;
    }

    public void setOnTextOperateListener(CellTextView.OnTextOperater onTextOperater) {
        this.A1 = onTextOperater;
    }

    public void setOuterListener(com.qzone.proxy.feedcomponent.text.font.a aVar) {
        this.I1 = aVar;
    }

    public void setPadding(int i3, int i16, int i17, int i18) {
        this.C0 = i3;
        this.D0 = i16;
        this.E0 = i17;
        this.F0 = i18;
    }

    public void setShadowLayer(int i3, int i16, int i17, int i18) {
        this.V0 = i3;
        this.W0 = i16;
        this.X0 = i17;
        this.Y0 = i18;
    }

    public void setShowMore(boolean z16) {
        this.f50629o0 = z16;
    }

    public TextCellLayout setShowMoreTextColor(int i3) {
        this.f50601f = i3;
        return this;
    }

    public TextCellLayout setShowMoreTextSize(float f16) {
        this.f50595d = f16;
        return this;
    }

    public TextCellLayout setShowMoreTextUnClickable(boolean z16) {
        this.f50598e = z16;
        return this;
    }

    public void setShowPackOrUnpack(boolean z16) {
        this.f50652w = z16;
    }

    public void setSummaryMaxPack(int i3) {
        this.f50631p = i3;
    }

    public void setSummaryMinPack(int i3) {
        this.f50634q = i3;
    }

    public void setSummaryPackOrUnpackDirect(int i3) {
        this.f50628o = i3;
    }

    public void setSummaryPackShowLine(int i3) {
        this.f50637r = i3;
    }

    public void setText(int i3) {
        setText(BaseApplication.getContext().getResources().getString(i3));
    }

    public void setTextBold(boolean z16) {
        this.C.setFakeBoldText(z16);
    }

    public void setTextColor(int i3) {
        this.S = i3;
        this.T = i3;
        this.f50630o1 = true;
    }

    public void setTextColorAnimation(int i3, int i16, int i17) {
        ArrayList<Integer> arrayList = new ArrayList<>(2);
        arrayList.add(Integer.valueOf(i3));
        arrayList.add(Integer.valueOf(i16));
        setTextColorAnimation(arrayList, i17);
    }

    public void setTextColorLink(int i3) {
        this.U = i3;
    }

    public void setTextColorLinkBackground(int i3) {
        this.V = i3;
    }

    public void setTextGravity(int i3) {
        this.f50635q0 = i3;
    }

    public void setTextSize(float f16) {
        this.f50592c = f16;
        s0(f16);
        requestLayout();
    }

    public void setTextSizeType(int i3) {
        this.D = i3;
        requestLayout();
    }

    public void setTrueTypeFont(int i3, String str) {
        Paint paint = this.C;
        if (paint instanceof com.qzone.proxy.feedcomponent.text.d) {
            this.C = ((com.qzone.proxy.feedcomponent.text.d) paint).e();
        }
        if (TextUtils.isEmpty(str)) {
            this.N0 = 0;
            this.O0 = this.P0;
        } else {
            if (this.N0 == i3) {
                return;
            }
            this.N0 = i3;
            if (this.Z1 == null) {
                this.Z1 = new com.qzone.proxy.feedcomponent.text.font.c(this, i3);
            }
            Typeface g16 = QzoneFontManager.f().g(i3, str, this.Z1);
            if (g16 != null) {
                this.O0 = g16;
            }
        }
    }

    public void setUseSoftLineBreak(boolean z16) {
        this.f50638r0 = z16;
    }

    public void startXuanDongAnimation() {
        if (b0() && !this.f50603f1 && isShown()) {
            com.qzone.proxy.feedcomponent.text.c cVar = this.f50615j1;
            if (cVar != null && this.f50618k1 != null) {
                cVar.f();
                this.f50615j1.e();
                if (!this.f50603f1 && !this.f50606g1 && !isScroll()) {
                    this.f50603f1 = true;
                }
                if (this.f50603f1) {
                    this.f50615j1.h();
                    return;
                }
                return;
            }
            this.f50603f1 = false;
        }
    }

    public void stopAnimation() {
        com.qzone.proxy.feedcomponent.text.l lVar = this.M0;
        if (lVar != null) {
            lVar.cancel();
        }
        TranslateAnimation translateAnimation = this.V1;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        if (this.W1 != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.W1);
        }
    }

    public void stopFadeAnimation() {
        long currentTimeMillis = System.currentTimeMillis();
        this.J0 = currentTimeMillis;
        this.I0 = currentTimeMillis;
    }

    public TextCellLayout(TextLayoutBase textLayoutBase, Paint paint) {
        this.f50585a = false;
        this.f50604g = true;
        this.f50607h = 0;
        this.f50610i = 0;
        this.f50613j = ViewUtils.dip2px(2.0f);
        this.f50616k = 1048576;
        this.f50619l = 0.0f;
        this.f50622m = -1;
        this.f50625n = -1;
        this.f50628o = 0;
        this.f50631p = 0;
        this.f50634q = 0;
        this.f50637r = 0;
        this.f50640s = "\u6536\u8d77";
        this.f50643t = "\u5c55\u5f00";
        this.f50646u = "\u67e5\u770b\u5168\u6587";
        this.f50649v = QZoneConfigHelper.Q0();
        this.f50652w = false;
        this.f50655x = 0;
        this.f50658y = 0;
        this.f50661z = 0;
        this.A = false;
        this.B = -1;
        this.F = false;
        this.G = new ArrayList<>();
        this.H = new ArrayList<>();
        this.I = true;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.P = 0;
        this.Q = 0;
        this.R = -1;
        this.S = -16777216;
        this.T = -16777216;
        this.U = BaseApplication.getContext().getResources().getColor(R.color.qzone_skin_feed_text_link_color);
        this.V = -2763307;
        this.W = true;
        this.X = -1710619;
        this.Y = null;
        this.Z = null;
        this.f50586a0 = new RectF();
        this.f50596d0 = new ArrayList<>();
        this.f50599e0 = -1.0f;
        this.f50602f0 = -1.0f;
        this.f50605g0 = -1.0f;
        this.f50608h0 = -1.0f;
        this.f50611i0 = true;
        this.f50614j0 = true;
        this.f50620l0 = true;
        this.f50623m0 = true;
        this.f50626n0 = true;
        this.f50629o0 = false;
        this.f50632p0 = false;
        this.f50635q0 = 16;
        this.f50638r0 = true;
        this.f50641s0 = new float[26];
        this.f50650v0 = MiniBoxNoticeInfo.APPNAME_SUFFIX;
        this.f50653w0 = new TextCell(0, this.f50650v0);
        this.f50656x0 = RichStatus.ACTION_COLOR_NORMAL;
        this.f50659y0 = new ColorTextCell(10, com.qzone.util.l.a(R.string.u2x), this.f50656x0);
        this.C0 = 0;
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = 0;
        this.I0 = 0L;
        this.J0 = 0L;
        this.K0 = false;
        this.M0 = null;
        this.Z0 = false;
        this.f50587a1 = null;
        this.f50591b1 = Boolean.TRUE;
        this.f50594c1 = 0;
        this.f50597d1 = 0;
        this.f50600e1 = 0;
        this.f50603f1 = false;
        this.f50606g1 = false;
        this.f50609h1 = 0;
        this.f50612i1 = null;
        this.f50624m1 = -1;
        this.f50627n1 = -1;
        this.f50630o1 = true;
        this.f50633p1 = true;
        this.f50636q1 = null;
        this.f50639r1 = null;
        this.f50642s1 = 0;
        this.f50645t1 = false;
        this.f50654w1 = 0;
        this.f50657x1 = ViewUtils.dip2px(5.0f);
        this.f50660y1 = false;
        this.A1 = new b();
        this.B1 = 0;
        this.C1 = null;
        this.D1 = new Transformation();
        this.E1 = new Transformation();
        this.F1 = new c();
        this.G1 = -1;
        this.H1 = -1;
        this.I1 = null;
        this.J1 = false;
        this.K1 = false;
        this.N1 = 0L;
        this.O1 = 0;
        this.P1 = -1;
        this.Q1 = null;
        this.R1 = -1;
        this.S1 = true;
        this.W1 = null;
        this.Y1 = true;
        this.C = paint == null ? new Paint(1) : paint;
        this.f50663z1 = textLayoutBase;
    }

    private void m(int i3) {
        n(i3, false);
    }

    private g o(int i3) {
        this.f50607h = 0;
        int size = this.G.size();
        if (size > 0) {
            i3 = this.H.get(size - 1).intValue();
        }
        this.f50610i += this.f50613j + i3;
        g gVar = new g();
        this.G.add(gVar);
        this.H.add(0);
        return gVar;
    }

    public void clearTouchTarget() {
        this.F = false;
        this.f50663z1.setPressed(false);
        this.f50663z1.postInvalidate();
        if (this.f50590b0 == null) {
            return;
        }
        Iterator<TextCell> it = this.f50596d0.iterator();
        while (it.hasNext()) {
            it.next().isPresseding = false;
        }
        this.f50596d0.clear();
        this.f50590b0 = null;
        this.f50599e0 = -1.0f;
        this.f50602f0 = -1.0f;
        this.f50605g0 = -1.0f;
        this.f50608h0 = -1.0f;
    }

    public void forceRequestLayout() {
        this.J = true;
        requestLayout();
    }

    public void requestLayout() {
        this.I = true;
        this.f50630o1 = true;
    }

    public void setBarrageEffect(boolean z16, QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        if (!z16) {
            this.J1 = false;
            this.L1 = null;
            this.T1 = 0;
            this.V1 = null;
            this.W1 = null;
            this.P1 = -1;
            this.R1 = -1;
            this.Q1 = null;
            return;
        }
        this.J1 = true;
        int i3 = barrageEffectInfo.type;
        this.O1 = i3;
        if (i3 == 0) {
            str3 = barrageEffectInfo.strAndBgUrl;
            this.T1 = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(barrageEffectInfo.strTextColor);
            this.R1 = barrageEffectInfo.iFrameRate;
            this.Q1 = barrageEffectInfo.strFrameZip;
            this.P1 = Integer.valueOf(barrageEffectInfo.f51896id);
            if (this.R1 > 0 && !TextUtils.isEmpty(this.Q1)) {
                if (this.W1 != null) {
                    ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.W1);
                    ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.W1);
                }
                this.W1 = T(this.Q1, this.R1);
            }
        } else {
            if (i3 == 1) {
                BubbleSource bubbleSource = barrageEffectInfo.stSource;
                str = bubbleSource.strAndUrl1;
                str2 = bubbleSource.strAndUrl2;
                this.T1 = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(bubbleSource.strTextColor1);
                this.U1 = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(barrageEffectInfo.stSource.strTextColor2);
                this.W1 = null;
                this.Q1 = null;
            } else if (i3 == 2) {
                BubbleSource bubbleSource2 = barrageEffectInfo.stSource;
                str = bubbleSource2.strAndUrl1;
                str2 = bubbleSource2.strAndUrl2;
                this.T1 = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(bubbleSource2.strTextColor1);
                this.U1 = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(barrageEffectInfo.stSource.strTextColor2);
                this.W1 = null;
                this.Q1 = null;
            } else {
                this.J1 = false;
                this.L1 = null;
                this.T1 = 0;
                this.V1 = null;
                this.W1 = null;
                this.P1 = -1;
                this.R1 = -1;
                this.Q1 = null;
                return;
            }
            str3 = str;
            str4 = str2;
        }
        final FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(str3).l(VasDynamicDrawableCache.INSTANCE).a();
        a16.c0(new Function1() { // from class: com.qzone.proxy.feedcomponent.text.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e06;
                e06 = TextCellLayout.this.e0(a16, (com.tencent.cachedrawable.dynamicdrawable.d) obj);
                return e06;
            }
        });
        if (str4 != null) {
            com.qzone.util.image.c.L(str4, true, new f());
        }
    }

    public void setFont(int i3, String str, int i16, String str2) {
        if (FontManager.isFontEnable(i16)) {
            this.f50600e1 = i16;
            if (i16 == 1 || i16 == 2) {
                setTrueTypeFont(i3, str);
                return;
            }
            if (i16 != 3 && i16 != 4) {
                resetDefaultFont();
                return;
            }
            setFullTypeFont(i3, str, i16, str2);
            if (W() || TextUtils.isEmpty(str2)) {
                return;
            }
            setPadding(39, 39, 39, 39);
        }
    }

    public void setGradientColor(int[] iArr, float[] fArr, GradientDrawable.Orientation orientation) {
        this.Q0 = null;
        this.R0 = iArr;
        this.S0 = fArr;
        this.T0 = orientation;
    }

    public void setMaxCommentLine(int i3, boolean z16) {
        this.f50655x = i3;
        this.A = z16;
        requestLayout();
    }

    public void setText(String str) {
        ArrayList<TextCell> arrayList = new ArrayList<>();
        this.E = arrayList;
        arrayList.add(new TextCell(0, str));
        requestLayout();
    }

    public void setTextColorLink(ColorStateList colorStateList) {
        this.Z = colorStateList;
    }

    private int F(String str, int i3) {
        while (i3 >= 0) {
            char charAt = str.charAt(i3);
            if (charAt == ' ' || !X(charAt)) {
                do {
                    i3--;
                    if (i3 < 0) {
                        break;
                    }
                } while (str.charAt(i3) == ' ');
                return i3 + 2;
            }
            i3--;
        }
        return 0;
    }

    public static String getPlainText(ArrayList<TextCell> arrayList) {
        if (arrayList == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<TextCell> it = arrayList.iterator();
        while (it.hasNext()) {
            String text = it.next().getText();
            if (text != null) {
                sb5.append(text);
            }
        }
        return sb5.toString();
    }

    private TextCell k(TextCell textCell, int i3, g gVar, float f16, int i16) {
        String str;
        if (i3 == 0 && this.f50607h != 0) {
            return textCell;
        }
        TextCell copy = textCell.copy();
        if (textCell.canBreak()) {
            int length = textCell.getLength();
            if (i3 > length) {
                i3 = length;
            }
            copy.text = textCell.getText().substring(0, i3);
            if (f16 <= 0.0f) {
                f16 = I(copy);
            }
        }
        if (i3 == 0 && this.f50607h == 0) {
            l(gVar, copy, f16);
            return null;
        }
        if (!textCell.canBreak() && f16 > i16 && this.f50607h != 0) {
            return textCell;
        }
        if (i3 >= textCell.getLength()) {
            l(gVar, copy, f16);
            return null;
        }
        boolean z16 = textCell instanceof DynamicImageCell;
        if (!z16 && (!this.J1 || !(textCell instanceof UserNameCell))) {
            l(gVar, copy, f16);
            TextCell copy2 = textCell.copy();
            copy2.text = textCell.text.substring(i3);
            return copy2;
        }
        if (copy.text.length() > 3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(copy.text.substring(0, copy.getLength() - 1));
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            if (z16) {
                str = "";
            } else {
                str = ":";
            }
            sb5.append(str);
            copy.text = sb5.toString();
        }
        float I = I(copy);
        if (z16) {
            I += ((DynamicImageCell) textCell).getDrawableWidth();
        }
        l(gVar, copy, I);
        return null;
    }

    private void m0(TextCell textCell, MotionEvent motionEvent) {
        if (textCell != null) {
            textCell.lastClickEvent = motionEvent;
            textCell.commentSpanHeight = this.f50658y;
            textCell.maxCommentHeight = this.f50661z;
        }
        if (textCell != null && textCell.type == 18) {
            if (this.A0 == null) {
                InnerOperateTextCell innerOperateTextCell = new InnerOperateTextCell(18, this.f50643t);
                this.A0 = innerOperateTextCell;
                innerOperateTextCell.setCanCopy(false);
                InnerOperateTextCell innerOperateTextCell2 = this.A0;
                innerOperateTextCell2.useDefaultFont = true;
                innerOperateTextCell2.setFontSize(this.C, this.f50592c);
            }
            this.A0.setDefaultShadowLayer(this.V0, this.W0, this.X0, this.Y0);
            this.A0.setLinkColor(this.U);
            if (!this.Z0) {
                this.A0.setText(this.f50640s);
                this.Z0 = true;
            } else {
                this.A0.setText(this.f50643t);
                this.Z0 = false;
            }
            forceRequestLayout();
            this.f50663z1.requestLayout();
        } else if (textCell != null && textCell.type == 10 && this.A) {
            forceRequestLayout();
            setMaxCommentLine(0);
            this.f50663z1.invalidate();
            this.f50663z1.requestLayout();
        }
        this.f50663z1.performCellClick(textCell);
    }

    private int o0(String str, int i3) {
        int i16 = i3 - 1;
        if (J(str, i16) == '\n') {
            return i3;
        }
        char J = J(str, i16 + 1);
        if (isChinesePunctuation(J) || isEnglishPunctuation(J)) {
            i3 = E(str, i16);
            i16 = i3 - 1;
        }
        if (X(J(str, i16)) && X(J(str, i16 + 1))) {
            return F(str, i16);
        }
        int i17 = i16 + 1;
        return (J(str, i17) == ' ' || J(str, i17) == '\n') ? i3 + 1 : i3;
    }

    public static void setJumpCmtId(String str) {
        if (str == null) {
            str = "";
        }
        f50578m2 = str;
    }

    public static void setJumpRepId(String str) {
        if (str == null) {
            str = "";
        }
        f50579n2 = str;
        f50581p2 = null;
    }

    private void w(Canvas canvas) {
        if (canvas == null || this.H0 == null || !a0().booleanValue()) {
            return;
        }
        Bitmap G = G();
        int i3 = this.C0 + this.M + this.E0;
        int i16 = this.N;
        if (this.A0 != null || this.f50662z0 != null) {
            i16 -= this.H.get(r3.size() - 1).intValue();
        }
        if (G != null) {
            i3 = this.C0 + this.E0 + G.getWidth();
        }
        this.H0.setBounds(new Rect(0, 0, i3, i16));
        if (this.f50604g) {
            this.H0.setAlpha(255);
        } else {
            this.H0.setAlpha(0);
        }
        this.H0.draw(canvas);
    }

    public void setEllipsisStr(String str, int i3, float f16) {
        if (str == null) {
            return;
        }
        this.f50650v0 = str;
        this.f50653w0 = new ColorTextCell(20, str, i3);
        float textSize = this.C.getTextSize();
        this.C.setTextSize(f16);
        this.f50653w0.setFontSize(this.C, f16);
        this.C.setTextSize(textSize);
        this.f50653w0.useSuperFont = false;
    }

    public void setNinePatchBackground(int i3) {
        if (i3 != 0) {
            this.f50587a1 = BaseApplication.getContext().getResources().getDrawable(i3);
        } else {
            this.f50587a1 = null;
        }
    }

    public void setTypefaceFromAttrs(String str, int i3, int i16) {
        Typeface typeface;
        if (str != null) {
            typeface = Typeface.create(str, i16);
            if (typeface != null) {
                t0(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        if (i3 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i3 == 2) {
            typeface = Typeface.SERIF;
        } else if (i3 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        if (typeface == Typeface.DEFAULT || typeface == null) {
            typeface = TextHook.getInstance().getSystemDefaultFont();
        }
        setTypeface(typeface, i16);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<TextCell> f50677a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<Rect> f50678b;

        /* renamed from: c, reason: collision with root package name */
        private int f50679c;

        /* renamed from: d, reason: collision with root package name */
        private int f50680d;

        private void i() {
            if (this.f50677a == null) {
                this.f50677a = new ArrayList<>(1);
            }
            if (this.f50678b == null) {
                this.f50678b = new ArrayList<>(1);
            }
        }

        public void c(TextCell textCell, Rect rect) {
            i();
            this.f50677a.add(textCell);
            this.f50678b.add(rect);
            if (rect != null) {
                this.f50679c += rect.width();
            }
        }

        public int e() {
            return this.f50680d;
        }

        public int f() {
            return this.f50679c;
        }

        public int h() {
            ArrayList<TextCell> arrayList = this.f50677a;
            if (arrayList == null || this.f50678b == null) {
                return 0;
            }
            int size = arrayList.size();
            int size2 = this.f50678b.size();
            return size < size2 ? size : size2;
        }

        public void j(int i3) {
            int size;
            ArrayList<TextCell> arrayList = this.f50677a;
            if (arrayList != null && i3 < (size = arrayList.size())) {
                for (int i16 = 0; i16 < size - i3; i16++) {
                    int i17 = (size - i16) - 1;
                    this.f50677a.remove(i17);
                    Rect remove = this.f50678b.remove(i17);
                    if (remove != null) {
                        this.f50679c -= remove.width();
                    }
                }
            }
        }

        public void k(int i3) {
            this.f50680d = i3;
        }

        public TextCell d(int i3) {
            ArrayList<TextCell> arrayList;
            if (i3 >= 0 && (arrayList = this.f50677a) != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        public Rect g(int i3) {
            ArrayList<Rect> arrayList;
            if (i3 >= 0 && (arrayList = this.f50678b) != null) {
                return arrayList.get(i3);
            }
            return null;
        }
    }

    private int E(String str, int i3) {
        for (int i16 = i3; i16 >= 0; i16--) {
            char charAt = str.charAt(i16);
            if (!isEnglishPunctuation(charAt) && !isChinesePunctuation(charAt) && charAt != ' ') {
                return i16;
            }
        }
        return i3 + 1;
    }

    private int N(ArrayList<k> arrayList) {
        int i3 = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<k> it = arrayList.iterator();
            while (it.hasNext()) {
                i3 += it.next().f50685c.width() + this.f50657x1;
            }
        }
        return i3;
    }

    private boolean R(ArrayList<k> arrayList, int i3) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<k> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f50684b == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean g0(int i3) {
        g gVar;
        int i16;
        int h16;
        int i17;
        TextCell d16;
        this.f50616k = 0;
        this.L = 0;
        this.G.clear();
        this.H.clear();
        g gVar2 = new g();
        this.G.add(gVar2);
        for (int i18 = 0; i18 < this.E.size(); i18++) {
            TextCell textCell = this.E.get(i18);
            textCell.text = com.qzone.util.g.a(textCell.text);
            int H = H(textCell);
            if (this.H.isEmpty()) {
                this.H.add(0);
            }
            if (textCell.isEmo()) {
                EmoObjectPool.f().o((EmoCell) textCell, this.f50663z1, this.I1);
            }
            if (textCell.cellIndex == 0) {
                this.f50616k += 1048576;
            }
            TextCell textCell2 = textCell;
            while (!TextUtils.isEmpty(textCell2.getText())) {
                textCell2.linebreakSeq = this.f50616k;
                if ((this.f50628o != 0 && this.G.size() > this.f50631p) || (this.f50628o == 0 && this.f50625n > 0 && this.G.size() > this.f50625n)) {
                    int size = this.H.size() - 1;
                    this.H.set(size, Integer.valueOf(this.H.get(size).intValue() - this.f50613j));
                    return false;
                }
                int i19 = i3 - this.f50607h;
                if (textCell2 instanceof DynamicImageCell) {
                    i19 -= ((DynamicImageCell) textCell2).getDrawableWidth();
                }
                if ((textCell2 instanceof UserNameCell) && this.J1) {
                    i19 -= f50577l2 + f50572g2;
                }
                int i26 = i19;
                com.qzone.proxy.feedcomponent.text.g<Integer, Float> r16 = r(textCell2, i26);
                int intValue = r16.f50743a.intValue();
                float floatValue = r16.f50744b.floatValue();
                if (this.f50638r0) {
                    int o06 = o0(textCell2.getText(), intValue);
                    if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONE_TEXTCELL_SETTING, QzoneConfig.SECONDARY_EMOJI_SHOULD_NOT_BREAK, 0) == 0 && this.f50607h != 0 && (h16 = gVar2.h()) > 1) {
                        char J = J(textCell2.getText(), o06);
                        String text = textCell2.getText();
                        if (!(!TextUtils.isEmpty(text) && text.startsWith("\n")) && ((isChinesePunctuation(J) || isEnglishPunctuation(J)) && (d16 = gVar2.d(h16 - 1)) != null && (d16.isEmo() || (d16 instanceof SystemEmoCell)))) {
                            gVar2.j(i17);
                            g o16 = o(H);
                            com.qzone.proxy.feedcomponent.text.g<Integer, Float> r17 = r(d16, i26);
                            k(d16, r17.f50743a.intValue(), o16, r17.f50744b.floatValue(), i26);
                            i26 = i3 - this.f50607h;
                            com.qzone.proxy.feedcomponent.text.g<Integer, Float> r18 = r(textCell2, i26);
                            int intValue2 = r18.f50743a.intValue();
                            float floatValue2 = r18.f50744b.floatValue();
                            intValue = o0(textCell2.getText(), intValue2);
                            i16 = intValue2;
                            floatValue = floatValue2;
                            gVar2 = o16;
                            if (this.f50607h == 0 && intValue == 0 && !(f50568c2 && this.J1)) {
                                gVar = gVar2;
                                i16 = 0;
                            } else {
                                gVar = gVar2;
                            }
                        }
                    }
                    i16 = intValue;
                    intValue = o06;
                    if (this.f50607h == 0) {
                    }
                    gVar = gVar2;
                } else {
                    gVar = gVar2;
                    i16 = intValue;
                }
                boolean z16 = (intValue == 0 || intValue == i16) ? false : true;
                if (!z16) {
                    intValue = i16;
                }
                textCell2 = k(textCell2, intValue, gVar, z16 ? 0.0f : floatValue, i26);
                if (textCell2 != null && !TextUtils.isEmpty(textCell2.getText())) {
                    gVar2 = o(H);
                } else {
                    gVar2 = (textCell2 == null && J(textCell.getText(), textCell.getLength() - 1) == '\n') ? o(H) : gVar;
                }
            }
        }
        return true;
    }

    public static void setCanCopy(ArrayList<TextCell> arrayList, boolean z16) {
        if (arrayList == null) {
            return;
        }
        Iterator<TextCell> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setCanCopy(z16);
        }
    }

    public void addLeftDrawable(Drawable drawable, int i3) {
        if (drawable == null || R(this.f50648u1, i3)) {
            return;
        }
        if (this.f50648u1 == null) {
            this.f50648u1 = new ArrayList<>();
        }
        this.f50648u1.add(new k(drawable, i3));
        this.f50654w1 = Math.max(this.f50654w1, drawable.getBounds().height());
        requestLayout();
    }

    public void addRightDrawable(Drawable drawable, int i3) {
        if (drawable == null || R(this.f50651v1, i3)) {
            return;
        }
        if (this.f50651v1 == null) {
            this.f50651v1 = new ArrayList<>();
        }
        this.f50651v1.add(new k(drawable, i3));
        this.f50654w1 = Math.max(this.f50654w1, drawable.getBounds().height());
        requestLayout();
    }

    public Rect getCellPosition(TextCell textCell) {
        Rect rect = null;
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            for (int i16 = 0; i16 < this.G.get(i3).f50677a.size(); i16++) {
                if (textCell.equals(this.G.get(i3).f50677a.get(i16))) {
                    rect = this.G.get(i3).g(i16);
                }
            }
        }
        return rect;
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.Y = colorStateList;
    }

    private char J(String str, int i3) {
        if (i3 < 0 || str == null || i3 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i3);
    }

    private boolean Y(float f16, float f17, Rect rect) {
        if (rect == null) {
            return false;
        }
        int i3 = rect.top;
        int i16 = rect.bottom;
        int i17 = rect.left;
        int i18 = rect.right;
        if (this.J1) {
            i16 = this.O;
            i3 = 0;
        }
        float f18 = this.B0 * 4.0f;
        return f16 >= ((float) i17) - f18 && f16 <= ((float) i18) + f18 && f17 >= ((float) i3) - f18 && f17 <= ((float) i16) + f18;
    }

    private boolean Z(float f16, float f17, Rect rect, TextCell textCell) {
        if (rect == null) {
            return false;
        }
        boolean z16 = textCell instanceof ComboNetImageCell;
        int i3 = rect.top;
        int i16 = rect.bottom;
        int i17 = rect.left;
        int i18 = rect.right;
        if (this.J1 && !z16) {
            i16 = this.O;
            if (TextUtils.isEmpty(textCell.getUrl()) && !(textCell instanceof UserNameCell)) {
                return false;
            }
            i3 = 0;
        }
        if (z16) {
            return f16 >= ((float) i17) && f16 <= ((float) i18);
        }
        float f18 = this.B0 * 4.0f;
        return f16 >= ((float) i17) - f18 && f16 <= ((float) i18) + f18 && f17 >= ((float) i3) - f18 && f17 <= ((float) i16) + f18;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0157, code lost:
    
        r17.f50607h += (int) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0164, code lost:
    
        if (r17.G.size() != 2) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0172, code lost:
    
        if (r17.G.get(1).d(0) != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0174, code lost:
    
        r17.L = r17.f50607h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0178, code lost:
    
        if (r7 != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0180, code lost:
    
        if (com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo.APPNAME_SUFFIX.equals(r17.f50650v0) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0182, code lost:
    
        r5 = r2.d(r2.h() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x018b, code lost:
    
        if (r5 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0191, code lost:
    
        if (r5.canBreak() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0193, code lost:
    
        r5.text += r17.f50650v0;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01b4, code lost:
    
        r5 = new android.graphics.Rect(r2.g(r2.h() - 1));
        r8 = r5.right;
        r5.left = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01c6, code lost:
    
        if (r19 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01c8, code lost:
    
        r8 = (int) (r8 + I(r17.f50653w0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01d4, code lost:
    
        r5.right = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01d6, code lost:
    
        if (r7 != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01d8, code lost:
    
        r7 = r2.d(r2.h() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01e5, code lost:
    
        if (r7.canBreak() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01ed, code lost:
    
        if (r7.text.endsWith("\n") == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01ef, code lost:
    
        r8 = r7.text;
        r7.text = r8.substring(0, r8.length() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01fc, code lost:
    
        r2.c(r17.f50653w0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0201, code lost:
    
        if (r19 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0203, code lost:
    
        if (r4 != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0205, code lost:
    
        r3 = r2.g(r2.h() - 1);
        r4 = com.tencent.mobileqq.utils.ViewUtils.dip2px(4.0f);
        r3.right = (r18 - r6) - r4;
        r2.g(r2.h() - 1).right = r3.right;
        r5 = new android.graphics.Rect();
        r7 = r3.right + r4;
        r5.left = r7;
        r5.top = r3.top;
        r7 = r7 + r6;
        r5.right = r7;
        r5.bottom = r3.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x023b, code lost:
    
        if (r7 <= r18) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x023d, code lost:
    
        r5.right = r18;
        r5.left = java.lang.Math.max(r18 - r6, r3.right);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0248, code lost:
    
        r2.c(r17.f50659y0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x024d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d2, code lost:
    
        r8 = r17.f50607h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01aa, code lost:
    
        r5 = r17.f50607h;
        r8 = r17.L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01ae, code lost:
    
        if (r5 <= r8) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b1, code lost:
    
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b2, code lost:
    
        r17.L = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0155, code lost:
    
        r4 = false;
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n(int i3, boolean z16) {
        boolean z17;
        if (this.G.size() < 2) {
            o(0);
        }
        ArrayList<g> arrayList = this.G;
        g gVar = arrayList.get(arrayList.size() - 2);
        float I = I(this.f50653w0) + this.f50642s1;
        int I2 = (int) I(this.f50659y0);
        if (z16) {
            I += I2;
        }
        this.f50607h = 0;
        int h16 = gVar.h();
        int i16 = 0;
        while (true) {
            if (i16 >= h16) {
                break;
            }
            TextCell d16 = gVar.d(i16);
            int i17 = (int) ((i3 - I) - this.f50607h);
            if (i17 <= 0) {
                return;
            }
            com.qzone.proxy.feedcomponent.text.g<Integer, Float> r16 = r(d16, i17);
            int intValue = r16.f50743a.intValue();
            float width = gVar.g(i16).width();
            if (width <= i17) {
                this.f50607h = (int) (this.f50607h + width);
                i16++;
            } else if (d16.canBreak()) {
                if (J(d16.text, intValue - 1) == '\n') {
                    intValue--;
                }
                if (MiniBoxNoticeInfo.APPNAME_SUFFIX.equals(this.f50650v0)) {
                    d16.text = d16.text.substring(0, intValue) + this.f50650v0;
                    gVar.j(i16 + 1);
                    this.f50607h = (int) (((float) this.f50607h) + r16.f50744b.floatValue());
                } else {
                    d16.text = d16.text.substring(0, intValue);
                    gVar.j(i16 + 1);
                    gVar.g(gVar.h() - 1).right = this.f50607h + r16.f50744b.intValue();
                    Rect rect = new Rect(gVar.g(gVar.h() - 1));
                    TextCell d17 = gVar.d(gVar.h() - 1);
                    if (d17.canBreak() && d17.text.endsWith("\n")) {
                        String str = d17.text;
                        d17.text = str.substring(0, str.length() - 1);
                    }
                    rect.left = this.f50607h + r16.f50744b.intValue();
                    int intValue2 = this.f50607h + r16.f50744b.intValue() + ((int) I);
                    rect.right = intValue2;
                    if (z16) {
                        rect.right = intValue2 - I2;
                    }
                    gVar.c(this.f50653w0, rect);
                    if (z16) {
                        Rect rect2 = new Rect();
                        int i18 = rect.right;
                        rect2.left = i18;
                        rect2.right = i18 + I2;
                        gVar.c(this.f50659y0, rect);
                        z17 = true;
                        boolean z18 = true;
                    }
                }
                z17 = false;
                boolean z182 = true;
            } else {
                gVar.j(i16);
            }
        }
    }

    private boolean x(Bitmap bitmap, Canvas canvas) {
        if (canvas == null) {
            return true;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    public void setText(ArrayList<TextCell> arrayList) {
        this.E = arrayList;
        requestLayout();
    }

    public void setTextColorAnimation(ArrayList<Integer> arrayList, int i3) {
        com.qzone.proxy.feedcomponent.text.l lVar = this.M0;
        if (lVar != null) {
            lVar.cancel();
        }
        if (arrayList != null && arrayList.size() >= 2 && i3 > 0) {
            com.qzone.proxy.feedcomponent.text.l lVar2 = new com.qzone.proxy.feedcomponent.text.l(this, arrayList);
            this.M0 = lVar2;
            lVar2.setFillAfter(true);
            this.M0.setRepeatCount(-1);
            this.M0.setRepeatMode(2);
            this.M0.setInterpolator(new LinearInterpolator());
            this.M0.setDuration(i3);
            this.M0.setStartTime(0L);
            return;
        }
        this.M0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k {

        /* renamed from: a, reason: collision with root package name */
        Drawable f50683a;

        /* renamed from: b, reason: collision with root package name */
        int f50684b;

        /* renamed from: c, reason: collision with root package name */
        Rect f50685c;

        public k(Drawable drawable, int i3) {
            this.f50683a = drawable;
            this.f50684b = i3;
            this.f50685c = drawable.copyBounds();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && (obj instanceof k) && this.f50684b == ((k) obj).f50684b;
        }
    }

    private boolean C(TextLayoutBase textLayoutBase, Canvas canvas) {
        Canvas canvas2;
        int i3;
        g gVar;
        int i16;
        int i17;
        Canvas canvas3;
        int i18;
        Canvas canvas4;
        float f16;
        int i19;
        TextCell textCell;
        int i26;
        int i27;
        TextLayoutBase textLayoutBase2 = textLayoutBase;
        boolean k06 = k0();
        Bitmap O = O(textLayoutBase);
        if (k06 && O != null && canvas != null) {
            return x(O, canvas);
        }
        if (canvas == null && O != null && !this.f50630o1) {
            return false;
        }
        if (k06) {
            O = p();
            if (O != null) {
                canvas2 = new Canvas(O);
            } else {
                this.f50633p1 = false;
                canvas2 = canvas;
                k06 = false;
            }
        } else if (O != null) {
            p0();
            canvas2 = canvas;
            O = null;
        } else {
            canvas2 = canvas;
        }
        if (canvas == null && canvas2 == null) {
            return false;
        }
        canvas2.translate(this.C0, this.D0);
        y(canvas2);
        B(canvas2);
        float f17 = 0.0f;
        if (this.f50635q0 == 80) {
            canvas2.translate(N(this.f50648u1), this.O - this.N);
        } else {
            canvas2.translate(N(this.f50648u1), 0.0f);
        }
        if (this.W && textLayoutBase.isPressed()) {
            int color = this.C.getColor();
            this.C.setColor(this.X);
            Shader shader = this.C.getShader();
            this.C.setShader(null);
            canvas2.drawRect(0.0f, 0.0f, this.L, this.O, this.C);
            this.C.setShader(shader);
            this.C.setColor(color);
        }
        int size = this.G.size();
        ArrayList<Integer> arrayList = this.H;
        int size2 = arrayList != null ? arrayList.size() : 0;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = false;
        int i28 = 0;
        int i29 = 0;
        while (i29 < size) {
            g gVar2 = this.G.get(i29);
            int h16 = gVar2.h();
            if (this.f50635q0 == 1) {
                int f18 = (this.L - gVar2.f()) / 2;
                gVar2.k(f18);
                canvas2.translate(f18, f17);
            }
            int i36 = i28;
            int i37 = 0;
            while (true) {
                if (i37 >= h16) {
                    i3 = size;
                    gVar = gVar2;
                    i16 = i29;
                    i17 = size2;
                    canvas3 = canvas2;
                    i18 = 1;
                    break;
                }
                TextCell d16 = gVar2.d(i37);
                Rect g16 = gVar2.g(i37);
                ArrayList<Integer> arrayList2 = this.H;
                if (arrayList2 != null && i29 < size2) {
                    i19 = arrayList2.get(i29).intValue();
                } else {
                    i19 = com.qzone.proxy.feedcomponent.text.h.f50745a;
                }
                int i38 = i19;
                if (d16.isEmo() && !d16.isDrawableLoaded) {
                    ((EmoCell) d16).reloadDrawable(textLayoutBase2, this.I1);
                } else if ((d16 instanceof SystemEmoCell) && !d16.isDrawableLoaded) {
                    ((SystemEmoCell) d16).reloadDrawable(textLayoutBase2, this.I1);
                }
                if (!this.K0) {
                    i3 = size;
                    gVar = gVar2;
                    i26 = h16;
                    i27 = i37;
                    i18 = 1;
                    i16 = i29;
                    textCell = d16;
                    i17 = size2;
                    canvas3 = canvas2;
                    z16 = d16.fadedDraw(canvas2, this.C, i38, g16, this.S, this.U, O, i36, this.J0 - this.I0);
                } else {
                    i3 = size;
                    textCell = d16;
                    i26 = h16;
                    gVar = gVar2;
                    i27 = i37;
                    i16 = i29;
                    i17 = size2;
                    canvas3 = canvas2;
                    i18 = 1;
                    z16 = textCell.fadedDraw(canvas3, this.C, i38, g16, this.S, this.U, O, i36, currentTimeMillis - this.I0);
                }
                i36 = ((textCell instanceof ImageCell) || (textCell instanceof EmoCell)) ? i36 + 1 : i36 + textCell.getDrawTextLength();
                if (z16) {
                    break;
                }
                i37 = i27 + 1;
                size2 = i17;
                canvas2 = canvas3;
                size = i3;
                h16 = i26;
                gVar2 = gVar;
                i29 = i16;
                textLayoutBase2 = textLayoutBase;
            }
            i28 = i36;
            if (this.f50635q0 != i18 || gVar.e() == 0) {
                canvas4 = canvas3;
                f16 = 0.0f;
            } else {
                canvas4 = canvas3;
                f16 = 0.0f;
                canvas4.translate(-gVar.e(), 0.0f);
            }
            i29 = i16 + 1;
            size2 = i17;
            canvas2 = canvas4;
            f17 = f16;
            size = i3;
            textLayoutBase2 = textLayoutBase;
        }
        Canvas canvas5 = canvas2;
        l lVar = this.L0;
        if (lVar != null) {
            if (!this.K0) {
                lVar.onProgressChanged(this.J0 - this.I0);
            } else {
                lVar.onProgressChanged(currentTimeMillis - this.I0);
            }
        }
        if (!z16) {
            setFadeAnimation(false);
        }
        if (this.f50635q0 == 80) {
            canvas5.translate(-(this.C0 + N(this.f50648u1)), ((-this.D0) - this.O) + this.N);
        } else {
            canvas5.translate(-(this.C0 + N(this.f50648u1)), -this.D0);
        }
        if (k06 && canvas != null) {
            x(O, canvas);
        }
        this.f50630o1 = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0555 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0547 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean U(TextLayoutBase textLayoutBase, Canvas canvas) {
        Canvas canvas2;
        int i3;
        boolean z16;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z17;
        int i26;
        g gVar;
        Canvas canvas3;
        boolean z18;
        boolean z19;
        boolean z26;
        Bitmap bitmap;
        boolean z27;
        boolean z28;
        Object obj;
        char c16;
        TextCell textCell;
        TextCell textCell2;
        TextLayoutBase textLayoutBase2 = textLayoutBase;
        boolean k06 = k0();
        Bitmap O = O(textLayoutBase);
        Paint paint = this.C;
        boolean z29 = paint instanceof com.qzone.proxy.feedcomponent.text.d ? ((com.qzone.proxy.feedcomponent.text.d) paint).f50712d : true;
        if (canvas != null && b0() && !W()) {
            if (this.H0 != null) {
                w(canvas);
            } else if (!TextUtils.isEmpty(this.G0)) {
                com.qzone.util.image.c.J(this.G0, true, new d(textLayoutBase2), Bitmap.Config.ARGB_8888);
            }
        }
        if (canvas != null) {
            canvas.translate(this.C0, this.D0);
        }
        if (k06 && O != null && canvas != null && z29) {
            return x(O, canvas);
        }
        if (canvas == null && O != null && !this.f50630o1) {
            return false;
        }
        if (k06) {
            if (z29) {
                O = p();
                if (O != null) {
                    canvas2 = new Canvas(O);
                } else {
                    this.f50633p1 = false;
                    canvas2 = canvas;
                    k06 = false;
                }
            }
            canvas2 = canvas;
        } else {
            if (O != null) {
                p0();
                canvas2 = canvas;
                O = null;
            }
            canvas2 = canvas;
        }
        if ((canvas == null && canvas2 == null) || canvas2 == null) {
            return false;
        }
        if (b0() && !W()) {
            A(canvas2);
        }
        if (this.W && textLayoutBase.isPressed()) {
            int color = this.C.getColor();
            this.C.setColor(this.X);
            Shader shader = this.C.getShader();
            this.C.setShader(null);
            canvas2.drawRect(0.0f, 0.0f, this.L, this.O, this.C);
            this.C.setShader(shader);
            this.C.setColor(color);
        }
        y(canvas2);
        B(canvas2);
        if (this.f50635q0 == 80) {
            canvas2.translate(N(this.f50648u1), this.O - this.N);
        } else {
            canvas2.translate(N(this.f50648u1), 0.0f);
        }
        if (this.J1) {
            i3 = (f50574i2 - this.f50589b) / 2;
            canvas2.save();
        } else {
            i3 = 0;
        }
        int size = this.G.size();
        int size2 = this.H.size();
        int i27 = 0;
        boolean z36 = false;
        int i28 = 0;
        boolean z37 = false;
        while (i27 < size) {
            g gVar2 = this.G.get(i27);
            int h16 = gVar2.h();
            S(canvas2, gVar2);
            boolean z38 = z36;
            int i29 = i28;
            boolean z39 = z37;
            int i36 = 0;
            while (i36 < h16) {
                TextCell d16 = gVar2.d(i36);
                Rect g16 = gVar2.g(i36);
                if (i27 < size2) {
                    i16 = h16;
                    i17 = this.H.get(i27).intValue();
                } else {
                    i16 = h16;
                    i17 = com.qzone.proxy.feedcomponent.text.h.f50745a;
                }
                if (d16.isEmo()) {
                    i18 = i36;
                    if (!d16.isDrawableLoaded) {
                        i19 = size2;
                        ((EmoCell) d16).reloadDrawable(textLayoutBase2, this.I1);
                        if (this.F && (textCell = this.f50590b0) != null && !textCell.canCopy()) {
                            textCell2 = this.f50590b0;
                            if (textCell2.type == 3) {
                                if (d16.linebreakSeq == textCell2.linebreakSeq) {
                                    this.C.setColor(this.V);
                                    RectF rectF = this.f50586a0;
                                    float f16 = g16.left;
                                    float f17 = this.B0;
                                    i26 = size;
                                    gVar = gVar2;
                                    z17 = z29;
                                    rectF.set(f16 - f17, g16.top - f17, g16.right + f17, r13 + i17 + f17);
                                    Shader shader2 = this.C.getShader();
                                    this.C.setShader(null);
                                    canvas2.drawRect(this.f50586a0, this.C);
                                    this.C.setShader(shader2);
                                } else {
                                    z17 = z29;
                                    i26 = size;
                                    gVar = gVar2;
                                }
                                int i37 = i17;
                                Canvas canvas4 = canvas2;
                                d16.draw(canvas2, this.C, i37, g16, this.S, this.U, O);
                                if (this.f50635q0 == 1 && gVar.e() != 0) {
                                    canvas4.translate(-gVar.e(), 0.0f);
                                }
                                z26 = k06;
                                bitmap = O;
                                canvas3 = canvas4;
                                i36 = i18 + 1;
                                canvas2 = canvas3;
                                h16 = i16;
                                size2 = i19;
                                size = i26;
                                gVar2 = gVar;
                                z29 = z17;
                                k06 = z26;
                                O = bitmap;
                                textLayoutBase2 = textLayoutBase;
                            }
                        }
                        z17 = z29;
                        i26 = size;
                        gVar = gVar2;
                        canvas3 = canvas2;
                        z18 = d16 instanceof ComboNetImageCell;
                        z19 = d16 instanceof DynamicImageCell;
                        if (this.J1 || d16.useDefaultFont || z38 || !TextUtils.isEmpty(d16.getUrl()) || z18) {
                            z26 = k06;
                            bitmap = O;
                            z27 = z18;
                            z28 = z19;
                        } else {
                            int i38 = f50577l2;
                            int i39 = f50572g2;
                            int i46 = (i39 * 2) + i38;
                            boolean z46 = z19;
                            if (canvas3.getWidth() < g16.left + i46) {
                                i38 = (canvas3.getWidth() - g16.left) - (i39 * 2);
                                i46 = i38 + (i39 * 2);
                            }
                            int i47 = g16.left;
                            int i48 = (i47 + i46) - i39;
                            int i49 = i47 - (this.M - i47);
                            z26 = k06;
                            if (this.V1 != null && this.G1 == i48 && this.H1 == i49) {
                                bitmap = O;
                            } else {
                                this.G1 = i48;
                                this.H1 = i49;
                                TranslateAnimation translateAnimation = new TranslateAnimation(0, i48, 0, i49, 0, 0.0f, 0, 0.0f);
                                this.V1 = translateAnimation;
                                translateAnimation.setFillAfter(true);
                                this.V1.setRepeatCount(-1);
                                this.V1.setRepeatMode(1);
                                this.V1.setInterpolator(new LinearInterpolator());
                                bitmap = O;
                                this.V1.setDuration(2000L);
                                this.V1.setStartTime(0L);
                                this.V1.setAnimationListener(new e());
                            }
                            this.V1.initialize(this.M, 0, 0, 0);
                            this.V1.setDuration((int) Math.max((Math.abs(i49 - i48) * 1000.0f) / f50576k2, 1000.0f));
                            try {
                                if (this.O1 == 1) {
                                    if (this.N1 == 0) {
                                        this.N1 = System.currentTimeMillis();
                                    }
                                    z27 = z18;
                                    try {
                                        if (System.currentTimeMillis() - this.N1 > 1200) {
                                            this.N1 = System.currentTimeMillis();
                                            this.S1 = !this.S1;
                                        }
                                        if (this.S1) {
                                            Drawable drawable = this.L1;
                                            if (drawable != null) {
                                                int i56 = g16.left;
                                                drawable.setBounds(i56, 0, i56 + i46, f50574i2);
                                                this.L1.draw(canvas3);
                                            }
                                        } else {
                                            Drawable drawable2 = this.M1;
                                            if (drawable2 != null) {
                                                int i57 = g16.left;
                                                drawable2.setBounds(i57, 0, i57 + i46, f50574i2);
                                                this.M1.draw(canvas3);
                                            }
                                        }
                                    } catch (Exception unused) {
                                        QZLog.e("TextCellLayout", 1, "draw error ");
                                        if (this.O1 == 2) {
                                        }
                                        if (!TextUtils.isEmpty(this.Q1)) {
                                            canvas3.translate(this.C0, this.D0);
                                            Drawable drawable3 = this.W1;
                                            int i58 = g16.left;
                                            drawable3.setBounds(i58, 0, i46 + i58, f50574i2);
                                            this.W1.draw(canvas3);
                                            canvas3.translate(-this.C0, -this.D0);
                                        }
                                        canvas3.translate(f50572g2, 0.0f);
                                        int i59 = g16.left;
                                        canvas3.clipRect(i59, 0, i38 + i59, f50574i2);
                                        if (this.V1.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.D1)) {
                                            if (this.X1 == null) {
                                            }
                                            this.D1.getMatrix().getValues(this.X1);
                                            canvas3.translate(this.X1[2] - g16.left, 0.0f);
                                            z46 = true;
                                        }
                                        z28 = z46;
                                        z38 = true;
                                        if (z28) {
                                        }
                                        if (this.J1) {
                                        }
                                        if (d16.isPresseding) {
                                        }
                                        obj = null;
                                        if (this.Y1) {
                                        }
                                        if (this.J1) {
                                        }
                                        d16.draw(canvas3, this.C, i17, g16, this.S, this.U, bitmap);
                                        if (this.J1) {
                                        }
                                        if (!this.J1) {
                                        }
                                        i36 = i18 + 1;
                                        canvas2 = canvas3;
                                        h16 = i16;
                                        size2 = i19;
                                        size = i26;
                                        gVar2 = gVar;
                                        z29 = z17;
                                        k06 = z26;
                                        O = bitmap;
                                        textLayoutBase2 = textLayoutBase;
                                    }
                                } else {
                                    z27 = z18;
                                    Drawable drawable4 = this.L1;
                                    if (drawable4 != null) {
                                        int i65 = g16.left;
                                        drawable4.setBounds(i65, 0, i65 + i46, f50574i2);
                                        this.L1.draw(canvas3);
                                    }
                                }
                            } catch (Exception unused2) {
                                z27 = z18;
                            }
                            if (this.O1 == 2) {
                                if (this.N1 == 0) {
                                    this.N1 = System.currentTimeMillis();
                                }
                                if (System.currentTimeMillis() - this.N1 > 2200) {
                                    this.Y1 = false;
                                }
                                if (!this.Y1 && this.M1 != null) {
                                    canvas3.translate(0.0f, i3);
                                    Drawable drawable5 = this.M1;
                                    int i66 = g16.left;
                                    int i67 = f50575j2;
                                    drawable5.setBounds(i66, 0, ((i67 * 70) / 42) + i66, i67);
                                    this.M1.draw(canvas3);
                                    canvas3.translate(0.0f, -i3);
                                }
                            }
                            if (!TextUtils.isEmpty(this.Q1) && this.R1 > 0 && this.W1 != null) {
                                canvas3.translate(this.C0, this.D0);
                                Drawable drawable32 = this.W1;
                                int i582 = g16.left;
                                drawable32.setBounds(i582, 0, i46 + i582, f50574i2);
                                this.W1.draw(canvas3);
                                canvas3.translate(-this.C0, -this.D0);
                            }
                            canvas3.translate(f50572g2, 0.0f);
                            int i592 = g16.left;
                            canvas3.clipRect(i592, 0, i38 + i592, f50574i2);
                            if (this.V1.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.D1) && !this.V1.hasEnded()) {
                                if (this.X1 == null) {
                                    this.X1 = new float[9];
                                }
                                this.D1.getMatrix().getValues(this.X1);
                                canvas3.translate(this.X1[2] - g16.left, 0.0f);
                                z46 = true;
                            }
                            z28 = z46;
                            z38 = true;
                        }
                        if (z28) {
                            postInvalidateOnAnimation();
                        }
                        if (this.J1) {
                            float f18 = i3;
                            canvas3.translate(0.0f, f18);
                            int i68 = this.T1;
                            this.S = i68;
                            if (this.O1 == 1) {
                                if (!this.S1) {
                                    i68 = this.U1;
                                }
                                this.S = i68;
                            }
                            if (!TextUtils.isEmpty(d16.getUrl())) {
                                canvas3.restore();
                                canvas3.translate(0.0f, f18);
                                this.K1 = true;
                                int i69 = g16.right - g16.left;
                                int i75 = f50577l2;
                                int i76 = f50572g2;
                                g16.right = i69 + i75 + (i76 * 2);
                                g16.left = i75 + (i76 * 2);
                            }
                        }
                        if (((d16.isPresseding || !this.f50620l0) && !(this.F && d16.canCopy())) || (d16 instanceof NetImageCell)) {
                            obj = null;
                        } else {
                            this.C.setColor(this.V);
                            int i77 = (this.J1 && z39 && i29 > 0) ? i29 : 0;
                            RectF rectF2 = this.f50586a0;
                            float f19 = g16.left;
                            float f26 = this.B0;
                            float f27 = i77;
                            rectF2.set((f19 - f26) + f27, g16.top - f26, g16.right + f26 + f27, r12 + i17 + f26);
                            Shader shader3 = this.C.getShader();
                            obj = null;
                            this.C.setShader(null);
                            canvas3.drawRect(this.f50586a0, this.C);
                            this.C.setShader(shader3);
                        }
                        if (this.Y1) {
                            c16 = 2;
                            if (this.O1 == 2 && !d16.useDefaultFont && this.M1 != null && TextUtils.isEmpty(d16.getUrl())) {
                                Drawable drawable6 = this.M1;
                                int i78 = g16.left;
                                int i79 = f50575j2;
                                drawable6.setBounds(i78, 0, ((i79 * 70) / 42) + i78, i79);
                                this.M1.draw(canvas3);
                                if (!this.J1) {
                                    canvas3.translate(0.0f, -i3);
                                }
                                i36 = i18 + 1;
                                canvas2 = canvas3;
                                h16 = i16;
                                size2 = i19;
                                size = i26;
                                gVar2 = gVar;
                                z29 = z17;
                                k06 = z26;
                                O = bitmap;
                                textLayoutBase2 = textLayoutBase;
                            }
                        } else {
                            c16 = 2;
                        }
                        if (this.J1) {
                            if (z27) {
                                i29 = g16.right - g16.left;
                            } else if (z39 && i29 > 0) {
                                g16.left += i29;
                                g16.right += i29;
                            }
                        }
                        d16.draw(canvas3, this.C, i17, g16, this.S, this.U, bitmap);
                        if (this.J1 && z38) {
                            z39 = true;
                        }
                        if (!this.J1) {
                        }
                        i36 = i18 + 1;
                        canvas2 = canvas3;
                        h16 = i16;
                        size2 = i19;
                        size = i26;
                        gVar2 = gVar;
                        z29 = z17;
                        k06 = z26;
                        O = bitmap;
                        textLayoutBase2 = textLayoutBase;
                    }
                } else {
                    i18 = i36;
                }
                i19 = size2;
                if ((d16 instanceof SystemEmoCell) && !d16.isDrawableLoaded) {
                    ((SystemEmoCell) d16).reloadDrawable(textLayoutBase2, this.I1);
                }
                if (this.F) {
                    textCell2 = this.f50590b0;
                    if (textCell2.type == 3) {
                    }
                }
                z17 = z29;
                i26 = size;
                gVar = gVar2;
                canvas3 = canvas2;
                z18 = d16 instanceof ComboNetImageCell;
                z19 = d16 instanceof DynamicImageCell;
                if (this.J1) {
                }
                z26 = k06;
                bitmap = O;
                z27 = z18;
                z28 = z19;
                if (z28) {
                }
                if (this.J1) {
                }
                if (d16.isPresseding) {
                }
                obj = null;
                if (this.Y1) {
                }
                if (this.J1) {
                }
                d16.draw(canvas3, this.C, i17, g16, this.S, this.U, bitmap);
                if (this.J1) {
                    z39 = true;
                }
                if (!this.J1) {
                }
                i36 = i18 + 1;
                canvas2 = canvas3;
                h16 = i16;
                size2 = i19;
                size = i26;
                gVar2 = gVar;
                z29 = z17;
                k06 = z26;
                O = bitmap;
                textLayoutBase2 = textLayoutBase;
            }
            boolean z47 = k06;
            Bitmap bitmap2 = O;
            boolean z48 = z29;
            int i85 = size2;
            int i86 = size;
            g gVar3 = gVar2;
            Canvas canvas5 = canvas2;
            if (this.f50635q0 != 1 || gVar3.e() == 0) {
                z16 = false;
            } else {
                z16 = false;
                canvas5.translate(-gVar3.e(), 0.0f);
            }
            i27++;
            canvas2 = canvas5;
            z36 = z38;
            i28 = i29;
            z37 = z39;
            size2 = i85;
            size = i86;
            z29 = z48;
            k06 = z47;
            O = bitmap2;
            textLayoutBase2 = textLayoutBase;
        }
        boolean z49 = k06;
        Bitmap bitmap3 = O;
        boolean z55 = z29;
        Canvas canvas6 = canvas2;
        if (this.J1) {
            try {
                canvas6.restore();
            } catch (Exception unused3) {
            }
        }
        if (this.f50635q0 == 80) {
            canvas6.translate(-(this.C0 + N(this.f50648u1)), ((-this.D0) - this.O) + this.N);
        } else {
            canvas6.translate(-(this.C0 + N(this.f50648u1)), -this.D0);
        }
        if (z49 && canvas != null && z55) {
            x(bitmap3, canvas);
        }
        this.f50630o1 = false;
        return true;
    }

    public void setText(TextCell textCell) {
        ArrayList<TextCell> arrayList = new ArrayList<>();
        this.E = arrayList;
        arrayList.add(textCell);
        requestLayout();
    }

    public void setTypeface(Typeface typeface, int i3) {
        Typeface create;
        if (i3 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i3);
            } else {
                create = Typeface.create(typeface, i3);
            }
            t0(create);
            int i16 = (~(create != null ? create.getStyle() : 0)) & i3;
            this.C.setFakeBoldText((i16 & 1) != 0);
            this.C.setTextSkewX((i16 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.C.setFakeBoldText(false);
        this.C.setTextSkewX(0.0f);
        t0(typeface);
    }

    public void setMeasuredLineLinkColor(int i3, int i16) {
        ArrayList<g> arrayList = this.G;
        if (arrayList != null) {
            int size = arrayList.size();
            int i17 = 0;
            boolean z16 = false;
            for (int i18 = 0; i18 < size; i18++) {
                g gVar = this.G.get(i18);
                int h16 = gVar.h();
                for (int i19 = 0; i19 < h16; i19++) {
                    TextCell d16 = gVar.d(i19);
                    if (d16 instanceof ColorTextCell) {
                        if (i17 < i16) {
                            z16 = true;
                        } else {
                            ((ColorTextCell) d16).setTextColor(i3);
                        }
                    } else if (z16) {
                        i17++;
                        z16 = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            TextCellLayout.this.Y1 = true;
            TextCellLayout.this.N1 = 0L;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    public static void setClickRepChangeListener(h hVar) {
    }

    public void reset() {
    }

    public void setOnSideDrawableClickListener(i iVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextLayoutBase f50673d;

        d(TextLayoutBase textLayoutBase) {
            this.f50673d = textLayoutBase;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            TextCellLayout.this.H0 = drawable;
            this.f50673d.requestLayout();
            TextCellLayout.this.forceRequestLayout();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements ImageLoader.ImageLoadListener {
        f() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            TextCellLayout.this.J1 = drawable != null;
            TextCellLayout.this.M1 = drawable;
            TextCellLayout.this.forceRequestLayout();
            TextCellLayout.this.f50663z1.requestLayout();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
