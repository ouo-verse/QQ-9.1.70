package com.tencent.pb.profilecard;

import com.qzone.common.business.model.AvatarCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.BaseProfileDiamondWallComponent;

/* loaded from: classes22.dex */
public final class VaProfileGate$PrivilegeInfo extends MessageMicro<VaProfileGate$PrivilegeInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field iIsBig;
    public final PBInt32Field iIsRemind;
    public final PBUInt32Field iRemindTime;
    public final PBUInt32Field iTipsTimes;
    public final PBBytesField strDeluxeIconUrl;
    public final PBBytesField strExtInfo;
    public final PBBytesField strIconUrl;
    public final PBBytesField strJumpUrl;
    public final PBStringField strTipsIconUrl;
    public final PBInt32Field iType = PBField.initInt32(0);
    public final PBInt32Field iSort = PBField.initInt32(0);
    public final PBInt32Field iFeeType = PBField.initInt32(0);
    public final PBInt32Field iLevel = PBField.initInt32(0);
    public final PBInt32Field iFlag = PBField.initInt32(0);

    static {
        String[] strArr = {AvatarCacheData.ITYPE, "iSort", "iFeeType", "iLevel", "iFlag", "strIconUrl", "strDeluxeIconUrl", "strJumpUrl", "iIsBig", "iIsRemind", BaseProfileDiamondWallComponent.REMIND_TIME, "strTipsIconUrl", BaseProfileDiamondWallComponent.TIPS_TIMES, "strExtInfo"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 72, 80, 88, 98, 104, 114}, strArr, new Object[]{0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, "", 0, byteStringMicro}, VaProfileGate$PrivilegeInfo.class);
    }

    public VaProfileGate$PrivilegeInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.strIconUrl = PBField.initBytes(byteStringMicro);
        this.strDeluxeIconUrl = PBField.initBytes(byteStringMicro);
        this.strJumpUrl = PBField.initBytes(byteStringMicro);
        this.iIsBig = PBField.initInt32(0);
        this.iIsRemind = PBField.initInt32(0);
        this.iRemindTime = PBField.initUInt32(0);
        this.strTipsIconUrl = PBField.initString("");
        this.iTipsTimes = PBField.initUInt32(0);
        this.strExtInfo = PBField.initBytes(byteStringMicro);
    }
}
