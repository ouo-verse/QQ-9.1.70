package ktvchannel;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Mem$MikeIndex extends MessageMicro<Mem$MikeIndex> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"uid", "mike_id", "mike_settop_stat", "mike_type", INetChannelCallback.KEY_TINY_ID}, new Object[]{0L, "", 0, 0, 0L}, Mem$MikeIndex.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField mike_id = PBField.initString("");
    public final PBInt32Field mike_settop_stat = PBField.initInt32(0);
    public final PBInt32Field mike_type = PBField.initInt32(0);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
}
