package com.tencent.trpcprotocol.qqrelation.operation_profile.operation_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class OperationProfile$ShareReq extends MessageMicro<OperationProfile$ShareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64}, new String[]{"activity_id", "to_uin", "to_group_code", "transparent", "share_params", "select_tag", "extra_share_req", "to_guild_id"}, new Object[]{0, 0L, 0L, "", null, "", null, 0L}, OperationProfile$ShareReq.class);
    public final PBUInt32Field activity_id = PBField.initUInt32(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt64Field to_group_code = PBField.initUInt64(0);
    public final PBStringField transparent = PBField.initString("");
    public final PBRepeatMessageField<OperationProfile$ShareParam> share_params = PBField.initRepeatMessage(OperationProfile$ShareParam.class);
    public final PBStringField select_tag = PBField.initString("");
    public final PBRepeatMessageField<OperationProfile$ShareReq> extra_share_req = PBField.initRepeatMessage(OperationProfile$ShareReq.class);
    public final PBUInt64Field to_guild_id = PBField.initUInt64(0);
}
