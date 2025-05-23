package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrder$LinkInfo extends MessageMicro<ECOrder$LinkInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 162, 240}, new String[]{"h5_url", "wechat_link_info", "qq_link_info", "priority"}, new Object[]{"", null, null, 0}, ECOrder$LinkInfo.class);
    public final PBStringField h5_url = PBField.initString("");
    public ECOrder$MiniProgramLinkInfo wechat_link_info = new MessageMicro<ECOrder$MiniProgramLinkInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$MiniProgramLinkInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"username", "path", "type", "app_id"}, new Object[]{"", "", "", ""}, ECOrder$MiniProgramLinkInfo.class);
        public final PBStringField username = PBField.initString("");
        public final PBStringField path = PBField.initString("");
        public final PBStringField type = PBField.initString("");
        public final PBStringField app_id = PBField.initString("");
    };
    public ECOrder$MiniProgramLinkInfo qq_link_info = new MessageMicro<ECOrder$MiniProgramLinkInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$MiniProgramLinkInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"username", "path", "type", "app_id"}, new Object[]{"", "", "", ""}, ECOrder$MiniProgramLinkInfo.class);
        public final PBStringField username = PBField.initString("");
        public final PBStringField path = PBField.initString("");
        public final PBStringField type = PBField.initString("");
        public final PBStringField app_id = PBField.initString("");
    };
    public final PBRepeatField<Integer> priority = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
