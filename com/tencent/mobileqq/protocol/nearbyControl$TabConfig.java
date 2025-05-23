package com.tencent.mobileqq.protocol;

import com.qzone.widget.u;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$TabConfig extends MessageMicro<nearbyControl$TabConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{u.COLUMN_TAB_ID, EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, "tab_name", "tab_web_url", "tab_hippy_module", "tab_icon_selected_png", "tab_icon_normal_png", "tab_icon_selected_webp", "tab_icon_normal_webp", "ext"}, new Object[]{0L, 0, "", "", "", "", "", "", "", ""}, nearbyControl$TabConfig.class);
    public final PBUInt64Field tab_id = PBField.initUInt64(0);
    public final PBUInt32Field tab_type = PBField.initUInt32(0);
    public final PBStringField tab_name = PBField.initString("");
    public final PBStringField tab_web_url = PBField.initString("");
    public final PBStringField tab_hippy_module = PBField.initString("");
    public final PBStringField tab_icon_selected_png = PBField.initString("");
    public final PBStringField tab_icon_normal_png = PBField.initString("");
    public final PBStringField tab_icon_selected_webp = PBField.initString("");
    public final PBStringField tab_icon_normal_webp = PBField.initString("");
    public final PBStringField ext = PBField.initString("");
}
