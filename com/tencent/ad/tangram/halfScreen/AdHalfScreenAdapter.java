package com.tencent.ad.tangram.halfScreen;

import android.support.annotation.NonNull;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.halfScreen.AdHalfScreen;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdHalfScreenAdapter {
    @NonNull
    AdError showWithoutAd(AdHalfScreen.Params params);
}
