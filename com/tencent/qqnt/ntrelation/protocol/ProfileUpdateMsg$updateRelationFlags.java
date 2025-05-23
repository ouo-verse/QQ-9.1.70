package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$updateRelationFlags extends MessageMicro<ProfileUpdateMsg$updateRelationFlags> {
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
}
