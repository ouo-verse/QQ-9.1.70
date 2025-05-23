package lx1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import ap0.f;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.components.panel.at.ui.RobotAtPanelTouchController;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.qqui.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.VError;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import yo0.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends PopupWindow implements View.OnClickListener, b.a, AtPanelTouchController.a, AtPanelTouchController.b {
    private static final int P = QQGuildUIUtil.f(58.0f);
    private static final int Q = QQGuildUIUtil.f(44.0f);
    private static int R = QQGuildUIUtil.f(88.0f);
    private static final int S = QQGuildUIUtil.f(35.0f);
    private static final int T = QQGuildUIUtil.f(44.0f);
    private static final int U = QQGuildUIUtil.f(35.0f);
    private View C;
    private QQViewPager D;
    private final LayerDrawable E;
    private final Drawable F;
    private final Drawable G;
    private int H;
    private int I;
    private float J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f415721d;

    /* renamed from: e, reason: collision with root package name */
    private final yo0.b f415722e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnLayoutChangeListener f415723f;

    /* renamed from: h, reason: collision with root package name */
    private View f415724h;

    /* renamed from: i, reason: collision with root package name */
    private RobotAtPanelTouchController f415725i;

    /* renamed from: m, reason: collision with root package name */
    private View f415726m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (i26 != i16) {
                b.this.N(1, 0, -1);
            }
        }
    }

    b(Activity activity, View view, int i3, int i16) {
        super(view, i3, i16);
        this.H = -1;
        this.I = -1;
        this.J = 0.0f;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = 0;
        R = ImmersiveUtils.getStatusBarHeight(activity) + Q;
        this.f415722e = new yo0.b(activity);
        this.f415721d = activity;
        RobotAtPanelTouchController robotAtPanelTouchController = (RobotAtPanelTouchController) view;
        this.f415725i = robotAtPanelTouchController;
        this.C = robotAtPanelTouchController.findViewById(R.id.efs);
        LayerDrawable layerDrawable = (LayerDrawable) activity.getResources().getDrawable(R.drawable.gxe);
        this.G = layerDrawable.getDrawable(1);
        LayerDrawable layerDrawable2 = (LayerDrawable) layerDrawable.mutate();
        this.E = layerDrawable2;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.F = colorDrawable;
        layerDrawable2.setDrawableByLayerId(R.id.lp7, colorDrawable);
        setBackgroundDrawable(layerDrawable2);
    }

    private void A(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2) {
        if (this.H > 0 && this.I > 0) {
            View s16 = s();
            int i3 = layoutParams2.height;
            int i16 = this.I;
            if (i3 != i16) {
                layoutParams2.height = i16;
                s16.setLayoutParams(layoutParams2);
            }
            int i17 = layoutParams.height;
            int i18 = this.H;
            if (i17 != i18) {
                layoutParams.height = i18;
                this.D.setLayoutParams(layoutParams);
            }
            s16.setTranslationY(this.J);
        }
    }

    private void B(Activity activity, int i3) {
        boolean z16;
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.D.getWidth(), this.D.getHeight());
        }
        ViewGroup.LayoutParams layoutParams2 = s().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        }
        this.f415725i = (RobotAtPanelTouchController) getContentView();
        boolean z17 = true;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            A(layoutParams, layoutParams2);
        } else {
            z(layoutParams, layoutParams2);
        }
        int v3 = v(i3);
        if (v3 == 0) {
            this.f415725i.i(0, 500);
            this.L = false;
        } else if (v3 == 1) {
            this.f415725i.scrollTo(0, 0);
        }
        if (this.f415725i.j() != 1 || z16) {
            z17 = false;
        }
        p(z17);
        this.f415725i.setPadding(0, R, 0, 0);
        this.f415725i.setAtPanelTouchListener(this);
        this.f415725i.setCustomParam(this, false);
        this.f415725i.setMode(i3);
    }

    private void G(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    public static void H(PopupWindow popupWindow) {
        if (!AppSetting.f99565y) {
            return;
        }
        for (Method method : PopupWindow.class.getMethods()) {
            if (method.getName().equals("setTouchModal")) {
                try {
                    method.invoke(popupWindow, Boolean.FALSE);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    private void I(final View view, final float f16) {
        if (this.K) {
            view.setTranslationY(f16);
        } else {
            this.D.post(new Runnable() { // from class: lx1.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.y(view, f16);
                }
            });
        }
    }

    private static void J(View view, View.OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
        ((RelativeLayout) view.findViewById(R.id.f7625416)).setOnClickListener(onClickListener);
    }

    private void K(QQViewPager qQViewPager) {
        this.D = qQViewPager;
    }

    public static b h(Activity activity) {
        return i(activity, -1, -1);
    }

    public static b i(Activity activity, int i3, int i16) {
        b j3 = j(activity, i3, i16);
        n(j3);
        RobotAtPanelTouchController robotAtPanelTouchController = (RobotAtPanelTouchController) j3.getContentView();
        J(robotAtPanelTouchController, j3);
        o(robotAtPanelTouchController, j3);
        if (AppSetting.f99565y) {
            H(j3);
        }
        return j3;
    }

    private static b j(Activity activity, int i3, int i16) {
        RobotAtPanelTouchController robotAtPanelTouchController = (RobotAtPanelTouchController) LayoutInflater.from(activity).inflate(R.layout.f4v, (ViewGroup) null);
        robotAtPanelTouchController.setHeadView(robotAtPanelTouchController.findViewById(R.id.f7625416));
        return new b(activity, robotAtPanelTouchController, i3, i16);
    }

    private boolean k(View view) {
        int height = this.f415721d.getWindow().getDecorView().getHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (iArr[1] < (height * 3) / 4) {
            return true;
        }
        return false;
    }

    private int l(View view, int i3) {
        int max = Math.max(3, i3 + 1);
        int i16 = T;
        int i17 = max * i16;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i18 = (iArr[1] - R) - S;
        if (i18 < 0) {
            i18 = i16 * 5;
        }
        return Math.min(i17, i18);
    }

    private int m() {
        if (this.f415721d != null) {
            return (int) (r0.getWindow().getDecorView().getHeight() * 0.75d);
        }
        return 3000;
    }

    private static void n(b bVar) {
        bVar.setFocusable(false);
        bVar.setInputMethodMode(32);
        bVar.setInputMethodMode(1);
        bVar.setClippingEnabled(false);
        bVar.setOutsideTouchable(false);
    }

    private static void o(RobotAtPanelTouchController robotAtPanelTouchController, b bVar) {
        QQViewPager qQViewPager = (QQViewPager) robotAtPanelTouchController.findViewById(R.id.f7626417);
        qQViewPager.setOffscreenPageLimit(1);
        bVar.K(qQViewPager);
    }

    private void p(boolean z16) {
        if (z16 && !this.M) {
            this.M = true;
            ViewParent parent = getContentView().getRootView().getParent();
            try {
                try {
                    try {
                        Method declaredMethod = parent.getClass().getDeclaredMethod("doTraversal", new Class[0]);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(parent, new Object[0]);
                    } catch (IllegalAccessException e16) {
                        QLog.e("RobotAtDialog", 1, "doTraversalManually | " + e16.getMessage());
                    } catch (InvocationTargetException e17) {
                        QLog.e("RobotAtDialog", 1, "doTraversalManually | " + e17.getMessage());
                    }
                } catch (NoSuchMethodException e18) {
                    QLog.e("RobotAtDialog", 1, "doTraversalManually | " + e18.getMessage());
                }
            } finally {
                this.M = false;
            }
        }
    }

    private static int q(View view, int i3) {
        int height = view.getHeight();
        if (view.getHeight() < i3) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(view.getWidth(), -2);
            }
            layoutParams.height = i3;
            view.setLayoutParams(layoutParams);
            return i3;
        }
        return height;
    }

    private View.OnLayoutChangeListener r() {
        if (this.f415723f == null) {
            this.f415723f = new a();
        }
        return this.f415723f;
    }

    private View s() {
        if (this.f415726m == null) {
            this.f415726m = this.f415725i.getChildAt(0);
        }
        return this.f415726m;
    }

    private int t() {
        if (this.f415724h.getParent() == null) {
            return 0;
        }
        return ((View) this.f415724h.getParent()).getWidth();
    }

    private int u() {
        if (this.f415724h.getParent() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        ((View) this.f415724h.getParent()).getLocationInWindow(iArr);
        return iArr[0];
    }

    private int v(int i3) {
        int j3 = this.f415725i.j();
        if (i3 != 1) {
            return 1;
        }
        if (this.L) {
            return 0;
        }
        if (i3 != j3) {
            return 1;
        }
        return -1;
    }

    private static int w(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view, float f16) {
        view.setTranslationY(f16);
        this.K = true;
    }

    private void z(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2) {
        View s16 = s();
        if (layoutParams2.height != -1) {
            layoutParams2.height = -1;
            s16.setLayoutParams(layoutParams2);
        }
        if (layoutParams.height != -1) {
            layoutParams.height = -1;
            this.D.setLayoutParams(layoutParams);
        }
        s16.setTranslationY(0.0f);
    }

    public void C() {
        ViewGroup viewGroup = (ViewGroup) getContentView().findViewById(R.id.f7625416);
        Resources resources = this.f415721d.getResources();
        Resources.Theme theme = this.f415721d.getTheme();
        ViewCompat.setBackground(viewGroup, ResourcesCompat.getDrawable(resources, R.drawable.guild_popup_drag_window_titlebar_bg, theme));
        ViewCompat.setBackground((ViewGroup) getContentView().findViewById(R.id.f7626417), ResourcesCompat.getDrawable(resources, R.drawable.qui_common_bg_middle_light_bg, theme));
        setBackgroundDrawable(this.E);
    }

    public void D(View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.f767542i);
        viewGroup.setBackgroundResource(0);
        viewGroup.setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
    }

    public void E(View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.f768242p);
        viewGroup.setBackgroundResource(0);
        viewGroup.setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
        View findViewById = viewGroup.findViewById(R.id.yjf);
        findViewById.setBackgroundResource(0);
        findViewById.setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
    }

    public void F() {
        RobotAtPanelTouchController robotAtPanelTouchController = this.f415725i;
        if (robotAtPanelTouchController != null) {
            robotAtPanelTouchController.scrollTo(0, VError.ERROR_STICKER_CREATE_FAIL);
        }
    }

    public void L(View view) {
        QQViewPager qQViewPager = this.D;
        if (qQViewPager == null) {
            return;
        }
        qQViewPager.setAdapter(new mx1.a(view));
        this.D.getAdapter().notifyDataSetChanged();
    }

    public void M(int i3) {
        View view = this.C;
        if (view == null) {
            QLog.e("RobotAtDialog", 1, "showLoading mLoadingView == null ");
            return;
        }
        View findViewById = view.findViewById(R.id.loading);
        View findViewById2 = this.C.findViewById(R.id.ysq);
        View findViewById3 = this.C.findViewById(R.id.ysm);
        this.C.setVisibility(0);
        this.f415725i.setIsFixedView(true);
        QQViewPager qQViewPager = this.D;
        if (qQViewPager != null) {
            qQViewPager.setVisibility(8);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    findViewById.setVisibility(8);
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(0);
                    return;
                }
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        findViewById2.setVisibility(8);
        findViewById3.setVisibility(8);
    }

    public void N(int i3, int i16, int i17) {
        int statusBarHeight;
        int height;
        int i18;
        View view;
        if (yo0.b.D) {
            statusBarHeight = 0;
        } else {
            statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.f415721d);
        }
        int height2 = getHeight();
        View view2 = this.f415724h;
        if (view2 == null) {
            height = 0;
        } else {
            height = view2.getHeight();
        }
        int i19 = -1;
        if (i17 == -1 && (view = this.f415724h) != null) {
            i16 = this.f415724h.getHeight() + w(view);
            if (k(this.f415724h)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            i18 = u();
            i19 = t();
            statusBarHeight = 0;
        } else {
            i18 = 0;
        }
        int i26 = (i16 - height) + statusBarHeight;
        if (i26 != height2 || i19 != getWidth() || this.N != i18) {
            this.N = i18;
            update(i18, 0, i19, i26);
        }
        B(this.f415721d, i3);
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController.a
    public void a(boolean z16) {
        if (z16) {
            this.E.setDrawableByLayerId(R.id.lp7, this.G);
        } else {
            this.E.setDrawableByLayerId(R.id.lp7, this.F);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RobotAtDialog", 2, "scrollMoving up: " + z16);
        }
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController.a
    public void b(int i3) {
        dismiss();
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController.b
    public boolean c() {
        return true;
    }

    @Override // yo0.b.a
    public void d(int i3, int i16, int i17) {
        e(i3, i16, -1);
    }

    @Override // android.widget.PopupWindow
    @TargetApi(16)
    public void dismiss() {
        View view;
        this.f415722e.e();
        this.f415722e.g(null);
        View.OnLayoutChangeListener onLayoutChangeListener = this.f415723f;
        if (onLayoutChangeListener != null && (view = this.f415724h) != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.f415724h = null;
        this.K = false;
        this.f415725i.setIsFixedView(false);
        f.firstSpanEnd = -1;
        f.isSlashListeningBlocked = false;
        super.dismiss();
    }

    @Override // yo0.b.a
    public void e(int i3, int i16, int i17) {
        if (i3 == 2 && this.C.getVisibility() == 0) {
            dismiss();
        } else {
            N(i3, i16, -1);
        }
    }

    public void g(Activity activity, View view, int i3) {
        view.addOnLayoutChangeListener(r());
        boolean k3 = k(view);
        if (i3 > 0 && k3 && this.D != null) {
            int l3 = l(view, i3);
            if (this.H < 0) {
                this.H = m();
            }
            G(this.D, this.H);
            G(this.C, l3);
            this.I = q(s(), this.H);
            this.J = (r2 - U) - l3;
            I(s(), this.J);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.f7625416) {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController.a
    public void scrollToTop() {
        if (this.f415721d == null) {
            return;
        }
        if (this.f415722e.c() == 1) {
            this.E.setDrawableByLayerId(R.id.lp7, this.G);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.f415721d.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.f415721d.getWindow().getDecorView().getWindowToken(), 0);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        this.f415724h = view;
        this.L = true;
        this.N = i16;
        super.showAtLocation(view, i3, i16, i17);
        this.f415722e.h(this);
        this.f415722e.g(this.f415724h);
    }

    public void x() {
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
        }
        QQViewPager qQViewPager = this.D;
        if (qQViewPager != null) {
            qQViewPager.setVisibility(0);
            this.f415725i.setIsFixedView(false);
        }
    }
}
