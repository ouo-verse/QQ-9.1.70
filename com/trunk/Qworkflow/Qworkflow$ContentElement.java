package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$ContentElement extends MessageMicro<Qworkflow$ContentElement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"rpt_text_list", "rpt_file_list", "rpt_picture_list", "bytes_userdef"}, new Object[]{null, null, null, ByteStringMicro.EMPTY}, Qworkflow$ContentElement.class);
    public final PBRepeatMessageField<Qworkflow$Text> rpt_text_list = PBField.initRepeatMessage(Qworkflow$Text.class);
    public final PBRepeatMessageField<Qworkflow$OrdinaryFile> rpt_file_list = PBField.initRepeatMessage(Qworkflow$OrdinaryFile.class);
    public final PBRepeatMessageField<Qworkflow$Picture> rpt_picture_list = PBField.initRepeatMessage(Qworkflow$Picture.class);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
}
