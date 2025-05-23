package com.tencent.gdtad.views.carousel;

import android.support.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtCarouselCardData {
    private final String mImageUrl;
    private final String mText;
    private final int mVideoDurationMs;
    private final String mVideoUrl;

    public GdtCarouselCardData(@NonNull String str, @Nullable String str2, int i3, @Nullable String str3) {
        this.mImageUrl = str;
        this.mVideoUrl = str2;
        this.mVideoDurationMs = i3;
        this.mText = str3;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getText() {
        return this.mText;
    }

    public int getVideoDurationMs() {
        return this.mVideoDurationMs;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }
}
