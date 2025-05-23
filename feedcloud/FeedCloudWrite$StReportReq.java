package feedcloud;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StReportReq extends MessageMicro<FeedCloudWrite$StReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"extInfo", AdMetricTag.Report.TYPE, "from", CacheTable.TABLE_NAME}, new Object[]{null, 0, 0, null}, FeedCloudWrite$StReportReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field reportType = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StReportInfo> reportInfo = PBField.initRepeatMessage(FeedCloudMeta$StReportInfo.class);
}
