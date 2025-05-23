package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$MenuRsp extends MessageMicro<clientbusilogic$MenuRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"oidb_0x4ce"}, new Object[]{null}, clientbusilogic$MenuRsp.class);
    public Rsp oidb_0x4ce = new Rsp();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ButtonInfo extends MessageMicro<ButtonInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66, 74}, new String[]{"id", "name", "key", "url", "type", "sub_buttons", "logo_url", "bg_colors", "texture_url"}, new Object[]{0, "", "", "", 0, null, "", "", ""}, ButtonInfo.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBUInt32Field f78781id = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBStringField key = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBRepeatMessageField<ButtonInfo> sub_buttons = PBField.initRepeatMessage(ButtonInfo.class);
        public final PBStringField logo_url = PBField.initString("");
        public final PBStringField bg_colors = PBField.initString("");
        public final PBStringField texture_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Rsp extends MessageMicro<Rsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"ret_info", "seqno", "menu_info", "menu_type"}, new Object[]{null, 0, null, 0}, Rsp.class);
        public clientbusilogic$RetInfo ret_info = new clientbusilogic$RetInfo();
        public final PBUInt32Field seqno = PBField.initUInt32(0);
        public final PBRepeatMessageField<ButtonInfo> menu_info = PBField.initRepeatMessage(ButtonInfo.class);
        public final PBUInt32Field menu_type = PBField.initUInt32(0);
    }
}
