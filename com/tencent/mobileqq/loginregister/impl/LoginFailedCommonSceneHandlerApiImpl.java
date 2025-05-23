package com.tencent.mobileqq.loginregister.impl;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.loginregister.h;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.LoginUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.Button;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.login.GatewayVerify$Button;
import tencent.im.login.GatewayVerify$RspBody;
import tencent.im.login.GatewayVerify$RspTipsInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginFailedCommonSceneHandlerApiImpl implements ILoginFailedCommonSceneHandlerApi {
    static IPatchRedirector $redirector_ = null;
    private static final String EVENT_ID_FINISH_VERIFY = "0X800C0BF";
    private static final String EVENT_ID_LOGIN_SUCCESS = "0X800C0B8";
    private static final String JUMP_URL_PHONE_LOGIN = "native://phone_login";
    private static final String JUMP_URL_SMS_LOGIN = "native://sms_login";
    public static final String KEY_MINIAPP_PREFIX = "mqqapi://miniapp";
    private static final String TAG = "LoginFailedCommonSceneHandler";
    private static final ConcurrentHashMap<String, h> reportDataMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final String f242850a;

        /* renamed from: b, reason: collision with root package name */
        final DialogInterface.OnClickListener f242851b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.loginregister.impl.LoginFailedCommonSceneHandlerApiImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public class DialogInterfaceOnClickListenerC7994a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f242852d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ h f242853e;

            DialogInterfaceOnClickListenerC7994a(QBaseActivity qBaseActivity, h hVar) {
                this.f242852d = qBaseActivity;
                this.f242853e = hVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) hVar);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    LoginFailedCommonSceneHandlerApiImpl.doReport(this.f242852d.getAppRuntime(), "0X800C0B6", this.f242853e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f242854d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f242855e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ h f242856f;

            b(String str, QBaseActivity qBaseActivity, h hVar) {
                this.f242854d = str;
                this.f242855e = qBaseActivity;
                this.f242856f = hVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, qBaseActivity, hVar);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                if (LoginFailedCommonSceneHandlerApiImpl.JUMP_URL_PHONE_LOGIN.equals(this.f242854d)) {
                    a.k();
                    return;
                }
                if (LoginFailedCommonSceneHandlerApiImpl.JUMP_URL_SMS_LOGIN.equals(this.f242854d)) {
                    a.l();
                    return;
                }
                if (a.h(this.f242854d)) {
                    a.j(this.f242855e, this.f242854d, this.f242856f.f242844b);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("url", this.f242854d);
                int a16 = a.a();
                if (a16 > 0) {
                    intent.putExtra("loginFragmentType", a16);
                }
                RouteUtils.startActivity(this.f242855e, intent, RouterConstants.UI_ROUTE_BROWSER);
                LoginFailedCommonSceneHandlerApiImpl.doReport(this.f242855e.getAppRuntime(), "0X800C0B7", this.f242856f);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public class c implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f242857d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ h f242858e;

            c(QBaseActivity qBaseActivity, h hVar) {
                this.f242857d = qBaseActivity;
                this.f242858e = hVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) hVar);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    LoginFailedCommonSceneHandlerApiImpl.doReport(this.f242857d.getAppRuntime(), "0X800C0B6", this.f242858e);
                    dialogInterface.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public class d implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f242859d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f242860e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ h f242861f;

            d(String str, QBaseActivity qBaseActivity, h hVar) {
                this.f242859d = str;
                this.f242860e = qBaseActivity;
                this.f242861f = hVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, qBaseActivity, hVar);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                if (LoginFailedCommonSceneHandlerApiImpl.JUMP_URL_PHONE_LOGIN.equals(this.f242859d)) {
                    a.k();
                    return;
                }
                if (LoginFailedCommonSceneHandlerApiImpl.JUMP_URL_SMS_LOGIN.equals(this.f242859d)) {
                    a.l();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("url", this.f242859d);
                int a16 = a.a();
                if (a16 > 0) {
                    intent.putExtra("loginFragmentType", a16);
                }
                RouteUtils.startActivity(this.f242860e, intent, RouterConstants.UI_ROUTE_BROWSER);
                LoginFailedCommonSceneHandlerApiImpl.doReport(this.f242860e.getAppRuntime(), "0X800C0B7", this.f242861f);
            }
        }

        a(String str, DialogInterface.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) onClickListener);
            } else {
                this.f242850a = str;
                this.f242851b = onClickListener;
            }
        }

        static /* bridge */ /* synthetic */ int a() {
            return g();
        }

        private static boolean f() {
            int g16 = g();
            if (g16 != 4 && g16 != 5) {
                return false;
            }
            return true;
        }

        private static int g() {
            Intent intent;
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null || qBaseActivity.isFinishing() || qBaseActivity.isDestroyed()) {
                return 0;
            }
            if ((!(qBaseActivity instanceof LoginActivity) && !(qBaseActivity instanceof QPublicFragmentActivity)) || (intent = qBaseActivity.getIntent()) == null) {
                return 0;
            }
            return intent.getIntExtra("loginFragmentType", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean h(String str) {
            return str.startsWith(LoginFailedCommonSceneHandlerApiImpl.KEY_MINIAPP_PREFIX);
        }

        private static boolean i(String str) {
            if (!LoginFailedCommonSceneHandlerApiImpl.JUMP_URL_PHONE_LOGIN.equals(str) && !LoginFailedCommonSceneHandlerApiImpl.JUMP_URL_SMS_LOGIN.equals(str)) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(QBaseActivity qBaseActivity, String str, String str2) {
            Map<String, String> argumentsFromURL = MiniAppSecurityUtil.getArgumentsFromURL(str);
            if (argumentsFromURL == null) {
                QLog.e(LoginFailedCommonSceneHandlerApiImpl.TAG, 1, "paramMap is null");
                return;
            }
            String str3 = argumentsFromURL.get("forbid_token");
            MiniAppSecurityUtil.updateLoginMiniAppUin(qBaseActivity, str2);
            if (str3 != null) {
                MiniAppSecurityUtil.updateLoginMiniAppForbidToken(qBaseActivity, str2, str3);
            }
            if (MiniAppSecurityUtil.checkMiniAppForLogin(str)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(qBaseActivity, str, 2098, null);
            } else {
                QLog.e(LoginFailedCommonSceneHandlerApiImpl.TAG, 1, "jumpMiniApp params error");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k() {
            Intent intent = new Intent("com.tencent.mobileqq.login.autoPhoneLogin");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            BaseApplication.getContext().sendBroadcast(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void l() {
            Intent intent = new Intent("com.tencent.mobileqq.login.autoSmsLogin");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            BaseApplication.getContext().sendBroadcast(intent);
        }

        static a m(QBaseActivity qBaseActivity, GatewayVerify$Button gatewayVerify$Button, h hVar) {
            String str;
            int i3;
            String str2;
            if (gatewayVerify$Button == null) {
                return null;
            }
            if (gatewayVerify$Button.str_text.has()) {
                str = gatewayVerify$Button.str_text.get();
            } else {
                str = null;
            }
            if (str == null || str.isEmpty()) {
                return null;
            }
            if (gatewayVerify$Button.uint32_action.has()) {
                i3 = gatewayVerify$Button.uint32_action.get();
            } else {
                i3 = 0;
            }
            if (gatewayVerify$Button.str_jump_url.has()) {
                str2 = gatewayVerify$Button.str_jump_url.get();
            } else {
                str2 = null;
            }
            if (i3 == 2 && i(str2) && !f()) {
                QLog.i(LoginFailedCommonSceneHandlerApiImpl.TAG, 1, "not support jump url: " + str2);
                return null;
            }
            if (i3 != 1) {
                if (i3 != 2 || str2 == null || str2.isEmpty()) {
                    return null;
                }
                return new a(str, new b(str2, qBaseActivity, hVar));
            }
            return new a(str, new DialogInterfaceOnClickListenerC7994a(qBaseActivity, hVar));
        }

        static a n(QBaseActivity qBaseActivity, Button button, h hVar) {
            if (button == null) {
                return null;
            }
            String str = button.wording;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = button.url;
            if (i(str2) && !f()) {
                QLog.e(LoginFailedCommonSceneHandlerApiImpl.TAG, 1, "parseNtData don't support url: " + str2);
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                return new a(str, new c(qBaseActivity, hVar));
            }
            return new a(str, new d(str2, qBaseActivity, hVar));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            reportDataMap = new ConcurrentHashMap<>();
        }
    }

    public LoginFailedCommonSceneHandlerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static void doReport(AppRuntime appRuntime, String str, h hVar) {
        if (appRuntime == null) {
            return;
        }
        ReportController.r(appRuntime, "dc00898", "", hVar.f242844b, str, str, hVar.f242845c, 0, String.valueOf(hVar.f242846d), "", hVar.a(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildDialogFromNTData$0(List list, DialogInterface dialogInterface, int i3) {
        if (((a) list.get(2)).f242851b != null) {
            ((a) list.get(2)).f242851b.onClick(dialogInterface, i3);
        }
        try {
            dialogInterface.dismiss();
        } catch (Exception unused) {
            QLog.e(TAG, 1, "dismiss dialog error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildDialogFromTlvData$2(List list, DialogInterface dialogInterface, int i3) {
        if (((a) list.get(2)).f242851b != null) {
            ((a) list.get(2)).f242851b.onClick(dialogInterface, i3);
        }
        try {
            dialogInterface.dismiss();
        } catch (Exception unused) {
            QLog.e(TAG, 1, "dismiss dialog error");
        }
    }

    static GatewayVerify$RspBody parseRspBody(byte[] bArr) {
        if (bArr == null) {
            QLog.d(TAG, 1, "parseRspBody tlvData is null");
            return null;
        }
        try {
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(bArr);
            return gatewayVerify$RspBody;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseRspBody error: ", e16);
            return null;
        }
    }

    Dialog buildDialogFromNTData(QBaseActivity qBaseActivity, LoginResult loginResult, h hVar) {
        QQCustomDialog createCustomDialog;
        if (qBaseActivity != null && hVar != null) {
            try {
                String str = loginResult.rspInfo.tipsContent;
                if (str != null && !str.isEmpty()) {
                    hVar.b(str);
                    String str2 = loginResult.rspInfo.tipsTitle;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = BaseApplication.getContext().getString(R.string.f172151nv4);
                    }
                    ArrayList<Button> arrayList = loginResult.rspInfo.msgButton;
                    final ArrayList arrayList2 = new ArrayList();
                    if (arrayList != null) {
                        Iterator<Button> it = arrayList.iterator();
                        while (it.hasNext()) {
                            a n3 = a.n(qBaseActivity, it.next(), hVar);
                            if (n3 != null) {
                                arrayList2.add(n3);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(loginResult.rspInfo.jumpUrl) && !TextUtils.isEmpty(loginResult.rspInfo.jumpWord)) {
                        Button button = new Button();
                        LoginRspInfo loginRspInfo = loginResult.rspInfo;
                        button.wording = loginRspInfo.jumpWord;
                        button.url = loginRspInfo.jumpUrl;
                        a n16 = a.n(qBaseActivity, button, hVar);
                        if (n16 != null) {
                            arrayList2.add(n16);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        QLog.w(TAG, 1, "buttonHolders is empty");
                        return null;
                    }
                    if (arrayList2.size() > 2) {
                        createCustomDialog = DialogUtil.createVerticalThreeBtnDialog(qBaseActivity, 0, str2, str, ((a) arrayList2.get(0)).f242850a, ((a) arrayList2.get(1)).f242850a, ((a) arrayList2.get(2)).f242850a, ((a) arrayList2.get(0)).f242851b, ((a) arrayList2.get(1)).f242851b, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.loginregister.impl.d
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                LoginFailedCommonSceneHandlerApiImpl.lambda$buildDialogFromNTData$0(arrayList2, dialogInterface, i3);
                            }
                        });
                    } else {
                        createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230, str2, str, "", "", (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
                        if (arrayList2.size() > 1) {
                            createCustomDialog.setNegativeButton(((a) arrayList2.get(0)).f242850a, ((a) arrayList2.get(0)).f242851b);
                            createCustomDialog.setPositiveButton(((a) arrayList2.get(1)).f242850a, ((a) arrayList2.get(1)).f242851b);
                        } else {
                            createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.loginregister.impl.e
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    LoginFailedCommonSceneHandlerApiImpl.lambda$buildDialogFromNTData$1(dialogInterface, i3);
                                }
                            });
                            createCustomDialog.setPositiveButton(((a) arrayList2.get(0)).f242850a, ((a) arrayList2.get(0)).f242851b);
                        }
                    }
                    createCustomDialog.setMessageWithoutAutoLink(LoginUtil.f306390a.f(str, qBaseActivity, null, qBaseActivity.getResources().getColor(R.color.f156896el)));
                    return createCustomDialog;
                }
                QLog.w(TAG, 1, "content is empty");
                return null;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "buildDialogFromTlvData", e16);
            }
        }
        return null;
    }

    Dialog buildDialogFromTlvData(QBaseActivity qBaseActivity, byte[] bArr, h hVar) {
        List<GatewayVerify$Button> list;
        QQCustomDialog createCustomDialog;
        if (qBaseActivity != null && hVar != null) {
            try {
                GatewayVerify$RspBody parseRspBody = parseRspBody(bArr);
                if (parseRspBody == null) {
                    return null;
                }
                GatewayVerify$RspTipsInfo gatewayVerify$RspTipsInfo = parseRspBody.msg_rsp_tips_info.get();
                int i3 = gatewayVerify$RspTipsInfo.uint32_scene_id.get();
                if (i3 != 5) {
                    QLog.w(TAG, 1, "sceneId=" + i3);
                    return null;
                }
                String str = gatewayVerify$RspTipsInfo.str_content.get();
                if (str != null && !str.isEmpty()) {
                    hVar.b(str);
                    String str2 = gatewayVerify$RspTipsInfo.str_title.get();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = BaseApplication.getContext().getString(R.string.f172151nv4);
                    }
                    if (gatewayVerify$RspTipsInfo.msg_buttons.has()) {
                        list = gatewayVerify$RspTipsInfo.msg_buttons.get();
                    } else {
                        QLog.d(TAG, 2, "use left_button and right_button");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(gatewayVerify$RspTipsInfo.msg_left_button);
                        arrayList.add(gatewayVerify$RspTipsInfo.msg_right_button);
                        list = arrayList;
                    }
                    if (list != null && !list.isEmpty()) {
                        final ArrayList arrayList2 = new ArrayList();
                        Iterator<GatewayVerify$Button> it = list.iterator();
                        while (it.hasNext()) {
                            a m3 = a.m(qBaseActivity, it.next(), hVar);
                            if (m3 != null) {
                                arrayList2.add(m3);
                            }
                        }
                        if (arrayList2.isEmpty()) {
                            QLog.w(TAG, 1, "buttonHolders is empty");
                            return null;
                        }
                        if (arrayList2.size() > 2) {
                            createCustomDialog = DialogUtil.createVerticalThreeBtnDialog(qBaseActivity, 0, str2, str, ((a) arrayList2.get(0)).f242850a, ((a) arrayList2.get(1)).f242850a, ((a) arrayList2.get(2)).f242850a, ((a) arrayList2.get(0)).f242851b, ((a) arrayList2.get(1)).f242851b, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.loginregister.impl.c
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i16) {
                                    LoginFailedCommonSceneHandlerApiImpl.lambda$buildDialogFromTlvData$2(arrayList2, dialogInterface, i16);
                                }
                            });
                        } else {
                            createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230, str2, str, "", "", (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
                            if (arrayList2.size() > 0) {
                                createCustomDialog.setNegativeButton(((a) arrayList2.get(0)).f242850a, ((a) arrayList2.get(0)).f242851b);
                            }
                            if (arrayList2.size() > 1) {
                                createCustomDialog.setPositiveButton(((a) arrayList2.get(1)).f242850a, ((a) arrayList2.get(1)).f242851b);
                            }
                        }
                        createCustomDialog.setMessageWithoutAutoLink(LoginUtil.f306390a.f(str, qBaseActivity, null, qBaseActivity.getResources().getColor(R.color.f156896el)));
                        return createCustomDialog;
                    }
                    QLog.w(TAG, 1, "buttons is empty");
                    return null;
                }
                QLog.w(TAG, 1, "content is empty");
                return null;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "buildDialogFromTlvData", e16);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi
    public boolean handleLoginErrorInfo(QBaseActivity qBaseActivity, byte[] bArr, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, qBaseActivity, bArr, hVar)).booleanValue();
        }
        try {
            Dialog buildDialogFromTlvData = buildDialogFromTlvData(qBaseActivity, bArr, hVar);
            if (buildDialogFromTlvData != null) {
                buildDialogFromTlvData.show();
                doReport(qBaseActivity.getAppRuntime(), "0X800C0B5", hVar);
                ConcurrentHashMap<String, h> concurrentHashMap = reportDataMap;
                concurrentHashMap.put(EVENT_ID_FINISH_VERIFY + hVar.f242843a, hVar);
                concurrentHashMap.put(EVENT_ID_LOGIN_SUCCESS + hVar.f242843a, hVar);
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e(TAG, 2, "handle exception!", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi
    public boolean handleNTLoginErrorInfo(QBaseActivity qBaseActivity, LoginResult loginResult, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, qBaseActivity, loginResult, hVar)).booleanValue();
        }
        try {
            Dialog buildDialogFromNTData = buildDialogFromNTData(qBaseActivity, loginResult, hVar);
            if (buildDialogFromNTData != null) {
                buildDialogFromNTData.show();
                doReport(qBaseActivity.getAppRuntime(), "0X800C0B5", hVar);
                ConcurrentHashMap<String, h> concurrentHashMap = reportDataMap;
                concurrentHashMap.put(EVENT_ID_FINISH_VERIFY + hVar.f242843a, hVar);
                concurrentHashMap.put(EVENT_ID_LOGIN_SUCCESS + hVar.f242843a, hVar);
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e(TAG, 2, "handle exception!", e16);
            return false;
        }
    }

    void report(AppRuntime appRuntime, String str, String str2) {
        if (str == null) {
            return;
        }
        h remove = reportDataMap.remove(str2 + str);
        if (remove == null) {
            return;
        }
        doReport(appRuntime, str2, remove);
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi
    public void reportLoginSuccess(AppRuntime appRuntime, Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, obj, str);
        } else {
            report(appRuntime, h.c(obj, str), EVENT_ID_LOGIN_SUCCESS);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi
    public void reportWebNotifyFinishVerify(AppRuntime appRuntime, Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appRuntime, obj, str);
        } else {
            report(appRuntime, h.c(obj, str), EVENT_ID_FINISH_VERIFY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildDialogFromNTData$1(DialogInterface dialogInterface, int i3) {
    }
}
