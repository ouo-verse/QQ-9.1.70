package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$SquareRelevantInfo extends MessageMicro<CircleSearchExhibition$SquareRelevantInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"words", "ext_info"}, new Object[]{null, null}, CircleSearchExhibition$SquareRelevantInfo.class);
    public final PBRepeatMessageField<CircleSearchExhibition$SuggestionWord> words = PBField.initRepeatMessage(CircleSearchExhibition$SuggestionWord.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
