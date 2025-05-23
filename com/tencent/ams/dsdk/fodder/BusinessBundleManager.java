package com.tencent.ams.dsdk.fodder;

import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BusinessBundleManager extends ModuleBundleManager {
    static IPatchRedirector $redirector_ = null;
    private static final String BUSINESS_BUNDLE_NAME = "index.android.bundle.js";
    private static final String TAG = "BusinessBundleManager";
    private static volatile BusinessBundleManager sInstance;

    BusinessBundleManager() {
        super("business");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static BusinessBundleManager getInstance() {
        if (sInstance == null) {
            synchronized (BusinessBundleManager.class) {
                if (sInstance == null) {
                    sInstance = new BusinessBundleManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.fodder.ModuleBundleManager
    public void doClearCache(List<ModuleInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            for (ModuleInfo moduleInfo : ModuleConfigCache.getBusinessInfoList()) {
                if (isValidModule(moduleInfo) && !ModuleBundleManager.isContains(list, moduleInfo)) {
                    deleteModuleInfo(moduleInfo);
                }
            }
        }
        super.doClearCache(list);
    }

    public String getModuleBundleFilePath(String str, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? getModuleBundleFilePath(str, BUSINESS_BUNDLE_NAME, z16, j3) : (String) iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    @Override // com.tencent.ams.dsdk.fodder.ModuleBundleManager
    protected boolean isNeedDelete(File file, List<ModuleInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) file, (Object) list)).booleanValue();
        }
        if (file == null) {
            return true;
        }
        if (list == null || list.isEmpty()) {
            return false;
        }
        if (!isInModuleList(file, list) && FileUtils.isExpireFile(file, DKConfiguration.getBundleExpireTime())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.fodder.ModuleBundleManager
    protected boolean isValidModule(ModuleInfo moduleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) moduleInfo)).booleanValue();
        }
        if (moduleInfo != null && moduleInfo.isBusiness() && !TextUtils.isEmpty(moduleInfo.getId()) && !TextUtils.isEmpty(moduleInfo.getUrl()) && !TextUtils.isEmpty(moduleInfo.getName())) {
            return true;
        }
        return false;
    }

    public String getModuleBundleFilePath(ModuleInfo moduleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getModuleBundleFilePath(moduleInfo, BUSINESS_BUNDLE_NAME, false, 0L) : (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) moduleInfo);
    }
}
