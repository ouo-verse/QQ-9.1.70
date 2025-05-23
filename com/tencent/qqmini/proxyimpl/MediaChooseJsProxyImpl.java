package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationMiniApp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.video.QzoneVerticalVideoConst;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@ProxyService(proxy = MediaChooseJsProxy.class)
/* loaded from: classes34.dex */
public class MediaChooseJsProxyImpl extends MediaChooseJsProxy {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f347378a;

    /* renamed from: b, reason: collision with root package name */
    private IMiniAppContext f347379b;

    /* renamed from: c, reason: collision with root package name */
    private int f347380c = -1;

    /* renamed from: d, reason: collision with root package name */
    private long f347381d = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_CHOOSE_VIDEO_MAX_DURATION, 600000L);

    /* renamed from: e, reason: collision with root package name */
    private long f347382e = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_CHOOSE_VIDEO_MAX_SIZE, 1610612736L);

    /* renamed from: f, reason: collision with root package name */
    private boolean f347383f = false;

    /* renamed from: g, reason: collision with root package name */
    private BroadcastReceiver f347384g = new BroadcastReceiver() { // from class: com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (MediaChooseJsProxyImpl.this.f347383f) {
                MediaChooseJsProxyImpl.this.f347383f = false;
                String action = intent.getAction();
                QLog.d("MediaChooseJsProxyImpl", 2, "mAvatarReceiver.onReceive action=" + action);
                if ("get_media_info".equals(action)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MediaChooseJsProxyImpl", 2, intent);
                    }
                    ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Iterator<String> it;
                            try {
                                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                                HashMap hashMap = (intent.getExtras() == null || !intent.getExtras().containsKey(PeakConstants.VIDEO_INFO)) ? null : (HashMap) intent.getExtras().get(PeakConstants.VIDEO_INFO);
                                if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                                    MediaChooseJsProxyImpl.this.C("\u6b63\u5728\u83b7\u53d6\u5a92\u4f53\u4fe1\u606f");
                                    int i3 = 0;
                                    int intExtra = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
                                    int intExtra2 = intent.getIntExtra("from_miniapp_cur_sizetype", 0);
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator<String> it5 = stringArrayListExtra.iterator();
                                    while (it5.hasNext()) {
                                        String next = it5.next();
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("tempFilePath", ((IMiniAppFileManager) MediaChooseJsProxyImpl.this.f347379b.getManager(IMiniAppFileManager.class)).getWxFilePath(next));
                                        jSONObject.put("size", new File(next).length());
                                        if (hashMap != null && hashMap.containsKey(Integer.valueOf(i3))) {
                                            jSONObject.put("type", "video");
                                            LocalMediaInfo localMediaInfo = (LocalMediaInfo) hashMap.get(Integer.valueOf(i3));
                                            it = it5;
                                            jSONObject.put("duration", localMediaInfo.mDuration);
                                            jSONObject.put("width", localMediaInfo.mediaWidth);
                                            jSONObject.put("height", localMediaInfo.mediaHeight);
                                            MediaChooseJsProxyImpl mediaChooseJsProxyImpl = MediaChooseJsProxyImpl.this;
                                            mediaChooseJsProxyImpl.B(mediaChooseJsProxyImpl.s(next), localMediaInfo);
                                            jSONObject.put("thumbTempFilePath", localMediaInfo.thumbnailPath);
                                        } else {
                                            it = it5;
                                            jSONObject.put("type", "image");
                                            if ((intExtra2 == 0 && intExtra == 0) || intExtra2 == 2) {
                                                String p16 = MediaChooseJsProxyImpl.this.p(next);
                                                jSONObject.put("tempFilePath", ((IMiniAppFileManager) MediaChooseJsProxyImpl.this.f347379b.getManager(IMiniAppFileManager.class)).getWxFilePath(p16));
                                                jSONObject.put("size", new File(p16).length());
                                            }
                                        }
                                        jSONArray.mo162put(jSONObject);
                                        i3++;
                                        it5 = it;
                                    }
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("tempFiles", jSONArray);
                                    MediaChooseJsProxyImpl mediaChooseJsProxyImpl2 = MediaChooseJsProxyImpl.this;
                                    mediaChooseJsProxyImpl2.x(mediaChooseJsProxyImpl2.f347380c, "chooseMedia", jSONObject2);
                                    MediaChooseJsProxyImpl.this.y();
                                    return;
                                }
                                MediaChooseJsProxyImpl mediaChooseJsProxyImpl3 = MediaChooseJsProxyImpl.this;
                                mediaChooseJsProxyImpl3.v(mediaChooseJsProxyImpl3.f347380c, "chooseMedia", null);
                            } catch (Exception e16) {
                                QLog.e("MediaChooseJsProxyImpl", 1, "get media info failed", e16);
                                MediaChooseJsProxyImpl mediaChooseJsProxyImpl4 = MediaChooseJsProxyImpl.this;
                                mediaChooseJsProxyImpl4.w(mediaChooseJsProxyImpl4.f347380c, "chooseMedia", null, "chooseMedia exception:" + e16.getMessage());
                                MediaChooseJsProxyImpl.this.y();
                            }
                        }
                    });
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Activity activity) {
        WeakReference<Activity> weakReference = this.f347378a;
        if (weakReference == null) {
            z(activity);
            return;
        }
        Activity activity2 = weakReference.get();
        if (activity2 == null || activity2 == activity) {
            return;
        }
        z(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str) {
        QLog.i("MediaChooseJsProxyImpl", 1, "showLoading " + str);
        MediaChooseJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.showLoading(str);
        }
    }

    private void D() {
        if (QLog.isColorLevel()) {
            QLog.d("MediaChooseJsProxyImpl", 2, "unregisterAvatarReceiver");
        }
        try {
            WeakReference<Activity> weakReference = this.f347378a;
            if (weakReference != null) {
                weakReference.get().unregisterReceiver(this.f347384g);
            }
        } catch (Throwable th5) {
            QLog.e("MediaChooseJsProxyImpl", 1, "unregisterReceiver exception.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        File file = new File(str);
        String tmpPath = ((IMiniAppFileManager) this.f347379b.getManager(IMiniAppFileManager.class)).getTmpPath("jpg");
        File file2 = new File(tmpPath);
        FileOutputStream fileOutputStream = null;
        try {
            QLog.d("MediaChooseJsProxyImpl", 1, "compressSingleImg, before compress, image file size is " + file.length());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                int exifOrientation = ImageUtil.getExifOrientation(str);
                QLog.d("MediaChooseJsProxyImpl", 1, "compressSingleImg, before compress, degree is : " + exifOrientation);
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
                            QLog.e("MediaChooseJsProxyImpl", 1, "compressSingleImg failed ", th);
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
            QLog.d("MediaChooseJsProxyImpl", 1, "compressSingleImg, after compress, image file size is " + file2.length());
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

    private int q(JSONObject jSONObject) {
        int config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_CHOOSE_MEDIA_MAX_COUNT, 15);
        int config2 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_CHOOSE_MEDIA_DEFAULT_COUNT, 15);
        int optInt = jSONObject.optInt("count", config2);
        if (optInt >= 0) {
            config2 = optInt;
        }
        return config2 > config ? config : config2;
    }

    private long r(JSONObject jSONObject) {
        int config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_CHOOSE_MEDIA_MAX_DURATION, 60);
        int optInt = jSONObject.optInt("maxDuration", QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_CHOOSE_MEDIA_DEFAULT_DURATION, 10));
        if (optInt < 3) {
            optInt = 3;
        }
        if (optInt <= config) {
            config = optInt;
        }
        return config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ShortVideoUtils.getVideoThumbnail(null, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Activity activity, long j3, boolean z16, int i3) {
        IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        activityResultManager.addActivityResultListener(new a(activityResultManager));
        Bundle bundle = new Bundle();
        bundle.putLong(AECameraConstants.EXTRA_ACTIVITY_START_TIME, System.currentTimeMillis());
        bundle.putBoolean(PeakConstants.ARG_ALBUM, false);
        bundle.putInt("edit_video_type", 10020);
        bundle.putInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, 3);
        bundle.putInt(AECameraConstants.KEY_CAMERA_VIDEO_EDIT_TYPE, 5);
        bundle.putBoolean(PeakConstants.EXTRA_DIRECTLY_BACK, true);
        bundle.putString(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_CLASS_NAME);
        bundle.putBoolean(ShortVideoConstants.ENABLE_EDIT_VIDEO, true);
        bundle.putBoolean(AECameraConstants.KEY_ENABLE_INPUT_TEXT, false);
        bundle.putBoolean(AECameraConstants.KEY_ENABLE_PRIV_LIST, false);
        bundle.putInt(PeakConstants.KEY_ENTRY_SOURCE, 5);
        bundle.putBoolean("support_record", true);
        bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, false);
        bundle.putBoolean("enable_local_button", false);
        bundle.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, false);
        bundle.putBoolean("enterPtu", false);
        bundle.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, true);
        bundle.putBoolean(AECameraConstants.KEY_DISABLE_FACE_DETECT, true);
        bundle.putBoolean(AECameraConstants.KEY_NEED_CHECK_SENSITIVE, false);
        if (i3 == 0) {
            bundle.putInt("ability_flag", 1);
        } else if (i3 == 1) {
            bundle.putInt("ability_flag", 2);
        } else if (i3 == 2) {
            bundle.putInt("ability_flag", 3);
        }
        bundle.putInt(AECameraConstants.ARG_CAPTURE_MAX_DURATION, ((int) j3) * 1000);
        if (z16) {
            bundle.putInt(PeakConstants.ARG_FORCE_CAMERA, 1);
        } else {
            bundle.putInt(PeakConstants.ARG_FORCE_CAMERA, 2);
        }
        bundle.putBoolean(AECameraConstants.PARAMS_NEED_SHOW_BANNER, false);
        Intent intent = new Intent(activity, (Class<?>) ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass());
        intent.putExtras(bundle);
        intent.putExtra(AECameraConstants.PARAMS_NEED_SHOW_BANNER, false);
        activity.startActivityForResult(intent, 10020);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3, String str, JSONObject jSONObject) {
        MediaChooseJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.responseCancel(i3, str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3, String str, JSONObject jSONObject, String str2) {
        MediaChooseJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.responseFail(i3, str, jSONObject, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3, String str, JSONObject jSONObject) {
        MediaChooseJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.responseOk(i3, str, jSONObject);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009e A[Catch: Exception -> 0x01c0, TRY_ENTER, TryCatch #0 {Exception -> 0x01c0, blocks: (B:3:0x0008, B:5:0x0018, B:8:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x005d, B:16:0x007d, B:23:0x008a, B:27:0x0092, B:30:0x009e, B:32:0x00a8, B:35:0x00ae, B:38:0x00ca, B:41:0x00cd, B:44:0x00d5, B:47:0x00eb, B:49:0x00f1, B:51:0x0116, B:55:0x011e, B:58:0x012a, B:60:0x0134, B:63:0x013a, B:66:0x0165, B:69:0x0168, B:72:0x0170, B:75:0x0185, B:77:0x0194, B:79:0x01a7, B:81:0x01b2, B:84:0x017d, B:88:0x00e2, B:92:0x0080), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5 A[Catch: Exception -> 0x01c0, TryCatch #0 {Exception -> 0x01c0, blocks: (B:3:0x0008, B:5:0x0018, B:8:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x005d, B:16:0x007d, B:23:0x008a, B:27:0x0092, B:30:0x009e, B:32:0x00a8, B:35:0x00ae, B:38:0x00ca, B:41:0x00cd, B:44:0x00d5, B:47:0x00eb, B:49:0x00f1, B:51:0x0116, B:55:0x011e, B:58:0x012a, B:60:0x0134, B:63:0x013a, B:66:0x0165, B:69:0x0168, B:72:0x0170, B:75:0x0185, B:77:0x0194, B:79:0x01a7, B:81:0x01b2, B:84:0x017d, B:88:0x00e2, B:92:0x0080), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1 A[Catch: Exception -> 0x01c0, TryCatch #0 {Exception -> 0x01c0, blocks: (B:3:0x0008, B:5:0x0018, B:8:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x005d, B:16:0x007d, B:23:0x008a, B:27:0x0092, B:30:0x009e, B:32:0x00a8, B:35:0x00ae, B:38:0x00ca, B:41:0x00cd, B:44:0x00d5, B:47:0x00eb, B:49:0x00f1, B:51:0x0116, B:55:0x011e, B:58:0x012a, B:60:0x0134, B:63:0x013a, B:66:0x0165, B:69:0x0168, B:72:0x0170, B:75:0x0185, B:77:0x0194, B:79:0x01a7, B:81:0x01b2, B:84:0x017d, B:88:0x00e2, B:92:0x0080), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0116 A[Catch: Exception -> 0x01c0, TryCatch #0 {Exception -> 0x01c0, blocks: (B:3:0x0008, B:5:0x0018, B:8:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x005d, B:16:0x007d, B:23:0x008a, B:27:0x0092, B:30:0x009e, B:32:0x00a8, B:35:0x00ae, B:38:0x00ca, B:41:0x00cd, B:44:0x00d5, B:47:0x00eb, B:49:0x00f1, B:51:0x0116, B:55:0x011e, B:58:0x012a, B:60:0x0134, B:63:0x013a, B:66:0x0165, B:69:0x0168, B:72:0x0170, B:75:0x0185, B:77:0x0194, B:79:0x01a7, B:81:0x01b2, B:84:0x017d, B:88:0x00e2, B:92:0x0080), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a A[Catch: Exception -> 0x01c0, TRY_ENTER, TryCatch #0 {Exception -> 0x01c0, blocks: (B:3:0x0008, B:5:0x0018, B:8:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x005d, B:16:0x007d, B:23:0x008a, B:27:0x0092, B:30:0x009e, B:32:0x00a8, B:35:0x00ae, B:38:0x00ca, B:41:0x00cd, B:44:0x00d5, B:47:0x00eb, B:49:0x00f1, B:51:0x0116, B:55:0x011e, B:58:0x012a, B:60:0x0134, B:63:0x013a, B:66:0x0165, B:69:0x0168, B:72:0x0170, B:75:0x0185, B:77:0x0194, B:79:0x01a7, B:81:0x01b2, B:84:0x017d, B:88:0x00e2, B:92:0x0080), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0170 A[Catch: Exception -> 0x01c0, TryCatch #0 {Exception -> 0x01c0, blocks: (B:3:0x0008, B:5:0x0018, B:8:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x005d, B:16:0x007d, B:23:0x008a, B:27:0x0092, B:30:0x009e, B:32:0x00a8, B:35:0x00ae, B:38:0x00ca, B:41:0x00cd, B:44:0x00d5, B:47:0x00eb, B:49:0x00f1, B:51:0x0116, B:55:0x011e, B:58:0x012a, B:60:0x0134, B:63:0x013a, B:66:0x0165, B:69:0x0168, B:72:0x0170, B:75:0x0185, B:77:0x0194, B:79:0x01a7, B:81:0x01b2, B:84:0x017d, B:88:0x00e2, B:92:0x0080), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0194 A[Catch: Exception -> 0x01c0, TryCatch #0 {Exception -> 0x01c0, blocks: (B:3:0x0008, B:5:0x0018, B:8:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x005d, B:16:0x007d, B:23:0x008a, B:27:0x0092, B:30:0x009e, B:32:0x00a8, B:35:0x00ae, B:38:0x00ca, B:41:0x00cd, B:44:0x00d5, B:47:0x00eb, B:49:0x00f1, B:51:0x0116, B:55:0x011e, B:58:0x012a, B:60:0x0134, B:63:0x013a, B:66:0x0165, B:69:0x0168, B:72:0x0170, B:75:0x0185, B:77:0x0194, B:79:0x01a7, B:81:0x01b2, B:84:0x017d, B:88:0x00e2, B:92:0x0080), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a7 A[Catch: Exception -> 0x01c0, TryCatch #0 {Exception -> 0x01c0, blocks: (B:3:0x0008, B:5:0x0018, B:8:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x005d, B:16:0x007d, B:23:0x008a, B:27:0x0092, B:30:0x009e, B:32:0x00a8, B:35:0x00ae, B:38:0x00ca, B:41:0x00cd, B:44:0x00d5, B:47:0x00eb, B:49:0x00f1, B:51:0x0116, B:55:0x011e, B:58:0x012a, B:60:0x0134, B:63:0x013a, B:66:0x0165, B:69:0x0168, B:72:0x0170, B:75:0x0185, B:77:0x0194, B:79:0x01a7, B:81:0x01b2, B:84:0x017d, B:88:0x00e2, B:92:0x0080), top: B:2:0x0008 }] */
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void chooseMedia(final Activity activity, String str, String str2, int i3) {
        int i16;
        int i17;
        int i18;
        this.f347380c = i3;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!"chooseMedia".equals(str)) {
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mediaType");
            JSONArray optJSONArray3 = jSONObject.optJSONArray("sizeType");
            final boolean equals = jSONObject.optString("camera").equals("front");
            int i19 = 1;
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i26 = 0; i26 < optJSONArray.length(); i26++) {
                    if (!optJSONArray.opt(i26).equals("album")) {
                        QLog.e("MediaChooseJsProxyImpl", 1, "API_CHOOSE_MEDIA sourceType error. " + optJSONArray.opt(i26));
                        w(i3, str, null, "fail sourceType error");
                        return;
                    }
                }
                if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                    for (i18 = 0; i18 < optJSONArray2.length(); i18++) {
                        Object opt = optJSONArray2.opt(i18);
                        if (!opt.equals("image") && !opt.equals("video")) {
                            QLog.e("MediaChooseJsProxyImpl", 1, "API_CHOOSE_MEDIA mediaType error. " + opt);
                            w(i3, str, null, "fail mediaType error");
                            return;
                        }
                    }
                    if (optJSONArray2.length() == 2) {
                        Object opt2 = optJSONArray2.opt(0);
                        if (opt2.equals("image")) {
                            i16 = 1;
                        } else if (opt2.equals("video")) {
                            i16 = 2;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("MediaChooseJsProxyImpl", 2, "chooseMedia sourceType: " + optJSONArray + " length: " + optJSONArray.length());
                        }
                        if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                            for (i17 = 0; i17 < optJSONArray3.length(); i17++) {
                                Object opt3 = optJSONArray3.opt(i17);
                                if (!opt3.equals("compressed") && !opt3.equals("original")) {
                                    QLog.e("MediaChooseJsProxyImpl", 1, "API_CHOOSE_MEDIA sizeType error. " + opt3);
                                    w(i3, str, null, "fail sizeType error:" + opt3);
                                    return;
                                }
                            }
                            if (optJSONArray3.length() == 2) {
                                Object opt4 = optJSONArray3.opt(0);
                                if (opt4.equals("compressed")) {
                                    i19 = 2;
                                } else if (opt4.equals("original")) {
                                }
                                final long r16 = r(jSONObject);
                                final int q16 = q(jSONObject);
                                if (optJSONArray.length() != 2) {
                                    final int i27 = i16;
                                    final int i28 = i19;
                                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.2

                                        /* renamed from: com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl$2$a */
                                        /* loaded from: classes34.dex */
                                        class a implements DialogInterface.OnClickListener {
                                            a() {
                                            }

                                            @Override // android.content.DialogInterface.OnClickListener
                                            public void onClick(DialogInterface dialogInterface, int i3) {
                                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                                MediaChooseJsProxyImpl.this.t(activity, r16, equals, i27);
                                                if (dialogInterface != null) {
                                                    dialogInterface.dismiss();
                                                }
                                            }
                                        }

                                        /* renamed from: com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl$2$b */
                                        /* loaded from: classes34.dex */
                                        class b implements DialogInterface.OnClickListener {
                                            b() {
                                            }

                                            @Override // android.content.DialogInterface.OnClickListener
                                            public void onClick(DialogInterface dialogInterface, int i3) {
                                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                                MediaChooseJsProxyImpl.this.A(activity);
                                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                                MediaChooseJsProxyImpl.this.u(activity, r16, i28, i27, q16);
                                                if (dialogInterface != null) {
                                                    dialogInterface.dismiss();
                                                }
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            DialogUtil.createCustomDialog(activity, 230, HardCodeUtil.qqStr(R.string.v4x), HardCodeUtil.qqStr(R.string.v4y), HardCodeUtil.qqStr(R.string.f172897v51), HardCodeUtil.qqStr(R.string.v4z), new a(), new b()).show();
                                        }
                                    });
                                    return;
                                } else {
                                    if ("album".equals(optJSONArray.optString(0))) {
                                        A(activity);
                                        u(activity, r16, i19, i16, q16);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        i19 = 0;
                        final long r162 = r(jSONObject);
                        final int q162 = q(jSONObject);
                        if (optJSONArray.length() != 2) {
                        }
                    }
                }
                i16 = 0;
                if (QLog.isColorLevel()) {
                }
                if (optJSONArray3 != null) {
                    while (i17 < optJSONArray3.length()) {
                    }
                    if (optJSONArray3.length() == 2) {
                    }
                }
                i19 = 0;
                final long r1622 = r(jSONObject);
                final int q1622 = q(jSONObject);
                if (optJSONArray.length() != 2) {
                }
            }
            optJSONArray = new JSONArray();
            optJSONArray.mo162put("album");
            if (optJSONArray2 != null) {
                while (i18 < optJSONArray2.length()) {
                }
                if (optJSONArray2.length() == 2) {
                }
            }
            i16 = 0;
            if (QLog.isColorLevel()) {
            }
            if (optJSONArray3 != null) {
            }
            i19 = 0;
            final long r16222 = r(jSONObject);
            final int q16222 = q(jSONObject);
            if (optJSONArray.length() != 2) {
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy
    public void create(IMiniAppContext iMiniAppContext) {
        this.f347379b = iMiniAppContext;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy
    public void destroy() {
        D();
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x006d -> B:23:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean B(Bitmap bitmap, LocalMediaInfo localMediaInfo) {
        BufferedOutputStream bufferedOutputStream;
        boolean z16 = false;
        if (bitmap == null) {
            QLog.w("MediaChooseJsProxyImpl", 2, "saveThumbnail bitmap is null");
            return false;
        }
        if (localMediaInfo == null) {
            QLog.w("MediaChooseJsProxyImpl", 2, "saveThumbnail LocalMediaInfo is null");
            return false;
        }
        String tmpPath = ((IMiniAppFileManager) this.f347379b.getManager(IMiniAppFileManager.class)).getTmpPath("png");
        File file = new File(tmpPath);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2, 4096);
                } catch (Exception e16) {
                    e = e16;
                    bufferedOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                }
                try {
                    z16 = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    tmpPath = file.getAbsolutePath();
                    localMediaInfo.thumbnailPath = ((IMiniAppFileManager) this.f347379b.getManager(IMiniAppFileManager.class)).getWxFilePath(tmpPath);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    bufferedOutputStream.close();
                } catch (Exception e18) {
                    e = e18;
                    fileOutputStream = fileOutputStream2;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.w("MediaChooseJsProxyImpl", 2, "saveThumbnail exp", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return z16;
                    } catch (Throwable th6) {
                        th = th6;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream == null) {
                            try {
                                bufferedOutputStream.close();
                                throw th;
                            } catch (IOException e27) {
                                e27.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    if (bufferedOutputStream == null) {
                    }
                }
            } catch (Exception e28) {
                e = e28;
                bufferedOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                bufferedOutputStream = null;
            }
        } catch (IOException e29) {
            e29.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i("MediaChooseJsProxyImpl", 2, "saveThumbnail " + tmpPath);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Activity activity, long j3, int i3, int i16, int i17) {
        this.f347383f = true;
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 4);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationMiniApp.H);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationMiniApp.f184372j);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationMiniApp.H);
        if (i16 == 0) {
            activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 0);
        } else if (i16 == 1) {
            activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        } else if (i16 == 2) {
            activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 2);
        }
        activityURIRequest.extra().putString(PeakConstants.DEST_BROADCAST_ACTION_NAME, "get_media_info");
        activityURIRequest.extra().putBoolean(PeakConstants.SHOW_MAGIC_USE_PASTER, false);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", i17);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", i17);
        activityURIRequest.extra().putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, this.f347382e);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        activityURIRequest.extra().putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, false);
        activityURIRequest.extra().putBoolean("from_miniapp_enable_bottombar", true);
        activityURIRequest.extra().putBoolean(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
        activityURIRequest.extra().putBoolean("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        if (i3 == 0) {
            activityURIRequest.extra().putBoolean(PeakConstants.ALBUM_SHOW_ORI_BUTTON, true);
        }
        activityURIRequest.extra().putBoolean(PeakConstants.IS_PREVIEW_VIDEO, true);
        activityURIRequest.extra().putInt("from_miniapp_cur_sizetype", i3);
        QRoute.startUri(activityURIRequest);
        QAlbumUtil.anim(activity, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        QLog.i("MediaChooseJsProxyImpl", 1, UIJsPlugin.EVENT_HIDE_LOADING);
        MediaChooseJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.hideLoading();
        }
    }

    private void z(Activity activity) {
        QLog.d("MediaChooseJsProxyImpl", 2, "registerAvatarReceiver");
        this.f347378a = new WeakReference<>(activity);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("get_media_info");
        activity.registerReceiver(this.f347384g, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347396a;

        a(IActivityResultManager iActivityResultManager) {
            this.f347396a = iActivityResultManager;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            String str;
            String str2;
            String str3;
            if (i3 != 10020) {
                return false;
            }
            if (i16 != -1) {
                MediaChooseJsProxyImpl mediaChooseJsProxyImpl = MediaChooseJsProxyImpl.this;
                mediaChooseJsProxyImpl.v(mediaChooseJsProxyImpl.f347380c, "makeMedia", null);
                this.f347396a.removeActivityResultListener(this);
                return true;
            }
            PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
            String stringExtra = intent.getStringExtra(AECameraConstants.INTENT_RESULT_KEY_TAKE_PHOTO_PATH);
            if (publishParam != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    String str4 = publishParam.P;
                    long length = new File(str4).length();
                    long j3 = publishParam.E;
                    str2 = "chooseMedia exception:";
                    try {
                        int i17 = publishParam.C;
                        str3 = "MediaChooseJsProxyImpl";
                        try {
                            int i18 = publishParam.D;
                            String str5 = publishParam.f69067e;
                            try {
                                jSONObject.put("tempFilePath", ((IMiniAppFileManager) MediaChooseJsProxyImpl.this.f347379b.getManager(IMiniAppFileManager.class)).getWxFilePath(str4));
                                jSONObject.put("type", "video");
                                jSONObject.put("size", length);
                                jSONObject.put("duration", j3);
                                jSONObject.put("width", i17);
                                jSONObject.put("height", i18);
                                jSONObject.put("thumbTempFilePath", ((IMiniAppFileManager) MediaChooseJsProxyImpl.this.f347379b.getManager(IMiniAppFileManager.class)).getWxFilePath(str5));
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.mo162put(jSONObject);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("tempFiles", jSONArray);
                                MediaChooseJsProxyImpl mediaChooseJsProxyImpl2 = MediaChooseJsProxyImpl.this;
                                str = "makeMedia";
                                try {
                                    mediaChooseJsProxyImpl2.x(mediaChooseJsProxyImpl2.f347380c, str, jSONObject2);
                                } catch (Exception e16) {
                                    e = e16;
                                    QLog.e(str3, 1, "camera for video parse failed", e);
                                    MediaChooseJsProxyImpl mediaChooseJsProxyImpl3 = MediaChooseJsProxyImpl.this;
                                    mediaChooseJsProxyImpl3.w(mediaChooseJsProxyImpl3.f347380c, str, null, str2 + e.getMessage());
                                    this.f347396a.removeActivityResultListener(this);
                                    return true;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str = "makeMedia";
                            }
                        } catch (Exception e18) {
                            e = e18;
                            str = "makeMedia";
                        }
                    } catch (Exception e19) {
                        e = e19;
                        str = "makeMedia";
                        str3 = "MediaChooseJsProxyImpl";
                        QLog.e(str3, 1, "camera for video parse failed", e);
                        MediaChooseJsProxyImpl mediaChooseJsProxyImpl32 = MediaChooseJsProxyImpl.this;
                        mediaChooseJsProxyImpl32.w(mediaChooseJsProxyImpl32.f347380c, str, null, str2 + e.getMessage());
                        this.f347396a.removeActivityResultListener(this);
                        return true;
                    }
                } catch (Exception e26) {
                    e = e26;
                    str = "makeMedia";
                    str2 = "chooseMedia exception:";
                }
            } else if (!TextUtils.isEmpty(stringExtra)) {
                long length2 = new File(stringExtra).length();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("tempFilePath", ((IMiniAppFileManager) MediaChooseJsProxyImpl.this.f347379b.getManager(IMiniAppFileManager.class)).getWxFilePath(stringExtra));
                    jSONObject3.put("type", "image");
                    jSONObject3.put("size", length2);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.mo162put(jSONObject3);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("tempFiles", jSONArray2);
                    MediaChooseJsProxyImpl mediaChooseJsProxyImpl4 = MediaChooseJsProxyImpl.this;
                    mediaChooseJsProxyImpl4.x(mediaChooseJsProxyImpl4.f347380c, "makeMedia", jSONObject4);
                } catch (Exception e27) {
                    QLog.e("MediaChooseJsProxyImpl", 1, "camera for image parse failed", e27);
                    MediaChooseJsProxyImpl mediaChooseJsProxyImpl5 = MediaChooseJsProxyImpl.this;
                    mediaChooseJsProxyImpl5.w(mediaChooseJsProxyImpl5.f347380c, "makeMedia", null, "chooseMedia exception:" + e27.getMessage());
                }
            }
            this.f347396a.removeActivityResultListener(this);
            return true;
        }
    }
}
