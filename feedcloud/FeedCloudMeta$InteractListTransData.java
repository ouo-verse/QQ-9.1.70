package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$InteractListTransData extends MessageMicro<FeedCloudMeta$InteractListTransData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{"ext_info", "commcount_round", "topped_uins", "cursor", "user_cache", ServiceConst.PARA_SESSION_ID, "remove_dup_uids"}, new Object[]{null, "", "", 0, null, "", ""}, FeedCloudMeta$InteractListTransData.class);
    public final PBInt32Field cursor;
    public final PBRepeatField<String> remove_dup_uids;
    public final PBStringField session_id;
    public final PBRepeatField<String> topped_uins;
    public final PBRepeatMessageField<FeedCloudMeta$StUser> user_cache;
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBStringField commcount_round = PBField.initString("");

    public FeedCloudMeta$InteractListTransData() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.topped_uins = PBField.initRepeat(pBStringField);
        this.cursor = PBField.initInt32(0);
        this.user_cache = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
        this.session_id = PBField.initString("");
        this.remove_dup_uids = PBField.initRepeat(pBStringField);
    }
}
