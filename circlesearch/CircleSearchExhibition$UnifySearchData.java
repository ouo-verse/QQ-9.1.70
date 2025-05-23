package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$UnifySearchData extends MessageMicro<CircleSearchExhibition$UnifySearchData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58}, new String[]{"more_text", "more_url", "type", "feed_result", "user_result", "game_desc", "game_collection"}, new Object[]{"", "", 1, null, null, null, null}, CircleSearchExhibition$UnifySearchData.class);
    public final PBStringField more_text = PBField.initString("");
    public final PBStringField more_url = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public CircleSearchExhibition$UnifyFeedsResult feed_result = new CircleSearchExhibition$UnifyFeedsResult();
    public CircleSearchExhibition$UnifyUserCardResult user_result = new CircleSearchExhibition$UnifyUserCardResult();
    public CircleSearchExhibition$StGameDescResp game_desc = new CircleSearchExhibition$StGameDescResp();
    public CircleSearchExhibition$StGameCollectionResp game_collection = new CircleSearchExhibition$StGameCollectionResp();
}
