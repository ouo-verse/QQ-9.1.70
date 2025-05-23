package com.tencent.qcircle.tavcut.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGLContext;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.bean.TextEditorData;
import com.tencent.qcircle.tavcut.constants.Constants;
import com.tencent.qcircle.tavcut.exporter.ImageExportConfig;
import com.tencent.qcircle.tavcut.exporter.ImageExporter;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.CompositionUtils;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.tavcut.view.TAVCutImageView;
import com.tencent.qcircle.tavcut.view.ext.OnRenderFinishListener;
import com.tencent.qcircle.weseevideo.composition.TAVAutomaticTransRenderContext;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.composition.effectnode.PreSegNode;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSSegmentManager;
import com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender;
import com.tencent.qcircle.weseevideo.editor.sticker.PicStickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.WsStickerContext;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.WSTemplateManager;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.ttpic.baseutils.gles.EglCore;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TAVCutImageSession extends TAVCutSession {
    private static final int MAX_CACHE_SIZE = 1024;
    private static final String TAG = "TAVCutImageSession";
    private PreSegNode.PicSaveDelegate cachePicDelegate;
    private EGLContext eglContext;
    private EglCore eglCore;
    private List<String> imagePaths;
    private AssetImageGenerator.ImageGeneratorThread imageProcessThread;
    private RenderContext renderContext;
    private CGSize screenSize;
    private SparseArray<WSImageRender> imageRenderers = new SparseArray<>();
    private SparseArray<WeakReference<TAVCutImageView>> tavCutImageViews = new SparseArray<>();
    private SparseArray<VideoRenderChainConfigure> chainConfigs = new SparseArray<>();
    private SparseArray<Bitmap> cacheBitmap = new SparseArray<>();
    private SparseArray<List<PointF>> cachePointFList = new SparseArray<>();
    private AEFilterManager aeFilterManager = new AEFilterManager("defaultBeautyV6.json", false, false, null);
    private boolean addingMultiStickers = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qcircle.tavcut.session.TAVCutImageSession$26, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass26 implements Runnable {
        final /* synthetic */ int val$index;
        final /* synthetic */ OnRenderFinishListener val$onRenderFinishListener;

        /* compiled from: P */
        /* renamed from: com.tencent.qcircle.tavcut.session.TAVCutImageSession$26$1, reason: invalid class name */
        /* loaded from: classes22.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((WSImageRender) TAVCutImageSession.this.imageRenderers.get(AnonymousClass26.this.val$index)).render(new WSImageRender.ImageRenderCallback() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.26.1.1
                    @Override // com.tencent.qcircle.weseevideo.composition.image.WSImageRender.ImageRenderCallback
                    public void onCompletion(@Nullable final Bitmap bitmap, @Nullable final List<PointF> list) {
                        TAVCutImageSession.this.runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.26.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TAVCutImageView tAVCutImageView;
                                WeakReference weakReference = (WeakReference) TAVCutImageSession.this.tavCutImageViews.get(AnonymousClass26.this.val$index);
                                if (weakReference != null && (tAVCutImageView = (TAVCutImageView) weakReference.get()) != null) {
                                    if (!BitmapUtil.isValidBitmap(bitmap)) {
                                        OnRenderFinishListener onRenderFinishListener = AnonymousClass26.this.val$onRenderFinishListener;
                                        if (onRenderFinishListener != null) {
                                            onRenderFinishListener.onRenderFinish();
                                            return;
                                        }
                                        return;
                                    }
                                    TAVCutImageSession.this.getMediaModels().get(AnonymousClass26.this.val$index).getMediaEffectModel().getGestureModel().setCorner(list);
                                    tAVCutImageView.setImageBitmap(bitmap, list);
                                    AnonymousClass26 anonymousClass26 = AnonymousClass26.this;
                                    TAVCutImageSession.this.saveBitmapToCache(anonymousClass26.val$index, bitmap, list);
                                    AnonymousClass26 anonymousClass262 = AnonymousClass26.this;
                                    TAVCutImageSession.this.resizeUI(anonymousClass262.val$index);
                                    AnonymousClass26 anonymousClass263 = AnonymousClass26.this;
                                    TAVCutImageSession.this.setAddingMultiStickers(anonymousClass263.val$index, false);
                                    AnonymousClass26 anonymousClass264 = AnonymousClass26.this;
                                    VideoRenderChainManager videoRenderChainManager = TAVCutImageSession.this.renderChainManagers.get(anonymousClass264.val$index);
                                    if (videoRenderChainManager != null) {
                                        videoRenderChainManager.setNeedRenderOverlayStickerMergedEffectNode(false);
                                    }
                                    OnRenderFinishListener onRenderFinishListener2 = AnonymousClass26.this.val$onRenderFinishListener;
                                    if (onRenderFinishListener2 != null) {
                                        onRenderFinishListener2.onRenderFinish();
                                    }
                                }
                            }
                        });
                    }
                }, TAVCutImageSession.this.eglContext, TAVCutImageSession.this.imageProcessThread, TAVCutImageSession.this.renderContext);
            }
        }

        AnonymousClass26(int i3, OnRenderFinishListener onRenderFinishListener) {
            this.val$index = i3;
            this.val$onRenderFinishListener = onRenderFinishListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TAVCutImageSession.this.tavCutImageViews.get(this.val$index) == null) {
                OnRenderFinishListener onRenderFinishListener = this.val$onRenderFinishListener;
                if (onRenderFinishListener != null) {
                    onRenderFinishListener.onRenderFinish();
                    return;
                }
                return;
            }
            if (TAVCutImageSession.this.renderChainManagers.get(this.val$index) == null || TAVCutImageSession.this.imageRenderers.get(this.val$index) == null) {
                DurationUtil.start("initRenderEnvironment");
                TAVCutImageSession.this.initRenderEnvironment(this.val$index);
                DurationUtil.end("initRenderEnvironment");
            }
            TAVCutImageSession.this.imageProcessThread.getHandler().post(new AnonymousClass1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qcircle.tavcut.session.TAVCutImageSession$27, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass27 implements Runnable {
        final /* synthetic */ int val$index;
        final /* synthetic */ OnRenderFinishListener val$onRenderFinishListener;

        /* compiled from: P */
        /* renamed from: com.tencent.qcircle.tavcut.session.TAVCutImageSession$27$1, reason: invalid class name */
        /* loaded from: classes22.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((WSImageRender) TAVCutImageSession.this.imageRenderers.get(AnonymousClass27.this.val$index)).render(new WSImageRender.ImageRenderCallback() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.27.1.1
                    @Override // com.tencent.qcircle.weseevideo.composition.image.WSImageRender.ImageRenderCallback
                    public void onCompletion(@Nullable final Bitmap bitmap, @Nullable final List<PointF> list) {
                        TAVCutImageSession.this.runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.27.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TAVCutImageView tAVCutImageView;
                                WeakReference weakReference = (WeakReference) TAVCutImageSession.this.tavCutImageViews.get(AnonymousClass27.this.val$index);
                                if (weakReference != null && (tAVCutImageView = (TAVCutImageView) weakReference.get()) != null) {
                                    if (!BitmapUtil.isValidBitmap(bitmap)) {
                                        OnRenderFinishListener onRenderFinishListener = AnonymousClass27.this.val$onRenderFinishListener;
                                        if (onRenderFinishListener != null) {
                                            onRenderFinishListener.onRenderFinish();
                                            return;
                                        }
                                        return;
                                    }
                                    TAVCutImageSession.this.getMediaModels().get(AnonymousClass27.this.val$index).getMediaEffectModel().getGestureModel().setCorner(list);
                                    tAVCutImageView.setImageBitmap(bitmap, list);
                                    AnonymousClass27 anonymousClass27 = AnonymousClass27.this;
                                    TAVCutImageSession.this.saveBitmapToCache(anonymousClass27.val$index, bitmap, list);
                                    AnonymousClass27 anonymousClass272 = AnonymousClass27.this;
                                    TAVCutImageSession.this.resizeUI(anonymousClass272.val$index);
                                    AnonymousClass27 anonymousClass273 = AnonymousClass27.this;
                                    TAVCutImageSession.this.setStickerVisible(anonymousClass273.val$index);
                                    TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                                    VideoRenderChainManager videoRenderChainManager = tAVCutImageSession.renderChainManagers.get(tAVCutImageSession.currentIndex);
                                    if (videoRenderChainManager != null) {
                                        videoRenderChainManager.setNeedRenderOverlayStickerMergedEffectNode(true);
                                    }
                                    OnRenderFinishListener onRenderFinishListener2 = AnonymousClass27.this.val$onRenderFinishListener;
                                    if (onRenderFinishListener2 != null) {
                                        onRenderFinishListener2.onRenderFinish();
                                    }
                                }
                            }
                        });
                    }
                }, TAVCutImageSession.this.eglContext, TAVCutImageSession.this.imageProcessThread, TAVCutImageSession.this.renderContext);
            }
        }

        AnonymousClass27(int i3, OnRenderFinishListener onRenderFinishListener) {
            this.val$index = i3;
            this.val$onRenderFinishListener = onRenderFinishListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TAVCutImageSession.this.tavCutImageViews.get(this.val$index) == null) {
                OnRenderFinishListener onRenderFinishListener = this.val$onRenderFinishListener;
                if (onRenderFinishListener != null) {
                    onRenderFinishListener.onRenderFinish();
                    return;
                }
                return;
            }
            if (TAVCutImageSession.this.renderChainManagers.get(this.val$index) == null || TAVCutImageSession.this.imageRenderers.get(this.val$index) == null) {
                DurationUtil.start("initRenderEnvironment");
                TAVCutImageSession.this.initRenderEnvironment(this.val$index);
                DurationUtil.end("initRenderEnvironment");
            }
            TAVCutImageSession.this.imageProcessThread.getHandler().post(new AnonymousClass1());
        }
    }

    private CGSize calculateRenderSize(MediaModel mediaModel, String str) {
        mediaModel.getMediaEffectModel();
        int width = mediaModel.getMediaResourceModel().getVideos().get(0).getResource().getWidth();
        int height = mediaModel.getMediaResourceModel().getVideos().get(0).getResource().getHeight();
        CropModel cropModel = mediaModel.getMediaEffectModel().getCropModel();
        if (cropModel != null && cropModel.getCropConfig() != null) {
            width = (int) (width * cropModel.getCropConfig().getWidth());
            height = (int) (height * cropModel.getCropConfig().getHeight());
        }
        return constrainRenderSize(width, height);
    }

    private VideoRenderChainConfigure getRenderChainConfig(int i3) {
        if (this.chainConfigs.get(i3) == null) {
            this.chainConfigs.put(i3, new VideoRenderChainConfigure(true));
        }
        return this.chainConfigs.get(i3);
    }

    private void initAEFilterManager() {
        AEFilterManager aEFilterManager = new AEFilterManager("defaultBeautyV6.json", false, false, null);
        this.aeFilterManager = aEFilterManager;
        aEFilterManager.defineFiltersAndOrder(300, 100);
        this.aeFilterManager.setFilterInSmooth(true);
    }

    private void initGLContext() {
        EglCore eglCore = new EglCore();
        this.eglCore = eglCore;
        this.eglContext = eglCore.getEGLContext();
        initAEFilterManager();
    }

    private void initMediaModel() {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.2
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                if (tAVCutImageSession.mediaModels == null) {
                    tAVCutImageSession.mediaModels = new ArrayList();
                    for (int i16 = 0; i16 < TAVCutImageSession.this.imagePaths.size(); i16++) {
                        String str = (String) TAVCutImageSession.this.imagePaths.get(i16);
                        MediaModel mediaModel = new MediaModel();
                        ArrayList arrayList = new ArrayList();
                        MediaClipModel mediaClipModel = new MediaClipModel();
                        VideoResourceModel videoResourceModel = new VideoResourceModel();
                        videoResourceModel.setPath(str);
                        videoResourceModel.setType(4);
                        videoResourceModel.setSourceTimeDurationUs(1000000L);
                        videoResourceModel.setSelectTimeDurationUs(1000000L);
                        Size imageSize = BitmapUtil.getImageSize(str);
                        SessionConfig sessionConfig = TAVCutImageSession.this.sessionConfig;
                        if (sessionConfig != null && sessionConfig.getMaxImageDecodeSize() != -1) {
                            Size constrainMaxSize = Util.constrainMaxSize(imageSize, TAVCutImageSession.this.sessionConfig.getMaxImageDecodeSize());
                            int width = imageSize.getWidth() / constrainMaxSize.getWidth();
                            if (imageSize.getWidth() % constrainMaxSize.getWidth() == 0) {
                                i3 = 0;
                            } else {
                                i3 = 1;
                            }
                            int i17 = width + i3;
                            if (i17 <= 0) {
                                i17 = 1;
                            }
                            imageSize.setWidth(imageSize.getWidth() / i17);
                            imageSize.setHeight(imageSize.getHeight() / i17);
                        }
                        SessionConfig sessionConfig2 = TAVCutImageSession.this.sessionConfig;
                        if (sessionConfig2 != null && sessionConfig2.getImageInitCropConfigs() != null) {
                            List<CropConfig> imageInitCropConfigs = TAVCutImageSession.this.sessionConfig.getImageInitCropConfigs();
                            CropModel cropModel = new CropModel();
                            cropModel.setCropConfig(imageInitCropConfigs.get(i16));
                            mediaModel.getMediaEffectModel().setCropModel(cropModel);
                        }
                        Logger.i(TAVCutImageSession.TAG, String.format("targetDecodeSize = %d * %d", Integer.valueOf(imageSize.getWidth()), Integer.valueOf(imageSize.getHeight())));
                        videoResourceModel.setWidth(imageSize.getWidth());
                        videoResourceModel.setHeight(imageSize.getHeight());
                        videoResourceModel.setRotate(0);
                        mediaClipModel.setResource(videoResourceModel);
                        VideoConfigurationModel videoConfigurationModel = new VideoConfigurationModel();
                        videoConfigurationModel.setRotate(0);
                        videoConfigurationModel.setContentMode(0);
                        mediaClipModel.setVideoConfigurationModel(videoConfigurationModel);
                        arrayList.add(mediaClipModel);
                        MediaResourceModel mediaResourceModel = mediaModel.getMediaResourceModel();
                        mediaResourceModel.setVideos(arrayList);
                        mediaModel.setMediaResourceModel(mediaResourceModel);
                        TAVCutImageSession.this.mediaModels.add(mediaModel);
                    }
                    TAVCutImageSession.this.recordInitMediaModelsMD5();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRenderEnvironment(int i3) {
        if (!ModelExtKt.isAutoTemplate(this.mediaModels.get(i3)) || !"1".equals(this.mediaModels.get(i3).getMediaEffectModel().getParam(Constants.FRAME_PARAMS_KEY_IS_ON))) {
            this.mediaModels.get(i3).getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_IS_ON, "0");
        }
        updateTemplateRenderChain(i3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshStickerContainerSize(ViewGroup viewGroup, int i3) {
        if (this.stickerControllers.get(i3) != null) {
            this.stickerControllers.get(i3).checkContainerSize(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWork(int i3, boolean z16) {
        if (this.renderChainManagers.get(i3) != null) {
            if (z16) {
                this.renderChainManagers.get(i3).releaseAndKeepStickerContext();
            } else {
                this.renderChainManagers.get(i3).release();
            }
            this.renderChainManagers.remove(i3);
        }
        if (this.imageRenderers.get(i3) != null) {
            this.imageRenderers.get(i3).release();
        }
        this.tavCompositions.remove(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveBitmapToCache(int i3, Bitmap bitmap, List<PointF> list) {
        if (BitmapUtil.isValidBitmap(bitmap)) {
            this.cacheBitmap.put(i3, bitmap.copy(Bitmap.Config.ARGB_4444, true));
            this.cachePointFList.put(i3, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStickerVisible(final int i3) {
        runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.29
            @Override // java.lang.Runnable
            public void run() {
                StickerController stickerController = TAVCutImageSession.this.stickerControllers.get(i3);
                if (stickerController instanceof PicStickerController) {
                    ((PicStickerController) stickerController).setStickersVisible();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTemplateRenderChain(final int i3, boolean z16) {
        int i16;
        releaseWork(i3, true);
        VideoRenderChainConfigure renderChainConfig = getRenderChainConfig(i3);
        if (renderChainConfig == null || !z16) {
            return;
        }
        StickerController stickerController = this.stickerControllers.get(i3);
        if (stickerController == null) {
            stickerController = createStickerController();
            this.stickerControllers.put(i3, stickerController);
        }
        MediaModel mediaModel = this.mediaModels.get(i3);
        final CGSize calculateRenderSize = calculateRenderSize(mediaModel, this.imagePaths.get(i3));
        renderChainConfig.setRenderSize(calculateRenderSize);
        renderChainConfig.setScreenSize(this.screenSize);
        if (ModelExtKt.isAutoTemplate(mediaModel)) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        renderChainConfig.setSceneType(i16);
        renderChainConfig.setImageMode(true);
        if (!this.addingMultiStickers) {
            renderChainConfig.setApplyType(101);
        } else {
            renderChainConfig.setApplyType(100);
        }
        this.addingMultiStickers = false;
        MediaBuilderFactory.mediaBuilderSync(mediaModel, this.context, stickerController, renderChainConfig, new MediaBuilderListener() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.21
            @Override // com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener
            public void buildCompleted(int i17, VideoRenderChainManager videoRenderChainManager, MediaBuilderOutput mediaBuilderOutput) {
                videoRenderChainManager.setFilterManager(TAVCutImageSession.this.aeFilterManager);
                videoRenderChainManager.setShouldRenderStickerAdapter(new VideoRenderChainManager.ShouldRenderStickerAdapter() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.21.1
                    @Override // com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.ShouldRenderStickerAdapter
                    public boolean shouldRenderSticker(TAVSticker tAVSticker, long j3) {
                        AnonymousClass21 anonymousClass21 = AnonymousClass21.this;
                        ArrayList<TAVSticker> arrayList = TAVCutImageSession.this.bulkStickers.get(i3);
                        if (arrayList != null) {
                            Iterator<TAVSticker> it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (it.next().getStickerId().equals(tAVSticker.getStickerId())) {
                                    return true;
                                }
                            }
                            return false;
                        }
                        return false;
                    }
                });
                videoRenderChainManager.setCachePicDelegate(TAVCutImageSession.this.cachePicDelegate);
                TAVCutImageSession.this.renderChainManagers.put(i3, videoRenderChainManager);
                TAVCutImageSession.this.tavCompositions.put(i3, videoRenderChainManager.getComposition());
                TAVCutImageSession.this.mediaBuilderOutputs.put(i3, mediaBuilderOutput);
                if (mediaBuilderOutput != null && mediaBuilderOutput.getAutomaticTemplate() != null && mediaBuilderOutput.getAutomaticTemplate().getRenderSize() != null) {
                    videoRenderChainManager.getComposition().setRenderSize(mediaBuilderOutput.getAutomaticTemplate().getRenderSize());
                } else {
                    videoRenderChainManager.getComposition().setRenderSize(calculateRenderSize);
                }
                videoRenderChainManager.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
                WSImageRender wSImageRender = new WSImageRender();
                CompositionUtils.removeTAVAspectEffect(videoRenderChainManager.getComposition());
                Iterator<List<? extends TAVTransitionableVideo>> it = videoRenderChainManager.getComposition().getVideoChannels().iterator();
                while (it.hasNext()) {
                    for (TAVTransitionableVideo tAVTransitionableVideo : it.next()) {
                        if (tAVTransitionableVideo instanceof TAVClip) {
                            TAVClip tAVClip = (TAVClip) tAVTransitionableVideo;
                            if (tAVClip.getResource() instanceof TAVImageTrackResource) {
                                ((TAVImageTrackResource) tAVClip.getResource()).setImageDecodeSize(calculateRenderSize);
                            }
                        }
                    }
                }
                wSImageRender.init(videoRenderChainManager.getComposition(), videoRenderChainManager.getComposition().getRenderSize());
                TAVStickerRenderContext pagChainRenderContext = videoRenderChainManager.getPagChainRenderContext();
                if (pagChainRenderContext instanceof TAVAutomaticTransRenderContext) {
                    wSImageRender.setTansRenderContext((TAVAutomaticTransRenderContext) pagChainRenderContext);
                }
                TAVCutImageSession.this.imageRenderers.put(i3, wSImageRender);
            }
        });
        runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.22
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession.this.stickerControllers.get(i3).resignCurrentSticker();
            }
        }, true);
    }

    public void activeBasePicCallback(int i3, boolean z16, MotionEvent motionEvent) {
        if (this.stickerControllers.get(i3) != null) {
            this.stickerControllers.get(i3).setNeedOperate(!z16, motionEvent);
        }
        if (this.renderChainManagers.get(i3) != null) {
            this.renderChainManagers.get(i3).setBasePicActive(z16);
        }
        if (z16) {
            render(i3);
        }
    }

    public void addFrame(final int i3, final String str, final String str2) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.17
            @Override // java.lang.Runnable
            public void run() {
                MediaModel mediaModel = TAVCutImageSession.this.mediaModels.get(i3);
                mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_IS_ON, "1");
                mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_COLOR, str2);
                mediaModel.getMediaEffectModel().getGestureModel().reset();
                WSTemplateManager.updateTemplate(mediaModel, 2, str, true, "ae_editor_board_template.json");
                TAVCutImageSession.this.updateTemplateRenderChain(i3, true);
                TAVCutImageSession.this.render(i3);
                TAVCutImageSession.this.setBasePicActive(false);
            }
        });
    }

    public void addFrameEmpty(int i3) {
        addFrame(i3, TAVCut.getPlaceHolderTemplatePath());
    }

    public void addSticker(int i3, @NonNull StickerModel stickerModel) {
        addSticker(i3, stickerModel, true);
    }

    public void applyCurrentSticker(final int i3) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.24
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession.this.runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass24 anonymousClass24 = AnonymousClass24.this;
                        TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                        tAVCutImageSession.applyCurrentSticker(tAVCutImageSession.stickerControllers.get(i3));
                    }
                }, true);
            }
        });
    }

    public void applyPreSeg(final int i3, final String str) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.37
            @Override // java.lang.Runnable
            public void run() {
                PreSegModel preSegModel = new PreSegModel();
                preSegModel.setIndex(i3);
                preSegModel.setSegMaterial(str);
                preSegModel.setOriginPic(TAVCutImageSession.this.getMediaModels().get(i3).getMediaResourceModel().getVideos().get(0).getResource().getPath());
                TAVCutImageSession.this.mediaModels.get(i3).getMediaEffectModel().setPreSegModel(preSegModel);
            }
        });
    }

    public void clearAEKitModel(final int i3) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.11
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.clearAEKitModel(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3));
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void clearAll(int i3) {
        this.mediaModels.get(i3).getMediaEffectModel().getStickerModelList().clear();
        this.stickerControllers.get(i3).removeAllStickers();
        MediaModel mediaModel = this.mediaModels.get(i3);
        mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_IS_ON, "0");
        mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_COLOR, null);
        mediaModel.getMediaEffectModel().getGestureModel().reset();
        WSTemplateManager.clearMediaTemplateModel(mediaModel);
        updateTemplateRenderChain(i3, true);
        clearAEKitModel(this.mediaModels.get(i3), this.renderChainManagers.get(i3));
    }

    public void clearAllWithoutUpdate(int i3) {
        this.mediaModels.get(i3).getMediaEffectModel().getStickerModelList().clear();
        if (this.stickerControllers.get(i3) != null) {
            this.stickerControllers.get(i3).removeAllStickers();
        }
        MediaModel mediaModel = this.mediaModels.get(i3);
        mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_IS_ON, "0");
        mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_COLOR, null);
        mediaModel.getMediaEffectModel().getGestureModel().reset();
        mediaModel.getMediaEffectModel().setPreSegModel(null);
        WSTemplateManager.clearMediaTemplateModel(mediaModel);
        this.mediaModels.get(i3).getMediaEffectModel().setAeKitModel(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession
    public StickerController createStickerController() {
        StickerEditViewIconConfig stickerEditViewIconConfig;
        Context context = this.context;
        SessionConfig sessionConfig = this.sessionConfig;
        if (sessionConfig != null) {
            stickerEditViewIconConfig = sessionConfig.getStickerEditViewIconConfig();
        } else {
            stickerEditViewIconConfig = null;
        }
        PicStickerController picStickerController = new PicStickerController(context, stickerEditViewIconConfig);
        picStickerController.setStickerOperationCallback(this);
        picStickerController.setStickerStateCallback(this);
        picStickerController.setStickerLyricCallback(this);
        picStickerController.setInterceptTouchDelegate(new TAVStickerContext.b() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.34
            @Override // com.tencent.tavsticker.core.TAVStickerContext.b
            public boolean checkInterceptArea(PointF pointF) {
                return ((TAVCutImageView) ((WeakReference) TAVCutImageSession.this.tavCutImageViews.get(TAVCutImageSession.this.currentIndex)).get()).checkInside(pointF, true);
            }

            @Override // com.tencent.tavsticker.core.TAVStickerContext.b
            public boolean shouldInterceptTouch() {
                return true;
            }

            @Override // com.tencent.tavsticker.core.TAVStickerContext.b
            public void touchInterceptArea(PointF pointF) {
                ((TAVCutImageView) ((WeakReference) TAVCutImageSession.this.tavCutImageViews.get(TAVCutImageSession.this.currentIndex)).get()).setBasePicActive(true);
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                if (tAVCutImageSession.renderChainManagers.get(tAVCutImageSession.currentIndex) != null) {
                    TAVCutImageSession tAVCutImageSession2 = TAVCutImageSession.this;
                    tAVCutImageSession2.renderChainManagers.get(tAVCutImageSession2.currentIndex).setBasePicActive(true);
                }
            }
        });
        return picStickerController;
    }

    public AEFilterManager getAeFilterManager() {
        return this.aeFilterManager;
    }

    public EGLContext getEglContext() {
        return this.eglContext;
    }

    public ImageExporter getExporter(ImageExportConfig imageExportConfig) {
        ImageExporter imageExporter = new ImageExporter();
        imageExporter.setContext(this.context);
        imageExporter.setImageExportConfig(imageExportConfig);
        imageExporter.setMediaModels(this.mediaModels);
        imageExporter.setMediaModelsMd5(this.mediaModelsMD5);
        return imageExporter;
    }

    public AssetImageGenerator.ImageGeneratorThread getImageProcessThread() {
        return this.imageProcessThread;
    }

    public SparseArray<WSImageRender> getImageRenderers() {
        return this.imageRenderers;
    }

    public List<MediaModel> getMediaModels() {
        return this.mediaModels;
    }

    public RenderContext getRenderContext() {
        return this.renderContext;
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.Session
    public int init(Context context) {
        this.runAsync = true;
        super.init(context);
        initMediaModel();
        return 0;
    }

    public void initSingleLightNode() {
        initGLContext();
        AssetImageGenerator.ImageGeneratorThread imageGeneratorThread = new AssetImageGenerator.ImageGeneratorThread("image_generator");
        this.imageProcessThread = imageGeneratorThread;
        imageGeneratorThread.start();
        this.imageProcessThread.initHandler();
        this.imageProcessThread.getHandler().post(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.1
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.renderContext = new RenderContext(1000, 2000, (Surface) null, tAVCutImageSession.eglContext);
            }
        });
    }

    public void loadFromCache(final int i3) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.35
            @Override // java.lang.Runnable
            public void run() {
                if (TAVCutImageSession.this.tavCutImageViews.get(i3) == null) {
                    return;
                }
                if (TAVCutImageSession.this.cacheBitmap.get(i3) == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile((String) TAVCutImageSession.this.imagePaths.get(i3), options);
                    int max = Math.max(options.outWidth, options.outHeight);
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inPreferredConfig = Bitmap.Config.ARGB_4444;
                    if (max > 1024) {
                        options2.inSampleSize = (max / 1024) + 1;
                    }
                    Bitmap decodeFile = BitmapFactory.decodeFile((String) TAVCutImageSession.this.imagePaths.get(i3), options2);
                    int imageRotation = BitmapUtil.getImageRotation((String) TAVCutImageSession.this.imagePaths.get(i3));
                    if (imageRotation != 0) {
                        Matrix matrix = new Matrix();
                        matrix.setRotate(imageRotation);
                        Bitmap retryMatrixBitmap = BitmapUtil.retryMatrixBitmap(decodeFile, decodeFile.getWidth(), decodeFile.getHeight(), matrix, false);
                        if (retryMatrixBitmap != decodeFile && retryMatrixBitmap != null) {
                            decodeFile = retryMatrixBitmap;
                        }
                    }
                    TAVCutImageSession.this.cacheBitmap.put(i3, decodeFile);
                    TAVCutImageSession.this.cachePointFList.put(i3, new ArrayList());
                }
                ((TAVCutImageView) ((WeakReference) TAVCutImageSession.this.tavCutImageViews.get(i3)).get()).setImageBitmap((Bitmap) TAVCutImageSession.this.cacheBitmap.get(i3), (List) TAVCutImageSession.this.cachePointFList.get(i3));
                TAVCutImageSession.this.resizeUI(i3);
            }
        });
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
    public void onDeleteButtonClick(String str) {
        super.onDeleteButtonClick(str);
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.callback.StickerStateCallback
    public void onStickerActive() {
        String extraStickerType;
        setBasePicActive(false);
        ArrayList<TAVSticker> arrayList = this.bulkStickers.get(this.currentIndex);
        StickerController stickerController = this.stickerControllers.get(this.currentIndex);
        if (stickerController != null) {
            if (arrayList != null) {
                Iterator<TAVSticker> it = arrayList.iterator();
                while (it.hasNext()) {
                    TAVSticker next = it.next();
                    if (next.getStickerId().equals(stickerController.getCurrentSticker().getStickerId())) {
                        arrayList.remove(next);
                        render(this.currentIndex);
                        return;
                    }
                }
            }
            if (stickerController.getCurrentSticker() != null && (extraStickerType = TAVStickerExKt.getExtraStickerType(stickerController.getCurrentSticker())) != null && extraStickerType.equals("blur")) {
                render(this.currentIndex);
            }
        }
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.callback.StickerStateCallback
    public void onStickerResign(TAVSticker tAVSticker) {
        super.onStickerResign(tAVSticker);
        if (WsStickerContext.isBlurSticker(tAVSticker)) {
            render(this.currentIndex);
        }
    }

    public void postRotation(final int i3, final float f16, final float f17, final float f18) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.33
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession.this.getMediaModels().get(i3).getMediaEffectModel().getGestureModel().postRotate(f18, f16, f17);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void postScale(final int i3, final float f16, final float f17, final float f18) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.32
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession.this.getMediaModels().get(i3).getMediaEffectModel().getGestureModel().postScale(f18, f16, f17);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void postTranslate(final int i3, final float f16, final float f17) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.31
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession.this.getMediaModels().get(i3).getMediaEffectModel().getGestureModel().postTranslate(f16, f17, ((TAVCutImageView) ((WeakReference) TAVCutImageSession.this.tavCutImageViews.get(i3)).get()).getBitmapBound());
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession, com.tencent.qcircle.tavcut.session.Session
    public void release() {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.30
            @Override // java.lang.Runnable
            @RequiresApi(api = 19)
            public void run() {
                DurationUtil.start("TAVCutImageSession release");
                for (int i3 = 0; i3 < TAVCutImageSession.this.imageRenderers.size(); i3++) {
                    ((WSImageRender) TAVCutImageSession.this.imageRenderers.get(TAVCutImageSession.this.imageRenderers.keyAt(i3))).release();
                }
                if (TAVCutImageSession.this.renderContext != null) {
                    TAVCutImageSession.this.renderContext.release();
                    TAVCutImageSession.this.renderContext = null;
                }
                if (TAVCutImageSession.this.aeFilterManager != null) {
                    TAVCutImageSession.this.aeFilterManager.setExternalRenderCallback(null);
                    TAVCutImageSession.this.aeFilterManager.destroy();
                    TAVCutImageSession.this.aeFilterManager = null;
                }
                if (TAVCutImageSession.this.eglCore != null) {
                    TAVCutImageSession.this.eglCore.release();
                    TAVCutImageSession.this.eglCore = null;
                    TAVCutImageSession.this.eglContext = null;
                }
                TAVCutImageSession.this.imageRenderers.clear();
                TAVCutImageSession.this.tavCompositions.clear();
                TAVCutImageSession.this.tavCutImageViews.clear();
                TAVCutImageSession.this.chainConfigs.clear();
                TAVCutImageSession.this.mediaBuilderOutputs.clear();
                TAVCutImageSession.this.imageProcessThread.quit();
                TAVCutImageSession.this.cacheBitmap.clear();
                TAVCutImageSession.this.cachePointFList.clear();
                WSSegmentManager.release();
                DurationUtil.end("TAVCutImageSession release");
            }
        });
        super.release();
    }

    public void releaseTAVCutImageView(final int i3) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.4
            @Override // java.lang.Runnable
            public void run() {
                DurationUtil.start("releaseTAVCutImageView");
                TAVCutImageSession.this.tavCutImageViews.remove(i3);
                if (TAVCutImageSession.this.stickerControllers.get(i3) != null) {
                    TAVCutImageSession.this.stickerControllers.get(i3).destroy();
                    TAVCutImageSession.this.stickerControllers.remove(i3);
                }
                TAVCutImageSession.this.releaseWork(i3, false);
                DurationUtil.end("releaseTAVCutImageView");
            }
        });
    }

    public void releaseTAVCutWithoutView(final int i3) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.5
            @Override // java.lang.Runnable
            public void run() {
                if (TAVCutImageSession.this.stickerControllers.get(i3) != null) {
                    TAVCutImageSession.this.stickerControllers.get(i3).destroy();
                    TAVCutImageSession.this.stickerControllers.remove(i3);
                }
                TAVCutImageSession.this.releaseWork(i3, false);
            }
        });
    }

    public void removeAllStickers(final int i3) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.25
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession.this.mediaModels.get(i3).getMediaEffectModel().getStickerModelList().clear();
                TAVCutImageSession.this.stickerControllers.get(i3).removeAllStickers(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.25.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass25 anonymousClass25 = AnonymousClass25.this;
                        TAVCutImageSession.this.render(i3);
                    }
                });
            }
        });
    }

    public void removeAllViews() {
        this.stickerControllers.get(this.currentIndex).getStickerContext().removeAllViews();
    }

    public void removeFrame(final int i3) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.18
            @Override // java.lang.Runnable
            public void run() {
                MediaModel mediaModel = TAVCutImageSession.this.mediaModels.get(i3);
                mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_IS_ON, "0");
                mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_COLOR, null);
                mediaModel.getMediaEffectModel().getGestureModel().reset();
                WSTemplateManager.clearMediaTemplateModel(mediaModel);
                TAVCutImageSession.this.updateTemplateRenderChain(i3, true);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void render(int i3) {
        VideoRenderChainManager videoRenderChainManager = this.renderChainManagers.get(this.currentIndex);
        ArrayList<TAVSticker> arrayList = this.bulkStickers.get(this.currentIndex);
        if (videoRenderChainManager != null && arrayList != null && !arrayList.isEmpty()) {
            videoRenderChainManager.setNeedRenderOverlayStickerMergedEffectNode(true);
        }
        render(i3, null);
    }

    public void resetAEKitModel(final int i3, final float f16, final String str, final float f17, final Map<String, String> map, final String str2) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.9
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.resetAEKitModel(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), f16, str, f17, map, str2);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void resetAEKitModelForAI(final int i3, @Nullable final String str, final float f16, final HashMap<String, String> hashMap, final int i16, final float f17) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.12
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.resetAEKitModelForAI(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), str, f16, hashMap, i16, f17, TAVCutImageSession.this.mediaModels.get(i3).getMediaResourceModel().getVideos().get(0).getResource().getSelectTimeDuration());
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void resetAEKitNodeForAIWithoutRender(final int i3, @Nullable final String str, final float f16, final HashMap<String, String> hashMap, final int i16, final float f17) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.13
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.resetAEKitModelForAI(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), str, f16, hashMap, i16, f17, TAVCutImageSession.this.mediaModels.get(i3).getMediaResourceModel().getVideos().get(0).getResource().getSelectTimeDuration());
            }
        });
    }

    public void resetAllAeKitModelWithOutRender(final float f16, final String str, final float f17, final Map<String, String> map, final String str2) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.8
            @Override // java.lang.Runnable
            public void run() {
                List<MediaModel> list = TAVCutImageSession.this.mediaModels;
                if (list != null && list.size() > 0) {
                    for (int i3 = 0; i3 < TAVCutImageSession.this.mediaModels.size(); i3++) {
                        TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                        tAVCutImageSession.resetAEKitModel(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), f16, str, f17, map, str2);
                    }
                }
            }
        });
    }

    public void resizeUI(final int i3) {
        runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.28
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageView tAVCutImageView;
                Bitmap bitmap;
                WeakReference weakReference = (WeakReference) TAVCutImageSession.this.tavCutImageViews.get(i3);
                if (weakReference != null && (tAVCutImageView = (TAVCutImageView) weakReference.get()) != null && (bitmap = (Bitmap) TAVCutImageSession.this.cacheBitmap.get(i3)) != null) {
                    ViewParent parent = tAVCutImageView.getParent();
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        int width = (viewGroup.getWidth() - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight();
                        int height = (viewGroup.getHeight() - viewGroup.getPaddingTop()) - viewGroup.getPaddingBottom();
                        int width2 = bitmap.getWidth();
                        int height2 = bitmap.getHeight();
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tAVCutImageView.getInnerStickerContainer().getLayoutParams();
                        float f16 = width2;
                        float f17 = height2;
                        float f18 = width * 1.0f;
                        float f19 = height;
                        if ((f16 * 1.0f) / f17 > f18 / f19) {
                            layoutParams.width = width;
                            int i16 = (int) ((f18 * f17) / f16);
                            layoutParams.height = i16;
                            layoutParams.topMargin = (height - i16) / 2;
                            layoutParams.leftMargin = 0;
                        } else {
                            layoutParams.height = height;
                            int i17 = (int) (((f19 * 1.0f) * f16) / f17);
                            layoutParams.width = i17;
                            layoutParams.leftMargin = (width - i17) / 2;
                            layoutParams.topMargin = 0;
                        }
                        tAVCutImageView.getInnerStickerContainer().setLayoutParams(layoutParams);
                        TAVCutImageSession.this.refreshStickerContainerSize(tAVCutImageView.getInnerStickerContainer(), i3);
                    }
                }
            }
        });
    }

    public void setAddingMultiStickers(int i3, boolean z16) {
        this.addingMultiStickers = true;
        StickerController stickerController = this.stickerControllers.get(i3);
        if (stickerController instanceof PicStickerController) {
            ((PicStickerController) stickerController).setAddingMultiSticker(z16);
        }
    }

    public void setBasePicActive(boolean z16) {
        this.tavCutImageViews.get(this.currentIndex).get().setBasePicActive(z16);
        activeBasePicCallback(this.currentIndex, z16, null);
    }

    public void setCachePicDelegate(PreSegNode.PicSaveDelegate picSaveDelegate) {
        this.cachePicDelegate = picSaveDelegate;
    }

    public void setCrop(final int i3, final CropConfig cropConfig) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.23
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.setCrop(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), cropConfig);
                TAVCutImageSession.this.mediaModels.get(i3).getMediaEffectModel().getGestureModel().reset();
                TAVCutImageSession.this.releaseWork(i3, true);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void setEffectStrength(final int i3, final float f16) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.14
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.setEffectStrength(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), f16);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void setImageContainerSize(CGSize cGSize) {
        this.screenSize = cGSize;
    }

    public void setImagePaths(final List<String> list) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.6
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession.this.imagePaths = list;
            }
        });
    }

    @Deprecated
    public void setMaterial(final int i3, @Nullable final String str) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.16
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.setMaterial(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), str);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void setMediaModels(List<MediaModel> list) {
        this.mediaModels = list;
    }

    public void setOverlayImage(final int i3, @Nullable final String str) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.15
            @Override // java.lang.Runnable
            public void run() {
                MediaModel mediaModel = TAVCutImageSession.this.mediaModels.get(i3);
                AEKitModel aeKitModel = mediaModel.getMediaEffectModel().getAeKitModel();
                if (aeKitModel == null) {
                    aeKitModel = new AEKitModel(1);
                }
                aeKitModel.setOverlayImagePath(str);
                mediaModel.getMediaEffectModel().setAeKitModel(aeKitModel);
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.updateRenderChain(tAVCutImageSession.renderChainManagers.get(i3), mediaModel.getMediaEffectModel(), false);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void setPreSeg(final int i3, final String str) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.36
            @Override // java.lang.Runnable
            public void run() {
                PreSegModel preSegModel = new PreSegModel();
                preSegModel.setIndex(i3);
                preSegModel.setSegMaterial(str);
                preSegModel.setOriginPic(TAVCutImageSession.this.getMediaModels().get(i3).getMediaResourceModel().getVideos().get(0).getResource().getPath());
                TAVCutImageSession.this.mediaModels.get(i3).getMediaEffectModel().setPreSegModel(preSegModel);
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.updateRenderChain(tAVCutImageSession.renderChainManagers.get(i3), TAVCutImageSession.this.mediaModels.get(i3).getMediaEffectModel(), false);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void setTAVCutImageView(final int i3, final TAVCutImageView tAVCutImageView) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.3
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession.this.tavCutImageViews.put(i3, new WeakReference(tAVCutImageView));
                if (TAVCutImageSession.this.stickerControllers.get(i3) == null) {
                    StickerController createStickerController = TAVCutImageSession.this.createStickerController();
                    TAVCutImageSession.this.stickerControllers.put(i3, createStickerController);
                    createStickerController.createStickerContext(true);
                    TAVCutImageSession.this.runOnMainThread(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            TAVCutImageSession.this.stickerControllers.get(i3).setStickerContainer(tAVCutImageView.getInnerStickerContainer());
                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                            StickerController stickerController = TAVCutImageSession.this.stickerControllers.get(i3);
                            AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                            stickerController.restoreSticker(TAVCutImageSession.this.mediaModels.get(i3).getMediaEffectModel().getStickerModelList());
                        }
                    });
                }
            }
        });
    }

    public void toggleAEKit(final int i3, final boolean z16) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.7
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.toggleAEKit(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), z16);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void updateAndRenderTemplate(int i3) {
        updateAndRenderTemplate(i3, false, null);
    }

    public void updateEmptyFrame(int i3) {
        updateTemplateFrame(i3, TAVCut.getPlaceHolderTemplatePath());
    }

    public void updateFrameColor(final int i3, final int i16) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.19
            @Override // java.lang.Runnable
            public void run() {
                ModelExtKt.updateFrameColor(TAVCutImageSession.this.mediaModels.get(i3), i16);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void updateFrameFillMode(final int i3, final int i16) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.20
            @Override // java.lang.Runnable
            public void run() {
                MediaModel mediaModel = TAVCutImageSession.this.mediaModels.get(i3);
                mediaModel.getMediaEffectModel().getGestureModel().reset();
                ModelExtKt.updateFrameFillMode(mediaModel, i16);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void updateTemplateAEKitModel(int i3, float f16, String str, float f17, Map<String, String> map, String str2) {
        AEKitModel aEKitModel = new AEKitModel(1);
        aEKitModel.setEffectStrength(f16);
        aEKitModel.setLutPath(str);
        aEKitModel.setGlowAlpha(f17);
        aEKitModel.setAdjustParams(map);
        aEKitModel.setMaterial(str2);
        this.mediaModels.get(i3).getMediaEffectModel().setAeKitModel(aEKitModel);
    }

    public void updateTemplateCrop(int i3, CropConfig cropConfig) {
        setCrop(this.mediaModels.get(i3), this.renderChainManagers.get(i3), cropConfig);
        this.mediaModels.get(i3).getMediaEffectModel().getGestureModel().reset();
    }

    public void updateTemplateFrame(int i3, String str, String str2) {
        MediaModel mediaModel = this.mediaModels.get(i3);
        mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_IS_ON, "1");
        mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_COLOR, str2);
        mediaModel.getMediaEffectModel().getGestureModel().reset();
        WSTemplateManager.updateTemplate(mediaModel, 2, str, true, "ae_editor_board_template.json");
        setBasePicActive(false);
    }

    @Override // com.tencent.qcircle.tavcut.session.TAVCutSession
    public void updateTextSticker(TextEditorData textEditorData) {
        super.updateTextSticker(textEditorData);
        render(this.currentIndex);
    }

    public void addFrame(int i3, String str) {
        addFrame(i3, str, null);
    }

    public void addSticker(int i3, @NonNull StickerModel stickerModel, boolean z16) {
        StickerController stickerController = this.stickerControllers.get(i3);
        if (stickerController == null) {
            stickerController = createStickerController();
            this.stickerControllers.put(i3, stickerController);
        }
        super.addSticker(stickerController, stickerModel, z16);
        setBasePicActive(false);
    }

    public void resetAEKitModel(final int i3, @Nullable final String str, final float f16) {
        runTask(new Runnable() { // from class: com.tencent.qcircle.tavcut.session.TAVCutImageSession.10
            @Override // java.lang.Runnable
            public void run() {
                TAVCutImageSession tAVCutImageSession = TAVCutImageSession.this;
                tAVCutImageSession.resetAEKitModel(tAVCutImageSession.mediaModels.get(i3), TAVCutImageSession.this.renderChainManagers.get(i3), str, f16);
                TAVCutImageSession.this.render(i3);
            }
        });
    }

    public void updateAndRenderTemplate(int i3, boolean z16, OnRenderFinishListener onRenderFinishListener) {
        if (!z16) {
            setAddingMultiStickers(i3, true);
        }
        updateTemplateRenderChain(i3, true);
        if (!z16) {
            setAddingMultiStickers(i3, true);
        }
        VideoRenderChainManager videoRenderChainManager = this.renderChainManagers.get(i3);
        if (videoRenderChainManager != null) {
            videoRenderChainManager.setNeedRenderOverlayStickerMergedEffectNode(true);
        }
        runTask(new AnonymousClass26(i3, onRenderFinishListener));
    }

    public void render(int i3, OnRenderFinishListener onRenderFinishListener) {
        runTask(new AnonymousClass27(i3, onRenderFinishListener));
    }

    public void updateTemplateFrame(int i3, String str) {
        updateTemplateFrame(i3, str, null);
    }
}
