package circlesearch;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$StPromptResp extends MessageMicro<CircleSearchExhibition$StPromptResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56}, new String[]{"hot_info", "tag_search", "hot_event", "guess_prompt", "shading_prompt", "ranking", "grey"}, new Object[]{null, null, null, null, null, null, Boolean.FALSE}, CircleSearchExhibition$StPromptResp.class);
    public CircleSearchExhibition$PromptTag hot_info = new CircleSearchExhibition$PromptTag();
    public CircleSearchExhibition$PromptTag tag_search = new CircleSearchExhibition$PromptTag();
    public CircleSearchExhibition$PromptEvent hot_event = new MessageMicro<CircleSearchExhibition$PromptEvent>() { // from class: circlesearch.CircleSearchExhibition$PromptEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", LinkReportConstant$GlobalKey.EVENTS}, new Object[]{"", null}, CircleSearchExhibition$PromptEvent.class);
        public final PBStringField name = PBField.initString("");
        public final PBRepeatMessageField<CircleSearchExhibition$PromptEventInfo> events = PBField.initRepeatMessage(CircleSearchExhibition$PromptEventInfo.class);
    };
    public CircleSearchExhibition$PromptGuess guess_prompt = new CircleSearchExhibition$PromptGuess();
    public CircleSearchExhibition$PromptShading shading_prompt = new CircleSearchExhibition$PromptShading();
    public CircleSearchExhibition$PromptRanking ranking = new CircleSearchExhibition$PromptRanking();
    public final PBBoolField grey = PBField.initBool(false);
}
