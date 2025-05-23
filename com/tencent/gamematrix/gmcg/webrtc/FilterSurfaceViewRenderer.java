package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmvideofilter.VideoFilter;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.GlRectDrawer;
import org.tencwebrtc.RendererCommon;
import org.tencwebrtc.SurfaceViewRenderer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FilterSurfaceViewRenderer extends SurfaceViewRenderer {
    public static final String TAG = "VideoFilter ";
    public static boolean VideoFilterEnabled = false;
    private static boolean debugView = false;
    private static boolean inited = false;
    private static VideoFilterParams videoFilterParams;
    private Context context;
    private FloatingView mFloatingView;
    private WebRTCSDK sdk;

    public FilterSurfaceViewRenderer(Context context) {
        super(context);
        this.sdk = null;
        this.mFloatingView = null;
        this.context = context;
    }

    public static void clearVideoFilterParams() {
        videoFilterParams = null;
    }

    public static boolean getVideoFilter() {
        return VideoFilterEnabled;
    }

    public static void setDebugMode(boolean z16) {
        debugView = z16;
    }

    public static int setVideoFilterParams(boolean z16, VideoFilterParams videoFilterParams2) {
        int i3;
        boolean z17;
        videoFilterParams = videoFilterParams2;
        if (videoFilterParams2 != null) {
            i3 = videoFilterParams2.getVideoFilterType();
            videoFilterParams2.setHwDecode(z16);
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            z17 = false;
        } else if (videoFilterParams2.isOnlyHwDecode()) {
            z17 = z16;
        } else {
            z17 = true;
        }
        int i16 = VideoFilter.SDK_INT;
        if (i16 < 21) {
            CGLog.e("VideoFilter FilterSurfaceViewRenderer setVideoFilter failed enabled:" + i3 + " inited:" + inited + " SDK_INT:" + i16 + " < 21");
            return -1;
        }
        if (inited) {
            CGLog.e("VideoFilter FilterSurfaceViewRenderer setVideoFilter enabled:" + i3 + " already inited:" + inited);
            return -1;
        }
        VideoFilterEnabled = z17;
        CGLog.i("setVideoFilter(" + VideoFilterEnabled + ") isVideoFilterEnabled=" + i3 + " isHwDecode=" + z16 + " !!!");
        return 0;
    }

    @Override // org.tencwebrtc.SurfaceViewRenderer
    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents) {
        RendererCommon.GlDrawer glRectDrawer;
        CGLog.v("VideoFilter FilterSurfaceViewRenderer init filter:" + VideoFilterEnabled + " SDK_INT:" + VideoFilter.SDK_INT);
        inited = true;
        VideoFilterParams videoFilterParams2 = videoFilterParams;
        if (videoFilterParams2 != null) {
            if (VideoFilterEnabled) {
                if (videoFilterParams2.isEnableFsr()) {
                    VideoFilterController.get().setOpenFsr(true, videoFilterParams.getFsrType(), videoFilterParams.getVideoFilterCallback());
                }
                if (videoFilterParams.isEnableTnnSr()) {
                    VideoFilterController.get().setOpenVideoSr(true, videoFilterParams);
                }
            } else if (videoFilterParams2.isEnableFsr()) {
                VideoFilterController.get().videoFilterSendCallback(0, videoFilterParams.getFsrType(), 99, -99, "VideoFilterType is " + videoFilterParams.getVideoFilterType() + ". VideoFilterEnabled is " + VideoFilterEnabled + ". isHwDecode is " + videoFilterParams.isHwDecode() + ".", videoFilterParams.getVideoFilterCallback());
            }
        }
        CGLog.v("VideoFilter FilterSurfaceViewRenderer init filter_enabled:" + VideoFilterEnabled);
        if (VideoFilterEnabled && debugView) {
            FloatingView floatingView = new FloatingView(this.context);
            this.mFloatingView = floatingView;
            floatingView.setWebRTCSDK(this.sdk);
        }
        if (VideoFilterController.get().isUseFilterDrawer()) {
            glRectDrawer = new GLFilterDrawer(this.context);
        } else {
            glRectDrawer = new GlRectDrawer();
        }
        super.init(context, rendererEvents, EglBase.CONFIG_PLAIN, glRectDrawer);
    }

    @Override // org.tencwebrtc.SurfaceViewRenderer
    public void release() {
        super.release();
        CGLog.v("VideoFilter FilterSurfaceViewRenderer release");
        FloatingView floatingView = this.mFloatingView;
        if (floatingView != null) {
            floatingView.setWebRTCSDK(null);
            this.mFloatingView = null;
            this.sdk = null;
        }
        VideoFilterController.get().releaseVideoFilter();
        inited = false;
    }

    public void setWebRTCSDK(WebRTCSDK webRTCSDK) {
        this.sdk = webRTCSDK;
        FloatingView floatingView = this.mFloatingView;
        if (floatingView != null) {
            floatingView.setWebRTCSDK(webRTCSDK);
        }
    }

    @Override // org.tencwebrtc.SurfaceViewRenderer, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        boolean z16;
        VideoFilterParams videoFilterParams2;
        boolean z17;
        CGLog.v("VideoFilter FilterSurfaceViewRenderer surfaceCreated");
        FloatingView floatingView = this.mFloatingView;
        if (floatingView != null) {
            floatingView.show();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("VideoFilter FilterSurfaceViewRenderer surfaceCreated filter type: ");
        sb5.append(VideoFilterController.get().getVideoFilterType());
        sb5.append(" VideoFilterEnabled: ");
        sb5.append(VideoFilterEnabled);
        sb5.append(" videoFilterParams is ");
        boolean z18 = false;
        if (videoFilterParams != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        CGLog.w(sb5.toString());
        if (VideoFilterEnabled && (videoFilterParams2 = videoFilterParams) != null) {
            if (videoFilterParams2.isEnableFsr() && !VideoFilterController.get().isOpenFsr()) {
                VideoFilterController.get().setOpenFsr(true, videoFilterParams.getFsrType(), videoFilterParams.getVideoFilterCallback());
                z17 = true;
            } else {
                z17 = false;
            }
            if (videoFilterParams.isEnableTnnSr() && !VideoFilterController.get().isOpenVideoSr()) {
                VideoFilterController.get().setOpenVideoSr(true, videoFilterParams);
                z18 = true;
            }
            CGLog.w("VideoFilter FilterSurfaceViewRenderer surfaceCreated filter type: " + VideoFilterController.get().getVideoFilterType() + " filter reset: (" + z17 + ", " + z18 + ")");
        }
    }

    @Override // org.tencwebrtc.SurfaceViewRenderer, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        CGLog.v("VideoFilter FilterSurfaceViewRenderer surfaceDestroyed");
        FloatingView floatingView = this.mFloatingView;
        if (floatingView != null) {
            floatingView.hide();
        }
        WebRTCSDK webRTCSDK = this.sdk;
        if (webRTCSDK != null) {
            webRTCSDK.setSurface(null);
        }
        VideoFilterController.get().releaseVideoFilter(2);
    }

    public FilterSurfaceViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sdk = null;
        this.mFloatingView = null;
        this.context = context;
    }
}
