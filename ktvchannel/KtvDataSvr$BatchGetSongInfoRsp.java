package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$BatchGetSongInfoRsp extends MessageMicro<KtvDataSvr$BatchGetSongInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"song_list", "msg"}, new Object[]{null, null}, KtvDataSvr$BatchGetSongInfoRsp.class);
    public final PBRepeatMessageField<KtvDataSvr$SongItem> song_list = PBField.initRepeatMessage(KtvDataSvr$SongItem.class);

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413017msg = new KtvCommon$ErrMsg();
}
