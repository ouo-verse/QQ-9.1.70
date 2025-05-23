package cooperation.qzone.webviewplugin.personalize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.vip.manager.MonitorManager;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneFacadeJsHandleLogic {
    public static final String AVATAR_FILE_CACHE_NAME = "avatar";
    public static final String FACE_SP_KEY = "key_personalize_prefix_19";
    public static final String KEY_PERSONALIZE_PREFIX = "key_personalize_prefix";
    public static final String TAG = "QZoneFacadeJsHandleLogic";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class InnerEnvironment {
        private static final String TAG = "InnerEnvironment";

        InnerEnvironment() {
        }

        public static File getExternalCacheDir() {
            synchronized (InnerEnvironment.class) {
                String str = QZoneFilePath.ROOT_QZONE_PATH;
                File file = new File(str);
                if (!file.exists()) {
                    try {
                        new File(str, ".nomedia").createNewFile();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    if (!file.mkdirs()) {
                        if (QLog.isColorLevel()) {
                            QLog.w(TAG, 2, "Unable to create external cache directory");
                        }
                        return null;
                    }
                }
                return file;
            }
        }
    }

    public static String getAvatarFileCacheDir(Context context) {
        return getExternalCacheDir("avatar");
    }

    public static String getExternalCacheDir(String str) {
        File externalCacheDir = InnerEnvironment.getExternalCacheDir();
        if (externalCacheDir == null) {
            return null;
        }
        String absolutePath = externalCacheDir.getAbsolutePath();
        if (TextUtils.isEmpty(str)) {
            return absolutePath;
        }
        File file = new File(absolutePath + File.separator + str);
        synchronized (QZoneFacadeJsHandleLogic.class) {
            if (file.isFile()) {
                FileUtils.delete(file);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file.getAbsolutePath();
    }

    public static void handleCheckDownloadedIdList(WebViewPlugin.b bVar, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleCheckDownloadedIdList");
        }
        String avatarIdFromFile = getAvatarIdFromFile();
        CustomWebView e16 = bVar.e();
        if (e16 != null) {
            e16.callJs("window.QzAvatarDressJSInterface.onReceive({type:\"idlist\",data:\"" + avatarIdFromFile + "\"});");
        }
    }

    public static void handleDownloadFacadeFinish(WebViewPlugin.b bVar, String... strArr) {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleDownloadFacadeFinish");
        }
        String str4 = "";
        if (strArr == null || strArr.length <= 0) {
            str = "";
            str2 = str;
        } else {
            try {
                jSONObject = new JSONObject(strArr[0]);
                str = jSONObject.getString("avatarID");
                try {
                    str3 = jSONObject.getString(PhotoCategorySummaryInfo.AVATAR_URL);
                } catch (JSONException e16) {
                    e = e16;
                    str3 = "";
                }
            } catch (JSONException e17) {
                e = e17;
                str = "";
                str3 = str;
            }
            try {
                str4 = jSONObject.getString("type");
            } catch (JSONException e18) {
                e = e18;
                e.printStackTrace();
                str2 = str4;
                str4 = str3;
                if (TextUtils.isEmpty(str4)) {
                    return;
                } else {
                    return;
                }
            }
            str2 = str4;
            str4 = str3;
        }
        if (TextUtils.isEmpty(str4) || bVar.a() == null) {
            return;
        }
        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_FACADE_JS_TO_QZONE);
        Bundle bundle = new Bundle();
        bundle.putString("avatarId", str);
        bundle.putString(PhotoCategorySummaryInfo.AVATAR_URL, str4);
        bundle.putString("type", str2);
        bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_DOWNLOAD);
        intent.putExtras(bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "actionString: " + intent.getAction());
        }
        QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
    }

    public static void handleSetFacadeFinish(WebViewPlugin.b bVar, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleSetFacadeFinish");
        }
        if (bVar.b() == null || bVar.a() == null) {
            return;
        }
        LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_19", 0, Long.valueOf(bVar.b().getCurrentAccountUin()).longValue());
        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_FACADE_JS_TO_QZONE);
        Bundle bundle = new Bundle();
        bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR);
        intent.putExtras(bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "actionString: " + intent.getAction());
        }
        QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
        boolean z16 = true;
        if (strArr != null && strArr.length >= 1 && !TextUtils.isEmpty(strArr[0])) {
            try {
                z16 = new JSONObject(strArr[0]).optInt("need_jump") == 1;
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.getMessage());
                MonitorManager.f().h(15, 4, " parse json error " + e16.getStackTrace(), false);
            }
        }
        if (z16) {
            bVar.a().finish();
        }
    }

    public static String getAvatarIdFromFile() {
        String str;
        String avatarFileCacheDir = getAvatarFileCacheDir(null);
        if (avatarFileCacheDir != null) {
            avatarFileCacheDir.substring(0, avatarFileCacheDir.lastIndexOf("/"));
            File file = new File(avatarFileCacheDir);
            if (!file.isDirectory()) {
                str = "";
            } else {
                str = "";
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        str = str + file2.getName() + ",";
                    }
                }
            }
            if (str.length() > 0) {
                return str.substring(0, str.length() - 1);
            }
        }
        return "";
    }
}
