package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FeedbackReport$FeedbackRequest extends MessageMicro<FeedbackReport$FeedbackRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bid_info", "user_info", "content_items"}, new Object[]{null, null, null}, FeedbackReport$FeedbackRequest.class);
    public FeedbackReport$BidInfo bid_info = new MessageMicro<FeedbackReport$BidInfo>() { // from class: NS_CERTIFIED_ACCOUNT.FeedbackReport$BidInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bid", "bsign"}, new Object[]{"", ""}, FeedbackReport$BidInfo.class);
        public final PBStringField bid = PBField.initString("");
        public final PBStringField bsign = PBField.initString("");
    };
    public FeedbackReport$UserInfo user_info = new MessageMicro<FeedbackReport$UserInfo>() { // from class: NS_CERTIFIED_ACCOUNT.FeedbackReport$UserInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"uid", "qq", "openid", "imei", "idfa", "idfv"}, new Object[]{"", "", "", "", "", ""}, FeedbackReport$UserInfo.class);
        public final PBStringField uid = PBField.initString("");

        /* renamed from: qq, reason: collision with root package name */
        public final PBStringField f24932qq = PBField.initString("");
        public final PBStringField openid = PBField.initString("");
        public final PBStringField imei = PBField.initString("");
        public final PBStringField idfa = PBField.initString("");
        public final PBStringField idfv = PBField.initString("");
    };
    public final PBRepeatMessageField<FeedbackReport$ContentFeedbackItem> content_items = PBField.initRepeatMessage(FeedbackReport$ContentFeedbackItem.class);
}
