package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$EntryConfig extends MessageMicro<VMBasicInfo$EntryConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"allow_local_installation_guide"}, new Object[]{Boolean.FALSE}, VMBasicInfo$EntryConfig.class);
    public final PBBoolField allow_local_installation_guide = PBField.initBool(false);
}
