package com.tencent.ad.tangram.web;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.web.AdBrowser;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdBrowserAdapter {
    @Nullable
    AdError show(AdBrowser.Params params);

    @Nullable
    AdError showWithoutAd(AdBrowser.Params params);
}
