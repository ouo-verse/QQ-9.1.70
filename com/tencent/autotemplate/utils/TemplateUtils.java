package com.tencent.autotemplate.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.CompositionUtils;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TemplateUtils {
    static IPatchRedirector $redirector_;

    public TemplateUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static CMTime calculateTotalTime(TAVComposition tAVComposition) {
        List<List<? extends TAVTransitionableVideo>> videoChannels = tAVComposition.getVideoChannels();
        CMTime cMTime = CMTime.CMTimeZero;
        for (List<? extends TAVTransitionableVideo> list : videoChannels) {
            CMTime cMTime2 = CMTime.CMTimeZero;
            Iterator<? extends TAVTransitionableVideo> it = list.iterator();
            while (it.hasNext()) {
                cMTime2 = cMTime2.add(((TAVClip) it.next()).getResource().getScaledDuration());
            }
            if (cMTime2.bigThan(cMTime)) {
                cMTime = cMTime2;
            }
        }
        return cMTime;
    }

    public static List<List<TAVClip>> checkVideoMaxDuration(TAVComposition tAVComposition, CMTime cMTime) {
        List<List<? extends TAVTransitionableVideo>> videoChannels;
        if (tAVComposition == null || (videoChannels = tAVComposition.getVideoChannels()) == null || videoChannels.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (List<? extends TAVTransitionableVideo> list : videoChannels) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<? extends TAVTransitionableVideo> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add((TAVClip) it.next());
            }
            arrayList.add(arrayList2);
        }
        return checkVideoMaxDuration(arrayList, cMTime);
    }

    public static void cutClip(TAVClip tAVClip, CMTime cMTime) {
        CMTimeRange sourceTimeRange = tAVClip.getResource().getSourceTimeRange();
        CMTime duration = sourceTimeRange.getDuration();
        CMTime scaledDuration = tAVClip.getResource().getScaledDuration();
        float timeSeconds = duration.getTimeSeconds() / scaledDuration.getTimeSeconds();
        CMTime sub = scaledDuration.sub(cMTime);
        CMTime cMTime2 = new CMTime(sub.getTimeSeconds() * timeSeconds * 1000.0f, 1000);
        tAVClip.getResource().setSourceTimeRange(new CMTimeRange(sourceTimeRange.getStart(), cMTime2));
        tAVClip.getResource().setDuration(cMTime2);
        tAVClip.getResource().setScaledDuration(sub);
    }

    public static String getResourcePath(TAVResource tAVResource) {
        if (tAVResource instanceof TAVImageTrackResource) {
            return ((TAVImageTrackResource) tAVResource).getPath();
        }
        if (tAVResource instanceof TAVAssetTrackResource) {
            return ((TAVAssetTrackResource) tAVResource).getAsset().getSourcePath();
        }
        return null;
    }

    public static String getTAVMovieClipFilePath(TAVMovieClip tAVMovieClip) {
        if (tAVMovieClip == null) {
            return null;
        }
        TAVMovieResource resource = tAVMovieClip.getResource();
        if (resource instanceof TAVMovieTrackResource) {
            return ((TAVMovieTrackResource) resource).getFilePath();
        }
        if (!(resource instanceof TAVMovieImageResource)) {
            return null;
        }
        return ((TAVMovieImageResource) resource).getFilePath();
    }

    public static boolean isAllPhotoClip(List<TAVMovieClip> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (TAVMovieClip tAVMovieClip : list) {
            if (tAVMovieClip != null && !(tAVMovieClip.getResource() instanceof TAVMovieImageResource)) {
                return false;
            }
        }
        return true;
    }

    public static void reloadChannels(TAVComposition tAVComposition) {
        Iterator<List<? extends TAVTransitionableVideo>> it = tAVComposition.getVideoChannels().iterator();
        while (it.hasNext()) {
            CompositionUtils.reloadVideoStartTimeWithTransitionableVideo(it.next());
        }
        Iterator<List<? extends TAVTransitionableAudio>> it5 = tAVComposition.getAudioChannels().iterator();
        while (it5.hasNext()) {
            CompositionUtils.reloadAudioStartTimeWithTransitionableAudio(it5.next());
        }
    }

    public static List<List<TAVClip>> checkVideoMaxDuration(List<List<TAVClip>> list, CMTime cMTime) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (List<TAVClip> list2 : list) {
            CMTime cMTime2 = CMTime.CMTimeZero;
            ArrayList arrayList2 = new ArrayList();
            Iterator<TAVClip> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    TAVClip next = it.next();
                    CMTime add = cMTime2.add(next.getResource().getScaledDuration());
                    if (!add.smallThan(cMTime) && !add.equalsTo(cMTime)) {
                        CMTime sub = add.sub(cMTime);
                        if (next.getResource().getScaledDuration().bigThan(sub)) {
                            cutClip(next, sub);
                            arrayList2.add(next);
                        }
                    } else {
                        arrayList2.add(next);
                        cMTime2 = cMTime2.add(next.getResource().getScaledDuration());
                    }
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }
}
