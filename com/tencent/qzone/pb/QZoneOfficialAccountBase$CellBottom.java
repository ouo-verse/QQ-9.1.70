package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$CellBottom extends MessageMicro<QZoneOfficialAccountBase$CellBottom> {
    public static final int BOTTOM_TYPE_INTERACTION = 2;
    public static final int BOTTOM_TYPE_INVALID = 0;
    public static final int BOTTOM_TYPE_TEXT = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"bottom_type", "text", "interaction"}, new Object[]{0, "", null}, QZoneOfficialAccountBase$CellBottom.class);
    public final PBEnumField bottom_type = PBField.initEnum(0);
    public final PBStringField text = PBField.initString("");
    public QZoneOfficialAccountBase$InteractionInfo interaction = new QZoneOfficialAccountBase$InteractionInfo();
}
