package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StPushList extends MessageMicro<FeedCloudMeta$StPushList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 56, 64, 74, 80, 90}, new String[]{"id", "count", "status", "vecUser", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "postUser", "hasClickCount", "totalClickCount", WadlProxyConsts.KEY_JUMP_URL, "pushUserCount", "pushBoxViewInfo"}, new Object[]{"", 0, 0, null, ByteStringMicro.EMPTY, null, 0, 0, "", 0, null}, FeedCloudMeta$StPushList.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398457id = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StUser> vecUser = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta$StUser postUser = new FeedCloudMeta$StUser();
    public final PBUInt32Field hasClickCount = PBField.initUInt32(0);
    public final PBUInt32Field totalClickCount = PBField.initUInt32(0);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBUInt32Field pushUserCount = PBField.initUInt32(0);
    public FeedCloudMeta$PushBoxViewInfo pushBoxViewInfo = new FeedCloudMeta$PushBoxViewInfo();
}
