package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildUserProfile {
    public byte age;
    public GProUserAllGiftInfo allGiftInfo;
    public int allowCommentToMe;
    public String avatarMeta;
    public String avatarPendant;
    public ArrayList<GProClientAccount> bindClientAccount;
    public short birthDay;
    public short birthMonth;
    public short birthYear;
    public String city;
    public int cityId;
    public int cityZoneId;
    public ArrayList<GProClientArchive> clientArchives;
    public GProClientIdentity clientIdentity;
    public GProClientPresence clientPresence;
    public String constellation;
    public String country;
    public int countryId;
    public int directMsgBlackFlag;
    public int faceAuthStatus;
    public GProArchiveArkData firstArchiveArkData;
    public int gender;
    public boolean hasGuildUserInfo;
    public boolean hasMoreArchive;
    public int isMember;
    public boolean isNlAge;
    public boolean isQQFriend;
    public long joinGroupProTimeStamp;
    public long joinTime;
    public int joinedGuildShowSwitch;
    public GProUserJoinedGuildSummary joinedGuildSummary;
    public ArrayList<GProMedal> medals;
    public String memberName;
    public String nick;
    public String openId;
    public String personalSignature;
    public String province;
    public int provinceId;
    public int publishedFeedShowSwitch;
    public GProUserPublishedFeedSummary publishedFeedSummary;
    public int robotType;
    public GProProfileRoomState roomState;
    public int roomStateShowSwitch;
    public long shutUpExpireTime;
    public GProSignGuildInfo signGuildInfo;
    public String skinPicUrl;
    public long tinyId;
    public long uin;
    public int userType;
    public int verifyFriType;
    public String verifyUrl;

    public GProGuildUserProfile() {
        this.nick = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.memberName = "";
        this.clientPresence = new GProClientPresence();
        this.clientArchives = new ArrayList<>();
        this.bindClientAccount = new ArrayList<>();
        this.firstArchiveArkData = new GProArchiveArkData();
        this.avatarMeta = "";
        this.verifyUrl = "";
        this.openId = "";
        this.avatarPendant = "";
        this.medals = new ArrayList<>();
        this.joinedGuildSummary = new GProUserJoinedGuildSummary();
        this.publishedFeedSummary = new GProUserPublishedFeedSummary();
        this.clientIdentity = new GProClientIdentity();
        this.signGuildInfo = new GProSignGuildInfo();
        this.allGiftInfo = new GProUserAllGiftInfo();
    }

    public byte getAge() {
        return this.age;
    }

    public GProUserAllGiftInfo getAllGiftInfo() {
        return this.allGiftInfo;
    }

    public int getAllowCommentToMe() {
        return this.allowCommentToMe;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public ArrayList<GProClientAccount> getBindClientAccount() {
        return this.bindClientAccount;
    }

    public short getBirthDay() {
        return this.birthDay;
    }

    public short getBirthMonth() {
        return this.birthMonth;
    }

    public short getBirthYear() {
        return this.birthYear;
    }

    public String getCity() {
        return this.city;
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getCityZoneId() {
        return this.cityZoneId;
    }

    public ArrayList<GProClientArchive> getClientArchives() {
        return this.clientArchives;
    }

    public GProClientIdentity getClientIdentity() {
        return this.clientIdentity;
    }

    public GProClientPresence getClientPresence() {
        return this.clientPresence;
    }

    public String getConstellation() {
        return this.constellation;
    }

    public String getCountry() {
        return this.country;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public int getDirectMsgBlackFlag() {
        return this.directMsgBlackFlag;
    }

    public int getFaceAuthStatus() {
        return this.faceAuthStatus;
    }

    public GProArchiveArkData getFirstArchiveArkData() {
        return this.firstArchiveArkData;
    }

    public int getGender() {
        return this.gender;
    }

    public boolean getHasGuildUserInfo() {
        return this.hasGuildUserInfo;
    }

    public boolean getHasMoreArchive() {
        return this.hasMoreArchive;
    }

    public int getIsMember() {
        return this.isMember;
    }

    public boolean getIsNlAge() {
        return this.isNlAge;
    }

    public boolean getIsQQFriend() {
        return this.isQQFriend;
    }

    public long getJoinGroupProTimeStamp() {
        return this.joinGroupProTimeStamp;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public int getJoinedGuildShowSwitch() {
        return this.joinedGuildShowSwitch;
    }

    public GProUserJoinedGuildSummary getJoinedGuildSummary() {
        return this.joinedGuildSummary;
    }

    public ArrayList<GProMedal> getMedals() {
        return this.medals;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public String getNick() {
        return this.nick;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getPersonalSignature() {
        return this.personalSignature;
    }

    public String getProvince() {
        return this.province;
    }

    public int getProvinceId() {
        return this.provinceId;
    }

    public int getPublishedFeedShowSwitch() {
        return this.publishedFeedShowSwitch;
    }

    public GProUserPublishedFeedSummary getPublishedFeedSummary() {
        return this.publishedFeedSummary;
    }

    public int getRobotType() {
        return this.robotType;
    }

    public GProProfileRoomState getRoomState() {
        return this.roomState;
    }

    public int getRoomStateShowSwitch() {
        return this.roomStateShowSwitch;
    }

    public long getShutUpExpireTime() {
        return this.shutUpExpireTime;
    }

    public GProSignGuildInfo getSignGuildInfo() {
        return this.signGuildInfo;
    }

    public String getSkinPicUrl() {
        return this.skinPicUrl;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public long getUin() {
        return this.uin;
    }

    public int getUserType() {
        return this.userType;
    }

    public int getVerifyFriType() {
        return this.verifyFriType;
    }

    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "GProGuildUserProfile{uin=" + this.uin + ",tinyId=" + this.tinyId + ",nick=" + this.nick + ",verifyFriType=" + this.verifyFriType + ",gender=" + this.gender + ",isNlAge=" + this.isNlAge + ",age=" + ((int) this.age) + ",birthYear=" + ((int) this.birthYear) + ",birthMonth=" + ((int) this.birthMonth) + ",birthDay=" + ((int) this.birthDay) + ",country=" + this.country + ",province=" + this.province + ",city=" + this.city + ",countryId=" + this.countryId + ",provinceId=" + this.provinceId + ",cityId=" + this.cityId + ",cityZoneId=" + this.cityZoneId + ",userType=" + this.userType + ",joinTime=" + this.joinTime + ",robotType=" + this.robotType + ",memberName=" + this.memberName + ",clientPresence=" + this.clientPresence + ",clientArchives=" + this.clientArchives + ",bindClientAccount=" + this.bindClientAccount + ",hasMoreArchive=" + this.hasMoreArchive + ",firstArchiveArkData=" + this.firstArchiveArkData + ",isMember=" + this.isMember + ",directMsgBlackFlag=" + this.directMsgBlackFlag + ",shutUpExpireTime=" + this.shutUpExpireTime + ",hasGuildUserInfo=" + this.hasGuildUserInfo + ",joinGroupProTimeStamp=" + this.joinGroupProTimeStamp + ",avatarMeta=" + this.avatarMeta + ",faceAuthStatus=" + this.faceAuthStatus + ",verifyUrl=" + this.verifyUrl + ",constellation=" + this.constellation + ",personalSignature=" + this.personalSignature + ",roomState=" + this.roomState + ",isQQFriend=" + this.isQQFriend + ",roomStateShowSwitch=" + this.roomStateShowSwitch + ",publishedFeedShowSwitch=" + this.publishedFeedShowSwitch + ",joinedGuildShowSwitch=" + this.joinedGuildShowSwitch + ",openId=" + this.openId + ",skinPicUrl=" + this.skinPicUrl + ",avatarPendant=" + this.avatarPendant + ",medals=" + this.medals + ",joinedGuildSummary=" + this.joinedGuildSummary + ",publishedFeedSummary=" + this.publishedFeedSummary + ",clientIdentity=" + this.clientIdentity + ",signGuildInfo=" + this.signGuildInfo + ",allGiftInfo=" + this.allGiftInfo + ",allowCommentToMe=" + this.allowCommentToMe + ",}";
    }

    public GProGuildUserProfile(long j3, long j16, String str, int i3, int i16, boolean z16, byte b16, short s16, short s17, short s18, String str2, String str3, String str4, int i17, int i18, int i19, int i26, int i27, long j17, int i28, String str5, GProClientPresence gProClientPresence, ArrayList<GProClientArchive> arrayList, ArrayList<GProClientAccount> arrayList2, boolean z17, GProArchiveArkData gProArchiveArkData, int i29, int i36, long j18, boolean z18, long j19, String str6, int i37, String str7, String str8, String str9, GProProfileRoomState gProProfileRoomState, boolean z19, int i38, int i39, int i46, String str10, String str11, String str12, ArrayList<GProMedal> arrayList3, GProUserJoinedGuildSummary gProUserJoinedGuildSummary, GProUserPublishedFeedSummary gProUserPublishedFeedSummary, GProClientIdentity gProClientIdentity, GProSignGuildInfo gProSignGuildInfo, GProUserAllGiftInfo gProUserAllGiftInfo) {
        this.nick = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.memberName = "";
        this.clientPresence = new GProClientPresence();
        this.clientArchives = new ArrayList<>();
        this.bindClientAccount = new ArrayList<>();
        this.firstArchiveArkData = new GProArchiveArkData();
        this.avatarMeta = "";
        this.verifyUrl = "";
        this.openId = "";
        this.avatarPendant = "";
        this.medals = new ArrayList<>();
        this.joinedGuildSummary = new GProUserJoinedGuildSummary();
        this.publishedFeedSummary = new GProUserPublishedFeedSummary();
        this.clientIdentity = new GProClientIdentity();
        this.signGuildInfo = new GProSignGuildInfo();
        new GProUserAllGiftInfo();
        this.uin = j3;
        this.tinyId = j16;
        this.nick = str;
        this.verifyFriType = i3;
        this.gender = i16;
        this.isNlAge = z16;
        this.age = b16;
        this.birthYear = s16;
        this.birthMonth = s17;
        this.birthDay = s18;
        this.country = str2;
        this.province = str3;
        this.city = str4;
        this.countryId = i17;
        this.provinceId = i18;
        this.cityId = i19;
        this.cityZoneId = i26;
        this.userType = i27;
        this.joinTime = j17;
        this.robotType = i28;
        this.memberName = str5;
        this.clientPresence = gProClientPresence;
        this.clientArchives = arrayList;
        this.bindClientAccount = arrayList2;
        this.hasMoreArchive = z17;
        this.firstArchiveArkData = gProArchiveArkData;
        this.isMember = i29;
        this.directMsgBlackFlag = i36;
        this.shutUpExpireTime = j18;
        this.hasGuildUserInfo = z18;
        this.joinGroupProTimeStamp = j19;
        this.avatarMeta = str6;
        this.faceAuthStatus = i37;
        this.verifyUrl = str7;
        this.constellation = str8;
        this.personalSignature = str9;
        this.roomState = gProProfileRoomState;
        this.isQQFriend = z19;
        this.roomStateShowSwitch = i38;
        this.publishedFeedShowSwitch = i39;
        this.joinedGuildShowSwitch = i46;
        this.openId = str10;
        this.skinPicUrl = str11;
        this.avatarPendant = str12;
        this.medals = arrayList3;
        this.joinedGuildSummary = gProUserJoinedGuildSummary;
        this.publishedFeedSummary = gProUserPublishedFeedSummary;
        this.clientIdentity = gProClientIdentity;
        this.signGuildInfo = gProSignGuildInfo;
        this.allGiftInfo = gProUserAllGiftInfo;
    }
}
