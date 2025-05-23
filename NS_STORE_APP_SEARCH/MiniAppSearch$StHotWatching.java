package NS_STORE_APP_SEARCH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppSearch$StHotWatching extends MessageMicro<MiniAppSearch$StHotWatching> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"hotWords", "url"}, new Object[]{"", ""}, MiniAppSearch$StHotWatching.class);
    public final PBStringField hotWords = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
