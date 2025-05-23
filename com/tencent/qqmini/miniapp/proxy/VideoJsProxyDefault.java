package com.tencent.qqmini.miniapp.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qqmini.miniapp.plugin.VideoJsPlugin;
import com.tencent.qqmini.miniapp.util.VideoCompress;
import com.tencent.qqmini.miniapp.util.VideoCompressProxy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ShortVideoUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import common.config.service.QzoneConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy = VideoJsProxy.class)
/* loaded from: classes23.dex */
public class VideoJsProxyDefault extends VideoJsProxy {
    public static final String API_CHOOSE_VIDEO = "chooseVideo";
    public static final String API_MAKE_MEDIA = "makeMedia";
    private static final String SOURCE_TYPE_ALBUM = "album";
    private static final String SOURCE_TYPE_CAMERA = "camera";
    public static final String TAG = "VideoJsProxyImpl";
    private static final ExecutorService copyExecutor = ProxyExecutors.newFixedThreadPool(5);
    private IMiniAppContext mMiniAppContext;
    private VideoCompressProxy mVideoCompressService;

    /* loaded from: classes23.dex */
    public static class BridgeInfo {
        int callbackId;
        String eventName;
    }

    public VideoJsProxyDefault() {
        Log.i(TAG, "construct");
        this.mVideoCompressService = new VideoCompressProxyDefault();
    }

    private File createVideoFile(Context context) {
        try {
            return File.createTempFile("MP4_" + System.currentTimeMillis() + "_", ".mp4", context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        } catch (Throwable th5) {
            QMLog.e(TAG, "createVideoFile: ", th5);
            return null;
        }
    }

    private void execVideoCompress(final LocalMediaInfo localMediaInfo, final String str, final VideoCompress.Option option, final BridgeInfo bridgeInfo) {
        showLoading("\u6b63\u5728\u538b\u7f29");
        final long currentTimeMillis = System.currentTimeMillis();
        this.mVideoCompressService.setMedia(localMediaInfo).setOption(option).setOutputPath(str).listen(new VideoCompress.Listener() { // from class: com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.5
            @Override // com.tencent.qqmini.miniapp.util.VideoCompress.Listener
            public void onFailure(String str2) {
                for (String str3 : str2.split("\n")) {
                    QMLog.w(VideoJsProxyDefault.TAG, "onFailure: " + str3);
                }
                if (option.scale > 0) {
                    VideoJsProxyDefault.this.startCompress(localMediaInfo, false, bridgeInfo);
                    return;
                }
                String wxFilePath = ((MiniAppFileManager) VideoJsProxyDefault.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(localMediaInfo.path);
                VideoJsProxyDefault videoJsProxyDefault = VideoJsProxyDefault.this;
                LocalMediaInfo localMediaInfo2 = localMediaInfo;
                videoJsProxyDefault.respGetVideo(wxFilePath, localMediaInfo2.fileSize, localMediaInfo2, bridgeInfo);
            }

            @Override // com.tencent.qqmini.miniapp.util.VideoCompress.Listener
            public void onFinish(boolean z16) {
                QMLog.d(VideoJsProxyDefault.TAG, "compress finish " + z16 + " " + (System.currentTimeMillis() - currentTimeMillis));
            }

            @Override // com.tencent.qqmini.miniapp.util.VideoCompress.Listener
            public void onProgress(String str2, float f16) {
                float f17 = f16 * 100.0f;
                if (f17 < 100.0f) {
                    VideoJsProxyDefault.this.showLoading("\u6b63\u5728\u538b\u7f29 " + String.format(Locale.getDefault(), "%.0f%%", Float.valueOf(f17)));
                }
            }

            @Override // com.tencent.qqmini.miniapp.util.VideoCompress.Listener
            public void onStart() {
                QMLog.d(VideoJsProxyDefault.TAG, "compress start");
            }

            @Override // com.tencent.qqmini.miniapp.util.VideoCompress.Listener
            public void onSuccess(String str2) {
                if (QMLog.isColorLevel()) {
                    QMLog.d(VideoJsProxyDefault.TAG, "compress success " + str2);
                }
                int i3 = option.scale;
                if (i3 > 0) {
                    LocalMediaInfo localMediaInfo2 = localMediaInfo;
                    localMediaInfo2.mediaWidth /= i3;
                    localMediaInfo2.mediaHeight /= i3;
                }
                VideoJsProxyDefault.this.respGetVideo(((MiniAppFileManager) VideoJsProxyDefault.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(str), new File(str).length(), localMediaInfo, bridgeInfo);
            }
        }).execute();
    }

    public static int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
            try {
                if (QMLog.isColorLevel()) {
                    QMLog.d(TAG, "format for track " + i3 + " is " + mediaExtractor.getTrackFormat(i3).getString("mime"));
                }
                if (mediaExtractor.getTrackFormat(i3).getString("mime").startsWith("video/")) {
                    mediaExtractor.selectTrack(i3);
                    return i3;
                }
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    private String getSaveVideoFilePath() {
        return ShortVideoUtil.getCameraPath() + FileUtils.SECONDARY_DIRECTORY + System.currentTimeMillis() + "_.mp4";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getThumbnailBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ShortVideoUtil.getVideoThumbnail(null, ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToCamera(Activity activity, long j3, final boolean z16, boolean z17, final BridgeInfo bridgeInfo) {
        boolean hasFrontCamera = hasFrontCamera(activity);
        if (z17 && !hasFrontCamera) {
            this.mBridge.responseFail(bridgeInfo.callbackId, bridgeInfo.eventName, null, "front camera not supported");
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(activity.getPackageManager()) == null) {
            this.mBridge.responseFail(bridgeInfo.callbackId, bridgeInfo.eventName, null, "\u5f53\u524d\u7cfb\u7edf\u4e0d\u652f\u6301");
            return;
        }
        final File createVideoFile = createVideoFile(activity.getApplicationContext());
        if (createVideoFile == null) {
            this.mBridge.responseFail(bridgeInfo.callbackId, bridgeInfo.eventName, null, "createVideoFile error");
            return;
        }
        QMLog.i(TAG, "videoFile=" + createVideoFile.getAbsolutePath());
        Uri uriForFile = FileUtils.getUriForFile(activity, createVideoFile);
        QMLog.i(TAG, "videoUri=" + uriForFile);
        intent.putExtra("output", uriForFile);
        if (j3 < 1 || j3 > 60000) {
            j3 = 60000;
        }
        intent.putExtra("android.intent.extra.durationLimit", j3);
        if (z17) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        }
        ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.3
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent2) {
                if (i3 != 4) {
                    return false;
                }
                if (i16 == -1) {
                    VideoJsProxyDefault.this.handleVideoResult(createVideoFile, z16, bridgeInfo);
                    ActivityResultManager.g().removeActivityResultListener(this);
                    return true;
                }
                if (i16 == 0) {
                    VideoJsProxy.Bridge bridge = ((VideoJsProxy) VideoJsProxyDefault.this).mBridge;
                    BridgeInfo bridgeInfo2 = bridgeInfo;
                    bridge.responseCancel(bridgeInfo2.callbackId, bridgeInfo2.eventName, null);
                }
                createVideoFile.deleteOnExit();
                ActivityResultManager.g().removeActivityResultListener(this);
                return true;
            }
        });
        activity.startActivityForResult(intent, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToPic(final Activity activity, int i3, final boolean z16, final BridgeInfo bridgeInfo) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "video/*");
        ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.2
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i16, int i17, Intent intent2) {
                if (i16 != 2) {
                    return false;
                }
                if (i17 != -1) {
                    if (i17 == 0) {
                        VideoJsProxy.Bridge bridge = ((VideoJsProxy) VideoJsProxyDefault.this).mBridge;
                        BridgeInfo bridgeInfo2 = bridgeInfo;
                        bridge.responseCancel(bridgeInfo2.callbackId, bridgeInfo2.eventName, null);
                    }
                    ActivityResultManager.g().removeActivityResultListener(this);
                    return true;
                }
                String path = VideoJsProxyDefault.this.getPath(activity, intent2.getData());
                if (path != null) {
                    VideoJsProxyDefault.this.handleVideoResult(new File(path), z16, bridgeInfo);
                }
                ActivityResultManager.g().removeActivityResultListener(this);
                return true;
            }
        });
        activity.startActivityForResult(intent, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleJsCallBack(String str, long j3, LocalMediaInfo localMediaInfo, BridgeInfo bridgeInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tempFilePath", str);
            jSONObject.put("thumbTempFilePath", localMediaInfo.thumbnailPath);
            jSONObject.put("duration", Math.round((float) (localMediaInfo.mDuration / 1000)));
            jSONObject.put("size", j3);
            jSONObject.put("height", localMediaInfo.mediaHeight);
            jSONObject.put("width", localMediaInfo.mediaWidth);
            this.mBridge.responseOk(bridgeInfo.callbackId, "chooseVideo", jSONObject);
        } catch (JSONException e16) {
            e16.printStackTrace();
            this.mBridge.responseFail(bridgeInfo.callbackId, "chooseVideo", null, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
    
        if (r5 != 0) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleVideoResult(File file, boolean z16, BridgeInfo bridgeInfo) {
        MediaExtractor mediaExtractor;
        FileInputStream fileInputStream;
        ?? r56;
        LocalMediaInfo localMediaInfo;
        int i3;
        QMLog.i(TAG, "handleVideoResult file:" + file.getAbsolutePath());
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e16) {
            e = e16;
            fileInputStream = null;
            r56 = 0;
        } catch (Throwable th5) {
            th = th5;
            mediaExtractor = null;
            if (fileInputStream2 != null) {
            }
            if (mediaExtractor != null) {
            }
        }
        try {
            r56 = new MediaExtractor();
        } catch (IOException e17) {
            e = e17;
            r56 = 0;
            localMediaInfo = r56;
            QMLog.w(TAG, "handleVideoResult: ", e);
            if (fileInputStream != null) {
            }
        } catch (Throwable th6) {
            th = th6;
            r56 = 0;
            fileInputStream2 = fileInputStream;
            mediaExtractor = r56;
            if (fileInputStream2 != null) {
            }
            if (mediaExtractor != null) {
            }
        }
        try {
            try {
                r56.setDataSource(fileInputStream.getFD());
                int andSelectVideoTrackIndex = getAndSelectVideoTrackIndex(r56);
                if (andSelectVideoTrackIndex > -1) {
                    MediaFormat trackFormat = r56.getTrackFormat(andSelectVideoTrackIndex);
                    localMediaInfo = new LocalMediaInfo();
                    try {
                        if (trackFormat.containsKey("rotation-degrees")) {
                            i3 = trackFormat.getInteger("rotation-degrees");
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 90 && i3 != 270) {
                            localMediaInfo.mediaWidth = trackFormat.getInteger("width");
                            localMediaInfo.mediaHeight = trackFormat.getInteger("height");
                        } else {
                            localMediaInfo.mediaWidth = trackFormat.getInteger("height");
                            localMediaInfo.mediaHeight = trackFormat.getInteger("width");
                        }
                        localMediaInfo.mDuration = Math.round(trackFormat.getLong("durationUs") / 1000.0d);
                        localMediaInfo.path = file.getAbsolutePath();
                        localMediaInfo.fileSize = file.length();
                    } catch (IOException e18) {
                        e = e18;
                        QMLog.w(TAG, "handleVideoResult: ", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    }
                } else {
                    localMediaInfo = null;
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    r56.release();
                    LocalMediaInfo localMediaInfo2 = localMediaInfo;
                    if (localMediaInfo2 == null) {
                        this.mBridge.responseFail(bridgeInfo.callbackId, "chooseVideo", null, "");
                    } else if (z16) {
                        startCompress(localMediaInfo2, true, bridgeInfo);
                    } else {
                        respGetVideo(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(localMediaInfo2.path), localMediaInfo2.fileSize, localMediaInfo2, bridgeInfo);
                    }
                }
            } catch (IOException e19) {
                e = e19;
                localMediaInfo = null;
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream2 = fileInputStream;
            mediaExtractor = r56;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
            if (mediaExtractor != null) {
                mediaExtractor.release();
                throw th;
            }
            throw th;
        }
    }

    private boolean hasFrontCamera(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.camera.front")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        this.mBridge.hideLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void respGetVideo(final String str, final long j3, final LocalMediaInfo localMediaInfo, final BridgeInfo bridgeInfo) {
        if (localMediaInfo == null) {
            this.mBridge.responseCancel(bridgeInfo.callbackId, "chooseVideo", null);
        } else if (!TextUtils.isEmpty(localMediaInfo.thumbnailPath)) {
            handleJsCallBack(str, j3, localMediaInfo, bridgeInfo);
        } else {
            ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoJsProxyDefault.this.showLoading("\u6b63\u5728\u83b7\u53d6\u89c6\u9891\u5c01\u9762\uff0c\u8bf7\u7a0d\u540e");
                    VideoJsProxyDefault videoJsProxyDefault = VideoJsProxyDefault.this;
                    QMLog.d(VideoJsProxyDefault.TAG, "saveThumbnail : " + videoJsProxyDefault.saveThumbnail(videoJsProxyDefault.getThumbnailBitmap(str), localMediaInfo));
                    VideoJsProxyDefault.this.hideLoading();
                    VideoJsProxyDefault.this.handleJsCallBack(str, j3, localMediaInfo, bridgeInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x006c -> B:23:0x009c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean saveThumbnail(Bitmap bitmap, LocalMediaInfo localMediaInfo) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        boolean z16 = false;
        if (bitmap == null) {
            QMLog.w(TAG, "saveThumbnail bitmap is null");
            return false;
        }
        if (localMediaInfo == null) {
            QMLog.w(TAG, "saveThumbnail LocalMediaInfo is null");
            return false;
        }
        String tmpPath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("png");
        File file = new File(tmpPath);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 4096);
                } catch (Exception e16) {
                    e = e16;
                    bufferedOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                }
            } catch (Exception e17) {
                e = e17;
                bufferedOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
            }
            try {
                z16 = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                tmpPath = file.getAbsolutePath();
                localMediaInfo.thumbnailPath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(tmpPath);
                try {
                    fileOutputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                bufferedOutputStream.close();
            } catch (Exception e19) {
                e = e19;
                fileOutputStream2 = fileOutputStream;
                try {
                    if (QMLog.isColorLevel()) {
                        QMLog.w(TAG, "saveThumbnail exp", e);
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (QMLog.isColorLevel()) {
                    }
                    return z16;
                } catch (Throwable th7) {
                    th = th7;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream == null) {
                        try {
                            bufferedOutputStream.close();
                            throw th;
                        } catch (IOException e28) {
                            e28.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                if (bufferedOutputStream == null) {
                }
            }
        } catch (IOException e29) {
            e29.printStackTrace();
        }
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "saveThumbnail " + tmpPath);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading(String str) {
        this.mBridge.showLoading(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071 A[Catch: Exception -> 0x0077, TryCatch #0 {Exception -> 0x0077, blocks: (B:2:0x0000, B:6:0x0019, B:8:0x0024, B:11:0x0034, B:13:0x004d, B:14:0x0050, B:16:0x0056, B:20:0x005e, B:22:0x0071, B:23:0x0073, B:26:0x0010), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startCompress(final LocalMediaInfo localMediaInfo, final boolean z16, final BridgeInfo bridgeInfo) {
        String substring;
        int i3;
        try {
            int lastIndexOf = localMediaInfo.path.lastIndexOf(".");
            if (lastIndexOf < 0) {
                substring = "";
            } else {
                substring = localMediaInfo.path.substring(lastIndexOf + 1);
            }
            final String str = substring;
            if (localMediaInfo.path.contains(" ")) {
                copyExecutor.execute(new Runnable() { // from class: com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QMLog.i(VideoJsProxyDefault.TAG, "start copy from " + localMediaInfo.path);
                        String tmpPath = ((MiniAppFileManager) VideoJsProxyDefault.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str);
                        if (tmpPath.contains(" ")) {
                            QMLog.w(VideoJsProxyDefault.TAG, "wrong copy path " + tmpPath);
                            String wxFilePath = ((MiniAppFileManager) VideoJsProxyDefault.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(localMediaInfo.path);
                            VideoJsProxyDefault videoJsProxyDefault = VideoJsProxyDefault.this;
                            LocalMediaInfo localMediaInfo2 = localMediaInfo;
                            videoJsProxyDefault.respGetVideo(wxFilePath, localMediaInfo2.fileSize, localMediaInfo2, bridgeInfo);
                            return;
                        }
                        File file = new File(tmpPath);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (FileUtils.copyFile(new File(localMediaInfo.path), file)) {
                            LocalMediaInfo localMediaInfo3 = localMediaInfo;
                            localMediaInfo3.path = tmpPath;
                            VideoJsProxyDefault.this.startCompress(localMediaInfo3, z16, bridgeInfo);
                        } else {
                            QMLog.w(VideoJsProxyDefault.TAG, "copy file failed");
                            String wxFilePath2 = ((MiniAppFileManager) VideoJsProxyDefault.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(localMediaInfo.path);
                            VideoJsProxyDefault videoJsProxyDefault2 = VideoJsProxyDefault.this;
                            LocalMediaInfo localMediaInfo4 = localMediaInfo;
                            videoJsProxyDefault2.respGetVideo(wxFilePath2, localMediaInfo4.fileSize, localMediaInfo4, bridgeInfo);
                        }
                    }
                });
                return;
            }
            String tmpPath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str);
            File file = new File(tmpPath);
            if (file.exists()) {
                file.delete();
            }
            if (localMediaInfo.mediaWidth <= 3000 && localMediaInfo.mediaHeight <= 3000) {
                i3 = 2;
                VideoCompress.Option option = new VideoCompress.Option();
                option.crf = 29;
                option.targetEncoding = VideoCompress.TargetEncoding.x264;
                option.targetFrameRate = 20;
                if (z16) {
                    option.scale = i3;
                }
                execVideoCompress(localMediaInfo, tmpPath, option, bridgeInfo);
            }
            i3 = 4;
            VideoCompress.Option option2 = new VideoCompress.Option();
            option2.crf = 29;
            option2.targetEncoding = VideoCompress.TargetEncoding.x264;
            option2.targetFrameRate = 20;
            if (z16) {
            }
            execVideoCompress(localMediaInfo, tmpPath, option2, bridgeInfo);
        } catch (Exception e16) {
            QMLog.e(TAG, "startCompress=e=" + e16.getMessage());
            this.mBridge.responseFail(bridgeInfo.callbackId, bridgeInfo.eventName, null, e16.getMessage());
        }
    }

    private void updateLoading(String str) {
        this.mBridge.updateLoading(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void chooseVideo(final Activity activity, String str, String str2, int i3) {
        Log.i(TAG, "chooseVideo");
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            final boolean optBoolean = jSONObject.optBoolean("compressed");
            final boolean equals = jSONObject.optString("camera").equals("front");
            final BridgeInfo bridgeInfo = new BridgeInfo();
            bridgeInfo.callbackId = i3;
            bridgeInfo.eventName = str;
            if (optJSONArray.length() == 0) {
                this.mBridge.responseFail(i3, str, null, "fail sourceType error");
                return;
            }
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                Object opt = optJSONArray.opt(i16);
                if (!opt.equals("album") && !opt.equals("camera")) {
                    QMLog.e(TAG, "API_CHOOSE_VIDEO sourceType error. " + optJSONArray.opt(i16));
                    this.mBridge.responseFail(i3, str, null, "fail sourceType error");
                    return;
                }
            }
            QMLog.d(VideoJsPlugin.TAG, "sourceType: " + optJSONArray + " length: " + optJSONArray.length());
            final int optInt = jSONObject.optInt("maxDuration");
            if (optJSONArray.length() == 2) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DialogUtil.createCustomDialog(activity, 230, "\u89c6\u9891\u9009\u62e9", "\u8bf7\u9009\u62e9\u83b7\u53d6\u89c6\u9891\u65b9\u5f0f", QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE, "\u62cd\u6444", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i17) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                VideoJsProxyDefault.this.goToCamera(activity, optInt, optBoolean, equals, bridgeInfo);
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i17) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                VideoJsProxyDefault.this.goToPic(activity, optInt, optBoolean, bridgeInfo);
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                            }
                        }).show();
                    }
                });
            } else if ("camera".equals(optJSONArray.optString(0))) {
                goToCamera(activity, optInt, optBoolean, equals, bridgeInfo);
            } else {
                goToPic(activity, optInt, optBoolean, bridgeInfo);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            this.mBridge.responseFail(i3, str, null, th5.getMessage());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void create(IMiniAppContext iMiniAppContext) {
        Log.i(TAG, OperateCustomButton.OPERATE_CREATE);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void destroy() {
        Log.i(TAG, "destroy");
        super.destroy();
    }

    public String getPath(Context context, Uri uri) {
        Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{"_data"}, null, null, null);
        if (query != null) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            return query.getString(columnIndexOrThrow);
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void makeMedia(Activity activity, String str, String str2, int i3) {
        Log.i(TAG, "makeMedia");
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            boolean optBoolean = jSONObject.optBoolean("compressed");
            boolean equals = TextUtils.equals(jSONObject.optString("camera"), "front");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                optJSONArray = new JSONArray();
                optJSONArray.mo162put("camera");
            }
            BridgeInfo bridgeInfo = new BridgeInfo();
            bridgeInfo.callbackId = i3;
            bridgeInfo.eventName = str;
            if (optJSONArray.length() == 0) {
                this.mBridge.responseFail(i3, str, null, "fail sourceType error");
                return;
            }
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                Object opt = optJSONArray.opt(i16);
                if (!opt.equals("album") && !opt.equals("camera")) {
                    QMLog.e(TAG, "API_MAKE_MEDIA sourceType error. " + optJSONArray.opt(i16));
                    this.mBridge.responseFail(i3, str, null, "fail sourceType error");
                    return;
                }
            }
            QMLog.d(VideoJsPlugin.TAG, "sourceType: " + optJSONArray + " length: " + optJSONArray.length());
            int optInt = jSONObject.optInt("maxDuration");
            if ("camera".equals(optJSONArray.optString(0))) {
                goToCamera(activity, optInt, optBoolean, equals, bridgeInfo);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, " makeMedia e: ", th5);
            this.mBridge.responseFail(i3, str, null, th5.getMessage());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void saveVideoToPhotosAlbum(Activity activity, String str, String str2, int i3) {
        Log.i(TAG, "saveVideoToPhotosAlbum");
        try {
            String optString = new JSONObject(str2).optString("filePath");
            if (StringUtil.isEmpty(optString)) {
                this.mBridge.responseFail(i3, str, null, "fail file not exists");
            } else if (FileUtils.saveVideoToAlbum(activity, ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString), getSaveVideoFilePath())) {
                this.mBridge.responseOk(i3, str, null);
            } else {
                this.mBridge.responseFail(i3, str, null, "fail filePath invalid");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, " saveVideoToPhotosAlbum e: ", th5);
            this.mBridge.responseFail(i3, str, null, th5.getMessage());
        }
    }
}
