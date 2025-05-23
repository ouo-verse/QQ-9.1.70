package com.tencent.biz.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$SetRefuseMsgSettingRequest extends MessageMicro<clientbusilogic$SetRefuseMsgSettingRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"params"}, new Object[]{null}, clientbusilogic$SetRefuseMsgSettingRequest.class);
    public Params params = new Params();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Params extends MessageMicro<Params> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 32}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "is_forever", "refuse_period"}, new Object[]{0L, Boolean.FALSE, 0}, Params.class);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBBoolField is_forever = PBField.initBool(false);
        public final PBUInt32Field refuse_period = PBField.initUInt32(0);
    }
}
