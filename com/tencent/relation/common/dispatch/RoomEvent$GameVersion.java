package com.tencent.relation.common.dispatch;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class RoomEvent$GameVersion extends MessageMicro<RoomEvent$GameVersion> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{AudienceReportConst.CLIENT_TYPE, "min_version"}, new Object[]{0, ""}, RoomEvent$GameVersion.class);
    public final PBEnumField client_type = PBField.initEnum(0);
    public final PBStringField min_version = PBField.initString("");
}
