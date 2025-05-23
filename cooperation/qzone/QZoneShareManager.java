package cooperation.qzone;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.mobileqq.thirdsig.api.b;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneShareManager {
    public static final String AVATAR_URL_PREFIX = "avatar://";
    public static final String GLORY_OF_KINGS = "1104466820";
    public static final String KEY_IS_THIRDPARTYSHARE = "key_share_is_third_party";
    public static final String KEY_SAHRE_DATA = "share_data";
    public static final String KUOLIE_SHARE_APPID = "101735437";
    public static final int MSG_QZONE_SHARE_IMAGE_UPLOAD_OK = 55555;
    public static final int MSG_QZONE_SHARE_LATER_CREATE_DIALOG = 55556;
    public static final int MSG_QZONE_SHARE_OPEN_ID_OK = 55557;
    public static final int MSG_QZONE_SHARE_UPLOAD_IMAGE_SKEY_ERROR = 55558;
    public static final String QQ_SHARE_APPID = "1103584836";
    public static final String QZONE_SHARE_ACTION = "share_action";
    public static final String QZONE_SHARE_APPNAME = "app_name";
    public static final String QZONE_SHARE_AT_FRIEND = "at_friend";
    public static final String QZONE_SHARE_EVENT_TAG = "event_tag";
    public static final String QZONE_SHARE_EXTSTRING = "share_ext_string";
    public static final int QZONE_SHARE_FREQUENTLY_ERROR = -11210;
    public static final String QZONE_SHARE_FROM_MINI_APP = "from_mini_app";
    public static final String QZONE_SHARE_FROM_QCIRCLE = "qcircle";
    public static final String QZONE_SHARE_FROM_WEB = "from_web";
    public static final String QZONE_SHARE_HULIAN_APPID = "hulian_appid";
    public static final String QZONE_SHARE_IMAGES = "images";
    public static final String QZONE_SHARE_KEY_MINI_APPID = "key_mini_appid";
    public static final String QZONE_SHARE_KEY_MINI_APP_TAIL = "key_mini_app_tail";
    public static final String QZONE_SHARE_KEY_REUQIRE_STORAGE_PERMISSION = "key_require_storage_permission";
    public static final String QZONE_SHARE_KEY_SHARE_SOURCE = "shareSource";
    public static final int QZONE_SHARE_MAX_PIC = 9;
    public static final int QZONE_SHARE_NETWORK_INVALID_ERROR = -1;
    public static final String QZONE_SHARE_OPENID = "open_id";
    public static final int QZONE_SHARE_SENSITIVE_WORD_ERROR1 = -11207;
    public static final int QZONE_SHARE_SENSITIVE_WORD_ERROR2 = -11215;
    public static final int QZONE_SHARE_SUMMARY_MAX = 40;
    public static final String QZONE_SHARE_SUMMERY = "summary";
    public static final String QZONE_SHARE_THIRD_PARTY_APPID = "third_party_appid";
    public static final String QZONE_SHARE_THIRD_PARTY_EXTEND_MAP = "third_party_extend_map";
    public static final String QZONE_SHARE_THIRD_PARTY_URL = "third_party_url";
    public static final int QZONE_SHARE_TITLE_MAX = 30;
    public static final int QZONE_SHARE_TYPE_IMAGE = 5;
    public static final int QZONE_SHARE_TYPE_SHUOSHUO = 3;
    public static final int QZONE_SHARE_TYPE_VIDEO = 4;
    public static final int QZONE_SHARE_UPLOAD_IMAGE_SKEY_ERROR = -2;
    public static final String QZONE_SHARE_VIDEO_PATH = "file_send_path";
    public static final String QZONE_SHARE_VIDEO_TEXT = "defaultText";
    public static int QZONE_UPLOAD_FAIL_RESULT_CODE = 0;
    public static final int THIRD_PART_SHARE_APPID = 2020014;
    public static final String TAG = TAG;
    public static final String TAG = TAG;
    public static String QZONE_UPLOAD_FAIL_RESULT_TEXT = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadFail", "\u4e0a\u4f20\u5931\u8d25");
    private static ConcurrentHashMap<String, OpenID> mOpenIDCache = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface ShareResultCallBack {
        void onShareResult(boolean z16, int i3, String str);
    }

    public static final ArrayList<String> batchUploadImages(ArrayList<String> arrayList, String str, String str2) {
        QZONE_UPLOAD_FAIL_RESULT_CODE = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str3 = arrayList.get(i3);
                if (FileUtils.fileExists(str3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "local url:" + str3);
                    }
                    if (FileUtils.getFileOrFolderSize(str3) > 2097152) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "file length:" + FileUtils.getFileOrFolderSize(str3));
                        }
                        File compressImages = compressImages(str3, i3);
                        if (compressImages != null) {
                            String absolutePath = compressImages.getAbsolutePath();
                            QLog.d(TAG, 2, "compressImages new Path:" + absolutePath);
                            arrayList2.add(compressImages);
                            str3 = absolutePath;
                        } else {
                            QLog.d(TAG, 1, "compressImages error");
                            return arrayList;
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("Connection", "keep-alive");
                    hashMap.put("Referer", "https://www.qq.com");
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("type", str2);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("share_image", str3);
                    String uploadImageWithHttps = HttpUtil.uploadImageWithHttps(MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_QZONE_UPLOAD_PIC, HttpUtil.LOCAL_IMAGE_UPLOAD_URL), HttpUtil.LOCAL_IMAGE_UPLOAD_HOST, str, hashMap2, hashMap3, hashMap, true);
                    if (uploadImageWithHttps != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(uploadImageWithHttps);
                            if (jSONObject.getInt("retcode") == 0) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                                if (jSONObject2 != null) {
                                    arrayList.set(i3, jSONObject2.getString("url"));
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 2, "target url:" + jSONObject2.getString("url"));
                                    }
                                }
                            } else {
                                QZONE_UPLOAD_FAIL_RESULT_CODE = jSONObject.getInt("retcode");
                                QLog.d(TAG, 1, "upload fail, code = " + QZONE_UPLOAD_FAIL_RESULT_CODE);
                            }
                        } catch (JSONException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, e16.getMessage());
                            }
                        }
                    } else {
                        QLog.e(TAG, 1, "uploadImageWithHttps error");
                    }
                } else {
                    QLog.e(TAG, 1, "uploadImageWithHttps file not exist");
                }
            }
            deleteTempFile(arrayList2);
        }
        return arrayList;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int round;
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (i17 <= i16 && i18 <= i3) {
            round = 2;
        } else {
            round = Math.round(i17 / i16);
            int round2 = Math.round(i18 / i3);
            if (round >= round2) {
                round = round2;
            }
        }
        if (round <= 0) {
            return 2;
        }
        return round;
    }

    public static final Bundle checkQzoneShareParams(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("image_url");
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && stringArrayList != null && !stringArrayList.isEmpty()) {
            bundle.remove("detail_url");
        }
        resetQzoneShareImages(bundle);
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static File compressImages(String str, int i3) {
        Bitmap bitmap;
        String internalCacheDir = CacheManager.getInternalCacheDir(CacheManager.QZONE_TEMP_IMAGE_SHARE);
        String extension = FileUtils.getExtension(str);
        Bitmap bitmap2 = 0;
        r3 = null;
        File file = null;
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = calculateInSampleSize(options, 640, 640);
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeFile(str, options);
                if (bitmap != null && internalCacheDir != null) {
                    try {
                        File file2 = new File(internalCacheDir, i3 + extension);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        if (bitmap.compress(Bitmap.CompressFormat.PNG, 50, fileOutputStream)) {
                            fileOutputStream.flush();
                        }
                        fileOutputStream.close();
                        file = file2;
                    } catch (Exception e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "CompressImage Failed", e);
                        }
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                            System.gc();
                        }
                        return null;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "OutOfMemoryError Has Occurred When Compress The Image", e);
                        }
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                            System.gc();
                        }
                        return null;
                    }
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                    System.gc();
                }
                return file;
            } catch (Exception e18) {
                e = e18;
                bitmap = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                bitmap = null;
            } catch (Throwable th5) {
                th = th5;
                if (bitmap2 != 0) {
                    bitmap2.recycle();
                    System.gc();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            bitmap2 = str;
            if (bitmap2 != 0 && !bitmap2.isRecycled()) {
                bitmap2.recycle();
                System.gc();
            }
            throw th;
        }
    }

    public static void deleteTempFile(ArrayList<File> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                FileUtils.deleteFile(it.next());
            }
            arrayList.clear();
        }
    }

    public static OpenID getOpenID(AppRuntime appRuntime, String str, BusinessObserver businessObserver) {
        OpenID openID = mOpenIDCache.get(str);
        if (openID != null) {
            return openID;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "get openid key = " + str);
        }
        getOpenID_new(appRuntime, str, businessObserver);
        return null;
    }

    private static void getOpenID_new(AppRuntime appRuntime, final String str, final BusinessObserver businessObserver) {
        ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "all")).getOpenId(appRuntime.getLongAccountUin(), Integer.parseInt(str), "", new b() { // from class: cooperation.qzone.QZoneShareManager.1
            @Override // com.tencent.mobileqq.thirdsig.api.b
            public void onFail(int i3, @NonNull String str2) {
                QLog.w(QZoneShareManager.TAG, 1, "result = " + i3 + " errMsg = " + str2);
            }

            @Override // com.tencent.mobileqq.thirdsig.api.b
            public void onSuccess(@NonNull String str2) {
                OpenID openID = new OpenID();
                openID.appID = str;
                openID.openID = str2;
                BusinessObserver businessObserver2 = businessObserver;
                if (businessObserver2 != null) {
                    businessObserver2.onUpdate(1, true, openID);
                }
            }
        });
    }

    public static final long getShareAppId(Intent intent) {
        Bundle bundleExtra;
        if (intent == null || (bundleExtra = intent.getBundleExtra(KEY_SAHRE_DATA)) == null) {
            return 0L;
        }
        return bundleExtra.getLong("req_share_id", 0L);
    }

    public static boolean isQzoneShareWhite(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHARE_WHITE_LIST, QzoneConfig.DefaultValue.DEFAULT_SHARE_WHITE_LIST);
        if (!TextUtils.isEmpty(config)) {
            for (String str2 : config.split(",")) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isShareFromQCircle(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("qcircle");
    }

    private static boolean isValidUrl(String str) {
        if (!HttpUtil.isValidUrl(str) && (str == null || !str.startsWith("avatar://"))) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static final boolean jumpToQzoneShare(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener) {
        return jumpToQzoneShare(appInterface, context, bundle, onDismissListener, -1);
    }

    public static final void publishToQzone(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener) {
        publishToQzone(appInterface, context, bundle, onDismissListener, -1);
    }

    public static final void publishToQzoneFromMiniApp(Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).publishToQzoneFromMiniApp(context, bundle, onDismissListener, i3);
    }

    public static final Bundle resetQzoneShareImages(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("image_url");
        if (stringArrayList != null) {
            for (int size = stringArrayList.size() - 1; size >= 0; size--) {
                String str = stringArrayList.get(size);
                if (!isValidUrl(str) && !FileUtils.fileExists(str)) {
                    stringArrayList.remove(size);
                }
            }
            while (stringArrayList.size() > 9) {
                stringArrayList.remove(9);
            }
            if (stringArrayList.size() > 0) {
                if (isValidUrl(stringArrayList.get(0))) {
                    for (int size2 = stringArrayList.size() - 1; size2 >= 0; size2--) {
                        if (!isValidUrl(stringArrayList.get(size2))) {
                            stringArrayList.remove(size2);
                        }
                    }
                } else {
                    for (int size3 = stringArrayList.size() - 1; size3 >= 0; size3--) {
                        if (size3 != 0) {
                            stringArrayList.remove(size3);
                        }
                    }
                }
            }
            bundle.putStringArrayList("image_url", stringArrayList);
        }
        return bundle;
    }

    public static final void shareToQZoneForRedPocket(Context context, String str, DialogInterface.OnDismissListener onDismissListener, int i3, String str2, String str3) {
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mTitle = str2 + HardCodeUtil.qqStr(R.string.s8b);
        qZoneShareData.mSummary = HardCodeUtil.qqStr(R.string.f172576s84);
        ArrayList<String> arrayList = new ArrayList<>();
        qZoneShareData.mImageUrls = arrayList;
        arrayList.add("https://qzonestyle.gtimg.cn/aoi/sola/20161111222053_4wlQcl1Eta.png");
        qZoneShareData.targetUrl = "https://h5.qzone.qq.com/redpacket/share?_wv=1&_ws=1&uin=" + str;
        qZoneShareData.from = 0;
        qZoneShareData.shareUin = str;
        shareToQzone(context, str, qZoneShareData, onDismissListener, i3);
    }

    public static final void shareToQzone(Context context, String str, QZoneShareData qZoneShareData, DialogInterface.OnDismissListener onDismissListener, int i3) {
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareToQzone(context, str, qZoneShareData, onDismissListener, i3);
    }

    public static void shareToQzoneFromAskAnonymously(Context context, String str, QZoneShareData qZoneShareData, int i3) {
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareToQzoneFromAskAnonymously(context, str, qZoneShareData, i3);
    }

    @Deprecated
    public static final boolean jumpToQzoneShare(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        return jumpToQzoneShare(appInterface.getCurrentAccountUin(), context, bundle, onDismissListener, i3);
    }

    public static final void publishToQzone(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).publishToQzone(appInterface, context, bundle, onDismissListener, i3);
    }

    @Deprecated
    public static final boolean jumpToQzoneShare(String str, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        return ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jumpToQzoneShare(str, context, bundle, onDismissListener, i3);
    }
}
