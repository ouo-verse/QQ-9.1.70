package com.tencent.qqmini.proxyimpl;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.report.MiniGetPhoneNumberReporter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog;
import com.tencent.mobileqq.qqpermission.base.AuthorizationMessage;
import com.tencent.mobileqq.qqpermission.base.AuthorizationRequestInfo;
import com.tencent.mobileqq.qqpermission.base.MessageNotificationInfo;
import com.tencent.mobileqq.qqpermission.view.AuthorizationHintDialog;
import com.tencent.mobileqq.qqpermission.view.AuthorizationRequestAdapter;
import com.tencent.mobileqq.qqpermission.view.AuthorizationRequestDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PrivacyDetailInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

@ProxyService(proxy = AuthJsProxy.class)
/* loaded from: classes34.dex */
public class AuthProxyImpl extends AuthJsProxy {

    /* renamed from: a, reason: collision with root package name */
    protected WeakReference<Activity> f347247a;

    /* renamed from: b, reason: collision with root package name */
    protected AuthJsProxy.AuthDialogResConfig f347248b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f347249c;

    /* renamed from: d, reason: collision with root package name */
    private String f347250d;

    /* renamed from: f, reason: collision with root package name */
    private Bundle f347252f;

    /* renamed from: g, reason: collision with root package name */
    private INTERFACE$StSubscribeMessage f347253g;

    /* renamed from: h, reason: collision with root package name */
    private IActivityResultListener f347254h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f347255i;

    /* renamed from: j, reason: collision with root package name */
    private DialogInterface.OnDismissListener f347256j;

    /* renamed from: k, reason: collision with root package name */
    private AuthorizationRequestDialog f347257k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f347258l;

    /* renamed from: n, reason: collision with root package name */
    private int f347260n;

    /* renamed from: p, reason: collision with root package name */
    private PrivacyDetailInfo f347262p;

    /* renamed from: e, reason: collision with root package name */
    private List<INTERFACE$StSubscribeMessage> f347251e = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private List<Boolean> f347259m = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    private String f347261o = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a extends QQAuthorizationDialog.AuthorizationListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onAllow() {
            QLog.d("AuthProxyImpl", 1, "showNormalTypeDialog onAllow");
            AuthProxyImpl.this.f347255i = true;
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogDismiss(AuthorizationRequestDialog authorizationRequestDialog) {
            QLog.d("AuthProxyImpl", 1, "showNormalTypeDialog onDialogDismiss");
            if (AuthProxyImpl.this.f347256j != null) {
                AuthProxyImpl.this.f347256j.onDismiss(authorizationRequestDialog);
                AuthProxyImpl.this.f347256j = null;
            }
            AuthProxyImpl.this.N();
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogShow(AuthorizationRequestDialog authorizationRequestDialog) {
            QLog.d("AuthProxyImpl", 1, "showNormalTypeDialog onDialogShow");
            AuthProxyImpl.this.Q(authorizationRequestDialog);
            AuthProxyImpl.this.f347257k = authorizationRequestDialog;
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onHintDialogShow(AuthorizationHintDialog authorizationHintDialog) {
            QLog.d("AuthProxyImpl", 1, "showNormalTypeDialog onHintDialogShow");
            AuthProxyImpl.this.O(authorizationHintDialog);
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onRefuse() {
            QLog.d("AuthProxyImpl", 1, "showNormalTypeDialog onRefuse");
            AuthProxyImpl.this.f347255i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b extends QQAuthorizationDialog.AuthorizationListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onAllow(List<Boolean> list) {
            QLog.d("AuthProxyImpl", 1, "showPhoneNumberDialog onAllow listCheck");
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3).booleanValue()) {
                    AuthProxyImpl.this.f347260n = i3;
                    break;
                }
                i3++;
            }
            AuthProxyImpl.this.A(list);
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogShow(AuthorizationRequestDialog authorizationRequestDialog) {
            WeakReference<Activity> weakReference = AuthProxyImpl.this.f347247a;
            if (weakReference != null && weakReference.get() != null) {
                QLog.d("AuthProxyImpl", 1, "showPhoneNumberDialog onDialogShow");
                authorizationRequestDialog.setTextColorSupplementTv(AuthProxyImpl.this.f347247a.get().getResources().getColor(R.color.cir));
                AuthProxyImpl.this.f347257k = authorizationRequestDialog;
                MiniGetPhoneNumberReporter.getInstance().phoneNumberDialogShowReport();
                return;
            }
            QLog.e("AuthProxyImpl", 1, "showPhoneNumberDialog onDialogShow activity is null!");
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogDismiss(AuthorizationRequestDialog authorizationRequestDialog) {
            QLog.d("AuthProxyImpl", 1, "showPhoneNumberDialog onDialogDismiss");
            if (AuthProxyImpl.this.f347256j != null) {
                AuthProxyImpl.this.f347256j.onDismiss(authorizationRequestDialog);
                AuthProxyImpl.this.f347256j = null;
            }
            ActivityResultManager.g().removeActivityResultListener(AuthProxyImpl.this.f347254h);
            AuthProxyImpl.this.N();
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onHintDialogShow(AuthorizationHintDialog authorizationHintDialog) {
            QLog.d("AuthProxyImpl", 1, "showPhoneNumberDialog onHintDialogShow");
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onRefuse() {
            QLog.d("AuthProxyImpl", 1, "showPhoneNumberDialog onRefuse");
            AuthProxyImpl.this.f347255i = false;
            MiniGetPhoneNumberReporter.getInstance().phoneNumberRefuseClickReport();
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onSupplementTvClick(View view) {
            QLog.d("AuthProxyImpl", 1, "showPhoneNumberDialog onSupplementTvClick");
            AuthProxyImpl.this.L();
            MiniGetPhoneNumberReporter.getInstance().phoneNumberManageClickReport();
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onAllow() {
            QLog.d("AuthProxyImpl", 1, "showPhoneNumberDialog onAllow");
            AuthProxyImpl.this.f347255i = true;
            MiniGetPhoneNumberReporter.getInstance().phoneNumberAllowClickReport();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c extends QQAuthorizationDialog.AuthorizationListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onAllow() {
            QLog.d("AuthProxyImpl", 1, "showOnceSubMessageDialog onAllow");
            AuthProxyImpl.this.f347255i = true;
            AuthProxyImpl.this.S();
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void bottomCheck(boolean z16) {
            QLog.d("AuthProxyImpl", 1, "showOnceSubMessageDialog bottomCheck");
            AuthProxyImpl.this.f347258l = z16;
            AuthProxyImpl.this.S();
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogDismiss(AuthorizationRequestDialog authorizationRequestDialog) {
            QLog.d("AuthProxyImpl", 1, "showOnceSubMessageDialog onDialogDismiss");
            if (AuthProxyImpl.this.f347256j != null) {
                AuthProxyImpl.this.f347256j.onDismiss(authorizationRequestDialog);
                AuthProxyImpl.this.f347256j = null;
            }
            AuthProxyImpl.this.M();
            AuthProxyImpl.this.N();
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogShow(AuthorizationRequestDialog authorizationRequestDialog) {
            QLog.d("AuthProxyImpl", 1, "showOnceSubMessageDialog onDialogShow");
            AuthProxyImpl.this.f347257k = authorizationRequestDialog;
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onRefuse() {
            QLog.d("AuthProxyImpl", 1, "showOnceSubMessageDialog onRefuse");
            AuthProxyImpl.this.f347255i = false;
            AuthProxyImpl.this.S();
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onSubHintDialogHide(MessageNotificationInfo messageNotificationInfo, AuthorizationHintDialog authorizationHintDialog) {
            QLog.d("AuthProxyImpl", 1, "showOnceSubMessageDialog onSubHintDialogHide");
            AuthProxyImpl.this.T(messageNotificationInfo, authorizationHintDialog);
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onAllow(List<Boolean> list) {
            QLog.d("AuthProxyImpl", 1, "showOnceSubMessageDialog onAllow listCheck");
            AuthProxyImpl.this.f347259m = list;
            AuthProxyImpl.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class d extends QQAuthorizationDialog.AuthorizationListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onAllow() {
            QLog.d("AuthProxyImpl", 1, "showUserInfoDialog onAllow");
            AuthProxyImpl.this.f347255i = true;
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogDismiss(AuthorizationRequestDialog authorizationRequestDialog) {
            QLog.d("AuthProxyImpl", 1, "showUserInfoDialog onDialogDismiss");
            if (AuthProxyImpl.this.f347256j != null) {
                AuthProxyImpl.this.f347256j.onDismiss(authorizationRequestDialog);
                AuthProxyImpl.this.f347256j = null;
            }
            if (!AuthProxyImpl.this.f347251e.isEmpty()) {
                AuthProxyImpl.this.f347257k = null;
                AuthProxyImpl.this.W();
            } else {
                AuthProxyImpl.this.N();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogShow(AuthorizationRequestDialog authorizationRequestDialog) {
            QLog.d("AuthProxyImpl", 1, "showUserInfoDialog onDialogShow");
            AuthProxyImpl.this.Q(authorizationRequestDialog);
            AuthProxyImpl.this.f347257k = authorizationRequestDialog;
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onHintDialogShow(AuthorizationHintDialog authorizationHintDialog) {
            QLog.d("AuthProxyImpl", 1, "showUserInfoDialog onHintDialogShow");
            AuthProxyImpl.this.O(authorizationHintDialog);
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onRefuse() {
            QLog.d("AuthProxyImpl", 1, "showUserInfoDialog onRefuse");
            AuthProxyImpl.this.f347255i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class e extends ClickableSpan {
        e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AuthProxyImpl.this.K();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#FF2D77E5"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class f extends ClickableSpan {
        f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AuthProxyImpl.this.J();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#FF2D77E5"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class g extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f347272d;

        /* renamed from: e, reason: collision with root package name */
        private List<COMM.Entry> f347273e;

        /* loaded from: classes34.dex */
        static class a {

            /* renamed from: a, reason: collision with root package name */
            private TextView f347274a;

            /* renamed from: b, reason: collision with root package name */
            private TextView f347275b;

            public a(View view) {
                this.f347274a = (TextView) view.findViewById(com.tencent.qqmini.sdk.R.id.detail_item_title);
                this.f347275b = (TextView) view.findViewById(com.tencent.qqmini.sdk.R.id.detail_item_desc);
            }
        }

        public g(Context context, List<COMM.Entry> list) {
            this.f347272d = context;
            this.f347273e = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f347273e.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.f347273e.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            COMM.Entry entry = (COMM.Entry) getItem(i3);
            if (entry != null) {
                if (view != null) {
                    aVar = (a) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f347272d).inflate(R.layout.fhk, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                }
                aVar.f347274a.setText(entry.key.get());
                aVar.f347275b.setText(entry.value.get());
            }
            return view;
        }
    }

    private List<AuthorizationMessage> C() {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = this.f347248b.phoneNumberList;
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String optString = jSONArray.optJSONObject(i3).optString("purePhoneNumber");
            int optInt = jSONArray.optJSONObject(i3).optInt("phoneType");
            AuthorizationMessage authorizationMessage = new AuthorizationMessage(optString, null);
            if (optInt == 0) {
                authorizationMessage.isChecked = true;
                authorizationMessage.supplement = HardCodeUtil.qqStr(R.string.f167002br);
            } else {
                authorizationMessage.isChecked = false;
            }
            arrayList.add(authorizationMessage);
        }
        return arrayList;
    }

    private void D() {
        Bundle bundle = this.f347252f;
        if (bundle == null) {
            return;
        }
        byte[] byteArray = bundle.getByteArray("key_once_sub_rsp_data");
        INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
        if (byteArray != null) {
            try {
                iNTERFACE$StGetUserSettingRsp.mergeFrom(byteArray);
            } catch (Throwable th5) {
                QLog.e("AuthProxyImpl", 1, "loadOnceSubMsgView - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", th5);
            }
        }
        INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = iNTERFACE$StGetUserSettingRsp.setting;
        if (iNTERFACE$StUserSettingInfo != null) {
            List<INTERFACE$StSubscribeMessage> list = iNTERFACE$StUserSettingInfo.subItems.get();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
                if (iNTERFACE$StSubscribeMessage.authState.get() == 0) {
                    arrayList.add(iNTERFACE$StSubscribeMessage);
                }
            }
            this.f347251e = arrayList;
        }
    }

    private boolean F() {
        QLog.d("AuthProxyImpl", 1, "isAddMiniGameSubscriptionEvent");
        SpecialProxy specialProxy = (SpecialProxy) ProxyManager.get(SpecialProxy.class);
        AuthJsProxy.AuthDialogResConfig authDialogResConfig = this.f347248b;
        IMiniAppContext iMiniAppContext = authDialogResConfig.miniAppContext;
        int i3 = authDialogResConfig.dialogType;
        int size = this.f347251e.size();
        if (specialProxy == null || iMiniAppContext == null || !iMiniAppContext.isMiniGame()) {
            return false;
        }
        if (5 == i3) {
            return true;
        }
        return (i3 == 3 || i3 == 4) && size > 0 && size < 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean I(int i3, int i16, Intent intent) {
        QLog.d("AuthProxyImpl", 1, "doOnActivityResult : " + i3);
        if (i3 == 1089) {
            if (i16 != -1) {
                QLog.e("AuthProxyImpl", 1, "REQUEST_CODE_PHONE_MANAGER " + i16);
            } else if (intent != null) {
                try {
                    JSONArray jSONArray = new JSONArray(intent.getStringExtra("phoneNumberArray"));
                    AuthJsProxy.AuthDialogResConfig authDialogResConfig = this.f347248b;
                    if (authDialogResConfig != null) {
                        authDialogResConfig.phoneNumberList = jSONArray;
                        Z();
                    }
                } catch (Throwable th5) {
                    QLog.e("AuthProxyImpl", 1, "REQUEST_CODE_PHONE_MANAGER error, ", th5);
                }
            }
            return true;
        }
        if (i3 != 1088) {
            return false;
        }
        if (i16 != -1) {
            QLog.e("AuthProxyImpl", 1, "REQUEST_CODE_ADD_PHONENUMBER " + i16);
        } else if (intent != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("phoneType", 1);
                jSONObject.put("purePhoneNumber", intent.getStringExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER));
                jSONObject.put("countryCode", "+86");
                jSONObject.put("iv", intent.getStringExtra("iv"));
                jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, intent.getStringExtra(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA));
                jSONObject.put(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, intent.getStringExtra(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID));
                QLog.d("AuthProxyImpl", 1, "REQUEST_CODE_ADD_PHONENUMBER stPhoneNumberObj : " + jSONObject);
                AuthJsProxy.AuthDialogResConfig authDialogResConfig2 = this.f347248b;
                if (authDialogResConfig2 != null) {
                    authDialogResConfig2.phoneNumberList.mo162put(jSONObject);
                    Z();
                }
            } catch (Throwable th6) {
                QLog.e("AuthProxyImpl", 1, "REQUEST_CODE_ADD_PHONENUMBER error, ", th6);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        String str;
        PrivacyDetailInfo privacyDetailInfo = this.f347262p;
        if (privacyDetailInfo != null && !TextUtils.isEmpty(privacyDetailInfo.getId())) {
            WeakReference<Activity> weakReference = this.f347247a;
            if (weakReference != null && weakReference.get() != null) {
                String id5 = this.f347262p.getId();
                MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                try {
                    str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    QMLog.e("AuthProxyImpl", "startComplainAndCallback, url = ");
                    e16.printStackTrace();
                    str = "";
                }
                String str2 = "https://support.qq.com/embed/phone/56748/new-post?appid=" + id5 + "&openid=" + LoginManager.getInstance().getAccount() + "&avatar=" + str + "&nickname=\u6e38\u5ba2";
                Intent intent = new Intent();
                intent.putExtra("url", str2);
                intent.putExtra("title", "\u6295\u8bc9");
                Bundle bundle = new Bundle();
                bundle.putBoolean("hide_more_button", true);
                intent.putExtras(bundle);
                miniAppProxy.startBrowserActivity(this.f347247a.get(), intent);
                return;
            }
            QLog.e("AuthProxyImpl", 1, "onComplainClick activity is null!");
            return;
        }
        QMLog.d("AuthProxyImpl", "onComplainClick but context or appId is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        WeakReference<Activity> weakReference = this.f347247a;
        if (weakReference != null && weakReference.get() != null) {
            if (TextUtils.isEmpty(this.f347262p.getWebUrl())) {
                QMLog.d("AuthProxyImpl", "onPrivacyWebClick, fail ctx is null : ${ctx == null}");
            }
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            Intent intent = new Intent();
            intent.putExtra("url", this.f347262p.getWebUrl());
            intent.putExtra("title", this.f347262p.getPrivacyTitle());
            miniAppProxy.startBrowserActivity(this.f347247a.get(), intent);
            QMLog.d("AuthProxyImpl", "onPrivacyWebClick:" + this.f347262p.getWebUrl());
            return;
        }
        QLog.e("AuthProxyImpl", 1, "onPrivacyWebClick activity is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        WeakReference<Activity> weakReference = this.f347247a;
        if (weakReference != null && weakReference.get() != null) {
            Intent intent = new Intent();
            intent.putExtra("appId", this.f347248b.miniAppInfo.appId);
            intent.putExtra("public_fragment_window_feature", 1);
            JSONArray jSONArray = this.f347248b.phoneNumberList;
            if (jSONArray.length() == 1) {
                ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                if (channelProxy != null) {
                    channelProxy.launchAddPhoneNumberFragment(this.f347247a.get(), intent, 1088);
                    return;
                }
                return;
            }
            intent.putExtra("phoneNumberList", jSONArray.toString());
            ChannelProxy channelProxy2 = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            if (channelProxy2 != null) {
                channelProxy2.launchPhoneNumberManagementFragment(this.f347247a.get(), intent, 1089);
                return;
            }
            return;
        }
        QLog.e("AuthProxyImpl", 1, "phoneNumberManageEvent activity is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage;
        QLog.d("AuthProxyImpl", 1, "revomeMiniGameSubscriptionEvent");
        List<INTERFACE$StSubscribeMessage> list = this.f347251e;
        if (list != null && (iNTERFACE$StSubscribeMessage = this.f347253g) != null && list.contains(iNTERFACE$StSubscribeMessage) && !this.f347259m.isEmpty()) {
            this.f347251e.remove(this.f347253g);
            int i3 = this.f347248b.dialogType;
            boolean z16 = false;
            if (i3 == 5) {
                z16 = this.f347259m.get(0).booleanValue();
            } else if (i3 == 3 || i3 == 4) {
                z16 = this.f347259m.get(r0.size() - 2).booleanValue();
            }
            if (z16) {
                this.f347261o = AuthJsProxy.SUB_MINIGAME_REPORT;
            } else {
                this.f347261o = AuthJsProxy.UNSUB_MINIGAME_REPORT;
            }
            if (this.f347255i && z16) {
                B();
                return;
            }
            return;
        }
        QLog.d("AuthProxyImpl", 1, "mMiniGameSubMsg is Empty!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.f347259m.clear();
        this.f347258l = false;
        this.f347257k = null;
        this.f347255i = false;
        this.f347253g = null;
        this.f347251e.clear();
        this.f347261o = "";
        this.f347262p = null;
        this.f347249c = false;
        this.f347247a = null;
        this.f347248b.miniAppContext = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(AuthorizationHintDialog authorizationHintDialog) {
        SpannableString spannableString = new SpannableString(authorizationHintDialog.getHintContent());
        PrivacyDetailInfo privacyDetailInfo = this.f347262p;
        if (privacyDetailInfo != null && !TextUtils.isEmpty(privacyDetailInfo.getPrivacyTitle())) {
            String privacyTitle = this.f347262p.getPrivacyTitle();
            int indexOf = authorizationHintDialog.getHintContent().indexOf(privacyTitle);
            spannableString.setSpan(new e(), indexOf, privacyTitle.length() + indexOf, 33);
        }
        String qqStr = HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_sdk_privacy_link_complain);
        int indexOf2 = authorizationHintDialog.getHintContent().indexOf(qqStr);
        spannableString.setSpan(new f(), indexOf2, qqStr.length() + indexOf2, 17);
        authorizationHintDialog.setHintContent(spannableString);
    }

    private void R() {
        this.f347254h = new IActivityResultListener() { // from class: com.tencent.qqmini.proxyimpl.c
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public final boolean doOnActivityResult(int i3, int i16, Intent intent) {
                boolean I;
                I = AuthProxyImpl.this.I(i3, i16, intent);
                return I;
            }
        };
        ActivityResultManager.g().addActivityResultListener(this.f347254h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        Bundle bundle = this.f347252f;
        if (bundle == null) {
            return;
        }
        bundle.putBoolean("key_once_sub_cb_maintain", this.f347258l);
        int size = this.f347259m.size();
        for (int i3 = 0; i3 < size; i3++) {
            boolean booleanValue = this.f347259m.get(i3).booleanValue();
            if (i3 == 0) {
                this.f347252f.putBoolean("key_once_sub_cb1", booleanValue);
            } else if (i3 == 1) {
                this.f347252f.putBoolean("key_once_sub_cb2", booleanValue);
            } else if (i3 == 2) {
                this.f347252f.putBoolean("key_once_sub_cb3", booleanValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(MessageNotificationInfo messageNotificationInfo, AuthorizationHintDialog authorizationHintDialog) {
        WeakReference<Activity> weakReference = this.f347247a;
        if (weakReference != null && weakReference.get() != null) {
            AuthJsProxy.AuthDetailDialogResConfig authDetailDialogResConfig = new AuthJsProxy.AuthDetailDialogResConfig();
            authDetailDialogResConfig.dialogType = 1;
            for (INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage : this.f347251e) {
                if (messageNotificationInfo.hintTitle.equals(iNTERFACE$StSubscribeMessage.example.title.get())) {
                    authDetailDialogResConfig.curSubMsg = iNTERFACE$StSubscribeMessage;
                    authDetailDialogResConfig.content = iNTERFACE$StSubscribeMessage.example.contents.get();
                    P(this.f347247a.get(), authDetailDialogResConfig, authorizationHintDialog);
                    return;
                }
            }
            return;
        }
        QMLog.e("AuthProxyImpl", "showCustomHintDialog activity is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        int i3 = this.f347248b.dialogType;
        if (i3 == 1) {
            V();
        } else if (i3 == 2) {
            X();
        } else if (i3 == 3 || i3 == 4) {
            W();
        } else if (i3 == 5) {
            Y();
        }
        reportMiniAppEvent("expo");
    }

    private void V() {
        WeakReference<Activity> weakReference = this.f347247a;
        if (weakReference != null && weakReference.get() != null) {
            QQAuthorizationDialog.showAuthorizationRequestDialog(this.f347247a.get(), new AuthorizationRequestInfo(this.f347248b.miniAppIconUrl, this.f347248b.miniAppName + " | \u7533\u8bf7", this.f347248b.authTitle, new a()).plainTextDialog(this.f347248b.authDesc).showHintView(HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_sdk_more_privacy_title), HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_sdk_privacy_content)));
            return;
        }
        QMLog.e("AuthProxyImpl", "showNormalTypeDialog activity is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        QLog.d("AuthProxyImpl", 1, "showOnceSubMessageDialog");
        if (this.f347251e.isEmpty()) {
            QMLog.e("AuthProxyImpl", "mSubMsgNoMaintainAuthData size > 3 || size == 0!!");
            return;
        }
        WeakReference<Activity> weakReference = this.f347247a;
        if (weakReference != null && weakReference.get() != null) {
            ArrayList arrayList = new ArrayList();
            for (INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage : this.f347251e) {
                MessageNotificationInfo messageNotificationInfo = new MessageNotificationInfo(iNTERFACE$StSubscribeMessage.example.title.get(), true);
                messageNotificationInfo.showHintView(iNTERFACE$StSubscribeMessage.example.title.get(), "");
                arrayList.add(messageNotificationInfo);
            }
            AuthorizationRequestInfo messageNotificationDialog = new AuthorizationRequestInfo(this.f347248b.miniAppIconUrl, this.f347248b.miniAppName + " | \u7533\u8bf7", HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_qqauthorization_apply_info), new c()).messageNotificationDialog(arrayList);
            if (this.f347248b.dialogType == 3) {
                messageNotificationDialog.showBottomCheck(false, HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_qqauthorization_bottom_text));
                this.f347258l = false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f347259m.add(Boolean.valueOf(((MessageNotificationInfo) it.next()).isChecked));
            }
            S();
            QQAuthorizationDialog.showAuthorizationRequestDialog(this.f347247a.get(), messageNotificationDialog);
            return;
        }
        QMLog.e("AuthProxyImpl", "showOnceSubMessageDialog activity is null!");
    }

    private void X() {
        WeakReference<Activity> weakReference = this.f347247a;
        if (weakReference != null && weakReference.get() != null) {
            JSONArray jSONArray = this.f347248b.phoneNumberList;
            if (jSONArray != null && jSONArray.length() > 0) {
                QQAuthorizationDialog.showAuthorizationRequestDialog(this.f347247a.get(), new AuthorizationRequestInfo(this.f347248b.miniAppIconUrl, this.f347248b.miniAppName + " | \u7533\u8bf7", this.f347248b.authTitle, new b()).plainTextDialog(HardCodeUtil.qqStr(R.string.f167692dm)).checkTextListDialog(C()).setSubHead(HardCodeUtil.qqStr(R.string.f167012bs)).showHintView(HardCodeUtil.qqStr(R.string.f167122c3), HardCodeUtil.qqStr(R.string.f167112c2)));
                return;
            }
            QLog.e("AuthProxyImpl", 1, "authdialog show error, getPhoneNumberList is null, return.");
            return;
        }
        QLog.e("AuthProxyImpl", 1, "showPhoneNumberDialog activity is null!");
    }

    private void Y() {
        WeakReference<Activity> weakReference = this.f347247a;
        if (weakReference != null && weakReference.get() != null) {
            AuthorizationRequestInfo authorizationRequestInfo = new AuthorizationRequestInfo(this.f347248b.miniAppIconUrl, this.f347248b.miniAppName + " | \u7533\u8bf7", this.f347248b.authTitle, new d());
            AuthJsProxy.AuthDialogResConfig authDialogResConfig = this.f347248b;
            QQAuthorizationDialog.showAuthorizationRequestDialog(this.f347247a.get(), authorizationRequestInfo.imageTextDialog(authDialogResConfig.userIconUrl, authDialogResConfig.userName, authDialogResConfig.authDesc).showHintView(HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_sdk_more_privacy_title), HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_sdk_privacy_content)));
            return;
        }
        QLog.e("AuthProxyImpl", 1, "showUserInfoDialog activity is null!");
    }

    private void Z() {
        if (this.f347257k.getListAdapter() instanceof AuthorizationRequestAdapter) {
            AuthorizationRequestAdapter authorizationRequestAdapter = new AuthorizationRequestAdapter();
            authorizationRequestAdapter.updateData(C());
            this.f347257k.showListView(authorizationRequestAdapter);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public Bundle getAuthDialogBundleData() {
        return this.f347252f;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public AuthJsProxy.AuthDialogResConfig getAuthDialogResConfig() {
        return this.f347248b;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public int getAuthDialogType() {
        AuthJsProxy.AuthDialogResConfig authDialogResConfig = this.f347248b;
        if (authDialogResConfig != null) {
            return authDialogResConfig.dialogType;
        }
        return 1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public JSONObject getSelectPhoneNumber() {
        JSONArray jSONArray = this.f347248b.phoneNumberList;
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        int i3 = this.f347260n;
        if (length > i3) {
            return this.f347248b.phoneNumberList.optJSONObject(i3);
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void initAuthDialog(Activity activity, AuthJsProxy.AuthDialogResConfig authDialogResConfig) {
        QLog.d("AuthProxyImpl", 1, "initAuthDialog");
        this.f347247a = new WeakReference<>(activity);
        this.f347248b = authDialogResConfig;
        this.f347249c = true;
        int i3 = authDialogResConfig.dialogType;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                D();
                this.f347248b.reportSubAction = MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_SYS_MSG_SUBSCRIBED;
            }
            D();
            this.f347248b.reportSubAction = MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_ONCE_MSG_SUBSCRIBED;
            return;
        }
        this.f347250d = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
        R();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthConfirm() {
        return this.f347255i;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthDialogInit() {
        return this.f347249c;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthDialogNotNull() {
        return this.f347257k != null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthDialogShow() {
        QLog.d("AuthProxyImpl", 1, "isAuthDialogShow");
        AuthorizationRequestDialog authorizationRequestDialog = this.f347257k;
        return authorizationRequestDialog != null && authorizationRequestDialog.isShowing();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public boolean isAuthRefuse() {
        return !this.f347255i;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void reportMiniAppEvent(String str) {
        AuthJsProxy.AuthDialogResConfig authDialogResConfig = this.f347248b;
        String str2 = authDialogResConfig.reportSubAction;
        MiniAppInfo miniAppInfo = authDialogResConfig.miniAppInfo;
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "scope", str2, str, this.f347261o);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void setAuthDialogBundleData(Bundle bundle) {
        this.f347252f = bundle;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void setAuthDialogToNull() {
        AuthorizationRequestDialog authorizationRequestDialog = this.f347257k;
        if (authorizationRequestDialog == null || !authorizationRequestDialog.isShowing()) {
            return;
        }
        this.f347257k.dismiss();
        this.f347257k = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f347256j = onDismissListener;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void showAuthDialog(AuthJsProxy.AuthDialogResConfig authDialogResConfig) {
        QLog.d("AuthProxyImpl", 1, "showAuthDialog dialogType:" + authDialogResConfig.dialogType);
        this.f347248b = authDialogResConfig;
        if (F()) {
            E();
        } else {
            U();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void showAuthListViewHintDialog(Activity activity, AuthJsProxy.AuthDetailDialogResConfig authDetailDialogResConfig) {
        QLog.d("AuthProxyImpl", 1, "showAuthListViewHintDialog");
        AuthorizationHintDialog buildHintDialog = AuthorizationHintDialog.buildHintDialog(activity, authDetailDialogResConfig.title, "");
        P(activity, authDetailDialogResConfig, buildHintDialog);
        try {
            buildHintDialog.show();
        } catch (WindowManager.BadTokenException e16) {
            QLog.e("AuthProxyImpl", 1, "showAuthListViewHintDialog " + e16.getMessage());
        }
    }

    private void B() {
        QLog.d("AuthProxyImpl", 1, "followMiniGamePA");
        SpecialProxy specialProxy = (SpecialProxy) ProxyManager.get(SpecialProxy.class);
        if (specialProxy != null) {
            specialProxy.sendEventToHost(4, null, null);
        }
    }

    private void E() {
        QLog.d("AuthProxyImpl", 1, "insertMiniGameSubscriptionEvent");
        ((SpecialProxy) ProxyManager.get(SpecialProxy.class)).sendEventToHost(3, null, new SpecialProxy.EventCallback() { // from class: com.tencent.qqmini.proxyimpl.AuthProxyImpl.7
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy.EventCallback
            public void onResult(boolean z16, Bundle bundle) {
                final INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = null;
                if (z16) {
                    try {
                        byte[] byteArray = bundle.getByteArray(SpecialProxy.KEY_DATA);
                        if (byteArray != null && byteArray.length > 0) {
                            INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage2 = new INTERFACE$StSubscribeMessage();
                            try {
                                iNTERFACE$StSubscribeMessage2.mergeFrom(byteArray);
                                iNTERFACE$StSubscribeMessage = iNTERFACE$StSubscribeMessage2;
                            } catch (Exception e16) {
                                e = e16;
                                iNTERFACE$StSubscribeMessage = iNTERFACE$StSubscribeMessage2;
                                QLog.e("AuthProxyImpl", 1, "[insertMiniGamePA2Dialog] error!", e);
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.AuthProxyImpl.7.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AuthProxyImpl.this.f347253g = iNTERFACE$StSubscribeMessage;
                                        AuthProxyImpl authProxyImpl = AuthProxyImpl.this;
                                        int i3 = authProxyImpl.f347248b.dialogType;
                                        boolean z17 = (i3 == 3 || i3 == 4) && !authProxyImpl.f347251e.isEmpty();
                                        if (AuthProxyImpl.this.f347253g != null && (z17 || i3 == 5)) {
                                            AuthProxyImpl.this.f347251e.add(AuthProxyImpl.this.f347253g);
                                        }
                                        AuthProxyImpl.this.U();
                                    }
                                });
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.AuthProxyImpl.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AuthProxyImpl.this.f347253g = iNTERFACE$StSubscribeMessage;
                        AuthProxyImpl authProxyImpl = AuthProxyImpl.this;
                        int i3 = authProxyImpl.f347248b.dialogType;
                        boolean z17 = (i3 == 3 || i3 == 4) && !authProxyImpl.f347251e.isEmpty();
                        if (AuthProxyImpl.this.f347253g != null && (z17 || i3 == 5)) {
                            AuthProxyImpl.this.f347251e.add(AuthProxyImpl.this.f347253g);
                        }
                        AuthProxyImpl.this.U();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(final AuthorizationRequestDialog authorizationRequestDialog) {
        QLog.d("AuthProxyImpl", 1, "setDefaultHintDialogEvent");
        authorizationRequestDialog.hideHintImage();
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        AuthJsProxy.AuthDialogResConfig authDialogResConfig = this.f347248b;
        miniAppProxy.getMiniAppPrivacyInfo(authDialogResConfig.miniAppInfo.appId, authDialogResConfig.eventName, new MiniAppProxy.GetPrivacyInfoListener() { // from class: com.tencent.qqmini.proxyimpl.d
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetPrivacyInfoListener
            public final void onResult(boolean z16, boolean z17, PrivacyDetailInfo privacyDetailInfo) {
                AuthProxyImpl.this.H(authorizationRequestDialog, z16, z17, privacyDetailInfo);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy
    public void dismissAuthDialog() {
        QLog.d("AuthProxyImpl", 1, "dismissAuthDialog");
        AuthorizationRequestDialog authorizationRequestDialog = this.f347257k;
        if (authorizationRequestDialog == null || !authorizationRequestDialog.isShowing()) {
            return;
        }
        this.f347257k.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<Boolean> list) {
        if (list == null || list.isEmpty() || list.get(0).booleanValue()) {
            return;
        }
        MiniGetPhoneNumberReporter.getInstance().changePhoneNumberClickReport();
    }

    private void P(Activity activity, AuthJsProxy.AuthDetailDialogResConfig authDetailDialogResConfig, final AuthorizationHintDialog authorizationHintDialog) {
        authorizationHintDialog.setContentView(R.layout.fhi);
        ImageView imageView = (ImageView) authorizationHintDialog.findViewById(R.id.y0f);
        TextView textView = (TextView) authorizationHintDialog.findViewById(R.id.f1061467x);
        ListView listView = (ListView) authorizationHintDialog.findViewById(R.id.yvl);
        textView.setText(authDetailDialogResConfig.curSubMsg.example.title.get());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.proxyimpl.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizationHintDialog.this.dismiss();
            }
        });
        listView.setAdapter((ListAdapter) new g(activity, authDetailDialogResConfig.content));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(AuthorizationRequestDialog authorizationRequestDialog, boolean z16, boolean z17, PrivacyDetailInfo privacyDetailInfo) {
        WeakReference<Activity> weakReference;
        if (!z16 || !z17 || privacyDetailInfo == null || (weakReference = this.f347247a) == null || weakReference.get() == null) {
            return;
        }
        String qqStr = HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_sdk_more_privacy_title);
        String string = this.f347247a.get().getResources().getString(com.tencent.qqmini.sdk.R.string.mini_sdk_privacy_content, privacyDetailInfo.getPermissionName(), privacyDetailInfo.getPrivacyTitle(), HardCodeUtil.qqStr(com.tencent.qqmini.sdk.R.string.mini_sdk_privacy_link_complain));
        this.f347262p = privacyDetailInfo;
        authorizationRequestDialog.showHintDialog(this.f347247a.get(), qqStr, string);
    }
}
