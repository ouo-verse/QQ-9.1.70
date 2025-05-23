package com.tencent.gdtad.basics.adbox;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.basics.motivevideo.report.b;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private j f108715a;

    /* renamed from: b, reason: collision with root package name */
    private g f108716b;

    public h(j jVar, g gVar) {
        GdtLog.d("GdtAdBoxPresenter", "GdtAdBoxPresenter() called with: view = [" + jVar + "], model = [" + gVar + "]");
        this.f108715a = jVar;
        this.f108716b = gVar;
        gVar.a(this);
    }

    public boolean a() {
        return false;
    }

    public void b(Activity activity, View view, b.a aVar, com.tencent.gdtad.basics.motivevideo.report.b bVar, GdtAdBoxData gdtAdBoxData) {
        String str;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        GdtHandler.Params params = new GdtHandler.Params();
        params.processId = 11;
        params.activity = new WeakReference<>(activity);
        Object tag = view.getTag(R.id.ljl);
        if (tag == null) {
            GdtLog.e("GdtAdBoxPresenter", "onClick() tag == null");
            return;
        }
        GdtAd gdtAd = (GdtAd) tag;
        StringBuffer stringBuffer = new StringBuffer("onClick()");
        stringBuffer.append(",url =");
        stringBuffer.append(gdtAd.info.dest_info.landing_page.get());
        params.f108486ad = gdtAd;
        params.reportForClick = true;
        params.appAutoDownload = true;
        Bundle bundle = new Bundle();
        if (gdtAdBoxData != null) {
            stringBuffer.append(",refId =");
            stringBuffer.append(gdtAdBoxData.getRefId());
            bundle.putString(LaunchParam.KEY_REF_ID, gdtAdBoxData.getRefId());
        }
        params.extra = bundle;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = params.f108486ad.info;
        if (adInfo != null && (reportInfo = adInfo.report_info) != null) {
            str = reportInfo.click_url.get();
            params.f108486ad.info.report_info.click_url.set(bVar.a(str, aVar));
        } else {
            str = null;
        }
        QLog.i("GdtAdBoxPresenter", 1, stringBuffer.toString());
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        if (!TextUtils.isEmpty(str)) {
            params.f108486ad.info.report_info.click_url.set(str);
        }
    }

    public void c() {
        GdtLog.d("GdtAdBoxPresenter", "onCreate() called");
        this.f108715a.L(this.f108716b);
    }

    public void f() {
        GdtLog.d("GdtAdBoxPresenter", "onResume() called");
    }

    public void d() {
    }

    public void e() {
    }
}
