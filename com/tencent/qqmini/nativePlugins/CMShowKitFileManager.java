package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class CMShowKitFileManager extends BaseJsPlugin {
    private static String C;
    private static String D;
    private static Timer E;
    private static Downloader.DownloadListener F;

    /* renamed from: d, reason: collision with root package name */
    private static JSONArray f346939d = new JSONArray();

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<String> f346940e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private static String f346941f;

    /* renamed from: h, reason: collision with root package name */
    private static final String f346942h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f346943i;

    /* renamed from: m, reason: collision with root package name */
    private static final String f346944m;

    static {
        String str = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini_cmshow/";
        f346942h = str;
        f346943i = str + "/dress/";
        f346944m = str + "/face/";
        C = "download url is empty";
        D = "cache exists";
    }

    private static synchronized void d() {
        synchronized (CMShowKitFileManager.class) {
            Timer timer = E;
            if (timer != null) {
                timer.cancel();
                E = null;
            }
        }
    }

    private static String e(String str, IMiniAppContext iMiniAppContext, String str2) {
        String str3 = "wxfile://tmp_cmshowCache/" + str2 + "/";
        String tmpPathByWxFilePath = ((IMiniAppFileManager) iMiniAppContext.getManager(IMiniAppFileManager.class)).getTmpPathByWxFilePath(str3);
        File file = new File(tmpPathByWxFilePath);
        if (file.exists()) {
            FileUtils.delete(tmpPathByWxFilePath, true);
        }
        file.mkdirs();
        if (!new File(str).exists()) {
            QLog.e("CMShowKitFileManager", 1, "cache file not exist, copy to game file error.");
            return null;
        }
        FileUtils.copyDocumentItemsToAnotherDocument(str, tmpPathByWxFilePath);
        return str3.replace(MiniAppFileManager.WXFILE_PREFIX_TMP, "qqfile://tmp_");
    }

    private static void f() {
        File file = new File(f346942h);
        if (file.exists() && file.isDirectory()) {
            return;
        }
        file.mkdirs();
    }

    private static String g(String str, String str2) {
        String str3;
        File file;
        try {
            str3 = MD5Utils.toMD5(str);
        } catch (Exception e16) {
            QLog.e("CMShowKitFileManager", 1, "checkDownloadData e" + e16);
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        if (str2 == "faceData") {
            file = new File(f346944m);
        } else {
            file = new File(f346943i);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(file.getAbsolutePath());
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str3);
        sb5.append(str4);
        sb5.append(str3);
        sb5.append(".zip");
        File file2 = new File(sb5.toString());
        if (file2.exists()) {
            return D;
        }
        file2.getParentFile().mkdirs();
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, file2);
        gVar.U = true;
        gVar.Q = true;
        gVar.f313008f = 2;
        gVar.W = true;
        gVar.X = true;
        if (DownloaderFactory.o(gVar, null) == 0) {
            if (!file2.exists()) {
                QLog.e("CMShowKitFileManager", 1, "CMShow kit zipFile download error, zipFile not exist.");
                return null;
            }
            try {
                String str5 = file.getAbsolutePath() + str4 + str2 + str4;
                File file3 = new File(str5);
                if (file3.exists()) {
                    FileUtils.deleteDirectory(str5);
                }
                file3.mkdirs();
                ZipUtils.unZipFile(file2, str5);
                return str5;
            } catch (Exception e17) {
                file2.delete();
                QLog.e("CMShowKitFileManager", 1, "checkDownloadData unZipFile file error  error->" + e17.getMessage());
                return null;
            } catch (OutOfMemoryError e18) {
                file2.delete();
                QLog.e("CMShowKitFileManager", 1, "checkDownloadData unZipFile file error resType->" + e18.getMessage());
                return null;
            }
        }
        QLog.e("CMShowKitFileManager", 1, "downloadTask.FAIL");
        return null;
    }

    private static void h(Map<String, String> map, IMiniAppContext iMiniAppContext, JSONObject jSONObject) {
        for (String str : map.keySet()) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("CMShowKitFileManager", 1, C);
                c();
                return;
            }
            String str2 = map.get(str);
            String g16 = g(str, str2);
            if (g16.equals(D)) {
                QLog.i("CMShowKitFileManager", 1, "read dressId " + str2 + " res from cache");
                File file = new File(f346943i + "/" + str2 + "/");
                if (file.exists()) {
                    g16 = file.getAbsolutePath();
                }
            }
            if (TextUtils.isEmpty(g16)) {
                QLog.e("CMShowKitFileManager", 1, "download to cache fail.");
                c();
                return;
            }
            String e16 = e(g16, iMiniAppContext, str2);
            if (TextUtils.isEmpty(e16)) {
                QLog.e("CMShowKitFileManager", 1, "copy to game file error.");
                c();
                return;
            }
            if (!m(f346939d, e16)) {
                try {
                    f346939d.mo162put(e16);
                    jSONObject.put("local_dress_res", f346939d);
                    QLog.i("CMShowKitFileManager", 1, "dressRes id : " + str2 + " ready");
                } catch (JSONException unused) {
                    c();
                    return;
                }
            }
            if (f346939d.length() == map.keySet().size() && !TextUtils.isEmpty(f346941f)) {
                F.onDownloadSucceed(null, null);
                d();
            }
        }
    }

    private static void i(String str, IMiniAppContext iMiniAppContext, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("CMShowKitFileManager", 1, C);
            c();
            return;
        }
        String g16 = g(str, "faceData");
        if (g16.equals(D)) {
            QLog.i("CMShowKitFileManager", 1, "read dressId faceData res from cache");
            File file = new File(f346944m + "/faceData/");
            if (file.exists()) {
                g16 = file.getAbsolutePath();
            }
        }
        if (TextUtils.isEmpty(g16)) {
            QLog.e("CMShowKitFileManager", 1, "download to cache fail.");
            c();
            return;
        }
        String e16 = e(g16, iMiniAppContext, "faceData");
        f346941f = e16;
        if (TextUtils.isEmpty(e16)) {
            QLog.e("CMShowKitFileManager", 1, "copy error.");
            c();
        } else {
            try {
                jSONObject.put("local_face_data", f346941f);
                QLog.i("CMShowKitFileManager", 1, "gameFaceData ready.");
            } catch (JSONException unused) {
                c();
            }
        }
    }

    private static Map<String, String> j(JSONObject jSONObject) {
        String str;
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject(GetCMShowInfoServlet.EXTRA_AVATAR_TYPE_3D).getJSONArray("dress_infos");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                try {
                    str = String.valueOf(jSONObject2.optLong("dress_id"));
                } catch (Exception e16) {
                    QLog.e("CMShowKitFileManager", 1, "dress_id cast to string error", e16);
                    str = null;
                }
                hashMap.put(jSONObject2.optString("dress_url"), str);
            }
            jSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject(GetCMShowInfoServlet.EXTRA_AVATAR_TYPE_3D).remove("dress_infos");
            return hashMap;
        } catch (JSONException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static void l(JSONObject jSONObject, IMiniAppContext iMiniAppContext, Downloader.DownloadListener downloadListener) {
        n(5000L);
        F = downloadListener;
        f346939d = new JSONArray();
        f();
        String k3 = k(jSONObject);
        Map<String, String> j3 = j(jSONObject);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject(GetCMShowInfoServlet.EXTRA_AVATAR_TYPE_3D);
            jSONObject2.put("local_face_data", (Object) null);
            jSONObject2.put("local_dress_res", (Object) null);
            if (!TextUtils.isEmpty(k3) && j3 != null && j3.size() != 0) {
                i(k3, iMiniAppContext, jSONObject2);
                h(j3, iMiniAppContext, jSONObject2);
            } else {
                QLog.e("CMShowKitFileManager", 1, C);
                c();
            }
        } catch (JSONException e16) {
            QLog.e("CMShowKitFileManager", 1, e16, new Object[0]);
            c();
        }
    }

    private static synchronized void n(long j3) {
        synchronized (CMShowKitFileManager.class) {
            d();
            BaseTimer baseTimer = new BaseTimer();
            E = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.qqmini.nativePlugins.CMShowKitFileManager.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    QLog.e("CMShowKitFileManager", 1, "getLocalRes timeout.");
                    CMShowKitFileManager.c();
                }
            }, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        QLog.i("CMShowKitFileManager", 1, "callBackError.");
        F.onDownloadFailed(null, null);
        d();
    }

    private static String k(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.e("CMShowKitFileManager", 1, "resultData is null");
            return "";
        }
        String optString = jSONObject.optString("extend_data");
        if (TextUtils.isEmpty(optString)) {
            QLog.e("TAG", 1, "resultData.extend_data is empty!");
            return "";
        }
        return optString.split(",")[3].split("\"")[3];
    }

    private static boolean m(JSONArray jSONArray, String str) {
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                if (str.equals(jSONArray.optString(i3))) {
                    return true;
                }
            }
        }
        return false;
    }
}
