package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShortVideo$CheckAuthRsp extends MessageMicro<ShortVideo$CheckAuthRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", "err_msg"}, new Object[]{0, ""}, ShortVideo$CheckAuthRsp.class);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}
