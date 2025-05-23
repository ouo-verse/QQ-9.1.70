package com.tencent.trpcprotocol.unite.unifysearch.head_template;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* loaded from: classes27.dex */
public final class HeadTemplatePB$SearchHeaderColumn extends MessageMicro<HeadTemplatePB$SearchHeaderColumn> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 74, 82}, new String[]{"icon", "title", "description", "button", ZPlanPublishSource.FROM_SCHEME, QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO}, new Object[]{"", "", "", null, "", null}, HeadTemplatePB$SearchHeaderColumn.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public HeadTemplatePB$SearchTextItem button = new HeadTemplatePB$SearchTextItem();
    public final PBStringField scheme = PBField.initString("");
    public HeadTemplatePB$ReportInfo report_info = new HeadTemplatePB$ReportInfo();
}
