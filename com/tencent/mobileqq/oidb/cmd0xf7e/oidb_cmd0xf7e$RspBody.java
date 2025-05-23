package com.tencent.mobileqq.oidb.cmd0xf7e;

import com.tencent.mobileqq.oidb.tofuCommon.TofuCommon$TofuCubeInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class oidb_cmd0xf7e$RspBody extends MessageMicro<oidb_cmd0xf7e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 8010}, new String[]{"uint64_next_pull_time", "lastTofus", "msg_tofu_cube_info"}, new Object[]{0L, null, null}, oidb_cmd0xf7e$RspBody.class);
    public final PBUInt64Field uint64_next_pull_time = PBField.initUInt64(0);
    public TofuCommon$TofuCubeInfo msg_tofu_cube_info = new TofuCommon$TofuCubeInfo();
    public final PBRepeatMessageField<oidb_cmd0xf7e$LastTofu> lastTofus = PBField.initRepeatMessage(oidb_cmd0xf7e$LastTofu.class);
}
