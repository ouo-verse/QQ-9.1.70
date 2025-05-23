package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StListTagBaseInfoReq extends MessageMicro<FeedCloudTagbasesvr$StListTagBaseInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"filter", "sort", "pageSize", "pageCurrent", "sortType"}, new Object[]{null, 0, 0, 0, 0}, FeedCloudTagbasesvr$StListTagBaseInfoReq.class);
    public FeedCloudTagbasesvr$StListFilter filter = new MessageMicro<FeedCloudTagbasesvr$StListFilter>() { // from class: feedcloud.FeedCloudTagbasesvr$StListFilter
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 800}, new String[]{"tagStatuss", "tagCategorys", "tagTypes", "startDay", "endDay", "search", "appid"}, new Object[]{0, "", 0, "", "", "", 0}, FeedCloudTagbasesvr$StListFilter.class);
        public final PBInt32Field appid;
        public final PBStringField endDay;
        public final PBStringField search;
        public final PBStringField startDay;
        public final PBRepeatField<String> tagCategorys;
        public final PBRepeatField<Integer> tagStatuss;
        public final PBRepeatField<Integer> tagTypes;

        {
            PBEnumField pBEnumField = PBEnumField.__repeatHelper__;
            this.tagStatuss = PBField.initRepeat(pBEnumField);
            this.tagCategorys = PBField.initRepeat(PBStringField.__repeatHelper__);
            this.tagTypes = PBField.initRepeat(pBEnumField);
            this.startDay = PBField.initString("");
            this.endDay = PBField.initString("");
            this.search = PBField.initString("");
            this.appid = PBField.initInt32(0);
        }
    };
    public final PBEnumField sort = PBField.initEnum(0);
    public final PBInt32Field pageSize = PBField.initInt32(0);
    public final PBInt32Field pageCurrent = PBField.initInt32(0);
    public final PBEnumField sortType = PBField.initEnum(0);
}
