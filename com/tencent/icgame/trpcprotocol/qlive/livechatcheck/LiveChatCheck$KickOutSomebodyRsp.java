package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$KickOutSomebodyRsp extends MessageMicro<LiveChatCheck$KickOutSomebodyRsp> {
    public static final int MSG_FIELD_NUMBER = 2;
    public static final int RETCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", "msg"}, new Object[]{0, ByteStringMicro.EMPTY}, LiveChatCheck$KickOutSomebodyRsp.class);
    public final PBInt32Field retcode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f116232msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
