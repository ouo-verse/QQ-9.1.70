package com.tencent.qqlive.tvkplayer.qqliveasset.subtitle;

import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import com.tencent.thumbplayer.api.common.TPSubtitleData;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKSubtitleRenderer {
    @Nullable
    TPSubtitleData getCurrentSubtitleData();

    void render(@Nullable TPSubtitleData tPSubtitleData);

    void reset();

    void updateVideoView(ITVKVideoViewPrivate iTVKVideoViewPrivate);
}
