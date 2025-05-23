package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_struct$Emoticon extends MessageMicro<qqstory_struct$Emoticon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "icon"}, new Object[]{0, ByteStringMicro.EMPTY}, qqstory_struct$Emoticon.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f94085id = PBField.initUInt32(0);
    public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
}
