package circlesearch;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StQueryReq extends MessageMicro<CircleSearchExhibition$StQueryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66}, new String[]{AppConstants.Key.SHARE_REQ_TYPE, "attach_info", "word", "query_type", "relation_uid", "ext_info", "filters", "correction_setting"}, new Object[]{0, "", "", 1, "", null, "", null}, CircleSearchExhibition$StQueryReq.class);
    public CircleSearchExhibition$CorrectionSetting correction_setting;
    public FeedCloudCommon$StCommonExt ext_info;
    public final PBRepeatField<String> filters;
    public final PBRepeatField<String> relation_uid;
    public final PBInt32Field req_type = PBField.initInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBStringField word = PBField.initString("");
    public final PBRepeatField<Integer> query_type = PBField.initRepeat(PBEnumField.__repeatHelper__);

    /* JADX WARN: Type inference failed for: r0v8, types: [circlesearch.CircleSearchExhibition$CorrectionSetting] */
    public CircleSearchExhibition$StQueryReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.relation_uid = PBField.initRepeat(pBStringField);
        this.ext_info = new FeedCloudCommon$StCommonExt();
        this.filters = PBField.initRepeat(pBStringField);
        this.correction_setting = new MessageMicro<CircleSearchExhibition$CorrectionSetting>() { // from class: circlesearch.CircleSearchExhibition$CorrectionSetting
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"disable_correction"}, new Object[]{Boolean.FALSE}, CircleSearchExhibition$CorrectionSetting.class);
            public final PBBoolField disable_correction = PBField.initBool(false);
        };
    }
}
