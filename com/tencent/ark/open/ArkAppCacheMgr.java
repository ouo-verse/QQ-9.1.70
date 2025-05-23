package com.tencent.ark.open;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Constants;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.ark;
import com.tencent.ark.mmkv.IMMKV;
import com.tencent.ark.mmkv.MMKVManager;
import com.tencent.ark.mmkv.MMKVUtils;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppCacheMgr {
    private static final String TAG = "ArkApp.ArkAppCacheMgr";
    private static final Map<String, ApplicationIconHolder> sAppIconCache = Collections.synchronizedMap(new HashMap());
    private static final Map<String, ArkDescIconInfo> sAppDescIconCache = Collections.synchronizedMap(new HashMap());
    protected static Map<String, ArkAppManifestInfo> sAppManifestInfoCache = Collections.synchronizedMap(new HashMap());

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class ApplicationIconHolder {
        public Bitmap bmp;
        public int refCount;

        ApplicationIconHolder() {
            this.refCount = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ArkAppManifestInfo {
        public String actionSet;
        public int checkVersion = 0;
        public String launcher;
        public String version;

        protected ArkAppManifestInfo() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ArkDescIconInfo {
        public String iconPath;
        public String name;

        public static ArkDescIconInfo fromJson(String str) {
            JSONException e16;
            ArkDescIconInfo arkDescIconInfo;
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(str);
                arkDescIconInfo = new ArkDescIconInfo();
            } catch (JSONException e17) {
                e16 = e17;
                arkDescIconInfo = null;
            }
            try {
                arkDescIconInfo.name = jSONObject.optString("name");
                arkDescIconInfo.iconPath = jSONObject.optString("iconPath");
            } catch (JSONException e18) {
                e16 = e18;
                Logger.logI(ArkAppCacheMgr.TAG, "fromJson exception." + e16.getMessage());
                return arkDescIconInfo;
            }
            return arkDescIconInfo;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.name);
                jSONObject.put("iconPath", this.iconPath);
            } catch (JSONException e16) {
                Logger.logI(ArkAppCacheMgr.TAG, "exception." + e16.getMessage());
            }
            return jSONObject.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnGetAppIcon {
        void callback(String str, Bitmap bitmap);
    }

    public static ArkAppManifestInfo cacheManifestInfo(final String str, final String str2, final String str3) {
        ArkDelegateManager.setupArkEnvironment(true);
        if (!ArkEnvironmentManager.getInstance().isLibraryLoad()) {
            Logger.logE(TAG, "cacheManifestInfo libraryLoad not load");
            return null;
        }
        if (sAppManifestInfoCache.containsKey(str)) {
            Logger.logI(TAG, "cacheManifestInfo sAppManifestInfoCache contained " + str3);
            return sAppManifestInfoCache.get(str);
        }
        if (TextUtils.isEmpty(str3)) {
            Logger.logE(TAG, "cacheManifestInfo name is empty");
            return null;
        }
        Logger.logI(TAG, "cacheManifestInfo ArkDispatchTask start");
        ArkDispatchTask.getInstance().send(str3, new Runnable() { // from class: com.tencent.ark.open.ArkAppCacheMgr.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.logI(ArkAppCacheMgr.TAG, "ArkTemp.cacheManifestInfo,name=" + str3 + ", bizSrc=" + str2 + ", path=" + str);
                ArkAppManifestInfo arkAppManifestInfo = new ArkAppManifestInfo();
                if (TextUtils.isEmpty(str)) {
                    Logger.logI(ArkAppCacheMgr.TAG, "cacheManifestInfo, path is empty");
                    return;
                }
                ark.Application Create = ark.Application.Create(str3, StringUtil.getNotNullString(str2), str);
                arkAppManifestInfo.actionSet = Create.GetActionSet();
                arkAppManifestInfo.version = Create.GetVersion();
                arkAppManifestInfo.checkVersion = Create.CheckVersion();
                arkAppManifestInfo.launcher = Create.GetLauncher();
                String GetDescription = Create.GetDescription();
                Create.Release();
                ArkAppCacheMgr.sAppManifestInfoCache.put(str, arkAppManifestInfo);
                ArkDescIconInfo descIconInfo = ArkAppCacheMgr.getDescIconInfo(str3);
                if (descIconInfo == null) {
                    descIconInfo = new ArkDescIconInfo();
                }
                descIconInfo.name = GetDescription;
                ArkAppCacheMgr.saveDescIconInfo(str3, descIconInfo);
            }
        });
        return sAppManifestInfoCache.get(str3);
    }

    public static int checkAppVersion(String str) {
        ArkAppManifestInfo arkAppManifestInfo = sAppManifestInfoCache.get(str);
        if (arkAppManifestInfo != null) {
            return arkAppManifestInfo.checkVersion;
        }
        Logger.logE(TAG, "checkAppVersion info == null");
        return 0;
    }

    public static String getAppActionSet(String str) {
        ArkAppManifestInfo arkAppManifestInfo = sAppManifestInfoCache.get(str);
        if (arkAppManifestInfo != null && !TextUtils.isEmpty(arkAppManifestInfo.actionSet)) {
            return arkAppManifestInfo.actionSet;
        }
        if (arkAppManifestInfo != null) {
            return arkAppManifestInfo.actionSet;
        }
        return "";
    }

    public static void getAppIcon(final String str, final String str2, final OnGetAppIcon onGetAppIcon) {
        ApplicationIconHolder applicationIconHolder;
        if (str != null && onGetAppIcon != null) {
            Map<String, ApplicationIconHolder> map = sAppIconCache;
            synchronized (map) {
                applicationIconHolder = map.get(str);
                if (applicationIconHolder != null) {
                    applicationIconHolder.refCount++;
                }
            }
            if (applicationIconHolder != null) {
                onGetAppIcon.callback(str, applicationIconHolder.bmp);
            } else {
                ArkDispatchTask.getInstance().post(str, new Runnable() { // from class: com.tencent.ark.open.ArkAppCacheMgr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        final ApplicationIconHolder applicationIconHolder2;
                        ark.Application application;
                        Bitmap bitmap;
                        synchronized (ArkAppCacheMgr.sAppIconCache) {
                            applicationIconHolder2 = (ApplicationIconHolder) ArkAppCacheMgr.sAppIconCache.get(str);
                            if (applicationIconHolder2 != null) {
                                applicationIconHolder2.refCount++;
                            }
                        }
                        if (applicationIconHolder2 != null) {
                            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.open.ArkAppCacheMgr.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    onGetAppIcon.callback(str, applicationIconHolder2.bmp);
                                }
                            });
                            return;
                        }
                        String appPathFromLocal = ArkAppMgr.getInstance().getAppPathFromLocal(str, str2);
                        StringBuilder sb5 = new StringBuilder();
                        if (!TextUtils.isEmpty(appPathFromLocal)) {
                            String str3 = str;
                            String str4 = str2;
                            if (str4 == null) {
                                str4 = "";
                            }
                            application = ark.Application.Create(str3, str4, appPathFromLocal);
                            if (application == null) {
                                sb5.append("getAppIcon.application == null .error!!\n");
                            } else {
                                int GetIconWidth = application.GetIconWidth();
                                int GetIconHeight = application.GetIconHeight();
                                if (GetIconWidth > 0 && GetIconHeight > 0) {
                                    try {
                                        bitmap = Bitmap.createBitmap(GetIconWidth, GetIconHeight, Bitmap.Config.ARGB_8888);
                                    } catch (OutOfMemoryError unused) {
                                        sb5.append("getAppIcon.createBitmap fail!!\n");
                                        bitmap = null;
                                    }
                                    if (bitmap != null && !application.CopyIconToBitmap(bitmap)) {
                                        sb5.append("getAppIcon.copyToBitmap fail!!\n");
                                    }
                                } else {
                                    sb5.append("getAppIcon.getSize.error!!\n");
                                }
                            }
                            bitmap = null;
                        } else {
                            application = null;
                            bitmap = null;
                        }
                        sb5.append("ArkTemp.getAppIcon is only template, from package appName=");
                        sb5.append(str);
                        sb5.append("\n");
                        Logger.logI(ArkAppCacheMgr.TAG, sb5.toString());
                        final ApplicationIconHolder applicationIconHolder3 = new ApplicationIconHolder();
                        applicationIconHolder3.bmp = bitmap;
                        ArkAppCacheMgr.sAppIconCache.put(str, applicationIconHolder3);
                        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.open.ArkAppCacheMgr.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                onGetAppIcon.callback(str, applicationIconHolder3.bmp);
                            }
                        });
                        if (application != null) {
                            application.Release();
                        }
                    }
                });
            }
        }
    }

    public static String getApplicationDesc(String str) {
        ArkDescIconInfo descIconInfo = getDescIconInfo(str);
        if (descIconInfo != null && !TextUtils.isEmpty(descIconInfo.name)) {
            return descIconInfo.name;
        }
        if (descIconInfo != null) {
            return descIconInfo.name;
        }
        return "";
    }

    public static Map<String, String> getApplicationFromManifest(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (ArkAppMgr.getInstance().getAppPathFromLocal(str, str2, str3) != null) {
            hashMap.put("desc", getApplicationDesc(str));
            hashMap.put("version", getApplicationVersion(str));
            return hashMap;
        }
        return null;
    }

    public static String getApplicationLauncher(String str) {
        ArkAppManifestInfo arkAppManifestInfo = sAppManifestInfoCache.get(str);
        if (arkAppManifestInfo != null && !TextUtils.isEmpty(arkAppManifestInfo.launcher)) {
            return arkAppManifestInfo.launcher;
        }
        if (arkAppManifestInfo != null) {
            return arkAppManifestInfo.launcher;
        }
        return "";
    }

    public static String getApplicationVersion(String str) {
        ArkAppManifestInfo arkAppManifestInfo = sAppManifestInfoCache.get(str);
        if (arkAppManifestInfo != null && !TextUtils.isEmpty(arkAppManifestInfo.version)) {
            return arkAppManifestInfo.version;
        }
        if (arkAppManifestInfo != null) {
            return arkAppManifestInfo.version;
        }
        return Constants.DEFAULT_MIN_APP_VERSION;
    }

    public static ArkDescIconInfo getDescIconInfo(String str) {
        ArkDescIconInfo arkDescIconInfo;
        IMMKV arkMMKV;
        Map<String, ArkDescIconInfo> map = sAppDescIconCache;
        synchronized (map) {
            arkDescIconInfo = map.get(str);
            if (arkDescIconInfo == null && (arkMMKV = MMKVManager.getInstance().getArkMMKV()) != null) {
                String string = arkMMKV.getString(MMKVUtils.fixAppCacheConfigKey(str), "");
                if (!TextUtils.isEmpty(string)) {
                    arkDescIconInfo = ArkDescIconInfo.fromJson(string);
                    map.put(str, arkDescIconInfo);
                    Logger.logI(TAG, "ArkTemp.getAppIcon get ArkAppConfigInfo app:" + str + ",ArkAppConfigInfo:" + string);
                }
            }
        }
        return arkDescIconInfo;
    }

    private static Bitmap getIconFromFile(String str) {
        Bitmap bitmap;
        StringBuilder sb5;
        FileInputStream fileInputStream = null;
        r3 = null;
        Bitmap bitmap2 = null;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                FileInputStream fileInputStream4 = new FileInputStream(str);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(fileInputStream4, null, options);
                    int i3 = options.outHeight;
                    int i16 = options.outWidth;
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = Math.max(i3, i16) / 128;
                    bitmap2 = BitmapFactory.decodeFile(str, options2);
                    Logger.logI(TAG, "ArkTemp.getAppIcon.getIconFromFile from path=" + str);
                    try {
                        fileInputStream4.close();
                        return bitmap2;
                    } catch (IOException e16) {
                        Logger.logI(TAG, "getAppIcon close Exception=" + e16.getMessage());
                        return bitmap2;
                    }
                } catch (FileNotFoundException e17) {
                    e = e17;
                    Bitmap bitmap3 = bitmap2;
                    fileInputStream2 = fileInputStream4;
                    bitmap = bitmap3;
                    Logger.logI(TAG, "getAppIcon exception=" + e.getMessage());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e18) {
                            e = e18;
                            sb5 = new StringBuilder();
                            sb5.append("getAppIcon close Exception=");
                            sb5.append(e.getMessage());
                            Logger.logI(TAG, sb5.toString());
                            return bitmap;
                        }
                    }
                    return bitmap;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    Bitmap bitmap4 = bitmap2;
                    fileInputStream3 = fileInputStream4;
                    bitmap = bitmap4;
                    Logger.logI(TAG, "getAppIcon oom=" + e.getMessage());
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (IOException e26) {
                            e = e26;
                            sb5 = new StringBuilder();
                            sb5.append("getAppIcon close Exception=");
                            sb5.append(e.getMessage());
                            Logger.logI(TAG, sb5.toString());
                            return bitmap;
                        }
                    }
                    return bitmap;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream4;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e27) {
                            Logger.logI(TAG, "getAppIcon close Exception=" + e27.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e28) {
                e = e28;
                bitmap = null;
            } catch (OutOfMemoryError e29) {
                e = e29;
                bitmap = null;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void releaseAppIcon(String str) {
        if (str == null) {
            Logger.logI(TAG, "releaseAppIcon call getAppName, return");
            return;
        }
        Map<String, ApplicationIconHolder> map = sAppIconCache;
        synchronized (map) {
            final ApplicationIconHolder applicationIconHolder = map.get(str);
            if (applicationIconHolder == null) {
                Logger.logI(TAG, "releaseAppIcon.notfound!! appName:" + str);
                return;
            }
            int i3 = applicationIconHolder.refCount - 1;
            applicationIconHolder.refCount = i3;
            if (i3 != 0) {
                return;
            }
            Logger.logI(TAG, "releaseAppIcon.release!! appName:" + str);
            map.remove(str);
            ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.ArkAppCacheMgr.3
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap = ApplicationIconHolder.this.bmp;
                    if (bitmap != null) {
                        bitmap.recycle();
                        ApplicationIconHolder.this.bmp = null;
                    }
                }
            });
        }
    }

    public static void saveDescIconInfo(String str, ArkDescIconInfo arkDescIconInfo) {
        if (!TextUtils.isEmpty(str) && arkDescIconInfo != null) {
            Map<String, ArkDescIconInfo> map = sAppDescIconCache;
            synchronized (map) {
                map.put(str, arkDescIconInfo);
                IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
                if (arkMMKV != null) {
                    arkMMKV.putString(MMKVUtils.fixAppCacheConfigKey(str), arkDescIconInfo.toString());
                }
            }
        }
    }
}
