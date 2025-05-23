package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$BatchGetSongInfoReq extends MessageMicro<KtvDataSvr$BatchGetSongInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"song_mid_list", "info_mask"}, new Object[]{"", 0}, KtvDataSvr$BatchGetSongInfoReq.class);
    public final PBRepeatField<String> song_mid_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField info_mask = PBField.initEnum(0);
}
