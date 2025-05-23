package com.tencent.qqlive.tvkplayer.qqliveasset.player;

import android.graphics.SurfaceTexture;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.postprocess.api.ITVKMonetSurfaceTexture;
import com.tencent.qqlive.tvkplayer.postprocess.api.TVKPostProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.common.TPDolbyVisionInfo;
import com.tencent.thumbplayer.api.common.TPVideoCropInfo;
import com.tencent.thumbplayer.api.common.TPVideoPacketBuffer;
import com.tencent.thumbplayer.api.surface.ITPSurfaceListener;
import com.tencent.thumbplayer.api.surface.TPSurface;
import com.tencent.thumbplayer.api.surface.TPSurfaceRenderInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSurface {
    private ITVKMonetSurfaceTexture mMonetSurfaceTexture;
    private TPSurface mTPSurface;
    private ITPSurfaceListener mTPSurfaceListener = new ITPSurfaceListener() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKSurface.1
        @Override // com.tencent.thumbplayer.api.surface.ITPSurfaceListener
        public void onFlush() {
            if (TVKSurface.this.mMonetSurfaceTexture != null) {
                TVKSurface.this.mMonetSurfaceTexture.onFlush();
            }
        }

        @Override // com.tencent.thumbplayer.api.surface.ITPSurfaceListener
        public void onRenderInfo(TPSurfaceRenderInfo tPSurfaceRenderInfo) {
            if (tPSurfaceRenderInfo != null && TVKSurface.this.mMonetSurfaceTexture != null) {
                TVKSurface.this.mMonetSurfaceTexture.onRenderInfo(tPSurfaceRenderInfo.getDisplayWidth(), tPSurfaceRenderInfo.getDisplayHeight(), TVKSurface.createMonetTextureCropInfo(tPSurfaceRenderInfo.getVideoCropInfo()));
            }
        }

        @Override // com.tencent.thumbplayer.api.surface.ITPSurfaceListener
        public void onVideoPacket(TPVideoPacketBuffer tPVideoPacketBuffer, long j3) {
            if (tPVideoPacketBuffer != null && TVKSurface.this.mMonetSurfaceTexture != null) {
                TVKSurface.this.mMonetSurfaceTexture.onVideoPacket(TVKSurface.createMonetTextureVideoPacket(tPVideoPacketBuffer), j3);
            }
        }
    };

    public TVKSurface(SurfaceTexture surfaceTexture) {
        boolean isManufacturerInList = TVKUtils.isManufacturerInList(TVKMediaPlayerConfig.PlayerConfig.crop_manufacturer_black_list);
        TPSurface tPSurface = new TPSurface(surfaceTexture);
        this.mTPSurface = tPSurface;
        tPSurface.setSurfaceListener(this.mTPSurfaceListener);
        this.mMonetSurfaceTexture = TVKPostProcessorFactory.createMonetSurfaceTexture(surfaceTexture, isManufacturerInList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static ITVKMonetSurfaceTexture.TVKMonetTextureCropInfo createMonetTextureCropInfo(TPVideoCropInfo tPVideoCropInfo) {
        if (tPVideoCropInfo == null) {
            return null;
        }
        ITVKMonetSurfaceTexture.TVKMonetTextureCropInfo tVKMonetTextureCropInfo = new ITVKMonetSurfaceTexture.TVKMonetTextureCropInfo();
        tVKMonetTextureCropInfo.cropLeft = tPVideoCropInfo.getCropLeft();
        tVKMonetTextureCropInfo.cropRight = tPVideoCropInfo.getCropRight();
        tVKMonetTextureCropInfo.cropTop = tPVideoCropInfo.getCropTop();
        tVKMonetTextureCropInfo.cropBottom = tPVideoCropInfo.getCropBottom();
        return tVKMonetTextureCropInfo;
    }

    @Nullable
    private static ITVKMonetSurfaceTexture.TVKMonetDolbyVisionInfo createMonetTextureDolbyVisionInfo(TPDolbyVisionInfo tPDolbyVisionInfo) {
        if (tPDolbyVisionInfo == null) {
            return null;
        }
        ITVKMonetSurfaceTexture.TVKMonetDolbyVisionInfo tVKMonetDolbyVisionInfo = new ITVKMonetSurfaceTexture.TVKMonetDolbyVisionInfo();
        tVKMonetDolbyVisionInfo.profile = tPDolbyVisionInfo.getProfile();
        tVKMonetDolbyVisionInfo.level = tPDolbyVisionInfo.getLevel();
        tVKMonetDolbyVisionInfo.blSignalCompatibilityId = tPDolbyVisionInfo.getBlSignalCompatibilityId();
        return tVKMonetDolbyVisionInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static ITVKMonetSurfaceTexture.TVKMonetVideoPacketBuffer createMonetTextureVideoPacket(TPVideoPacketBuffer tPVideoPacketBuffer) {
        int i3;
        if (tPVideoPacketBuffer == null) {
            return null;
        }
        ITVKMonetSurfaceTexture.TVKMonetVideoPacketBuffer tVKMonetVideoPacketBuffer = new ITVKMonetSurfaceTexture.TVKMonetVideoPacketBuffer();
        byte[] data = tPVideoPacketBuffer.getData();
        tVKMonetVideoPacketBuffer.data = data;
        if (data != null) {
            i3 = data.length;
        } else {
            i3 = 0;
        }
        tVKMonetVideoPacketBuffer.size = i3;
        tVKMonetVideoPacketBuffer.ptsMs = tPVideoPacketBuffer.getPtsMs();
        tVKMonetVideoPacketBuffer.dtsMs = tPVideoPacketBuffer.getDtsMs();
        tVKMonetVideoPacketBuffer.dolbyVisionInfo = createMonetTextureDolbyVisionInfo(tPVideoPacketBuffer.getDolbyVisionInfo());
        return tVKMonetVideoPacketBuffer;
    }

    public TPSurface getTPSurface() {
        return this.mTPSurface;
    }
}
