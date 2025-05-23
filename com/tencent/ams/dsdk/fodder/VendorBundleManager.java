package com.tencent.ams.dsdk.fodder;

import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VendorBundleManager extends ModuleBundleManager {
    static IPatchRedirector $redirector_ = null;
    private static final String VENDOR_BUNDLE_NAME = "vendor.android.bundle.js";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static final VendorBundleManager INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18708);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new VendorBundleManager(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ VendorBundleManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) anonymousClass1);
    }

    private List<ModuleInfo> getDependenciesModuleList(ModuleInfo moduleInfo) {
        List<String> dependencies;
        ArrayList arrayList = null;
        if (moduleInfo == null) {
            dependencies = null;
        } else {
            dependencies = moduleInfo.getDependencies();
        }
        if (dependencies != null && !dependencies.isEmpty()) {
            arrayList = new ArrayList();
            Iterator<String> it = dependencies.iterator();
            while (it.hasNext()) {
                ModuleInfo moduleInfo2 = ModuleConfigCache.getModuleInfo(it.next());
                if (moduleInfo2 != null) {
                    arrayList.add(moduleInfo2);
                }
            }
        }
        return arrayList;
    }

    public static VendorBundleManager getInstance() {
        return Holder.INSTANCE;
    }

    private boolean isDependency(ModuleInfo moduleInfo, List<ModuleInfo> list) {
        if (moduleInfo != null && list != null && !list.isEmpty()) {
            for (ModuleInfo moduleInfo2 : list) {
                if (moduleInfo2 != null && moduleInfo2.getDependencies() != null && moduleInfo2.getDependencies().contains(moduleInfo.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.fodder.ModuleBundleManager
    protected void doClearCache(List<ModuleInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            List<ModuleInfo> vendorInfoList = ModuleConfigCache.getVendorInfoList();
            List<ModuleInfo> businessInfoList = ModuleConfigCache.getBusinessInfoList();
            for (ModuleInfo moduleInfo : vendorInfoList) {
                if (isValidModule(moduleInfo) && !ModuleBundleManager.isContains(list, moduleInfo) && !isDependency(moduleInfo, businessInfoList)) {
                    deleteModuleInfo(moduleInfo);
                }
            }
        }
        super.doClearCache(list);
    }

    @Deprecated
    public String getVendorBundleFilePath(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? getModuleBundleFilePath(DKConfiguration.Directory.VENDOR, VENDOR_BUNDLE_NAME, z16, j3) : (String) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    @Override // com.tencent.ams.dsdk.fodder.ModuleBundleManager
    protected boolean isNeedDelete(File file, List<ModuleInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) file, (Object) list)).booleanValue();
        }
        if (file == null || list == null || list.isEmpty()) {
            return false;
        }
        Iterator<ModuleInfo> it = list.iterator();
        while (it.hasNext()) {
            if (isDependency(file, it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.ams.dsdk.fodder.ModuleBundleManager
    protected boolean isValidModule(ModuleInfo moduleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) moduleInfo)).booleanValue();
        }
        if (moduleInfo != null && moduleInfo.isVendor() && !TextUtils.isEmpty(moduleInfo.getId()) && !TextUtils.isEmpty(moduleInfo.getName()) && !TextUtils.isEmpty(moduleInfo.getUrl())) {
            return true;
        }
        return false;
    }

    VendorBundleManager() {
        super(DKConfiguration.Directory.VENDOR);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String getVendorBundleFilePath(String str, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getModuleBundleFilePath(str, VENDOR_BUNDLE_NAME, z16, j3) : (String) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    public String getVendorBundleFilePath(ModuleInfo moduleInfo, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? getModuleBundleFilePath(moduleInfo, VENDOR_BUNDLE_NAME, z16, j3) : (String) iPatchRedirector.redirect((short) 4, this, moduleInfo, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    private boolean isDependency(File file, ModuleInfo moduleInfo) {
        List<ModuleInfo> dependenciesModuleList;
        if (file == null || (dependenciesModuleList = getDependenciesModuleList(moduleInfo)) == null || dependenciesModuleList.isEmpty()) {
            return false;
        }
        return isInModuleList(file, dependenciesModuleList);
    }
}
