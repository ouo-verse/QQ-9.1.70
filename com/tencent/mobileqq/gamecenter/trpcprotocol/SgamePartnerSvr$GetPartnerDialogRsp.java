package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$GetPartnerDialogRsp extends MessageMicro<SgamePartnerSvr$GetPartnerDialogRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"next_offset", "dialog_list"}, new Object[]{0, null}, SgamePartnerSvr$GetPartnerDialogRsp.class);
    public final PBInt32Field next_offset = PBField.initInt32(0);
    public final PBRepeatMessageField<SgamePartnerSvr$PartnerDialog> dialog_list = PBField.initRepeatMessage(SgamePartnerSvr$PartnerDialog.class);
}
