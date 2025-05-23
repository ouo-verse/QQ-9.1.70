package com.etrump.mixlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.api.ETFontUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IETextView;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import m.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ETTextView extends AnimationTextView implements IETextView {
    private static boolean K0 = false;
    private static Bitmap L0;
    private static Handler M0;
    public static Handler N0;
    private boolean A0;
    private boolean B0;
    int C0;
    int D0;
    Runnable E0;
    public m.e F0;
    public boolean G0;
    private boolean H0;
    private boolean I0;
    private boolean J0;
    public com.etrump.mixlayout.e V;
    public ETFont W;

    /* renamed from: a0, reason: collision with root package name */
    public int f32605a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f32606b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f32607c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f32608d0;

    /* renamed from: e0, reason: collision with root package name */
    public long f32609e0;

    /* renamed from: f0, reason: collision with root package name */
    private float f32610f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f32611g0;

    /* renamed from: h0, reason: collision with root package name */
    private float f32612h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f32613i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f32614j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f32615k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f32616l0;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f32617m0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f32618n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f32619o0;

    /* renamed from: p0, reason: collision with root package name */
    public ChatMessage f32620p0;

    /* renamed from: q0, reason: collision with root package name */
    public SessionInfo f32621q0;

    /* renamed from: r0, reason: collision with root package name */
    public e f32622r0;

    /* renamed from: s0, reason: collision with root package name */
    private final a f32623s0;

    /* renamed from: t0, reason: collision with root package name */
    private ETDecoration f32624t0;

    /* renamed from: u0, reason: collision with root package name */
    private j f32625u0;

    /* renamed from: v0, reason: collision with root package name */
    private Paint f32626v0;

    /* renamed from: w0, reason: collision with root package name */
    private q f32627w0;

    /* renamed from: x0, reason: collision with root package name */
    private int[] f32628x0;

    /* renamed from: y0, reason: collision with root package name */
    private d f32629y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f32630z0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private Bitmap f32631a;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(int i3, int i16) {
            synchronized (this) {
                int size = ETTextView.this.W.getSize() * 4;
                if (i16 < size) {
                    i16 = size;
                }
                Bitmap bitmap = this.f32631a;
                if (bitmap != null && (bitmap.getHeight() < i16 || this.f32631a.getWidth() < i3 || this.f32631a.getHeight() > size + i16)) {
                    this.f32631a.recycle();
                    this.f32631a = null;
                }
                if (this.f32631a == null) {
                    this.f32631a = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                }
                Bitmap bitmap2 = this.f32631a;
                if (bitmap2 != null) {
                    bitmap2.setDensity(ETTextView.this.getResources().getDisplayMetrics().densityDpi);
                }
            }
        }

        Bitmap b() {
            return this.f32631a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 2) {
                if (i3 == 3 && ETTextView.L0 != null) {
                    ETTextView.L0.recycle();
                    ETTextView.L0 = null;
                    return;
                }
                return;
            }
            c cVar = (c) message.obj;
            if (cVar != null) {
                int width = cVar.f32638f.getWidth();
                int height = cVar.f32638f.getHeight();
                if (ETTextView.L0 != null && (ETTextView.L0.getWidth() < width || ETTextView.L0.getHeight() < height)) {
                    ETTextView.L0.recycle();
                    ETTextView.L0 = null;
                }
                boolean z16 = false;
                if (ETTextView.L0 == null) {
                    ETTextView.L0 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                } else {
                    ETTextView.L0.eraseColor(0);
                }
                ETEngine instanceForAnimation = ETEngine.getInstanceForAnimation();
                ETDecoration e16 = cVar.f32637e.e(instanceForAnimation, false);
                if (e16 != null) {
                    e16.gotoFrame(cVar.f32636d);
                }
                cVar.f32637e.g(instanceForAnimation, ETTextView.L0, e16, true);
                if (e16 != null) {
                    e16.deleteDescriptor();
                }
                Bitmap bitmap = cVar.f32638f;
                if (cVar.f32633a.get() != null) {
                    synchronized (cVar.f32633a.get().f32623s0) {
                        if (!bitmap.isRecycled() && cVar.f32633a.get().f32609e0 == cVar.f32634b) {
                            bitmap.eraseColor(0);
                            instanceForAnimation.native_cloneBitmap(ETTextView.L0, bitmap);
                            z16 = true;
                        }
                    }
                }
                if (z16) {
                    ETTextView.M0.obtainMessage(1, cVar).sendToTarget();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ETTextView> f32633a;

        /* renamed from: b, reason: collision with root package name */
        public long f32634b;

        /* renamed from: c, reason: collision with root package name */
        public long f32635c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f32636d = -1;

        /* renamed from: e, reason: collision with root package name */
        public com.etrump.mixlayout.e f32637e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f32638f;

        static c a(ETTextView eTTextView) {
            if (eTTextView.f32624t0 == null) {
                return null;
            }
            c cVar = new c();
            cVar.f32633a = new WeakReference<>(eTTextView);
            cVar.f32634b = eTTextView.f32609e0;
            cVar.f32637e = eTTextView.V;
            cVar.f32636d = eTTextView.f32624t0.currentFrameIndex();
            cVar.f32638f = eTTextView.f32623s0.b();
            cVar.f32635c = System.currentTimeMillis();
            return cVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        void a(ETTextView eTTextView, CharSequence charSequence);

        void b(ETTextView eTTextView);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class e {
        public abstract void a(ChatMessage chatMessage, int i3);

        public abstract void b(ChatMessage chatMessage, boolean z16, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class f extends Handler {
        f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ETTextView eTTextView;
            Handler handler;
            ETFont eTFont;
            boolean z16;
            ETFont eTFont2;
            c cVar = (c) message.obj;
            if (cVar != null && (eTTextView = cVar.f32633a.get()) != null && eTTextView.f32624t0 != null) {
                int i3 = message.what;
                if (i3 != 0) {
                    boolean z17 = true;
                    if (i3 == 1 && eTTextView.S()) {
                        if (eTTextView.f32623s0.b() == cVar.f32638f && eTTextView.f32609e0 == cVar.f32634b && eTTextView.f32624t0 != null && eTTextView.f32624t0.currentFrameIndex() == cVar.f32636d && (eTFont = eTTextView.W) != null && eTFont.equals(cVar.f32637e.f32703d)) {
                            if (eTTextView.J0 && eTTextView.I0 && ETFontUtil.enableAnimation && !eTTextView.H0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                eTTextView.postInvalidate();
                                ETDecoration eTDecoration = eTTextView.f32624t0;
                                if (eTDecoration.nextFrame()) {
                                    int frameDelay = eTDecoration.getFrameDelay();
                                    int currentTimeMillis = (int) (System.currentTimeMillis() - cVar.f32635c);
                                    if (currentTimeMillis > 0) {
                                        frameDelay -= currentTimeMillis;
                                    }
                                    Message obtainMessage = obtainMessage(0, c.a(eTTextView));
                                    if (frameDelay <= 1) {
                                        sendMessage(obtainMessage);
                                    } else {
                                        sendMessageDelayed(obtainMessage, frameDelay);
                                    }
                                } else {
                                    eTTextView.f32619o0 = false;
                                    eTTextView.postInvalidateDelayed(100L);
                                    e eVar = eTTextView.f32622r0;
                                    if (eVar != null && (eTFont2 = eTTextView.W) != null) {
                                        eVar.a(eTTextView.f32620p0, eTFont2.mFontId);
                                    }
                                    z17 = false;
                                }
                            } else {
                                z17 = z16;
                            }
                            eTTextView.J0 = z17;
                            return;
                        }
                        QLog.e("ETTextView", 2, "this textView reused!");
                        return;
                    }
                    return;
                }
                if (eTTextView.S() && (handler = ETTextView.N0) != null) {
                    handler.obtainMessage(2, c.a(eTTextView)).sendToTarget();
                }
            }
        }
    }

    public ETTextView(Context context) {
        super(context);
        this.f32605a0 = Integer.MAX_VALUE;
        this.f32610f0 = 0.0f;
        this.f32611g0 = 0.0f;
        this.f32612h0 = 0.0f;
        this.f32613i0 = 0;
        this.f32614j0 = -1;
        this.f32615k0 = -1;
        this.f32616l0 = false;
        this.f32617m0 = false;
        this.f32618n0 = false;
        this.f32619o0 = false;
        this.f32623s0 = new a();
        this.f32625u0 = null;
        this.f32628x0 = new int[4];
        this.f32630z0 = true;
        this.A0 = false;
        this.B0 = false;
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = new Runnable() { // from class: com.etrump.mixlayout.ETTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ETTextView.this.getTag(R.id.dbm) != null) {
                    ((Boolean) ETTextView.this.getTag(R.id.dbm)).booleanValue();
                }
                ETTextView eTTextView = ETTextView.this;
                if (eTTextView.R) {
                    eTTextView.getClass();
                }
                ETTextView.this.setTag(R.id.dbm, Boolean.FALSE);
            }
        };
        this.G0 = false;
        this.H0 = false;
        this.I0 = false;
        this.J0 = false;
        O();
        N();
    }

    private boolean K() {
        ETDecoration eTDecoration;
        if (this.V == null || (eTDecoration = this.f32624t0) == null || eTDecoration.getFrameNum() <= 0) {
            return false;
        }
        return true;
    }

    private static void O() {
        m e16;
        if (N0 == null) {
            M0 = new f(Looper.getMainLooper());
            if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
                IFontManagerService iFontManagerService = (IFontManagerService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFontManagerService.class, "");
                if (iFontManagerService != null && iFontManagerService.getHandlerThread() != null && iFontManagerService.getHandlerThread().getLooper() != null) {
                    N0 = new b(iFontManagerService.getHandlerThread().getLooper());
                    return;
                }
                return;
            }
            if ((BaseApplicationImpl.getApplication().getRuntime() instanceof ToolAppRuntime) && (e16 = m.e()) != null) {
                N0 = new b(e16.f32769f.getLooper());
            }
        }
    }

    private void W(ETFont eTFont, long j3, int i3) {
        Typeface typeface;
        if (this.f32609e0 != j3) {
            this.A0 = false;
        }
        ETFont eTFont2 = this.W;
        if (eTFont2 == null) {
            ETFont eTFont3 = new ETFont(eTFont.mFontId, eTFont.mFontPath, getTextSize(), eTFont.mFontType, eTFont.mTypeface);
            this.W = eTFont3;
            eTFont3.copy(eTFont);
            this.W.setSize(getTextSize());
        } else {
            eTFont2.copy(eTFont);
            ETFont eTFont4 = this.W;
            eTFont4.mAnimationId = j3;
            eTFont4.mText = eTFont.mText;
            if (eTFont.mFontType != 1) {
                eTFont4.mTypeface = eTFont.mTypeface;
            }
            eTFont4.mDiyHandle = eTFont.mDiyHandle;
        }
        ETFont eTFont5 = this.W;
        eTFont5.mComboIndex = i3;
        if (eTFont5.mFontType != 1 && (typeface = eTFont5.mTypeface) != null) {
            setTypeface(typeface);
        }
        if (this.W.mFontId == 0) {
            setTypeface(null);
        }
        this.f32609e0 = j3;
        if (this.V == null) {
            this.V = new com.etrump.mixlayout.e();
        }
        this.W.setColor(getCurrentTextColor());
        d dVar = this.f32629y0;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    public com.etrump.mixlayout.e I() {
        return this.V;
    }

    public q J() {
        if (this.f32627w0 == null) {
            this.f32627w0 = new q(getText());
        }
        return this.f32627w0;
    }

    public boolean L() {
        int i3;
        ETFont eTFont = this.W;
        if (eTFont == null || (i3 = eTFont.mFontId) == 0 || eTFont.mFontType != 4) {
            return false;
        }
        int h16 = m.b.h(i3);
        if (h16 != 3 && h16 != 7 && h16 != 8) {
            return false;
        }
        return true;
    }

    public boolean M() {
        ETFont eTFont = this.W;
        if ((eTFont != null && eTFont.mFontId != 0 && eTFont.mFontType == 1) || P()) {
            return !ETEngine.getInstance().native_containComplexScript(getText().toString());
        }
        return false;
    }

    protected void N() {
        this.f32626v0 = new Paint();
        setTypeface(null);
    }

    public boolean P() {
        ETFont eTFont = this.W;
        if (eTFont != null && eTFont.mFontId == 9999 && !TextUtils.isEmpty(eTFont.mFontPath) && VasShieldFont.f32669b == 4) {
            return true;
        }
        return false;
    }

    public boolean Q() {
        if (!this.A0) {
            this.B0 = com.tencent.mobileqq.text.TextUtils.isContainComplexScript(getText().toString());
            this.A0 = true;
        }
        ETFont eTFont = this.W;
        if (eTFont != null && eTFont.mFontId != 0 && eTFont.mFontType == 4 && !this.B0) {
            return true;
        }
        return false;
    }

    public boolean R() {
        com.etrump.mixlayout.e eVar;
        if (M() && (eVar = this.V) != null && eVar.f32719t.get()) {
            return true;
        }
        return false;
    }

    public boolean S() {
        boolean isProfileCardActivity = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardActivity(getContext());
        boolean equals = "StickyNoteETTextView".equals(getClass().getSimpleName());
        if (!(getContext() instanceof QQBrowserActivity) && !(getContext() instanceof PublicFragmentActivity) && !equals && !isProfileCardActivity) {
            return false;
        }
        return true;
    }

    public void T() {
        this.H0 = true;
    }

    public void U() {
        m.e eVar = this.F0;
        if (eVar != null) {
            eVar.m();
        }
    }

    public void V() {
        m.e eVar = this.F0;
        if (eVar != null) {
            eVar.n();
        }
    }

    public void X(boolean z16, boolean z17) {
        if (R()) {
            Y(z16, z17);
        } else if (L()) {
            a0(z16, z17);
        }
    }

    public void Y(boolean z16, boolean z17) {
        boolean z18;
        e eVar;
        this.H0 = false;
        if (K() && S() && !this.f32618n0) {
            if (ETFontUtil.enableAnimation && !this.H0) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.I0 = z18;
            if (z18 && !this.J0) {
                if (z17 && this.f32624t0.isLastFrame()) {
                    return;
                }
                this.J0 = true;
                this.f32619o0 = false;
                M0.obtainMessage(0, c.a(this)).sendToTarget();
                if (!z17 && (eVar = this.f32622r0) != null) {
                    eVar.b(this.f32620p0, z16, this.W.mFontId);
                }
            }
        }
    }

    public void Z() {
        m.e eVar = this.F0;
        if (eVar != null) {
            eVar.o();
        }
    }

    public void a0(boolean z16, boolean z17) {
        e eVar;
        QQAppInterface qQAppInterface;
        IFontManagerService iFontManagerService;
        this.H0 = false;
        if (this.W != null && S()) {
            if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) && (qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()) != null && (iFontManagerService = (IFontManagerService) qQAppInterface.getRuntimeService(IFontManagerService.class, "")) != null && !iFontManagerService.getFounderDynamicFontAbility()) {
                return;
            }
            if (ETFontUtil.enableAnimation && !this.H0) {
                m.e eVar2 = this.F0;
                if (eVar2 != null) {
                    if (this.f32619o0 || z16 || z17) {
                        int i3 = eVar2.f415894g;
                        int[] iArr = this.F0.f415889b;
                        if (iArr != null) {
                            int i16 = iArr[0];
                            if (z17 && i3 == 0) {
                                return;
                            }
                            if (i3 == 0) {
                                Z();
                                this.G0 = true;
                            } else if (i3 > 0 && i3 < i16) {
                                V();
                                this.G0 = true;
                            }
                            this.f32619o0 = false;
                            if (!z17 && (eVar = this.f32622r0) != null) {
                                eVar.b(this.f32620p0, z16, this.W.mFontId);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            m.e eVar3 = this.F0;
            if (eVar3 != null) {
                int i17 = eVar3.f415894g;
                int[] iArr2 = this.F0.f415889b;
                if (iArr2 != null) {
                    int i18 = iArr2[0];
                    if (i17 > 0 && i17 < i18) {
                        U();
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.AnimationTextView, com.tencent.qqnt.selectable.g
    public int b(int i3, int i16) {
        if (Q()) {
            Object obj = this.F0;
            if (!(obj instanceof e.a)) {
                return -1;
            }
            return J().b(((e.a) obj).b(i3, i16));
        }
        if (R()) {
            j jVar = this.f32625u0;
            if (jVar == null) {
                return -1;
            }
            return J().b(jVar.e(i3, i16));
        }
        return super.b(i3, i16);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETextView
    public int getETMaxWidth() {
        return this.f32605a0;
    }

    @Override // android.widget.TextView, com.tencent.mobileqq.vas.font.api.IETextView
    public /* bridge */ /* synthetic */ Paint getPaint() {
        return super.getPaint();
    }

    @Override // com.tencent.mobileqq.widget.AnimationTextView, com.tencent.qqnt.selectable.g
    public void h() {
        if (Q()) {
            Object obj = this.F0;
            if (obj instanceof e.a) {
                ((e.a) obj).h();
                return;
            }
            return;
        }
        if (R()) {
            j jVar = this.f32625u0;
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        super.h();
    }

    @Override // com.tencent.mobileqq.widget.AnimationTextView, com.tencent.qqnt.selectable.g
    public void i(int i3, int[] iArr, boolean z16) {
        if (Q()) {
            if (this.F0 instanceof e.a) {
                ((e.a) this.F0).i(J().a(i3), iArr, z16);
                return;
            }
            return;
        }
        if (R()) {
            if (this.f32625u0 != null) {
                this.f32625u0.d(J().a(i3), iArr, z16);
                return;
            }
            return;
        }
        super.i(i3, iArr, z16);
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETextView
    public boolean isCacheMeasureResult() {
        return this.f32630z0;
    }

    @Override // com.tencent.mobileqq.widget.AnimationTextView, com.tencent.qqnt.selectable.g
    public void m() {
        if (Q()) {
            if (this.F0 instanceof e.a) {
                ((e.a) this.F0).a(J().a(y()), J().a(u()));
                return;
            }
            return;
        }
        if (R()) {
            if (this.f32625u0 != null) {
                this.f32625u0.c(J().a(y()), J().a(u() - 1));
                return;
            }
            return;
        }
        super.m();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETextView
    public void onAnimationEnd(int i3) {
        e eVar = this.f32622r0;
        if (eVar != null) {
            eVar.a(this.f32620p0, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.AnimationTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m.e eVar = this.F0;
        if (eVar != null) {
            eVar.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.AnimationTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        if (TextUtils.isEmpty(getText())) {
            super.onDraw(canvas);
            return;
        }
        boolean z16 = true;
        if (!R() && !Q()) {
            ETFont eTFont = this.W;
            if (eTFont != null && eTFont.mFontId != 0 && eTFont.mFontType == 1 && ETEngine.getInstance().native_isColorVariantFont(this.W)) {
                setTextColor(ETEngine.getInstance().native_getTextColor(this.W));
            }
            try {
                super.onDraw(canvas);
                return;
            } catch (Exception e16) {
                QLog.e("ETTextView", 1, "onDraw failed of:" + ((Object) getText()), e16);
                return;
            }
        }
        if (R()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f32619o0) {
                Y(false, false);
            }
            j jVar = this.f32625u0;
            if (jVar != null) {
                SparseArray<Rect> b16 = jVar.b();
                this.f32626v0.setColor(highlightBackgroundColor());
                if (b16 != null) {
                    int size = b16.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        canvas.drawRect(b16.valueAt(i3), this.f32626v0);
                    }
                }
            }
            this.V.f32703d.setColor(getCurrentTextColor());
            synchronized (this.f32623s0) {
                Bitmap b17 = this.f32623s0.b();
                if (b17 != null && !b17.isRecycled()) {
                    int paddingLeft = getPaddingLeft();
                    int paddingTop = getPaddingTop();
                    if (this.J0 && this.f32624t0 != null) {
                        canvas.drawBitmap(b17, paddingLeft, paddingTop, (Paint) null);
                        if (this.f32624t0.getDecorationType() == 1) {
                            this.V.D(canvas, paddingLeft, paddingTop);
                        }
                    } else {
                        ETEngine eTEngine = ETEngine.getInstance();
                        ETDecoration eTDecoration = this.f32624t0;
                        if (eTDecoration == null || eTDecoration.isLastFrame()) {
                            z16 = false;
                        }
                        b17.eraseColor(0);
                        this.V.g(eTEngine, b17, this.f32624t0, z16);
                        this.V.h(canvas, paddingLeft, paddingTop, b17);
                        ETDecoration eTDecoration2 = this.f32624t0;
                        if (eTDecoration2 != null && (rect = eTDecoration2.mMargins) != null) {
                            paddingLeft += rect.left;
                            paddingTop += rect.top;
                        }
                        this.V.D(canvas, paddingLeft, paddingTop);
                    }
                    this.V.E(canvas, paddingLeft, paddingTop);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            ETFont eTFont2 = this.W;
            n.a("action_draw", eTFont2.mFontId, eTFont2.mFontType, getText().length(), currentTimeMillis2 - currentTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i16) {
        boolean z16;
        boolean z17;
        int i17;
        Rect rect;
        ETFont eTFont;
        if (TextUtils.isEmpty(getText())) {
            super.onMeasure(i3, i16);
            return;
        }
        try {
            if (!M()) {
                super.onMeasure(i3, i16);
                return;
            }
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            com.etrump.mixlayout.e eVar = this.V;
            Rect rect2 = null;
            if (eVar == null || eVar.f32701b != this.f32609e0 || (((eTFont = this.W) != null && !eTFont.equals(eVar.f32703d)) || !this.f32630z0 || this.V.f32715p != this.f32616l0)) {
                this.J0 = false;
                com.etrump.mixlayout.e eVar2 = new com.etrump.mixlayout.e();
                this.V = eVar2;
                this.f32625u0 = new j(this, eVar2);
                ETDecoration eTDecoration = this.f32624t0;
                if (eTDecoration != null) {
                    eTDecoration.deleteDescriptor();
                    this.f32624t0 = null;
                }
                int defaultColor = getLinkTextColors().getDefaultColor();
                ETFont eTFont2 = this.W;
                if (eTFont2 != null) {
                    eTFont2.setColor(getCurrentTextColor());
                    this.W.setSize(getTextSize());
                    if ((getPaint().getFlags() & 32) > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.W.setBold(z16);
                    float f16 = this.f32610f0;
                    if (f16 > 0.0f) {
                        this.W.setShadow(true, this.f32613i0, (int) this.f32611g0, (int) this.f32612h0, (int) f16);
                    } else {
                        this.W.setShadow(false, 0, 0, 0, 0);
                    }
                    ETEngine eTEngine = ETEngine.getInstance();
                    Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
                    float f17 = (fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading;
                    com.etrump.mixlayout.e eVar3 = this.V;
                    eVar3.f32700a = (int) f17;
                    eVar3.f32701b = this.f32609e0;
                    eVar3.f32715p = this.f32616l0;
                    eVar3.z(this.f32608d0);
                    ETFont eTFont3 = this.W;
                    ETFont eTFont4 = new ETFont(eTFont3.mFontId, eTFont3.mFontPath, getTextSize());
                    eTFont4.copy(this.W);
                    int i18 = this.f32605a0;
                    if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                        i18 = Math.min(i18, size);
                    }
                    int paddingLeft = i18 - (getPaddingLeft() + getPaddingRight());
                    if (mode == Integer.MIN_VALUE) {
                        paddingLeft = Math.min(size, paddingLeft);
                    }
                    if (this.V.f32715p) {
                        float f18 = FontManagerConstants.magicFontNormalSize1;
                        if (FontSettingManager.getFontLevel() == 18.0f) {
                            f18 = FontManagerConstants.magicFontMaxSize1;
                        }
                        eTFont4.setSize(f18 * getTextSize());
                    }
                    int native_getHorizontalMarginThreshold = eTEngine.native_getHorizontalMarginThreshold(eTFont4, paddingLeft);
                    eTFont4.setSize(getTextSize());
                    if (native_getHorizontalMarginThreshold > 0 && native_getHorizontalMarginThreshold < paddingLeft) {
                        z17 = this.V.y(eTEngine, paddingLeft - native_getHorizontalMarginThreshold, getText(), eTFont4, defaultColor, true, paddingLeft);
                        this.f32624t0 = this.V.e(eTEngine, true);
                    } else {
                        z17 = false;
                    }
                    if (this.f32624t0 == null) {
                        z17 = this.V.y(eTEngine, paddingLeft, getText(), eTFont4, defaultColor, false, paddingLeft);
                        this.f32624t0 = this.V.e(eTEngine, true);
                    }
                    if (!z17) {
                        this.W.mFontId = 0;
                        this.V.f32701b = -1L;
                        super.onMeasure(i3, i16);
                        return;
                    }
                    com.etrump.mixlayout.e eVar4 = this.V;
                    int i19 = eVar4.f32709j;
                    if (i19 < 2048 && (i17 = eVar4.f32710k) < 2048) {
                        if (!eVar4.f32714o) {
                            ETDecoration eTDecoration2 = this.f32624t0;
                            if (eTDecoration2 != null) {
                                rect = eTDecoration2.mMargins;
                                i19 += rect.left + rect.right;
                                i17 += rect.top + rect.bottom;
                            } else {
                                rect = null;
                            }
                            this.f32623s0.c(i19, i17);
                            rect2 = rect;
                        } else {
                            throw new Exception("no text use system measure2");
                        }
                    } else {
                        throw new Exception("large bitmap width=0, height=0");
                    }
                } else {
                    return;
                }
            }
            ETDecoration eTDecoration3 = this.f32624t0;
            if (eTDecoration3 != null) {
                rect2 = eTDecoration3.mMargins;
            }
            if (mode != 1073741824) {
                size = this.V.f32709j + getPaddingLeft() + getPaddingRight();
                if (rect2 != null) {
                    size += rect2.left + rect2.right;
                }
            }
            int min = Math.min(size, this.f32605a0);
            if (mode2 != 1073741824) {
                int paddingTop = this.V.f32710k + getPaddingTop() + getPaddingBottom();
                if (rect2 != null) {
                    paddingTop += rect2.top + rect2.bottom;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    size2 = Math.min(paddingTop, size2);
                } else {
                    size2 = paddingTop;
                }
            }
            setMeasuredDimension(Math.max(min, this.f32606b0), Math.max(size2, this.f32607c0));
        } catch (Throwable th5) {
            QLog.e("ETTextView", 1, "measure fail ", th5);
            th5.printStackTrace();
            this.W.mFontId = 0;
            this.V.f32701b = -1L;
            if (!K0 && th5.getMessage().contains("textlayout")) {
                K0 = true;
            }
            super.onMeasure(i3, i16);
        }
    }

    @Override // android.widget.TextView, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (!R() && !Q()) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            return super.onPreDraw();
        }
        getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        super.onTextChanged(charSequence, i3, i16, i17);
        this.f32627w0 = null;
    }

    @Override // com.tencent.mobileqq.widget.AnimationTextView, com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!R() && !Q()) {
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCacheMeasureResult(boolean z16) {
        if (this.f32630z0 != z16) {
            this.f32630z0 = z16;
            requestLayout();
        }
    }

    public void setDefaultFont(Typeface typeface, long j3) {
        setTypeface(typeface);
        if (VasShieldFont.f32669b == 4) {
            ETFont eTFont = this.W;
            if (eTFont == null) {
                this.W = new ETFont(9999, VasShieldFont.n(), getTextSize());
            } else {
                eTFont.mFontId = 9999;
                eTFont.setPath(VasShieldFont.n());
                this.W.setSize(getTextSize());
            }
            this.f32609e0 = j3;
            this.W.mFontType = -1;
        } else {
            this.W = null;
        }
        d dVar = this.f32629y0;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    public void setFont(ETFont eTFont, ChatMessage chatMessage, SessionInfo sessionInfo) {
        CharSequence charSequence;
        if (eTFont.mText == null && (chatMessage instanceof MessageForText)) {
            MessageForText messageForText = (MessageForText) chatMessage;
            if (TextUtils.isEmpty(messageForText.charStr)) {
                charSequence = null;
            } else if (!TextUtils.isEmpty(messageForText.charStr2)) {
                charSequence = messageForText.charStr2;
            } else {
                charSequence = messageForText.charStr;
            }
            eTFont.mText = charSequence;
        }
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("vip_sub_font_id");
        W(eTFont, chatMessage.uniseq, !TextUtils.isEmpty(extInfoFromExtStr) ? Integer.parseInt(extInfoFromExtStr) : 0);
        this.f32620p0 = chatMessage;
        this.f32621q0 = sessionInfo;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IETextView
    public void setIsFounderAnimating(boolean z16) {
        this.G0 = z16;
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i3) {
        this.f32605a0 = i3;
        super.setMaxWidth(i3);
    }

    @Override // android.widget.TextView
    public void setMinHeight(int i3) {
        this.f32607c0 = i3;
        super.setMinHeight(i3);
    }

    @Override // android.widget.TextView
    public void setMinWidth(int i3) {
        this.f32606b0 = i3;
        super.setMinWidth(i3);
    }

    public void setOnTextOrFontChangeListener(d dVar) {
        this.f32629y0 = dVar;
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f16, float f17, float f18, int i3) {
        super.setShadowLayer(f16, f17, f18, i3);
        this.f32610f0 = f16;
        this.f32611g0 = f17;
        this.f32612h0 = f18;
        this.f32613i0 = i3;
    }

    @Override // com.tencent.mobileqq.widget.AnimationTextView, com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        d dVar = this.f32629y0;
        if (dVar != null) {
            dVar.a(this, charSequence);
        }
        super.setText(charSequence, bufferType);
    }

    public void setTextAnimationListener(e eVar) {
        this.f32622r0 = eVar;
    }

    public final void setTextMsg(CharSequence charSequence) {
        String str;
        if (getText() != null) {
            str = getText().toString();
        } else {
            str = "";
        }
        if (charSequence != null && !charSequence.toString().equals(str)) {
            setText(charSequence);
            this.f32609e0 = System.currentTimeMillis();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        if (typeface == null) {
            try {
                typeface = Typeface.DEFAULT;
            } catch (Exception e16) {
                QLog.e("ETTextView", 1, "fail to setTypeface", e16);
                return;
            }
        }
        super.setTypeface(typeface);
    }

    public void setFont(ETFont eTFont, long j3) {
        W(eTFont, j3, 0);
    }

    public void setFont(int i3, long j3) {
        ETFont eTFont = this.W;
        if (eTFont == null) {
            this.W = new ETFont(i3, "", getTextSize());
        } else {
            eTFont.mFontId = i3;
        }
        if (this.W.mFontId == 0) {
            setTypeface(null);
        }
        if (this.f32609e0 != j3) {
            this.A0 = false;
        }
        this.f32609e0 = j3;
    }

    public ETTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32605a0 = Integer.MAX_VALUE;
        this.f32610f0 = 0.0f;
        this.f32611g0 = 0.0f;
        this.f32612h0 = 0.0f;
        this.f32613i0 = 0;
        this.f32614j0 = -1;
        this.f32615k0 = -1;
        this.f32616l0 = false;
        this.f32617m0 = false;
        this.f32618n0 = false;
        this.f32619o0 = false;
        this.f32623s0 = new a();
        this.f32625u0 = null;
        this.f32628x0 = new int[4];
        this.f32630z0 = true;
        this.A0 = false;
        this.B0 = false;
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = new Runnable() { // from class: com.etrump.mixlayout.ETTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ETTextView.this.getTag(R.id.dbm) != null) {
                    ((Boolean) ETTextView.this.getTag(R.id.dbm)).booleanValue();
                }
                ETTextView eTTextView = ETTextView.this;
                if (eTTextView.R) {
                    eTTextView.getClass();
                }
                ETTextView.this.setTag(R.id.dbm, Boolean.FALSE);
            }
        };
        this.G0 = false;
        this.H0 = false;
        this.I0 = false;
        this.J0 = false;
        O();
        N();
    }

    public ETTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f32605a0 = Integer.MAX_VALUE;
        this.f32610f0 = 0.0f;
        this.f32611g0 = 0.0f;
        this.f32612h0 = 0.0f;
        this.f32613i0 = 0;
        this.f32614j0 = -1;
        this.f32615k0 = -1;
        this.f32616l0 = false;
        this.f32617m0 = false;
        this.f32618n0 = false;
        this.f32619o0 = false;
        this.f32623s0 = new a();
        this.f32625u0 = null;
        this.f32628x0 = new int[4];
        this.f32630z0 = true;
        this.A0 = false;
        this.B0 = false;
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = new Runnable() { // from class: com.etrump.mixlayout.ETTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ETTextView.this.getTag(R.id.dbm) != null) {
                    ((Boolean) ETTextView.this.getTag(R.id.dbm)).booleanValue();
                }
                ETTextView eTTextView = ETTextView.this;
                if (eTTextView.R) {
                    eTTextView.getClass();
                }
                ETTextView.this.setTag(R.id.dbm, Boolean.FALSE);
            }
        };
        this.G0 = false;
        this.H0 = false;
        this.I0 = false;
        this.J0 = false;
        O();
        N();
    }
}
