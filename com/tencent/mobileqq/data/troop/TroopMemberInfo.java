package com.tencent.mobileqq.data.troop;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopMemberInfo implements Serializable {
    public static final long VALUE_DISTANCE_TO_SELF_UNKOWN = -100;
    protected static final int VALUE_INVALID = -100;
    public static final long VALUE_MEMBER_CLOSE_SHARE_LBS = -1001;
    public int addState;

    @Deprecated(since = "\u63a8\u8350\u4f7f\u7528TroopMemberNickInfo")
    public String autoremark;
    public long credit_level;
    public String displayedNamePinyinFirst;

    @Nullable
    public TroopMemberInfoExt extInfo;
    public int flagEx = 0;

    @Deprecated(since = "\u63a8\u8350\u4f7f\u7528TroopMemberNickInfo")
    public String friendnick;
    public long gagTimeStamp;
    public String honorList;
    public boolean isTroopFollowed;
    public long join_time;
    public long last_active_time;
    public int mBigClubVipType;
    public byte mHonorRichFlag;
    public boolean mIsShielded;
    public int mVipType;
    public String memberUid;
    public String memberuin;
    public TroopMemberNickInfo nickInfo;
    public int realLevel;
    public MemberRole role;

    @Nullable
    public TroopMemberSpecialTitleInfo specialTitleInfo;
    public int titleId;

    @Deprecated(since = "\u63a8\u8350\u4f7f\u7528TroopMemberNickInfo")
    public String troopColorNick;

    @Deprecated(since = "\u63a8\u8350\u4f7f\u7528TroopMemberNickInfo")
    public int troopColorNickId;

    @Deprecated(since = "\u63a8\u8350\u4f7f\u7528TroopMemberNickInfo")
    public String troopnick;
    public String troopuin;

    public TroopMemberInfo(String str, String str2) {
        this.troopuin = str;
        this.memberuin = str2;
    }

    public int getCommonFrdCnt() {
        TroopMemberInfoExt troopMemberInfoExt = this.extInfo;
        if (troopMemberInfoExt == null) {
            return Integer.MIN_VALUE;
        }
        return troopMemberInfoExt.commonFrdCnt;
    }

    public int getHWIdentity() {
        TroopMemberInfoExt troopMemberInfoExt = this.extInfo;
        if (troopMemberInfoExt == null) {
            return 0;
        }
        return troopMemberInfoExt.hwIdentity;
    }

    public long getLastMsgUpdateHonorRichTime() {
        TroopMemberInfoExt troopMemberInfoExt = this.extInfo;
        if (troopMemberInfoExt == null) {
            return 0L;
        }
        return troopMemberInfoExt.lastMsgUpdateHonorRichTime;
    }

    @Nullable
    public String getSpecialTitleStr() {
        TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = this.specialTitleInfo;
        if (troopMemberSpecialTitleInfo != null) {
            return troopMemberSpecialTitleInfo.getSpecialTitle();
        }
        return "";
    }

    public boolean isValidMember() {
        MemberRole memberRole = this.role;
        if (memberRole != null && memberRole != MemberRole.UNSPECIFIED && memberRole != MemberRole.STRANGER) {
            return true;
        }
        return false;
    }

    public boolean noCommonFrdCnt() {
        if (getCommonFrdCnt() < 0) {
            return true;
        }
        return false;
    }

    public void setCommonFrdCnt(int i3) {
        if (this.extInfo == null) {
            this.extInfo = new TroopMemberInfoExt();
        }
        this.extInfo.commonFrdCnt = i3;
    }

    public String toString() {
        return "TroopMemberInfo{, troopuin='" + this.troopuin + "', memberuin='" + this.memberuin + "', role='" + this.role + "', displayedNamePinyinFirst='" + this.displayedNamePinyinFirst + "', friendnick='" + ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fuzzyLog(this.friendnick) + "', troopnick='" + ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fuzzyLog(this.troopnick) + "', level=" + this.titleId + ", newRealLevel" + this.realLevel + ", join_time=" + this.join_time + ", last_active_time=" + this.last_active_time + ", credit_level=" + this.credit_level + ", isTroopFollowed=" + this.isTroopFollowed + ", gagTimeStamp=" + this.gagTimeStamp + ", mIsShielded=" + this.mIsShielded + ", mVipType=" + this.mVipType + ", honorList=" + this.honorList + ", troopColorNickId=" + this.troopColorNickId + '}';
    }

    public void updatePinyin(TroopMemberNickUIInfo troopMemberNickUIInfo) {
        this.nickInfo.updatePinyin(troopMemberNickUIInfo);
        if (this.extInfo == null) {
            this.extInfo = new TroopMemberInfoExt();
        }
        this.extInfo.updatePinyin(troopMemberNickUIInfo);
    }
}
