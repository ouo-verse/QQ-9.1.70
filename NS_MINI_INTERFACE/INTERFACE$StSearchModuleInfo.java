package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.servlet.MiniAppSearchAppServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSearchModuleInfo extends MessageMicro<INTERFACE$StSearchModuleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{MiniAppSearchAppServlet.KEY_SEARCH_APP, "keywords"}, new Object[]{null, ""}, INTERFACE$StSearchModuleInfo.class);
    public INTERFACE$StUserAppInfo searchApp = new INTERFACE$StUserAppInfo();
    public final PBRepeatField<String> keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
}
