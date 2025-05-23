package cd0;

import com.tencent.biz.qqstory.network.pb.qqstory_service$ReqGetLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetLocation;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends com.tencent.biz.qqstory.channel.c<dd0.b> {

    /* renamed from: i, reason: collision with root package name */
    private static final String f30710i = xc0.c.d("StorySvc.get_location");

    /* renamed from: f, reason: collision with root package name */
    public final int f30711f;

    /* renamed from: g, reason: collision with root package name */
    public final int f30712g;

    /* renamed from: h, reason: collision with root package name */
    public final int f30713h;

    public b(int i3, int i16, int i17) {
        this.f30711f = i3;
        this.f30712g = i16;
        this.f30713h = i17;
    }

    @Override // com.tencent.biz.qqstory.channel.c
    public String a() {
        return f30710i;
    }

    @Override // com.tencent.biz.qqstory.channel.c
    public com.tencent.biz.qqstory.channel.a c(byte[] bArr) {
        qqstory_service$RspGetLocation qqstory_service_rspgetlocation = new qqstory_service$RspGetLocation();
        try {
            qqstory_service_rspgetlocation.mergeFrom(bArr);
            return new dd0.b(qqstory_service_rspgetlocation);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.channel.c
    public byte[] d() {
        qqstory_service$ReqGetLocation qqstory_service_reqgetlocation = new qqstory_service$ReqGetLocation();
        qqstory_service_reqgetlocation.coordinate.set(this.f30711f);
        qqstory_service_reqgetlocation.gps.lng.set(this.f30712g);
        qqstory_service_reqgetlocation.gps.lat.set(this.f30713h);
        qqstory_service_reqgetlocation.gps.setHasFlag(true);
        return qqstory_service_reqgetlocation.toByteArray();
    }

    public String toString() {
        return "GetLocationRequest{mCoordinate=" + this.f30711f + ", mLng=" + this.f30712g + ", mLat=" + this.f30713h + '}';
    }
}
