package NS_MINI_USERAUTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniUserAuth$StApiScopeConfig extends MessageMicro<MiniUserAuth$StApiScopeConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"scopeList", "apiToScope"}, new Object[]{null, null}, MiniUserAuth$StApiScopeConfig.class);
    public final PBRepeatMessageField<MiniUserAuth$StUserAuthScope> scopeList = PBField.initRepeatMessage(MiniUserAuth$StUserAuthScope.class);
    public final PBRepeatMessageField<MiniUserAuth$StApiScopeEntry> apiToScope = PBField.initRepeatMessage(MiniUserAuth$StApiScopeEntry.class);
}
