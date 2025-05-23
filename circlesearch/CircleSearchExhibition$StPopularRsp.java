package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$StPopularRsp extends MessageMicro<CircleSearchExhibition$StPopularRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext_info", "words"}, new Object[]{null, null}, CircleSearchExhibition$StPopularRsp.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<CircleSearchExhibition$StPopularWord> words = PBField.initRepeatMessage(CircleSearchExhibition$StPopularWord.class);
}
