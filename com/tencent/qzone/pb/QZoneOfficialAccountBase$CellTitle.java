package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$CellTitle extends MessageMicro<QZoneOfficialAccountBase$CellTitle> {
    public static final int TITLE_TYPE_INVALID = 0;
    public static final int TITLE_TYPE_MULTI_AVATAR = 3;
    public static final int TITLE_TYPE_SINGLE_AVATAR = 2;
    public static final int TITLE_TYPE_TEXT = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"title_type", "title", "user_list"}, new Object[]{0, "", null}, QZoneOfficialAccountBase$CellTitle.class);
    public final PBEnumField title_type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QZoneOfficialAccountBase$UserInfo> user_list = PBField.initRepeatMessage(QZoneOfficialAccountBase$UserInfo.class);
}
