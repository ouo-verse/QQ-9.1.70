package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$CellVisitor extends MessageMicro<QZoneOfficialAccountBase$CellVisitor> {
    public static final int VISITOR_TYPE_INVALID = 0;
    public static final int VISITOR_TYPE_MULTI_AVATAR = 2;
    public static final int VISITOR_TYPE_SINGLE_AVATAR = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"visitor_type", "user_list"}, new Object[]{0, null}, QZoneOfficialAccountBase$CellVisitor.class);
    public final PBEnumField visitor_type = PBField.initEnum(0);
    public final PBRepeatMessageField<QZoneOfficialAccountBase$UserInfo> user_list = PBField.initRepeatMessage(QZoneOfficialAccountBase$UserInfo.class);
}
