package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$SquareBubbleInfo extends MessageMicro<CircleSearchExhibition$SquareBubbleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 82}, new String[]{"words", "duration", "ext_info"}, new Object[]{null, 0L, null}, CircleSearchExhibition$SquareBubbleInfo.class);
    public final PBRepeatMessageField<CircleSearchExhibition$SuggestionWord> words = PBField.initRepeatMessage(CircleSearchExhibition$SuggestionWord.class);
    public final PBInt64Field duration = PBField.initInt64(0);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
