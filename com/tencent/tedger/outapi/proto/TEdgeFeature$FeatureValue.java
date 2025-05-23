package com.tencent.tedger.outapi.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TEdgeFeature$FeatureValue extends MessageMicro<TEdgeFeature$FeatureValue> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField value_type = PBField.initEnum(0);
    public final PBInt32Field int32_val = PBField.initInt32(0);
    public final PBFloatField float_val = PBField.initFloat(0.0f);
    public final PBStringField string_val = PBField.initString("");
    public TEdgeFeature$StringFloatTuple stringfloat_val = new MessageMicro<TEdgeFeature$StringFloatTuple>() { // from class: com.tencent.tedger.outapi.proto.TEdgeFeature$StringFloatTuple
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21}, new String[]{"string_val", "float_val"}, new Object[]{"", Float.valueOf(0.0f)}, TEdgeFeature$StringFloatTuple.class);
        public final PBStringField string_val = PBField.initString("");
        public final PBFloatField float_val = PBField.initFloat(0.0f);
    };
    public final PBRepeatField<Integer> int32_vals = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatField<Float> float_vals = PBField.initRepeat(PBFloatField.__repeatHelper__);
    public final PBRepeatField<String> string_vals = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<TEdgeFeature$StringFloatTuple> stringfloat_vals = PBField.initRepeatMessage(TEdgeFeature$StringFloatTuple.class);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 34, 42, 72, 85, 90, 98}, new String[]{"value_type", "int32_val", "float_val", "string_val", "stringfloat_val", "int32_vals", "float_vals", "string_vals", "stringfloat_vals"}, new Object[]{0, 0, valueOf, "", null, 0, valueOf, "", null}, TEdgeFeature$FeatureValue.class);
    }
}
