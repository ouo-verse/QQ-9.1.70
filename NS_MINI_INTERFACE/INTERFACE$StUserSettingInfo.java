package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StUserSettingInfo extends MessageMicro<INTERFACE$StUserSettingInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"settingItem", "desc", "authState", "subItems"}, new Object[]{"", "", 0, null}, INTERFACE$StUserSettingInfo.class);
    public final PBStringField settingItem = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field authState = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE$StSubscribeMessage> subItems = PBField.initRepeatMessage(INTERFACE$StSubscribeMessage.class);
}
