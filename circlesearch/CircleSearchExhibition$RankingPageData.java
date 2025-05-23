package circlesearch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$RankingPageData extends MessageMicro<CircleSearchExhibition$RankingPageData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBEnumField style = PBField.initEnum(1);
    public final PBRepeatField<ByteStringMicro> data = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBStringField completeRankingURL = PBField.initString("");
    public final PBBytesField serverParams = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBoolField hasMore = PBField.initBool(false);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56}, new String[]{"ext_info", "style", "data", "completeRankingURL", "serverParams", "attachInfo", "hasMore"}, new Object[]{null, 1, byteStringMicro, "", byteStringMicro, "", Boolean.FALSE}, CircleSearchExhibition$RankingPageData.class);
    }
}
