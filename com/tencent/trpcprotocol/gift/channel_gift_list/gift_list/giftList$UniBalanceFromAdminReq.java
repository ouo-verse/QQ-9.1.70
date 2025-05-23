package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class giftList$UniBalanceFromAdminReq extends MessageMicro<giftList$UniBalanceFromAdminReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"appid", "authkey", "domainID"}, new Object[]{"", "", 0}, giftList$UniBalanceFromAdminReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField authkey = PBField.initString("");
    public final PBUInt32Field domainID = PBField.initUInt32(0);
}
