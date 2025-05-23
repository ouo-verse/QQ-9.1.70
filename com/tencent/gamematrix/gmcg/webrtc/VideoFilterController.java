package com.tencent.gamematrix.gmcg.webrtc;

import androidx.annotation.FloatRange;
import com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmvideofilter.VideoFilter;
import mqq.app.Constants;
import org.tencwebrtc.NativeLibrary;
import org.tencwebrtc.VideoSR;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class VideoFilterController {
    static int ecbsr_lr_height;
    static int ecbsr_lr_width;
    private static final CGSingletonHelper<VideoFilterController> sInstance = new CGSingletonHelper<VideoFilterController>() { // from class: com.tencent.gamematrix.gmcg.webrtc.VideoFilterController.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper
        public VideoFilterController create() {
            return new VideoFilterController();
        }
    };
    private final String TAG;
    public boolean mEnableCloudGameFullScreenVideo;
    public boolean mHasLoadLibJingle;
    public boolean mIsSrSolutionMutex;
    public int mScreenDisplayHeight;
    public int mScreenDisplayWidth;
    public int mVideoFilterType;

    private void checkAndloadLibJingle() {
        if (!this.mHasLoadLibJingle) {
            this.mHasLoadLibJingle = true;
            try {
                NativeLibrary.initialize(new NativeLibrary.DefaultLoader(), "jingle_peerconnection_so_tenc");
                CGLog.v("VideoFilter: loadLibrary jingle finished!");
            } catch (Exception e16) {
                this.mHasLoadLibJingle = false;
                e16.printStackTrace();
                CGLog.e("VideoFilter: loadLibrary jingle failed! " + e16.getMessage());
            }
        }
    }

    public static VideoFilterController get() {
        return sInstance.get();
    }

    public static void setEcbsrVideoSize(int i3, int i16) {
        ecbsr_lr_width = i3;
        ecbsr_lr_height = i16;
    }

    public int getScreenDisplayHeight() {
        return this.mScreenDisplayHeight;
    }

    public int getScreenDisplayWidth() {
        return this.mScreenDisplayWidth;
    }

    public int getSrErrCount() {
        return VideoSR.predictErrCount_;
    }

    public String getSrServiceVersion() {
        return VideoSR.srServiceVersion();
    }

    public float getTvsrSharpFactor() {
        if (this.mVideoFilterType == 1) {
            return VideoFilter.getSharpFactor();
        }
        return 0.0f;
    }

    public short getVideoFilterAvgTime() {
        return (short) VideoFilter.avgCostTimeMs_;
    }

    public int getVideoFilterType() {
        return this.mVideoFilterType;
    }

    public short getVideoSrAvgTime() {
        return (short) VideoSR.avgCostTimeMs_;
    }

    public int getVideoSrScale() {
        return VideoSR.getScale();
    }

    public boolean initSrService(VideoFilterParams videoFilterParams) {
        boolean z16;
        if (VideoSR.isInited()) {
            CGLog.i("VideoFilter: initSrService already inited!");
            return true;
        }
        if (videoFilterParams == null) {
            CGLog.i("VideoFilter: initSrService params is null object");
            return false;
        }
        VideoSR.registerCGLogCallback(new VideoSR.CGLogCallback() { // from class: com.tencent.gamematrix.gmcg.webrtc.VideoFilterController.3
            @Override // org.tencwebrtc.VideoSR.CGLogCallback
            public void d(String str, String str2) {
                CGLog.d(str2);
            }

            @Override // org.tencwebrtc.VideoSR.CGLogCallback
            public void e(String str, String str2) {
                CGLog.e(str2);
            }

            @Override // org.tencwebrtc.VideoSR.CGLogCallback
            public void i(String str, String str2) {
                CGLog.i(str2);
            }

            @Override // org.tencwebrtc.VideoSR.CGLogCallback
            public void v(String str, String str2) {
                CGLog.v(str2);
            }

            @Override // org.tencwebrtc.VideoSR.CGLogCallback
            public void w(String str, String str2) {
                CGLog.w(str2);
            }
        });
        VideoSR.Callback srCallback = videoFilterParams.getSrCallback();
        if (srCallback == null) {
            CGLog.i("VideoFilter: srServiceInit callback is null");
        }
        VideoSR.registerSrClientCallback(srCallback);
        CGLog.i("VideoFilter: srServiceInit lr_width=" + videoFilterParams.m_lrWidth + " lr_height=" + videoFilterParams.m_lrHeight + " scale=" + videoFilterParams.m_scale);
        int srServiceEnable = VideoSR.srServiceEnable(true, 0, videoFilterParams.m_strBaseDir, videoFilterParams.m_strConfig, videoFilterParams.m_strCacheDir, videoFilterParams.m_strGameId, videoFilterParams.m_strDspLibPath, videoFilterParams.m_lrHeight, videoFilterParams.m_lrWidth, videoFilterParams.m_scale, videoFilterParams.m_glContext, videoFilterParams.m_glDisplay);
        if (srServiceEnable == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        CGLog.i("VideoFilter: srServiceInit res=" + z16 + " errCode=" + srServiceEnable);
        return z16;
    }

    public boolean isEnableCloudGameFullScreenVideo() {
        return this.mEnableCloudGameFullScreenVideo;
    }

    public boolean isOpenFsr() {
        return VideoFilter.isOpenFsr();
    }

    public boolean isOpenTvesr() {
        return VideoFilter.isOpenTvesr();
    }

    public boolean isOpenVideoSr() {
        return VideoSR.isInited();
    }

    public boolean isUseFilterDrawer() {
        int i3 = this.mVideoFilterType;
        if ((i3 & 1) == 0 && (i3 & 2) == 0) {
            return false;
        }
        return true;
    }

    public boolean isUseShareEglContext() {
        if ((this.mVideoFilterType & 4) != 0) {
            return false;
        }
        return true;
    }

    public void loadYuvFileToFsrEnabled(boolean z16) {
        VideoFilter.inputYuvFileToDumpFsrEnabled(z16);
    }

    public void releaseVideoFilter(int i3) {
        if (i3 == 0) {
            return;
        }
        int i16 = this.mVideoFilterType;
        if ((i3 & 4) != 0 && (i16 & 4) != 0) {
            this.mVideoFilterType = i16 & (-5);
            VideoSR.srServiceRelease();
        }
        if ((i3 & 2) != 0) {
            int i17 = this.mVideoFilterType;
            if ((i17 & 2) != 0) {
                this.mVideoFilterType = i17 & (-3);
                VideoFilter.setOpenFsr(false, 0);
                VideoFilter.release();
            }
        }
        if ((i3 & 1) != 0) {
            int i18 = this.mVideoFilterType;
            if ((i18 & 1) != 0) {
                this.mVideoFilterType = i18 & (-2);
                VideoFilter.setOpenTvesr(false);
                VideoFilter.release();
            }
        }
        if (this.mVideoFilterType != 0) {
            CGLog.e("VideoFilter: clear video filter!");
            this.mVideoFilterType = 0;
        }
        CGLog.w("VideoFilter: VideoFilterController release videofilter type=" + i3 + " current type=" + i16 + " after release the videofilter is " + this.mVideoFilterType + " (" + VideoFilterParams.getVideoFilterDesc(this.mVideoFilterType) + ")");
    }

    public void setDrawerRotate(float f16) {
        VideoFilter.setDrawerRotate(f16);
    }

    public void setEnableCloudGameFullScreenVideo(boolean z16) {
        this.mEnableCloudGameFullScreenVideo = z16;
    }

    public void setOpenFsr(boolean z16, int i3, VideoFilter.Callback callback) {
        int i16;
        CGLog.i("VideoFilter: setOpenFsr enable=" + z16 + " mode=" + i3);
        if (z16) {
            if (this.mIsSrSolutionMutex && (i16 = this.mVideoFilterType) != 2) {
                releaseVideoFilter(i16);
            }
            if (callback == null) {
                CGLog.i("VideoFilter: VideoFiler callback is null");
            }
            VideoFilter.registerCGLogCallback(new VideoFilter.CGLogCallback() { // from class: com.tencent.gamematrix.gmcg.webrtc.VideoFilterController.2
                @Override // com.tencent.gamematrix.gmvideofilter.VideoFilter.CGLogCallback
                public void d(String str, String str2) {
                    CGLog.d(str2);
                }

                @Override // com.tencent.gamematrix.gmvideofilter.VideoFilter.CGLogCallback
                public void e(String str, String str2) {
                    CGLog.e(str2);
                }

                @Override // com.tencent.gamematrix.gmvideofilter.VideoFilter.CGLogCallback
                public void i(String str, String str2) {
                    CGLog.i(str2);
                }

                @Override // com.tencent.gamematrix.gmvideofilter.VideoFilter.CGLogCallback
                public void v(String str, String str2) {
                    CGLog.v(str2);
                }

                @Override // com.tencent.gamematrix.gmvideofilter.VideoFilter.CGLogCallback
                public void w(String str, String str2) {
                    CGLog.w(str2);
                }
            });
            VideoFilter.registerFilterClientCallback(callback);
            VideoFilter.setOpenFsr(z16, i3);
            if (VideoFilter.isOpenFsr()) {
                this.mVideoFilterType |= 2;
                CGLog.i("VideoFilter: VideoFilterController set current videofilter type=" + this.mVideoFilterType + " (" + VideoFilterParams.getVideoFilterDesc(this.mVideoFilterType) + ")");
                return;
            }
            return;
        }
        VideoFilter.unregisterFilterClientCallback();
        VideoFilter.unregisterCGLogCallback();
        releaseVideoFilter(2);
    }

    public void setOpenTvesr(boolean z16) {
        int i3;
        if (z16) {
            if (this.mIsSrSolutionMutex && (i3 = this.mVideoFilterType) != 1) {
                releaseVideoFilter(i3);
            }
            VideoFilter.setOpenTvesr(true);
            if (VideoFilter.isOpenTvesr()) {
                this.mVideoFilterType |= 1;
                CGLog.i("VideoFilter: VideoFilterController set current videofilter type=" + this.mVideoFilterType + " (" + VideoFilterParams.getVideoFilterDesc(this.mVideoFilterType) + ")");
                return;
            }
            return;
        }
        releaseVideoFilter(1);
    }

    public void setOpenVideoSr(boolean z16, VideoFilterParams videoFilterParams) {
        int i3;
        if (z16 && videoFilterParams != null) {
            if (this.mIsSrSolutionMutex && (i3 = this.mVideoFilterType) != 4) {
                releaseVideoFilter(i3);
            }
            if (((this.mVideoFilterType & 4) == 0 || !VideoSR.isInited()) && initSrService(videoFilterParams)) {
                this.mVideoFilterType |= 4;
                CGLog.i("VideoFilter: VideoFilterController set current videofilter type=" + this.mVideoFilterType + " (" + VideoFilterParams.getVideoFilterDesc(this.mVideoFilterType) + ")");
                return;
            }
            return;
        }
        uninitSrService();
    }

    public void setSGSRDeltaLimit(@FloatRange(from = 0.0d, to = 255.0d) float f16) {
        VideoFilter.setSGSRDeltaLimit(f16);
    }

    public void setSGSREdgeSharpness(float f16) {
        VideoFilter.setSGSREdgeSharpness(f16);
    }

    public void setSGSREdgeThreshold(@FloatRange(from = 0.0d, to = 255.0d) float f16) {
        VideoFilter.setSGSREdgeThreshold(f16);
    }

    public void setScreenDisplayWH(int i3, int i16) {
        this.mScreenDisplayWidth = i3;
        this.mScreenDisplayHeight = i16;
    }

    public void setTvsrSharpFactor(float f16) {
        if (this.mVideoFilterType == 1) {
            VideoFilter.setSharpFactor(f16);
        }
    }

    public void srServicePause() {
        VideoSR.srServicePause();
    }

    public void srServiceResume() {
        VideoSR.srServiceResume();
    }

    public void srServiceSendCallback(int i3, int i16, int i17, int i18, String str) {
        VideoSR.srServiceSendCallback(i3, i16, i17, i18, str);
    }

    public void uninitSrService() {
        VideoSR.unregisterSrClientCallback();
        VideoSR.unregisterCGLogCallback();
        releaseVideoFilter(4);
    }

    public void videoFilterSendCallback(int i3, int i16, int i17, int i18, String str, VideoFilter.Callback callback) {
        CGLog.e("videoFilterSendCallback: " + str);
        VideoFilter.registerFilterClientCallback(callback);
        VideoFilter.videoFilterSendCallback(i3, i16, i17, i18, str);
        VideoFilter.unregisterFilterClientCallback();
    }

    VideoFilterController() {
        this.TAG = "VideoFilter: ";
        this.mVideoFilterType = 0;
        this.mIsSrSolutionMutex = false;
        this.mScreenDisplayWidth = 1080;
        this.mScreenDisplayHeight = Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE;
        this.mEnableCloudGameFullScreenVideo = false;
        this.mHasLoadLibJingle = false;
        checkAndloadLibJingle();
    }

    public void releaseVideoFilter() {
        CGLog.i("VideoFilter releaseVideoFilter()");
        releaseVideoFilter(this.mVideoFilterType);
    }
}
