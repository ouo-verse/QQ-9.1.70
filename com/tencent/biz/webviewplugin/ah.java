package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.jsp.an;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ah extends VasWebviewJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    public String f97541d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f97542e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f97543f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f97544h = "";

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.webviewplugin.n f97545d;

        a(com.tencent.mobileqq.webviewplugin.n nVar) {
            this.f97545d = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v21 */
        /* JADX WARN: Type inference failed for: r10v22 */
        /* JADX WARN: Type inference failed for: r10v8, types: [int] */
        /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.StringBuilder] */
        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            if (QLog.isColorLevel()) {
                QLog.d("ShareApiPlugin", 2, "onReceive, getUrlInfo, isSuccess=" + z16);
            }
            Bundle bundle2 = new Bundle();
            if (z16) {
                if (TextUtils.isEmpty(ah.this.f97543f) || ah.this.f97543f.startsWith("http://") || ah.this.f97543f.startsWith("https://")) {
                    String string = bundle.getString("extra_summary");
                    if (!TextUtils.isEmpty(string)) {
                        ah.this.f97543f = string;
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareApiPlugin", 2, "Use share summary parsed by server");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("ShareApiPlugin", 2, "Server can't resolve summary");
                    }
                }
                if (TextUtils.isEmpty(ah.this.f97544h)) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("extra_images");
                    if (stringArrayList != null && stringArrayList.size() > 0) {
                        ah.this.f97544h = stringArrayList.get(0);
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareApiPlugin", 2, "Use share thumb parsed by server");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("ShareApiPlugin", 2, "Server can't resolve thumb");
                    }
                }
                if (TextUtils.isEmpty(ah.this.f97542e)) {
                    String string2 = bundle.getString("extra_title");
                    if (!TextUtils.isEmpty(string2)) {
                        ah.this.f97542e = string2;
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareApiPlugin", 2, "Use share title parsed by server");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("ShareApiPlugin", 2, "Server can't resolve title");
                    }
                }
                if (TextUtils.isEmpty(ah.this.f97541d)) {
                    String string3 = bundle.getString("extra_url");
                    if (!TextUtils.isEmpty(string3)) {
                        ah.this.f97541d = string3;
                        if (QLog.isColorLevel()) {
                            QLog.d("ShareApiPlugin", 2, "Use share url parsed by server");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("ShareApiPlugin", 2, "Server can't resolve url");
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("shareWebPage", 2, "Share info after QZone rich: title=" + ah.this.f97542e + ", summary=" + ah.this.f97543f + ", thumb=" + ah.this.f97544h + ", shareURL=" + ah.this.f97541d);
                }
                bundle2.putInt("extra_url_info_from", 5);
            } else {
                bundle2.putInt("extra_url_info_from", 3);
            }
            com.tencent.mobileqq.webviewplugin.n nVar = this.f97545d;
            ah ahVar = ah.this;
            nVar.setSummary(ahVar.f97542e, ahVar.f97543f, ahVar.f97541d, ahVar.f97544h, bundle2);
            boolean isEmpty = TextUtils.isEmpty(ah.this.f97544h);
            boolean z17 = isEmpty;
            if (TextUtils.isEmpty(ah.this.f97543f)) {
                z17 = (isEmpty ? 1 : 0) | 2;
            }
            ?? r102 = z17;
            if (TextUtils.isEmpty(ah.this.f97542e)) {
                r102 = (z17 ? 1 : 0) | 4;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
            bundle3.putString("act_type", "91");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            if (r102 == 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            sb5.append(i16);
            bundle3.putString("intext_1", sb5.toString());
            bundle3.putString("intext_2", "" + r102);
            bundle3.putString("stringext_1", "" + ah.this.f97541d);
            ReportCenter.f().l(bundle3, "", ah.this.mRuntime.b().getAccount(), false);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "share";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v40, types: [int] */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v50 */
    /* JADX WARN: Type inference failed for: r12v51 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.StringBuilder] */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        int i3;
        if (str2 == null || !"share".equals(str2)) {
            return false;
        }
        if (str3 != null && "setShare".equals(str3) && strArr.length == 1) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                if ("share".equals(jSONObject.optString("type"))) {
                    this.f97544h = jSONObject.optString("image");
                    this.f97542e = jSONObject.optString("title");
                    this.f97543f = jSONObject.optString("summary");
                    this.f97541d = jSONObject.optString("shareURL");
                    if (QLog.isColorLevel()) {
                        QLog.e("shareWebPage", 2, "Share info after JS capture: title=" + this.f97542e + ", summary=" + this.f97543f + ", thumb=" + this.f97544h + ", shareURL=" + this.f97541d);
                    }
                    boolean isEmpty = TextUtils.isEmpty(this.f97544h);
                    boolean z16 = isEmpty;
                    if (TextUtils.isEmpty(this.f97543f)) {
                        z16 = (isEmpty ? 1 : 0) | 2;
                    }
                    ?? r122 = z16;
                    if (TextUtils.isEmpty(this.f97542e)) {
                        r122 = (z16 ? 1 : 0) | 4;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                    bundle.putString("act_type", "90");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    if (r122 == 0) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    sb5.append(i3);
                    bundle.putString("intext_1", sb5.toString());
                    bundle.putString("intext_2", "" + r122);
                    bundle.putString("stringext_1", "" + this.f97541d);
                    ReportCenter.f().l(bundle, "", this.mRuntime.b().getAccount(), false);
                }
                WebViewPlugin.b bVar = this.mRuntime;
                com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) getBrowserComponent(4);
                if (swiftBrowserShareMenuHandler != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.n)) {
                    com.tencent.mobileqq.webviewplugin.n nVar = (com.tencent.mobileqq.webviewplugin.n) d16;
                    Share share = (Share) nVar.getShare();
                    if (share != null) {
                        if (share.W == null) {
                            share.W = this.mRuntime.e();
                            QLog.w("ShareApiPlugin", 2, "webview from runtime is null");
                        }
                        if (swiftBrowserShareMenuHandler.z(share.getShareUrl())) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ShareApiPlugin", 2, "is not need load share js");
                            }
                        } else {
                            if (!TextUtils.isEmpty(this.f97543f) && !TextUtils.isEmpty(this.f97542e) && !TextUtils.isEmpty(this.f97544h) && !TextUtils.isEmpty(this.f97541d) && !this.f97543f.startsWith("http://") && !this.f97543f.startsWith("https://")) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt("extra_url_info_from", 3);
                                nVar.setSummary(this.f97542e, this.f97543f, this.f97541d, this.f97544h, bundle2);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ShareApiPlugin", 2, "Share info imperfect, request from svr");
                            }
                            NewIntent newIntent = new NewIntent(this.mRuntime.b().getApplication(), an.class);
                            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "SQQzoneSvc.getUrlInfo");
                            newIntent.putExtra("extra_current_uin", this.mRuntime.b().getAccount());
                            newIntent.putExtra("extra_url", share.getShareUrl());
                            newIntent.setObserver(new a(nVar));
                            this.mRuntime.b().startServlet(newIntent);
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareApiPlugin", 2, "exception =" + e16);
                }
            }
        }
        return true;
    }
}
