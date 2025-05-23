package com.tencent.mobileqq.icgame.data.user;

import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class UserCardInfo extends LiveUserInfo {
    public String circleId;
    public String userLevelIcon;
    public long explicitUid = 0;
    public int clientType = 0;
    public String fromAppName = "";
    public String hometown = "";
    public String signature = "";

    /* renamed from: qq, reason: collision with root package name */
    public long f237299qq = 0;
    public int followNum = 0;
    public int fansNum = 0;
    public int isFollow = 0;
    public boolean showGift = false;
    public int userLevel = -1;
    public boolean isUserLevelStatusHide = true;
    public int fansLevel = -1;
    public String fansName = "";
    public String fanIconUrl = "";
    public String fansMedalBgImgStyle = "";
    public String enterRoomTips = "";

    @Override // com.tencent.mobileqq.qqlive.data.user.LiveUserInfo
    public String toString() {
        return "UserCardInfo{explicitUid=" + this.explicitUid + ", clientType=" + this.clientType + ", fromAppName='" + this.fromAppName + "', uid=" + this.uid + ", circleId='" + this.circleId + "', headUrl='" + this.headUrl + "', nick='" + this.nick + "', hometown='" + this.hometown + "', signature='" + this.signature + "', followNum='" + this.followNum + "', nick='" + this.nick + "', isFollow=" + this.isFollow + '}';
    }
}
