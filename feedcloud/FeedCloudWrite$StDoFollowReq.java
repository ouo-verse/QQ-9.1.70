package feedcloud;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoFollowReq extends MessageMicro<FeedCloudWrite$StDoFollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50, 56, 66}, new String[]{"extInfo", VasLiveIPCModule.KEY_FOLLOW_TYPE, QCircleAlphaUserReporter.KEY_USER, "from", "followMethod", "feed", "src", QCircleSchemeAttr.MainPage.EUID}, new Object[]{null, 0, null, 0, 0, null, 0, ""}, FeedCloudWrite$StDoFollowReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field followType = PBField.initUInt32(0);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBInt32Field followMethod = PBField.initInt32(0);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBInt32Field src = PBField.initInt32(0);
    public final PBStringField euid = PBField.initString("");
}
