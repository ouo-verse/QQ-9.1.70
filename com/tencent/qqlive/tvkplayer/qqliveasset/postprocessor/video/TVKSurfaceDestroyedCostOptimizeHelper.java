package com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKSurfaceDestroyedInfo;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.qqlive.tvkplayer.view.api.ITVKRenderSurface;
import com.tencent.qqlive.tvkplayer.view.subview.TVKSurfaceView;
import com.tencent.qqlive.tvkplayer.view.subview.TVKTextureView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSurfaceDestroyedCostOptimizeHelper {
    private static final String SURFACE_VIEW_NATIVE_OBJECT_FIELD_NAME = "mNativeObject";
    private static final String TEXTURE_VIEW_NATIVE_WINDOW_FIELD_NAME = "mNativeWindow";

    @Nullable
    public static TVKSurfaceDestroyedInfo generateSurfaceDestroyedInfo(@Nullable ITVKRenderSurface iTVKRenderSurface, @Nullable Surface surface) {
        Long fieldValueOfSurfaceNativeObject;
        Long fieldValueOfTextureViewNativeWindow;
        if (isSurfaceDestroyedAsyncForTextureView(iTVKRenderSurface)) {
            TVKTextureView tVKTextureView = (TVKTextureView) ((TVKPlayerVideoView) iTVKRenderSurface).getCurrentDisplayView();
            SurfaceTexture surfaceTexture = tVKTextureView.getSurfaceTexture();
            if (surfaceTexture == null || (fieldValueOfTextureViewNativeWindow = getFieldValueOfTextureViewNativeWindow(tVKTextureView)) == null) {
                return null;
            }
            return new TVKSurfaceDestroyedInfo(fieldValueOfTextureViewNativeWindow.longValue(), surfaceTexture, tVKTextureView);
        }
        if (!isSurfaceDestroyedAsyncForSurfaceView(iTVKRenderSurface) || (fieldValueOfSurfaceNativeObject = getFieldValueOfSurfaceNativeObject(surface)) == null) {
            return null;
        }
        return new TVKSurfaceDestroyedInfo(fieldValueOfSurfaceNativeObject.longValue(), (TVKSurfaceView) ((TVKPlayerVideoView) iTVKRenderSurface).getCurrentDisplayView());
    }

    @Nullable
    private static Long getFieldValueOfSurfaceNativeObject(@Nullable Surface surface) {
        Object field;
        if (surface == null || (field = TVKUtils.getField(Surface.class, SURFACE_VIEW_NATIVE_OBJECT_FIELD_NAME, surface)) == null) {
            return null;
        }
        return (Long) field;
    }

    @Nullable
    private static Long getFieldValueOfTextureViewNativeWindow(@Nullable TextureView textureView) {
        Object field;
        if (textureView == null || (field = TVKUtils.getField(TextureView.class, TEXTURE_VIEW_NATIVE_WINDOW_FIELD_NAME, textureView)) == null) {
            return null;
        }
        return (Long) field;
    }

    public static boolean isSurfaceDestroyedAsyncForSurfaceView(@Nullable ITVKRenderSurface iTVKRenderSurface) {
        if (!TVKCommParams.isSurfaceViewDestroyedAsyncEnabled() || !(iTVKRenderSurface instanceof TVKPlayerVideoView)) {
            return false;
        }
        return ((TVKPlayerVideoView) iTVKRenderSurface).getCurrentDisplayView() instanceof TVKSurfaceView;
    }

    public static boolean isSurfaceDestroyedAsyncForTextureView(@Nullable ITVKRenderSurface iTVKRenderSurface) {
        if (!TVKCommParams.isTextureViewDestroyedAsyncEnabled() || !(iTVKRenderSurface instanceof TVKPlayerVideoView)) {
            return false;
        }
        return ((TVKPlayerVideoView) iTVKRenderSurface).getCurrentDisplayView() instanceof TVKTextureView;
    }
}
