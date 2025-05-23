package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudConvertidClient$IDItem extends MessageMicro<FeedCloudConvertidClient$IDItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"feedsid", TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, "status"}, new Object[]{"", "", 0}, FeedCloudConvertidClient$IDItem.class);
    public final PBStringField feedsid = PBField.initString("");
    public final PBStringField bizid = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
}
