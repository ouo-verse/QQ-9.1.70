package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.filter.QQFilterConstants;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.TabLottieHelper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TabDragAnimationView extends View {
    private static boolean L0;
    private static boolean M0;
    private static WeakReference<FrameFragment> O0;
    private b A0;
    private View.OnLongClickListener B0;
    private int C;
    private int C0;
    private String D;
    private List<c> D0;
    private String E;
    private final TabLottieHelper.g E0;
    private Drawable F;
    private boolean F0;
    private Drawable G;
    public URLDrawable G0;
    private LottieDrawable H;
    public boolean H0;
    private String I;
    private int J;
    private int K;
    private int L;
    protected int M;
    protected int N;
    private int P;
    private int Q;
    float R;
    float S;
    float T;
    float U;
    int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f316364a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f316365b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f316366c0;

    /* renamed from: d, reason: collision with root package name */
    private String f316367d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f316368d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f316369e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f316370e0;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f316371f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f316372f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f316373g0;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f316374h;

    /* renamed from: h0, reason: collision with root package name */
    ValueAnimator f316375h0;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f316376i;

    /* renamed from: i0, reason: collision with root package name */
    private final f f316377i0;

    /* renamed from: j0, reason: collision with root package name */
    private final e f316378j0;

    /* renamed from: k0, reason: collision with root package name */
    ValueAnimator f316379k0;

    /* renamed from: l0, reason: collision with root package name */
    private final d f316380l0;

    /* renamed from: m, reason: collision with root package name */
    private int f316381m;

    /* renamed from: m0, reason: collision with root package name */
    private float f316382m0;

    /* renamed from: n0, reason: collision with root package name */
    private final boolean f316383n0;

    /* renamed from: o0, reason: collision with root package name */
    int f316384o0;

    /* renamed from: p0, reason: collision with root package name */
    int f316385p0;

    /* renamed from: q0, reason: collision with root package name */
    private Paint f316386q0;

    /* renamed from: r0, reason: collision with root package name */
    private Rect f316387r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f316388s0;

    /* renamed from: t0, reason: collision with root package name */
    private Canvas f316389t0;

    /* renamed from: u0, reason: collision with root package name */
    private Bitmap f316390u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f316391v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f316392w0;

    /* renamed from: x0, reason: collision with root package name */
    private final Handler f316393x0;

    /* renamed from: y0, reason: collision with root package name */
    private GestureDetector f316394y0;

    /* renamed from: z0, reason: collision with root package name */
    private GestureDetector.OnDoubleTapListener f316395z0;
    private static final int I0 = ViewUtils.dpToPx(2.0f);
    public static final int J0 = ViewUtils.dpToPx(27.0f);
    public static final int K0 = ViewUtils.dpToPx(42.0f);
    private static boolean N0 = false;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (TabDragAnimationView.this.f316395z0 != null) {
                return TabDragAnimationView.this.f316395z0.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            if (TabDragAnimationView.this.B0 != null) {
                TabDragAnimationView.this.B0.onLongClick(TabDragAnimationView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (TabDragAnimationView.this.f316395z0 != null) {
                TabDragAnimationView.this.f316395z0.onSingleTapConfirmed(motionEvent);
            }
            ViewParent parent = TabDragAnimationView.this.getParent();
            if (parent != null) {
                ((ViewGroup) parent).performClick();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onDragEnd();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void onDraw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private final TabDragAnimationView f316397d;

        /* renamed from: e, reason: collision with root package name */
        boolean f316398e = false;

        /* renamed from: f, reason: collision with root package name */
        boolean f316399f = false;

        /* renamed from: h, reason: collision with root package name */
        float f316400h = 1.0f;

        d(TabDragAnimationView tabDragAnimationView) {
            this.f316397d = tabDragAnimationView;
        }

        void a() {
            this.f316398e = false;
            this.f316399f = false;
            this.f316400h = 1.0f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue - this.f316400h > 0.0f) {
                this.f316398e = true;
            }
            if (this.f316398e && floatValue > 0.8f) {
                this.f316399f = false;
            }
            this.f316400h = floatValue;
            this.f316397d.L();
            if (QLog.isDevelopLevel()) {
                QLog.d(TabDragAnimationView.class.getSimpleName(), 4, "do mScale animation, percent=" + this.f316400h + ",reversed=" + this.f316398e + ",doAnim=" + this.f316399f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private final TabDragAnimationView f316401d;

        e(TabDragAnimationView tabDragAnimationView) {
            this.f316401d = tabDragAnimationView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f316401d.K(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private final TabDragAnimationView f316402d;

        /* renamed from: e, reason: collision with root package name */
        private float f316403e = 0.0f;

        /* renamed from: f, reason: collision with root package name */
        private float f316404f = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        private float f316405h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        private float f316406i = 0.0f;

        /* renamed from: m, reason: collision with root package name */
        float f316407m = 0.0f;
        float C = 0.0f;

        f(TabDragAnimationView tabDragAnimationView) {
            this.f316402d = tabDragAnimationView;
        }

        void a() {
            TabDragAnimationView tabDragAnimationView = this.f316402d;
            float f16 = tabDragAnimationView.T;
            this.f316403e = f16;
            float f17 = tabDragAnimationView.U;
            this.f316404f = f17;
            this.f316405h = f16 - this.f316407m;
            this.f316406i = f17 - this.C;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f16;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue < 0.1f && this.f316407m == 0.0f && this.C == 0.0f) {
                TabDragAnimationView tabDragAnimationView = this.f316402d;
                tabDragAnimationView.V = 1;
                tabDragAnimationView.L();
                valueAnimator.cancel();
                valueAnimator.removeUpdateListener(this);
                this.f316402d.f316375h0 = null;
                return;
            }
            float f17 = this.f316405h;
            if (floatValue >= 0.1f) {
                f17 *= 1.0f - floatValue;
            }
            if (floatValue < 0.1f) {
                f16 = this.f316406i;
            } else {
                f16 = (1.0f - floatValue) * this.f316406i;
            }
            this.f316402d.K(this.f316403e - f17, this.f316404f - f16, false);
        }
    }

    public TabDragAnimationView(Context context) {
        this(context, null);
    }

    private void A(int i3, int i16) {
        int i17;
        int paddingLeft = (i3 - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (i16 - getPaddingTop()) - getPaddingBottom();
        int i18 = this.J;
        if (paddingLeft > i18) {
            paddingLeft = i18;
        }
        this.M = paddingLeft;
        int i19 = this.K;
        if (paddingTop > i19) {
            paddingTop = i19;
        }
        this.N = paddingTop;
        int i26 = this.L;
        if (i26 != -1) {
            i17 = i26;
        } else {
            i17 = paddingLeft / 10;
        }
        if (i26 == -1) {
            i26 = paddingTop / 10;
        }
        this.Q = (int) Math.sqrt(Math.pow(i17, 2.0d) + Math.pow(i26, 2.0d));
        this.P = (int) Math.sqrt(Math.pow((this.M / 2) + i17, 2.0d) + Math.pow((this.N / 2) + i26, 2.0d));
    }

    private void C() {
        Iterator<c> it = this.D0.iterator();
        while (it.hasNext()) {
            it.next().onDraw();
        }
    }

    public static void E(String str, InputStream inputStream) {
        StringBuilder sb5;
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file.delete();
                if (!file.exists()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[inputStream.available()];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                fileOutputStream2.write(bArr, 0, read);
                            }
                        }
                        fileOutputStream2.flush();
                        fileOutputStream = fileOutputStream2;
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        QLog.e("TabDragAnimationView", 1, "readInputStream called error: " + e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                QLog.e("TabDragAnimationView", 1, "readInputStream called error: " + e17);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (IOException e18) {
                                e = e18;
                                sb5 = new StringBuilder();
                                sb5.append("readInputStream called error: ");
                                sb5.append(e);
                                QLog.e("TabDragAnimationView", 1, sb5.toString());
                            }
                        }
                        return;
                    } catch (IOException e19) {
                        e = e19;
                        fileOutputStream = fileOutputStream2;
                        QLog.e("TabDragAnimationView", 1, "readInputStream called error: " + e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                QLog.e("TabDragAnimationView", 1, "readInputStream called error: " + e26);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (IOException e27) {
                                e = e27;
                                sb5 = new StringBuilder();
                                sb5.append("readInputStream called error: ");
                                sb5.append(e);
                                QLog.e("TabDragAnimationView", 1, sb5.toString());
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e28) {
                                QLog.e("TabDragAnimationView", 1, "readInputStream called error: " + e28);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                throw th;
                            } catch (IOException e29) {
                                QLog.e("TabDragAnimationView", 1, "readInputStream called error: " + e29);
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e36) {
                        QLog.e("TabDragAnimationView", 1, "readInputStream called error: " + e36);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e37) {
                        e = e37;
                        sb5 = new StringBuilder();
                        sb5.append("readInputStream called error: ");
                        sb5.append(e);
                        QLog.e("TabDragAnimationView", 1, sb5.toString());
                    }
                }
            } catch (FileNotFoundException e38) {
                e = e38;
            } catch (IOException e39) {
                e = e39;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void F() {
        if (t() && this.F0) {
            int i3 = (int) (getResources().getDisplayMetrics().density * 29.0f);
            setIconSize(i3, i3);
        }
    }

    public static void G(TextView textView) {
        if (textView == null || !t()) {
            return;
        }
        textView.setTextSize(2, 11.0f);
    }

    private void H(TabLottieHelper.STATE state) {
        FrameFragment frameFragment;
        WeakReference<FrameFragment> weakReference = O0;
        if (weakReference != null) {
            frameFragment = weakReference.get();
        } else {
            frameFragment = null;
        }
        if (frameFragment == null) {
            QLog.i(this.f316367d, 1, "resetLottieDrawable null fragment");
            return;
        }
        if (state == TabLottieHelper.STATE.ENTER) {
            if (s()) {
                this.H = this.E0.f316473a;
                return;
            } else {
                this.H = this.E0.f316475c;
                return;
            }
        }
        if (state == TabLottieHelper.STATE.IDLE) {
            if (!w() && !v()) {
                if (s()) {
                    this.H = this.E0.f316473a;
                    return;
                } else {
                    this.H = this.E0.f316475c;
                    return;
                }
            }
            this.H = this.E0.f316477e;
            return;
        }
        if (state == TabLottieHelper.STATE.BACK) {
            if (!w() && !v()) {
                if (s()) {
                    this.H = this.E0.f316474b;
                    return;
                } else {
                    this.H = this.E0.f316476d;
                    return;
                }
            }
            this.H = this.E0.f316477e;
        }
    }

    private void N() {
        if (this.H0 && q()) {
            String animatePathByTag = ((IVasApngUtilApi) QRoute.api(IVasApngUtilApi.class)).getAnimatePathByTag(this.f316384o0);
            if (!TextUtils.isEmpty(animatePathByTag) && new File(animatePathByTag).exists()) {
                this.f316373g0 = true;
                return;
            }
        }
        this.f316373g0 = false;
    }

    private boolean i() {
        if (this.G != null) {
            return true;
        }
        return false;
    }

    private LottieDrawable j(TabLottieHelper.f fVar) {
        if (this.J <= 0) {
            return null;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tab_lottie_9035_120834195", true) && !x()) {
            QLog.d(this.f316367d, 1, "generateLottieDrawable not support lottie");
            return null;
        }
        return TabLottieHelper.d(fVar, this.D, this.E);
    }

    private LottieDrawable k(TabLottieHelper.STATE state) {
        if (com.tencent.mobileqq.startup.a.f289668i) {
            p();
        }
        if (z()) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f316367d, 2, "initLottieDrawable because of theme changed");
            }
            F();
        }
        H(state);
        return this.H;
    }

    public static int n(Resources resources) {
        if (resources == null) {
            QLog.e("TabDragAnimationView", 1, "getTabTextViewColor called error: resources == null");
            return Color.parseColor("#000000");
        }
        return resources.getColor(R.color.qui_common_brand_standard);
    }

    public static int o(Resources resources) {
        if (resources == null) {
            QLog.e("TabDragAnimationView", 1, "getTabTextViewUnselectedColor called error: resources == null");
            return Color.parseColor("#000000");
        }
        if (!QQTheme.isCustomTheme("", false)) {
            return resources.getColor(R.color.qui_common_text_tabbar_primary);
        }
        String currentThemeId = QQTheme.getCurrentThemeId();
        if (t()) {
            if (!w() && !v()) {
                if (s()) {
                    return -16777216;
                }
                return Color.parseColor("#999999");
            }
            return Color.parseColor("#999999");
        }
        if (!y()) {
            return resources.getColor(R.color.skin_gray2);
        }
        if (TextUtils.isEmpty(currentThemeId)) {
            return resources.getColor(R.color.skin_tab_selected_black);
        }
        if ("2920".equals(currentThemeId)) {
            return Color.parseColor("#999999");
        }
        return resources.getColor(R.color.skin_tab_selected_black);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.E0 == null || this.J <= 0) {
            return;
        }
        if (z()) {
            if (QLog.isColorLevel()) {
                QLog.i(this.f316367d, 2, "isThemeChanged, init lottie");
            }
            this.E0.a();
        }
        if (s()) {
            TabLottieHelper.g gVar = this.E0;
            if (gVar.f316473a == null) {
                gVar.f316473a = j(new TabLottieHelper.e().d(TabLottieHelper.STATE.ENTER).b(true).c(false).a());
                LottieDrawable lottieDrawable = this.E0.f316473a;
                if (lottieDrawable != null) {
                    lottieDrawable.setCallback(this);
                }
            }
            TabLottieHelper.g gVar2 = this.E0;
            if (gVar2.f316474b == null) {
                gVar2.f316474b = j(new TabLottieHelper.e().d(TabLottieHelper.STATE.BACK).b(true).c(false).a());
                LottieDrawable lottieDrawable2 = this.E0.f316474b;
                if (lottieDrawable2 != null) {
                    lottieDrawable2.setCallback(this);
                }
            }
        } else {
            TabLottieHelper.g gVar3 = this.E0;
            if (gVar3.f316475c == null) {
                gVar3.f316475c = j(new TabLottieHelper.e().d(TabLottieHelper.STATE.ENTER).b(false).c(false).a());
                LottieDrawable lottieDrawable3 = this.E0.f316475c;
                if (lottieDrawable3 != null) {
                    lottieDrawable3.setCallback(this);
                }
            }
            TabLottieHelper.g gVar4 = this.E0;
            if (gVar4.f316476d == null) {
                gVar4.f316476d = j(new TabLottieHelper.e().d(TabLottieHelper.STATE.BACK).b(false).c(false).a());
                LottieDrawable lottieDrawable4 = this.E0.f316476d;
                if (lottieDrawable4 != null) {
                    lottieDrawable4.setCallback(this);
                }
            }
        }
        TabLottieHelper.g gVar5 = this.E0;
        if (gVar5.f316477e == null) {
            gVar5.f316477e = j(new TabLottieHelper.e().d(TabLottieHelper.STATE.BACK).b(false).c(true).a());
            LottieDrawable lottieDrawable5 = this.E0.f316477e;
            if (lottieDrawable5 != null) {
                lottieDrawable5.setCallback(this);
            }
        }
    }

    public static boolean q() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("vas_theme_tab_disable_apng", false);
    }

    private static boolean r() {
        return QQTheme.isBaseDIYTheme();
    }

    private static boolean s() {
        if (!QQTheme.isDefaultTheme() && !r()) {
            return false;
        }
        return true;
    }

    public static void setCurrentFragment(WeakReference<FrameFragment> weakReference) {
        O0 = weakReference;
    }

    public static void setIsKDImmersiveMode(boolean z16) {
        M0 = z16;
    }

    public static void setIsQCircleLayerMode(boolean z16) {
        L0 = z16;
    }

    public static void setIsQCircleTabExperiment(boolean z16) {
        N0 = z16;
    }

    public static boolean t() {
        if (!TabLottieHelper.g.c()) {
            return false;
        }
        if (!s() && !QQTheme.isNowThemeDefaultNight()) {
            return false;
        }
        return true;
    }

    public static boolean u() {
        FrameFragment frameFragment;
        WeakReference<FrameFragment> weakReference = O0;
        if (weakReference == null || (frameFragment = weakReference.get()) == null) {
            return false;
        }
        if (!ThemeConstants.TAB_NAME_KANDIAN.equals(frameFragment.getCurrentTabName()) && !ThemeConstants.TAB_NAME_KANDIAN_RIJ_FRAME.equals(frameFragment.getCurrentTabName())) {
            return false;
        }
        return true;
    }

    public static boolean v() {
        if (u() && M0) {
            return true;
        }
        return false;
    }

    public static boolean w() {
        FrameFragment frameFragment;
        WeakReference<FrameFragment> weakReference = O0;
        if (weakReference == null || (frameFragment = weakReference.get()) == null || !ThemeConstants.TAB_NAME_QCIRCLE.equals(frameFragment.getCurrentTabName()) || !L0) {
            return false;
        }
        return true;
    }

    public static boolean x() {
        return t();
    }

    public static boolean y() {
        if (QQTheme.isNowSimpleUI() && !L0 && !M0) {
            return true;
        }
        return false;
    }

    private boolean z() {
        String currentThemeId = QQTheme.getCurrentThemeId();
        if (!TextUtils.isEmpty(this.I) && (TextUtils.isEmpty(currentThemeId) || currentThemeId.equals(this.I))) {
            return false;
        }
        this.I = currentThemeId;
        return true;
    }

    public boolean B() {
        return this.f316372f0;
    }

    public void D() {
        LottieDrawable lottieDrawable = this.H;
        if (lottieDrawable != null) {
            lottieDrawable.setCallback(this);
            this.H.playAnimation();
        }
    }

    void I() {
        ValueAnimator valueAnimator = this.f316375h0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f316375h0.removeUpdateListener(this.f316377i0);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f316375h0 = ofFloat;
        ofFloat.setDuration(300L);
        this.f316375h0.setInterpolator(new DecelerateInterpolator());
        this.f316375h0.addUpdateListener(this.f316377i0);
    }

    public void J(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream2);
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
    }

    public void K(float f16, float f17, boolean z16) {
        if (this.f316366c0) {
            this.f316364a0 = true;
            this.V = 8;
            this.T = f16;
            this.U = f17;
            this.f316368d0 = z16;
            invalidate();
        }
    }

    public void L() {
        this.T = 0.0f;
        this.U = 0.0f;
        this.f316364a0 = false;
        invalidate();
    }

    void M() {
        ValueAnimator valueAnimator = this.f316379k0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f316379k0.removeUpdateListener(this.f316380l0);
            this.f316380l0.a();
            this.f316379k0 = null;
        }
    }

    public boolean O() {
        return this.f316373g0;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f316388s0) {
            if (this.f316390u0 == null) {
                this.f316390u0 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.f316390u0.eraseColor(-1);
            this.f316389t0.setBitmap(this.f316390u0);
            super.draw(this.f316389t0);
            String str = Environment.getExternalStorageDirectory() + "/aaaa/";
            new File(str).mkdirs();
            Bitmap bitmap = this.f316390u0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            int i3 = this.f316391v0;
            this.f316391v0 = i3 + 1;
            sb5.append(i3);
            sb5.append(".png");
            J(bitmap, sb5.toString());
        }
    }

    void f() {
        ValueAnimator valueAnimator = this.f316379k0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f316379k0.removeUpdateListener(this.f316380l0);
        }
        this.V = 1;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.75f, 0.5f, 0.75f, 1.0f);
        this.f316379k0 = ofFloat;
        ofFloat.setDuration(200L);
        this.f316379k0.setInterpolator(new LinearInterpolator());
        this.f316379k0.addUpdateListener(this.f316380l0);
        this.f316379k0.start();
    }

    public void g() {
        if (this.f316366c0) {
            this.f316377i0.a();
            I();
            this.f316375h0.start();
            return;
        }
        L();
    }

    public void h(String str) {
        this.f316367d += str;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    @Override // android.view.View
    public boolean isImportantForAccessibility() {
        return false;
    }

    Drawable l(TabLottieHelper.STATE state) {
        Drawable drawable;
        if (x() && this.F0) {
            return k(state);
        }
        if (y() && (drawable = getResources().getDrawable(this.f316381m)) != null) {
            return drawable;
        }
        return this.f316371f;
    }

    Drawable m(TabLottieHelper.STATE state) {
        boolean z16 = false;
        if (this.H0 && q()) {
            if (QLog.isColorLevel()) {
                QLog.d(this.f316367d, 2, "getBgPressedDrawable() called ");
            }
            URLDrawable uRLDrawable = this.G0;
            if (uRLDrawable != null) {
                return uRLDrawable;
            }
            String animatePathByTag = ((IVasApngUtilApi) QRoute.api(IVasApngUtilApi.class)).getAnimatePathByTag(this.f316384o0);
            Drawable drawable = this.f316376i;
            Bundle bundle = new Bundle();
            bundle.putInt(QQFilterConstants.FilterParameters.KEY_WIDTH, this.M);
            bundle.putInt(QQFilterConstants.FilterParameters.KEY_HEIGHT, this.N);
            bundle.putInt("key_loop", 1);
            int[] iArr = {this.f316385p0};
            URLDrawable apngDrawable = ((IVasApngUtilApi) QRoute.api(IVasApngUtilApi.class)).getApngDrawable(MobileQQ.sMobileQQ.waitAppRuntime(null), animatePathByTag, "- tab-" + this.f316384o0, drawable, iArr, "- tab-" + this.f316384o0, bundle);
            this.G0 = apngDrawable;
            if (apngDrawable != null) {
                apngDrawable.setCallback(this);
                return this.G0;
            }
        } else {
            if (x() && this.F0) {
                return k(state);
            }
            if (y()) {
                Drawable drawable2 = getResources().getDrawable(this.C);
                String str = this.f316367d;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getBgPressedDrawable()  drawable!=null :");
                if (drawable2 != null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.d(str, 1, sb5.toString());
                if (drawable2 != null) {
                    return drawable2;
                }
            }
        }
        URLDrawable uRLDrawable2 = this.G0;
        if (uRLDrawable2 != null) {
            uRLDrawable2.setCallback(null);
            this.G0 = null;
        }
        return this.f316376i;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Drawable drawable;
        Drawable l3;
        int i26;
        int i27;
        Drawable drawable2;
        int i28;
        int i29;
        int i36;
        int i37;
        double d16;
        double d17;
        int i38;
        int i39;
        Drawable drawable3;
        int i46;
        int i47;
        int i48;
        int i49;
        int paddingLeft = getPaddingLeft();
        int right = (getRight() - getLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        int i56 = this.f316369e;
        if (i56 != 1) {
            if (i56 != 2) {
                if (i56 != 3) {
                    if (i56 != 4) {
                        i3 = (paddingLeft + right) / 2;
                        i19 = (paddingTop + bottom) / 2;
                        int i57 = this.M;
                        int i58 = i3 - (i57 / 2);
                        right = (i57 / 2) + i3;
                        int i59 = this.N;
                        int i65 = i19 - (i59 / 2);
                        i17 = (i59 / 2) + i19;
                        i49 = i65;
                        i16 = i58;
                        i18 = i49;
                    } else {
                        int i66 = this.M;
                        i46 = right - (i66 / 2);
                        i19 = (paddingTop + bottom) / 2;
                        paddingLeft = right - (i66 / 2);
                        int i67 = this.N;
                        i47 = i19 - (i67 / 2);
                        i48 = i67 / 2;
                    }
                } else {
                    int i68 = this.M;
                    i46 = (i68 / 2) + paddingLeft;
                    i19 = (paddingTop + bottom) / 2;
                    right = i68 + paddingLeft;
                    int i69 = this.N;
                    i47 = i19 - (i69 / 2);
                    i48 = i69 / 2;
                }
                i49 = i47;
                i16 = paddingLeft;
                i3 = i46;
                i17 = i48 + i19;
                i18 = i49;
            } else {
                i3 = (paddingLeft + right) / 2;
                int i75 = this.N;
                i19 = bottom - (i75 / 2);
                int i76 = this.M;
                i16 = i3 - (i76 / 2);
                i18 = bottom - i75;
                right = (i76 / 2) + i3;
                i17 = bottom;
            }
        } else {
            i3 = (paddingLeft + right) / 2;
            int i77 = this.N;
            int i78 = (i77 / 2) + paddingTop;
            int i79 = this.M;
            i16 = i3 - (i79 / 2);
            int i85 = (i79 / 2) + i3;
            i17 = i77 + paddingTop;
            right = i85;
            i18 = paddingTop;
            i19 = i78;
        }
        this.C0 = i19;
        C();
        this.f316386q0.setStyle(Paint.Style.STROKE);
        this.f316386q0.setStrokeWidth(1.0f);
        if (this.V == 1 && !this.f316364a0) {
            d dVar = this.f316380l0;
            boolean z16 = dVar.f316398e;
            if ((z16 || !dVar.f316399f) && this.f316365b0) {
                drawable3 = this.F;
            } else {
                drawable3 = this.f316374h;
            }
            if ((z16 || !dVar.f316399f) && this.f316365b0) {
                drawable2 = m(this.E0.b());
            } else {
                drawable2 = l(this.E0.b());
            }
            float f16 = this.f316380l0.f316400h;
            if (f16 != 1.0f) {
                canvas.scale(f16, f16, i3, i19);
            }
            if (drawable2 != null) {
                if (x() && this.F0) {
                    canvas.save();
                    canvas.translate(i16, i18);
                    drawable2.setBounds(i16, i18, right, i17);
                    if (!i()) {
                        drawable2.draw(canvas);
                    }
                    canvas.restore();
                } else {
                    drawable2.setBounds(i16, i18, right, i17);
                    if (!i()) {
                        drawable2.draw(canvas);
                    }
                }
                this.f316386q0.setColor(SupportMenu.CATEGORY_MASK);
                this.f316387r0.set(drawable2.getBounds());
            }
            if (drawable3 != null && this.f316366c0) {
                drawable3.setBounds(i16, i18, right, i17);
                if (!i()) {
                    drawable3.draw(canvas);
                }
                this.f316386q0.setColor(-16776961);
            }
        } else {
            boolean z17 = this.f316365b0;
            if (z17) {
                drawable = this.F;
            } else {
                drawable = this.f316374h;
            }
            if (z17) {
                l3 = m(this.E0.b());
            } else {
                l3 = l(this.E0.b());
            }
            if (((int) Math.sqrt(Math.pow((this.M / 2) + Math.abs(this.T), 2.0d) + Math.pow((this.N / 2) + Math.abs(this.U), 2.0d))) > this.P) {
                float f17 = this.T;
                if (f17 != 0.0f) {
                    float f18 = this.U;
                    if (f18 != 0.0f) {
                        double pow = Math.pow(f18, 2.0d) / Math.pow(this.T, 2.0d);
                        double d18 = pow + 1.0d;
                        d16 = this.Q * (1.0d / Math.sqrt(d18));
                        d17 = this.Q * Math.sqrt(pow / d18);
                        if (this.T <= 0.0f) {
                            i38 = 1;
                        } else {
                            i38 = -1;
                        }
                        i26 = (int) (d16 * i38);
                        if (this.U <= 0.0f) {
                            i39 = 1;
                        } else {
                            i39 = -1;
                        }
                        i27 = (int) (d17 * i39);
                    }
                }
                d16 = 0.0d;
                if (f17 != 0.0f) {
                    d17 = 0.0d;
                    d16 = this.Q;
                } else if (this.U != 0.0f) {
                    d17 = this.Q;
                } else {
                    d17 = 0.0d;
                }
                if (this.T <= 0.0f) {
                }
                i26 = (int) (d16 * i38);
                if (this.U <= 0.0f) {
                }
                i27 = (int) (d17 * i39);
            } else {
                i26 = (int) this.T;
                i27 = (int) this.U;
            }
            int i86 = i26 * 2;
            int i87 = i27 * 2;
            if (l3 != null) {
                boolean z18 = this.f316368d0;
                if (z18) {
                    i28 = i16;
                } else {
                    i28 = i16 - i26;
                }
                if (z18) {
                    i29 = i18;
                } else {
                    i29 = i18 - i27;
                }
                if (z18) {
                    i36 = right;
                } else {
                    i36 = right - i26;
                }
                if (z18) {
                    i37 = i17;
                } else {
                    i37 = i17 - i27;
                }
                l3.setBounds(i28, i29, i36, i37);
                if (!i()) {
                    l3.draw(canvas);
                }
                this.f316386q0.setColor(SupportMenu.CATEGORY_MASK);
                this.f316387r0.set(l3.getBounds());
            }
            if (drawable != null && this.f316366c0) {
                canvas.save();
                drawable.setBounds(i16 - i86, i18 - i87, right - i86, i17 - i87);
                if (!i()) {
                    drawable.draw(canvas);
                }
                this.f316386q0.setColor(-16776961);
                canvas.restore();
            }
            drawable2 = l3;
        }
        if (i() && drawable2 != null) {
            this.G.setBounds(drawable2.getBounds());
            this.G.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int paddingLeft = getPaddingLeft() + getPaddingRight() + this.J;
        int paddingTop = getPaddingTop() + getPaddingBottom() + this.K;
        int resolveSizeAndState = View.resolveSizeAndState(paddingLeft, i3, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(paddingTop, i16, 0);
        View.MeasureSpec.getSize(resolveSizeAndState);
        View.MeasureSpec.getSize(resolveSizeAndState2);
        A(resolveSizeAndState, resolveSizeAndState2);
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0101  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        b bVar;
        float f16;
        if (this.f316395z0 != null) {
            this.f316394y0.onTouchEvent(motionEvent);
        }
        Object obj = this.G;
        if (obj != null && (obj instanceof Animatable) && !((Animatable) obj).isRunning()) {
            setClickAnimationDrawable(null);
        }
        int paddingLeft = (getPaddingLeft() + ((getRight() - getLeft()) - getPaddingRight())) / 2;
        int paddingTop = (getPaddingTop() + ((getBottom() - getTop()) - getPaddingBottom())) / 2;
        int sqrt = (int) Math.sqrt(Math.pow(this.M / 2.0d, 2.0d) + Math.pow(this.N / 2.0d, 2.0d));
        int width = getWidth();
        int height = getHeight();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            float f17 = 0.0f;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                    if (this.f316383n0) {
                        if (this.f316382m0 > ((int) (com.tencent.mobileqq.utils.ah.L() - ViewUtils.dip2px(14.0f)))) {
                            this.R = 0.0f;
                            this.S = 0.0f;
                            this.f316382m0 = 0.0f;
                            this.W = -1;
                            this.f316370e0 = false;
                            if (this.f316364a0) {
                                g();
                            }
                            return false;
                        }
                    }
                } else {
                    if (!this.f316366c0) {
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(this.W);
                    if (findPointerIndex == -1) {
                        this.f316370e0 = false;
                        return false;
                    }
                    float x16 = motionEvent.getX(findPointerIndex);
                    float y16 = motionEvent.getY(findPointerIndex);
                    if (((int) Math.sqrt(Math.pow(x16 - paddingLeft, 2.0d) + Math.pow(y16 - paddingTop, 2.0d))) <= this.P) {
                        float f18 = this.R;
                        if (x16 != f18 || y16 != this.S) {
                            f17 = f18 - x16;
                            f16 = this.S - y16;
                            this.f316370e0 = true;
                            if (this.f316370e0) {
                                M();
                                K(f17, f16, false);
                            }
                            return this.f316370e0;
                        }
                    }
                    if (this.f316370e0) {
                        f17 = this.R - x16;
                        f16 = this.S - y16;
                    } else {
                        f16 = 0.0f;
                    }
                    if (this.f316370e0) {
                    }
                    return this.f316370e0;
                }
            }
            this.W = -1;
            this.f316370e0 = false;
            if (this.f316364a0) {
                g();
            }
            float f19 = paddingLeft;
            float f26 = paddingTop;
            int sqrt2 = ((int) Math.sqrt(Math.pow(this.R - f19, 2.0d) + Math.pow(this.S - f26, 2.0d))) + I0;
            float x17 = motionEvent.getX();
            float y17 = motionEvent.getY();
            int sqrt3 = (int) Math.sqrt(Math.pow(x17 - f19, 2.0d) + Math.pow(y17 - f26, 2.0d));
            if ((sqrt2 >= sqrt || sqrt3 <= sqrt) && x17 > 0.0f && x17 < width && y17 > 0.0f && y17 < height) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && (bVar = this.A0) != null) {
                bVar.onDragEnd();
            }
            if (this.f316395z0 == null && getParent() != null && z16) {
                ((ViewGroup) getParent()).performClick();
                if (QLog.isColorLevel()) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    QLog.d(this.f316367d, 2, "TabDragView perform click, action=" + actionMasked + ", ux=" + x17 + ", uy=" + y17 + ", urx=" + rawX + ", ury=" + rawY + ", w=" + width + ", vh=" + height + ", radius=" + sqrt2 + ", innerRadius=" + sqrt + ", upRidus=" + sqrt3);
                    return true;
                }
                return true;
            }
            return true;
        }
        this.R = motionEvent.getX();
        this.S = motionEvent.getY();
        this.f316382m0 = motionEvent.getRawY();
        this.W = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (((int) Math.sqrt(Math.pow(this.R - paddingLeft, 2.0d) + Math.pow(this.S - paddingTop, 2.0d))) <= sqrt) {
            if (this.f316365b0) {
                L();
                return true;
            }
            if (this.f316392w0) {
                f();
                return true;
            }
            return true;
        }
        return true;
    }

    public void setAnimEnable(boolean z16) {
        this.f316366c0 = z16;
        N();
        invalidate();
    }

    public void setBgDrawable(int i3) {
        if (i3 != -1) {
            this.f316371f = getResources().getDrawable(i3);
            invalidate();
        }
    }

    public void setBgPressedDrawable(int i3) {
        if (i3 != -1) {
            this.f316376i = getResources().getDrawable(i3);
            invalidate();
        }
    }

    public void setClickAnimationDrawable(Drawable drawable) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f316367d, 2, "setClickAnimationDrawable() called with: drawable = [" + drawable + "]");
        }
        Drawable drawable2 = this.G;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.G = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidate();
    }

    public void setDebug(boolean z16) {
        this.f316388s0 = z16;
    }

    public void setEnableClickScaleAnimation(boolean z16) {
        this.f316392w0 = z16;
    }

    public void setEnableLottie(boolean z16) {
        this.F0 = z16;
    }

    public void setExpectedLogoMoveDistance(int i3) {
        this.L = i3;
        if (i3 != -1) {
            this.Q = (int) Math.sqrt(Math.pow(i3, 2.0d) * 2.0d);
        }
    }

    public void setFaceDrawable(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f316367d, 2, "setFaceDrawable() called with: faceId = [" + i3 + "]");
        }
        if (i3 != -1) {
            this.f316374h = getResources().getDrawable(i3);
        } else {
            this.f316374h = null;
        }
        invalidate();
    }

    public void setFacePressedDrawable(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f316367d, 2, "setFacePressedDrawable() called with: facePressId = [" + i3 + "]");
        }
        if (i3 != -1) {
            this.F = getResources().getDrawable(i3);
        } else {
            this.F = null;
        }
        invalidate();
    }

    public void setIconGravity(int i3) {
        if (i3 != 0 && i3 != 3 && i3 != 4 && i3 != 1 && i3 != 2) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f316367d, 2, "unsupported gravity=" + i3);
                return;
            }
            return;
        }
        this.f316369e = i3;
        invalidate();
    }

    public void setIconSize(int i3, int i16) {
        Drawable drawable;
        d dVar = this.f316380l0;
        if ((dVar.f316398e || !dVar.f316399f) && this.f316365b0) {
            drawable = this.f316376i;
        } else {
            drawable = this.f316371f;
        }
        if (i16 >= 0) {
            this.K = i16;
        } else if (drawable != null) {
            this.K = Math.min(K0, Math.max(drawable.getIntrinsicHeight(), J0));
        }
        if (i3 >= 0) {
            this.J = i3;
        } else if (drawable != null) {
            this.J = Math.min(K0, Math.max(drawable.getIntrinsicWidth(), J0));
        }
        requestLayout();
    }

    public void setLogoGravity(int i3) {
        this.f316369e = i3;
    }

    public void setLogoHeight(int i3) {
        this.K = i3;
    }

    public void setLogoWidth(int i3) {
        this.J = i3;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f316395z0 = onDoubleTapListener;
    }

    public void setOnDragListener(b bVar) {
        this.A0 = bVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.B0 = onLongClickListener;
    }

    public void setPressChanged(boolean z16) {
        TabLottieHelper.STATE state;
        boolean z17;
        LottieDrawable lottieDrawable;
        TabLottieHelper.STATE state2;
        this.f316365b0 = z16;
        URLDrawable uRLDrawable = this.G0;
        if (uRLDrawable != null) {
            if (z16) {
                state2 = TabLottieHelper.STATE.ENTER;
            } else {
                state2 = TabLottieHelper.STATE.BACK;
            }
            if (uRLDrawable == m(state2)) {
                Drawable currDrawable = this.G0.getCurrDrawable();
                if (currDrawable instanceof ApngDrawable) {
                    ((ApngDrawable) currDrawable).repaly();
                }
            }
        }
        if (x() && this.F0) {
            if (z16) {
                state = TabLottieHelper.STATE.ENTER;
            } else {
                state = TabLottieHelper.STATE.BACK;
            }
            if (state == this.E0.b() && this.E0.b() == TabLottieHelper.STATE.ENTER) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.E0.d(state);
            H(this.E0.b());
            float f16 = 1.0f;
            if (z16) {
                LottieDrawable lottieDrawable2 = this.H;
                if (lottieDrawable2 != null) {
                    if (z17) {
                        lottieDrawable2.pauseAnimation();
                        this.H.setProgress(1.0f);
                        return;
                    }
                    lottieDrawable2.playAnimation();
                } else {
                    LottieDrawable k3 = k(this.E0.b());
                    this.H = k3;
                    if (k3 != null) {
                        k3.setCallback(this);
                        this.H.playAnimation();
                    }
                }
            } else if (this.E0.b() == TabLottieHelper.STATE.BACK) {
                LottieDrawable lottieDrawable3 = this.H;
                if (lottieDrawable3 != null) {
                    if (N0 && 17 == this.f316384o0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(this.f316367d, 2, "setPressChanged() hit circle tab experiment ");
                        }
                        this.H.pauseAnimation();
                        this.H.setProgress(1.0f);
                    } else {
                        lottieDrawable3.setCallback(this);
                        this.H.playAnimation();
                    }
                }
            } else if (this.E0.b() == TabLottieHelper.STATE.IDLE && (lottieDrawable = this.H) != null) {
                lottieDrawable.pauseAnimation();
                LottieDrawable lottieDrawable4 = this.H;
                if (!w() && !v()) {
                    f16 = 0.0f;
                }
                lottieDrawable4.setProgress(f16);
            }
        }
        invalidate();
    }

    public void setShowTextView(boolean z16) {
        this.f316372f0 = z16;
    }

    public void setTabDrawable(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, String str, String str2) {
        Resources resources = getResources();
        this.f316384o0 = i19;
        this.f316385p0 = i26;
        if (i3 != -1) {
            this.f316374h = resources.getDrawable(i3);
        }
        if (i16 != -1) {
            this.f316371f = resources.getDrawable(i16);
        }
        if (i17 != -1) {
            this.F = resources.getDrawable(i17);
        }
        if (i18 != -1) {
            this.f316376i = resources.getDrawable(i18);
        }
        this.f316381m = i27;
        this.C = i28;
        this.D = str;
        this.E = str2;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.widget.TabDragAnimationView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(TabDragAnimationView.this.f316367d, 2, "initLottieDrawable for preload " + TabDragAnimationView.this.D);
                }
                TabDragAnimationView.this.p();
            }
        }, 16, null, true);
        N();
    }

    public TabDragAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabDragAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316367d = "TabDragAnimationView@" + Integer.toHexString(hashCode());
        this.L = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = 1;
        this.W = -1;
        this.f316364a0 = false;
        this.f316365b0 = false;
        this.f316366c0 = true;
        this.f316368d0 = false;
        this.f316370e0 = false;
        this.f316372f0 = true;
        this.f316373g0 = false;
        this.f316382m0 = 0.0f;
        this.f316386q0 = new Paint(1);
        this.f316387r0 = new Rect();
        this.f316388s0 = false;
        this.f316389t0 = new Canvas();
        this.f316391v0 = 10000;
        this.f316392w0 = true;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f316393x0 = handler;
        this.C0 = 0;
        this.D0 = new ArrayList();
        this.E0 = new TabLottieHelper.g();
        this.F0 = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ke2.a.J3, i3, 0);
        try {
            this.f316369e = obtainStyledAttributes.getInt(ke2.a.K3, 0);
            this.J = obtainStyledAttributes.getDimensionPixelSize(ke2.a.M3, 0);
            this.K = obtainStyledAttributes.getDimensionPixelSize(ke2.a.L3, 0);
            if (QLog.isColorLevel()) {
                QLog.d(this.f316367d, 2, "load xml attr, expected logo width=" + this.J + ", expected logo height=" + this.K);
            }
            obtainStyledAttributes.recycle();
            this.f316377i0 = new f(this);
            this.f316378j0 = new e(this);
            this.f316380l0 = new d(this);
            this.H0 = ((IVasApngUtilApi) QRoute.api(IVasApngUtilApi.class)).isNowThemeIsAnimate();
            this.f316383n0 = DeviceInfoMonitor.getModel().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) || Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
            this.f316394y0 = new GestureDetector(context, new a(), handler);
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }
}
