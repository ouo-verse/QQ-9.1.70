package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.commonModule.d;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType$AuthItem;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final String f154178f;

    /* renamed from: a, reason: collision with root package name */
    final DoraemonAPIManager f154179a;

    /* renamed from: b, reason: collision with root package name */
    final com.tencent.mobileqq.Doraemon.impl.commonModule.d f154180b;

    /* renamed from: c, reason: collision with root package name */
    protected com.tencent.mobileqq.Doraemon.a f154181c;

    /* renamed from: d, reason: collision with root package name */
    protected List<hp3.e> f154182d;

    /* renamed from: e, reason: collision with root package name */
    int f154183e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.open.appcommon.d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f154184d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f154185e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f154186f;

        a(String str, boolean z16, boolean z17) {
            this.f154184d = str;
            this.f154185e = z16;
            this.f154186f = z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (!this.f154184d.equals(bundle.getString("ssoAccount"))) {
                return;
            }
            int i16 = bundle.getInt("code");
            if (z16) {
                try {
                    SdkAuthorize$GetAuthApiListResponse mergeFrom = new SdkAuthorize$GetAuthApiListResponse().mergeFrom(bundle.getByteArray("data"));
                    int i17 = mergeFrom.ret.get();
                    String str = mergeFrom.f342210msg.get();
                    if (i17 != 0) {
                        DoraemonUtil.c(e.this.f154181c, i17, str);
                        return;
                    }
                    SdkAuthorize$AuthorizeResponse sdkAuthorize$AuthorizeResponse = mergeFrom.auth_response.get();
                    if (!com.tencent.mobileqq.Doraemon.ui.a.L && e.this.h(mergeFrom) && sdkAuthorize$AuthorizeResponse != null && sdkAuthorize$AuthorizeResponse.has()) {
                        d.c cVar = new d.c();
                        cVar.f154173a = sdkAuthorize$AuthorizeResponse.openid.get().toUpperCase();
                        cVar.f154174b = sdkAuthorize$AuthorizeResponse.access_token.get().toUpperCase();
                        cVar.f154175c = sdkAuthorize$AuthorizeResponse.pay_token.get().toUpperCase();
                        long j3 = sdkAuthorize$AuthorizeResponse.expires_in.get();
                        cVar.f154176d = j3;
                        cVar.f154177e = j3 + (System.currentTimeMillis() / 1000);
                        e.this.f154180b.k(cVar);
                        DoraemonUtil.e(e.this.f154181c, cVar.a());
                        return;
                    }
                    if (this.f154185e) {
                        e.this.g(this.f154186f, true);
                        return;
                    }
                    String str2 = "";
                    for (int i18 = 0; i18 < e.this.f154182d.size(); i18++) {
                        str2 = str2 + e.this.f154182d.get(i18).f405820b + "\n";
                    }
                    e.this.l(str2, this.f154186f);
                    return;
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(e.f154178f, 2, "parse auth info error: \n" + e16.getMessage());
                    }
                    DoraemonUtil.c(e.this.f154181c, -1, "parse auth info error");
                    return;
                }
            }
            DoraemonUtil.c(e.this.f154181c, i16, "get auth info failure");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f154188d;

        b(boolean z16) {
            this.f154188d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                e.this.f154179a.f();
                e.this.g(this.f154188d, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                e.this.f154179a.f();
                DoraemonUtil.d(e.this.f154181c, 4);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                e.this.f154179a.f();
                DoraemonUtil.d(e.this.f154181c, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.impl.commonModule.e$e, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C7080e implements com.tencent.open.appcommon.d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f154192d;

        C7080e(String str) {
            this.f154192d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) str);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            String string = bundle.getString("ssoAccount");
            if (QLog.isColorLevel()) {
                QLog.d(e.f154178f, 2, "-->doAuthorize-onReceive, ssoAccount: " + string + " | uin: " + this.f154192d + " isSuccess: " + z16);
            }
            if (!this.f154192d.equals(string)) {
                return;
            }
            int i16 = bundle.getInt("code");
            if (z16) {
                try {
                    SdkAuthorize$AuthorizeResponse mergeFrom = new SdkAuthorize$AuthorizeResponse().mergeFrom(bundle.getByteArray("data"));
                    int i17 = mergeFrom.ret.get();
                    String str = mergeFrom.f342206msg.get();
                    if (i17 != 0) {
                        DoraemonUtil.c(e.this.f154181c, i17, str);
                        return;
                    }
                    d.c cVar = new d.c();
                    cVar.f154173a = mergeFrom.openid.get().toUpperCase();
                    cVar.f154174b = mergeFrom.access_token.get().toUpperCase();
                    cVar.f154175c = mergeFrom.pay_token.get().toUpperCase();
                    cVar.f154176d = mergeFrom.expires_in.get();
                    cVar.f154177e = mergeFrom.expires_in.get() + (System.currentTimeMillis() / 1000);
                    String str2 = mergeFrom.callbackURL.get();
                    QLog.isColorLevel();
                    e.this.j(str2);
                    e.this.f154180b.k(cVar);
                    DoraemonUtil.e(e.this.f154181c, cVar.a());
                    return;
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(e.f154178f, 2, "parse do auth result error: \n" + e16.getMessage());
                    }
                    DoraemonUtil.c(e.this.f154181c, -2, "parse do auth result error");
                    return;
                }
            }
            DoraemonUtil.c(e.this.f154181c, i16, "do auth error");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f154178f = "DoraemonOpenAPI." + e.class.getSimpleName();
    }

    public e(DoraemonAPIManager doraemonAPIManager, com.tencent.mobileqq.Doraemon.impl.commonModule.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) doraemonAPIManager, (Object) dVar);
            return;
        }
        this.f154183e = 0;
        this.f154179a = doraemonAPIManager;
        this.f154180b = dVar;
        this.f154182d = new ArrayList();
    }

    private String e(AppRuntime appRuntime, String str, String str2, String str3) {
        String str4;
        String str5;
        StringBuilder sb5 = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("app_id", this.f154179a.f154071c);
        linkedHashMap.put("uin", appRuntime.getAccount());
        linkedHashMap.put("sdkp", "a");
        linkedHashMap.put(CommonConstant.ReqAccessTokenParam.RESPONSE_TYPE, "token");
        com.tencent.mobileqq.miniapp.d k3 = this.f154179a.k();
        if (k3 == null) {
            str4 = "";
        } else {
            str4 = k3.f246795d;
        }
        linkedHashMap.put("app_name", str4);
        linkedHashMap.put("kSSOLoginTypeKey", "1");
        linkedHashMap.put("scope", "get_user_info,get_simple_userinfo,add_share,get_info,server_side");
        if (k3 == null) {
            str5 = "";
        } else {
            str5 = k3.f246809r;
        }
        linkedHashMap.put("bundleid", str5);
        linkedHashMap.put("skey", str);
        linkedHashMap.put("state", str3);
        linkedHashMap.put(CommonConstant.ReqAccessTokenParam.REDIRECT_URI, str2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str6 = (String) entry.getValue();
            if (str6 == null) {
                str6 = "";
            }
            sb5.append(((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(str6) + ContainerUtils.FIELD_DELIMITER);
        }
        int length = sb5.length();
        if (length > 0) {
            sb5.delete(length - 1, length);
        }
        return sb5.toString();
    }

    private String f(AppRuntime appRuntime, String str) {
        String str2;
        String str3;
        StringBuilder sb5 = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("app_id", this.f154179a.f154071c);
        linkedHashMap.put("uin", appRuntime.getAccount());
        linkedHashMap.put("sdkp", "android");
        linkedHashMap.put(CommonConstant.ReqAccessTokenParam.RESPONSE_TYPE, "token");
        com.tencent.mobileqq.miniapp.d k3 = this.f154179a.k();
        if (k3 == null) {
            str2 = "";
        } else {
            str2 = k3.f246795d;
        }
        linkedHashMap.put("app_name", str2);
        linkedHashMap.put("kSSOLoginTypeKey", "1");
        linkedHashMap.put("scope", "all,server_side");
        if (k3 == null) {
            str3 = "";
        } else {
            str3 = k3.f246809r;
        }
        linkedHashMap.put("bundleid", str3);
        linkedHashMap.put("skey", str);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str4 = (String) entry.getValue();
            if (str4 == null) {
                str4 = "";
            }
            sb5.append(((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(str4) + ContainerUtils.FIELD_DELIMITER);
        }
        int length = sb5.length();
        if (length > 0) {
            sb5.delete(length - 1, length);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16, boolean z17) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i(f154178f, 2, "doAuthorize");
        }
        long parseLong = Long.parseLong(this.f154179a.f154071c);
        SdkAuthorize$AuthorizeRequest sdkAuthorize$AuthorizeRequest = new SdkAuthorize$AuthorizeRequest();
        sdkAuthorize$AuthorizeRequest.client_id.set(parseLong);
        sdkAuthorize$AuthorizeRequest.need_pay.set(1);
        for (hp3.e eVar : this.f154182d) {
            if (eVar.f405819a > 0) {
                sdkAuthorize$AuthorizeRequest.openapi.add(Integer.valueOf(eVar.f405824f));
            }
        }
        sdkAuthorize$AuthorizeRequest.f342204os.set(Build.VERSION.RELEASE + "|android os|" + DeviceInfoMonitor.getModel());
        sdkAuthorize$AuthorizeRequest.qqv.set(com.tencent.open.adapter.a.f().n());
        sdkAuthorize$AuthorizeRequest.f342205pf.set("openmobile_android");
        sdkAuthorize$AuthorizeRequest.sdkp.set(DoraemonUtil.b(this.f154179a.f154070b));
        sdkAuthorize$AuthorizeRequest.sdkv.set("1.5.9");
        sdkAuthorize$AuthorizeRequest.response_type.set("token");
        DoraemonAPIManager doraemonAPIManager = this.f154179a;
        if (doraemonAPIManager instanceof com.tencent.mobileqq.Doraemon.impl.a) {
            String A = ((com.tencent.mobileqq.Doraemon.impl.a) doraemonAPIManager).A();
            if (!TextUtils.isEmpty(A)) {
                sdkAuthorize$AuthorizeRequest.appUniqueIdentifier.set(A);
            }
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String account = runtime.getAccount();
        sdkAuthorize$AuthorizeRequest.skey.set("");
        DoraemonAPIManager doraemonAPIManager2 = this.f154179a;
        if (doraemonAPIManager2 instanceof com.tencent.mobileqq.Doraemon.impl.webview.a) {
            com.tencent.mobileqq.Doraemon.impl.webview.a aVar = (com.tencent.mobileqq.Doraemon.impl.webview.a) doraemonAPIManager2;
            if (aVar.f154213v) {
                sdkAuthorize$AuthorizeRequest.passData.set(e(runtime, "", aVar.f154215x, aVar.f154214w));
            }
        } else if (z16) {
            sdkAuthorize$AuthorizeRequest.passData.set(f(runtime, ""));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("login_type=");
        if (z17) {
            str = "1";
        } else {
            str = "0";
        }
        sb5.append(str);
        sdkAuthorize$AuthorizeRequest.url_encoded_data.set(sb5.toString());
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", account);
        newIntent.putExtra("data", sdkAuthorize$AuthorizeRequest.toByteArray());
        newIntent.putExtra("cmd", "ConnAuthSvr.sdk_auth_api");
        newIntent.setObserver(new C7080e(account));
        runtime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(SdkAuthorize$GetAuthApiListResponse sdkAuthorize$GetAuthApiListResponse) {
        boolean z16;
        this.f154182d.clear();
        for (appType$AuthItem apptype_authitem : sdkAuthorize$GetAuthApiListResponse.authorized_form_list.get()) {
            if (apptype_authitem.is_new.get() != 0) {
                hp3.e eVar = new hp3.e();
                eVar.f405823e = apptype_authitem.api_list.get();
                eVar.f405819a = apptype_authitem.default_flag.get();
                eVar.f405824f = apptype_authitem.f342466id.get();
                if (apptype_authitem.is_new.get() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                eVar.f405822d = z16;
                eVar.f405820b = apptype_authitem.title.get();
                this.f154182d.add(eVar);
            }
        }
        return this.f154182d.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        WebViewFragment currentWebViewFragment;
        if (QLog.isColorLevel()) {
            QLog.i(f154178f, 2, "openBrowserForRedirect: invoked.  url: " + str);
        }
        ComponentCallbacks2 j3 = this.f154179a.j();
        if (j3 != null && (this.f154179a instanceof com.tencent.mobileqq.Doraemon.impl.webview.a) && (j3 instanceof u) && (currentWebViewFragment = ((u) j3).getCurrentWebViewFragment()) != null) {
            currentWebViewFragment.getWebView().loadUrl(str);
        }
    }

    private void k(boolean z16, boolean z17) {
        long j3;
        if (QLog.isColorLevel()) {
            QLog.d(f154178f, 2, "-->queryAuthority");
        }
        SdkAuthorize$GetAuthApiListRequest sdkAuthorize$GetAuthApiListRequest = new SdkAuthorize$GetAuthApiListRequest();
        try {
            j3 = Long.parseLong(this.f154179a.f154071c);
        } catch (NumberFormatException unused) {
            j3 = 0;
        }
        sdkAuthorize$GetAuthApiListRequest.client_id.set(j3);
        sdkAuthorize$GetAuthApiListRequest.f342208os.set(Build.VERSION.RELEASE + "|android os|" + DeviceInfoMonitor.getModel());
        String n3 = com.tencent.open.adapter.a.f().n();
        PBStringField pBStringField = sdkAuthorize$GetAuthApiListRequest.qqv;
        if (n3 == null) {
            n3 = "";
        }
        pBStringField.set(n3);
        sdkAuthorize$GetAuthApiListRequest.f342209pf.set("openmobile_android");
        DoraemonAPIManager doraemonAPIManager = this.f154179a;
        String str = "all";
        if ((doraemonAPIManager instanceof com.tencent.mobileqq.Doraemon.impl.webview.a) && ((com.tencent.mobileqq.Doraemon.impl.webview.a) doraemonAPIManager).f154213v) {
            str = "all,server_side";
        }
        sdkAuthorize$GetAuthApiListRequest.scope.set(str);
        sdkAuthorize$GetAuthApiListRequest.sdkp.set(DoraemonUtil.b(this.f154179a.f154070b));
        sdkAuthorize$GetAuthApiListRequest.sdkv.set("1.5.9");
        sdkAuthorize$GetAuthApiListRequest.need_pay.set(1);
        DoraemonAPIManager doraemonAPIManager2 = this.f154179a;
        if (doraemonAPIManager2 instanceof com.tencent.mobileqq.Doraemon.impl.a) {
            String A = ((com.tencent.mobileqq.Doraemon.impl.a) doraemonAPIManager2).A();
            if (!TextUtils.isEmpty(A)) {
                sdkAuthorize$GetAuthApiListRequest.appUniqueIdentifier.set(A);
            }
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String account = runtime.getAccount();
        sdkAuthorize$GetAuthApiListRequest.skey.set("");
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), OpensdkServlet.class);
        newIntent.setWithouLogin(true);
        newIntent.putExtra("uin", account);
        newIntent.putExtra("data", sdkAuthorize$GetAuthApiListRequest.toByteArray());
        newIntent.putExtra("cmd", "ConnAuthSvr.get_auth_api_list");
        newIntent.setObserver(new a(account, z16, z17));
        runtime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z16) {
        String str2;
        com.tencent.mobileqq.miniapp.d k3 = this.f154179a.k();
        String str3 = null;
        if (k3 == null) {
            str2 = null;
        } else {
            str2 = k3.f246795d;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = BaseApplicationImpl.getApplication().getString(R.string.cpl);
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str)) {
            g(z16, false);
            return;
        }
        DoraemonAPIManager doraemonAPIManager = this.f154179a;
        if (k3 != null) {
            str3 = k3.f246796e;
        }
        doraemonAPIManager.u(str4, str3, BaseApplicationImpl.getApplication().getString(R.string.cpk, str4), str, BaseApplicationImpl.getApplication().getString(R.string.igh), new b(z16), BaseApplicationImpl.getApplication().getString(R.string.igj), new c(), new d());
    }

    public void i(JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, jSONObject, aVar, Boolean.valueOf(z16));
            return;
        }
        this.f154181c = aVar;
        if (this.f154183e != 0) {
            return;
        }
        if (jSONObject != null) {
            z17 = jSONObject.optBoolean("server_side");
        }
        k(z16, z17);
    }
}
