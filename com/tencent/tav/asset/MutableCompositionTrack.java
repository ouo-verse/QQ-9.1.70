package com.tencent.tav.asset;

import android.graphics.Matrix;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.ImageDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MutableCompositionTrack extends CompositionTrack {
    private String extendedLanguageTag;
    private String languageCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableCompositionTrack(int i3, int i16) {
        this.mediaType = i3;
        this.trackID = i16;
    }

    private int findSegmentIndexAt(CMTime cMTime, boolean z16) {
        boolean z17;
        CMTime cMTime2 = CMTime.CMTimeZero;
        Iterator<CompositionTrackSegment> it = ((CompositionTrack) this).segments.iterator();
        boolean z18 = false;
        int i3 = 0;
        while (true) {
            z17 = true;
            if (!it.hasNext()) {
                break;
            }
            CompositionTrackSegment next = it.next();
            if (next.timeRange.containsTime(cMTime)) {
                z18 = true;
                break;
            }
            cMTime2 = next.timeRange.getEnd();
            i3++;
        }
        if (!z18 && cMTime.equalsTo(cMTime2) && i3 > 0 && z16) {
            i3--;
        } else {
            z17 = z18;
        }
        if (!z17) {
            return -1;
        }
        return i3;
    }

    private CMTime getSegmentStartCMTime(int i3) {
        CMTime cMTime = CMTime.CMTimeZero;
        for (int i16 = 0; i16 < i3 && i16 < ((CompositionTrack) this).segments.size(); i16++) {
            cMTime = cMTime.add(((CompositionTrack) this).segments.get(i16).getScaleDuration());
        }
        return cMTime;
    }

    private long getSegmentStartTime(int i3) {
        CMTime cMTime = CMTime.CMTimeZero;
        for (int i16 = 0; i16 < i3 && i16 < ((CompositionTrack) this).segments.size(); i16++) {
            cMTime = cMTime.add(((CompositionTrack) this).segments.get(i16).getScaleDuration());
        }
        return cMTime.getTimeUs();
    }

    private void insertSegment(CompositionTrackSegment compositionTrackSegment, int i3) {
        if (i3 >= 0) {
            ((CompositionTrack) this).segments.add(i3, compositionTrackSegment);
        } else {
            ((CompositionTrack) this).segments.add(compositionTrackSegment);
        }
        updateTimeRange();
    }

    private CompositionTrackSegment[] split(CompositionTrackSegment compositionTrackSegment, CMTime cMTime) {
        if (compositionTrackSegment != null && !compositionTrackSegment.timeRange.getDuration().smallThan(cMTime)) {
            float timeUs = (((float) cMTime.getTimeUs()) * 1.0f) / ((float) compositionTrackSegment.timeRange.getDurationUs());
            CMTimeRange[] split = compositionTrackSegment.getTimeMapping().getTarget().split(timeUs);
            CMTimeRange[] split2 = compositionTrackSegment.getTimeMapping().getSource().split(timeUs);
            if (split != null && split2 != null) {
                CompositionTrackSegment compositionTrackSegment2 = new CompositionTrackSegment(compositionTrackSegment.getSourcePath(), compositionTrackSegment.getSourceTrackID(), split2[0], split[0], compositionTrackSegment.getSourceType());
                compositionTrackSegment2.setExtraInfo(compositionTrackSegment.getExtraInfo());
                CompositionTrackSegment compositionTrackSegment3 = new CompositionTrackSegment(compositionTrackSegment.getSourcePath(), compositionTrackSegment.getSourceTrackID(), split2[1], split[1], compositionTrackSegment.getSourceType());
                compositionTrackSegment3.setExtraInfo(compositionTrackSegment.getExtraInfo());
                compositionTrackSegment2.scaleDuration = cMTime;
                compositionTrackSegment3.scaleDuration = compositionTrackSegment.scaleDuration.sub(cMTime);
                return new CompositionTrackSegment[]{compositionTrackSegment2, compositionTrackSegment3};
            }
            return null;
        }
        return null;
    }

    private void updateSegmentStartTimeAfterInserted(CMTime cMTime, CMTimeRange cMTimeRange) {
        int findSegmentIndexAt = findSegmentIndexAt(cMTime, false);
        if (findSegmentIndexAt < 0 || findSegmentIndexAt >= ((CompositionTrack) this).segments.size()) {
            return;
        }
        while (true) {
            findSegmentIndexAt++;
            if (findSegmentIndexAt < ((CompositionTrack) this).segments.size()) {
                CompositionTrackSegment compositionTrackSegment = ((CompositionTrack) this).segments.get(findSegmentIndexAt);
                CMTimeRange target = compositionTrackSegment.getTimeMapping().getTarget();
                compositionTrackSegment.updateTargetTimeRange(new CMTimeRange(target.getStart().add(cMTimeRange.getDuration()), target.getDuration().m259clone()));
            } else {
                return;
            }
        }
    }

    private void updateSegmentsStartTimeAfterRemoved(CMTimeRange cMTimeRange) {
        int findSegmentIndexAt = findSegmentIndexAt(cMTimeRange.getStart(), false);
        if (findSegmentIndexAt >= 0 && findSegmentIndexAt < ((CompositionTrack) this).segments.size()) {
            while (findSegmentIndexAt < ((CompositionTrack) this).segments.size()) {
                CompositionTrackSegment compositionTrackSegment = ((CompositionTrack) this).segments.get(findSegmentIndexAt);
                CMTimeRange target = compositionTrackSegment.getTimeMapping().getTarget();
                CMTime start = target.getStart();
                CMTime duration = cMTimeRange.getDuration();
                CMTime cMTime = CMTime.CMTimeOne;
                compositionTrackSegment.updateTargetTimeRange(new CMTimeRange(start.sub(duration.add(cMTime).add(cMTime)), target.getDuration().m259clone()));
                findSegmentIndexAt++;
            }
        }
    }

    private void updateTimeRange() {
        List<CompositionTrackSegment> list = ((CompositionTrack) this).segments;
        if (list != null && list.size() > 0) {
            this.timeRange = new CMTimeRange(((CompositionTrack) this).segments.get(0).timeRange.getStart(), getDuration());
        } else {
            CMTime cMTime = CMTime.CMTimeZero;
            this.timeRange = new CMTimeRange(cMTime, cMTime);
        }
    }

    public void clipRangeAndRemoveOutRange(CMTimeRange cMTimeRange) {
        List<CompositionTrackSegment> list;
        if (cMTimeRange != null && cMTimeRange.getDuration().getTimeUs() > 0 && (list = ((CompositionTrack) this).segments) != null && list.size() != 0) {
            CMTime start = cMTimeRange.getStart();
            CMTime end = cMTimeRange.getEnd();
            int findSegmentIndexAt = findSegmentIndexAt(start, false);
            if (findSegmentIndexAt == -1) {
                return;
            }
            int findSegmentIndexAt2 = findSegmentIndexAt(end, false);
            if (findSegmentIndexAt2 == -1) {
                findSegmentIndexAt2 = ((CompositionTrack) this).segments.size() - 1;
            } else if (getSegmentStartTime(findSegmentIndexAt2) == end.getTimeUs()) {
                findSegmentIndexAt2--;
            }
            long segmentStartTime = getSegmentStartTime(findSegmentIndexAt);
            long segmentStartTime2 = getSegmentStartTime(findSegmentIndexAt2);
            CompositionTrackSegment compositionTrackSegment = ((CompositionTrack) this).segments.get(findSegmentIndexAt);
            CompositionTrackSegment compositionTrackSegment2 = ((CompositionTrack) this).segments.get(findSegmentIndexAt2);
            long timeUs = cMTimeRange.getEnd().getTimeUs() - segmentStartTime2;
            compositionTrackSegment2.timeRange = new CMTimeRange(compositionTrackSegment2.timeRange.getStart(), TimeUtil.us2CMTime(((float) timeUs) * ((float) (compositionTrackSegment2.scaleDuration.getTimeUs() / compositionTrackSegment2.timeRange.getDuration().getTimeUs()))));
            compositionTrackSegment2.scaleDuration = TimeUtil.us2CMTime(timeUs);
            float timeUs2 = (float) (compositionTrackSegment.scaleDuration.getTimeUs() / compositionTrackSegment.timeRange.getDuration().getTimeUs());
            long timeUs3 = cMTimeRange.getStart().getTimeUs() - segmentStartTime;
            long j3 = ((float) timeUs3) * timeUs2;
            compositionTrackSegment.timeRange = new CMTimeRange(TimeUtil.us2CMTime(compositionTrackSegment.timeRange.getStart().getTimeUs() + j3), TimeUtil.us2CMTime(compositionTrackSegment.timeRange.getDuration().getTimeUs() - j3));
            compositionTrackSegment.scaleDuration = TimeUtil.us2CMTime(compositionTrackSegment.scaleDuration.getTimeUs() - timeUs3);
            for (int size = ((CompositionTrack) this).segments.size() - 1; size >= 0; size--) {
                if (size > findSegmentIndexAt2 || size < findSegmentIndexAt) {
                    ((CompositionTrack) this).segments.remove(size);
                }
            }
        }
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public CMTime getDuration() {
        CMTime cMTime = CMTime.CMTimeZero;
        for (int i3 = 0; i3 < ((CompositionTrack) this).segments.size(); i3++) {
            cMTime = cMTime.add(((CompositionTrack) this).segments.get(i3).getScaleDuration());
        }
        return cMTime;
    }

    public String getExtendedLanguageTag() {
        return this.extendedLanguageTag;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void insertCompositionTrackSegment(@NonNull CompositionTrackSegment compositionTrackSegment) {
        CGSize cGSize = this.naturalSize;
        if ((cGSize == null || cGSize.equals(CGSize.CGSizeZero)) && compositionTrackSegment.getSourceType() == 3 && !TextUtils.isEmpty(compositionTrackSegment.getSourcePath())) {
            this.naturalSize = ImageDecoder.getDefaultOutputImageSize(compositionTrackSegment.getSourcePath());
        }
        CMTimeRange target = compositionTrackSegment.timeMapping.getTarget();
        CMTime start = target.getStart();
        if (((CompositionTrack) this).segments.size() == 0) {
            if (target.getStart().value > 0) {
                ((CompositionTrack) this).segments.add(new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, target.getStart())));
            }
            insertSegment(compositionTrackSegment, -1);
            return;
        }
        int findSegmentIndexAt = findSegmentIndexAt(start, false);
        if (findSegmentIndexAt != -1) {
            CMTime segmentStartCMTime = getSegmentStartCMTime(findSegmentIndexAt);
            if (start.equalsTo(segmentStartCMTime)) {
                insertSegment(compositionTrackSegment, findSegmentIndexAt);
            } else {
                CompositionTrackSegment[] split = split(((CompositionTrack) this).segments.remove(findSegmentIndexAt), start.sub(segmentStartCMTime));
                if (split[1].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split[1]);
                }
                insertSegment(compositionTrackSegment, findSegmentIndexAt);
                if (split[0].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split[0]);
                }
            }
        } else {
            CMTime segmentStartCMTime2 = getSegmentStartCMTime(((CompositionTrack) this).segments.size());
            if (start.bigThan(segmentStartCMTime2)) {
                ((CompositionTrack) this).segments.add(new CompositionTrackSegment(new CMTimeRange(segmentStartCMTime2, start.sub(segmentStartCMTime2))));
            }
            insertSegment(compositionTrackSegment, -1);
        }
        CMTime cMTime = CMTime.CMTimeZero;
        for (CompositionTrackSegment compositionTrackSegment2 : ((CompositionTrack) this).segments) {
            compositionTrackSegment2.updateTargetTimeRange(new CMTimeRange(cMTime, compositionTrackSegment2.scaleDuration));
            cMTime = cMTime.add(compositionTrackSegment2.scaleDuration);
        }
        updateTimeRange();
    }

    public void insertEmptyTimeRange(CMTimeRange cMTimeRange) {
        insertTimeRange(cMTimeRange, null, cMTimeRange.getStart());
    }

    public boolean insertTimeRange(CMTimeRange cMTimeRange, AssetTrack assetTrack, CMTime cMTime) {
        if (this.timeRange == null) {
            CMTime cMTime2 = CMTime.CMTimeZero;
            this.timeRange = new CMTimeRange(cMTime2, cMTime2);
        }
        CGSize cGSize = this.naturalSize;
        if ((cGSize == null || cGSize.equals(CGSize.CGSizeZero)) && assetTrack != null) {
            this.naturalSize = assetTrack.naturalSize;
        }
        if (this.preferredRotation == 0 && assetTrack != null) {
            this.preferredRotation = assetTrack.preferredRotation;
        }
        if (cMTime == CMTime.CMTimeInvalid || cMTime.getValue() < 0) {
            insertTimeRange(cMTimeRange, new CMTimeRange(this.timeRange.getDuration(), cMTimeRange.getDuration()), assetTrack, -1);
            return true;
        }
        if (cMTimeRange.getDuration().value <= 0) {
            return false;
        }
        CMTimeRange cMTimeRange2 = new CMTimeRange(cMTime, cMTimeRange.getDuration());
        if (((CompositionTrack) this).segments.size() == 0) {
            if (cMTime.value > 0) {
                ((CompositionTrack) this).segments.add(new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, cMTime)));
            }
            insertTimeRange(cMTimeRange, cMTimeRange2, assetTrack, -1);
            return true;
        }
        int findSegmentIndexAt = findSegmentIndexAt(cMTime, false);
        if (findSegmentIndexAt != -1) {
            CMTime segmentStartCMTime = getSegmentStartCMTime(findSegmentIndexAt);
            if (cMTime.equalsTo(segmentStartCMTime)) {
                insertTimeRange(cMTimeRange, cMTimeRange2, assetTrack, findSegmentIndexAt);
            } else {
                CompositionTrackSegment[] split = split(((CompositionTrack) this).segments.remove(findSegmentIndexAt), cMTime.sub(segmentStartCMTime));
                if (split[1].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split[1]);
                }
                insertTimeRange(cMTimeRange, cMTimeRange, assetTrack, findSegmentIndexAt);
                if (split[0].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split[0]);
                }
            }
        } else {
            CMTime segmentStartCMTime2 = getSegmentStartCMTime(((CompositionTrack) this).segments.size());
            if (cMTime.bigThan(segmentStartCMTime2)) {
                ((CompositionTrack) this).segments.add(new CompositionTrackSegment(new CMTimeRange(segmentStartCMTime2, cMTime.sub(segmentStartCMTime2))));
            }
            insertTimeRange(cMTimeRange, cMTimeRange2, assetTrack, -1);
        }
        updateTimeRange();
        return true;
    }

    public void removeTimeRange(CMTimeRange cMTimeRange) {
        if (cMTimeRange != null && cMTimeRange.isLegal()) {
            CMTime start = cMTimeRange.getStart();
            CMTime cMTime = CMTime.CMTimeOne;
            insertEmptyTimeRange(new CMTimeRange(start, cMTime));
            insertEmptyTimeRange(new CMTimeRange(cMTimeRange.getEnd().add(cMTime), cMTime));
            int findSegmentIndexAt = findSegmentIndexAt(cMTimeRange.getStart(), false);
            int findSegmentIndexAt2 = findSegmentIndexAt(cMTimeRange.getEnd().add(cMTime), false);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < ((CompositionTrack) this).segments.size(); i3++) {
                if (i3 < findSegmentIndexAt || i3 > findSegmentIndexAt2) {
                    arrayList.add(((CompositionTrack) this).segments.get(i3));
                }
            }
            ((CompositionTrack) this).segments = arrayList;
            updateTimeRange();
            updateSegmentsStartTimeAfterRemoved(cMTimeRange);
        }
    }

    public void scaleTimeRange(CMTimeRange cMTimeRange, CMTime cMTime) {
        List<CompositionTrackSegment> list;
        int findSegmentIndexAt;
        CMTime sub;
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        if (cMTimeRange.getDuration().getTimeUs() <= 0 || (list = ((CompositionTrack) this).segments) == null || list.size() == 0 || (findSegmentIndexAt = findSegmentIndexAt(cMTimeRange.getStart(), false)) == -1) {
            return;
        }
        int findSegmentIndexAt2 = findSegmentIndexAt(cMTimeRange.getEnd(), false);
        if (findSegmentIndexAt2 == -1) {
            findSegmentIndexAt2 = ((CompositionTrack) this).segments.size() - 1;
        } else if (getSegmentStartCMTime(findSegmentIndexAt2).equalsTo(cMTimeRange.getEnd())) {
            findSegmentIndexAt2--;
        }
        if (findSegmentIndexAt == findSegmentIndexAt2) {
            CMTime segmentStartCMTime = getSegmentStartCMTime(findSegmentIndexAt);
            CompositionTrackSegment remove = ((CompositionTrack) this).segments.remove(findSegmentIndexAt);
            if (end.smallThan(segmentStartCMTime.add(remove.scaleDuration))) {
                CompositionTrackSegment[] split = split(remove, start.sub(segmentStartCMTime));
                remove = split[0];
                if (split[1].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split[1]);
                }
            }
            if (start.bigThan(segmentStartCMTime)) {
                CompositionTrackSegment[] split2 = split(remove, start.sub(segmentStartCMTime));
                split2[1].scaleDuration = cMTime;
                if (cMTime.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split2[1]);
                }
                if (split2[0].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split2[0]);
                }
            } else {
                remove.scaleDuration = cMTime;
                ((CompositionTrack) this).segments.add(findSegmentIndexAt, remove);
            }
        } else {
            CMTime segmentStartCMTime2 = getSegmentStartCMTime(findSegmentIndexAt);
            CMTime segmentStartCMTime3 = getSegmentStartCMTime(findSegmentIndexAt2);
            if (start.bigThan(segmentStartCMTime2)) {
                CompositionTrackSegment[] split3 = split(((CompositionTrack) this).segments.remove(findSegmentIndexAt), start.sub(segmentStartCMTime2));
                CompositionTrackSegment compositionTrackSegment = split3[1];
                compositionTrackSegment.scaleDuration = cMTime.multi(compositionTrackSegment.scaleDuration).divide(cMTimeRange.getDuration());
                sub = cMTime.sub(split3[1].scaleDuration);
                if (split3[1].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split3[1]);
                }
                if (split3[0].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt, split3[0]);
                }
            } else {
                CompositionTrackSegment compositionTrackSegment2 = ((CompositionTrack) this).segments.get(findSegmentIndexAt);
                CMTime divide = cMTime.multi(compositionTrackSegment2.scaleDuration).divide(cMTimeRange.getDuration());
                compositionTrackSegment2.scaleDuration = divide;
                sub = cMTime.sub(divide);
            }
            for (int i3 = findSegmentIndexAt + 1; i3 < findSegmentIndexAt2; i3++) {
                CompositionTrackSegment compositionTrackSegment3 = ((CompositionTrack) this).segments.get(i3);
                CMTime divide2 = sub.multi(compositionTrackSegment3.scaleDuration).divide(cMTimeRange.getDuration());
                compositionTrackSegment3.scaleDuration = divide2;
                sub = sub.sub(divide2);
            }
            CompositionTrackSegment compositionTrackSegment4 = ((CompositionTrack) this).segments.get(findSegmentIndexAt2);
            if (end.smallThan(segmentStartCMTime3.add(compositionTrackSegment4.scaleDuration))) {
                CompositionTrackSegment[] split4 = split(((CompositionTrack) this).segments.remove(findSegmentIndexAt2), end.sub(segmentStartCMTime3));
                split4[0].scaleDuration = sub;
                if (split4[1].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt2, split4[1]);
                }
                if (split4[0].scaleDuration.getTimeUs() > 0) {
                    ((CompositionTrack) this).segments.add(findSegmentIndexAt2, split4[0]);
                }
            } else {
                compositionTrackSegment4.scaleDuration = sub;
            }
        }
        CMTime cMTime2 = CMTime.CMTimeZero;
        for (CompositionTrackSegment compositionTrackSegment5 : ((CompositionTrack) this).segments) {
            compositionTrackSegment5.updateTargetTimeRange(new CMTimeRange(cMTime2, compositionTrackSegment5.scaleDuration));
            cMTime2 = cMTime2.add(compositionTrackSegment5.scaleDuration);
        }
        updateTimeRange();
    }

    public void setExtendedLanguageTag(String str) {
        this.extendedLanguageTag = str;
    }

    public void setLanguageCode(String str) {
        this.languageCode = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNaturalSize(CGSize cGSize) {
        this.naturalSize = cGSize;
    }

    public void setNaturalTimeScale(int i3) {
        this.naturalTimeScale = i3;
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public void setPreferredTransform(Matrix matrix) {
        this.preferredTransform = matrix;
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public void setPreferredVolume(float f16) {
        this.preferredVolume = f16;
    }

    public void setSegments(List<CompositionTrackSegment> list) {
        ((CompositionTrack) this).segments = list;
    }

    public boolean validateTrackSegments(List<CompositionTrackSegment> list) throws Exception {
        return false;
    }

    private void insertTimeRange(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2, AssetTrack assetTrack, int i3) {
        CompositionTrackSegment compositionTrackSegment;
        if (assetTrack instanceof CompositionTrack) {
            insertTimeRange(cMTimeRange, cMTimeRange2, (CompositionTrack) assetTrack, i3);
            return;
        }
        if (assetTrack != null) {
            compositionTrackSegment = new CompositionTrackSegment(assetTrack.getSourcePath(), assetTrack.getTrackID(), cMTimeRange, cMTimeRange2, assetTrack.getMediaType());
            compositionTrackSegment.setExtraInfo(assetTrack.getExtraInfo());
        } else {
            compositionTrackSegment = new CompositionTrackSegment(cMTimeRange2);
        }
        if (i3 >= 0) {
            ((CompositionTrack) this).segments.add(i3, compositionTrackSegment);
        } else {
            ((CompositionTrack) this).segments.add(compositionTrackSegment);
        }
        updateTimeRange();
    }

    private void insertTimeRange(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2, CompositionTrack compositionTrack, int i3) {
        CMTime cMTime;
        CMTime start = cMTimeRange.getStart();
        CMTime end = cMTimeRange.getEnd();
        CMTime start2 = cMTimeRange2.getStart();
        float durationUs = (((float) cMTimeRange2.getDurationUs()) * 1.0f) / ((float) cMTimeRange.getDurationUs());
        CMTime cMTime2 = start2;
        int i16 = i3;
        for (CompositionTrackSegment compositionTrackSegment : compositionTrack.getSegments()) {
            CMTimeRange target = compositionTrackSegment.getTimeMapping().getTarget();
            CMTime start3 = target.getStart();
            CMTime end2 = target.getEnd();
            CMTime m259clone = start3.m259clone();
            CMTime m259clone2 = end2.m259clone();
            if (start3.smallThan(start)) {
                m259clone = cMTimeRange.getStart();
            } else if (start3.bigThan(end)) {
                m259clone = CMTime.CMTimeInvalid;
            }
            if (end2.smallThan(start)) {
                m259clone2 = CMTime.CMTimeInvalid;
            } else if (end2.bigThan(end)) {
                m259clone2 = end;
            }
            if (!m259clone.equalsTo(m259clone2) && m259clone != (cMTime = CMTime.CMTimeInvalid) && m259clone2 != cMTime) {
                CMTime sub = m259clone.sub(start3);
                CMTime sub2 = m259clone2.sub(m259clone);
                CMTime multi = sub2.multi(durationUs);
                CMTimeRange cMTimeRange3 = new CMTimeRange(compositionTrackSegment.timeMapping.getSource().getStart().add(sub.divide((((float) compositionTrackSegment.timeMapping.getTarget().getDurationUs()) * 1.0f) / ((float) compositionTrackSegment.timeMapping.getSource().getDurationUs()))), sub2);
                CMTimeRange cMTimeRange4 = new CMTimeRange(cMTime2, multi);
                cMTime2 = cMTime2.add(multi);
                CompositionTrackSegment compositionTrackSegment2 = new CompositionTrackSegment(compositionTrackSegment.getSourcePath(), this.trackID, cMTimeRange3, cMTimeRange4, compositionTrackSegment.getSourceType());
                compositionTrackSegment2.setExtraInfo(compositionTrackSegment.getExtraInfo());
                if (i16 >= 0) {
                    ((CompositionTrack) this).segments.add(i16, compositionTrackSegment2);
                    i16++;
                } else {
                    ((CompositionTrack) this).segments.add(compositionTrackSegment2);
                }
            }
        }
        updateTimeRange();
    }
}
