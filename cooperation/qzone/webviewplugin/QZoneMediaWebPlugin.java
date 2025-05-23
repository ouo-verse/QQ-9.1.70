package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qzone.reborn.configx.g;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.media.QZoneMediaWrapper;
import cooperation.qzone.util.QZoneImageUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneMediaWebPlugin extends QzoneInternalWebViewPlugin implements QQProgressDialog.b {
    private static final String GET_PICTURE_METHOD_NAME = "getPicture";
    public static final String INTENT_IMAGE_SIZE_LIMIT = "imageSizeLimit";
    private static final String KEY_BUSINESS = "business";
    public static final String KEY_CALLBACK = "callback";
    public static final String KEY_GET_MEDIA_PARAM = "getMediaParam";
    private static final String KEY_MAX = "max";
    private static final String KEY_METHOD = "method";
    public static final int SOURCE_TYPE_CAMERA = 1;
    public static final int SOURCE_TYPE_IMAGE = 0;
    private static final String TAG = "QZoneMediaWebPlugin";
    private QQProgressDialog mLoadingDialog;
    private Thread mPicturesThread;
    private QQPermission mQQPermission;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes38.dex */
    public class PreparePicturesAndCallbackThread extends BaseThread {
        String mCallback;
        int mInMinHeight;
        int mInMinWidth;
        String mMethodName;
        int mOutMaxHeight;
        int mOutMaxWidth;
        String[] mPaths;
        String mRet;
        String mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;

        public PreparePicturesAndCallbackThread(String str, String str2, int i3, int i16, int i17, int i18, String[] strArr) {
            this.mCallback = str;
            this.mOutMaxWidth = i3;
            this.mOutMaxHeight = i16;
            this.mInMinWidth = i17;
            this.mInMinHeight = i18;
            this.mPaths = strArr;
            this.mMethodName = str2;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            JSONArray jSONArray = new JSONArray();
            try {
                try {
                    try {
                        try {
                            for (String str : this.mPaths) {
                                if (!isInterrupted()) {
                                    jSONArray.mo162put(QZoneImageUtils.packImageObject(str, this.mInMinWidth, this.mInMinHeight, this.mOutMaxWidth, this.mOutMaxHeight));
                                } else {
                                    throw new InterruptedException();
                                }
                            }
                            if (!isInterrupted()) {
                                this.mRet = "0";
                                this.mRetMsg = jSONArray.toString();
                                if (QZoneMediaWebPlugin.this.mLoadingDialog != null && QZoneMediaWebPlugin.this.mLoadingDialog.isShowing()) {
                                    QZoneMediaWebPlugin.this.mLoadingDialog.dismiss();
                                }
                                try {
                                    QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, this.mRet, this.mRetMsg);
                                    return;
                                } catch (OutOfMemoryError unused) {
                                    System.gc();
                                    this.mRet = "3";
                                    this.mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                                    QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                                    return;
                                }
                            }
                            throw new InterruptedException();
                        } catch (InterruptedException unused2) {
                            Activity a16 = QZoneMediaWebPlugin.this.parentPlugin.mRuntime.a();
                            if (a16 != null && !a16.isFinishing()) {
                                this.mRet = "1";
                                this.mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                            }
                            if (QZoneMediaWebPlugin.this.mLoadingDialog != null && QZoneMediaWebPlugin.this.mLoadingDialog.isShowing()) {
                                QZoneMediaWebPlugin.this.mLoadingDialog.dismiss();
                            }
                            try {
                                QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, this.mRet, this.mRetMsg);
                            } catch (OutOfMemoryError unused3) {
                                System.gc();
                                this.mRet = "3";
                                this.mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                                QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                            }
                        }
                    } catch (OutOfMemoryError unused4) {
                        System.gc();
                        this.mRet = "3";
                        this.mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                        if (QZoneMediaWebPlugin.this.mLoadingDialog != null && QZoneMediaWebPlugin.this.mLoadingDialog.isShowing()) {
                            QZoneMediaWebPlugin.this.mLoadingDialog.dismiss();
                        }
                        try {
                            QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, this.mRet, this.mRetMsg);
                        } catch (OutOfMemoryError unused5) {
                            System.gc();
                            this.mRet = "3";
                            this.mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                            QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        }
                    }
                } catch (IOException | JSONException unused6) {
                    this.mRet = "2";
                    this.mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                    if (QZoneMediaWebPlugin.this.mLoadingDialog != null && QZoneMediaWebPlugin.this.mLoadingDialog.isShowing()) {
                        QZoneMediaWebPlugin.this.mLoadingDialog.dismiss();
                    }
                    try {
                        QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, this.mRet, this.mRetMsg);
                    } catch (OutOfMemoryError unused7) {
                        System.gc();
                        this.mRet = "3";
                        this.mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                        QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    }
                }
            } catch (Throwable th5) {
                if (QZoneMediaWebPlugin.this.mLoadingDialog != null && QZoneMediaWebPlugin.this.mLoadingDialog.isShowing()) {
                    QZoneMediaWebPlugin.this.mLoadingDialog.dismiss();
                }
                try {
                    QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, this.mRet, this.mRetMsg);
                } catch (OutOfMemoryError unused8) {
                    System.gc();
                    this.mRet = "3";
                    this.mRetMsg = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                    QZoneMediaWebPlugin.this.parentPlugin.callJs(this.mCallback, "3", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                }
                throw th5;
            }
        }
    }

    private List<String> checkLackOfPermissions(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (this.mQQPermission.hasPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private void dealWithMediaList(String[] strArr, JSONObject jSONObject) {
        String optString = jSONObject.optString("method");
        String optString2 = jSONObject.optString("callback");
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        if (this.mLoadingDialog == null) {
            Activity a16 = this.parentPlugin.mRuntime.a();
            QQProgressDialog qQProgressDialog = new QQProgressDialog(a16, a16.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.mLoadingDialog = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.c7z);
            this.mLoadingDialog.O(this);
        }
        Thread thread = this.mPicturesThread;
        if (thread != null) {
            thread.interrupt();
        }
        if (!this.mLoadingDialog.isShowing()) {
            this.mLoadingDialog.show();
        }
        PreparePicturesAndCallbackThread preparePicturesAndCallbackThread = new PreparePicturesAndCallbackThread(optString2, optString, jSONObject.optInt("outMaxWidth", 1280), jSONObject.optInt("outMaxHeight", 1280), jSONObject.optInt("inMinWidth", 1), jSONObject.optInt("inMinHeight", 1), strArr);
        this.mPicturesThread = preparePicturesAndCallbackThread;
        ThreadManagerV2.post(preparePicturesAndCallbackThread, 5, null, true);
    }

    private static SharedPreferences getDefaultSharedPreferencesMultiProcess(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_qzone_preferences", 4);
    }

    private QZoneMediaBusiness getQzoneBusiness(String str) {
        QZoneMediaBusiness qZoneMediaBusiness = QZoneMediaBusiness.QZONE_DIARY;
        if (TextUtils.equals(str, qZoneMediaBusiness.getBusinessName())) {
            return qZoneMediaBusiness;
        }
        QZoneMediaBusiness qZoneMediaBusiness2 = QZoneMediaBusiness.QZONE_SHOUZHANG;
        return TextUtils.equals(str, qZoneMediaBusiness2.getBusinessName()) ? qZoneMediaBusiness2 : qZoneMediaBusiness;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamera(Intent intent, Context context, String str, JSONObject jSONObject) {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || webViewPlugin.mRuntime == null) {
            return;
        }
        try {
            webViewPlugin.startActivityForResult(intent, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA);
            getDefaultSharedPreferencesMultiProcess(context).edit().putString(AppConstants.Preferences.CAMERA_PHOTO_PATH, str).putString(KEY_GET_MEDIA_PARAM, jSONObject.toString()).commit();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            QQToast.makeText(context, R.string.f170671xw, 0).show();
        }
    }

    private void requestCameraData(final Context context, final JSONObject jSONObject, String str, String str2) {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || webViewPlugin.mRuntime == null || QavCameraUsage.a(BaseApplication.getContext())) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String str3 = AppConstants.SDCARD_PATH;
        sb5.append(str3);
        sb5.append("photo/");
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString()));
        if (!file.exists()) {
            file.mkdirs();
        }
        final String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str3 + "photo/" + System.currentTimeMillis() + ".jpg");
        final Intent intent = new Intent();
        FileProvider7Helper.setSystemCapture(BaseApplication.getContext(), new File(sDKPrivatePath), intent);
        if (jSONObject.optBoolean("front", false)) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        }
        WebViewPlugin.b bVar = this.parentPlugin.mRuntime;
        if ((bVar != null ? bVar.a() : null) == null) {
            return;
        }
        BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, QQPermissionConstants.Business.SCENE.QQ_QZONE_JS_OPEN_CAMERA);
        if (this.mQQPermission == null) {
            this.mQQPermission = QQPermissionFactory.getQQPermission(this.parentPlugin.mRuntime.a(), businessConfig);
        }
        List<String> checkLackOfPermissions = checkLackOfPermissions(QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        if (!checkLackOfPermissions.isEmpty()) {
            this.mQQPermission.requestPermissions((String[]) checkLackOfPermissions.toArray(new String[0]), 2, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.webviewplugin.QZoneMediaWebPlugin.1
                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    QZoneMediaWebPlugin.this.openCamera(intent, context, sDKPrivatePath, jSONObject);
                    super.onAllGranted();
                }

                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onDenied(List<String> list, List<Integer> list2) {
                    QLog.d(QZoneMediaWebPlugin.TAG, 1, "User requestPermissions " + list + list2);
                }
            });
        } else {
            openCamera(intent, context, sDKPrivatePath, jSONObject);
        }
    }

    private void requestLocalPhotoData(JSONObject jSONObject, String str) {
        WebViewPlugin.b bVar;
        boolean z16;
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null) {
            return;
        }
        try {
            if ((bVar.f() != null && this.parentPlugin.mRuntime.a() != null && (this.parentPlugin.mRuntime.a() instanceof AppActivity)) || (this.parentPlugin.mRuntime.a() instanceof BaseActivity)) {
                BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, QQPermissionConstants.Business.SCENE.QQ_QZONE_JS_SELECT_PHOTO);
                if (this.mQQPermission == null) {
                    this.mQQPermission = QQPermissionFactory.getQQPermission(this.parentPlugin.mRuntime.a(), businessConfig);
                }
                if (this.mQQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                    requestPermissionImpl(jSONObject);
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                startAlbumActivityForResult(jSONObject);
                return;
            }
            this.parentPlugin.callJs(str, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "getPicture ", th5);
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        String optString;
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || webViewPlugin.mRuntime == null || !"getPicture".equals(str3) || strArr.length != 1) {
            return false;
        }
        try {
            this.parentPlugin.addOpenApiListenerIfNeeded(str3, jsBridgeListener);
            jSONObject = new JSONObject(strArr[0]);
            jSONObject.put("method", str3);
            optString = jSONObject.optString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        int optInt = jSONObject.optInt("source", 0);
        BaseApplication context = BaseApplication.getContext();
        if (optInt == 0) {
            requestLocalPhotoData(jSONObject, optString);
        } else if (optInt == 1) {
            requestCameraData(context, jSONObject, str3, optString);
        }
        return true;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String[] strArr;
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || webViewPlugin.mRuntime == null) {
            return;
        }
        super.onActivityResult(intent, b16, i3);
        SharedPreferences defaultSharedPreferencesMultiProcess = getDefaultSharedPreferencesMultiProcess(BaseApplication.getContext());
        String string = defaultSharedPreferencesMultiProcess.getString(AppConstants.Preferences.CAMERA_PHOTO_PATH, "");
        String string2 = defaultSharedPreferencesMultiProcess.getString(KEY_GET_MEDIA_PARAM, "");
        if (g.f53821a.b().V1()) {
            defaultSharedPreferencesMultiProcess.edit().remove(AppConstants.Preferences.CAMERA_PHOTO_PATH).remove(KEY_GET_MEDIA_PARAM).apply();
        } else {
            defaultSharedPreferencesMultiProcess.edit().remove(AppConstants.Preferences.CAMERA_PHOTO_PATH).remove(KEY_GET_MEDIA_PARAM).commit();
        }
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            String optString = jSONObject.optString("callback");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            if (QZoneMediaWrapper.isFromQCirclePicker(intent)) {
                QLog.e(TAG, 1, "pick from qcircle");
                dealWithMediaList((String[]) QZoneMediaWrapper.getImagePathsFromQCircle(intent).toArray(new String[0]), jSONObject);
                return;
            }
            if (b16 == 20 || b16 == 21) {
                QLog.e(TAG, 1, "pick from qqbase");
                if (i3 == -1) {
                    if (b16 == 20) {
                        strArr = new String[]{string};
                    } else {
                        if (intent == null) {
                            this.parentPlugin.callJs(optString, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                            return;
                        }
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                        if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                            strArr = (String[]) stringArrayListExtra.toArray(new String[0]);
                        } else {
                            this.parentPlugin.callJs(optString, "2", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                            return;
                        }
                    }
                    dealWithMediaList(strArr, jSONObject);
                    return;
                }
                this.parentPlugin.callJs(optString, "1", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
    public void onBackPressed() {
        Thread thread = this.mPicturesThread;
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        Thread thread = this.mPicturesThread;
        if (thread != null) {
            thread.interrupt();
        }
        QQProgressDialog qQProgressDialog = this.mLoadingDialog;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mLoadingDialog.dismiss();
        }
        super.onDestroy();
    }

    void requestPermissionImpl(final JSONObject jSONObject) {
        this.mQQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.webviewplugin.QZoneMediaWebPlugin.2
            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                QZoneMediaWebPlugin.this.startAlbumActivityForResult(jSONObject);
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(List<String> list, List<Integer> list2) {
                QLog.d(QZoneMediaWebPlugin.TAG, 1, "User requestPermissions " + list + list2);
            }
        });
    }

    void startAlbumActivityForResult(JSONObject jSONObject) {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || webViewPlugin.mRuntime == null) {
            return;
        }
        QZoneMediaWrapper.PickConfig pickConfig = new QZoneMediaWrapper.PickConfig();
        pickConfig.needHeif = jSONObject.optBoolean("NEED_HEIF", false);
        pickConfig.maxNum = jSONObject.optInt("max", 1);
        pickConfig.imageSizeLimit = jSONObject.optInt("imageSizeLimit", 8388608);
        QZoneMediaWrapper.goSelectPhoto(pickConfig, getQzoneBusiness(jSONObject.optString("business", QZoneMediaBusiness.QZONE_DIARY.getBusinessName())), this.parentPlugin);
        getDefaultSharedPreferencesMultiProcess(BaseApplication.getContext()).edit().putString(KEY_GET_MEDIA_PARAM, jSONObject.toString()).commit();
    }
}
