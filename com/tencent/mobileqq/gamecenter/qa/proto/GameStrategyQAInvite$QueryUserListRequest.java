package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.util.QZoneImageUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$QueryUserListRequest extends MessageMicro<GameStrategyQAInvite$QueryUserListRequest> {
    public static final int QUERY_INVITE = 2;
    public static final int QUERY_MATCH = 4;
    public static final int QUERY_RECOMMEND = 1;
    public static final int QUERY_UNSPECIFIED = 0;
    public static final int QUERY_WITH_EXPOSURE_HIT = 8;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"query", "appid", "question_id", QZoneImageUtils.KEY_MATCH}, new Object[]{0, 0, 0L, ""}, GameStrategyQAInvite$QueryUserListRequest.class);
    public final PBEnumField query = PBField.initEnum(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt64Field question_id = PBField.initInt64(0);
    public final PBStringField match = PBField.initString("");
}
