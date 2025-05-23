package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SmallYellowItem extends MessageMicro<EmosmPb$SmallYellowItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"id", "type", "count", "ts"}, new Object[]{0, 0, 0, 0L}, EmosmPb$SmallYellowItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f342125id = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f342126ts = PBField.initUInt64(0);
}
