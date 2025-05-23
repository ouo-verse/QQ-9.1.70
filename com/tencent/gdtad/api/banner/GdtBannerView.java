package com.tencent.gdtad.api.banner;

import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.api.GdtAdView;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface GdtBannerView extends GdtAdView {
    @Nullable
    AdAntiSpamForClick getAntiSpamForClick();

    @Nullable
    View getOptionsView();

    void setSize(int i3, int i16);
}
