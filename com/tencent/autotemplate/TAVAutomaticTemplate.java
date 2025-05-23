package com.tencent.autotemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect;
import com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect;
import com.tencent.autotemplate.model.TAVAdaptiveMovieClip;
import com.tencent.autotemplate.model.TAVAspectFillModel;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectsModel;
import com.tencent.autotemplate.model.TAVLUTAutomaticEffect;
import com.tencent.autotemplate.model.TAVPagAutomaticEffect;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.model.TAVVolumeAutomaticEffect;
import com.tencent.autotemplate.model.bean.MaterialLimits;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.autotemplate.transition.FaceTransition;
import com.tencent.autotemplate.transition.TransitionEffectModel;
import com.tencent.autotemplate.transition.TransitionHelper;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.autotemplate.utils.RandomUtil;
import com.tencent.autotemplate.utils.TemplateUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.component.TAVTimeEffect;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.utils.CompositionUtils;
import com.tencent.tavkit.utils.TAVBitmapUtils;
import com.tencent.tavmovie.TAVMovie;
import com.tencent.tavmovie.TAVTemplate;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import com.tencent.tavmovie.filter.TAVMovieFilterChainContext;
import com.tencent.tavmovie.filter.TAVMovieFilterProxy;
import com.tencent.tavmovie.filter.TAVStickerOverlayEffect;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVAutomaticTemplate implements TAVTemplate {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_IMAGE_EFFECT_COUNT = 4;
    public static final String DEFAULT_IMAGE_EFFECT_PAG_NAME = "pag/autotemplate";
    private static final boolean OPEN_FILTER_STICKERS = true;
    private static final boolean OPEN_LUT_FILTER = true;
    private static final boolean OPEN_OVERLAY_STICKERS = true;
    public static final String TAG = "TAVAutomaticTemplate";
    public static final int VIDEO_MIN_DURATION_FOR_HAS_CLOSING = 5000;
    public static transient boolean isMapping;
    public TAVAspectFillModel aspectFillModel;

    @SerializedName("backgroundColor")
    private String backgroundColor;
    private transient boolean buildFromSegmentCache;
    private transient Context context;
    private transient StringBuilder debugInfo;
    protected transient List<TAVPagAutomaticEffect> effectModelList;

    @SerializedName(JsonUtils.KEY_EFFECTS)
    protected TAVEffectsModel effectsModel;
    private transient ExtraData extraData;
    private transient List<FaceTransition> faceTransitions;
    private transient String filePath;

    @SerializedName("fillScale")
    private float fillScale;
    private transient List<TAVSticker> filterStickers;

    @SerializedName("fonts")
    private List<String> fontList;

    @SerializedName(JsonUtils.KEY_IMAGE_DURATIONS)
    private List<Long> imageDurations;
    private transient List<TAVMovieSticker> imageEffects;
    private transient String imagePagAssetDir;
    protected transient List<TAVMovieFilterProxy> lutFilters;

    @SerializedName("material_limit")
    protected MaterialLimits materialLimits;

    @SerializedName(JsonUtils.KEY_BGM)
    protected TAVAdaptiveMovieClip musicResource;
    private transient List<TAVSticker> overlayStickers;

    @SerializedName("preDetect")
    protected List<String> preDetect;
    protected transient CGSize renderSize;

    @SerializedName("rhythmEffectsGroup")
    protected List<TAVRhythmEffects> rhythmEffectsGroup;

    @SerializedName("secondEffectApplyType")
    protected int secondEffectApplyType;
    protected transient String templateDir;
    private transient String templateName;
    private transient List<TAVTimeEffect> timeEffects;

    @SerializedName("transThreshold")
    protected long transThreshold;

    @SerializedName("transitionApplyType")
    protected int transitionApplyType;
    protected transient List<TransitionEffectModel> transitionEffectModels;
    private transient TransitionHelper transitionHelper;
    protected transient List<TAVSticker> transitionStickers;

    @SerializedName(JsonUtils.KEY_TRANSITIONS)
    protected List<TAVTransitionAutomaticEffect> transitions;

    @SerializedName("version")
    private String version;

    @SerializedName(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME)
    private float volume;

    @SerializedName(JsonUtils.KEY_VOLUME_EFFECTS)
    private List<TAVVolumeAutomaticEffect> volumeEffects;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12342);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 58)) {
            redirector.redirect((short) 58);
        } else {
            isMapping = false;
        }
    }

    public TAVAutomaticTemplate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.imageEffects = new ArrayList();
        this.filterStickers = new ArrayList();
        this.overlayStickers = new ArrayList();
        this.transitionStickers = new ArrayList();
        this.transitionEffectModels = new ArrayList();
        this.lutFilters = new ArrayList();
        this.effectModelList = new ArrayList();
        this.debugInfo = new StringBuilder();
    }

    private void addEffectToClip(TAVClip tAVClip, CGSize cGSize) {
        TAVMovieSticker imageMovieSticker;
        if (!isRhythmTemplate() && (((tAVClip.getResource() instanceof TAVImageResource) || (tAVClip.getResource() instanceof TAVImageTrackResource)) && (imageMovieSticker = imageMovieSticker(RandomUtil.RandomInt(1, 5))) != null && imageMovieSticker.getSticker() != null)) {
            imageMovieSticker.setTimeRange(tAVClip.getTimeRange());
            this.filterStickers.add(imageMovieSticker.getSticker());
        }
        if (isNeedDefaultBlurEffectNote(tAVClip, tAVClip.getVideoConfiguration())) {
            ArrayList arrayList = new ArrayList();
            TAVTimeRangeAspectFillEffect tAVTimeRangeAspectFillEffect = new TAVTimeRangeAspectFillEffect(cGSize);
            arrayList.add(tAVTimeRangeAspectFillEffect);
            TAVAspectFillModel tAVAspectFillModel = new TAVAspectFillModel();
            this.aspectFillModel = tAVAspectFillModel;
            tAVAspectFillModel.renderSize = cGSize;
            if (!TextUtils.isEmpty(this.backgroundColor)) {
                tAVTimeRangeAspectFillEffect.setBgCIColor(this.backgroundColor);
                this.aspectFillModel.backgroundColor = this.backgroundColor;
            }
            List<TAVVideoEffect> effects = tAVClip.getVideoConfiguration().getEffects();
            effects.addAll(arrayList);
            tAVClip.getVideoConfiguration().setEffects(effects);
        }
    }

    private void addFilterSticker(TAVPagAutomaticEffect tAVPagAutomaticEffect, long j3) {
        TAVMovieSticker convertToMovieStickerWithDuraton;
        if (tAVPagAutomaticEffect != null && j3 > 0 && (convertToMovieStickerWithDuraton = tAVPagAutomaticEffect.convertToMovieStickerWithDuraton((float) j3)) != null && convertToMovieStickerWithDuraton.getSticker() != null) {
            addEffect(convertToMovieStickerWithDuraton, tAVPagAutomaticEffect, this.filterStickers);
        }
    }

    private CIImage applyBackgroundEffect(CIImage cIImage, CGSize cGSize) {
        if (cIImage != null && cGSize != null) {
            if (cGSize.equals(cIImage.getSize())) {
                return cIImage;
            }
            return cIImage.imageByCompositingOverImage(new CIImage(cGSize));
        }
        return cIImage;
    }

    private void audioChannelsApplyEffect(TAVComposition tAVComposition, float f16) {
        List<List<? extends TAVTransitionableAudio>> audioChannels = tAVComposition.getAudioChannels();
        if (audioChannels != null) {
            for (List<? extends TAVTransitionableAudio> list : audioChannels) {
                if (list != null) {
                    for (TAVTransitionableAudio tAVTransitionableAudio : list) {
                        if (tAVTransitionableAudio != null && (tAVTransitionableAudio instanceof TAVClip)) {
                            TAVClip tAVClip = (TAVClip) tAVTransitionableAudio;
                            tAVClip.getAudioConfiguration().setVolume(this.volume);
                            volumeEffectApplyToClip(this.volumeEffects, tAVClip, f16);
                        }
                    }
                }
            }
        }
    }

    private void bgmApplyEffectToComposition(TAVComposition tAVComposition, float f16) {
        TAVAdaptiveMovieClip tAVAdaptiveMovieClip = this.musicResource;
        if (tAVAdaptiveMovieClip != null) {
            tAVAdaptiveMovieClip.setFileDir(this.templateDir);
            List<? extends TAVAudio> audios = tAVComposition.getAudios();
            if (audios == null) {
                audios = new ArrayList<>();
            }
            this.musicResource.setDuration(f16);
            TAVMovieClip convertToMovieClip = this.musicResource.convertToMovieClip();
            if (convertToMovieClip != null) {
                audios.add(convertToMovieClip.convertToClip());
            }
            tAVComposition.setAudios(audios);
            CompositionUtils.reloadAudioStartTimeWithTransitionableAudio(audios);
            Iterator<? extends TAVAudio> it = audios.iterator();
            while (it.hasNext()) {
                volumeEffectApplyToClip(this.musicResource.getVolumeEffects(), (TAVClip) it.next(), f16);
            }
        }
    }

    private void changeVolumeEffects(float f16, List<TAVVolumeAutomaticEffect> list) {
        if (!CollectionUtil.isEmptyList(list)) {
            for (TAVVolumeAutomaticEffect tAVVolumeAutomaticEffect : list) {
                if (tAVVolumeAutomaticEffect.getStartOffset() > -1.0f && tAVVolumeAutomaticEffect.getEndOffset() > -1.0f) {
                    tAVVolumeAutomaticEffect.setStartVolume(f16);
                    tAVVolumeAutomaticEffect.setEndVolume(f16);
                } else if (tAVVolumeAutomaticEffect.getStartOffset() > -1.0f && tAVVolumeAutomaticEffect.getEndOffset() == -1.0f) {
                    tAVVolumeAutomaticEffect.setEndVolume(f16);
                } else if (tAVVolumeAutomaticEffect.getEndOffset() > -1.0f && tAVVolumeAutomaticEffect.getStartOffset() == -1.0f) {
                    tAVVolumeAutomaticEffect.setStartVolume(f16);
                }
            }
        }
    }

    private void effectApplyToClip(@NonNull TAVComposition tAVComposition) {
        List<List<? extends TAVTransitionableVideo>> videoChannels = tAVComposition.getVideoChannels();
        if (CollectionUtil.isEmptyList(videoChannels)) {
            return;
        }
        for (List<? extends TAVTransitionableVideo> list : videoChannels) {
            if (!CollectionUtil.isEmptyList(list)) {
                Iterator<? extends TAVTransitionableVideo> it = list.iterator();
                while (it.hasNext()) {
                    addEffectToClip((TAVClip) it.next(), tAVComposition.getRenderSize());
                }
            }
        }
    }

    private TAVPagAutomaticEffect getClosingEffect() {
        TAVEffectsModel tAVEffectsModel = this.effectsModel;
        if (tAVEffectsModel == null) {
            return null;
        }
        List<TAVEffectAutomaticEffect> list = tAVEffectsModel.filterEffects;
        List<TAVEffectAutomaticEffect> list2 = tAVEffectsModel.overlayEffects;
        if (CollectionUtil.isEmptyList(list)) {
            if (CollectionUtil.isEmptyList(list2)) {
                return null;
            }
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : list2) {
                if (tAVEffectAutomaticEffect != null && tAVEffectAutomaticEffect.isClosingcredits() && tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
                    return tAVEffectAutomaticEffect.copyPAGEffectFrom();
                }
            }
        } else {
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect2 : list) {
                if (tAVEffectAutomaticEffect2 != null && tAVEffectAutomaticEffect2.isClosingcredits() && tAVEffectAutomaticEffect2.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
                    return tAVEffectAutomaticEffect2.copyPAGEffectFrom();
                }
            }
        }
        return null;
    }

    private TAVPagAutomaticEffect getOpeningEffect() {
        TAVEffectsModel tAVEffectsModel = this.effectsModel;
        if (tAVEffectsModel == null) {
            return null;
        }
        List<TAVEffectAutomaticEffect> list = tAVEffectsModel.filterEffects;
        List<TAVEffectAutomaticEffect> list2 = tAVEffectsModel.overlayEffects;
        if (CollectionUtil.isEmptyList(list)) {
            if (CollectionUtil.isEmptyList(list2)) {
                return null;
            }
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : list2) {
                if (tAVEffectAutomaticEffect != null && tAVEffectAutomaticEffect.isOpeningCredits() && tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
                    return tAVEffectAutomaticEffect.copyPAGEffectFrom();
                }
            }
        } else {
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect2 : list) {
                if (tAVEffectAutomaticEffect2 != null && tAVEffectAutomaticEffect2.isOpeningCredits() && tAVEffectAutomaticEffect2.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
                    return tAVEffectAutomaticEffect2.copyPAGEffectFrom();
                }
            }
        }
        return null;
    }

    private TAVMovieSticker imageMovieSticker(int i3) {
        String valueOf = String.valueOf(i3);
        if (TextUtils.isEmpty(this.imagePagAssetDir)) {
            return null;
        }
        TAVMovieSticker tAVMovieSticker = new TAVMovieSticker(this.imagePagAssetDir + "/" + valueOf + ".pag", true);
        TAVSticker sticker = tAVMovieSticker.getSticker();
        if (sticker == null) {
            return null;
        }
        sticker.setScale(1.0f);
        sticker.setCenterY(0.5f);
        sticker.setCenterX(0.5f);
        return tAVMovieSticker;
    }

    private boolean isNeedDefaultBlurEffectNote(TAVClip tAVClip, TAVVideoConfiguration tAVVideoConfiguration) {
        if (tAVClip.getExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO) == null && tAVVideoConfiguration.getContentMode() != TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill && isAddBlurEffectNote()) {
            return true;
        }
        return false;
    }

    private void setAllDirs(String str) {
        TAVAdaptiveMovieClip tAVAdaptiveMovieClip = this.musicResource;
        if (tAVAdaptiveMovieClip != null) {
            tAVAdaptiveMovieClip.setFileDir(str);
        }
        TAVEffectsModel tAVEffectsModel = this.effectsModel;
        if (tAVEffectsModel != null) {
            tAVEffectsModel.setAllFileDir(str);
        }
        List<TAVRhythmEffects> list = this.rhythmEffectsGroup;
        if (list != null && !list.isEmpty()) {
            Iterator<TAVRhythmEffects> it = this.rhythmEffectsGroup.iterator();
            while (it.hasNext()) {
                it.next().setFileDir(str);
            }
        }
    }

    private boolean shouldApplyClosingCredits(@NonNull TAVMovie tAVMovie, float f16) {
        float timeSeconds;
        if (f16 < 5000.0f || tAVMovie.getClips() == null || tAVMovie.getClips().size() == 0) {
            return false;
        }
        if (tAVMovie.getClips().size() == 1 && tAVMovie.getClips().get(0).getResource().getType() == TAVMovieResource.TAVResourceType.TAVResourceTypePhoto) {
            return false;
        }
        TAVPagAutomaticEffect openingEffect = getOpeningEffect();
        if (openingEffect == null) {
            timeSeconds = 0.0f;
        } else {
            timeSeconds = openingEffect.getStickerDuration().getTimeSeconds();
        }
        TAVPagAutomaticEffect closingEffect = getClosingEffect();
        if (closingEffect == null || (timeSeconds + closingEffect.getStickerDuration().getTimeSeconds()) * 1000.0f > f16) {
            return false;
        }
        return true;
    }

    private void videoEffectApplyToComposition(@NonNull TAVComposition tAVComposition, boolean z16, long j3) {
        TAVMovieSticker convertToMovieStickerWithDuraton;
        if (CollectionUtil.isEmptyList(tAVComposition.getVideoChannels())) {
            return;
        }
        TAVEffectsModel tAVEffectsModel = this.effectsModel;
        if (tAVEffectsModel != null && !CollectionUtil.isEmptyList(tAVEffectsModel.filterEffects)) {
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : this.effectsModel.filterEffects) {
                if (!isRhythmTemplate() || (tAVEffectAutomaticEffect.getRhythmEffectType() != 1 && tAVEffectAutomaticEffect.getRhythmEffectType() != 2)) {
                    if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
                        this.lutFilters.add(tAVEffectAutomaticEffect.copyLUTEffectFrom().convertToMovieFilter());
                    } else if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
                        TAVPagAutomaticEffect copyPAGEffectFrom = tAVEffectAutomaticEffect.copyPAGEffectFrom();
                        if (copyPAGEffectFrom.isOpeningCredits()) {
                            if (isOpeningEffectEnable()) {
                                addFilterSticker(copyPAGEffectFrom, j3);
                            }
                        } else if (copyPAGEffectFrom.isClosingcredits()) {
                            if (z16) {
                                addFilterSticker(copyPAGEffectFrom, j3);
                            }
                        } else {
                            addFilterSticker(copyPAGEffectFrom, j3);
                        }
                    }
                }
            }
        }
        TAVEffectsModel tAVEffectsModel2 = this.effectsModel;
        if (tAVEffectsModel2 != null && !CollectionUtil.isEmptyList(tAVEffectsModel2.overlayEffects)) {
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect2 : this.effectsModel.overlayEffects) {
                if (tAVEffectAutomaticEffect2.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG && (convertToMovieStickerWithDuraton = tAVEffectAutomaticEffect2.copyPAGEffectFrom().convertToMovieStickerWithDuraton((float) j3)) != null && convertToMovieStickerWithDuraton.getSticker() != null) {
                    this.overlayStickers.add(convertToMovieStickerWithDuraton.getSticker());
                }
            }
        }
    }

    private void volumeEffectApplyToClip(List<TAVVolumeAutomaticEffect> list, TAVClip tAVClip, float f16) {
        if (!CollectionUtil.isEmptyList(list) && tAVClip != null) {
            Iterator<TAVVolumeAutomaticEffect> it = list.iterator();
            while (it.hasNext()) {
                TAVAudioConfiguration.VolumeEdge convertToAudioVolumeEdge = it.next().convertToAudioVolumeEdge(f16);
                if (convertToAudioVolumeEdge != null) {
                    CMTimeRange intersection = CMTimeRange.getIntersection(tAVClip.getTimeRange(), convertToAudioVolumeEdge.getTimeRange());
                    if (tAVClip.getTimeRange().containsTimeRange(convertToAudioVolumeEdge.getTimeRange())) {
                        tAVClip.getAudioConfiguration().addVolumeEdge(convertToAudioVolumeEdge);
                    } else if (!CMTimeRange.CMTimeRangeInvalid.equals(intersection)) {
                        float startVolume = convertToAudioVolumeEdge.getStartVolume() + ((convertToAudioVolumeEdge.getEndVolume() - convertToAudioVolumeEdge.getStartVolume()) * (intersection.getStart().sub(convertToAudioVolumeEdge.getTimeRange().getStart()).getTimeSeconds() / convertToAudioVolumeEdge.getTimeRange().getDuration().getTimeSeconds()));
                        float startVolume2 = convertToAudioVolumeEdge.getStartVolume() + ((convertToAudioVolumeEdge.getEndVolume() - convertToAudioVolumeEdge.getStartVolume()) * (intersection.getEnd().sub(convertToAudioVolumeEdge.getTimeRange().getStart()).getTimeSeconds() / convertToAudioVolumeEdge.getTimeRange().getDuration().getTimeSeconds()));
                        convertToAudioVolumeEdge.setTimeRange(new CMTimeRange(intersection.getStart().sub(tAVClip.getStartTime()), intersection.getDuration()));
                        convertToAudioVolumeEdge.setStartVolume(startVolume);
                        convertToAudioVolumeEdge.setEndVolume(startVolume2);
                        tAVClip.getAudioConfiguration().addVolumeEdge(convertToAudioVolumeEdge);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addEffect(TAVMovieSticker tAVMovieSticker, TAVPagAutomaticEffect tAVPagAutomaticEffect, List<TAVSticker> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, tAVMovieSticker, tAVPagAutomaticEffect, list);
        } else {
            if (isMapping) {
                tAVPagAutomaticEffect.setStartOffset(tAVMovieSticker.getTimeRange().getStartUs() / 1000);
                tAVPagAutomaticEffect.setDuration(tAVMovieSticker.getTimeRange().getDurationUs() / 1000);
                this.effectModelList.add(tAVPagAutomaticEffect);
                return;
            }
            list.add(tAVMovieSticker.getSticker());
        }
    }

    public void addExtraFilterSticker(List<TAVSticker> list, CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) list, (Object) cMTime);
        }
    }

    public void addExtraOverlaySticker(List<TAVSticker> list, CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) list, (Object) cMTime);
        }
    }

    public void appendDebugInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.debugInfo.append("\n");
        this.debugInfo.append("\n");
        this.debugInfo.append(str);
    }

    public void applyTimeEffectToComposition(TAVComposition tAVComposition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) tAVComposition);
        }
    }

    public TAVComposition buildBaseComposition(@NonNull TAVMovie tAVMovie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (TAVComposition) iPatchRedirector.redirect((short) 29, (Object) this, (Object) tAVMovie);
        }
        this.buildFromSegmentCache = false;
        parseToMovie(tAVMovie);
        TAVComposition buildCompostion = buildCompostion(tAVMovie);
        applyTimeEffectToComposition(buildCompostion);
        TransitionHelper transitionHelper = new TransitionHelper(this.transitions, getExtraData(), this.templateDir, this.transitionStickers, getFaceTransitions());
        this.transitionHelper = transitionHelper;
        transitionHelper.setTransitionEffectModels(this.transitionEffectModels);
        this.transitionHelper.setTransitionApplyType(this.transitionApplyType);
        if (!isRhythmTemplate() && this.transitionHelper.needTransition(buildCompostion)) {
            this.transitionHelper.applyTransitionToComposition(buildCompostion);
        }
        TemplateUtils.reloadChannels(buildCompostion);
        long timeUs = TemplateUtils.calculateTotalTime(buildCompostion).getTimeUs() / 1000;
        effectApplyToClip(buildCompostion);
        float f16 = (float) timeUs;
        audioChannelsApplyEffect(buildCompostion, f16);
        bgmApplyEffectToComposition(buildCompostion, f16);
        videoEffectApplyToComposition(buildCompostion, shouldApplyClosingCredits(tAVMovie, f16), timeUs);
        float f17 = f16 / 1000.0f;
        addExtraFilterSticker(this.filterStickers, new CMTime(f17));
        addExtraOverlaySticker(this.overlayStickers, new CMTime(f17));
        return buildCompostion;
    }

    @Override // com.tencent.tavmovie.TAVTemplate
    public TAVComposition buildCompositionFromMovie(@NonNull TAVMovie tAVMovie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (TAVComposition) iPatchRedirector.redirect((short) 31, (Object) this, (Object) tAVMovie);
        }
        clearDebugInfo();
        TAVComposition buildBaseComposition = buildBaseComposition(tAVMovie);
        TAVMovieFilterChainContext tAVMovieFilterChainContext = new TAVMovieFilterChainContext();
        List<TAVMovieFilterProxy> list = this.lutFilters;
        if (list != null && !list.isEmpty()) {
            Iterator<TAVMovieFilterProxy> it = this.lutFilters.iterator();
            while (it.hasNext()) {
                tAVMovieFilterChainContext.addFilter(it.next());
            }
        }
        if (this.filterStickers.size() > 0 || this.transitionStickers.size() > 0) {
            TAVAutomaticRenderContext tAVAutomaticRenderContext = new TAVAutomaticRenderContext();
            tAVAutomaticRenderContext.setTransitionStickers(this.transitionStickers);
            if (!isMapping) {
                tAVAutomaticRenderContext.setEffectStickers(this.filterStickers);
            }
            tAVAutomaticRenderContext.readAllVideoTracks();
            TAVOneClickFilmStickerEffect tAVOneClickFilmStickerEffect = new TAVOneClickFilmStickerEffect(tAVAutomaticRenderContext);
            tAVOneClickFilmStickerEffect.setFaceTransitions(this.faceTransitions);
            buildBaseComposition.setVideoMixEffect(tAVOneClickFilmStickerEffect);
        }
        if (this.overlayStickers.size() > 0) {
            TAVAutomaticRenderContext tAVAutomaticRenderContext2 = new TAVAutomaticRenderContext();
            tAVAutomaticRenderContext2.reloadStickers(this.overlayStickers);
            tAVMovieFilterChainContext.addFilter(new TAVStickerOverlayEffect(tAVAutomaticRenderContext2));
        }
        buildBaseComposition.setGlobalVideoEffect(tAVMovieFilterChainContext);
        return buildBaseComposition;
    }

    public TAVComposition buildCompositionFromSegments(TAVMovie tAVMovie, List<TAVRhythmMovieSegment> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (TAVComposition) iPatchRedirector.redirect((short) 45, (Object) this, (Object) tAVMovie, (Object) list);
        }
        return null;
    }

    public TAVComposition buildCompostion(TAVMovie tAVMovie) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (TAVComposition) iPatchRedirector.redirect((short) 33, (Object) this, (Object) tAVMovie);
        }
        if (!tAVMovie.getTimeEffects().isEmpty()) {
            f16 = tAVMovie.getTimeEffects().get(0).getSpeed();
        } else {
            f16 = 1.0f;
        }
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.setRenderSize(this.renderSize);
        tAVComposition.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        for (int i3 = 0; i3 < tAVMovie.getClips().size(); i3++) {
            TAVClip convertToClip = tAVMovie.getClips().get(i3).convertToClip();
            TAVRhythmTimeEffectUtils.covertTAVClipTimeScale(convertToClip);
            if (f16 != 1.0f && f16 > 0.0f) {
                TAVResource resource = convertToClip.getResource();
                resource.setScaledDuration(resource.getSourceTimeRange().getDuration().divide(f16));
            }
            convertToClip.putExtraTrackInfo(TAVOneClickFilmStickerEffect.TRACK_INDEX, Integer.valueOf(i3));
            convertToClip.setStartTime(new CMTime(j3, 1000));
            arrayList.add(convertToClip);
            j3 = ((float) j3) + (((float) convertToClip.getDuration().getTimeUs()) / 1000.0f);
        }
        if (!arrayList.isEmpty()) {
            tAVComposition.addAudioChannel(arrayList);
            tAVComposition.addVideoChannel(arrayList);
        }
        return tAVComposition;
    }

    public void clearDebugInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            StringBuilder sb5 = this.debugInfo;
            sb5.delete(0, sb5.length());
        }
    }

    public void configMusic(String str, String str2, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, str, str2, Float.valueOf(f16));
            return;
        }
        if (this.musicResource == null) {
            this.musicResource = new TAVAdaptiveMovieClip();
        }
        this.musicResource.setFileName(str2);
        this.musicResource.setFileDir(str);
        this.musicResource.setStartOffset(f16);
    }

    @Override // com.tencent.tavmovie.TAVTemplate
    public List<TAVMovieSegment> convertClips(List<TAVMovieClip> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (List) iPatchRedirector.redirect((short) 34, (Object) this, (Object) list);
        }
        if (list != null) {
            list.isEmpty();
            return null;
        }
        return null;
    }

    public List<TAVSticker> getAllStickers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (List) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmptyList(this.filterStickers)) {
            arrayList.addAll(this.filterStickers);
        }
        if (!CollectionUtil.isEmptyList(this.overlayStickers)) {
            arrayList.addAll(arrayList.size(), this.overlayStickers);
        }
        return arrayList;
    }

    public String getBackgroundColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.backgroundColor;
    }

    public float getBgmVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Float) iPatchRedirector.redirect((short) 37, (Object) this)).floatValue();
        }
        TAVAdaptiveMovieClip tAVAdaptiveMovieClip = this.musicResource;
        if (tAVAdaptiveMovieClip != null) {
            return tAVAdaptiveMovieClip.getVolume();
        }
        return 0.0f;
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Context) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.context;
    }

    public StringBuilder getDebugInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (StringBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.debugInfo;
    }

    public List<TAVPagAutomaticEffect> getEffectModelList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (List) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        return this.effectModelList;
    }

    public TAVEffectsModel getEffectsModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TAVEffectsModel) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.effectsModel;
    }

    public ExtraData getExtraData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ExtraData) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        if (this.extraData == null) {
            this.extraData = new ExtraData();
        }
        return this.extraData;
    }

    public List<FaceTransition> getFaceTransitions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        if (this.faceTransitions == null) {
            this.faceTransitions = new ArrayList();
        }
        return this.faceTransitions;
    }

    public String getFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.filePath;
    }

    public List<TAVSticker> getFilterStickers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.filterStickers;
    }

    public List<String> getFontList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.fontList;
    }

    public List<TAVMovieSticker> getImageEffects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.imageEffects;
    }

    public String getImagePagAssetDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.imagePagAssetDir;
    }

    public boolean getIsMapping() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        return isMapping;
    }

    public TAVLUTAutomaticEffect getLutEffect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (TAVLUTAutomaticEffect) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        TAVEffectsModel effectsModel = getEffectsModel();
        if (effectsModel != null && !CollectionUtil.isEmptyList(effectsModel.filterEffects)) {
            for (TAVEffectAutomaticEffect tAVEffectAutomaticEffect : effectsModel.filterEffects) {
                if (!isRhythmTemplate() || (tAVEffectAutomaticEffect.getRhythmEffectType() != 1 && tAVEffectAutomaticEffect.getRhythmEffectType() != 2)) {
                    if (tAVEffectAutomaticEffect.getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
                        return tAVEffectAutomaticEffect.copyLUTEffectFrom();
                    }
                }
            }
            return null;
        }
        return null;
    }

    public List<TAVMovieFilterProxy> getLutFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.lutFilters;
    }

    public MaterialLimits getMaterialLimits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (MaterialLimits) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        return this.materialLimits;
    }

    @Override // com.tencent.tavmovie.TAVTemplate
    public List<TAVMovieClip> getMovieClips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (List) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return null;
    }

    public TAVAdaptiveMovieClip getMusicResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TAVAdaptiveMovieClip) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.musicResource;
    }

    public List<TAVSticker> getOverlayStickers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.overlayStickers;
    }

    public List<String> getPreDetect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (List) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return this.preDetect;
    }

    public CGSize getRenderSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (CGSize) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.renderSize;
    }

    public String getTemplateDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.templateDir;
    }

    public String getTemplateName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.templateName;
    }

    public List<TAVTimeEffect> getTimeEffects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.timeEffects;
    }

    public List<TransitionEffectModel> getTransitionEffectModels() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.transitionEffectModels;
    }

    public List<TAVSticker> getTransitionStickers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.transitionStickers;
    }

    public float getVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Float) iPatchRedirector.redirect((short) 39, (Object) this)).floatValue();
        }
        return this.volume;
    }

    public boolean isAddBlurEffectNote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        return a.f72569a;
    }

    public boolean isOpeningEffectEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return true;
    }

    public boolean isRhythmTemplate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.tavmovie.TAVTemplate
    public void parseToMovie(@NonNull TAVMovie tAVMovie) {
        int i3;
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) tAVMovie);
            return;
        }
        if (tAVMovie != null && !CollectionUtil.isEmptyList(tAVMovie.getClips())) {
            for (TAVMovieClip tAVMovieClip : tAVMovie.getClips()) {
                TAVMovieResource resource = tAVMovieClip.getResource();
                if (resource != null) {
                    TAVResource convertToResource = resource.convertToResource();
                    if (convertToResource instanceof TAVImageTrackResource) {
                        i3 = TAVBitmapUtils.readImagePreferRotation(((TAVImageTrackResource) convertToResource).getPath());
                    } else {
                        i3 = 0;
                    }
                    if (i3 % 2 == 1) {
                        f16 = resource.getNaturalSize().height;
                        f17 = resource.getNaturalSize().width;
                    } else {
                        f16 = resource.getNaturalSize().width;
                        f17 = resource.getNaturalSize().height;
                    }
                    float f18 = 0.0f;
                    if (f16 > 0.0f && f17 > 0.0f) {
                        f18 = f16 / f17;
                        if (f18 <= this.fillScale) {
                            tAVMovieClip.getVideoConfiguration().setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
                        }
                    }
                    if (resource.getType() == TAVMovieResource.TAVResourceType.TAVResourceTypePhoto && (resource instanceof TAVMovieImageResource)) {
                        TAVMovieImageResource tAVMovieImageResource = (TAVMovieImageResource) resource;
                        if (f18 > this.fillScale) {
                            TAVMovieImageResource mo280clone = tAVMovieImageResource.mo280clone();
                            mo280clone.setImage(applyBackgroundEffect(mo280clone.getImage(), tAVMovie.getRenderSize()));
                            tAVMovieClip.setResource(mo280clone);
                        }
                    }
                }
            }
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        List<TAVMovieFilterProxy> list = this.lutFilters;
        if (list != null && !list.isEmpty()) {
            Iterator<TAVMovieFilterProxy> it = this.lutFilters.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
    }

    public void setBgmVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Float.valueOf(f16));
            return;
        }
        TAVAdaptiveMovieClip tAVAdaptiveMovieClip = this.musicResource;
        if (tAVAdaptiveMovieClip != null) {
            tAVAdaptiveMovieClip.setVolume(f16);
            changeVolumeEffects(f16, this.musicResource.getVolumeEffects());
        }
    }

    public void setContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    public void setDebugInfo(StringBuilder sb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sb5);
        } else {
            this.debugInfo = sb5;
        }
    }

    public void setImagePagAssetDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.imagePagAssetDir = str;
        }
    }

    public void setIsAddBlurEffectNote(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, z16);
        } else {
            a.f72569a = z16;
        }
    }

    public void setMapping(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, z16);
        } else {
            isMapping = z16;
        }
    }

    public void setRenderSize(CGSize cGSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) cGSize);
        } else {
            this.renderSize = cGSize;
        }
    }

    public void setTemplateDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            this.templateDir = str;
            setAllDirs(str);
        }
    }

    public void setVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Float.valueOf(f16));
        } else {
            this.volume = f16;
            changeVolumeEffects(f16, this.volumeEffects);
        }
    }

    public TAVComposition buildBaseComposition(TAVMovie tAVMovie, List<TAVRhythmMovieSegment> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (TAVComposition) iPatchRedirector.redirect((short) 30, (Object) this, (Object) tAVMovie, (Object) list);
        }
        this.buildFromSegmentCache = true;
        parseToMovie(tAVMovie);
        TAVComposition buildCompositionFromSegments = buildCompositionFromSegments(tAVMovie, list);
        TemplateUtils.reloadChannels(buildCompositionFromSegments);
        long timeUs = TemplateUtils.calculateTotalTime(buildCompositionFromSegments).getTimeUs() / 1000;
        effectApplyToClip(buildCompositionFromSegments);
        float f16 = (float) timeUs;
        audioChannelsApplyEffect(buildCompositionFromSegments, f16);
        bgmApplyEffectToComposition(buildCompositionFromSegments, f16);
        videoEffectApplyToComposition(buildCompositionFromSegments, shouldApplyClosingCredits(tAVMovie, f16), timeUs);
        float f17 = f16 / 1000.0f;
        addExtraFilterSticker(this.filterStickers, new CMTime(f17));
        addExtraOverlaySticker(this.overlayStickers, new CMTime(f17));
        return buildCompositionFromSegments;
    }
}
