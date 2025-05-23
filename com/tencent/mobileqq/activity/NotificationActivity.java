package com.tencent.mobileqq.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.ProtoUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.ims.AlertReport$ButtonAction;
import com.tencent.ims.signature$SignatureKickData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.graycheck.business.GrayCheckHandler;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.NumberUtil;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "\u901a\u77e5\u7c7b\u5f39\u6846activity", path = RouterConstants.UI_ROUTER_NOTIFICATION)
/* loaded from: classes9.dex */
public class NotificationActivity extends QBaseActivity implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_NIGHT_COLOR = "#FFFFFF";
    public static final int DIALOG_ANOTHER_TERMINAL_LOGIN = 5;
    public static final int DIALOG_CLONE_LOGIN = 12;
    public static final int DIALOG_IDENTITY_EXPIRED = 1;
    public static final int DIALOG_SDK_SUSPENDED = 4;
    public static final int DIALOG_SECURITY_SCAN = 7;
    public static final int DIALOG_SSO_TIPS = 6;
    public static final String DLG_CONTENT = "dlg_content";
    public static final String DLG_LBUTTON = "dlg_lbutton";
    public static final String DLG_RBUTTON = "dlg_rbutton";
    public static final String DLG_TITLE = "dlg_title";
    public static final String DLG_URL = "dlg_url";
    public static final String KEY_ALIAS = "alias";
    public static final String KEY_ERROR = "error";
    public static final String KEY_IS_FROM_LH_LOGIN_VERIFY_CODE = "lh_is_from_login_verify_code";
    public static final String KEY_LAST_ERROR = "lastError";
    public static final int MSF_APPLY_GRAY_VERSION_EXPIRED = 10;
    public static final int MSF_APPLY_GRAY_VERSION_FAILED = 8;
    public static final int MSF_APPLY_GRAY_VERSION_START = 7;
    public static final int MSF_APPLY_GRAY_VERSION_SUCCESS = 9;
    public static final int MSF_APPLY_GRAY_VERSION_TIME_OUT = 11;
    public static final String PASSWORD = "password";
    public static final int PAYRESULT_SUCC = 0;
    private static final String SEC_TAG = "sec_sig_tag";
    private static final String TAG = "NotificationActivity";
    private static final int TIPS_SENEDES_ID_DEFAULT = 0;
    public static NotificationActivity instance;
    private static Boolean mIsOpenNavigationBarImmersive;
    private static com.tencent.mobileqq.qqsec.api.c sSecControllerInjectInterface;
    private final int MSG_CARD_STATUS_ERROR;
    private final int MSG_CARD_STATUS_NO;
    private final int MSG_CARD_STATUS_OK;
    private final int MSG_LH_RECEIVE_FAIL;
    private final int MSG_LH_RECEIVE_START;
    private final int MSG_LH_RECEIVE_SUCCESS;
    private Dialog dialog;
    private int dlgType;
    private byte[] expiredSig;
    private final ak frozenDlgHelper;
    private final com.tencent.mobileqq.graycheck.business.a grayCheckObserver;
    private boolean isAlreadyAuthorized;
    private boolean isDialogShow;
    private long lastApplyGrayVersionTime;
    private com.tencent.mobileqq.vip.m lhHelper;
    private String loginAlias;
    private int loginRet;
    private final aj mFrozenData;
    private QQProgressDialog mLoadingDialog;
    private Constants.LogoutReason mReason;
    private BroadcastReceiver mReceiver;

    /* renamed from: msg, reason: collision with root package name */
    private String f176494msg;
    private al myClickListener;
    private am receiveClickListener;
    private am renewalClickListener;
    private String title;
    private MqqHandler uiHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NotificationActivity.this.kickedLogin(false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class aa implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        aa() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NotificationActivity.this.checkSetResult(0);
                NotificationActivity.this.finish();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class ab implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        ab() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NotificationActivity.this.logoutAndExitApp();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class ac extends com.tencent.mobileqq.graycheck.business.a {
        static IPatchRedirector $redirector_;

        ac() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.graycheck.business.a
        public void d(String str, String str2, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            super.d(str, str2, i3, j3);
            QLog.d("GrayCheck.tag", 1, "[GrayCheckObserver], onSignUpExpired, uin: " + str + ", errorMsg: " + str2 + ", ret: " + i3 + ", totalGrayUin: " + j3);
            Message obtainMessage = NotificationActivity.this.uiHandler.obtainMessage(10);
            Bundle bundle = new Bundle();
            bundle.putString("errorMsg", str2);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }

        @Override // com.tencent.mobileqq.graycheck.business.a
        public void e(String str, String str2, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            super.e(str, str2, i3, j3);
            QLog.d("GrayCheck.tag", 1, "[GrayCheckObserver], onSignUpFailed, uin: " + str + ", errorMsg: " + str2 + ", ret: " + i3 + ", totalGrayUin: " + j3);
            NotificationActivity.this.uiHandler.sendEmptyMessage(8);
        }

        @Override // com.tencent.mobileqq.graycheck.business.a
        public void f(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
                return;
            }
            super.f(str, j3);
            QLog.d("GrayCheck.tag", 1, "[GrayCheckObserver], onSignUpSuccess, uin: " + str + ", totalGrayUin: " + j3);
            NotificationActivity.this.uiHandler.sendEmptyMessage(9);
        }

        @Override // com.tencent.mobileqq.graycheck.business.a
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            super.g();
            QLog.d("GrayCheck.tag", 1, "[GrayCheckObserver], onSignUpTimeOut");
            NotificationActivity.this.uiHandler.sendEmptyMessage(11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ad implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        ad() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.i(NotificationActivity.TAG, 1, "setNegativeButton.onClick: invoked.  isDialogShow: " + NotificationActivity.this.isDialogShow);
            NotificationActivity.sSecControllerInjectInterface.a(NotificationActivity.this, false, false);
            NotificationActivity.this.jumpLoginAndFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ae implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        ae() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                NotificationActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class af extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        af() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (intent.getAction().equals("com.tencent.mobileqq.closeNotification") && NotificationActivity.this.dlgType == 5) {
                NotificationActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ag implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        ag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ReportController.r(null, "dc00898", "", "", "0X800B430", "0X800B430", 0, 0, "", "", "", "");
            NotificationActivity.this.getAppRuntime().logout(true);
            if (!TextUtils.isEmpty(NotificationActivity.this.getAppRuntime().getCurrentAccountUin())) {
                AutoLoginUtil.setAutoLogin(NotificationActivity.this.getAppRuntime().getCurrentAccountUin(), false);
            }
            ArrayList<String> h16 = NotificationActivity.sSecControllerInjectInterface.h((BaseQQAppInterface) NotificationActivity.this.getAppRuntime());
            if (h16 != null && h16.size() > 0) {
                Iterator<String> it = h16.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!com.tencent.mobileqq.phonelogin.a.a().b(NotificationActivity.this.getAppRuntime(), next)) {
                        NotificationActivity.this.getAppRuntime().updateSubAccountLogin(next, false);
                        NotificationActivity.this.getAppRuntime().getApplication().refreAccountList();
                    }
                }
            }
            if (NotificationActivity.this.getIntent().getBooleanExtra("is_from_login_page", false)) {
                NotificationActivity.this.finish();
                NotificationActivity.this.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
                return;
            }
            Intent addFlags = new Intent().putExtra("loginFragmentType", 5).putExtra("uin", NotificationActivity.this.getAppRuntime().getCurrentAccountUin()).addFlags(67108864);
            Navigator createNavigator = QRoute.createNavigator(NotificationActivity.this.getBaseContext(), RouterConstants.UI_ROUTER_LOGIN);
            createNavigator.withInt("loginFragmentType", 5);
            if (addFlags != null) {
                if (addFlags.getExtras() != null) {
                    createNavigator.withAll(addFlags.getExtras());
                }
                createNavigator.withFlags(addFlags.getFlags());
            }
            createNavigator.requestWithReturn();
            NotificationActivity.this.overridePendingTransition(R.anim.f154454a3, R.anim.f154550b4);
            NotificationActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ah implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        ah() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NotificationActivity.this.exitApp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ai implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        ai() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (NotificationActivity.this.getIntent().getBooleanExtra("is_from_login_page", false)) {
                NotificationActivity.this.finish();
                NotificationActivity.this.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
            } else {
                NotificationActivity.this.kickToLoginActivity(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ak {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ aj f176521d;

            a(aj ajVar) {
                this.f176521d = ajVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ak.this, (Object) ajVar);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                com.tencent.mobileqq.app.security.a.d().n((BaseQQAppInterface) NotificationActivity.this.getAppRuntime(), this.f176521d.f176517h, 1, NotificationActivity.this.f176494msg);
                aj ajVar = this.f176521d;
                if (ajVar.f176514e) {
                    if (MiniAppSecurityUtil.checkMiniAppForLogin(ajVar.f176510a)) {
                        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                        NotificationActivity notificationActivity = NotificationActivity.this;
                        aj ajVar2 = this.f176521d;
                        iMiniAppService.startMiniApp(notificationActivity, ajVar2.f176510a, ajVar2.f176518i, null);
                    } else {
                        QLog.e(NotificationActivity.TAG, 1, "MiniAppLauncher.startMiniApp error: fake app!");
                    }
                } else {
                    String e16 = com.tencent.mobileqq.app.security.a.d().e(this.f176521d.f176510a, NotificationActivity.this.loginAlias, this.f176521d.f176519j);
                    RouteUtils.startActivity(NotificationActivity.this, new Intent().putExtra("url", e16), RouterConstants.UI_ROUTE_BROWSER);
                }
                NotificationActivity.this.finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ aj f176523d;

            b(aj ajVar) {
                this.f176523d = ajVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ak.this, (Object) ajVar);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    com.tencent.mobileqq.app.security.a.d().n((BaseQQAppInterface) NotificationActivity.this.getAppRuntime(), this.f176523d.f176517h, 2, NotificationActivity.this.f176494msg);
                    NotificationActivity.this.finish();
                }
            }
        }

        ak() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
        }

        private String b(String str) {
            if (!AppSetting.o(BaseApplication.getContext())) {
                return str;
            }
            Map<String, String> arguments = URLUtil.getArguments("_wwv");
            long j3 = 2;
            if (arguments.containsKey("_wwv")) {
                j3 = 2 | NumberUtil.stringToLong(arguments.get("_wwv"));
            }
            return URLUtil.addParameter(URLUtil.deleteParameter(str, "_wwv"), "_wwv", String.valueOf(j3));
        }

        private String c(Map<String, String> map) {
            if (map == null) {
                return "";
            }
            String str = map.get("uin");
            if (TextUtils.isEmpty(str)) {
                return NotificationActivity.this.loginAlias;
            }
            return str;
        }

        private void d(aj ajVar) {
            Map<String, String> argumentsFromURL = MiniAppSecurityUtil.getArgumentsFromURL(ajVar.f176510a);
            if (argumentsFromURL == null) {
                QLog.e("handleMiniAppFeature", 1, "paramMap == null");
                return;
            }
            String str = argumentsFromURL.get("forbid_token");
            ajVar.f176513d = argumentsFromURL.get("forbid_status");
            QLog.d("handleMiniAppFeature", 2, "mErrorUrl = " + ajVar.f176510a);
            if (TextUtils.isEmpty(str) && ajVar.f176511b != 1 && !com.tencent.mobileqq.app.security.a.d().m(NotificationActivity.this.mFrozenData.f176510a)) {
                return;
            }
            ajVar.f176514e = true;
            String c16 = c(argumentsFromURL);
            MiniAppSecurityUtil.updateLoginMiniAppUin(BaseApplication.getContext(), c16);
            MiniAppSecurityUtil.updateLoginMiniAppForbidToken(BaseApplication.getContext(), c16, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Dialog e(aj ajVar) {
            String str;
            com.tencent.mobileqq.app.security.a.d().n((BaseQQAppInterface) NotificationActivity.this.getAppRuntime(), ajVar.f176517h, 0, NotificationActivity.this.f176494msg);
            int f16 = com.tencent.mobileqq.app.security.a.d().f(NotificationActivity.this.f176494msg, ajVar.f176517h, 0);
            CharSequence i3 = com.tencent.mobileqq.app.security.a.d().i(NotificationActivity.this.f176494msg + "\u4f60\u4e5f\u53ef\u4ee5\u5bf9\u8d26\u53f7\u8fdb\u884c<TITLE=\"\u8d44\u91d1\u7ba1\u7406\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">\u3002", NotificationActivity.this, f16);
            if (ajVar.f176517h == 2) {
                ajVar.f176518i = 2201;
            }
            if (TextUtils.isEmpty(ajVar.f176516g)) {
                str = NotificationActivity.this.getResources().getString(R.string.f1355901v);
            } else {
                str = ajVar.f176516g;
            }
            return DialogUtil.createCustomDialogUrlWithoutAutoLink(NotificationActivity.this, 230, str, i3, R.string.cancel, com.tencent.mobileqq.app.security.a.d().g(ajVar.f176517h), new a(ajVar), new b(ajVar));
        }

        public void f(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
                return;
            }
            if (intent == null) {
                QLog.e("parseFrozenDataFromIntent", 1, "loginFailedIntent == null");
                return;
            }
            NotificationActivity.this.mFrozenData.f176512c = 0;
            NotificationActivity.this.mFrozenData.f176510a = "";
            NotificationActivity.this.mFrozenData.f176511b = 0;
            NotificationActivity.this.mFrozenData.f176513d = "";
            NotificationActivity.this.mFrozenData.f176514e = false;
            NotificationActivity.this.mFrozenData.f176516g = "";
            NotificationActivity.this.mFrozenData.f176517h = -1;
            NotificationActivity.this.mFrozenData.f176518i = 2098;
            if (intent.getBooleanExtra("keyFromLoginView", false)) {
                ReportController.r(NotificationActivity.this.getAppRuntime(), "dc00898", "", "", "0X800B292", "0X800B292", 0, 0, "", "", NotificationActivity.this.f176494msg, "");
            } else if (intent.getBooleanExtra("keyFromAddAccount", false)) {
                ReportController.r(NotificationActivity.this.getAppRuntime(), "dc00898", "", "", "0X800B294", "0X800B294", 0, 0, "", "", NotificationActivity.this.f176494msg, "");
            } else if (intent.getBooleanExtra("keyFromBindAccount", false)) {
                ReportController.r(NotificationActivity.this.getAppRuntime(), "dc00898", "", "", "0X800B296", "0X800B296", 0, 0, "", "", NotificationActivity.this.f176494msg, "");
            }
            NotificationActivity.this.mFrozenData.f176512c = intent.getIntExtra("keyTipsScenesId", 0);
            NotificationActivity.this.mFrozenData.f176510a = intent.getStringExtra(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
            NotificationActivity.this.mFrozenData.f176511b = intent.getIntExtra("errorver", 0);
            NotificationActivity.this.mFrozenData.f176519j = intent.getBooleanExtra("is_need_login_with_mask", false);
            NotificationActivity.this.mFrozenData.f176516g = intent.getStringExtra("errortitle");
            NotificationActivity.this.mFrozenData.f176517h = com.tencent.mobileqq.app.security.a.d().c(intent.getByteArrayExtra("tlverror"));
            if (!TextUtils.isEmpty(NotificationActivity.this.mFrozenData.f176510a)) {
                if (NotificationActivity.this.mFrozenData.f176511b != 1) {
                    NotificationActivity.this.mFrozenData.f176510a = b(NotificationActivity.this.mFrozenData.f176510a);
                } else {
                    d(NotificationActivity.this.mFrozenData);
                }
            }
        }

        /* synthetic */ ak(NotificationActivity notificationActivity, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) notificationActivity, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class al implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        al() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view.getId() == R.id.close) {
                NotificationActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class am implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f176526d;

        public am(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this, i3);
            } else {
                this.f176526d = i3;
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 0) {
                int i16 = this.f176526d;
                if (i16 == 1) {
                    NotificationActivity.this.receiveLhCard();
                    NotificationActivity.this.uiHandler.sendEmptyMessage(4);
                    return;
                } else {
                    if (i16 == 2) {
                        NotificationActivity notificationActivity = NotificationActivity.this;
                        notificationActivity.payExpiredAccount(notificationActivity.loginRet);
                        return;
                    }
                    return;
                }
            }
            if (i3 == 1) {
                NotificationActivity.this.buyoutLh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NotificationActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NotificationActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NotificationActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            SettingCloneUtil.writeValue((Context) NotificationActivity.this.getAppRuntime().getApp(), (String) null, AppConstants.Preferences.SECURITY_SCAN_KEY, AppConstants.QQSETTING_SECURITY_SCAN_KEY, true);
            NotificationActivity.sSecControllerInjectInterface.f(NotificationActivity.this);
            NotificationActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NotificationActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NotificationActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                ReportController.o(null, "P_CliOper", "Safe_StartAppCheck", "", "DIALOG_PACKAGE_INVALID", "LeftButton", 0, 0, "", "", "", "");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            NotificationActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f176535d;

        i(String str) {
            this.f176535d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                NotificationActivity.this.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(this.f176535d)));
            } catch (Exception unused) {
                try {
                    ReportController.o(null, "P_CliOper", "Safe_StartAppCheck", "", "DIALOG_PACKAGE_INVALID", "RightButton", 0, 0, "", "", "", "");
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    NotificationActivity.this.finish();
                }
            } catch (Throwable th5) {
                try {
                    ReportController.o(null, "P_CliOper", "Safe_StartAppCheck", "", "DIALOG_PACKAGE_INVALID", "RightButton", 0, 0, "", "", "", "");
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                NotificationActivity.this.finish();
                throw th5;
            }
            try {
                ReportController.o(null, "P_CliOper", "Safe_StartAppCheck", "", "DIALOG_PACKAGE_INVALID", "RightButton", 0, 0, "", "", "", "");
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
                NotificationActivity.this.finish();
            }
            NotificationActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CheckBox f176537d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f176538e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f176539f;

        j(CheckBox checkBox, boolean z16, SharedPreferences sharedPreferences) {
            this.f176537d = checkBox;
            this.f176538e = z16;
            this.f176539f = sharedPreferences;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotificationActivity.this, checkBox, Boolean.valueOf(z16), sharedPreferences);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                boolean isChecked = this.f176537d.isChecked();
                if (this.f176538e != isChecked) {
                    this.f176539f.edit().putBoolean("MemoryAlertAutoClear", isChecked).commit();
                }
            } catch (Exception unused) {
            }
            NotificationActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CheckBox f176541d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f176542e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f176543f;

        k(CheckBox checkBox, boolean z16, SharedPreferences sharedPreferences) {
            this.f176541d = checkBox;
            this.f176542e = z16;
            this.f176543f = sharedPreferences;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotificationActivity.this, checkBox, Boolean.valueOf(z16), sharedPreferences);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                boolean isChecked = this.f176541d.isChecked();
                if (this.f176542e != isChecked) {
                    this.f176543f.edit().putBoolean("MemoryAlertAutoClear", isChecked).commit();
                }
                ImageCacheHelper.f98636a.e();
            } catch (Exception unused) {
            } catch (Throwable th5) {
                NotificationActivity.this.finish();
                throw th5;
            }
            NotificationActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f176545d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f176546e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f176547f;

        l(String str, int i3, String str2) {
            this.f176545d = str;
            this.f176546e = i3;
            this.f176547f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotificationActivity.this, str, Integer.valueOf(i3), str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                try {
                    if (!TextUtils.isEmpty(this.f176545d)) {
                        String currentAccountUin = NotificationActivity.this.getAppRuntime().getCurrentAccountUin();
                        Intent intent = new Intent();
                        intent.putExtra("uin", currentAccountUin);
                        String str2 = this.f176545d;
                        if (str2.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1) {
                            str = str2 + "?uin=" + currentAccountUin;
                        } else {
                            str = str2 + "&uin=" + currentAccountUin;
                        }
                        intent.putExtra("url", str);
                        RouteUtils.startActivity(NotificationActivity.this, intent, RouterConstants.UI_ROUTE_BROWSER);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    try {
                        AlertReport$ButtonAction alertReport$ButtonAction = new AlertReport$ButtonAction();
                        alertReport$ButtonAction.uint32_cmd.set(1);
                        alertReport$ButtonAction.uint32_button_id.set(this.f176546e);
                        alertReport$ButtonAction.str_package_name.set(com.tencent.qqprotect.common.a.a());
                        alertReport$ButtonAction.uint32_app_id.set(AppSetting.f());
                        ProtoUtils.g(NotificationActivity.this.getAppRuntime(), alertReport$ButtonAction.toByteArray(), "SecuritySvc.AlertReport");
                        ReportController.o(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.f176546e, 0, this.f176547f, "", "", "");
                    } catch (Exception e17) {
                        e = e17;
                        e.printStackTrace();
                        NotificationActivity.this.finish();
                    }
                }
                try {
                    AlertReport$ButtonAction alertReport$ButtonAction2 = new AlertReport$ButtonAction();
                    alertReport$ButtonAction2.uint32_cmd.set(1);
                    alertReport$ButtonAction2.uint32_button_id.set(this.f176546e);
                    alertReport$ButtonAction2.str_package_name.set(com.tencent.qqprotect.common.a.a());
                    alertReport$ButtonAction2.uint32_app_id.set(AppSetting.f());
                    ProtoUtils.g(NotificationActivity.this.getAppRuntime(), alertReport$ButtonAction2.toByteArray(), "SecuritySvc.AlertReport");
                    ReportController.o(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.f176546e, 0, this.f176547f, "", "", "");
                } catch (Exception e18) {
                    e = e18;
                    e.printStackTrace();
                    NotificationActivity.this.finish();
                }
                NotificationActivity.this.finish();
            } catch (Throwable th5) {
                try {
                    AlertReport$ButtonAction alertReport$ButtonAction3 = new AlertReport$ButtonAction();
                    alertReport$ButtonAction3.uint32_cmd.set(1);
                    alertReport$ButtonAction3.uint32_button_id.set(this.f176546e);
                    alertReport$ButtonAction3.str_package_name.set(com.tencent.qqprotect.common.a.a());
                    alertReport$ButtonAction3.uint32_app_id.set(AppSetting.f());
                    ProtoUtils.g(NotificationActivity.this.getAppRuntime(), alertReport$ButtonAction3.toByteArray(), "SecuritySvc.AlertReport");
                    ReportController.o(null, "P_CliOper", "Safe_AlertReport", "", "0X8007536", "0X8007536", this.f176546e, 0, this.f176547f, "", "", "");
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
                NotificationActivity.this.finish();
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f176549d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f176550e;

        m(int i3, String str) {
            this.f176549d = i3;
            this.f176550e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotificationActivity.this, Integer.valueOf(i3), str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                AlertReport$ButtonAction alertReport$ButtonAction = new AlertReport$ButtonAction();
                alertReport$ButtonAction.uint32_cmd.set(1);
                alertReport$ButtonAction.uint32_button_id.set(this.f176549d);
                alertReport$ButtonAction.str_package_name.set(com.tencent.qqprotect.common.a.a());
                alertReport$ButtonAction.uint32_app_id.set(AppSetting.f());
                ProtoUtils.g(NotificationActivity.this.getAppRuntime(), alertReport$ButtonAction.toByteArray(), "SecuritySvc.AlertReport");
                ReportController.o(null, "P_CliOper", "Safe_AlertReport", "", "0X8007535", "0X8007535", this.f176549d, 0, this.f176550e, "", "", "");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            NotificationActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QLog.i(NotificationActivity.TAG, 2, "handleCloneLogin dialog.onDismiss");
                NotificationActivity.this.kickToLoginActivity(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f176554d;

        p(String str) {
            this.f176554d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", "100686848");
                jSONObject.put("apkId", "6633");
                jSONObject.put("versionCode", String.valueOf(InstalledAppListMonitor.getPackageInfo(NotificationActivity.this.getPackageManager(), this.f176554d, 16384).versionCode));
                jSONObject.put("via", "ANDROIDQQ.NEICE.OTHER");
                jSONObject.put(DKEngine.GlobalKey.APP_PACKAGE_NAME, this.f176554d);
                jSONObject.put(WadlProxyConsts.CHANNEL, "000316053134377c30");
                jSONObject.put("appAuthorizedStr", NotificationActivity.this.f176494msg);
                NotificationActivity.sSecControllerInjectInterface.d(NotificationActivity.this, jSONObject.toString());
                NotificationActivity.this.isAlreadyAuthorized = true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class q implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - NotificationActivity.this.lastApplyGrayVersionTime) > 1000 || NotificationActivity.this.lastApplyGrayVersionTime == 0) {
                NotificationActivity.this.lastApplyGrayVersionTime = currentTimeMillis;
                NotificationActivity.this.uiHandler.sendEmptyMessage(7);
                NotificationActivity.this.handleGrayCheckSignUp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class r implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NotificationActivity.this.logoutAndExitApp();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class s implements com.tencent.mobileqq.qroute.route.m<Object> {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.m
        public void a(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
            } else if (!NotificationActivity.this.isFinishing()) {
                NotificationActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class t implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else {
                    NotificationActivity.this.exitApp();
                }
            }
        }

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                NotificationActivity notificationActivity = NotificationActivity.this;
                ProgressDialog showProgressDialog = DialogUtil.showProgressDialog(notificationActivity, notificationActivity.getResources().getDrawable(R.drawable.sc_publish_spinner_temp), R.string.b0s);
                showProgressDialog.setOnDismissListener(new a());
                NotificationActivity.sSecControllerInjectInterface.e((BaseQQAppInterface) NotificationActivity.this.getAppRuntime(), showProgressDialog);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class u implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ signature$SignatureKickData f176561d;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements com.tencent.mobileqq.qroute.route.m<Object> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
                }
            }

            @Override // com.tencent.mobileqq.qroute.route.m
            public void a(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    return;
                }
                try {
                    NotificationActivity.this.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(u.this.f176561d.str_url.get())));
                } catch (Exception unused) {
                }
                NotificationActivity.this.finish();
            }
        }

        u(signature$SignatureKickData signature_signaturekickdata) {
            this.f176561d = signature_signaturekickdata;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this, (Object) signature_signaturekickdata);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.i(NotificationActivity.TAG, 1, "setPositiveButton.onClick: invoked.  isDialogShow: " + NotificationActivity.this.isDialogShow);
            QRoute.createNavigator(NotificationActivity.this, RouterConstants.UI_ROUTER_LOGIN).withString(NotificationActivity.PASSWORD, "").withTransition(NotificationActivity.this, R.anim.f154454a3, R.anim.f154550b4).subscribeSuccess(new a()).request();
            NotificationActivity.sSecControllerInjectInterface.a(NotificationActivity.this, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class v implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                NotificationActivity.this.exitApp();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class w extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f176565d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f176566e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f176567f;

        w(String str, String str2, String str3) {
            this.f176565d = str;
            this.f176566e = str2;
            this.f176567f = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotificationActivity.this, str, str2, str3);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NotificationActivity.this.httpMqqJump(this.f176565d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            if (!TextUtils.isEmpty(this.f176566e)) {
                textPaint.setColor(Color.parseColor(this.f176566e));
            } else {
                textPaint.setColor(NotificationActivity.this.getResources().getColor(R.color.qui_common_text_link));
            }
            if (!TextUtils.isEmpty(this.f176567f)) {
                textPaint.setTextSize(ViewUtils.spToPx(NumberUtil.stringToFloat(this.f176567f)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class x implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f176569d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f176570e;

        x(String str, long j3) {
            this.f176569d = str;
            this.f176570e = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotificationActivity.this, str, Long.valueOf(j3));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NotificationActivity.this.httpMqqJump(this.f176569d);
                NotificationActivity.this.finish();
                NotificationActivity.this.reportCommonDialogBtnClick(this.f176570e, 0);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class y implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f176572d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f176573e;

        y(String str, long j3) {
            this.f176572d = str;
            this.f176573e = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotificationActivity.this, str, Long.valueOf(j3));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NotificationActivity.this.httpMqqJump(this.f176572d);
                NotificationActivity.this.finish();
                NotificationActivity.this.reportCommonDialogBtnClick(this.f176573e, 1);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class z implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NotificationActivity notificationActivity = NotificationActivity.this;
                notificationActivity.payExpiredAccount(notificationActivity.loginRet);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20852);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        try {
            if (com.tencent.mobileqq.qqsec.api.d.f274417a.size() > 0) {
                sSecControllerInjectInterface = com.tencent.mobileqq.qqsec.api.d.f274417a.get(0).newInstance();
                QLog.d(TAG, 1, "NotificationActivity newInstance");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "NotificationActivity static statement: ", e16);
        }
        instance = null;
        mIsOpenNavigationBarImmersive = null;
    }

    public NotificationActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        AnonymousClass1 anonymousClass1 = null;
        this.dialog = null;
        this.title = null;
        this.f176494msg = null;
        this.loginAlias = "";
        this.mReason = Constants.LogoutReason.tips;
        this.isAlreadyAuthorized = false;
        this.frozenDlgHelper = new ak(this, anonymousClass1);
        this.mFrozenData = new aj(anonymousClass1);
        this.lastApplyGrayVersionTime = 0L;
        this.mReceiver = new af();
        this.MSG_CARD_STATUS_OK = 1;
        this.MSG_CARD_STATUS_NO = 2;
        this.MSG_CARD_STATUS_ERROR = 3;
        this.MSG_LH_RECEIVE_START = 4;
        this.MSG_LH_RECEIVE_SUCCESS = 5;
        this.MSG_LH_RECEIVE_FAIL = 6;
        this.myClickListener = new al();
        this.receiveClickListener = new am(1);
        this.renewalClickListener = new am(2);
        this.uiHandler = new MqqHandler(Looper.getMainLooper(), this);
        this.grayCheckObserver = new ac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buyoutLh() {
        boolean z16;
        int g16 = this.lhHelper.g();
        int f16 = this.lhHelper.f();
        if (f16 != -1 && g16 != -1) {
            String str = f16 + "";
            if (g16 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            gotoPay(str, "mvip.p.lh.pay_over", z16, false);
            return;
        }
        QQToast.makeText(this, HardCodeUtil.qqStr(R.string.osp), 0).show();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSetResult(int i3) {
        boolean z16;
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra(KEY_IS_FROM_LH_LOGIN_VERIFY_CODE, false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, String.format(Locale.getDefault(), "checkSetResult, isFromLH: %s, resultCode: %s", Boolean.valueOf(z16), Integer.valueOf(i3)));
        }
        if (z16) {
            Intent intent2 = new Intent();
            intent2.putExtra(KEY_IS_FROM_LH_LOGIN_VERIFY_CODE, true);
            setResult(i3, intent2);
        }
    }

    private Dialog createDialog() {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.show();
        Window window = create.getWindow();
        window.setContentView(R.layout.f168345tg);
        Button button = (Button) window.findViewById(R.id.dialog_button_ok);
        Button button2 = (Button) window.findViewById(R.id.dialog_button_cancel);
        TextView textView = (TextView) window.findViewById(R.id.bkg);
        if (button != null && textView != null) {
            textView.setText(getString(R.string.f5t) + AppSetting.f99551k + getString(R.string.f5s));
            button.setOnClickListener(new t());
            button2.setOnClickListener(new v());
            return create;
        }
        return null;
    }

    private TextView createGrayCheckTextView() {
        TextView textView = new TextView(this);
        textView.setLinksClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTextSize(getResources().getInteger(R.integer.f167156i));
        textView.setTextColor(getResources().getColor(R.color.f156931fl));
        return textView;
    }

    private boolean doInit() {
        String str = "";
        try {
            addObserver(this.grayCheckObserver);
            this.dlgType = getIntent().getIntExtra("type", 0);
            str = getIntent().getAction();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "NotificationActivity action = " + str);
            }
            if (NewIntent.ACTION_ACCOUNT_EXPIRED.equals(str)) {
                this.dlgType = 1;
                stopUpgrade();
            } else if (NewIntent.ACTION_ACCOUNT_TIPS.equals(str)) {
                this.dlgType = 6;
            } else if (NewIntent.ACTION_ACCOUNT_KICKED.equals(str)) {
                sendAccountBroadcast();
                stopUpgrade();
                this.dlgType = 5;
            } else if (NewIntent.ACTION_GRAY.equals(str)) {
                this.dlgType = 2;
            } else if (NewIntent.ACTION_GRAY_APPLY.equals(str)) {
                this.dlgType = 13;
            } else if (NewIntent.ACTION_GRAY_EXPIRED.equals(str)) {
                this.dlgType = 14;
            } else if (NewIntent.ACTION_SUSPEND.equals(str)) {
                this.dlgType = 4;
            } else if (NewIntent.ACTION_CLONE_LOGIN.equals(str)) {
                this.dlgType = 12;
            }
            this.title = getIntent().getStringExtra("title");
            this.f176494msg = getIntent().getStringExtra("msg");
            this.loginAlias = getIntent().getStringExtra("loginalias");
            this.expiredSig = getIntent().getByteArrayExtra("expiredSig");
            this.loginRet = getIntent().getIntExtra("loginret", 0);
            this.mReason = (Constants.LogoutReason) getIntent().getSerializableExtra("reason");
            String stringExtra = getIntent().getStringExtra("securityScan");
            if (stringExtra != null && "security_scan".equals(stringExtra)) {
                this.dlgType = 7;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "doOnCreate exception", e16);
            }
        }
        QLog.d(TAG, 1, "notification activity type:" + this.dlgType);
        if (NewIntent.ACTION_ACCOUNT_KICKED.equals(str)) {
            if (this.mReason == Constants.LogoutReason.secKicked) {
                if (QLog.isColorLevel()) {
                    QLog.d(SEC_TAG, 2, "NotificationActivity:sec kick");
                }
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("data");
                signature$SignatureKickData signature_signaturekickdata = new signature$SignatureKickData();
                try {
                    signature_signaturekickdata.mergeFrom(byteArrayExtra);
                } catch (InvalidProtocolBufferMicroException e17) {
                    e17.printStackTrace();
                }
                if (!signature_signaturekickdata.has()) {
                    return false;
                }
                if (signature_signaturekickdata.str_packname.has() && signature_signaturekickdata.u32_check_result.has() && signature_signaturekickdata.str_right_button.has() && signature_signaturekickdata.str_url.has()) {
                    ThreadManagerV2.post(new Runnable(signature_signaturekickdata.u32_check_result.get(), signature_signaturekickdata.u32_cache_time.get()) { // from class: com.tencent.mobileqq.activity.NotificationActivity.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f176497d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f176498e;

                        {
                            this.f176497d = r6;
                            this.f176498e = r7;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, NotificationActivity.this, Integer.valueOf(r6), Integer.valueOf(r7));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            int i3 = sharedPreferences.getInt("SecResEntry", -1);
                            if (i3 == -1 || (i3 ^ 18) != this.f176497d) {
                                edit.putInt("SecResEntry", this.f176497d ^ 18);
                                edit.putLong("SecStampEntry", System.currentTimeMillis() ^ 18);
                                edit.putInt("SecCacheTime", this.f176498e);
                                edit.commit();
                            }
                        }
                    }, 5, null, false);
                    this.dialog = DialogUtil.createCustomDialog(this, 230).setTitle(this.title).setMessage(this.f176494msg).setPositiveButton(signature_signaturekickdata.str_right_button.get(), new u(signature_signaturekickdata));
                    if (signature_signaturekickdata.str_left_button.has()) {
                        ((QQCustomDialog) this.dialog).setNegativeButton(signature_signaturekickdata.str_left_button.get(), new ad());
                    }
                    showDialog(false);
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(SEC_TAG, 2, "NotificationActivity:package fail");
                }
                return false;
            }
            sSecControllerInjectInterface.c(this, getAppRuntime().getAccount());
        }
        this.lhHelper = new com.tencent.mobileqq.vip.m(this.loginAlias);
        myShowDialog(this.dlgType);
        return true;
    }

    private int getReportLoginType(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 4) {
            return 3;
        }
        return 2;
    }

    private void gotoPay(String str, String str2, boolean z16, boolean z17) {
        if (this.expiredSig == null) {
            String str3 = "https://haoma.qq.com/m/expire.html?num=" + this.loginAlias;
            String stringExtra = getIntent().getStringExtra(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
            if (MobileQQ.sMobileQQ.isLoginByNT() && !TextUtils.isEmpty(stringExtra)) {
                str3 = stringExtra;
            }
            Intent intent = new Intent();
            intent.putExtra("url", str3);
            RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTE_BROWSER);
            checkSetResult(0);
            finish();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unit", HardCodeUtil.qqStr(R.string.osf));
            jSONObject.put("userId", this.loginAlias);
            jSONObject.put("openMonth", str);
            jSONObject.put("offerId", "1450000833");
            jSONObject.put("aid", str2);
            jSONObject.put("ticketValue", SecUtil.toHexString(this.expiredSig));
            jSONObject.put("ticketName", "vask_27");
            jSONObject.put("isCanChange", z17);
            if (z16) {
                jSONObject.put("serviceCode", "CJCLUBT");
                jSONObject.put("serviceName", "QQ\u8d85\u7ea7\u4f1a\u5458");
            } else {
                jSONObject.put("serviceCode", "LTMCLUB");
                jSONObject.put("serviceName", "QQ\u4f1a\u5458");
            }
            sSecControllerInjectInterface.g(this, jSONObject);
        } catch (Exception e16) {
            e16.printStackTrace();
            checkSetResult(0);
            finish();
        }
    }

    private void handleCloneLogin() {
        QLog.i(TAG, 2, "handleCloneLogin");
        QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(this, 230, (String) null, getString(R.string.f200154rc), R.string.f171151ok, R.string.f171151ok, (DialogInterface.OnClickListener) null, new n());
        this.dialog = createCustomDialogUrlWithoutAutoLink;
        createCustomDialogUrlWithoutAutoLink.setOnDismissListener(new o());
        getAppRuntime().setKickIntent(null);
        com.tencent.mobileqq.guid.c.f213821a.e();
        ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C0A1", "0X800C0A1", 0, 0, "", "", "", "");
    }

    private void handleCommonGlobalDialog() {
        boolean z16;
        UniteEntity uniteEntity = (UniteEntity) getIntent().getSerializableExtra("commonDialogTemplate");
        long longExtra = getIntent().getLongExtra("businessId", 0L);
        boolean z17 = true;
        QLog.i(TAG, 1, "handleCommonGlobalDialog busId = " + longExtra);
        if (uniteEntity == null) {
            QLog.w(TAG, 1, "handleCommonGlobalDialog but uniteEntity is null");
            finish();
            return;
        }
        UniteEntity.Note rootNote = uniteEntity.getRootNote();
        if (rootNote.getNoteType() != 6) {
            finish();
            return;
        }
        ArrayList<UniteEntity.Note> subNotes = rootNote.getSubNotes();
        if (subNotes != null && subNotes.size() != 0) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            this.dialog = createCustomDialog;
            Iterator<UniteEntity.Note> it = subNotes.iterator();
            while (true) {
                int i3 = 0;
                if (it.hasNext()) {
                    UniteEntity.Note next = it.next();
                    HashMap<Integer, Object> fields = next.getFields();
                    ArrayList<UniteEntity.Note> subNotes2 = next.getSubNotes();
                    if (next.getNoteType() == 7) {
                        String str = (String) fields.get(2);
                        if (!TextUtils.isEmpty(str)) {
                            createCustomDialog.setTitle(str);
                        }
                        z16 = z17;
                    } else {
                        int i16 = 4;
                        if (next.getNoteType() == 8) {
                            if (subNotes2 != null && !subNotes2.isEmpty()) {
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                                for (UniteEntity.Note note : subNotes2) {
                                    HashMap<Integer, Object> fields2 = note.getFields();
                                    if (fields2 != null) {
                                        if (note.getNoteType() == 2) {
                                            String str2 = (String) fields2.get(2);
                                            if (!TextUtils.isEmpty(str2)) {
                                                SpannableString spannableString = new SpannableString(str2);
                                                spannableString.setSpan(Integer.valueOf(getResources().getColor(R.color.qui_common_text_primary)), 0, spannableString.length(), 33);
                                                spannableStringBuilder.append((CharSequence) spannableString);
                                            }
                                        } else if (note.getNoteType() == 3) {
                                            String str3 = (String) fields2.get(2);
                                            if (!TextUtils.isEmpty(str3)) {
                                                String str4 = (String) fields2.get(Integer.valueOf(i16));
                                                String str5 = (String) fields2.get(3);
                                                String str6 = (String) fields2.get(5);
                                                SpannableString spannableString2 = new SpannableString(str3);
                                                spannableString2.setSpan(new w(str4, str6, str5), 0, str3.length(), 33);
                                                spannableStringBuilder.append((CharSequence) spannableString2);
                                            }
                                        }
                                        i16 = 4;
                                    }
                                }
                                createCustomDialog.setMessageWithoutAutoLink(spannableStringBuilder);
                                z16 = true;
                            }
                        } else {
                            if (next.getNoteType() == 9) {
                                if (subNotes2 != null && !subNotes2.isEmpty()) {
                                    for (UniteEntity.Note note2 : subNotes2) {
                                        if (note2.getNoteType() == 10) {
                                            HashMap<Integer, Object> fields3 = note2.getFields();
                                            String str7 = (String) fields3.get(2);
                                            String str8 = (String) fields3.get(4);
                                            if (i3 == 0) {
                                                createCustomDialog.setNegativeButton(str7, new x(str8, longExtra));
                                            } else if (i3 == 1) {
                                                createCustomDialog.setPositiveButton(str7, new y(str8, longExtra));
                                            }
                                            i3++;
                                        }
                                    }
                                } else {
                                    z17 = true;
                                }
                            }
                            z16 = true;
                        }
                    }
                    z17 = z16;
                } else {
                    this.dialog.setCanceledOnTouchOutside(false);
                    this.dialog.show();
                    reportCommonDialogShow(longExtra);
                    return;
                }
            }
        } else {
            finish();
        }
    }

    private void handleGrayCheck() {
        boolean z16;
        String string;
        String str = this.title;
        if (str != null && str.equals("true")) {
            z16 = handleYingYongBaoGrayCheck();
        } else {
            z16 = false;
        }
        if (!z16) {
            try {
                String string2 = getString(R.string.f171186d02);
                if (!TextUtils.isEmpty(this.f176494msg)) {
                    string = this.f176494msg;
                } else {
                    string = getString(R.string.bls);
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, string2, Html.fromHtml(string), getString(R.string.f170901b10), getString(R.string.f227776ry), new q(), new r());
                this.dialog = createCustomDialog;
                createCustomDialog.setCancelable(false);
            } catch (Exception e16) {
                QLog.d("GrayCheck.tag", 1, "createCustomDialog error, ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGrayCheckSignUp() {
        AppRuntime appRuntime = this.mRuntime;
        if (!(appRuntime instanceof AppInterface)) {
            return;
        }
        ((GrayCheckHandler) ((AppInterface) appRuntime).getBusinessHandler(GrayCheckHandler.class.getName())).G2();
    }

    private void handleLhExpire() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.NotificationActivity.35
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int e16 = NotificationActivity.this.lhHelper.e();
                QLog.e("LhHelper", 1, "handleLhExpire userStatus = " + e16);
                if (e16 == 1) {
                    NotificationActivity.this.uiHandler.sendEmptyMessage(1);
                } else if (e16 == 2) {
                    NotificationActivity.this.uiHandler.sendEmptyMessage(2);
                } else if (e16 == 3) {
                    NotificationActivity.this.uiHandler.sendEmptyMessage(3);
                }
            }
        }, 16, null, true);
    }

    private boolean handleYingYongBaoGrayCheck() {
        TextView createGrayCheckTextView = createGrayCheckTextView();
        try {
            String packageName = getPackageName();
            createGrayCheckTextView.setText(this.f176494msg);
            this.dialog = DialogUtil.createCustomDialog(this, 230).setMessage(this.f176494msg).addView(createGrayCheckTextView).setPositiveButton(R.string.fvu, (DialogInterface.OnClickListener) new p(packageName), false);
            return true;
        } catch (Exception e16) {
            QLog.e("GrayCheck.tag", 1, "create YingYongBao gray check dialog error, ", e16);
            return false;
        }
    }

    private void hideProgressDialog() {
        QQProgressDialog qQProgressDialog = this.mLoadingDialog;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mLoadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void httpMqqJump(String str) {
        boolean z16;
        com.tencent.mobileqq.utils.ax c16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean startsWith = str.toLowerCase().startsWith("mqq://");
        if (z16) {
            Intent intent = new Intent();
            intent.putExtra("url", str);
            RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTE_BROWSER);
        } else if (startsWith && (c16 = com.tencent.mobileqq.utils.bi.c((BaseQQAppInterface) getAppRuntime(), this, str)) != null) {
            c16.z();
            c16.b();
        }
    }

    private boolean isOpenNavigationBarImmersive() {
        if (mIsOpenNavigationBarImmersive == null) {
            mIsOpenNavigationBarImmersive = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_activity_open_navigation_bar_immersive", true));
        }
        return mIsOpenNavigationBarImmersive.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpLoginAndFinish() {
        QRoute.createNavigator(this, RouterConstants.UI_ROUTER_LOGIN).withString(PASSWORD, "").withTransition(this, R.anim.f154454a3, R.anim.f154550b4).subscribeSuccess(new s()).request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kickedLogin(boolean z16) {
        SimpleAccount simpleAccount;
        String account;
        List<SimpleAccount> allAccounts = getAppRuntime().getApplication().getAllAccounts();
        if (allAccounts != null && allAccounts.size() > 0 && (account = getAppRuntime().getAccount()) != null && account.length() > 0) {
            Iterator<SimpleAccount> it = allAccounts.iterator();
            while (it.hasNext()) {
                simpleAccount = it.next();
                if (account.equals(simpleAccount.getUin())) {
                    break;
                }
            }
        }
        simpleAccount = null;
        getAppRuntime().setKickIntent(null);
        if (simpleAccount != null) {
            if (!TextUtils.isEmpty(simpleAccount.getUin())) {
                AutoLoginUtil.setAutoLogin(simpleAccount.getUin(), true);
            }
            if (z16) {
                new Handler(ThreadManagerV2.getSubThreadLooper()).postDelayed(new Runnable(simpleAccount) { // from class: com.tencent.mobileqq.activity.NotificationActivity.31
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ SimpleAccount f176499d;

                    {
                        this.f176499d = simpleAccount;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this, (Object) simpleAccount);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            NotificationActivity.this.getAppRuntime().login(this.f176499d);
                        }
                    }
                }, 500L);
            } else {
                getAppRuntime().login(simpleAccount);
            }
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(simpleAccount.getUin(), (byte) 0);
            finish();
            return;
        }
        if (!com.tencent.mobileqq.phonelogin.a.a().b(getAppRuntime(), getAppRuntime().getCurrentAccountUin())) {
            getAppRuntime().updateSubAccountLogin(getAppRuntime().getCurrentAccountUin(), false);
            getAppRuntime().getApplication().refreAccountList();
        }
        ArrayList<String> h16 = sSecControllerInjectInterface.h((BaseQQAppInterface) getAppRuntime());
        if (h16 != null && h16.size() > 0) {
            Iterator<String> it5 = h16.iterator();
            while (it5.hasNext()) {
                String next = it5.next();
                if (!com.tencent.mobileqq.phonelogin.a.a().b(getAppRuntime(), next)) {
                    getAppRuntime().updateSubAccountLogin(next, false);
                    getAppRuntime().getApplication().refreAccountList();
                }
            }
        }
        jumpLoginAndFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logoutAndExitApp() {
        QLog.d("GrayCheck.tag", 1, "logout and exit app");
        getAppRuntime().logout(true);
        if (!TextUtils.isEmpty(getAppRuntime().getCurrentAccountUin())) {
            AutoLoginUtil.setAutoLogin(getAppRuntime().getCurrentAccountUin(), false);
        }
        ArrayList<String> h16 = sSecControllerInjectInterface.h((BaseQQAppInterface) getAppRuntime());
        if (h16 != null && h16.size() > 0) {
            Iterator<String> it = h16.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!com.tencent.mobileqq.phonelogin.a.a().b(getAppRuntime(), next)) {
                    getAppRuntime().updateSubAccountLogin(next, false);
                    getAppRuntime().getApplication().refreAccountList();
                }
            }
        }
        exitApp();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void myShowDialog(int i3) {
        int i16;
        Intent kickIntent;
        QLog.i(TAG, 1, "myShowDialog: invoked.  id: " + i3);
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.dialog.dismiss();
            } catch (Throwable th5) {
                QLog.i(TAG, 1, "myShowDialog: invoked.  throwable: " + th5);
            }
        }
        this.dialog = null;
        if (i3 != 20) {
            switch (i3) {
                case 1:
                    ReportController.r(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
                    this.title = getString(R.string.f173179hs4);
                    this.f176494msg = getString(R.string.f173178hs3);
                    this.dialog = DialogUtil.createCustomDialog(this, 230).setTitle(this.title).setMessage(this.f176494msg).setPositiveButton(android.R.string.ok, new ag());
                    break;
                case 2:
                    String str = this.title;
                    if (!((str == null || !str.equals("true")) ? false : handleYingYongBaoGrayCheck())) {
                        TextView createGrayCheckTextView = createGrayCheckTextView();
                        if (!TextUtils.isEmpty(this.f176494msg)) {
                            createGrayCheckTextView.setText(Html.fromHtml(this.f176494msg));
                        } else {
                            createGrayCheckTextView.setText(Html.fromHtml(getString(R.string.bls)));
                        }
                        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this, 230).setMessage(this.f176494msg).addView(createGrayCheckTextView).setPositiveButton(R.string.f170901b10, new ah());
                        this.dialog = positiveButton;
                        positiveButton.setCancelable(false);
                        break;
                    }
                    break;
                case 3:
                    try {
                        this.dialog = createDialog();
                        break;
                    } catch (Exception unused) {
                        exitApp();
                        break;
                    }
                case 4:
                    this.dialog = DialogUtil.createCustomDialog(this, 230).setTitle(this.title).setMessage(this.f176494msg).setPositiveButton(android.R.string.ok, new c());
                    break;
                case 5:
                    if (TextUtils.isEmpty(this.f176494msg) && TextUtils.isEmpty(this.title) && (kickIntent = getAppRuntime().getKickIntent()) != null) {
                        this.title = kickIntent.getStringExtra("title");
                        this.f176494msg = kickIntent.getStringExtra("msg");
                        this.mReason = (Constants.LogoutReason) kickIntent.getSerializableExtra("reason");
                    }
                    sSecControllerInjectInterface.a(this, true, true);
                    Constants.LogoutReason logoutReason = this.mReason;
                    Constants.LogoutReason logoutReason2 = Constants.LogoutReason.kicked;
                    int i17 = (logoutReason == logoutReason2 || getIntent().getBooleanExtra("is_from_login_page", false)) ? R.string.f171151ok : R.string.ckv;
                    if (com.tencent.mobileqq.app.security.a.d().k(this.f176494msg)) {
                        ReportController.r(null, "dc00898", "", "", "0X800B427", "0X800B427", 0, 0, "", "", "", "");
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    if (com.tencent.mobileqq.app.security.a.d().l(this.f176494msg)) {
                        ReportController.r(null, "dc00898", "", "", "0X800B5E4", "0X800B5E4", 0, 0, "", "", "", "");
                        i16 = 4;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "DIALOG_ANOTHER_TERMINAL_LOGIN msg: " + this.f176494msg);
                    }
                    this.dialog = DialogUtil.createCustomDialogUrlWithoutAutoLink(this, 230, this.title, com.tencent.mobileqq.app.security.a.d().i(this.f176494msg, this, i16), i17, R.string.f171151ok, (DialogInterface.OnClickListener) null, new ai());
                    if (this.mReason != logoutReason2) {
                        if (getIntent() != null && getIntent().getBooleanExtra("isSameDevice", false) && !isInMultiWindow()) {
                            this.dialog = null;
                            kickedLogin(true);
                        } else {
                            if (!getIntent().getBooleanExtra("is_from_login_page", false)) {
                                ((QQCustomDialog) this.dialog).setPositiveButton(R.string.bbw, new a());
                            }
                            Intent intent = new Intent(AppConstants.TIM_KICKED_LOGIN_OTHER_DEVICE);
                            intent.putExtra("kickedUin", getAppRuntime().getAccount());
                            intent.putExtra("msg", this.f176494msg);
                            intent.setPackage(AppConstants.TIM_PACKAGE_NAME);
                            sendBroadcast(intent);
                        }
                    }
                    getAppRuntime().setKickIntent(null);
                    break;
                case 6:
                    this.dialog = DialogUtil.createCustomDialog(this, 230).setTitle(this.title).setMessage(this.f176494msg).setPositiveButton(android.R.string.ok, new b());
                    break;
                case 7:
                    this.dialog = DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.c6e)).setMessage(getString(R.string.hc9)).setPositiveButton(getString(R.string.hca), new e()).setNegativeButton(getString(R.string.hc8), new d());
                    break;
                case 8:
                    int i18 = this.loginRet;
                    if (i18 != 40) {
                        if (i18 != 41 && i18 != 116) {
                            this.dialog = DialogUtil.createCustomDialogUrl(this, 230).setMessageWithUrl(this.f176494msg).setTitle(getString(R.string.frc)).setPositiveButton(android.R.string.ok, new g());
                            break;
                        } else {
                            Long l3 = com.tencent.mobileqq.vip.m.f313034d.get(this.loginAlias);
                            if (l3 != null && System.currentTimeMillis() - l3.longValue() < 30000) {
                                this.dialog = DialogUtil.createCustomDialog(this, 230).setTitle(HardCodeUtil.qqStr(R.string.ose)).setMessage(HardCodeUtil.qqStr(R.string.osc)).setNegativeButton(HardCodeUtil.qqStr(R.string.osl), new f());
                                break;
                            } else {
                                handleLhExpire();
                                break;
                            }
                        }
                    } else {
                        ReportController.r(getAppRuntime(), "dc00898", "", this.loginAlias, "0X800AA2F", "0X800AA2F", 0, 0, "", "", "", this.f176494msg);
                        Intent intent2 = getIntent();
                        if (intent2 != null) {
                            this.frozenDlgHelper.f(intent2);
                            Dialog e16 = this.frozenDlgHelper.e(this.mFrozenData);
                            this.dialog = e16;
                            e16.setCancelable(true);
                            break;
                        }
                    }
                    break;
                case 9:
                    Bundle extras = getIntent().getExtras();
                    this.dialog = DialogUtil.createCustomDialog(this, 230).setTitle(extras.getString(DLG_TITLE)).setMessage(extras.getString(DLG_CONTENT)).setPositiveButton(extras.getString(DLG_RBUTTON), new i(extras.getString(DLG_URL))).setNegativeButton(extras.getString(DLG_LBUTTON), new h());
                    break;
                case 10:
                    String string = getResources().getString(R.string.c85);
                    String string2 = getResources().getString(R.string.f171107c84);
                    String string3 = getResources().getString(R.string.f171104c81);
                    String string4 = getResources().getString(R.string.f171106c83);
                    String string5 = getResources().getString(R.string.f171105c82);
                    CheckBox checkBox = new CheckBox(this);
                    checkBox.setText(string5);
                    checkBox.setTextSize(getResources().getInteger(R.integer.f167156i));
                    checkBox.setTextColor(getResources().getColor(R.color.f156931fl));
                    SharedPreferences sharedPreferences = getAppRuntime().getApp().getSharedPreferences(getAppRuntime().getAccount(), 0);
                    boolean z16 = sharedPreferences.getBoolean("MemoryAlertAutoClear", false);
                    checkBox.setChecked(z16);
                    this.dialog = DialogUtil.createCustomDialog(this, 230).setTitle(string).setMessage(string2).setView(checkBox).setPositiveButton(string4, new k(checkBox, z16, sharedPreferences)).setNegativeButton(string3, new j(checkBox, z16, sharedPreferences));
                    break;
                case 11:
                    try {
                        Bundle extras2 = getIntent().getExtras();
                        String string6 = extras2.getString(DLG_TITLE, "");
                        String string7 = extras2.getString(DLG_CONTENT, "");
                        String string8 = extras2.getString(DLG_LBUTTON, "");
                        String string9 = extras2.getString(DLG_RBUTTON, "");
                        String string10 = extras2.getString(DLG_URL, "");
                        int i19 = extras2.getInt("dlg_lbtnid", 0);
                        int i26 = extras2.getInt("dlg_rbtnid", 0);
                        String format = String.format("%d", Integer.valueOf(extras2.getInt("dlg_seccmd", 0)));
                        QQCustomDialog message = DialogUtil.createCustomDialog(this, 230).setTitle(string6).setMessage(string7);
                        this.dialog = message;
                        if (message != null) {
                            if (!TextUtils.isEmpty(string9)) {
                                ((QQCustomDialog) this.dialog).setPositiveButton(string9, new l(string10, i26, format));
                            }
                            if (!TextUtils.isEmpty(string8)) {
                                ((QQCustomDialog) this.dialog).setNegativeButton(string8, new m(i19, format));
                            }
                            ReportController.o(null, "P_CliOper", "Safe_AlertReport", "", "0X8007534", "0X8007534", 0, 0, format, "", "", "");
                            break;
                        }
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        break;
                    }
                    break;
                case 12:
                    handleCloneLogin();
                    break;
                case 13:
                    handleGrayCheck();
                    break;
                case 14:
                    Message obtainMessage = this.uiHandler.obtainMessage(10);
                    Bundle bundle = new Bundle();
                    bundle.putString("errorMsg", this.f176494msg);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    this.dialog = createDialog();
                    break;
            }
        } else {
            handleCommonGlobalDialog();
        }
        sendBroadcast(new Intent("before_account_change"));
        showDialog(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void payExpiredAccount(int i3) {
        boolean z16;
        if (i3 != 41 && i3 != 116) {
            return;
        }
        if (i3 == 116) {
            z16 = true;
        } else {
            z16 = false;
        }
        gotoPay("3", "mvip.gongneng.android.haoma_03", z16, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveLhCard() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.NotificationActivity.39
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                boolean i3 = NotificationActivity.this.lhHelper.i();
                QLog.e("LhHelper", 1, "receiveLhCard result = " + i3);
                if (i3) {
                    if (NotificationActivity.this.lhHelper.k()) {
                        NotificationActivity.this.uiHandler.sendEmptyMessage(5);
                        return;
                    } else {
                        NotificationActivity.this.uiHandler.sendEmptyMessage(6);
                        return;
                    }
                }
                NotificationActivity.this.uiHandler.sendEmptyMessage(6);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCommonDialogBtnClick(long j3, int i3) {
        String str;
        if (j3 == 10171 || j3 == 10169) {
            int intExtra = getIntent().getIntExtra(TangramHippyConstants.LOGIN_TYPE, 0);
            if (i3 == 0) {
                str = "0X800C220";
            } else {
                str = "0X800C221";
            }
            String str2 = str;
            ReportController.r(getAppRuntime(), "dc00898", "", "", str2, str2, getReportLoginType(intExtra), 0, "", "", "", "");
        }
    }

    private void reportCommonDialogShow(long j3) {
        if (j3 == 10171 || j3 == 10169) {
            ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C21F", "0X800C21F", getReportLoginType(getIntent().getIntExtra(TangramHippyConstants.LOGIN_TYPE, 0)), 0, "", "", "", "");
        }
    }

    private void sendAccountBroadcast() {
        if (QLog.isColorLevel()) {
            QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
        }
        Intent intent = new Intent();
        intent.setAction(NewIntent.ACTION_ACCOUNT_KICKED);
        getAppRuntime().getApp().sendBroadcast(intent);
    }

    private void showDialog(boolean z16) {
        Dialog dialog;
        QLog.i(TAG, 1, "showDialog: invoked.  inResume: " + z16 + " isDialogShow: " + this.isDialogShow);
        if (!this.isDialogShow) {
            if ((isResume() || Build.VERSION.SDK_INT < 28) && (dialog = this.dialog) != null && !dialog.isShowing() && !isFinishing()) {
                if (this.dlgType == 8 && this.loginRet == 40) {
                    this.dialog.setCancelable(true);
                    this.dialog.setOnCancelListener(new ae());
                } else {
                    this.dialog.setCancelable(false);
                }
                try {
                    this.dialog.show();
                } catch (Throwable th5) {
                    QLog.i(TAG, 1, "showDialog: invoked.  t: " + th5);
                }
                this.isDialogShow = true;
            }
        }
    }

    private void showProgressDialog(int i3) {
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = new QQProgressDialog(this, getTitleBarHeight());
        }
        if (!this.mLoadingDialog.isShowing()) {
            this.mLoadingDialog.setMessage(HardCodeUtil.qqStr(i3));
            this.mLoadingDialog.show();
        }
    }

    private void stopUpgrade() {
        sSecControllerInjectInterface.i((BaseQQAppInterface) getAppRuntime());
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i3 == 1) {
            if (Utils.y(intent) == 0) {
                i17 = -1;
            }
            checkSetResult(i17);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.notification_activity_transparent);
        if (!doInit()) {
            return false;
        }
        registerReceiver(this.mReceiver, new IntentFilter("com.tencent.mobileqq.closeNotification"));
        if (isOpenNavigationBarImmersive()) {
            com.tencent.mobileqq.qui.b.f276860a.l(getWindow());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "doOnDestroy: invoked.  isDialogShow: " + this.isDialogShow);
        try {
            unregisterReceiver(this.mReceiver);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.dialog.dismiss();
            } catch (Throwable th6) {
                QLog.i(TAG, 1, "doOnDestroy: invoked.  t: " + th6);
            }
        }
        removeObserver(this.grayCheckObserver);
        this.dialog = null;
        super.doOnDestroy();
        if (instance == this) {
            instance = null;
        }
        com.tencent.util.i.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (this.dlgType != 5 && NewIntent.ACTION_ACCOUNT_KICKED.equals(intent.getAction())) {
            Dialog dialog = this.dialog;
            if (dialog != null && dialog.isShowing()) {
                this.dialog.dismiss();
            }
            this.isDialogShow = false;
            setIntent(intent);
            doInit();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.doOnResume();
        showDialog(true);
        if (this.isAlreadyAuthorized && (dialog = this.dialog) != null && dialog.isShowing()) {
            ((QQCustomDialog) this.dialog).setPositiveButton(R.string.fvt, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.NotificationActivity.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NotificationActivity.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.NotificationActivity.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    NotificationActivity.this.exitApp();
                                }
                            }
                        }, 1000L);
                    }
                }
            });
        }
        if (this.mFrozenData.f176515f && this.dlgType == 5) {
            this.mFrozenData.f176515f = false;
            kickToLoginActivity(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnUserLeaveHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnUserLeaveHint();
        if (this.dlgType == 3) {
            exitApp();
        }
    }

    public void enableJumpLoginFromFund() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.mFrozenData.f176515f = true;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void exitApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        sSecControllerInjectInterface.a(this, false, false);
        finish();
        if (getAppRuntime() != null) {
            getAppRuntime().exit(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.dialog = null;
        super.finish();
        if (instance == this) {
            instance = null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 1:
                QQCustomDialog createCustomCloseDialog = DialogUtil.createCustomCloseDialog(this, getResources().getString(R.string.c1t), getResources().getString(R.string.c1j), getResources().getString(R.string.c1f), this.receiveClickListener, HardCodeUtil.qqStr(R.string.oso), this.receiveClickListener, this.myClickListener);
                this.dialog = createCustomCloseDialog;
                createCustomCloseDialog.show();
                break;
            case 2:
                QQCustomDialog createCustomCloseDialog2 = DialogUtil.createCustomCloseDialog(this, getResources().getString(R.string.c1t), getResources().getString(R.string.c1i), getResources().getString(R.string.c1g), this.renewalClickListener, getResources().getString(R.string.c1e), this.renewalClickListener, this.myClickListener);
                this.dialog = createCustomCloseDialog2;
                createCustomCloseDialog2.show();
                break;
            case 3:
                if (this.loginRet == 41) {
                    i3 = R.string.f171188d04;
                } else {
                    i3 = R.string.f171187d03;
                }
                String string = getString(i3);
                QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this, 230).setMessage(string).setTitle(getString(R.string.f171186d02)).setNegativeButton(R.string.f171185d01, new aa()).setPositiveButton(R.string.czy, new z());
                this.dialog = positiveButton;
                positiveButton.setCancelable(false);
                this.dialog.show();
                break;
            case 4:
                showProgressDialog(R.string.osg);
                break;
            case 5:
                hideProgressDialog();
                QQToast.makeText(this, 2, HardCodeUtil.qqStr(R.string.osj), 0).show(getTitleBarHeight());
                com.tencent.mobileqq.vip.m.f313034d.put(this.loginAlias, Long.valueOf(System.currentTimeMillis()));
                finish();
                break;
            case 6:
                hideProgressDialog();
                QQToast.makeText(this, 1, HardCodeUtil.qqStr(R.string.osi), 0).show(getTitleBarHeight());
                finish();
                break;
            case 7:
                showProgressDialog(R.string.zt9);
                break;
            case 8:
                hideProgressDialog();
                QQToast.makeText(this, 1, HardCodeUtil.qqStr(R.string.f227796s0), 0).show(getTitleBarHeight());
                break;
            case 9:
                hideProgressDialog();
                QQToast.makeText(this, 2, HardCodeUtil.qqStr(R.string.f227806s1), 0).show(getTitleBarHeight());
                finish();
                break;
            case 10:
                hideProgressDialog();
                String string2 = message.getData().getString("errorMsg");
                String string3 = getString(R.string.f171186d02);
                Dialog dialog = this.dialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.dialog = DialogUtil.createCustomDialog(this, 230).setMessage(string2).setTitle(string3).setNegativeButton(R.string.f170901b10, new ab());
                if (!isFinishing() && !isDestroyed()) {
                    try {
                        this.dialog.setCancelable(false);
                        this.dialog.show();
                        break;
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "handleMessage dialog.show() error", e16);
                        break;
                    }
                }
                break;
            case 11:
                hideProgressDialog();
                QQToast.makeText(this, 1, HardCodeUtil.qqStr(R.string.f227816s2), 0).show(getTitleBarHeight());
                break;
        }
        return true;
    }

    public void kickToLoginActivity(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        QLog.i(TAG, 2, "kickToLoginActivity");
        if (com.tencent.mobileqq.app.security.a.d().k(this.f176494msg)) {
            ReportController.r(null, "dc00898", "", "", "0X800B42A", "0X800B42A", 0, 0, "", "", "", "");
        }
        if (com.tencent.mobileqq.app.security.a.d().l(this.f176494msg)) {
            ReportController.r(null, "dc00898", "", "", "0X800B5E6", "0X800B5E6", 0, 0, "", "", "", "");
        }
        if (!com.tencent.mobileqq.phonelogin.a.a().b(getAppRuntime(), getAppRuntime().getCurrentAccountUin())) {
            getAppRuntime().updateSubAccountLogin(getAppRuntime().getCurrentAccountUin(), false);
            getAppRuntime().getApplication().refreAccountList();
        }
        ArrayList<String> h16 = sSecControllerInjectInterface.h((BaseQQAppInterface) getAppRuntime());
        if (h16 != null && h16.size() > 0) {
            Iterator<String> it = h16.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!com.tencent.mobileqq.phonelogin.a.a().b(getAppRuntime(), next)) {
                    getAppRuntime().updateSubAccountLogin(next, false);
                    getAppRuntime().getApplication().refreAccountList();
                }
            }
        }
        if (z16) {
            QLog.i(TAG, 1, "logout all account");
            getAppRuntime().logout(true);
            getAppRuntime().setKickIntent(null);
            List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
            if (loginedAccountList != null) {
                Iterator<SimpleAccount> it5 = loginedAccountList.iterator();
                while (it5.hasNext()) {
                    MsfSdkUtils.updateSimpleAccount(it5.next().getUin(), false);
                }
            }
            MobileQQ.sMobileQQ.refreAccountList();
            if (getIntent().getBooleanExtra("is_from_login_page", false)) {
                finish();
                overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
                return;
            }
        }
        jumpLoginAndFinish();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        NotificationActivity notificationActivity = instance;
        if (notificationActivity != null) {
            try {
                notificationActivity.finish();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onCreate finish instance error:", e16);
            }
        }
        instance = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) logoutReason);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class aj {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f176510a;

        /* renamed from: b, reason: collision with root package name */
        public int f176511b;

        /* renamed from: c, reason: collision with root package name */
        public int f176512c;

        /* renamed from: d, reason: collision with root package name */
        public String f176513d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f176514e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f176515f;

        /* renamed from: g, reason: collision with root package name */
        public String f176516g;

        /* renamed from: h, reason: collision with root package name */
        public int f176517h;

        /* renamed from: i, reason: collision with root package name */
        public int f176518i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f176519j;

        aj() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f176510a = "";
            this.f176511b = 0;
            this.f176513d = "";
            this.f176514e = false;
            this.f176515f = false;
            this.f176516g = "";
            this.f176517h = -1;
            this.f176518i = 2098;
            this.f176519j = false;
        }

        /* synthetic */ aj(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }
}
