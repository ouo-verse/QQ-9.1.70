package com.tencent.mobileqq.addcontacts;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.login.api.IWClientApi;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import e72.e;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.BuiltInServlet;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends WebViewPlugin implements ShareActionSheet.OnItemClickListener, DialogInterface.OnDismissListener {

    /* renamed from: d, reason: collision with root package name */
    private ShareActionSheet f187258d;

    /* renamed from: e, reason: collision with root package name */
    private String f187259e;

    /* renamed from: f, reason: collision with root package name */
    private String f187260f;

    /* renamed from: h, reason: collision with root package name */
    private String f187261h;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            c cVar = c.this;
            cVar.J(cVar.f187261h);
        }
    }

    private void B(String[] strArr) {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        String str4 = "";
        if (strArr == null || strArr.length < 1) {
            str = "";
            str2 = str;
        } else {
            try {
                jSONObject = new JSONObject(strArr[0]);
                str3 = jSONObject.optString("number");
                try {
                    str2 = jSONObject.optString("code");
                } catch (JSONException e16) {
                    e = e16;
                    str2 = "";
                }
            } catch (JSONException e17) {
                e = e17;
                str3 = "";
                str2 = str3;
            }
            try {
                str4 = jSONObject.getString("callback");
            } catch (JSONException e18) {
                e = e18;
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_PHONE_NUMBER_LOGIN error: " + e);
                String str5 = str4;
                str4 = str3;
                str = str5;
                Bundle bundle = new Bundle();
                bundle.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, str4);
                bundle.putString("country_code", str2);
                QIPCClientHelper.getInstance().callServer("LoginIPCModule", "PhoneSmsLogin", bundle);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 0);
                callJs(str, jSONObject2.toString());
                if (TextUtils.isEmpty(str4)) {
                    return;
                } else {
                    return;
                }
            }
            String str52 = str4;
            str4 = str3;
            str = str52;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, str4);
        bundle2.putString("country_code", str2);
        QIPCClientHelper.getInstance().callServer("LoginIPCModule", "PhoneSmsLogin", bundle2);
        JSONObject jSONObject22 = new JSONObject();
        try {
            jSONObject22.put("code", 0);
            callJs(str, jSONObject22.toString());
        } catch (JSONException e19) {
            QLog.e("InvitationFriend", 1, "handlePhoneNumLogin json exception: " + e19);
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2) || getActivity() == null) {
            return;
        }
        getActivity().finish();
    }

    private boolean D(String str) {
        QLog.d("InvitationFriend", 1, "handleUnbindAccount");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String jSONObject2 = jSONObject.toString();
            QLog.d("InvitationFriend", 2, "handle newLogin/unbindPhone jsonObj\uff1a" + jSONObject.toString());
            if (TextUtils.isEmpty(jSONObject2)) {
                return false;
            }
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar != null && bVar.a() != null) {
                Intent intent = new Intent();
                intent.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.unbindAccount");
                intent.setPackage(BaseApplication.getContext().getPackageName());
                intent.putExtra("key_login_unbind_phone_account_data", jSONObject2);
                Activity a16 = this.mRuntime.a();
                a16.sendBroadcast(intent);
                Bundle bundle = new Bundle();
                bundle.putString("key_login_unbind_phone_account_data", jSONObject2);
                WebViewBridge.f().j(this.mRuntime.a(), "com.tencent.mobileqq.InvitationWebViewPlugin.unbindAccount", bundle);
                QIPCClientHelper.getInstance().callServer("LoginIPCModule", "UnbindPhoneFinish", bundle);
                a16.setResult(-1);
                a16.finish();
            } else {
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_UNBIND_PHONE error: runtime or activity is null");
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private void E(String str) {
        final String str2;
        JSONObject jSONObject;
        String str3 = null;
        int i3 = 0;
        try {
            jSONObject = new JSONObject(str);
            str2 = jSONObject.getString("callback");
        } catch (JSONException e16) {
            e = e16;
            str2 = null;
        }
        try {
            i3 = jSONObject.getInt("type");
            str3 = jSONObject.getString("bizSeq");
        } catch (JSONException e17) {
            e = e17;
            QLog.e("InvitationFriend", 1, "handleWClientUnblock get callback error: " + e);
            if (TextUtils.isEmpty(str2)) {
            }
            QLog.e("InvitationFriend", 1, "handleWClientUnblock callback or bizSeq is null");
        }
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            ((IWClientApi) QRoute.api(IWClientApi.class)).startWClientVerify(this.mRuntime.a(), i3, str3, new e() { // from class: com.tencent.mobileqq.addcontacts.b
                @Override // e72.e
                public final void onResult(String str4) {
                    c.this.I(str2, str4);
                }
            });
        } else {
            QLog.e("InvitationFriend", 1, "handleWClientUnblock callback or bizSeq is null");
        }
    }

    private boolean G() {
        WebViewPlugin.b bVar = this.mRuntime;
        return bVar == null || bVar.a() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(int i3, String str, String str2) {
        QLog.d("InvitationFriend", 1, "handleGetWechatCode errCode: " + i3 + " errorMsg: " + str);
        String wXAppId = ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).getWXAppId();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i3);
            jSONObject.put("errorStr", str);
            jSONObject.put("code", str2);
            jSONObject.put("appId", wXAppId);
            callJs(this.f187259e, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("InvitationFriend", 1, "handleCheckWechatInstalled json exception: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str, String str2) {
        QLog.d("InvitationFriend", 2, "handleWClientUnblock callJs callback: " + str + "result : " + str2);
        callJs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI));
        intent.putExtra(SmsPlugin.KEY_SYSTEM_SMS_CONTENT, str);
        this.mRuntime.a().startActivity(intent);
    }

    private Activity getActivity() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    private List<ShareActionSheetBuilder.ActionSheetItem>[] t() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        return new ArrayList[]{arrayList};
    }

    private boolean u() {
        QLog.d("InvitationFriend", 1, "handleCheckWechatInstalled");
        boolean isWXAppInstalled = ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).isWXAppInstalled();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", isWXAppInstalled ? 1 : 0);
            callJs(this.f187259e, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("InvitationFriend", 1, "handleCheckWechatInstalled json exception: " + e16);
        }
        return true;
    }

    private boolean v() {
        QLog.d("InvitationFriend", 1, "handleGetWechatCode");
        ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).reqWXAuthCode(new IWXAuthApi.a() { // from class: com.tencent.mobileqq.addcontacts.a
            @Override // com.tencent.mobileqq.wxapi.IWXAuthApi.a
            public final void a(int i3, String str, String str2) {
                c.this.H(i3, str, str2);
            }
        });
        return true;
    }

    private boolean w(String str) {
        QLog.d("InvitationFriend", 1, "handleGuaranteeNotice");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            boolean z16 = new JSONObject(str).getBoolean("guaranteed");
            QLog.d("InvitationFriend", 2, "handle newLogin/guaranteeNotice guaranteed\uff1a" + z16);
            Bundle bundle = new Bundle();
            bundle.putBoolean("friend_verify_guaranteed", z16);
            WebViewBridge.f().j(this.mRuntime.a(), "com.tencent.mobileqq.InvitationWebViewPlugin.guaranteeNotice", bundle);
            this.mRuntime.a().setResult(-1);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private void y(String[] strArr) {
        String str;
        if (strArr != null && strArr.length >= 1) {
            try {
                str = new JSONObject(strArr[0]).optString("phoneMaskNum");
            } catch (JSONException e16) {
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_PHONE_NUMBER_LOGIN error: " + e16);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("key_login_page_entrance", 7);
            bundle.putString("phoneMaskNum", str);
            QIPCClientHelper.getInstance().callServer("LoginIPCModule", "JumpPhoneSmsLoginPage", bundle);
        }
        str = "";
        Bundle bundle2 = new Bundle();
        bundle2.putInt("key_login_page_entrance", 7);
        bundle2.putString("phoneMaskNum", str);
        QIPCClientHelper.getInstance().callServer("LoginIPCModule", "JumpPhoneSmsLoginPage", bundle2);
    }

    private boolean z() {
        AuthorityControlFragment.Ih(this.mRuntime.a());
        return true;
    }

    @QQPermissionDenied(1)
    public void denied() {
        QLog.d("InvitationFriend", 1, "CheckPermission user denied = sms");
        QQToast.makeText(this.mRuntime.a(), HardCodeUtil.qqStr(R.string.ngw), 1).show();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "newLogin";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        Activity activity;
        super.onActivityResult(intent, b16, i3);
        QLog.i("InvitationFriend", 1, "onActivityResult requestCode=" + ((int) b16) + " resultCode= " + i3);
        if (b16 == 100 && (activity = getActivity()) != null && i3 == -1) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_login_verify_by_mask", true);
            if (intent != null && intent.getExtras() != null) {
                bundle.putAll(intent.getExtras());
            }
            WebViewBridge.f().j(activity, "com.tencent.mobileqq.webAuxiliaryVerifySuccess", bundle);
            activity.setResult(i3, intent);
            activity.finish();
        }
    }

    private void A() {
        QLog.i("InvitationFriend", 2, "handleOpenUinMaskVerifyPage");
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e("InvitationFriend", 1, "handleOpenUinMaskVerifyPage activity is null");
        } else if (activity.getIntent() == null) {
            QLog.e("InvitationFriend", 1, "handleOpenUinMaskVerifyPage intent is null");
        } else {
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).jumpToAccountVerifyPage(activity, i.f(100, ao.a(this)));
        }
    }

    private void C() {
        QLog.d("InvitationFriend", 1, "handleRegWithNickAndPwd");
        WebViewBridge.f().j(this.mRuntime.a(), "com.tencent.mobileqq.InvitationWebViewPlugin.registerWithNickAndPwd", null);
        this.mRuntime.a().setResult(-1);
    }

    @QQPermissionGrant(1)
    public void grant() {
        QLog.d("InvitationFriend", 1, "CheckPermission user grant = sms");
        if (TextUtils.isEmpty(this.f187261h)) {
            return;
        }
        J(this.f187261h);
    }

    private boolean F(String[] strArr) {
        return strArr == null || strArr.length == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        String str;
        String str2;
        int i3 = actionSheetItem.action;
        int i16 = i3 != 1 ? (i3 == 9 || i3 != 10) ? 0 : 1 : 3;
        if (i16 == 0) {
            str2 = "0X80096FA";
        } else if (i16 == 1) {
            str2 = "0X80096FB";
        } else if (i16 == 2) {
            str2 = "0X80096FC";
        } else {
            if (i16 != 3) {
                str = "";
                callJs(this.f187259e, String.valueOf(i16));
                if ("".equals(str)) {
                    ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            str2 = "0X80096FD";
        }
        str = str2;
        callJs(this.f187259e, String.valueOf(i16));
        if ("".equals(str)) {
        }
    }

    private void x(String str, String str2, boolean z16, boolean z17) {
        QLog.d("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK success, jump to LoginActivity, enableLoginWithMask: " + z16 + "uinMask: " + str + ", isFromDeactivateAccount: " + z17);
        ReportController.r(null, "dc00898", "", "", "0X800B337", "0X800B337", 0, 0, "", "", "", "");
        Intent intent = new Intent();
        if (z16) {
            intent.putExtra("is_need_login_with_mask", true);
            intent.putExtra("uinMask", str);
            intent.putExtra("uinEncrpyt", str2);
        }
        intent.putExtra("is_from_deactivate_account_page", z17);
        intent.putExtra("loginFragmentType", 5);
        RouteUtils.startActivity(this.mRuntime.a(), intent, RouterConstants.UI_ROUTER_LOGIN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.i("InvitationFriend", 2, "handleJsRequest url is: " + str + " method: " + str3 + " pkgName: " + str2 + " args: " + strArr);
        }
        if (!"newLogin".equals(str2)) {
            return false;
        }
        if ("shareSMS".equalsIgnoreCase(str3)) {
            if (strArr != null && strArr.length == 1) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    String string = jSONObject.getString("desc");
                    this.f187260f = jSONObject.getString("callback");
                    QQPermission qQPermission = QQPermissionFactory.getQQPermission((AppActivity) this.mRuntime.a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_INVITATION_WEBVIEW, QQPermissionConstants.Business.SCENE.QQ_INVITATION_WEBVIEW_STAGE));
                    if (qQPermission != null) {
                        if (qQPermission.hasPermission(QQPermissionConstants.Permission.SEND_SMS) == 0) {
                            J(string);
                        } else {
                            this.f187261h = string;
                            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.SEND_SMS}, 2, new a());
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            return false;
        }
        if ("callShare".equalsIgnoreCase(str3)) {
            if (strArr != null && strArr.length == 1) {
                try {
                    this.f187259e = new JSONObject(strArr[0]).getString("callback");
                    Activity a16 = this.mRuntime.a();
                    if (this.f187258d == null) {
                        this.f187258d = ShareActionSheetFactory.create(a16, false);
                    }
                    this.f187258d.setActionSheetTitle(HardCodeUtil.qqStr(R.string.ngx));
                    this.f187258d.setActionSheetItems(t());
                    this.f187258d.setItemClickListenerV2(this);
                    this.f187258d.setOnDismissListener(this);
                    if (!a16.isFinishing()) {
                        try {
                            this.f187258d.show();
                            ReportController.o(null, "dc00898", "", "", "0X80096F9", "0X80096F9", 0, 0, "", "", "", "");
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("InvitationFriend", 2, "actionSheet.show exception=" + e16);
                            }
                        }
                        return true;
                    }
                } catch (JSONException unused2) {
                }
            }
            return false;
        }
        if ("AutoLogin".equalsIgnoreCase(str3)) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("InvitationFriend", 2, "handle newLogin/AutoLogin");
                }
                WebViewPlugin.b bVar = this.mRuntime;
                if (bVar != null && bVar.a() != null) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.autoLogin");
                    intent.setPackage(BaseApplication.getContext().getPackageName());
                    intent.putExtra("key_login_verify_by_web", true);
                    Intent intent2 = this.mRuntime.a().getIntent();
                    int intExtra = intent2 != null ? intent2.getIntExtra("loginFragmentType", 0) : 0;
                    if (intExtra > 0) {
                        intent.putExtra("loginFragmentType", intExtra);
                    }
                    Activity a17 = this.mRuntime.a();
                    a17.sendBroadcast(intent);
                    a17.setResult(-1);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("key_login_verify_by_web", true);
                    try {
                        String string2 = new JSONObject(strArr[0]).getString("verifySign");
                        QLog.d("InvitationFriend", 2, "handle newLogin/web newDevice verify sig\uff1a" + string2);
                        String str4 = new String(Base64.decode(string2, 0), "UTF-8");
                        bundle.putString("devlock_verify_sig", str4);
                        QLog.d("InvitationFriend", 2, "handleJsRequest decodeStr: " + str4);
                    } catch (Exception e17) {
                        QLog.d("InvitationFriend", 2, "handleJsRequest web newDevice verify error: " + e17);
                    }
                    WebViewBridge.f().j(a17, "com.tencent.mobileqq.webAuxiliaryVerifySuccess", bundle);
                } else {
                    QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_AUTO_LOGIN error: runtime or activity is null");
                }
            } catch (Exception e18) {
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_AUTO_LOGIN error: " + e18.getMessage());
            }
        } else if ("smsSig".equalsIgnoreCase(str3)) {
            QLog.d("InvitationFriend", 1, "handle newLogin/smsSig");
            if (F(strArr)) {
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_WECHAT_SMS_SIG error: args invalid");
                return false;
            }
            if (G()) {
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_WECHAT_SMS_SIG error: mRuntime invalid");
                return false;
            }
            try {
                String optString = new JSONObject(strArr[0]).optString(BuiltInServlet.MSF_KEY_SIG_INFO);
                Activity a18 = this.mRuntime.a();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("key_login_verify_by_web", true);
                bundle2.putString("login_verify_sms_sig", optString);
                WebViewBridge.f().j(a18, "com.tencent.mobileqq.webAuxiliaryVerifySuccess", bundle2);
                a18.setResult(-1);
            } catch (Exception e19) {
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_WECHAT_SMS_SIG error", e19);
                return false;
            }
        } else if ("loginWithUinMask".equalsIgnoreCase(str3)) {
            QLog.d("InvitationFriend", 1, "handle newLogin/loginWithUinMask");
            if (F(strArr)) {
                QLog.e("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK error: args invalid");
                return false;
            }
            if (G()) {
                QLog.e("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK error: mRuntime invalid");
                return false;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strArr[0]);
                String optString2 = jSONObject2.optString("uinMask");
                String optString3 = jSONObject2.optString("uinEncrpyt");
                boolean optBoolean = jSONObject2.optBoolean("enableLoginWithUinMask");
                if (optBoolean && (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3))) {
                    QLog.e("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK error: params empty");
                    return false;
                }
                x(optString2, optString3, optBoolean, jSONObject2.optBoolean("fromDeactivateAccount", false));
            } catch (Exception e26) {
                QLog.e("InvitationFriend", 1, "METHOD_LOGIN_WITH_UIN_MASK error", e26);
                return false;
            }
        } else if ("registerWithNickAndPwd".equalsIgnoreCase(str3)) {
            QLog.d("InvitationFriend", 1, "handle newLogin/registerWithNickAndPwd");
            if (G()) {
                QLog.e("InvitationFriend", 1, "METHOD_REG_WITH_NICK_PWD error: mRuntime invalid");
                return false;
            }
            C();
        } else if ("accountIdentityNotify".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("InvitationFriend", 2, "handle newLogin/accountIdentityNotify");
            }
            WebViewPlugin.b bVar2 = this.mRuntime;
            if (bVar2 != null && bVar2.a() != null) {
                Intent intent3 = new Intent();
                intent3.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
                intent3.setPackage(BaseApplication.getContext().getPackageName());
                this.mRuntime.a().sendBroadcast(intent3);
            } else {
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_AUTO_LOGIN error: runtime or activity is null");
            }
        } else if ("unbindPhone".equalsIgnoreCase(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("InvitationFriend", 2, "handle newLogin/unbindPhone");
            }
            if (strArr == null || strArr.length != 1 || !D(strArr[0])) {
                return false;
            }
        } else if ("phoneLogin".equalsIgnoreCase(str3)) {
            QLog.d("InvitationFriend", 1, "handle newLogin/phoneLogin");
            B(strArr);
        } else if ("mobileLogin".equalsIgnoreCase(str3)) {
            QLog.d("InvitationFriend", 4, "handle newLogin/mobileLogin");
            if (G()) {
                QLog.e("InvitationFriend", 1, "PLUGIN_METHOD_PHONE_NUMBER_LOGIN error: mRuntime invalid");
                return false;
            }
            y(strArr);
        } else {
            if ("guaranteeNotice".equals(str3)) {
                QLog.d("InvitationFriend", 4, "handle newLogin/guaranteeNotice");
                if (G()) {
                    QLog.e("InvitationFriend", 1, "METHOD_GUARANTEE_NOTICE error: mRuntime invalid");
                    return false;
                }
                if (strArr == null || strArr.length != 1) {
                    return false;
                }
                return w(strArr[0]);
            }
            if ("wclientVerify".equals(str3)) {
                QLog.d("InvitationFriend", 1, "handleJsRequest wclient verify");
                if (G()) {
                    QLog.e("InvitationFriend", 1, "METHOD_GUARANTEE_NOTICE error: mRuntime invalid");
                    return false;
                }
                if (strArr == null || strArr.length != 1) {
                    return false;
                }
                E(strArr[0]);
            } else if ("loginOpenUinMaskVerifyPage".equals(str3)) {
                A();
            } else {
                if ("openAuthorityControlPage".equals(str3)) {
                    return z();
                }
                if ("IsWechatInstalled".equals(str3)) {
                    try {
                        this.f187259e = new JSONObject(strArr[0]).getString("callback");
                        return u();
                    } catch (JSONException unused3) {
                        return false;
                    }
                }
                if ("WechatAuth".equals(str3)) {
                    try {
                        this.f187259e = new JSONObject(strArr[0]).getString("callback");
                        return v();
                    } catch (JSONException unused4) {
                        return false;
                    }
                }
            }
        }
        LocalPhoneWebViewPluginHelper.g(jsBridgeListener, str, str2, str3, strArr);
        return true;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
    }
}
