package com.tencent.mobileqq.qqlive.data.user;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import java.util.List;
import rr4.b;
import rr4.d;
import rr4.f;
import rr4.h;
import rr4.i;
import sr4.g;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UserCardInfo extends LiveUserInfo {
    static IPatchRedirector $redirector_;
    public String avatarDynamicPendantUrl;
    public h[] avatarPendantResources;
    public String avatarStaticPendantUrl;
    public String circleId;
    public int clientType;
    public String diamondMedalBgImgStyle;
    public String enterRoomTips;
    public long explicitUid;
    public String fanIconUrl;
    public int fansLevel;
    public String fansMedalBgImgStyle;
    public String fansName;
    public int fansNum;
    public int followNum;
    public String fromAppName;
    public String hometown;
    public int isFollow;
    public List<g> medalInfoNews;

    /* renamed from: qq, reason: collision with root package name */
    public long f271218qq;
    public boolean showGift;
    public String signature;

    @Nullable
    public SkinInfo skinInfo;
    public String suspectUrl;
    public int userLevel;
    public String userLevelIcon;

    public UserCardInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.explicitUid = 0L;
        this.clientType = 0;
        this.fromAppName = "";
        this.hometown = "";
        this.signature = "";
        this.f271218qq = 0L;
        this.followNum = 0;
        this.fansNum = 0;
        this.isFollow = 0;
        this.showGift = false;
        this.userLevel = -1;
        this.fansLevel = -1;
        this.fansName = "";
        this.fanIconUrl = "";
        this.fansMedalBgImgStyle = "";
        this.diamondMedalBgImgStyle = "";
        this.enterRoomTips = "";
        this.suspectUrl = "";
        this.avatarStaticPendantUrl = "";
        this.avatarDynamicPendantUrl = "";
    }

    public static UserCardInfo from(d dVar) {
        h[] hVarArr;
        if (dVar == null) {
            return null;
        }
        UserCardInfo userCardInfo = new UserCardInfo();
        i iVar = dVar.f432104a;
        if (iVar != null) {
            userCardInfo.uid = iVar.f432126a;
            userCardInfo.nick = iVar.f432127b;
            userCardInfo.sex = iVar.f432128c;
            userCardInfo.headUrl = iVar.f432129d;
            userCardInfo.hometown = iVar.f432130e;
            userCardInfo.explicitUid = iVar.f432131f;
            userCardInfo.signature = iVar.f432132g;
            userCardInfo.f271218qq = iVar.f432133h;
            userCardInfo.circleId = iVar.f432134i;
        }
        b bVar = dVar.f432105b;
        if (bVar != null) {
            userCardInfo.fansNum = bVar.f432097b;
            userCardInfo.followNum = bVar.f432096a;
            userCardInfo.isFollow = bVar.f432098c;
        }
        userCardInfo.showGift = dVar.f432109f;
        g[] gVarArr = dVar.f432106c;
        if (gVarArr != null && gVarArr.length > 0) {
            userCardInfo.medalInfoNews = Arrays.asList(gVarArr);
        }
        userCardInfo.enterRoomTips = dVar.f432112i;
        userCardInfo.suspectUrl = dVar.f432113j;
        f fVar = dVar.f432114k;
        if (fVar != null) {
            userCardInfo.avatarStaticPendantUrl = fVar.f432118a;
            userCardInfo.avatarDynamicPendantUrl = fVar.f432119b;
            userCardInfo.avatarPendantResources = fVar.f432120c;
        }
        f fVar2 = dVar.f432115l;
        if (fVar2 != null && (hVarArr = fVar2.f432120c) != null) {
            userCardInfo.skinInfo = SkinInfo.parseFrom(hVarArr);
        }
        return userCardInfo;
    }

    public void copyFrom(UserCardInfo userCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) userCardInfo);
            return;
        }
        this.uid = userCardInfo.uid;
        this.nick = userCardInfo.nick;
        this.sex = userCardInfo.sex;
        this.headUrl = userCardInfo.headUrl;
        this.hometown = userCardInfo.hometown;
        this.explicitUid = userCardInfo.explicitUid;
        this.signature = userCardInfo.signature;
        this.f271218qq = userCardInfo.f271218qq;
        this.fansNum = userCardInfo.fansNum;
        this.followNum = userCardInfo.followNum;
        this.isFollow = userCardInfo.isFollow;
        this.showGift = userCardInfo.showGift;
        this.medalInfoNews = userCardInfo.medalInfoNews;
        this.enterRoomTips = userCardInfo.enterRoomTips;
        this.suspectUrl = userCardInfo.suspectUrl;
        this.circleId = userCardInfo.circleId;
        this.avatarStaticPendantUrl = userCardInfo.avatarStaticPendantUrl;
        this.avatarDynamicPendantUrl = userCardInfo.avatarDynamicPendantUrl;
        this.avatarPendantResources = userCardInfo.avatarPendantResources;
        SkinInfo skinInfo = userCardInfo.skinInfo;
        if (skinInfo != null) {
            this.skinInfo = SkinInfo.copyFrom(skinInfo);
        } else {
            this.skinInfo = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.data.user.LiveUserInfo
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "UserCardInfo{explicitUid=" + this.explicitUid + ", clientType=" + this.clientType + ", fromAppName='" + this.fromAppName + "', uid=" + this.uid + ", circleId='" + this.circleId + "', headUrl='" + this.headUrl + "', nick='" + this.nick + "', hometown='" + this.hometown + "', signature='" + this.signature + "', followNum='" + this.followNum + "', nick='" + this.nick + "', isFollow=" + this.isFollow + ", avatarStaticPendantUrl=" + this.avatarStaticPendantUrl + ", avatarDynamicPendantUrl=" + this.avatarDynamicPendantUrl + ", userCardSkinInfo=" + this.skinInfo + '}';
    }
}
