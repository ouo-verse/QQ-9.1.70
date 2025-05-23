package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class QQShopTabConfig$TabItem extends MessageMicro<QQShopTabConfig$TabItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114}, new String[]{"id", EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, "url", "hippy_page", "name", "navigation_title", "normal_icon", "selected_icon", "night_icon", "normal_color", "selected_color", "night_color", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", "", "", ""}, QQShopTabConfig$TabItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f274503id = PBField.initString("");
    public final PBStringField tab_type = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField hippy_page = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField navigation_title = PBField.initString("");
    public final PBStringField normal_icon = PBField.initString("");
    public final PBStringField selected_icon = PBField.initString("");
    public final PBStringField night_icon = PBField.initString("");
    public final PBStringField normal_color = PBField.initString("");
    public final PBStringField selected_color = PBField.initString("");
    public final PBStringField night_color = PBField.initString("");
    public final PBStringField begin_time = PBField.initString("");
    public final PBStringField end_time = PBField.initString("");
}
