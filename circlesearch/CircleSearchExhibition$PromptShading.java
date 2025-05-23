package circlesearch;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$PromptShading extends MessageMicro<CircleSearchExhibition$PromptShading> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 82}, new String[]{"text", "shading_infos", WidgetCacheConstellationData.INTERVAL, "ext_info"}, new Object[]{"", null, 0, null}, CircleSearchExhibition$PromptShading.class);
    public final PBStringField text = PBField.initString("");
    public final PBRepeatMessageField<CircleSearchExhibition$PromptShadingInfo> shading_infos = PBField.initRepeatMessage(CircleSearchExhibition$PromptShadingInfo.class);
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
