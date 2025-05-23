package com.tencent.tedger.outapi.proto;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TEdgeSample$ListWiseSample extends MessageMicro<TEdgeSample$ListWiseSample> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{CheckForwardServlet.KEY_REQ_ID, "dupl", "items"}, new Object[]{"", null, null}, TEdgeSample$ListWiseSample.class);
    public final PBStringField req_id = PBField.initString("");
    public TEdgeFeature$FeatureList dupl = new TEdgeFeature$FeatureList();
    public final PBRepeatMessageField<TEdgeFeature$FeatureList> items = PBField.initRepeatMessage(TEdgeFeature$FeatureList.class);
}
