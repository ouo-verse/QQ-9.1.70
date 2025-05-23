package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.effect.toolbar.newversion.FilterToolbar;
import com.tencent.av.ui.m;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.af;
import com.tencent.av.utils.ba;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mw.k;

/* loaded from: classes32.dex */
public class AVToolBarPart extends Part implements mw.j {
    public static boolean S = false;
    static int T = -1;
    private c L;
    private QavPanel.o M;
    private int N;
    k P;

    /* renamed from: i, reason: collision with root package name */
    private View f76240i;

    /* renamed from: d, reason: collision with root package name */
    public QavPanel f76236d = null;

    /* renamed from: e, reason: collision with root package name */
    boolean f76237e = true;

    /* renamed from: f, reason: collision with root package name */
    Animation f76238f = null;

    /* renamed from: h, reason: collision with root package name */
    Animation f76239h = null;

    /* renamed from: m, reason: collision with root package name */
    d f76241m = null;
    d C = null;
    View D = null;
    RelativeLayout E = null;
    private RelativeLayout F = null;
    private boolean G = false;
    private boolean H = false;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    ToolbarAnimationRunnable Q = new ToolbarAnimationRunnable();
    Runnable R = new Runnable() { // from class: com.tencent.av.ui.part.base.AVToolBarPart.3
        @Override // java.lang.Runnable
        public void run() {
            if (AVToolBarPart.this.getActivity().isDestroyed()) {
                QLog.e("AVToolBarPart", 1, "Activity is destroyed.");
                return;
            }
            if (AVToolBarPart.this.f76237e) {
                if (QLog.isDevelopLevel()) {
                    QLog.w("AVToolBarPart", 1, "HideToolbarRunnable");
                }
                if (com.tencent.av.utils.e.e(1) == 1) {
                    com.tencent.av.utils.e.x(HardCodeUtil.qqStr(R.string.f172880v05));
                } else {
                    if (AppSetting.f99565y) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AVToolBarPart", 2, "enable talk back now, do not hide toolbar");
                            return;
                        }
                        return;
                    }
                    AVToolBarPart.this.ha(0);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ToolbarAnimationRunnable implements Runnable {
        ToolbarAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            nw.b.b().k0(new Object[]{102});
            if (AVToolBarPart.this.G) {
                AVToolBarPart aVToolBarPart = AVToolBarPart.this;
                if (aVToolBarPart.f76237e) {
                    aVToolBarPart.J++;
                } else {
                    aVToolBarPart.J--;
                }
                if (AVToolBarPart.this.J > 5) {
                    AVToolBarPart.this.J = 5;
                }
                if (AVToolBarPart.this.J < 0) {
                    AVToolBarPart.this.J = 0;
                }
                AVToolBarPart.this.getMainHandler().postDelayed(this, AVToolBarPart.this.I);
            }
        }
    }

    /* loaded from: classes32.dex */
    class a implements QavPanel.o {
        a() {
        }

        @Override // com.tencent.av.ui.QavPanel.o
        public void a(boolean z16, boolean z17) {
            AVToolBarPart.this.P.a(z16, z17);
        }

        @Override // com.tencent.av.ui.QavPanel.o
        public void b() {
            AVToolBarPart.this.resetToolBarTimer(com.tencent.av.utils.e.d());
        }

        @Override // com.tencent.av.ui.QavPanel.o
        public long c() {
            return AVToolBarPart.this.P.k();
        }

        @Override // com.tencent.av.ui.QavPanel.o
        public boolean d() {
            return true;
        }

        @Override // com.tencent.av.ui.QavPanel.o
        public boolean e() {
            return AVToolBarPart.this.M9();
        }
    }

    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DataReport.P(view.getId());
            AVActivity aVActivity = (AVActivity) AVToolBarPart.this.getActivity();
            if (aVActivity != null) {
                aVActivity.BtnOnClick(view);
            }
        }
    }

    /* loaded from: classes32.dex */
    static class c implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<AVToolBarPart> f76245d;

        c(AVToolBarPart aVToolBarPart) {
            this.f76245d = new WeakReference<>(aVToolBarPart);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AVToolBarPart aVToolBarPart = this.f76245d.get();
            if (aVToolBarPart == null || motionEvent.getAction() != 1) {
                return false;
            }
            aVToolBarPart.resetToolBarTimer(0L);
            return false;
        }
    }

    public AVToolBarPart(int i3) {
        this.N = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L9() {
        AVActivity aVActivity;
        VideoLayerUI videoLayerUI;
        return n.e().f() == null || (aVActivity = (AVActivity) getActivity()) == null || (videoLayerUI = aVActivity.J0) == null || videoLayerUI.g2() == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        if (r1.equals("m9") != false) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static boolean R9() {
        int i3;
        int i16;
        if (T == -1) {
            if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                T = 0;
            } else {
                try {
                    i3 = ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
                } catch (Exception e16) {
                    QLog.d("AVToolBarPart", 1, "hasSmartBar error : " + e16);
                    i3 = 0;
                }
                String str = Build.DEVICE;
                if (str.equals("mx2")) {
                    i16 = 1;
                } else {
                    if (!str.equals("mx")) {
                        i16 = i3;
                    }
                    i16 = 0;
                }
                T = i16;
            }
        }
        return T == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U9(View view) {
        if (getActivity().isFinishing()) {
            return;
        }
        ((mw.c) RFWIocAbilityProvider.g().getIocInterface(mw.c.class, getPartRootView(), null)).g2(0, view, R.string.f17863377, 3);
    }

    private int V9() {
        if ((this.G || this.f76237e) ? false : true) {
            return W9();
        }
        return X9();
    }

    private int W9() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.a1y);
    }

    private int X9() {
        QavPanel qavPanel = this.f76236d;
        if (qavPanel == null) {
            return 0;
        }
        RelativeLayout N = qavPanel.N(99);
        if (N != null) {
            N.measure(0, 0);
            return N.getMeasuredHeight();
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.f76236d.findViewById(m.l.f76056b);
        if (relativeLayout == null) {
            return 0;
        }
        relativeLayout.measure(0, 0);
        return relativeLayout.getMeasuredHeight();
    }

    private void ba(boolean z16, boolean z17) {
        Window window;
        String str;
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || (window = aVActivity.getWindow()) == null) {
            return;
        }
        boolean z18 = z16 && z17;
        if (!z18) {
            try {
                View findViewById = aVActivity.findViewById(R.id.f166564cp2);
                if (findViewById != null && findViewById.isShown()) {
                    z18 = true;
                }
                if (S) {
                    z18 = true;
                }
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.w(ImmersiveUtils.TAG, 1, "setSystemStatusBar, Exception", e16);
                    return;
                }
                return;
            }
        }
        if (z18) {
            window.setFlags(2048, 1024);
        } else {
            window.addFlags(1024);
        }
        if (QLog.isDevelopLevel()) {
            String str2 = ImmersiveUtils.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setSystemStatusBar, ");
            if (z18) {
                str = "\u663e\u793a";
            } else {
                str = "\u9690\u85cf";
            }
            sb5.append(str);
            sb5.append("\u72b6\u6001\u680f, isToolBarDisplay[");
            sb5.append(z16);
            sb5.append("], recordNeedShowBar[");
            sb5.append(z17);
            sb5.append("], SystemUiVisibility[0x");
            sb5.append(Integer.toHexString(window.getDecorView().getSystemUiVisibility()));
            sb5.append("], flags[0x");
            sb5.append(Integer.toHexString(window.getAttributes().flags));
            sb5.append("]");
            QLog.w(str2, 1, sb5.toString());
        }
    }

    public boolean M9() {
        int i3 = this.N;
        if (i3 == 3 || i3 == 100) {
            return true;
        }
        if (r.h0() == null) {
            return false;
        }
        SessionInfo f16 = n.e().f();
        boolean v3 = af.v();
        boolean z16 = (f16.f73037i1 || f16.f73041j1) ? false : true;
        if (QLog.isColorLevel()) {
            QLog.w("AVToolBarPart", 1, "canStopMuteStatus, isAllowedControlMicAfterBeMuted[" + v3 + "], isNormalUser[" + z16 + "], isRoomMicOff[" + f16.W0 + "], micAuthByAdmin[" + f16.X0 + "], mIsPhoneCalling[" + n.e().f().f73071r + "]");
        }
        if (z16 && f16.W0 && f16.X0 != 0) {
            return false;
        }
        if (!v3 && z16 && f16.X0 == 1) {
            return false;
        }
        return !n.e().f().f73071r;
    }

    public void N9() {
        final long d16 = com.tencent.av.utils.e.d();
        if (n.e().f().f73048l0) {
            n.e().f().f73048l0 = false;
            nw.b.b().k0(new Object[]{167, Boolean.FALSE});
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.base.AVToolBarPart.4
                @Override // java.lang.Runnable
                public void run() {
                    AVToolBarPart aVToolBarPart = AVToolBarPart.this;
                    if (aVToolBarPart.f76237e || !aVToolBarPart.L9()) {
                        return;
                    }
                    AVToolBarPart.this.ha(0);
                    AVToolBarPart.this.resetToolBarTimer(d16);
                }
            }, 300L);
        }
    }

    public int O9() {
        if (this.f76240i == null || this.f76236d == null) {
            return 0;
        }
        int V9 = V9();
        Resources resources = getContext().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.b1v);
        if (this.G) {
            int max = (V9 / 5) * Math.max(this.J, 0);
            if (max <= V9) {
                V9 = max <= 0 ? W9() : max;
            }
        } else if (this.f76237e && getContext() != null && ba.getScreenWidth(getContext()) <= 320) {
            V9 = resources.getDimensionPixelSize(R.dimen.a1t) + dimensionPixelSize;
        }
        return R9() ? V9 + resources.getDimensionPixelSize(R.dimen.a9i) : V9;
    }

    public int Q9(long j3) {
        int i3 = 0;
        if (this.f76240i == null || this.E == null) {
            return 0;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.b2c);
        if (this.f76237e) {
            i3 = this.P.getSystemBarHeight() + (this.G ? (dimensionPixelSize / 5) * Math.max(this.J, 0) : dimensionPixelSize);
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("AVToolBarPart", 1, "getTopToolbarHeight, topToolbarHeight[" + i3 + "], margin[" + dimensionPixelSize + "], mInToolBarAnimation[" + this.G + "], mToolbarDisplayFrameNow[" + this.J + "], seq[" + j3 + "]");
        }
        return i3;
    }

    public void S9(String str) {
        QLog.w("AVToolBarPart", 1, "hideToolBar[" + str + "], isToolBarDisplay[" + isToolBarDisplay() + "], mToolbarDisplay[" + this.f76237e + "]");
        if (this.f76237e) {
            ha(0);
        }
        getMainHandler().removeCallbacks(this.R);
    }

    public boolean T9() {
        return this.f76237e;
    }

    public void Z9() {
        ba(isToolBarDisplay(), true);
    }

    public void ca(boolean z16) {
        ba(isToolBarDisplay(), z16);
    }

    @Override // mw.j
    public void childLock() {
        if (n.e().f().f73048l0) {
            return;
        }
        n.e().f().f73048l0 = true;
        if (this.f76237e) {
            ha(0);
        }
        nw.b.b().k0(new Object[]{167, Boolean.TRUE});
    }

    public void da(boolean z16) {
        if (this.f76237e != z16) {
            this.f76237e = z16;
        }
    }

    @Override // mw.j
    public void displayToolBar() {
        if (QLog.isColorLevel()) {
            QLog.w("AVToolBarPart", 1, "displayToolBar, isToolBarDisplay[" + isToolBarDisplay() + "]");
        }
        if (!isToolBarDisplay()) {
            da(false);
            ha(0);
        }
        getMainHandler().removeCallbacks(this.R);
    }

    public void ea() {
        final View h16;
        QavPanel qavPanel = this.f76236d;
        if (qavPanel == null || (h16 = qavPanel.h1(m.l.H)) == null || h16.getVisibility() != 0) {
            return;
        }
        if (!this.G && this.f76237e) {
            this.H = false;
            h16.post(new Runnable() { // from class: com.tencent.av.ui.part.base.j
                @Override // java.lang.Runnable
                public final void run() {
                    AVToolBarPart.this.U9(h16);
                }
            });
        } else {
            this.H = true;
        }
    }

    public void ga(int i3) {
        long d16 = com.tencent.av.utils.e.d();
        int i16 = this.N;
        if (i16 == 3) {
            if (n.e().f().f73035i == 2 && !n.e().f().z()) {
                if (this.f76237e) {
                    return;
                }
                ha(i3);
                return;
            } else {
                ha(i3);
                resetToolBarTimer(d16);
                return;
            }
        }
        if (i16 == 100 || i16 == 1 || i16 == 2) {
            if (QLog.isColorLevel()) {
                QLog.w("AVToolBarPart", 1, "showToolBars, isAllOnstageMembersNotRecvData[" + n.e().f().t() + "], mToolbarDisplay[" + this.f76237e + "], session[" + n.e().f() + "], seq[" + d16 + "]");
            }
            if (n.e().f().t()) {
                return;
            }
            ha(i3);
            resetToolBarTimer(d16);
        }
    }

    public void ha(int i3) {
        QavPanel qavPanel = this.f76236d;
        if (qavPanel == null || !qavPanel.isPressed()) {
            if (r.h0() == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("AVToolBarPart", 2, "switchToolBar-->VideoController.getInstance() is null, Why???");
                    return;
                }
                return;
            }
            SessionInfo f16 = n.e().f();
            if ((f16.f73067q == 9500 && r.h0().c1()) || this.P.d()) {
                return;
            }
            if (f16.z() || f16.f73035i != 2) {
                if (((AVActivity) getActivity()).isInFoldingMode() && this.f76237e) {
                    return;
                }
                boolean z16 = this.f76237e;
                if (this.f76240i == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AVToolBarPart", 2, "switchToolBar-->mRootView is null Why");
                        return;
                    }
                    return;
                }
                if (!f16.f73098x2 && !f16.f73102y2) {
                    if (!f16.N && !f16.O && !f16.f73060o0) {
                        da(true);
                    } else {
                        int i16 = f16.f73035i;
                        if (i16 == 1) {
                            da(true);
                        } else if (i16 == 3 && !f16.f73060o0) {
                            da(true);
                        } else {
                            da(!z16);
                        }
                    }
                } else if (f16.z()) {
                    da(!this.f76237e);
                } else {
                    da(true);
                }
                QLog.w("AVToolBarPart", 1, "switchToolBar, ToolbarDisplay[" + z16 + "->" + this.f76237e + "], type[" + i3 + "]");
                SmallScreenUtils.m();
                if (this.f76237e) {
                    if (this.f76236d != null) {
                        if (QLog.isColorLevel()) {
                            QLog.e("AVToolBarPart", 2, "WL_DEBUG switchToolBar mQavPanel.isShown()[" + this.f76236d.isShown() + "], mTopToolbar.isShown()[" + this.E.isShown() + "]");
                        }
                        if (this.f76236d.isShown() && this.E.isShown()) {
                            return;
                        }
                    }
                    QavPanel qavPanel2 = this.f76236d;
                    if (qavPanel2 != null) {
                        qavPanel2.setVisibility(0);
                    }
                    this.E.setVisibility(0);
                    this.F.setVisibility(8);
                    this.K++;
                    if (QLog.isColorLevel()) {
                        QLog.d("AVToolBarPart", 2, "WL_DEBUG switchToolBar type=" + i3 + ", toolbarShowTimes: " + this.K);
                    }
                    if (i3 == 1) {
                        this.f76238f = P9(true);
                        this.f76239h = P9(true);
                    } else {
                        this.f76238f = AnimationUtils.loadAnimation(getContext(), R.anim.f154827d1);
                        this.f76239h = AnimationUtils.loadAnimation(getContext(), R.anim.f154852e1);
                    }
                } else if (i3 == 1) {
                    this.f76238f = P9(false);
                    this.f76239h = P9(false);
                } else {
                    this.f76238f = AnimationUtils.loadAnimation(getContext(), R.anim.f154826d0);
                    this.f76239h = AnimationUtils.loadAnimation(getContext(), R.anim.f154851e0);
                }
                this.P.p();
                if (this.f76241m == null) {
                    this.f76241m = new d(2);
                }
                if (this.C == null) {
                    this.C = new d(1);
                }
                this.f76238f.setAnimationListener(this.f76241m);
                this.f76239h.setAnimationListener(this.C);
                if (!AVCoreSystemInfo.isLowLevelDevice()) {
                    QavPanel qavPanel3 = this.f76236d;
                    if (qavPanel3 != null) {
                        qavPanel3.startAnimation(this.f76238f);
                    }
                    this.E.startAnimation(this.f76239h);
                    return;
                }
                VideoAppInterface b16 = nw.b.b();
                if (b16 != null) {
                    b16.k0(new Object[]{118, Boolean.valueOf(this.f76237e), Boolean.TRUE, 0L});
                }
                d dVar = this.f76241m;
                if (dVar != null) {
                    dVar.onAnimationEnd(null);
                }
                if (b16 != null) {
                    b16.k0(new Object[]{118, Boolean.valueOf(this.f76237e), Boolean.FALSE, 0L});
                }
            }
        }
    }

    @Override // mw.j
    public boolean isToolBarDisplay() {
        QavPanel qavPanel;
        RelativeLayout relativeLayout = this.E;
        return relativeLayout != null && relativeLayout.getVisibility() == 0 && (qavPanel = this.f76236d) != null && qavPanel.getVisibility() == 0;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        QavPanel qavPanel;
        super.onInitView(view);
        this.f76240i = view;
        this.P = (k) RFWIocAbilityProvider.g().getIocInterface(k.class, this.f76240i, null);
        this.E = (RelativeLayout) view.findViewById(m.d.f76006d);
        this.F = (RelativeLayout) view.getRootView().findViewById(m.d.f76007e);
        QavPanel qavPanel2 = (QavPanel) this.f76240i.findViewById(R.id.f166587gb4);
        this.f76236d = qavPanel2;
        if (qavPanel2 != null) {
            c cVar = new c(this);
            this.L = cVar;
            this.f76236d.setBtnOnTouchListener(cVar);
            a aVar = new a();
            this.M = aVar;
            this.f76236d.q(aVar);
            this.f76236d.setOperationMenuViewOnClickListener(new b());
        }
        int i3 = this.N;
        if (i3 == 3) {
            if (this.f76236d != null) {
                SessionInfo f16 = n.e().f();
                this.f76236d.h0(m.a.f75990a, f16.f73035i == 2, FilterToolbar.checkShowBeauty(nw.b.b()));
                if (f16.f73067q == 1044) {
                    this.f76236d.setNoVideoAndShareBtnMode();
                }
            }
        } else if (i3 == 1 || i3 == 2) {
            QavPanel qavPanel3 = this.f76236d;
            if (qavPanel3 != null) {
                if (i3 == 1) {
                    qavPanel3.g0(m.a.f75993d);
                } else {
                    qavPanel3.g0(m.a.f75992c);
                }
            }
        } else if (i3 == 100 && (qavPanel = this.f76236d) != null) {
            qavPanel.g0(m.a.f75991b);
        }
        RFWIocAbilityProvider.g().registerIoc(view, this, mw.j.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QavPanel qavPanel = this.f76236d;
        if (qavPanel != null) {
            qavPanel.B0(0L);
            this.f76236d = null;
        }
        this.f76238f = null;
        this.f76239h = null;
        this.f76241m = null;
        this.C = null;
        this.D = null;
        this.L = null;
        this.M = null;
        getMainHandler().removeCallbacks(this.Q);
        getMainHandler().removeCallbacks(this.R);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), mw.j.class);
    }

    public void onPause() {
        getMainHandler().removeCallbacks(this.R);
    }

    @Override // mw.j
    public void resetToolBarTimer(long j3) {
        String qqStr;
        if (getActivity().isDestroyed()) {
            return;
        }
        boolean isDevelopLevel = QLog.isDevelopLevel();
        SessionInfo f16 = n.e().f();
        int i3 = f16.f73035i;
        AVActivity aVActivity = (AVActivity) getActivity();
        nw.b.b();
        if (aVActivity != null && aVActivity.t3()) {
            getMainHandler().removeCallbacks(this.R);
            if (isDevelopLevel) {
                qqStr = "isKeepToolBar";
            }
            qqStr = "";
        } else {
            if (i3 != 2 && i3 != 4 && (i3 != 1 || (!f16.f73098x2 && !f16.f73102y2))) {
                if ((i3 == 1 || i3 == 3) && !f16.f73098x2 && !f16.f73102y2) {
                    getMainHandler().removeCallbacks(this.R);
                    if (!this.f76237e) {
                        ha(0);
                    }
                }
            } else {
                getMainHandler().removeCallbacks(this.R);
                if (this.f76237e) {
                    if (i3 != 2 || f16.z()) {
                        if (i3 != 4 || !f16.t()) {
                            QavPanel qavPanel = this.f76236d;
                            if (qavPanel != null && qavPanel.M0 != 5 && j3 != -1056) {
                                getMainHandler().postDelayed(this.R, 6000L);
                            }
                            if (isDevelopLevel) {
                                qqStr = HardCodeUtil.qqStr(R.string.f172878v03);
                            }
                        } else if (isDevelopLevel) {
                            qqStr = "not Recv Data";
                        }
                    } else if (isDevelopLevel) {
                        qqStr = "not Connected";
                    }
                }
            }
            qqStr = "";
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("AVToolBarPart", 4, "resetToolBarTimer, mToolbarDisplay[" + this.f76237e + "], SessionType[" + i3 + "], log[" + qqStr + "], seq[" + j3 + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(boolean z16) {
        ba(z16, true);
    }

    public void Y9() {
        QavPanel qavPanel;
        this.H = false;
        if (!SmallScreenUtils.w() || (qavPanel = this.f76236d) == null) {
            return;
        }
        qavPanel.setViewEnable(m.l.f76060f, false);
        this.f76236d.setViewEnable(m.l.f76059e, false);
        this.f76236d.setViewEnable(m.l.f76080z, false);
        this.f76236d.setViewEnable(m.l.O, false);
        this.f76236d.setViewEnable(m.l.P, false);
    }

    public AlphaAnimation P9(boolean z16) {
        AlphaAnimation alphaAnimation;
        if (z16) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setStartOffset(0L);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        int f76246d;

        d(int i3) {
            this.f76246d = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            int i3;
            long d16 = com.tencent.av.utils.e.d();
            VideoAppInterface b16 = nw.b.b();
            AVToolBarPart.this.getMainHandler().removeCallbacks(AVToolBarPart.this.Q);
            if (b16 != null && animation != null && 2 == this.f76246d) {
                b16.k0(new Object[]{118, Boolean.valueOf(AVToolBarPart.this.f76237e), Boolean.FALSE, Long.valueOf(animation.getDuration())});
            }
            QLog.w("AVToolBarPart", 1, "onAnimationEnd, mToolBarType[" + this.f76246d + "], animation[" + animation + "], mToolbarDisplay[" + AVToolBarPart.this.f76237e + "], seq[" + d16 + "]");
            AVToolBarPart aVToolBarPart = AVToolBarPart.this;
            if (!aVToolBarPart.f76237e) {
                RelativeLayout relativeLayout = aVToolBarPart.E;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(4);
                }
                if (AVToolBarPart.this.F != null) {
                    AVToolBarPart.this.F.setVisibility(0);
                }
                QavPanel qavPanel = AVToolBarPart.this.f76236d;
                if (qavPanel != null) {
                    qavPanel.setVisibility(4);
                }
                AVToolBarPart.this.f76240i.setBackgroundColor(0);
                AVToolBarPart.this.J = 0;
                if (r.h0() != null && (((i3 = n.e().f().S0) == 2 || i3 == 1) && !n.e().f().t())) {
                    AVToolBarPart.this.P.c(d16, 360 - AVToolBarPart.this.P.b());
                }
            } else {
                RelativeLayout relativeLayout2 = aVToolBarPart.E;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                }
                if (AVToolBarPart.this.F != null) {
                    AVToolBarPart.this.F.setVisibility(8);
                }
                QavPanel qavPanel2 = AVToolBarPart.this.f76236d;
                if (qavPanel2 != null) {
                    qavPanel2.setVisibility(0);
                    AVToolBarPart.this.f76236d.setAlpha(1.0f);
                }
                if (AVToolBarPart.this.D != null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AVToolBarPart", 2, "onAnimationEnd, change member list ui to visible");
                    }
                    AVToolBarPart.this.D.setVisibility(0);
                }
                AVToolBarPart.this.aa(true);
                AVToolBarPart.this.J = 5;
                if (r.h0() != null) {
                    SessionInfo f16 = n.e().f();
                    int i16 = f16.S0;
                    if (i16 == 2 || i16 == 1) {
                        AVToolBarPart.this.P.c(d16, 0.0f);
                    }
                    if (AVToolBarPart.this.H && f16.f73102y2) {
                        AVToolBarPart.this.H = false;
                        AVToolBarPart.this.ea();
                    }
                }
            }
            AVToolBarPart.this.G = false;
            if (b16 != null) {
                b16.k0(new Object[]{102});
            }
            ((k) RFWIocAbilityProvider.g().getIocInterface(k.class, AVToolBarPart.this.f76240i, null)).p();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AVToolBarPart.this.G = true;
            VideoAppInterface b16 = nw.b.b();
            if (b16 != null && animation != null && 2 == this.f76246d) {
                b16.k0(new Object[]{118, Boolean.valueOf(AVToolBarPart.this.f76237e), Boolean.TRUE, Long.valueOf(animation.getDuration())});
            }
            QLog.w("AVToolBarPart", 1, "[" + this.f76246d + "]onAnimationStart[" + animation + "]");
            AVToolBarPart aVToolBarPart = AVToolBarPart.this;
            aVToolBarPart.I = (int) (aVToolBarPart.f76238f.getDuration() / 5);
            AVToolBarPart aVToolBarPart2 = AVToolBarPart.this;
            if (aVToolBarPart2.f76237e) {
                aVToolBarPart2.J = 0;
            } else {
                aVToolBarPart2.J = 5;
                AVToolBarPart.this.aa(false);
            }
            AVToolBarPart.this.getMainHandler().post(AVToolBarPart.this.Q);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
