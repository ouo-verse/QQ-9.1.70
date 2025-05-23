package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetWeixinSDKAppInfoReq extends MessageMicro<INTERFACE$StGetWeixinSDKAppInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"code"}, new Object[]{""}, INTERFACE$StGetWeixinSDKAppInfoReq.class);
    public final PBStringField code = PBField.initString("");
}
