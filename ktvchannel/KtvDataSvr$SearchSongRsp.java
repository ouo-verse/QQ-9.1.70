package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$SearchSongRsp extends MessageMicro<KtvDataSvr$SearchSongRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"acc_list", "pass_back", "msg"}, new Object[]{null, "", null}, KtvDataSvr$SearchSongRsp.class);
    public final PBRepeatMessageField<KtvDataSvr$SongItem> acc_list = PBField.initRepeatMessage(KtvDataSvr$SongItem.class);
    public final PBStringField pass_back = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public KtvCommon$ErrMsg f413020msg = new KtvCommon$ErrMsg();
}
