package com.tencent.gamematrix.gmcg.webrtc;

import android.util.Log;
import com.tencent.gamematrix.gmvideofilter.VideoFilter;
import org.tencwebrtc.VideoSR;

/* loaded from: classes6.dex */
public class VideoFilterParams {
    private static final String TAG = "VideoFilterParams";
    public static final int VIDEO_FILTER_FSR10_MODE_ENGINE_OPT = 4;
    public static final int VIDEO_FILTER_FSR10_MODE_HSSM = 3;
    public static final int VIDEO_FILTER_FSR10_MODE_NONE = 0;
    public static final int VIDEO_FILTER_FSR10_MODE_ON = 1;
    public static final int VIDEO_FILTER_FSR10_MODE_SGSR = 5;
    public static final int VIDEO_FILTER_FSR10_MODE_TEST = 2;
    public static final int VIDEO_FILTER_TYPE_INDEX_FSR10 = 2;
    public static final int VIDEO_FILTER_TYPE_INDEX_NONE = 0;
    public static final int VIDEO_FILTER_TYPE_INDEX_RAISR = 1;
    public static final int VIDEO_FILTER_TYPE_INDEX_TNN = 4;
    private boolean m_isOnlyOne;
    public String m_strSrResultHost;
    public String m_strSrResultKey;
    public String m_strSessionId = "1";
    public String m_strDeviceId = "1";
    public String m_strBuildSoc = "1";
    public String m_strBuildBrand = "1";
    public String m_strBuildModel = "1";
    public String m_strModelConfigName = "1";
    private int m_videoFilterType = 0;
    private int m_fsr_type = 0;
    private boolean m_isLoadYuvToFsr = false;
    private boolean m_isOnlyHwDecode = true;
    private boolean m_isHwDecode = false;
    public int m_solution = 0;
    public String m_strBaseDir = "1";
    public String m_strConfig = "1";
    public String m_strCacheDir = "1";
    public String m_strGameId = "1";
    public String m_strDspLibPath = "1";
    public int m_lrWidth = 0;
    public int m_lrHeight = 0;
    public int m_scale = 2;
    public long m_glContext = 0;
    public long m_glDisplay = 0;
    private VideoSR.Callback m_callback = null;
    private VideoFilter.Callback m_videoFilterCallback = null;

    public VideoFilterParams(boolean z16) {
        this.m_isOnlyOne = z16;
    }

    public static String getVideoFilterDesc(int i3) {
        String str = "no filter";
        boolean z16 = false;
        for (int i16 = 0; i16 < 3; i16++) {
            int i17 = (1 << i16) & i3;
            if (i17 == 1) {
                if (!z16) {
                    str = "VIDEO_FILTER_TYPE_INDEX_RAISR";
                    z16 = true;
                } else {
                    str = str + " | VIDEO_FILTER_TYPE_INDEX_RAISR";
                }
            }
            if (i17 == 2) {
                if (!z16) {
                    str = "VIDEO_FILTER_TYPE_INDEX_FSR10";
                    z16 = true;
                } else {
                    str = str + " | VIDEO_FILTER_TYPE_INDEX_FSR10";
                }
            }
            if (i17 == 4) {
                if (!z16) {
                    str = "VIDEO_FILTER_TYPE_INDEX_TNN";
                    z16 = true;
                } else {
                    str = str + " | VIDEO_FILTER_TYPE_INDEX_TNN";
                }
            }
        }
        return str;
    }

    public int getFsrType() {
        return this.m_fsr_type;
    }

    public VideoSR.Callback getSrCallback() {
        return this.m_callback;
    }

    public VideoFilter.Callback getVideoFilterCallback() {
        return this.m_videoFilterCallback;
    }

    public int getVideoFilterType() {
        return this.m_videoFilterType;
    }

    public boolean isEnableFsr() {
        if ((this.m_videoFilterType & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isEnableTnnSr() {
        if ((this.m_videoFilterType & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean isHwDecode() {
        return this.m_isHwDecode;
    }

    public boolean isLoadYuvToFsr() {
        return this.m_isLoadYuvToFsr;
    }

    public boolean isOnlyHwDecode() {
        return this.m_isOnlyHwDecode;
    }

    public void setFsrType(int i3) {
        this.m_fsr_type = i3;
    }

    public void setHwDecode(boolean z16) {
        this.m_isHwDecode = z16;
    }

    public void setLoadYuvToFsr(boolean z16) {
        this.m_isLoadYuvToFsr = z16;
    }

    public void setOnlyHwDecode(boolean z16) {
        this.m_isOnlyHwDecode = z16;
    }

    public void setSrCallback(VideoSR.Callback callback) {
        this.m_callback = callback;
    }

    public void setVideoFilterCallback(VideoFilter.Callback callback) {
        this.m_videoFilterCallback = callback;
    }

    public void setVideoFilterType(int i3) {
        if (this.m_isOnlyOne) {
            this.m_videoFilterType = i3;
        } else {
            this.m_videoFilterType |= i3;
        }
        Log.i(TAG, "isOnlyOne=" + this.m_isOnlyOne + " videofilter type=" + i3 + " current type=" + this.m_videoFilterType + " (" + getVideoFilterDesc(this.m_videoFilterType) + ")");
    }
}
