package circlesearch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$GetRankingDataRsp extends MessageMicro<CircleSearchExhibition$GetRankingDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBStringField ID = PBField.initString("");
    public final PBRepeatField<ByteStringMicro> data = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField serverParams = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBoolField hasMore = PBField.initBool(false);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"ext_info", "ID", "data", "serverParams", "attachInfo", "hasMore"}, new Object[]{null, "", byteStringMicro, byteStringMicro, "", Boolean.FALSE}, CircleSearchExhibition$GetRankingDataRsp.class);
    }
}
