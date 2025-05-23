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

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StLike extends MessageMicro<FeedCloudMeta$StLike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 56, 64, 74, 80, 88}, new String[]{"id", "count", "status", "vecUser", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "postUser", "hasLikedCount", "ownerStatus", WadlProxyConsts.KEY_JUMP_URL, "negativeLikeStatus", "negativeLikeCount"}, new Object[]{"", 0, 0, null, ByteStringMicro.EMPTY, null, 0, 0, "", 0, 0}, FeedCloudMeta$StLike.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398454id = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StUser> vecUser = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta$StUser postUser = new FeedCloudMeta$StUser();
    public final PBUInt32Field hasLikedCount = PBField.initUInt32(0);
    public final PBUInt32Field ownerStatus = PBField.initUInt32(0);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBUInt32Field negativeLikeStatus = PBField.initUInt32(0);
    public final PBUInt32Field negativeLikeCount = PBField.initUInt32(0);
}
