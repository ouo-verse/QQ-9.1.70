package com.tencent.hippy.qq.offline;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.c;
import com.tencent.biz.common.util.h;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.a;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyOfflineAssist {
    private static final int MEMORY_CACHE_SIZE = 500;
    public static final String TAG = "HippyOfflineAssist";
    private static a<String, OfflineWebRes> mOfflineWebResCache = new a<>(Business.Conversation, "OfflineWebRes", 500);

    /* JADX WARN: Removed duplicated region for block: B:12:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0092 A[Catch: Exception -> 0x014b, TryCatch #3 {Exception -> 0x014b, blocks: (B:3:0x0007, B:5:0x0010, B:7:0x0016, B:9:0x0024, B:10:0x0087, B:14:0x0092, B:17:0x00aa, B:19:0x00b4, B:21:0x00bf, B:24:0x00c6, B:26:0x00dc, B:29:0x00e3, B:31:0x00f0, B:33:0x00f6, B:34:0x013d, B:38:0x002b, B:48:0x0063, B:57:0x0084, B:62:0x0147, B:63:0x014a), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0147 A[Catch: Exception -> 0x014b, TryCatch #3 {Exception -> 0x014b, blocks: (B:3:0x0007, B:5:0x0010, B:7:0x0016, B:9:0x0024, B:10:0x0087, B:14:0x0092, B:17:0x00aa, B:19:0x00b4, B:21:0x00bf, B:24:0x00c6, B:26:0x00dc, B:29:0x00e3, B:31:0x00f0, B:33:0x00f6, B:34:0x013d, B:38:0x002b, B:48:0x0063, B:57:0x0084, B:62:0x0147, B:63:0x014a), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static String getOfflineResFromDatabase(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        Exception exc;
        String str3;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ConcurrentHashMap<String, String> concurrentHashMap = HtmlOffline.f78404g;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(str2)) {
                str3 = HtmlOffline.f78404g.get(str2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "read verifyjson from cache.");
                }
            } else {
                String str4 = c.c(str2) + str2 + "/verify.json";
                if (!new File(str4).exists()) {
                    return null;
                }
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str4));
                    try {
                        try {
                            String d16 = h.d(bufferedInputStream);
                            try {
                                HtmlOffline.f78404g.put(str2, d16);
                                bufferedInputStream.close();
                                str3 = d16;
                            } catch (Exception e16) {
                                exc = e16;
                                str3 = d16;
                                QLog.e(TAG, 1, exc.getMessage());
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                long currentTimeMillis2 = System.currentTimeMillis();
                                if (!TextUtils.isEmpty(str3)) {
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e17) {
                        exc = e17;
                        str3 = null;
                    }
                } catch (Exception e18) {
                    exc = e18;
                    str3 = null;
                    bufferedInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream = null;
                    if (bufferedInputStream != null) {
                    }
                    throw th;
                }
            }
            long currentTimeMillis22 = System.currentTimeMillis();
            if (!TextUtils.isEmpty(str3)) {
                return null;
            }
            final String optString = new JSONObject(str3).optString(HtmlOffline.v(str));
            long currentTimeMillis3 = System.currentTimeMillis();
            final OfflineWebResManager offlineWebResManager = getOfflineWebResManager();
            if (offlineWebResManager == null) {
                return null;
            }
            OfflineWebRes e19 = mOfflineWebResCache.e(optString);
            if (e19 == null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.offline.HippyOfflineAssist.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineWebResManager offlineWebResManager2 = OfflineWebResManager.this;
                        if (offlineWebResManager2 == null) {
                            return;
                        }
                        OfflineWebRes k3 = offlineWebResManager2.k(optString);
                        if (optString != null && k3 != null) {
                            HippyOfflineAssist.mOfflineWebResCache.f(optString, k3);
                        }
                    }
                }, 32, null, true);
                return null;
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            if (e19 == null) {
                return null;
            }
            File file = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            File file2 = new File(file, e19.hashName);
            if (!file2.exists()) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "shouldInterceptRequest from database return local res, readMd5File: " + (currentTimeMillis22 - currentTimeMillis) + ", getMd5: " + (currentTimeMillis3 - currentTimeMillis22) + ", query: " + (currentTimeMillis4 - currentTimeMillis3) + ", totalCost: " + (System.currentTimeMillis() - currentTimeMillis) + ", filePath: " + HtmlOffline.v(str));
            }
            return file2.getAbsolutePath();
        } catch (Exception e26) {
            QLog.e(TAG, 1, "getOfflineResFromDatabase got exception!", e26);
            return null;
        }
    }

    private static String getOfflineResFromSdcard(String str, String str2) {
        String v3 = HtmlOffline.v(str);
        String c16 = c.c(str2);
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        File file = new File((c16 + str2) + "/" + v3);
        if (!file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    public static String getOfflineResPath(final String str) {
        final AppInterface appInterface;
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            String queryParameter = Uri.parse(str).getQueryParameter("_bid");
            if (TextUtils.isEmpty(queryParameter) || (appInterface = HippyUtils.getAppInterface()) == null) {
                return null;
            }
            if (!str.contains("_discheck=1")) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.offline.HippyOfflineAssist.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HtmlOffline.d(str, appInterface);
                    }
                }, 128, null, true);
            }
            String offlineResFromDatabase = getOfflineResFromDatabase(str, queryParameter);
            if (offlineResFromDatabase == null) {
                offlineResFromDatabase = getOfflineResFromSdcard(str, queryParameter);
            }
            OfflineWebResManager.b(str);
            return offlineResFromDatabase;
        }
        QLog.i(TAG, 1, "[getOfflineResPath], illegal url.");
        return null;
    }

    private static OfflineWebResManager getOfflineWebResManager() {
        AppInterface appInterface = HippyUtils.getAppInterface();
        if (appInterface == null) {
            return null;
        }
        return new OfflineWebResManager(appInterface);
    }

    public static void updateUrl() {
        OfflineWebResManager offlineWebResManager = getOfflineWebResManager();
        if (offlineWebResManager != null) {
            offlineWebResManager.e(5);
        }
    }
}
