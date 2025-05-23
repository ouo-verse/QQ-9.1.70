package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CreatorReader$CreatorAD extends MessageMicro<CreatorReader$CreatorAD> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 56, 66}, new String[]{"creative_id", "job_id", "qq_ad_get_rsp", "action_report_infos", "card_show_second", "highlight_second", "highlight_slide_second", "id"}, new Object[]{"", 0L, null, null, 0, 0, 0, null}, CreatorReader$CreatorAD.class);
    public final PBStringField creative_id = PBField.initString("");
    public final PBInt64Field job_id = PBField.initInt64(0);
    public qq_ad_get.QQAdGetRsp qq_ad_get_rsp = new qq_ad_get.QQAdGetRsp();
    public CreatorReader$UserActionReportInfo action_report_infos = new CreatorReader$UserActionReportInfo();
    public final PBInt32Field card_show_second = PBField.initInt32(0);
    public final PBInt32Field highlight_second = PBField.initInt32(0);
    public final PBInt32Field highlight_slide_second = PBField.initInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public CreatorReader$IDInfo f100376id = new MessageMicro<CreatorReader$IDInfo>() { // from class: com.tencent.creatorad.pb.CreatorReader$IDInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"task_id", "creator_id"}, new Object[]{"", ""}, CreatorReader$IDInfo.class);
        public final PBStringField task_id = PBField.initString("");
        public final PBStringField creator_id = PBField.initString("");
    };
}
