package com.tencent.ad.tangram.image;

import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.image.AdImageViewBuilder;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdImageViewAdapter {

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface Callback {
        void onStopLoad(boolean z16);
    }

    @Nullable
    View buildImageView(AdImageViewBuilder.Params params);

    @Deprecated
    void buildImageView(AdImageViewBuilder.Params params, View view);
}
