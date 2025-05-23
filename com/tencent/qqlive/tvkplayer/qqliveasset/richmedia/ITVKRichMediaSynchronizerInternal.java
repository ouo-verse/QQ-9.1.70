package com.tencent.qqlive.tvkplayer.qqliveasset.richmedia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKRichMediaSynchronizerInternal extends ITVKRichMediaSynchronizer {
    boolean activateRichMedia(@NonNull TVKNetVideoInfo tVKNetVideoInfo);

    void connectToPlayer(@NonNull ITVKTPPlayer iTVKTPPlayer);

    boolean isPrepared();

    void release();

    void reset();

    void setQQLiveAssetPlayerListener(@Nullable ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener);
}
