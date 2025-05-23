package com.tencent.nowsummarycard;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$ReqNearbySummaryCard extends MessageMicro<NowSummaryCard$ReqNearbySummaryCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uin", INetChannelCallback.KEY_TINY_ID, "location", "client_info", "come_from"}, new Object[]{0L, 0L, null, null, 0L}, NowSummaryCard$ReqNearbySummaryCard.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public NowSummaryCard$LocationInfo location = new NowSummaryCard$LocationInfo();
    public NowSummaryCard$ClientInfo client_info = new NowSummaryCard$ClientInfo();
    public final PBUInt64Field come_from = PBField.initUInt64(0);
}
