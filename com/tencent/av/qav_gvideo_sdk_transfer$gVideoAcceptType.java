package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class qav_gvideo_sdk_transfer$gVideoAcceptType extends MessageMicro<qav_gvideo_sdk_transfer$gVideoAcceptType> {
    public static final int BIG = 2;
    public static final int SMALL = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_account", "video_type"}, new Object[]{0L, 1}, qav_gvideo_sdk_transfer$gVideoAcceptType.class);
    public final PBUInt64Field uint64_account = PBField.initUInt64(0);
    public final PBEnumField video_type = PBField.initEnum(1);
}
