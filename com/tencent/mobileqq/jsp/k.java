package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.IdentificationFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.identification.EncryptContext;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.mobileqq.identification.UnusableAreaStrategy;
import com.tencent.mobileqq.identification.k;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.bm;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k extends WebViewPlugin implements k.a {
    static IPatchRedirector $redirector_;
    private String C;
    protected String D;
    protected String E;
    private String F;
    private String G;
    private EncryptContext H;
    private String I;
    private int J;
    protected AtomicBoolean K;
    private long L;
    private Dialog M;
    private String N;
    protected FaceConf P;

    /* renamed from: d, reason: collision with root package name */
    private Activity f238881d;

    /* renamed from: e, reason: collision with root package name */
    private int f238882e;

    /* renamed from: f, reason: collision with root package name */
    private int f238883f;

    /* renamed from: h, reason: collision with root package name */
    private String f238884h;

    /* renamed from: i, reason: collision with root package name */
    private String f238885i;

    /* renamed from: m, reason: collision with root package name */
    private String f238886m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.identification.c f238887d;

        a(com.tencent.mobileqq.identification.c cVar) {
            this.f238887d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void ipJudgeSuccess(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                k.this.t(this.f238887d);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            } else {
                ReportController.r(null, "dc00898", "", "", "0X800B0EB", "0X800B0EB", 0, 0, "", "", "", "");
                k.this.t(this.f238887d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f238889a;

        /* renamed from: b, reason: collision with root package name */
        String f238890b;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.K = new AtomicBoolean(false);
        }
    }

    private boolean A(Intent intent, int i3) {
        Bundle bundleExtra;
        if (i3 != -1 || intent == null || (bundleExtra = intent.getBundleExtra("data")) == null || bundleExtra.getInt("ret", 299) != 0) {
            return false;
        }
        return true;
    }

    private void C(int i3) {
        if ("loginVerify".equals(this.E) && i3 == -1) {
            new Bundle().putBoolean("key_login_verify_by_face", true);
            WebViewBridge.f().j(this.f238881d, "com.tencent.mobileqq.webAuxiliaryVerifySuccess", null);
        }
    }

    private void E() {
        try {
            JSONObject jSONObject = new JSONObject(this.N);
            this.f238882e = jSONObject.optInt("platformAppId", 0);
            this.L = jSONObject.optLong("nonce");
            this.f238883f = jSONObject.optInt("srcAppId", 0);
            this.f238884h = jSONObject.optString("srcOpenId", "");
            this.f238885i = jSONObject.optString("key", "");
            this.f238886m = jSONObject.optString("idNum", "");
            this.C = jSONObject.optString("name", "");
            this.J = jSONObject.optInt("serviceType", -1);
            this.F = jSONObject.optString("ticket", "");
            String optString = jSONObject.optString("encContext", "");
            this.G = optString;
            this.H = EncryptContext.mergeFromBase64String(optString);
            this.I = jSONObject.optString("uin", "");
            this.D = jSONObject.optString("callback", "");
        } catch (JSONException e16) {
            QLog.e("IdentificationApiPlugin", 1, "parseParams error : ", e16);
        }
    }

    private void F(Intent intent, int i3) {
        String str;
        StringBuilder sb5 = new StringBuilder("identificationPlugin invokeCallback intent=");
        if (intent == null) {
            str = "true";
        } else {
            str = "false";
        }
        sb5.append(str);
        if (intent != null && intent.hasExtra("data")) {
            sb5.append(" has_key_data=");
            sb5.append("true");
        }
        sb5.append(" resultCode=");
        sb5.append(i3);
        QLog.d("IdentificationApiPlugin", 2, sb5.toString());
        if (intent != null && intent.getBundleExtra("data") != null) {
            Bundle bundleExtra = intent.getBundleExtra("data");
            QLog.d("IdentificationApiPlugin", 1, "idKey : ", bundleExtra.getString("idKey", ""), " retValue : ", Integer.valueOf(bundleExtra.getInt("ret", -1)), " errorMsg : ", bundleExtra.getString("errMsg", ""));
        }
    }

    private void G() {
        Activity activity = this.f238881d;
        if (activity != null && !activity.isFinishing()) {
            try {
                if (this.M == null) {
                    this.M = DialogUtil.createWaitingDialog(this.f238881d, R.string.f159541sl);
                }
                this.M.show();
                return;
            } catch (Exception e16) {
                QLog.e("IdentificationApiPlugin", 1, "showLoadingView ", e16);
                return;
            }
        }
        QLog.e("IdentificationApiPlugin", 1, "showLoadingView activity is null or is finish");
    }

    private boolean q() {
        b v3 = v();
        if (v3.f238889a == 0) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", v3.f238889a);
            jSONObject.put("errMsg", v3.f238890b);
            p(jSONObject);
        } catch (JSONException e16) {
            QLog.e("IdentificationApiPlugin", 1, "context invalid, call js error : ", e16);
        }
        QQToast.makeText(this.f238881d, v3.f238890b, 0).show();
        return true;
    }

    private void r() {
        com.tencent.mobileqq.identification.c j3 = com.tencent.mobileqq.identification.c.j();
        j3.f(this.f238882e, this.I, this.E, new a(j3));
    }

    private void s() {
        Activity activity = this.f238881d;
        if (activity != null && !activity.isFinishing()) {
            try {
                Dialog dialog = this.M;
                if (dialog != null && dialog.isShowing()) {
                    this.M.dismiss();
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("IdentificationApiPlugin", 1, "dismissLoadingView ", e16);
                return;
            }
        }
        QLog.e("IdentificationApiPlugin", 1, "dismissLoadingView activity is null or activity is null");
    }

    private void u(Intent intent, int i3) {
        Activity activity = this.f238881d;
        if (activity != null && !activity.isFinishing()) {
            if (("studyModeIdentify".equals(this.E) && i3 == 0) || ("loginVerify".equals(this.E) && A(intent, i3))) {
                QLog.e("IdentificationApiPlugin", 1, "finishCurrentActivity activity finish");
                this.f238881d.setResult(i3);
                this.f238881d.finish();
                return;
            }
            return;
        }
        QLog.e("IdentificationApiPlugin", 1, "finishCurrentActivity activity is invalid");
    }

    private Activity w() {
        Activity a16 = this.mRuntime.a();
        while (a16 instanceof BasePluginActivity) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private void y() {
        WebViewPlugin.b bVar;
        FaceConf faceConf = new FaceConf();
        this.P = faceConf;
        faceConf.setAppId(this.f238883f);
        this.P.setPlatformAppId(this.f238882e);
        this.P.setNonce(this.L);
        this.P.setOpenId(this.f238884h);
        this.P.setKey(this.f238885i);
        this.P.setImei(QQDeviceInfo.getIMEI("0"));
        this.P.setQimei36(com.tencent.mobileqq.statistics.o.c());
        this.P.setIdNum(this.f238886m);
        this.P.setName(this.C);
        this.P.setServiceType(this.J);
        this.P.setTicket(this.F);
        this.P.setEncryptContext(this.H);
        this.P.setUin(this.I);
        this.P.setCallback(this.D);
        this.P.setMethod(this.E);
        if (TextUtils.isEmpty(this.P.getUin()) && (bVar = this.mRuntime) != null && bVar.c() != null) {
            this.P.setUin(this.mRuntime.c().getCurrentUin());
        }
    }

    private void z(Intent intent, int i3) {
        String str;
        if (!TextUtils.isEmpty(this.D)) {
            JSONObject jSONObject = new JSONObject();
            if (intent == null || !intent.hasExtra("allResults")) {
                str = "";
            } else {
                str = intent.getStringExtra("allResults");
                if (!TextUtils.isEmpty(str) && str.endsWith("|")) {
                    str = str.substring(0, str.length() - 1);
                }
            }
            if (QLog.isColorLevel()) {
                F(intent, i3);
            }
            try {
                String qqStr = HardCodeUtil.qqStr(R.string.f159511si);
                int i16 = 299;
                if (intent != null && intent.hasExtra("data")) {
                    Bundle bundleExtra = intent.getBundleExtra("data");
                    i16 = bundleExtra.getInt("ret", 299);
                    qqStr = bundleExtra.getString("errMsg", HardCodeUtil.qqStr(R.string.f159511si));
                    jSONObject.put("idKey", bundleExtra.getString("idKey"));
                } else if (i3 == 0) {
                    qqStr = com.tencent.mobileqq.identification.l.f237976h;
                    i16 = 201;
                }
                jSONObject.put("ret", i16);
                jSONObject.put("errMsg", qqStr);
                jSONObject.put("allResults", str);
                ReportController.o(null, "dc00898", "", "", "0X8009862", "0X8009862", 0, 0, this.J + "", "", this.f238883f + "", i16 + "");
                QLog.d("IdentificationApiPlugin", 1, "invokeCallback ret:" + i16 + " errMsg:" + qqStr + " allResults:" + str);
                callJs(this.D, jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("IdentificationApiPlugin", 1, e16, new Object[0]);
            }
        }
    }

    protected boolean B() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.N)) {
            QLog.e("IdentificationApiPlugin", 1, "requestLivenessDetection: empty FaceParam");
            return true;
        }
        E();
        if (this.f238882e != 0 && !TextUtils.isEmpty(this.f238885i)) {
            if (!this.E.equalsIgnoreCase("studyModeIdentify") && (i3 = this.f238883f) == 0) {
                QLog.e("IdentificationApiPlugin", 1, "params invalid,  appId : ", Integer.valueOf(i3));
                return true;
            }
            y();
            return false;
        }
        QLog.e("IdentificationApiPlugin", 1, "params invalid, platformAppId : ", Integer.valueOf(this.f238882e), " key : ", this.f238885i);
        return true;
    }

    protected void D(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent, i3);
            return;
        }
        this.K.set(false);
        s();
        z(intent, i3);
        if (A(intent, i3)) {
            C(i3);
        }
        u(intent, i3);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NonNull
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "identification";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (!"identification".equals(str2)) {
            QLog.e("IdentificationApiPlugin", 1, "handleJsRequest, pkgName not match, pkgName : ", str2);
            return false;
        }
        QLog.d("IdentificationApiPlugin", 1, "handleJsRequest, method : ", str3);
        if (!com.tencent.mobileqq.identification.l.f237973e.contains(str3)) {
            return false;
        }
        if (q()) {
            return true;
        }
        this.E = str3;
        this.N = strArr[0];
        if (B()) {
            QLog.e("IdentificationApiPlugin", 1, "handleJsRequest params is invalid");
            return true;
        }
        addOpenApiListenerIfNeeded(str3, jsBridgeListener);
        G();
        r();
        return true;
    }

    @Override // com.tencent.mobileqq.identification.k.a
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("IdentificationApiPlugin", 1, "startFaceVerify");
        this.K.set(true);
        if (com.tencent.mobileqq.identification.l.f237971c.contains(this.E)) {
            x(true);
        } else {
            s();
            x(false);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        super.onActivityResult(intent, b16, i3);
        if (b16 == 102) {
            QLog.d("IdentificationApiPlugin", 1, "onActivityResult REQ_IDENTIFICATION_GUIDE_PAGE, resultCode=" + i3 + ", method=" + this.E);
            D(intent, i3);
            return;
        }
        QLog.d("IdentificationApiPlugin", 1, "onActivityResult error result, requestCode=" + ((int) b16) + ", resultCode=" + i3 + ", method=" + this.E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
            this.f238881d = w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        Dialog dialog = this.M;
        if (dialog != null) {
            dialog.dismiss();
            this.M = null;
        }
    }

    protected void p(JSONObject jSONObject) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) jSONObject);
            return;
        }
        s();
        boolean z17 = false;
        if (!"loginVerify".equals(this.E) && !"changeSecureMobile".equals(this.E)) {
            callJs(this.D, jSONObject.toString());
            return;
        }
        if (jSONObject != null && jSONObject.has("errMsg") && this.f238881d != null) {
            QLog.d("IdentificationApiPlugin", 1, "jsonObject is ", jSONObject.toString(), " method is ", this.E);
            QQToast.makeText(this.f238881d, jSONObject.optString("errMsg"), 0).show();
            return;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "activity is null ? ";
        if (this.f238881d == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = " jsonObject is null ? ";
        if (jSONObject == null) {
            z17 = true;
        }
        objArr[3] = Boolean.valueOf(z17);
        QLog.e("IdentificationApiPlugin", 1, objArr);
    }

    protected void t(com.tencent.mobileqq.identification.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
            return;
        }
        com.tencent.mobileqq.identification.k a16 = cVar.a();
        if (a16 != null) {
            a16.a(this);
        }
        QLog.d("IdentificationApiPlugin", 1, "doFaceVerify");
        boolean z16 = a16 instanceof UnusableAreaStrategy;
        if (z16 || QCircleQualityReporter.KEY_ID.equals(this.E)) {
            s();
            if (z16) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ret", 219);
                    jSONObject.put("errMsg", com.tencent.mobileqq.identification.l.f237978j);
                    p(jSONObject);
                } catch (JSONException e16) {
                    QLog.e("IdentificationApiPlugin", 1, "RET_CODE_AREA_NOT_SUPPORT error : ", e16.getMessage());
                }
            }
        }
    }

    protected b v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        b bVar = new b();
        if (bm.b(this.f238881d)) {
            bVar.f238889a = 206;
            bVar.f238890b = com.tencent.mobileqq.identification.l.f237975g;
            QLog.e("IdentificationApiPlugin", 1, "current mode is in multi window");
            return bVar;
        }
        if (bm.c()) {
            bVar.f238889a = 204;
            bVar.f238890b = com.tencent.mobileqq.identification.l.f237974f;
            QLog.e("IdentificationApiPlugin", 1, "current mode is video chatting");
            return bVar;
        }
        if (this.K.get()) {
            bVar.f238889a = 212;
            bVar.f238890b = com.tencent.mobileqq.identification.l.f237977i;
            QLog.e("IdentificationApiPlugin", 1, "duplicate");
            return bVar;
        }
        bVar.f238889a = 0;
        return bVar;
    }

    protected void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        QLog.i("IdentificationApiPlugin", 1, "gotoIdentificationGuidePage skipGuidePage=" + z16);
        Intent intent = new Intent(this.f238881d, (Class<?>) IdentificationFragmentActivity.class);
        intent.putExtra("faceConf", this.P);
        intent.putExtra("skipIdentificationGuidePage", z16);
        startActivityForResult(intent, (byte) 102);
    }
}
