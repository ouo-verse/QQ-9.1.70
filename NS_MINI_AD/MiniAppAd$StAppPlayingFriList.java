package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes.dex */
public final class MiniAppAd$StAppPlayingFriList extends MessageMicro<MiniAppAd$StAppPlayingFriList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"strAppId", "vecFriUin", "total"}, new Object[]{"", 0L, 0}, MiniAppAd$StAppPlayingFriList.class);
    public final PBStringField strAppId = PBField.initString("");
    public final PBRepeatField<Long> vecFriUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field total = PBField.initUInt32(0);
}
