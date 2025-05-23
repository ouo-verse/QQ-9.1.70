package com.tencent.qcircle.weseevideo.composition.builder;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AutoTemplateMediaBuilder;
import com.tencent.qcircle.weseevideo.model.template.light.LightTemplateMediaBuilder;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieTemplateMediaBuilder;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MediaBuilderFactory {
    public static final int RHYTHM_SINGLE_IMAGE = 10000;
    public static final float TIME_FLOAT_MS = 1000.0f;
    public static final float TIME_FLOAT_US = 1000000.0f;
    public static final int TIME_INT_MS = 1000;
    public static final int TIME_MAX_MS = 60000;
    public static final int TIME_MIN_MS = 2000;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class MediaBuilderErrorCode {
        public static final int AUTO_COMPOSITION_BUILD_FAILED = -201;
        public static final int AUTO_TEMPLATE_BUILD_FAILED = -200;
        public static final int BUILD_SUCCESS = 0;
        public static final int COMPOSITION_BUILD_FAILED = -101;
        public static final int MOVIE_COMPOSITION_BUILD_FAILED = -301;
        public static final int MOVIE_LOAD_DATA_FAILED = -302;
        public static final int MOVIE_MODEL_EMPTY = -303;
        public static final int MOVIE_TEMPLATE_BUILD_FAILED = -300;
        public static final int RESOURCE_EMPTY = -100;
    }

    public static void mediaBuilderSync(@NonNull MediaModel mediaModel, Context context, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, @NonNull VideoRenderChainConfigure videoRenderChainConfigure, @NonNull MediaBuilderListener mediaBuilderListener, boolean z16) {
        int sceneType = videoRenderChainConfigure.getSceneType();
        if (sceneType == 1) {
            MovieTemplateMediaBuilder.build(mediaModel, iStickerContextInterface, mediaBuilderListener, videoRenderChainConfigure);
            return;
        }
        if (sceneType == 2) {
            AutoTemplateMediaBuilder.build(mediaModel, context, iStickerContextInterface, videoRenderChainConfigure, mediaBuilderListener);
        } else if (sceneType != 4) {
            MediaBuilder.build(mediaModel, iStickerContextInterface, mediaBuilderListener, videoRenderChainConfigure);
        } else {
            LightTemplateMediaBuilder.build(mediaModel, iStickerContextInterface, mediaBuilderListener, videoRenderChainConfigure, z16);
        }
    }

    public static void mediaBuilderSync(@NonNull MediaModel mediaModel, Context context, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, @NonNull VideoRenderChainConfigure videoRenderChainConfigure, @NonNull MediaBuilderListener mediaBuilderListener) {
        mediaBuilderSync(mediaModel, context, iStickerContextInterface, videoRenderChainConfigure, mediaBuilderListener, false);
    }
}
