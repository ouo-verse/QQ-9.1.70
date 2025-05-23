package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Build;
import android.text.TextUtils;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.Permissions;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import common.config.service.QzoneConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class ImageJsPlugin extends BaseJsPlugin {
    public static final String ACTION_CHOOSE_IMAGE = "micro_api_choose_image";
    public static final String API_CHOOSE_IMAGE = "chooseImage";
    public static final String API_COMPRESS_IMAGE = "compressImage";
    public static final String API_GET_IMAGE_INFO = "getImageInfo";
    public static final String API_PREVIEW_IMAGE = "previewImage";
    public static final String API_SAVE_IMAGE_TO_ALBUM = "saveImageToPhotosAlbum";
    private static final String TAG = "ImageJsPlugin";
    private static final boolean USE_NATIVE_CAMERA_FLAG = true;
    private RequestEvent mCurRequestEvent;
    private boolean mNeedCompress = false;
    private boolean mHasChoosePhoto = false;
    private MiniAppProxy mMiniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.tencent.qqmini.sdk.plugins.ImageJsPlugin.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            QMLog.d(ImageJsPlugin.TAG, String.format("receiver.onReceive action=%s", action));
            if (ImageJsPlugin.ACTION_CHOOSE_IMAGE.equals(action)) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                if (ImageJsPlugin.this.mCurRequestEvent != null && ImageJsPlugin.this.mCurRequestEvent.callbackId > 0) {
                    ImageJsPlugin imageJsPlugin = ImageJsPlugin.this;
                    imageJsPlugin.callbackChooseImage(stringArrayListExtra, imageJsPlugin.mCurRequestEvent);
                }
            }
        }
    };

    /* renamed from: com.tencent.qqmini.sdk.plugins.ImageJsPlugin$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int val$count;
        final /* synthetic */ RequestEvent val$req;

        AnonymousClass2(RequestEvent requestEvent, int i3) {
            this.val$req = requestEvent;
            this.val$count = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            MiniCustomDialog createCustomDialog = DialogUtil.createCustomDialog(((BaseJsPlugin) ImageJsPlugin.this).mMiniAppContext.getAttachActivity(), 230, "\u56fe\u7247\u9009\u62e9", "\u8bf7\u9009\u62e9\u83b7\u53d6\u56fe\u7247\u65b9\u5f0f", QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE, "\u62cd\u7167", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.ImageJsPlugin.2.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    ImageJsPlugin.this.openCamera(anonymousClass2.val$req);
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.ImageJsPlugin.2.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    if (!ImageJsPlugin.this.mMiniAppProxy.openChoosePhotoActivity(((BaseJsPlugin) ImageJsPlugin.this).mMiniAppContext.getAttachActivity(), AnonymousClass2.this.val$count, new MiniAppProxy.IChoosePhotoListner() { // from class: com.tencent.qqmini.sdk.plugins.ImageJsPlugin.2.2.1
                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IChoosePhotoListner
                        public void onResult(ArrayList<String> arrayList) {
                            QMLog.i(ImageJsPlugin.TAG, "openChoosePhotoActivity, path=" + arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            ImageJsPlugin.this.callbackChooseImage(arrayList, anonymousClass2.val$req);
                        }
                    })) {
                        MiniToast.makeText(((BaseJsPlugin) ImageJsPlugin.this).mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(((BaseJsPlugin) ImageJsPlugin.this).mContext) + "\u4e2d\u9009\u62e9\u56fe\u7247", 1);
                        AnonymousClass2.this.val$req.fail();
                    }
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            });
            createCustomDialog.setCanceledOnTouchOutside(false);
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackChooseImage(ArrayList<String> arrayList, RequestEvent requestEvent) {
        if (this.mHasChoosePhoto) {
            return;
        }
        if (this.mNeedCompress) {
            callbackJsChooseImage(compressImages(arrayList), requestEvent);
        } else {
            callbackJsChooseImage(copyImages(arrayList), requestEvent);
        }
    }

    private void callbackGetImageInfo(String str, RequestEvent requestEvent) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", options.outWidth);
            jSONObject.put("height", options.outHeight);
            jSONObject.put("path", ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(str));
            jSONObject.put("type", ImageUtil.getType(options));
            jSONObject.put("orientation", getExifOrientation(str));
            requestEvent.ok(jSONObject);
        } catch (Exception e16) {
            e16.printStackTrace();
            QMLog.e(TAG, "getimageinfo error,", e16);
            requestEvent.fail();
        }
    }

    private void callbackJsChooseImage(ArrayList<String> arrayList, RequestEvent requestEvent) {
        try {
            this.mHasChoosePhoto = true;
            if (arrayList != null && arrayList.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        String wxFilePath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(next);
                        jSONArray.mo162put(wxFilePath);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("path", wxFilePath);
                        jSONObject.put("size", new File(next).length());
                        jSONArray2.mo162put(jSONObject);
                    }
                }
                QMLog.d(TAG, "chooseImage photoArray=" + jSONArray.toString() + ",fileArray=" + jSONArray2.toString());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("tempFilePaths", jSONArray);
                jSONObject2.put("tempFiles", jSONArray2);
                requestEvent.ok(jSONObject2);
                return;
            }
            requestEvent.fail("cancel");
        } catch (Exception e16) {
            this.mHasChoosePhoto = false;
            QMLog.e(TAG, e16.getMessage(), e16);
            requestEvent.fail();
        }
    }

    private ArrayList<String> compressImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(compressSingleImg(it.next()));
            }
            return arrayList2;
        }
        return arrayList;
    }

    private String compressSingleImg(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        File file = new File(str);
        String tmpPath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("jpg");
        File file2 = new File(tmpPath);
        FileOutputStream fileOutputStream = null;
        try {
            QMLog.d(TAG, "compressSingleImg, before compress, image file size is " + file.length());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                int exifOrientation = ImageUtil.getExifOrientation(str);
                QMLog.d(TAG, "compressSingleImg, before compress, degree is : " + exifOrientation);
                if (exifOrientation != 0) {
                    Bitmap rotaingImageView = ImageUtil.rotaingImageView(exifOrientation, decodeFile);
                    decodeFile.recycle();
                    decodeFile = rotaingImageView;
                }
                if (decodeFile != null) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        decodeFile.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream2);
                        fileOutputStream2.flush();
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        try {
                            QMLog.e(TAG, th.getMessage(), th);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            return str;
                        } catch (Throwable th6) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th6;
                        }
                    }
                }
            }
            QMLog.d(TAG, "compressSingleImg, after compress, image file size is " + file2.length());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
            }
            return tmpPath;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private ArrayList<String> copyImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String copyTmpFile = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).copyTmpFile(next);
                if (!TextUtils.isEmpty(copyTmpFile)) {
                    next = copyTmpFile;
                }
                arrayList2.add(next);
            }
            return arrayList2;
        }
        return arrayList;
    }

    private File createImageFile(Context context) {
        return new File(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
    }

    private void doCompressImage(String str, int i3, RequestEvent requestEvent) {
        try {
            int exifOrientation = ImageUtil.getExifOrientation(str);
            Bitmap localBitmap = ImageUtil.getLocalBitmap(str);
            if (localBitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                localBitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
                if (exifOrientation != 0 && decodeStream != null) {
                    Bitmap rotaingImageView = ImageUtil.rotaingImageView(exifOrientation, decodeStream);
                    decodeStream.recycle();
                    decodeStream = rotaingImageView;
                }
                String tmpPath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str.hashCode() + ".jpg");
                ImageUtil.saveBitmapToFile(decodeStream, new File(tmpPath));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tempFilePath", ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(tmpPath));
                requestEvent.ok(jSONObject);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "compressImage error,", e16);
            requestEvent.fail();
        }
    }

    private String getExifOrientation(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e16) {
            QMLog.e(TAG, "getExifOrientation error." + e16);
            exifInterface = null;
        }
        if (exifInterface != null) {
            switch (exifInterface.getAttributeInt("Orientation", -1)) {
                case 1:
                default:
                    return "up";
                case 2:
                    return "up-mirrored";
                case 3:
                    return "down";
                case 4:
                    return "down-mirrored";
                case 5:
                    return "left-mirrored";
                case 6:
                    return "right";
                case 7:
                    return "right-mirrored";
                case 8:
                    return "left";
            }
        }
        return "up";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamera(final RequestEvent requestEvent) {
        final File createImageFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.mMiniAppContext.getAttachActivity().getPackageManager()) == null || (createImageFile = createImageFile(this.mMiniAppContext.getAttachActivity())) == null) {
            return;
        }
        intent.putExtra("output", FileUtils.getUriForFile(this.mMiniAppContext.getAttachActivity(), createImageFile));
        this.mMiniAppContext.getAttachActivity().startActivityForResult(intent, 4);
        ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.sdk.plugins.ImageJsPlugin.4
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent2) {
                if (i3 != 4) {
                    return false;
                }
                if (i16 != -1) {
                    if (i16 == 0) {
                        requestEvent.cancel();
                    }
                    createImageFile.deleteOnExit();
                    ActivityResultManager.g().removeActivityResultListener(this);
                    return true;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(createImageFile.getAbsolutePath());
                ImageJsPlugin.this.callbackChooseImage(arrayList, requestEvent);
                ActivityResultManager.g().removeActivityResultListener(this);
                return true;
            }
        });
    }

    @JsEvent({"chooseImage"})
    public void chooseImage(final RequestEvent requestEvent) {
        try {
            this.mHasChoosePhoto = false;
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int i3 = 9;
            int optInt = jSONObject.optInt("count", 9);
            JSONArray optJSONArray = jSONObject.optJSONArray("sizeType");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sourceType");
            if (optInt <= 9) {
                i3 = optInt;
            }
            if (i3 < 1) {
                i3 = 1;
            }
            if (optJSONArray != null) {
                String optString = optJSONArray.optString(0);
                if (!TextUtils.isEmpty(optString) && "compressed".equals(optString)) {
                    this.mNeedCompress = true;
                }
            }
            if (optJSONArray2.length() == 2) {
                AppBrandTask.runTaskOnUiThread(new AnonymousClass2(requestEvent, i3));
                return;
            }
            if ("camera".equals(optJSONArray2.optString(0))) {
                openCamera(requestEvent);
                return;
            }
            if (!this.mMiniAppProxy.openChoosePhotoActivity(this.mMiniAppContext.getAttachActivity(), i3, new MiniAppProxy.IChoosePhotoListner() { // from class: com.tencent.qqmini.sdk.plugins.ImageJsPlugin.3
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IChoosePhotoListner
                public void onResult(ArrayList<String> arrayList) {
                    QMLog.i(ImageJsPlugin.TAG, "openChoosePhotoActivity, path=" + arrayList);
                    ImageJsPlugin.this.callbackChooseImage(arrayList, requestEvent);
                }
            })) {
                MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u9009\u62e9\u56fe\u7247", 1);
                requestEvent.fail();
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " error,", th5);
            requestEvent.fail();
        }
    }

    @JsEvent({"compressImage"})
    public void compressImage(RequestEvent requestEvent) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("src");
            int optInt = jSONObject.optInt(CustomImageProps.QUALITY);
            int optInt2 = jSONObject.optInt("destWidth");
            int optInt3 = jSONObject.optInt("destHeight");
            QMLog.i(TAG, "starting compress image, src:" + optString);
            if (!TextUtils.isEmpty(optString)) {
                str = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
            } else {
                str = null;
            }
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                if (optInt3 <= 0 && optInt2 <= 0) {
                    doCompressImage(str2, optInt, requestEvent);
                    return;
                }
                if ((optInt3 > 0 && optInt2 <= 0) || (optInt3 <= 0 && optInt2 > 0)) {
                    requestEvent.fail("destSize invalid(" + optInt2 + "," + optInt3 + ")");
                    return;
                }
                doCompressImage(str2, optInt, optInt2, optInt3, requestEvent);
                return;
            }
            QMLog.e(TAG, requestEvent.event + " realUrl is null: src" + optString);
            requestEvent.fail();
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"getImageInfo"})
    public void getImageInfo(RequestEvent requestEvent) {
        String str;
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("src", "");
            if (!TextUtils.isEmpty(optString)) {
                str = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                callbackGetImageInfo(str, requestEvent);
                return;
            }
            QMLog.e(TAG, "getImageInfo: src " + optString + " can't find absolute path.");
            requestEvent.fail("image path error.");
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
            requestEvent.fail();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CHOOSE_IMAGE);
        this.mMiniAppContext.getContext().registerReceiver(this.receiver, intentFilter);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        if (this.receiver != null) {
            this.mMiniAppContext.getContext().unregisterReceiver(this.receiver);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        this.mCurRequestEvent = requestEvent;
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({"previewImage"})
    public void previewImage(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("current", "");
            JSONArray optJSONArray = jSONObject.optJSONArray(CoverDBCacheData.URLS);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                String optString2 = optJSONArray.optString(i16);
                if (optString2.equals(optString)) {
                    i3 = i16;
                }
                String absolutePath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString2);
                arrayList.add(absolutePath);
                QMLog.d(TAG, "previewImage wxFilePath=" + optString2 + ",localFilePath=" + absolutePath);
            }
            if (!this.mMiniAppProxy.openImagePreview(this.mMiniAppContext.getAttachActivity(), i3, arrayList)) {
                MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u9884\u89c8\u56fe\u7247", 1);
                requestEvent.fail();
                return;
            }
            requestEvent.ok();
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error,", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({"saveImageToPhotosAlbum"})
    public void saveImageToPhotosAlbum(RequestEvent requestEvent) {
        String str = "";
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("filePath", "");
            if (!TextUtils.isEmpty(optString)) {
                String absolutePath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                File file = new File(absolutePath);
                if (!ImageUtil.isJpgFile(absolutePath) && !ImageUtil.isPngFile(absolutePath) && !ImageUtil.isWebpFile(absolutePath)) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(absolutePath, options);
                    String type = ImageUtil.getType(options);
                    if (!TextUtils.isEmpty(type) && !type.equals("unknown")) {
                        str = "." + type;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    String name = file.getName();
                    str = name.substring(name.lastIndexOf("."));
                }
                String str2 = UUID.randomUUID() + str;
                IPermissionManagerProxy iPermissionManagerProxy = (IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class);
                Activity attachActivity = this.mMiniAppContext.getAttachActivity();
                if (Build.VERSION.SDK_INT < 29) {
                    Permissions permissions = Permissions.WRITE_EXTERNAL_STORAGE;
                    if (!iPermissionManagerProxy.isPermissionGranted(attachActivity, permissions)) {
                        iPermissionManagerProxy.requestForPermission(attachActivity, permissions, new a(file, str2, requestEvent));
                        return;
                    }
                }
                if (FileUtils.saveToSharedStorageCompat(this.mContext, file, str2, FileUtils.MediaType.PICTURE)) {
                    requestEvent.ok();
                    return;
                } else {
                    requestEvent.fail("save failed.");
                    return;
                }
            }
            requestEvent.fail("save failed.");
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error", e16);
            requestEvent.fail();
        }
    }

    private void doCompressImage(String str, int i3, int i16, int i17, RequestEvent requestEvent) {
        try {
            int exifOrientation = ImageUtil.getExifOrientation(str);
            Bitmap localBitmapwithHW = ImageUtil.getLocalBitmapwithHW(str, i16, i17);
            if (localBitmapwithHW != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                localBitmapwithHW.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
                if (exifOrientation != 0 && decodeStream != null) {
                    Bitmap rotaingImageView = ImageUtil.rotaingImageView(exifOrientation, decodeStream);
                    decodeStream.recycle();
                    decodeStream = rotaingImageView;
                }
                String tmpPath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str.hashCode() + ".jpg");
                File file = new File(tmpPath);
                if (decodeStream == null) {
                    QMLog.e(TAG, "created bitmap from decoding stream fail: bitmap is null.");
                    requestEvent.fail("compression failed: null bitmap object from stream.");
                    return;
                }
                if (file.exists()) {
                    QMLog.e(TAG, "temp file writing to has existed.");
                    requestEvent.fail("compression failed: temp file is exist before saving.");
                    return;
                }
                ImageUtil.saveBitmapToFile(decodeStream, file);
                if (!file.exists()) {
                    QMLog.e(TAG, "temp file doesn't exist after compressing.");
                    requestEvent.fail("compression failed: temp file doesn't exist after compressing.");
                    return;
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tempFilePath", ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(tmpPath));
                    requestEvent.ok(jSONObject);
                    return;
                }
            }
            QMLog.e(TAG, "getLocalBitmap fail or destSize invalid(" + i16 + "," + i17 + ")");
            requestEvent.fail("fail to get Local picture or destSize invalid(" + i16 + "," + i17 + ")");
        } catch (Exception e16) {
            QMLog.e(TAG, "compressImage error,", e16);
            requestEvent.fail();
        }
    }

    /* loaded from: classes23.dex */
    class a implements RequestPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f348196a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f348197b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348198c;

        a(File file, String str, RequestEvent requestEvent) {
            this.f348196a = file;
            this.f348197b = str;
            this.f348198c = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onFail() {
            this.f348198c.fail("write permission denied.");
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onSuccess() {
            if (FileUtils.saveToSharedStorageCompat(((BaseJsPlugin) ImageJsPlugin.this).mContext, this.f348196a, this.f348197b, FileUtils.MediaType.PICTURE)) {
                this.f348198c.ok();
            } else {
                this.f348198c.fail("save failed.");
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onPartialGrant() {
        }
    }
}
