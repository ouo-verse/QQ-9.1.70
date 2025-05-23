package com.tencent.autotemplate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVRhythmTimeEffectUtils {
    static IPatchRedirector $redirector_;

    public TAVRhythmTimeEffectUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static List<TAVClip> applyTimeEffectsInPreviewTimeline(List<TAVClip> list, List<TAVMovieTimeEffect> list2) {
        if (list2 != null && !list2.isEmpty()) {
            List<TAVMovieTimeEffect> fillTimeEffectsAndRemoveOverlap = fillTimeEffectsAndRemoveOverlap(list2);
            CMTime calculateClipTotalDuration = calculateClipTotalDuration(list);
            ArrayList arrayList = new ArrayList();
            CMTime cMTime = CMTime.CMTimeZero;
            for (TAVMovieTimeEffect tAVMovieTimeEffect : fillTimeEffectsAndRemoveOverlap) {
                if (cMTime.bigThan(calculateClipTotalDuration) || cMTime.equals(calculateClipTotalDuration)) {
                    break;
                }
                CMTimeRange timeRange = tAVMovieTimeEffect.getTimeRange();
                float speed = tAVMovieTimeEffect.getSpeed();
                if (speed > 0.0f) {
                    CMTime multi = timeRange.getDuration().multi(speed);
                    arrayList.addAll(getTAVClipsByTimeEffect(list, cMTime, multi, timeRange.getDuration(), speed));
                    cMTime = cMTime.add(multi);
                } else if (speed == 0.0f) {
                    arrayList.addAll(getTAVClipsByTimeEffect(list, cMTime, new CMTime(33L, 1000), timeRange.getDuration(), speed));
                    cMTime = cMTime.add(new CMTime(33L, 1000));
                }
            }
            if (cMTime.smallThan(calculateClipTotalDuration)) {
                arrayList.addAll(getTAVClipsByTimeEffect(list, cMTime, calculateClipTotalDuration.sub(cMTime), calculateClipTotalDuration.sub(cMTime), 1.0f));
            }
            return arrayList;
        }
        return list;
    }

    private static CMTime calculateClipTotalDuration(List<TAVClip> list) {
        CMTime cMTime = CMTime.CMTimeZero;
        Iterator<TAVClip> it = list.iterator();
        while (it.hasNext()) {
            cMTime = cMTime.add(it.next().getResource().getScaledDuration());
        }
        return cMTime;
    }

    public static void covertTAVClipTimeScale(TAVClip tAVClip) {
        CMTimeRange sourceTimeRange = tAVClip.getResource().getSourceTimeRange();
        CMTime scaledDuration = tAVClip.getResource().getScaledDuration();
        tAVClip.getResource().setDuration(new CMTime(tAVClip.getResource().getDuration().getTimeSeconds() * 1000.0f, 1000));
        tAVClip.getResource().setScaledDuration(new CMTime(scaledDuration.getTimeSeconds() * 1000.0f, 1000));
        tAVClip.getResource().setSourceTimeRange(new CMTimeRange(new CMTime(sourceTimeRange.getStart().getTimeSeconds() * 1000.0f, 1000), new CMTime(sourceTimeRange.getDuration().getTimeSeconds() * 1000.0f, 1000)));
    }

    private static List<TAVMovieTimeEffect> fillTimeEffectsAndRemoveOverlap(List<TAVMovieTimeEffect> list) {
        ArrayList arrayList = new ArrayList();
        CMTime cMTime = CMTime.CMTimeZero;
        for (int i3 = 0; i3 < list.size(); i3++) {
            TAVMovieTimeEffect tAVMovieTimeEffect = list.get(i3);
            CMTimeRange timeRange = tAVMovieTimeEffect.getTimeRange();
            if (timeRange.getStart().bigThan(cMTime)) {
                arrayList.add(getNormalSpeedTimeEffect(cMTime, timeRange.getStart().sub(cMTime)));
                arrayList.add(tAVMovieTimeEffect);
                cMTime = timeRange.getEnd();
            } else if (timeRange.getStart().equalsTo(cMTime)) {
                arrayList.add(tAVMovieTimeEffect);
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

    private static TAVMovieTimeEffect getNormalSpeedTimeEffect(CMTime cMTime, CMTime cMTime2) {
        TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
        tAVMovieTimeEffect.setTimeRange(new CMTimeRange(cMTime, cMTime2));
        return tAVMovieTimeEffect;
    }

    private static List<TAVClip> getTAVClipsByTimeEffect(List<TAVClip> list, CMTime cMTime, CMTime cMTime2, CMTime cMTime3, float f16) {
        CMTime cMTime4 = CMTime.CMTimeZero;
        ArrayList arrayList = new ArrayList();
        Iterator<TAVClip> it = list.iterator();
        CMTime cMTime5 = cMTime4;
        CMTime cMTime6 = cMTime;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TAVClip next = it.next();
            CMTime scaledDuration = next.getResource().getScaledDuration();
            if ((cMTime5.smallThan(cMTime6) || cMTime5.equals(cMTime6)) && cMTime5.add(scaledDuration).bigThan(cMTime6)) {
                TAVClip cutClip = getCutClip(next, cMTime6.sub(cMTime5), cMTime2);
                CMTime scaledDuration2 = cutClip.getResource().getScaledDuration();
                if (f16 != 0.0f) {
                    cutClip.getResource().setScaledDuration(scaledDuration2.divide(f16));
                    arrayList.add(cutClip);
                    if (!cMTime2.sub(scaledDuration2).bigThan(CMTime.CMTimeZero)) {
                        break;
                    }
                    cMTime6 = cMTime6.add(scaledDuration2);
                    cMTime2 = cMTime2.sub(scaledDuration2);
                } else {
                    cutClip.getResource().setScaledDuration(cMTime3);
                    arrayList.add(cutClip);
                    break;
                }
            }
            cMTime5 = cMTime5.add(scaledDuration);
            cMTime6 = cMTime6;
        }
        return arrayList;
    }
}
