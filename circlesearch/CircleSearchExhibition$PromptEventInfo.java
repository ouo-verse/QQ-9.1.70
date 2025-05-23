package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$PromptEventInfo extends MessageMicro<CircleSearchExhibition$PromptEventInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"rank_img", "name", "icon", "ext_info", "heat"}, new Object[]{"", "", null, null, 0}, CircleSearchExhibition$PromptEventInfo.class);
    public final PBStringField rank_img = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public CircleSearchExhibition$Icon icon = new CircleSearchExhibition$Icon();
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field heat = PBField.initUInt32(0);
}
