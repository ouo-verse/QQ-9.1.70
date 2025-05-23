package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class RichmediaHttpsConfProcessor extends BaseConfigParser<a> {

    /* loaded from: classes10.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        public int f202476d = 1;

        public static a b(String str) {
            a aVar = new a();
            try {
            } catch (Throwable th5) {
                QLog.d("RichmediaHttpsConfProcessor", 2, "parse S$EConfBean failed!", th5);
            }
            if (TextUtils.isEmpty(str)) {
                return new a();
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("pic_down_https_switch")) {
                aVar.f202476d = jSONObject.optInt("pic_down_https_switch", 1);
            }
            if (QLog.isColorLevel()) {
                QLog.i("RichmediaHttpsConfProcessor", 2, "parse S$EConfBean: " + str);
            }
            return aVar;
        }

        public boolean a() {
            if (this.f202476d == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "RichmediaHttpsConfigBean{mPicDownHttpsSwitch=" + this.f202476d + '}';
        }
    }

    public static a d() {
        return (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101021");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a aVar) {
        super.doOnConfigUpdate(aVar);
        if (QLog.isColorLevel()) {
            QLog.d("RichmediaHttpsConfProcessor", 2, "doOnConfigUpdate");
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (QLog.isColorLevel()) {
            QLog.d("RichmediaHttpsConfProcessor", 2, "config: " + str);
        }
        return a.b(str);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public boolean isAccountRelated() {
        return false;
    }
}
