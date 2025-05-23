package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAvInfo {
    public Integer avType;
    public Integer bitrate;
    public String extInfo;
    public GProOpenSdkUrl flv;
    public GProOpenSdkUrl hls;
    public Integer mode;
    public Integer pixelsX;
    public Integer pixelsY;
    public GProOpenSdkUrl rtmp;
    public String sig;
    public GProStreamIDInfo streamIdInfo;
    public GProDesignatedStreamInfo streamInfo;
    public Integer time;
    public GProTimeShiftInfo timeShiftInfo;
    public GProTrtcInfo trtcInfo;
    public Integer videoStatus;

    public Integer getAvType() {
        return this.avType;
    }

    public Integer getBitrate() {
        return this.bitrate;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public GProOpenSdkUrl getFlv() {
        return this.flv;
    }

    public GProOpenSdkUrl getHls() {
        return this.hls;
    }

    public Integer getMode() {
        return this.mode;
    }

    public Integer getPixelsX() {
        return this.pixelsX;
    }

    public Integer getPixelsY() {
        return this.pixelsY;
    }

    public GProOpenSdkUrl getRtmp() {
        return this.rtmp;
    }

    public String getSig() {
        return this.sig;
    }

    public GProStreamIDInfo getStreamIdInfo() {
        return this.streamIdInfo;
    }

    public GProDesignatedStreamInfo getStreamInfo() {
        return this.streamInfo;
    }

    public Integer getTime() {
        return this.time;
    }

    public GProTimeShiftInfo getTimeShiftInfo() {
        return this.timeShiftInfo;
    }

    public GProTrtcInfo getTrtcInfo() {
        return this.trtcInfo;
    }

    public Integer getVideoStatus() {
        return this.videoStatus;
    }

    public String toString() {
        return "GProAvInfo{videoStatus=" + this.videoStatus + ",mode=" + this.mode + ",sig=" + this.sig + ",time=" + this.time + ",extInfo=" + this.extInfo + ",rtmp=" + this.rtmp + ",hls=" + this.hls + ",flv=" + this.flv + ",streamInfo=" + this.streamInfo + ",avType=" + this.avType + ",bitrate=" + this.bitrate + ",pixelsX=" + this.pixelsX + ",pixelsY=" + this.pixelsY + ",trtcInfo=" + this.trtcInfo + ",streamIdInfo=" + this.streamIdInfo + ",timeShiftInfo=" + this.timeShiftInfo + ",}";
    }
}
