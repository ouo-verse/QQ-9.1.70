package com.tencent.gdtad.splash.mcconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.freesia.NetworkResult;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class GdtSplashAdPreloadConfigParser extends BaseConfigParser<a> {

    /* loaded from: classes6.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        public int f109382d = 1;

        /* renamed from: e, reason: collision with root package name */
        public int f109383e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f109384f = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f109385h = 1;

        /* renamed from: i, reason: collision with root package name */
        public int f109386i = 1;

        /* renamed from: m, reason: collision with root package name */
        public boolean f109387m = false;
        public boolean C = false;
        public boolean D = false;
        public int E = 120;

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("preloadCountPerStart");
                if (optInt > 0) {
                    aVar.f109382d = optInt;
                }
                int optInt2 = jSONObject.optInt("preloadCountPerDay");
                if (optInt2 > 0) {
                    aVar.f109383e = optInt2;
                }
                int optInt3 = jSONObject.optInt("preloadIntervalSeconds");
                if (optInt3 > 0) {
                    aVar.f109384f = optInt3;
                }
                int optInt4 = jSONObject.optInt("allowPreloadNonVideoNetType");
                if (optInt4 > 0) {
                    aVar.f109385h = optInt4;
                }
                int optInt5 = jSONObject.optInt("allowPreloadVideoNetType");
                if (optInt5 > 0) {
                    aVar.f109386i = optInt5;
                }
                aVar.f109387m = jSONObject.optBoolean("allowBackgroundPreload");
                aVar.C = jSONObject.optBoolean("allowBackgroundImagePreload");
                aVar.D = jSONObject.optBoolean("allowBackgroundVideoPreload");
                int optInt6 = jSONObject.optInt("preloadDelaySeconds");
                if (optInt6 > 0) {
                    aVar.E = optInt6;
                }
                return aVar;
            } catch (Exception e16) {
                QLog.e("GdtSplashAdPreloadConfigParser", 1, "parseFromJson, exp=" + e16.toString() + ", jsonStr=" + str);
                return new a();
            }
        }

        public String toString() {
            return "{preloadCountPerStart=" + this.f109382d + ", preloadCountPerDay=" + this.f109383e + ", preloadIntervalSeconds=" + this.f109384f + ", allowPreloadNonVideoNetType=" + this.f109385h + ", allowPreloadVideoNetType=" + this.f109386i + ", allowBackgroundPreload=" + this.f109387m + ", allowBackgroundImagePreload=" + this.C + ", allowBackgroundVideoPreload=" + this.D + ", preloadDelaySeconds=" + this.E + '}';
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        a aVar = new a();
        QLog.i("GdtSplashAdPreloadConfigParser", 1, "defaultConfig, cfg=" + aVar + ", cfg.hash=" + aVar.hashCode());
        return aVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a aVar) {
        super.doOnConfigUpdate(aVar);
        QLog.i("GdtSplashAdPreloadConfigParser", 1, "doOnConfigUpdate, cfg=" + aVar + ", cfg.hash=" + aVar.hashCode());
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str = new String(bArr, StandardCharsets.UTF_8);
                    a a16 = a.a(str);
                    QLog.i("GdtSplashAdPreloadConfigParser", 1, "parse, cfgStr=" + str + ", cfg=" + a16 + ", cfg.hash=" + a16.hashCode());
                    return a16;
                }
            } catch (Exception e16) {
                QLog.e("GdtSplashAdPreloadConfigParser", 1, "parse, exp=" + e16.toString());
            }
        }
        QLog.i("GdtSplashAdPreloadConfigParser", 1, "parse, cfgStr is empty");
        a aVar = new a();
        QLog.i("GdtSplashAdPreloadConfigParser", 1, "parse, defaultCfg=" + aVar + ", cfg.hash=" + aVar.hashCode());
        return aVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(@NonNull NetworkResult networkResult) {
        super.onReceiveNotUpdate(networkResult);
        if (QLog.isColorLevel()) {
            QLog.i("GdtSplashAdPreloadConfigParser", 2, "onReceiveNotUpdate");
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        super.onRemoved();
        QLog.i("GdtSplashAdPreloadConfigParser", 1, "onRemoved");
    }
}
