package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacGetWindowStateRsp extends MessageMicro<VacAdvGetAccess$VacGetWindowStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "state_info"}, new Object[]{0, "", null}, VacAdvGetAccess$VacGetWindowStateRsp.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public StateInfo state_info = new StateInfo();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class StateInfo extends MessageMicro<StateInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"state", "content_name", "media_name", "image_url"}, new Object[]{0, "", "", ""}, StateInfo.class);
        public final PBInt32Field state = PBField.initInt32(0);
        public final PBStringField content_name = PBField.initString("");
        public final PBStringField media_name = PBField.initString("");
        public final PBStringField image_url = PBField.initString("");
    }
}
