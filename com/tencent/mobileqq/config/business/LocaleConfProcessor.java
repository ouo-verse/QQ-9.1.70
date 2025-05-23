package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class LocaleConfProcessor extends com.tencent.mobileqq.config.l<a> {
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
        if (aiVarArr != null && aiVarArr.length > 0) {
            a a16 = a.a(aiVarArr[0].f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("LocaleConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return a16;
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.f202433a)) {
            LocaleManager.isConfShowEntrance = "1".equals(aVar.f202433a);
        }
        if (QLog.isColorLevel()) {
            QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + LocaleManager.isConfShowEntrance);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
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
    public int type() {
        return 552;
    }

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f202433a;

        public a() {
            this.f202433a = "";
        }

        public static a a(String str) {
            try {
                String optString = new JSONObject(str).optString("ShowLocaleEntrance");
                if (QLog.isColorLevel()) {
                    QLog.e("LocaleConfProcessor", 2, "manager parse, showEntrance: " + optString);
                }
                return new a(optString.trim());
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public a(String str) {
            this.f202433a = str;
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
