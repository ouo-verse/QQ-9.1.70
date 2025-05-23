package com.tencent.tavmovie.base;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TAVMovieSegment implements Serializable {
    private static final String TAG = "TAVMovieSegment";
    protected int layerIndex = -1;
    protected boolean mEditable;
    protected List<TAVSegmentImageEffect> mImageEffects;
    protected List<TAVMovieTimeEffect> mTimeEffects;
    protected CMTimeRange mTimeRange;
    protected List<TAVStickerLayerInfo.TAVStickerUserData> mUserDatas;
    protected List<TAVClip> tavClips;
    protected List<TAVMovieClip> tavMovieClips;

    public abstract List<TAVClip> getFullTavClips();

    public List<TAVSegmentImageEffect> getImageEffects() {
        return this.mImageEffects;
    }

    public int getLayerIndex() {
        return this.layerIndex;
    }

    public abstract CMTime getMinOriginDuration();

    public abstract CMTime getPlayDuration();

    public abstract CMTime getSourceDuration();

    public abstract List<TAVClip> getTavClips();

    public List<TAVMovieClip> getTavMovieClips() {
        return this.tavMovieClips;
    }

    public List<TAVMovieTimeEffect> getTimeEffects() {
        return this.mTimeEffects;
    }

    public CMTimeRange getTimeRange() {
        return this.mTimeRange;
    }

    public abstract List<TAVClip> getUseTavClips();

    public List<TAVStickerLayerInfo.TAVStickerUserData> getUserDatas() {
        return this.mUserDatas;
    }

    public boolean isEditable() {
        return this.mEditable;
    }

    public abstract List<TAVMovieTimeEffect> separateSegmentByTimeEffects();

    public void setEditable(boolean z16) {
        this.mEditable = z16;
    }

    public void setImageEffects(List<TAVSegmentImageEffect> list) {
        this.mImageEffects = list;
    }

    public void setLayerIndex(int i3) {
        this.layerIndex = i3;
    }

    public void setTavClips(List<TAVClip> list) {
        this.tavClips = list;
    }

    public void setTavMovieClips(List<TAVMovieClip> list) {
        this.tavMovieClips = list;
    }

    public void setTimeEffects(List<TAVMovieTimeEffect> list) {
        this.mTimeEffects = list;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.mTimeRange = cMTimeRange;
    }

    public void setUserDatas(List<TAVStickerLayerInfo.TAVStickerUserData> list) {
        this.mUserDatas = list;
    }
}
