package cd0;

import com.tencent.biz.qqstory.network.pb.qqstory_service$ReqGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct$GpsMsg;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends com.tencent.biz.qqstory.channel.c<dd0.d> {

    /* renamed from: f, reason: collision with root package name */
    public final int f30715f;

    /* renamed from: g, reason: collision with root package name */
    public final int f30716g;

    /* renamed from: h, reason: collision with root package name */
    public final int f30717h = 1;

    public d(int i3, int i16) {
        this.f30715f = i3;
        this.f30716g = i16;
    }

    @Override // com.tencent.biz.qqstory.channel.c
    public String a() {
        return xc0.c.d("StorySvc.video_poi_posters_get");
    }

    @Override // com.tencent.biz.qqstory.channel.c
    public com.tencent.biz.qqstory.channel.a c(byte[] bArr) {
        qqstory_service$RspGetPOIPosters qqstory_service_rspgetpoiposters = new qqstory_service$RspGetPOIPosters();
        try {
            qqstory_service_rspgetpoiposters.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return new dd0.d(qqstory_service_rspgetpoiposters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.channel.c
    public byte[] d() {
        qqstory_service$ReqGetPOIPosters qqstory_service_reqgetpoiposters = new qqstory_service$ReqGetPOIPosters();
        qqstory_struct$GpsMsg qqstory_struct_gpsmsg = new qqstory_struct$GpsMsg();
        qqstory_struct_gpsmsg.lng.set(this.f30715f);
        qqstory_struct_gpsmsg.lat.set(this.f30716g);
        qqstory_service_reqgetpoiposters.coordinate.set(this.f30717h);
        qqstory_service_reqgetpoiposters.gps.set(qqstory_struct_gpsmsg);
        return qqstory_service_reqgetpoiposters.toByteArray();
    }
}
