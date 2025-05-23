package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ExtendFriendSquareInfo$LBSInfo extends MessageMicro<ExtendFriendSquareInfo$LBSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_gps", "rpt_msg_wifis", "rpt_msg_cells"}, new Object[]{null, null, null}, ExtendFriendSquareInfo$LBSInfo.class);
    public ExtendFriendSquareInfo$GPS msg_gps = new ExtendFriendSquareInfo$GPS();
    public final PBRepeatMessageField<ExtendFriendSquareInfo$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(ExtendFriendSquareInfo$Wifi.class);
    public final PBRepeatMessageField<ExtendFriendSquareInfo$Cell> rpt_msg_cells = PBField.initRepeatMessage(ExtendFriendSquareInfo$Cell.class);
}
