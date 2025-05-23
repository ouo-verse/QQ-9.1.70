package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CreatorReader$ShareAD extends MessageMicro<CreatorReader$ShareAD> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"tickets", "qq_ad_get_rsp", "action_report_infos", "display"}, new Object[]{"", null, null, null}, CreatorReader$ShareAD.class);
    public final PBStringField tickets = PBField.initString("");
    public qq_ad_get.QQAdGetRsp qq_ad_get_rsp = new qq_ad_get.QQAdGetRsp();
    public final PBRepeatMessageField<CreatorReader$UserActionReportInfo> action_report_infos = PBField.initRepeatMessage(CreatorReader$UserActionReportInfo.class);
    public Display display = new Display();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Display extends MessageMicro<Display> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"display_pos", "ad_template", "icon_url", "title", "ad_style"}, new Object[]{0, 0, "", "", 0}, Display.class);
        public final PBEnumField display_pos = PBField.initEnum(0);
        public final PBEnumField ad_template = PBField.initEnum(0);
        public final PBStringField icon_url = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBEnumField ad_style = PBField.initEnum(0);
    }
}
