package com.tencent.mobileqq.gamecenter.msginfo;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameBasicInfo extends Entity {
    public static final String COMMON_PRE = "GameCenterMsg.";
    public static final String TAG = "GameCenterMsg.GameBasicInfo";

    @unique
    public String mAppId;
    public String mIconUrl;
    public int mMsgMaxLen;
    public String mName;
    public String mStartGameUrl;
    public long mUpdateTs;

    public static String getDefaultGameLaunchUrl(String str) {
        return "https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=" + str + "&_wv=2164260896&_wwv=448&autodownload=1&autolaunch=1&autosubscribe=1&ADTAG=youxixiaoxi";
    }
}
