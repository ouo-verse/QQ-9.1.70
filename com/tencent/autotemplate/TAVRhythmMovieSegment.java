package com.tencent.autotemplate;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
/* loaded from: classes3.dex */
public class TAVRhythmMovieSegment extends TAVMovieSegment implements Comparable<TAVRhythmMovieSegment> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RhythmMovieSegment";
    private CMTime mCorrectStartTime;
    private CMTime mEndingTime;
    private int mIndex;
    private boolean mNeedCentered;
    private CMTimeRange mOverlapTimeRange;
    private float mVolume;

    public TAVRhythmMovieSegment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mNeedCentered = true;
        this.mCorrectStartTime = null;
        this.mVolume = 0.0f;
    }

    public CMTime getCorrectStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CMTime) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        CMTime cMTime = this.mCorrectStartTime;
        if (cMTime == null) {
            return getTimeRange().getStart();
        }
        return cMTime;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public List<TAVClip> getFullTavClips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mIndex;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public CMTime getMinOriginDuration() {
        TAVMovieTimeEffect tAVMovieTimeEffect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (CMTime) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        List<TAVMovieTimeEffect> separateSegmentByTimeEffects = separateSegmentByTimeEffects();
        if (separateSegmentByTimeEffects != null && !separateSegmentByTimeEffects.isEmpty() && (tAVMovieTimeEffect = separateSegmentByTimeEffects.get(separateSegmentByTimeEffects.size() - 1)) != null && tAVMovieTimeEffect.getSourceTimeRange() != null) {
            return tAVMovieTimeEffect.getSourceTimeRange().getEnd();
        }
        return CMTime.CMTimeZero;
    }

    public CMTimeRange getOverlapTimeRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CMTimeRange) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mOverlapTimeRange;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public CMTime getPlayDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (CMTime) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return CMTime.CMTimeZero;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public CMTime getSourceDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (CMTime) iPatchRedirector.redirect((short) 20, (Object) this);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        List<TAVClip> list = this.tavClips;
        if (list != null && !list.isEmpty()) {
            CMTimeRange cMTimeRange = this.mTimeRange;
            if (cMTimeRange != null) {
                CMTime start = cMTimeRange.getStart();
                if (start.bigThan(CMTime.CMTimeZero)) {
                    List<TAVClip> cloneTAVClips = CloneUtil.cloneTAVClips(this.tavClips);
                    if (cloneTAVClips == null) {
                        cloneTAVClips = new ArrayList<>();
                    }
                    cloneTAVClips.add(0, new TAVClip(new TAVEmptyResource(start)));
                    return cloneTAVClips;
                }
            }
            return this.tavClips;
        }
        return this.tavClips;
    }

    @Override // com.tencent.tavmovie.base.TAVMovieSegment
    public List<TAVClip> getUseTavClips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.tavClips;
    }

    public float getVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.mVolume;
    }

    boolean isNeedCentered() {
        return this.mNeedCentered;
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
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

    public void setCorrectStartTime(CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cMTime);
        } else {
            this.mCorrectStartTime = cMTime;
        }
    }

    public void setEndingTime(CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) cMTime);
        } else {
            this.mEndingTime = cMTime;
        }
    }

    public void setIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mIndex = i3;
        }
    }

    public void setNeedCentered(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.mNeedCentered = z16;
        }
    }

    public void setOverlapTimeRange(CMTimeRange cMTimeRange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cMTimeRange);
        } else {
            this.mOverlapTimeRange = cMTimeRange;
        }
    }

    public void setVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.mVolume = f16;
        }
    }

    public void updateMovieClips(List<TAVMovieClip> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, list, Boolean.valueOf(z16));
        } else {
            this.mNeedCentered = z16;
            setTavMovieClips(list);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull TAVRhythmMovieSegment tAVRhythmMovieSegment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) tAVRhythmMovieSegment)).intValue();
        }
        if (getTimeRange().getStart().smallThan(tAVRhythmMovieSegment.getTimeRange().getStart())) {
            return -1;
        }
        return (!getTimeRange().getStart().equalsTo(tAVRhythmMovieSegment.getTimeRange().getStart()) && getTimeRange().getStart().bigThan(tAVRhythmMovieSegment.getTimeRange().getStart())) ? 1 : 0;
    }
}
