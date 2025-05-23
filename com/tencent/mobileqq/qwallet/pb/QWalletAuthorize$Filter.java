package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$Filter extends MessageMicro<QWalletAuthorize$Filter> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"is_global", "carrier_type"}, new Object[]{Boolean.TRUE, 0}, QWalletAuthorize$Filter.class);
    public final PBBoolField is_global = PBField.initBool(true);
    public final PBEnumField carrier_type = PBField.initEnum(0);
}
