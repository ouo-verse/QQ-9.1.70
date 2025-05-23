package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$CellPic extends MessageMicro<QZoneOfficialAccountBase$CellPic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pic_list"}, new Object[]{null}, QZoneOfficialAccountBase$CellPic.class);
    public final PBRepeatMessageField<QZoneOfficialAccountBase$PicInfo> pic_list = PBField.initRepeatMessage(QZoneOfficialAccountBase$PicInfo.class);
}
