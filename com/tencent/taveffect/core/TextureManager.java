package com.tencent.taveffect.core;

import android.util.Log;
import com.tencent.taveffect.effects.LookupFilter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TextureManager {
    private static final String TAG = "TextureManager";
    private volatile TAVFilterGroup customVideoFilterGroup;
    private volatile TAVBaseFilter lookupFilter;
    private TAVFilterGroup releaseFilterGroup;
    private volatile boolean released;
    private VideoFrameListener videoFrameListener = new VideoFrameListener() { // from class: com.tencent.taveffect.core.TextureManager.1
        @Override // com.tencent.taveffect.core.VideoFrameListener
        public void onStickerTextureProcess(TAVTextureInfo tAVTextureInfo, RenderParams renderParams) {
            if (TextureManager.this.released) {
                Log.e(TextureManager.TAG, "onStickerTextureProcess:texture manager is released");
                return;
            }
            TextureManager.this.stickerRenderFilter.setParams(renderParams.getVertexMatrix(), renderParams.getTextureMatrix(), renderParams.getRectangle(), renderParams.getOpacity());
            TextureManager.this.stickerRenderFilter.setRendererWidth(renderParams.getRenderWidth());
            TextureManager.this.stickerRenderFilter.setRendererHeight(renderParams.getRenderHeight());
            TextureManager.this.stickerRenderFilter.applyFilter(tAVTextureInfo);
        }

        @Override // com.tencent.taveffect.core.VideoFrameListener
        public void onVideoTextureProcess(TAVTextureInfo tAVTextureInfo, RenderParams renderParams) {
            if (TextureManager.this.released) {
                Log.e(TextureManager.TAG, "onVideoTextureProcess:texture manager is released");
                return;
            }
            TAVFilterGroup tAVFilterGroup = TextureManager.this.customVideoFilterGroup != null ? TextureManager.this.customVideoFilterGroup : TextureManager.this.defaultVideoFilterGroup;
            tAVFilterGroup.setParams(renderParams.getVertexMatrix(), renderParams.getTextureMatrix(), renderParams.getRectangle(), renderParams.getOpacity());
            tAVFilterGroup.setRendererWidth(renderParams.getRenderWidth());
            tAVFilterGroup.setRendererHeight(renderParams.getRenderHeight());
            tAVFilterGroup.applyFilter(tAVTextureInfo);
            synchronized (this) {
                if (TextureManager.this.releaseFilterGroup != null) {
                    TextureManager.this.releaseFilterGroup.release();
                    TextureManager.this.releaseFilterGroup = null;
                }
            }
        }
    };
    private TAVFilterGroup defaultVideoFilterGroup = new TAVFilterGroup(true);
    private TAVStickerRenderFilter stickerRenderFilter = new TAVStickerRenderFilter();

    public void applyFilter(TAVBaseFilter tAVBaseFilter) {
        if (tAVBaseFilter != null) {
            if (tAVBaseFilter instanceof TAVFilterGroup) {
                TAVFilterGroup tAVFilterGroup = (TAVFilterGroup) tAVBaseFilter;
                if (tAVFilterGroup.hasRender()) {
                    if (this.customVideoFilterGroup != null) {
                        synchronized (this) {
                            TAVFilterGroup tAVFilterGroup2 = this.releaseFilterGroup;
                            if (tAVFilterGroup2 != null) {
                                tAVFilterGroup2.release();
                                this.releaseFilterGroup = null;
                            }
                            this.releaseFilterGroup = this.customVideoFilterGroup;
                        }
                    }
                    this.customVideoFilterGroup = tAVFilterGroup;
                    if (this.lookupFilter != null) {
                        this.customVideoFilterGroup.add(this.lookupFilter);
                        return;
                    }
                    return;
                }
            }
            this.defaultVideoFilterGroup.add(tAVBaseFilter);
        }
    }

    public VideoFrameListener getVideoFrameListener() {
        return this.videoFrameListener;
    }

    public void release() {
        this.released = true;
        if (this.lookupFilter != null) {
            this.lookupFilter.release();
        }
        TAVFilterGroup tAVFilterGroup = this.defaultVideoFilterGroup;
        if (tAVFilterGroup != null) {
            tAVFilterGroup.release();
        }
        if (this.customVideoFilterGroup != null) {
            this.customVideoFilterGroup.release();
        }
        TAVStickerRenderFilter tAVStickerRenderFilter = this.stickerRenderFilter;
        if (tAVStickerRenderFilter != null) {
            tAVStickerRenderFilter.release();
        }
    }

    public void setLookupFilter(TAVBaseFilter tAVBaseFilter) {
        if (this.lookupFilter != null) {
            this.lookupFilter.release();
        }
        this.lookupFilter = tAVBaseFilter;
        if (this.customVideoFilterGroup == null) {
            this.customVideoFilterGroup = new TAVFilterGroup(true);
        }
        this.customVideoFilterGroup.remove(LookupFilter.class);
        if (tAVBaseFilter != null) {
            this.customVideoFilterGroup.add(tAVBaseFilter);
        }
    }

    public void setVideoFrameListener(VideoFrameListener videoFrameListener) {
        this.videoFrameListener = videoFrameListener;
    }
}
