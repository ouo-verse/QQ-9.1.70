package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class SougouSearch$CardV2 extends MessageMicro<SougouSearch$CardV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"template_name", "is_recommended", "card_properties", "carousel", "subcards"}, new Object[]{"", Boolean.FALSE, null, null, null}, SougouSearch$CardV2.class);
    public final PBStringField template_name = PBField.initString("");
    public final PBBoolField is_recommended = PBField.initBool(false);
    public final PBRepeatMessageField<SougouSearch$MapItem> card_properties = PBField.initRepeatMessage(SougouSearch$MapItem.class);
    public final PBRepeatMessageField<CarouselUnitV2> carousel = PBField.initRepeatMessage(CarouselUnitV2.class);
    public final PBRepeatMessageField<SougouSearch$CardV2> subcards = PBField.initRepeatMessage(SougouSearch$CardV2.class);

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static final class CarouselUnitV2 extends MessageMicro<CarouselUnitV2> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"card_properties"}, new Object[]{null}, CarouselUnitV2.class);
        public final PBRepeatMessageField<SougouSearch$MapItem> card_properties = PBField.initRepeatMessage(SougouSearch$MapItem.class);
    }
}
