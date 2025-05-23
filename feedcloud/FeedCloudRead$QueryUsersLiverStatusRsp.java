package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$QueryUsersLiverStatusRsp extends MessageMicro<FeedCloudRead$QueryUsersLiverStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"in_live_uids"}, new Object[]{""}, FeedCloudRead$QueryUsersLiverStatusRsp.class);
    public final PBRepeatField<String> in_live_uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
