package com.tencent.biz.qqcircle.tedgers2.bean.pb;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tedger.outapi.proto.TEdgeEvent$Event;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class TEdgeAction$Action extends MessageMicro<TEdgeAction$Action> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"item_id", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, LinkReportConstant$GlobalKey.EVENTS}, new Object[]{"", null, null}, TEdgeAction$Action.class);
    public final PBStringField item_id = PBField.initString("");
    public TEdgeItem$Item item = new TEdgeItem$Item();
    public final PBRepeatMessageField<TEdgeEvent$Event> events = PBField.initRepeatMessage(TEdgeEvent$Event.class);
}
