package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$AdminMenuListReq extends MessageMicro<LiveChatCheck$AdminMenuListReq> {
    public static final int SOURCE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"source"}, new Object[]{0}, LiveChatCheck$AdminMenuListReq.class);
    public final PBUInt32Field source = PBField.initUInt32(0);
}
