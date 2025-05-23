package com.tencent.tedger.outapi.proto;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes26.dex */
public final class TEdgeSample$PointWiseSample extends MessageMicro<TEdgeSample$PointWiseSample> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{CheckForwardServlet.KEY_REQ_ID, "item_id", "timestamp", "dupl", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "feedbacks"}, new Object[]{"", "", 0L, null, null, null}, TEdgeSample$PointWiseSample.class);
    public final PBStringField req_id = PBField.initString("");
    public final PBStringField item_id = PBField.initString("");
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public TEdgeFeature$FeatureList dupl = new TEdgeFeature$FeatureList();
    public TEdgeFeature$FeatureList item = new TEdgeFeature$FeatureList();
    public final PBRepeatMessageField<TEdgeEvent$Event> feedbacks = PBField.initRepeatMessage(TEdgeEvent$Event.class);
}
