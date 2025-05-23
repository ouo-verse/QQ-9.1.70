package com.tencent.mobileqq.pb;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class StatusService {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class ChangeLockStatusReq extends MessageMicro<ChangeLockStatusReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"instance_id", "lock_status"}, new Object[]{0, 0}, ChangeLockStatusReq.class);
        public final PBUInt32Field instance_id = PBField.initUInt32(0);
        public final PBUInt32Field lock_status = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class ChangeLockStatusResp extends MessageMicro<ChangeLockStatusResp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"reply_code", "reply_string"}, new Object[]{0, ByteStringMicro.EMPTY}, ChangeLockStatusResp.class);
        public final PBUInt32Field reply_code = PBField.initUInt32(0);
        public final PBBytesField reply_string = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    StatusService() {
    }
}
