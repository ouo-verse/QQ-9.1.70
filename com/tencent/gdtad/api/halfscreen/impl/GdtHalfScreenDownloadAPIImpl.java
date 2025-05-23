package com.tencent.gdtad.api.halfscreen.impl;

import com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownload;
import com.tencent.gdtad.api.halfscreen.GdtHalfScreenDownloadFragment;
import com.tencent.gdtad.api.halfscreen.IGdtHalfScreenDownloadAPI;

/* loaded from: classes6.dex */
public final class GdtHalfScreenDownloadAPIImpl implements IGdtHalfScreenDownloadAPI {
    @Override // com.tencent.gdtad.api.halfscreen.IGdtHalfScreenDownloadAPI
    public void start(AdHalfScreenDownload.Params params) {
        GdtHalfScreenDownloadFragment.uh(params);
    }
}
