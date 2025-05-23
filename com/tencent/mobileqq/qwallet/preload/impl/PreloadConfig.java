package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.ResInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.config.PreloadConfProcessor;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class PreloadConfig implements Serializable {
    private static final long serialVersionUID = 2;
    public transient List<PreloadModuleImpl> mLastModules;
    public transient byte[] mSaveLock;
    public transient String mSavePath;
    public long moggyConfigVersion = 0;
    private CopyOnWriteArrayList<PreloadModuleImpl> mPreloadModules = new CopyOnWriteArrayList<>();

    public static ArrayList<ResInfo> modulesToResInfos(List<PreloadModuleImpl> list) {
        ArrayList<ResInfo> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        for (PreloadModuleImpl preloadModuleImpl : list) {
            try {
                ResInfo resInfo = new ResInfo();
                resInfo.sResId = preloadModuleImpl.mid;
                resInfo.iSize = preloadModuleImpl.getModuleResSize();
                arrayList.add(resInfo);
            } catch (NumberFormatException e16) {
                QLog.e("PreloadConfig", 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        return arrayList;
    }

    public static List<PreloadModuleImpl> parseConfig(JSONArray jSONArray, boolean z16, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
            try {
                arrayList.add(PreloadModuleImpl.parsePreloadModule(jSONArray.getJSONObject(i16), z16, i3));
            } catch (Exception e16) {
                QLog.e("PreloadConfig", 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PreloadConfig readConfig(String str) {
        PreloadConfig preloadConfig;
        String c16 = com.tencent.mobileqq.qwallet.preload.a.c(str);
        try {
            preloadConfig = (PreloadConfig) d.v(c16);
        } catch (InvalidClassException unused) {
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "preload config update should delete local config");
            }
            g.q(PreloadConfProcessor.d(), "0");
            preloadConfig = null;
            if (preloadConfig == null) {
            }
            preloadConfig.mSavePath = c16;
            preloadConfig.mSaveLock = new byte[0];
            preloadConfig.mLastModules = preloadConfig.getCloneModules();
            if (QLog.isColorLevel()) {
            }
            return preloadConfig;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(IPreloadService.TAG, 2, "readPreloadConfig exception:" + c16 + "|" + e16.toString());
            }
            preloadConfig = null;
            if (preloadConfig == null) {
            }
            preloadConfig.mSavePath = c16;
            preloadConfig.mSaveLock = new byte[0];
            preloadConfig.mLastModules = preloadConfig.getCloneModules();
            if (QLog.isColorLevel()) {
            }
            return preloadConfig;
        }
        if (preloadConfig == null) {
            preloadConfig = new PreloadConfig();
        } else {
            preloadConfig.checkModules();
        }
        preloadConfig.mSavePath = c16;
        preloadConfig.mSaveLock = new byte[0];
        preloadConfig.mLastModules = preloadConfig.getCloneModules();
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "readPreloadConfig:" + preloadConfig);
        }
        return preloadConfig;
    }

    public static void splitModulesByBackControl(List<PreloadModuleImpl> list, List<PreloadModuleImpl> list2, List<PreloadModuleImpl> list3) {
        for (PreloadModuleImpl preloadModuleImpl : list) {
            if (preloadModuleImpl.mBackControl) {
                list2.add(preloadModuleImpl);
            } else {
                list3.add(preloadModuleImpl);
            }
        }
    }

    public static void splitModulesBySize(int i3, List<PreloadModuleImpl> list, List<PreloadModuleImpl> list2, List<PreloadModuleImpl> list3) {
        if (list != null && list2 != null && list3 != null) {
            for (PreloadModuleImpl preloadModuleImpl : list) {
                if (preloadModuleImpl.getModuleResSize() <= i3) {
                    list2.add(preloadModuleImpl);
                } else {
                    list3.add(preloadModuleImpl);
                }
            }
        }
    }

    public void addOrMerge(JSONObject jSONObject, PreloadServiceImpl preloadServiceImpl) {
        PreloadModuleImpl parsePreloadModule = PreloadModuleImpl.parsePreloadModule(jSONObject, true, 0);
        PreloadModuleImpl moduleByID = getModuleByID(parsePreloadModule.mid);
        if (moduleByID != null) {
            moduleByID.updatePreloadModule(parsePreloadModule, preloadServiceImpl);
        } else {
            this.mPreloadModules.add(parsePreloadModule);
        }
    }

    public void checkModules() {
        if (this.mPreloadModules == null) {
            this.mPreloadModules = new CopyOnWriteArrayList<>();
        }
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            PreloadModuleImpl next = it.next();
            next.check();
            for (PreloadResourceImpl preloadResourceImpl : next.getResList()) {
                if (TextUtils.isEmpty(preloadResourceImpl.mResId)) {
                    preloadResourceImpl.mResId = preloadResourceImpl.getResDownloadUrl(next);
                }
            }
        }
    }

    public void filterInvalidModules(PreloadServiceImpl preloadServiceImpl) {
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            PreloadModuleImpl next = it.next();
            next.filterInvalidRes(preloadServiceImpl);
            if (next.getResNum() <= 0) {
                this.mPreloadModules.remove(next);
            }
        }
    }

    public List<PreloadModuleImpl> getCloneModules() {
        ArrayList arrayList = new ArrayList();
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            arrayList.add(new PreloadModuleImpl(it.next()));
        }
        return arrayList;
    }

    public PreloadModuleImpl getModuleByID(String str) {
        if (str != null) {
            Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
            while (it.hasNext()) {
                PreloadModuleImpl next = it.next();
                if (next.mid.equals(str)) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    public PreloadModuleImpl getModuleByName(String str) {
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            PreloadModuleImpl next = it.next();
            if (next.name.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public int getModuleNum() {
        return this.mPreloadModules.size();
    }

    public List<PreloadModuleImpl> getModules() {
        ArrayList arrayList = new ArrayList();
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public String getResIdByUrl(String str) {
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            PreloadModuleImpl next = it.next();
            for (PreloadResourceImpl preloadResourceImpl : next.getResList()) {
                if (d.r(preloadResourceImpl.getResDownloadUrl(next), str)) {
                    return preloadResourceImpl.mResId;
                }
            }
        }
        return "";
    }

    public ResourceInfo getResInfoByResId(String str) {
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            PreloadModuleImpl next = it.next();
            for (PreloadResourceImpl preloadResourceImpl : next.getResList()) {
                if (d.r(preloadResourceImpl.mResId, str)) {
                    return preloadResourceImpl.getResInfo(next);
                }
            }
        }
        return null;
    }

    public void innerReplaceConfig(JSONArray jSONArray, PreloadServiceImpl preloadServiceImpl, int i3) {
        List<PreloadModuleImpl> parseConfig = parseConfig(jSONArray, false, i3);
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            PreloadModuleImpl next = it.next();
            int indexOf = parseConfig.indexOf(next);
            if (indexOf != -1) {
                next.updateNewModuleWhenReplace(parseConfig.get(indexOf), preloadServiceImpl, i3);
            } else {
                next.deleteResFromServer(i3);
                if (next.getResNum() > 0) {
                    parseConfig.add(next);
                }
            }
        }
        PreloadResConfigPrinter.f279031a.a(parseConfig);
        this.mPreloadModules = new CopyOnWriteArrayList<>(parseConfig);
    }

    public boolean isModulesChange(List<PreloadModuleImpl> list) {
        List<PreloadModuleImpl> modules = getModules();
        if (modules.size() != list.size()) {
            return true;
        }
        for (int i3 = 0; i3 < modules.size(); i3++) {
            if (modules.get(i3).isModuleChange(list.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public boolean isResInConfig(PreloadResourceImpl preloadResourceImpl) {
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            Iterator<PreloadResourceImpl> it5 = it.next().getResList().iterator();
            while (it5.hasNext()) {
                if (d.r(it5.next().mResId, preloadResourceImpl.mResId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isUrlInConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<PreloadModuleImpl> it = this.mPreloadModules.iterator();
        while (it.hasNext()) {
            PreloadModuleImpl next = it.next();
            Iterator<PreloadResourceImpl> it5 = next.getResList().iterator();
            while (it5.hasNext()) {
                if (str.equals(it5.next().getResDownloadUrl(next))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void mergeConfig(String str, PreloadServiceImpl preloadServiceImpl) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("module_config");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                addOrMerge(jSONArray.getJSONObject(i3), preloadServiceImpl);
            }
        } catch (Exception | OutOfMemoryError e16) {
            QLog.e("PreloadConfig", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    public void removeModule(PreloadModuleImpl preloadModuleImpl) {
        this.mPreloadModules.remove(preloadModuleImpl);
    }

    public List<PreloadModuleImpl> resInfosToModules(ArrayList<ResInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            return arrayList2;
        }
        Iterator<ResInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            PreloadModuleImpl moduleByID = getModuleByID(it.next().sResId);
            if (moduleByID != null) {
                arrayList2.add(moduleByID);
            }
        }
        return arrayList2;
    }

    public void savePreloadConfig() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadConfig.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (PreloadConfig.this.mSaveLock) {
                    PreloadConfig preloadConfig = PreloadConfig.this;
                    if (preloadConfig.isModulesChange(preloadConfig.mLastModules)) {
                        PreloadConfig preloadConfig2 = PreloadConfig.this;
                        d.x(preloadConfig2, preloadConfig2.mSavePath);
                        if (QLog.isColorLevel()) {
                            QLog.d(IPreloadService.TAG, 2, "really save:" + PreloadConfig.this);
                        }
                        PreloadConfig preloadConfig3 = PreloadConfig.this;
                        preloadConfig3.mLastModules = preloadConfig3.getCloneModules();
                    }
                }
            }
        });
    }

    public String toString() {
        return "Config [mModules=" + this.mPreloadModules + "]";
    }
}
