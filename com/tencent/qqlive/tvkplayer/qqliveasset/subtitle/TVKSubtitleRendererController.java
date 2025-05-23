package com.tencent.qqlive.tvkplayer.qqliveasset.subtitle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController;
import com.tencent.qqlive.tvkplayer.api.subtitle.TVKSubtitleRenderParams;
import com.tencent.qqlive.tvkplayer.logic.TVKThreadAnnotations;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSubtitleRendererController implements ITVKSubtitleRendererController, ITVKSubtitleRenderer, View.OnLayoutChangeListener {
    private static final ITVKSubtitleRenderer SUBTITLE_RENDER_STUB = new TVKSubtitleRendererStub();
    private static final String TAG = "TVKSubtitleRendererController";
    private final TVKQQLiveAssetPlayerContext mAssetPlayerContext;
    private final ITVKLogger mLogger;

    @Nullable
    private ITVKVideoViewPrivate mVideoView;
    private volatile boolean mEnableSubtitleRender = true;
    private TPSubtitleData mCurrentSubtitleData = null;
    private TVKSubtitleRenderParams mSubtitleRenderParams = null;

    @Nullable
    private View.OnLayoutChangeListener mOnLayoutChangeListener = null;
    private ITVKSubtitleRenderer mSubtitleRenderer = SUBTITLE_RENDER_STUB;

    public TVKSubtitleRendererController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, TAG);
    }

    private void removeAndAddVideoViewCallback(ITVKVideoViewPrivate iTVKVideoViewPrivate, ITVKVideoViewPrivate iTVKVideoViewPrivate2) {
        ITVKSubtitleRenderer subtitleRenderer = this.mAssetPlayerContext.getSubtitleRenderer();
        if (!(subtitleRenderer instanceof View.OnLayoutChangeListener)) {
            this.mLogger.error("cannot monitor view event. FIX ME", new Object[0]);
            return;
        }
        this.mOnLayoutChangeListener = (View.OnLayoutChangeListener) subtitleRenderer;
        if (iTVKVideoViewPrivate != null) {
            iTVKVideoViewPrivate.getInnerSubtitleView().removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
        if (iTVKVideoViewPrivate2 != null) {
            iTVKVideoViewPrivate2.getInnerSubtitleView().addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController
    @TVKThreadAnnotations.ThreadSwitch
    public void enableRender(boolean z16) {
        TPSubtitleData tPSubtitleData;
        this.mLogger.info("enableRender: " + z16, new Object[0]);
        this.mEnableSubtitleRender = z16;
        ITVKSubtitleRenderer iTVKSubtitleRenderer = this.mSubtitleRenderer;
        if (this.mEnableSubtitleRender) {
            tPSubtitleData = this.mCurrentSubtitleData;
        } else {
            tPSubtitleData = null;
        }
        iTVKSubtitleRenderer.render(tPSubtitleData);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer
    @Nullable
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public TPSubtitleData getCurrentSubtitleData() {
        if (!this.mEnableSubtitleRender) {
            return null;
        }
        return this.mSubtitleRenderer.getCurrentSubtitleData();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public TVKSubtitleRenderParams getRenderParam() {
        return this.mSubtitleRenderParams;
    }

    @Override // android.view.View.OnLayoutChangeListener
    @TVKThreadAnnotations.ThreadSwitch
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        render(this.mCurrentSubtitleData);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer
    @TVKThreadAnnotations.ThreadSwitch
    public void render(@Nullable TPSubtitleData tPSubtitleData) {
        this.mCurrentSubtitleData = tPSubtitleData;
        if (!this.mEnableSubtitleRender) {
            return;
        }
        if ((this.mSubtitleRenderer instanceof TVKSubtitleRendererStub) && tPSubtitleData != null) {
            TVKSubtitleRenderer tVKSubtitleRenderer = new TVKSubtitleRenderer(this.mAssetPlayerContext);
            this.mSubtitleRenderer = tVKSubtitleRenderer;
            tVKSubtitleRenderer.updateVideoView(this.mVideoView);
        }
        this.mSubtitleRenderer.render(tPSubtitleData);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer
    @TVKThreadAnnotations.ThreadSwitch
    public void reset() {
        this.mLogger.info("reset", new Object[0]);
        this.mEnableSubtitleRender = true;
        this.mSubtitleRenderParams = null;
        this.mCurrentSubtitleData = null;
        ITVKVideoViewPrivate iTVKVideoViewPrivate = this.mVideoView;
        if (iTVKVideoViewPrivate != null) {
            iTVKVideoViewPrivate.getInnerSubtitleView().removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
        this.mVideoView = null;
        this.mSubtitleRenderer.reset();
        this.mSubtitleRenderer = SUBTITLE_RENDER_STUB;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController
    @TVKThreadAnnotations.ThreadSwitch
    public void setRenderParam(TVKSubtitleRenderParams tVKSubtitleRenderParams) {
        this.mLogger.info("setRenderParam: " + tVKSubtitleRenderParams, new Object[0]);
        this.mSubtitleRenderParams = tVKSubtitleRenderParams;
        if (tVKSubtitleRenderParams != null) {
            this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildObject(TPOptionalID.OPTIONAL_ID_GLOBAL_OBJECT_SUBTITLE_RENDER_PARAMS, TVKSubtitleUtils.generateTPSubtitleRenderParams(tVKSubtitleRenderParams)));
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer
    @TVKThreadAnnotations.ThreadSwitch
    public void updateVideoView(@Nullable ITVKVideoViewPrivate iTVKVideoViewPrivate) {
        this.mLogger.info("updateVideoView", new Object[0]);
        removeAndAddVideoViewCallback(this.mVideoView, iTVKVideoViewPrivate);
        this.mVideoView = iTVKVideoViewPrivate;
        this.mSubtitleRenderer.updateVideoView(iTVKVideoViewPrivate);
    }
}
