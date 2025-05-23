package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.vas.VasIpcTempData;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.upload.uinterface.IUploadConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.model.Size;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.util.QZonePermission;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzonePhotoWallPlugin extends QzoneInternalWebViewPlugin {
    private static final int COMPRESS_HD = 2;
    private static final int COMPRESS_NORMAL = 0;
    private static final int COMPRESS_RAW = 3;
    private static final String NAMESPACE = "QZImagePicker";
    private static final byte REQUEST_PICK_PHOTO = 115;
    private static final String TAG = "QzonePhotoWallPlugin";
    public static Set<String> sIdentifierSet = new HashSet();
    private boolean mClipFlag;
    int mCompressType;
    private int mMaxPickCount;
    private boolean mNoNeedImageData;
    private int mPickerType;
    private String mTipText;
    private JSONObject mUserInfo;

    /* loaded from: classes38.dex */
    public interface PickerType {
        public static final int MobileAlbum = 0;
        public static final int QzoneAlbum = 1;
    }

    public QzonePhotoWallPlugin() {
        this.mMaxPickCount = VasNormalToggle.VAS_QZONE_PHOTO_CHOOSE_NUM_CONFIG.isEnable(true) ? 1 : 3;
        this.mUserInfo = null;
        this.mClipFlag = false;
        this.mNoNeedImageData = false;
        this.mCompressType = 0;
    }

    public static String checkSharpP(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead() || !SharpPUtil.isSharpPFile(file)) {
            return str;
        }
        try {
            if (!com.tencent.qqsharpP.a.b(context)) {
                QLog.w(TAG, 1, "------ sharpp is not avaliable.");
                return str;
            }
            Bitmap decodeSharpPByFilePath = SharpPUtil.decodeSharpPByFilePath(file.getAbsolutePath());
            if (decodeSharpPByFilePath == null) {
                return str;
            }
            String str2 = String.valueOf(System.currentTimeMillis()) + ".jpeg";
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE + str2);
            if (!PhotoUtils.saveBitmapToFile(decodeSharpPByFilePath, sDKPrivatePath, Bitmap.CompressFormat.JPEG, 90, true)) {
                return str;
            }
            try {
                QLog.i(TAG, 1, "------ sharpp file save success:" + str2);
                return sDKPrivatePath;
            } catch (Throwable th5) {
                th = th5;
                str = sDKPrivatePath;
                QLog.e(TAG, 1, "decodeSharpP catch an exception: ", th);
                return str;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private int getCompressType(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("compressType", 0);
        if (optInt != 1) {
            return optInt != 2 ? 0 : 3;
        }
        return 2;
    }

    private int getQzoneAlbumModel() {
        return this.mMaxPickCount > 1 ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoSelectMobilePhoto() {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.parentPlugin.mRuntime.a(), IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        Bundle bundle = new Bundle();
        bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", this.mMaxPickCount);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", this.mMaxPickCount <= 1);
        bundle.putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", this.mClipFlag);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
        bundle.putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        bundle.putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 6);
        bundle.putInt("uintype", 0);
        activityURIRequest.extra().putAll(bundle);
        QZoneHelper.addSource(activityURIRequest);
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 != null) {
            gotoSelectPicture(a16, this.parentPlugin, activityURIRequest, (byte) 115);
        } else {
            QLog.e(TAG, 1, "launchCustom MobileAlbum activity is null");
        }
    }

    private static void gotoSelectPicture(Activity activity, WebViewPlugin webViewPlugin, ActivityURIRequest activityURIRequest, byte b16) {
        int switchRequestCodeImpl = AbsBaseWebViewActivity.switchRequestCodeImpl(webViewPlugin, b16);
        activityURIRequest.extra().putString("keyAction", "actionSelectPicture");
        activityURIRequest.extra().putInt("requestCode", switchRequestCodeImpl);
        QRoute.startUri(activityURIRequest);
    }

    private void launchCustom(String str) {
        if ("MobileAlbum".equals(str)) {
            if (QZonePermission.requestStoragePermission(this.parentPlugin.mRuntime.a(), new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.webviewplugin.QzonePhotoWallPlugin.1
                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    super.onAllGranted();
                    QzonePhotoWallPlugin.this.gotoSelectMobilePhoto();
                }
            }, QQPermissionConstants.Business.SCENE.QQ_QZONE_JS_SELECT_PHOTO)) {
                gotoSelectMobilePhoto();
            }
        } else if ("QzoneAlbum".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_personal_album_enter_model", getQzoneAlbumModel());
            bundle.putInt("_input_max", this.mMaxPickCount);
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, true);
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = this.parentPlugin.mRuntime.b().getAccount();
            bundle.putString(QZoneHelper.QZonePersonalAlbumContants.KEY_TIP_TEXT, this.mTipText);
            bundle.putString("keyAction", "actionSelectPicture");
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, false);
            QZoneHelper.forwardToPersonalAlbumSelect(this.parentPlugin.mRuntime.a(), userInfo, bundle, 115);
        }
    }

    private void parseSourceAndFrom(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mPickerType = jSONObject.getInt("pickerType");
            this.mMaxPickCount = jSONObject.getInt("maxPickCount");
            this.mCompressType = getCompressType(jSONObject);
            this.mUserInfo = jSONObject.optJSONObject(ITVKPlayerEventListener.KEY_USER_INFO);
            this.mClipFlag = jSONObject.optBoolean("clipByH5");
            this.mNoNeedImageData = jSONObject.optBoolean("noNeedImageData", false);
            this.mTipText = jSONObject.optString("tipText");
            if (this.mMaxPickCount > 1) {
                QLog.e(TAG, 1, "maxPickCount " + this.mMaxPickCount + ", json: " + str);
            }
        } catch (JSONException unused) {
            QLog.e(TAG, 1, "parse error " + this.mMaxPickCount);
        }
    }

    private void startTobase64(final ArrayList<String> arrayList) {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzonePhotoWallPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                QzonePhotoWallPlugin.this.toBase64(arrayList, false);
            }
        }, 8, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toBase64(ArrayList<String> arrayList, boolean z16) {
        int i3;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            try {
                String str = arrayList.get(i16);
                long currentTimeMillis = System.currentTimeMillis();
                if (!TextUtils.isEmpty(str)) {
                    String checkSharpP = checkSharpP(str, this.parentPlugin.mRuntime.a().getApplicationContext());
                    sIdentifierSet.add(checkSharpP);
                    Size bitmapSize = QzoneDynamicAlbumPlugin.getBitmapSize(checkSharpP);
                    if (bitmapSize != null) {
                        QLog.i(TAG, 2, "@coverOptimize with =" + bitmapSize.width + " height=" + bitmapSize.height + " compressType=" + this.mCompressType);
                        if (this.mCompressType != 3) {
                            double ratio = getRatio(this.parentPlugin.mRuntime.a(), this.mCompressType, bitmapSize);
                            if (ratio > 0.0d) {
                                bitmapSize.width = (int) (bitmapSize.width / ratio);
                                bitmapSize.height = (int) (bitmapSize.height / ratio);
                            }
                        }
                        QLog.i(TAG, 2, "@coverOptimize change width =" + bitmapSize.width + " height=" + bitmapSize.height + " compressType=" + this.mCompressType);
                        String encodeBase64File = QzoneDynamicAlbumPlugin.encodeBase64File(checkSharpP, bitmapSize.width, bitmapSize.height);
                        if (!TextUtils.isEmpty(encodeBase64File)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("currentIndex", i16);
                                if (getQzoneAlbumModel() == 2 || !z16) {
                                    QLog.i(TAG, 2, "@coverOptimize before path =" + checkSharpP);
                                    String encodeToString = Base64.encodeToString(checkSharpP.getBytes(), 2);
                                    jSONObject.put(IECDtReport.ACTION_IDENTIFIER, encodeToString);
                                    QLog.i(TAG, 2, "@coverOptimize toH5 identifier =" + encodeToString);
                                }
                                if (this.mNoNeedImageData) {
                                    i3 = 0;
                                } else {
                                    i3 = encodeBase64File.length();
                                    jSONObject.put("imageSize", i3);
                                    jSONObject.put("data", "data:image/jpg;base64," + encodeBase64File);
                                }
                                this.parentPlugin.callJs("window.QZImagePickerJSInterface.onReceive(" + jSONObject.toString() + ")");
                                QLog.i(TAG, 1, "@coverOptimize : maxPickCount=" + this.mMaxPickCount + " path=" + checkSharpP + " timediff=" + (System.currentTimeMillis() - currentTimeMillis) + " length=" + i3 + " compressType =" + this.mCompressType + " with =" + bitmapSize.width + " height=" + bitmapSize.height);
                            } catch (OutOfMemoryError e16) {
                                QLog.e(TAG, 2, "imageBase64 size=" + encodeBase64File.length() + ",compressType=" + this.mCompressType + ",width=" + bitmapSize.width + ",height=" + bitmapSize.height + "," + e16);
                                ToastUtil.a().f(HardCodeUtil.qqStr(R.string.s3i), 1);
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "toBase64: " + th5);
                return;
            }
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        String optString;
        if (str2.equals("QZImagePicker") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (str3.equals("choosePhoto")) {
                if (strArr != null && strArr.length > 0) {
                    parseSourceAndFrom(strArr[0]);
                    this.mCompressType = 0;
                    if (this.mPickerType == 0) {
                        launchCustom("MobileAlbum");
                    } else {
                        launchCustom("QzoneAlbum");
                    }
                }
                return true;
            }
            if (str3.equals("getLocalImage")) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    this.mCompressType = getCompressType(jSONObject);
                    optString = jSONObject.optString(IECDtReport.ACTION_IDENTIFIER, "");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                if (TextUtils.isEmpty(optString)) {
                    QLog.w(TAG, 2, "@coverOptimize  identifier is null or size is 0 ");
                    return false;
                }
                String str4 = new String(Base64.decode(optString, 2));
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str4);
                QLog.i(TAG, 1, "@coverOptimize  identifier =" + str4);
                if (!sIdentifierSet.contains(str4) && !VasIpcTempData.getKuikly().getBool(str4, false)) {
                    QLog.w(TAG, 2, "@coverOptimize  identifier is wrong identifier = " + str4);
                    return false;
                }
                this.mNoNeedImageData = false;
                startTobase64(arrayList);
                return true;
            }
            if ("generatePhotowallVideo".equals(str3)) {
                c.g(MobileQQ.sMobileQQ.getApplicationContext(), "mqqapi://qcircle/openqqpublish?target=12&share_preview_type=0");
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (b16 == 115 && i3 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                stringArrayListExtra = new ArrayList<>(1);
                String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                if (!TextUtils.isEmpty(stringExtra)) {
                    stringArrayListExtra.add(stringExtra);
                }
            }
            pushResultToH5(stringArrayListExtra);
        }
    }

    private void pushResultToH5(final ArrayList<String> arrayList) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.mUserInfo == null) {
                this.mUserInfo = new JSONObject();
            }
            jSONObject.put(ITVKPlayerEventListener.KEY_USER_INFO, this.mUserInfo);
            jSONObject.put("totalPickCount", arrayList == null ? 0 : arrayList.size());
            this.parentPlugin.callJs("window.QZImagePickerJSInterface.doSelectPhoto(" + jSONObject.toString() + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (getQzoneAlbumModel() == 2 && arrayList != null && arrayList.size() != 0) {
            sIdentifierSet.add(arrayList.get(0));
        }
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzonePhotoWallPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                QzonePhotoWallPlugin.this.toBase64(arrayList, true);
            }
        }, 8, null, false);
    }

    public static double getRatio(Context context, int i3, Size size) {
        double d16;
        double d17;
        int i16;
        if (size == null) {
            return 0.0d;
        }
        int i17 = size.width;
        int i18 = size.height;
        if (i17 < i18) {
            i17 = i18;
            i18 = i17;
        }
        IUploadConfig.UploadImageSize imageTargetSize = QZoneHelper.getImageTargetSize(context, i17, i18, i3, false);
        if (imageTargetSize == null) {
            return 0.0d;
        }
        int i19 = imageTargetSize.width;
        if (i17 <= i19 && i18 <= imageTargetSize.height) {
            return 0.0d;
        }
        if (i17 > i18) {
            d16 = i17 / i19;
            d17 = i18;
            i16 = imageTargetSize.height;
        } else {
            d16 = i18 / i19;
            d17 = i17;
            i16 = imageTargetSize.height;
        }
        double d18 = d17 / i16;
        return d16 > d18 ? d16 : d18;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        ArrayList<String> arrayList;
        if (j3 == 8589934600L && Integer.valueOf(String.valueOf(map.get("requestCode"))).intValue() == 115) {
            int intValue = Integer.valueOf(String.valueOf(map.get("requestCode"))).intValue();
            Intent intent = (Intent) map.get("data");
            int intValue2 = Integer.valueOf(String.valueOf(map.get(QzoneIPCModule.RESULT_CODE))).intValue();
            if (intValue == 115 && intValue2 == -1) {
                if (getQzoneAlbumModel() == 1) {
                    arrayList = intent.getStringArrayListExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH);
                } else {
                    arrayList = new ArrayList<>();
                    String stringExtra = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH);
                    if (!TextUtils.isEmpty(stringExtra)) {
                        arrayList.add(stringExtra);
                    }
                }
                pushResultToH5(arrayList);
            }
            return true;
        }
        return super.handleEvent(str, j3, map);
    }
}
