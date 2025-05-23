package dd0;

import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetLocation;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends com.tencent.biz.qqstory.channel.a {

    /* renamed from: c, reason: collision with root package name */
    public final String f393624c;

    /* renamed from: d, reason: collision with root package name */
    public final String f393625d;

    /* renamed from: e, reason: collision with root package name */
    public final String f393626e;

    /* renamed from: f, reason: collision with root package name */
    public final String f393627f;

    /* renamed from: g, reason: collision with root package name */
    public final String f393628g;

    public b(qqstory_service$RspGetLocation qqstory_service_rspgetlocation) {
        this.f393624c = qqstory_service_rspgetlocation.country.get().toStringUtf8();
        this.f393625d = qqstory_service_rspgetlocation.province.get().toStringUtf8();
        this.f393626e = qqstory_service_rspgetlocation.city.get().toStringUtf8();
        this.f393627f = qqstory_service_rspgetlocation.district.get().toStringUtf8();
        this.f393628g = qqstory_service_rspgetlocation.street.get().toStringUtf8();
    }

    public String toString() {
        return "GetLocationResponse{mCountry='" + this.f393624c + "', mProvince='" + this.f393625d + "', mCity='" + this.f393626e + "', mDistrict='" + this.f393627f + "', mStreet='" + this.f393628g + "'}";
    }
}
