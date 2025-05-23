package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GetMobileDialogRsp extends MessageMicro<GetMobileDialogRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"nextOffset", "dialogList"}, new Object[]{0, null}, GetMobileDialogRsp.class);
    public final PBInt32Field nextOffset = PBField.initInt32(0);
    public final PBRepeatMessageField<MobileDialog> dialogList = PBField.initRepeatMessage(MobileDialog.class);
}
