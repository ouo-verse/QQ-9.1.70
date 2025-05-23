package com.tencent.mobileqq.search.searchlocal.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.search.api.IFunctionConfigManager;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import tp2.a;

/* loaded from: classes18.dex */
public class SearchFunctionModuleProcessor extends l<a> {
    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        QLog.i("search_manager_configSearchFunctionModuleProcessor", 1, "[migrateOldOrDefaultContent] type=" + i3);
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        return a.c(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        String str;
        if (aVar == null) {
            str = null;
        } else {
            str = aVar.f437064d;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("search_manager_configSearchFunctionModuleProcessor", 1, "[onUpdate] fileUrl is empty");
            return;
        }
        ((FunctionConfigManagerImpl) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFunctionConfigManager.class, "all")).getFunctionListFile(str);
        QLog.i("search_manager_configSearchFunctionModuleProcessor", 1, "[onUpdate] fileUrl =" + str);
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
    public boolean isNeedUpgradeReset() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        QLog.i("search_manager_configSearchFunctionModuleProcessor", 1, "[onReqFailed] failCode=" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 190;
    }
}
