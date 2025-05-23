package com.tencent.qcircle.weseevideo.model.template.movie;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MovieSegment extends TAVMovieSegment implements Comparable<MovieSegment> {
    private static final String TAG = "MovieSegment";
    private CMTime mEndingTime;
    private int mIndex;
    private CMTimeRange mOverlapTimeRange;
    private boolean mNeedCentered = true;
    private CMTime mCorrectStartTime = null;
    private CMTime mCorrectEndTime = null;
    private float mVolume = 0.0f;

    public CMTime getCorrectEndTime() {
        return this.mCorrectEndTime;
    }

    public CMTime getCorrectStartTime() {
        CMTime cMTime = this.mCorrectStartTime;
        if (cMTime == null) {
            return getTimeRange().getStart();
        }
        return cMTime;
    }

    public CMTimeRange getCorrectTimeRange() {
        CMTime add;
        CMTime cMTime = this.mCorrectStartTime;
        if (cMTime == null) {
            cMTime = this.mTimeRange.getStart();
        }
        CMTime cMTime2 = this.mCorrectEndTime;
        if (cMTime2 == null) {
            add = this.mTimeRange.getEnd();
        } else {
            add = cMTime2.add(this.mEndingTime);
        }
        return new CMTimeRange(cMTime, add.sub(cMTime));
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public List<TAVClip> getFullTavClips() {
        CMTime cMTime = this.mEndingTime;
        if (cMTime != null && cMTime.bigThan(CMTime.CMTimeZero)) {
            if (this.tavClips == null) {
                this.tavClips = new ArrayList();
            }
            this.tavClips.add(new TAVClip(new TAVEmptyResource(this.mEndingTime)));
        }
        return this.tavClips;
    }

    public int getIndex() {
        return this.mIndex;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public CMTime getMinOriginDuration() {
        TAVMovieTimeEffect tAVMovieTimeEffect;
        List<TAVMovieTimeEffect> separateSegmentByTimeEffects = separateSegmentByTimeEffects();
        if (separateSegmentByTimeEffects != null && !separateSegmentByTimeEffects.isEmpty() && (tAVMovieTimeEffect = separateSegmentByTimeEffects.get(separateSegmentByTimeEffects.size() - 1)) != null && tAVMovieTimeEffect.getSourceTimeRange() != null) {
            return tAVMovieTimeEffect.getSourceTimeRange().getEnd();
        }
        return CMTime.CMTimeZero;
    }

    public CMTimeRange getOverlapTimeRange() {
        return this.mOverlapTimeRange;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public CMTime getPlayDuration() {
        return CMTime.CMTimeZero;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public CMTime getSourceDuration() {
        CMTime cMTime = CMTime.CMTimeZero;
        List<TAVMovieTimeEffect> separateSegmentByTimeEffects = separateSegmentByTimeEffects();
        if (separateSegmentByTimeEffects != null && !separateSegmentByTimeEffects.isEmpty()) {
            Iterator<TAVMovieTimeEffect> it = separateSegmentByTimeEffects.iterator();
            while (it.hasNext()) {
                cMTime = cMTime.add(it.next().getSourceTimeRange().getDuration());
            }
        }
        return cMTime;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public List<TAVClip> getTavClips() {
        List<TAVClip> list = this.tavClips;
        if (list != null && !list.isEmpty()) {
            CMTimeRange cMTimeRange = this.mTimeRange;
            if (cMTimeRange != null) {
                CMTime start = cMTimeRange.getStart();
                if (start.bigThan(CMTime.CMTimeZero)) {
                    List<TAVClip> cloneTAVClips = CloneUtil.cloneTAVClips(this.tavClips);
                    if (cloneTAVClips != null) {
                        cloneTAVClips.add(0, new TAVClip(new TAVEmptyResource(start)));
                        return cloneTAVClips;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(0, new TAVClip(new TAVEmptyResource(start)));
                    return arrayList;
                }
            }
            return this.tavClips;
        }
        return this.tavClips;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public List<TAVClip> getUseTavClips() {
        return this.tavClips;
    }

    public float getVolume() {
        return this.mVolume;
    }

    boolean isNeedCentered() {
        return this.mNeedCentered;
    }

    public void release() {
        List<TAVMovieClip> list = this.tavMovieClips;
        if (list != null) {
            for (TAVMovieClip tAVMovieClip : list) {
                if (tAVMovieClip != null) {
                    tAVMovieClip.release();
                }
            }
        }
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public List<TAVMovieTimeEffect> separateSegmentByTimeEffects() {
        List<TAVMovieTimeEffect> noOverlapTimeEffects;
        List<TAVMovieTimeEffect> list = this.mTimeEffects;
        ArrayList arrayList = null;
        if (list != null && !list.isEmpty() && (noOverlapTimeEffects = TAVMovieTimeEffectUtil.getNoOverlapTimeEffects(CloneUtil.cloneMovieTimeEffects(this.mTimeEffects))) != null && !noOverlapTimeEffects.isEmpty()) {
            arrayList = new ArrayList();
            CMTime cMTime = CMTime.CMTimeZero;
            List<TAVMovieTimeEffect> list2 = this.mTimeEffects;
            if (list2 != null && !list2.isEmpty()) {
                cMTime = this.mTimeEffects.get(0).getTimeRange().getStart();
            }
            for (TAVMovieTimeEffect tAVMovieTimeEffect : noOverlapTimeEffects) {
                CMTime sub = tAVMovieTimeEffect.getTimeRange().getStart().sub(cMTime);
                if (sub.getTimeUs() > 0) {
                    TAVMovieTimeEffect tAVMovieTimeEffect2 = new TAVMovieTimeEffect();
                    tAVMovieTimeEffect2.setTimeRange(new CMTimeRange(cMTime, sub));
                    arrayList.add(tAVMovieTimeEffect2);
                }
                arrayList.add(tAVMovieTimeEffect);
                cMTime = tAVMovieTimeEffect.getTimeRange().getEnd();
            }
        }
        return arrayList;
    }

    public void setCorrectEndTime(CMTime cMTime) {
        this.mCorrectEndTime = cMTime;
    }

    public void setCorrectStartTime(CMTime cMTime) {
        this.mCorrectStartTime = cMTime;
    }

    public void setEndingTime(CMTime cMTime) {
        this.mEndingTime = cMTime;
    }

    public void setIndex(int i3) {
        this.mIndex = i3;
    }

    public void setNeedCentered(boolean z16) {
        this.mNeedCentered = z16;
    }

    public void setOverlapTimeRange(CMTimeRange cMTimeRange) {
        this.mOverlapTimeRange = cMTimeRange;
    }

    public void setVolume(float f16) {
        this.mVolume = f16;
    }

    public void updateMovieClips(List<TAVMovieClip> list, boolean z16) {
        this.mNeedCentered = z16;
        setTavMovieClips(list);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MovieSegment movieSegment) {
        if (getTimeRange().getStart().smallThan(movieSegment.getTimeRange().getStart())) {
            return -1;
        }
        return (!getTimeRange().getStart().equalsTo(movieSegment.getTimeRange().getStart()) && getTimeRange().getStart().bigThan(movieSegment.getTimeRange().getStart())) ? 1 : 0;
    }
}
