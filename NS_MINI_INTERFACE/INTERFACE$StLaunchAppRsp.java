package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StLaunchAppRsp extends MessageMicro<INTERFACE$StLaunchAppRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"miniGameBox", "miniGameFloat", "miniGamePopup"}, new Object[]{null, null, null}, INTERFACE$StLaunchAppRsp.class);
    public INTERFACE$MiniGameBox miniGameBox = new INTERFACE$MiniGameBox();
    public INTERFACE$MiniGameFloat miniGameFloat = new INTERFACE$MiniGameFloat();
    public INTERFACE$MiniGamePopup miniGamePopup = new INTERFACE$MiniGamePopup();
}
