package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$SearchSongReq extends MessageMicro<KtvDataSvr$SearchSongReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"keywords", "pass_back"}, new Object[]{"", ""}, KtvDataSvr$SearchSongReq.class);
    public final PBStringField keywords = PBField.initString("");
    public final PBStringField pass_back = PBField.initString("");
}
