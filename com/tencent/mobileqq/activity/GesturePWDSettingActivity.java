package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@RoutePage(desc = "\u8bbe\u7f6e\u624b\u52bf\u5bc6\u7801", path = RouterConstants.UI_ROUTER_GESTURE_PWD_SETTING)
/* loaded from: classes9.dex */
public class GesturePWDSettingActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_GESTURE_RESET = "key_reset";
    private static final int REQUEST_CODE_GUIDE_CREATE = 10;
    static final int REQUEST_CODE_RESET = 11;
    private View.OnClickListener mClickListener;
    private boolean mFromMainReset;
    private int mGestureMode;
    private FormSwitchItem mGestureSetting;
    private int mGestureState;
    private View mResetLayoutView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GesturePWDSettingActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String str;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                GesturePWDSettingActivity gesturePWDSettingActivity = GesturePWDSettingActivity.this;
                String currentAccountUin = gesturePWDSettingActivity.app.getCurrentAccountUin();
                if (z16) {
                    i3 = 2;
                }
                GesturePWDUtils.setGesturePWDState(gesturePWDSettingActivity, currentAccountUin, i3);
                GesturePWDSettingActivity.this.setGesturePWDChange(z16);
                QQAppInterface qQAppInterface = GesturePWDSettingActivity.this.app;
                if (z16) {
                    str = "0";
                } else {
                    str = "1";
                }
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C553", "0X800C553", 0, 0, str, "", "", "");
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public GesturePWDSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mGestureState = 0;
        this.mGestureMode = 0;
        this.mFromMainReset = false;
        this.mClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.cy
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GesturePWDSettingActivity.this.lambda$new$0(view);
            }
        };
    }

    private void initData() {
        this.mFromMainReset = getIntent().getBooleanExtra(KEY_GESTURE_RESET, false);
        int gesturePWDState = BaseGesturePWDUtil.getGesturePWDState(this, this.app.getCurrentAccountUin());
        this.mGestureState = gesturePWDState;
        if (gesturePWDState != 0) {
            if (gesturePWDState != 1) {
                if (gesturePWDState == 2) {
                    this.mGestureSetting.setChecked(true);
                    setGesturePWDChange(true);
                    ReportController.y(this.app, "0X800C552");
                    return;
                }
                return;
            }
            this.mGestureSetting.setChecked(false);
            setGesturePWDChange(false);
            return;
        }
        if (this.mFromMainReset) {
            Intent intent = new Intent(this, (Class<?>) GesturePWDCreateActivity.class);
            intent.putExtra(KEY_GESTURE_RESET, this.mFromMainReset);
            startActivityForResult(intent, 10);
            overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
            ReportController.y(this.app, "0X800C552");
            return;
        }
        startActivityForResult(new Intent(this, (Class<?>) GesturePWDGuideActivity.class), 10);
    }

    private void initUI() {
        setTitle(R.string.f1379908c);
        this.mResetLayoutView.setOnClickListener(this.mClickListener);
        this.mGestureSetting.setOnCheckedChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("IphoneTitleBarActivity") && view.getId() == R.id.ctz) {
            startActivityForResult(new Intent(this, (Class<?>) GesturePWDCreateActivity.class), 11);
            overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
            ReportController.y(this.app, "0X800C556");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void refreshState() {
        int gesturePWDState = BaseGesturePWDUtil.getGesturePWDState(this, this.app.getCurrentAccountUin());
        this.mGestureState = gesturePWDState;
        if (gesturePWDState != 0 && gesturePWDState != 1) {
            if (gesturePWDState == 2) {
                setGesturePWDChange(true);
                this.mGestureSetting.setChecked(true);
                ReportController.y(this.app, "0X800C552");
                return;
            }
            return;
        }
        setGesturePWDChange(false);
        this.mGestureSetting.setChecked(false);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 10) {
            if (i16 == -1) {
                refreshState();
            } else {
                finish();
                return;
            }
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.f168010ow);
        this.mGestureSetting = (FormSwitchItem) findViewById(R.id.f165355cu0);
        this.mResetLayoutView = findViewById(R.id.ctz);
        initData();
        initUI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.mFromMainReset) {
            Intent intent = new Intent(getActivity(), (Class<?>) PermissionPrivacyFragmentKotlin.class);
            intent.putExtra(KEY_GESTURE_RESET, this.mFromMainReset);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void setGesturePWDChange(boolean z16) {
        if (z16) {
            this.mResetLayoutView.setVisibility(0);
        } else {
            this.mResetLayoutView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mGestureState == 0) {
            return getString(R.string.frq);
        }
        return getString(R.string.f1379908c);
    }
}
