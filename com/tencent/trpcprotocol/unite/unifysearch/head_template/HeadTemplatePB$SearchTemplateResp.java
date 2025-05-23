package com.tencent.trpcprotocol.unite.unifysearch.head_template;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* loaded from: classes27.dex */
public final class HeadTemplatePB$SearchTemplateResp extends MessageMicro<HeadTemplatePB$SearchTemplateResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"image", "header", "icons", QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO}, new Object[]{null, null, null, null}, HeadTemplatePB$SearchTemplateResp.class);
    public HeadTemplatePB$SearchImage image = new HeadTemplatePB$SearchImage();
    public HeadTemplatePB$SearchHeaderColumn header = new HeadTemplatePB$SearchHeaderColumn();
    public final PBRepeatMessageField<HeadTemplatePB$SearchIconItem> icons = PBField.initRepeatMessage(HeadTemplatePB$SearchIconItem.class);
    public HeadTemplatePB$ReportInfo report_info = new HeadTemplatePB$ReportInfo();
}
