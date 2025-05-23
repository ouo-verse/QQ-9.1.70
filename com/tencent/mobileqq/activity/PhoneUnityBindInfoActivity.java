package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.login.api.selectAccount.ISelectAccountHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

@RoutePage(desc = "\u7ed1\u5b9a\u624b\u673a\u53f7\u4fe1\u606fActivity", path = RouterConstants.UI_ROUTER_PHONE_INFO)
/* loaded from: classes9.dex */
public class PhoneUnityBindInfoActivity extends DialogBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    public static final String FROM_SCHEMA = "from_schema";
    public static final String KEY_FROM = "from";
    private static final String QQ_SETTING_SELECT_ACCOUNT_MANAGER = "qq_setting_select_account_manager";
    private static final String REPORT_T_FROM_SHEMA = "0X800B6BF";
    private static final String REPORT_T_PHONE_BIND_ACCOUNT_LINK_CLICK = "0X800C275";
    public static final int REQUEST_BIND_MIBAO = 1009;
    public static final int REQUEST_BIND_MIBAO_UNDER_REVIEW = 1010;
    public static final int REQUEST_CHANGE_BIND_MIBAO = 1011;
    public static final int REQUEST_PHONE_BIND_ACCOUNT_MANAGER = 1013;
    public static final int REQUEST_PROCEED = 1008;
    public static final int REQUEST_VERIFY_PHONE = 1012;
    public static final int RESULT_CONTACT_STOP = 4002;
    public static final int RESULT_CONTACT_UNBIND = 4001;
    static String SEARCH_TITLE = null;
    public static final String TAG = "PhoneUnityBindInfoActivity";
    public static final int WEB_CHANGE_PHONE_RESUEST = 1;
    public static final int WEB_UNITY_CHANGE_PHONE_RESUEST = 2;
    private final int STATE_IOT_PHONE;
    private final int STATE_UNKNOWN;
    private final int STATE_UNVERIFIED_PHONE;
    private final int STATE_VERIFIED_PHONE;
    public com.tencent.mobileqq.phonecontact.observer.b bindObserver;
    public com.tencent.mobileqq.phonecontact.observer.b disableMatchObserver;
    private boolean isReGetPhone;
    BroadcastReceiver mBindMiBaoReceiver;
    private TextView mBindPhoneTv;
    private QQCustomDialog mBindPhoneVerifyDialog;
    private TextView mBindPhoneVerifyTv;
    private Button mChangeBindBtn;
    private int mChangePhoneNum;
    public boolean mCloseThisActivity;
    private QQCustomDialog mContactSecurityDialog;
    private QUISingleLineListItem mContactSwitch;
    private View mContactSwitchCompoundButton;
    private x.b.C8996b mContactSwitchLeft;
    private x.c.f mContactSwitchRight;
    private String mCountryCode;
    private int mCurrentState;
    private Runnable mFinishRunnable;
    private Handler mHandler;
    public boolean mInit;
    private boolean mIsUnBindedUnity;
    public QQCustomDialog mMobileAlreadyBindDialog;
    private QQCustomDialog mNoPwdUnbindLoginDialog;
    public QQCustomDialog mNotSetPasswordDialog;
    private String mPhone;
    private TextView mPhoneBindAccountManagerBtn;
    private PhoneUnityManager.a mPhoneUnityData;
    private QQCustomDialog mPhoneUnityDialog;
    public Bundle mPhoneUnityInfoBundle;
    public PhoneUnityManager mPhoneUnityManager;
    private com.tencent.mobileqq.widget.ap mProgressNotifier;
    com.tencent.mobileqq.app.cx mSecObserver;
    public int mUnBindedNum;
    private TipsBar mUnverifiedBar;
    private int topPadding;
    public com.tencent.mobileqq.phonecontact.observer.b unbindObserver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (PhoneUnityBindInfoActivity.this.mContactSecurityDialog != null) {
                PhoneUnityBindInfoActivity.this.bindContactsMobile();
                PhoneUnityBindInfoActivity.this.mContactSecurityDialog.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (PhoneUnityBindInfoActivity.this.mContactSecurityDialog != null) {
                PhoneUnityBindInfoActivity.this.mContactSecurityDialog.dismiss();
            }
            PhoneUnityBindInfoActivity.this.resetContactSwitch(false);
        }
    }

    /* loaded from: classes9.dex */
    class f extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            QLog.d(PhoneUnityBindInfoActivity.TAG, 1, "bindMiBaoReceiver onReceive");
            if (PhoneUnityBindInfoActivity.this.mChangePhoneNum == 1) {
                ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B316", "0X800B316", 0, 0, "", "", "", "");
            } else if (PhoneUnityBindInfoActivity.this.mChangePhoneNum == 2) {
                ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B326", "0X800B326", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class g implements com.tencent.mobileqq.widget.bf {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void a(View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void b(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void c(View view, int i3, int i16, int i17, int i18) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            int i19 = PhoneUnityBindInfoActivity.this.topPadding / 2;
            if (i16 > 0 && i16 < i19) {
                f16 = i16 / i19;
            } else if (i16 >= i19) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            PhoneUnityBindInfoActivity.this.quiSecNavBar.setTitleBlurAlpha(f16);
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void d(View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class h implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else if (!PhoneUnityBindInfoActivity.this.isFinishing()) {
                PhoneUnityBindInfoActivity.this.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                PhoneUnityBindInfoActivity.this.verifyPhone();
                ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800BAEA", "0X800BAEA", 0, 0, "", "", "", "");
            } else if (i3 == 0) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class k extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.phonecontact.observer.b
        public void onCancelBind(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            super.onCancelBind(z16);
            PhoneUnityBindInfoActivity.this.dismissProgressDialog();
            PhoneUnityBindInfoActivity.this.app.unRegistObserver(this);
            PhoneUnityBindInfoActivity.this.countDownBindedNum();
            if (z16) {
                PhoneUnityBindInfoActivity.this.resetContactSwitch(false);
            } else {
                PhoneUnityBindInfoActivity.this.resetContactSwitch(true);
            }
            PhoneUnityBindInfoActivity.this.phoneUnitySuc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class l extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onBindMobile(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PhoneUnityBindInfoActivity.this.dismissProgressDialog();
                if (z16) {
                    int i3 = bundle.getInt(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT);
                    if (i3 != 104 && i3 != 0) {
                        if (i3 == 107) {
                            String string = PhoneUnityBindInfoActivity.this.mPhoneUnityInfoBundle.getString("country_code");
                            byte[] phoneVasKey = PhoneUnityBindInfoActivity.this.getPhoneVasKey(3);
                            if (phoneVasKey != null) {
                                ((DialogBaseActivity) PhoneUnityBindInfoActivity.this).mPhoneContactService.sendRebindMobileEncrypt(string, phoneVasKey, 0, true, false);
                                PhoneUnityBindInfoActivity.this.showProgressDialog(R.string.hex, 1000L, true);
                            } else if (QLog.isColorLevel()) {
                                QLog.e(PhoneUnityBindInfoActivity.TAG, 2, "sendBindMobileEncrypt contact vaskey is null.");
                            }
                            ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B31D", "0X800B31D", 0, 0, "2", "", "", "");
                            return;
                        }
                        if (i3 == 106) {
                            PhoneUnityBindInfoActivity.this.onBindSuc();
                            ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B31D", "0X800B31D", 0, 0, "1", "", "", "");
                        } else if (i3 == 227) {
                            PhoneUnityBindInfoActivity.this.onMobileBindUinNotSetPasswordError();
                            PhoneUnityBindInfoActivity.this.resetContactSwitch(false);
                        } else if (i3 == 226) {
                            PhoneUnityBindInfoActivity.this.onUinNotSetPasswordError();
                            PhoneUnityBindInfoActivity.this.resetContactSwitch(false);
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(PhoneUnityBindInfoActivity.TAG, 2, "bind error " + i3);
                            }
                            PhoneUnityBindInfoActivity.this.showToast(getBindErrorMessage(i3));
                            PhoneUnityBindInfoActivity.this.resetContactSwitch(false);
                        }
                    } else {
                        PhoneUnityBindInfoActivity.this.gotoBindVerify();
                        PhoneUnityBindInfoActivity.this.resetContactSwitch(false);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(PhoneUnityBindInfoActivity.TAG, 2, "onBindMobile failed");
                    }
                    PhoneUnityBindInfoActivity.this.showToast(R.string.h1y);
                    PhoneUnityBindInfoActivity.this.resetContactSwitch(false);
                }
                PhoneUnityBindInfoActivity phoneUnityBindInfoActivity = PhoneUnityBindInfoActivity.this;
                phoneUnityBindInfoActivity.app.unRegistObserver(phoneUnityBindInfoActivity.bindObserver);
                PhoneUnityBindInfoActivity.this.bindObserver = null;
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onRebindMobile(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                PhoneUnityBindInfoActivity.this.dismissProgressDialog();
                if (!z16) {
                    PhoneUnityBindInfoActivity.this.showToast(R.string.h1y);
                    PhoneUnityBindInfoActivity.this.resetContactSwitch(false);
                } else {
                    PhoneUnityBindInfoActivity.this.gotoBindVerify();
                }
                PhoneUnityBindInfoActivity phoneUnityBindInfoActivity = PhoneUnityBindInfoActivity.this;
                phoneUnityBindInfoActivity.app.unRegistObserver(phoneUnityBindInfoActivity.bindObserver);
                PhoneUnityBindInfoActivity.this.bindObserver = null;
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67254);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            SEARCH_TITLE = "setting_search_title";
        }
    }

    public PhoneUnityBindInfoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mCloseThisActivity = true;
        this.mInit = false;
        this.mUnBindedNum = -1;
        this.mBindPhoneTv = null;
        this.mBindPhoneVerifyTv = null;
        this.mChangeBindBtn = null;
        this.mIsUnBindedUnity = false;
        this.mPhoneUnityData = new PhoneUnityManager.a();
        this.mChangePhoneNum = 0;
        this.isReGetPhone = false;
        this.mHandler = new Handler();
        this.STATE_UNKNOWN = 0;
        this.STATE_UNVERIFIED_PHONE = 1;
        this.STATE_VERIFIED_PHONE = 2;
        this.STATE_IOT_PHONE = 3;
        this.mCurrentState = 0;
        this.topPadding = com.tencent.biz.qui.quisecnavbar.e.b(this);
        this.mBindMiBaoReceiver = new f();
        this.mSecObserver = new com.tencent.mobileqq.app.cx() { // from class: com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.2
            static IPatchRedirector $redirector_;

            /* renamed from: com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity$2$a */
            /* loaded from: classes9.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
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

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneUnityBindInfoActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.app.cx
            public void a(int i3, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                    return;
                }
                if (i3 != 0) {
                    if (i3 == 39) {
                        PhoneUnityBindInfoActivity phoneUnityBindInfoActivity = PhoneUnityBindInfoActivity.this;
                        DialogUtil.createCustomDialog(phoneUnityBindInfoActivity, 230, phoneUnityBindInfoActivity.getString(R.string.f173772u2), PhoneUnityBindInfoActivity.this.getString(R.string.f173802u5), (String) null, PhoneUnityBindInfoActivity.this.getString(R.string.azg), new a(), (DialogInterface.OnClickListener) null).show();
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            str = PhoneUnityBindInfoActivity.this.getString(R.string.crs);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SecSvcObserver", 4, "bindPhoneNumLogin fail retCode: " + i3);
                        }
                        QQToast.makeText(PhoneUnityBindInfoActivity.this, str, 0).show(PhoneUnityBindInfoActivity.this.getTitleBarHeight());
                    }
                    PhoneUnityBindInfoActivity.this.mPhoneUnityData.f181285a = false;
                    ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B320", "0X800B320", 0, 0, "", "", "", "");
                    return;
                }
                PhoneUnityBindInfoActivity.this.mPhoneUnityData.f181285a = true;
                ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B31E", "0X800B31E", 0, 0, "", "", "", "");
            }

            @Override // com.tencent.mobileqq.app.cx
            public void c(boolean z16, Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                    return;
                }
                if (PhoneUnityBindInfoActivity.this.isFinishing()) {
                    return;
                }
                QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo, success=" + z16);
                if (z16 && bundle != null && bundle.getBoolean("is_all_phone_get", true)) {
                    if (PhoneUnityBindInfoActivity.this.mPhoneUnityDialog != null && PhoneUnityBindInfoActivity.this.mPhoneUnityDialog.isShowing()) {
                        PhoneUnityBindInfoActivity.this.mPhoneUnityDialog.dismiss();
                    }
                    PhoneUnityBindInfoActivity.this.initViews(z16, bundle);
                    PhoneUnityBindInfoActivity.this.hideLoading();
                    PhoneUnityBindInfoActivity.this.isReGetPhone = false;
                    return;
                }
                if (!PhoneUnityBindInfoActivity.this.isReGetPhone) {
                    QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo: re-pull PhoneUnityInfo");
                    PhoneUnityBindInfoActivity.this.refreshServerData(1, null);
                    PhoneUnityBindInfoActivity.this.isReGetPhone = true;
                } else {
                    QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo: re-pull PhoneUnityInfo fail, close self");
                    PhoneUnityBindInfoActivity.this.showToast(R.string.f173752u0);
                    PhoneUnityBindInfoActivity.this.hideLoading();
                    if (PhoneUnityBindInfoActivity.this.mFinishRunnable == null) {
                        PhoneUnityBindInfoActivity.this.mFinishRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else if (!PhoneUnityBindInfoActivity.this.isFinishing()) {
                                    PhoneUnityBindInfoActivity.this.finish();
                                }
                            }
                        };
                    }
                    PhoneUnityBindInfoActivity.this.mHandler.postDelayed(PhoneUnityBindInfoActivity.this.mFinishRunnable, 2000L);
                }
                PhoneUnityBindInfoActivity.this.initViews(false, null);
            }

            @Override // com.tencent.mobileqq.app.cx
            protected void e(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                    return;
                }
                if (z17) {
                    PhoneUnityBindInfoActivity.this.updateContactSwitch(z16);
                    PhoneUnityBindInfoActivity.this.mPhoneUnityData.f181287c = z16;
                    PhoneUnityBindInfoActivity.this.mPhoneUnityData.f181286b = z16;
                    if (z16) {
                        ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B31A", "0X800B31A", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                PhoneUnityBindInfoActivity.this.updateContactSwitch(!z16);
                PhoneUnityBindInfoActivity.this.mPhoneUnityData.f181286b = !z16;
                if (z16) {
                    ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B31B", "0X800B31B", 0, 0, "", "", "", "");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.cx
            public void i(int i3, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, i3, (Object) str);
                    return;
                }
                super.i(i3, str);
                PhoneUnityBindInfoActivity.this.countDownBindedNum();
                if (i3 == 0) {
                    PhoneUnityBindInfoActivity.this.mPhoneUnityData.f181285a = false;
                    ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B31F", "0X800B31F", 0, 0, "", "", "", "");
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(PhoneUnityBindInfoActivity.TAG, 2, "UnbindPhoneNumLogin error " + i3 + " errMsg: " + str);
                    }
                    if (!PhoneUnityBindInfoActivity.this.mIsUnBindedUnity) {
                        if (i3 == 36) {
                            PhoneUnityBindInfoActivity.this.showNoPwdUnbindLoginDialog();
                        } else {
                            if (TextUtils.isEmpty(str)) {
                                str = PhoneUnityBindInfoActivity.this.getString(R.string.f173732ty);
                            }
                            QQToast.makeText(PhoneUnityBindInfoActivity.this, str, 0).show(PhoneUnityBindInfoActivity.this.getTitleBarHeight());
                        }
                    }
                    PhoneUnityBindInfoActivity.this.mPhoneUnityData.f181285a = true;
                    ReportController.o(PhoneUnityBindInfoActivity.this.app, "dc00898", "", "", "0X800B321", "0X800B321", 0, 0, "", "", "", "");
                }
                PhoneUnityBindInfoActivity.this.phoneUnitySuc();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDownBindedNum() {
        int i3;
        if (this.mIsUnBindedUnity && (i3 = this.mUnBindedNum) > -1) {
            this.mUnBindedNum = i3 - 1;
            QLog.d(TAG, 1, "phone_unity_info, mUnBindedNum: " + this.mUnBindedNum);
        }
    }

    public static SpannableStringBuilder createBoldText(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, str.length(), 18);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        this.mProgressNotifier.b();
    }

    private void initSecNavBar() {
        this.quiSecNavBar.setBlur(true, findViewById(R.id.root));
        BounceScrollView bounceScrollView = (BounceScrollView) findViewById(R.id.adr);
        bounceScrollView.setClipToPadding(false);
        bounceScrollView.setPadding(0, this.topPadding, 0, 0);
        bounceScrollView.setScrollListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViews(boolean z16, Bundle bundle) {
        boolean z17;
        if (z16 && bundle != null) {
            this.mChangeBindBtn.setVisibility(0);
            setContactSwitchEnable(true);
            this.mPhoneUnityInfoBundle = bundle;
            initPhoneUnityInfo(bundle);
            if (bundle.getInt("need_unify", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (this.mPhoneUnityData.f181288d == 3 && z17) {
                ReportController.o(this.app, "dc00898", "", "", "0X800B313", "0X800B313", 0, 0, "", "", "", "");
                if (!TextUtils.isEmpty(this.mPhoneUnityData.f181292h)) {
                    PhoneUnityManager.m(this, this.app, this.mPhoneUnityData.f181292h, 1010);
                }
                sendUnityBroadcast();
                finish();
                return;
            }
            if (bundle.getInt("check_result") == 1 && TextUtils.isEmpty(bundle.getString("phone_unverified_number"))) {
                String string = bundle.getString("mibao_set_url");
                if (!TextUtils.isEmpty(string)) {
                    PhoneUnityManager.m(this, this.app, string, 1009);
                } else {
                    QLog.e(TAG, 4, "mb set url is null.");
                }
                sendUnityBroadcast();
                finish();
                return;
            }
            this.mPhone = updatePhoneBindUI(bundle);
            if (!((IFeatureRuntimeService) this.app.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(QQ_SETTING_SELECT_ACCOUNT_MANAGER, false)) {
                this.mPhoneBindAccountManagerBtn.setVisibility(8);
            } else if (this.mPhone != null) {
                this.mPhoneBindAccountManagerBtn.setVisibility(0);
            }
            if (z17) {
                showUnityDialog(bundle);
                ReportController.o(this.app, "dc00898", "", "", "0X800B322", "0X800B322", 0, 0, "", "", "", "");
                return;
            }
            ReportController.o(this.app, "dc00898", "", "", "0X800B314", "0X800B314", 0, 0, "", "", "", "");
            if (!QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("phone_unity_banner_tips_need_show" + this.app.getAccount(), false)) {
                return;
            }
            QQToast.makeText(this, 2, getResources().getString(R.string.f173842u9), 0).show();
            sendUnityBroadcast();
            return;
        }
        this.mChangeBindBtn.setVisibility(4);
        setContactSwitchEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doOnCreate$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((ISelectAccountHelper) QRoute.api(ISelectAccountHelper.class)).gotoPhoneBindAccountManager(this, this.mPhone, this.mCountryCode, 1013);
        ReportController.y(this.app, REPORT_T_PHONE_BIND_ACCOUNT_LINK_CLICK);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUnityDialog$2(DialogInterface dialogInterface, int i3) {
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, getString(R.string.b3j), 0).show(getTitleBarHeight());
        } else {
            dialogInterface.dismiss();
            showProgressDialog(R.string.hex, 0L, true);
            this.mUnBindedNum = 2;
            this.mIsUnBindedUnity = true;
            if (this.mPhoneUnityData.f181287c) {
                QLog.i(TAG, 1, "phone_unity_info, unBindContactsMobile");
                unBindContactsMobile();
            } else {
                countDownBindedNum();
                resetContactSwitch(false);
            }
            if (this.mPhoneUnityData.f181285a) {
                QLog.i(TAG, 1, "phone_unity_info, unbindPhoneNumLoginOnPhoneUnity");
                unbindPhoneNumLoginOnPhoneUnity();
            } else {
                countDownBindedNum();
            }
            phoneUnitySuc();
            this.mCloseThisActivity = false;
        }
        ReportController.o(this.app, "dc00898", "", "", "0X800B323", "0X800B323", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUnityDialog$3(DialogInterface dialogInterface, int i3) {
        if (!NetworkUtil.isNetSupport(getApplicationContext())) {
            showToast(R.string.cjm);
            return;
        }
        this.mChangePhoneNum = 2;
        onClickChangeSecurePhone(this.mPhoneUnityData.f181291g);
        dialogInterface.dismiss();
        ReportController.o(this.app, "dc00898", "", "", "0X800B325", "0X800B325", 0, 0, "", "", "", "");
        this.mCloseThisActivity = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUnityDialog$4(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        this.mCloseThisActivity = true;
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUnityDialog$5(DialogInterface dialogInterface) {
        if (this.mCloseThisActivity && !isFinishing()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateContactSwitch$1(View view) {
        this.mContactSwitchCompoundButton = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (this.mPhoneUnityData.f181288d == 3) {
            showUnityUnderReviewDialog();
            resetContactSwitch(!z16);
            ReportController.o(this.app, "dc00898", "", "", "0X800BAE8", "0X800BAE8", 0, 0, "2", "", "", "");
        } else if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, getString(R.string.b3j), 0).show(getTitleBarHeight());
            resetContactSwitch(!z16);
        } else {
            PhoneUnityManager.a aVar = this.mPhoneUnityData;
            if (!aVar.f181287c) {
                ReportController.o(this.app, "dc00898", "", "", "0X800B319", "0X800B319", 0, 0, "2", "", "", "");
                showBindContactPhoneDialog();
            } else if (!aVar.f181286b) {
                openMobileMatch();
                ReportController.o(this.app, "dc00898", "", "", "0X800B319", "0X800B319", 0, 0, "1", "", "", "");
            } else {
                closeMobileMatch();
            }
            ReportController.o(this.app, "dc00898", "", "", "0X800BAE8", "0X800BAE8", 0, 0, "2", "", "", "");
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private boolean onClickChangeSecurePhone(String str) {
        return onClickWebView(str, 1011);
    }

    private boolean onClickWebView(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "url is null.");
            return false;
        }
        PhoneUnityManager.m(this, this.app, str, i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void phoneUnitySuc() {
        if (this.mIsUnBindedUnity && this.mUnBindedNum == 0) {
            this.mUnBindedNum = -1;
            this.mIsUnBindedUnity = false;
            dismissProgressDialog();
            x.c.f fVar = this.mContactSwitchRight;
            if (fVar != null && fVar.getIsChecked()) {
                QQToast.makeText(this, 1, getResources().getString(R.string.f173732ty), 0).show(getTitleBarHeight());
                finish();
            } else {
                sendUnityBroadcast();
                QQToast.makeText(this, 2, getResources().getString(R.string.f173842u9), 0).show(getTitleBarHeight());
                refreshServerData(1, null);
                ReportController.o(this.app, "dc00898", "", "", "0X800B324", "0X800B324", 0, 0, "", "", "", "");
            }
        }
    }

    private void sendUnityBroadcast() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        sendBroadcast(intent);
    }

    private void setContactSwitchEnable(boolean z16) {
        this.mContactSwitch.setEnabled(z16);
        View view = this.mContactSwitchCompoundButton;
        if (view != null) {
            view.setEnabled(z16);
        }
    }

    private void setMaskViewContentDescription(View view) {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        if (this.mContactSwitchRight.getIsChecked()) {
            i3 = R.string.f170788aa2;
        } else {
            i3 = R.string.f170790aa4;
        }
        sb5.append(getString(i3));
        sb5.append(getString(R.string.f173832u8));
        view.setContentDescription(sb5.toString());
    }

    private void showBindContactPhoneDialog() {
        QLog.i(TAG, 1, "showBindContactPhoneDialog");
        if (this.mPhoneUnityInfoBundle == null) {
            return;
        }
        if (this.mContactSecurityDialog == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            createCustomDialog.setCancelable(true);
            createCustomDialog.adjustMessageTopBottomMargin(8.0f, 40.0f);
            createCustomDialog.setTitle(R.string.f173602tl);
            String string = this.mPhoneUnityInfoBundle.getString("phone");
            createCustomDialog.setMessage(Html.fromHtml(String.format(getString(R.string.f173582tj), "<font color=\"#FF8343\">" + string + "</font>")));
            createCustomDialog.setPositiveButton(R.string.f173592tk, new d());
            createCustomDialog.setNegativeButton(R.string.f173572ti, new e());
            this.mContactSecurityDialog = createCustomDialog;
        }
        if (!this.mContactSecurityDialog.isShowing() && !isFinishing()) {
            this.mContactSecurityDialog.show();
            ReportController.o(this.app, "dc00898", "", "", "0X800B31C", "0X800B31C", 0, 0, "", "", "", "");
        }
    }

    private void showLoading() {
        this.mProgressNotifier.f(0, getString(R.string.f173762u1), 0, new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoPwdUnbindLoginDialog() {
        QLog.i(TAG, 1, "showUnityUnderReviewDialog");
        if (this.mNoPwdUnbindLoginDialog == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            createCustomDialog.setCancelable(true);
            createCustomDialog.setTitle(R.string.f173772u2);
            createCustomDialog.adjustMessageTopBottomMargin(8.0f, 40.0f);
            createCustomDialog.setMessage(R.string.f173812u6);
            createCustomDialog.setPositiveButton(R.string.f174062uu, new b());
            this.mNoPwdUnbindLoginDialog = createCustomDialog;
        }
        if (!this.mNoPwdUnbindLoginDialog.isShowing() && !isFinishing()) {
            this.mNoPwdUnbindLoginDialog.show();
        }
    }

    private void showUnityDialog(Bundle bundle) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        String string = bundle.getString("phone");
        Parcelable[] parcelableArray = bundle.getParcelableArray("phone_info");
        String str = "";
        String str2 = "";
        String str3 = str2;
        if (parcelableArray != null) {
            for (Parcelable parcelable : parcelableArray) {
                Bundle bundle2 = (Bundle) parcelable;
                if (bundle2 != null) {
                    int i3 = bundle2.getInt("phone_type", 0);
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                str3 = bundle2.getString("phone");
                            }
                        } else {
                            str = bundle2.getString("phone");
                        }
                    } else {
                        string = bundle2.getString("phone");
                        str2 = string;
                    }
                }
            }
        }
        QQCustomDialog qQCustomDialog = this.mPhoneUnityDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.mPhoneUnityDialog.dismiss();
        }
        this.mCloseThisActivity = true;
        View inflate = LayoutInflater.from(this).inflate(R.layout.f168372u9, (ViewGroup) null);
        if (inflate != null) {
            inflate.setOnClickListener(new j());
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.fms);
            if (linearLayout != null && (textView3 = (TextView) linearLayout.findViewById(R.id.fmu)) != null && !TextUtils.isEmpty(str)) {
                linearLayout.setVisibility(0);
                textView3.setText(str);
            }
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.fmj);
            if (linearLayout2 != null && (textView2 = (TextView) linearLayout2.findViewById(R.id.fml)) != null && !TextUtils.isEmpty(str2)) {
                linearLayout2.setVisibility(0);
                textView2.setText(str2);
            }
            LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.fn7);
            if (linearLayout3 != null && (textView = (TextView) inflate.findViewById(R.id.fne)) != null && !TextUtils.isEmpty(str3)) {
                linearLayout3.setVisibility(0);
                textView.setText(str3);
            }
        }
        QQCustomDialog createVerticalThreeBtnDialog = DialogUtil.createVerticalThreeBtnDialog(this, 0, getString(R.string.crf), "", String.format(getString(R.string.cre), string), getString(R.string.crd), getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.eh
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                PhoneUnityBindInfoActivity.this.lambda$showUnityDialog$2(dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.ei
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                PhoneUnityBindInfoActivity.this.lambda$showUnityDialog$3(dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.ej
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                PhoneUnityBindInfoActivity.this.lambda$showUnityDialog$4(dialogInterface, i16);
            }
        });
        this.mPhoneUnityDialog = createVerticalThreeBtnDialog;
        createVerticalThreeBtnDialog.setView(inflate);
        this.mPhoneUnityDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.activity.ek
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PhoneUnityBindInfoActivity.this.lambda$showUnityDialog$5(dialogInterface);
            }
        });
        this.mPhoneUnityDialog.setCancelable(false);
        this.mPhoneUnityDialog.setCanceledOnTouchOutside(false);
        this.mPhoneUnityDialog.show();
    }

    private void showUnityUnderReviewDialog() {
        QLog.i(TAG, 1, "showUnityUnderReviewDialog");
        if (this.mBindPhoneVerifyDialog == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            createCustomDialog.setCancelable(true);
            createCustomDialog.adjustMessageTopBottomMargin(8.0f, 40.0f);
            createCustomDialog.setMessage(R.string.f173862ua);
            createCustomDialog.setPositiveButton(R.string.f174062uu, new c());
            this.mBindPhoneVerifyDialog = createCustomDialog;
        }
        if (!this.mBindPhoneVerifyDialog.isShowing() && !isFinishing()) {
            this.mBindPhoneVerifyDialog.show();
            ReportController.o(this.app, "dc00898", "", "", "0X800B318", "0X800B318", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContactSwitch(boolean z16) {
        x.c.f fVar;
        if (this.mContactSwitchLeft != null && (fVar = this.mContactSwitchRight) != null) {
            fVar.f(z16);
        } else {
            this.mContactSwitchLeft = new x.b.C8996b(getString(R.string.f173832u8), R.drawable.qui_phone);
            x.c.f fVar2 = new x.c.f(z16, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.ee
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                    PhoneUnityBindInfoActivity.this.onCheckedChanged(compoundButton, z17);
                }
            });
            this.mContactSwitchRight = fVar2;
            fVar2.b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.activity.ef
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    PhoneUnityBindInfoActivity.this.lambda$updateContactSwitch$1(view);
                }
            });
            this.mContactSwitch.setBackgroundType(QUIListItemBackgroundType.AllRound);
            this.mContactSwitch.setStyle(QUIListItemStyle.Card);
        }
        this.mContactSwitch.setConfig(this.mContactSwitchLeft, this.mContactSwitchRight);
        this.mContactSwitch.setFocusable(true);
        this.mContactSwitch.setContentDescription(getString(R.string.f173832u8));
    }

    private void updateIotOrUnverifiedPhoneUI(Button button, View view, Bundle bundle) {
        String string;
        button.setText(R.string.crg);
        this.mBindPhoneVerifyTv.setText(bundle.getString("str_red_dot_tips"));
        this.mBindPhoneVerifyTv.setVisibility(0);
        this.mUnverifiedBar.setBarType(2);
        this.mUnverifiedBar.setTipsIcon(getActivity().getResources().getDrawable(R.drawable.c3g));
        TipsBar tipsBar = this.mUnverifiedBar;
        if (TextUtils.isEmpty(bundle.getString("str_hori_bar_tips"))) {
            string = "";
        } else {
            string = bundle.getString("str_hori_bar_tips");
        }
        tipsBar.setTipsText(string);
        this.mUnverifiedBar.setOnClickListener(this);
        this.mUnverifiedBar.setVisibility(0);
        view.setOnClickListener(this);
        if (this.mCurrentState == 3) {
            this.mBindPhoneTv.setText(getResources().getString(R.string.f173692tu) + bundle.getString("phone"));
        } else {
            this.mBindPhoneTv.setText(getResources().getString(R.string.f173692tu) + bundle.getString("phone_unverified_number"));
        }
        if (this.mPhoneUnityInfoBundle.getBoolean("phone_verified", true)) {
            view.setVisibility(8);
            PhoneUnityManager.a aVar = this.mPhoneUnityData;
            if (aVar.f181287c && aVar.f181286b) {
                updateContactSwitch(true);
                return;
            } else {
                updateContactSwitch(false);
                return;
            }
        }
        view.setVisibility(0);
    }

    private String updatePhoneBindUI(Bundle bundle) {
        if (this.mBindPhoneTv != null) {
            Button button = (Button) findViewById(R.id.tr_);
            String string = bundle.getString("phone");
            this.mCountryCode = bundle.getString("country_code");
            View findViewById = findViewById(R.id.t7t);
            setMaskViewContentDescription(findViewById);
            boolean z16 = bundle.getBoolean("phone_verified", true);
            boolean z17 = bundle.getBoolean("bool_is_IOT", false);
            if (this.mCurrentState == 1 && z16) {
                ReportController.o(this.app, "dc00898", "", "", "0X800BAEB", "0X800BAEB", 0, 0, "", "", "", "");
            }
            if (z17) {
                this.mCurrentState = 3;
                updateIotOrUnverifiedPhoneUI(button, findViewById, bundle);
                ReportController.o(this.app, "dc00898", "", "", "0X800BDA8", "0X800BDA8", 0, 0, "", "", "", "");
            } else if (!z16) {
                updateIotOrUnverifiedPhoneUI(button, findViewById, bundle);
                ReportController.o(this.app, "dc00898", "", "", "0X800BAE3", "0X800BAE3", 0, 0, "", "", "", "");
                this.mCurrentState = 1;
            } else {
                updateVerifiedPhoneUI(button, findViewById, string);
                this.mCurrentState = 2;
            }
            return string;
        }
        return "";
    }

    private void updateVerifiedPhoneUI(Button button, View view, String str) {
        this.mUnverifiedBar.setVisibility(8);
        this.mBindPhoneVerifyTv.setVisibility(8);
        view.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.mBindPhoneTv.setText(getResources().getString(R.string.f173822u7) + str);
            this.mBindPhoneVerifyTv.setText(R.string.f171161cs3);
            if (this.mPhoneUnityData.f181288d == 3) {
                this.mBindPhoneVerifyTv.setVisibility(0);
                button.setText(R.string.f173852u_);
            } else {
                this.mBindPhoneVerifyTv.setVisibility(8);
                button.setText(R.string.crg);
            }
        } else {
            this.mBindPhoneTv.setText(R.string.f173702tv);
            button.setText(R.string.f173552tg);
            this.mPhoneContactService.checkUpdateBindStateAndListIgnoreBindState(true, false, 17);
        }
        PhoneUnityManager.a aVar = this.mPhoneUnityData;
        if (aVar.f181287c && aVar.f181286b) {
            updateContactSwitch(true);
        } else {
            updateContactSwitch(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean verifyPhone() {
        Bundle bundle = this.mPhoneUnityInfoBundle;
        if (bundle == null) {
            QLog.e(TAG, 2, "mPhoneUnityInfoBundle is null.");
            return false;
        }
        if (bundle.getBoolean("bool_is_IOT")) {
            return onClickWebView(this.mPhoneUnityInfoBundle.getString("verify_phone_url"), 1012);
        }
        if (this.mPhoneUnityInfoBundle.getBoolean("phone_verified")) {
            return false;
        }
        return onClickWebView(this.mPhoneUnityInfoBundle.getString("verify_phone_url"), 1012);
    }

    public void bindContactsMobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.mPhoneUnityInfoBundle == null) {
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        if (this.bindObserver == null) {
            l lVar = new l();
            this.bindObserver = lVar;
            this.app.registObserver(lVar);
        }
        String string = this.mPhoneUnityInfoBundle.getString("country_code");
        byte[] phoneVasKey = getPhoneVasKey(3);
        if (phoneVasKey != null) {
            this.mPhoneContactService.sendBindMobileEncrypt(string, phoneVasKey, 0, true, false);
            return;
        }
        resetContactSwitch(false);
        QQToast.makeText(this, 1, getResources().getString(R.string.f173732ty), 0).show(getTitleBarHeight());
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "sendBindMobileEncrypt contact vaskey is null.");
        }
    }

    public void bindPhoneNumLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        if (secSvcHandler != null && this.mPhoneUnityInfoBundle != null) {
            QLog.i(TAG, 1, "phone_unity_info_login, bindPhoneNumLogin");
            byte[] phoneVasKey = getPhoneVasKey(2);
            if (phoneVasKey != null) {
                secSvcHandler.D2(phoneVasKey);
            } else if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "bindPhoneNumLogin contact vaskey is null.");
            }
        }
    }

    public void closeMobileMatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        if (secSvcHandler != null) {
            secSvcHandler.E2();
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnActivityResult requestCode = " + i3 + " resultCode = " + i16);
        }
        switch (i3) {
            case 1008:
                if (i16 != 0 && i16 == -1) {
                    onBindSuc();
                    return;
                } else {
                    resetContactSwitch(false);
                    QQToast.makeText(this, 1, getResources().getString(R.string.f173732ty), 0).show(getTitleBarHeight());
                    return;
                }
            case 1009:
            case 1011:
            case 1012:
                refreshServerData(1, null);
                return;
            case 1010:
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = false;
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        this.mPhoneUnityInfoBundle = getIntent().getBundleExtra("kBindPhoneData");
        super.setSuperContentView(R.layout.f168832az3);
        setTitle(R.string.fsn);
        initSecNavBar();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
        registerReceiver(this.mBindMiBaoReceiver, intentFilter);
        this.mPhoneUnityManager = (PhoneUnityManager) this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
        this.mBindPhoneTv = (TextView) super.findViewById(R.id.z5y);
        this.mBindPhoneVerifyTv = (TextView) super.findViewById(R.id.f246009k);
        this.mChangeBindBtn = (Button) super.findViewById(R.id.tr_);
        this.mContactSwitch = (QUISingleLineListItem) super.findViewById(R.id.t7o);
        this.mUnverifiedBar = (TipsBar) super.findViewById(R.id.t7u);
        this.mPhoneBindAccountManagerBtn = (TextView) super.findViewById(R.id.f243208t);
        this.mProgressNotifier = new com.tencent.mobileqq.widget.ap(this);
        View findViewById = super.findViewById(R.id.f243308u);
        com.tencent.mobileqq.widget.o.m(findViewById, 0, false);
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).topMargin = BaseAIOUtils.f(com.tencent.mobileqq.widget.o.b(), getResources());
        updateContactSwitch(false);
        this.mChangeBindBtn.setOnClickListener(this);
        this.mBindPhoneVerifyTv.setOnClickListener(this);
        PhoneUnityManager phoneUnityManager = this.mPhoneUnityManager;
        if (phoneUnityManager != null) {
            phoneUnityManager.f181279d = true;
        }
        super.addObserver(this.mSecObserver);
        refreshServerData(1, this.mPhoneUnityInfoBundle);
        this.mPhoneBindAccountManagerBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.eg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneUnityBindInfoActivity.this.lambda$doOnCreate$0(view);
            }
        });
        if (FROM_SCHEMA.equals(getIntent().getStringExtra("from"))) {
            ReportController.o(this.app, "dc00898", "", "", REPORT_T_FROM_SHEMA, REPORT_T_FROM_SHEMA, 0, 0, "", "", "", "");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnDestroy();
        super.removeObserver(this.mSecObserver);
        unregisterReceiver(this.mBindMiBaoReceiver);
        Runnable runnable = this.mFinishRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        hideLoading();
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.unbindObserver;
        if (bVar != null) {
            this.app.unRegistObserver(bVar);
            this.unbindObserver = null;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar2 = this.bindObserver;
        if (bVar2 != null) {
            this.app.unRegistObserver(bVar2);
            this.bindObserver = null;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar3 = this.disableMatchObserver;
        if (bVar3 != null) {
            this.app.unRegistObserver(bVar3);
            this.disableMatchObserver = null;
        }
        QQCustomDialog qQCustomDialog = this.mPhoneUnityDialog;
        if (qQCustomDialog != null) {
            if (qQCustomDialog.isShowing()) {
                this.mPhoneUnityDialog.dismiss();
            }
            this.mPhoneUnityDialog = null;
        }
        QQCustomDialog qQCustomDialog2 = this.mMobileAlreadyBindDialog;
        if (qQCustomDialog2 != null) {
            qQCustomDialog2.dismiss();
            this.mMobileAlreadyBindDialog = null;
        }
        QQCustomDialog qQCustomDialog3 = this.mNotSetPasswordDialog;
        if (qQCustomDialog3 != null) {
            qQCustomDialog3.dismiss();
            this.mNotSetPasswordDialog = null;
        }
        QQCustomDialog qQCustomDialog4 = this.mContactSecurityDialog;
        if (qQCustomDialog4 != null) {
            qQCustomDialog4.dismiss();
            this.mContactSecurityDialog = null;
        }
        QQCustomDialog qQCustomDialog5 = this.mBindPhoneVerifyDialog;
        if (qQCustomDialog5 != null) {
            qQCustomDialog5.dismiss();
            this.mBindPhoneVerifyDialog = null;
        }
        QQCustomDialog qQCustomDialog6 = this.mNoPwdUnbindLoginDialog;
        if (qQCustomDialog6 != null) {
            qQCustomDialog6.dismiss();
            this.mNoPwdUnbindLoginDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.doOnResume();
        Intent intent = getIntent();
        if (intent != null && TextUtils.equals(intent.getStringExtra(SEARCH_TITLE), getString(R.string.f173832u8))) {
            ((ISettingApi) QRoute.api(ISettingApi.class)).checkAndStartAnimation(this.mContactSwitch);
        }
    }

    protected byte[] getPhoneVasKey(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (byte[]) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        return this.mPhoneUnityData.f181293i.get(i3);
    }

    protected void gotoBindVerify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (this.mPhoneUnityInfoBundle == null) {
            return;
        }
        byte[] phoneVasKey = getPhoneVasKey(3);
        if (phoneVasKey == null) {
            QLog.e(TAG, 2, "gotoBindVerify contact phoneVasKey is null.");
            return;
        }
        resetContactSwitch(false);
        String string = this.mPhoneUnityInfoBundle.getString("country_code");
        String string2 = this.mPhoneUnityInfoBundle.getString("phone");
        Intent intent = new Intent(this, (Class<?>) BindVerifyActivity.class);
        intent.putExtra("kSrouce", 23);
        intent.putExtra("kBindType", 0);
        intent.putExtra("keyReqBindMode", 0);
        intent.putExtra("cmd_param_is_encrypt", true);
        intent.putExtra("cmd_param_encrypt_mobile", phoneVasKey);
        intent.putExtra("k_mask_number_forshow", string2);
        intent.putExtra("k_country_code", string);
        intent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
        intent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
        intent.putExtra("cmd_param_is_from_uni", true);
        intent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
        intent.putExtra("cmd_param_is_from_change_bind", false);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        if (!isFinishing()) {
            startActivityForResult(intent, 1008);
        }
    }

    protected void initPhoneUnityInfo(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) bundle);
            return;
        }
        this.mPhoneUnityData.a();
        if (bundle != null) {
            this.mPhoneUnityData.f181291g = bundle.getString("mibao_change_url");
            this.mPhoneUnityData.f181290f = bundle.getString("mibao_set_url");
            this.mPhoneUnityData.f181292h = bundle.getString("mibao_verify_url");
            Parcelable[] parcelableArray = bundle.getParcelableArray("phone_info");
            if (parcelableArray != null) {
                for (Parcelable parcelable : parcelableArray) {
                    Bundle bundle2 = (Bundle) parcelable;
                    if (bundle2 != null) {
                        int i3 = bundle2.getInt("phone_type");
                        boolean z16 = true;
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    this.mPhoneUnityData.f181287c = !TextUtils.isEmpty(bundle2.getString("phone"));
                                    PhoneUnityManager.a aVar = this.mPhoneUnityData;
                                    if (!aVar.f181287c || bundle2.getInt("status") != 1) {
                                        z16 = false;
                                    }
                                    aVar.f181286b = z16;
                                    this.mPhoneUnityData.f181293i.put(i3, bundle2.getByteArray("vaskey"));
                                }
                            } else {
                                String string = bundle2.getString("phone");
                                PhoneUnityManager.a aVar2 = this.mPhoneUnityData;
                                if (bundle2.getInt("status") != 1 || TextUtils.isEmpty(string)) {
                                    z16 = false;
                                }
                                aVar2.f181285a = z16;
                                this.mPhoneUnityData.f181293i.put(i3, bundle2.getByteArray("vaskey"));
                            }
                        } else {
                            this.mPhoneUnityData.f181289e = bundle2.getString("phone");
                            this.mPhoneUnityData.f181288d = bundle2.getInt("status");
                            this.mPhoneUnityData.f181293i.put(i3, bundle2.getByteArray("vaskey"));
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    protected void onBindSuc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mPhoneUnityData.f181287c = true;
            openMobileMatch();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.tr_) {
                PhoneUnityManager.a aVar = this.mPhoneUnityData;
                if (aVar.f181288d == 3 && !TextUtils.isEmpty(aVar.f181292h)) {
                    ReportController.o(this.app, "dc00898", "", "", "0X800B317", "0X800B317", 0, 0, "", "", "", "");
                    PhoneUnityManager.m(this, this.app, this.mPhoneUnityData.f181292h, 1010);
                } else if (!TextUtils.isEmpty(this.mPhoneUnityData.f181291g)) {
                    ReportController.o(this.app, "dc00898", "", "", "0X800B315", "0X800B315", 0, 0, "", "", "", "");
                    this.mChangePhoneNum = 1;
                    onClickChangeSecurePhone(this.mPhoneUnityData.f181291g);
                } else {
                    QLog.e(TAG, 2, "change bind phone error.");
                }
                Bundle bundle = this.mPhoneUnityInfoBundle;
                if (bundle != null && bundle.getBoolean("bool_is_IOT")) {
                    ReportController.o(this.app, "dc00898", "", "", "0X800BDAB", "0X800BDAB", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.app, "dc00898", "", "", "0X800BAE6", "0X800BAE6", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.t7u) {
                Bundle bundle2 = this.mPhoneUnityInfoBundle;
                if (bundle2 != null && bundle2.getBoolean("bool_is_IOT")) {
                    ReportController.o(this.app, "dc00898", "", "", "0X800BDA9", "0X800BDA9", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.app, "dc00898", "", "", "0X800BAE4", "0X800BAE4", 0, 0, "", "", "", "");
                }
                verifyPhone();
            } else if (id5 == R.id.f246009k) {
                Bundle bundle3 = this.mPhoneUnityInfoBundle;
                if (bundle3 != null && bundle3.getBoolean("bool_is_IOT")) {
                    ReportController.o(this.app, "dc00898", "", "", "0X800BDAA", "0X800BDAA", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.app, "dc00898", "", "", "0X800BAE5", "0X800BAE5", 0, 0, "", "", "", "");
                }
                verifyPhone();
            } else if (id5 == R.id.t7t) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
                createCustomDialog.setTitle(getString(R.string.f173632to));
                createCustomDialog.setMessage(getString(R.string.f173612tm));
                i iVar = new i();
                createCustomDialog.setPositiveButton(getString(R.string.f173622tn), iVar);
                createCustomDialog.setNegativeButton(getString(R.string.f170647xd), iVar);
                createCustomDialog.show();
                ReportController.o(this.app, "dc00898", "", "", "0X800BAE9", "0X800BAE9", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected void onMobileBindUinNotSetPasswordError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (this.mMobileAlreadyBindDialog == null) {
            this.mMobileAlreadyBindDialog = DialogUtil.createCustomDialog(this, 230, getString(R.string.f173772u2), getString(R.string.f173782u3), (String) null, HardCodeUtil.qqStr(R.string.k1n), new m(), (DialogInterface.OnClickListener) null);
        }
        QQCustomDialog qQCustomDialog = this.mMobileAlreadyBindDialog;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !isFinishing()) {
            this.mMobileAlreadyBindDialog.show();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            super.onPostThemeChanged();
            RFWThemeUtil.setNavigationBarColor(this, getColor(R.color.qui_common_bg_bottom_standard));
        }
    }

    protected void onUinNotSetPasswordError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (this.mNotSetPasswordDialog == null) {
            this.mNotSetPasswordDialog = DialogUtil.createCustomDialog(this, 230, (String) null, getString(R.string.f173792u4), (String) null, HardCodeUtil.qqStr(R.string.k1r), new a(), (DialogInterface.OnClickListener) null);
        }
        QQCustomDialog qQCustomDialog = this.mNotSetPasswordDialog;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !isFinishing()) {
            this.mNotSetPasswordDialog.show();
        }
    }

    public void openMobileMatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        if (secSvcHandler != null) {
            secSvcHandler.S2();
        }
    }

    public void refreshServerData(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
            return;
        }
        if (bundle == null) {
            initViews(false, null);
            SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
            if (secSvcHandler != null) {
                QLog.i(TAG, 1, "refreshServerData, getPhoneUnityInfo");
                secSvcHandler.G2(i3);
                showLoading();
                return;
            }
            return;
        }
        QLog.i(TAG, 1, "init with prefetched bind phone data");
        initViews(true, bundle);
    }

    protected void resetContactSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            updateContactSwitch(z16);
        }
    }

    public void unBindContactsMobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.mPhoneUnityInfoBundle == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "InfoBundle is null.");
                return;
            }
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        if (this.unbindObserver == null) {
            k kVar = new k();
            this.unbindObserver = kVar;
            this.app.registObserver(kVar);
        }
        byte[] phoneVasKey = getPhoneVasKey(3);
        if (phoneVasKey != null) {
            QLog.i(TAG, 1, "phone_unity_info, unbindMobileEncrypt");
            this.mPhoneContactService.unbindMobileEncrypt(phoneVasKey, true, false);
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "unbindMobileEncrypt contact vaskey is null.");
        }
    }

    public void unbindPhoneNumLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        if (secSvcHandler != null && this.mPhoneUnityInfoBundle != null) {
            QLog.i(TAG, 1, "phone_unity_info_login, unbindPhoneNumLogin");
            byte[] phoneVasKey = getPhoneVasKey(2);
            if (phoneVasKey != null) {
                secSvcHandler.W2(phoneVasKey);
            } else if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "unbindPhoneNumLogin contact vaskey is null.");
            }
        }
    }

    public void unbindPhoneNumLoginOnPhoneUnity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        if (secSvcHandler != null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "unbindPhoneNumLoginOnPhoneUnity contact.");
            }
            secSvcHandler.X2();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
