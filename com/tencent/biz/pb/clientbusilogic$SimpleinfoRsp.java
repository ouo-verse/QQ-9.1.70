package com.tencent.biz.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$SimpleinfoRsp extends MessageMicro<clientbusilogic$SimpleinfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"oidb_0x4cb"}, new Object[]{null}, clientbusilogic$SimpleinfoRsp.class);
    public Rsp oidb_0x4cb = new Rsp();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Rsp extends MessageMicro<Rsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"ret", "info", "seqno"}, new Object[]{null, null, 0}, Rsp.class);
        public clientbusilogic$RetInfo ret = new clientbusilogic$RetInfo();
        public final PBRepeatMessageField<SimpleInfo> info = PBField.initRepeatMessage(SimpleInfo.class);
        public final PBUInt32Field seqno = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SimpleInfo extends MessageMicro<SimpleInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 274}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "account_name", "account_display_number", "account_desc", "account_grade", "show_flag", "account_flag", "account_uid"}, new Object[]{0L, "", "", "", 0, 0, 0, ""}, SimpleInfo.class);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBStringField account_name = PBField.initString("");
        public final PBStringField account_display_number = PBField.initString("");
        public final PBStringField account_desc = PBField.initString("");
        public final PBUInt32Field account_grade = PBField.initUInt32(0);
        public final PBUInt32Field show_flag = PBField.initUInt32(0);
        public final PBUInt32Field account_flag = PBField.initUInt32(0);
        public final PBStringField account_uid = PBField.initString("");
    }
}
