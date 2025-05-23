package com.tencent.ad.tangram.triple;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.util.AdClickUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface AdTripleLinkAdapter {
    @Nullable
    AdError show(AdClickUtil.Params params, AdClickUtil.URLObject uRLObject);
}
