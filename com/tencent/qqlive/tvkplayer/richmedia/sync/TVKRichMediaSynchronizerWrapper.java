package com.tencent.qqlive.tvkplayer.richmedia.sync;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.richmedia.TVKRichMediaFeature;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaSynchronizerWrapper implements ITVKRichMediaSynchronizer {
    private final ITVKPrivateRichMediaSynchronizer mTVKRichMediaSynchronizerImpl;

    public TVKRichMediaSynchronizerWrapper(@NonNull ITVKPrivateRichMediaSynchronizer iTVKPrivateRichMediaSynchronizer) {
        this.mTVKRichMediaSynchronizerImpl = iTVKPrivateRichMediaSynchronizer;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void deselectAsync(@NonNull TVKRichMediaFeature tVKRichMediaFeature) throws IllegalStateException, IllegalArgumentException {
        if (tVKRichMediaFeature != null) {
            if (!tVKRichMediaFeature.isInternal()) {
                this.mTVKRichMediaSynchronizerImpl.deselectAsync(tVKRichMediaFeature);
                return;
            }
            throw new IllegalArgumentException("feature is internal");
        }
        throw new IllegalArgumentException("feature can not be null");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public List<TVKRichMediaFeature> getFeatureList() {
        return this.mTVKRichMediaSynchronizerImpl.getFeatureList();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void selectAsync(@NonNull TVKRichMediaFeature tVKRichMediaFeature) throws IllegalStateException, IllegalArgumentException {
        if (tVKRichMediaFeature != null) {
            if (!tVKRichMediaFeature.isInternal()) {
                this.mTVKRichMediaSynchronizerImpl.selectAsync(tVKRichMediaFeature);
                return;
            }
            throw new IllegalArgumentException("feature is internal");
        }
        throw new IllegalArgumentException("feature can not be null");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void setListener(@NonNull ITVKRichMediaSynchronizer.ITVKRichMediaSynchronizerListener iTVKRichMediaSynchronizerListener) {
        this.mTVKRichMediaSynchronizerImpl.setListener(iTVKRichMediaSynchronizerListener);
    }
}
