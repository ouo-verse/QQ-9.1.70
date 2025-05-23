package com.tencent.autotemplate.transition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.extra.FaceInfo;
import com.tencent.autotemplate.extra.FrameInfo;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.autotemplate.utils.TAVMovieClipEx;
import com.tencent.autotemplate.utils.TavStickerUtils;
import com.tencent.autotemplate.utils.TemplateUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.resource.TAVMovieTrackResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RhythmTransitionHelper {
    static IPatchRedirector $redirector_;
    private ExtraData extraData;
    private ArrayList<TAVTransitionAutomaticEffect> mTransitionAutomaticEffectList;
    private ArrayList<Long> mTransitionDurationMsList;
    private ArrayList<TransitionEffectParam> mTransitionEffectParams;
    private TAVRhythmEffects rhythmEffects;
    public String templateDir;
    public long transThreshold;
    protected int transitionApplyType;

    public RhythmTransitionHelper(RhythmTransitionParams rhythmTransitionParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rhythmTransitionParams);
            return;
        }
        this.mTransitionDurationMsList = new ArrayList<>();
        this.mTransitionEffectParams = new ArrayList<>();
        this.mTransitionAutomaticEffectList = new ArrayList<>();
        this.rhythmEffects = rhythmTransitionParams.rhythmEffects;
        this.transitionApplyType = rhythmTransitionParams.transitionApplyType;
        this.templateDir = rhythmTransitionParams.templateDir;
        this.extraData = rhythmTransitionParams.extraData;
        this.transThreshold = rhythmTransitionParams.transThreshold;
    }

    private void checkTransitonAvailable(List<TAVTransitionAutomaticEffect> list, List<TAVMovieClip> list2) {
        int i3;
        for (int i16 = 0; i16 < list.size(); i16++) {
            TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect = list.get(i16);
            if (tAVTransitionAutomaticEffect.isFaceTransition() && (i3 = i16 + 1) < list2.size()) {
                TAVMovieClip tAVMovieClip = list2.get(i16);
                TAVMovieClip tAVMovieClip2 = list2.get(i3);
                if ((!clipSupportFaceTransition(tAVMovieClip) || !clipSupportFaceTransition(tAVMovieClip2)) && !CollectionUtil.isEmptyList(tAVTransitionAutomaticEffect.subTransitions)) {
                    TAVTransitionAutomaticEffect faceTransitionSubTransition = getFaceTransitionSubTransition(tAVTransitionAutomaticEffect.subTransitions);
                    list.remove(i16);
                    list.add(i16, faceTransitionSubTransition);
                }
            }
        }
    }

    private void reverseMovieTrackResource(@NonNull TAVMovieClipEx tAVMovieClipEx, @Nullable TAVMovieClipEx tAVMovieClipEx2, int i3, @NonNull TAVMovieResource tAVMovieResource) {
        CMTimeRange timeRange = tAVMovieResource.getTimeRange();
        TransitionEffectParam transitionEffectParam = tAVMovieClipEx.getTransitionEffectParam();
        CMTime leftTransitionTime = transitionEffectParam.getLeftTransitionTime();
        CMTime divide = transitionEffectParam.getOverlayTime().divide(2.0f);
        if (i3 == 0) {
            if (timeRange.getDuration().bigThan(leftTransitionTime)) {
                timeRange.setDuration(timeRange.getDuration().sub(divide));
                tAVMovieResource.setTimeRange(timeRange);
                tAVMovieClipEx.setCurrentReverse(true);
                return;
            }
            return;
        }
        if (tAVMovieClipEx2 == null) {
            return;
        }
        TransitionEffectParam transitionEffectParam2 = tAVMovieClipEx2.getTransitionEffectParam();
        CMTime divide2 = transitionEffectParam2.getOverlayTime().divide(2);
        if (tAVMovieClipEx2.isCurrentReverse()) {
            if (tAVMovieClipEx.getTavMovieClip().getResource().getTimeRange().getDuration().bigThan(transitionEffectParam2.getRightTransitionTime())) {
                CMTime add = timeRange.getStart().add(divide2);
                CMTime sub = timeRange.getDuration().sub(divide2);
                timeRange.setStart(add);
                timeRange.setDuration(sub);
                tAVMovieResource.setTimeRange(timeRange);
                tAVMovieClipEx.setLastReverse(true);
            } else {
                CMTime sub2 = timeRange.getStart().sub(divide2);
                CMTime add2 = timeRange.getDuration().add(divide2);
                timeRange.setStart(sub2);
                timeRange.setDuration(add2);
                tAVMovieClipEx2.getTavMovieClip().getResource().setTimeRange(timeRange);
                tAVMovieClipEx2.setCurrentReverse(false);
                tAVMovieClipEx.setLastReverse(false);
            }
        } else {
            tAVMovieClipEx.setLastReverse(false);
        }
        if (timeRange.getDuration().bigThan(leftTransitionTime)) {
            timeRange.setDuration(timeRange.getDuration().sub(divide));
            tAVMovieResource.setTimeRange(timeRange);
            tAVMovieClipEx.setCurrentReverse(true);
            return;
        }
        tAVMovieClipEx.setCurrentReverse(false);
    }

    public void addExtraInfoToClip(List<List<TAVClip>> list, List<FaceTransition> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list, (Object) list2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmptyList(list2)) {
            Iterator<FaceTransition> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.addAll(getClipsFromChannels(list, it.next().getTimeRange()));
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            addExtraInfoToClip((TAVClip) it5.next());
        }
    }

    public boolean clipSupportFaceTransition(TAVMovieClip tAVMovieClip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) tAVMovieClip)).booleanValue();
        }
        String tAVMovieClipFilePath = TemplateUtils.getTAVMovieClipFilePath(tAVMovieClip);
        FaceInfo faceInfo = this.extraData.getFaceInfo(tAVMovieClipFilePath);
        FrameInfo frameInfo = this.extraData.getFrameInfo(tAVMovieClipFilePath);
        if (faceInfo != null && frameInfo != null) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void computeTransitionTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mTransitionDurationMsList.clear();
        ArrayList<TAVTransitionAutomaticEffect> arrayList = this.mTransitionAutomaticEffectList;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < this.mTransitionAutomaticEffectList.size(); i3++) {
                TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect = this.mTransitionAutomaticEffectList.get(i3);
                if (tAVTransitionAutomaticEffect.isFaceTransition()) {
                    this.mTransitionDurationMsList.add(Long.valueOf(tAVTransitionAutomaticEffect.getDuration()));
                } else {
                    if (new TAVMovieSticker(this.templateDir + File.separator + tAVTransitionAutomaticEffect.parameter.filePath).getSticker() != null) {
                        this.mTransitionDurationMsList.add(Long.valueOf(((float) r2.getSticker().durationTime()) / 1000.0f));
                    }
                }
            }
        }
    }

    public void computeTransitionTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mTransitionDurationMsList.clear();
        this.mTransitionEffectParams.clear();
        if (CollectionUtil.isEmptyList(this.mTransitionAutomaticEffectList)) {
            return;
        }
        for (int i3 = 0; i3 < this.mTransitionAutomaticEffectList.size(); i3++) {
            TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect = this.mTransitionAutomaticEffectList.get(i3);
            if (tAVTransitionAutomaticEffect.isFaceTransition()) {
                long duration = tAVTransitionAutomaticEffect.getDuration();
                this.mTransitionDurationMsList.add(Long.valueOf(duration));
                this.mTransitionEffectParams.add(TransitionUtils.getFaceTransitionParam(CMTime.fromMs(duration), tAVTransitionAutomaticEffect.effectId));
            } else {
                TAVSticker createSticker = TavStickerUtils.createSticker(this.templateDir + File.separator + tAVTransitionAutomaticEffect.parameter.filePath, false);
                if (createSticker != null) {
                    this.mTransitionDurationMsList.add(Long.valueOf(createSticker.durationTime() / 1000));
                    this.mTransitionEffectParams.add(TransitionUtils.getTransitionParams(createSticker, tAVTransitionAutomaticEffect.effectId));
                }
            }
        }
    }

    public List<TAVClip> getClipsFromChannel(List<TAVClip> list, CMTimeRange cMTimeRange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this, (Object) list, (Object) cMTimeRange);
        }
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmptyList(list)) {
            CMTime cMTime = CMTime.CMTimeZero;
            for (TAVClip tAVClip : list) {
                CMTime duration = tAVClip.getDuration();
                if (Math.max(cMTime.getTimeUs(), cMTimeRange.getStart().getTimeUs()) <= Math.min(cMTime.add(duration).getTimeUs(), cMTimeRange.getEnd().getTimeUs())) {
                    arrayList.add(tAVClip);
                }
                cMTime = cMTime.add(duration);
            }
        }
        return arrayList;
    }

    public List<TAVClip> getClipsFromChannels(List<List<TAVClip>> list, CMTimeRange cMTimeRange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this, (Object) list, (Object) cMTimeRange);
        }
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmptyList(list)) {
            Iterator<List<TAVClip>> it = list.iterator();
            while (it.hasNext()) {
                arrayList.addAll(getClipsFromChannel(it.next(), cMTimeRange));
            }
        }
        return arrayList;
    }

    public TAVTransitionAutomaticEffect getFaceTransitionSubTransition(List<TAVTransitionAutomaticEffect> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TAVTransitionAutomaticEffect) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        }
        if (TAVRhythmAutomaticTemplate.ApplyEffectType.RandomApplyEffect.ordinal() == this.transitionApplyType) {
            return list.get((int) (Math.random() * list.size()));
        }
        return list.get(0);
    }

    public ArrayList<TAVTransitionAutomaticEffect> getTransitionAutomaticEffectList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mTransitionAutomaticEffectList;
    }

    public ArrayList<Long> getTransitionDurationMsList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mTransitionDurationMsList;
    }

    @Nullable
    public TAVTransitionAutomaticEffect getTransitionEffect(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TAVTransitionAutomaticEffect) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        ArrayList<TAVTransitionAutomaticEffect> arrayList = this.mTransitionAutomaticEffectList;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (i3 >= this.mTransitionAutomaticEffectList.size()) {
                i3 %= this.mTransitionAutomaticEffectList.size();
            }
            return this.mTransitionAutomaticEffectList.get(i3);
        }
        return null;
    }

    public TAVSticker getTransitionSticker(TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (TAVSticker) iPatchRedirector.redirect((short) 13, (Object) this, (Object) tAVTransitionAutomaticEffect);
        }
        TAVSticker createSticker = TavStickerUtils.createSticker(this.templateDir + File.separator + tAVTransitionAutomaticEffect.parameter.filePath, false);
        if (createSticker == null) {
            return null;
        }
        createSticker.setStickerId(tAVTransitionAutomaticEffect.effectId);
        return createSticker;
    }

    public boolean isDurationEnoughForTransition(CMTime cMTime, CMTime cMTime2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, cMTime, cMTime2, Long.valueOf(j3))).booleanValue();
        }
        long timeUs = cMTime.getTimeUs() / 1000;
        long timeUs2 = cMTime2.getTimeUs() / 1000;
        long j16 = this.transThreshold;
        if (timeUs > j16 && timeUs2 > j16 && timeUs > j3 && timeUs2 > j3) {
            return true;
        }
        return false;
    }

    public void reRandomTransitions(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.mTransitionAutomaticEffectList = TransitionUtils.randomTransitionEffects(this.rhythmEffects.getTransitions(), i3, this.transitionApplyType);
        if (TAVAutomaticTemplate.isMapping) {
            computeTransitionTimes();
        } else {
            computeTransitionTime();
        }
    }

    @Deprecated
    public void reserveClipTransitionTime(List<TAVMovieClipEx> list) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (this.mTransitionDurationMsList.isEmpty()) {
            return;
        }
        int i3 = 0;
        for (TAVMovieClipEx tAVMovieClipEx : list) {
            TAVMovieResource resource = tAVMovieClipEx.getTavMovieClip().getResource();
            if (resource instanceof TAVMovieTrackResource) {
                CMTimeRange timeRange = resource.getTimeRange();
                if (i3 < this.mTransitionEffectParams.size()) {
                    j3 = this.mTransitionDurationMsList.get(i3).longValue();
                } else {
                    j3 = 0;
                }
                if (timeRange.getDuration().getTimeUs() / 1000 > j3) {
                    CMTime add = timeRange.getStart().add(new CMTime(j3 / 2, 1000));
                    CMTime sub = timeRange.getDuration().sub(new CMTime(j3, 1000));
                    timeRange.setStart(add);
                    timeRange.setDuration(sub);
                    resource.setTimeRange(timeRange);
                    tAVMovieClipEx.setReverse(true);
                }
            } else if (resource instanceof TAVMovieImageResource) {
                tAVMovieClipEx.setReverse(true);
            }
            i3++;
        }
    }

    public void reserveClipTransitionsTime(List<TAVMovieClipEx> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (this.mTransitionDurationMsList.isEmpty()) {
            return;
        }
        TAVMovieClipEx tAVMovieClipEx = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            TAVMovieClipEx tAVMovieClipEx2 = list.get(i3);
            if (i3 >= this.mTransitionEffectParams.size()) {
                tAVMovieClipEx2.setTransitionEffectParam(new TransitionEffectParam());
            } else {
                tAVMovieClipEx2.setTransitionEffectParam(this.mTransitionEffectParams.get(i3));
            }
            TAVMovieResource resource = tAVMovieClipEx2.getTavMovieClip().getResource();
            if (i3 > 0) {
                tAVMovieClipEx = list.get(i3 - 1);
            }
            if (resource instanceof TAVMovieTrackResource) {
                reverseMovieTrackResource(tAVMovieClipEx2, tAVMovieClipEx, i3, resource);
            } else if (resource instanceof TAVMovieImageResource) {
                tAVMovieClipEx2.setLastReverse(true);
                tAVMovieClipEx2.setCurrentReverse(true);
            }
        }
    }

    public void setTransitionAutomaticEffectList(ArrayList<TAVTransitionAutomaticEffect> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
        } else {
            this.mTransitionAutomaticEffectList = arrayList;
        }
    }

    private void addExtraInfoToClip(TAVClip tAVClip) {
        String resourcePath = TemplateUtils.getResourcePath(tAVClip.getResource());
        FaceInfo faceInfo = this.extraData.getFaceInfo(resourcePath);
        FrameInfo frameInfo = this.extraData.getFrameInfo(resourcePath);
        tAVClip.putExtraTrackInfo(ExtraData.EXTRA_FACE_INFO, faceInfo);
        tAVClip.putExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO, frameInfo);
    }
}
