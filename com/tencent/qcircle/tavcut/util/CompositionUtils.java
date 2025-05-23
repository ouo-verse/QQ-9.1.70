package com.tencent.qcircle.tavcut.util;

import com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CompositionUtils {
    public static void removeTAVAspectEffect(TAVComposition tAVComposition) {
        if (tAVComposition == null) {
            return;
        }
        List<List<? extends TAVTransitionableVideo>> videoChannels = tAVComposition.getVideoChannels();
        if (CollectionUtil.isEmptyList(videoChannels)) {
            return;
        }
        for (List<? extends TAVTransitionableVideo> list : videoChannels) {
            if (!CollectionUtil.isEmptyList(list)) {
                Iterator<? extends TAVTransitionableVideo> it = list.iterator();
                while (it.hasNext()) {
                    TAVClip tAVClip = (TAVClip) it.next();
                    if (tAVClip != null && tAVClip.getVideoConfiguration() != null && tAVClip.getVideoConfiguration().getEffects() != null && tAVClip.getVideoConfiguration().getEffects().size() >= 1) {
                        Iterator<TAVVideoEffect> it5 = tAVClip.getVideoConfiguration().getEffects().iterator();
                        while (it5.hasNext()) {
                            if (it5.next() instanceof TAVTimeRangeAspectFillEffect) {
                                it5.remove();
                            }
                        }
                    }
                }
            }
        }
    }
}
