package com.tencent.ttpic.openapi.initializer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.initializer.so.SoDependencyUtil;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class Feature implements Initializable, Destroyable {
    private static final String TAG = "AEKitFeature";
    private Object initLock = new Object();
    protected volatile boolean isInited = false;
    protected boolean isSoFilesLoaded = false;
    private String pendingErrorMessage = "";
    private String resourceDirOverrideFeatureManager;
    private String soDirOverrideFeatureManager;

    private boolean checkAssetsFileExist(ModelInfo modelInfo) {
        boolean z16 = true;
        if (AEModule.getContext() == null) {
            return true;
        }
        try {
            String[] list = AEModule.getContext().getAssets().list(trimEnd(modelInfo.getAssetsDir()));
            int length = list.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (list[i3].equals(modelInfo.fileName)) {
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
            return z16;
        } catch (IOException e16) {
            e16.printStackTrace();
            setPendingErrorMessage(e16);
            return false;
        }
    }

    private boolean containsLib(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean copyModelsToLocalPath(String str, List<ModelInfo> list) {
        boolean z16;
        boolean z17;
        while (true) {
            boolean z18 = true;
            for (ModelInfo modelInfo : list) {
                if (!isExternalResources() && modelInfo.isMustUseSDCardPath()) {
                    if (AEModule.getContext() == null) {
                        return false;
                    }
                    String str2 = str + File.separator + modelInfo.fileName;
                    File file = new File(str2);
                    if (file.exists() && !file.isDirectory() && FileUtils.SIMPLE_ASSET_MD5_COMPARATOR.equals(AEModule.getContext(), modelInfo.getFullAssetsPathNoPrefix(), file)) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        LogUtils.i(TAG, "copy resource: " + str2);
                        z17 = FileUtils.copyAssets(AEModule.getContext(), modelInfo.getFullAssetsPathNoPrefix(), str2);
                    } else {
                        z17 = true;
                    }
                    AEOpenRenderConfig.checkStrictMode(z17, "copy res file failed: " + modelInfo.getFullAssetsPathNoPrefix());
                    if (!z18 || !z17) {
                        z18 = false;
                    }
                }
            }
            return z18;
        }
    }

    private String getDefaultCopyAssetsDir() {
        try {
            Context context = AEModule.getContext();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(context.getExternalFilesDir(null).getPath());
            String str = File.separator;
            sb5.append(str);
            sb5.append("Tencent");
            sb5.append(str);
            sb5.append("aekit");
            return sb5.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            setPendingErrorMessage(e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getFullLibname(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    private boolean hasSoFiles() {
        if (getSharedLibraries() != null) {
            return true;
        }
        return false;
    }

    private boolean isVersionOK(SharedLibraryInfo sharedLibraryInfo) {
        if (!FeatureManager.isEnableResourceCheck() || !isExternalSoLoad() || TextUtils.isEmpty(sharedLibraryInfo.sha1)) {
            return true;
        }
        String sha1 = FileUtils.getSHA1(new File(getFinalSoDir(), sharedLibraryInfo.getFullLibName()).getPath());
        String str = sharedLibraryInfo.sha1;
        AEOpenRenderConfig.checkStrictMode(sha1.equals(str), "so sha1 check failed: " + sharedLibraryInfo.getFullLibName());
        if (sha1.equals(str)) {
            return true;
        }
        return false;
    }

    private String trimEnd(String str) {
        if (str.endsWith(File.separator)) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    protected boolean checkAllResourcesFilesValid() {
        List<ModelInfo> modelInfos = getModelInfos();
        if (modelInfos == null || modelInfos.size() == 0) {
            return true;
        }
        boolean z16 = true;
        for (ModelInfo modelInfo : getModelInfos()) {
            if (isModelFileInAssets(modelInfo)) {
                boolean checkAssetsFileExist = checkAssetsFileExist(modelInfo);
                AEOpenRenderConfig.checkStrictMode(checkAssetsFileExist, "file not found: " + modelInfo);
                z16 &= checkAssetsFileExist;
            } else {
                File file = new File(getFinalResourcesDir(), modelInfo.fileName);
                AEOpenRenderConfig.checkStrictMode(file.exists(), "file " + modelInfo + " not found in " + getFinalResourcesDir());
                boolean z17 = false;
                if (file.exists()) {
                    if (modelInfo.getFileSizeInBytes() > 0 && file.length() != modelInfo.getFileSizeInBytes()) {
                        AEOpenRenderConfig.checkStrictMode(file.exists(), "file " + modelInfo + " size error: " + file.length() + " != " + modelInfo.getFileSizeInBytes() + "(expected)");
                    } else {
                        z17 = true;
                    }
                }
                z16 &= z17;
            }
        }
        return z16;
    }

    protected boolean checkAllSoFilesExists() {
        boolean z16;
        if (getSharedLibraries() != null && getSharedLibraries().size() != 0) {
            if (TextUtils.isEmpty(FeatureManager.getSoDir()) && TextUtils.isEmpty(getSoDirOverrideFeatureManager())) {
                if (AEModule.getContext() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AEOpenRenderConfig.checkStrictMode(z16, "AEModule context is null");
                if (AEModule.getContext() == null) {
                    LogUtils.e(TAG, "[checkAllSoFilesExists] so load failed: AEModule context is null");
                    return false;
                }
                String[] list = new File(AEModule.getContext().getApplicationInfo().nativeLibraryDir).list();
                if (list != null && list.length != 0) {
                    for (SharedLibraryInfo sharedLibraryInfo : getSharedLibraries()) {
                        if (!containsLib(list, getFullLibname(sharedLibraryInfo.fileName))) {
                            AEOpenRenderConfig.checkStrictMode(false, "so load failed: " + sharedLibraryInfo + " not found in apk");
                            LogUtils.e(TAG, "[checkAllSoFilesExists] so load failed: " + sharedLibraryInfo + " not found in apk");
                            return false;
                        }
                    }
                    return true;
                }
                AEOpenRenderConfig.checkStrictMode(false, "so load failed: no libs in apk");
                LogUtils.e(TAG, "[checkAllSoFilesExists] so load failed: no libs in apk");
                return false;
            }
            for (SharedLibraryInfo sharedLibraryInfo2 : getSharedLibraries()) {
                if (!new File(getFinalSoDir(), getFullLibname(sharedLibraryInfo2.fileName)).exists()) {
                    AEOpenRenderConfig.checkStrictMode(false, "so load failed: " + sharedLibraryInfo2 + " not found in " + getFinalSoDir());
                    LogUtils.e(TAG, "[checkAllSoFilesExists] so load failed: " + sharedLibraryInfo2 + " not found in " + getFinalSoDir());
                    return false;
                }
            }
        }
        return true;
    }

    public boolean copyAssetsModelsToLocalPath(List<ModelInfo> list) {
        return copyModelsToLocalPath(getFinalResourcesDir(), list);
    }

    @Override // com.tencent.ttpic.openapi.initializer.Destroyable
    public boolean destroy() {
        this.isInited = !destroyImpl();
        return true;
    }

    protected abstract boolean destroyImpl();

    public String getFinalResourcesDir() {
        if (TextUtils.isEmpty(FeatureManager.getResourceDir()) && TextUtils.isEmpty(getResourceDirOverrideFeatureManager())) {
            File file = new File(getDefaultCopyAssetsDir(), getName());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        if (!TextUtils.isEmpty(getResourceDirOverrideFeatureManager())) {
            return getResourceDirOverrideFeatureManager();
        }
        return FeatureManager.getResourceDir();
    }

    public String getFinalSoDir() {
        if (!isExternalSoLoad()) {
            return null;
        }
        if (!TextUtils.isEmpty(getSoDirOverrideFeatureManager())) {
            return getSoDirOverrideFeatureManager();
        }
        return FeatureManager.getSoDir();
    }

    protected String getModelFinalPath(ModelInfo modelInfo) {
        if (isModelFileInAssets(modelInfo)) {
            return modelInfo.getFullAssetsPathWithPrefix();
        }
        return new File(getFinalResourcesDir(), modelInfo.getFileName()).getPath();
    }

    @Override // com.tencent.ttpic.openapi.initializer.Initializable
    public abstract List<ModelInfo> getModelInfos();

    @Override // com.tencent.ttpic.openapi.initializer.Initializable
    public abstract String getName();

    public String getPendingErrorMessage() {
        return this.pendingErrorMessage;
    }

    public String getResourceDirOverrideFeatureManager() {
        return this.resourceDirOverrideFeatureManager;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Initializable
    public abstract List<SharedLibraryInfo> getSharedLibraries();

    public String getSoDirOverrideFeatureManager() {
        return this.soDirOverrideFeatureManager;
    }

    public boolean hasError() {
        return !TextUtils.isEmpty(this.pendingErrorMessage);
    }

    @Override // com.tencent.ttpic.openapi.initializer.Initializable
    public synchronized boolean init() {
        if (!this.isInited) {
            synchronized (this.initLock) {
                if (!this.isInited) {
                    try {
                        setPendingErrorMessage(null);
                        boolean copyAssetsModelsToLocalPath = copyAssetsModelsToLocalPath(getModelInfos()) & true;
                        if (FeatureManager.isEnableResourceCheck()) {
                            copyAssetsModelsToLocalPath &= checkAllResourcesFilesValid();
                        }
                        LogUtils.e(TAG, "init Feature:" + getClass().getSimpleName());
                        this.isInited = copyAssetsModelsToLocalPath & initImpl();
                    } catch (UnsatisfiedLinkError e16) {
                        AEOpenRenderConfig.checkStrictMode(false, e16.toString());
                        setPendingErrorMessage(e16);
                        this.isInited = false;
                    }
                    LogUtils.i(TAG, "AEKitFeature:" + getName() + " init result = " + this.isInited);
                }
            }
        }
        return this.isInited;
    }

    protected abstract boolean initImpl();

    public boolean isAllSoVersionOk() {
        if (CollectionUtils.isEmpty(getSharedLibraries())) {
            return true;
        }
        Iterator<SharedLibraryInfo> it = getSharedLibraries().iterator();
        while (it.hasNext()) {
            if (!isVersionOK(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isExternalResources() {
        if (TextUtils.isEmpty(FeatureManager.getResourceDir()) && TextUtils.isEmpty(getResourceDirOverrideFeatureManager())) {
            return false;
        }
        return true;
    }

    public boolean isExternalSoLoad() {
        if (TextUtils.isEmpty(FeatureManager.getSoDir()) && TextUtils.isEmpty(getSoDirOverrideFeatureManager())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Initializable
    public boolean isFunctionReady() {
        return this.isInited;
    }

    protected boolean isModelFileInAssets(ModelInfo modelInfo) {
        if (!isExternalResources() && !modelInfo.isMustUseSDCardPath()) {
            return true;
        }
        return false;
    }

    public boolean isModelReadyInDirectory(String str) {
        if (getModelInfos() != null && getModelInfos().size() != 0) {
            Iterator<ModelInfo> it = getModelInfos().iterator();
            while (it.hasNext()) {
                if (!new File(str, it.next().fileName).exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Initializable
    public boolean isResourceReady() {
        return checkAllSoFilesExists() && checkAllResourcesFilesValid();
    }

    public boolean isSoFilesLoaded() {
        return this.isSoFilesLoaded;
    }

    public boolean isSoReadyInDirectory(String str) {
        if (getSharedLibraries() != null && getSharedLibraries().size() != 0) {
            Iterator<SharedLibraryInfo> it = getSharedLibraries().iterator();
            while (it.hasNext()) {
                if (!new File(str, getFullLibname(it.next().fileName)).exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean loadAllSoFiles() {
        if (FeatureManager.isEnableResourceCheck() && !checkAllSoFilesExists()) {
            LogUtils.e(TAG, "checkAllSoFilesExists : " + checkAllSoFilesExists());
            LogUtils.e(TAG, "isEnableResourceCheck : " + FeatureManager.isEnableResourceCheck());
            return false;
        }
        this.isSoFilesLoaded = true;
        Iterator<SharedLibraryInfo> it = getSharedLibraries().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SharedLibraryInfo next = it.next();
            boolean loadSoFile = loadSoFile(next);
            AEOpenRenderConfig.checkStrictMode(loadSoFile, "so load failed: " + next);
            if (!loadSoFile && FeatureManager.isEnableSoLoadCheck()) {
                LogUtils.i(TAG, "so load failed: " + next);
                this.isSoFilesLoaded = false;
                break;
            }
            if (loadSoFile) {
                LogUtils.i(TAG, "load so success:" + next);
            }
        }
        return this.isSoFilesLoaded;
    }

    protected boolean loadSoFile(SharedLibraryInfo sharedLibraryInfo) {
        if (!hasSoFiles()) {
            return true;
        }
        if (!isExternalSoLoad()) {
            return systemLoadLibrarySafely(sharedLibraryInfo.fileName);
        }
        String genSeperateFileDir = FileUtils.genSeperateFileDir(FeatureManager.getSoDir());
        if (!TextUtils.isEmpty(getSoDirOverrideFeatureManager())) {
            genSeperateFileDir = FileUtils.genSeperateFileDir(getSoDirOverrideFeatureManager());
        }
        List<String> dependencies = SoDependencyUtil.getDependencies(genSeperateFileDir, sharedLibraryInfo.getFullLibName());
        LogUtils.e(TAG, "loading " + sharedLibraryInfo.getFullLibName());
        if (dependencies != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loading " + sharedLibraryInfo.getFullLibName() + " | deps:");
            for (String str : dependencies) {
                sb5.append(" -" + str);
                if (new File(genSeperateFileDir, str).exists() && !systemLoadSafely(genSeperateFileDir, new SharedLibraryInfo(sharedLibraryInfo.fileName))) {
                    return false;
                }
            }
            LogUtils.e(TAG, sb5.toString());
        }
        return systemLoadSafely(genSeperateFileDir, sharedLibraryInfo);
    }

    public boolean reloadModel() {
        return true;
    }

    protected void setPendingErrorMessage(Throwable th5) {
        if (th5 == null) {
            this.pendingErrorMessage = "";
        } else {
            this.pendingErrorMessage = Log.getStackTraceString(th5);
        }
    }

    public void setResourceDirOverrideFeatureManager(String str) {
        this.resourceDirOverrideFeatureManager = str;
    }

    public void setSoDirOverrideFeatureManager(String str) {
        this.soDirOverrideFeatureManager = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean systemLoadLibrarySafely(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            LogUtils.e(TAG, str + " systemLoadLibrarySafely failed:" + e16.toString());
            setPendingErrorMessage(e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean systemLoadSafely(String str, SharedLibraryInfo sharedLibraryInfo) {
        try {
            File file = new File(str, sharedLibraryInfo.getFullLibName());
            if (FeatureManager.isEnableResourceCheck() && !isVersionOK(sharedLibraryInfo)) {
                return false;
            }
            System.load(file.getPath());
            LogUtils.i(TAG, "[systemLoadSafely]:" + file.getPath());
            return true;
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            setPendingErrorMessage(e16);
            return false;
        }
    }

    public String toString() {
        return "Initializer(" + getName() + ", init=" + this.isInited + ")";
    }

    public boolean isResourceReady(String str, String str2) {
        return isSoReadyInDirectory(str) && isModelReadyInDirectory(str2);
    }
}
