package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.hippy.qq.adapter.image.decoder.AvifLibraryLoader;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AbiUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQLibraryManager {
    private static HippyQQLibraryManager INSTANCE = null;
    public static final int STATE_LOADED = 2;
    public static final int STATE_LOADING = 1;
    public static final int STATE_UNLOAD = 0;
    private String mCommonPackagePath;
    private String mHippySoName;
    private String[] mSoNames;
    private int mLoadState = 0;
    private Object mListenerLock = new Object();
    private List<LibraryLoadListener> mLibraryLoadListeners = new ArrayList();
    private HashMap<String, String> mLibraryVerions = new HashMap<>();

    HippyQQLibraryManager() {
        if (isUseAllInOneSo()) {
            this.mHippySoName = "hippy";
            this.mSoNames = new String[]{"flexbox", "hippy"};
        } else {
            String hippyBridgeSoName = getHippyBridgeSoName();
            this.mHippySoName = hippyBridgeSoName;
            this.mSoNames = new String[]{"flexbox", "v8_shared", hippyBridgeSoName};
        }
    }

    private void addLibraryLoadListener(LibraryLoadListener libraryLoadListener) {
        synchronized (this.mListenerLock) {
            if (libraryLoadListener != null) {
                if (!this.mLibraryLoadListeners.contains(libraryLoadListener)) {
                    this.mLibraryLoadListeners.add(libraryLoadListener);
                }
            }
        }
    }

    private void downloadHippySo() {
        String[] strArr;
        if (isUseAllInOneSo()) {
            strArr = new String[]{"flexbox", "hippy"};
        } else {
            strArr = new String[]{"flexbox", "v8_shared", getHippyBridgeSoName()};
        }
        SoLoadManager.getInstance().download(strArr, new OnLoadListener() { // from class: com.tencent.hippy.qq.update.a
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                HippyQQLibraryManager.this.lambda$downloadHippySo$0(i3, loadExtResult);
            }
        });
    }

    private String getHippyBridgeSoName() {
        String hippyBridgeSoName = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getHippyBridgeSoName();
        if (TextUtils.isEmpty(hippyBridgeSoName)) {
            return "hippy_qq_021306";
        }
        return hippyBridgeSoName;
    }

    public static HippyQQLibraryManager getInstance() {
        if (INSTANCE == null) {
            synchronized (HippyQQLibraryManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HippyQQLibraryManager();
                }
            }
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadHippySo$0(int i3, LoadExtResult loadExtResult) {
        if (QLog.isColorLevel() || i3 != 0) {
            QLog.d(HippyQQConstants.HIPPY_TAG, 1, "SoLoadManager download resCode=" + i3);
        }
        if (i3 == 0) {
            updateSoVersions(loadExtResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLibraryWithInspector$1() {
        QLog.i(HippyQQConstants.HIPPY_TAG, 1, "loadLibraryWithInspector success");
        onDownloadSuccess();
        synchronized (this.mListenerLock) {
            this.mLibraryLoadListeners.clear();
        }
    }

    private void loadLibraryWithInspector(LibraryLoadListener libraryLoadListener) {
        String str;
        int i3 = this.mLoadState;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2 && libraryLoadListener != null) {
                    libraryLoadListener.onLoadSuccess();
                    return;
                }
                return;
            }
            addLibraryLoadListener(libraryLoadListener);
            return;
        }
        this.mLoadState = 1;
        addLibraryLoadListener(libraryLoadListener);
        String str2 = MobileQQ.QQ_PACKAGE_NAME;
        BaseApplication context = BaseApplication.getContext();
        File file = new File(new File(context.getFilesDir(), "hippy"), HippyQQConstants.HIPPY_DEBUG_SO_DIR);
        if (AbiUtil.isArm64Runtime(context)) {
            str = HippyQQConstants.HIPPY_DEBUG_SO_ARM64_DIR;
        } else {
            str = HippyQQConstants.HIPPY_DEBUG_SO_ARMEABI_DIR;
        }
        File file2 = new File(file, str + HippyQQConstants.HIPPY_LIB_HIPPY_DEBUG_SO);
        File file3 = new File(file, str + HippyQQConstants.HIPPY_LIB_FLEXBOX_DEBUG_SO);
        try {
            System.load(file2.getAbsolutePath());
            System.load(file3.getAbsolutePath());
            HippyQQEngine.runTaskInUIThread(new Runnable() { // from class: com.tencent.hippy.qq.update.b
                @Override // java.lang.Runnable
                public final void run() {
                    HippyQQLibraryManager.this.lambda$loadLibraryWithInspector$1();
                }
            });
        } catch (Throwable th5) {
            QLog.e(HippyQQConstants.HIPPY_TAG, 1, "loadLibraryWithInspector e:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadFail(int i3) {
        this.mLoadState = 0;
        ArrayList<LibraryLoadListener> arrayList = new ArrayList();
        synchronized (this.mListenerLock) {
            arrayList.addAll(this.mLibraryLoadListeners);
        }
        for (LibraryLoadListener libraryLoadListener : arrayList) {
            if (libraryLoadListener != null) {
                libraryLoadListener.onLoadFail(-8, "SoLoadManager load failed, resCode=" + i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadSuccess() {
        this.mLoadState = 2;
        ArrayList<LibraryLoadListener> arrayList = new ArrayList();
        synchronized (this.mListenerLock) {
            arrayList.addAll(this.mLibraryLoadListeners);
        }
        for (LibraryLoadListener libraryLoadListener : arrayList) {
            if (libraryLoadListener != null) {
                libraryLoadListener.onLoadSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0064, code lost:
    
        if (r0.equals(r1 + ":" + mqq.app.api.ProcessConstant.MINI_5) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runTaskInUIThreadAccordProcess(Runnable runnable) {
        String qQProcessName = MobileQQ.sMobileQQ.getQQProcessName();
        String packageName = MobileQQ.sMobileQQ.getPackageName();
        if (!TextUtils.isEmpty(qQProcessName)) {
            if (!qQProcessName.equals(packageName + ":" + ProcessConstant.MINI_3)) {
                if (!qQProcessName.equals(packageName + ":" + ProcessConstant.MINI_4)) {
                }
            }
            HippyQQEngine.runTaskInUIThreadFront(runnable);
            return;
        }
        HippyQQEngine.runTaskInUIThread(runnable);
    }

    public void downloadSo() {
        downloadHippySo();
        AvifLibraryLoader.loadLibrary();
    }

    public String getCoreJsFilePath(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mCommonPackagePath)) {
            File file = new File(this.mCommonPackagePath);
            if (!file.exists()) {
                return null;
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
        }
        return null;
    }

    public String getDebugCoreJsFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(new File(new File(BaseApplication.getContext().getFilesDir(), "hippy"), HippyQQConstants.HIPPY_DEBUG_SO_DIR), HippyQQConstants.HIPPY_DEBUG_CORE_JS_DIR + str);
        if (!file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    public int getHippyLibraryId() {
        String str = "";
        for (int i3 = 0; i3 < this.mSoNames.length; i3++) {
            String soVer = SoLoadManager.getInstance().getSoVer(this.mSoNames[i3]);
            if (TextUtils.isEmpty(soVer)) {
                return 0;
            }
            str = str + soVer;
        }
        return str.hashCode();
    }

    public HashMap<String, String> getLibraryVersions() {
        return this.mLibraryVerions;
    }

    public boolean isLibraryExists() {
        for (int i3 = 0; i3 < this.mSoNames.length; i3++) {
            if (TextUtils.isEmpty(SoLoadManager.getInstance().getSoVer(this.mSoNames[i3]))) {
                return false;
            }
        }
        return true;
    }

    public boolean isLibraryLoaded() {
        if (this.mLoadState == 2) {
            return true;
        }
        return false;
    }

    public boolean isUseAllInOneSo() {
        if (((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isHippyUseAllInOneSo()) {
            return true;
        }
        return false;
    }

    public boolean isUseInspector() {
        if (!HippyDebugUtil.isDebugEnable()) {
            return false;
        }
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(MMKVCommonFileKeys.IS_USE_INSPECTOR, false);
    }

    public void loadLibraryIfNeed(LibraryLoadListener libraryLoadListener) {
        if (isUseInspector()) {
            loadLibraryWithInspector(libraryLoadListener);
        } else {
            loadLibraryWithoutInspector(libraryLoadListener);
        }
    }

    public void loadLibraryWithoutInspector(LibraryLoadListener libraryLoadListener) {
        int i3 = this.mLoadState;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2 && libraryLoadListener != null) {
                    libraryLoadListener.onLoadSuccess();
                    return;
                }
                return;
            }
            addLibraryLoadListener(libraryLoadListener);
            return;
        }
        this.mLoadState = 1;
        addLibraryLoadListener(libraryLoadListener);
        SoLoadManager.getInstance().loadSequentially(this.mSoNames, new OnLoadListener() { // from class: com.tencent.hippy.qq.update.HippyQQLibraryManager.1
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public void onLoadResult(final int i16, final LoadExtResult loadExtResult) {
                HippyQQLibraryManager.this.runTaskInUIThreadAccordProcess(new Runnable() { // from class: com.tencent.hippy.qq.update.HippyQQLibraryManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel() || i16 != 0) {
                            QLog.d(HippyQQConstants.HIPPY_TAG, 1, "Hippy: SoLoadManager loadSequentially resCode=" + i16);
                        }
                        int i17 = i16;
                        if (i17 != 0) {
                            HippyQQLibraryManager.this.onDownloadFail(i17);
                        } else {
                            HippyQQLibraryManager.this.updateSoVersions(loadExtResult);
                            HippyQQLibraryManager hippyQQLibraryManager = HippyQQLibraryManager.this;
                            hippyQQLibraryManager.mCommonPackagePath = loadExtResult.getRelatedFilesFolder(hippyQQLibraryManager.mHippySoName);
                            if (!TextUtils.isEmpty(HippyQQLibraryManager.this.mCommonPackagePath)) {
                                HippyQQLibraryManager.this.onDownloadSuccess();
                            } else {
                                QLog.d(HippyQQConstants.HIPPY_TAG, 2, "Hippy: SoLoadManager mCommonPackagePath empty");
                                HippyQQLibraryManager.this.onDownloadFail(-10);
                            }
                        }
                        synchronized (HippyQQLibraryManager.this.mListenerLock) {
                            HippyQQLibraryManager.this.mLibraryLoadListeners.clear();
                        }
                    }
                });
            }
        });
    }

    public void removeLibraryLoadListener(LibraryLoadListener libraryLoadListener) {
        synchronized (this.mListenerLock) {
            if (libraryLoadListener != null) {
                if (this.mLibraryLoadListeners.contains(libraryLoadListener)) {
                    this.mLibraryLoadListeners.remove(libraryLoadListener);
                }
            }
        }
    }

    protected void updateSoVersions(LoadExtResult loadExtResult) {
        if (loadExtResult == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = this.mSoNames;
            if (i3 < strArr.length) {
                String ver = loadExtResult.getVer(strArr[i3]);
                this.mLibraryVerions.put(this.mSoNames[i3], ver);
                QLog.d(HippyQQConstants.HIPPY_TAG, 1, "updateSoVersions soName=", this.mSoNames[i3], ", verName=", ver);
                i3++;
            } else {
                return;
            }
        }
    }
}
