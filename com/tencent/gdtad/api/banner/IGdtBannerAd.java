package com.tencent.gdtad.api.banner;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.gdtad.api.IGdtAd;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IGdtBannerAd extends IGdtAd {
    void onDisplay();

    @Nullable
    GdtBannerView render(Context context, int i3, int i16);
}
