package com.tencent.autotemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.autotemplate.model.TAVPagAutomaticEffect;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.model.rhythm.TAVEffectPoint;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.autotemplate.model.rhythm.TAVTimeAutomaticEffect;
import com.tencent.autotemplate.parse.RhythmDataBean;
import com.tencent.autotemplate.transition.FaceTransition;
import com.tencent.autotemplate.transition.RhythmTransitionHelper;
import com.tencent.autotemplate.transition.RhythmTransitionParams;
import com.tencent.autotemplate.transition.TransitionEffectModel;
import com.tencent.autotemplate.transition.TransitionEffectParam;
import com.tencent.autotemplate.transition.TransitionUtils;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.autotemplate.utils.TAVMovieClipEx;
import com.tencent.autotemplate.utils.TemplateUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.taveffect.utils.RandomUtils;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVRhythmAutomaticTemplate extends TAVAutomaticTemplate {
    static IPatchRedirector $redirector_ = null;
    public static final String BpmValueTrail = "BpmValueTrail";
    public static final String DefaultTrail = "DefalutTrail";
    public static final String DrumTrail = "DrumTrail";
    public static final String FastRhythmTrail = "FastRhythmTrail";
    public static final String HighlightValueTrail = "HighlightValueTrail";
    public static final long IMAGE_MIN_DURATION = 10000;
    public static final String PuckingDrum = "PuckingDrum";
    private static final int SECONDS_MS = 1000;
    public static final String SlowRhythmTrail = "SlowRhythmTrail";
    public static final String StartValueTrail = "StartValueTrail";
    public static final String TAG = "TAVRhythmTemplate";
    public transient TAVRhythmAdjustClipType adjustClipType;
    private transient List<TAVEffectPoint> bpmEffectPoints;
    private transient List<TAVEffectPoint> drumEffectPoints;
    private transient List<TAVEffectAutomaticEffect> highlightEffects;
    private transient String highlightEffectsPath;
    private transient List<TAVEffectPoint> highlightPoints;
    private transient boolean isRhythmTemplate;
    private transient List<TAVRhythmMovieSegment> mCorrectSegments;
    private transient int mTransitionLoopIndex;
    private transient CMTime maxDuration;
    private transient CMTime maxVideoDuration;
    private transient TAVMovie movie;
    private transient CMTime musicRealStart;
    private transient int randomIndex;
    private transient TAVRhythmRandomType randomType;
    private transient String rhythmEffectID;
    private transient TAVRhythmEffects rhythmEffects;
    private RhythmTransitionHelper rhythmTransitionHelper;
    public transient TAVRhythmEffectType rhythmType;
    private transient List<List<TAVEffectAutomaticEffect>> secondApplyEffects;
    private transient List<Integer> secondApplyEffectsRandomIndices;
    private transient List<TAVEffectPoint> secondEffectPoints;
    public transient TAVRhythmSecondEffectType secondEffectType;
    private transient List<List<TAVEffectAutomaticEffect>> secondEffects;
    private transient String secondEffectsPath;
    private transient List<TAVRhythmMovieSegment> segments;
    private transient boolean singleResource;
    private transient List<TAVEffectPoint> slowEffectPoints;
    private transient CMTime start;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ApplyEffectType {
        private static final /* synthetic */ ApplyEffectType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ApplyEffectType DefaultApplyEffect;
        public static final ApplyEffectType RandomApplyEffect;
        public static final ApplyEffectType SequenceApplyEffect;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12371);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ApplyEffectType applyEffectType = new ApplyEffectType("DefaultApplyEffect", 0);
            DefaultApplyEffect = applyEffectType;
            ApplyEffectType applyEffectType2 = new ApplyEffectType("RandomApplyEffect", 1);
            RandomApplyEffect = applyEffectType2;
            ApplyEffectType applyEffectType3 = new ApplyEffectType("SequenceApplyEffect", 2);
            SequenceApplyEffect = applyEffectType3;
            $VALUES = new ApplyEffectType[]{applyEffectType, applyEffectType2, applyEffectType3};
        }

        ApplyEffectType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ApplyEffectType valueOf(String str) {
            return (ApplyEffectType) Enum.valueOf(ApplyEffectType.class, str);
        }

        public static ApplyEffectType[] values() {
            return (ApplyEffectType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class TAVRhythmAdjustClipType {
        private static final /* synthetic */ TAVRhythmAdjustClipType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TAVRhythmAdjustClipType TAVRhythmAdjustClipMode1;
        public static final TAVRhythmAdjustClipType TAVRhythmAdjustClipMode2;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12387);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TAVRhythmAdjustClipType tAVRhythmAdjustClipType = new TAVRhythmAdjustClipType("TAVRhythmAdjustClipMode1", 0);
            TAVRhythmAdjustClipMode1 = tAVRhythmAdjustClipType;
            TAVRhythmAdjustClipType tAVRhythmAdjustClipType2 = new TAVRhythmAdjustClipType("TAVRhythmAdjustClipMode2", 1);
            TAVRhythmAdjustClipMode2 = tAVRhythmAdjustClipType2;
            $VALUES = new TAVRhythmAdjustClipType[]{tAVRhythmAdjustClipType, tAVRhythmAdjustClipType2};
        }

        TAVRhythmAdjustClipType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TAVRhythmAdjustClipType valueOf(String str) {
            return (TAVRhythmAdjustClipType) Enum.valueOf(TAVRhythmAdjustClipType.class, str);
        }

        public static TAVRhythmAdjustClipType[] values() {
            return (TAVRhythmAdjustClipType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class TAVRhythmEffectType {
        private static final /* synthetic */ TAVRhythmEffectType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TAVRhythmEffectType TAVRhythmBPMChannel;
        public static final TAVRhythmEffectType TAVRhythmSlowChannel;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12403);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TAVRhythmEffectType tAVRhythmEffectType = new TAVRhythmEffectType("TAVRhythmBPMChannel", 0);
            TAVRhythmBPMChannel = tAVRhythmEffectType;
            TAVRhythmEffectType tAVRhythmEffectType2 = new TAVRhythmEffectType("TAVRhythmSlowChannel", 1);
            TAVRhythmSlowChannel = tAVRhythmEffectType2;
            $VALUES = new TAVRhythmEffectType[]{tAVRhythmEffectType, tAVRhythmEffectType2};
        }

        TAVRhythmEffectType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TAVRhythmEffectType valueOf(String str) {
            return (TAVRhythmEffectType) Enum.valueOf(TAVRhythmEffectType.class, str);
        }

        public static TAVRhythmEffectType[] values() {
            return (TAVRhythmEffectType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class TAVRhythmRandomType {
        private static final /* synthetic */ TAVRhythmRandomType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TAVRhythmRandomType TAVRhythmMultiCutMode1;
        public static final TAVRhythmRandomType TAVRhythmMultiCutMode2;
        public static final TAVRhythmRandomType TAVRhythmMultiPicDrum;
        public static final TAVRhythmRandomType TAVRhythmMultiPicSlow;
        public static final TAVRhythmRandomType TAVRhythmSingleBPM;
        public static final TAVRhythmRandomType TAVRhythmSingleSlow;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12412);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TAVRhythmRandomType tAVRhythmRandomType = new TAVRhythmRandomType("TAVRhythmSingleSlow", 0);
            TAVRhythmSingleSlow = tAVRhythmRandomType;
            TAVRhythmRandomType tAVRhythmRandomType2 = new TAVRhythmRandomType("TAVRhythmSingleBPM", 1);
            TAVRhythmSingleBPM = tAVRhythmRandomType2;
            TAVRhythmRandomType tAVRhythmRandomType3 = new TAVRhythmRandomType("TAVRhythmMultiCutMode1", 2);
            TAVRhythmMultiCutMode1 = tAVRhythmRandomType3;
            TAVRhythmRandomType tAVRhythmRandomType4 = new TAVRhythmRandomType("TAVRhythmMultiCutMode2", 3);
            TAVRhythmMultiCutMode2 = tAVRhythmRandomType4;
            TAVRhythmRandomType tAVRhythmRandomType5 = new TAVRhythmRandomType("TAVRhythmMultiPicDrum", 4);
            TAVRhythmMultiPicDrum = tAVRhythmRandomType5;
            TAVRhythmRandomType tAVRhythmRandomType6 = new TAVRhythmRandomType("TAVRhythmMultiPicSlow", 5);
            TAVRhythmMultiPicSlow = tAVRhythmRandomType6;
            $VALUES = new TAVRhythmRandomType[]{tAVRhythmRandomType, tAVRhythmRandomType2, tAVRhythmRandomType3, tAVRhythmRandomType4, tAVRhythmRandomType5, tAVRhythmRandomType6};
        }

        TAVRhythmRandomType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TAVRhythmRandomType valueOf(String str) {
            return (TAVRhythmRandomType) Enum.valueOf(TAVRhythmRandomType.class, str);
        }

        public static TAVRhythmRandomType[] values() {
            return (TAVRhythmRandomType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class TAVRhythmSecondEffectType {
        private static final /* synthetic */ TAVRhythmSecondEffectType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TAVRhythmSecondEffectType TAVRhythmSecondEffectFreeze;
        public static final TAVRhythmSecondEffectType TAVRhythmSecondEffectMix;
        public static final TAVRhythmSecondEffectType TAVRhythmSecondEffectSpeed;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12417);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TAVRhythmSecondEffectType tAVRhythmSecondEffectType = new TAVRhythmSecondEffectType("TAVRhythmSecondEffectSpeed", 0);
            TAVRhythmSecondEffectSpeed = tAVRhythmSecondEffectType;
            TAVRhythmSecondEffectType tAVRhythmSecondEffectType2 = new TAVRhythmSecondEffectType("TAVRhythmSecondEffectFreeze", 1);
            TAVRhythmSecondEffectFreeze = tAVRhythmSecondEffectType2;
            TAVRhythmSecondEffectType tAVRhythmSecondEffectType3 = new TAVRhythmSecondEffectType("TAVRhythmSecondEffectMix", 2);
            TAVRhythmSecondEffectMix = tAVRhythmSecondEffectType3;
            $VALUES = new TAVRhythmSecondEffectType[]{tAVRhythmSecondEffectType, tAVRhythmSecondEffectType2, tAVRhythmSecondEffectType3};
        }

        TAVRhythmSecondEffectType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TAVRhythmSecondEffectType valueOf(String str) {
            return (TAVRhythmSecondEffectType) Enum.valueOf(TAVRhythmSecondEffectType.class, str);
        }

        public static TAVRhythmSecondEffectType[] values() {
            return (TAVRhythmSecondEffectType[]) $VALUES.clone();
        }
    }

    public TAVRhythmAutomaticTemplate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.adjustClipType = TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1;
        this.rhythmType = TAVRhythmEffectType.TAVRhythmBPMChannel;
        this.secondEffectType = TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix;
        this.highlightPoints = new ArrayList();
        this.drumEffectPoints = new ArrayList();
        this.slowEffectPoints = new ArrayList();
        this.bpmEffectPoints = new ArrayList();
        CMTime cMTime = CMTime.CMTimeZero;
        this.start = cMTime;
        this.musicRealStart = cMTime;
        this.maxDuration = new CMTime(TTL.MAX_VALUE, 1000);
        this.maxVideoDuration = new CMTime(60000L, 1000);
        this.secondEffectPoints = new ArrayList();
        this.highlightEffects = new ArrayList();
        this.secondEffects = new ArrayList();
        this.secondApplyEffects = new ArrayList();
        this.secondApplyEffectsRandomIndices = new ArrayList();
        this.segments = new ArrayList();
        this.mCorrectSegments = new ArrayList();
        this.mTransitionLoopIndex = 0;
    }

    private void addOverLayTimeToClip(CMTime cMTime, TAVMovieResource tAVMovieResource) {
        CMTimeRange timeRange = tAVMovieResource.getTimeRange();
        if (tAVMovieResource instanceof TAVMovieImageResource) {
            timeRange.setDuration(timeRange.getDuration().add(cMTime));
            tAVMovieResource.setDuration(timeRange.getDuration());
        } else {
            timeRange.setStart(timeRange.getStart().sub(cMTime));
            timeRange.setDuration(timeRange.getDuration().add(cMTime));
            tAVMovieResource.setDuration(timeRange.getDuration());
        }
    }

    private void applyTimeEffectToEffectPoint(TAVComposition tAVComposition) {
        List<TAVClip> applyTimeEffectsInPreviewTimeline;
        List<? extends TAVTransitionableVideo> list = tAVComposition.getVideoChannels().get(0);
        CMTime calculateTotalTime = TemplateUtils.calculateTotalTime(tAVComposition);
        ArrayList arrayList = new ArrayList();
        Iterator<List<TAVEffectAutomaticEffect>> it = this.secondApplyEffects.iterator();
        while (it.hasNext()) {
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : it.next()) {
                if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime) {
                    TAVTimeAutomaticEffect copyTimeEffectFrom = tAVEffectAutomaticEffect.copyTimeEffectFrom();
                    TAVMovieTimeEffect convertToMovieTimeEffect = copyTimeEffectFrom.convertToMovieTimeEffect(calculateTotalTime.getTimeSeconds() * 1000.0f);
                    arrayList.add(convertToMovieTimeEffect);
                    appendDebugInfo("add time effect to effect point at:" + copyTimeEffectFrom.getStartOffset() + " ,speed:" + convertToMovieTimeEffect.getSpeed());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (this.singleResource) {
            applyTimeEffectsInPreviewTimeline = TAVRhythmTimeEffectUtils.applyTimeEffectsInPreviewTimeline(list, arrayList);
        } else {
            applyTimeEffectsInPreviewTimeline = TAVRhythmTimeEffectWithCutUtils.applyTimeEffectsInPreviewTimeline(list, arrayList, covertTAVEffectPointsToCMTimes(this.secondEffectPoints));
        }
        tAVComposition.getVideoChannels().remove(0);
        tAVComposition.getVideoChannels().add(0, applyTimeEffectsInPreviewTimeline);
    }

    private void applyTimeEffectToHighlightPoint(TAVComposition tAVComposition) {
        if (!this.singleResource) {
            return;
        }
        for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : this.highlightEffects) {
            if (tAVEffectAutomaticEffect != null && tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime && !this.highlightPoints.isEmpty()) {
                TAVTimeAutomaticEffect copyTimeEffectFrom = tAVEffectAutomaticEffect.copyTimeEffectFrom();
                List<? extends TAVTransitionableVideo> list = tAVComposition.getVideoChannels().get(0);
                Iterator<? extends TAVTransitionableVideo> it = list.iterator();
                long j3 = 0;
                while (it.hasNext()) {
                    j3 = ((float) j3) + (((TAVClip) it.next()).getResource().getScaledDuration().getTimeSeconds() * 1000.0f);
                }
                float time = ((float) this.highlightPoints.get(0).getTime()) - (this.musicRealStart.getTimeSeconds() * 1000.0f);
                copyTimeEffectFrom.setStartOffset(time);
                copyTimeEffectFrom.setDuration((r5 - time) / copyTimeEffectFrom.getSpeed());
                TAVMovieTimeEffect convertToMovieTimeEffect = copyTimeEffectFrom.convertToMovieTimeEffect((float) j3);
                ArrayList arrayList = new ArrayList();
                arrayList.add(convertToMovieTimeEffect);
                List<TAVClip> applyTimeEffectsInPreviewTimeline = TAVRhythmTimeEffectUtils.applyTimeEffectsInPreviewTimeline(list, arrayList);
                tAVComposition.getVideoChannels().remove(0);
                tAVComposition.getVideoChannels().add(0, applyTimeEffectsInPreviewTimeline);
                appendDebugInfo("add time effect to hightlight at: " + time + " ,speed:" + convertToMovieTimeEffect.getSpeed());
            }
        }
    }

    private void applyTransitionToSegment(TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect, TAVSticker tAVSticker, CMTime cMTime, long j3, int i3) {
        CMTime cMTime2;
        if (tAVTransitionAutomaticEffect.isFaceTransition()) {
            CMTimeRange cMTimeRange = new CMTimeRange(cMTime, new CMTime(j3, 1000));
            FaceTransition faceTransition = new FaceTransition();
            faceTransition.setTimeRange(cMTimeRange);
            faceTransition.setProcMethod(tAVTransitionAutomaticEffect.getProcMethod());
            faceTransition.setPosition(i3);
            getFaceTransitions().add(faceTransition);
            return;
        }
        if (tAVSticker == null) {
            tAVSticker = this.rhythmTransitionHelper.getTransitionSticker(tAVTransitionAutomaticEffect);
        }
        if (tAVSticker != null) {
            TransitionEffectParam transitionParams = TransitionUtils.getTransitionParams(tAVSticker, tAVTransitionAutomaticEffect.effectId);
            if (TAVAutomaticTemplate.isMapping) {
                cMTime2 = cMTime.add(transitionParams.getOverlayTime()).sub(transitionParams.getLeftTransitionTime());
            } else {
                cMTime2 = cMTime;
            }
            tAVSticker.setTimeRange(new CMTimeRange(cMTime2, CMTime.fromMs(j3)));
            TransitionEffectModel transitionEffectModel = new TransitionEffectModel();
            transitionEffectModel.setEffectId(tAVTransitionAutomaticEffect.effectId);
            transitionEffectModel.setFilePath(tAVSticker.getFilePath());
            transitionEffectModel.setStickerId(tAVSticker.getStickerId());
            transitionEffectModel.setTransitionPosition(i3);
            transitionEffectModel.setLeftTransitionMs(transitionParams.getLeftTransitionTime().getTimeUs() / 1000);
            transitionEffectModel.setRightTransitionMs(transitionParams.getRightTransitionTime().getTimeUs() / 1000);
            transitionEffectModel.setOverlayTransitionMs(transitionParams.getOverlayTime().getTimeUs() / 1000);
            transitionEffectModel.setTimeRange(tAVSticker.getTimeRange());
            this.transitionEffectModels.add(transitionEffectModel);
            if (TAVAutomaticTemplate.isMapping) {
                tAVSticker.getExtraBundle().putString("key_extra_sticker_type", TAVAutomaticRenderContext.STICKER_VIDEO_TRANSITION);
            }
            this.transitionStickers.add(tAVSticker);
            appendDebugInfo("add transition sticker " + tAVSticker.getFilePath() + ", start offset: " + cMTime);
        }
    }

    private List<TAVRhythmMovieSegment> buildSegmentsFromClips(List<TAVMovieClipEx> list) {
        int handleTransitionForSegment;
        Log.i(TAG, "buildSegmentsFromClips: ");
        ArrayList arrayList = new ArrayList();
        CMTime cMTime = CMTime.CMTimeZero;
        this.mTransitionLoopIndex = 0;
        CMTime cMTime2 = cMTime;
        int i3 = 0;
        TAVMovieClipEx tAVMovieClipEx = null;
        TAVRhythmMovieSegment tAVRhythmMovieSegment = null;
        for (TAVMovieClipEx tAVMovieClipEx2 : list) {
            CMTime duration = tAVMovieClipEx2.getTavMovieClip().getResource().getTimeRange().getDuration();
            TAVRhythmMovieSegment tAVRhythmMovieSegment2 = new TAVRhythmMovieSegment();
            tAVRhythmMovieSegment2.setTimeRange(new CMTimeRange(cMTime, duration));
            if (!this.rhythmTransitionHelper.getTransitionDurationMsList().isEmpty()) {
                if (TAVAutomaticTemplate.isMapping) {
                    handleTransitionForSegment = handleTransitionsForSegment(i3, tAVMovieClipEx2, tAVMovieClipEx, cMTime, cMTime2, duration, tAVRhythmMovieSegment2, tAVRhythmMovieSegment);
                } else {
                    handleTransitionForSegment = handleTransitionForSegment(i3, tAVMovieClipEx2, tAVMovieClipEx, cMTime, cMTime2, duration, tAVRhythmMovieSegment2, tAVRhythmMovieSegment);
                }
                i3 = handleTransitionForSegment;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(tAVMovieClipEx2.getTavMovieClip());
            tAVRhythmMovieSegment2.setTavMovieClips(arrayList2);
            arrayList.add(tAVRhythmMovieSegment2);
            cMTime = cMTime.add(duration);
            cMTime2 = duration;
            tAVMovieClipEx = tAVMovieClipEx2;
            tAVRhythmMovieSegment = tAVRhythmMovieSegment2;
        }
        fillSegmentTAVClip(arrayList);
        fillSegmentTimeEffect(arrayList);
        return arrayList;
    }

    private void checkRhythmTransitionHelper() {
        if (this.rhythmTransitionHelper == null) {
            createRhythmTransitionHelper();
        }
    }

    private void clearLastPoints() {
        this.highlightPoints.clear();
        this.bpmEffectPoints.clear();
        this.slowEffectPoints.clear();
        this.drumEffectPoints.clear();
        this.secondEffectPoints.clear();
        this.segments.clear();
        this.mCorrectSegments.clear();
    }

    private void configMusic(String str, float f16) {
        if (f16 < 0.0f) {
            configMusic("", str, this.start.getTimeSeconds() * 1000.0f);
        } else {
            configMusic("", str, f16);
        }
    }

    private void configMusicSecondEffects() {
        List<TAVEffectAutomaticEffect> list;
        int randomInt;
        this.secondApplyEffects.clear();
        if (this.singleResource && !this.highlightPoints.isEmpty() && !this.secondEffects.isEmpty() && !this.secondEffectPoints.isEmpty()) {
            Iterator<TAVEffectPoint> it = this.secondEffectPoints.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                long time = ((float) it.next().getTime()) - (this.musicRealStart.getTimeSeconds() * 1000.0f);
                if (time > 0 && ((float) time) < this.maxVideoDuration.getTimeSeconds() * 1000.0f) {
                    ArrayList arrayList = new ArrayList();
                    TAVRhythmSecondEffectType tAVRhythmSecondEffectType = this.secondEffectType;
                    if (tAVRhythmSecondEffectType == TAVRhythmSecondEffectType.TAVRhythmSecondEffectSpeed) {
                        list = getTimeEffectFromEffectsGroup(this.secondEffects, false);
                    } else if (tAVRhythmSecondEffectType == TAVRhythmSecondEffectType.TAVRhythmSecondEffectFreeze) {
                        list = getTimeEffectFromEffectsGroup(this.secondEffects, true);
                    } else if (tAVRhythmSecondEffectType == TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix) {
                        if (i3 < this.secondApplyEffectsRandomIndices.size()) {
                            randomInt = this.secondApplyEffectsRandomIndices.get(i3).intValue();
                        } else {
                            randomInt = RandomUtils.randomInt(0, this.secondEffects.size());
                        }
                        list = this.secondEffects.get(randomInt);
                    } else {
                        list = null;
                    }
                    Iterator<TAVEffectAutomaticEffect> it5 = list.iterator();
                    while (it5.hasNext()) {
                        TAVEffectAutomaticEffect copy = it5.next().copy();
                        copy.setStartOffset(time);
                        arrayList.add(copy);
                    }
                    this.secondApplyEffects.add(arrayList);
                    i3++;
                }
            }
        }
    }

    private void configSegments() {
        List<TAVEffectPoint> list;
        boolean z16;
        CMTime cMTime = CMTime.CMTimeZero;
        CMTime cMTime2 = this.maxVideoDuration;
        if (this.randomType == TAVRhythmRandomType.TAVRhythmMultiPicSlow) {
            list = this.slowEffectPoints;
            z16 = true;
        } else {
            list = this.drumEffectPoints;
            z16 = false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            TAVEffectPoint tAVEffectPoint = list.get(i3);
            if (TextUtils.equals(tAVEffectPoint.getType(), PuckingDrum) || z16) {
                CMTime cMTime3 = new CMTime(tAVEffectPoint.getTime(), 1000);
                if (!cMTime.bigThan(cMTime2) && !cMTime.equals(cMTime2)) {
                    if (cMTime3.bigThan(this.musicRealStart)) {
                        CMTime sub = cMTime3.sub(this.musicRealStart).sub(cMTime);
                        if (cMTime.add(sub).bigThan(cMTime2)) {
                            sub = cMTime2.sub(cMTime);
                        }
                        TAVRhythmMovieSegment tAVRhythmMovieSegment = new TAVRhythmMovieSegment();
                        tAVRhythmMovieSegment.setTimeRange(new CMTimeRange(cMTime, sub));
                        this.segments.add(tAVRhythmMovieSegment);
                        ArrayList arrayList = new ArrayList();
                        TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
                        CMTime cMTime4 = CMTime.CMTimeZero;
                        tAVMovieTimeEffect.setSourceTimeRange(new CMTimeRange(cMTime4, sub));
                        tAVMovieTimeEffect.setTimeRange(new CMTimeRange(cMTime4, sub));
                        arrayList.add(tAVMovieTimeEffect);
                        tAVRhythmMovieSegment.setTimeEffects(arrayList);
                        cMTime = cMTime.add(sub);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void correctSegments(List<TAVRhythmMovieSegment> list) {
        boolean z16;
        this.mCorrectSegments.addAll(list);
        int i3 = 0;
        while (i3 < this.mCorrectSegments.size()) {
            TAVRhythmMovieSegment tAVRhythmMovieSegment = this.mCorrectSegments.get(i3);
            tAVRhythmMovieSegment.setIndex(i3);
            if (i3 == this.mCorrectSegments.size() - 1) {
                break;
            }
            i3++;
            TAVRhythmMovieSegment tAVRhythmMovieSegment2 = this.mCorrectSegments.get(i3);
            CMTimeRange timeRange = tAVRhythmMovieSegment.getTimeRange();
            CMTime end = timeRange.getEnd();
            CMTimeRange timeRange2 = tAVRhythmMovieSegment2.getTimeRange();
            CMTime start = timeRange2.getStart();
            CMTime end2 = timeRange2.getEnd();
            if (timeRange.containsTime(start)) {
                if (end.bigThan(end2)) {
                    end = end2;
                }
                tAVRhythmMovieSegment2.setOverlapTimeRange(new CMTimeRange(start, end.sub(start)));
                tAVRhythmMovieSegment2.setCorrectStartTime(start.add(end.sub(start).divide(2.0f)));
            } else {
                tAVRhythmMovieSegment2.setCorrectStartTime(start);
            }
        }
        Iterator<TAVRhythmMovieSegment> it = this.mCorrectSegments.iterator();
        while (it.hasNext()) {
            TAVRhythmMovieSegment next = it.next();
            if (next != null && next.getTavMovieClips() != null && !next.getTavMovieClips().isEmpty() && next.getTavClips() != null && !next.getTavClips().isEmpty() && (next.getOverlapTimeRange() == null || !next.getTimeRange().getEnd().smallThan(next.getOverlapTimeRange().getEnd()))) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                it.remove();
            }
        }
    }

    private void createRhythmTransitionHelper() {
        RhythmTransitionParams rhythmTransitionParams = new RhythmTransitionParams();
        rhythmTransitionParams.templateDir = this.templateDir;
        rhythmTransitionParams.extraData = getExtraData();
        rhythmTransitionParams.rhythmEffects = this.rhythmEffects;
        rhythmTransitionParams.transitionApplyType = this.transitionApplyType;
        rhythmTransitionParams.transThreshold = this.transThreshold;
        this.rhythmTransitionHelper = new RhythmTransitionHelper(rhythmTransitionParams);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0026. Please report as an issue. */
    private void fillAllChannelPoints(RhythmDataBean rhythmDataBean) {
        String str;
        for (RhythmDataBean.PackedEffectPoints packedEffectPoints : rhythmDataBean.allData) {
            if (packedEffectPoints != null && (str = packedEffectPoints.name) != null && packedEffectPoints.effectPoints != null) {
                str.hashCode();
                char c16 = '\uffff';
                switch (str.hashCode()) {
                    case -1870542368:
                        if (str.equals(DrumTrail)) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -1704423735:
                        if (str.equals(HighlightValueTrail)) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case -1358596873:
                        if (str.equals(StartValueTrail)) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case -1142061521:
                        if (str.equals(SlowRhythmTrail)) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case 820031028:
                        if (str.equals(BpmValueTrail)) {
                            c16 = 4;
                            break;
                        }
                        break;
                }
                switch (c16) {
                    case 0:
                        this.drumEffectPoints.addAll(packedEffectPoints.effectPoints);
                        sortPoints(this.drumEffectPoints);
                        Log.i(TAG, "init DrumTrail, size:" + this.drumEffectPoints.size());
                        break;
                    case 1:
                        this.highlightPoints.addAll(packedEffectPoints.effectPoints);
                        Log.i(TAG, "init HighlightValueTrail, size:" + this.highlightPoints.size());
                        break;
                    case 2:
                        List<TAVEffectPoint> list = packedEffectPoints.effectPoints;
                        if (list != null && !list.isEmpty()) {
                            this.start = new CMTime(packedEffectPoints.effectPoints.get(0).getTime(), 1000);
                            Log.i(TAG, "init start time:" + (this.start.getTimeSeconds() * 1000.0f));
                            if (packedEffectPoints.effectPoints.size() > 1) {
                                long time = packedEffectPoints.effectPoints.get(1).getTime() - packedEffectPoints.effectPoints.get(0).getTime();
                                if (time > 0) {
                                    this.maxDuration = new CMTime(time, 1000);
                                } else {
                                    this.maxDuration = new CMTime(-time, 1000);
                                }
                                Log.i(TAG, "init max duration:" + (this.maxDuration.getTimeSeconds() * 1000.0f));
                                break;
                            } else {
                                break;
                            }
                        }
                        break;
                    case 3:
                        this.slowEffectPoints.addAll(packedEffectPoints.effectPoints);
                        sortPoints(this.slowEffectPoints);
                        Log.i(TAG, "init SlowRhythmTrail, size:" + this.slowEffectPoints.size());
                        break;
                    case 4:
                        this.bpmEffectPoints.addAll(packedEffectPoints.effectPoints);
                        sortPoints(this.bpmEffectPoints);
                        Log.i(TAG, "init BpmValueTrail, size:" + this.bpmEffectPoints.size());
                        break;
                }
            }
        }
    }

    private void fillEffects() {
        List<TAVRhythmEffects> list = this.rhythmEffectsGroup;
        if (list != null && !list.isEmpty()) {
            TAVRhythmEffects tAVRhythmEffects = this.rhythmEffectsGroup.get(0);
            this.rhythmEffects = tAVRhythmEffects;
            this.rhythmEffectID = tAVRhythmEffects.getRhythmEffectID();
            List<TAVEffectAutomaticEffect> highlightEffects = this.rhythmEffects.getHighlightEffects();
            List<TAVEffectAutomaticEffect> list2 = this.effectsModel.filterEffects;
            if (highlightEffects != null && !highlightEffects.isEmpty()) {
                fillRealEffects(highlightEffects, this.highlightEffects);
            }
            if (list2 != null && !list2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : list2) {
                    if (tAVEffectAutomaticEffect.getRhythmEffectType() == 1 || tAVEffectAutomaticEffect.getRhythmEffectType() == 2) {
                        arrayList.add(tAVEffectAutomaticEffect);
                    }
                }
                fillRealEffects(arrayList, this.highlightEffects);
            }
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect2 : this.highlightEffects) {
                if (tAVEffectAutomaticEffect2.getRhythmEffectType() == 2) {
                    tAVEffectAutomaticEffect2.setEndOffset(-1L);
                }
            }
            List<List<TAVEffectAutomaticEffect>> secondEffects = this.rhythmEffects.getSecondEffects();
            if (this.rhythmEffects.getSecondEffects() != null && !secondEffects.isEmpty()) {
                for (List<TAVEffectAutomaticEffect> list3 : secondEffects) {
                    if (list3 != null && !list3.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        fillRealEffects(list3, arrayList2);
                        this.secondEffects.add(arrayList2);
                    }
                }
            }
        }
    }

    private void fillRandomType(TAVMovie tAVMovie) {
        List<TAVMovieClip> clips = tAVMovie.getClips();
        if (this.singleResource) {
            if (this.rhythmType == TAVRhythmEffectType.TAVRhythmSlowChannel) {
                this.randomType = TAVRhythmRandomType.TAVRhythmSingleSlow;
                return;
            } else {
                this.randomType = TAVRhythmRandomType.TAVRhythmSingleBPM;
                return;
            }
        }
        if (TemplateUtils.isAllPhotoClip(clips)) {
            if (this.adjustClipType == TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1) {
                this.randomType = TAVRhythmRandomType.TAVRhythmMultiPicDrum;
                return;
            } else {
                this.randomType = TAVRhythmRandomType.TAVRhythmMultiPicSlow;
                return;
            }
        }
        if (this.adjustClipType == TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1) {
            this.randomType = TAVRhythmRandomType.TAVRhythmMultiCutMode1;
        } else {
            this.randomType = TAVRhythmRandomType.TAVRhythmMultiCutMode2;
        }
    }

    private void fillRealEffects(List<TAVEffectAutomaticEffect> list, List<TAVEffectAutomaticEffect> list2) {
        for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : list) {
            if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
                list2.add(tAVEffectAutomaticEffect.copyPAGEffectFrom());
            } else if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
                list2.add(tAVEffectAutomaticEffect.copyLUTEffectFrom());
            } else if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime) {
                list2.add(tAVEffectAutomaticEffect.copyTimeEffectFrom());
            }
        }
    }

    private void fillSecondEffectPoints() {
        TAVRhythmEffectType tAVRhythmEffectType = this.rhythmType;
        if (tAVRhythmEffectType == TAVRhythmEffectType.TAVRhythmBPMChannel) {
            this.secondEffectPoints.addAll(this.bpmEffectPoints);
        } else if (tAVRhythmEffectType == TAVRhythmEffectType.TAVRhythmSlowChannel) {
            this.secondEffectPoints.addAll(this.slowEffectPoints);
        }
    }

    private void fillSegmentTAVClip(List<TAVRhythmMovieSegment> list) {
        List<TAVMovieClip> tavMovieClips;
        if (list == null) {
            return;
        }
        int i3 = 0;
        for (TAVRhythmMovieSegment tAVRhythmMovieSegment : list) {
            if (tAVRhythmMovieSegment != null && (tavMovieClips = tAVRhythmMovieSegment.getTavMovieClips()) != null && !tavMovieClips.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<TAVMovieClip> it = tavMovieClips.iterator();
                while (it.hasNext()) {
                    TAVClip convertToClip = it.next().convertToClip();
                    convertToClip.putExtraTrackInfo(TAVOneClickFilmStickerEffect.TRACK_INDEX, Integer.valueOf(i3));
                    arrayList.add(convertToClip);
                    i3++;
                }
                tAVRhythmMovieSegment.setTavClips(arrayList);
            }
        }
    }

    private void fillSegmentTimeEffect(List<TAVRhythmMovieSegment> list) {
        for (TAVRhythmMovieSegment tAVRhythmMovieSegment : list) {
            CMTimeRange timeRange = tAVRhythmMovieSegment.getTimeRange();
            ArrayList arrayList = new ArrayList();
            TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
            CMTime cMTime = CMTime.CMTimeZero;
            tAVMovieTimeEffect.setSourceTimeRange(new CMTimeRange(cMTime, timeRange.getDuration()));
            tAVMovieTimeEffect.setTimeRange(new CMTimeRange(cMTime, timeRange.getDuration()));
            arrayList.add(tAVMovieTimeEffect);
            tAVRhythmMovieSegment.setTimeEffects(arrayList);
        }
    }

    private void getSecondEffectsIndex() {
        this.secondApplyEffectsRandomIndices.clear();
        if (!this.secondEffects.isEmpty() && !this.secondEffectPoints.isEmpty()) {
            if (this.secondEffectApplyType == ApplyEffectType.SequenceApplyEffect.ordinal()) {
                for (int i3 = 0; i3 < this.secondEffectPoints.size(); i3++) {
                    long time = ((float) this.secondEffectPoints.get(i3).getTime()) - (this.musicRealStart.getTimeSeconds() * 1000.0f);
                    if (time > 0 && ((float) time) <= this.maxVideoDuration.getTimeSeconds() * 1000.0f && this.secondEffectType == TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix) {
                        this.secondApplyEffectsRandomIndices.add(Integer.valueOf(i3 % this.secondEffects.size()));
                    }
                }
                return;
            }
            if (this.secondEffectApplyType == ApplyEffectType.RandomApplyEffect.ordinal()) {
                Iterator<TAVEffectPoint> it = this.secondEffectPoints.iterator();
                while (it.hasNext()) {
                    long time2 = ((float) it.next().getTime()) - (this.musicRealStart.getTimeSeconds() * 1000.0f);
                    if (time2 > 0 && ((float) time2) <= this.maxVideoDuration.getTimeSeconds() * 1000.0f && this.secondEffectType == TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix) {
                        this.secondApplyEffectsRandomIndices.add(Integer.valueOf(RandomUtils.randomInt(0, this.secondEffects.size())));
                    }
                }
                return;
            }
            if (this.secondEffectApplyType == ApplyEffectType.DefaultApplyEffect.ordinal()) {
                Iterator<TAVEffectPoint> it5 = this.secondEffectPoints.iterator();
                while (it5.hasNext()) {
                    long time3 = ((float) it5.next().getTime()) - (this.musicRealStart.getTimeSeconds() * 1000.0f);
                    if (time3 > 0 && ((float) time3) <= this.maxVideoDuration.getTimeSeconds() * 1000.0f && this.secondEffectType == TAVRhythmSecondEffectType.TAVRhythmSecondEffectMix) {
                        this.secondApplyEffectsRandomIndices.add(0);
                    }
                }
            }
        }
    }

    @Nullable
    private List<List<TAVClip>> getTAVClipsFromSegments(List<TAVRhythmMovieSegment> list) {
        if (list != null && list.size() != 0) {
            ArrayList<List> arrayList = new ArrayList();
            Iterator<TAVRhythmMovieSegment> it = list.iterator();
            while (true) {
                boolean z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                TAVRhythmMovieSegment next = it.next();
                if (arrayList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(next);
                    arrayList.add(arrayList2);
                } else {
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        List list2 = (List) it5.next();
                        if (!((TAVRhythmMovieSegment) list2.get(list2.size() - 1)).getTimeRange().containsTime(next.getTimeRange().getStart())) {
                            list2.add(next);
                            z16 = true;
                            break;
                        }
                    }
                    if (!z16) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(next);
                        arrayList.add(arrayList3);
                    }
                }
            }
            ArrayList arrayList4 = new ArrayList();
            for (List list3 : arrayList) {
                ArrayList arrayList5 = new ArrayList();
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    TAVRhythmMovieSegment tAVRhythmMovieSegment = (TAVRhythmMovieSegment) list3.get(i3);
                    if (i3 == 0) {
                        if (tAVRhythmMovieSegment.getTimeRange().getStart().bigThan(CMTime.CMTimeZero)) {
                            arrayList5.add(new TAVClip(new TAVEmptyResource(((TAVRhythmMovieSegment) list3.get(0)).getTimeRange().getStart())));
                        }
                    } else {
                        CMTime sub = tAVRhythmMovieSegment.getTimeRange().getStart().sub(((TAVRhythmMovieSegment) list3.get(i3 - 1)).getTimeRange().getEnd());
                        if (sub.bigThan(CMTime.CMTimeZero)) {
                            arrayList5.add(new TAVClip(new TAVEmptyResource(sub)));
                        }
                    }
                    Iterator<TAVClip> it6 = tAVRhythmMovieSegment.getFullTavClips().iterator();
                    while (it6.hasNext()) {
                        arrayList5.add(it6.next());
                    }
                }
                arrayList4.add(arrayList5);
            }
            return arrayList4;
        }
        return null;
    }

    private List<TAVEffectAutomaticEffect> getTimeEffectFromEffectsGroup(List<List<TAVEffectAutomaticEffect>> list, boolean z16) {
        for (List<TAVEffectAutomaticEffect> list2 : list) {
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : list2) {
                if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime && (!z16 || tAVEffectAutomaticEffect.getSpeed() == 0.0f)) {
                    return list2;
                }
            }
        }
        return null;
    }

    private void handleNormalTransition(int i3, @NonNull TAVMovieClipEx tAVMovieClipEx, @Nullable TAVMovieClipEx tAVMovieClipEx2, @NonNull TAVRhythmMovieSegment tAVRhythmMovieSegment, @NonNull TAVRhythmMovieSegment tAVRhythmMovieSegment2, long j3, TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect, TAVSticker tAVSticker) {
        CMTime divide = tAVMovieClipEx2.getTransitionEffectParam().getOverlayTime().divide(2.0f);
        TAVMovieResource resource = tAVMovieClipEx2.getTavMovieClip().getResource();
        TAVMovieResource resource2 = tAVMovieClipEx.getTavMovieClip().getResource();
        CMTimeRange timeRange = resource.getTimeRange();
        timeRange.setDuration(timeRange.getDuration().add(divide));
        resource.setDuration(timeRange.getDuration());
        CMTimeRange timeRange2 = tAVRhythmMovieSegment2.getTimeRange();
        timeRange2.setDuration(timeRange2.getDuration().add(divide));
        tAVRhythmMovieSegment2.setTimeRange(timeRange2);
        addOverLayTimeToClip(divide, resource2);
        CMTimeRange timeRange3 = tAVRhythmMovieSegment.getTimeRange();
        timeRange3.setDuration(timeRange3.getDuration().add(divide));
        CMTime sub = timeRange3.getStart().sub(divide);
        timeRange3.setStart(sub);
        tAVRhythmMovieSegment.setTimeRange(timeRange3);
        if (tAVTransitionAutomaticEffect != null) {
            applyTransitionToSegment(tAVTransitionAutomaticEffect, tAVSticker, sub, j3, i3);
        }
    }

    @Deprecated
    private int handleTransitionForSegment(int i3, TAVMovieClipEx tAVMovieClipEx, TAVMovieClipEx tAVMovieClipEx2, CMTime cMTime, CMTime cMTime2, CMTime cMTime3, TAVRhythmMovieSegment tAVRhythmMovieSegment, TAVRhythmMovieSegment tAVRhythmMovieSegment2) {
        long j3;
        if (i3 < this.rhythmTransitionHelper.getTransitionDurationMsList().size()) {
            j3 = this.rhythmTransitionHelper.getTransitionDurationMsList().get(i3).longValue();
        } else {
            j3 = 0;
        }
        TAVTransitionAutomaticEffect transitionEffect = this.rhythmTransitionHelper.getTransitionEffect(i3);
        boolean needNormalTransition = needNormalTransition(tAVMovieClipEx, tAVMovieClipEx2, cMTime);
        TAVSticker tAVSticker = null;
        if (needNormalTransition && transitionEffect != null && needFaceSubTransition(transitionEffect, tAVMovieClipEx.getTavMovieClip(), tAVMovieClipEx2.getTavMovieClip())) {
            TAVTransitionAutomaticEffect faceTransitionSubTransition = this.rhythmTransitionHelper.getFaceTransitionSubTransition(transitionEffect.subTransitions);
            TAVSticker transitionSticker = this.rhythmTransitionHelper.getTransitionSticker(faceTransitionSubTransition);
            long durationTime = transitionSticker.durationTime() / 1000;
            if (durationTime > j3) {
                needNormalTransition = false;
            } else {
                transitionEffect = faceTransitionSubTransition;
                tAVSticker = transitionSticker;
                j3 = durationTime;
            }
        }
        CMTime cMTime4 = new CMTime(j3 / 2, 1000);
        if (!needNormalTransition || !this.rhythmTransitionHelper.isDurationEnoughForTransition(cMTime2, cMTime3, j3)) {
            return i3;
        }
        TAVMovieResource resource = tAVMovieClipEx2.getTavMovieClip().getResource();
        TAVMovieResource resource2 = tAVMovieClipEx.getTavMovieClip().getResource();
        CMTimeRange timeRange = resource.getTimeRange();
        timeRange.setDuration(timeRange.getDuration().add(cMTime4));
        resource.setDuration(resource.getDuration().add(cMTime4));
        CMTimeRange timeRange2 = tAVRhythmMovieSegment2.getTimeRange();
        timeRange2.setDuration(timeRange2.getDuration().add(cMTime4));
        tAVRhythmMovieSegment2.setTimeRange(timeRange2);
        CMTimeRange timeRange3 = resource2.getTimeRange();
        if (resource2 instanceof TAVMovieImageResource) {
            timeRange3.setDuration(timeRange3.getDuration().add(cMTime4));
            resource2.setDuration(resource2.getDuration().add(cMTime4));
        } else {
            timeRange3.setStart(timeRange3.getStart().sub(cMTime4));
            timeRange3.setDuration(timeRange3.getDuration().add(cMTime4));
            resource2.setDuration(resource2.getDuration().add(cMTime4));
        }
        CMTimeRange timeRange4 = tAVRhythmMovieSegment.getTimeRange();
        timeRange4.setDuration(timeRange4.getDuration().add(cMTime4));
        CMTime sub = timeRange4.getStart().sub(cMTime4);
        timeRange4.setStart(sub);
        tAVRhythmMovieSegment.setTimeRange(timeRange4);
        if (transitionEffect != null) {
            applyTransitionToSegment(transitionEffect, tAVSticker, sub, j3, i3);
        }
        int i16 = i3 + 1;
        if (i16 >= this.rhythmTransitionHelper.getTransitionDurationMsList().size()) {
            return 0;
        }
        return i16;
    }

    private int handleTransitionsForSegment(int i3, @NonNull TAVMovieClipEx tAVMovieClipEx, @Nullable TAVMovieClipEx tAVMovieClipEx2, @NonNull CMTime cMTime, @NonNull CMTime cMTime2, @NonNull CMTime cMTime3, @NonNull TAVRhythmMovieSegment tAVRhythmMovieSegment, @NonNull TAVRhythmMovieSegment tAVRhythmMovieSegment2) {
        TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect;
        TAVSticker tAVSticker;
        long j3;
        TAVTransitionAutomaticEffect faceTransitionSubTransition;
        TAVSticker transitionSticker;
        long longValue = this.rhythmTransitionHelper.getTransitionDurationMsList().get(i3).longValue();
        TAVTransitionAutomaticEffect transitionEffect = this.rhythmTransitionHelper.getTransitionEffect(i3);
        boolean needAddNormalTransition = needAddNormalTransition(tAVMovieClipEx, tAVMovieClipEx2, cMTime);
        if (needAddNormalTransition && transitionEffect != null && needFaceSubTransition(transitionEffect, tAVMovieClipEx.getTavMovieClip(), tAVMovieClipEx2.getTavMovieClip()) && (transitionSticker = this.rhythmTransitionHelper.getTransitionSticker((faceTransitionSubTransition = this.rhythmTransitionHelper.getFaceTransitionSubTransition(transitionEffect.subTransitions)))) != null) {
            long durationTime = transitionSticker.durationTime() / 1000;
            if (durationTime > longValue) {
                tAVTransitionAutomaticEffect = transitionEffect;
                tAVSticker = null;
                needAddNormalTransition = false;
            } else {
                tAVMovieClipEx2.setTransitionEffectParam(TransitionUtils.getTransitionParams(transitionSticker, faceTransitionSubTransition.effectId));
                tAVSticker = transitionSticker;
                tAVTransitionAutomaticEffect = faceTransitionSubTransition;
                j3 = durationTime;
                int size = this.rhythmTransitionHelper.getTransitionDurationMsList().size();
                if (!needAddNormalTransition && this.rhythmTransitionHelper.isDurationEnoughForTransition(cMTime2, cMTime3, j3)) {
                    handleNormalTransition(i3 + (this.mTransitionLoopIndex * size), tAVMovieClipEx, tAVMovieClipEx2, tAVRhythmMovieSegment, tAVRhythmMovieSegment2, j3, tAVTransitionAutomaticEffect, tAVSticker);
                    int i16 = i3 + 1;
                    if (i16 >= size) {
                        this.mTransitionLoopIndex++;
                        return 0;
                    }
                    return i16;
                }
            }
        } else {
            tAVTransitionAutomaticEffect = transitionEffect;
            tAVSticker = null;
        }
        j3 = longValue;
        int size2 = this.rhythmTransitionHelper.getTransitionDurationMsList().size();
        return !needAddNormalTransition ? i3 : i3;
    }

    private boolean isNeedCycleFill(List<TAVMovieClip> list) {
        return TemplateUtils.isAllPhotoClip(list);
    }

    private boolean isPointInPuckingDrum(CMTime cMTime) {
        long timeUs = cMTime.getTimeUs();
        Iterator<TAVRhythmMovieSegment> it = this.segments.iterator();
        while (it.hasNext()) {
            if (Math.abs(timeUs - it.next().getTimeRange().getStart().getTimeUs()) <= 1000) {
                return true;
            }
        }
        appendDebugInfo("clip start time: " + (timeUs / 1000) + ", don't match puckingDrum point");
        return false;
    }

    private void loadMusicEffectPointsWithRhythmDataBean(RhythmDataBean rhythmDataBean, String str, long j3) {
        List<RhythmDataBean.PackedEffectPoints> list;
        clearLastPoints();
        if (rhythmDataBean != null && (list = rhythmDataBean.allData) != null && !list.isEmpty()) {
            this.isRhythmTemplate = true;
            fillAllChannelPoints(rhythmDataBean);
            fillSecondEffectPoints();
            fillEffects();
            configMusic(str, (float) j3);
            getSecondEffectsIndex();
            return;
        }
        this.isRhythmTemplate = false;
        configMusic(str, (float) j3);
    }

    private boolean needAddNormalTransition(@NonNull TAVMovieClipEx tAVMovieClipEx, @NonNull TAVMovieClipEx tAVMovieClipEx2, @NonNull CMTime cMTime) {
        if (tAVMovieClipEx2 == null || !tAVMovieClipEx.isLastReverse() || !tAVMovieClipEx2.isCurrentReverse()) {
            return false;
        }
        return isPointInPuckingDrum(cMTime);
    }

    private boolean needFaceSubTransition(TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect, TAVMovieClip tAVMovieClip, TAVMovieClip tAVMovieClip2) {
        if (tAVTransitionAutomaticEffect.isFaceTransition() && ((!this.rhythmTransitionHelper.clipSupportFaceTransition(tAVMovieClip2) || !this.rhythmTransitionHelper.clipSupportFaceTransition(tAVMovieClip)) && !CollectionUtil.isEmptyList(tAVTransitionAutomaticEffect.subTransitions))) {
            return true;
        }
        return false;
    }

    private boolean needNormalTransition(TAVMovieClipEx tAVMovieClipEx, TAVMovieClipEx tAVMovieClipEx2, CMTime cMTime) {
        if (tAVMovieClipEx2 != null && isPointInPuckingDrum(cMTime) && tAVMovieClipEx.isReverse() && tAVMovieClipEx2.isReverse()) {
            return true;
        }
        return false;
    }

    private void randomRhythmChannleAndAdjustMode() {
        if (this.randomIndex % 2 == 0) {
            this.adjustClipType = TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1;
            this.rhythmType = TAVRhythmEffectType.TAVRhythmSlowChannel;
        } else {
            this.adjustClipType = TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode2;
            this.rhythmType = TAVRhythmEffectType.TAVRhythmBPMChannel;
        }
    }

    private List<TAVMovieClipEx> separateClipsWithAdjust(List<TAVMovieClipEx> list) {
        CMTime cMTime;
        CMTime cMTime2;
        CMTime cMTime3;
        int i3;
        TAVRhythmAutomaticTemplate tAVRhythmAutomaticTemplate = this;
        ArrayList arrayList = new ArrayList();
        CMTime cMTime4 = CMTime.CMTimeZero;
        Iterator<TAVRhythmMovieSegment> it = tAVRhythmAutomaticTemplate.segments.iterator();
        Logger.d(TAG, "separateClipsWithAdjust maxDuration " + tAVRhythmAutomaticTemplate.maxDuration);
        CMTime cMTime5 = cMTime4;
        while (it.hasNext()) {
            TAVRhythmMovieSegment next = it.next();
            if (next == null) {
                it.remove();
            } else {
                cMTime5 = cMTime5.add(next.getTimeRange().getDuration());
            }
        }
        CMTime cMTime6 = CMTime.CMTimeZero;
        if (!cMTime5.equalsTo(cMTime6) && !cMTime5.smallThan(cMTime6)) {
            if (cMTime5.bigThan(tAVRhythmAutomaticTemplate.maxDuration)) {
                cMTime5 = tAVRhythmAutomaticTemplate.maxDuration;
            }
            Iterator<TAVMovieClipEx> it5 = list.iterator();
            while (it5.hasNext()) {
                TAVMovieClip tavMovieClip = it5.next().getTavMovieClip();
                if (tavMovieClip != null && tavMovieClip.getResource() != null && tavMovieClip.getResource().getTimeRange() != null) {
                    if (!(tavMovieClip.getResource() instanceof TAVMovieImageResource)) {
                        cMTime6 = cMTime6.add(tavMovieClip.getResource().getTimeRange().getDuration());
                    }
                } else {
                    it5.remove();
                }
            }
            CMTime cMTime7 = CMTime.CMTimeZero;
            if (!cMTime6.equalsTo(cMTime7) && !cMTime6.smallThan(cMTime7)) {
                int i16 = 0;
                int i17 = 0;
                while (i16 < list.size()) {
                    TAVMovieClip tavMovieClip2 = list.get(i16).getTavMovieClip();
                    if (i17 >= tAVRhythmAutomaticTemplate.segments.size()) {
                        break;
                    }
                    if (tavMovieClip2.getResource() instanceof TAVMovieImageResource) {
                        CMTime minOriginDuration = tAVRhythmAutomaticTemplate.segments.get(i17).getMinOriginDuration();
                        CMTime cMTime8 = CMTime.CMTimeZero;
                        if (!cMTime7.equalsTo(cMTime8)) {
                            i3 = i17;
                            cMTime3 = cMTime8;
                        } else {
                            int i18 = i17 + 1;
                            cMTime3 = cMTime7;
                            cMTime7 = minOriginDuration;
                            i3 = i18;
                        }
                        if (!cMTime7.equalsTo(cMTime8)) {
                            TAVMovieClip m275clone = tavMovieClip2.m275clone();
                            TAVMovieResource resource = m275clone.getResource();
                            CMTimeRange timeRange = resource.getTimeRange();
                            timeRange.setDuration(cMTime7);
                            resource.setTimeRange(timeRange);
                            resource.setDuration(cMTime7);
                            TAVMovieClipEx m95clone = list.get(i16).m95clone();
                            m95clone.setTavMovieClip(m275clone);
                            arrayList.add(m95clone);
                        }
                        cMTime = cMTime6;
                        cMTime7 = cMTime3;
                        i17 = i3;
                    } else {
                        CMTime m259clone = tavMovieClip2.getResource().getTimeRange().getDuration().m259clone();
                        CMTime cMTime9 = CMTime.CMTimeZero;
                        if (m259clone.equalsTo(cMTime9)) {
                            cMTime = cMTime6;
                        } else {
                            CMTime divide = m259clone.multi(cMTime5).divide(cMTime6);
                            if (m259clone.smallThan(divide)) {
                                divide = m259clone;
                            }
                            if (!cMTime7.equalsTo(cMTime9)) {
                                cMTime9 = cMTime9.add(cMTime7);
                                cMTime7 = cMTime9;
                            }
                            while (true) {
                                if (i17 >= tAVRhythmAutomaticTemplate.segments.size()) {
                                    break;
                                }
                                TAVRhythmMovieSegment tAVRhythmMovieSegment = tAVRhythmAutomaticTemplate.segments.get(i17);
                                if (cMTime9.smallThan(divide)) {
                                    cMTime9 = cMTime9.add(tAVRhythmMovieSegment.getMinOriginDuration());
                                    i17++;
                                } else {
                                    i17--;
                                    break;
                                }
                            }
                            if (i17 == tAVRhythmAutomaticTemplate.segments.size()) {
                                i17--;
                            }
                            TAVMovieClip m275clone2 = tavMovieClip2.m275clone();
                            CMTimeRange timeRange2 = m275clone2.getResource().getTimeRange();
                            CMTime cMTime10 = CMTime.CMTimeZero;
                            cMTime = cMTime6;
                            if (i17 >= 0 && i17 < tAVRhythmAutomaticTemplate.segments.size()) {
                                cMTime2 = tAVRhythmAutomaticTemplate.segments.get(i17).getMinOriginDuration();
                            } else {
                                cMTime2 = cMTime10;
                            }
                            if (cMTime9.bigThan(divide)) {
                                CMTime sub = cMTime9.sub(cMTime2);
                                if (sub.smallThan(cMTime10)) {
                                    cMTime2 = cMTime9;
                                    cMTime9 = cMTime10;
                                } else {
                                    cMTime9 = sub;
                                }
                            }
                            if (cMTime9.equalsTo(cMTime10)) {
                                i17++;
                                CMTime sub2 = cMTime2.sub(divide);
                                timeRange2.setDuration(divide);
                                m275clone2.getResource().setDuration(divide);
                                cMTime4 = cMTime4.add(timeRange2.getDuration());
                                m275clone2.getResource().setTimeRange(timeRange2);
                                TAVMovieClipEx m95clone2 = list.get(i16).m95clone();
                                m95clone2.setTavMovieClip(m275clone2);
                                arrayList.add(m95clone2);
                                cMTime7 = sub2;
                            } else if (m259clone.bigThan(cMTime9) || m259clone.equalsTo(cMTime9)) {
                                timeRange2.setDuration(cMTime9);
                                m275clone2.getResource().setDuration(cMTime9);
                                CMTime add = cMTime4.add(timeRange2.getDuration());
                                m275clone2.getResource().setTimeRange(timeRange2);
                                TAVMovieClipEx m95clone3 = list.get(i16).m95clone();
                                m95clone3.setTavMovieClip(m275clone2);
                                arrayList.add(m95clone3);
                                cMTime4 = add;
                            }
                        }
                    }
                    i16++;
                    tAVRhythmAutomaticTemplate = this;
                    cMTime6 = cMTime;
                }
                Logger.d(TAG, "separateClipsWithAdjust fillTotalDuration " + cMTime5);
                Logger.d(TAG, "separateClipsWithAdjust totalDuration " + cMTime4);
            }
        }
        return arrayList;
    }

    private List<TAVMovieClipEx> separateClipsWithoutAdjust(List<TAVMovieClipEx> list, boolean z16) {
        CMTime cMTime;
        CMTime m259clone;
        ArrayList arrayList = new ArrayList();
        CMTime cMTime2 = CMTime.CMTimeZero;
        CMTime cMTime3 = new CMTime(10000L, 1000);
        CMTime cMTime4 = cMTime2;
        int i3 = 0;
        int i16 = 0;
        boolean z17 = false;
        while (i3 < list.size() && i16 < this.segments.size()) {
            CMTime cMTime5 = CMTime.CMTimeZero;
            TAVMovieClip tavMovieClip = list.get(i3).getTavMovieClip();
            if (tavMovieClip.getResource() instanceof TAVMovieImageResource) {
                if (!cMTime2.equalsTo(cMTime5)) {
                    m259clone = cMTime2;
                } else {
                    m259clone = this.segments.get(i16).getMinOriginDuration().m259clone();
                    i16++;
                }
                if (m259clone.equalsTo(cMTime5)) {
                    continue;
                } else {
                    TAVMovieClip m275clone = tavMovieClip.m275clone();
                    TAVMovieResource resource = m275clone.getResource();
                    CMTimeRange timeRange = resource.getTimeRange();
                    timeRange.setDuration(m259clone);
                    resource.setTimeRange(timeRange);
                    resource.setDuration(m259clone);
                    TAVMovieClipEx m95clone = list.get(i3).m95clone();
                    m95clone.setTavMovieClip(m275clone);
                    arrayList.add(m95clone);
                    cMTime4 = cMTime4.add(m259clone);
                }
            } else {
                CMTime duration = tavMovieClip.getResource().getTimeRange().getDuration();
                TAVMovieClip m275clone2 = tavMovieClip.m275clone();
                CMTimeRange timeRange2 = m275clone2.getResource().getTimeRange();
                if (!cMTime2.equalsTo(cMTime5)) {
                    cMTime5 = cMTime5.add(cMTime2);
                    cMTime2 = cMTime5;
                }
                while (true) {
                    if (i16 >= this.segments.size()) {
                        break;
                    }
                    TAVRhythmMovieSegment tAVRhythmMovieSegment = this.segments.get(i16);
                    if (cMTime5.smallThan(duration)) {
                        cMTime5 = cMTime5.add(tAVRhythmMovieSegment.getMinOriginDuration());
                        i16++;
                    } else {
                        i16--;
                        break;
                    }
                }
                if (i16 == this.segments.size()) {
                    i16--;
                }
                CMTime cMTime6 = CMTime.CMTimeZero;
                if (i16 >= 0 && i16 < this.segments.size()) {
                    cMTime = this.segments.get(i16).getMinOriginDuration();
                } else {
                    cMTime = cMTime6;
                }
                if (cMTime5.bigThan(duration)) {
                    CMTime sub = cMTime5.sub(cMTime);
                    if (sub.smallThan(cMTime6)) {
                        cMTime = cMTime5;
                        cMTime5 = cMTime6;
                    } else {
                        cMTime5 = sub;
                    }
                }
                if (cMTime5.equalsTo(cMTime6)) {
                    i16++;
                    cMTime2 = cMTime.sub(duration);
                    timeRange2.setDuration(duration);
                    m275clone2.getResource().setDuration(duration);
                    m275clone2.getResource().setTimeRange(timeRange2);
                    TAVMovieClipEx m95clone2 = list.get(i3).m95clone();
                    m95clone2.setTavMovieClip(m275clone2);
                    arrayList.add(m95clone2);
                } else if (duration.bigThan(cMTime5) || duration.equalsTo(cMTime5)) {
                    timeRange2.setDuration(cMTime5);
                    m275clone2.getResource().setDuration(cMTime5);
                    m275clone2.getResource().setTimeRange(timeRange2);
                    TAVMovieClipEx m95clone3 = list.get(i3).m95clone();
                    m95clone3.setTavMovieClip(m275clone2);
                    arrayList.add(m95clone3);
                }
                i3++;
            }
            if (!z16) {
                continue;
            } else {
                if (z17 && !cMTime4.smallThan(cMTime3)) {
                    break;
                }
                if (cMTime4.smallThan(cMTime3) && i3 == list.size() - 1) {
                    z17 = true;
                    i3 = 0;
                } else {
                    i3++;
                }
            }
        }
        return arrayList;
    }

    private void sortPoints(List<TAVEffectPoint> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new Comparator<TAVEffectPoint>() { // from class: com.tencent.autotemplate.TAVRhythmAutomaticTemplate.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TAVRhythmAutomaticTemplate.this);
                    }
                }

                @Override // java.util.Comparator
                public int compare(TAVEffectPoint tAVEffectPoint, TAVEffectPoint tAVEffectPoint2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (int) (tAVEffectPoint.getTime() - tAVEffectPoint2.getTime()) : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tAVEffectPoint, (Object) tAVEffectPoint2)).intValue();
                }
            });
        }
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    public void addExtraFilterSticker(List<TAVSticker> list, CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list, (Object) cMTime);
            return;
        }
        super.addExtraFilterSticker(list, cMTime);
        if (!this.highlightPoints.isEmpty() && !this.highlightEffects.isEmpty() && this.singleResource) {
            long time = ((float) this.highlightPoints.get(0).getTime()) - (this.musicRealStart.getTimeSeconds() * 1000.0f);
            if (time >= 0 && ((float) time) < cMTime.getTimeSeconds() * 1000.0f) {
                for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : this.highlightEffects) {
                    if (tAVEffectAutomaticEffect != null) {
                        if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
                            TAVPagAutomaticEffect tAVPagAutomaticEffect = (TAVPagAutomaticEffect) tAVEffectAutomaticEffect;
                            if (tAVPagAutomaticEffect.getRhythmEffectType() == 2) {
                                tAVPagAutomaticEffect.setEndOffset(-1L);
                            }
                            tAVPagAutomaticEffect.setFileDir(this.highlightEffectsPath);
                            tAVPagAutomaticEffect.setStartOffset(time);
                            TAVMovieSticker convertToMovieStickerWithDuraton = tAVPagAutomaticEffect.convertToMovieStickerWithDuraton(cMTime.getTimeSeconds() * 1000.0f);
                            if (convertToMovieStickerWithDuraton != null && convertToMovieStickerWithDuraton.getSticker() != null) {
                                addEffect(convertToMovieStickerWithDuraton, tAVPagAutomaticEffect, list);
                            }
                            appendDebugInfo("add highlight pag filter: " + tAVPagAutomaticEffect.getFilePath() + ", start offset: " + time);
                        } else if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
                            TAVLUTAutomaticEffect tAVLUTAutomaticEffect = (TAVLUTAutomaticEffect) tAVEffectAutomaticEffect;
                            tAVLUTAutomaticEffect.setStartOffset(time);
                            this.lutFilters.add(tAVLUTAutomaticEffect.covertToMovieFilterWithDuraton(cMTime.getTimeSeconds() * 1000.0f));
                            appendDebugInfo("add highlight lut filter: " + tAVLUTAutomaticEffect.getFilePath() + ", start offset: " + time);
                        }
                    }
                }
            }
        }
        Iterator<List<TAVEffectAutomaticEffect>> it = this.secondApplyEffects.iterator();
        while (it.hasNext()) {
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect2 : it.next()) {
                if (tAVEffectAutomaticEffect2.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
                    TAVPagAutomaticEffect tAVPagAutomaticEffect2 = (TAVPagAutomaticEffect) tAVEffectAutomaticEffect2;
                    tAVPagAutomaticEffect2.setFileDir(this.secondEffectsPath);
                    TAVMovieSticker convertToMovieStickerWithDuraton2 = tAVPagAutomaticEffect2.convertToMovieStickerWithDuraton(cMTime.getTimeSeconds() * 1000.0f);
                    if (convertToMovieStickerWithDuraton2 != null && convertToMovieStickerWithDuraton2.getSticker() != null) {
                        addEffect(convertToMovieStickerWithDuraton2, tAVPagAutomaticEffect2, list);
                    }
                    appendDebugInfo("add second effect pag filter: " + tAVPagAutomaticEffect2.getFilePath() + ", start offset: " + tAVPagAutomaticEffect2.getStartOffset());
                } else if (tAVEffectAutomaticEffect2.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
                    TAVLUTAutomaticEffect tAVLUTAutomaticEffect2 = (TAVLUTAutomaticEffect) tAVEffectAutomaticEffect2;
                    this.lutFilters.add(tAVLUTAutomaticEffect2.covertToMovieFilterWithDuraton(cMTime.getTimeSeconds() * 1000.0f));
                    appendDebugInfo("add second effect lut filter: " + tAVLUTAutomaticEffect2.getFilePath() + ", start offset: " + tAVLUTAutomaticEffect2.getStartOffset());
                }
            }
        }
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    public void addExtraOverlaySticker(List<TAVSticker> list, CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list, (Object) cMTime);
        } else {
            super.addExtraOverlaySticker(list, cMTime);
        }
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    public void applyTimeEffectToComposition(TAVComposition tAVComposition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) tAVComposition);
            return;
        }
        super.applyTimeEffectToComposition(tAVComposition);
        if (!this.singleResource && this.segments.size() > 0) {
            List<List<TAVClip>> checkVideoMaxDuration = TemplateUtils.checkVideoMaxDuration(convertClipsFromMovie(this.movie, this.adjustClipType), this.maxVideoDuration);
            if (checkVideoMaxDuration != null) {
                tAVComposition.getVideoChannels().clear();
                tAVComposition.getAudioChannels().clear();
                for (List<TAVClip> list : checkVideoMaxDuration) {
                    tAVComposition.getVideoChannels().add(list);
                    tAVComposition.getAudioChannels().add(list);
                }
                return;
            }
            return;
        }
        applyTimeEffectToHighlightPoint(tAVComposition);
        applyTimeEffectToEffectPoint(tAVComposition);
        List<List<TAVClip>> checkVideoMaxDuration2 = TemplateUtils.checkVideoMaxDuration(tAVComposition, this.maxVideoDuration);
        if (checkVideoMaxDuration2 != null) {
            tAVComposition.getVideoChannels().clear();
            tAVComposition.getAudioChannels().clear();
            for (List<TAVClip> list2 : checkVideoMaxDuration2) {
                tAVComposition.getVideoChannels().add(list2);
                tAVComposition.getAudioChannels().add(list2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f1  */
    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TAVComposition buildCompositionFromSegments(TAVMovie tAVMovie, List<TAVRhythmMovieSegment> list) {
        List<TAVMovieClip> list2;
        CMTime cMTime;
        long j3;
        TAVTransitionAutomaticEffect tAVTransitionAutomaticEffect;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TAVComposition) iPatchRedirector.redirect((short) 15, (Object) this, (Object) tAVMovie, (Object) list);
        }
        Log.i(TAG, "buildCompositionFromSegments: ");
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.setRenderSize(this.renderSize);
        tAVComposition.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
        List<TAVMovieClip> clips = tAVMovie.getClips();
        CMTime cMTime2 = CMTime.CMTimeZero;
        this.transitionEffectModels.clear();
        int i3 = 0;
        while (i3 < clips.size() && !this.rhythmTransitionHelper.getTransitionDurationMsList().isEmpty()) {
            TAVMovieClip tAVMovieClip = clips.get(i3);
            TAVRhythmMovieSegment tAVRhythmMovieSegment = list.get(i3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(tAVMovieClip);
            tAVRhythmMovieSegment.setTavMovieClips(arrayList);
            CMTime add = cMTime2.add(tAVMovieClip.getResource().getTimeRange().getDuration());
            int i16 = i3 + 1;
            if (i16 < clips.size()) {
                TAVRhythmMovieSegment tAVRhythmMovieSegment2 = list.get(i16);
                CMTimeRange timeRange = tAVRhythmMovieSegment.getTimeRange();
                CMTime start = tAVRhythmMovieSegment2.getTimeRange().getStart();
                CMTime end = timeRange.getEnd();
                TAVMovieClip tAVMovieClip2 = clips.get(i16);
                if (i3 < this.rhythmTransitionHelper.getTransitionDurationMsList().size()) {
                    j3 = this.rhythmTransitionHelper.getTransitionDurationMsList().get(i3).longValue();
                } else {
                    j3 = 0;
                }
                TAVTransitionAutomaticEffect transitionEffect = this.rhythmTransitionHelper.getTransitionEffect(i3);
                TAVSticker tAVSticker = null;
                if (needFaceSubTransition(transitionEffect, tAVMovieClip, tAVMovieClip2)) {
                    tAVTransitionAutomaticEffect = this.rhythmTransitionHelper.getFaceTransitionSubTransition(transitionEffect.subTransitions);
                    TAVSticker transitionSticker = this.rhythmTransitionHelper.getTransitionSticker(tAVTransitionAutomaticEffect);
                    long durationTime = transitionSticker.durationTime() / 1000;
                    if (durationTime > j3) {
                        tAVTransitionAutomaticEffect = transitionEffect;
                        z16 = false;
                        if (z16) {
                            cMTime = add;
                            list2 = clips;
                            if (end.sub(start).bigThan(new CMTime(j3 / 2, 1000))) {
                                applyTransitionToSegment(tAVTransitionAutomaticEffect, tAVSticker, start, j3, i3);
                            }
                            i3 = i16;
                            cMTime2 = cMTime;
                            clips = list2;
                        }
                    } else {
                        tAVSticker = transitionSticker;
                        j3 = durationTime;
                    }
                } else {
                    tAVTransitionAutomaticEffect = transitionEffect;
                }
                z16 = true;
                if (z16) {
                }
            }
            list2 = clips;
            cMTime = add;
            i3 = i16;
            cMTime2 = cMTime;
            clips = list2;
        }
        Logger.d(TAG, "buildCompositionFromSegments totalDuration " + cMTime2.getTimeSeconds());
        fillSegmentTAVClip(list);
        fillSegmentTimeEffect(list);
        correctSegments(list);
        List<List<TAVClip>> tAVClipsFromSegments = getTAVClipsFromSegments(this.mCorrectSegments);
        this.rhythmTransitionHelper.addExtraInfoToClip(tAVClipsFromSegments, getFaceTransitions());
        if (tAVClipsFromSegments != null && !tAVClipsFromSegments.isEmpty()) {
            for (List<TAVClip> list3 : tAVClipsFromSegments) {
                tAVComposition.getVideoChannels().add(list3);
                tAVComposition.getAudioChannels().add(list3);
            }
        }
        return tAVComposition;
    }

    @Nullable
    public List<List<TAVClip>> convertClipsFromMovie(TAVMovie tAVMovie, TAVRhythmAdjustClipType tAVRhythmAdjustClipType) {
        List<TAVMovieClipEx> separateClipsWithoutAdjust;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this, (Object) tAVMovie, (Object) tAVRhythmAdjustClipType);
        }
        List<TAVMovieClip> cloneMovieClips = CloneUtil.cloneMovieClips(tAVMovie.getClips());
        ArrayList arrayList = new ArrayList();
        if (CollectionUtil.isEmptyList(cloneMovieClips)) {
            return null;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < cloneMovieClips.size(); i16++) {
            arrayList.add(new TAVMovieClipEx(cloneMovieClips.get(i16)));
        }
        this.rhythmTransitionHelper.reRandomTransitions(cloneMovieClips.size());
        if (TAVAutomaticTemplate.isMapping) {
            this.rhythmTransitionHelper.reserveClipTransitionsTime(arrayList);
        } else {
            this.rhythmTransitionHelper.reserveClipTransitionTime(arrayList);
        }
        if (isNeedCycleFill(cloneMovieClips)) {
            separateClipsWithoutAdjust = separateClipsWithoutAdjust(arrayList, true);
            this.rhythmTransitionHelper.reRandomTransitions(cloneMovieClips.size());
        } else if (tAVRhythmAdjustClipType == TAVRhythmAdjustClipType.TAVRhythmAdjustClipMode1) {
            separateClipsWithoutAdjust = separateClipsWithAdjust(arrayList);
        } else {
            separateClipsWithoutAdjust = separateClipsWithoutAdjust(arrayList, false);
        }
        correctSegments(buildSegmentsFromClips(separateClipsWithoutAdjust));
        List<List<TAVClip>> tAVClipsFromSegments = getTAVClipsFromSegments(this.mCorrectSegments);
        this.rhythmTransitionHelper.addExtraInfoToClip(tAVClipsFromSegments, getFaceTransitions());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("correct segments count: ");
        sb5.append(this.mCorrectSegments.size());
        sb5.append(", channel count: ");
        if (tAVClipsFromSegments != null) {
            i3 = tAVClipsFromSegments.size();
        }
        sb5.append(i3);
        appendDebugInfo(sb5.toString());
        return tAVClipsFromSegments;
    }

    public List<CMTime> covertTAVEffectPointsToCMTimes(List<TAVEffectPoint> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<TAVEffectPoint> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new CMTime(it.next().getTime(), 1000).sub(this.musicRealStart));
            }
        }
        return arrayList;
    }

    public List<TAVRhythmMovieSegment> getCorrectSegments() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mCorrectSegments;
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    public TAVLUTAutomaticEffect getLutEffect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TAVLUTAutomaticEffect) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (!this.highlightPoints.isEmpty() && !this.highlightEffects.isEmpty() && this.singleResource) {
            long time = ((float) this.highlightPoints.get(0).getTime()) - (this.musicRealStart.getTimeSeconds() * 1000.0f);
            if (time >= 0) {
                for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : this.highlightEffects) {
                    if (tAVEffectAutomaticEffect != null && tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
                        TAVLUTAutomaticEffect tAVLUTAutomaticEffect = (TAVLUTAutomaticEffect) tAVEffectAutomaticEffect;
                        tAVLUTAutomaticEffect.setStartOffset(time);
                        appendDebugInfo("add highlight lut filter: " + tAVLUTAutomaticEffect.getFilePath() + ", start offset: " + time);
                        return tAVLUTAutomaticEffect;
                    }
                }
            }
        }
        return super.getLutEffect();
    }

    public TAVRhythmRandomType getRandomType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (TAVRhythmRandomType) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.randomType;
    }

    public String getRhythmEffectID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.rhythmEffectID;
    }

    public List<Integer> getSecondApplyEffectsRandomIndices() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.secondApplyEffectsRandomIndices;
    }

    public ArrayList<TAVTransitionAutomaticEffect> getTransitionApplyEffects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.rhythmTransitionHelper.getTransitionAutomaticEffectList();
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    public boolean isOpeningEffectEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!this.highlightPoints.isEmpty() && ((float) this.highlightPoints.get(0).getTime()) - (this.musicRealStart.getTimeSeconds() * 1000.0f) < 3000.0f) {
            appendDebugInfo("OpeningEffect: false");
            return false;
        }
        appendDebugInfo("OpeningEffect: true");
        return true;
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    public boolean isRhythmTemplate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isRhythmTemplate;
    }

    public void parseMusicRhythm(Context context, @NonNull String str, @NonNull String str2, long j3, @Nullable List<Integer> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, str, str2, Long.valueOf(j3), list, Integer.valueOf(i3));
            return;
        }
        this.randomIndex = i3;
        this.secondApplyEffectsRandomIndices.clear();
        if (list != null && !list.isEmpty()) {
            this.secondApplyEffectsRandomIndices.addAll(list);
        }
        randomRhythmChannleAndAdjustMode();
        RhythmDataBean parseRhythmTemplate = JsonUtils.parseRhythmTemplate(context, str);
        setContext(context);
        loadMusicEffectPointsWithRhythmDataBean(parseRhythmTemplate, str2, j3);
        checkRhythmTransitionHelper();
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate, com.tencent.tavmovie.TAVTemplate
    public void parseToMovie(@NonNull TAVMovie tAVMovie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tAVMovie);
            return;
        }
        super.parseToMovie(tAVMovie);
        this.movie = tAVMovie;
        if (tAVMovie.getClips().size() == 1) {
            this.singleResource = true;
        }
        fillRandomType(tAVMovie);
        configSegments();
        configMusicSecondEffects();
        checkRhythmTransitionHelper();
    }

    public void setMaxVideoDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.maxVideoDuration = new CMTime(j3, 1000);
        }
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    public void setTemplateDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        super.setTemplateDir(str);
        this.highlightEffectsPath = str;
        this.secondEffectsPath = str;
    }

    public void setTransitionEffects(ArrayList<TAVTransitionAutomaticEffect> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) arrayList);
            return;
        }
        this.rhythmTransitionHelper.setTransitionAutomaticEffectList(arrayList);
        if (TAVAutomaticTemplate.isMapping) {
            this.rhythmTransitionHelper.computeTransitionTimes();
        } else {
            this.rhythmTransitionHelper.computeTransitionTime();
        }
    }

    @Override // com.tencent.autotemplate.TAVAutomaticTemplate
    public void configMusic(String str, String str2, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Float.valueOf(f16));
        } else {
            super.configMusic(str, str2, f16);
            this.musicRealStart = new CMTime(f16, 1000);
        }
    }
}
