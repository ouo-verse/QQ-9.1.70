package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class giftList$UniBalanceFromAdminRsp extends MessageMicro<giftList$UniBalanceFromAdminRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"balance", "rechargeUrl", "ret", "retMsg"}, new Object[]{0L, "", 0L, ""}, giftList$UniBalanceFromAdminRsp.class);
    public final PBUInt64Field balance = PBField.initUInt64(0);
    public final PBStringField rechargeUrl = PBField.initString("");
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField retMsg = PBField.initString("");
}
