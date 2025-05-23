package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$TextIconStyleData extends MessageMicro<CircleSearchExhibition$TextIconStyleData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56}, new String[]{"text", "icon", "rankImg", "jumpInfo", CacheTable.TABLE_NAME, "extInfo", "heat"}, new Object[]{"", null, "", null, null, null, 0}, CircleSearchExhibition$TextIconStyleData.class);
    public final PBStringField text = PBField.initString("");
    public CircleSearchExhibition$Icon icon = new CircleSearchExhibition$Icon();
    public final PBStringField rankImg = PBField.initString("");
    public CircleSearchExhibition$JumpInfo jumpInfo = new CircleSearchExhibition$JumpInfo();
    public FeedCloudCommon$StCommonExt reportInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field heat = PBField.initUInt32(0);
}
