package com.tencent.ad.tangram.videoceiling;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdVideoCeilingAdapter {
    @Nullable
    AdError show(AdVideoCeiling.Params params);
}
