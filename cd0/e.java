package cd0;

import com.tencent.biz.qqstory.network.pb.qqstory_service$ReqGetWeather;
import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetWeather;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends com.tencent.biz.qqstory.channel.c<dd0.e> {

    /* renamed from: i, reason: collision with root package name */
    private static final String f30718i = xc0.c.d("StorySvc.get_weather");

    /* renamed from: f, reason: collision with root package name */
    public final int f30719f;

    /* renamed from: g, reason: collision with root package name */
    public final int f30720g;

    /* renamed from: h, reason: collision with root package name */
    public final int f30721h;

    public e(int i3, int i16, int i17) {
        this.f30719f = i3;
        this.f30720g = i16;
        this.f30721h = i17;
    }

    @Override // com.tencent.biz.qqstory.channel.c
    public String a() {
        return f30718i;
    }

    @Override // com.tencent.biz.qqstory.channel.c
    public com.tencent.biz.qqstory.channel.a c(byte[] bArr) {
        qqstory_service$RspGetWeather qqstory_service_rspgetweather = new qqstory_service$RspGetWeather();
        try {
            qqstory_service_rspgetweather.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return new dd0.e(qqstory_service_rspgetweather);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.channel.c
    public byte[] d() {
        qqstory_service$ReqGetWeather qqstory_service_reqgetweather = new qqstory_service$ReqGetWeather();
        qqstory_service_reqgetweather.coordinate.set(this.f30719f);
        qqstory_service_reqgetweather.longitude.set(this.f30720g);
        qqstory_service_reqgetweather.latitude.set(this.f30721h);
        return qqstory_service_reqgetweather.toByteArray();
    }
}
