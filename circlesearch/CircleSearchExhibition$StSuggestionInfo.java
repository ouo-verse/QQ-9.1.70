package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSuggestionInfo extends MessageMicro<CircleSearchExhibition$StSuggestionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66}, new String[]{"suggest_word", "suggest_type", "hit_key_word", "report_data", "icon", "game_ad", "extra_icons", "ext_info"}, new Object[]{"", 0, "", "", null, null, null, null}, CircleSearchExhibition$StSuggestionInfo.class);
    public final PBStringField suggest_word = PBField.initString("");
    public final PBEnumField suggest_type = PBField.initEnum(0);
    public final PBStringField hit_key_word = PBField.initString("");
    public final PBStringField report_data = PBField.initString("");
    public CircleSearchExhibition$Icon icon = new CircleSearchExhibition$Icon();
    public CircleSearchExhibition$StSugGameAd game_ad = new CircleSearchExhibition$StSugGameAd();
    public final PBRepeatMessageField<CircleSearchExhibition$ExtraIcon> extra_icons = PBField.initRepeatMessage(CircleSearchExhibition$ExtraIcon.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
