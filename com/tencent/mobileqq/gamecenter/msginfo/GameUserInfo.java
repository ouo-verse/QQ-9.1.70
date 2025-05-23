package com.tencent.mobileqq.gamecenter.msginfo;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameUserInfo extends Entity {
    public static final String TAG = "GameCenterMsg.GameUserInfo";
    public String growthRankUrl;
    public String growthRankUrlJump;
    public String mAppId;
    public String mFaceUrl;
    public String mLevelPic;
    public String mLevelText;
    public String mNickInGame;
    public String mOnLineDesc;
    public int mOnlineType;
    public String mPartitioName;

    @unique
    public String mRoleId;
    public long mSaveTs;
    public int mSex;
    public int mSwitchInGame;
    public String mUin;
    public long mUpdateTs;
    public String mVipRankUrl;
    public String medalUrl;
    public String medalUrlJump;

    public static boolean isUsrInfoUpdate(GameUserInfo gameUserInfo, GameUserInfo gameUserInfo2) {
        if (gameUserInfo != null && gameUserInfo.mUpdateTs == gameUserInfo2.mUpdateTs) {
            return false;
        }
        return true;
    }

    public void print() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " roleId:" + this.mRoleId + ",appid:" + this.mAppId + ",onlineType:" + this.mOnlineType + ",sex:" + this.mSex + ",ts:" + this.mUpdateTs + ",nick:" + this.mNickInGame + ",faceUrl:" + this.mFaceUrl + ",partName:" + this.mPartitioName + ",levelPic:" + this.mLevelPic + ",levelText:" + this.mLevelText + ",saveTs:" + this.mSaveTs + ",switchInGame:" + this.mSwitchInGame + ",onlineDesc:" + this.mOnLineDesc + "vipRank:" + this.mVipRankUrl + "growthRankUrl:" + this.growthRankUrl + "growthRankUrlJump:" + this.growthRankUrlJump + "medalUrl:" + this.medalUrl + "medalUrlJump:" + this.medalUrlJump);
        }
    }
}
