package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StNoticeCategoryLabel extends MessageMicro<FeedCloudMeta$StNoticeCategoryLabel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"need_show", QCircleLpReportDc05507.KEY_PIC_INFO}, new Object[]{Boolean.FALSE, null}, FeedCloudMeta$StNoticeCategoryLabel.class);
    public final PBBoolField need_show = PBField.initBool(false);
    public FeedCloudMeta$StImage pic_info = new FeedCloudMeta$StImage();
}
