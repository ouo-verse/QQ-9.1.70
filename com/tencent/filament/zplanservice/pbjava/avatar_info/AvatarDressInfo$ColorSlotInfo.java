package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$ColorSlotInfo extends MessageMicro<AvatarDressInfo$ColorSlotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{MiniAppReportManager2.KEY_SLOT_ID, "color_type", "single_color", "gradient_type"}, new Object[]{0, 0, null, null}, AvatarDressInfo$ColorSlotInfo.class);
    public final PBUInt32Field slot_id = PBField.initUInt32(0);
    public final PBEnumField color_type = PBField.initEnum(0);
    public AvatarDressInfo$SingleColor single_color = new AvatarDressInfo$SingleColor();
    public AvatarDressInfo$GradientColor gradient_type = new MessageMicro<AvatarDressInfo$GradientColor>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$GradientColor
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field color_config_id = PBField.initUInt32(0);
        public AvatarDressInfo$SingleColor from_color = new AvatarDressInfo$SingleColor();
        public AvatarDressInfo$SingleColor to_color = new AvatarDressInfo$SingleColor();
        public final PBFloatField from_progress = PBField.initFloat(0.0f);
        public final PBFloatField to_progress = PBField.initFloat(0.0f);
        public final PBFloatField progress = PBField.initFloat(0.0f);

        static {
            Float valueOf = Float.valueOf(0.0f);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 37, 45, 53}, new String[]{"color_config_id", "from_color", "to_color", "from_progress", "to_progress", "progress"}, new Object[]{0, null, null, valueOf, valueOf, valueOf}, AvatarDressInfo$GradientColor.class);
        }
    };
}
