package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes17.dex */
public final class MsgSwitchPB$SetSwitchReq extends MessageMicro<MsgSwitchPB$SetSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"open_ids", "close_ids"}, new Object[]{0, 0}, MsgSwitchPB$SetSwitchReq.class);
    public final PBRepeatField<Integer> close_ids;
    public final PBRepeatField<Integer> open_ids;

    public MsgSwitchPB$SetSwitchReq() {
        PBEnumField pBEnumField = PBEnumField.__repeatHelper__;
        this.open_ids = PBField.initRepeat(pBEnumField);
        this.close_ids = PBField.initRepeat(pBEnumField);
    }
}
