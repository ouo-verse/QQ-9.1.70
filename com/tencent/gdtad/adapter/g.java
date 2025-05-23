package com.tencent.gdtad.adapter;

import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.gdtad.views.image.GdtGifImageView;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class g implements AdImageViewAdapter {
    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter
    @Nullable
    public View buildImageView(@Nullable AdImageViewBuilder.Params params) {
        if (params == null || !params.isValid()) {
            return null;
        }
        URLImageView uRLImageView = new URLImageView(params.context.get());
        uRLImageView.setImageURL(params.url);
        return uRLImageView;
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter
    public void buildImageView(@Nullable AdImageViewBuilder.Params params, @Nullable View view) {
        if (view == null || params == null || !params.isValid() || !(view instanceof GdtGifImageView)) {
            return;
        }
        ((GdtGifImageView) view).updateUrl(params.url, params.listener);
    }
}
