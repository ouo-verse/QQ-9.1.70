package com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class oidb_0xe9b$RspBody extends MessageMicro<oidb_0xe9b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"uint64_next_req_interval", "msg_basic_profile", "rpt_msg_label", "msg_qzone_info", "rpt_msg_selected_pic", "rpt_bytes_longnick", "rpt_msg_quests", "msg_circle_info"}, new Object[]{0L, null, null, null, null, ByteStringMicro.EMPTY, null, null}, oidb_0xe9b$RspBody.class);
    public final PBUInt64Field uint64_next_req_interval = PBField.initUInt64(0);
    public oidb_0xe9b$BasicProfileData msg_basic_profile = new oidb_0xe9b$BasicProfileData();
    public final PBRepeatMessageField<oidb_0xe9b$LabelInfo> rpt_msg_label = PBField.initRepeatMessage(oidb_0xe9b$LabelInfo.class);
    public oidb_0xe9b$QZoneInfo msg_qzone_info = new oidb_0xe9b$QZoneInfo();
    public final PBRepeatMessageField<oidb_0xe9b$SelectedPicInfo> rpt_msg_selected_pic = PBField.initRepeatMessage(oidb_0xe9b$SelectedPicInfo.class);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_longnick = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0xe9b$Quest> rpt_msg_quests = PBField.initRepeatMessage(oidb_0xe9b$Quest.class);
    public oidb_0xe9b$QCircle msg_circle_info = new oidb_0xe9b$QCircle();
}
