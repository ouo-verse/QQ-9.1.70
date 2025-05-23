package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$SimpleInfoReq extends MessageMicro<clientbusilogic$SimpleInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"oidb_0x4cb"}, new Object[]{null}, clientbusilogic$SimpleInfoReq.class);
    public Params oidb_0x4cb = new Params();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Params extends MessageMicro<Params> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"user_uin", "puin_list", "seqno", "version"}, new Object[]{0L, 0L, 0, 0}, Params.class);
        public final PBUInt64Field user_uin = PBField.initUInt64(0);
        public final PBRepeatField<Long> puin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field seqno = PBField.initUInt32(0);
        public final PBUInt32Field version = PBField.initUInt32(0);
    }
}
