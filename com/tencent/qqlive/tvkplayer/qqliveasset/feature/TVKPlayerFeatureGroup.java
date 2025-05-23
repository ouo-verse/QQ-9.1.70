package com.tencent.qqlive.tvkplayer.qqliveasset.feature;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKLivePlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKVodPlayerFeature;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKPlayerFeatureGroup implements ITVKPlayerFeatureGroup {
    private final List<ITVKFeatureBase> mFeatureList;
    private final List<ITVKVodFeature> mVodFeatureList = new ArrayList();
    private final List<ITVKLiveFeature> mLiveFeatureList = new ArrayList();
    private final List<ITVKPlayerFeature> mVodPlayFeatureList = new ArrayList();
    private final List<ITVKPlayerFeature> mLivePlayFeatureList = new ArrayList();
    private final List<ITVKPlayerFeature> mVodFeatureRetryFeatureList = new ArrayList();
    private final List<ITVKPlayerFeature> mLiveFeatureRetryFeatureList = new ArrayList();
    private final List<ITVKPlayerFeature> mVodPlayerAndDecoderChooseFeatureList = new ArrayList();
    private final List<ITVKPlayerFeature> mLivePlayerAndDecoderChooseFeatureList = new ArrayList();

    public TVKPlayerFeatureGroup(@NonNull List<ITVKFeatureBase> list) {
        this.mFeatureList = new ArrayList(list);
        init();
    }

    private void addToFeatureList(ITVKFeatureBase iTVKFeatureBase) {
        if (iTVKFeatureBase instanceof ITVKVodFeature) {
            this.mVodFeatureList.add((ITVKVodFeature) iTVKFeatureBase);
        } else if (iTVKFeatureBase instanceof ITVKLiveFeature) {
            this.mLiveFeatureList.add((ITVKLiveFeature) iTVKFeatureBase);
        }
    }

    private void addToPlayerAndDecoderChooseStrategyFeatureList(ITVKPlayerFeature iTVKPlayerFeature) {
        if (iTVKPlayerFeature.getPlayerAndDecoderChoosePriority() != ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_DEFAULT) {
            if (iTVKPlayerFeature instanceof ITVKVodPlayerFeature) {
                this.mVodPlayerAndDecoderChooseFeatureList.add(iTVKPlayerFeature);
            } else {
                this.mLivePlayerAndDecoderChooseFeatureList.add(iTVKPlayerFeature);
            }
        }
    }

    private void addToPlayerFeatureList(ITVKPlayerFeature iTVKPlayerFeature) {
        if (iTVKPlayerFeature instanceof ITVKVodPlayerFeature) {
            this.mVodPlayFeatureList.add(iTVKPlayerFeature);
        } else if (iTVKPlayerFeature instanceof ITVKLivePlayerFeature) {
            this.mLivePlayFeatureList.add(iTVKPlayerFeature);
        }
    }

    private void addToRetryFeatureList(ITVKPlayerFeature iTVKPlayerFeature) {
        if (iTVKPlayerFeature.getRetryPriority() != ITVKPlayerFeature.FeatureRetryPriority.RETRY_NONE) {
            if (iTVKPlayerFeature instanceof ITVKVodPlayerFeature) {
                this.mVodFeatureRetryFeatureList.add(iTVKPlayerFeature);
            } else {
                this.mLiveFeatureRetryFeatureList.add(iTVKPlayerFeature);
            }
        }
    }

    private void init() {
        for (ITVKFeatureBase iTVKFeatureBase : this.mFeatureList) {
            addToFeatureList(iTVKFeatureBase);
            if (iTVKFeatureBase instanceof ITVKPlayerFeature) {
                ITVKPlayerFeature iTVKPlayerFeature = (ITVKPlayerFeature) iTVKFeatureBase;
                addToPlayerFeatureList(iTVKPlayerFeature);
                addToRetryFeatureList(iTVKPlayerFeature);
                addToPlayerAndDecoderChooseStrategyFeatureList(iTVKPlayerFeature);
            }
        }
        Comparator<ITVKPlayerFeature> comparator = new Comparator<ITVKPlayerFeature>() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureGroup.1
            @Override // java.util.Comparator
            public int compare(ITVKPlayerFeature iTVKPlayerFeature2, ITVKPlayerFeature iTVKPlayerFeature3) {
                return iTVKPlayerFeature2.getRetryPriority().ordinal() - iTVKPlayerFeature3.getRetryPriority().ordinal();
            }
        };
        Comparator<ITVKPlayerFeature> comparator2 = new Comparator<ITVKPlayerFeature>() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureGroup.2
            @Override // java.util.Comparator
            public int compare(ITVKPlayerFeature iTVKPlayerFeature2, ITVKPlayerFeature iTVKPlayerFeature3) {
                return iTVKPlayerFeature2.getPlayerAndDecoderChoosePriority().ordinal() - iTVKPlayerFeature3.getPlayerAndDecoderChoosePriority().ordinal();
            }
        };
        Collections.sort(this.mVodFeatureRetryFeatureList, comparator);
        Collections.sort(this.mLiveFeatureRetryFeatureList, comparator);
        Collections.sort(this.mVodPlayerAndDecoderChooseFeatureList, comparator2);
        Collections.sort(this.mLivePlayerAndDecoderChooseFeatureList, comparator2);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup
    public List<ITVKLiveFeature> getLiveFeatureList() {
        return this.mLiveFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup
    public List<ITVKPlayerFeature> getLivePlayerAndDecoderChooseFeatureList() {
        return this.mLivePlayerAndDecoderChooseFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup
    public List<ITVKPlayerFeature> getLivePlayerFeatureList() {
        return this.mLivePlayFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup
    public List<ITVKPlayerFeature> getLiveRetryFeatureList() {
        return this.mLiveFeatureRetryFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup
    public List<ITVKVodFeature> getVodFeatureList() {
        return this.mVodFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup
    public List<ITVKPlayerFeature> getVodPlayerAndDecoderChooseFeatureList() {
        return this.mVodPlayerAndDecoderChooseFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup
    public List<ITVKPlayerFeature> getVodPlayerFeatureList() {
        return this.mVodPlayFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup
    public List<ITVKPlayerFeature> getVodRetryFeatureList() {
        return this.mVodFeatureRetryFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup
    public synchronized void reset() {
        Iterator<ITVKFeatureBase> it = this.mFeatureList.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }
}
