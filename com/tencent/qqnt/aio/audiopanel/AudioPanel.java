package com.tencent.qqnt.aio.audiopanel;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager;
import com.tencent.mobileqq.activity.aio.audiopanel.PttTextTransitionAnim;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.SoftReference;

/* loaded from: classes34.dex */
public class AudioPanel extends LinearLayout implements ViewPager.OnPageChangeListener, View.OnClickListener, Handler.Callback, AudioTransitionAnimManager.c {
    private static final int A0;

    /* renamed from: u0, reason: collision with root package name */
    private static final int[] f349499u0;

    /* renamed from: v0, reason: collision with root package name */
    private static final int f349500v0;

    /* renamed from: w0, reason: collision with root package name */
    private static SoftReference<PopupWindow> f349501w0 = null;

    /* renamed from: x0, reason: collision with root package name */
    private static final int f349502x0 = 55;

    /* renamed from: y0, reason: collision with root package name */
    private static final int f349503y0;

    /* renamed from: z0, reason: collision with root package name */
    private static final float f349504z0;
    private PressToSpeakPanel C;
    private TextView D;
    private TextView E;
    private TextView F;
    private String[] G;
    private ViewGroup H;
    private boolean I;
    private int J;
    private int K;
    private int L;
    View M;
    private int N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private RelativeLayout T;
    private PttTextTransitionAnim U;
    private ImageView V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f349505a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f349506b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f349507c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f349508d;

    /* renamed from: d0, reason: collision with root package name */
    private int f349509d0;

    /* renamed from: e, reason: collision with root package name */
    private int f349510e;

    /* renamed from: e0, reason: collision with root package name */
    private float f349511e0;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f349512f;

    /* renamed from: f0, reason: collision with root package name */
    private int f349513f0;

    /* renamed from: g0, reason: collision with root package name */
    private LottieDrawable f349514g0;

    /* renamed from: h, reason: collision with root package name */
    private AudioPanelViewPager f349515h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f349516h0;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f349517i;

    /* renamed from: i0, reason: collision with root package name */
    private m f349518i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f349519j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f349520k0;

    /* renamed from: l0, reason: collision with root package name */
    private Rect f349521l0;

    /* renamed from: m, reason: collision with root package name */
    private AudioPanelAdapter f349522m;

    /* renamed from: m0, reason: collision with root package name */
    private Rect f349523m0;

    /* renamed from: n0, reason: collision with root package name */
    private Paint f349524n0;

    /* renamed from: o0, reason: collision with root package name */
    private float f349525o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f349526p0;

    /* renamed from: q0, reason: collision with root package name */
    private float f349527q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f349528r0;

    /* renamed from: s0, reason: collision with root package name */
    private WeakReferenceHandler f349529s0;

    /* renamed from: t0, reason: collision with root package name */
    private Runnable f349530t0;

    public AudioPanel(Context context) {
        super(context);
        this.f349510e = 1;
        this.G = new String[3];
        this.I = false;
        this.N = -1;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.W = false;
        this.f349505a0 = false;
        this.f349506b0 = -1;
        this.f349507c0 = false;
        this.f349513f0 = 0;
        this.f349519j0 = true;
        this.f349520k0 = false;
        this.f349529s0 = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f349530t0 = new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.AudioPanel.1
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("AudioPanel", 2, "playAnimRunable isEnabled():" + AudioPanel.this.isEnabled() + " mCurAnimType=" + AudioPanel.this.f349506b0);
                }
                if (AudioPanel.this.isEnabled()) {
                    AudioTransitionAnimManager.k().u(AudioPanel.this.f349514g0, AudioPanel.this.f349506b0, AudioPanel.this.V, AudioPanel.this.f349507c0);
                }
            }
        };
    }

    public static PopupWindow H(Context context, int i3, int i16, View view, int i17, int i18, int i19, int i26) {
        SoftReference<PopupWindow> softReference = f349501w0;
        if (softReference != null && softReference.get() != null && f349501w0.get().isShowing()) {
            return f349501w0.get();
        }
        View view2 = new View(context);
        view2.setBackgroundColor(i26);
        PopupWindow popupWindow = new PopupWindow(view2, i3, i16);
        f349501w0 = new SoftReference<>(popupWindow);
        try {
            popupWindow.setAttachedInDecor(false);
            popupWindow.setClippingEnabled(false);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("AudioPanel", 2, th5, new Object[0]);
            }
        }
        if (view.getWindowToken() != null) {
            popupWindow.showAtLocation(view, i17, i18, i19);
        }
        return popupWindow;
    }

    private void M() {
        if (this.f349521l0 != null) {
            this.f349526p0 += A0;
            this.f349527q0 += f349504z0;
            if (QLog.isColorLevel()) {
                QLog.d("HollowRound", 2, "updateHollowRoundAnim:" + this.f349526p0 + ", " + this.f349527q0);
            }
        }
    }

    private void g() {
        if (this.f349516h0) {
            this.D.setTextSize(20.0f);
            this.E.setTextSize(18.0f);
            this.F.setTextSize(18.0f);
            int f16 = BaseAIOUtils.f(2.0f, getResources());
            this.D.setPadding(f16, 0, f16, 0);
            this.E.setPadding(f16, 0, f16, 0);
            ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
            layoutParams.height = BaseAIOUtils.f(44.0f, getResources());
            this.H.setLayoutParams(layoutParams);
        }
    }

    private void i(float f16) {
        float f17 = this.f349511e0;
        if (f17 == 0.0f) {
            this.f349511e0 = f16;
            return;
        }
        float f18 = f16 - f17;
        int i3 = f18 > 0.0f ? 1 : f18 < 0.0f ? -1 : 0;
        if (this.f349513f0 != i3) {
            this.f349505a0 = true;
            this.f349513f0 = i3;
        }
    }

    private boolean j(int i3) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_audio_ignore_panel_state_9035_121288950", true)) {
            return i3 == 4 && this.f349520k0;
        }
        return false;
    }

    private void k(int i3) {
        int n3 = n();
        int i16 = i3 == R.id.izk ? 1 : i3 == R.id.i3t ? 2 : i3 == R.id.f167119l04 ? 0 : -1;
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "doClickItemTransitionAnim() lastSelectItem is:" + n3 + " nextItem=" + i16);
        }
        if (i16 < 0 || i16 == n3) {
            return;
        }
        G(true);
        this.f349507c0 = true;
        m(n3, i16);
    }

    private void l(int i3, int i16, float f16) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "doPageScrolledTransitionAnim() curItem is:" + i3 + " nextItem=" + i16 + " needDoPageScrolledTransitionAnim=" + this.f349505a0 + " nextdirect=" + this.f349513f0);
        }
        int s16 = s(i16);
        if (this.f349505a0 && i3 != s16) {
            m(i3, s16);
            this.f349505a0 = false;
        }
        this.U.setScrollDis(f16, this.f349515h.getWidth());
        if (this.f349514g0 == null || this.f349505a0) {
            return;
        }
        if (Math.abs(f16) > this.f349515h.getWidth()) {
            f16 = Math.abs(f16) - this.f349515h.getWidth();
        }
        AudioTransitionAnimManager.k().y(this.f349514g0, com.tencent.mobileqq.activity.aio.audiopanel.e.c(f16, this.f349515h.getWidth()), this.f349506b0, this.f349507c0);
    }

    private void m(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "doTransitionAnimByNextItem lastSelectItem is:" + i3 + " nextItem=" + i16);
        }
        if (AudioTransitionAnimManager.k().j()) {
            if (i3 < 0) {
                i3 = n();
            }
            if (i3 != i16) {
                this.f349506b0 = com.tencent.mobileqq.activity.aio.audiopanel.e.b(i3, i16);
                D(getContext(), this.f349507c0);
            }
        }
    }

    private int o() {
        AudioPanelViewPager audioPanelViewPager = this.f349515h;
        if (audioPanelViewPager == null) {
            return -12566449;
        }
        return audioPanelViewPager.getContext().getResources().getColorStateList(R.color.qui_common_text_primary).getDefaultColor();
    }

    private int p() {
        AudioPanelViewPager audioPanelViewPager = this.f349515h;
        if (audioPanelViewPager == null) {
            return 2103140725;
        }
        return audioPanelViewPager.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary).getDefaultColor();
    }

    public static PopupWindow r() {
        SoftReference<PopupWindow> softReference = f349501w0;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    private int s(int i3) {
        if (i3 > 2) {
            i3 = 2;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    private void v() {
        PressToSpeakPanel pressToSpeakPanel;
        if (this.f349515h.getCurrentItem() != 1 || (pressToSpeakPanel = this.C) == null) {
            return;
        }
        ImageView B = pressToSpeakPanel.B();
        Rect rect = new Rect();
        B.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        super.getGlobalVisibleRect(rect2);
        int i3 = rect.left - rect2.left;
        int i16 = rect.top - rect2.top;
        this.f349525o0 = TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics());
        this.f349521l0 = new Rect(i3, i16, rect.width() + i3, rect.height() + i16);
        this.f349526p0 = 40;
        this.f349527q0 = 0.98f;
        if (QLog.isColorLevel()) {
            QLog.d("HollowRound", 2, "initAndStartHollowRoundAnim:" + this.f349526p0 + ", " + this.f349527q0);
        }
        Paint paint = new Paint();
        this.f349524n0 = paint;
        paint.setAntiAlias(true);
        this.f349524n0.setStyle(Paint.Style.STROKE);
        w();
    }

    private void w() {
        Rect rect = this.f349523m0;
        if (rect == null) {
            super.invalidate();
        } else {
            super.invalidate(rect);
        }
    }

    public void B(ViewGroup viewGroup) {
        if (this.S) {
            this.S = false;
        }
    }

    public void D(Context context, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "playTransitionAnimByType AudioTransitionAnimManager animType:" + this.f349506b0 + " mCurLottieDrawable=" + this.f349514g0);
        }
        AudioTransitionAnimManager k3 = AudioTransitionAnimManager.k();
        k3.f(this);
        LottieDrawable lottieDrawable = this.f349514g0;
        if (lottieDrawable != null) {
            k3.g(lottieDrawable);
        }
        LottieDrawable i3 = k3.i(context, this.f349506b0);
        this.f349514g0 = i3;
        if (i3 != null) {
            G(false);
            k3.u(this.f349514g0, this.f349506b0, this.V, z16);
        } else {
            t();
        }
    }

    public void G(boolean z16) {
        LottieDrawable lottieDrawable;
        if (AudioTransitionAnimManager.k().j() && this.T != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPanel", 2, "showAnimMask needStopLastAnim=" + z16);
            }
            if (z16 && (lottieDrawable = this.f349514g0) != null && lottieDrawable.isAnimating()) {
                this.f349514g0.endAnimation();
            }
            if (this.f349514g0 != null) {
                this.T.setVisibility(0);
            }
        }
    }

    public void J(int i3) {
        if (AudioTransitionAnimManager.k().j()) {
            G(true);
            this.f349506b0 = com.tencent.mobileqq.activity.aio.audiopanel.e.a(i3);
            this.f349507c0 = true;
            D(getContext(), true);
        }
    }

    public void K(boolean z16) {
        if (this.f349521l0 != null) {
            this.f349521l0 = null;
            this.f349523m0 = null;
        }
        this.f349528r0 = false;
        this.f349529s0.removeMessages(2);
        this.f349529s0.removeMessages(1);
        if (z16) {
            w();
        }
    }

    public void L() {
        if (this.f349521l0 != null) {
            K(true);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.c
    public void a(LottieDrawable lottieDrawable, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AudioPanel", 2, "onDrawableLoaded AudioPanel mCurAnimType:" + this.f349506b0 + ",type= " + i3 + " drawable=" + lottieDrawable);
        }
        if (com.tencent.mobileqq.activity.aio.audiopanel.e.d(i3) && this.f349506b0 == i3) {
            this.f349514g0 = lottieDrawable;
            if (lottieDrawable != null) {
                ThreadManager.getUIHandler().removeCallbacks(this.f349530t0);
                ThreadManager.getUIHandler().post(this.f349530t0);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.c
    public void b(Animator animator, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AudioPanel", 2, "onAnimationEnd AudioPanel mCurAnimType:" + this.f349506b0 + ",type= " + i3 + " isPageViewStartDragger=" + this.W);
        }
        if (com.tencent.mobileqq.activity.aio.audiopanel.e.d(i3)) {
            this.f349507c0 = false;
            if (this.W) {
                return;
            }
            t();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Rect rect = this.f349521l0;
        if (rect != null) {
            if (this.f349526p0 <= 0) {
                if (!this.f349528r0) {
                    I(true);
                    return;
                } else {
                    K(false);
                    return;
                }
            }
            float width = rect.width() / 2;
            float f16 = this.f349527q0 * width;
            float f17 = this.f349525o0;
            if (f16 <= width + f17) {
                f17 = f16 > width ? f16 - width : 0.0f;
            }
            if (f17 > 0.0f) {
                this.f349524n0.setColor(Color.argb(this.f349526p0, 0, 0, 255));
                this.f349524n0.setStrokeWidth(f17);
                canvas.drawCircle(rect.centerX(), rect.centerY(), f16 - (f17 / 2.0f), this.f349524n0);
            }
            this.f349529s0.sendEmptyMessageDelayed(2, f349502x0);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            v();
        } else if (i3 == 2) {
            M();
            w();
        } else if (i3 == 3) {
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) this.f349512f.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103300.103301");
            RedTouch applyTo = new RedTouch(getContext(), this.F).setGravity(53).applyTo();
            this.F.setTag(applyTo);
            applyTo.parseRedTouch(appInfoByPath);
        }
        return true;
    }

    public int n() {
        AudioPanelViewPager audioPanelViewPager = this.f349515h;
        if (audioPanelViewPager != null) {
            return audioPanelViewPager.getCurrentItem();
        }
        return -1;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (AppSetting.o(getContext())) {
            this.f349520k0 = true;
            u(this.f349512f, this.f349518i0);
            invalidate();
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (!this.I || this.Q) {
            this.Q = false;
            View childAt = this.H.getChildAt(this.f349515h.getCurrentItem());
            if (childAt != null) {
                int left = childAt.getLeft() - (((i17 - i3) - childAt.getWidth()) / 2);
                ViewGroup viewGroup = this.H;
                viewGroup.scrollTo(left, viewGroup.getScrollY());
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        try {
            if (this.f349515h.getCurrentItem() == 0) {
                boolean z16 = ListenChangeVoicePanel.f349561f0;
            }
        } catch (Exception unused) {
        }
        super.onMeasure(i3, i16);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "onPageScrollStateChanged() is called,state is:" + i3 + " onPageScrolled=" + this.W);
        }
        if (i3 == 1) {
            A();
            return;
        }
        if (i3 == 0) {
            z();
            if (n() == 0) {
                ReportController.o(this.f349512f, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "1", "", "", "");
                ((IRedTouchManager) this.f349512f.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103300.103301");
                Object tag = this.F.getTag();
                if (tag == null || !(tag instanceof RedTouch)) {
                    return;
                }
                ((RedTouch) tag).clearRedTouch();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        int i17;
        int i18;
        int width = this.f349515h.getWidth() + this.f349515h.getPageMargin();
        if (!this.I) {
            int currentItem = this.f349515h.getCurrentItem();
            this.L = currentItem;
            this.J = (currentItem + this.N) * width;
            this.K = this.H.getScrollX();
            this.I = true;
        }
        float scrollX = this.f349515h.getScrollX() - this.J;
        if (scrollX < 0.0f) {
            i17 = this.L - 1;
        } else if (scrollX > 0.0f) {
            i17 = this.L + 1;
        } else {
            i17 = this.L;
        }
        i(scrollX);
        if (!this.f349507c0 && (i18 = this.f349513f0) != 0) {
            int i19 = this.f349509d0;
            l(i19, i18 + i19, scrollX);
        }
        View childAt = this.H.getChildAt(this.L);
        View childAt2 = this.H.getChildAt(i17);
        if (childAt == null || childAt2 == null) {
            return;
        }
        int left = childAt.getLeft() + (childAt.getWidth() / 2);
        int left2 = (int) (((childAt2.getLeft() + (childAt2.getWidth() / 2)) - left) * Math.abs(scrollX / width));
        ViewGroup viewGroup = this.H;
        viewGroup.scrollTo(this.K + left2, viewGroup.getScrollY());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public int q() {
        return this.f349510e;
    }

    public void setBlurView(boolean z16) {
        this.f349518i0.r(z16);
    }

    public void setSpeakPanel(PressToSpeakPanel pressToSpeakPanel) {
        this.C = pressToSpeakPanel;
    }

    public void setStatus(int i3) {
        int i16 = this.f349510e;
        if (QLog.isColorLevel()) {
            QLog.d("AudioPanel", 1, "setStatus status = " + i3 + ", lastStatus = " + i16 + ", needIgnorePanelState = " + this.f349520k0);
        }
        this.f349510e = i3;
        if (i3 != 2 && i3 != 3 && i3 != 4) {
            this.f349518i0.R(false);
        } else if (i16 == 1) {
            if (j(i3)) {
                this.f349520k0 = false;
            } else {
                this.f349518i0.R(true);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (this.f349508d) {
            this.f349508d = false;
        }
        if (i3 == 0) {
            ReportController.o(this.f349512f, "CliOper", "", "", "changevoice", "0X8006F49", 0, 0, "" + n(), "", "", "");
            if (n() == 0) {
                ReportController.o(this.f349512f, "CliOper", "", "", "changevoice", "0X8006F4C", 0, 0, "0", "", "", "");
            }
        }
    }

    public void t() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioPanel", 2, "hideAnimLayout ");
        }
        RelativeLayout relativeLayout = this.T;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void u(QQAppInterface qQAppInterface, m mVar) {
        this.f349512f = qQAppInterface;
        this.f349518i0 = mVar;
        this.f349515h = (AudioPanelViewPager) findViewById(R.id.fho);
        this.V = (ImageView) findViewById(R.id.swr);
        this.T = (RelativeLayout) findViewById(R.id.sws);
        this.U = (PttTextTransitionAnim) findViewById(R.id.f28860k3);
        this.f349517i = (ViewGroup) findViewById(R.id.fhm);
        this.D = (TextView) findViewById(R.id.izk);
        this.E = (TextView) findViewById(R.id.i3t);
        this.F = (TextView) findViewById(R.id.f167119l04);
        this.M = findViewById(R.id.f167118l02);
        this.H = (ViewGroup) findViewById(R.id.fhl);
        this.f349522m = new AudioPanelAdapter(qQAppInterface, this, this.f349517i, mVar);
        this.f349515h.a(this);
        this.f349515h.setAdapter(this.f349522m);
        this.f349515h.setOnPageChangeListener(this);
        this.f349515h.setCurrentItem(Math.min(1, this.f349522m.getF373114d() - 1));
        this.D.setTextColor(o());
        this.f349516h0 = SimpleUIUtil.isNowElderMode();
        if (FontSettingManager.getFontLevel() > 17.0f) {
            AudioPanelUtils.c(this.V);
        }
        this.P = true;
        this.Q = true;
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.f349529s0.sendEmptyMessage(3);
        AudioTransitionAnimManager.k().f(this);
        VideoReport.setElementId(this, "em_aio_voice_panel");
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103300");
        VideoReport.setElementParam(this, EmotionReportDtImpl.IS_RED_TIPS_BEFORE, Integer.valueOf((appInfoByPath == null || appInfoByPath.iNewFlag.get() != 1) ? 0 : 1));
        g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View] */
    public boolean x() {
        ?? r46;
        ViewGroup viewGroup = this.f349522m.f349534h;
        boolean z16 = false;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    r46 = 0;
                    break;
                }
                r46 = viewGroup.getChildAt(i3);
                if (r46.getVisibility() == 0) {
                    break;
                }
                i3++;
            }
            if (r46 != 0 && (r46 instanceof com.tencent.mobileqq.activity.aio.audiopanel.c)) {
                z16 = ((com.tencent.mobileqq.activity.aio.audiopanel.c) r46).onBackEvent();
            }
        }
        K(true);
        return z16;
    }

    private void A() {
        G(true);
        this.W = true;
        int n3 = n();
        this.f349509d0 = n3;
        this.U.setCurrentItem(n3);
        this.f349511e0 = 0.0f;
        this.f349513f0 = 0;
        this.I = false;
    }

    private void z() {
        LottieDrawable lottieDrawable;
        this.W = false;
        this.U.setCurrentItem(n());
        if (this.f349507c0 || (lottieDrawable = this.f349514g0) == null) {
            return;
        }
        lottieDrawable.endAnimation();
        t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    public void C() {
        ?? r36;
        int i3 = 0;
        com.tencent.mobileqq.activity.aio.audiopanel.b.f178314a = false;
        E();
        ViewGroup viewGroup = this.f349522m.f349534h;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            while (true) {
                if (i3 >= childCount) {
                    r36 = 0;
                    break;
                }
                r36 = viewGroup.getChildAt(i3);
                if (r36.getVisibility() == 0) {
                    break;
                } else {
                    i3++;
                }
            }
            if (r36 != 0 && (r36 instanceof com.tencent.mobileqq.activity.aio.audiopanel.c)) {
                ((com.tencent.mobileqq.activity.aio.audiopanel.c) r36).onPause();
            }
        }
        K(true);
    }

    public void I(boolean z16) {
        K(false);
        this.f349528r0 = z16;
        this.f349529s0.sendEmptyMessageDelayed(1, (z16 ? 600 : 0) + 1200);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View] */
    public void y() {
        ?? r46;
        this.f349506b0 = -1;
        ThreadManager.getUIHandler().removeCallbacks(this.f349530t0);
        AudioTransitionAnimManager.k().s();
        ViewGroup viewGroup = this.f349522m.f349534h;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    r46 = 0;
                    break;
                }
                r46 = viewGroup.getChildAt(i3);
                if (r46.getVisibility() == 0) {
                    break;
                } else {
                    i3++;
                }
            }
            if (r46 != 0 && (r46 instanceof com.tencent.mobileqq.activity.aio.audiopanel.c)) {
                ((com.tencent.mobileqq.activity.aio.audiopanel.c) r46).onDestroy();
            }
        }
        E();
        this.f349520k0 = false;
    }

    static {
        int[] iArr = {1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000};
        f349499u0 = iArr;
        f349500v0 = iArr[1] - iArr[0];
        int i3 = 55 - 4;
        f349503y0 = i3;
        f349504z0 = ((55 + i3) * 0.52f) / 1200.0f;
        A0 = ((55 + i3) * (-40)) / 1200;
    }

    void F(ViewGroup viewGroup, View view, int i3, int i16) {
        TextView textView;
        TextView textView2;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int n3 = n();
            for (int i17 = 0; i17 < childCount; i17++) {
                if (i17 != n3) {
                    View childAt = viewGroup.getChildAt(i17);
                    if (childAt instanceof TextView) {
                        TextView textView3 = (TextView) childAt;
                        textView3.setTextColor(i3);
                        textView3.setTextSize(2, this.f349516h0 ? 18.0f : 13.0f);
                    } else if (i17 == 0 && (textView2 = this.F) != null) {
                        textView2.setTextColor(i3);
                        this.F.setTextSize(2, this.f349516h0 ? 18.0f : 13.0f);
                    }
                } else if (view != null) {
                    if (view instanceof TextView) {
                        TextView textView4 = (TextView) view;
                        textView4.setTextColor(i16);
                        textView4.setTextSize(2, this.f349516h0 ? 20.0f : 15.0f);
                    } else if ((view instanceof FrameLayout) && (textView = this.F) != null) {
                        textView.setTextColor(i16);
                        this.F.setTextSize(2, this.f349516h0 ? 20.0f : 15.0f);
                    }
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int id5 = view.getId();
        k(id5);
        if (id5 == R.id.izk) {
            setCurrentPannel(1, false);
            i3 = 1;
        } else if (id5 == R.id.i3t) {
            i3 = 2;
            setCurrentPannel(2, false);
        } else {
            if (id5 == R.id.f167119l04) {
                setCurrentPannel(0, false);
                ((IRedTouchManager) this.f349512f.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103300.103301");
                Object tag = this.F.getTag();
                if (tag != null && (tag instanceof RedTouch)) {
                    ((RedTouch) tag).clearRedTouch();
                }
            }
            i3 = 0;
        }
        boolean z16 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_audio_panel_reset_scroll_page_enable_8983", true) && this.f349519j0;
        QLog.d("AudioPanel", 1, "onClick needResetScrollPage:" + z16);
        if (z16) {
            this.I = false;
            this.f349519j0 = false;
        }
        ReportController.o(this.f349512f, "CliOper", "", "", "changevoice", "0X8006F4D", 0, 0, "" + i3, "", "", "");
    }

    public void h(boolean z16) {
        if (z16) {
            setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg_robot);
        } else {
            setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
        }
    }

    public void setCurrentPannel(int i3, boolean z16) {
        if (i3 < 0 || i3 >= 3) {
            return;
        }
        if (this.f349515h.getCurrentItem() != i3) {
            this.R = z16;
            this.S = z16;
            this.f349515h.setCurrentItem(i3);
            requestLayout();
            ViewGroup viewGroup = this.H;
            F(viewGroup, viewGroup.getChildAt(this.f349515h.getCurrentItem()), p(), o());
        }
        if (this.f349515h.f349540e) {
            this.N = -i3;
        }
        this.U.setCurrentItem(i3);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        String[] strArr;
        TextView textView;
        if (i3 == 0) {
            ReportController.o(this.f349512f, "CliOper", "", "", "0X8005471", "0X8005471", 0, 0, "", "", "", "");
        } else if (i3 == 1) {
            ReportController.o(this.f349512f, "dc00898", "", "", "0X800A1D2", "0X800A1D2", 0, 0, "", "", "", "");
        }
        ViewGroup viewGroup = this.H;
        F(viewGroup, viewGroup.getChildAt(this.f349515h.getCurrentItem()), p(), o());
        this.R = false;
        if (!AppSetting.f99565y || (strArr = this.G) == null || i3 >= strArr.length) {
            return;
        }
        int i16 = 0;
        while (i16 < this.H.getChildCount()) {
            View childAt = this.H.getChildAt(i16);
            if (childAt != null && i16 < this.G.length) {
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else {
                    textView = (TextView) childAt.findViewById(R.id.f167119l04);
                }
                this.G[i16] = textView.getText().toString();
                AccessibilityUtil.x(textView, this.G[i16], i3 == i16, Button.class.getName());
            }
            i16++;
        }
        com.tencent.mobileqq.util.c.b(this.H, this.G[i3], Button.class.getName(), true);
    }

    public AudioPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f349510e = 1;
        this.G = new String[3];
        this.I = false;
        this.N = -1;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.W = false;
        this.f349505a0 = false;
        this.f349506b0 = -1;
        this.f349507c0 = false;
        this.f349513f0 = 0;
        this.f349519j0 = true;
        this.f349520k0 = false;
        this.f349529s0 = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f349530t0 = new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.AudioPanel.1
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("AudioPanel", 2, "playAnimRunable isEnabled():" + AudioPanel.this.isEnabled() + " mCurAnimType=" + AudioPanel.this.f349506b0);
                }
                if (AudioPanel.this.isEnabled()) {
                    AudioTransitionAnimManager.k().u(AudioPanel.this.f349514g0, AudioPanel.this.f349506b0, AudioPanel.this.V, AudioPanel.this.f349507c0);
                }
            }
        };
    }

    public void E() {
    }
}
