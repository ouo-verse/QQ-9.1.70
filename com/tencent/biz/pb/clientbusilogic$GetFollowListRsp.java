package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$GetFollowListRsp extends MessageMicro<clientbusilogic$GetFollowListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"seq", "ret_code", "err_msg", "rsp", "ext_info"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, null, null}, clientbusilogic$GetFollowListRsp.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBInt64Field ret_code = PBField.initInt64(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public Rsp rsp = new Rsp();
    public final PBRepeatMessageField<clientbusilogic$Entry> ext_info = PBField.initRepeatMessage(clientbusilogic$Entry.class);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Rsp extends MessageMicro<Rsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"ext_info", "seq", "attach_info", "refresh", "has_next", "account_list"}, new Object[]{null, 0, "", 0, 0, null}, Rsp.class);
        public clientbusilogic$StCommonExt ext_info = new MessageMicro<clientbusilogic$StCommonExt>() { // from class: com.tencent.biz.pb.clientbusilogic$StCommonExt
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"map_info", "attach_info"}, new Object[]{null, ""}, clientbusilogic$StCommonExt.class);
            public final PBRepeatMessageField<clientbusilogic$Entry> map_info = PBField.initRepeatMessage(clientbusilogic$Entry.class);
            public final PBStringField attach_info = PBField.initString("");
        };
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public final PBStringField attach_info = PBField.initString("");
        public final PBUInt32Field refresh = PBField.initUInt32(0);
        public final PBUInt32Field has_next = PBField.initUInt32(0);
        public final PBRepeatMessageField<clientbusilogic$PublicAccountInfo> account_list = PBField.initRepeatMessage(clientbusilogic$PublicAccountInfo.class);
    }
}
