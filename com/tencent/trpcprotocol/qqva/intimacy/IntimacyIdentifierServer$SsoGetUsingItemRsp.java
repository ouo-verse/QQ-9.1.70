package com.tencent.trpcprotocol.qqva.intimacy;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class IntimacyIdentifierServer$SsoGetUsingItemRsp extends MessageMicro<IntimacyIdentifierServer$SsoGetUsingItemRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "items"}, new Object[]{0, "", null}, IntimacyIdentifierServer$SsoGetUsingItemRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<IntimacyIdentifierServer$BaseItem> items = PBField.initRepeatMessage(IntimacyIdentifierServer$BaseItem.class);
}
