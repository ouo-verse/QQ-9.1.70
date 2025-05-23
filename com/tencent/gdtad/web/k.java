package com.tencent.gdtad.web;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class k extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private ArrayList<h> f109793d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<CustomWebView> f109794e;

    public k() {
        GdtLog.d("GdtWebReportPlugin", " GdtWebReportPlugin ");
        j jVar = new j(this);
        GdtWebReportQQ gdtWebReportQQ = new GdtWebReportQQ(this);
        i iVar = new i(this);
        l lVar = new l(this);
        this.f109793d.add(jVar);
        this.f109793d.add(gdtWebReportQQ);
        this.f109793d.add(iVar);
        if (GdtLandingPageConfig.b().f()) {
            this.f109793d.add(new g(this));
        }
        this.f109793d.add(lVar);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String str) {
        super.callJs(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Activity getActivity() {
        Activity activity;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        if (activity instanceof BasePluginActivity) {
            return ((BasePluginActivity) BasePluginActivity.class.cast(activity)).getOutActivity();
        }
        return activity;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "GdtWebReportPlugin";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 2L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        String d16;
        if (QLog.isColorLevel()) {
            d16 = str;
        } else {
            d16 = s.d(str, new String[0]);
        }
        QLog.d("GdtWebReportPlugin", 4, " handleEvent url = " + d16 + "==type ==" + j3);
        for (int i3 = 0; i3 < this.f109793d.size(); i3++) {
            this.f109793d.get(i3).a(str, j3, map);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        return super.handleSchemaRequest(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        super.onActivityReady();
        GdtLog.d("GdtWebReportPlugin", " onActivityReady ");
        for (int i3 = 0; i3 < this.f109793d.size(); i3++) {
            this.f109793d.get(i3).b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        GdtLog.d("GdtWebReportPlugin", " onCreate ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        GdtLog.d("GdtWebReportPlugin", " onDestroy webviewGetPerformanceResult");
        for (int i3 = 0; i3 < this.f109793d.size(); i3++) {
            this.f109793d.get(i3).onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        this.f109794e = new WeakReference<>(customWebView);
        GdtLog.d("GdtWebReportPlugin", " onWebViewCreated ");
        for (int i3 = 0; i3 < this.f109793d.size(); i3++) {
            this.f109793d.get(i3).c(customWebView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WeakReference<CustomWebView> p() {
        return this.f109794e;
    }
}
