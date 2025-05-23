package feedcloud;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StNoticeCategory extends MessageMicro<FeedCloudMeta$StNoticeCategory> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 56, 66, 72, 82}, new String[]{"id", "title", "summary", "icon", MiniProgramLpReportDC04239.DETAIN_DIALOG_SUB_ACTION_CLICK_R, "jump_url", "newest_notice_timestamp", "label_text", "notice_count", QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO}, new Object[]{0, "", "", null, 0, "", 0L, "", 0L, null}, FeedCloudMeta$StNoticeCategory.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBEnumField f398455id = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public FeedCloudMeta$StImage icon = new FeedCloudMeta$StImage();
    public final PBEnumField right_icon = PBField.initEnum(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt64Field newest_notice_timestamp = PBField.initUInt64(0);
    public final PBStringField label_text = PBField.initString("");
    public final PBInt64Field notice_count = PBField.initInt64(0);
    public FeedCloudMeta$StNoticeCategoryReport report_info = new FeedCloudMeta$StNoticeCategoryReport();
}
