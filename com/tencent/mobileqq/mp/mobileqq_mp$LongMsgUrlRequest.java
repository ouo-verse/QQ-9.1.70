package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$LongMsgUrlRequest extends MessageMicro<mobileqq_mp$LongMsgUrlRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "str_fileid"}, new Object[]{0L, ""}, mobileqq_mp$LongMsgUrlRequest.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBStringField str_fileid = PBField.initString("");
}
