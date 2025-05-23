package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StBatchGetMusicInfoReq extends MessageMicro<CLIENT$StBatchGetMusicInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "vecSongMid", "needLyric"}, new Object[]{null, "", 0}, CLIENT$StBatchGetMusicInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatField<String> vecSongMid = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field needLyric = PBField.initUInt32(0);
}
