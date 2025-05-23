package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class INTERFACE$MiniGamePopup extends MessageMicro<INTERFACE$MiniGamePopup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, INTERFACE$MiniGamePopup.class);
    public final PBRepeatMessageField<INTERFACE$PopupInfo> infos = PBField.initRepeatMessage(INTERFACE$PopupInfo.class);
}
