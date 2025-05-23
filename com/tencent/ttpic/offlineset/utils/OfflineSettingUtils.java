package com.tencent.ttpic.offlineset.utils;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.zip.ZipUtils;
import com.tencent.ttpic.offlineset.beans.ConfigJsonBean;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OfflineSettingUtils {
    private static final String CONFIG_NAME = "config.json";
    private static final int REQUEST_CHECK_CODE = 1;
    private static final int REQUEST_DOWNLOAD_ZIP_CODE = 2;
    private static String REQUEST_URL_PRE = "https://offline.qq.com/offline/check?";
    private static final String TAG = "OfflineSettingUtils";
    private static ArrayList<IDownloadedListener> sDownloadedListeners;
    private static IHttpClient sHttpClient;
    private static IResponseListener sResponseListener = new IResponseListener() { // from class: com.tencent.ttpic.offlineset.utils.OfflineSettingUtils.1
        @Override // com.tencent.ttpic.openapi.offlineset.utils.IResponseListener
        public void response(int i3, int i16, String str, Object obj) {
            String str2;
            if (i16 == 1) {
                StringBuilder sb5 = new StringBuilder();
                if (obj instanceof String) {
                    str2 = (String) obj;
                } else {
                    str2 = "";
                }
                sb5.append(str2);
                sb5.append(" response ERROR:");
                sb5.append(i3);
                sb5.append("->");
                sb5.append(str);
                LogUtils.e(OfflineSettingUtils.TAG, sb5.toString());
                return;
            }
            if (i3 != 1) {
                if (i3 == 2 && str != null && (obj instanceof String)) {
                    LogUtils.i(OfflineSettingUtils.TAG, "zip:" + str);
                    String unZip = ZipUtils.unZip(str, FileOfflineUtil.getOfflineDirPath() + File.separator + obj);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("unzip:");
                    sb6.append(unZip);
                    LogUtils.i(OfflineSettingUtils.TAG, sb6.toString());
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    OfflineSettingUtils.notifyDownloadListeners((String) obj);
                    return;
                }
                return;
            }
            if (obj instanceof String) {
                try {
                    JsonObject json2JsonObject = GsonUtils.json2JsonObject(str);
                    if (OfflineSettingUtils.isNeedUpdate(json2JsonObject)) {
                        OfflineSettingUtils.startDownload(json2JsonObject, (String) obj);
                        return;
                    }
                    String str3 = (String) obj;
                    OfflineSettingUtils.notifyDownloadListeners(str3);
                    LogUtils.i(OfflineSettingUtils.TAG, "\u6682\u4e14\u4e0d\u9700\u8981\u8fdb\u884c\u66f4\u65b0\u79bb\u7ebf\u914d\u7f6e\uff1a" + str3);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IDownloadedListener {
        void downloadCompleted(String str);
    }

    public static void addDownloadLister(IDownloadedListener iDownloadedListener) {
        if (iDownloadedListener != null) {
            if (sDownloadedListeners == null) {
                sDownloadedListeners = new ArrayList<>();
            }
            if (!sDownloadedListeners.contains(iDownloadedListener)) {
                sDownloadedListeners.add(iDownloadedListener);
            }
        }
    }

    private static String getBid(String str) {
        try {
            return "biz=" + Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String getHVerion(String str) {
        return "hver=" + getLocalVersion(str);
    }

    private static int getLocalVersion(String str) {
        ConfigJsonBean configJsonBean;
        if (str == null) {
            return 0;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(FileOfflineUtil.getOfflineDirPath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        sb5.append("config.json");
        String readJsonStringFromFile = FileOfflineUtil.readJsonStringFromFile(sb5.toString());
        if (readJsonStringFromFile == null || (configJsonBean = (ConfigJsonBean) GsonUtils.json2Obj(readJsonStringFromFile, new TypeToken<ConfigJsonBean>() { // from class: com.tencent.ttpic.offlineset.utils.OfflineSettingUtils.2
        }.getType())) == null) {
            return 0;
        }
        return configJsonBean.version;
    }

    public static String getOfflineCGIUrl(String str) {
        String bid = getBid(str);
        if (bid != null) {
            return ((((REQUEST_URL_PRE + getHVerion(str)) + ContainerUtils.FIELD_DELIMITER) + getPlatformId()) + ContainerUtils.FIELD_DELIMITER) + bid;
        }
        return null;
    }

    private static String getPlatformId() {
        return "pf=3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNeedUpdate(JsonObject jsonObject) {
        if (jsonObject == null) {
            return false;
        }
        try {
            Integer valueOf = Integer.valueOf(GsonUtils.getIntUnsafe(jsonObject, "type"));
            if (valueOf != null) {
                if (valueOf.intValue() == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyDownloadListeners(String str) {
        Iterator<IDownloadedListener> it = sDownloadedListeners.iterator();
        while (it.hasNext()) {
            it.next().downloadCompleted(str);
        }
    }

    public static void removeDownloadListener(IDownloadedListener iDownloadedListener) {
        ArrayList<IDownloadedListener> arrayList;
        if (iDownloadedListener != null && (arrayList = sDownloadedListeners) != null) {
            arrayList.remove(iDownloadedListener);
        }
    }

    public static void setHttpClient(IHttpClient iHttpClient) {
        sHttpClient = iHttpClient;
        if (iHttpClient != null) {
            iHttpClient.setResponseListener(sResponseListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startDownload(JsonObject jsonObject, String str) {
        if (jsonObject == null) {
            return;
        }
        try {
            String stringUnsafe = GsonUtils.getStringUnsafe(jsonObject, "url");
            if (stringUnsafe != null) {
                String offlineDirPath = FileOfflineUtil.getOfflineDirPath();
                IHttpClient iHttpClient = sHttpClient;
                if (iHttpClient != null) {
                    iHttpClient.download(2, str, stringUnsafe, offlineDirPath);
                }
            }
        } catch (Exception e16) {
            LogUtils.e(TAG, "startDownload:" + e16.getMessage());
        }
    }

    public static boolean updateOfflinePage(String str) {
        if (str != null && sHttpClient != null) {
            String offlineCGIUrl = getOfflineCGIUrl(str);
            LogUtils.i(TAG, "getUrl:" + offlineCGIUrl);
            sHttpClient.get(1, str, offlineCGIUrl);
            return true;
        }
        LogUtils.i(TAG, "bid :" + str + " ,sHttpClient:" + sHttpClient);
        return false;
    }
}
