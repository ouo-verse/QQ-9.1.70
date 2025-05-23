package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StBarrage extends MessageMicro<FeedCloudMeta$StBarrage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50, 56, 64, 72}, new String[]{"id", "postUser", WadlProxyConsts.CREATE_TIME, "content", "createTimeNs", "storeExtInfo", "feedPlayTime", "status", "pannelOpenTime"}, new Object[]{"", null, 0L, "", 0L, null, 0L, 0, 0L}, FeedCloudMeta$StBarrage.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398446id = PBField.initString("");
    public FeedCloudMeta$StUser postUser = new FeedCloudMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field createTimeNs = PBField.initUInt64(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> storeExtInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBUInt64Field feedPlayTime = PBField.initUInt64(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt64Field pannelOpenTime = PBField.initUInt64(0);
}
