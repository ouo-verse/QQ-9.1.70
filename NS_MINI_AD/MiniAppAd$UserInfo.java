package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$UserInfo extends MessageMicro<MiniAppAd$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"qq", "wx_appid", "wx_openid", "media_specified_id", "qq_appid", "qq_openid"}, new Object[]{0L, "", "", "", 0L, ""}, MiniAppAd$UserInfo.class);

    /* renamed from: qq, reason: collision with root package name */
    public final PBUInt64Field f24939qq = PBField.initUInt64(0);
    public final PBStringField wx_appid = PBField.initString("");
    public final PBStringField wx_openid = PBField.initString("");
    public final PBStringField media_specified_id = PBField.initString("");
    public final PBUInt64Field qq_appid = PBField.initUInt64(0);
    public final PBStringField qq_openid = PBField.initString("");
}
