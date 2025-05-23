package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSquareReq extends MessageMicro<CircleSearchExhibition$StSquareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82, 90}, new String[]{"type", "query", "attach_info", "ext_info"}, new Object[]{0, "", null, null}, CircleSearchExhibition$StSquareReq.class);
    public final PBRepeatField<Integer> type = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBStringField query = PBField.initString("");
    public FeedCloudCommon$StCommonExt attach_info = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
