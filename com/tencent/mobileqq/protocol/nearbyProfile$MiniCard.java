package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes35.dex */
public final class nearbyProfile$MiniCard extends MessageMicro<nearbyProfile$MiniCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 72, 82, 802}, new String[]{"target_id", "nick", "logo", "gender", "age", "marriage", IProfileProtocolConst.KEY_PROFESSION, LpReport_UserInfo_dc02148.CONSTELLATION, AppConstants.VIPKey.KEY_FOR_VIP_TYPE, "origin_tag_text", "common_tag"}, new Object[]{0L, "", "", 0, 0, 0, 0, 0, 0, "", null}, nearbyProfile$MiniCard.class);
    public final PBUInt64Field target_id = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBUInt32Field marriage = PBField.initUInt32(0);
    public final PBUInt32Field profession = PBField.initUInt32(0);
    public final PBUInt32Field constellation = PBField.initUInt32(0);
    public final PBUInt32Field vip_type = PBField.initUInt32(0);
    public final PBStringField origin_tag_text = PBField.initString("");
    public nearbyProfile$CommonTag common_tag = new MessageMicro<nearbyProfile$CommonTag>() { // from class: com.tencent.mobileqq.protocol.nearbyProfile$CommonTag
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tag"}, new Object[]{null}, nearbyProfile$CommonTag.class);
        public final PBRepeatMessageField<Tag> tag = PBField.initRepeatMessage(Tag.class);

        /* loaded from: classes35.dex */
        public static final class Tag extends MessageMicro<Tag> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"topic", "name", "type"}, new Object[]{"", "", 0}, Tag.class);
            public final PBStringField topic = PBField.initString("");
            public final PBRepeatField<String> name = PBField.initRepeat(PBStringField.__repeatHelper__);
            public final PBUInt32Field type = PBField.initUInt32(0);
        }
    };
}
