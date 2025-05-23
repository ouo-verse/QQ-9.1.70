package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StResultReq extends MessageMicro<CircleSearchExhibition$StResultReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext_info", "query"}, new Object[]{null, ""}, CircleSearchExhibition$StResultReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBStringField query = PBField.initString("");
}
