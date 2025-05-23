package com.tencent.qcircle.weseevideo.composition;

import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.weishi.module.publisher.WSAudioEngine;
import com.tencent.qcircle.weseevideo.composition.effectnode.AEKitNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.CropEffectNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.GestureNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.LightVideoRenderNote;
import com.tencent.qcircle.weseevideo.composition.effectnode.PreSegNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectNodeFactory;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSLutEffectNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverlayStickerMergedEffectNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSPagChainStickerMergedEffectNode;
import com.tencent.qcircle.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.qcircle.weseevideo.editor.sticker.WsStickerRenderContext;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.LutModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoBeginModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoEndModel;
import com.tencent.qcircle.weseevideo.model.effect.VideoFenWeiModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightTemplate;
import com.tencent.qcircle.weseevideo.model.utils.AudioUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.component.effectchain.IVideoEffectContext;
import com.tencent.tavkit.component.effectchain.VideoEffectProxy;
import com.tencent.tavkit.component.effectchain.VideoMixEffectProxy;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoRenderChainManager {
    public static final String TAG = "VideoRenderChainManager";
    private OnNodeRenderListener lightNodeRenderListener;
    private AEKitNode mAEKitNode;
    private VideoEffectProxy mAfterVideoEffectProxy;
    private CopyOnWriteArrayList<TAVVideoEffect> mAfterVideoEffects;
    private int mApplyType;
    private TAVAutomaticTemplate mAutomaticTemplate;
    private VideoEffectProxy mBeforeVideoEffectProxy;
    private CopyOnWriteArrayList<TAVVideoEffect> mBeforeVideoEffects;
    private TAVComposition mComposition;
    private VideoRenderChainConfigure mConfigure;
    private CropEffectNode mCropEffectNode;
    private IEffectNodeInterface mEffectNodeInterface;
    private GestureNode mGestureNode;
    private LightTemplate mLightTemplate;
    private LightVideoRenderNote mLightVideoRenderNote;
    private WSLutEffectNode mLutEffectNode;
    private MediaModel mMediaModel;
    private TAVVideoMixEffect mPagChainMergedEffect;
    private WSOverlayStickerMergedEffectNode mPagOverlayMergedEffect;
    private PreSegNode mPreSegNode;
    private IStickerContextInterface mRenderContextCreator;
    private TAVStickerRenderContext mSharePagChainRenderContext;
    private TAVStickerRenderContext mSharePagOverlayStickerContext;
    private VideoMixEffectProxy mVideoMixEffectProxy;
    private CopyOnWriteArrayList<TAVVideoMixEffect> mVideoMixEffects;
    private WSAudioEngine mWsAudioEngine;
    private ShouldRenderStickerAdapter shouldRenderStickerAdapter;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface IEffectNodeInterface {
        void insertEffectNode(VideoRenderChainManager videoRenderChainManager, MediaEffectModel mediaEffectModel);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface IStickerContextInterface {
        void alignStickers(long j3);

        @NonNull
        TAVStickerContext createStickerContext(boolean z16);

        void releaseStickerContext();
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ShouldRenderStickerAdapter {
        boolean shouldRenderSticker(TAVSticker tAVSticker, long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class WSVideoEffectContext implements IVideoEffectContext {
        WSVideoEffectContext() {
        }

        @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
        public TAVVideoEffect getGlobalVideoEffect() {
            VideoRenderChainManager.this.mAfterVideoEffectProxy.setEffects(VideoRenderChainManager.this.mAfterVideoEffects);
            return VideoRenderChainManager.this.mAfterVideoEffectProxy;
        }

        @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
        public TAVVideoEffect getSourceVideoEffect() {
            VideoRenderChainManager.this.mBeforeVideoEffectProxy.setEffects(VideoRenderChainManager.this.mBeforeVideoEffects);
            return VideoRenderChainManager.this.mBeforeVideoEffectProxy;
        }

        @Override // com.tencent.tavkit.component.effectchain.IVideoEffectContext
        public TAVVideoMixEffect getVideoMixEffect() {
            VideoRenderChainManager.this.mVideoMixEffectProxy.setEffects(VideoRenderChainManager.this.mVideoMixEffects);
            return VideoRenderChainManager.this.mVideoMixEffectProxy;
        }
    }

    public VideoRenderChainManager(@NonNull TAVComposition tAVComposition, MediaModel mediaModel) {
        this(-1, tAVComposition, mediaModel, null);
    }

    private boolean checkOverlayMergedEffect() {
        boolean z16;
        if (this.mPagOverlayMergedEffect == null) {
            TAVStickerRenderContext tAVStickerRenderContext = this.mSharePagOverlayStickerContext;
            IStickerContextInterface iStickerContextInterface = this.mRenderContextCreator;
            if (this.mConfigure.mApplyType != 101) {
                z16 = true;
            } else {
                z16 = false;
            }
            WSOverlayStickerMergedEffectNode createPagOverlayEffect = VideoEffectNodeFactory.createPagOverlayEffect(tAVStickerRenderContext, iStickerContextInterface, z16);
            this.mPagOverlayMergedEffect = createPagOverlayEffect;
            this.mAfterVideoEffects.add(createPagOverlayEffect);
        }
        return this.mPagOverlayMergedEffect instanceof WSOverlayStickerMergedEffectNode;
    }

    private TAVVideoMixEffect checkPagChainMergedEffect() {
        if (this.mPagChainMergedEffect == null) {
            TAVVideoMixEffect createPagChainEffect = VideoEffectNodeFactory.createPagChainEffect(this.mSharePagChainRenderContext);
            this.mPagChainMergedEffect = createPagChainEffect;
            this.mVideoMixEffects.add(createPagChainEffect);
        }
        return this.mPagChainMergedEffect;
    }

    private void initOverlayStickerContext() {
        IStickerContextInterface iStickerContextInterface = this.mRenderContextCreator;
        if (iStickerContextInterface != null) {
            this.mSharePagOverlayStickerContext = iStickerContextInterface.createStickerContext(this.mConfigure.isImageMode());
        }
        if (this.mSharePagOverlayStickerContext == null) {
            if (needBlur()) {
                this.mSharePagOverlayStickerContext = new WsStickerRenderContext();
            } else {
                this.mSharePagOverlayStickerContext = new TAVStickerRenderContext();
            }
        }
    }

    private void initPagChainStickerContext(MediaModel mediaModel) {
        if (this.mSharePagChainRenderContext == null) {
            int i3 = 1;
            if (this.mConfigure.getSceneType() == 1) {
                this.mSharePagChainRenderContext = new TAVStickerRenderContext();
            } else if (ModelExtKt.isImageMode(mediaModel) && this.mConfigure.isImageMode()) {
                this.mSharePagChainRenderContext = new TAVAutomaticTransRenderContext(mediaModel);
                AEFrameModel aEFrameModel = mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel().getAEFrameModel();
                if (aEFrameModel != null) {
                    i3 = aEFrameModel.getPagFillMode();
                }
                ((TAVAutomaticTransRenderContext) this.mSharePagChainRenderContext).setPagFillMode(i3);
                ((TAVAutomaticTransRenderContext) this.mSharePagChainRenderContext).setScreenSize(this.mConfigure.getScreenSize());
            } else {
                this.mSharePagChainRenderContext = new TAVAutomaticRenderContext();
            }
        }
        if (ModelExtKt.isImageMode(mediaModel)) {
            this.mSharePagChainRenderContext.setTavRenderContextDataSource(new ITAVRenderContextDataSource() { // from class: com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.1
                @Override // com.tencent.tavsticker.core.ITAVRenderContextDataSource
                public boolean shouldRenderSticker(TAVSticker tAVSticker, long j3) {
                    boolean z16;
                    CMTimeRange timeRange = tAVSticker.getTimeRange();
                    if (timeRange != null) {
                        CMTime cMTime = new CMTime(j3, 1000);
                        if ((!timeRange.getStart().smallThan(cMTime) && !timeRange.getStart().equalsTo(cMTime)) || (!timeRange.getEnd().bigThan(cMTime) && !timeRange.getEnd().equalsTo(cMTime))) {
                            z16 = false;
                            if (z16 || TAVStickerMode.INACTIVE != tAVSticker.getMode()) {
                                return false;
                            }
                            return true;
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                    return false;
                }
            });
            if (this.mApplyType == 101) {
                this.mSharePagOverlayStickerContext.setTavRenderContextDataSource(new ITAVRenderContextDataSource() { // from class: com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.2
                    @Override // com.tencent.tavsticker.core.ITAVRenderContextDataSource
                    public boolean shouldRenderSticker(TAVSticker tAVSticker, long j3) {
                        if (VideoRenderChainManager.this.shouldRenderStickerAdapter != null) {
                            return VideoRenderChainManager.this.shouldRenderStickerAdapter.shouldRenderSticker(tAVSticker, j3);
                        }
                        return false;
                    }
                });
            }
        }
    }

    private boolean needBlur() {
        Iterator<StickerModel> it = this.mMediaModel.getMediaEffectModel().getStickerModelList().iterator();
        while (it.hasNext()) {
            if ("blur".equals(it.next().getType())) {
                return true;
            }
        }
        return false;
    }

    private void updateAEKit(AEKitModel aEKitModel) {
        if (this.mAEKitNode == null) {
            AEKitNode aEKitNode = new AEKitNode();
            this.mAEKitNode = aEKitNode;
            this.mBeforeVideoEffects.add(aEKitNode);
        }
        this.mAEKitNode.setAEKitModel(aEKitModel);
    }

    private void updateCropEffect(CropModel cropModel) {
        if (cropModel == null) {
            CropEffectNode cropEffectNode = this.mCropEffectNode;
            if (cropEffectNode != null) {
                this.mBeforeVideoEffects.remove(cropEffectNode);
                this.mCropEffectNode = null;
                return;
            }
            return;
        }
        CropEffectNode cropEffectNode2 = this.mCropEffectNode;
        if (cropEffectNode2 == null) {
            CropEffectNode createCropEffectNode = VideoEffectNodeFactory.createCropEffectNode(cropModel);
            this.mCropEffectNode = createCropEffectNode;
            this.mBeforeVideoEffects.add(createCropEffectNode);
            return;
        }
        cropEffectNode2.setCropModel(cropModel);
    }

    private void updateLutEffect(LutModel lutModel) {
        VideoRenderChainConfigure videoRenderChainConfigure = this.mConfigure;
        if (videoRenderChainConfigure != null && !videoRenderChainConfigure.isOpenLutEffect()) {
            return;
        }
        if (lutModel == null) {
            WSLutEffectNode wSLutEffectNode = this.mLutEffectNode;
            if (wSLutEffectNode != null) {
                this.mBeforeVideoEffects.remove(wSLutEffectNode);
                this.mLutEffectNode = null;
                return;
            }
            return;
        }
        WSLutEffectNode wSLutEffectNode2 = this.mLutEffectNode;
        if (wSLutEffectNode2 == null) {
            WSLutEffectNode createLutEffectNode = VideoEffectNodeFactory.createLutEffectNode(lutModel);
            this.mLutEffectNode = createLutEffectNode;
            this.mBeforeVideoEffects.add(createLutEffectNode);
            return;
        }
        wSLutEffectNode2.setLutMode(lutModel);
    }

    private void updatePreSeg(PreSegModel preSegModel, CropModel cropModel) {
        if (this.mPreSegNode == null) {
            PreSegNode preSegNode = new PreSegNode();
            this.mPreSegNode = preSegNode;
            this.mBeforeVideoEffects.add(preSegNode);
        }
        this.mPreSegNode.setPreSegModel(preSegModel);
        this.mPreSegNode.setCropModel(cropModel);
    }

    private void updateStickerEffect(List<StickerModel> list) {
        VideoRenderChainConfigure videoRenderChainConfigure = this.mConfigure;
        if ((videoRenderChainConfigure == null || videoRenderChainConfigure.isOpenStickerEffect()) && checkOverlayMergedEffect()) {
            this.mPagOverlayMergedEffect.setStickerModels(list, this.mComposition.getRenderSize());
        }
    }

    private void updateStickerForTimeLineChanged() {
        TAVComposition tAVComposition;
        IStickerContextInterface iStickerContextInterface = this.mRenderContextCreator;
        if (iStickerContextInterface != null && (tAVComposition = this.mComposition) != null) {
            iStickerContextInterface.alignStickers(tAVComposition.getDuration().getTimeUs());
        }
    }

    private void updateSubtitleEffect(SubtitleModel subtitleModel) {
        VideoRenderChainConfigure videoRenderChainConfigure = this.mConfigure;
        if ((videoRenderChainConfigure == null || videoRenderChainConfigure.isOpenSubtitleEffect()) && checkOverlayMergedEffect()) {
            this.mPagOverlayMergedEffect.setSubtitleModel(subtitleModel, this.mComposition.getRenderSize());
        }
    }

    private void updateVideoBeginEffect(VideoBeginModel videoBeginModel) {
        VideoRenderChainConfigure videoRenderChainConfigure = this.mConfigure;
        if (videoRenderChainConfigure != null && !videoRenderChainConfigure.isOpenVideoBeginEffect()) {
            return;
        }
        TAVVideoMixEffect checkPagChainMergedEffect = checkPagChainMergedEffect();
        if (checkPagChainMergedEffect instanceof WSPagChainStickerMergedEffectNode) {
            ((WSPagChainStickerMergedEffectNode) checkPagChainMergedEffect).setVideoBeginModel(videoBeginModel);
        }
    }

    private void updateVideoEndEffect(VideoEndModel videoEndModel) {
        VideoRenderChainConfigure videoRenderChainConfigure = this.mConfigure;
        if (videoRenderChainConfigure != null && !videoRenderChainConfigure.isOpenVideoEndEffect()) {
            return;
        }
        TAVVideoMixEffect checkPagChainMergedEffect = checkPagChainMergedEffect();
        if (checkPagChainMergedEffect instanceof WSPagChainStickerMergedEffectNode) {
            TAVComposition tAVComposition = this.mComposition;
            if (tAVComposition != null && videoEndModel != null) {
                videoEndModel.setCompositionDuration((float) (tAVComposition.getDuration().getTimeUs() / 1000));
            }
            ((WSPagChainStickerMergedEffectNode) checkPagChainMergedEffect).setVideoEndModel(videoEndModel);
        }
    }

    private void updateVideoFenWeiEffect(VideoFenWeiModel videoFenWeiModel) {
        VideoRenderChainConfigure videoRenderChainConfigure = this.mConfigure;
        if (videoRenderChainConfigure != null && !videoRenderChainConfigure.isOpenVideoFenWeiEffect()) {
            return;
        }
        TAVVideoMixEffect checkPagChainMergedEffect = checkPagChainMergedEffect();
        if (checkPagChainMergedEffect instanceof WSPagChainStickerMergedEffectNode) {
            ((WSPagChainStickerMergedEffectNode) checkPagChainMergedEffect).setVideoFenWeiModel(videoFenWeiModel);
        }
    }

    public void addBgmEffect(@NonNull TAVClip tAVClip) {
        TAVComposition tAVComposition = this.mComposition;
        if (tAVComposition == null) {
            Logger.e(TAG, "this mComposition is null.");
            return;
        }
        List<? extends TAVAudio> audios = tAVComposition.getAudios();
        if (audios == null) {
            audios = new ArrayList<>();
            this.mComposition.setAudios(audios);
        }
        audios.add(tAVClip);
    }

    public TAVComposition getComposition() {
        return this.mComposition;
    }

    public LightTemplate getLightTemplate() {
        return this.mLightTemplate;
    }

    public MediaModel getMediaModel() {
        return this.mMediaModel;
    }

    public TAVStickerRenderContext getPagChainRenderContext() {
        return this.mSharePagChainRenderContext;
    }

    public TAVStickerRenderContext getStickerRenderContext() {
        if (this.mSharePagOverlayStickerContext == null) {
            initOverlayStickerContext();
        }
        return this.mSharePagOverlayStickerContext;
    }

    public void release() {
        TAVStickerRenderContext tAVStickerRenderContext;
        TAVStickerRenderContext tAVStickerRenderContext2 = this.mSharePagChainRenderContext;
        if (tAVStickerRenderContext2 != null) {
            tAVStickerRenderContext2.release();
            this.mSharePagChainRenderContext = null;
        }
        IStickerContextInterface iStickerContextInterface = this.mRenderContextCreator;
        if (iStickerContextInterface != null) {
            iStickerContextInterface.releaseStickerContext();
        }
        if (this.mRenderContextCreator == null && (tAVStickerRenderContext = this.mSharePagOverlayStickerContext) != null) {
            tAVStickerRenderContext.release();
            this.mSharePagOverlayStickerContext = null;
        }
    }

    public void releaseAndKeepStickerContext() {
        TAVStickerRenderContext tAVStickerRenderContext;
        TAVStickerRenderContext tAVStickerRenderContext2 = this.mSharePagChainRenderContext;
        if (tAVStickerRenderContext2 != null) {
            tAVStickerRenderContext2.release();
            this.mSharePagChainRenderContext = null;
        }
        if (this.mRenderContextCreator == null && (tAVStickerRenderContext = this.mSharePagOverlayStickerContext) != null) {
            tAVStickerRenderContext.release();
            this.mSharePagOverlayStickerContext = null;
        }
    }

    public void setBasePicActive(boolean z16) {
        AEKitNode aEKitNode = this.mAEKitNode;
        if (aEKitNode != null) {
            aEKitNode.setBasePicActive(z16);
        }
    }

    public void setCachePicDelegate(PreSegNode.PicSaveDelegate picSaveDelegate) {
        this.mPreSegNode.setPicSaveDelegate(picSaveDelegate);
    }

    public void setComposition(TAVComposition tAVComposition) {
        this.mComposition = tAVComposition;
    }

    public void setFilterManager(AEFilterManager aEFilterManager) {
        AEKitNode aEKitNode = this.mAEKitNode;
        if (aEKitNode != null) {
            aEKitNode.setFilterManager(aEFilterManager);
        }
        PreSegNode preSegNode = this.mPreSegNode;
        if (preSegNode != null) {
            preSegNode.setFilterManager(aEFilterManager);
        }
    }

    public void setNeedRenderOverlayStickerMergedEffectNode(boolean z16) {
        this.mPagOverlayMergedEffect.setNeedRender(z16);
        this.mSharePagOverlayStickerContext.setTavRenderContextDataSource(new ITAVRenderContextDataSource() { // from class: com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.3
            @Override // com.tencent.tavsticker.core.ITAVRenderContextDataSource
            public boolean shouldRenderSticker(TAVSticker tAVSticker, long j3) {
                if (VideoRenderChainManager.this.shouldRenderStickerAdapter != null) {
                    return VideoRenderChainManager.this.shouldRenderStickerAdapter.shouldRenderSticker(tAVSticker, j3);
                }
                return false;
            }
        });
    }

    public void setShouldRenderStickerAdapter(ShouldRenderStickerAdapter shouldRenderStickerAdapter) {
        this.shouldRenderStickerAdapter = shouldRenderStickerAdapter;
    }

    public void updateBgmVolume(float f16) {
        WSAudioEngine wSAudioEngine = this.mWsAudioEngine;
        if (wSAudioEngine != null) {
            wSAudioEngine.updateBgmVolume(f16);
        }
    }

    public void updateLightAudioRender(LightTemplate lightTemplate, TAVComposition tAVComposition, MediaModel mediaModel) {
        this.mWsAudioEngine = new WSAudioEngine(tAVComposition, lightTemplate.getLightEngine().audioOutput());
        MusicModel musicModel = mediaModel.getMediaEffectModel().getMusicModel();
        this.mWsAudioEngine.initEmptyClip(musicModel.getVolume());
        this.mWsAudioEngine.initBgm(AudioUtils.getBGMAudioClips(tAVComposition.getDuration().getTimeUs() / 1000, musicModel.getMetaDataBean(), musicModel.getBgmVolume()), musicModel.getBgmVolume());
    }

    public void updateLightVideoRender(@NotNull LightTemplate lightTemplate, MediaModel mediaModel) {
        if (mediaModel != null && lightTemplate.getLightAsset() != null && lightTemplate.getLightEngine() != null) {
            this.mLightTemplate = lightTemplate;
            LightVideoRenderNote lightVideoRenderNote = this.mLightVideoRenderNote;
            if (lightVideoRenderNote != null) {
                this.mBeforeVideoEffects.remove(lightVideoRenderNote);
            }
            LightVideoRenderNote lightVideoRenderNote2 = new LightVideoRenderNote(lightTemplate.getLightEngine());
            this.mLightVideoRenderNote = lightVideoRenderNote2;
            lightVideoRenderNote2.setLightAsset(lightTemplate.getLightAsset());
            this.mLightVideoRenderNote.setOnNodeRenderListener(this.lightNodeRenderListener);
            this.mBeforeVideoEffects.add(this.mLightVideoRenderNote);
            return;
        }
        Logger.e(TAG, "updateLightVideoRender error!! some variable is NULL!");
    }

    public void updateMovieTemplateEffect(TAVSticker tAVSticker) {
        VideoRenderChainConfigure videoRenderChainConfigure = this.mConfigure;
        if (videoRenderChainConfigure != null && !videoRenderChainConfigure.isOpenMovieTemplateEffect()) {
            return;
        }
        this.mSharePagChainRenderContext.loadSticker(tAVSticker, false);
    }

    public TAVComposition updateRenderChain(@NonNull MediaEffectModel mediaEffectModel) {
        return updateRenderChain(mediaEffectModel, this.mApplyType != 101);
    }

    public TAVComposition updateVideoRenderChain() {
        if (this.mComposition == null) {
            Logger.e(TAG, "updateVideoRenderChain---this mComposition is null.");
            return null;
        }
        IEffectNodeInterface iEffectNodeInterface = this.mEffectNodeInterface;
        if (iEffectNodeInterface != null) {
            iEffectNodeInterface.insertEffectNode(this, this.mMediaModel.getMediaEffectModel());
        }
        MediaModel mediaModel = this.mMediaModel;
        if (mediaModel != null && mediaModel.getMediaEffectModel() != null) {
            updateStickerForTimeLineChanged();
            return updateRenderChain(this.mMediaModel.getMediaEffectModel());
        }
        Logger.e(TAG, "updateVideoRenderChain---this mMediaEffectModel is null.");
        return this.mComposition;
    }

    public void updateVideoVolume(float f16) {
        WSAudioEngine wSAudioEngine = this.mWsAudioEngine;
        if (wSAudioEngine != null) {
            wSAudioEngine.updateVideoVolume(f16);
        }
    }

    public VideoRenderChainManager(int i3, @NonNull TAVComposition tAVComposition, MediaModel mediaModel, IStickerContextInterface iStickerContextInterface) {
        this(i3, tAVComposition, mediaModel, iStickerContextInterface, null);
    }

    public TAVComposition updateRenderChain(@NonNull MediaEffectModel mediaEffectModel, boolean z16) {
        if (mediaEffectModel == null) {
            Logger.e(TAG, "updateVideoRenderChain---this mMediaEffectModel is null.");
            return this.mComposition;
        }
        updateCropEffect(mediaEffectModel.getCropModel());
        updatePreSeg(mediaEffectModel.getPreSegModel(), mediaEffectModel.getCropModel());
        updateVideoBeginEffect(mediaEffectModel.getVideoBeginModel());
        updateVideoFenWeiEffect(mediaEffectModel.getVideoFenWeiModel());
        updateVideoEndEffect(mediaEffectModel.getVideoEndModel());
        updateLutEffect(mediaEffectModel.getLutModel());
        updateAEKit(mediaEffectModel.getAeKitModel());
        if (z16) {
            updateStickerEffect(mediaEffectModel.getStickerModelList());
        }
        updateSubtitleEffect(mediaEffectModel.getSubtitleModel());
        this.mComposition.attachVideoEffectChain(new WSVideoEffectContext());
        return this.mComposition;
    }

    public VideoRenderChainManager(int i3, @NonNull TAVComposition tAVComposition, MediaModel mediaModel, IStickerContextInterface iStickerContextInterface, IEffectNodeInterface iEffectNodeInterface) {
        this(i3, tAVComposition, mediaModel, iStickerContextInterface, iEffectNodeInterface, null);
    }

    public VideoRenderChainManager(int i3, @NonNull TAVComposition tAVComposition, MediaModel mediaModel, IStickerContextInterface iStickerContextInterface, IEffectNodeInterface iEffectNodeInterface, VideoRenderChainConfigure videoRenderChainConfigure) {
        this.mApplyType = -1;
        this.mBeforeVideoEffectProxy = new VideoEffectProxy();
        this.mBeforeVideoEffects = new CopyOnWriteArrayList<>();
        this.mVideoMixEffectProxy = new VideoMixEffectProxy();
        this.mVideoMixEffects = new CopyOnWriteArrayList<>();
        this.mAfterVideoEffectProxy = new VideoEffectProxy();
        this.mAfterVideoEffects = new CopyOnWriteArrayList<>();
        this.lightNodeRenderListener = new OnNodeRenderListener() { // from class: com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.4
            @Override // com.tencent.qcircle.weseevideo.composition.interfaces.OnNodeRenderListener
            public void onNodeRender() {
                if (VideoRenderChainManager.this.mLightTemplate != null) {
                    RectF boundsByKey = VideoRenderChainManager.this.mLightTemplate.getMovieController().getBoundsByKey("hongbao");
                    if (!boundsByKey.isEmpty()) {
                        VideoRenderChainManager.this.mLightTemplate.getBoundsRect().put("hongbao", boundsByKey);
                    }
                }
            }
        };
        this.mApplyType = i3;
        this.mComposition = tAVComposition;
        this.mMediaModel = mediaModel;
        this.mRenderContextCreator = iStickerContextInterface;
        this.mEffectNodeInterface = iEffectNodeInterface;
        this.mConfigure = videoRenderChainConfigure;
        initOverlayStickerContext();
        initPagChainStickerContext(mediaModel);
        updateVideoRenderChain();
    }
}
