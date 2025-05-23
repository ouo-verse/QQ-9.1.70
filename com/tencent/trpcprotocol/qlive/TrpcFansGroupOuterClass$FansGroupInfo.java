package com.tencent.trpcprotocol.qlive;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class TrpcFansGroupOuterClass$FansGroupInfo extends MessageMicro<TrpcFansGroupOuterClass$FansGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"status", AudienceReportConst.ANCHOR_NAME, "anchor_pic", "group_name", "fans_num", "has_fans_group"}, new Object[]{0, "", "", "", 0, Boolean.FALSE}, TrpcFansGroupOuterClass$FansGroupInfo.class);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField anchor_name = PBField.initString("");
    public final PBStringField anchor_pic = PBField.initString("");
    public final PBStringField group_name = PBField.initString("");
    public final PBUInt32Field fans_num = PBField.initUInt32(0);
    public final PBBoolField has_fans_group = PBField.initBool(false);
}
