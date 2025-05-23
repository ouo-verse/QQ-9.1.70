package com.tencent.qqlive.tvkplayer.api.richmedia.sync;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.richmedia.TVKRichMediaFeature;
import com.tencent.qqlive.tvkplayer.api.richmedia.response.TVKRichMediaFeatureData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKRichMediaSynchronizer {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKRichMediaSynchronizerListener {
        void onRichMediaDeselectSuccess(@NonNull TVKRichMediaFeature tVKRichMediaFeature);

        void onRichMediaError(int i3);

        void onRichMediaFeatureFailure(@NonNull TVKRichMediaFeature tVKRichMediaFeature, int i3);

        void onRichMediaInfo(int i3, @Nullable TVKRichMediaFeature tVKRichMediaFeature, TVKInfoData tVKInfoData);

        void onRichMediaResponse(@NonNull TVKRichMediaFeature tVKRichMediaFeature, TVKRichMediaFeatureData tVKRichMediaFeatureData);

        void onRichMediaSelectSuccess(@NonNull TVKRichMediaFeature tVKRichMediaFeature);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKInfoData {
        long arg1;
        long arg2;
        long arg3;
        Object object;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface TVKRichMediaInfoCode {
    }

    void deselectAsync(@NonNull TVKRichMediaFeature tVKRichMediaFeature) throws IllegalStateException, IllegalArgumentException;

    List<TVKRichMediaFeature> getFeatureList();

    void selectAsync(@NonNull TVKRichMediaFeature tVKRichMediaFeature) throws IllegalStateException, IllegalArgumentException;

    void setListener(ITVKRichMediaSynchronizerListener iTVKRichMediaSynchronizerListener);
}
