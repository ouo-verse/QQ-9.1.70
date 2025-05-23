package com.tencent.trpcprotocol.zplan.data_card.data_card;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$Info;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class dataCard$RspBody extends MessageMicro<dataCard$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, dataCard$RspBody.class);
    public final PBRepeatMessageField<commonPb$Info> infos = PBField.initRepeatMessage(commonPb$Info.class);
}
