package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$ChannelInfo extends MessageMicro<QWalletAuthorize$ChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"appid", "logo", "title"}, new Object[]{0L, "", ""}, QWalletAuthorize$ChannelInfo.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField logo = PBField.initString("");
    public final PBStringField title = PBField.initString("");
}
