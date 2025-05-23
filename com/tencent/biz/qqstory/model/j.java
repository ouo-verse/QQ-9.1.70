package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.b;
import com.tencent.biz.qqstory.model.lbs.LbsManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j extends com.tencent.biz.qqstory.model.c<c> {

    /* renamed from: d, reason: collision with root package name */
    private long f94046d;

    /* renamed from: e, reason: collision with root package name */
    private LbsManager.b f94047e = new a();

    /* renamed from: f, reason: collision with root package name */
    protected boolean f94048f;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements LbsManager.b {
        a() {
        }

        @Override // com.tencent.biz.qqstory.model.lbs.LbsManager.b
        public void a(boolean z16, com.tencent.biz.qqstory.model.lbs.a aVar) {
            hd0.c.a("WeatherDataProvider", "WeatherLbsListener: onLbsUpdate, isSuccess=" + z16);
            if (z16 && aVar != null) {
                j.this.l(aVar.f94079b, aVar.f94078a);
            } else {
                j.this.b(false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements b.InterfaceC0941b<cd0.e, dd0.e> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v2, types: [DATA, com.tencent.biz.qqstory.model.j$c] */
        @Override // com.tencent.biz.qqstory.channel.b.InterfaceC0941b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void v(@NonNull cd0.e eVar, @Nullable dd0.e eVar2, @NonNull ErrorMessage errorMessage) {
            hd0.c.a("WeatherDataProvider", "requestWeather Cmd Respond.");
            if (errorMessage.isSuccess() && eVar2 != null) {
                hd0.c.b("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(eVar2.f393631c));
                j.this.f94038a = new c(eVar2.f393631c, eVar2.f393632d);
                hd0.c.k("WeatherDataProvider", "update local weather data.");
                h hVar = (h) i.c(10);
                hVar.m("edit_video_weather_filter_data", Integer.valueOf(eVar2.f393631c));
                hVar.m("edit_video_weather_desc", eVar2.f393632d);
                j.this.f94046d = System.currentTimeMillis() + 14400000;
                hVar.m("edit_video_weather_expiry_time", Long.valueOf(j.this.f94046d));
                j jVar = j.this;
                jVar.b(true, (c) jVar.f94038a);
            } else {
                hd0.c.v("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", errorMessage, eVar);
                j.this.b(false, null);
            }
            j.this.f94048f = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f94051a;

        /* renamed from: b, reason: collision with root package name */
        public final String f94052b;

        public c(int i3, String str) {
            this.f94051a = i3;
            this.f94052b = str;
        }
    }

    public j() {
        k();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [DATA, com.tencent.biz.qqstory.model.j$c] */
    private void k() {
        h hVar = (h) i.c(10);
        long longValue = ((Long) hVar.j("edit_video_weather_expiry_time", 0L)).longValue();
        this.f94046d = longValue;
        if (longValue >= System.currentTimeMillis()) {
            int intValue = ((Integer) hVar.j("edit_video_weather_filter_data", -999)).intValue();
            String str = (String) hVar.j("edit_video_weather_desc", "");
            if (intValue != -999 && !TextUtils.isEmpty(str)) {
                hd0.c.n("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(intValue), Long.valueOf(this.f94046d), Long.valueOf(System.currentTimeMillis()));
                this.f94038a = new c(intValue, str);
                return;
            }
        }
        hd0.c.t("WeatherDataProvider", "no valid local weather data.");
    }

    @Override // com.tencent.biz.qqstory.model.c
    protected void a(com.tencent.biz.qqstory.model.lbs.a aVar) {
        hd0.c.a("WeatherDataProvider", "requestWeather.");
        if (this.f94048f) {
            hd0.c.a("WeatherDataProvider", "is request ing....");
            return;
        }
        this.f94048f = true;
        LbsManager lbsManager = (LbsManager) i.c(9);
        if (aVar == null) {
            aVar = lbsManager.d();
        }
        if (aVar != null) {
            l(aVar.f94079b, aVar.f94078a);
        } else {
            lbsManager.f(this.f94047e);
            lbsManager.g();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c j() {
        long j3 = this.f94046d;
        if (j3 != 0 && j3 < System.currentTimeMillis()) {
            return (c) this.f94038a;
        }
        return null;
    }

    protected void l(int i3, int i16) {
        hd0.c.c("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(i3), Integer.valueOf(i16));
        com.tencent.biz.qqstory.channel.b.a().b(new cd0.e(1, i3, i16), new b());
    }
}
