package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$QueryChatStatusRsp extends MessageMicro<LiveChatCheck$QueryChatStatusRsp> {
    public static final int UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, LiveChatCheck$QueryChatStatusRsp.class);
    public final PBRepeatField<Long> uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
