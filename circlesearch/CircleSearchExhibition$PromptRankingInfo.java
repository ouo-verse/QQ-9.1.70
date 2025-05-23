package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$PromptRankingInfo extends MessageMicro<CircleSearchExhibition$PromptRankingInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"ID", "type", "tab", "page"}, new Object[]{"", 1, null, null}, CircleSearchExhibition$PromptRankingInfo.class);
    public final PBStringField ID = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public CircleSearchExhibition$TabData tab = new CircleSearchExhibition$TabData();
    public CircleSearchExhibition$RankingPageData page = new CircleSearchExhibition$RankingPageData();
}
