package com.tencent.mobileqq.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class MigrateBlackListParser extends BaseConfigParser<a> {

    /* renamed from: d, reason: collision with root package name */
    private static a f202239d;

    /* loaded from: classes10.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        private Set<String> f202240d;

        /* JADX INFO: Access modifiers changed from: private */
        public static a c(@NonNull byte[] bArr) {
            a aVar = new a();
            try {
                JSONArray optJSONArray = new JSONObject(new String(bArr)).optJSONArray("blacklist");
                if (optJSONArray == null) {
                    return aVar;
                }
                aVar.f202240d = new HashSet();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    aVar.f202240d.add(optJSONArray.getString(i3));
                }
                return aVar;
            } catch (JSONException e16) {
                QLog.e("MigrateBlackListParser", 1, e16, new Object[0]);
                return aVar;
            }
        }

        public boolean b(String str) {
            Set<String> set = this.f202240d;
            if (set != null && set.contains(str)) {
                return true;
            }
            return false;
        }
    }

    public static boolean d(String str) {
        a aVar = f202239d;
        if (aVar == null) {
            aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100418");
            f202239d = aVar;
        }
        if (aVar != null && aVar.b(str)) {
            return true;
        }
        return false;
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
        f202239d = aVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        return a.c(bArr);
    }
}
