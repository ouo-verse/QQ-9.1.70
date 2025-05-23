package com.tencent.mobileqq.videoplatform.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes20.dex */
public class VideoPlayParam {
    static IPatchRedirector $redirector_;
    public VideoPlayerCallback mCallback;
    public ArrayList<String> mCookies;
    public String mFileID;
    public long mFileSize;
    public boolean mIsLocal;
    public boolean mIsLoop;
    public boolean mIsMute;
    public long mLastPlayPosMs;
    public long mMaxPlayTimeMs;
    public boolean mNeedPlayProgress;
    public String mSavePath;
    public int mSceneId;
    public String mSceneName;
    public long mStartPlayPosMs;
    public String[] mUrls;
    public long mVideoFileTimeMs;
    public int mVideoFormat;
    public String mVideoPath;

    public VideoPlayParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mVideoFormat = 101;
        }
    }

    public boolean isSameVideo(Object obj) {
        String[] strArr;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof VideoPlayParam)) {
            return false;
        }
        VideoPlayParam videoPlayParam = (VideoPlayParam) obj;
        if (videoPlayParam.mIsLocal != this.mIsLocal || videoPlayParam.mIsLoop != this.mIsLoop || videoPlayParam.mIsMute != this.mIsMute) {
            return false;
        }
        String str2 = videoPlayParam.mVideoPath;
        if (str2 != null && (str = this.mVideoPath) != null && str2.equals(str)) {
            return true;
        }
        String[] strArr2 = videoPlayParam.mUrls;
        if (strArr2 == null || (strArr = this.mUrls) == null || !Arrays.equals(strArr2, strArr)) {
            return false;
        }
        return true;
    }
}
