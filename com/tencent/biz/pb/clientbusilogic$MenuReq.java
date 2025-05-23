package com.tencent.biz.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$MenuReq extends MessageMicro<clientbusilogic$MenuReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"oidb_0x4ce"}, new Object[]{null}, clientbusilogic$MenuReq.class);
    public Params oidb_0x4ce = new Params();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Params extends MessageMicro<Params> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"user_uin", IPublicAccountBrowser.KEY_PUB_UIN, "seqno"}, new Object[]{0L, 0L, 0}, Params.class);
        public final PBUInt64Field user_uin = PBField.initUInt64(0);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBUInt32Field seqno = PBField.initUInt32(0);
    }
}
