package cooperation.vip.ad;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.RoundRectImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UserLeadingActivity extends QBaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener, SimpleEventReceiver {
    private static String A0 = "qun.qq.com";
    private static String B0 = "http://127.0.0.1:38989/index.bundle?debugUrl=ws%3A%2F%2F127.0.0.1%3A38989%2Fdebugger-proxy";
    private static String C0 = "_VAS_DEBUG_DEMO_";
    private static String D0 = "pg_bas_half_screen_pop_floating_layer";
    private static String E0 = "advertising_id";
    private static String F0 = "trace_info";

    /* renamed from: a0, reason: collision with root package name */
    private AppInterface f391080a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f391081b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f391082c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f391083d0;

    /* renamed from: e0, reason: collision with root package name */
    private LinearLayout f391084e0;

    /* renamed from: f0, reason: collision with root package name */
    private ViewPager f391085f0;

    /* renamed from: g0, reason: collision with root package name */
    private LinearLayout f391086g0;

    /* renamed from: h0, reason: collision with root package name */
    private ImageView f391087h0;

    /* renamed from: i0, reason: collision with root package name */
    private Button f391088i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f391089j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f391090k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f391091l0;

    /* renamed from: m0, reason: collision with root package name */
    private UserLeadingDialogModel[] f391092m0;

    /* renamed from: n0, reason: collision with root package name */
    private ah[] f391093n0;

    /* renamed from: o0, reason: collision with root package name */
    private UserLeadingHippyFragment f391094o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f391095p0;

    /* renamed from: q0, reason: collision with root package name */
    private UserLeadingAdapter f391096q0;

    /* renamed from: s0, reason: collision with root package name */
    private GestureDetector f391098s0;

    /* renamed from: t0, reason: collision with root package name */
    private FragmentManager f391099t0;

    /* renamed from: u0, reason: collision with root package name */
    private FragmentTransaction f391100u0;

    /* renamed from: x0, reason: collision with root package name */
    boolean f391103x0;

    /* renamed from: r0, reason: collision with root package name */
    private int f391097r0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    private int f391101v0 = 2000;

    /* renamed from: w0, reason: collision with root package name */
    private long f391102w0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    private Handler f391104y0 = new b();

    /* renamed from: z0, reason: collision with root package name */
    private Runnable f391105z0 = new Runnable() { // from class: cooperation.vip.ad.UserLeadingActivity.3
        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = UserLeadingActivity.this.f391104y0.obtainMessage();
            obtainMessage.what = ActivityResultManager.ACTION_REQUEST_PERMISSION;
            UserLeadingActivity.this.f391104y0.sendMessage(obtainMessage);
            UserLeadingActivity.this.f391104y0.removeCallbacks(UserLeadingActivity.this.f391105z0);
            UserLeadingActivity.this.f391104y0.postDelayed(this, UserLeadingActivity.this.f391101v0);
        }
    };

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 9527 && UserLeadingActivity.this.f391085f0 != null && UserLeadingActivity.this.f391096q0 != null) {
                int currentItem = UserLeadingActivity.this.f391085f0.getCurrentItem();
                int f373114d = UserLeadingActivity.this.f391096q0.getF373114d();
                QLog.d("UserLeadingBaseActivity", 1, "scrolling, currentItemIndex:" + currentItem + ",itemsCount:" + f373114d);
                int i3 = currentItem + 1;
                if (i3 < f373114d) {
                    UserLeadingActivity.this.f391085f0.setCurrentItem(i3, true);
                } else {
                    UserLeadingActivity.this.f391085f0.setCurrentItem(0, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(api = 16)
        public void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams = UserLeadingActivity.this.f391085f0.getLayoutParams();
            layoutParams.height = UserLeadingActivity.this.n3();
            UserLeadingActivity.this.f391085f0.setLayoutParams(layoutParams);
            QLog.i("UserLeadingBaseActivity", 1, "onGlobalLayout   | width = " + UserLeadingActivity.this.f391085f0.getMeasuredWidth() + " | height = " + layoutParams.height);
            UserLeadingActivity.this.f391085f0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (motionEvent2 != null && motionEvent != null && motionEvent2.getRawY() - motionEvent.getRawY() > 200.0f) {
                UserLeadingActivity.this.i3();
                UserLeadingActivity.this.finish();
                return true;
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }
    }

    public static final float D3(int i3, Resources resources) {
        if (i3 == 0) {
            return 0.0f;
        }
        return i3 / resources.getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F3(RelativeLayout relativeLayout, ImageView imageView, TextView textView, URLDrawable uRLDrawable) {
        if (relativeLayout != null && uRLDrawable != null) {
            relativeLayout.setBackground(uRLDrawable);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    private void G3() {
        E3(true);
        t3();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        translateAnimation.setAnimationListener(new a());
        this.f391084e0.startAnimation(translateAnimation);
    }

    private void H3() {
        QLog.d("UserLeadingBaseActivity", 1, "startAutoScroll   intervalTime = " + this.f391101v0);
        int i3 = this.f391101v0;
        if (i3 > 0) {
            this.f391104y0.postDelayed(this.f391105z0, i3);
        }
    }

    public static final int dp2px(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private void l3() {
        super.finish();
        overridePendingTransition(0, 0);
        QLog.i("UserLeadingBaseActivity", 1, "finishWithoutAnimation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n3() {
        String[] split;
        int measuredWidth = this.f391085f0.getMeasuredWidth();
        if (measuredWidth <= 0) {
            measuredWidth = p3();
        }
        UserLeadingDialogModel[] userLeadingDialogModelArr = this.f391092m0;
        float f16 = 0.98f;
        if (userLeadingDialogModelArr != null && userLeadingDialogModelArr.length > 0 && !TextUtils.isEmpty(userLeadingDialogModelArr[0].getResCustomHippyWh()) && (split = this.f391092m0[0].getResCustomHippyWh().split(HippyTKDListViewAdapter.X)) != null && split.length == 2) {
            try {
                f16 = Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
                QLog.d("UserLeadingBaseActivity", 1, "getPreviewImageVpCustomHeight   | width = " + split[0] + " | height = " + split[1]);
            } catch (Exception e16) {
                QLog.w("UserLeadingBaseActivity", 1, "adjustPreviewImageVpWh  e = " + e16.getMessage());
            }
        }
        if (VasNormalToggle.VAS_BUG_119078231.isEnable(true) && com.tencent.mobileqq.util.x.g(BaseApplication.context)) {
            return ((int) (measuredWidth / f16)) + com.tencent.mobileqq.util.x.e(this);
        }
        return (int) (measuredWidth / f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p3() {
        return ImmersiveUtils.getScreenWidth() - ImmersiveUtils.dpToPx(32.0f);
    }

    private void u3() {
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.f391084e0, D0);
        HashMap hashMap = new HashMap();
        hashMap.put(E0, String.valueOf(this.f391081b0));
        hashMap.put(F0, this.f391082c0);
        VideoReport.setPageParams(this.f391084e0, new PageParams(hashMap));
    }

    public void A3() {
        UserLeadingHippyFragment userLeadingHippyFragment = this.f391094o0;
        if (userLeadingHippyFragment != null) {
            userLeadingHippyFragment.sendHippyNativeEvent("onGuideSheetHideEvent", new HippyMap());
        }
    }

    public void B3() {
        UserLeadingHippyFragment userLeadingHippyFragment = this.f391094o0;
        if (userLeadingHippyFragment != null) {
            userLeadingHippyFragment.sendHippyNativeEvent("onGuideSheetShowEvent", new HippyMap());
        }
    }

    public void C3() {
        ah[] ahVarArr = this.f391093n0;
        if (ahVarArr != null && ahVarArr.length != 0) {
            for (int i3 = 0; i3 < this.f391092m0.length; i3++) {
                if (y3(i3)) {
                    QLog.d("UserLeadingBaseActivity", 1, "start preload , finalI = " + i3);
                    this.f391093n0[i3].g(new e(i3));
                }
            }
            return;
        }
        QLog.e("UserLeadingBaseActivity", 1, "predownVideos  userLeadingVideos is empty");
    }

    public void E3(boolean z16) {
        int i3;
        if (z16) {
            i3 = Color.parseColor("#66000000");
        } else {
            i3 = 0;
        }
        try {
            View decorView = getWindow().getDecorView();
            if (decorView instanceof FrameLayout) {
                ((LinearLayout) ((FrameLayout) ((LinearLayout) ((FrameLayout) decorView).getChildAt(0)).getChildAt(1)).getChildAt(0)).setBackgroundColor(i3);
            }
        } catch (Exception unused) {
            QLog.d("UserLeadingBaseActivity", 1, "get activity layout level error");
        }
    }

    public void I3(int i3, boolean z16) {
        try {
            if (z16) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    i.n(null, 142, String.valueOf(this.f391081b0), this.f391082c0);
                                }
                            } else {
                                i.n(null, 140, String.valueOf(this.f391081b0), this.f391082c0);
                            }
                        } else {
                            i.n(null, 118, String.valueOf(this.f391081b0), this.f391082c0);
                        }
                    } else {
                        i.n(null, 138, String.valueOf(this.f391081b0), this.f391082c0);
                    }
                } else {
                    i.n(null, 102, String.valueOf(this.f391081b0), this.f391082c0);
                }
            } else if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                i.n(null, 141, String.valueOf(this.f391081b0), this.f391082c0);
                            }
                        } else {
                            i.n(null, 139, String.valueOf(this.f391081b0), this.f391082c0);
                        }
                    } else {
                        i.n(null, 117, String.valueOf(this.f391081b0), this.f391082c0);
                    }
                } else {
                    i.n(null, 137, String.valueOf(this.f391081b0), this.f391082c0);
                }
            } else {
                i.n(null, 101, String.valueOf(this.f391081b0), this.f391082c0);
            }
        } catch (Exception e16) {
            QLog.e("UserLeadingBaseActivity", 1, "report error", e16);
        }
    }

    public void J3(int i3) {
        if (!j3(this.f391092m0, i3)) {
            return;
        }
        this.f391089j0.setText(this.f391095p0);
        try {
            UserLeadingDialogModel[] userLeadingDialogModelArr = this.f391092m0;
            if (userLeadingDialogModelArr.length > 0 && TextUtils.isEmpty(userLeadingDialogModelArr[0].getButtonColor())) {
                this.f391091l0.setVisibility(8);
            } else {
                this.f391091l0.setVisibility(0);
            }
            if (!this.f391092m0[i3].getTitle().equals("")) {
                this.f391089j0.setText(this.f391092m0[i3].getTitle().replace("{nickname}", this.f391095p0));
            }
            if (!this.f391092m0[i3].getButtonText().equals("")) {
                this.f391088i0.setText(this.f391092m0[i3].getButtonText());
            }
            if (!this.f391092m0[i3].getContent().equals("")) {
                this.f391090k0.setText(this.f391092m0[i3].getContent());
            }
            if (this.f391103x0) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.f391084e0.getBackground();
                gradientDrawable.setColor(Color.parseColor("#262626"));
                this.f391084e0.setBackground(gradientDrawable);
                this.f391087h0.setBackgroundResource(R.drawable.mzn);
                if (!this.f391092m0[i3].getTitleColorDark().equals("")) {
                    this.f391089j0.setTextColor(Color.parseColor(this.f391092m0[i3].getTitleColorDark()));
                }
                if (!this.f391092m0[i3].getContentColorDark().equals("")) {
                    this.f391090k0.setTextColor(Color.parseColor(this.f391092m0[i3].getContentColorDark()));
                }
                if (!this.f391092m0[i3].getButtonColorDark().equals("")) {
                    this.f391088i0.setBackgroundColor(Color.parseColor(this.f391092m0[i3].getButtonColorDark()));
                }
                if (!this.f391092m0[i3].getButtonTextColorDark().equals("")) {
                    this.f391088i0.setTextColor(Color.parseColor(this.f391092m0[i3].getButtonTextColorDark()));
                }
            } else {
                if (!this.f391092m0[i3].getTitleColorLight().equals("")) {
                    this.f391089j0.setTextColor(Color.parseColor(this.f391092m0[i3].getTitleColorLight()));
                }
                if (!this.f391092m0[i3].getContentColorLight().equals("")) {
                    this.f391090k0.setTextColor(Color.parseColor(this.f391092m0[i3].getContentColorLight()));
                }
                if (!this.f391092m0[i3].getButtonColorLight().equals("")) {
                    this.f391088i0.setBackgroundColor(Color.parseColor(this.f391092m0[i3].getButtonColorLight()));
                }
                if (!this.f391092m0[i3].getButtonTextColorLight().equals("")) {
                    this.f391088i0.setTextColor(Color.parseColor(this.f391092m0[i3].getButtonTextColorLight()));
                }
            }
            if (this.f391092m0[i3].getButtonTextColor().equals("")) {
                this.f391088i0.setTextColor(-1);
            }
        } catch (Exception e16) {
            QLog.e("UserLeadingBaseActivity", 1, "configuration data is incorrect", e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        if (r0 != 2) goto L14;
     */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        if (j3(this.f391092m0, this.f391097r0) && this.f391092m0[this.f391097r0].isCustomType()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    H3();
                }
            }
            h3();
        }
        this.f391098s0.onTouchEvent(motionEvent);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        if (j3(this.f391092m0, this.f391097r0 - 1)) {
            this.f391085f0.setCurrentItem(this.f391097r0 - 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
        }
        if (!v3()) {
            l3();
            return false;
        }
        initView();
        w3();
        C3();
        G3();
        u3();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        z3();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (this.f391092m0 != null) {
            for (int i3 = 0; i3 < this.f391092m0.length; i3++) {
                if (y3(i3)) {
                    this.f391093n0[i3].h();
                } else {
                    URLDrawable.removeMemoryCacheByUrl(this.f391092m0[i3].getResUrl());
                }
            }
        }
        UserLeadingHippyFragment userLeadingHippyFragment = this.f391094o0;
        if (userLeadingHippyFragment != null) {
            userLeadingHippyFragment.onDestroy();
            this.f391094o0 = null;
        }
        this.f391093n0 = null;
        this.f391087h0 = null;
        this.f391085f0 = null;
        this.f391096q0 = null;
        this.f391080a0 = null;
        super.doOnDestroy();
        QLog.i("UserLeadingBaseActivity", 1, "doOnDestroy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        ApngImage.pauseAll();
        QLog.i("UserLeadingBaseActivity", 1, "doOnPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        ApngImage.resumeAll();
        QLog.i("UserLeadingBaseActivity", 1, "doOnResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        if (this.f391097r0 == 0 && y3(0)) {
            QLog.d("UserLeadingBaseActivity", 1, "open video 0");
            this.f391093n0[0].d();
        }
        QLog.i("UserLeadingBaseActivity", 1, "doOnStart   mCurrentIndex = " + this.f391097r0);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setDuration(500L);
        translateAnimation.setFillAfter(true);
        this.f391084e0.startAnimation(translateAnimation);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: cooperation.vip.ad.UserLeadingActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (!UserLeadingActivity.this.isFinishing()) {
                    UserLeadingActivity.this.E3(false);
                    UserLeadingActivity.super.finish();
                    UserLeadingActivity.this.overridePendingTransition(0, 0);
                    if (UserLeadingActivity.this.f391102w0 > 0) {
                        i.m(133, String.valueOf(UserLeadingActivity.this.f391081b0), (int) (SystemClock.uptimeMillis() - UserLeadingActivity.this.f391102w0), UserLeadingActivity.this.f391082c0);
                    }
                    QLog.i("UserLeadingBaseActivity", 1, "finish ");
                }
            }
        }, 500L);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(VideoMessage.class);
        return arrayList;
    }

    public void h3() {
        if (this.f391101v0 > 0) {
            this.f391104y0.removeCallbacksAndMessages(null);
        }
    }

    public void i3() {
        try {
            i.n(null, 122, String.valueOf(this.f391081b0), this.f391082c0);
        } catch (Exception e16) {
            QLog.e("UserLeadingBaseActivity", 1, "close report error", e16);
        }
    }

    public void initView() {
        setContentView(R.layout.f167558dr3);
        this.f391083d0 = findViewById(R.id.f164814ty2);
        this.f391084e0 = (LinearLayout) findViewById(R.id.u8b);
        this.f391085f0 = (ViewPager) findViewById(R.id.f27280ft);
        this.f391086g0 = (LinearLayout) findViewById(R.id.xmc);
        this.f391087h0 = (ImageView) findViewById(R.id.aze);
        this.f391088i0 = (Button) findViewById(R.id.dzp);
        this.f391089j0 = (TextView) findViewById(R.id.f122257dg);
        this.f391090k0 = (TextView) findViewById(R.id.b_6);
        this.f391091l0 = findViewById(R.id.yb6);
        this.f391096q0 = new UserLeadingAdapter();
        this.f391083d0.setOnClickListener(new View.OnClickListener() { // from class: cooperation.vip.ad.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserLeadingActivity.this.onClick(view);
            }
        });
        this.f391087h0.setOnClickListener(new View.OnClickListener() { // from class: cooperation.vip.ad.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserLeadingActivity.this.onClick(view);
            }
        });
        this.f391088i0.setOnClickListener(new View.OnClickListener() { // from class: cooperation.vip.ad.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserLeadingActivity.this.onClick(view);
            }
        });
        this.f391085f0.setOnClickListener(new View.OnClickListener() { // from class: cooperation.vip.ad.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserLeadingActivity.this.onClick(view);
            }
        });
        try {
            int i3 = ViewPager.SCROLL_STATE_IDLE;
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            cooperation.vip.ad.b bVar = new cooperation.vip.ad.b(this, new LinearOutSlowInInterpolator());
            bVar.a(800);
            declaredField.setAccessible(true);
            declaredField.set(this.f391085f0, bVar);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("UserLeadingBaseActivity", 1, "set mPreviewImageVp speed error");
        }
        ah[] ahVarArr = this.f391093n0;
        if (ahVarArr != null && ahVarArr.length > 0) {
            this.f391085f0.setOffscreenPageLimit(ahVarArr.length);
        }
        this.f391085f0.setPageMargin(50);
        this.f391085f0.getViewTreeObserver().addOnGlobalLayoutListener(new c());
        this.f391085f0.setAdapter(this.f391096q0);
        this.f391085f0.setOnPageChangeListener(this);
        UserLeadingDialogModel[] userLeadingDialogModelArr = this.f391092m0;
        if (userLeadingDialogModelArr != null && userLeadingDialogModelArr.length != 0) {
            r3();
            x3();
            J3(0);
            if (this.f391101v0 > 0 && !this.f391092m0[0].isVideoType()) {
                H3();
                return;
            }
            return;
        }
        QLog.e("UserLeadingBaseActivity", 1, "initView userModels is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    public boolean j3(Object[] objArr, int i3) {
        if (objArr != null && i3 >= 0 && i3 < objArr.length && objArr[i3] != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f391083d0 || view == this.f391087h0) {
            QLog.d("UserLeadingBaseActivity", 1, "[onClick]  close");
            i3();
            finish();
        }
        if (view == this.f391088i0 && j3(this.f391092m0, this.f391097r0) && !this.f391092m0[this.f391097r0].getResLink().equals("")) {
            QLog.d("UserLeadingBaseActivity", 1, "[onClick] mJumpBtn  url = " + this.f391092m0[this.f391097r0].getResLink());
            s3(this.f391092m0[this.f391097r0].getResLink());
            I3(this.f391097r0, true);
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        if (this.f391101v0 > 0) {
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    h3();
                    return;
                }
                return;
            }
            if (j3(this.f391092m0, this.f391097r0) && !this.f391092m0[this.f391097r0].isVideoType()) {
                H3();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        UserLeadingAdapter userLeadingAdapter;
        if (j3(this.f391092m0, this.f391097r0)) {
            QLog.d("UserLeadingBaseActivity", 1, "onPageSelected at " + i3 + "'s position");
            this.f391086g0.getChildAt(this.f391097r0).setSelected(false);
            this.f391086g0.getChildAt(i3).setSelected(true);
            if (y3(this.f391097r0)) {
                this.f391093n0[this.f391097r0].e();
            }
            if (this.f391092m0[this.f391097r0].getResType().equals("3")) {
                A3();
            }
        }
        this.f391097r0 = i3;
        if (j3(this.f391092m0, i3)) {
            I3(this.f391097r0, false);
            if (y3(this.f391097r0) && this.f391096q0 != null) {
                this.f391093n0[this.f391097r0].j();
                this.f391096q0.f();
                if (!this.f391093n0[this.f391097r0].c()) {
                    this.f391093n0[this.f391097r0].d();
                }
            }
            J3(this.f391097r0);
            if (this.f391092m0[this.f391097r0].isCustomType()) {
                B3();
            }
            if ((this.f391092m0[this.f391097r0].isImageType() || this.f391092m0[this.f391097r0].isDynamicImageType()) && (userLeadingAdapter = this.f391096q0) != null) {
                userLeadingAdapter.h();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof VideoMessage) {
            VideoMessage videoMessage = (VideoMessage) simpleBaseEvent;
            int messageCode = videoMessage.getMessageCode();
            if (messageCode != 1) {
                if (messageCode != 2) {
                    if (messageCode != 3) {
                        if (messageCode != 5) {
                            if (messageCode == 6) {
                                try {
                                    cooperation.vip.ad.a.tianshuReportbyId(Integer.parseInt(videoMessage.getMessage()));
                                    return;
                                } catch (Exception unused) {
                                    QLog.d("UserLeadingBaseActivity", 1, "get actionId error");
                                    return;
                                }
                            }
                            return;
                        }
                        if (videoMessage.getMessage() != null && j3(videoMessage.getMessage().split("_"), 1) && this.f391096q0 != null) {
                            QLog.d("UserLeadingBaseActivity", 1, videoMessage.getMessage() + "video is ready");
                            try {
                                this.f391096q0.g(Integer.parseInt(videoMessage.getMessage().split("_")[1]));
                                return;
                            } catch (Exception e16) {
                                QLog.e("UserLeadingBaseActivity", 1, "parse number error", e16);
                                return;
                            }
                        }
                        return;
                    }
                    QLog.d("UserLeadingBaseActivity", 1, "\u53ef\u4ea4\u4e92\u533a\u57df\u8df3\u8f6c\uff0c\u8df3\u8f6cposition:" + this.f391097r0);
                    if (videoMessage.getMessage().equals("") && j3(this.f391092m0, this.f391097r0)) {
                        s3(this.f391092m0[this.f391097r0].getResUrl());
                        return;
                    } else {
                        s3(videoMessage.getMessage());
                        return;
                    }
                }
                QLog.d("UserLeadingBaseActivity", 1, "\u53ef\u4ea4\u4e92\u533a\u57df\u9ed8\u8ba4\u70b9\u51fb\u4e0a\u62a5\uff0c\u4e0a\u62a5position:" + this.f391097r0);
                I3(this.f391097r0, true);
                return;
            }
            QLog.d("UserLeadingBaseActivity", 1, "\u6536\u5230\u5173\u95ed\u4fe1\u53f7");
            finish();
            i3();
        }
    }

    public void r3() {
        if (getIntent().getBooleanExtra("hideTitleArea", false)) {
            View findViewById = findViewById(R.id.f98205mg);
            View findViewById2 = findViewById(R.id.f98215mh);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
        }
    }

    public void s3(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, str);
            QIPCClientHelper.getInstance().getClient().callServer("TianshuAdQIPCModule", "handleUrl", bundle, null);
            QLog.d("UserLeadingBaseActivity", 1, "handleUrl   jumpUrl = " + str);
        } catch (Exception e16) {
            QLog.e("UserLeadingBaseActivity", 1, "jump error", e16);
        }
    }

    public void t3() {
        try {
            View decorView = getWindow().getDecorView();
            if (decorView instanceof FrameLayout) {
                ((FrameLayout) decorView).getChildAt(1).setVisibility(4);
            }
        } catch (Exception unused) {
            QLog.d("UserLeadingBaseActivity", 1, "hideStatusBar error");
        }
    }

    public boolean v3() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f391099t0 = supportFragmentManager;
        this.f391100u0 = supportFragmentManager.beginTransaction();
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return false;
        }
        long time = new Date().getTime() - extras.getLong("startTime");
        this.f391081b0 = extras.getInt(WinkDaTongReportConstant.ElementParamKey.ADID, 0);
        this.f391082c0 = extras.getString(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO);
        this.f391095p0 = extras.getString("nickName");
        this.f391101v0 = extras.getInt("intervalTime");
        this.f391103x0 = QQTheme.isNowThemeIsNight();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initData   | launchCost = ");
        long j3 = time / 1000;
        sb5.append(j3);
        sb5.append("s | mAdId = ");
        sb5.append(this.f391081b0);
        sb5.append(" | mTraceInfo = ");
        sb5.append(this.f391082c0);
        sb5.append(" | nickName = ");
        sb5.append(this.f391095p0);
        sb5.append(" | intervalTime = ");
        sb5.append(this.f391101v0);
        sb5.append(" | isNight = ");
        sb5.append(this.f391103x0);
        QLog.d("UserLeadingBaseActivity", 1, sb5.toString());
        try {
            if (MobileQQ.sProcessId == 1) {
                this.f391080a0 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            } else {
                this.f391080a0 = (PeakAppInterface) BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
            }
        } catch (Exception e16) {
            QLog.e("UserLeadingBaseActivity", 1, "getAppRuntime fail, ", e16);
        }
        if (extras.getSerializable("dialogModels") != null) {
            UserLeadingDialogModel[] userLeadingDialogModelArr = (UserLeadingDialogModel[]) extras.getSerializable("dialogModels");
            this.f391092m0 = userLeadingDialogModelArr;
            if (userLeadingDialogModelArr == null) {
                QLog.e("UserLeadingBaseActivity", 1, "initData  userModels == null");
                return false;
            }
            this.f391093n0 = new ah[userLeadingDialogModelArr.length];
            QLog.i("UserLeadingBaseActivity", 1, "initData  userModels = " + Arrays.toString(this.f391092m0));
            int i3 = 0;
            while (true) {
                UserLeadingDialogModel[] userLeadingDialogModelArr2 = this.f391092m0;
                if (i3 >= userLeadingDialogModelArr2.length) {
                    break;
                }
                if (this.f391080a0 != null && userLeadingDialogModelArr2[i3].isVideoType()) {
                    this.f391093n0[i3] = new ah(this.f391080a0.getApplicationContext(), String.valueOf(i3), this.f391092m0[i3].getResUrl());
                } else {
                    this.f391093n0[i3] = null;
                }
                i3++;
            }
        }
        if (time < 180000) {
            I3(0, false);
        } else {
            QLog.e("UserLeadingBaseActivity", 1, "launch long time error , launchCost" + j3 + ReportConstant.COSTREPORT_PREFIX);
        }
        return true;
    }

    public void w3() {
        this.f391098s0 = new GestureDetector(this, new d());
    }

    public void x3() {
        for (int i3 = 0; i3 < this.f391092m0.length; i3++) {
            View view = new View(getApplicationContext());
            view.setBackgroundResource(R.drawable.guild_appchannel_preview_indicate);
            view.setSelected(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px(6.0f, getResources()), dp2px(6.0f, getResources()));
            layoutParams.leftMargin = 14;
            layoutParams.rightMargin = 14;
            this.f391086g0.addView(view, layoutParams);
        }
        this.f391086g0.getChildAt(0).setSelected(true);
        if (this.f391092m0.length == 1) {
            this.f391086g0.setVisibility(4);
        }
    }

    public boolean y3(int i3) {
        if (j3(this.f391092m0, i3) && this.f391092m0[i3].isVideoType() && j3(this.f391093n0, i3)) {
            return true;
        }
        return false;
    }

    public void z3() {
        UserLeadingHippyFragment userLeadingHippyFragment = this.f391094o0;
        if (userLeadingHippyFragment != null) {
            userLeadingHippyFragment.sendHippyNativeEvent("onGuideSheetDestroyEvent", new HippyMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class UserLeadingAdapter extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private View[] f391106d;

        /* renamed from: e, reason: collision with root package name */
        private URLDrawable[] f391107e;

        /* compiled from: P */
        /* renamed from: cooperation.vip.ad.UserLeadingActivity$UserLeadingAdapter$5, reason: invalid class name */
        /* loaded from: classes28.dex */
        class AnonymousClass5 implements URLDrawable.URLDrawableListener {

            /* renamed from: d, reason: collision with root package name */
            int f391118d = 0;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RoundRectImageView f391119e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ RelativeLayout f391120f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f391121h;

            AnonymousClass5(RoundRectImageView roundRectImageView, RelativeLayout relativeLayout, int i3) {
                this.f391119e = roundRectImageView;
                this.f391120f = relativeLayout;
                this.f391121h = i3;
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
                QLog.d("UserLeadingBaseActivity", 2, "onLoadCanceled");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                QLog.d("UserLeadingBaseActivity", 1, "onLoadFialed");
                ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.ad.UserLeadingActivity.UserLeadingAdapter.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        int i3 = anonymousClass5.f391118d;
                        anonymousClass5.f391118d = i3 + 1;
                        if (i3 < 3) {
                            UserLeadingAdapter.this.f391107e[AnonymousClass5.this.f391121h].restartDownload();
                        }
                    }
                }, 128, null, true);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                QLog.d("UserLeadingBaseActivity", 2, "onLoadProgressed");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                QLog.d("UserLeadingBaseActivity", 1, "onLoadSuccessed");
                this.f391119e.setImageDrawable(uRLDrawable);
                this.f391119e.setVisibility(0);
                this.f391120f.setVisibility(4);
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QLog.d("UserLeadingBaseActivity", 1, "mCustomContent...onClick");
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f391129d;

            b(int i3) {
                this.f391129d = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (UserLeadingActivity.this.f391092m0 != null && !UserLeadingActivity.this.f391092m0[this.f391129d].getResLink().equals("")) {
                    UserLeadingActivity userLeadingActivity = UserLeadingActivity.this;
                    userLeadingActivity.s3(userLeadingActivity.f391092m0[this.f391129d].getResLink());
                    UserLeadingActivity.this.I3(this.f391129d, true);
                    UserLeadingActivity.this.finish();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        class d implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f391135d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ImageView f391136e;

            d(int i3, ImageView imageView) {
                this.f391135d = i3;
                this.f391136e = imageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                UserLeadingActivity.this.I3(this.f391135d, true);
                UserLeadingActivity userLeadingActivity = UserLeadingActivity.this;
                if (userLeadingActivity.j3(userLeadingActivity.f391093n0, this.f391135d)) {
                    if (UserLeadingActivity.this.f391093n0[this.f391135d].c()) {
                        UserLeadingActivity.this.f391093n0[this.f391135d].e();
                        this.f391136e.setVisibility(0);
                    } else {
                        UserLeadingActivity.this.f391093n0[this.f391135d].f();
                        this.f391136e.setVisibility(4);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public UserLeadingAdapter() {
            if (UserLeadingActivity.this.f391092m0 != null) {
                this.f391106d = new View[UserLeadingActivity.this.f391092m0.length];
                this.f391107e = new URLDrawable[UserLeadingActivity.this.f391092m0.length];
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            if (obj != null && viewGroup != null) {
                viewGroup.removeView((View) obj);
            }
        }

        public void f() {
            UserLeadingActivity userLeadingActivity = UserLeadingActivity.this;
            if (userLeadingActivity.y3(userLeadingActivity.f391097r0)) {
                UserLeadingActivity userLeadingActivity2 = UserLeadingActivity.this;
                if (userLeadingActivity2.j3(this.f391106d, userLeadingActivity2.f391097r0)) {
                    this.f391106d[UserLeadingActivity.this.f391097r0].findViewById(R.id.f25670bg).setVisibility(4);
                }
            }
        }

        public void g(int i3) {
            if (i3 == UserLeadingActivity.this.f391097r0) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: cooperation.vip.ad.UserLeadingActivity.UserLeadingAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UserLeadingActivity userLeadingActivity = UserLeadingActivity.this;
                        if (userLeadingActivity.y3(userLeadingActivity.f391097r0)) {
                            UserLeadingAdapter userLeadingAdapter = UserLeadingAdapter.this;
                            if (UserLeadingActivity.this.j3(userLeadingAdapter.f391106d, UserLeadingActivity.this.f391097r0)) {
                                UserLeadingAdapter.this.f391106d[UserLeadingActivity.this.f391097r0].findViewById(R.id.f25530b3).setVisibility(4);
                                UserLeadingAdapter.this.f391106d[UserLeadingActivity.this.f391097r0].findViewById(R.id.kq5).setVisibility(0);
                            }
                        }
                    }
                });
                UserLeadingActivity userLeadingActivity = UserLeadingActivity.this;
                if (userLeadingActivity.y3(userLeadingActivity.f391097r0) && !UserLeadingActivity.this.f391093n0[UserLeadingActivity.this.f391097r0].c()) {
                    UserLeadingActivity.this.f391093n0[UserLeadingActivity.this.f391097r0].d();
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            if (UserLeadingActivity.this.f391092m0 != null) {
                return UserLeadingActivity.this.f391092m0.length;
            }
            return 0;
        }

        public void h() {
            UserLeadingActivity userLeadingActivity = UserLeadingActivity.this;
            if ((userLeadingActivity.j3(userLeadingActivity.f391092m0, UserLeadingActivity.this.f391097r0) && UserLeadingActivity.this.f391092m0[UserLeadingActivity.this.f391097r0].isImageType()) || UserLeadingActivity.this.f391092m0[UserLeadingActivity.this.f391097r0].isDynamicImageType()) {
                UserLeadingActivity userLeadingActivity2 = UserLeadingActivity.this;
                if (userLeadingActivity2.j3(this.f391107e, userLeadingActivity2.f391097r0) && this.f391107e[UserLeadingActivity.this.f391097r0].getStatus() != 1) {
                    this.f391107e[UserLeadingActivity.this.f391097r0].restartDownload();
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, final int i3) {
            URLDrawable[] uRLDrawableArr;
            View[] viewArr;
            boolean z16;
            boolean z17;
            String str;
            QLog.d("UserLeadingBaseActivity", 1, "instantiateItem...");
            View inflate = LayoutInflater.from(UserLeadingActivity.this.getApplicationContext()).inflate(R.layout.efu, (ViewGroup) null);
            if (inflate == null) {
                return null;
            }
            final RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f25530b3);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f25580b8);
            TextView textView = (TextView) inflate.findViewById(R.id.f25550b5);
            final RoundRectImageView roundRectImageView = (RoundRectImageView) inflate.findViewById(R.id.f27290fu);
            ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.f27440g9);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f25670bg);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.ucp);
            if (UserLeadingActivity.this.f391103x0) {
                imageView.setBackgroundResource(R.drawable.mzp);
                textView.setTextColor(Color.parseColor("#999999"));
            }
            roundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            roundRectImageView.setCornerRadiusAndMode(20, 1);
            roundRectImageView.setOnClickListener(new b(i3));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            if (UserLeadingActivity.this.f391092m0 != null && UserLeadingActivity.this.f391092m0.length > i3 && (uRLDrawableArr = this.f391107e) != null && uRLDrawableArr.length > i3 && (viewArr = this.f391106d) != null && viewArr.length > i3) {
                QLog.d("UserLeadingBaseActivity", 1, "instantiateItem ,  userModels[position].getResType = " + UserLeadingActivity.this.f391092m0[i3].getResType());
                String resType = UserLeadingActivity.this.f391092m0[i3].getResType();
                resType.hashCode();
                char c16 = '\uffff';
                switch (resType.hashCode()) {
                    case 48:
                        if (resType.equals("0")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case 49:
                        if (resType.equals("1")) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case 50:
                        if (resType.equals("2")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 51:
                        if (resType.equals("3")) {
                            c16 = 3;
                            break;
                        }
                        break;
                }
                switch (c16) {
                    case 0:
                        this.f391107e[i3] = URLDrawable.getDrawable(UserLeadingActivity.this.f391092m0[i3].getResUrl(), obtain);
                        this.f391107e[i3].setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: cooperation.vip.ad.UserLeadingActivity.UserLeadingAdapter.3

                            /* renamed from: d, reason: collision with root package name */
                            int f391110d = 0;

                            @Override // com.tencent.image.URLDrawable.URLDrawableListener
                            public void onLoadCanceled(URLDrawable uRLDrawable) {
                                QLog.d("UserLeadingBaseActivity", 1, "URLDrawable status....onLoadCanceled");
                            }

                            @Override // com.tencent.image.URLDrawable.URLDrawableListener
                            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                                QLog.d("UserLeadingBaseActivity", 1, "URLDrawable status....onLoadFialed");
                                int i16 = this.f391110d;
                                this.f391110d = i16 + 1;
                                if (i16 < 3) {
                                    ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.ad.UserLeadingActivity.UserLeadingAdapter.3.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            UserLeadingAdapter.this.f391107e[i3].restartDownload();
                                        }
                                    }, 128, null, true);
                                }
                            }

                            @Override // com.tencent.image.URLDrawable.URLDrawableListener
                            public void onLoadProgressed(URLDrawable uRLDrawable, int i16) {
                                QLog.d("UserLeadingBaseActivity", 2, "URLDrawable status....onLoadProgressed");
                            }

                            @Override // com.tencent.image.URLDrawable.URLDrawableListener
                            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                                QLog.d("UserLeadingBaseActivity", 1, "URLDrawable status....onLoadSuccessed");
                                roundRectImageView.setImageDrawable(uRLDrawable);
                                roundRectImageView.setVisibility(0);
                                relativeLayout.setVisibility(4);
                            }
                        });
                        URLDrawable uRLDrawable = this.f391107e[i3];
                        if (uRLDrawable != null) {
                            z16 = true;
                            if (uRLDrawable.getStatus() == 1) {
                                QLog.d("UserLeadingBaseActivity", 1, "URLDrawable status....SUCCESSED");
                                roundRectImageView.setImageDrawable(this.f391107e[i3]);
                                roundRectImageView.setVisibility(0);
                                relativeLayout.setVisibility(4);
                                break;
                            }
                        } else {
                            z16 = true;
                        }
                        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.ad.UserLeadingActivity.UserLeadingAdapter.4
                            @Override // java.lang.Runnable
                            public void run() {
                                UserLeadingAdapter.this.f391107e[i3].downloadImediatly();
                            }
                        }, 128, null, z16);
                        break;
                    case 1:
                        if (Pattern.compile("[\\s\\S]*png").matcher(UserLeadingActivity.this.f391092m0[i3].getResUrl()).matches()) {
                            obtain.mUseApngImage = true;
                            obtain.mPlayGifImage = false;
                        } else {
                            obtain.mPlayGifImage = true;
                            obtain.mUseApngImage = false;
                        }
                        this.f391107e[i3] = URLDrawable.getDrawable(UserLeadingActivity.this.f391092m0[i3].getResUrl(), obtain);
                        this.f391107e[i3].setURLDrawableListener(new AnonymousClass5(roundRectImageView, relativeLayout, i3));
                        URLDrawable uRLDrawable2 = this.f391107e[i3];
                        if (uRLDrawable2 != null) {
                            z17 = true;
                            if (uRLDrawable2.getStatus() == 1) {
                                roundRectImageView.setImageDrawable(this.f391107e[i3]);
                                roundRectImageView.setVisibility(0);
                                relativeLayout.setVisibility(4);
                                break;
                            }
                        } else {
                            z17 = true;
                        }
                        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.ad.UserLeadingActivity.UserLeadingAdapter.6
                            @Override // java.lang.Runnable
                            public void run() {
                                UserLeadingAdapter.this.f391107e[i3].downloadImediatly();
                            }
                        }, 128, null, z17);
                        break;
                    case 2:
                        if (!UserLeadingActivity.this.f391092m0[i3].getResPlaceholder().equals("")) {
                            final URLDrawable drawable2 = URLDrawable.getDrawable(UserLeadingActivity.this.f391092m0[i3].getResPlaceholder(), obtain);
                            if (drawable2.getStatus() == 1) {
                                UserLeadingActivity.this.F3(relativeLayout, imageView, textView, drawable2);
                            } else {
                                drawable2.setURLDrawableListener(new c(relativeLayout, imageView, textView));
                                ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.ad.UserLeadingActivity.UserLeadingAdapter.8
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        drawable2.downloadImediatly();
                                    }
                                }, 128, null, true);
                            }
                        }
                        viewGroup2.setOnClickListener(new d(i3, imageView2));
                        UserLeadingActivity userLeadingActivity = UserLeadingActivity.this;
                        if (userLeadingActivity.j3(userLeadingActivity.f391093n0, i3)) {
                            viewGroup2.addView((View) UserLeadingActivity.this.f391093n0[i3].a());
                            break;
                        }
                        break;
                    case 3:
                        if (!UserLeadingActivity.this.f391092m0[i3].getResCustomUrl().equals("")) {
                            String str2 = UserLeadingActivity.this.f391092m0[i3].getResCustomUrl().split("@").length > 0 ? UserLeadingActivity.this.f391092m0[i3].getResCustomUrl().split("@")[0] : "";
                            if (UserLeadingActivity.this.f391092m0[i3].getResCustomUrl().split("@").length > 1) {
                                str = UserLeadingActivity.this.f391092m0[i3].getResCustomUrl().split("@")[1];
                                if (!str.equals(HippyQQConstants.HIPPY_VUE) && !str.equals("react")) {
                                    QLog.d("UserLeadingBaseActivity", 1, "EXTRA_KEY_FRAMEWORK parameter wrong");
                                }
                            } else {
                                str = "";
                            }
                            if (!str2.equals("") || !str.equals("")) {
                                if (UserLeadingActivity.this.f391094o0 == null) {
                                    UserLeadingActivity.this.f391094o0 = new UserLeadingHippyFragment();
                                }
                                Bundle bundle = new Bundle();
                                bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, true);
                                bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT, !ThemeUtil.isNowThemeIsNight(null, false, null));
                                bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, true);
                                bundle.putBoolean(OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE, true);
                                bundle.putString("processName", "main");
                                bundle.putString("bundleName", str2);
                                bundle.putInt(OpenHippyInfo.EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE, 1);
                                bundle.putString("domain", UserLeadingActivity.A0);
                                bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
                                bundle.putString("framework", str);
                                if (str2.equals(UserLeadingActivity.C0)) {
                                    bundle.putString(OpenHippyInfo.EXTRA_KEY_BUNDLE_URL, UserLeadingActivity.B0);
                                }
                                HashMap<String, String> hashMap = new HashMap<>();
                                int measuredWidth = UserLeadingActivity.this.f391085f0.getMeasuredWidth() > 0 ? UserLeadingActivity.this.f391085f0.getMeasuredWidth() : UserLeadingActivity.this.p3();
                                int n3 = UserLeadingActivity.this.n3();
                                hashMap.put("__VASCustomViewWidth__", String.valueOf(UserLeadingActivity.D3(measuredWidth, UserLeadingActivity.this.getResources())));
                                hashMap.put("__VASCustomViewHeight__", String.valueOf(UserLeadingActivity.D3(n3, UserLeadingActivity.this.getResources())));
                                hashMap.put("__VASCustomViewTraceID__", UserLeadingActivity.this.f391092m0[i3].getResCustomHippyTraceId());
                                hashMap.put(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, UserLeadingActivity.this.f391082c0);
                                Intent intent = UserLeadingActivity.this.getIntent();
                                if (intent != null) {
                                    hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_TIANSHU_AD_ID, String.valueOf(intent.getIntExtra(ProfileCardDtReportUtil.DT_REPORT_PARAM_TIANSHU_AD_ID, 0)));
                                    hashMap.put("last_load_time", String.valueOf(intent.getLongExtra("last_load_time", 0L)));
                                    hashMap.put("pre_load_start", String.valueOf(intent.getLongExtra("pre_load_start", 0L)));
                                    hashMap.put("pre_load_end", String.valueOf(intent.getLongExtra("pre_load_end", 0L)));
                                    hashMap.put("request_num", String.valueOf(intent.getIntExtra("request_num", 0)));
                                }
                                QLog.i("UserLeadingBaseActivity", 1, "hippyInfo   | width = " + UserLeadingActivity.this.f391085f0.getMeasuredWidth() + " | height = " + UserLeadingActivity.this.f391085f0.getMeasuredHeight() + " | customHeight = " + n3 + " | traceId = " + UserLeadingActivity.this.f391092m0[i3].getResCustomHippyTraceId() + " | bundleName = " + str2 + " | traceInfo = " + UserLeadingActivity.this.f391082c0 + " | hashMap = " + hashMap.toString());
                                SerializableMap serializableMap = new SerializableMap();
                                serializableMap.wrapMap(hashMap);
                                bundle.putSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP, serializableMap);
                                Bundle bundle2 = new Bundle();
                                bundle2.putBundle("params", bundle);
                                UserLeadingActivity.this.f391094o0.setArguments(bundle2);
                                UserLeadingActivity userLeadingActivity2 = UserLeadingActivity.this;
                                userLeadingActivity2.f391100u0 = userLeadingActivity2.f391099t0.beginTransaction();
                                frameLayout.addView(new UserLeadingHippyLayout(UserLeadingActivity.this.getApplicationContext()));
                                UserLeadingActivity.this.f391100u0.replace(R.id.f115496w7, UserLeadingActivity.this.f391094o0);
                                UserLeadingActivity.this.f391100u0.commitAllowingStateLoss();
                                frameLayout.setOnClickListener(new a());
                                frameLayout.setVisibility(0);
                                relativeLayout.setVisibility(4);
                                break;
                            }
                        }
                        break;
                }
            }
            ViewGroup viewGroup3 = (ViewGroup) inflate.getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(inflate);
            }
            viewGroup.addView(inflate);
            View[] viewArr2 = this.f391106d;
            if (viewArr2 != null && i3 < viewArr2.length) {
                viewArr2[i3] = inflate;
            }
            return inflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        class c implements URLDrawable.URLDrawableListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RelativeLayout f391131d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ImageView f391132e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ TextView f391133f;

            c(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
                this.f391131d = relativeLayout;
                this.f391132e = imageView;
                this.f391133f = textView;
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                QLog.d("UserLeadingBaseActivity", 1, "onLoadFialed");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                QLog.d("UserLeadingBaseActivity", 1, "onLoadSuccessed");
                UserLeadingActivity.this.F3(this.f391131d, this.f391132e, this.f391133f, uRLDrawable);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            UserLeadingActivity.this.f391102w0 = SystemClock.uptimeMillis();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e implements ISPlayerPreDownloader.Listener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f391142a;

        e(int i3) {
            this.f391142a = i3;
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareError(int i3, int i16, int i17, String str) {
            QLog.d("UserLeadingBaseActivity", 1, this.f391142a + "\u9884\u52a0\u8f7d\u5931\u8d25");
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareSuccess(int i3) {
            QLog.d("UserLeadingBaseActivity", 1, this.f391142a + "\u9884\u52a0\u8f7d\u6210\u529f");
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onInfo(int i3, long j3, long j16, Object obj) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
        }
    }
}
