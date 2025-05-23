package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import NS_QQ_STORY_META.META$StMusic;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StSmartMatchMusicRsp extends MessageMicro<CLIENT$StSmartMatchMusicRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "vecMusic"}, new Object[]{null, null}, CLIENT$StSmartMatchMusicRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<META$StMusic> vecMusic = PBField.initRepeatMessage(META$StMusic.class);
}
