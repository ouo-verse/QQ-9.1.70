package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$UserTextStyleData extends MessageMicro<CircleSearchExhibition$UserTextStyleData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 80, 88}, new String[]{"uid", "avatar", "nick", "text", "rankImg", "jumpInfo", CacheTable.TABLE_NAME, "extInfo", "fansNum", "feedNum", "certification"}, new Object[]{"", "", "", "", "", null, null, null, 0L, 0L, 0}, CircleSearchExhibition$UserTextStyleData.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField rankImg = PBField.initString("");
    public CircleSearchExhibition$JumpInfo jumpInfo = new CircleSearchExhibition$JumpInfo();
    public FeedCloudCommon$StCommonExt reportInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt64Field fansNum = PBField.initInt64(0);
    public final PBInt64Field feedNum = PBField.initInt64(0);
    public final PBInt32Field certification = PBField.initInt32(0);
}
