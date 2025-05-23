package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$GetPartnerDialogReq extends MessageMicro<SgamePartnerSvr$GetPartnerDialogReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"offset", "page_size"}, new Object[]{0, 0}, SgamePartnerSvr$GetPartnerDialogReq.class);
    public final PBInt32Field offset = PBField.initInt32(0);
    public final PBInt32Field page_size = PBField.initInt32(0);
}
