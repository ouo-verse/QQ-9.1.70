package com.tencent.biz.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$GetRefuseMsgSettingRequest extends MessageMicro<clientbusilogic$GetRefuseMsgSettingRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"params"}, new Object[]{null}, clientbusilogic$GetRefuseMsgSettingRequest.class);
    public Params params = new Params();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Params extends MessageMicro<Params> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "version"}, new Object[]{0L, 0}, Params.class);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBUInt32Field version = PBField.initUInt32(0);
    }
}
