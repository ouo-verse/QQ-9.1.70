package cd0;

import com.tencent.biz.qqstory.network.pb.qqstory_service$ReqGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetMusicListConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends com.tencent.biz.qqstory.channel.c<dd0.c> {

    /* renamed from: f, reason: collision with root package name */
    private static final String f30714f = xc0.c.d("StorySvc.video_music_get");

    @Override // com.tencent.biz.qqstory.channel.c
    public String a() {
        return f30714f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.channel.c
    public byte[] d() {
        return new MessageMicro<qqstory_service$ReqGetMusicListConfig>() { // from class: com.tencent.biz.qqstory.network.pb.qqstory_service$ReqGetMusicListConfig
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"version"}, new Object[]{0}, qqstory_service$ReqGetMusicListConfig.class);
            public final PBUInt32Field version = PBField.initUInt32(0);
        }.toByteArray();
    }

    @Override // com.tencent.biz.qqstory.channel.c
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public dd0.c c(byte[] bArr) {
        qqstory_service$RspGetMusicListConfig qqstory_service_rspgetmusiclistconfig = new qqstory_service$RspGetMusicListConfig();
        try {
            qqstory_service_rspgetmusiclistconfig.mergeFrom(bArr);
            return new dd0.c(qqstory_service_rspgetmusiclistconfig);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
