package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LbsShare$GetShopsByIdsResp extends MessageMicro<LbsShare$GetShopsByIdsResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ec", "shops"}, new Object[]{0, null}, LbsShare$GetShopsByIdsResp.class);

    /* renamed from: ec, reason: collision with root package name */
    public final PBUInt32Field f342134ec = PBField.initUInt32(0);
    public final PBRepeatMessageField<LbsShare$DPBiz> shops = PBField.initRepeatMessage(LbsShare$DPBiz.class);
}
