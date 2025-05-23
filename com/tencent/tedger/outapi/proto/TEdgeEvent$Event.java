package com.tencent.tedger.outapi.proto;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.raft.codegenmeta.utils.Constants;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TEdgeEvent$Event extends MessageMicro<TEdgeEvent$Event> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{CheckForwardServlet.KEY_REQ_ID, "item_id", "type", "timestamp", Constants.Service.PROPERTIES}, new Object[]{"", "", 0, 0L, null}, TEdgeEvent$Event.class);
    public final PBStringField req_id = PBField.initString("");
    public final PBStringField item_id = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public final PBRepeatMessageField<TEdgeCommon$MapEntry> properties = PBField.initRepeatMessage(TEdgeCommon$MapEntry.class);
}
