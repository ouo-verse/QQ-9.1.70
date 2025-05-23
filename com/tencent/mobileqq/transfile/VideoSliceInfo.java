package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VideoSliceInfo {
    static IPatchRedirector $redirector_;
    public boolean mEncodeFinish;
    public int mIndex;
    public boolean mSendClicked;
    public int mVideoDuration;
    public int mVideoHeight;
    public String mVideoMd5;
    public String mVideoPath;
    public boolean mVideoSyncStory;
    public int mVideoWidth;

    public VideoSliceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("VideoSliceInfo\n");
        sb5.append("mIndex=");
        sb5.append(this.mIndex);
        sb5.append(",mVideoDuration=");
        sb5.append(this.mVideoDuration);
        sb5.append(",mEncodeFinish=");
        sb5.append(this.mEncodeFinish);
        sb5.append(",mVideoPath(");
        sb5.append(this.mVideoWidth + "*" + this.mVideoHeight);
        sb5.append(")=");
        sb5.append(this.mVideoPath);
        sb5.append(",mVideoMd5=");
        sb5.append(this.mVideoMd5);
        sb5.append(",mSendClicked=");
        sb5.append(this.mSendClicked);
        sb5.append(",mVideoSyncStory=");
        sb5.append(this.mVideoSyncStory);
        return sb5.toString();
    }
}
