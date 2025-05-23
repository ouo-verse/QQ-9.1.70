package com.tencent.trpcprotocol.unite.unifysearch.head_template;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* loaded from: classes27.dex */
public final class HeadTemplatePB$SearchTextItem extends MessageMicro<HeadTemplatePB$SearchTextItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"text", ZPlanPublishSource.FROM_SCHEME, QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO}, new Object[]{"", "", null}, HeadTemplatePB$SearchTextItem.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public HeadTemplatePB$ReportInfo report_info = new HeadTemplatePB$ReportInfo();
}
