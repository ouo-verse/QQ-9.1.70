package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$UpdateData extends MessageMicro<ProfileUpdateMsg$UpdateData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8002, MessageHandlerConstants.NOTIFY_TYPE_MSG_REVOKE_RSP, 165602, 192002, 192802, 193602, 216002, 224002, 232002}, new String[]{"uid", "uin", "intimate", "coreInfo", "baseInfo", "baseExtInfo", "relationFalgs", "vasInfo", "otherFlags"}, new Object[]{"", 0L, null, null, null, null, null, null, null}, ProfileUpdateMsg$UpdateData.class);
    public final PBStringField uid = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public ProfileUpdateMsg$updateIntimate intimate = new ProfileUpdateMsg$updateIntimate();
    public ProfileUpdateMsg$updateCoreInfo coreInfo = new ProfileUpdateMsg$updateCoreInfo();
    public ProfileUpdateMsg$updateBaseInfo baseInfo = new ProfileUpdateMsg$updateBaseInfo();
    public ProfileUpdateMsg$updateBaseExt baseExtInfo = new MessageMicro<ProfileUpdateMsg$updateBaseExt>() { // from class: com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateBaseExt
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
    public ProfileUpdateMsg$updateRelationFlags relationFalgs = new ProfileUpdateMsg$updateRelationFlags();
    public ProfileUpdateMsg$updateVas vasInfo = new ProfileUpdateMsg$updateVas();
    public ProfileUpdateMsg$updateOtherFlags otherFlags = new ProfileUpdateMsg$updateOtherFlags();
}
