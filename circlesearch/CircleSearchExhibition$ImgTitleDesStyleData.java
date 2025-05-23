package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$ImgTitleDesStyleData extends MessageMicro<CircleSearchExhibition$ImgTitleDesStyleData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"img", "title", "description", "rankImg", "jumpInfo", CacheTable.TABLE_NAME, "extInfo"}, new Object[]{"", "", "", "", null, null, null}, CircleSearchExhibition$ImgTitleDesStyleData.class);
    public final PBStringField img = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField rankImg = PBField.initString("");
    public CircleSearchExhibition$JumpInfo jumpInfo = new CircleSearchExhibition$JumpInfo();
    public FeedCloudCommon$StCommonExt reportInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
