package com.tencent.qqnt.aio.audiopanel;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.MoveDistIndicateView;
import com.tencent.mobileqq.activity.aio.audiopanel.PttTipSwitchView;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeChangeView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.av;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOPttControlApi;
import com.tencent.qqnt.aio.audiopanel.c;
import com.tencent.qqnt.aio.audiopanel.e;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.UiThreadUtil;
import com.tencent.util.hapticcreator.HapticUtil;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes34.dex */
public class PressToSpeakPanel extends RelativeLayout implements d.a, View.OnTouchListener, com.tencent.mobileqq.activity.aio.audiopanel.c {

    /* renamed from: s0, reason: collision with root package name */
    private static boolean f349602s0;
    private VolumeChangeView C;
    private TextView D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private MoveDistIndicateView H;
    private MoveDistIndicateView I;
    private ViewGroup J;
    private PopupWindow K;
    private View L;
    private int M;
    private Handler N;
    private ViewGroup P;
    private boolean Q;
    private int R;
    private int S;
    private SharedPreferences T;
    private int U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f349603a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f349604b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.ptt.a f349605c0;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f349606d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f349607d0;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f349608e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f349609e0;

    /* renamed from: f, reason: collision with root package name */
    private AudioPanel f349610f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f349611f0;

    /* renamed from: g0, reason: collision with root package name */
    private final int f349612g0;

    /* renamed from: h, reason: collision with root package name */
    private PttTipSwitchView f349613h;

    /* renamed from: h0, reason: collision with root package name */
    private final int f349614h0;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f349615i;

    /* renamed from: i0, reason: collision with root package name */
    private int f349616i0;

    /* renamed from: j0, reason: collision with root package name */
    private double f349617j0;

    /* renamed from: k0, reason: collision with root package name */
    private double f349618k0;

    /* renamed from: l0, reason: collision with root package name */
    private double f349619l0;

    /* renamed from: m, reason: collision with root package name */
    private VolumeChangeView f349620m;

    /* renamed from: m0, reason: collision with root package name */
    private double f349621m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f349622n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f349623o0;

    /* renamed from: p0, reason: collision with root package name */
    private double f349624p0;

    /* renamed from: q0, reason: collision with root package name */
    private m f349625q0;

    /* renamed from: r0, reason: collision with root package name */
    private com.tencent.qqnt.aio.audiopanel.c f349626r0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationEnd is called,time is:" + System.currentTimeMillis());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationRepeat is called,time is:" + System.currentTimeMillis());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationStart is called,time is:" + System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!AppSetting.f99565y || PressToSpeakPanel.this.U <= 0 || PressToSpeakPanel.this.V || PressToSpeakPanel.this.f349610f.n() != 1) {
                return;
            }
            PressToSpeakPanel.this.V = true;
            PressToSpeakPanel.this.U--;
            PressToSpeakPanel pressToSpeakPanel = PressToSpeakPanel.this;
            com.tencent.mobileqq.util.c.a(pressToSpeakPanel, pressToSpeakPanel.getContext().getString(R.string.a_j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class e implements c.b {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<PressToSpeakPanel> f349643a;

        e(PressToSpeakPanel pressToSpeakPanel) {
            this.f349643a = new WeakReference<>(pressToSpeakPanel);
        }

        @Override // com.tencent.qqnt.aio.audiopanel.c.b
        public void a(boolean z16) {
            PressToSpeakPanel pressToSpeakPanel = this.f349643a.get();
            if (pressToSpeakPanel != null) {
                pressToSpeakPanel.L(z16);
            }
        }
    }

    public PressToSpeakPanel(Context context) {
        super(context);
        this.M = -1;
        this.Q = false;
        this.R = 0;
        this.S = 0;
        this.U = 0;
        this.V = false;
        this.f349607d0 = true;
        this.f349609e0 = true;
        this.f349611f0 = true;
        this.f349612g0 = 80;
        this.f349614h0 = 42;
        this.f349622n0 = 100;
        this.f349623o0 = 0;
    }

    private int A(int i3, boolean z16, View view, double d16, double d17) {
        int i16 = this.f349623o0;
        if (view.getVisibility() != 0) {
            return i16;
        }
        if (d16 == 0.0d || d17 == 0.0d) {
            G();
        }
        if (z16) {
            if (i3 <= d16 && d16 > 0.0d) {
                return this.f349622n0;
            }
            if (i3 > this.f349616i0) {
                return this.f349623o0;
            }
        } else {
            if (i3 >= d16 && d16 > 0.0d) {
                return this.f349622n0;
            }
            if (i3 < this.f349616i0) {
                return this.f349623o0;
            }
        }
        if (Math.abs(i3 - d16) < d17 * 1.5d) {
            return this.f349622n0;
        }
        return this.f349623o0;
    }

    private int C(int i3) {
        return getContext().getColorStateList(i3).getDefaultColor();
    }

    private void G() {
        this.f349616i0 = ScreenUtil.getRealWidth(getContext()) / 2;
        double width = this.H.getWidth();
        this.H.getLocationOnScreen(new int[2]);
        double d16 = width / 2.0d;
        this.f349617j0 = r0[0] + d16;
        if (AppSetting.f99565y) {
            d16 = width * 0.8d;
        }
        this.f349618k0 = d16;
        double width2 = this.I.getWidth();
        this.I.getLocationOnScreen(new int[2]);
        double d17 = width2 / 2.0d;
        this.f349619l0 = r0[0] + d17;
        if (AppSetting.f99565y) {
            d17 = width2 * 0.8d;
        }
        this.f349621m0 = d17;
    }

    private void H() {
        com.tencent.qqnt.aio.audiopanel.c cVar = new com.tencent.qqnt.aio.audiopanel.c();
        this.f349626r0 = cVar;
        cVar.g(new e(this));
    }

    private void I() {
        String str;
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.aqx, (ViewGroup) null);
        textView.setTextColor(C(R.color.qui_common_text_secondary));
        com.tencent.qqnt.aio.audiopanel.e.b(textView);
        if (VasUtil.getSignedService(this.f349606d).getVipStatus().isVip() && K()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.aqy, (ViewGroup) null);
            if (VasUtil.getSignedService(this.f349606d).getVipStatus().isSVip()) {
                ((TextView) linearLayout.findViewById(R.id.g3h)).setText(z(new SpannableString(getContext().getString(R.string.fv_, "5\u5206\u949f")), "5\u5206\u949f"));
                ((ImageView) linearLayout.findViewById(R.id.g3g)).setImageResource(R.drawable.dvd);
            } else {
                ((TextView) linearLayout.findViewById(R.id.g3h)).setText(z(new SpannableString(getContext().getString(R.string.fvo, "3\u5206\u949f")), "3\u5206\u949f"));
                ((ImageView) linearLayout.findViewById(R.id.g3g)).setImageResource(R.drawable.e6r);
            }
            this.f349613h.addView(linearLayout);
            this.f349613h.addView(textView);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PressToSpeakPanel.this.f349613h != null) {
                        PressToSpeakPanel.this.f349613h.c();
                    }
                }
            }, 2000L);
            this.f349606d.getApp().getSharedPreferences("pref_ppt_hint" + this.f349606d.getCurrentAccountUin(), 0).edit().putLong("key_last_show_vip_tips", System.currentTimeMillis()).apply();
            String currentAccountUin = this.f349606d.getCurrentAccountUin();
            String netWorkTypeByStr = HttpUtil.getNetWorkTypeByStr();
            if (VasUtil.getSignedService(this.f349606d).getVipStatus().isSVip()) {
                str = "svip";
            } else {
                str = "vip";
            }
            VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "PanelPrivilegeView", "TailView", "0", 1, 0, 0, netWorkTypeByStr, "", str);
        } else {
            this.f349613h.addView(textView);
        }
        AccessibilityUtil.n(textView, false);
    }

    private boolean K() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel onCallStateChanged isCalling = " + z16);
        }
        if (z16) {
            long uptimeMillis = SystemClock.uptimeMillis();
            X(new View(getContext()), MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.f349620m.setColor(getContext().getColor(R.color.qui_common_icon_primary));
        this.f349620m.setBgColor(getContext().getColor(R.color.qui_common_fill_standard_secondary));
        this.C.setColor(getContext().getColor(R.color.qui_common_icon_primary));
        this.C.setBgColor(getContext().getColor(R.color.qui_common_fill_standard_secondary));
        if (!QQTheme.isNowThemeSimpleNight() && !QQTheme.isNowThemeIsNight()) {
            this.E.setImageResource(R.drawable.lmi);
            this.F.setImageResource(R.drawable.lmk);
            this.G.setImageResource(R.drawable.lmh);
        } else {
            this.E.setImageResource(R.drawable.lmj);
            this.F.setImageResource(R.drawable.lml);
            this.G.setImageResource(R.drawable.lmm);
        }
        S();
    }

    private void R(boolean z16) {
        this.G.setActivated(z16);
        this.E.setActivated(z16);
        this.F.setActivated(z16);
    }

    private final void S() {
        this.D.setTextColor(C(R.color.qui_common_text_secondary));
        this.f349620m.setColor(C(R.color.qui_common_icon_primary));
        this.f349620m.setBgColor(C(R.color.qui_common_fill_standard_secondary));
        this.C.setColor(C(R.color.qui_common_icon_primary));
        this.C.setBgColor(C(R.color.qui_common_fill_standard_secondary));
    }

    private void V(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154930tv));
    }

    private void W(MoveDistIndicateView moveDistIndicateView, int i3) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154931tw);
        loadAnimation.setAnimationListener(new a(moveDistIndicateView, i3));
        moveDistIndicateView.startAnimation(loadAnimation);
    }

    private void X(View view, MotionEvent motionEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.stopRecord(), touchValid is:" + this.Q);
        }
        this.H.clearAnimation();
        this.I.clearAnimation();
        this.E.clearAnimation();
        this.F.clearAnimation();
        R(false);
        if (this.Q) {
            this.Q = false;
            if (this.f349625q0.isRecording()) {
                D(view, motionEvent);
                return;
            }
            return;
        }
        this.N.removeMessages(1);
    }

    private void w() {
        if (XPanelContainer.f384714h0 != ((int) (getContext().getResources().getDisplayMetrics().density * 196.0f))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
            layoutParams.topMargin = 0;
            this.J.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
            layoutParams2.topMargin = ScreenUtil.dip2px(42.0f);
            this.J.setLayoutParams(layoutParams2);
        }
    }

    private void x(View view) {
        if (!AppSetting.f99565y) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "is not talkback mode, return");
                return;
            }
            return;
        }
        if (view != null) {
            CharSequence contentDescription = view.getContentDescription();
            if (TextUtils.isEmpty(contentDescription)) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOAudioPanel", 2, "view:" + view + " contentDescription is null, return");
                    return;
                }
                return;
            }
            if (HardCodeUtil.qqStr(R.string.pcm).equals(contentDescription)) {
                com.tencent.mobileqq.util.c.a(view, HardCodeUtil.qqStr(R.string.pcn));
            } else if (HardCodeUtil.qqStr(R.string.pck).equals(contentDescription)) {
                com.tencent.mobileqq.util.c.a(view, HardCodeUtil.qqStr(R.string.f214625te));
            } else if (HardCodeUtil.qqStr(R.string.pcj).equals(contentDescription)) {
                com.tencent.mobileqq.util.c.a(view, HardCodeUtil.qqStr(R.string.pci));
            }
        }
    }

    private void y() {
        if (HapticUtil.INSTANCE.isExperiment()) {
            return;
        }
        ((Vibrator) this.f349606d.getApp().getSystemService("vibrator")).vibrate(50L);
    }

    public ImageView B() {
        return this.G;
    }

    public void E(int i3) {
        int a16 = this.f349605c0.a(i3);
        this.f349620m.c(a16);
        this.C.c(a16);
    }

    public void F(QQAppInterface qQAppInterface, ViewGroup viewGroup, AudioPanel audioPanel, ViewGroup viewGroup2, m mVar) {
        this.f349606d = qQAppInterface;
        this.P = viewGroup;
        this.f349610f = audioPanel;
        this.f349625q0 = mVar;
        audioPanel.setSpeakPanel(this);
        this.f349608e = viewGroup2;
        this.N = new Handler(Looper.getMainLooper());
        this.f349613h = (PttTipSwitchView) findViewById(R.id.g3e);
        this.f349615i = (ViewGroup) findViewById(R.id.djl);
        this.f349620m = (VolumeChangeView) findViewById(R.id.djn);
        this.C = (VolumeChangeView) findViewById(R.id.djo);
        this.D = (TextView) findViewById(R.id.izm);
        this.E = (ImageView) findViewById(R.id.f27010f3);
        this.F = (ImageView) findViewById(R.id.f27020f4);
        this.G = (ImageView) findViewById(R.id.press_to_speak_iv);
        MoveDistIndicateView moveDistIndicateView = (MoveDistIndicateView) findViewById(R.id.bxo);
        this.H = moveDistIndicateView;
        moveDistIndicateView.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createThemeViewPresenter(this.H));
        this.H.setType(1);
        this.H.setDisableCustomDraw(true);
        if (J()) {
            this.H.setImageResource(R.drawable.koj);
            this.H.setContentDescription(HardCodeUtil.qqStr(R.string.pcm));
        } else {
            this.H.setImageResource(R.drawable.aa7);
            this.H.setContentDescription(HardCodeUtil.qqStr(R.string.pck));
        }
        MoveDistIndicateView moveDistIndicateView2 = (MoveDistIndicateView) findViewById(R.id.izl);
        this.I = moveDistIndicateView2;
        moveDistIndicateView2.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createThemeViewPresenter(this.I));
        this.I.setType(0);
        this.I.setContentDescription(HardCodeUtil.qqStr(R.string.pcj));
        this.I.setDisableCustomDraw(true);
        this.I.setImageResource(R.drawable.kok);
        this.J = (ViewGroup) findViewById(R.id.djk);
        this.G.setOnTouchListener(this);
        Resources resources = getResources();
        if (viewGroup2.getVisibility() == 4) {
            setPadding(getPaddingLeft(), getPaddingTop() + BaseAIOUtils.f(12.5f, resources), getPaddingRight(), getPaddingBottom());
        }
        if (XPanelContainer.f384714h0 <= XPanelContainer.f384715i0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f349615i.getLayoutParams();
            marginLayoutParams.topMargin = (int) resources.getDimension(R.dimen.d5u);
            this.f349615i.setLayoutParams(marginLayoutParams);
        }
        P();
        if (FontSettingManager.getFontLevel() > 17.0f) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f349615i.getLayoutParams();
            marginLayoutParams2.topMargin = 0;
            this.f349615i.setLayoutParams(marginLayoutParams2);
            AudioPanelUtils.c(this.E);
            AudioPanelUtils.c(this.F);
            AudioPanelUtils.c(this.G);
            AudioPanelUtils.c(this.H);
            AudioPanelUtils.c(this.I);
        }
        I();
        this.f349605c0 = ((IPttUtils) QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
        if (this.M == -1) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.M = (rect.right / 2) - BaseAIOUtils.f(75.0f, resources);
        }
        if (AppSetting.f99565y) {
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("pref_ppt_hint" + qQAppInterface.getCurrentAccountUin(), 0);
            this.T = sharedPreferences;
            this.U = sharedPreferences.getInt("key_ppt_hint", 3);
            this.V = false;
            setFocusable(false);
            ViewCompat.setImportantForAccessibility(this, 2);
            ViewCompat.setImportantForAccessibility(this.f349613h, 2);
            ViewCompat.setImportantForAccessibility(this.E, 2);
            ViewCompat.setImportantForAccessibility(this.F, 2);
            this.G.setContentDescription(getContext().getString(R.string.f170274kz));
            ViewCompat.setAccessibilityDelegate(this.G, new c());
        }
        H();
    }

    public boolean J() {
        RecordParams.RecorderParam c16 = RecordParams.c(this.f349606d, false);
        av avVar = (av) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100828");
        return avVar != null && avVar.b() && c16.f307257f == 1;
    }

    public void O(boolean z16) {
        if ((getContext() instanceof Activity) && ((Activity) getContext()).isFinishing()) {
            return;
        }
        this.J.setVisibility(8);
        this.f349613h.setVisibility(0);
        this.f349615i.setVisibility(8);
        this.H.clearAnimation();
        this.I.clearAnimation();
        this.E.clearAnimation();
        this.F.clearAnimation();
        this.W = false;
        this.f349604b0 = false;
        this.f349603a0 = false;
        R(false);
        this.G.setVisibility(0);
        this.D.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0d));
        this.f349620m.setVisibility(8);
        this.C.setVisibility(8);
        this.f349608e.setVisibility(0);
        P();
        this.f349610f.setStatus(1);
        if (!z16 && J() && this.R == 0) {
            return;
        }
        PopupWindow popupWindow = this.K;
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                try {
                    this.K.dismiss();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", e16);
                    }
                }
            }
            this.K = null;
        }
        View view = this.L;
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) this.L.getParent()).removeView(this.L);
            }
            this.L = null;
        }
    }

    public void T() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, " PressToSpeakPanel.startRecord() is called, time is " + System.currentTimeMillis());
        }
        this.f349620m.b();
        this.C.b();
        this.J.setVisibility(0);
        this.f349613h.setVisibility(8);
        this.f349615i.setVisibility(0);
        this.G.setVisibility(0);
        this.f349620m.setVisibility(0);
        this.C.setVisibility(0);
        this.f349608e.setVisibility(4);
        this.H.setLevel(0);
        this.I.setLevel(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(150L);
        animationSet.setInterpolator(new LinearInterpolator());
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.86f, 1.0f, 0.86f, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new d());
        this.J.startAnimation(animationSet);
    }

    void U() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154928tt);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154929tu);
        loadAnimation.setAnimationListener(new b());
        this.E.startAnimation(loadAnimation);
        this.F.startAnimation(loadAnimation2);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public boolean onBackEvent() {
        boolean isRecording = this.f349625q0.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBackEvent() is called,isRecording is:" + isRecording);
        }
        if (!isRecording) {
            return false;
        }
        this.f349625q0.j(false);
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam) {
        return k.b();
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onDestroy() {
        N();
        boolean isRecording = this.f349625q0.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + isRecording);
        }
        if (isRecording) {
            this.f349625q0.j(false);
        }
        if (AppSetting.f99565y && this.V) {
            this.T.edit().putInt("key_ppt_hint", this.U).commit();
        }
        com.tencent.qqnt.aio.audiopanel.c cVar = this.f349626r0;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitFailed() is called");
        }
        this.f349625q0.g0(str, true, recorderParam);
        this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.12
            @Override // java.lang.Runnable
            public void run() {
                PressToSpeakPanel.this.O(true);
            }
        });
        ReportController.o(this.f349606d, "CliOper", "", "", "0X8005A17", "0X8005A17", 13, 0, "", "", "", AppSetting.f99551k);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitSuccess() is called");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onPause() {
        boolean isRecording = this.f349625q0.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onPause() is called,isRecording is:" + isRecording);
        }
        if (isRecording) {
            this.S = 1;
            this.f349625q0.j(false);
            this.f349625q0.W0();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam) {
        this.f349625q0.g0(str, true, recorderParam);
        this.f349625q0.I0(recorderParam);
        this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.13
            @Override // java.lang.Runnable
            public void run() {
                PressToSpeakPanel.this.O(true);
            }
        });
        ReportController.o(this.f349606d, "CliOper", "", "", "0X8005A17", "0X8005A17", 14, 0, "", "", "", AppSetting.f99551k);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderError() is called,path is:" + str + " err: " + str2);
        }
        this.f349625q0.g0(str, false, recorderParam);
        this.f349625q0.I0(recorderParam);
        this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.11
            @Override // java.lang.Runnable
            public void run() {
                PressToSpeakPanel.this.O(true);
            }
        });
        ReportController.o(this.f349606d, "CliOper", "", "", "0X8005A17", "0X8005A17", 12, 0, "", "", "", AppSetting.f99551k);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderPrepare() is called,path is:" + str);
        }
        this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.4
            @Override // java.lang.Runnable
            public void run() {
                PressToSpeakPanel.this.M();
            }
        });
        com.tencent.qqnt.aio.audiopanel.e.f(R.raw.f169416n, str);
        this.f349625q0.C0(str, 0.0f, new ArrayList<>(), recorderParam, false, false, 0);
        this.f349625q0.c();
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(String str, byte[] bArr, int i3, final int i16, final double d16, RecordParams.RecorderParam recorderParam) {
        this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.14
            @Override // java.lang.Runnable
            public void run() {
                if (PressToSpeakPanel.this.f349605c0.b()) {
                    PressToSpeakPanel.this.E(i16);
                }
                int color = PressToSpeakPanel.this.getContext().getColor(R.color.qui_common_fill_standard_secondary);
                int color2 = PressToSpeakPanel.this.getContext().getColor(R.color.qui_common_icon_primary);
                int color3 = PressToSpeakPanel.this.getContext().getColor(R.color.qui_common_text_secondary);
                if (PressToSpeakPanel.this.R != 1) {
                    if (PressToSpeakPanel.this.R == 2) {
                        PressToSpeakPanel.this.D.setText(HardCodeUtil.qqStr(R.string.pci));
                    } else {
                        PressToSpeakPanel.this.D.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(d16));
                        PressToSpeakPanel.this.P();
                        return;
                    }
                } else if (PressToSpeakPanel.this.J()) {
                    PressToSpeakPanel.this.D.setText(HardCodeUtil.qqStr(R.string.pcn));
                } else {
                    PressToSpeakPanel.this.D.setText(HardCodeUtil.qqStr(R.string.pcl));
                }
                PressToSpeakPanel.this.f349620m.setColor(color2);
                PressToSpeakPanel.this.f349620m.setBgColor(color);
                PressToSpeakPanel.this.C.setColor(color2);
                PressToSpeakPanel.this.C.setBgColor(color);
                PressToSpeakPanel.this.D.setTextColor(color3);
            }
        });
        this.f349624p0 = d16;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
        }
        if (this.f349607d0) {
            y();
            this.f349607d0 = false;
        }
        this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.5
            @Override // java.lang.Runnable
            public void run() {
                PressToSpeakPanel.this.T();
            }
        });
        PttInfoCollector.reportCostUntilPrepare(1);
        this.f349624p0 = 0.0d;
        return 250;
    }

    public SpannableString z(SpannableString spannableString, String str) {
        int indexOf = spannableString.toString().indexOf(str);
        if (indexOf < 0) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(-1145334), indexOf, str.length() + indexOf, 33);
        return spannableString;
    }

    private void Q() {
        this.f349607d0 = true;
        this.f349609e0 = true;
        this.f349611f0 = true;
    }

    public void M() {
        com.tencent.mobileqq.activity.aio.l.f179531g = true;
        this.J.setVisibility(8);
        this.f349613h.setVisibility(8);
        this.f349615i.setVisibility(8);
        this.G.setVisibility(0);
        this.f349620m.setVisibility(8);
        this.C.setVisibility(8);
        this.f349608e.setVisibility(4);
    }

    public void N() {
        O(false);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int i3) {
        if (i3 == 1) {
            ReportController.o(this.f349606d, "CliOper", "", "", "0X800484C", "0X800484C", 0, 0, "", "", "", "");
        }
    }

    public boolean D(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        if (action == 0 || action == 2) {
            this.R = 3;
            this.S = 3;
            if (this.H.getVisibility() == 0) {
                int A = A(rawX, true, this.H, this.f349617j0, this.f349618k0);
                int i3 = this.f349622n0;
                if (A <= i3) {
                    i3 = A;
                }
                if (A > 80) {
                    this.R = 1;
                    this.S = 1;
                    if (this.f349609e0) {
                        this.f349609e0 = false;
                        V(this.H);
                        HapticUtil.INSTANCE.play(view);
                        y();
                        x(this.H);
                        this.f349603a0 = true;
                    }
                    this.H.setLevel(i3);
                } else {
                    this.f349620m.setVisibility(0);
                    this.C.setVisibility(0);
                    if (A < 42 && !this.f349609e0) {
                        this.f349609e0 = true;
                    }
                    if (this.f349603a0) {
                        this.f349603a0 = false;
                        W(this.H, i3);
                    } else {
                        this.H.setLevel(i3);
                    }
                }
            }
            if (this.I.getVisibility() == 0) {
                int A2 = A(rawX, false, this.I, this.f349619l0, this.f349621m0);
                int i16 = this.f349622n0;
                if (A2 <= i16) {
                    i16 = A2;
                }
                if (A2 > 80) {
                    this.R = 2;
                    this.S = 2;
                    if (this.f349611f0) {
                        this.f349611f0 = false;
                        V(this.I);
                        HapticUtil.INSTANCE.play(view);
                        y();
                        x(this.I);
                        this.f349604b0 = true;
                    }
                    this.I.setLevel(i16);
                } else {
                    this.f349620m.setVisibility(0);
                    this.C.setVisibility(0);
                    if (A2 < 42 && !this.f349611f0) {
                        this.f349611f0 = true;
                    }
                    if (this.f349604b0) {
                        this.f349604b0 = false;
                        W(this.I, i16);
                    } else {
                        this.I.setLevel(i16);
                    }
                }
            }
            if (view.getId() == R.id.press_to_speak_iv) {
                if (!this.H.isPressed() && !this.I.isPressed()) {
                    this.H.clearAnimation();
                    this.I.clearAnimation();
                    R(false);
                    if (this.W) {
                        this.W = false;
                        U();
                    }
                } else {
                    this.E.clearAnimation();
                    this.F.clearAnimation();
                    R(true);
                    this.W = true;
                }
            }
        } else if (action == 1 || action == 3) {
            this.H.setLevel(0);
            this.I.setLevel(0);
            this.f349620m.setVisibility(8);
            this.C.setVisibility(8);
            int i17 = this.R;
            if (i17 == 2) {
                ReportController.o(null, "dc00898", "", "", "0X800A1D5", "0X800A1D5", 1, 0, "", "", "", "");
                if (AppSetting.f99565y) {
                    com.tencent.mobileqq.util.c.a(this.P, getContext().getString(R.string.a_f));
                }
                this.f349625q0.W0();
                this.S = 2;
            } else if (i17 == 1) {
                this.f349625q0.W0();
                this.S = 1;
            }
            this.f349625q0.j(false);
            this.R = 0;
            this.W = false;
            this.f349604b0 = false;
            this.f349603a0 = false;
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        this.f349610f.L();
        if (view.getId() != R.id.press_to_speak_iv) {
            return false;
        }
        if (action == 0) {
            ((IAIOPttControlApi) QRoute.api(IAIOPttControlApi.class)).pauseCurrentPttPlay();
            HapticUtil.INSTANCE.play(view);
            w();
            ReportController.o(null, "dc00898", "", "", "0X800A1D3", "0X800A1D3", 1, 0, "", "", "", "");
            R(false);
            Q();
            G();
            Message obtain = Message.obtain(this.N, new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.15

                /* renamed from: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel$15$a */
                /* loaded from: classes34.dex */
                class a implements e.a {
                    a() {
                    }

                    @Override // com.tencent.qqnt.aio.audiopanel.e.a
                    public void onStart() {
                        m mVar = PressToSpeakPanel.this.f349625q0;
                        PressToSpeakPanel pressToSpeakPanel = PressToSpeakPanel.this;
                        mVar.s0(pressToSpeakPanel, RecordParams.c(pressToSpeakPanel.f349606d, false));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    PressToSpeakPanel.this.Q = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAudioPanel", 2, "delay start record runnable is run,touchValid is:" + PressToSpeakPanel.this.Q);
                    }
                    if (!PressToSpeakPanel.f349602s0) {
                        PressToSpeakPanel.f349602s0 = true;
                        PressToChangeVoicePanel.h(PressToSpeakPanel.this.f349606d, false, "0X8006385");
                    }
                    if (PressToSpeakPanel.this.f349625q0.H0()) {
                        PressToSpeakPanel.this.f349610f.setStatus(2);
                        PressToSpeakPanel.this.D(view, motionEvent);
                        com.tencent.qqnt.aio.audiopanel.e.e(R.raw.f169416n, new a());
                        PressToSpeakPanel.this.U();
                        int v3 = PressToSpeakPanel.this.getResources().getDisplayMetrics().heightPixels - PressToSpeakPanel.this.f349625q0.v();
                        PressToSpeakPanel pressToSpeakPanel = PressToSpeakPanel.this;
                        pressToSpeakPanel.K = AudioPanel.H(pressToSpeakPanel.getContext(), PressToSpeakPanel.this.getWidth(), v3, PressToSpeakPanel.this, 0, 0, 0, 0);
                    }
                }
            });
            obtain.what = 1;
            this.N.sendMessageDelayed(obtain, 150L);
        } else if (action == 2) {
            if (this.Q && this.f349625q0.isRecording()) {
                D(view, motionEvent);
            }
        } else if (action == 3 || action == 1) {
            X(view, motionEvent);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(final String str, final RecordParams.RecorderParam recorderParam, final double d16) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.i("AIOAudioPanel", 2, "onRecorderEnd recordTime:" + this.f349624p0 + ", pressState:" + this.S + ", path:" + str);
        }
        if (this.f349624p0 < 500.0d) {
            this.f349625q0.O(str);
            this.f349625q0.I0(recorderParam);
            this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(PressToSpeakPanel.this.getContext(), R.string.f170312ly, 1).show();
                    PressToSpeakPanel.this.O(true);
                }
            });
            ReportController.o(this.f349606d, "CliOper", "", "", "0X8005A17", "0X8005A17", 11, 0, String.valueOf((int) this.f349624p0), "", "", AppSetting.f99551k);
            return;
        }
        if (this.f349624p0 > com.tencent.mobileqq.activity.aio.item.n.c(this.f349606d, "Normal_MaxPtt") * 1000) {
            com.tencent.mobileqq.vip.api.f highestVipType = ((IVipInfoUtils) QRoute.api(IVipInfoUtils.class)).getHighestVipType(((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f349606d.getAccount()), "AIOAudioPanel"));
            if (highestVipType.c()) {
                str2 = "bigvip";
            } else if (highestVipType.e()) {
                str2 = "svip";
            } else if (highestVipType.d()) {
                str2 = "vip";
            } else {
                str2 = "other";
            }
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "aio", "long_voice", "", "send_voice", "", "61", 121, 0, 0, "", String.format("{\"user_id\":\"%s\"}", str2), "");
        }
        ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(1, (int) this.f349624p0);
        int i3 = this.S;
        if (i3 == 1) {
            if (J()) {
                this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.7
                    @Override // java.lang.Runnable
                    public void run() {
                        PressToSpeakPanel.this.O(true);
                        m mVar = PressToSpeakPanel.this.f349625q0;
                        String str3 = str;
                        float f16 = (float) d16;
                        RecordParams.RecorderParam recorderParam2 = recorderParam;
                        mVar.B(str3, f16, k.c(recorderParam2.D, recorderParam2.C), recorderParam);
                    }
                });
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A1D6", "0X800A1D6", 1, 0, "", "", "", "");
                this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ListenPanel listenPanel = (ListenPanel) PressToSpeakPanel.this.P.findViewById(R.id.ebv);
                        listenPanel.setVisibility(0);
                        listenPanel.setAudioPath(str, PressToSpeakPanel.this.f349624p0, recorderParam);
                        listenPanel.setJumpSource(ListenPanel.f349575c0);
                        RecordParams.RecorderParam recorderParam2 = recorderParam;
                        listenPanel.setAudioData(k.c(recorderParam2.D, recorderParam2.C));
                        PressToSpeakPanel.this.f349610f.setStatus(4);
                        PressToSpeakPanel.this.setVisibility(8);
                    }
                });
            }
        } else if (i3 == 3) {
            ReportController.o(null, "dc00898", "", "", "0X800A1D4", "0X800A1D4", 1, 0, "", "", "", "");
            this.f349625q0.P0(str, (int) d16, k.c(recorderParam.D, recorderParam.C), recorderParam);
            this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.9
                @Override // java.lang.Runnable
                public void run() {
                    PressToSpeakPanel.this.O(true);
                }
            });
        } else {
            this.N.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToSpeakPanel.10
                @Override // java.lang.Runnable
                public void run() {
                    PressToSpeakPanel.this.O(true);
                }
            });
        }
        this.S = 0;
    }

    public PressToSpeakPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.M = -1;
        this.Q = false;
        this.R = 0;
        this.S = 0;
        this.U = 0;
        this.V = false;
        this.f349607d0 = true;
        this.f349609e0 = true;
        this.f349611f0 = true;
        this.f349612g0 = 80;
        this.f349614h0 = 42;
        this.f349622n0 = 100;
        this.f349623o0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MoveDistIndicateView f349637d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f349638e;

        a(MoveDistIndicateView moveDistIndicateView, int i3) {
            this.f349637d = moveDistIndicateView;
            this.f349638e = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            try {
                this.f349637d.setLevel(this.f349638e);
            } catch (Throwable th5) {
                QLog.e("AIOAudioPanel", 1, "startSttOrDelButtonScaleOutAnim() error!", th5);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
