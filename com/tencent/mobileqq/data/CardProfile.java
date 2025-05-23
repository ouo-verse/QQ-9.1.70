package com.tencent.mobileqq.data;

import QQService.UserProfile;
import QQService.VipBaseInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.en;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.Comparator;

@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "lEctID,type")
/* loaded from: classes10.dex */
public class CardProfile extends Entity {
    public static final int TYPE_FAVORITE = 3;
    public static final int TYPE_VISITOR = 1;
    public static final int TYPE_VOTER = 2;
    public byte bAage;
    public long bAvailableCnt;
    public byte bCloseNeighborVote;
    public byte bFavorite;
    public byte bFavoritedMe;
    public short bIsLastVoteCharged;
    public byte bMutualFriends;
    public byte bSex;
    public byte bSingle;
    public long bTodayVotedCnt;
    public byte bVote;
    public short bVoteCnt;
    public long dwLikeCustomId;
    public int eUserIdentityType;
    public long lEctID;
    public int lTime;
    public int nFaceNum;
    public short payVoteCount;
    public short shIntroType;
    public String strNick;
    public long uSource;
    public byte[] vFaceID;
    public byte[] vIntroContent;
    public short wFace;
    public byte[] vRichSign = null;
    public byte bConstellation = 0;
    public VipBaseInfo stVipInfo = null;
    public int type = 1;
    public byte[] vC2CSign = null;

    @notColumn
    public String strTime = "";

    @notColumn
    public boolean isFriend = false;

    /* loaded from: classes10.dex */
    public static class CardProfileComparator implements Comparator<CardProfile> {
        @Override // java.util.Comparator
        public int compare(CardProfile cardProfile, CardProfile cardProfile2) {
            return cardProfile2.lTime - cardProfile.lTime;
        }
    }

    public static String tableName() {
        return "CardProfilev4";
    }

    public String getSimpleZanInfo() {
        return "zanInfo:,uin" + ContainerUtils.KEY_VALUE_DELIMITER + this.lEctID + ",t" + ContainerUtils.KEY_VALUE_DELIMITER + this.type + "," + DomainData.DOMAIN_NAME + ContainerUtils.KEY_VALUE_DELIMITER + this.strNick + ",bVC" + ContainerUtils.KEY_VALUE_DELIMITER + ((int) this.bVoteCnt) + ",bAailC" + ContainerUtils.KEY_VALUE_DELIMITER + this.bAvailableCnt + ",bTVC" + ContainerUtils.KEY_VALUE_DELIMITER + this.bTodayVotedCnt + ",bClose" + ContainerUtils.KEY_VALUE_DELIMITER + ((int) this.bCloseNeighborVote) + ",bCharged" + ContainerUtils.KEY_VALUE_DELIMITER + ((int) this.bIsLastVoteCharged) + ",payVC" + ContainerUtils.KEY_VALUE_DELIMITER + ((int) this.payVoteCount) + ",bMutual" + ContainerUtils.KEY_VALUE_DELIMITER + ((int) this.bMutualFriends);
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return tableName();
    }

    public void readFrom(UserProfile userProfile) {
        this.bAage = userProfile.bAge;
        this.bFavorite = userProfile.bFavorited;
        this.bFavoritedMe = userProfile.bFavoritedMe;
        this.bSex = userProfile.bSex;
        this.bSingle = userProfile.bSingle;
        this.bVote = userProfile.bVote;
        this.eUserIdentityType = userProfile.eUserIdentityType;
        this.lEctID = userProfile.lEctID;
        int i3 = userProfile.lTime;
        this.lTime = i3;
        this.nFaceNum = userProfile.nFaceNum;
        this.shIntroType = userProfile.shIntroType;
        this.strNick = userProfile.strNick;
        this.vFaceID = userProfile.vFaceID;
        this.vIntroContent = userProfile.vIntroContent;
        this.wFace = userProfile.wFace;
        this.vRichSign = userProfile.vRichSign;
        this.bConstellation = userProfile.bConstellation;
        this.stVipInfo = userProfile.stVipInfo;
        this.vC2CSign = userProfile.vC2CSign;
        this.bVoteCnt = userProfile.bVoteCnt;
        this.bAvailableCnt = userProfile.bAvailableCnt;
        this.bTodayVotedCnt = userProfile.bTodayVotedCnt;
        if (i3 > 0) {
            this.strTime = en.p(i3 * 1000, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        }
        this.uSource = userProfile.uSource;
        this.bCloseNeighborVote = (byte) userProfile.bCloseNeighborVote;
        this.dwLikeCustomId = userProfile.dwLikeCustomId;
        this.bIsLastVoteCharged = userProfile.bIsLastVoteCharged;
        this.payVoteCount = userProfile.bTollVoteCnt;
        this.bMutualFriends = (byte) userProfile.bMutualFriends;
    }

    public String toString() {
        return "CardProfile,lEctID:" + this.lEctID + ",strNick:" + this.strNick + ",bVC:" + ((int) this.bVoteCnt) + ",bAailC:" + this.bAvailableCnt + ",bTVC:" + this.bTodayVotedCnt + ",bClose:" + ((int) this.bCloseNeighborVote) + ",strTime:" + this.strTime + ",type:" + this.type + ",bMutual" + ContainerUtils.KEY_VALUE_DELIMITER + ((int) this.bMutualFriends);
    }

    public void updateTime(long j3) {
        this.lTime = (int) j3;
        this.strTime = en.p(j3 * 1000, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CardProfile m167clone() {
        CardProfile cardProfile = new CardProfile();
        cardProfile.bAage = this.bAage;
        cardProfile.bFavorite = this.bFavorite;
        cardProfile.bFavoritedMe = this.bFavoritedMe;
        cardProfile.bSex = this.bSex;
        cardProfile.bSingle = this.bSingle;
        cardProfile.bVote = this.bVote;
        cardProfile.eUserIdentityType = this.eUserIdentityType;
        cardProfile.lEctID = this.lEctID;
        cardProfile.lTime = this.lTime;
        cardProfile.bConstellation = this.bConstellation;
        cardProfile.stVipInfo = this.stVipInfo;
        cardProfile.type = this.type;
        cardProfile.nFaceNum = this.nFaceNum;
        cardProfile.shIntroType = this.shIntroType;
        cardProfile.strNick = this.strNick;
        cardProfile.vFaceID = this.vFaceID;
        cardProfile.vIntroContent = this.vIntroContent;
        cardProfile.wFace = this.wFace;
        cardProfile.vC2CSign = this.vC2CSign;
        cardProfile.bVoteCnt = this.bVoteCnt;
        cardProfile.uSource = this.uSource;
        cardProfile.bAvailableCnt = this.bAvailableCnt;
        cardProfile.bTodayVotedCnt = this.bTodayVotedCnt;
        cardProfile.bCloseNeighborVote = this.bCloseNeighborVote;
        cardProfile.bMutualFriends = this.bMutualFriends;
        cardProfile.dwLikeCustomId = this.dwLikeCustomId;
        cardProfile.bIsLastVoteCharged = this.bIsLastVoteCharged;
        cardProfile.vRichSign = this.vRichSign;
        int i3 = this.lTime;
        if (i3 > 0) {
            cardProfile.strTime = en.p(i3 * 1000, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        }
        return cardProfile;
    }
}
