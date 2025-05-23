package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class GetZPlanAction$ActionInfo extends MessageMicro<GetZPlanAction$ActionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 64, 72, 80, 88, 96, 109, 114, 122, 130, 138}, new String[]{"id", "name", "type", "icon_url", "player_number", "duration", "intimate_mutual_type", "intimate_mutual_level", "timestamp", "cover_index", "is_dynamic", "min_version", "scale_ratio", "male_default_url", "female_default_url", "rec_info", "emo_2d_info"}, new Object[]{0, "", 0, "", 0, 0, 0, 0, 0L, 0, Boolean.FALSE, 0, Float.valueOf(0.0f), "", "", null, null}, GetZPlanAction$ActionInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f381671id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt32Field player_number = PBField.initUInt32(0);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field intimate_mutual_type = PBField.initUInt32(0);
    public final PBUInt32Field intimate_mutual_level = PBField.initUInt32(0);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public final PBUInt32Field cover_index = PBField.initUInt32(0);
    public final PBBoolField is_dynamic = PBField.initBool(false);
    public final PBUInt32Field min_version = PBField.initUInt32(0);
    public final PBFloatField scale_ratio = PBField.initFloat(0.0f);
    public final PBStringField male_default_url = PBField.initString("");
    public final PBStringField female_default_url = PBField.initString("");
    public GetZPlanAction$Rectangle rec_info = new GetZPlanAction$Rectangle();
    public GetZPlanAction$Emo2DExtraInfo emo_2d_info = new GetZPlanAction$Emo2DExtraInfo();
}
