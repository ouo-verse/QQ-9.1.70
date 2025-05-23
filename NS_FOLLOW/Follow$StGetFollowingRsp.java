package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.xweb.updater.IXWebBroadcastListener;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StGetFollowingRsp extends MessageMicro<Follow$StGetFollowingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"stars", "nextStart", IXWebBroadcastListener.STAGE_FINISHED, "totalNum"}, new Object[]{null, 0, 0, 0}, Follow$StGetFollowingRsp.class);
    public final PBRepeatMessageField<Follow$StStar> stars = PBField.initRepeatMessage(Follow$StStar.class);
    public final PBUInt32Field nextStart = PBField.initUInt32(0);
    public final PBUInt32Field finished = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
}
