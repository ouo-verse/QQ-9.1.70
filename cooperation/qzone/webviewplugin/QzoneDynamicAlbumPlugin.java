package cooperation.qzone.webviewplugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.reborn.albumx.qzonex.utils.d;
import com.qzone.reborn.util.i;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationH5;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.f;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IDataUtils;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZonePublishConfig;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.media.QZoneMediaWrapper;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.model.Size;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes38.dex */
public class QzoneDynamicAlbumPlugin extends QzoneInternalWebViewPlugin implements WebEventListener {
    public static final String DYNAMIC_ALBUM_LOCAL_IMAGE = "https://www.dynamicalbumlocalimage.com";
    private static final String DynamicCoverListUrl = "qzone.qq.com/dynamic/album/coverList";
    private static final String DynamicPreviewUrl = "qzone.qq.com/dynamic/album/preview";
    private static final String DynamicURL = "qzone.qq.com/dynamic";
    private static final String EVENT_PUBLISH_DYNAMIC_MOOD = "publishDynamicMood";
    public static final String KEY_CALLBACK = "callback";
    private static final int MSG_PICK_PHOTO_COMPRESS_FINISH = 2;
    private static final String MSG_VOLUME_CHANGE = "qbrowserVolumeChange";
    private static final String MY_DYNAMIC_ALBUM_URL = "https://h5.qzone.qq.com/dynamic/album/list?_ws&_wv=2098179&_wwv=4&_proxy=1";
    public static final String NAMESPACE = "qzDynamicAlbum";
    public static final String NAMESPACE2 = "Qzone";
    public static final String PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM = QZoneFilePath.CACHE_DYNAMIC_ALBUM;
    private static final String TAG = "QzoneDynamicAlbumPlugin";
    private static String currentUrl;
    static File dirdynamicalbum;
    private static int[] mSelectedImageSize;
    private boolean isChating;
    private boolean isResume;
    private boolean ispreSelloaded;
    private String mJSONArgs;
    private boolean musicPlaying;
    private boolean toPickPhoto;
    private byte REQUEST_PICK_PHOTO = PublicAccountH5AbilityPluginImpl.OPENIMG;
    private int REQUEST_PUBLISH_MOOD = 274;
    private int REQUEST_PICK_CLOUD_PHOTO = 1;
    private boolean isFromAlbum = false;
    private boolean isFromAlbumSharePanel = false;
    private List<String> mSelectedImageInfos = new ArrayList();
    private List<QzonePhotoInfo> mSelectedCloudImageInfos = new ArrayList();
    private int hasSelectSize = 30;
    Handler handler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            if (message.what == 2 && (obj = message.obj) != null && (obj instanceof String[])) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(QzoneDynamicAlbumPlugin.this.convertToJSONInfo((String[]) message.obj));
                QzoneDynamicAlbumPlugin.this.sendPhotoData(arrayList, message.arg1);
            }
        }
    };
    String mJumpToAlbumID = "";
    int mJumpToAlbumTheme = 0;
    int mSortType = 0;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0092: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:41:0x0092 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0069 A[Catch: all -> 0x0091, OutOfMemoryError -> 0x0094, Exception -> 0x0096, TryCatch #0 {OutOfMemoryError -> 0x0094, blocks: (B:5:0x000f, B:7:0x0014, B:12:0x0069, B:13:0x0073, B:15:0x007a, B:17:0x007e, B:22:0x001e, B:25:0x0030, B:27:0x0054, B:29:0x005a, B:32:0x002c), top: B:4:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String CompressImageFile(InputStream inputStream, BitmapFactory.Options options, int i3, boolean z16) {
        ByteArrayOutputStream byteArrayOutputStream;
        Object obj;
        Bitmap bitmap;
        boolean z17;
        Object obj2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e16) {
                e = e16;
                byteArrayOutputStream = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(obj2);
                throw th;
            }
            try {
                try {
                    if (options.inSampleSize > 1 || !IsSupportImgType(options.outMimeType) || z16) {
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                        options.inPurgeable = true;
                        options.inInputShareable = true;
                        try {
                            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                        } catch (OutOfMemoryError e18) {
                            QLog.e(TAG, 1, "CompressImageFile: OutOfMemoryError", e18);
                            bitmap = null;
                        }
                        QLog.i(TAG, 1, "@coverOptimize with=" + options.outWidth + " height =" + options.outHeight);
                        if (i3 != 0) {
                            bitmap = rotate(bitmap, i3);
                        }
                        if (bitmap != null) {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
                            bitmap.recycle();
                            z17 = true;
                            if (!z17) {
                                QLog.i(TAG, 1, "not compress, return source file base64");
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            }
                            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(byteArrayOutputStream);
                            return encodeToString;
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                    String encodeToString2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(byteArrayOutputStream);
                    return encodeToString2;
                } catch (Exception e19) {
                    e = e19;
                    QLog.e(TAG, 1, "CompressImageFile: Exception", e);
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(byteArrayOutputStream);
                    return null;
                }
            } catch (OutOfMemoryError e26) {
                e = e26;
                QLog.e(TAG, 1, "CompressImageFile: OutOfMemoryError", e);
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(byteArrayOutputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            obj2 = obj;
            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(obj2);
            throw th;
        }
    }

    public static float[] appendGPSInfo(String str) {
        ExifInterface exifInterface;
        float[] fArr;
        if (JpegExifReader.isCrashJpeg(str)) {
            return null;
        }
        try {
            exifInterface = new ExifInterface(str);
            fArr = new float[2];
        } catch (Exception unused) {
        }
        if (exifInterface.getLatLong(fArr)) {
            return fArr;
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:16|17|(1:19)|20|(1:22)|23|25|26|(8:31|(2:32|(1:34)(1:35))|36|37|38|40|41|42)|46|47|48|(1:50)|(7:52|36|37|38|40|41|42)(6:53|54|55|56|57|58)) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean compressDynamicAlbumImage(Context context, String str, String str2, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("compressDynamicAlbumImage", 2, "srcFilePath is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            QLog.e("compressDynamicAlbumImage", 2, "srcFilePath no exists");
            return false;
        }
        int imageDegree = getImageDegree(str);
        FileInputStream fileInputStream = null;
        Bitmap bitmap = null;
        r5 = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                FileInputStream fileInputStream3 = new FileInputStream(str);
                try {
                    BitmapFactory.Options sizeOpt = getSizeOpt(Uri.fromFile(file), context, i3, i16);
                    File file2 = new File(str2);
                    try {
                        try {
                            if (!dirdynamicalbum.exists()) {
                                dirdynamicalbum.mkdirs();
                            }
                            if (!file2.exists()) {
                                file2.createNewFile();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            try {
                                if (sizeOpt.inSampleSize <= 1 && IsSupportImgType(sizeOpt.outMimeType)) {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = fileInputStream3.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream2.write(bArr, 0, read);
                                    }
                                    fileOutputStream2.close();
                                    fileInputStream3.close();
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                    try {
                                        fileInputStream3.close();
                                    } catch (IOException unused2) {
                                    }
                                    return true;
                                }
                                sizeOpt.inPreferredConfig = Bitmap.Config.RGB_565;
                                sizeOpt.inPurgeable = true;
                                sizeOpt.inInputShareable = true;
                                bitmap = BitmapFactory.decodeStream(fileInputStream3, null, sizeOpt);
                                if (imageDegree != 0) {
                                    bitmap = rotate(bitmap, imageDegree);
                                }
                                if (bitmap != null) {
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream2);
                                    bitmap.recycle();
                                    fileOutputStream2.close();
                                    fileInputStream3.close();
                                    fileOutputStream2.close();
                                    fileInputStream3.close();
                                    return true;
                                }
                                QLog.e("compressDynamicAlbumImage", 2, "destBm is null");
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException unused3) {
                                }
                                try {
                                    fileInputStream3.close();
                                } catch (IOException unused4) {
                                }
                                return false;
                            } catch (Exception e16) {
                                e = e16;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                QLog.e("compressDynamicAlbumImage", 2, "get an exception:" + e);
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                }
                                try {
                                    fileInputStream3.close();
                                } catch (IOException unused6) {
                                }
                                return false;
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused7) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                } catch (Exception e18) {
                    e = e18;
                    fileInputStream = fileInputStream3;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    QLog.e("compressDynamicAlbumImage", 2, " return false at the end");
                    return false;
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused9) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static String compressImageToBase64(Context context, Uri uri, int i3, int i16, boolean z16) {
        InputStream inputStream;
        BitmapFactory.Options sizeCrop;
        Context context2 = null;
        try {
            if (uri == null) {
                return null;
            }
            try {
                sizeCrop = getSizeCrop(uri, context, i3, i16);
                inputStream = context.getContentResolver().openInputStream(uri);
            } catch (Exception e16) {
                e = e16;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(context2);
                throw th;
            }
            try {
                String CompressImageFile = CompressImageFile(inputStream, sizeCrop, getImageDegree(uri.getPath()), z16);
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream);
                return CompressImageFile;
            } catch (Exception e17) {
                e = e17;
                QLog.e(TAG, 1, "compressImage: Exception" + e);
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            context2 = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String convertToJSONInfo(String[] strArr) {
        Size bitmapSize = getBitmapSize(strArr[1]);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", "https://www.dynamicalbumlocalimage.com" + strArr[1]);
            if (bitmapSize != null) {
                jSONObject.put("width", bitmapSize.width);
                jSONObject.put("height", bitmapSize.height);
            }
            if (appendGPSInfo(strArr[0]) != null) {
                jSONObject.put("poiX", r8[1]);
                jSONObject.put("poiY", r8[0]);
                jSONObject.put("poiName", "");
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private void deletePhotos(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("photoList");
            jSONObject.getString("callback");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                Object obj = optJSONArray.get(i3);
                if (obj != null && (obj instanceof String)) {
                    String str2 = (String) obj;
                    arrayList.add(str2);
                    if (str2.startsWith("https://www.dynamicalbumlocalimage.com")) {
                        arrayList2.add(str2.replace("https://www.dynamicalbumlocalimage.com", ""));
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static String encodeBase64File(String str, int i3, int i16) {
        return encodeBase64File(str, i3, i16, false);
    }

    private void forwardToQzonePhotoPicker(String str) {
        this.mJSONArgs = str;
        try {
            this.hasSelectSize = new JSONObject(str).optInt("selectedPhotoNum");
        } catch (JSONException unused) {
            QLog.e("p2vMakeBlog", 1, "json error cmd:" + str);
        }
        QLog.d("p2vMakeBlog", 1, "hasSelectSize:" + this.hasSelectSize);
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        Bundle bundle = new Bundle();
        bundle.putString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID, this.mJumpToAlbumID);
        bundle.putLong("key_album_owner_uin", Long.parseLong(userInfo.qzone_uin));
        bundle.putInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_THEME, this.mJumpToAlbumTheme);
        bundle.putInt("key_personal_album_enter_model", 1);
        bundle.putInt(PeakConstants.SAVE_OPERATION, 1);
        bundle.putBoolean(QZoneHelper.Constants.KEY_IS_FILTER_VIDEO, true);
        bundle.putBoolean(QZoneHelper.Constants.KEY_IS_FROM_MAKE_BLOG, true);
        bundle.putInt(QZoneHelper.QZoneAlbumConstants.HAS_SELECT_SIZE, this.hasSelectSize);
        WebViewPlugin webViewPlugin = this.parentPlugin;
        QZoneHelper.forwardToPersonalPhotoList(this.parentPlugin.mRuntime.a(), userInfo, bundle, QZoneWebViewPlugin.generateRequestCode(webViewPlugin, webViewPlugin.mRuntime, 8));
    }

    public static Size getBitmapSize(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "getBitmapSize: OutOfMemoryError" + e16);
        }
        options.inJustDecodeBounds = false;
        return new Size(options.outWidth, options.outHeight);
    }

    private void getCloudDynamicAlbumImage(Bundle bundle, boolean z16) {
        String str;
        String str2;
        String str3;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST);
        this.mJumpToAlbumID = bundle.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID);
        this.mJumpToAlbumTheme = bundle.getInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_THEME);
        this.mSortType = bundle.getInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_SORT_TYPE);
        this.mSelectedCloudImageInfos = parcelableArrayList;
        if (QLog.isColorLevel()) {
            QLog.i("p2vMakeBlog", 1, "mJumpToAlbumID:" + this.mJumpToAlbumID + " mJumpToAlbumTheme:" + this.mJumpToAlbumTheme + " mSortType:" + this.mSortType);
        }
        if (z16) {
            if (this.mSelectedCloudImageInfos.size() > 0) {
                str = this.mSelectedCloudImageInfos.get(0).mAlbumId;
                str3 = this.mSelectedCloudImageInfos.get(0).mlloc;
                str2 = this.mSelectedCloudImageInfos.get(0).mBigUrl;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            RemoteHandleManager.getInstance().getSender().uploadFirstDynamicPhoto(str, str3, str2, this.mSelectedCloudImageInfos.size());
        }
    }

    private void getCloudPhotos(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            List<QzonePhotoInfo> list = this.mSelectedCloudImageInfos;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int size = this.mSelectedCloudImageInfos.size();
                for (int i3 = 0; i3 < size; i3++) {
                    JSONObject jSONObject = new JSONObject();
                    QzonePhotoInfo qzonePhotoInfo = this.mSelectedCloudImageInfos.get(i3);
                    String str2 = qzonePhotoInfo.mAlbumId;
                    String str3 = qzonePhotoInfo.mlloc;
                    String str4 = qzonePhotoInfo.mBigUrl;
                    Integer valueOf = Integer.valueOf(qzonePhotoInfo.mBigHeight);
                    Integer valueOf2 = Integer.valueOf(qzonePhotoInfo.mBigWidth);
                    jSONObject.put("albumid", str2);
                    jSONObject.put("lloc", str3);
                    jSONObject.put("url", str4);
                    jSONObject.put("height", valueOf);
                    jSONObject.put("width", valueOf2);
                    jSONArray.mo162put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("photoList", jSONArray);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("data", jSONObject2);
                this.parentPlugin.callJs(str, jSONObject3.toString());
                return;
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("code", -1);
            jSONObject4.put("msg", "fail");
            this.parentPlugin.callJs(str, jSONObject4.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static double getCropRatio(InputStream inputStream, int i3, int i16) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (OutOfMemoryError unused) {
        }
        int i17 = options.outWidth;
        int i18 = options.outHeight;
        if (i3 != -1 && i16 != -1) {
            double d16 = i17 / i3;
            double d17 = i18 / i16;
            return d16 > d17 ? d16 : d17;
        }
        if (i3 != -1) {
            return i17 / i3;
        }
        if (i16 != -1) {
            return i18 / i16;
        }
        return 0.0d;
    }

    public static int getImageDegree(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return JpegExifReader.getRotationDegree(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static WebResourceResponse getImageResponse(String str) {
        String str2;
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "getImageResponse start :" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = URLDecoder.decode(str.replace("https://www.dynamicalbumlocalimage.com", ""), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            str2 = null;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "image filePath :" + str2);
        }
        File file = new File(str2);
        String str3 = currentUrl;
        if (str3 != null && str3.equals(MY_DYNAMIC_ALBUM_URL)) {
            QLog.i(TAG, 4, "getImageResponse -  getThumbnail:" + str);
            InputStream thumbnail = getThumbnail(str2);
            if (thumbnail != null) {
                return new WebResourceResponse("image/*", "utf-8", thumbnail);
            }
        }
        if (!file.exists()) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "getImageResponse local file not exists :" + str2);
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str2);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "getImageResponse ****************** :" + str);
            }
            return new WebResourceResponse("image/*", "utf-8", fileInputStream);
        } catch (FileNotFoundException e17) {
            e17.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getImageResponse get local file fail:" + str);
            }
            return null;
        }
    }

    public static double getOptRatio(InputStream inputStream, int i3, int i16) {
        double d16;
        double d17;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (OutOfMemoryError unused) {
        }
        int i17 = options.outWidth;
        int i18 = options.outHeight;
        if (i17 < i18) {
            i18 = i17;
            i17 = i18;
        }
        if (i17 <= i3 && i18 <= i16) {
            return 0.0d;
        }
        if (i17 > i18) {
            d16 = i17 / i3;
            d17 = i18;
        } else {
            d16 = i18 / i3;
            d17 = i17;
        }
        double d18 = d17 / i16;
        return d16 > d18 ? d16 : d18;
    }

    private void getPhotos(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            List<String> list = this.mSelectedImageInfos;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.mSelectedImageInfos.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(new JSONObject(it.next()));
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("photoList", jSONArray);
                jSONObject.put("totalNumPreSelected", this.mSelectedImageInfos.size());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 0);
                jSONObject2.put("msg", "success");
                jSONObject2.put("data", jSONObject);
                this.parentPlugin.callJs(str, jSONObject2.toString());
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("code", -1);
            jSONObject3.put("msg", "fail");
            this.parentPlugin.callJs(str, jSONObject3.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static double getRatio(Size size) {
        double d16;
        double d17;
        int i3;
        if (mSelectedImageSize == null) {
            mSelectedImageSize = getDynamicAlbumImageSize();
        }
        if (size == null) {
            return 0.0d;
        }
        int i16 = size.width;
        int i17 = size.height;
        if (i16 < i17) {
            i16 = i17;
            i17 = i16;
        }
        int[] iArr = mSelectedImageSize;
        int i18 = iArr[0];
        if (i16 <= i18 && i17 <= iArr[1]) {
            return 0.0d;
        }
        if (i16 > i17) {
            d16 = i16 / i18;
            d17 = i17;
            i3 = iArr[1];
        } else {
            d16 = i17 / i18;
            d17 = i16;
            i3 = iArr[1];
        }
        double d18 = d17 / i3;
        return d16 > d18 ? d16 : d18;
    }

    private void getSelectNum(Bundle bundle) {
        try {
            int i3 = bundle.getInt(RemoteHandleConst.PARAM_DYNAMIC_MIN);
            int i16 = bundle.getInt(RemoteHandleConst.PARAM_DYNAMIC_MAX);
            String string = bundle.getString(RemoteHandleConst.PARAM_DYNAMIC_CMD);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("msg", "success");
            jSONObject.put("maxNum", i16);
            jSONObject.put("minNum", i3);
            this.parentPlugin.callJs(string, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static BitmapFactory.Options getSizeCrop(Uri uri, Context context, int i3, int i16) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        double cropRatio = getCropRatio(openInputStream, i3, i16);
        int i17 = (int) cropRatio;
        if (cropRatio > i17) {
            i17++;
        }
        options.inSampleSize = i17;
        options.inJustDecodeBounds = true;
        openInputStream.close();
        InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
        try {
            BitmapFactory.decodeStream(openInputStream2, null, options);
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "getSizeCrop" + e16);
        }
        openInputStream2.close();
        options.inJustDecodeBounds = false;
        return options;
    }

    public static BitmapFactory.Options getSizeOpt(Uri uri, Context context, int i3, int i16) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        double optRatio = getOptRatio(openInputStream, i3, i16);
        int i17 = (int) optRatio;
        if (optRatio > i17) {
            i17++;
        }
        options.inSampleSize = i17;
        options.inJustDecodeBounds = true;
        openInputStream.close();
        InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
        try {
            BitmapFactory.decodeStream(openInputStream2, null, options);
        } catch (OutOfMemoryError unused) {
        }
        openInputStream2.close();
        options.inJustDecodeBounds = false;
        return options;
    }

    private static InputStream getThumbnail(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = 1;
        while (i3 < Math.min(options.outWidth / 400, options.outHeight / 300)) {
            i3 *= 2;
        }
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "getThumbnail:outOfMemortError " + e16);
            return null;
        }
    }

    private void isDraftPhotosValid(String str) {
        boolean z16;
        QLog.d(TAG, 4, "isDraftPhotosValid - start");
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("photosPath");
            int i3 = 0;
            while (true) {
                if (i3 >= jSONArray.length()) {
                    z16 = true;
                    break;
                }
                String string = jSONArray.getString(i3);
                if (string.startsWith("https://www.dynamicalbumlocalimage.com")) {
                    File file = new File(string.replace("https://www.dynamicalbumlocalimage.com", ""));
                    QLog.d(TAG, 4, "isDraftPhotosValid - isValid:true");
                    if (!file.exists()) {
                        z16 = false;
                        break;
                    }
                }
                i3++;
            }
            String string2 = jSONObject.getString("callback");
            JSONObject jSONObject2 = new JSONObject();
            if (z16) {
                QLog.d(TAG, 4, "isDraftPhotosValid SUCCESS!");
                jSONObject2.put("code", 0);
                jSONObject2.put("msg", "success");
            } else {
                QLog.d(TAG, 4, "isDraftPhotosValid FAILE");
                jSONObject2.put("code", -1);
                jSONObject2.put("msg", "fail");
            }
            this.parentPlugin.callJs(string2, jSONObject2.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void requestPlayMusic(String str) {
        try {
            QZLog.d("dynamic.Album", 2, "requestPlayMusic start:" + str + ";isChating:" + this.isChating);
            JSONObject jSONObject = new JSONObject();
            if (this.isChating) {
                jSONObject.put("isCanPlayMusic", "false");
                this.parentPlugin.callJs(str, jSONObject.toString());
            } else {
                jSONObject.put("isCanPlayMusic", "true");
                this.parentPlugin.callJs(str, jSONObject.toString());
                AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService("audio");
                if (audioManager != null) {
                    audioManager.requestAudioFocus(null, 3, 1);
                }
            }
        } catch (JSONException e16) {
            QZLog.e("dynamic.Album", 2, "requestPlayMusic get jsonException, cmd:" + str);
            e16.printStackTrace();
        } catch (Exception e17) {
            QZLog.d("dynamic.Album", 2, "requestPlayMusic get an Exception, cmd:" + str);
            e17.printStackTrace();
        }
    }

    private void sendBlogCLoudPhotoToH5(Intent intent) {
        getCloudDynamicAlbumImage(intent.getExtras(), false);
        if (TextUtils.isEmpty(this.mJSONArgs)) {
            return;
        }
        QLog.d(TAG, 2, "sendBlogCLoudPhotoToH5 | mJSONArgs:" + this.mJSONArgs);
        getBlogCloudPhoto(this.mJSONArgs);
    }

    private void sendCloudDynmicPhotoSuccess() {
        RemoteHandleManager.getInstance().getSender().sendCloudDynmicPhotoSuccess((ArrayList) this.mSelectedCloudImageInfos);
        this.mSelectedCloudImageInfos.clear();
    }

    private void setDynamicAlbumData(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("songInfo");
            RemoteHandleManager.getInstance().getSender().updateDynamicAlbumInfo(optJSONObject.getString("music_id"), optJSONObject.getString(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID), optJSONObject.getString(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START), optJSONObject.getString(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void toBase64(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("callback");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("photoList");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                Object obj = optJSONArray.get(i3);
                if (obj != null && (obj instanceof String)) {
                    String str2 = (String) obj;
                    if (str2.startsWith("https://www.dynamicalbumlocalimage.com")) {
                        String replace = str2.replace("https://www.dynamicalbumlocalimage.com", "");
                        Size bitmapSize = getBitmapSize(replace);
                        if (bitmapSize == null) {
                            return;
                        }
                        String encodeBase64File = encodeBase64File(replace, bitmapSize.width, bitmapSize.height);
                        if (!TextUtils.isEmpty(encodeBase64File)) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", 0);
                            jSONObject2.put("msg", "success");
                            jSONObject2.put("data", encodeBase64File);
                            this.parentPlugin.callJs(string, jSONObject2.toString());
                        } else {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("code", -1);
                            jSONObject3.put("msg", "fail");
                            this.parentPlugin.callJs(string, jSONObject3.toString());
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934600L && (Integer.valueOf(String.valueOf(map.get("requestCode"))).intValue() == this.REQUEST_PICK_PHOTO || Integer.valueOf(String.valueOf(map.get("requestCode"))).intValue() == this.REQUEST_PUBLISH_MOOD)) {
            int intValue = Integer.valueOf(String.valueOf(map.get("requestCode"))).intValue();
            Intent intent = (Intent) map.get("data");
            int intValue2 = Integer.valueOf(String.valueOf(map.get(QzoneIPCModule.RESULT_CODE))).intValue();
            if (intValue == this.REQUEST_PICK_PHOTO) {
                if (intValue2 == -1) {
                    pickDynamicAlbumImage(intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
                } else {
                    sendPhotoData(null, 0);
                }
            } else if (intValue == this.REQUEST_PUBLISH_MOOD && intValue2 == -1) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("isPublishDynamicMood", true);
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put("*.qzone.qq.com");
                    jSONObject2.put("echo", false);
                    jSONObject2.put("broadcast", true);
                    jSONObject2.put("domains", jSONArray);
                    dispatchEvent(EVENT_PUBLISH_DYNAMIC_MOOD, jSONObject, jSONObject2);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                WebViewPlugin.b bVar = this.parentPlugin.mRuntime;
                if (bVar != null && bVar.a() != null) {
                    this.parentPlugin.mRuntime.a().finish();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && str.contains(DynamicURL)) {
            if (str.contains(DynamicCoverListUrl)) {
                RemoteHandleManager.getInstance().getSender().enableFirstDynamicPreUpload();
            }
            if (j3 == 2) {
                this.isResume = true;
                if (this.toPickPhoto) {
                    this.toPickPhoto = false;
                    sendPhotoData(null, 0);
                }
            } else if (j3 == 8589934597L) {
                this.isResume = false;
            } else if (j3 == 8589934608L) {
                notifyVolumeChange(MSG_VOLUME_CHANGE, 2);
            } else if (j3 == 8589934609L) {
                notifyVolumeChange(MSG_VOLUME_CHANGE, 1);
            } else if (j3 == 8589934601L && str.contains(DynamicPreviewUrl)) {
                RemoteHandleManager.getInstance().getSender().deletePrePostDynamicAlbum();
            }
            return super.handleEvent(str, j3, map);
        }
        return super.handleEvent(str, j3, map);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        final String str4;
        if ((str2.equals("qzDynamicAlbum") || str2.equals("Qzone")) && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (strArr != null && strArr.length != 0) {
                str4 = strArr[0];
            } else {
                str4 = "" + jsBridgeListener.f314007b;
            }
            QLog.d(TAG, 4, "NAMESPACE = " + str2 + ";method = " + str3 + ";args = " + str4);
            if ("deletePhotos".equals(str3)) {
                deletePhotos(str4);
                return true;
            }
            if ("saveDynamicAlbum".equals(str3)) {
                return true;
            }
            if ("getPhotos".equals(str3)) {
                QZLog.d("dynamic.Album", 4, "handleJsRequest - getPhotos - isFromAlbum:" + this.isFromAlbum);
                if (this.isFromAlbum) {
                    getCloudPhotos(str4);
                } else {
                    getPhotos(str4);
                }
                return true;
            }
            if ("getBlogCloudPhotoUrls".equals(str3)) {
                getBlogCloudPhoto(str4);
                return true;
            }
            if ("getCloudPhotoUrl".equals(str3)) {
                getCloudPhotos(str4);
            } else if ("dynamicSendSuccess".equals(str3)) {
                sendCloudDynmicPhotoSuccess();
            } else if ("isDraftPhotosValid".equals(str3)) {
                isDraftPhotosValid(str4);
            } else {
                if ("getSelectNum".equals(str3)) {
                    this.parentPlugin.mRuntime.b().getHandler(QzoneDynamicAlbumPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.2
                        @Override // java.lang.Runnable
                        public void run() {
                            RemoteHandleManager.getInstance().getSender().getDynamicselNum(str4);
                        }
                    });
                    return true;
                }
                if ("entryWriteMoodAsync".equals(str3)) {
                    entryWriteMoodAsync(str4);
                    return true;
                }
                if ("blogOpenQzoneImagePicker".equals(str3)) {
                    forwardToQzonePhotoPicker(str4);
                    return true;
                }
                if ("toBase64".equals(str3)) {
                    toBase64(str4);
                    return true;
                }
                if ("openImagePicker".equals(str3)) {
                    pickPhoto(str4);
                    return true;
                }
                if ("cancel".equals(str3)) {
                    this.parentPlugin.mRuntime.b().getHandler(QzoneDynamicAlbumPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.3
                        @Override // java.lang.Runnable
                        public void run() {
                            RemoteHandleManager.getInstance().getSender().cancelAllupload();
                        }
                    });
                    return true;
                }
                if ("requestPlayMusic".equals(str3)) {
                    requestPlayMusic(str4);
                    return true;
                }
                if ("startPlay".equals(str3)) {
                    play(true);
                    return true;
                }
                if ("endPlay".equals(str3)) {
                    play(false);
                    return true;
                }
                if ("setDynamicAlbumData".equals(str3)) {
                    setDynamicAlbumData(str4);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void initRuntime(WebViewPlugin webViewPlugin) {
        WebViewPlugin.b bVar;
        String str;
        super.initRuntime(webViewPlugin);
        if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || !(bVar.a() instanceof QQBrowserActivity)) {
            return;
        }
        if (webViewPlugin.mRuntime.f() != null) {
            str = webViewPlugin.mRuntime.f().getCurrentUrl();
        } else {
            str = "";
        }
        currentUrl = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (currentUrl.contains(DynamicURL) || currentUrl.contains("blog")) {
            if (dirdynamicalbum == null) {
                dirdynamicalbum = new File(PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM);
            }
            if (this.ispreSelloaded) {
                return;
            }
            this.ispreSelloaded = true;
            RemoteHandleManager.getInstance().addWebEventListener(this);
            webViewPlugin.mRuntime.b().getHandler(QzoneDynamicAlbumPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    QzoneDynamicAlbumPlugin.mSelectedImageSize = QzoneDynamicAlbumPlugin.getDynamicAlbumImageSize();
                    RemoteHandleManager.getInstance().getSender().getDynamicPhoto("0");
                    RemoteHandleManager.getInstance().getSender().getCloudPhotoDynamic("0");
                }
            });
        }
    }

    public void notifyVolumeChange(String str, int i3) {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService("audio");
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
        boolean z16 = audioManager.getRingerMode() == 0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("isMute", z16);
            jSONObject.put("maxVolume", streamMaxVolume);
            jSONObject.put("currentVolume", streamVolume);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        this.parentPlugin.dispatchJsEvent(MSG_VOLUME_CHANGE, jSONObject, jSONObject);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (intent == null) {
            QLog.d(TAG, 2, "onActivityResult error, intent is null");
            return;
        }
        if (QZoneMediaWrapper.isFromQCirclePicker(intent)) {
            QLog.d(TAG, 2, "onActivityResult form qcircle picker");
            this.toPickPhoto = false;
            pickDynamicAlbumImage(QZoneMediaWrapper.getImagePathsFromQCircle(intent));
        } else if (b16 != this.REQUEST_PICK_PHOTO) {
            if (b16 == 8) {
                sendBlogCLoudPhotoToH5(intent);
            }
        } else {
            this.toPickPhoto = false;
            if (i3 == -1) {
                pickDynamicAlbumImage(intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
            } else {
                sendPhotoData(null, 0);
            }
        }
    }

    public void onAudioSessionActive() {
        this.parentPlugin.dispatchJsEvent("com.tencent.qq.qzone.playInterruptBegin", new JSONObject(), new JSONObject());
    }

    public void onAudioSessionDeactive() {
        this.parentPlugin.dispatchJsEvent("com.tencent.qq.qzone.playWillBeInterruptEnd", new JSONObject(), new JSONObject());
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        RemoteHandleManager.getInstance().removeWebEventListener(this);
        RemoteHandleManager.getInstance().getSender().onDynamicPageDestroy();
        f.w(false, this.parentPlugin.mRuntime.a(), false);
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        QZLog.d("dynamic.Album", 4, "onWebEvent: event - " + str);
        if (bundle == null || !bundle.containsKey("data")) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("data");
        if (str.equals(RemoteHandleConst.CMD_GET_DYNAMIC_PHOTO)) {
            if (d.a()) {
                bundle2 = (Bundle) i.b().i("get_dynamic_photo_" + RFWApplication.getAccountId(), Bundle.class, new Bundle());
                bundle2.setClassLoader(getClass().getClassLoader());
                i.b().q("get_dynamic_photo_" + RFWApplication.getAccountId(), null);
            }
            this.isFromAlbum = bundle2.getBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_ALBUM, false);
            boolean z16 = bundle2.getBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_MAKE_BLOG, false);
            this.isFromAlbumSharePanel = bundle2.getBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_ALBUM_SHARE_PANEL, false);
            QZLog.d("dynamic.Album", 4, "onWebEvent - getBoolean - isFromAlbum:" + this.isFromAlbum + " isFromMakeBlog:" + z16);
            if (!this.isFromAlbum) {
                getDynamicAlbumImage(bundle2.getStringArrayList(RemoteHandleConst.PARAM_DYNAMIC_PHOTOLIST));
                return;
            } else if (z16) {
                getCloudDynamicAlbumImage(bundle2, false);
                return;
            } else {
                getCloudDynamicAlbumImage(bundle2, true);
                return;
            }
        }
        if (str.equals(RemoteHandleConst.CMD_GET_DYNAMIC_SELNUM)) {
            getSelectNum(bundle2);
        } else if (str.equals(RemoteHandleConst.CMD_GET_DYNAMIC_CLOUD_PHOTO)) {
            getCloudDynamicAlbumImage(bundle2, false);
        }
    }

    public void sendPhotoData(List<String> list, int i3) {
        try {
            if (TextUtils.isEmpty(this.mJSONArgs)) {
                return;
            }
            String optString = new JSONObject(this.mJSONArgs).optString("callback");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(new JSONObject(it.next()));
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("photoList", jSONArray);
                jSONObject.put("totalNumPreSelected", i3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 0);
                jSONObject2.put("msg", "success");
                jSONObject2.put("data", jSONObject);
                this.parentPlugin.callJs(optString, jSONObject2.toString());
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("code", -1);
            jSONObject3.put("msg", "fail");
            this.parentPlugin.callJs(optString, jSONObject3.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static String encodeBase64File(String str, int i3, int i16, boolean z16) {
        if (str.startsWith("/")) {
            try {
                str = "file:///" + Uri.encode(str.substring(1));
            } catch (Exception unused) {
                QLog.e(TAG, 1, "compressImage with some: URL encode failed");
            }
        }
        return compressImageToBase64(BaseApplication.getContext(), Uri.parse(str), i3, i16, z16);
    }

    public static int[] getDynamicAlbumImageSize() {
        int[] iArr = new int[2];
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_MIN_CPU, 1150);
        Long valueOf = Long.valueOf(ah.l());
        long config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_MIN_RAM, 700);
        long c16 = m.c() / 1048576;
        long config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_MIN_RUNTIME_RAM, 150);
        long X = ah.X() / 1048576;
        if (QLog.isColorLevel()) {
            QLog.i(QZLog.TO_DEVICE_TAG, 2, "DynamicQzoneDynamicAlbumPlugin freeSizeMB " + X);
        }
        if (valueOf.longValue() >= config && c16 >= config2 && X >= config3) {
            iArr[0] = 1600;
            iArr[1] = 1600;
            return iArr;
        }
        iArr[0] = 640;
        iArr[1] = 640;
        return iArr;
    }

    private void pickDynamicAlbumImage(final ArrayList<String> arrayList) {
        QLog.d(TAG, 4, "pickDynamicAlbumImage start!");
        final int size = arrayList != null ? arrayList.size() : 0;
        new ArrayList();
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (mSelectedImageSize == null) {
            mSelectedImageSize = getDynamicAlbumImageSize();
        }
        if (dirdynamicalbum == null) {
            dirdynamicalbum = new File(PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM);
        }
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (arrayList.get(i3) != null) {
                        String str = QzoneDynamicAlbumPlugin.PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM + (new Date().getTime() + i3);
                        String str2 = (String) arrayList.get(i3);
                        boolean compressDynamicAlbumImage = QzoneDynamicAlbumPlugin.compressDynamicAlbumImage(BaseApplication.getContext(), str2, str, QzoneDynamicAlbumPlugin.mSelectedImageSize[0], QzoneDynamicAlbumPlugin.mSelectedImageSize[1]);
                        if (compressDynamicAlbumImage && i3 == 0 && !QzoneDynamicAlbumPlugin.this.isFromAlbum) {
                            QLog.d(QzoneDynamicAlbumPlugin.TAG, 4, "pickDynamicAlbumImage uploadFirstDynamicPhoto:" + str);
                            RemoteHandleManager.getInstance().getSender().uploadFirstDynamicPhoto(str, arrayList.size());
                        } else {
                            QLog.d(QzoneDynamicAlbumPlugin.TAG, 4, "no launch uploadFirstDynamicPhoto;");
                        }
                        if (compressDynamicAlbumImage) {
                            QLog.d(QzoneDynamicAlbumPlugin.TAG, 2, "pickDynamicAlbumImage sendMsg: MSG_PICK_PHOTO_COMPRESS_FINISH");
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            obtain.arg1 = size;
                            obtain.obj = new String[]{str2, str};
                            QzoneDynamicAlbumPlugin.this.handler.sendMessage(obtain);
                        } else {
                            QLog.e(QzoneDynamicAlbumPlugin.TAG, 2, "compressDynamicAlbumImage failed! skip this photo.");
                        }
                    }
                }
            }
        }, 5, null, true);
    }

    private void pickPhoto(String str) {
        try {
            this.toPickPhoto = true;
            this.mJSONArgs = str;
            int optInt = new JSONObject(str).optInt("maxSelectNum");
            if (QZonePublishConfig.isUseQCirclePublish()) {
                QLog.d(TAG, 4, "goSelectPhoto from qcircle");
                QZoneMediaWrapper.PickConfig pickConfig = new QZoneMediaWrapper.PickConfig();
                pickConfig.maxNum = optInt;
                QZoneMediaWrapper.goSelectPhoto(pickConfig, QZoneMediaBusiness.QZONE_VIDEO_ALBUM, this.parentPlugin);
                return;
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.parentPlugin.mRuntime.a(), IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
            Bundle bundle = new Bundle();
            bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", optInt);
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
            bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", false);
            activityURIRequest.extra().putBoolean(PeakConstants.FROM_DYNAMIC_ALBUM, true);
            activityURIRequest.extra().putBoolean(PeakConstants.IS_NO_PANORAMA, true);
            activityURIRequest.extra().putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
            bundle.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
            bundle.putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
            bundle.putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
            bundle.putInt("uintype", 0);
            bundle.putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationH5.F);
            activityURIRequest.extra().putAll(bundle);
            QZoneHelper.addSource(activityURIRequest);
            WebViewProvider f16 = this.parentPlugin.mRuntime.f();
            if (f16 != null) {
                ao.d(this.parentPlugin, activityURIRequest, this.REQUEST_PICK_PHOTO, f16);
            } else {
                ((AbsBaseWebViewActivity) this.parentPlugin.mRuntime.a()).gotoSelectPicture(this.parentPlugin, activityURIRequest, this.REQUEST_PICK_PHOTO);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static boolean IsSupportImgType(String str) {
        return str != null && (str.equalsIgnoreCase("image/jpeg") || str.equalsIgnoreCase("image/png") || str.equalsIgnoreCase("image/gif"));
    }

    private void entryWriteMoodAsync(String str) {
        ArrayList<? extends Parcelable> arrayList;
        String str2;
        String str3;
        String str4;
        JSONArray jSONArray;
        JSONObject jSONObject;
        String str5;
        Bundle bundle;
        QZoneHelper.UserInfo userInfo;
        String str6;
        JSONObject jSONObject2;
        String str7;
        String str8;
        JSONArray jSONArray2;
        String str9;
        DynamicPhotoData dynamicPhotoData;
        String str10 = "https://www.dynamicalbumlocalimage.com";
        String str11 = QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE;
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            JSONArray optJSONArray = jSONObject3.optJSONArray("photoList");
            JSONObject optJSONObject = jSONObject3.optJSONObject("data");
            String string = jSONObject3.getString("callback");
            JSONObject jSONObject4 = new JSONObject();
            arrayList = new ArrayList<>();
            String str12 = "photoUrl";
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                str2 = "https://www.dynamicalbumlocalimage.com";
                str3 = QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE;
                str4 = string;
            } else {
                DynamicPhotoData dynamicPhotoData2 = null;
                str4 = string;
                int i3 = 0;
                while (i3 < optJSONArray.length()) {
                    JSONObject jSONObject5 = optJSONArray.getJSONObject(i3);
                    JSONObject jSONObject6 = jSONObject4;
                    String string2 = jSONObject5.getString(str12);
                    if (string2 != null) {
                        str7 = str10;
                        String string3 = jSONObject5.getString("albumId");
                        String string4 = jSONObject5.getString("photoId");
                        jSONArray2 = optJSONArray;
                        str9 = str12;
                        int i16 = -1;
                        for (int i17 = 0; i17 < this.mSelectedCloudImageInfos.size(); i17++) {
                            if (this.mSelectedCloudImageInfos.get(i17).mBigUrl.equals(string2)) {
                                i16 = i17;
                            }
                        }
                        str8 = str11;
                        if (this.isFromAlbum && i16 != -1) {
                            dynamicPhotoData = new DynamicPhotoData(string2, jSONObject5.getString("title"), jSONObject5.getString("desc"), this.mSelectedCloudImageInfos.get(i16).mAlbumId, this.mSelectedCloudImageInfos.get(i16).mlloc);
                        } else if (string3 != null && string4 != null) {
                            dynamicPhotoData = new DynamicPhotoData(string2, jSONObject5.getString("title"), jSONObject5.getString("desc"), string3, string4);
                        } else {
                            dynamicPhotoData = new DynamicPhotoData(string2, jSONObject5.getString("title"), jSONObject5.getString("desc"));
                        }
                    } else {
                        str7 = str10;
                        str8 = str11;
                        jSONArray2 = optJSONArray;
                        str9 = str12;
                        dynamicPhotoData = dynamicPhotoData2;
                    }
                    if (dynamicPhotoData != null) {
                        arrayList.add(dynamicPhotoData);
                    }
                    i3++;
                    dynamicPhotoData2 = dynamicPhotoData;
                    jSONObject4 = jSONObject6;
                    str10 = str7;
                    str12 = str9;
                    optJSONArray = jSONArray2;
                    str11 = str8;
                }
                str2 = str10;
                str3 = str11;
            }
            jSONArray = optJSONArray;
            jSONObject = jSONObject4;
            str5 = str12;
            String string5 = optJSONObject.getString(QZoneJsConstants.DYNAMIC_ALBUM_NAME);
            String string6 = optJSONObject.getString(QZoneJsConstants.DYNAMIC_ALBUM_DESC);
            String string7 = optJSONObject.getString(QZoneJsConstants.DYNAMIC_ALBUM_TEMPLT_ID);
            String string8 = optJSONObject.getString("music_id");
            String string9 = optJSONObject.getString(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID);
            String string10 = optJSONObject.getString(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START);
            String str13 = str3;
            try {
                String string11 = optJSONObject.getString(str13);
                int i18 = optJSONObject.getInt("isDraft");
                bundle = new Bundle();
                bundle.putParcelableArrayList(QZoneJsConstants.DYNAMIC_ALBUM_PHOTOLIST, arrayList);
                bundle.putString(QZoneJsConstants.DYNAMIC_ALBUM_NAME, string5);
                bundle.putString(QZoneJsConstants.DYNAMIC_ALBUM_DESC, string6);
                bundle.putString(QZoneJsConstants.DYNAMIC_ALBUM_TEMPLT_ID, string7);
                bundle.putString("music_id", string8);
                bundle.putString(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID, string9);
                bundle.putString(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START, string10);
                bundle.putString(str13, string11);
                bundle.putBoolean(QZoneJsConstants.EDIT_IMAGE, false);
                bundle.putBoolean(QZoneJsConstants.APPEND_IMAGE, false);
                bundle.putBoolean(QZoneJsConstants.SHOW_RECENT_IMAGE, false);
                bundle.putString("shareSource", HardCodeUtil.qqStr(R.string.f172540rs4));
                if (i18 == 1) {
                    bundle.putBoolean(QZoneJsConstants.DYNAMIC_ALBUM_IS_FROM_DRAFT, true);
                } else {
                    bundle.putBoolean(QZoneJsConstants.DYNAMIC_ALBUM_IS_FROM_DRAFT, false);
                }
                userInfo = QZoneHelper.UserInfo.getInstance();
            } catch (JSONException e16) {
                e = e16;
            }
        } catch (JSONException e17) {
            e = e17;
        }
        try {
            userInfo.qzone_uin = this.parentPlugin.mRuntime.b().getAccount();
            if (jSONArray == null || jSONArray.length() <= 0) {
                str6 = "";
            } else {
                str6 = jSONArray.getJSONObject(0).getString(str5);
            }
            if (arrayList.size() > 0 && !TextUtils.isEmpty(str6)) {
                String str14 = str2;
                QZoneHelper.forwardToPublishMood(this.parentPlugin.mRuntime.a(), bundle, userInfo, str6.startsWith(str14) ? str6.replace(str14, "") : str6, HardCodeUtil.qqStr(R.string.f172539rs3), null, this.REQUEST_PUBLISH_MOOD);
                QLog.d(TAG, 4, "entryWriteMoodAsync SUCCESS!");
                jSONObject2 = jSONObject;
                jSONObject2.put("code", 0);
                jSONObject2.put("msg", "success");
            } else {
                jSONObject2 = jSONObject;
                QLog.d(TAG, 4, "entryWriteMoodAsync FAILE");
                jSONObject2.put("code", -1);
                jSONObject2.put("msg", "fail");
            }
            this.parentPlugin.callJs(str4, jSONObject2.toString());
        } catch (JSONException e18) {
            e = e18;
            e.printStackTrace();
        }
    }

    private void getBlogCloudPhoto(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString("callback");
            List<QzonePhotoInfo> list = this.mSelectedCloudImageInfos;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int size = this.mSelectedCloudImageInfos.size();
                int i3 = 0;
                while (i3 < size) {
                    JSONObject jSONObject = new JSONObject();
                    QzonePhotoInfo qzonePhotoInfo = this.mSelectedCloudImageInfos.get(i3);
                    String str2 = qzonePhotoInfo.mAlbumId;
                    String str3 = qzonePhotoInfo.mlloc;
                    String str4 = qzonePhotoInfo.mBigUrl;
                    Integer valueOf = Integer.valueOf(qzonePhotoInfo.mBigHeight);
                    Integer valueOf2 = Integer.valueOf(qzonePhotoInfo.mBigWidth);
                    Long valueOf3 = Long.valueOf(qzonePhotoInfo.mShootTime);
                    int i16 = size;
                    Long valueOf4 = Long.valueOf(qzonePhotoInfo.mUploadTime);
                    jSONObject.put("albumid", str2);
                    jSONObject.put("lloc", str3);
                    jSONObject.put("url", str4);
                    jSONObject.put("height", valueOf);
                    jSONObject.put("width", valueOf2);
                    jSONObject.put(PhotoCacheData.SHOOTTIME, valueOf3);
                    jSONObject.put("uploadtime", valueOf4);
                    Map<Integer, String> map = qzonePhotoInfo.mShouzhang_extend_map;
                    if (map != null) {
                        JSONStringer object = new JSONStringer().object();
                        for (Map.Entry<Integer, String> entry : map.entrySet()) {
                            object.key(String.valueOf(entry.getKey())).value(entry.getValue());
                        }
                        jSONObject.put("shouzhang_extend_map", object.endObject());
                    }
                    jSONArray.mo162put(jSONObject);
                    i3++;
                    size = i16;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("photoList", jSONArray);
                jSONObject2.put("sorttype", this.mSortType);
                jSONObject2.put("albumtype", this.mJumpToAlbumTheme);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("data", jSONObject2);
                QZLog.d(TAG, 2, "json:" + jSONObject3.toString());
                this.parentPlugin.callJs(optString, jSONObject3.toString());
                return;
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("code", -1);
            jSONObject4.put("msg", "fail");
            this.parentPlugin.callJs(optString, jSONObject4.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void getDynamicAlbumImage(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(QZLog.TO_DEVICE_TAG, 2, "DynamicQzoneDynamicAlbumPlugin getDynamicAlbumImage " + list.size() + " " + list.get(0));
        }
        if (mSelectedImageSize == null) {
            return;
        }
        final String[] strArr = new String[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) != null) {
                String str = list.get(i3);
                int imageDegree = getImageDegree(str);
                Size bitmapSize = getBitmapSize(str);
                float[] appendGPSInfo = appendGPSInfo(str);
                double ratio = getRatio(bitmapSize);
                if ((imageDegree == 90 || imageDegree == 270) && bitmapSize != null) {
                    int i16 = bitmapSize.width;
                    bitmapSize.width = bitmapSize.height;
                    bitmapSize.height = i16;
                }
                JSONObject jSONObject = new JSONObject();
                strArr[i3] = PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM + (new Date().getTime() + i3);
                try {
                    jSONObject.put("url", "https://www.dynamicalbumlocalimage.com" + strArr[i3]);
                    if (bitmapSize != null) {
                        if (ratio > 0.0d) {
                            jSONObject.put("width", (int) (bitmapSize.width / ratio));
                            jSONObject.put("height", (int) (bitmapSize.height / ratio));
                        } else {
                            jSONObject.put("width", bitmapSize.width);
                            jSONObject.put("height", bitmapSize.height);
                        }
                    }
                    if (appendGPSInfo != null) {
                        jSONObject.put("poiX", appendGPSInfo[1]);
                        jSONObject.put("poiY", appendGPSInfo[0]);
                        jSONObject.put("poiName", "");
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                this.mSelectedImageInfos.add(jSONObject.toString());
            }
        }
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                for (int i17 = 0; i17 < list.size(); i17++) {
                    if (list.get(i17) != null) {
                        boolean compressDynamicAlbumImage = QzoneDynamicAlbumPlugin.compressDynamicAlbumImage(BaseApplication.getContext(), (String) list.get(i17), strArr[i17], QzoneDynamicAlbumPlugin.mSelectedImageSize[0], QzoneDynamicAlbumPlugin.mSelectedImageSize[1]);
                        if (compressDynamicAlbumImage && i17 == 0 && !QzoneDynamicAlbumPlugin.this.isFromAlbum) {
                            QLog.d(QzoneDynamicAlbumPlugin.TAG, 1, "pickDynamicAlbumImage uploadFirstDynamicPhoto:" + strArr[0]);
                            RemoteHandleManager.getInstance().getSender().uploadFirstDynamicPhoto(strArr[0], list.size());
                        } else {
                            QLog.d(QzoneDynamicAlbumPlugin.TAG, 4, "no launch uploadFirstDynamicPhoto;");
                        }
                        if (!compressDynamicAlbumImage) {
                            QLog.e(QZLog.TO_DEVICE_TAG, 2, "DynamicQzoneDynamicAlbumPlugin compress failed! ");
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QZLog.TO_DEVICE_TAG, 2, "DynamicQzoneDynamicAlbumPlugin compress all done  ");
                }
            }
        }, 5, null, true);
    }

    public static Bitmap rotate(Bitmap bitmap, int i3) {
        if (bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    private void play(boolean z16) {
        if (z16) {
            f.w(true, this.parentPlugin.mRuntime.a(), false);
        } else {
            f.w(false, this.parentPlugin.mRuntime.a(), false);
            ((AudioManager) BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (j3 == 8 && str.startsWith("https://www.dynamicalbumlocalimage.com")) {
            if (QLog.isColorLevel()) {
                QLog.i(QZLog.TO_DEVICE_TAG, 2, "DynamicQzoneDynamicAlbumPlugin getImageResponse " + str);
            }
            return getImageResponse(str);
        }
        return super.handleEvent(str, j3);
    }
}
