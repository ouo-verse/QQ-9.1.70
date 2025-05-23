package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$SubscribeRequest extends MessageMicro<mobileqq_mp$SubscribeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "template_id", "msg_id", "index"}, new Object[]{0L, "", 0L, 0}, mobileqq_mp$SubscribeRequest.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBStringField template_id = PBField.initString("");
    public final PBUInt64Field msg_id = PBField.initUInt64(0);
    public final PBUInt32Field index = PBField.initUInt32(0);
}
