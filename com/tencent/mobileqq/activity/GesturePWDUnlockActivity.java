package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import mqq.app.Constants;
import mqq.os.MqqHandler;

@RoutePage(desc = "\u624b\u52bf\u89e3\u9501", path = RouterConstants.UI_ROUTE_GESTURE_PWD_UNLOCK)
/* loaded from: classes9.dex */
public class GesturePWDUnlockActivity extends BaseActivity implements LockPatternView.b, View.OnClickListener, Animation.AnimationListener {
    static IPatchRedirector $redirector_ = null;
    public static final int GESTUREPWD_LENGHT_MIN = 3;
    private static final int GESTUREPWD_UNLOCK_MAXTIME = 5;
    public static final String GESTURE_ACTION = "com.tencent.mobileqq.gestureunlock";
    private static final String GESTURE_TAG = "Q.gesturelock.unlock";
    public static final String KEY_GESTURE_FROM_AUTHORITY = "key_gesture_from_authority";
    public static final String KEY_GESTURE_FROM_JUMPACTIVITY = "key_gesture_from_jumpactivity";
    public static final String KEY_GESTURE_FROM_SYSTEM_CONTACT = "key_req_by_contact_sync";
    public static final String KEY_GESTURE_RESULT = "key_gesture_result";
    public static final String KEY_GESTURE_SHOWGESTURE_VALID = "key_gesture_showgesture_valid";
    public static final String KEY_GESTURE_UNLOCK_FAILED = "key_gesture_unlock_failed";
    public static final int MESSAGE_UNLOCK_FAILED = 2;
    public static final int MESSAGE_UNLOCK_SUCCESS = 1;
    private static final float POLAR_RENDER_FREQUENCY = 0.025f;
    private static final a.b POLAR_RENDER_GRADIENT;
    private static final float POLAR_RENDER_OFFSET = 0.5f;
    private static final int REQUEST_CODE_LOGIN = 9999;
    public static final int RESULT_UNLOCK_SUCCESS = 100;
    public static boolean sGesturePWDUnlockShowing;
    private int[] StepLocation;
    private long[] StepTime;
    long createTime;
    private int curStep;
    private final List<Integer> defaultPolarColors;
    private float density;
    private QQCustomDialog faiedUnlockDialog;
    private boolean isNeedReLogin;
    private boolean isOtherPageSuccess;
    private BroadcastReceiver mBroadcastReceiver;
    QQProAvatarView mFaceImageView;
    private LinearLayout mForgePasswordView;
    private boolean mIsFromAuthority;
    boolean mIsFromJump;
    boolean mIsFromSystemContact;
    private boolean mIsJumpFinish;
    LockPatternView mLockView;
    String mPkgNameString;
    private QUIPolarLightView mPolarLightView;
    private View mTransView;
    private int mUnlockFailedTime;
    private TextView mUnlockTextView;
    int mUnlockTime;
    String mUrlString;
    private String mWrongTips;
    private final List<Integer> nightPolarColors;
    private int totalStep;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GesturePWDUnlockActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GesturePWDUnlockActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            if (!GesturePWDUnlockActivity.this.isNeedReLogin) {
                GesturePWDUnlockActivity.this.isNeedReLogin = true;
                return;
            }
            GesturePWDUnlockActivity.this.unLockFailed();
            BaseGesturePWDUtil.setGestureUnlockFailedType(GesturePWDUnlockActivity.this, 1);
            StatisticCollector statisticCollector = StatisticCollector.getInstance(GesturePWDUnlockActivity.this.getBaseContext());
            QQAppInterface qQAppInterface = GesturePWDUnlockActivity.this.app;
            statisticCollector.reportActionCount(qQAppInterface, qQAppInterface.getCurrentAccountUin(), "Gesture_pwd", "click_wrong_pwd", 0, 1, "0", null, null, null, null);
        }
    }

    /* loaded from: classes9.dex */
    class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GesturePWDUnlockActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent == null) {
                return;
            }
            if (GesturePWDUnlockActivity.this.mIsFromJump) {
                int intExtra = intent.getIntExtra(GesturePWDUnlockActivity.KEY_GESTURE_RESULT, 0);
                if (QLog.isColorLevel()) {
                    QLog.d(GesturePWDUnlockActivity.GESTURE_TAG, 2, "GesturePWDUnlockActivity onReceive result=" + intExtra);
                }
                if (100 == intExtra) {
                    GesturePWDUnlockActivity.this.onJumpReceiveUnlock();
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(GesturePWDUnlockActivity.GESTURE_TAG, 2, "GesturePWDUnlockActivity finish onReceive");
            }
            long longExtra = intent.getLongExtra("timeid", 0L);
            GesturePWDUnlockActivity gesturePWDUnlockActivity = GesturePWDUnlockActivity.this;
            if (longExtra > gesturePWDUnlockActivity.createTime && !gesturePWDUnlockActivity.isFinishing()) {
                GesturePWDUnlockActivity.this.finish();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67119);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            POLAR_RENDER_GRADIENT = new a.b(0.7f, 0.5f, 0.3f, 0.5f, 0.0f);
        }
    }

    public GesturePWDUnlockActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mUnlockTime = 5;
        this.mWrongTips = "";
        this.mUnlockFailedTime = 0;
        this.mIsFromJump = false;
        this.mIsFromAuthority = false;
        this.mIsFromSystemContact = false;
        this.mUrlString = "";
        this.mPkgNameString = "";
        this.density = 1.0f;
        this.createTime = 0L;
        this.isNeedReLogin = true;
        this.isOtherPageSuccess = false;
        this.mIsJumpFinish = false;
        this.mPolarLightView = null;
        this.defaultPolarColors = Arrays.asList(-4428, -344833, -4540161, -4338945, -6033153, -786433);
        this.nightPolarColors = Arrays.asList(-16169079, -13026376, -10339966, -9224591, -8369834, -8362166);
        this.curStep = 0;
        this.totalStep = 5;
        this.mBroadcastReceiver = new c();
    }

    private void doAlertAnimation(View view) {
        this.curStep = 0;
        this.totalStep = 5;
        this.StepTime = new long[]{50, 100, 100, 100, 100};
        float f16 = this.density;
        this.StepLocation = new int[]{(int) ((-20.0f) * f16), (int) (20.0f * f16), (int) ((-15.0f) * f16), (int) (f16 * 15.0f), 0};
        this.mTransView = view;
        nextStep();
    }

    private void doJumpAction(boolean z16) {
        if (!this.mIsJumpFinish && this.mIsFromJump) {
            this.mIsJumpFinish = true;
            QLog.i("qqBaseActivity", 2, "doJumpAction");
            if (!TextUtils.isEmpty(this.mUrlString)) {
                com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c(this.app, getActivity(), this.mUrlString);
                c16.B(this.mPkgNameString);
                c16.f307459x = z16;
                String account = getAppRuntime().getAccount();
                String str = c16.f307441f.get("uin");
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, account)) {
                    c16.f307460y = true;
                    c16.f307461z = false;
                }
                c16.b();
                return;
            }
            QLog.e("qqBaseActivity", 1, "mUrlString is empty");
        }
    }

    private void finishJumpActivity() {
        JumpActivity.sendFinishBroadcast(this);
    }

    private void initBackground() {
        QUIPolarLightView qUIPolarLightView = (QUIPolarLightView) findViewById(R.id.f26270d3);
        this.mPolarLightView = qUIPolarLightView;
        qUIPolarLightView.setVisibility(0);
        this.mPolarLightView.getLayoutParams().height = (int) (ViewUtils.getScreenHeight() * 0.6d);
        this.mPolarLightView.getPolarLightRender().p(POLAR_RENDER_FREQUENCY);
        this.mPolarLightView.getPolarLightRender().r(0.5f);
        PolarImageRender polarLightRender = this.mPolarLightView.getPolarLightRender();
        a.b bVar = POLAR_RENDER_GRADIENT;
        polarLightRender.q(bVar);
        if (QQTheme.isNowThemeIsNight()) {
            this.mPolarLightView.getPolarLightRender().s(this.nightPolarColors);
        } else {
            this.mPolarLightView.getPolarLightRender().s(this.defaultPolarColors);
        }
        this.mPolarLightView.getPolarLightRender().q(bVar);
    }

    private void initData() {
        this.mWrongTips = getString(R.string.f1380008d);
        this.mIsFromJump = getIntent().getBooleanExtra(KEY_GESTURE_FROM_JUMPACTIVITY, false);
        this.mIsFromAuthority = getIntent().getBooleanExtra(KEY_GESTURE_FROM_AUTHORITY, false);
        this.mIsFromSystemContact = getIntent().getBooleanExtra(KEY_GESTURE_FROM_SYSTEM_CONTACT, false);
        if (this.mIsFromJump) {
            this.mUrlString = getIntent().getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
            this.mPkgNameString = getIntent().getStringExtra("pkg_name");
        }
        this.density = getResources().getDisplayMetrics().density;
        this.mUnlockFailedTime = BaseGesturePWDUtil.getGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin());
    }

    private void initUI() {
        String str;
        setTitle(R.string.f170992bi4);
        initBackground();
        this.mUnlockTextView = (TextView) findViewById(R.id.vnr);
        LockPatternView lockPatternView = (LockPatternView) findViewById(R.id.vnq);
        this.mLockView = lockPatternView;
        lockPatternView.setFillInGapCell(false);
        this.mLockView.setTactileFeedbackEnabled(false);
        this.mLockView.setOnPatternListener(this);
        this.mFaceImageView = (QQProAvatarView) findViewById(R.id.f165356cu1);
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            str = qQAppInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str != null && !str.isEmpty()) {
            this.mFaceImageView.x(1, str, new e.a().f(getDrawable(R.drawable.csy)).g(200).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(str)).a());
        } else {
            QLog.e("GesturePWDUnlockActivity", 1, "initUI uin is null or empty");
            this.mFaceImageView.setImageResource(R.drawable.csy);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f165357cu3);
        this.mForgePasswordView = linearLayout;
        linearLayout.setOnClickListener(this);
        this.mForgePasswordView.setEnabled(false);
        if (this.density <= 1.0d) {
            ViewGroup.LayoutParams layoutParams = this.mLockView.getLayoutParams();
            float f16 = this.density;
            layoutParams.height = (int) (f16 * 240.0f);
            layoutParams.width = (int) (f16 * 240.0f);
            this.mLockView.setLayoutParams(layoutParams);
        }
        int i3 = this.mUnlockFailedTime;
        if (i3 > 0 && i3 < 5) {
            int i16 = 5 - i3;
            this.mUnlockTime = i16;
            String format = MessageFormat.format(this.mWrongTips, Integer.valueOf(i16));
            this.mUnlockTextView.setTextColor(getResources().getColor(R.color.qui_common_feedback_error));
            String str2 = this.mUnlockTime + "";
            int indexOf = format.indexOf(str2);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new StyleSpan(1), indexOf, str2.length() + indexOf, 18);
            this.mUnlockTextView.setText(spannableString);
        }
        if (this.mUnlockFailedTime == 5) {
            this.mUnlockTime = 0;
            onUnlockFailedOutRange();
        }
        ReportController.y(this.app, "0X800C557");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onJumpReceiveUnlock() {
        boolean isDelayFinish = isDelayFinish();
        doJumpAction(isDelayFinish);
        if (!isDelayFinish) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 9999) {
            if (i16 == -1) {
                setResult(-1, intent);
                finish();
            } else {
                setResult(0);
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(GESTURE_TAG, 2, "onCreate begin.");
        }
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 28) {
            View decorView = window.getDecorView();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024);
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.f168011ox);
        initData();
        initUI();
        BaseGesturePWDUtil.setGestureLocking(this, true);
        this.createTime = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(GESTURE_ACTION);
        intent.putExtra("timeid", this.createTime);
        sendBroadcast(intent);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(GESTURE_ACTION);
        registerReceiver(this.mBroadcastReceiver, intentFilter);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (this.mIsFromJump) {
            finishJumpActivity();
        }
        QQCustomDialog qQCustomDialog = this.faiedUnlockDialog;
        if (qQCustomDialog != null) {
            this.isNeedReLogin = false;
            qQCustomDialog.dismiss();
        }
        try {
            unregisterReceiver(this.mBroadcastReceiver);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.doOnPause();
        sGesturePWDUnlockShowing = false;
        this.mPolarLightView.stopAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnResume();
        sGesturePWDUnlockShowing = true;
        this.mForgePasswordView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.GesturePWDUnlockActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GesturePWDUnlockActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    GesturePWDUnlockActivity.this.mForgePasswordView.setEnabled(true);
                }
            }
        }, 500L);
        if (this.isOtherPageSuccess && this.mIsFromJump) {
            onJumpReceiveUnlock();
        }
        this.mPolarLightView.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.doOnStop();
        this.mForgePasswordView.setEnabled(false);
        BaseGesturePWDUtil.setGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin(), 5 - this.mUnlockTime);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(R.anim.f154442w, R.anim.f154550b4);
        }
    }

    public boolean isDelayFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.mIsFromJump && !TextUtils.isEmpty(this.mUrlString)) {
            com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c(this.app, getActivity(), this.mUrlString);
            if (c16 == null) {
                QLog.d("qqBaseActivity", 1, "isDelayFinish false jumpAction == null");
                return false;
            }
            if ("share".equals(c16.f307439d) && "to_fri".equals(c16.f307440e) && !TextUtils.isEmpty(com.tencent.mobileqq.utils.ax.E(c16.f307441f.get("file_uri")))) {
                QLog.d("qqBaseActivity", 1, "isDelayFinish true share qq file");
                return true;
            }
            if ("share".equals(c16.f307439d) && "to_qzone".equals(c16.f307440e) && !TextUtils.isEmpty(com.tencent.mobileqq.utils.ax.E(c16.f307441f.get(AppConstants.Key.SHARE_REQ_IMAGE_URI)))) {
                QLog.d("qqBaseActivity", 1, "isDelayFinish true share qqzone file");
                return true;
            }
            QLog.d("qqBaseActivity", 1, "isDelayFinish false sn = " + c16.f307439d + ",an=" + c16.f307440e);
            return false;
        }
        QLog.d("qqBaseActivity", 1, "isDelayFinish false noJump" + this.mIsFromJump);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    void nextStep() {
        int[] iArr;
        long[] jArr;
        int i3 = this.curStep;
        int i16 = this.totalStep;
        int i17 = 0;
        if (i3 < i16 && (iArr = this.StepLocation) != null && iArr.length >= i16 && (jArr = this.StepTime) != null && jArr.length >= i16) {
            if (i3 > 0) {
                i17 = iArr[i3 - 1];
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(i17, iArr[i3], 0.0f, 0.0f);
            translateAnimation.setAnimationListener(this);
            translateAnimation.setDuration(this.StepTime[this.curStep]);
            this.mTransView.startAnimation(translateAnimation);
            this.curStep++;
            return;
        }
        this.curStep = 0;
        this.mTransView = null;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) animation);
        } else {
            nextStep();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (!this.mIsFromJump && !this.mIsFromAuthority) {
            moveTaskToBack(true);
            return true;
        }
        setResult(0);
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f165357cu3) {
            unLockFailed();
            BaseGesturePWDUtil.setGestureUnlockFailedType(this, 0);
            ReportController.y(this.app, "0X800C55A");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) logoutReason);
        }
    }

    @Override // com.tencent.mobileqq.gesturelock.LockPatternView.b
    public void onPatternCellAdded(List<LockPatternView.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
        }
    }

    @Override // com.tencent.mobileqq.gesturelock.LockPatternView.b
    public void onPatternCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.gesturelock.LockPatternView.b
    public void onPatternDetected(List<LockPatternView.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            String gesturePWD = BaseGesturePWDUtil.getGesturePWD(this, this.app.getCurrentAccountUin());
            String md5 = MD5.toMD5(GesturePWDUtils.patternToString(list));
            String encodeGesture = BaseGesturePWDUtil.encodeGesture(GesturePWDUtils.patternToString(list), this.app.getCurrentAccountUin());
            if (gesturePWD != null && ((md5 != null && md5.equals(gesturePWD)) || (encodeGesture != null && encodeGesture.equals(gesturePWD)))) {
                QBaseActivity.isUnLockSuccess = true;
                if (this.mIsFromSystemContact) {
                    Intent intent = new Intent(this, (Class<?>) ContactSyncJumpActivity.class);
                    intent.putExtra("key_req_from_lock_screen", true);
                    intent.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
                    startActivity(intent);
                    moveTaskToBack(true);
                } else {
                    setResult(-1);
                }
                boolean isDelayFinish = isDelayFinish();
                doJumpAction(isDelayFinish);
                if (!isDelayFinish) {
                    finish();
                }
                MqqHandler handler = this.app.getHandler(GesturePWDUnlockActivity.class);
                if (handler != null) {
                    handler.sendEmptyMessage(1);
                }
                Intent intent2 = new Intent();
                intent2.setAction(GESTURE_ACTION);
                intent2.putExtra(KEY_GESTURE_RESULT, 100);
                sendBroadcast(intent2);
                BaseGesturePWDUtil.setGestureLocking(this, false);
                if (QLog.isColorLevel()) {
                    QLog.d(GESTURE_TAG, 2, "unlock success.");
                }
                this.mUnlockTime = 5;
                ((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).onQQForeground(this.app, true);
                ReportController.o(this.app, "dc00898", "", "", "0X800C558", "0X800C558", 0, 0, "0", "", "", "");
                return;
            }
            this.mLockView.setDisplayMode(2);
            int i3 = this.mUnlockTime - 1;
            this.mUnlockTime = i3;
            if (i3 > 0) {
                onUnlockFailedInRange();
            } else {
                onUnlockFailedOutRange();
            }
            ReportController.o(this.app, "dc00898", "", "", "0X800C558", "0X800C558", 0, 0, "1", "", "", "");
            return;
        }
        QQToast.makeText(this, 0, getString(R.string.bie), 0).show(getTitleBarHeight());
        this.mLockView.setDisplayMode(2);
        int i16 = this.mUnlockTime - 1;
        this.mUnlockTime = i16;
        if (i16 > 0) {
            onUnlockFailedInRange();
        } else {
            onUnlockFailedOutRange();
        }
        ReportController.o(this.app, "dc00898", "", "", "0X800C558", "0X800C558", 0, 0, "1", "", "", "");
    }

    @Override // com.tencent.mobileqq.gesturelock.LockPatternView.b
    public void onPatternStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPostThemeChanged();
            initBackground();
        }
    }

    void onUnlockFailedInRange() {
        if (QLog.isColorLevel()) {
            QLog.d(GESTURE_TAG, 2, "onUnlockFailedInRange");
        }
        String format = MessageFormat.format(this.mWrongTips, Integer.valueOf(this.mUnlockTime));
        this.mUnlockTextView.setTextColor(getResources().getColor(R.color.f157924ab3));
        String str = this.mUnlockTime + "";
        int indexOf = format.indexOf(str);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new StyleSpan(1), indexOf, str.length() + indexOf, 18);
        this.mUnlockTextView.setText(spannableString);
        doAlertAnimation(this.mUnlockTextView);
        BaseApplicationImpl.sUiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.GesturePWDUnlockActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GesturePWDUnlockActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    GesturePWDUnlockActivity.this.mLockView.c();
                }
            }
        }, 500L);
    }

    void onUnlockFailedOutRange() {
        if (QLog.isColorLevel()) {
            QLog.d(GESTURE_TAG, 2, "onUnlockFailedOutRange");
        }
        MqqHandler handler = this.app.getHandler(GesturePWDUnlockActivity.class);
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
        BaseApplicationImpl.sUiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.GesturePWDUnlockActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GesturePWDUnlockActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    GesturePWDUnlockActivity.this.mLockView.c();
                }
            }
        }, 500L);
        QQCustomDialog qQCustomDialog = this.faiedUnlockDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 231, getString(R.string.bih), getString(R.string.big), new a(), null);
        this.faiedUnlockDialog = createCustomDialog;
        createCustomDialog.setOnDismissListener(new b());
        this.faiedUnlockDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    void unLockFailed() {
        this.mUnlockTime = 5;
        GesturePWDUtils.setGesturePWDState(this, this.app.getCurrentAccountUin(), 0);
        BaseGesturePWDUtil.setGesturePWDMode(this, this.app.getCurrentAccountUin(), 21);
        BaseGesturePWDUtil.setGestureUnlockFailed(this, this.app.getCurrentAccountUin());
        List<SimpleAccount> allAccounts = getAppRuntime().getApplication().getAllAccounts();
        if (allAccounts != null) {
            for (SimpleAccount simpleAccount : allAccounts) {
                if (simpleAccount != null && simpleAccount.getUin() != null) {
                    this.app.updateSubAccountLogin(simpleAccount.getUin(), false);
                }
            }
            getAppRuntime().getApplication().refreAccountList();
        }
        BaseGesturePWDUtil.setGestureLocking(this, false);
        if (QQPlayerService.s0()) {
            Intent intent = new Intent();
            intent.setAction("qqplayer_exit_action");
            sendBroadcast(intent);
        }
        String currentAccountUin = this.app.getCurrentAccountUin();
        this.app.logout(true);
        if (QLog.isColorLevel()) {
            QLog.d(GESTURE_TAG, 2, this.mIsFromAuthority + "," + this.mIsFromSystemContact + "," + this.mIsFromJump + "," + this.mUrlString + "," + this.mPkgNameString);
        }
        Intent intent2 = new Intent();
        intent2.putExtra("loginFragmentType", 5);
        intent2.putExtra("uin", currentAccountUin);
        if (this.mIsFromAuthority) {
            intent2.putExtra(KEY_GESTURE_FROM_AUTHORITY, true);
            BaseGesturePWDUtil.setGestureLocking(this, false);
            RouteUtils.startActivityForResult(this, intent2, RouterConstants.UI_ROUTER_LOGIN, 9999);
            return;
        }
        if (this.mIsFromSystemContact) {
            QRoute.createNavigator(this, RouterConstants.UI_ROUTER_LOGIN).withFlags(67108864).withInt("loginFragmentType", 5).withParcelable("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent")).withBoolean(KEY_GESTURE_FROM_SYSTEM_CONTACT, true).requestWithReturn();
        } else if (!this.mIsFromJump) {
            QRoute.createNavigator(this, RouterConstants.UI_ROUTER_LOGIN).withFlags(67108864).withInt("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a).withBoolean(KEY_GESTURE_UNLOCK_FAILED, true).requestWithReturn();
        } else {
            Navigator withString = QRoute.createNavigator(this, RouterConstants.UI_ROUTER_LOGIN).withFlags(67108864).withInt("loginFragmentType", 5).withString("uin", currentAccountUin);
            if (!TextUtils.isEmpty(this.mUrlString)) {
                withString.withString(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, this.mUrlString);
            }
            if (!TextUtils.isEmpty(this.mPkgNameString)) {
                withString.withString("pkg_name", this.mPkgNameString);
            }
            withString.requestWithReturn();
        }
        finish();
    }
}
