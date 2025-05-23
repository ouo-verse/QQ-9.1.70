package expand.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AddMatchedRaletionReq extends MessageMicro<AddMatchedRaletionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"UserInfo", "MatchUserInfo"}, new Object[]{null, null}, AddMatchedRaletionReq.class);
    public MatchedInfo UserInfo = new MatchedInfo();
    public MatchedInfo MatchUserInfo = new MatchedInfo();
}
