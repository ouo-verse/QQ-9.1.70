package com.tencent.autotemplate.transition;

import android.support.annotation.NonNull;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TransitionUtils {
    static IPatchRedirector $redirector_;

    public TransitionUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TransitionEffectParam getFaceTransitionParam(CMTime cMTime, String str) {
        TransitionEffectParam transitionEffectParam = new TransitionEffectParam();
        transitionEffectParam.setEffectId(str);
        transitionEffectParam.setLeftTransitionTime(cMTime);
        transitionEffectParam.setRightTransitionTime(cMTime);
        transitionEffectParam.setOverlayTime(cMTime);
        transitionEffectParam.setDurationTime(cMTime);
        transitionEffectParam.setFilePath("");
        transitionEffectParam.setFaceTransition(true);
        return transitionEffectParam;
    }

    public static TransitionEffectParam getTransitionParams(@NonNull TAVSticker tAVSticker, String str) {
        TransitionEffectParam transitionEffectParam = new TransitionEffectParam();
        List<TAVStickerLayerInfo> stickerLayerInfos = tAVSticker.getStickerLayerInfos();
        if (CollectionUtil.isEmptyList(stickerLayerInfos)) {
            return transitionEffectParam;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVStickerLayerInfo tAVStickerLayerInfo : stickerLayerInfos) {
            if (TAVAutomaticRenderContext.isLayerFillAble(tAVStickerLayerInfo)) {
                arrayList.add(tAVStickerLayerInfo);
            }
        }
        Collections.sort(arrayList, new Comparator<TAVStickerLayerInfo>() { // from class: com.tencent.autotemplate.transition.TransitionUtils.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.util.Comparator
            public int compare(TAVStickerLayerInfo tAVStickerLayerInfo2, TAVStickerLayerInfo tAVStickerLayerInfo3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? tAVStickerLayerInfo2.getLayerIndex() - tAVStickerLayerInfo3.getLayerIndex() : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tAVStickerLayerInfo2, (Object) tAVStickerLayerInfo3)).intValue();
            }
        });
        ArrayList<TAVStickerImageItem> stickerImageItems = tAVSticker.getStickerImageItems();
        if (stickerImageItems.size() == 2 && arrayList.size() == 0) {
            for (int i3 = 0; i3 < stickerImageItems.size(); i3++) {
                arrayList.add(stickerImageItems.get(i3).getLayerInfo());
            }
        }
        if (arrayList.size() >= 2) {
            TAVStickerLayerInfo tAVStickerLayerInfo2 = (TAVStickerLayerInfo) arrayList.get(0);
            CMTime end = tAVStickerLayerInfo2.getTimeRange().getEnd();
            CMTime duration = tAVStickerLayerInfo2.getTimeRange().getDuration();
            TAVStickerLayerInfo tAVStickerLayerInfo3 = (TAVStickerLayerInfo) arrayList.get(1);
            CMTime start = tAVStickerLayerInfo3.getTimeRange().getStart();
            CMTime duration2 = tAVStickerLayerInfo3.getTimeRange().getDuration();
            CMTime sub = end.sub(start);
            transitionEffectParam.setEffectId(str);
            transitionEffectParam.setLeftTransitionTime(duration);
            transitionEffectParam.setRightTransitionTime(duration2);
            transitionEffectParam.setOverlayTime(sub);
            transitionEffectParam.setFilePath(tAVSticker.getFilePath());
            transitionEffectParam.setFaceTransition(false);
            transitionEffectParam.setDurationTime(CMTime.fromUs(tAVSticker.durationTime()));
        }
        return transitionEffectParam;
    }

    @NonNull
    public static ArrayList<TAVTransitionAutomaticEffect> randomTransitionEffects(@NonNull List<TAVTransitionAutomaticEffect> list, int i3, int i16) {
        ArrayList<TAVTransitionAutomaticEffect> arrayList = new ArrayList<>();
        if (CollectionUtil.isEmptyList(list)) {
            return arrayList;
        }
        int i17 = i3 - 1;
        int i18 = 0;
        if (TAVRhythmAutomaticTemplate.ApplyEffectType.DefaultApplyEffect.ordinal() == i16) {
            TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect = list.get(0);
            while (i18 < i17) {
                arrayList.add(tAVTransitionAutomaticEffect);
                i18++;
            }
        } else if (TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal() == i16) {
            while (i18 < i17) {
                arrayList.add(list.get((int) (Math.random() * list.size())));
                i18++;
            }
        } else if (TAVRhythmAutomaticTemplate.ApplyEffectType.SequenceApplyEffect.ordinal() == i16) {
            while (i18 < i17) {
                arrayList.add(list.get(i18 % list.size()));
                i18++;
            }
        }
        return arrayList;
    }
}
