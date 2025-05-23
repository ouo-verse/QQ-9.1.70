package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownload;
import com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownloadAdapter;
import com.tencent.gdtad.api.halfscreen.IGdtHalfScreenDownloadAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e implements AdHalfScreenDownloadAdapter {
    @Override // com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownloadAdapter
    public AdError show(AdHalfScreenDownload.Params params) {
        if (params != null && params.isValid()) {
            try {
                ((IGdtHalfScreenDownloadAPI) QRoute.api(IGdtHalfScreenDownloadAPI.class)).start(params);
                return new AdError(0);
            } catch (Throwable unused) {
                GdtLog.e("GdtHalfScreenDownloadAdapter", "[show] params error");
                return new AdError(15);
            }
        }
        GdtLog.e("GdtHalfScreenDownloadAdapter", "[show] params error");
        return new AdError(4);
    }
}
