package com.tencent.icgame.trpc.yes.common;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes7.dex */
public final class RecommendProxyOuterClass$SendIMArkMsgReq extends MessageMicro<RecommendProxyOuterClass$SendIMArkMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"game_id", "card_type", "group_id", QCircleAlphaUserReporter.KEY_USER, PublicAccountMessageUtilImpl.META_NAME}, new Object[]{0, 0, 0L, null, ""}, RecommendProxyOuterClass$SendIMArkMsgReq.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBInt32Field card_type = PBField.initInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId user = new CommonOuterClass$QQUserId();
    public final PBStringField meta = PBField.initString("");
}
