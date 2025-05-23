package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "\u8bbe\u5907\u9a8c\u8bc1", path = "/base/safe/authDevOpenActivity")
/* loaded from: classes9.dex */
public class AuthDevOpenUgActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    public static final String H5_CALL_ME = "AUTH_DEV_OPEN_UG_ACTIVITY";
    public static final String KEY_ALLOW_SET = "allow_set";
    public static final String KEY_AUTH_DEV_OPEN = "auth_dev_open";
    public static final String KEY_COUNTRY_CODE = "country_code";
    public static final String KEY_DEVLOCK_INFO = "DevlockInfo";
    public static final String KEY_IS_FROM_LOGIN = "from_login";
    public static final String KEY_PHONE_NUM = "phone_num";
    public static final String KEY_USER_GUIDE = "user_guide";
    public static final String KEY_USER_UIN = "user_uin";
    public static final String KEY_VERIFY_SEQ = "seq";
    public static final int REQUEST_CODE_OPEN_AUTH_DEV = 1001;
    public static final int REQUEST_CODE_SET_MOBILE = 1003;
    public static final int REQUEST_CODE_VERIFY_AUTH_DEV = 1002;
    public static final int REQUEST_CODE_VERIFY_PASSWD = 1004;
    private static final String TAG = "Q.devlock.AuthDevOpenUgActivity";
    private static boolean isH5Jump = false;
    private static final String mManually = "Manually";
    private static final String mUserBehavior = "UserBehavior";
    private Button mBottomBtn;
    private DevlockInfo mDevlockInfo;
    private String mFromWhere;
    private boolean mIsFromLogin;
    private String mMainAccount;
    private boolean mShowAuthDevList;
    private String mUin;
    private int mVerifySeq;
    private com.tencent.mobileqq.loginregister.servlet.h mWtLoginObserver;
    private int nGuideImageResID;
    private String strBottomBtnText;
    private String strConfirmPageParaDown;
    private String strConfirmPageParaUp;
    private String strDlgPcItemText;
    private String strDlgPhoneItemText;
    private String strDlgTitleText;
    private String strGuideContent;
    private String strJumpText;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevOpenUgActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void b(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
                return;
            }
            if (i3 == 0) {
                EquipmentLockImpl o16 = EquipmentLockImpl.o();
                AuthDevOpenUgActivity authDevOpenUgActivity = AuthDevOpenUgActivity.this;
                QQAppInterface qQAppInterface = authDevOpenUgActivity.app;
                o16.H(qQAppInterface, authDevOpenUgActivity, qQAppInterface.getCurrentAccountUin(), true);
                QQToast.makeText(AuthDevOpenUgActivity.this.getApplicationContext(), 2, AuthDevOpenUgActivity.this.getString(R.string.aya), 0).show(AuthDevOpenUgActivity.this.getTitleBarHeight());
                AuthDevOpenUgActivity.this.tryBroadcastDevlockStatus(true, 0);
                Intent intent = new Intent();
                intent.putExtra(AuthDevOpenUgActivity.KEY_AUTH_DEV_OPEN, true);
                if (AuthDevOpenUgActivity.this.mDevlockInfo != null) {
                    str = AuthDevOpenUgActivity.this.mDevlockInfo.Mobile;
                } else {
                    str = "";
                }
                intent.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, str);
                AuthDevOpenUgActivity.this.finishSelf(-1, intent);
                return;
            }
            if (errMsg != null && !TextUtils.isEmpty(errMsg.getMessage())) {
                QQToast.makeText(AuthDevOpenUgActivity.this.getApplicationContext(), 1, errMsg.getMessage(), 0).show(AuthDevOpenUgActivity.this.getTitleBarHeight());
            } else {
                QQToast.makeText(AuthDevOpenUgActivity.this.getApplicationContext(), 1, AuthDevOpenUgActivity.this.getString(R.string.azm), 0).show(AuthDevOpenUgActivity.this.getTitleBarHeight());
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void c(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
            } else if (i3 == 0 && devlockInfo != null) {
                AuthDevOpenUgActivity.this.doClickOpenDevLockBtn(devlockInfo);
            } else {
                AuthDevOpenUgActivity authDevOpenUgActivity = AuthDevOpenUgActivity.this;
                QQToast.makeText(authDevOpenUgActivity, authDevOpenUgActivity.getString(R.string.azu), 0).show(AuthDevOpenUgActivity.this.getTitleBarHeight());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66635);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            isH5Jump = false;
        }
    }

    public AuthDevOpenUgActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsFromLogin = false;
        this.mDevlockInfo = null;
        this.nGuideImageResID = 0;
        this.mShowAuthDevList = true;
        this.mWtLoginObserver = new a();
    }

    private boolean checkIsH5CallMe(Bundle bundle) {
        if ("true".equals(bundle.getString(H5_CALL_ME))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doClickOpenDevLockBtn(DevlockInfo devlockInfo) {
        Bundle extras;
        String str;
        try {
            EquipmentLockImpl.o().C(null, this.app.getCurrentAccountUin(), 3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        com.tencent.mobileqq.equipmentlock.a b16 = com.tencent.mobileqq.equipmentlock.a.b();
        if (b16 != null && b16.a() == com.tencent.mobileqq.equipmentlock.a.f205358f) {
            if (devlockInfo != null && !TextUtils.isEmpty(devlockInfo.Mobile)) {
                str = devlockInfo.Mobile;
            } else {
                str = "";
            }
            b16.e(this, str);
            return;
        }
        if (devlockInfo != null && !TextUtils.isEmpty(devlockInfo.Mobile)) {
            if (devlockInfo.AllowSet == 1 && devlockInfo.DevSetup != 1) {
                EquipmentLockImpl o16 = EquipmentLockImpl.o();
                QQAppInterface qQAppInterface = this.app;
                if (o16.e(qQAppInterface, qQAppInterface.getCurrentAccountUin(), "", null, this.mWtLoginObserver) != 0) {
                    QQToast.makeText(getApplicationContext(), getString(R.string.azl), 0).show(getTitleBarHeight());
                }
                if (isH5Jump) {
                    QLog.d(TAG, 2, "h5call", "BIND_AND_CREDIT_NOT_OPEN_DEVLOCK");
                    EquipmentLockImpl.o().D(null, this.app.getCurrentAccountUin(), 9);
                    finish();
                    ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this, new Intent(), -1);
                    return;
                }
                return;
            }
            if (devlockInfo.DevSetup == 1) {
                if (isH5Jump) {
                    QLog.d(TAG, 2, "h5call", "OPENED_DEVLOCK");
                    finish();
                    ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this, new Intent(), -1);
                    return;
                }
                return;
            }
            if (isH5Jump) {
                QLog.d(TAG, 2, "h5call", "BIND_BUT_CREDIT_NOT_OPEN_DEVLOCK");
                EquipmentLockImpl.o().D(null, this.app.getCurrentAccountUin(), 7);
            }
            Intent intent = new Intent(this, (Class<?>) AuthDevConfirmPhoneNoActivity.class);
            if (getIntent() != null && (extras = getIntent().getExtras()) != null) {
                intent.putExtra("devlock_need_broadcast", extras.getBoolean("devlock_need_broadcast"));
            }
            intent.putExtra("ParaTextUp", this.strConfirmPageParaUp);
            intent.putExtra("ParaTextDown", this.strConfirmPageParaDown);
            intent.putExtra("PhoneNO", devlockInfo.Mobile);
            intent.putExtra("mainaccount", this.mMainAccount);
            intent.putExtra("uin", this.mUin);
            intent.putExtra("from_where", this.mFromWhere);
            intent.putExtra(KEY_DEVLOCK_INFO, devlockInfo);
            startActivityForResult(intent, 1001);
            overridePendingTransition(0, R.anim.f154454a3);
            return;
        }
        if (isH5Jump) {
            QLog.d(TAG, 2, "h5call", "NO_BIND_AND_NO_CREDIT_NOT_OPEN_DEVLOCK");
            EquipmentLockImpl.o().D(null, this.app.getCurrentAccountUin(), 6);
        }
        com.tencent.mobileqq.equipmentlock.b.a(this, this.app, com.tencent.mobileqq.equipmentlock.b.f205366c, 1003, null);
    }

    public static boolean getIsH5Jump() {
        return isH5Jump;
    }

    private void initUI(String str) {
        String string;
        Button button;
        ImageView imageView;
        TextView textView = (TextView) findViewById(R.id.czz);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        Button button2 = this.mBottomBtn;
        if (!TextUtils.isEmpty(this.strBottomBtnText)) {
            string = this.strBottomBtnText;
        } else {
            string = getString(R.string.azf);
        }
        button2.setText(string);
        this.mBottomBtn.setContentDescription(getString(R.string.aye));
        if (!TextUtils.isEmpty(this.strDlgTitleText)) {
            setTitle(this.strDlgTitleText);
        }
        if (this.nGuideImageResID != 0 && (imageView = (ImageView) findViewById(R.id.czl)) != null) {
            imageView.setImageResource(this.nGuideImageResID);
        }
        if (!TextUtils.isEmpty(this.strJumpText) && (button = (Button) findViewById(R.id.czm)) != null) {
            button.setVisibility(0);
            button.setText(this.strJumpText);
            button.setOnClickListener(this);
        }
        EquipmentLockImpl.o().C(null, this.app.getCurrentAccountUin(), 1);
    }

    private void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.strGuideContent = jSONObject.getString("title");
            this.strBottomBtnText = jSONObject.getString("smallTitle");
            this.strDlgTitleText = jSONObject.getString("guideTitle");
            JSONArray jSONArray = jSONObject.getJSONArray("guideArray");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    String string = jSONArray.getString(i3);
                    if (i3 == 0) {
                        this.strDlgPcItemText = string;
                    } else if (i3 == 1) {
                        this.strDlgPhoneItemText = string;
                    } else if (i3 == 2) {
                        this.strConfirmPageParaUp = string;
                    } else if (i3 == 3) {
                        this.strConfirmPageParaDown = string;
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseJson error.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryBroadcastDevlockStatus(boolean z16, int i3) {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("devlock_need_broadcast") || !extras.getBoolean("devlock_need_broadcast")) {
            return;
        }
        Intent intent2 = new Intent();
        intent2.setAction(NewIntent.ACTION_DEVLOCK_ROAM);
        intent2.putExtra(KEY_AUTH_DEV_OPEN, z16);
        intent2.putExtra("auth_dev_open_cb_reason", i3);
        sendBroadcast(intent2, "com.tencent.msg.permission.pushnotify");
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 1001) {
            if (i16 == -1) {
                if (intent != null && intent.getExtras().getInt("requestCode") == 1002) {
                    finishSelf(-1, intent);
                    return;
                }
                com.tencent.mobileqq.equipmentlock.a.b().d(com.tencent.mobileqq.equipmentlock.a.f205359g);
                tryBroadcastDevlockStatus(true, 0);
                if (EquipmentLockImpl.o().g()) {
                    Intent intent2 = new Intent(this, (Class<?>) AuthDevEnableCompleteActivity.class);
                    DevlockInfo devlockInfo = this.mDevlockInfo;
                    if (devlockInfo != null) {
                        intent2.putExtra(KEY_PHONE_NUM, devlockInfo.Mobile);
                        intent2.putExtra("country_code", this.mDevlockInfo.CountryCode);
                    }
                    if (isH5Jump) {
                        intent2.putExtra("h5_flag", true);
                    }
                    startActivity(intent2);
                } else if (this.mShowAuthDevList) {
                    Intent intent3 = new Intent();
                    DevlockInfo devlockInfo2 = this.mDevlockInfo;
                    if (devlockInfo2 != null) {
                        intent3.putExtra(KEY_PHONE_NUM, devlockInfo2.Mobile);
                        intent3.putExtra("country_code", this.mDevlockInfo.CountryCode);
                    }
                    if (getIntent() != null) {
                        intent3.putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
                    }
                    intent3.putExtra(KEY_AUTH_DEV_OPEN, true);
                    if (isH5Jump) {
                        intent3.putExtra("h5_flag", true);
                    }
                    RouteUtils.startActivity(this, intent3, RouterConstants.UI_ROUTE_AUTH_DEV_ACTIVITY);
                }
                Intent intent4 = new Intent();
                intent4.putExtra(KEY_ALLOW_SET, true);
                DevlockInfo devlockInfo3 = this.mDevlockInfo;
                if (devlockInfo3 != null) {
                    intent4.putExtra(KEY_PHONE_NUM, devlockInfo3.Mobile);
                }
                finishSelf(-1, intent4);
                return;
            }
            return;
        }
        if (i3 == 1002) {
            if (i16 == -1) {
                finish();
                return;
            }
            return;
        }
        if (i3 == 1003) {
            if (intent != null && intent.getExtras() != null) {
                int i17 = intent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + i17);
                }
                if (i17 == 2) {
                    String string = intent.getExtras().getString("resultMobileMask");
                    boolean z16 = intent.getExtras().getBoolean("resultSetMobile");
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + string + " openSuccess=" + z16);
                    }
                    DevlockInfo devlockInfo4 = this.mDevlockInfo;
                    if (devlockInfo4 != null) {
                        devlockInfo4.Mobile = string;
                    }
                    if (!z16) {
                        return;
                    }
                    EquipmentLockImpl o16 = EquipmentLockImpl.o();
                    QQAppInterface qQAppInterface = this.app;
                    o16.H(qQAppInterface, this, qQAppInterface.getCurrentAccountUin(), true);
                    tryBroadcastDevlockStatus(true, 0);
                    boolean g16 = EquipmentLockImpl.o().g();
                    Intent intent5 = new Intent(getIntent());
                    DevlockInfo devlockInfo5 = this.mDevlockInfo;
                    if (devlockInfo5 != null) {
                        intent5.putExtra(KEY_PHONE_NUM, devlockInfo5.Mobile);
                        intent5.putExtra("country_code", this.mDevlockInfo.CountryCode);
                    }
                    if (g16) {
                        intent5.setClass(this, AuthDevEnableCompleteActivity.class);
                        startActivity(intent5);
                    } else if (this.mShowAuthDevList) {
                        intent5.putExtra(KEY_AUTH_DEV_OPEN, true);
                        RouteUtils.startActivity(this, intent5, RouterConstants.UI_ROUTE_AUTH_DEV_ACTIVITY);
                    }
                    QQToast.makeText(getApplicationContext(), 2, getString(R.string.aya), 0).show(getTitleBarHeight());
                    Intent intent6 = new Intent();
                    intent6.putExtra(KEY_AUTH_DEV_OPEN, true);
                    intent6.putExtra(KEY_ALLOW_SET, true);
                    DevlockInfo devlockInfo6 = this.mDevlockInfo;
                    if (devlockInfo6 != null) {
                        intent6.putExtra(KEY_PHONE_NUM, devlockInfo6.Mobile);
                    }
                    finishSelf(-1, intent6);
                    return;
                }
                return;
            }
            if (i16 == 0 && intent != null && intent.getExtras() != null) {
                int i18 = intent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + i18);
                }
                if (i18 == 2) {
                    String string2 = intent.getExtras().getString("resultMobileMask");
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + string2);
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        EquipmentLockImpl o17 = EquipmentLockImpl.o();
                        QQAppInterface qQAppInterface2 = this.app;
                        o17.f(qQAppInterface2, qQAppInterface2.getCurrentAccountUin(), null);
                    }
                    DevlockInfo devlockInfo7 = this.mDevlockInfo;
                    if (devlockInfo7 != null) {
                        devlockInfo7.Mobile = string2;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 1004) {
            if (i16 == 3000) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "verify passwd failed");
                }
                tryBroadcastDevlockStatus(false, 3);
                finish();
                overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "verify passwd succ");
            }
            DevlockInfo devlockInfo8 = this.mDevlockInfo;
            if (devlockInfo8 == null) {
                EquipmentLockImpl o18 = EquipmentLockImpl.o();
                QQAppInterface qQAppInterface3 = this.app;
                o18.f(qQAppInterface3, qQAppInterface3.getCurrentAccountUin(), this.mWtLoginObserver);
                return;
            }
            doClickOpenDevLockBtn(devlockInfo8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        Intent intent = super.getIntent();
        if (intent == null) {
            super.doOnCreate(bundle);
            finish();
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            super.doOnCreate(bundle);
            finish();
            return false;
        }
        isH5Jump = checkIsH5CallMe(extras);
        EquipmentLockImpl.o().G(false);
        String string = extras.getString("devlock_open_source");
        if (TextUtils.isEmpty(string)) {
            string = mManually;
        }
        EquipmentLockImpl.o().J(string);
        this.mIsFromLogin = extras.getBoolean(KEY_IS_FROM_LOGIN);
        this.mVerifySeq = extras.getInt("seq");
        this.mDevlockInfo = (DevlockInfo) extras.get(KEY_DEVLOCK_INFO);
        this.mUin = extras.getString("uin");
        this.mFromWhere = extras.getString("from_where");
        this.mMainAccount = extras.getString("mainaccount");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCreate mIsFromLogin = " + this.mIsFromLogin + " mVerifySeq=" + this.mVerifySeq + " mUin=" + this.mUin + " mFromWhere=" + this.mFromWhere + " mMainAccount=" + this.mMainAccount);
            if (this.mDevlockInfo != null) {
                QLog.d(TAG, 2, "onCreate DevlockInfo devSetup:" + this.mDevlockInfo.DevSetup + " countryCode:" + this.mDevlockInfo.CountryCode + " mobile:" + this.mDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.mDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.mDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.mDevlockInfo.AvailableMsgCount + " AllowSet:" + this.mDevlockInfo.AllowSet);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("DevlockInfo.ProtectIntro:");
                sb5.append(this.mDevlockInfo.ProtectIntro);
                sb5.append("  info.MbGuideType:");
                sb5.append(this.mDevlockInfo.MbGuideType);
                QLog.d(TAG, 2, sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("DevlockInfo.MbGuideMsg:");
                sb6.append(this.mDevlockInfo.MbGuideMsg);
                QLog.d(TAG, 2, sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("DevlockInfo.MbGuideInfoType:");
                sb7.append(this.mDevlockInfo.MbGuideInfoType);
                QLog.d(TAG, 2, sb7.toString());
                QLog.d(TAG, 2, "DevlockInfo.MbGuideInfo:" + this.mDevlockInfo.MbGuideInfo);
            }
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.aty);
        super.setTitle(R.string.azi);
        if (this.app == null) {
            this.app = (QQAppInterface) getAppRuntime();
        }
        if (this.app == null) {
            super.doOnCreate(bundle);
            finish();
            return false;
        }
        if (TextUtils.equals(string, "PhoneUnity")) {
            this.leftView.setText(R.string.fsn);
        }
        Button button = (Button) findViewById(R.id.ug_btn);
        this.mBottomBtn = button;
        button.setOnClickListener(this);
        this.mShowAuthDevList = extras.getBoolean("devlock_show_auth_dev_list", true);
        String string2 = extras.getString("devlock_guide_config");
        if (!TextUtils.isEmpty(string2)) {
            try {
                JSONObject jSONObject = new JSONObject(string2);
                this.strDlgTitleText = jSONObject.getString("title");
                this.strGuideContent = jSONObject.getString("wording");
                this.nGuideImageResID = jSONObject.getInt("image_res_id");
                this.strBottomBtnText = jSONObject.getString("btn_text");
                this.strJumpText = jSONObject.getString("jump_text");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            DevlockInfo devlockInfo = this.mDevlockInfo;
            if (devlockInfo != null) {
                parseJson(devlockInfo.ProtectIntro);
            }
        }
        if (TextUtils.isEmpty(this.strGuideContent)) {
            this.strGuideContent = getString(R.string.aze);
        }
        if (TextUtils.isEmpty(this.strDlgPcItemText)) {
            this.strDlgPcItemText = getString(R.string.ayu);
        }
        if (TextUtils.isEmpty(this.strDlgPhoneItemText)) {
            this.strDlgPhoneItemText = getString(R.string.ayv);
        }
        if (TextUtils.isEmpty(this.strConfirmPageParaUp)) {
            this.strConfirmPageParaUp = getString(R.string.ayr);
        }
        if (TextUtils.isEmpty(this.strConfirmPageParaDown)) {
            this.strConfirmPageParaDown = getString(R.string.ays);
        }
        if (TextUtils.isEmpty(this.strDlgTitleText)) {
            this.strDlgTitleText = getString(R.string.ayx);
        }
        initUI(this.strGuideContent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.finish();
        if (getIntent().getBooleanExtra("from_risk_hint", false)) {
            getIntent().removeExtra("from_risk_hint");
            Intent intent = new Intent();
            intent.putExtra("from_risk_hint", true);
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this, intent, -1);
        }
    }

    public void finishSelf(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) intent);
            return;
        }
        setResult(i3, intent);
        if (getIntent().getBooleanExtra("open_devlock_from_roam", false)) {
            finish();
            overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        tryBroadcastDevlockStatus(false, 1);
        Intent intent = new Intent();
        intent.putExtra(KEY_AUTH_DEV_OPEN, false);
        DevlockInfo devlockInfo = this.mDevlockInfo;
        if (devlockInfo != null && !TextUtils.isEmpty(devlockInfo.Mobile)) {
            intent.putExtra(KEY_PHONE_NUM, this.mDevlockInfo.Mobile);
        }
        finishSelf(0, intent);
        if (isH5Jump) {
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this, new Intent(), -1);
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ug_btn) {
                ReportController.o(null, "dc00898", "", "", "0X800A71F", "0X800A71F", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("DevRpt", 2, "\u70b9\u51fb\u6253\u5f00\u8bbe\u5907\u9501\u4e0a\u62a5\uff010X800A71F");
                }
                if (getIntent().getBooleanExtra("open_devlock_verify_passwd", false)) {
                    Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "open_devlock"));
                    startActivityForResult(intent, 1004);
                } else {
                    DevlockInfo devlockInfo = this.mDevlockInfo;
                    if (devlockInfo == null) {
                        EquipmentLockImpl o16 = EquipmentLockImpl.o();
                        QQAppInterface qQAppInterface = this.app;
                        o16.f(qQAppInterface, qQAppInterface.getCurrentAccountUin(), this.mWtLoginObserver);
                    } else {
                        doClickOpenDevLockBtn(devlockInfo);
                    }
                }
                String stringExtra = getIntent().getStringExtra("devlock_open_source");
                if (!TextUtils.isEmpty(stringExtra) && (stringExtra.equals("RoamMsg") || stringExtra.equals("RoamMsgWeb"))) {
                    com.tencent.mobileqq.utils.ff.T(this.app, "chat_history", "LockSet", "Clk_buttonUse", 1, 0, new String[0]);
                }
            } else if (id5 == R.id.ivTitleBtnRightText) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onClick.cancelVerifyCode mVerifyObserver.");
                }
                finish();
                overridePendingTransition(0, R.anim.f154458a7);
                tryBroadcastDevlockStatus(false, 2);
                finish();
                overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
            } else if (id5 == R.id.czm) {
                tryBroadcastDevlockStatus(false, 2);
                finish();
                overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
