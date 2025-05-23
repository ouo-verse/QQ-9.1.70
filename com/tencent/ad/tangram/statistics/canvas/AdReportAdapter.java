package com.tencent.ad.tangram.statistics.canvas;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface AdReportAdapter {
    void downloadReport(Ad ad5, String str, int i3, boolean z16, AdAppBtnData adAppBtnData);

    @NonNull
    AdRefreshCallback getAdReportAdapter();

    void reportForCanvasDataBuildEnd(Context context, Ad ad5, long j3);

    void reportForCanvasDataBuildError(Context context, int i3, Ad ad5, String str);
}
