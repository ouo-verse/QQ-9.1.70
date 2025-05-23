package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Keep
/* loaded from: classes12.dex */
public class GroupLiveTRTCParams {
    static IPatchRedirector $redirector_;
    public String businessInfo;
    public String privateMapKey;
    public int role;
    public int roomId;
    public int sdkAppId;
    public String strRoomId;
    public String streamId;
    public String userDefineRecordId;
    public String userId;
    public String userSig;

    public GroupLiveTRTCParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sdkAppId = 0;
        this.userId = "";
        this.userSig = "";
        this.roomId = 0;
        this.strRoomId = "";
        this.role = 20;
        this.streamId = "";
        this.userDefineRecordId = "";
        this.privateMapKey = "";
        this.businessInfo = "";
    }

    public GroupLiveTRTCParams(int i3, String str, String str2, int i16, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), str3, str4);
            return;
        }
        this.role = 20;
        this.streamId = "";
        this.userDefineRecordId = "";
        this.sdkAppId = i3;
        this.userId = str;
        this.userSig = str2;
        this.roomId = i16;
        this.strRoomId = "";
        this.privateMapKey = str3;
        this.businessInfo = str4;
    }

    public GroupLiveTRTCParams(int i3, String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, str3, str4, str5);
            return;
        }
        this.roomId = 0;
        this.role = 20;
        this.streamId = "";
        this.userDefineRecordId = "";
        this.sdkAppId = i3;
        this.userId = str;
        this.userSig = str2;
        this.strRoomId = str3;
        this.privateMapKey = str4;
        this.businessInfo = str5;
    }

    public GroupLiveTRTCParams(GroupLiveTRTCParams groupLiveTRTCParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) groupLiveTRTCParams);
            return;
        }
        this.sdkAppId = 0;
        this.userId = "";
        this.userSig = "";
        this.roomId = 0;
        this.strRoomId = "";
        this.role = 20;
        this.streamId = "";
        this.userDefineRecordId = "";
        this.privateMapKey = "";
        this.businessInfo = "";
        this.sdkAppId = groupLiveTRTCParams.sdkAppId;
        this.userId = groupLiveTRTCParams.userId;
        this.userSig = groupLiveTRTCParams.userSig;
        this.roomId = groupLiveTRTCParams.roomId;
        this.strRoomId = groupLiveTRTCParams.strRoomId;
        this.role = groupLiveTRTCParams.role;
        this.streamId = groupLiveTRTCParams.streamId;
        this.userDefineRecordId = groupLiveTRTCParams.userDefineRecordId;
        this.privateMapKey = groupLiveTRTCParams.privateMapKey;
        this.businessInfo = groupLiveTRTCParams.businessInfo;
    }
}
