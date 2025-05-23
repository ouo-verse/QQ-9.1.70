package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StRecomForward extends MessageMicro<FeedCloudMeta$StRecomForward> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58}, new String[]{"id", "title", "subtitle", QAdVrReport.ElementID.AD_POSTER, WadlProxyConsts.CREATE_TIME, "type", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA}, new Object[]{"", "", "", null, 0L, 0, ByteStringMicro.EMPTY}, FeedCloudMeta$StRecomForward.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398458id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public FeedCloudMeta$StUser poster = new FeedCloudMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
}
