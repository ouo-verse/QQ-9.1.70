package com.tencent.trpcprotocol.qqcollect.arkshare.oidb0x11bf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class oidb0x11bf$ArkShareRsp extends MessageMicro<oidb0x11bf$ArkShareRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "msg", "ark"}, new Object[]{0, "", ByteStringMicro.EMPTY}, oidb0x11bf$ArkShareRsp.class);
    public final PBEnumField ret = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381595msg = PBField.initString("");
    public final PBBytesField ark = PBField.initBytes(ByteStringMicro.EMPTY);
}
