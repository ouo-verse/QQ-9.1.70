package com.tencent.trpcprotocol.zplan.data_card.data_card;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$InfoDes;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class dataCard$ReqBody extends MessageMicro<dataCard$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"need_infos"}, new Object[]{null}, dataCard$ReqBody.class);
    public final PBRepeatMessageField<commonPb$InfoDes> need_infos = PBField.initRepeatMessage(commonPb$InfoDes.class);
}
