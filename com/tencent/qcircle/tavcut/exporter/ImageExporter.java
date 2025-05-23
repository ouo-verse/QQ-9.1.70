package com.tencent.qcircle.tavcut.exporter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.media.ExifInterface;
import android.opengl.EGLContext;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.constants.Constants;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.CompositionUtils;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ImageExporter {
    private final String TAG = ImageExporter.class.getSimpleName();
    private boolean cancel = false;
    private Context context;
    private ImageExportConfig imageExportConfig;
    private CountDownLatch mCountDownLatch;
    private List<MediaModel> mediaModels;
    private List<String> mediaModelsMD5;

    /* compiled from: P */
    /* renamed from: com.tencent.qcircle.tavcut.exporter.ImageExporter$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ AEFilterManager val$aeFilterManager;
        final /* synthetic */ ImageExportCallback val$callback;
        final /* synthetic */ EGLContext val$eglContext;
        final /* synthetic */ ExecutorService val$executorService;
        final /* synthetic */ AssetImageGenerator.ImageGeneratorThread val$imageProcessThread;
        final /* synthetic */ RenderContext val$renderContext;

        AnonymousClass1(ImageExportCallback imageExportCallback, ExecutorService executorService, AEFilterManager aEFilterManager, EGLContext eGLContext, AssetImageGenerator.ImageGeneratorThread imageGeneratorThread, RenderContext renderContext) {
            this.val$callback = imageExportCallback;
            this.val$executorService = executorService;
            this.val$aeFilterManager = aEFilterManager;
            this.val$eglContext = eGLContext;
            this.val$imageProcessThread = imageGeneratorThread;
            this.val$renderContext = renderContext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r14v3 */
        @Override // java.lang.Runnable
        public void run() {
            int i3;
            LinkedBlockingDeque linkedBlockingDeque;
            int i16;
            AtomicInteger atomicInteger;
            AnonymousClass1 anonymousClass1;
            int i17;
            AnonymousClass1 anonymousClass12 = this;
            ?? r142 = 0;
            AtomicInteger atomicInteger2 = new AtomicInteger(0);
            LinkedBlockingDeque linkedBlockingDeque2 = new LinkedBlockingDeque();
            final long currentTimeMillis = System.currentTimeMillis();
            int i18 = 0;
            while (i18 < ImageExporter.this.mediaModels.size()) {
                if (ImageExporter.this.cancel) {
                    ImageExportCallback imageExportCallback = anonymousClass12.val$callback;
                    if (imageExportCallback != null) {
                        imageExportCallback.onCancelled();
                    }
                    anonymousClass12.val$executorService.shutdown();
                    return;
                }
                final MediaModel mediaModel = (MediaModel) new Gson().fromJson(((MediaModel) ImageExporter.this.mediaModels.get(i18)).toString(), MediaModel.class);
                if (((String) ImageExporter.this.mediaModelsMD5.get(i18)).equals(Util.md5(((MediaModel) ImageExporter.this.mediaModels.get(i18)).toString()))) {
                    if (anonymousClass12.val$callback != null) {
                        String path = mediaModel.getMediaResourceModel().getVideos().get(r142).getResource().getPath();
                        if (ImageExporter.this.isNeedCrop(path)) {
                            path = ImageExporter.this.cropSourcePath(linkedBlockingDeque2, i18, mediaModel, path);
                        }
                        anonymousClass12.val$callback.onImageExport(path);
                    }
                    if (atomicInteger2.incrementAndGet() == ImageExporter.this.mediaModels.size()) {
                        Logger.d(ImageExporter.this.TAG, "cost time: =========== " + (System.currentTimeMillis() - currentTimeMillis));
                        if (anonymousClass12.val$callback != null) {
                            if (linkedBlockingDeque2.isEmpty()) {
                                anonymousClass12.val$callback.onExportComplete();
                            } else {
                                anonymousClass12.val$callback.onFailed(linkedBlockingDeque2);
                            }
                        }
                        anonymousClass12.val$executorService.shutdown();
                        return;
                    }
                    i16 = i18;
                    anonymousClass1 = anonymousClass12;
                    atomicInteger = atomicInteger2;
                    linkedBlockingDeque = linkedBlockingDeque2;
                } else {
                    VideoRenderChainConfigure videoRenderChainConfigure = new VideoRenderChainConfigure(true);
                    MediaTemplateModel mediaTemplateModel = mediaModel.getMediaTemplateModel();
                    if (!mediaTemplateModel.isAutoTemplateEmpty()) {
                        videoRenderChainConfigure.setSceneType(2);
                        mediaModel.getMediaEffectModel().putParam(Constants.FRAME_PARAMS_KEY_IS_ON, "1");
                    } else if (!mediaTemplateModel.isMovieTemplateEmpty()) {
                        videoRenderChainConfigure.setSceneType(1);
                    } else {
                        videoRenderChainConfigure.setSceneType(r142);
                    }
                    videoRenderChainConfigure.setImageMode(true);
                    final String path2 = mediaModel.getMediaResourceModel().getVideos().get(r142).getResource().getPath();
                    Size imageSize = BitmapUtil.getImageSize(path2, r142);
                    if (ImageExporter.this.imageExportConfig != null) {
                        i3 = ImageExporter.this.imageExportConfig.getMaxExportSize();
                    } else {
                        i3 = -1;
                    }
                    if (i3 != -1) {
                        Size constrainMaxSize = Util.constrainMaxSize(imageSize, i3);
                        int width = imageSize.getWidth() / constrainMaxSize.getWidth();
                        if (imageSize.getWidth() % constrainMaxSize.getWidth() == 0) {
                            i17 = r142;
                        } else {
                            i17 = 1;
                        }
                        int i19 = width + i17;
                        if (i19 <= 0) {
                            i19 = 1;
                        }
                        imageSize.setWidth(imageSize.getWidth() / i19);
                        imageSize.setHeight(imageSize.getHeight() / i19);
                    }
                    mediaModel.getMediaResourceModel().getVideos().get(r142).getResource().setWidth(imageSize.getWidth());
                    mediaModel.getMediaResourceModel().getVideos().get(r142).getResource().setHeight(imageSize.getHeight());
                    final CGSize calculateRenderSize = ImageExporter.this.calculateRenderSize(mediaModel, path2);
                    videoRenderChainConfigure.setRenderSize(calculateRenderSize);
                    videoRenderChainConfigure.setScreenSize(ImageExporter.this.imageExportConfig.getScreenSize());
                    final String str = ImageExporter.this.imageExportConfig.getOutputPaths().get(i18);
                    final StickerController stickerController = new StickerController(ImageExporter.this.context);
                    ImageExporter.this.mCountDownLatch = new CountDownLatch(1);
                    final LinkedBlockingDeque linkedBlockingDeque3 = linkedBlockingDeque2;
                    linkedBlockingDeque = linkedBlockingDeque2;
                    final AtomicInteger atomicInteger3 = atomicInteger2;
                    i16 = i18;
                    atomicInteger = atomicInteger2;
                    MediaBuilderFactory.mediaBuilderSync(mediaModel, ImageExporter.this.context, stickerController, videoRenderChainConfigure, new MediaBuilderListener() { // from class: com.tencent.qcircle.tavcut.exporter.ImageExporter.1.1
                        @Override // com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener
                        public void buildCompleted(int i26, final VideoRenderChainManager videoRenderChainManager, MediaBuilderOutput mediaBuilderOutput) {
                            stickerController.restoreSticker(mediaModel.getMediaEffectModel().getStickerModelList());
                            if (mediaBuilderOutput != null && mediaBuilderOutput.getAutomaticTemplate() != null && mediaBuilderOutput.getAutomaticTemplate().getRenderSize() != null) {
                                videoRenderChainManager.getComposition().setRenderSize(mediaBuilderOutput.getAutomaticTemplate().getRenderSize());
                            } else {
                                videoRenderChainManager.getComposition().setRenderSize(calculateRenderSize);
                            }
                            videoRenderChainManager.setFilterManager(AnonymousClass1.this.val$aeFilterManager);
                            videoRenderChainManager.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
                            CompositionUtils.removeTAVAspectEffect(videoRenderChainManager.getComposition());
                            final WSImageRender wSImageRender = new WSImageRender();
                            DurationUtil.start("imageRender.init");
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
                            DurationUtil.end("imageRender.init");
                            DurationUtil.start("imageRender.render");
                            WSImageRender.ImageRenderCallback imageRenderCallback = new WSImageRender.ImageRenderCallback() { // from class: com.tencent.qcircle.tavcut.exporter.ImageExporter.1.1.1
                                /* JADX WARN: Removed duplicated region for block: B:11:0x0109  */
                                /* JADX WARN: Removed duplicated region for block: B:6:0x00e4  */
                                @Override // com.tencent.qcircle.weseevideo.composition.image.WSImageRender.ImageRenderCallback
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public void onCompletion(@Nullable Bitmap bitmap, @Nullable List<PointF> list) {
                                    int i27;
                                    boolean z16;
                                    DurationUtil.start("imageRender.inRender");
                                    if (!BitmapUtil.isValidBitmap(bitmap)) {
                                        linkedBlockingDeque3.add("image render result is an invalid bitmap! output path = " + str);
                                    } else {
                                        if (ImageExporter.this.imageExportConfig != null) {
                                            i27 = ImageExporter.this.imageExportConfig.getMaxExportSize();
                                        } else {
                                            i27 = -1;
                                        }
                                        if (i27 != -1) {
                                            DurationUtil.start("scaleBitmap");
                                            Bitmap scaleBitmap = BitmapUtil.scaleBitmap(bitmap, i27);
                                            DurationUtil.end("scaleBitmap");
                                            if (!BitmapUtil.isValidBitmap(scaleBitmap)) {
                                                linkedBlockingDeque3.add("scale bitmap failed! output path = " + str);
                                            } else {
                                                if (scaleBitmap != bitmap) {
                                                    bitmap = scaleBitmap;
                                                }
                                                try {
                                                    DurationUtil.start("saveBitmap");
                                                } catch (IOException e16) {
                                                    Logger.e(e16);
                                                }
                                                if (!BitmapUtil.saveBitmap(bitmap, ImageExporter.this.imageExportConfig.getFormat(), ImageExporter.this.imageExportConfig.getQuality(), str, new ExifInterface(path2))) {
                                                    linkedBlockingDeque3.add("image save failed! output path = " + str);
                                                    bitmap.recycle();
                                                } else {
                                                    DurationUtil.end("saveBitmap");
                                                    bitmap.recycle();
                                                    z16 = true;
                                                    if (z16) {
                                                        C92931 c92931 = C92931.this;
                                                        ImageExportCallback imageExportCallback2 = AnonymousClass1.this.val$callback;
                                                        if (imageExportCallback2 != null) {
                                                            imageExportCallback2.onImageExport(str);
                                                        }
                                                    }
                                                    if (atomicInteger3.incrementAndGet() == ImageExporter.this.mediaModels.size()) {
                                                        Logger.d(ImageExporter.this.TAG, "cost time: =========== " + (System.currentTimeMillis() - currentTimeMillis));
                                                        C92931 c929312 = C92931.this;
                                                        if (AnonymousClass1.this.val$callback != null) {
                                                            if (linkedBlockingDeque3.isEmpty()) {
                                                                AnonymousClass1.this.val$callback.onExportComplete();
                                                            } else {
                                                                C92931 c929313 = C92931.this;
                                                                AnonymousClass1.this.val$callback.onFailed(linkedBlockingDeque3);
                                                            }
                                                        }
                                                        AnonymousClass1.this.val$executorService.shutdown();
                                                    }
                                                    videoRenderChainManager.release();
                                                    stickerController.destroy();
                                                    wSImageRender.release();
                                                    ImageExporter.this.mCountDownLatch.countDown();
                                                    DurationUtil.end("imageRender.inRender");
                                                }
                                            }
                                        }
                                    }
                                    z16 = false;
                                    if (z16) {
                                    }
                                    if (atomicInteger3.incrementAndGet() == ImageExporter.this.mediaModels.size()) {
                                    }
                                    videoRenderChainManager.release();
                                    stickerController.destroy();
                                    wSImageRender.release();
                                    ImageExporter.this.mCountDownLatch.countDown();
                                    DurationUtil.end("imageRender.inRender");
                                }
                            };
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            wSImageRender.render(imageRenderCallback, anonymousClass13.val$eglContext, anonymousClass13.val$imageProcessThread, anonymousClass13.val$renderContext);
                            DurationUtil.end("imageRender.render");
                        }
                    });
                    anonymousClass1 = this;
                    try {
                        ImageExporter.this.mCountDownLatch.await();
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                i18 = i16 + 1;
                anonymousClass12 = anonymousClass1;
                linkedBlockingDeque2 = linkedBlockingDeque;
                atomicInteger2 = atomicInteger;
                r142 = 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ImageExportCallback {
        void onCancelled();

        void onExportComplete();

        void onFailed(Collection<String> collection);

        void onImageExport(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CGSize calculateRenderSize(MediaModel mediaModel, String str) {
        mediaModel.getMediaEffectModel();
        int width = mediaModel.getMediaResourceModel().getVideos().get(0).getResource().getWidth();
        int height = mediaModel.getMediaResourceModel().getVideos().get(0).getResource().getHeight();
        int imageRotation = BitmapUtil.getImageRotation(str);
        if (imageRotation == 90 || imageRotation == 270) {
            height = width;
            width = height;
        }
        CropModel cropModel = mediaModel.getMediaEffectModel().getCropModel();
        if (cropModel != null && cropModel.getCropConfig() != null) {
            width = (int) (width * cropModel.getCropConfig().getWidth());
            height = (int) (height * cropModel.getCropConfig().getHeight());
        }
        return constrainRenderSize(width, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cropSourcePath(LinkedBlockingDeque<String> linkedBlockingDeque, int i3, MediaModel mediaModel, String str) {
        String str2 = this.imageExportConfig.getOutputPaths().get(i3);
        Bitmap decodeBitmapWithCrop = BitmapUtil.decodeBitmapWithCrop(str, mediaModel.getMediaEffectModel().getCropModel().getCropConfig());
        try {
            if (!BitmapUtil.saveBitmap(decodeBitmapWithCrop, this.imageExportConfig.getFormat(), this.imageExportConfig.getQuality(), str2, new ExifInterface(str))) {
                linkedBlockingDeque.add("image save failed! output path = " + str2);
            }
        } catch (IOException e16) {
            Logger.e(e16);
        }
        if (decodeBitmapWithCrop != null) {
            decodeBitmapWithCrop.recycle();
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedCrop(String str) {
        int imageRotation = BitmapUtil.getImageRotation(str);
        if (imageRotation != 90 && imageRotation != 270) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFileWithBuffer(str, options);
            float f16 = (float) ((options.outWidth * 1.0d) / options.outHeight);
            if (f16 < 1.3333334f && f16 > 0.5625f) {
                return false;
            }
        }
        return true;
    }

    public void cancel() {
        this.cancel = true;
    }

    protected CGSize constrainRenderSize(int i3, int i16) {
        int i17;
        int i18;
        CGSize cGSize = new CGSize(i3, i16);
        ImageExportConfig imageExportConfig = this.imageExportConfig;
        if (imageExportConfig != null) {
            i17 = imageExportConfig.getMaxIntermediateRenderSize();
        } else {
            i17 = -1;
        }
        if (i17 != -1) {
            Size constrainMaxSize = Util.constrainMaxSize(new Size(i3, i16), i17);
            cGSize.width = constrainMaxSize.getWidth();
            cGSize.height = constrainMaxSize.getHeight();
        }
        ImageExportConfig imageExportConfig2 = this.imageExportConfig;
        if (imageExportConfig2 != null) {
            i18 = imageExportConfig2.getMinIntermediateRenderSize();
        } else {
            i18 = -1;
        }
        if (i18 != -1) {
            Size constrainMinSize = Util.constrainMinSize(new Size((int) cGSize.width, (int) cGSize.height), i18);
            cGSize.width = constrainMinSize.getWidth();
            cGSize.height = constrainMinSize.getHeight();
        }
        Logger.i(this.TAG, String.format("targetRenderSize = %d * %d", Integer.valueOf((int) cGSize.width), Integer.valueOf((int) cGSize.height)));
        return cGSize;
    }

    public void export(ImageExportCallback imageExportCallback, EGLContext eGLContext, AssetImageGenerator.ImageGeneratorThread imageGeneratorThread, RenderContext renderContext, AEFilterManager aEFilterManager) {
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        newSingleThreadExecutor.submit(new AnonymousClass1(imageExportCallback, newSingleThreadExecutor, aEFilterManager, eGLContext, imageGeneratorThread, renderContext));
    }

    public List<MediaModel> getMediaModels() {
        return this.mediaModels;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setImageExportConfig(ImageExportConfig imageExportConfig) {
        this.imageExportConfig = imageExportConfig;
    }

    public void setMediaModels(List<MediaModel> list) {
        this.mediaModels = list;
    }

    public void setMediaModelsMd5(List<String> list) {
        this.mediaModelsMD5 = list;
    }
}
