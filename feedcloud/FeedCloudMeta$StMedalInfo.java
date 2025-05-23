package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StMedalInfo extends MessageMicro<FeedCloudMeta$StMedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField medalName = PBField.initString("");
    public final PBStringField medalID = PBField.initString("");
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBBoolField isHighLight = PBField.initBool(false);
    public final PBBoolField isNew = PBField.initBool(false);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
    public final PBStringField backgroundUrl = PBField.initString("");
    public final PBStringField describe = PBField.initString("");
    public final PBInt32Field reportValue = PBField.initInt32(0);
    public final PBInt64Field recieveTime = PBField.initInt64(0);
    public final PBStringField shortDescribe = PBField.initString("");
    public final PBStringField activityUrl = PBField.initString("");
    public final PBStringField activityDesc = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField invalidDesc = PBField.initString("");
    public final PBStringField restoreDesc = PBField.initString("");
    public final PBInt64Field invalidTime = PBField.initInt64(0);
    public final PBInt64Field restoreTime = PBField.initInt64(0);
    public final PBStringField shortInvalidDesc = PBField.initString("");
    public final PBStringField shortActivityDesc = PBField.initString("");

    static {
        String[] strArr = {"type", "medalName", "medalID", "rank", "isHighLight", "isNew", WadlProxyConsts.KEY_JUMP_URL, "iconUrl", "backgroundUrl", "describe", "reportValue", "recieveTime", "shortDescribe", "activityUrl", "activityDesc", "status", "invalidDesc", "restoreDesc", "invalidTime", "restoreTime", "shortInvalidDesc", "shortActivityDesc"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 66, 74, 82, 88, 96, 106, 114, 122, 128, 138, 146, 152, 160, 170, 178}, strArr, new Object[]{0, "", "", 0, bool, bool, "", "", "", "", 0, 0L, "", "", "", 0, "", "", 0L, 0L, "", ""}, FeedCloudMeta$StMedalInfo.class);
    }
}
