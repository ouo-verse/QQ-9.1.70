package com.tencent.ark.open.appmanage;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.Utils;
import com.tencent.ark.data.ArkAppElement;
import com.tencent.ark.open.ArkAppBizMgr;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkAppMgr;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LocalAppManager {
    private static final String TAG = "ArkApp.ArkAppMgr";

    public static void deleteAllLocalApps() {
        for (ArkAppElement arkAppElement : enumInstalledAppName()) {
            deleteAppByNameAndBiz(arkAppElement.appName, arkAppElement.bizSrc, true);
        }
    }

    private static void deleteAppByName(String str, boolean z16) {
        final String appDirByNameAndVersion = Utility.getAppDirByNameAndVersion(str);
        if (z16) {
            File file = new File(String.format("%s_%d", appDirByNameAndVersion, Long.valueOf(System.currentTimeMillis())));
            File file2 = new File(appDirByNameAndVersion);
            if (!file2.renameTo(file)) {
                Logger.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, failed to rename, %s->%s", appDirByNameAndVersion, file));
            }
            if (!Utility.deleteFile(file)) {
                Logger.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, failed to delete dir, %s->%s", appDirByNameAndVersion, file));
            }
            if (file2.exists()) {
                Logger.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, dir still exists, %s->%s", appDirByNameAndVersion, file));
                return;
            }
            return;
        }
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.appmanage.LocalAppManager.1
            @Override // java.lang.Runnable
            public void run() {
                File file3 = new File(appDirByNameAndVersion);
                if (file3.isFile()) {
                    Utility.deleteFile(file3);
                    return;
                }
                File[] listFiles = file3.listFiles();
                if (listFiles != null) {
                    for (File file4 : listFiles) {
                        file4.delete();
                    }
                }
            }
        });
    }

    public static void deleteAppByNameAndBiz(String str, String str2, boolean z16) {
        if (!TextUtils.isEmpty(str2)) {
            ArkAppBizMgr.getInstance().removeBizSrc(str, str2);
        } else {
            deleteAppByName(str, z16);
        }
    }

    public static List<ArkAppElement> enumInstalledAppName() {
        File[] listFiles = new File(ArkEnvironmentManager.getInstance().getAppInstallDirectory()).listFiles(new FileFilter() { // from class: com.tencent.ark.open.appmanage.LocalAppManager.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (!file.isDirectory()) {
                    return false;
                }
                return Utility.isValidAppName(file.getName());
            }
        });
        if (listFiles != null && listFiles.length != 0) {
            int length = listFiles.length;
            String[] strArr = new String[length];
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                strArr[i3] = listFiles[i3].getName();
            }
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < length; i16++) {
                String str = strArr[i16];
                List<String> bizSrcList = ArkAppBizMgr.getInstance().getBizSrcList(str);
                if (Utils.isEmpty(bizSrcList)) {
                    arrayList.add(new ArkAppElement(str, ""));
                } else {
                    Iterator<String> it = bizSrcList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new ArkAppElement(str, it.next()));
                    }
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static ArkAppMgr.AppPathInfo getLocalAppPathByAppName(String str, String str2) {
        String appDirByNameAndVersion = Utility.getAppDirByNameAndVersion(str);
        if (!appDirByNameAndVersion.endsWith("/")) {
            appDirByNameAndVersion = appDirByNameAndVersion.concat("/");
        }
        File[] listFiles = new File(appDirByNameAndVersion).listFiles(new FileFilter() { // from class: com.tencent.ark.open.appmanage.LocalAppManager.3
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.isFile() && file.exists()) {
                    return true;
                }
                return false;
            }
        });
        ArkAppMgr.AppPathInfo appPathInfo = null;
        if (listFiles == null) {
            return null;
        }
        for (File file : listFiles) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                String substring = name.substring(lastIndexOf);
                String substring2 = name.substring(0, lastIndexOf);
                if (!TextUtils.isEmpty(substring) && Utility.isValidAppVersion(substring2)) {
                    if (appPathInfo == null) {
                        appPathInfo = new ArkAppMgr.AppPathInfo();
                        ArkAppInfo.AppDesc appDesc = appPathInfo.desc;
                        appDesc.name = str;
                        appDesc.bizSrc = str2;
                        appDesc.version = substring2;
                        appPathInfo.path = file.getAbsolutePath();
                    } else if (Utility.compareVersionString(substring2, appPathInfo.desc.version) > 0) {
                        ArkAppInfo.AppDesc appDesc2 = appPathInfo.desc;
                        appDesc2.name = str;
                        appDesc2.bizSrc = str2;
                        appDesc2.version = substring2;
                        appPathInfo.path = file.getAbsolutePath();
                    }
                }
            }
        }
        if (appPathInfo != null) {
            ArkAppCacheMgr.cacheManifestInfo(appPathInfo.path, str2, str);
        }
        return appPathInfo;
    }
}
