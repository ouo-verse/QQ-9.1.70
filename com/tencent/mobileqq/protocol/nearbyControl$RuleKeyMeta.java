package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$RuleKeyMeta extends MessageMicro<nearbyControl$RuleKeyMeta> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField floatValue;
    public final PBBytesField key;
    public final PBUInt64Field longValue;
    public final PBBytesField stringValue;
    public final PBUInt32Field value_type;

    public nearbyControl$RuleKeyMeta() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key = PBField.initBytes(byteStringMicro);
        this.stringValue = PBField.initBytes(byteStringMicro);
        this.longValue = PBField.initUInt64(0L);
        this.floatValue = PBField.initFloat(0.0f);
        this.value_type = PBField.initUInt32(0);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 37, 40}, new String[]{"key", "stringValue", "longValue", "floatValue", "value_type"}, new Object[]{byteStringMicro, byteStringMicro, 0L, Float.valueOf(0.0f), 0}, nearbyControl$RuleKeyMeta.class);
    }
}
