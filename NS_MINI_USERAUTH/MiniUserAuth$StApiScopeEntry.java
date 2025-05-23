package NS_MINI_USERAUTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniUserAuth$StApiScopeEntry extends MessageMicro<MiniUserAuth$StApiScopeEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{DTConstants.TAG.API, "scope"}, new Object[]{null, ""}, MiniUserAuth$StApiScopeEntry.class);
    public MiniUserAuth$StApiNameItem api = new MiniUserAuth$StApiNameItem();
    public final PBStringField scope = PBField.initString("");
}
