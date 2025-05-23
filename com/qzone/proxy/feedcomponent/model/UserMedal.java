package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_medal;
import NS_MOBILE_FEEDS.s_user;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageUrl;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UserMedal implements SmartParcelable {

    @NeedParcel
    public ImageUrl imageUrl;

    @NeedParcel
    public int level;

    @NeedParcel
    public int medalId;

    @NeedParcel
    public int medalState;

    @NeedParcel
    public int medalType;

    @NeedParcel
    public long userTypeReport;

    @NeedParcel
    public String picUrl = "";

    @NeedParcel
    public String jumpUrl = "";

    public static UserMedal create(s_user s_userVar) {
        if (s_userVar == null || s_userVar.medalInfo == null) {
            return null;
        }
        UserMedal userMedal = new UserMedal();
        s_medal s_medalVar = s_userVar.medalInfo;
        userMedal.medalType = s_medalVar.medal_type;
        userMedal.medalState = s_medalVar.medal_state;
        userMedal.level = s_medalVar.level;
        String str = s_medalVar.pic_url;
        userMedal.picUrl = str;
        userMedal.imageUrl = PictureUrl.calculateImageUrl(str);
        s_medal s_medalVar2 = s_userVar.medalInfo;
        userMedal.jumpUrl = s_medalVar2.jump_url;
        userMedal.medalId = s_medalVar2.medal_id;
        return userMedal;
    }

    public static UserMedal createFamousSpaceMedal(s_user s_userVar) {
        if (s_userVar == null || s_userVar.authqzoneMedalInfo == null) {
            return null;
        }
        UserMedal userMedal = new UserMedal();
        s_medal s_medalVar = s_userVar.authqzoneMedalInfo;
        userMedal.medalType = s_medalVar.medal_type;
        userMedal.medalState = s_medalVar.medal_state;
        userMedal.level = s_medalVar.level;
        String str = s_medalVar.pic_url;
        userMedal.picUrl = str;
        userMedal.imageUrl = PictureUrl.calculateImageUrl(str);
        s_medal s_medalVar2 = s_userVar.authqzoneMedalInfo;
        userMedal.jumpUrl = s_medalVar2.jump_url;
        userMedal.userTypeReport = s_userVar.iCurUserType;
        userMedal.medalId = s_medalVar2.medal_id;
        return userMedal;
    }

    public static UserMedal createLiveMedal(s_user s_userVar) {
        if (s_userVar == null || s_userVar.liveshowMedalInfo == null) {
            return null;
        }
        UserMedal userMedal = new UserMedal();
        s_medal s_medalVar = s_userVar.liveshowMedalInfo;
        userMedal.medalType = s_medalVar.medal_type;
        userMedal.medalState = s_medalVar.medal_state;
        userMedal.level = s_medalVar.level;
        String str = s_medalVar.pic_url;
        userMedal.picUrl = str;
        userMedal.imageUrl = PictureUrl.calculateImageUrl(str);
        s_medal s_medalVar2 = s_userVar.liveshowMedalInfo;
        userMedal.jumpUrl = s_medalVar2.jump_url;
        userMedal.medalId = s_medalVar2.medal_id;
        return userMedal;
    }
}
