package com.tencent.autotemplate;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVRhythmTimeEffectWithCutUtils {
    static IPatchRedirector $redirector_;

    public TAVRhythmTimeEffectWithCutUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static List<TAVClip> applyTimeEffectsInPreviewTimeline(List<TAVClip> list, List<TAVMovieTimeEffect> list2, List<CMTime> list3) {
        if (list2 == null || list2.isEmpty()) {
            return list;
        }
        List<TAVMovieTimeEffect> fillTimeEffectsAndRemoveOverlap = fillTimeEffectsAndRemoveOverlap(list2, list3);
        CMTime calculateClipTotalDuration = calculateClipTotalDuration(list);
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        CMTime cMTime = CMTime.CMTimeZero;
        CMTime cMTime2 = cMTime;
        for (TAVMovieTimeEffect tAVMovieTimeEffect : fillTimeEffectsAndRemoveOverlap) {
            if (cMTime2.bigThan(calculateClipTotalDuration) || cMTime2.equals(calculateClipTotalDuration)) {
                break;
            }
            CMTimeRange timeRange = tAVMovieTimeEffect.getTimeRange();
            float speed = tAVMovieTimeEffect.getSpeed();
            if (speed > 0.0f) {
                CMTime multi = timeRange.getDuration().multi(speed);
                arrayList2.addAll(getTAVClipsByTimeEffect(arrayList, cMTime2, multi, timeRange.getStart(), timeRange.getDuration(), speed, list3));
                cMTime2 = cMTime2.add(multi);
            } else if (speed == 0.0f) {
                arrayList2.addAll(getTAVClipsByTimeEffect(arrayList, cMTime2, new CMTime(33L, 1000), timeRange.getStart(), timeRange.getDuration(), speed, list3));
                cMTime2 = cMTime2.add(new CMTime(33L, 1000));
            }
            calculateClipTotalDuration = calculateClipTotalDuration(list);
        }
        if (cMTime2.smallThan(calculateClipTotalDuration)) {
            arrayList2.addAll(getTAVClipsByTimeEffect(arrayList, cMTime2, calculateClipTotalDuration.sub(cMTime2), fillTimeEffectsAndRemoveOverlap.get(fillTimeEffectsAndRemoveOverlap.size() - 1).getTimeRange().getEnd(), calculateClipTotalDuration.sub(cMTime2), 1.0f, list3));
        }
        return arrayList2;
    }

    private static CMTime calculateClipTotalDuration(List<TAVClip> list) {
        CMTime cMTime = CMTime.CMTimeZero;
        Iterator<TAVClip> it = list.iterator();
        while (it.hasNext()) {
            cMTime = cMTime.add(it.next().getResource().getScaledDuration());
        }
        return cMTime;
    }

    private static List<TAVMovieTimeEffect> fillTimeEffectsAndRemoveOverlap(List<TAVMovieTimeEffect> list, List<CMTime> list2) {
        ArrayList arrayList = new ArrayList();
        CMTime cMTime = CMTime.CMTimeZero;
        CMTime end = list.get(list.size() - 1).getTimeRange().getEnd();
        CMTime cMTime2 = new CMTime(TTL.MAX_VALUE, 1000);
        if (end.smallThan(cMTime2)) {
            TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
            CMTimeRange cMTimeRange = new CMTimeRange(end, cMTime2.sub(end));
            tAVMovieTimeEffect.setTimeRange(cMTimeRange);
            tAVMovieTimeEffect.setSourceTimeRange(cMTimeRange);
            list.add(tAVMovieTimeEffect);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            TAVMovieTimeEffect tAVMovieTimeEffect2 = list.get(i3);
            CMTimeRange timeRange = tAVMovieTimeEffect2.getTimeRange();
            if (timeRange.getStart().bigThan(cMTime)) {
                arrayList.addAll(getNormalSpeedTimeEffects(cMTime, timeRange.getStart().sub(cMTime), getPointsInTimeRange(list2, new CMTimeRange(cMTime, timeRange.getStart().sub(cMTime)))));
                arrayList.add(tAVMovieTimeEffect2);
                cMTime = timeRange.getEnd();
            } else if (timeRange.getStart().equalsTo(cMTime)) {
                arrayList.add(tAVMovieTimeEffect2);
                cMTime = timeRange.getEnd();
            }
        }
        return arrayList;
    }

    private static TAVClip getCutClip(TAVClip tAVClip, CMTime cMTime, CMTime cMTime2) {
        TAVClip m268clone = tAVClip.m268clone();
        CMTimeRange sourceTimeRange = m268clone.getResource().getSourceTimeRange();
        CMTime duration = sourceTimeRange.getDuration();
        CMTime scaledDuration = m268clone.getResource().getScaledDuration();
        float timeSeconds = duration.getTimeSeconds() / scaledDuration.getTimeSeconds();
        if (!cMTime.add(cMTime2).smallThan(scaledDuration) && !cMTime.add(cMTime2).equals(scaledDuration)) {
            m268clone.getResource().setSourceTimeRange(new CMTimeRange(sourceTimeRange.getStart().add(cMTime.multi(timeSeconds)), new CMTime(scaledDuration.sub(cMTime).getTimeSeconds() * timeSeconds * 1000.0f, 1000)));
            m268clone.getResource().setScaledDuration(scaledDuration.sub(cMTime));
        } else {
            m268clone.getResource().setSourceTimeRange(new CMTimeRange(sourceTimeRange.getStart().add(cMTime.multi(timeSeconds)), new CMTime(cMTime2.getTimeSeconds() * timeSeconds * 1000.0f, 1000)));
            m268clone.getResource().setScaledDuration(cMTime2);
        }
        return m268clone;
    }

    private static List<TAVMovieTimeEffect> getNormalSpeedTimeEffects(CMTime cMTime, CMTime cMTime2, List<CMTime> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
            tAVMovieTimeEffect.setTimeRange(new CMTimeRange(cMTime, cMTime2));
            arrayList.add(tAVMovieTimeEffect);
        } else {
            int i3 = 0;
            CMTime cMTime3 = cMTime;
            while (i3 < list.size()) {
                CMTime cMTime4 = list.get(i3);
                TAVMovieTimeEffect tAVMovieTimeEffect2 = new TAVMovieTimeEffect();
                tAVMovieTimeEffect2.setTimeRange(new CMTimeRange(cMTime3, cMTime4.sub(cMTime3)));
                arrayList.add(tAVMovieTimeEffect2);
                if (i3 == list.size() - 1) {
                    TAVMovieTimeEffect tAVMovieTimeEffect3 = new TAVMovieTimeEffect();
                    tAVMovieTimeEffect3.setTimeRange(new CMTimeRange(cMTime4, cMTime.add(cMTime2).sub(cMTime4)));
                    arrayList.add(tAVMovieTimeEffect3);
                }
                i3++;
                cMTime3 = cMTime4;
            }
        }
        return arrayList;
    }

    private static List<CMTime> getPointsInTimeRange(List<CMTime> list, CMTimeRange cMTimeRange) {
        ArrayList arrayList = new ArrayList();
        for (CMTime cMTime : list) {
            if (cMTime.bigThan(cMTimeRange.getStart()) && cMTime.smallThan(cMTimeRange.getEnd())) {
                arrayList.add(cMTime);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        if (r5 != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<TAVClip> getTAVClipsByTimeEffect(List<TAVClip> list, CMTime cMTime, CMTime cMTime2, CMTime cMTime3, CMTime cMTime4, float f16, List<CMTime> list2) {
        CMTime cMTime5;
        boolean z16;
        CMTime add;
        CMTime cMTime6 = CMTime.CMTimeZero;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (list2 != null && list2.contains(cMTime3)) {
            z16 = true;
            int indexOf = list2.indexOf(cMTime3) + 1;
            if (indexOf > 0 && indexOf < list2.size()) {
                cMTime5 = list2.get(indexOf);
            } else {
                cMTime5 = cMTime6;
            }
        } else {
            cMTime5 = cMTime6;
            z16 = false;
        }
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            TAVClip tAVClip = list.get(i3);
            CMTime scaledDuration = tAVClip.getResource().getScaledDuration();
            if (!cMTime6.smallThan(cMTime)) {
                boolean equals = cMTime6.equals(cMTime);
                cMTime = cMTime;
            }
            boolean bigThan = cMTime6.add(scaledDuration).bigThan(cMTime);
            cMTime = cMTime;
            if (bigThan) {
                if (z16 && cMTime6.smallThan(cMTime) && cMTime6.add(scaledDuration).smallThan(cMTime5)) {
                    CMTime sub = cMTime.sub(cMTime6);
                    TAVClip cutClip = getCutClip(tAVClip, CMTime.CMTimeZero, sub);
                    list.add(list.indexOf(tAVClip), cutClip);
                    list.remove(tAVClip);
                    add = cMTime6.add(cutClip.getResource().getScaledDuration());
                    Log.d(TAVRhythmAutomaticTemplate.TAG, "cut clip at time" + cMTime.getTimeSeconds() + ", cutclip index" + i3 + ", cut dur " + sub.getTimeSeconds());
                    cMTime6 = add;
                    i3++;
                } else {
                    TAVClip cutClip2 = getCutClip(tAVClip, cMTime.sub(cMTime6), cMTime2);
                    CMTime scaledDuration2 = cutClip2.getResource().getScaledDuration();
                    if (f16 != 0.0f) {
                        cutClip2.getResource().setScaledDuration(scaledDuration2.divide(f16));
                        arrayList.add(cutClip2);
                        if (!cMTime2.sub(scaledDuration2).bigThan(CMTime.CMTimeZero)) {
                            break;
                        }
                        CMTime add2 = cMTime.add(scaledDuration2);
                        cMTime2 = cMTime2.sub(scaledDuration2);
                        cMTime = add2;
                    } else {
                        cutClip2.getResource().setScaledDuration(cMTime4);
                        arrayList.add(cutClip2);
                        break;
                    }
                }
            }
            add = cMTime6.add(scaledDuration);
            cMTime6 = add;
            i3++;
        }
        return arrayList;
    }
}
