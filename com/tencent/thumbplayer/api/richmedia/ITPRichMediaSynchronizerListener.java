package com.tencent.thumbplayer.api.richmedia;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;

/* loaded from: classes26.dex */
public interface ITPRichMediaSynchronizerListener {
    void onDeselectFeatureSuccess(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3);

    void onRichMediaError(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, TPError tPError);

    void onRichMediaFeatureData(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3, TPRichMediaData tPRichMediaData);

    void onRichMediaFeatureError(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3, TPError tPError);

    void onRichMediaInfo(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3, @Nullable TPOnInfoParam tPOnInfoParam);

    void onRichMediaPrepared(ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    void onSelectFeatureSuccess(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3);
}
