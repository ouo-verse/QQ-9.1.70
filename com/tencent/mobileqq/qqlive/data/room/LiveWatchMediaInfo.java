package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceFrameInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceStreamInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveWatchMediaInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int CODEC_TYPE_AV1 = 4;
    public static final int CODEC_TYPE_H264 = 1;
    public static final int CODEC_TYPE_H265 = 2;
    public static final int CODEC_TYPE_H266 = 3;
    public static final int CODEC_TYPE_VP9 = 5;
    public static final int PROTO_TYPE_FILE = 3;
    public static final int PROTO_TYPE_HTTP = 1;
    public static final int PROTO_TYPE_RTMP = 2;
    public boolean forceSwitch;
    public boolean isOriginStream;
    public boolean isPreload;
    public String mFlvUrl;
    public String mFlvUrlHigh;
    public String mFlvUrlLow;
    public String mFlvUrlLowest;
    public String mHLSUrl;
    public int mLevel;
    public String mRtmpUrl;
    public String mRtmpUrlHigh;
    public String mRtmpUrlLow;
    public String mRtmpUrlLowest;
    public int mSdkType;
    public String mUrl;
    public String mUrlHigh;
    public String mUrlLow;
    public String mUrlLowest;
    public LiveVideoStatus mVideoStatus;
    public ServiceStreamInfo serviceStreamInfo;
    public byte[] sig;
    public long sigTimeOut;
    public int sugLevel;
    public ServiceFrameInfo sugServiceFrameInfo;

    public LiveWatchMediaInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mVideoStatus = LiveVideoStatus.Start;
        this.forceSwitch = false;
        this.mSdkType = 0;
        this.isPreload = false;
    }

    public String getMediaUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mRtmpUrl;
    }

    public int getProtoType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 2;
    }
}
