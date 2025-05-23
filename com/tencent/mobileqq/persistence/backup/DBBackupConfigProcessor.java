package com.tencent.mobileqq.persistence.backup;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class DBBackupConfigProcessor extends l<a> {

    /* loaded from: classes16.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f258308a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f258309b = 100;

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            boolean z16;
            QLog.d("DBBackupConfigProcessor", 1, "Config parse configText -> " + str);
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("backup_master_switch", 0) == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.f258308a = z16;
                    this.f258309b = jSONObject.optInt("backup_master_threshold", 100);
                } catch (JSONException e16) {
                    QLog.e("DBBackupConfigProcessor", 1, e16, new Object[0]);
                }
            }
        }

        public int b() {
            return this.f258309b;
        }

        public boolean c() {
            return this.f258308a;
        }
    }

    public static a a() {
        a aVar = (a) am.s().x(769);
        if (aVar != null) {
            return aVar;
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        ai aiVar;
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            aVar.d(aiVar.f202268b);
        }
        return aVar;
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
    public boolean isNeedUpgradeReset() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 769;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
