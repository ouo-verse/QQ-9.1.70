package com.tencent.gdtad.web;

import android.app.Activity;
import android.content.Intent;
import com.tencent.ad.tangram.statistics.AdReporterOfDeeplink;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class l implements h {

    /* renamed from: a, reason: collision with root package name */
    private k f109795a;

    public l(k kVar) {
        this.f109795a = kVar;
    }

    private AdClickUtil.Params d() {
        Activity activity;
        k kVar = this.f109795a;
        GdtHandler.Options options = null;
        if (kVar != null) {
            activity = kVar.getActivity();
        } else {
            activity = null;
        }
        if (activity == null) {
            GdtLog.i("GdtWebTripleLinkAction", "[generateParam] activity is null ");
            return null;
        }
        if (activity.getIntent() == null) {
            GdtLog.i("GdtWebTripleLinkAction", "[generateParam] intent is null");
            return null;
        }
        Intent intent = activity.getIntent();
        AdClickUtil.Params params = new AdClickUtil.Params();
        try {
        } catch (Throwable th5) {
            GdtLog.e("GdtWebTripleLinkAction", "[generateParam] ", th5);
        }
        if (!intent.hasExtra("key_options")) {
            return null;
        }
        options = (GdtHandler.Options) intent.getParcelableExtra("key_options");
        GdtHandler.fillClickUtilParamsFromOptions(options, params);
        params.activity = new WeakReference<>(activity);
        params.reportForClick = false;
        return params;
    }

    @Override // com.tencent.gdtad.web.h
    public boolean a(String str, long j3, Map<String, Object> map) {
        return false;
    }

    @Override // com.tencent.gdtad.web.h
    public void b() {
        GdtLog.i("GdtWebTripleLinkAction", "[onActivityReady] ");
        AdClickUtil.Params d16 = d();
        if (d16 != null && d16.isValid() && d16.f61334ad.isTripleLink()) {
            try {
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(BaseApplication.getContext(), new InitGdtContextParams());
            } catch (Throwable th5) {
                GdtLog.e("GdtWebTripleLinkAction", "[initGdtContext]", th5);
            }
            AdReporterOfDeeplink.report(d16, AdClickUtil.handleTripleLinkAfterWebViewLoaded(d16), false);
            return;
        }
        GdtLog.d("GdtWebTripleLinkAction", "[onActivityReady] params is null");
    }

    @Override // com.tencent.gdtad.web.h
    public void onDestroy() {
        GdtLog.i("GdtWebTripleLinkAction", "[onDestroy] ");
    }

    @Override // com.tencent.gdtad.web.h
    public void c(CustomWebView customWebView) {
    }
}
