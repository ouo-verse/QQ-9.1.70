package com.tencent.tavmovie.resource;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.utils.CloneUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TAVMovieResource {
    protected CMTime duration;
    protected int errorStatus;
    protected CGSize naturalSize;
    protected CMTimeRange sourceTimeRange;
    protected TAVMovieResourceStatus status;
    protected TAVMovieTimeEffect timeEffect;
    protected List<TAVMovieTimeEffect> timeEffects;
    protected CMTimeRange timeRange;
    protected TAVResourceType type;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum TAVMovieResourceStatus {
        TAVMovieResourceStatusAvailable,
        TAVMovieResourceStatusError
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum TAVResourceType {
        TAVResourceTypeVideo,
        TAVResourceTypePhoto,
        TAVResourceTypeAudio,
        TAVResourceTypeiTunesAudio
    }

    @Override // 
    /* renamed from: clone */
    public abstract TAVMovieResource mo280clone();

    /* JADX INFO: Access modifiers changed from: protected */
    public void cloneFrom(@NonNull TAVMovieResource tAVMovieResource) {
        CMTimeRange cMTimeRange;
        CMTimeRange cMTimeRange2;
        CMTime cMTime;
        CMTimeRange cMTimeRange3 = tAVMovieResource.sourceTimeRange;
        CGSize cGSize = null;
        if (cMTimeRange3 != null) {
            cMTimeRange = cMTimeRange3.m260clone();
        } else {
            cMTimeRange = null;
        }
        this.sourceTimeRange = cMTimeRange;
        CMTimeRange cMTimeRange4 = tAVMovieResource.timeRange;
        if (cMTimeRange4 != null) {
            cMTimeRange2 = cMTimeRange4.m260clone();
        } else {
            cMTimeRange2 = null;
        }
        this.timeRange = cMTimeRange2;
        CMTime cMTime2 = tAVMovieResource.duration;
        if (cMTime2 != null) {
            cMTime = cMTime2.m259clone();
        } else {
            cMTime = null;
        }
        this.duration = cMTime;
        this.timeEffects = CloneUtil.cloneMovieTimeEffects(tAVMovieResource.timeEffects);
        this.type = tAVMovieResource.type;
        CGSize cGSize2 = tAVMovieResource.naturalSize;
        if (cGSize2 != null) {
            cGSize = cGSize2.m258clone();
        }
        this.naturalSize = cGSize;
        this.status = tAVMovieResource.status;
        this.errorStatus = tAVMovieResource.errorStatus;
    }

    public abstract TAVResource convertToResource();

    public abstract TAVMovieResource dataClone();

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public CMTime getDuration() {
        return this.duration;
    }

    public int getErrorStatus() {
        return this.errorStatus;
    }

    public CGSize getNaturalSize() {
        return this.naturalSize;
    }

    public CMTimeRange getSourceTimeRange() {
        return this.sourceTimeRange;
    }

    public TAVMovieResourceStatus getStatus() {
        return this.status;
    }

    public TAVMovieTimeEffect getTimeEffect() {
        return this.timeEffect;
    }

    public List<TAVMovieTimeEffect> getTimeEffects() {
        return this.timeEffects;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public TAVResourceType getType() {
        return this.type;
    }

    public void setDuration(CMTime cMTime) {
        this.duration = cMTime;
    }

    public void setErrorStatus(int i3) {
        this.errorStatus = i3;
    }

    public void setNaturalSize(CGSize cGSize) {
        this.naturalSize = cGSize;
    }

    public void setSourceTimeRange(@NonNull CMTimeRange cMTimeRange) {
        this.sourceTimeRange = cMTimeRange;
    }

    public void setStatus(TAVMovieResourceStatus tAVMovieResourceStatus) {
        this.status = tAVMovieResourceStatus;
    }

    public void setTimeEffect(TAVMovieTimeEffect tAVMovieTimeEffect) {
        this.timeEffect = tAVMovieTimeEffect;
    }

    public void setTimeEffects(List<TAVMovieTimeEffect> list) {
        this.timeEffects = list;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public void setType(TAVResourceType tAVResourceType) {
        this.type = tAVResourceType;
    }
}
