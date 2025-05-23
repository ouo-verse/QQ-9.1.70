package com.tencent.tavmovie.utils;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.component.TAVTimeEffect;
import com.tencent.tavkit.component.TAVTimeEffectBuilder;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieTimeEffectUtil {
    private static List<TAVTimeEffect> adjustTimeEffects(List<TAVClip> list, List<TAVTimeEffect> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            ArrayList arrayList = new ArrayList();
            CMTime sub = list.get(0).getResource().getSourceTimeRange().getStart().sub(list2.get(0).getTimeRange().getStart());
            for (TAVTimeEffect tAVTimeEffect : list2) {
                TAVTimeEffect tAVTimeEffect2 = new TAVTimeEffect();
                tAVTimeEffect2.setTimeRange(new CMTimeRange(tAVTimeEffect.getTimeRange().getStart().add(sub), tAVTimeEffect.getTimeRange().getDuration()));
                tAVTimeEffect2.setScaledDuration(tAVTimeEffect.getScaledDuration());
                tAVTimeEffect2.setReverse(tAVTimeEffect.isReverse());
                tAVTimeEffect2.setFreeze(tAVTimeEffect.isFreeze());
                tAVTimeEffect2.setLoopCount(tAVTimeEffect.getLoopCount());
                arrayList.add(tAVTimeEffect2);
            }
            return arrayList;
        }
        return list2;
    }

    public static List<TAVClip> applyTimeEffects(List<TAVClip> list, List<TAVMovieTimeEffect> list2) {
        int i3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<TAVMovieTimeEffect> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().calculateSourceDuration());
        }
        int i16 = 0;
        int i17 = 0;
        while (i17 < arrayList2.size() && !list.isEmpty()) {
            CMTime cMTime = (CMTime) arrayList2.get(i17);
            TAVMovieTimeEffect tAVMovieTimeEffect = list2.get(i17);
            int loop = tAVMovieTimeEffect.getLoop();
            float speed = tAVMovieTimeEffect.getSpeed();
            TAVClip remove = list.remove(i16);
            CMTime duration = remove.getResource().getSourceTimeRange().getDuration();
            ArrayList arrayList3 = new ArrayList();
            if (duration.equalsTo(cMTime)) {
                for (int i18 = i16; i18 < loop; i18++) {
                    remove.getResource().setScaledDuration(remove.getResource().getSourceTimeRange().getDuration().divide(speed));
                    arrayList3.add(remove.m268clone());
                }
                i3 = i16;
            } else {
                if (duration.bigThan(cMTime)) {
                    CMTime sub = duration.sub(cMTime);
                    CMTime start = remove.getResource().getSourceTimeRange().getStart();
                    TAVClip m268clone = remove.m268clone();
                    m268clone.getResource().setSourceTimeRange(new CMTimeRange(start.add(cMTime), sub));
                    list.add(0, m268clone);
                    remove.getResource().setSourceTimeRange(new CMTimeRange(start, cMTime));
                    for (int i19 = 0; i19 < loop; i19++) {
                        remove.getResource().setScaledDuration(remove.getResource().getSourceTimeRange().getDuration().divide(speed));
                        arrayList3.add(remove.m268clone());
                    }
                } else if (duration.smallThan(cMTime)) {
                    ArrayList<TAVClip> arrayList4 = new ArrayList();
                    arrayList4.add(remove);
                    CMTime sub2 = cMTime.sub(duration);
                    CMTime cMTime2 = CMTime.CMTimeZero;
                    while (sub2.bigThan(CMTime.CMTimeZero) && !list.isEmpty()) {
                        TAVClip remove2 = list.remove(0);
                        CMTime duration2 = remove2.getResource().getSourceTimeRange().getDuration();
                        arrayList4.add(remove2);
                        cMTime2 = cMTime2.add(duration2);
                        sub2 = sub2.sub(duration2);
                    }
                    if (cMTime2.bigThan(cMTime)) {
                        TAVClip tAVClip = (TAVClip) arrayList4.get(arrayList4.size() - 1);
                        TAVClip m268clone2 = tAVClip.m268clone();
                        CMTime sub3 = cMTime2.sub(cMTime);
                        CMTime sub4 = tAVClip.getResource().getSourceTimeRange().getDuration().sub(sub3);
                        tAVClip.getResource().setSourceTimeRange(new CMTimeRange(tAVClip.getResource().getSourceTimeRange().getStart(), sub4));
                        m268clone2.getResource().setSourceTimeRange(new CMTimeRange(m268clone2.getResource().getSourceTimeRange().getStart().add(sub4), sub3));
                        i3 = 0;
                        list.add(0, m268clone2);
                    } else {
                        i3 = 0;
                    }
                    for (int i26 = i3; i26 < loop; i26++) {
                        for (TAVClip tAVClip2 : arrayList4) {
                            tAVClip2.getResource().setScaledDuration(tAVClip2.getResource().getSourceTimeRange().getDuration().divide(speed));
                        }
                        arrayList3.addAll(CloneUtil.cloneTAVClips(arrayList4));
                    }
                }
                i3 = 0;
            }
            arrayList.addAll(arrayList3);
            i17++;
            i16 = i3;
        }
        return arrayList;
    }

    public static List<TAVClip> applyTimeEffectsNew(List<TAVClip> list, List<TAVMovieTimeEffect> list2) {
        int i3;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            CMTime cMTime = CMTime.CMTimeZero;
            Iterator<TAVClip> it = list.iterator();
            while (it.hasNext()) {
                cMTime = cMTime.add(it.next().getResource().getSourceTimeRange().getDuration());
            }
            if (list2 == null) {
                return list;
            }
            for (TAVMovieTimeEffect tAVMovieTimeEffect : list2) {
                List<TAVClip> cloneTAVClips = CloneUtil.cloneTAVClips(list);
                if (tAVMovieTimeEffect != null && tAVMovieTimeEffect.getSourceTimeRange() != null) {
                    if (!tAVMovieTimeEffect.getSourceTimeRange().getStart().smallThan(cMTime) || !tAVMovieTimeEffect.getSourceTimeRange().getStart().smallThan(tAVMovieTimeEffect.getSourceTimeRange().getEnd())) {
                        break;
                    }
                    CMTime start = tAVMovieTimeEffect.getSourceTimeRange().getStart();
                    int i16 = 0;
                    int i17 = 0;
                    while (true) {
                        i3 = -1;
                        if (i17 < cloneTAVClips.size()) {
                            start = start.sub(list.get(i17).getResource().getSourceTimeRange().getDuration());
                            if (!start.bigThan(CMTime.CMTimeZero)) {
                                break;
                            }
                            i17++;
                        } else {
                            i17 = -1;
                            break;
                        }
                    }
                    CMTime add = cloneTAVClips.get(i17).getResource().getSourceTimeRange().getEnd().add(start);
                    CMTime end = tAVMovieTimeEffect.getSourceTimeRange().getEnd();
                    while (true) {
                        if (i16 >= cloneTAVClips.size()) {
                            break;
                        }
                        end = end.sub(list.get(i16).getResource().getSourceTimeRange().getDuration());
                        if (!end.bigThan(CMTime.CMTimeZero)) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                    CMTime cMTime2 = CMTime.CMTimeZero;
                    if (end.bigThan(cMTime2)) {
                        i3 = cloneTAVClips.size() - 1;
                        end = cMTime2;
                    }
                    CMTime add2 = list.get(i3).getResource().getSourceTimeRange().getEnd().add(end);
                    TAVClip tAVClip = cloneTAVClips.get(i17);
                    tAVClip.getResource().setSourceTimeRange(new CMTimeRange(add, tAVClip.getResource().getSourceTimeRange().getEnd().sub(add)));
                    TAVClip tAVClip2 = cloneTAVClips.get(i3);
                    tAVClip2.getResource().setSourceTimeRange(new CMTimeRange(tAVClip2.getResource().getSourceTimeRange().getStart(), add2.sub(tAVClip2.getResource().getSourceTimeRange().getStart())));
                    List<TAVClip> subList = cloneTAVClips.subList(i17, i3 + 1);
                    for (TAVClip tAVClip3 : subList) {
                        tAVClip3.getResource().setScaledDuration(tAVClip3.getResource().getSourceTimeRange().getDuration().divide(tAVMovieTimeEffect.getSpeed()));
                    }
                    arrayList.addAll(subList);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<TAVClip> applyTimeEffectsOld(List<TAVClip> list, List<TAVMovieTimeEffect> list2) {
        Iterator<TAVClip> it;
        Iterator<TAVMovieTimeEffect> it5;
        boolean z16;
        if (list2 == null || list2.size() == 0 || list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        TAVTimeEffectBuilder tAVTimeEffectBuilder = new TAVTimeEffectBuilder();
        ArrayList<TAVMovieTimeEffect> arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        CMTime start = list2.get(0).getTimeRange().getStart();
        Iterator<TAVClip> it6 = list.iterator();
        while (it6.hasNext()) {
            TAVClip next = it6.next();
            tAVTimeEffectBuilder.setClip(next);
            CMTimeRange cMTimeRange = new CMTimeRange(next.getStartTime(), next.getResource().getSourceTimeRange().getDuration());
            ArrayList arrayList3 = new ArrayList();
            HashMap hashMap2 = new HashMap();
            Iterator<TAVMovieTimeEffect> it7 = list2.iterator();
            while (it7.hasNext()) {
                TAVMovieTimeEffect next2 = it7.next();
                if (next2.getTimeRange().getEnd().compare(start) > 0) {
                    TAVMovieTimeEffect m276clone = next2.m276clone();
                    CMTime sub = next2.getTimeRange().getStart().sub(start);
                    if (sub.getTimeUs() < 0) {
                        it = it6;
                        it5 = it7;
                        m276clone.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, next2.getTimeRange().getDuration().add(sub)));
                        if (next2.getLoop() > 1) {
                            z16 = true;
                            CMTimeRange intersection = getIntersection(cMTimeRange, m276clone.getTimeRange());
                            if (!cMTimeRange.containsTimeRange(m276clone.getTimeRange())) {
                                arrayList3.add(m276clone.convertToTimeEffect());
                                if (z16) {
                                    hashMap2.put(next2, Boolean.TRUE);
                                }
                            } else if (!CMTimeRange.CMTimeRangeInvalid.equals(intersection)) {
                                TAVMovieTimeEffect m276clone2 = m276clone.m276clone();
                                m276clone2.setTimeRange(intersection);
                                TAVTimeEffect convertToTimeEffect = m276clone2.convertToTimeEffect();
                                arrayList3.add(convertToTimeEffect);
                                if (next2.getLoop() > 1) {
                                    if (!arrayList2.contains(next2)) {
                                        arrayList2.add(next2);
                                    }
                                    if (convertToTimeEffect.getTimeRange().getStart().equalsTo(CMTime.CMTimeZero)) {
                                        hashMap2.put(next2, Boolean.TRUE);
                                    } else {
                                        hashMap2.put(next2, Boolean.FALSE);
                                    }
                                }
                            }
                            it6 = it;
                            it7 = it5;
                        }
                    } else {
                        it = it6;
                        it5 = it7;
                        m276clone.setTimeRange(new CMTimeRange(sub, next2.getTimeRange().getDuration()));
                    }
                    z16 = false;
                    CMTimeRange intersection2 = getIntersection(cMTimeRange, m276clone.getTimeRange());
                    if (!cMTimeRange.containsTimeRange(m276clone.getTimeRange())) {
                    }
                    it6 = it;
                    it7 = it5;
                }
            }
            Iterator<TAVClip> it8 = it6;
            List<TAVTimeEffect> adjustTimeEffects = adjustTimeEffects(list, arrayList3);
            TAVTimeEffect[] tAVTimeEffectArr = new TAVTimeEffect[adjustTimeEffects.size()];
            for (int i3 = 0; i3 < adjustTimeEffects.size(); i3++) {
                tAVTimeEffectArr[i3] = adjustTimeEffects.get(i3);
            }
            tAVTimeEffectBuilder.setTimeEffects(tAVTimeEffectArr);
            List build = tAVTimeEffectBuilder.build();
            arrayList.addAll(build);
            if (!hashMap2.isEmpty()) {
                for (Map.Entry entry : hashMap2.entrySet()) {
                    TAVMovieTimeEffect tAVMovieTimeEffect = (TAVMovieTimeEffect) entry.getKey();
                    boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                    List list3 = (List) hashMap.get(tAVMovieTimeEffect);
                    if (list3 == null) {
                        list3 = new ArrayList();
                    }
                    if (booleanValue) {
                        list3.add(build.subList(0, tAVMovieTimeEffect.getLoop()));
                    } else {
                        list3.add(build.subList(build.size() - tAVMovieTimeEffect.getLoop(), build.size()));
                    }
                    hashMap.put(tAVMovieTimeEffect, list3);
                }
            }
            start = start.add(next.getResource().getSourceTimeRange().getDuration());
            it6 = it8;
        }
        for (TAVMovieTimeEffect tAVMovieTimeEffect2 : arrayList2) {
            List list4 = (List) hashMap.get(tAVMovieTimeEffect2);
            if (list4 != null && list4.size() > 0) {
                if (tAVMovieTimeEffect2.getLoop() > 1) {
                    List list5 = (List) list4.get(0);
                    int indexOf = arrayList.indexOf(list5.get(0));
                    int size = list4.size();
                    for (int i16 = 0; i16 < list5.size(); i16++) {
                        for (int i17 = 0; i17 < list4.size(); i17++) {
                            List list6 = (List) list4.get(i17);
                            int i18 = indexOf + i17 + (i16 * size);
                            arrayList.remove(i18);
                            arrayList.add(i18, list6.get(i16));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static CMTimeRange createMaxTimeRange(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        if (cMTimeRange == null) {
            return cMTimeRange2;
        }
        if (cMTimeRange2 == null) {
            return cMTimeRange;
        }
        if (cMTimeRange.getStartUs() <= cMTimeRange2.getStartUs()) {
            return new CMTimeRange(cMTimeRange.getStart(), cMTimeRange2.getEnd().sub(cMTimeRange.getStart()));
        }
        return new CMTimeRange(cMTimeRange2.getStart(), cMTimeRange.getEnd().sub(cMTimeRange2.getStart()));
    }

    public static CMTimeRange getIntersection(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        if (cMTimeRange != null && cMTimeRange2 != null) {
            CMTimeRange m260clone = cMTimeRange.m260clone();
            CMTimeRange m260clone2 = cMTimeRange2.m260clone();
            if (m260clone.getStartUs() > m260clone2.getStartUs()) {
                m260clone2 = m260clone;
                m260clone = m260clone2;
            }
            if (m260clone.getEndUs() > m260clone2.getStartUs() && m260clone.getEndUs() < m260clone2.getEndUs()) {
                return new CMTimeRange(m260clone2.getStart(), m260clone.getEnd().sub(m260clone2.getStart()));
            }
            if (m260clone.getEndUs() >= m260clone2.getEndUs()) {
                return m260clone2;
            }
            if (m260clone.getEndUs() < m260clone2.getStartUs()) {
                return CMTimeRange.CMTimeRangeInvalid;
            }
            return CMTimeRange.CMTimeRangeInvalid;
        }
        return CMTimeRange.CMTimeRangeInvalid;
    }

    public static List<TAVMovieTimeEffect> getNoOverlapTimeEffects(List<TAVMovieTimeEffect> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            List<TAVMovieTimeEffect> sortMovieTimeEffects = sortMovieTimeEffects(list);
            int size = sortMovieTimeEffects.size();
            TAVMovieTimeEffect m276clone = sortMovieTimeEffects.get(0).m276clone();
            arrayList.add(m276clone);
            CMTimeRange timeRange = m276clone.getTimeRange();
            for (int i3 = 1; i3 < size; i3++) {
                TAVMovieTimeEffect m276clone2 = sortMovieTimeEffects.get(i3).m276clone();
                CMTimeRange timeRange2 = m276clone2.getTimeRange();
                CMTimeRange[] unions = getUnions(timeRange, timeRange2);
                CMTimeRange cMTimeRange = unions[1];
                if (cMTimeRange != null && timeRange2.containsTimeRange(cMTimeRange)) {
                    m276clone2.setTimeRange(cMTimeRange);
                    arrayList.add(m276clone2);
                }
                timeRange = createMaxTimeRange(unions[0], unions[1]);
            }
            return arrayList;
        }
        return null;
    }

    public static CMTimeRange[] getUnions(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        CMTimeRange[] cMTimeRangeArr = new CMTimeRange[2];
        if (cMTimeRange == null) {
            cMTimeRangeArr[0] = cMTimeRange2;
        } else if (cMTimeRange2 == null) {
            cMTimeRangeArr[0] = cMTimeRange;
        } else {
            CMTimeRange m260clone = cMTimeRange.m260clone();
            CMTimeRange m260clone2 = cMTimeRange2.m260clone();
            if (m260clone.getStartUs() > m260clone2.getStartUs()) {
                m260clone2 = m260clone;
                m260clone = m260clone2;
            }
            cMTimeRangeArr[0] = m260clone;
            if (m260clone.getEndUs() >= m260clone2.getStartUs() && m260clone.getEndUs() < m260clone2.getEndUs()) {
                cMTimeRangeArr[1] = new CMTimeRange(m260clone.getEnd(), m260clone2.getEnd().sub(m260clone.getEnd()));
            } else if (m260clone.getEndUs() >= m260clone2.getEndUs()) {
                cMTimeRangeArr[1] = null;
            } else if (m260clone.getEndUs() < m260clone2.getStartUs()) {
                cMTimeRangeArr[1] = m260clone2;
            }
        }
        return cMTimeRangeArr;
    }

    public static List<TAVMovieTimeEffect> pretreatTimeEffects(List<TAVMovieTimeEffect> list) {
        if (list == null) {
            return null;
        }
        return getNoOverlapTimeEffects(list);
    }

    public static List<TAVMovieTimeEffect> sortMovieTimeEffects(List<TAVMovieTimeEffect> list) {
        Collections.sort(list, new Comparator<TAVMovieTimeEffect>() { // from class: com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil.1
            @Override // java.util.Comparator
            public int compare(TAVMovieTimeEffect tAVMovieTimeEffect, TAVMovieTimeEffect tAVMovieTimeEffect2) {
                long startUs = tAVMovieTimeEffect.getTimeRange().getStartUs();
                long startUs2 = tAVMovieTimeEffect2.getTimeRange().getStartUs();
                if (startUs == startUs2) {
                    return 0;
                }
                return startUs <= startUs2 ? -1 : 1;
            }
        });
        return list;
    }
}
