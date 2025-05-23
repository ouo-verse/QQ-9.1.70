package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$StGetMemberStateRsp extends MessageMicro<MiniAppAd$StGetMemberStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"is_member", "freqctrl_in_second", "toast_text"}, new Object[]{Boolean.FALSE, 0, ""}, MiniAppAd$StGetMemberStateRsp.class);
    public final PBBoolField is_member = PBField.initBool(false);
    public final PBUInt32Field freqctrl_in_second = PBField.initUInt32(0);
    public final PBStringField toast_text = PBField.initString("");
}
