package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$updateVas extends MessageMicro<ProfileUpdateMsg$updateVas> {
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
}
