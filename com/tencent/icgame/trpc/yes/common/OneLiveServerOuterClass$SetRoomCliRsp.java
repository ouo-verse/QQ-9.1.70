package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class OneLiveServerOuterClass$SetRoomCliRsp extends MessageMicro<OneLiveServerOuterClass$SetRoomCliRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"SchemeUrl", "LiveID"}, new Object[]{"", ""}, OneLiveServerOuterClass$SetRoomCliRsp.class);
    public final PBStringField SchemeUrl = PBField.initString("");
    public final PBStringField LiveID = PBField.initString("");
}
