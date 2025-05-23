package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$FollowListReq extends MessageMicro<clientbusilogic$FollowListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"oidb_0x4c9", "oidb_0xf2a"}, new Object[]{null, null}, clientbusilogic$FollowListReq.class);
    public ParamsOld oidb_0x4c9 = new ParamsOld();
    public ParamsNew oidb_0xf2a = new ParamsNew();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ParamsNew extends MessageMicro<ParamsNew> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start_seq", "count"}, new Object[]{0L, 0}, ParamsNew.class);
        public final PBInt64Field start_seq = PBField.initInt64(0);
        public final PBInt32Field count = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ParamsOld extends MessageMicro<ParamsOld> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"user_uin", "seqno", "begin", "number", "version"}, new Object[]{0L, 0, 0, 0, 0}, ParamsOld.class);
        public final PBUInt64Field user_uin = PBField.initUInt64(0);
        public final PBUInt32Field seqno = PBField.initUInt32(0);
        public final PBUInt32Field begin = PBField.initUInt32(0);
        public final PBUInt32Field number = PBField.initUInt32(0);
        public final PBUInt32Field version = PBField.initUInt32(0);
    }
}
