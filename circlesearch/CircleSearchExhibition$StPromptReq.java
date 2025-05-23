package circlesearch;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$StPromptReq extends MessageMicro<CircleSearchExhibition$StPromptReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"ext_info", AppConstants.Key.SHARE_REQ_TYPE, "prompts_type"}, new Object[]{null, 1, 1}, CircleSearchExhibition$StPromptReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBEnumField req_type = PBField.initEnum(1);
    public final PBRepeatField<Integer> prompts_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
