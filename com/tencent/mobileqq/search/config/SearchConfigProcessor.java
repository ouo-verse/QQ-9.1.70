package com.tencent.mobileqq.search.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public class SearchConfigProcessor extends l<ap2.c> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ap2.c migrateOldOrDefaultContent(int i3) {
        QLog.i("search_manager_configSearchConfigProcessor", 1, "[migrateOldOrDefaultContent] type=" + i3);
        return new ap2.c();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ap2.c onParsed(ai[] aiVarArr) {
        return ap2.c.a(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(ap2.c cVar) {
        String str;
        String str2 = null;
        if (cVar == null) {
            str = null;
        } else {
            str = cVar.f26682a;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("search_manager_configSearchConfigProcessor", 1, "[onUpdate] configContent is empty");
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            str2 = waitAppRuntime.getCurrentUin();
        }
        if (!TextUtils.isEmpty(str2)) {
            SearchConfigManager.e(str2, str);
        }
        QLog.i("search_manager_configSearchConfigProcessor", 1, "[onUpdate] configContent =" + str);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ap2.c> clazz() {
        return ap2.c.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return false;
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
    public void onReqFailed(int i3) {
        QLog.i("search_manager_configSearchConfigProcessor", 1, "[onReqFailed] failCode=" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 50;
    }
}
