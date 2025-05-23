package com.tencent.hippy.qq.api.impl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.obj.HippyPadConfigBean;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyFontUtils;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippySettingImpl implements IHippySetting {
    private static final String TAG = "HippySettingImpl";
    private static volatile boolean gIsClearingCache = false;

    @NonNull
    private HippyPadConfigBean getHippyPadConfigBean() {
        return (HippyPadConfigBean) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.HIPPY_ANDROID_PAD, new HippyPadConfigBean());
    }

    private boolean isBundleInHippyPadList(String str) {
        List<String> list = getHippyPadConfigBean().bundleList;
        if (list != null && str != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public void clearCache() {
        QLog.i(TAG, 1, "Clear cache of hippy");
        gIsClearingCache = true;
        HippyDomNodeManagerImpl.INSTANCE.clearDomCache();
        HippyFontUtils.clearFontFiles();
        HippyQQFileUtil.clearJsBundles();
        HippyAccessHelper.onClearHippyCache();
        gIsClearingCache = false;
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public long getCacheSize() {
        ArrayList arrayList = new ArrayList();
        File hippyFile = HippyQQFileUtil.getHippyFile();
        arrayList.add(new File(hippyFile, "bundle"));
        arrayList.add(new File(hippyFile, HippyQQFileUtil.HIPPY_BUSINESS_DATA_DIR));
        arrayList.add(new File(hippyFile, HippyQQFileUtil.HIPPY_CODE_CACHE_DIR));
        arrayList.add(new File(hippyFile, "pkg"));
        arrayList.add(new File(hippyFile, HippyQQFileUtil.HIPPY_TAB_CONFIG_CACHE_DIR));
        arrayList.add(HippyQQFileUtil.getHippyFileByType(HippyDomNodeManagerImpl.FILE_TYPE));
        arrayList.add(new File(HippyUtils.getHippyFontRootDir()));
        Iterator it = arrayList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).getDirSize(((File) it.next()).getAbsolutePath());
        }
        return j3;
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public int getFixedWidth(String str) {
        int dip2px;
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "getFixedWidth isPadOrFoldDevice:", Boolean.valueOf(HippyUtils.isPadOrFoldDevice()));
        }
        if (!HippyUtils.isPadOrFoldDevice() || !isBundleInHippyPadList(str) || (dip2px = ViewUtils.dip2px(getHippyPadConfigBean().width)) <= 0) {
            return 0;
        }
        int screenSmallerSideWidth = com.tencent.hippy.qq.utils.ViewUtils.getScreenSmallerSideWidth();
        if (dip2px > screenSmallerSideWidth) {
            return screenSmallerSideWidth;
        }
        return dip2px;
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public File getHippyFileByType(String str) {
        return HippyQQFileUtil.getHippyFileByType(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public File getModuleFile(String str) {
        return HippyQQFileUtil.getModuleFile(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public File getModuleIndex(String str, int i3) {
        return HippyQQFileUtil.getModuleIndex(str, i3);
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public long getModuleIndexFileLength(String str, int i3) {
        File moduleIndex = getModuleIndex(str, i3);
        if (moduleIndex != null && moduleIndex.exists()) {
            return moduleIndex.length();
        }
        return -1L;
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public int getModuleVersion(String str) {
        return UpdateSetting.getInstance().getModuleVersion(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public boolean isClearingCache() {
        Bundle bundle;
        if (MobileQQ.sProcessId == 1) {
            return gIsClearingCache;
        }
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IHippyIPC.NAME, IHippyIPC.ACTION_IS_CLEARING_HIPPY_CACHE, null);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getBoolean(IHippyIPC.KEY_IS_CLEAR_HIPPY_CACHE);
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public void setModuleVersion(String str, int i3) {
        UpdateSetting.getInstance().setModuleVersion(str, i3);
    }

    @Override // com.tencent.hippy.qq.api.IHippySetting
    public File getModuleFile(String str, int i3) {
        return HippyQQFileUtil.getModuleFile(str, i3);
    }
}
