package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$PromptGuess extends MessageMicro<CircleSearchExhibition$PromptGuess> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"name", "ext_info", "guess_info", "show"}, new Object[]{"", null, null, Boolean.FALSE}, CircleSearchExhibition$PromptGuess.class);
    public final PBStringField name = PBField.initString("");
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<CircleSearchExhibition$PromptGuessInfo> guess_info = PBField.initRepeatMessage(CircleSearchExhibition$PromptGuessInfo.class);
    public final PBBoolField show = PBField.initBool(false);
}
