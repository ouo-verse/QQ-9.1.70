package com.tencent.ecommerce.repo.proto.ecom.common_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECComm$MsgBox extends MessageMicro<ECComm$MsgBox> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 42, 50}, new String[]{"display", "title", "text", "left_btn", "right_btn"}, new Object[]{Boolean.FALSE, "", "", null, null}, ECComm$MsgBox.class);
    public final PBBoolField display = PBField.initBool(false);
    public final PBStringField title = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public ECComm$Btn left_btn = new MessageMicro<ECComm$Btn>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_comm.ECComm$Btn
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField text = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBBoolField should_pop_page = PBField.initBool(false);
        public final PBBoolField should_keep_msg_box = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"text", "url", "should_pop_page", "should_keep_msg_box"}, new Object[]{"", "", bool, bool}, ECComm$Btn.class);
        }
    };
    public ECComm$Btn right_btn = new MessageMicro<ECComm$Btn>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_comm.ECComm$Btn
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField text = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBBoolField should_pop_page = PBField.initBool(false);
        public final PBBoolField should_keep_msg_box = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"text", "url", "should_pop_page", "should_keep_msg_box"}, new Object[]{"", "", bool, bool}, ECComm$Btn.class);
        }
    };
}
