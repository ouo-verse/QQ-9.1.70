package com.tencent.pb.now;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_write$GetChangVideoAndResetRsp extends MessageMicro<ilive_feeds_write$GetChangVideoAndResetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "chang"}, new Object[]{0, ByteStringMicro.EMPTY, null}, ilive_feeds_write$GetChangVideoAndResetRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ilive_feeds_tmem$Chang> chang = PBField.initRepeatMessage(ilive_feeds_tmem$Chang.class);
}
