package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class RedPackSkin$GenShareArkMsgRsp extends MessageMicro<RedPackSkin$GenShareArkMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ark_msg"}, new Object[]{ByteStringMicro.EMPTY}, RedPackSkin$GenShareArkMsgRsp.class);
    public final PBBytesField ark_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
