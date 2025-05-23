package com.tencent.gdtad.splash.mcconfig;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.freesia.NetworkResult;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class GdtSplashAdSwitchConfigParser extends BaseConfigParser<a> {

    /* loaded from: classes6.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        public int f109388d = 500;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<String> f109389e = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name */
        public int f109390f = 0;

        /* renamed from: h, reason: collision with root package name */
        public boolean f109391h = false;

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("transitionPageDisplayMillis");
                if (optInt > 0) {
                    aVar.f109388d = optInt;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("invalidOrderId");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        String optString = optJSONArray.optString(i3);
                        if (!TextUtils.isEmpty(optString)) {
                            aVar.f109389e.add(optString);
                        }
                    }
                }
                int optInt2 = jSONObject.optInt("emptyOrderReportPerDay");
                if (optInt2 > 0) {
                    aVar.f109390f = optInt2;
                }
                aVar.f109391h = jSONObject.optBoolean("isReportHasVaildOrder", aVar.f109391h);
                return aVar;
            } catch (Exception e16) {
                QLog.e("GdtSplashAdSwitchConfigParser", 1, "parseFromJson, exp=" + e16.toString() + ", jsonStr=" + str);
                return new a();
            }
        }

        public String toString() {
            return "{transitionPageDisplayMillis=" + this.f109388d + ", ids=" + this.f109389e.toString() + ", emptyOrderReportPerDay=" + this.f109390f + ", isReportHasVaildOrder=" + this.f109391h + '}';
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        a aVar = new a();
        QLog.i("GdtSplashAdSwitchConfigParser", 1, "defaultConfig, cfg=" + aVar + ", cfg.hash=" + aVar.hashCode());
        return aVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a aVar) {
        super.doOnConfigUpdate(aVar);
        QLog.i("GdtSplashAdSwitchConfigParser", 1, "doOnConfigUpdate, cfg=" + aVar + ", cfg.hash=" + aVar.hashCode());
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
                    QLog.i("GdtSplashAdSwitchConfigParser", 1, "parse, cfgStr=" + str + ", cfg=" + a16 + ", cfg.hash=" + a16.hashCode());
                    return a16;
                }
            } catch (Exception e16) {
                QLog.e("GdtSplashAdSwitchConfigParser", 1, "parse, exp=" + e16.toString());
            }
        }
        QLog.i("GdtSplashAdSwitchConfigParser", 1, "parse, cfgStr is empty");
        a aVar = new a();
        QLog.i("GdtSplashAdSwitchConfigParser", 1, "parse, defaultCfg=" + aVar + ", cfg.hash=" + aVar.hashCode());
        return aVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceiveNotUpdate(@NonNull NetworkResult networkResult) {
        super.onReceiveNotUpdate(networkResult);
        if (QLog.isColorLevel()) {
            QLog.i("GdtSplashAdSwitchConfigParser", 2, "onReceiveNotUpdate");
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onRemoved() {
        super.onRemoved();
        QLog.i("GdtSplashAdSwitchConfigParser", 1, "onRemoved");
    }
}
