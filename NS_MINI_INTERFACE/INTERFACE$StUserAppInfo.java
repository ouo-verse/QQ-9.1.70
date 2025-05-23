package NS_MINI_INTERFACE;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StUserAppInfo extends MessageMicro<INTERFACE$StUserAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 64, 74, 82, 90, 96, 104, 114}, new String[]{"appInfo", "useTime", "putTop", "doLike", "likeNum", "enablePush", "openid", "tinyid", "bgPic", "motionPics", "apngUrl", "userNum", ComicCancelRedPointPopItemData.JSON_KEY_FRIEND_NUM, "users"}, new Object[]{null, 0, 0, 0, 0, 0, "", 0L, "", null, "", 0, 0, null}, INTERFACE$StUserAppInfo.class);
    public INTERFACE$StApiAppInfo appInfo = new INTERFACE$StApiAppInfo();
    public final PBUInt32Field useTime = PBField.initUInt32(0);
    public final PBUInt32Field putTop = PBField.initUInt32(0);
    public final PBUInt32Field doLike = PBField.initUInt32(0);
    public final PBUInt32Field likeNum = PBField.initUInt32(0);
    public final PBUInt32Field enablePush = PBField.initUInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBStringField bgPic = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StMotionPicInfo> motionPics = PBField.initRepeatMessage(INTERFACE$StMotionPicInfo.class);
    public final PBStringField apngUrl = PBField.initString("");
    public final PBUInt32Field userNum = PBField.initUInt32(0);
    public final PBUInt32Field friendNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<INTERFACE$UseUserInfo> users = PBField.initRepeatMessage(INTERFACE$UseUserInfo.class);
}
