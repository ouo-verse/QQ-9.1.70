package com.tencent.autotemplate.transition;

import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.extra.FaceInfo;
import com.tencent.autotemplate.extra.FrameInfo;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.utils.TavStickerUtils;
import com.tencent.autotemplate.utils.TemplateUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TransitionHelper {
    static IPatchRedirector $redirector_;
    protected List<TAVTransitionAutomaticEffect> applyTransitions;
    private ExtraData extraData;
    private List<FaceTransition> faceTransitions;
    protected String templateDir;
    private int transitionApplyType;
    protected List<TransitionEffectModel> transitionEffectModels;
    protected List<TAVSticker> transitionStickers;
    protected List<TAVTransitionAutomaticEffect> transitions;

    public TransitionHelper(List<TAVTransitionAutomaticEffect> list, ExtraData extraData, String str, List<TAVSticker> list2, List<FaceTransition> list3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, extraData, str, list2, list3);
            return;
        }
        this.transitionEffectModels = new ArrayList();
        this.transitionApplyType = 0;
        this.transitionStickers = list2;
        this.faceTransitions = list3;
        this.transitions = list;
        this.templateDir = str;
        this.extraData = extraData;
    }

    private void addExtraInfoToClip(TAVClip tAVClip) {
        String resourcePath = TemplateUtils.getResourcePath(tAVClip.getResource());
        FaceInfo faceInfo = this.extraData.getFaceInfo(resourcePath);
        FrameInfo frameInfo = this.extraData.getFrameInfo(resourcePath);
        tAVClip.putExtraTrackInfo(ExtraData.EXTRA_FACE_INFO, faceInfo);
        tAVClip.putExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO, frameInfo);
    }

    private void applyFaceTransitionsToChannel(TransitionStruct transitionStruct, TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect) {
        long duration = tAVTransitionAutomaticEffect.getDuration();
        CMTime cMTime = new CMTime(transitionStruct.totalDurationMsInTimeLine - duration, 1000);
        if (faceTransitionAvailable(transitionStruct.lastClip, transitionStruct.curClip) && cMTime.bigThan(transitionStruct.lastTransitionEndTime)) {
            transitionStruct.curChannel.add(new TAVClip(cMTime));
            transitionStruct.curClip.setStartTime(cMTime);
            transitionStruct.curChannel.add(transitionStruct.curClip);
            transitionStruct.totalDurationMsInTimeLine = (transitionStruct.totalDurationMsInTimeLine - duration) + (transitionStruct.curClip.getDuration().getTimeUs() / 1000);
            CMTimeRange cMTimeRange = new CMTimeRange(cMTime, new CMTime(duration, 1000));
            FaceTransition faceTransition = new FaceTransition();
            faceTransition.setTimeRange(cMTimeRange);
            faceTransition.setProcMethod(tAVTransitionAutomaticEffect.getProcMethod());
            faceTransition.setPosition(transitionStruct.index - 1);
            this.faceTransitions.add(faceTransition);
            addExtraInfoToClip(transitionStruct.curClip);
            addExtraInfoToClip(transitionStruct.lastClip);
            transitionStruct.lastTransitionEndTime = cMTimeRange.getEnd();
            List<TAVClip> list = transitionStruct.curChannel;
            transitionStruct.lastChannel = list;
            transitionStruct.lastClip = transitionStruct.curClip;
            transitionStruct.channels.add(list);
            return;
        }
        if (!CollectionUtil.isEmptyList(tAVTransitionAutomaticEffect.getSubTransitions())) {
            TAVTransitionAutomaticEffect randomTransition = randomTransition(tAVTransitionAutomaticEffect.getSubTransitions());
            if (TAVAutomaticTemplate.isMapping) {
                applyNormalTransitionInChannel(transitionStruct, randomTransition);
            } else {
                applyNormalTransitionsToChannel(transitionStruct, randomTransition);
            }
        }
    }

    private void applyNormalTransitionInChannel(TransitionStruct transitionStruct, TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect) {
        TAVSticker tAVSticker = getTAVSticker(tAVTransitionAutomaticEffect);
        if (tAVSticker != null) {
            TransitionEffectParam transitionParams = TransitionUtils.getTransitionParams(tAVSticker, tAVTransitionAutomaticEffect.effectId);
            if (shouldAddTransition(transitionParams, transitionStruct)) {
                applyTransitionsToClip(transitionStruct, transitionParams, tAVSticker);
                return;
            }
        }
        transitionStruct.lastChannel.add(transitionStruct.curClip);
        TAVClip tAVClip = transitionStruct.curClip;
        transitionStruct.lastClip = tAVClip;
        transitionStruct.totalDurationMsInTimeLine += tAVClip.getDuration().getTimeUs() / 1000;
    }

    @Deprecated
    private void applyNormalTransitionsToChannel(TransitionStruct transitionStruct, TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect) {
        long j3;
        CMTime cMTime;
        TAVSticker tAVSticker = getTAVSticker(tAVTransitionAutomaticEffect);
        if (tAVSticker != null) {
            j3 = ((float) tAVSticker.durationTime()) / 1000.0f;
            cMTime = new CMTime(transitionStruct.totalDurationMsInTimeLine - j3, 1000);
        } else {
            j3 = 0;
            cMTime = null;
        }
        CMTime cMTime2 = cMTime;
        long j16 = j3;
        if (tAVSticker != null && cMTime2.bigThan(transitionStruct.lastTransitionEndTime)) {
            applyTransitionsToClip(transitionStruct, j16, cMTime2, tAVSticker, tAVTransitionAutomaticEffect.effectId);
            return;
        }
        transitionStruct.lastChannel.add(transitionStruct.curClip);
        TAVClip tAVClip = transitionStruct.curClip;
        transitionStruct.lastClip = tAVClip;
        transitionStruct.totalDurationMsInTimeLine += tAVClip.getDuration().getTimeUs() / 1000;
    }

    private void applyTransitionsToChannel(TransitionStruct transitionStruct) {
        int i3 = transitionStruct.index;
        if (i3 == 0) {
            transitionStruct.curChannel.add(transitionStruct.curClip);
            transitionStruct.totalDurationMsInTimeLine += transitionStruct.curClip.getDuration().getTimeUs() / 1000;
            List<TAVClip> list = transitionStruct.curChannel;
            transitionStruct.lastChannel = list;
            transitionStruct.lastClip = transitionStruct.curClip;
            transitionStruct.channels.add(list);
            return;
        }
        if (i3 > this.applyTransitions.size()) {
            return;
        }
        TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect = this.applyTransitions.get(transitionStruct.index - 1);
        if (tAVTransitionAutomaticEffect.isFaceTransition()) {
            applyFaceTransitionsToChannel(transitionStruct, tAVTransitionAutomaticEffect);
        } else if (TAVAutomaticTemplate.isMapping) {
            applyNormalTransitionInChannel(transitionStruct, tAVTransitionAutomaticEffect);
        } else {
            applyNormalTransitionsToChannel(transitionStruct, tAVTransitionAutomaticEffect);
        }
    }

    private void applyTransitionsToChannels(List<? extends TAVTransitionableVideo> list, List<List<TAVClip>> list2) {
        TransitionStruct transitionStruct = new TransitionStruct();
        transitionStruct.totalDurationMsInTimeLine = 0L;
        transitionStruct.lastTransitionEndTime = CMTime.CMTimeZero;
        transitionStruct.lastChannel = null;
        transitionStruct.lastClip = null;
        transitionStruct.channels = list2;
        this.transitionEffectModels.clear();
        this.applyTransitions = TransitionUtils.randomTransitionEffects(this.transitions, list.size(), this.transitionApplyType);
        for (int i3 = 0; i3 < list.size(); i3++) {
            transitionStruct.curClip = (TAVClip) list.get(i3);
            transitionStruct.curChannel = new ArrayList();
            transitionStruct.index = i3;
            applyTransitionsToChannel(transitionStruct);
        }
    }

    @Deprecated
    private void applyTransitionsToClip(TransitionStruct transitionStruct, long j3, CMTime cMTime, TAVSticker tAVSticker, String str) {
        transitionStruct.curChannel.add(new TAVClip(cMTime));
        transitionStruct.curClip.setStartTime(cMTime);
        transitionStruct.curChannel.add(transitionStruct.curClip);
        transitionStruct.totalDurationMsInTimeLine = (transitionStruct.totalDurationMsInTimeLine - j3) + (transitionStruct.curClip.getDuration().getTimeUs() / 1000);
        tAVSticker.setTimeRange(new CMTimeRange(cMTime, new CMTime(j3, 1000)));
        this.transitionStickers.add(tAVSticker);
        TransitionEffectModel transitionEffectModel = new TransitionEffectModel();
        transitionEffectModel.setTransitionPosition(transitionStruct.index - 1);
        transitionEffectModel.setStickerId(tAVSticker.getStickerId());
        transitionEffectModel.setFilePath(tAVSticker.getFilePath());
        transitionEffectModel.setEffectId(str);
        this.transitionEffectModels.add(transitionEffectModel);
        transitionStruct.lastTransitionEndTime = tAVSticker.getTimeRange().getEnd();
        List<TAVClip> list = transitionStruct.curChannel;
        transitionStruct.lastChannel = list;
        transitionStruct.lastClip = transitionStruct.curClip;
        transitionStruct.channels.add(list);
    }

    private boolean shouldAddTransition(TransitionEffectParam transitionEffectParam, TransitionStruct transitionStruct) {
        TAVClip tAVClip;
        boolean z16;
        if (transitionStruct.index == 0) {
            return false;
        }
        List<TAVClip> list = transitionStruct.lastChannel;
        if (!CollectionUtil.isEmptyCollection(list)) {
            tAVClip = list.get(list.size() - 1);
        } else {
            tAVClip = null;
        }
        if (tAVClip != null) {
            z16 = tAVClip.getTimeRange().getEnd().sub(transitionStruct.lastTransitionEndTime).bigThan(transitionEffectParam.getLeftTransitionTime());
        } else {
            z16 = false;
        }
        boolean bigThan = transitionStruct.curClip.getDuration().bigThan(transitionEffectParam.getRightTransitionTime());
        if (!z16 || !bigThan) {
            return false;
        }
        return true;
    }

    public void applyTransitionToComposition(TAVComposition tAVComposition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tAVComposition);
            return;
        }
        List<? extends TAVTransitionableVideo> list = tAVComposition.getVideoChannels().get(0);
        tAVComposition.getVideoChannels().clear();
        tAVComposition.getAudioChannels().clear();
        ArrayList arrayList = new ArrayList();
        applyTransitionsToChannels(list, arrayList);
        for (List<TAVClip> list2 : arrayList) {
            tAVComposition.addVideoChannel(list2);
            tAVComposition.addAudioChannel(list2);
        }
    }

    public boolean clipSupportFaceTransition(TAVClip tAVClip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) tAVClip)).booleanValue();
        }
        String resourcePath = TemplateUtils.getResourcePath(tAVClip.getResource());
        FaceInfo faceInfo = this.extraData.getFaceInfo(resourcePath);
        FrameInfo frameInfo = this.extraData.getFrameInfo(resourcePath);
        if (faceInfo != null && frameInfo != null) {
            return true;
        }
        return false;
    }

    public boolean faceTransitionAvailable(TAVClip tAVClip, TAVClip tAVClip2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tAVClip, (Object) tAVClip2)).booleanValue();
        }
        if (clipSupportFaceTransition(tAVClip2) && clipSupportFaceTransition(tAVClip)) {
            return true;
        }
        return false;
    }

    public TAVSticker getTAVSticker(TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TAVSticker) iPatchRedirector.redirect((short) 9, (Object) this, (Object) tAVTransitionAutomaticEffect);
        }
        TAVSticker createSticker = TavStickerUtils.createSticker(this.templateDir + File.separator + tAVTransitionAutomaticEffect.parameter.filePath, false);
        if (createSticker == null) {
            return null;
        }
        createSticker.setStickerId(tAVTransitionAutomaticEffect.effectId);
        return createSticker;
    }

    public boolean needTransition(TAVComposition tAVComposition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) tAVComposition)).booleanValue();
        }
        List<? extends TAVTransitionableVideo> list = tAVComposition.getVideoChannels().get(0);
        if (list == null || list.size() <= 1 || CollectionUtil.isEmptyList(this.transitions)) {
            return false;
        }
        return true;
    }

    public TAVTransitionAutomaticEffect randomTransition(List<TAVTransitionAutomaticEffect> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TAVTransitionAutomaticEffect) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        }
        return list.get((int) (Math.random() * list.size()));
    }

    public void setTransitionApplyType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.transitionApplyType = i3;
        }
    }

    public void setTransitionEffectModels(List<TransitionEffectModel> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.transitionEffectModels = list;
        }
    }

    private void applyTransitionsToClip(TransitionStruct transitionStruct, TransitionEffectParam transitionEffectParam, TAVSticker tAVSticker) {
        long timeUs = transitionEffectParam.getOverlayTime().getTimeUs() / 1000;
        CMTime cMTime = new CMTime(transitionStruct.totalDurationMsInTimeLine - timeUs, 1000);
        transitionStruct.curChannel.add(new TAVClip(cMTime));
        transitionStruct.curClip.setStartTime(cMTime);
        transitionStruct.curChannel.add(transitionStruct.curClip);
        transitionStruct.totalDurationMsInTimeLine = (transitionStruct.totalDurationMsInTimeLine - timeUs) + (transitionStruct.curClip.getDuration().getTimeUs() / 1000);
        CMTime fromUs = CMTime.fromUs(tAVSticker.durationTime());
        if (TAVAutomaticTemplate.isMapping) {
            cMTime = cMTime.add(transitionEffectParam.getOverlayTime()).sub(transitionEffectParam.getLeftTransitionTime());
        }
        tAVSticker.setTimeRange(new CMTimeRange(cMTime, fromUs));
        if (TAVAutomaticTemplate.isMapping) {
            tAVSticker.getExtraBundle().putString("key_extra_sticker_type", TAVAutomaticRenderContext.STICKER_VIDEO_TRANSITION);
        }
        this.transitionStickers.add(tAVSticker);
        TransitionEffectModel transitionEffectModel = new TransitionEffectModel();
        transitionEffectModel.setTransitionPosition(transitionStruct.index - 1);
        transitionEffectModel.setStickerId(tAVSticker.getStickerId());
        transitionEffectModel.setFilePath(tAVSticker.getFilePath());
        transitionEffectModel.setEffectId(transitionEffectParam.getEffectId());
        transitionEffectModel.setLeftTransitionMs(transitionEffectParam.getLeftTransitionTime().getTimeUs() / 1000);
        transitionEffectModel.setRightTransitionMs(transitionEffectParam.getRightTransitionTime().getTimeUs() / 1000);
        transitionEffectModel.setOverlayTransitionMs(transitionEffectParam.getOverlayTime().getTimeUs() / 1000);
        transitionEffectModel.setTimeRange(tAVSticker.getTimeRange());
        this.transitionEffectModels.add(transitionEffectModel);
        transitionStruct.lastTransitionEndTime = tAVSticker.getTimeRange().getEnd();
        List<TAVClip> list = transitionStruct.curChannel;
        transitionStruct.lastChannel = list;
        transitionStruct.lastClip = transitionStruct.curClip;
        transitionStruct.channels.add(list);
    }
}
