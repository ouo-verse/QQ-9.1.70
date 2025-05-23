package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$ScoreInfo extends MessageMicro<KtvKaraokeMikeSvr$ScoreInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"total_score", "sentence_count", "sing_type"}, new Object[]{0, 0, 0}, KtvKaraokeMikeSvr$ScoreInfo.class);
    public final PBInt32Field total_score = PBField.initInt32(0);
    public final PBUInt32Field sentence_count = PBField.initUInt32(0);
    public final PBInt32Field sing_type = PBField.initInt32(0);
}
