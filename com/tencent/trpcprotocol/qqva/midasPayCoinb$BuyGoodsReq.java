package com.tencent.trpcprotocol.qqva;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class midasPayCoinb$BuyGoodsReq extends MessageMicro<midasPayCoinb$BuyGoodsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"src_user", "dst_user", "product", "access_appid", "is_consume", "recharge_pf_ext"}, new Object[]{null, null, null, 0, Boolean.FALSE, ""}, midasPayCoinb$BuyGoodsReq.class);
    public midasPayCoinb$UserInfo src_user = new MessageMicro<midasPayCoinb$UserInfo>() { // from class: com.tencent.trpcprotocol.qqva.midasPayCoinb$UserInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"token", "platform", "account_type"}, new Object[]{null, 0, 0}, midasPayCoinb$UserInfo.class);
        public midasPayCoinb$TokenInfo token = new MessageMicro<midasPayCoinb$TokenInfo>() { // from class: com.tencent.trpcprotocol.qqva.midasPayCoinb$TokenInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"type", "open_id", "open_key", "connectAppid", "domainID"}, new Object[]{0, "", "", 0, 0}, midasPayCoinb$TokenInfo.class);
            public final PBEnumField type = PBField.initEnum(0);
            public final PBStringField open_id = PBField.initString("");
            public final PBStringField open_key = PBField.initString("");
            public final PBUInt32Field connectAppid = PBField.initUInt32(0);
            public final PBUInt32Field domainID = PBField.initUInt32(0);
        };
        public final PBEnumField platform = PBField.initEnum(0);
        public final PBInt32Field account_type = PBField.initInt32(0);
    };
    public midasPayCoinb$UserInfo dst_user = new MessageMicro<midasPayCoinb$UserInfo>() { // from class: com.tencent.trpcprotocol.qqva.midasPayCoinb$UserInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"token", "platform", "account_type"}, new Object[]{null, 0, 0}, midasPayCoinb$UserInfo.class);
        public midasPayCoinb$TokenInfo token = new MessageMicro<midasPayCoinb$TokenInfo>() { // from class: com.tencent.trpcprotocol.qqva.midasPayCoinb$TokenInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"type", "open_id", "open_key", "connectAppid", "domainID"}, new Object[]{0, "", "", 0, 0}, midasPayCoinb$TokenInfo.class);
            public final PBEnumField type = PBField.initEnum(0);
            public final PBStringField open_id = PBField.initString("");
            public final PBStringField open_key = PBField.initString("");
            public final PBUInt32Field connectAppid = PBField.initUInt32(0);
            public final PBUInt32Field domainID = PBField.initUInt32(0);
        };
        public final PBEnumField platform = PBField.initEnum(0);
        public final PBInt32Field account_type = PBField.initInt32(0);
    };
    public final PBRepeatMessageField<midasPayCoinb$ProductItem> product = PBField.initRepeatMessage(midasPayCoinb$ProductItem.class);
    public final PBInt32Field access_appid = PBField.initInt32(0);
    public final PBBoolField is_consume = PBField.initBool(false);
    public final PBStringField recharge_pf_ext = PBField.initString("");
}
