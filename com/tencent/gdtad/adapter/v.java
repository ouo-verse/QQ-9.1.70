package com.tencent.gdtad.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class v implements AdVideoCeilingAdapter {
    @Override // com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter
    @NonNull
    public AdError show(@Nullable AdVideoCeiling.Params params) {
        if (params != null && params.isValid() && (params.f61336ad instanceof GdtAd)) {
            GdtVideoCeilingData a16 = com.tencent.gdtad.util.q.a(params);
            if (a16 != null && a16.isValid()) {
                GdtVideoCeilingFragment.uh(params.activity.get(), a16, params.useVerticalTransitionBetweenActivities, params.extrasForIntent, null);
                return new AdError(0);
            }
            GdtLog.e("GdtVideoCeilingAdapter", "show error");
            return new AdError(4);
        }
        GdtLog.e("GdtVideoCeilingAdapter", "show error");
        return new AdError(4);
    }
}
