package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.utils.o;
import rt3.aa;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LiveInfo";
    public LiveAnchorInfo anchorInfo;
    public int anchorType;
    public LiveRoomConfigInfo configInfo;
    public LiveEcomInfo ecomInfo;
    public LiveGameRecommendInfo gameRecommendInfo;
    public LiveMediaInfo mediaInfo;
    public aa roomEnterSetting;
    public LiveRoomInfo roomInfo;
    public LiveStreamIdInfo streamIdInfo;
    public LiveTrtcInfo trtcInfo;
    public int userFlag;
    public LiveWatchMediaInfo watchMediaInfo;

    public LiveInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.userFlag = 0;
            this.anchorType = 1;
        }
    }

    public boolean isQQAnchor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.anchorType == 1) {
            return true;
        }
        return false;
    }

    public void setAnchorInfo(LiveAnchorInfo liveAnchorInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) liveAnchorInfo);
        } else {
            this.anchorInfo = liveAnchorInfo;
            o.a(TAG, "setAnchorInfo in sub thread!");
        }
    }

    public void setRoomInfo(LiveRoomInfo liveRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) liveRoomInfo);
        } else {
            this.roomInfo = liveRoomInfo;
            o.a(TAG, "setRoomInfo in sub thread!");
        }
    }
}
