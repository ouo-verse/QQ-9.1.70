package com.tencent.trpcprotocol.qqstranger.relation.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.trpcprotocol.qqstranger.relation.interactive_marker.InteractiveMarkerPB$InteractiveMarker;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Relation$GetInteractiveMarkerRsp extends MessageMicro<Relation$GetInteractiveMarkerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", "markers"}, new Object[]{0, "", null}, Relation$GetInteractiveMarkerRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<InteractiveMarkerPB$InteractiveMarker> markers = PBField.initRepeatMessage(InteractiveMarkerPB$InteractiveMarker.class);
}
