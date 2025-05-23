package NS_QQ_STORY_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StUinTime extends MessageMicro<CLIENT$StUinTime> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "newestTime"}, new Object[]{0L, 0L}, CLIENT$StUinTime.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field newestTime = PBField.initUInt64(0);
}
