package com.tencent.hippy.qq.utils;

import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.TypeFaceUtil;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyFontUtils {
    private static final String TAG = "HippyFontUtils";
    private static final ArrayList<String> loadingFonts = new ArrayList<>();
    private static Object lockForClearFile = new Object();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class FontDownloadListener extends com.tencent.mobileqq.vip.f {
        private Promise mPromise;
        private int mTotalSum;
        private int mSuccessTime = 0;
        private int mFailTime = 0;

        public FontDownloadListener(Promise promise, int i3) {
            this.mPromise = promise;
            this.mTotalSum = i3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            boolean z16;
            boolean z17;
            int i3;
            File file;
            String str;
            if (gVar == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("download done task = ");
                sb5.append(gVar.f313011i);
                sb5.append(" path = ");
                Map<String, File> map = gVar.f313010h;
                if (map != null) {
                    str = map.toString();
                } else {
                    str = "";
                }
                sb5.append(str);
                QLog.i(HippyFontUtils.TAG, 2, sb5.toString());
            }
            int i16 = 0;
            if (gVar.i() == 3 && gVar.f313006d == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.mSuccessTime++;
                Map<String, File> map2 = gVar.f313010h;
                if (map2 != null) {
                    file = map2.get(gVar.f313011i);
                } else {
                    file = null;
                }
                z17 = HippyFontUtils.injectHippyTypeFace(file);
            } else {
                this.mFailTime++;
                z17 = false;
            }
            int i17 = this.mSuccessTime;
            int i18 = this.mFailTime;
            if (i17 + i18 == this.mTotalSum) {
                Promise promise = this.mPromise;
                if (i18 > 0) {
                    i3 = -1;
                } else {
                    i3 = 0;
                }
                if (!z17) {
                    i16 = -1;
                }
                HippyFontUtils.notifyPromise(promise, i3, i16);
            }
        }
    }

    public static boolean checkFileExit(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static void clearFontFiles() {
        File[] listFiles;
        try {
            File file = new File(HippyUtils.getHippyFontRootDir());
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                synchronized (lockForClearFile) {
                    for (int i3 = 0; i3 < listFiles.length; i3++) {
                        File file2 = listFiles[i3];
                        if (file2 != null && file2.isFile() && !loadingFonts.contains(listFiles[i3].getAbsolutePath())) {
                            listFiles[i3].delete();
                            if (QLog.isDevelopLevel()) {
                                QLog.d(TAG, 4, "clearFontFiles delete:", listFiles[i3].getName());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "clearFontFiles error:", th5);
        }
    }

    public static com.tencent.mobileqq.vip.g createDownloadTask(String str, String str2) {
        return new com.tencent.mobileqq.vip.g(str, new File(str2));
    }

    public static ArrayList filterArray(@NonNull HippyArray hippyArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < hippyArray.size(); i3++) {
            String string = hippyArray.getString(i3);
            if (!checkFileExit(getFontPath(string))) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    public static com.tencent.mobileqq.vip.h getDownloader() {
        return ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(4);
    }

    public static HashMap<String, Typeface> getFontCache() {
        Object obj;
        try {
            Field declaredField = TypeFaceUtil.class.getDeclaredField("mFontCache");
            declaredField.setAccessible(true);
            obj = declaredField.get("mFontCache");
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, "getStaticFieldValue error ", e16);
            obj = null;
        }
        if (obj == null || !(obj instanceof HashMap)) {
            return null;
        }
        return (HashMap) obj;
    }

    public static String getFontPath(String str) {
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return HippyUtils.getHippyFontRootDir() + parseFileName(str);
    }

    public static boolean injectHippyTypeFace(File file) {
        HashMap<String, Typeface> fontCache;
        ArrayList<String> arrayList;
        if (file == null || !file.exists() || (fontCache = getFontCache()) == null) {
            return false;
        }
        String str = parseFontFamily(file.getAbsolutePath()) + 0;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "injectHippyTypeFace key = " + str);
        }
        try {
            try {
                synchronized (lockForClearFile) {
                    arrayList = loadingFonts;
                    arrayList.add(file.getAbsolutePath());
                }
                fontCache.put(str, Typeface.createFromFile(file));
                synchronized (lockForClearFile) {
                    arrayList.remove(file.getAbsolutePath());
                }
                return true;
            } catch (RuntimeException e16) {
                e16.printStackTrace();
                QLog.e(TAG, 1, "createFromFile error ", e16);
                synchronized (lockForClearFile) {
                    loadingFonts.remove(file.getAbsolutePath());
                    return false;
                }
            }
        } catch (Throwable th5) {
            synchronized (lockForClearFile) {
                loadingFonts.remove(file.getAbsolutePath());
                throw th5;
            }
        }
    }

    public static HippyMap newRspObj(int i3, int i16, Object obj) {
        HippyMap hippyMap = new HippyMap();
        try {
            hippyMap.pushInt("downloadCode", i3);
            hippyMap.pushInt(QzoneIPCModule.RESULT_CODE, i16);
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    hippyMap.pushJSONObject(new JSONObject().put("data", obj));
                } else {
                    hippyMap.pushObject("data", obj);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "newRspObj error" + e16);
        }
        return hippyMap;
    }

    public static void notifyPromise(Promise promise, int i3, int i16) {
        if (promise == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "notifyPromise returnCode = " + i3 + " registerCode = " + i16);
        }
        promise.resolve(newRspObj(i3, i16, null));
    }

    public static String parseFileName(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("/")) {
            return str.substring(str.lastIndexOf("/") + 1);
        }
        return "";
    }

    public static String parseFontFamily(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = File.separator;
            if (str.contains(str2)) {
                try {
                    String substring = str.substring(str.lastIndexOf(str2) + 1);
                    return substring.substring(0, substring.lastIndexOf("."));
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e(TAG, 1, "parseFontFamily error , path = " + str, e16);
                }
            }
        }
        return "";
    }

    public static void startAsyncDownloadFont(final HippyArray hippyArray, final Promise promise) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.utils.HippyFontUtils.1
            @Override // java.lang.Runnable
            public void run() {
                HippyFontUtils.startDownloadFont(HippyArray.this, promise);
            }
        }, 128, null, false);
    }

    public static void startDownloadFont(HippyArray hippyArray, Promise promise) {
        if (hippyArray != null && hippyArray.size() != 0) {
            ArrayList filterArray = filterArray(hippyArray);
            if (filterArray.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "all file has downloaded");
                }
                notifyPromise(promise, 1, 1);
            } else {
                FontDownloadListener fontDownloadListener = new FontDownloadListener(promise, filterArray.size());
                com.tencent.mobileqq.vip.h downloader = getDownloader();
                Iterator it = filterArray.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    downloader.startDownload(createDownloadTask(str, getFontPath(str)), fontDownloadListener, null);
                }
            }
        }
    }
}
