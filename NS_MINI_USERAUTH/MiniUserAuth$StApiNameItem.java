package NS_MINI_USERAUTH;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniUserAuth$StApiNameItem extends MessageMicro<MiniUserAuth$StApiNameItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{AdMetricTag.EVENT_NAME, "apiName"}, new Object[]{"", ""}, MiniUserAuth$StApiNameItem.class);
    public final PBStringField eventName = PBField.initString("");
    public final PBStringField apiName = PBField.initString("");
}
