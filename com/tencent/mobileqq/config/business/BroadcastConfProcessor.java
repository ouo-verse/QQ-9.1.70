package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class BroadcastConfProcessor extends com.tencent.mobileqq.config.l<a> {

    /* loaded from: classes10.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        public ArraySet<String> f202431d = new ArraySet<>();

        public static a a(String str) {
            a aVar = new a();
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray(MobileQQ.PREF_WHITE_LIST_KEY);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    aVar.f202431d.add(jSONArray.optString(i3, ""));
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("BroadcastConfProcessor", 2, th5, new Object[0]);
                }
            }
            return aVar;
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("BroadcastConfProcessor", 2, "onParsed");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + str);
            }
            a a16 = a.a(str);
            if (!TextUtils.isEmpty(str)) {
                BaseApplicationImpl.getApplication().getSharedPreferences(MobileQQ.PREF_BROADCAST, 4).edit().putString(MobileQQ.PREF_WHITE_LIST_KEY, str).apply();
                MobileQQ.addBroadcastWhitList(a16.f202431d);
            }
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("BroadcastConfProcessor", 2, "onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    @androidx.annotation.Nullable
    public com.tencent.mobileqq.config.ai migrateToFreesia(@androidx.annotation.NonNull com.tencent.mobileqq.config.ai[] aiVarArr) {
        for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
            QLog.d("BroadcastConfProcessor", 1, "local config: " + aiVar.f202268b);
        }
        if (aiVarArr.length > 0) {
            return aiVarArr[0];
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 567;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
