package dd0;

import com.tencent.biz.qqstory.network.pb.qqstory_service$RspGetWeather;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends com.tencent.biz.qqstory.channel.a {

    /* renamed from: c, reason: collision with root package name */
    public final int f393631c;

    /* renamed from: d, reason: collision with root package name */
    public final String f393632d;

    public e(qqstory_service$RspGetWeather qqstory_service_rspgetweather) {
        this.f393631c = qqstory_service_rspgetweather.temperature.get();
        this.f393632d = qqstory_service_rspgetweather.wea_desc.get();
    }
}
