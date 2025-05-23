package com.tencent.trpcprotocol.friends;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes10.dex */
public final class ProfileUpdateMsg$UpdateData extends MessageMicro<ProfileUpdateMsg$UpdateData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8002, MessageHandlerConstants.NOTIFY_TYPE_MSG_REVOKE_RSP, 165602, 192002, 192802, 193602, 216002, 224002, 232002}, new String[]{"uid", "uin", "intimate", "coreInfo", "baseInfo", "baseExtInfo", "relationFalgs", "vasInfo", "otherFlags"}, new Object[]{"", 0L, null, null, null, null, null, null, null}, ProfileUpdateMsg$UpdateData.class);
    public final PBStringField uid = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public ProfileUpdateMsg$updateIntimate intimate = new MessageMicro<ProfileUpdateMsg$updateIntimate>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$updateIntimate
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{165608, 165616, 248002}, new String[]{"iconFlag", "ssListenTogetherOpen", QCircleDaTongConstant.ElementParamValue.MUTUAL}, new Object[]{0, Boolean.FALSE, null}, ProfileUpdateMsg$updateIntimate.class);
        public final PBUInt32Field iconFlag = PBField.initUInt32(0);
        public final PBBoolField ssListenTogetherOpen = PBField.initBool(false);
        public final PBRepeatMessageField<ProfileUpdateMsg$updateMutualMark> mutual = PBField.initRepeatMessage(ProfileUpdateMsg$updateMutualMark.class);
    };
    public ProfileUpdateMsg$updateCoreInfo coreInfo = new MessageMicro<ProfileUpdateMsg$updateCoreInfo>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$updateCoreInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{160018, 160074}, new String[]{"nick", "remark"}, new Object[]{"", ""}, ProfileUpdateMsg$updateCoreInfo.class);
        public final PBStringField nick = PBField.initString("");
        public final PBStringField remark = PBField.initString("");
    };
    public ProfileUpdateMsg$updateBaseInfo baseInfo = new MessageMicro<ProfileUpdateMsg$updateBaseInfo>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$updateBaseInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8010, 160048, 160056, 160064, 160090, 160112, 160194, 160202, 160384, 192824, 192832, 192842}, new String[]{"qid", "birthdayYear", "birthdayMonth", "birthdayDay", "longNick", "gender", "eMail", "phoneNum", "categoryId", "age", "richTime", "richBuffer"}, new Object[]{"", 0, 0, 0, "", 0, "", "", 0, 0, 0, ByteStringMicro.EMPTY}, ProfileUpdateMsg$updateBaseInfo.class);
        public final PBUInt32Field age = PBField.initUInt32(0);
        public final PBStringField qid = PBField.initString("");
        public final PBStringField longNick = PBField.initString("");
        public final PBUInt32Field birthdayYear = PBField.initUInt32(0);
        public final PBUInt32Field birthdayMonth = PBField.initUInt32(0);
        public final PBUInt32Field birthdayDay = PBField.initUInt32(0);
        public final PBInt32Field gender = PBField.initInt32(0);
        public final PBStringField eMail = PBField.initString("");
        public final PBStringField phoneNum = PBField.initString("");
        public final PBUInt32Field categoryId = PBField.initUInt32(0);
        public final PBUInt32Field richTime = PBField.initUInt32(0);
        public final PBBytesField richBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public ProfileUpdateMsg$updateBaseExt baseExtInfo = new MessageMicro<ProfileUpdateMsg$updateBaseExt>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$updateBaseExt
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{160144, 160152, 160160, 160170, 160176, 160184, 160210, 160218, 160226, 160234, 160242, 160290, 160304, 160314, 160330, 163208, 163216, 163224, 163232}, new String[]{LpReport_UserInfo_dc02148.CONSTELLATION, "shengXiao", "kBloodType", "homeTown", "makeFriendCareer", c.G, IProfileProtocolConst.KEY_COLLEGE, "country", "province", "postCode", "address", "city", "regTime", "interest", "labels", "crownNum", "sunNum", "moonNum", "starNum"}, new Object[]{0, 0, 0, "", 0, 0, "", "", "", "", "", "", 0, "", "", 0, 0, 0, 0}, ProfileUpdateMsg$updateBaseExt.class);
        public final PBInt32Field crownNum = PBField.initInt32(0);
        public final PBInt32Field sunNum = PBField.initInt32(0);
        public final PBInt32Field moonNum = PBField.initInt32(0);
        public final PBInt32Field starNum = PBField.initInt32(0);
        public final PBUInt32Field constellation = PBField.initUInt32(0);
        public final PBUInt32Field shengXiao = PBField.initUInt32(0);
        public final PBUInt32Field kBloodType = PBField.initUInt32(0);
        public final PBStringField homeTown = PBField.initString("");
        public final PBUInt32Field makeFriendCareer = PBField.initUInt32(0);
        public final PBUInt32Field pos = PBField.initUInt32(0);
        public final PBStringField college = PBField.initString("");
        public final PBStringField country = PBField.initString("");
        public final PBStringField province = PBField.initString("");
        public final PBStringField city = PBField.initString("");
        public final PBStringField postCode = PBField.initString("");
        public final PBStringField address = PBField.initString("");
        public final PBUInt32Field regTime = PBField.initUInt32(0);
        public final PBStringField interest = PBField.initString("");
        public final PBRepeatField<String> labels = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public ProfileUpdateMsg$updateRelationFlags relationFalgs = new MessageMicro<ProfileUpdateMsg$updateRelationFlags>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$updateRelationFlags
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt64Field topTime = PBField.initUInt64(0);
        public final PBBoolField isBlock = PBField.initBool(false);
        public final PBBoolField isBlocked = PBField.initBool(false);
        public final PBBoolField isMsgDisturb = PBField.initBool(false);
        public final PBBoolField isSpecialCareOpen = PBField.initBool(false);
        public final PBBoolField isSpecialCareZone = PBField.initBool(false);
        public final PBStringField ringId = PBField.initString("");
        public final PBUInt32Field recommendImgFlag = PBField.initUInt32(0);
        public final PBUInt32Field qidianMasterFlag = PBField.initUInt32(0);
        public final PBUInt32Field qidianCrewFlag = PBField.initUInt32(0);
        public final PBUInt32Field qidianCrewFlag2 = PBField.initUInt32(0);
        public final PBBoolField isHideSession = PBField.initBool(false);
        public final PBStringField c2cRingId = PBField.initString("");
        public final PBBytesField notifyFlag = PBField.initBytes(ByteStringMicro.EMPTY);

        static {
            String[] strArr = {"topTime", "isBlock", "isMsgDisturb", "isSpecialCareOpen", "isSpecialCareZone", VipFunCallConstants.KEY_RING_ID, "recommendImgFlag", "qidianMasterFlag", "qidianCrewFlag", "qidianCrewFlag2", "isBlocked", "isHideSession", "c2cRingId", "notifyFlag"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{160120, 160248, 160256, 160264, 160272, 160282, 160464, 160640, 160648, 160656, 216008, 216016, 216026, 216034}, strArr, new Object[]{0L, bool, bool, bool, bool, "", 0, 0, 0, 0, bool, bool, "", ByteStringMicro.EMPTY}, ProfileUpdateMsg$updateRelationFlags.class);
        }
    };
    public ProfileUpdateMsg$updateVas vasInfo = new MessageMicro<ProfileUpdateMsg$updateVas>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$updateVas
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField vipFlag = PBField.initBool(false);
        public final PBBoolField yearVipFlag = PBField.initBool(false);
        public final PBBoolField svipFlag = PBField.initBool(false);
        public final PBUInt32Field vipLevel = PBField.initUInt32(0);
        public final PBBoolField bigClub = PBField.initBool(false);
        public final PBUInt32Field bigClubLevel = PBField.initUInt32(0);
        public final PBUInt32Field nameplateVipType = PBField.initUInt32(0);
        public final PBUInt32Field grayNameplateFlag = PBField.initUInt32(0);
        public final PBUInt32Field extendNameplateId = PBField.initUInt32(0);
        public final PBUInt32Field diyFontId = PBField.initUInt32(0);
        public final PBUInt64Field gameCardId = PBField.initUInt64(0);
        public final PBUInt32Field vipStartFlag = PBField.initUInt32(0);
        public final PBRepeatField<Integer> diyNameplateIDs = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt32Field vipDataFlag = PBField.initUInt32(0);
        public final PBUInt32Field pendantId = PBField.initUInt32(0);
        public final PBUInt32Field pendantDiyId = PBField.initUInt32(0);
        public final PBUInt32Field faceId = PBField.initUInt32(0);
        public final PBUInt32Field vipFont = PBField.initUInt32(0);
        public final PBUInt32Field vipFontType = PBField.initUInt32(0);
        public final PBUInt32Field magicFont = PBField.initUInt32(0);
        public final PBUInt32Field fontEffect = PBField.initUInt32(0);
        public final PBUInt32Field newLoverDiamondFlag = PBField.initUInt32(0);
        public final PBUInt32Field superVipTemplateId = PBField.initUInt32(0);
        public final PBUInt64Field gameNameplateId = PBField.initUInt64(0);
        public final PBUInt64Field gameLastLoginTime = PBField.initUInt64(0);
        public final PBUInt32Field gameRank = PBField.initUInt32(0);
        public final PBBoolField gameIconShowFlag = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{224008, 224016, 224024, 224032, 224040, 224048, 224056, 224064, 224072, 224080, 224088, 224096, 224104, 224112, 224120, 224128, 224136, 224144, 224152, 224160, 224168, 224184, 224192, 224200, 224208, 224216, 224224}, new String[]{"vipFlag", "yearVipFlag", "svipFlag", "vipLevel", "bigClub", "bigClubLevel", "nameplateVipType", "grayNameplateFlag", "extendNameplateId", "diyFontId", "gameCardId", "vipStartFlag", "diyNameplateIDs", "vipDataFlag", "pendantId", "pendantDiyId", "faceId", "vipFont", "vipFontType", "magicFont", "fontEffect", "newLoverDiamondFlag", "superVipTemplateId", "gameNameplateId", "gameLastLoginTime", "gameRank", "gameIconShowFlag"}, new Object[]{bool, bool, bool, 0, bool, 0, 0, 0, 0, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0, bool}, ProfileUpdateMsg$updateVas.class);
        }
    };
    public ProfileUpdateMsg$updateOtherFlags otherFlags = new MessageMicro<ProfileUpdateMsg$updateOtherFlags>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$updateOtherFlags
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField onlyChat = PBField.initBool(false);
        public final PBBoolField qzoneNotWatch = PBField.initBool(false);
        public final PBBoolField qzoneNotWatched = PBField.initBool(false);
        public final PBBoolField isZPlanCoupleOpen = PBField.initBool(false);
        public final PBUInt32Field zplanCoupleSceneId = PBField.initUInt32(0);
        public final PBUInt32Field teenagerFlag = PBField.initUInt32(0);
        public final PBUInt32Field studyFlag = PBField.initUInt32(0);
        public final PBBoolField isAioShortcutBarOpen = PBField.initBool(false);
        public final PBUInt32Field colorRindId = PBField.initUInt32(0);
        public final PBBoolField isSharingLocation = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{160352, 160360, 160392, 160400, 160408, 160504, 160512, 232008, 232016, 232024}, new String[]{"teenagerFlag", "studyFlag", "onlyChat", "qzoneNotWatch", "qzoneNotWatched", "isZPlanCoupleOpen", "zplanCoupleSceneId", "isAioShortcutBarOpen", "colorRindId", "isSharingLocation"}, new Object[]{0, 0, bool, bool, bool, bool, 0, bool, 0, bool}, ProfileUpdateMsg$updateOtherFlags.class);
        }
    };
}
