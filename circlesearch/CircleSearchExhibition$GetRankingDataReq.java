package circlesearch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$GetRankingDataReq extends MessageMicro<CircleSearchExhibition$GetRankingDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ext_info", "serverParams", "attachInfo"}, new Object[]{null, ByteStringMicro.EMPTY, ""}, CircleSearchExhibition$GetRankingDataReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBBytesField serverParams = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField attachInfo = PBField.initString("");
}
