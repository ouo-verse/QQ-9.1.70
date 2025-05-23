package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCircleUnCareListRsp extends MessageMicro<FeedCloudRead$StGetCircleUnCareListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_UIN_LIST, "userlist"}, new Object[]{null, 0, null}, FeedCloudRead$StGetCircleUnCareListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<Integer> uinlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userlist = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
}
