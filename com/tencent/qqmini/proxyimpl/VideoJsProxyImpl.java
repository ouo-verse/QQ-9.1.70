package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationMiniApp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.plugin.VideoJsPlugin;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.Permissions;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qzonehub.api.DownloadResultCallback;
import com.tencent.qzonehub.api.IQzoneVideoSoDownloadModule;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoConst;
import eipc.EIPCResult;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy = VideoJsProxy.class)
/* loaded from: classes34.dex */
public class VideoJsProxyImpl extends VideoJsProxy {

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f347586o;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f347588a;

    /* renamed from: e, reason: collision with root package name */
    private IMiniAppContext f347592e;

    /* renamed from: k, reason: collision with root package name */
    private FFmpeg f347598k;

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f347583l = Pattern.compile("(?<=time=)[\\d:.]*");

    /* renamed from: m, reason: collision with root package name */
    private static final ExecutorService f347584m = ProxyExecutors.newSingleThreadExecutor();

    /* renamed from: n, reason: collision with root package name */
    private static final ExecutorService f347585n = ProxyExecutors.newFixedThreadPool(5);

    /* renamed from: p, reason: collision with root package name */
    private static AtomicBoolean f347587p = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private int f347589b = -1;

    /* renamed from: c, reason: collision with root package name */
    private String f347590c = "album";

    /* renamed from: d, reason: collision with root package name */
    private String f347591d = "camera";

    /* renamed from: f, reason: collision with root package name */
    private boolean f347593f = false;

    /* renamed from: g, reason: collision with root package name */
    private long f347594g = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_CHOOSE_VIDEO_MAX_DURATION, 600000L);

    /* renamed from: h, reason: collision with root package name */
    private long f347595h = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_CHOOSE_VIDEO_MAX_SIZE, 1610612736L);

    /* renamed from: i, reason: collision with root package name */
    private String f347596i = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_FFMPEG_VIDEO_COMPRESS_PARAM, QzoneConfig.DEFAULT_FFMPEG_VIDEO_COMPRESS_PARAM);

    /* renamed from: j, reason: collision with root package name */
    private BroadcastReceiver f347597j = new d();

    /* loaded from: classes34.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ac, code lost:
        
            if (r7 == null) goto L46;
         */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(Context context, Intent intent) {
            MediaExtractor mediaExtractor;
            if (VideoJsProxyImpl.this.f347593f) {
                int i3 = 0;
                VideoJsProxyImpl.this.f347593f = false;
                String action = intent.getAction();
                if (QLog.isColorLevel()) {
                    QLog.d(VideoJsPlugin.TAG, 2, String.format("mAvatarReceiver.onReceive action=%s", action));
                }
                if ("get_video_info".equals(action)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(VideoJsPlugin.TAG, 2, intent);
                    }
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) intent.getParcelableExtra(ShortVideoConstants.MEDIA_INFO);
                    FileInputStream fileInputStream = null;
                    if (localMediaInfo == null) {
                        VideoJsProxyImpl videoJsProxyImpl = VideoJsProxyImpl.this;
                        videoJsProxyImpl.B(videoJsProxyImpl.f347589b, "chooseVideo", null);
                        return;
                    }
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(localMediaInfo.path);
                        try {
                            mediaExtractor = new MediaExtractor();
                            try {
                                mediaExtractor.setDataSource(fileInputStream2.getFD());
                                int andSelectVideoTrackIndex = VideoJsProxyImpl.getAndSelectVideoTrackIndex(mediaExtractor);
                                if (andSelectVideoTrackIndex > -1) {
                                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
                                    if (trackFormat.containsKey("rotation-degrees")) {
                                        i3 = trackFormat.getInteger("rotation-degrees");
                                    }
                                }
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused) {
                                }
                            } catch (IOException e16) {
                                e = e16;
                                fileInputStream = fileInputStream2;
                                try {
                                    QLog.w(VideoJsPlugin.TAG, 1, "handleVideoResult: ", e);
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    if (mediaExtractor == null) {
                                        mediaExtractor.release();
                                        throw th;
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                }
                                if (mediaExtractor == null) {
                                }
                            }
                        } catch (IOException e17) {
                            e = e17;
                            mediaExtractor = null;
                        } catch (Throwable th7) {
                            th = th7;
                            mediaExtractor = null;
                        }
                    } catch (IOException e18) {
                        e = e18;
                        mediaExtractor = null;
                    } catch (Throwable th8) {
                        th = th8;
                        mediaExtractor = null;
                    }
                    mediaExtractor.release();
                    QLog.i(VideoJsPlugin.TAG, 2, "onReceive: " + i3);
                    if (i3 == 90 || i3 == 270) {
                        int i16 = localMediaInfo.mediaWidth;
                        localMediaInfo.mediaWidth = localMediaInfo.mediaHeight;
                        localMediaInfo.mediaHeight = i16;
                    }
                    boolean equals = ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS.equals(intent.getStringExtra(PeakConstants.DEST_OTHER_FLAG));
                    if (QLog.isColorLevel()) {
                        QLog.d(VideoJsPlugin.TAG, 2, "receive " + equals);
                    }
                    if (equals) {
                        VideoJsProxyImpl.this.K(localMediaInfo, true);
                    } else {
                        VideoJsProxyImpl.this.I(((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(localMediaInfo.path), localMediaInfo.fileSize, localMediaInfo);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class e implements FFmpegExecuteResponseCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f347624a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f347625b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f347626c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f347627d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f347628e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f347629f;

        e(long j3, String str, LocalMediaInfo localMediaInfo, int i3, String str2, long j16) {
            this.f347624a = j3;
            this.f347625b = str;
            this.f347626c = localMediaInfo;
            this.f347627d = i3;
            this.f347628e = str2;
            this.f347629f = j16;
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            for (String str2 : str.split("\n")) {
                QLog.w(VideoJsPlugin.TAG, 1, "onFailure: " + str2);
            }
            if (this.f347625b.contains("-vf")) {
                VideoJsProxyImpl.this.K(this.f347626c, false);
                return;
            }
            String wxFilePath = ((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(this.f347626c.path);
            VideoJsProxyImpl videoJsProxyImpl = VideoJsProxyImpl.this;
            LocalMediaInfo localMediaInfo = this.f347626c;
            videoJsProxyImpl.I(wxFilePath, localMediaInfo.fileSize, localMediaInfo);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFinish(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoJsPlugin.TAG, 2, "compress finish " + z16 + " " + (System.currentTimeMillis() - this.f347624a));
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onProgress(String str) {
            String findWithinHorizon;
            if (str.length() < 90 || str.length() > 150 || (findWithinHorizon = new Scanner(str).findWithinHorizon(VideoJsProxyImpl.f347583l, 0)) == null) {
                return;
            }
            String[] split = findWithinHorizon.split(":");
            if (split.length > 2) {
                try {
                    int millis = (int) ((((float) ((TimeUnit.HOURS.toMillis(Integer.parseInt(split[0])) + TimeUnit.MINUTES.toMillis(Integer.parseInt(split[1]))) + ((long) (Double.parseDouble(split[2]) * 1000.0d)))) * 100.0f) / ((float) this.f347629f));
                    if (millis < 100) {
                        VideoJsProxyImpl.this.showLoading(HardCodeUtil.qqStr(R.string.f172896v50) + millis + "%");
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onStart() {
            if (QLog.isColorLevel()) {
                QLog.d(VideoJsPlugin.TAG, 2, "compress start");
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoJsPlugin.TAG, 2, "compress success " + str + " " + this.f347625b);
            }
            if (this.f347625b.contains("-vf")) {
                LocalMediaInfo localMediaInfo = this.f347626c;
                int i3 = localMediaInfo.mediaWidth;
                int i16 = this.f347627d;
                localMediaInfo.mediaWidth = i3 / i16;
                localMediaInfo.mediaHeight /= i16;
            }
            VideoJsProxyImpl.this.I(((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(this.f347628e), new File(this.f347628e).length(), this.f347626c);
        }
    }

    public VideoJsProxyImpl() {
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3, String str, JSONObject jSONObject) {
        VideoJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.responseCancel(i3, str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i3, String str, JSONObject jSONObject, String str2) {
        VideoJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.responseFail(i3, str, jSONObject, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i3, String str, JSONObject jSONObject) {
        VideoJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.responseOk(i3, str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
    
        if (r4 != 0) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.media.MediaExtractor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(File file, boolean z16) {
        MediaExtractor mediaExtractor;
        FileInputStream fileInputStream;
        ?? r46;
        LocalMediaInfo localMediaInfo;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e16) {
                e = e16;
                fileInputStream = null;
                r46 = 0;
            } catch (Throwable th5) {
                th = th5;
                mediaExtractor = null;
                if (fileInputStream2 != null) {
                }
                if (mediaExtractor == null) {
                }
            }
            try {
                r46 = new MediaExtractor();
                try {
                    r46.setDataSource(fileInputStream.getFD());
                    int andSelectVideoTrackIndex = getAndSelectVideoTrackIndex(r46);
                    if (andSelectVideoTrackIndex > -1) {
                        MediaFormat trackFormat = r46.getTrackFormat(andSelectVideoTrackIndex);
                        localMediaInfo = new LocalMediaInfo();
                        try {
                            int integer = trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : 0;
                            if (integer != 90 && integer != 270) {
                                localMediaInfo.mediaWidth = trackFormat.getInteger("width");
                                localMediaInfo.mediaHeight = trackFormat.getInteger("height");
                            } else {
                                localMediaInfo.mediaWidth = trackFormat.getInteger("height");
                                localMediaInfo.mediaHeight = trackFormat.getInteger("width");
                            }
                            localMediaInfo.mDuration = Math.round(trackFormat.getLong("durationUs") / 1000.0d);
                            localMediaInfo.path = file.getAbsolutePath();
                            localMediaInfo.fileSize = file.length();
                        } catch (IOException e17) {
                            e = e17;
                            QLog.w(VideoJsPlugin.TAG, 1, "handleVideoResult: ", e);
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
                    }
                } catch (IOException e18) {
                    e = e18;
                    localMediaInfo = null;
                }
            } catch (IOException e19) {
                e = e19;
                r46 = 0;
                localMediaInfo = r46;
                QLog.w(VideoJsPlugin.TAG, 1, "handleVideoResult: ", e);
                if (fileInputStream != null) {
                }
            } catch (Throwable th6) {
                th = th6;
                mediaExtractor = null;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                if (mediaExtractor == null) {
                    mediaExtractor.release();
                    throw th;
                }
                throw th;
            }
            r46.release();
            if (localMediaInfo == null) {
                C(this.f347589b, "chooseVideo", null, "");
            } else if (z16) {
                K(localMediaInfo, true);
            } else {
                I(((IMiniAppFileManager) this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(localMediaInfo.path), localMediaInfo.fileSize, localMediaInfo);
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private static void F() {
        if (f347586o) {
            return;
        }
        int loadAVCodecSo = VideoEnvironment.loadAVCodecSo();
        QLog.i(VideoJsPlugin.TAG, 1, "loadFFmpeg: " + loadAVCodecSo);
        if (loadAVCodecSo == 0) {
            QLog.i(VideoJsPlugin.TAG, 1, "loadFFmpeg: is already load");
            f347586o = true;
        } else if (!f347587p.compareAndSet(false, true)) {
            QLog.i(VideoJsPlugin.TAG, 1, "loadFFmpeg: is downloading already");
        } else {
            f347584m.execute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.1

                /* renamed from: com.tencent.qqmini.proxyimpl.VideoJsProxyImpl$1$a */
                /* loaded from: classes34.dex */
                class a implements DownloadResultCallback {
                    a() {
                    }

                    @Override // com.tencent.qzonehub.api.DownloadResultCallback
                    public void callback(int i3, Bundle bundle) {
                        if (i3 == 0) {
                            QLog.i(VideoJsPlugin.TAG, 1, "callback: load ok " + i3);
                            VideoJsProxyImpl.f347586o = VideoEnvironment.loadAVCodecSo() == 0;
                        } else {
                            QLog.w(VideoJsPlugin.TAG, 1, "callback: load failed " + i3);
                        }
                        VideoJsProxyImpl.f347587p.compareAndSet(true, false);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ResultReceiver receiverForSending = ((IQzoneVideoSoDownloadModule) QRoute.api(IQzoneVideoSoDownloadModule.class)).getReceiverForSending(new a());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("key_download_result_receiver", receiverForSending);
                    EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneVideoSoDownloadModule", "action_download_avcodec", bundle);
                    if (callServer != null && callServer.code == 0) {
                        QLog.i(VideoJsPlugin.TAG, 1, "loadFFmpeg: start");
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("loadFFmpeg: failed ");
                    sb5.append(callServer == null ? -1 : callServer.code);
                    QLog.w(VideoJsPlugin.TAG, 1, sb5.toString());
                }
            });
        }
    }

    private void H(Activity activity) {
        WeakReference<Activity> weakReference = this.f347588a;
        if (weakReference == null) {
            G(activity);
            return;
        }
        Activity activity2 = weakReference.get();
        if (activity2 == null || activity2 == activity) {
            return;
        }
        G(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(final LocalMediaInfo localMediaInfo, final boolean z16) {
        final String substring;
        String str;
        try {
            int lastIndexOf = localMediaInfo.path.lastIndexOf(".");
            if (lastIndexOf < 0) {
                substring = "";
            } else {
                substring = localMediaInfo.path.substring(lastIndexOf + 1);
            }
            if (localMediaInfo.path.contains(" ")) {
                f347585n.execute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.7
                    @Override // java.lang.Runnable
                    public void run() {
                        QZLog.i(VideoJsPlugin.TAG, 1, "start copy from " + localMediaInfo.path);
                        String tmpPath = ((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getTmpPath(substring);
                        if (tmpPath.contains(" ")) {
                            QLog.w(VideoJsPlugin.TAG, 1, "wrong copy path " + tmpPath);
                            String wxFilePath = ((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(localMediaInfo.path);
                            VideoJsProxyImpl videoJsProxyImpl = VideoJsProxyImpl.this;
                            LocalMediaInfo localMediaInfo2 = localMediaInfo;
                            videoJsProxyImpl.I(wxFilePath, localMediaInfo2.fileSize, localMediaInfo2);
                            return;
                        }
                        File file = new File(tmpPath);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (FileUtils.copyFile(new File(localMediaInfo.path), file)) {
                            LocalMediaInfo localMediaInfo3 = localMediaInfo;
                            localMediaInfo3.path = tmpPath;
                            VideoJsProxyImpl.this.K(localMediaInfo3, z16);
                        } else {
                            QLog.w(VideoJsPlugin.TAG, 1, "copy file failed");
                            String wxFilePath2 = ((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(localMediaInfo.path);
                            VideoJsProxyImpl videoJsProxyImpl2 = VideoJsProxyImpl.this;
                            LocalMediaInfo localMediaInfo4 = localMediaInfo;
                            videoJsProxyImpl2.I(wxFilePath2, localMediaInfo4.fileSize, localMediaInfo4);
                        }
                    }
                });
                return;
            }
            String tmpPath = ((IMiniAppFileManager) this.f347592e.getManager(IMiniAppFileManager.class)).getTmpPath(substring);
            File file = new File(tmpPath);
            if (file.exists()) {
                file.delete();
            }
            QLog.i(VideoJsPlugin.TAG, 2, "startCompress: " + localMediaInfo.orientation);
            int i3 = (localMediaInfo.mediaWidth > 3000 || localMediaInfo.mediaHeight > 3000) ? 4 : 2;
            int i16 = localMediaInfo.mediaHeight / i3;
            if (z16) {
                str = "-i " + localMediaInfo.path + " -r 20 -y -vf scale=-1:" + i16 + " " + this.f347596i + " " + tmpPath;
            } else if (VideoEnvironment.isAvcodecNewVersion()) {
                str = "-i " + localMediaInfo.path + " -r 20 -y -c:v libo264rt -preset ultrafast " + tmpPath;
            } else {
                str = "-i " + localMediaInfo.path + " -r 20 -y -c:v libx264 -preset ultrafast " + tmpPath;
            }
            u(str, tmpPath, localMediaInfo, i3);
        } catch (Exception e16) {
            QLog.e(VideoJsPlugin.TAG, 1, "startCompress=e=" + e16.getMessage());
        }
    }

    private void L() {
        if (QLog.isColorLevel()) {
            QLog.d(VideoJsPlugin.TAG, 2, "unregisterAvatarReceiver");
        }
        try {
            WeakReference<Activity> weakReference = this.f347588a;
            if (weakReference != null) {
                weakReference.get().unregisterReceiver(this.f347597j);
            }
        } catch (Throwable th5) {
            QLog.e(VideoJsPlugin.TAG, 1, "unregisterReceiver exception.", th5);
        }
    }

    private File createVideoFile(Context context) {
        try {
            return File.createTempFile("MP4_" + System.currentTimeMillis() + "_", ".mp4", context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        } catch (Throwable th5) {
            QLog.e(VideoJsPlugin.TAG, 1, "createVideoFile: ", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getThumbnailBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ShortVideoUtils.getVideoThumbnail(null, ((IMiniAppFileManager) this.f347592e.getManager(IMiniAppFileManager.class)).getAbsolutePath(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading(String str) {
        QLog.i(VideoJsPlugin.TAG, 1, "showLoading " + str);
        VideoJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.showLoading(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Activity activity, int i3, boolean z16, boolean z17) {
        w(activity, i3, z16, z17);
    }

    private void w(Activity activity, int i3, boolean z16, boolean z17) {
        File createVideoFile;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(activity.getPackageManager()) == null || (createVideoFile = createVideoFile(activity)) == null) {
            return;
        }
        IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        activityResultManager.addActivityResultListener(new a(createVideoFile, activityResultManager, z16));
        intent.putExtra("output", FileProvider7Helper.getUriForFile(activity, createVideoFile));
        if (i3 < 1 || i3 > 60000) {
            i3 = 60000;
        }
        intent.putExtra("android.intent.extra.durationLimit", i3);
        if (z17) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        }
        intent.putExtra("big_brother_source_key", "biz_src_miniapp");
        activity.startActivityForResult(intent, 2);
    }

    private void x(Activity activity, long j3, boolean z16, int i3) {
        IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        activityResultManager.addActivityResultListener(new c(activityResultManager));
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
    public void z(String str, long j3, LocalMediaInfo localMediaInfo, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tempFilePath", str);
            jSONObject.put("thumbTempFilePath", localMediaInfo.thumbnailPath);
            jSONObject.put("duration", Math.round((float) (localMediaInfo.mDuration / 1000)));
            jSONObject.put("size", j3);
            jSONObject.put("height", localMediaInfo.mediaHeight);
            jSONObject.put("width", localMediaInfo.mediaWidth);
            jSONObject.put("__plugin_ready__", new File(FFmpegFileUtils.getFFmpeg(BaseApplication.getContext())).exists());
            D(i3, "chooseVideo", jSONObject);
        } catch (JSONException e16) {
            e16.printStackTrace();
            C(i3, "chooseVideo", null, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x01f8 A[Catch: JSONException -> 0x02b7, TryCatch #0 {JSONException -> 0x02b7, blocks: (B:3:0x003d, B:6:0x0060, B:8:0x007c, B:12:0x0082, B:14:0x0088, B:16:0x0096, B:19:0x009e, B:22:0x00bd, B:25:0x00c2, B:27:0x00ca, B:28:0x00e7, B:30:0x00f2, B:32:0x0103, B:34:0x0110, B:35:0x0117, B:36:0x011e, B:38:0x0128, B:40:0x0140, B:43:0x0151, B:45:0x0157, B:49:0x0165, B:47:0x0184, B:54:0x018d, B:58:0x0195, B:61:0x01a1, B:63:0x01ab, B:66:0x01b1, B:69:0x01cf, B:72:0x01d3, B:75:0x01dc, B:78:0x01f2, B:80:0x01f8, B:81:0x0215, B:83:0x0224, B:84:0x01e9, B:88:0x0146, B:89:0x0231, B:91:0x023a, B:93:0x0247, B:94:0x024f, B:96:0x0276, B:98:0x027e, B:99:0x0286, B:101:0x02aa, B:102:0x02af), top: B:2:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0224 A[Catch: JSONException -> 0x02b7, TryCatch #0 {JSONException -> 0x02b7, blocks: (B:3:0x003d, B:6:0x0060, B:8:0x007c, B:12:0x0082, B:14:0x0088, B:16:0x0096, B:19:0x009e, B:22:0x00bd, B:25:0x00c2, B:27:0x00ca, B:28:0x00e7, B:30:0x00f2, B:32:0x0103, B:34:0x0110, B:35:0x0117, B:36:0x011e, B:38:0x0128, B:40:0x0140, B:43:0x0151, B:45:0x0157, B:49:0x0165, B:47:0x0184, B:54:0x018d, B:58:0x0195, B:61:0x01a1, B:63:0x01ab, B:66:0x01b1, B:69:0x01cf, B:72:0x01d3, B:75:0x01dc, B:78:0x01f2, B:80:0x01f8, B:81:0x0215, B:83:0x0224, B:84:0x01e9, B:88:0x0146, B:89:0x0231, B:91:0x023a, B:93:0x0247, B:94:0x024f, B:96:0x0276, B:98:0x027e, B:99:0x0286, B:101:0x02aa, B:102:0x02af), top: B:2:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String A(final Activity activity, String str, String str2, int i3) {
        int i16;
        QLog.d(VideoJsPlugin.TAG, 2, "handleNativeRequest event=" + str + ",jsonParams=" + str2 + ",callbackId=" + i3);
        F();
        this.f347589b = i3;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String str3 = "camera";
            if ("chooseVideo".equals(str)) {
                H(activity);
                JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
                final boolean optBoolean = jSONObject.optBoolean("compressed");
                final boolean equals = jSONObject.optString("camera").equals("front");
                if (optJSONArray.length() == 0) {
                    C(i3, str, null, "fail sourceType error");
                    return "";
                }
                int i17 = 0;
                while (i17 < optJSONArray.length()) {
                    Object opt = optJSONArray.opt(i17);
                    String str4 = str3;
                    if (!opt.equals(this.f347590c) && !opt.equals(this.f347591d)) {
                        QLog.e(VideoJsPlugin.TAG, 1, "API_CHOOSE_VIDEO sourceType error. " + optJSONArray.opt(i17));
                        C(i3, str, null, "fail sourceType error");
                        return "";
                    }
                    i17++;
                    str3 = str4;
                }
                String str5 = str3;
                if (QLog.isColorLevel()) {
                    QLog.d(VideoJsPlugin.TAG, 2, "sourceType: " + optJSONArray + " length: " + optJSONArray.length());
                }
                final int optInt = jSONObject.optInt("maxDuration");
                if (optJSONArray.length() == 2) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.2

                        /* renamed from: com.tencent.qqmini.proxyimpl.VideoJsProxyImpl$2$a */
                        /* loaded from: classes34.dex */
                        class a implements DialogInterface.OnClickListener {
                            a() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                VideoJsProxyImpl.this.v(activity, optInt, optBoolean, equals);
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                            }
                        }

                        /* renamed from: com.tencent.qqmini.proxyimpl.VideoJsProxyImpl$2$b */
                        /* loaded from: classes34.dex */
                        class b implements DialogInterface.OnClickListener {
                            b() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                VideoJsProxyImpl.this.y(activity, optInt, optBoolean);
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
                } else if (str5.equals(optJSONArray.optString(0))) {
                    v(activity, optInt, optBoolean, equals);
                } else {
                    y(activity, optInt, optBoolean);
                }
            } else if ("makeMedia".equals(str)) {
                H(activity);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("sourceType");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("mediaType");
                boolean equals2 = jSONObject.optString("camera").equals("front");
                if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                    optJSONArray2 = new JSONArray();
                    optJSONArray2.mo162put(this.f347591d);
                }
                int i18 = 0;
                while (i18 < optJSONArray2.length()) {
                    boolean z16 = equals2;
                    if (!optJSONArray2.opt(i18).equals(this.f347591d)) {
                        QLog.e(VideoJsPlugin.TAG, 1, "API_MAKE_MEDIA sourceType error. " + optJSONArray2.opt(i18));
                        C(i3, str, null, "fail sourceType error");
                        return "";
                    }
                    i18++;
                    equals2 = z16;
                }
                boolean z17 = equals2;
                if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                    for (int i19 = 0; i19 < optJSONArray3.length(); i19++) {
                        Object opt2 = optJSONArray3.opt(i19);
                        if (!opt2.equals("image") && !opt2.equals("video")) {
                            QLog.e(VideoJsPlugin.TAG, 1, "API_CHOOSE_MEDIA mediaType error. " + opt2);
                            C(i3, str, null, "fail mediaType error");
                            return "";
                        }
                    }
                    if (optJSONArray3.length() != 2) {
                        Object opt3 = optJSONArray3.opt(0);
                        if (opt3.equals("image")) {
                            i16 = 1;
                        } else if (opt3.equals("video")) {
                            i16 = 2;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(VideoJsPlugin.TAG, 2, "sourceType: " + optJSONArray2 + " length: " + optJSONArray2.length());
                        }
                        int optInt2 = jSONObject.optInt("maxDuration");
                        if ("camera".equals(optJSONArray2.optString(0))) {
                            x(activity, optInt2, z17, i16);
                        }
                    }
                }
                i16 = 0;
                if (QLog.isColorLevel()) {
                }
                int optInt22 = jSONObject.optInt("maxDuration");
                if ("camera".equals(optJSONArray2.optString(0))) {
                }
            } else if ("saveVideoToPhotosAlbum".equals(str)) {
                String optString = jSONObject.optString("filePath");
                if (StringUtil.isEmpty(optString)) {
                    C(i3, str, null, "fail file not exists");
                } else {
                    String absolutePath = ((IMiniAppFileManager) this.f347592e.getManager(IMiniAppFileManager.class)).getAbsolutePath(optString);
                    IPermissionManagerProxy iPermissionManagerProxy = (IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class);
                    Activity attachActivity = this.f347592e.getAttachActivity();
                    File file = new File(absolutePath);
                    if (Build.VERSION.SDK_INT < 29) {
                        Permissions permissions = Permissions.WRITE_EXTERNAL_STORAGE;
                        if (!iPermissionManagerProxy.isPermissionGranted(attachActivity, permissions)) {
                            iPermissionManagerProxy.requestForPermission(attachActivity, permissions, new b(file, i3, str));
                        }
                    }
                    if (com.tencent.qqmini.sdk.core.utils.FileUtils.saveToSharedStorageCompat(this.f347592e.getContext(), file, UUID.randomUUID() + ".mp4", FileUtils.MediaType.VIDEO)) {
                        D(i3, str, null);
                    } else {
                        C(i3, str, null, "fail filePath invalid");
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            C(i3, str, null, "");
        }
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void chooseVideo(Activity activity, String str, String str2, int i3) {
        A(activity, str, str2, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void create(IMiniAppContext iMiniAppContext) {
        this.f347592e = iMiniAppContext;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void destroy() {
        L();
        super.destroy();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void makeMedia(Activity activity, String str, String str2, int i3) {
        A(activity, str, str2, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy
    public void saveVideoToPhotosAlbum(Activity activity, String str, String str2, int i3) {
        A(activity, str, str2, i3);
    }

    private void G(Activity activity) {
        QLog.d(VideoJsPlugin.TAG, 2, "registerAvatarReceiver");
        this.f347588a = new WeakReference<>(activity);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("get_video_info");
        activity.registerReceiver(this.f347597j, intentFilter);
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
    public boolean J(Bitmap bitmap, LocalMediaInfo localMediaInfo) {
        BufferedOutputStream bufferedOutputStream;
        boolean z16 = false;
        if (bitmap == null) {
            QLog.w(VideoJsPlugin.TAG, 2, "saveThumbnail bitmap is null");
            return false;
        }
        if (localMediaInfo == null) {
            QLog.w(VideoJsPlugin.TAG, 2, "saveThumbnail LocalMediaInfo is null");
            return false;
        }
        String tmpPath = ((IMiniAppFileManager) this.f347592e.getManager(IMiniAppFileManager.class)).getTmpPath("png");
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
                    localMediaInfo.thumbnailPath = ((IMiniAppFileManager) this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(tmpPath);
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
                            QLog.w(VideoJsPlugin.TAG, 2, "saveThumbnail exp", e);
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
            QLog.i(VideoJsPlugin.TAG, 2, "saveThumbnail " + tmpPath);
        }
        return z16;
    }

    public static int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(VideoJsPlugin.TAG, 2, "format for track " + i3 + " is " + mediaExtractor.getTrackFormat(i3).getString("mime"));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        QLog.i(VideoJsPlugin.TAG, 1, UIJsPlugin.EVENT_HIDE_LOADING);
        VideoJsProxy.Bridge bridge = this.mBridge;
        if (bridge != null) {
            bridge.hideLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Activity activity, int i3, boolean z16) {
        this.f347593f = true;
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 4);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationMiniApp.H);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationMiniApp.f184372j);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationMiniApp.H);
        activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 2);
        activityURIRequest.extra().putString(PeakConstants.DEST_BROADCAST_ACTION_NAME, "get_video_info");
        activityURIRequest.extra().putBoolean(PeakConstants.SHOW_MAGIC_USE_PASTER, false);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        activityURIRequest.extra().putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, this.f347594g);
        activityURIRequest.extra().putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, this.f347595h);
        if (z16) {
            activityURIRequest.extra().putString(PeakConstants.DEST_OTHER_FLAG, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS);
        }
        activityURIRequest.extra().putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_PREVIEW_VIDEO, false);
        QRoute.startUri(activityURIRequest);
        QAlbumUtil.anim(activity, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final String str, final long j3, final LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            B(this.f347589b, "chooseVideo", null);
        } else if (!TextUtils.isEmpty(localMediaInfo.thumbnailPath)) {
            z(str, j3, localMediaInfo, this.f347589b);
        } else {
            final int i3 = this.f347589b;
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoJsProxyImpl.this.showLoading("\u6b63\u5728\u83b7\u53d6\u89c6\u9891\u5c01\u9762\uff0c\u8bf7\u7a0d\u5019...");
                    VideoJsProxyImpl videoJsProxyImpl = VideoJsProxyImpl.this;
                    QLog.d(VideoJsPlugin.TAG, 2, "saveThumbnail : " + videoJsProxyImpl.J(videoJsProxyImpl.getThumbnailBitmap(str), localMediaInfo));
                    VideoJsProxyImpl.this.hideLoading();
                    VideoJsProxyImpl.this.z(str, j3, localMediaInfo, i3);
                }
            });
        }
    }

    private void u(String str, String str2, LocalMediaInfo localMediaInfo, int i3) {
        if (this.f347598k == null) {
            this.f347598k = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
        }
        showLoading(HardCodeUtil.qqStr(R.string.v4w));
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = localMediaInfo.mDuration;
        QLog.i(VideoJsPlugin.TAG, 2, "execCommand: " + str + " " + currentTimeMillis);
        try {
            this.f347598k.execute(str.split(" "), new e(currentTimeMillis, str, localMediaInfo, i3, str2, j3));
        } catch (Exception e16) {
            QLog.w(VideoJsPlugin.TAG, 1, "execCommand: failed " + str, e16);
            hideLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f347613a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347614b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f347615c;

        a(File file, IActivityResultManager iActivityResultManager, boolean z16) {
            this.f347613a = file;
            this.f347614b = iActivityResultManager;
            this.f347615c = z16;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            if (i3 != 2) {
                return false;
            }
            if (i16 == -1) {
                VideoJsProxyImpl.this.E(this.f347613a, this.f347615c);
                this.f347614b.removeActivityResultListener(this);
                return true;
            }
            this.f347613a.deleteOnExit();
            VideoJsProxyImpl videoJsProxyImpl = VideoJsProxyImpl.this;
            videoJsProxyImpl.B(videoJsProxyImpl.f347589b, "chooseVideo", null);
            this.f347614b.removeActivityResultListener(this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f347621a;

        c(IActivityResultManager iActivityResultManager) {
            this.f347621a = iActivityResultManager;
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
                VideoJsProxyImpl videoJsProxyImpl = VideoJsProxyImpl.this;
                videoJsProxyImpl.B(videoJsProxyImpl.f347589b, "makeMedia", null);
                this.f347621a.removeActivityResultListener(this);
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
                        str3 = VideoJsPlugin.TAG;
                        try {
                            int i18 = publishParam.D;
                            String str5 = publishParam.f69067e;
                            try {
                                jSONObject.put("tempFilePath", ((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(str4));
                                jSONObject.put("type", "video");
                                jSONObject.put("size", length);
                                jSONObject.put("duration", j3);
                                jSONObject.put("width", i17);
                                jSONObject.put("height", i18);
                                jSONObject.put("thumbTempFilePath", ((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(str5));
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("tempFile", jSONObject);
                                VideoJsProxyImpl videoJsProxyImpl2 = VideoJsProxyImpl.this;
                                str = "makeMedia";
                                try {
                                    videoJsProxyImpl2.D(videoJsProxyImpl2.f347589b, str, jSONObject2);
                                } catch (Exception e16) {
                                    e = e16;
                                    QLog.e(str3, 1, "camera for video parse failed", e);
                                    VideoJsProxyImpl videoJsProxyImpl3 = VideoJsProxyImpl.this;
                                    videoJsProxyImpl3.C(videoJsProxyImpl3.f347589b, str, null, str2 + e.getMessage());
                                    this.f347621a.removeActivityResultListener(this);
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
                        str3 = VideoJsPlugin.TAG;
                        QLog.e(str3, 1, "camera for video parse failed", e);
                        VideoJsProxyImpl videoJsProxyImpl32 = VideoJsProxyImpl.this;
                        videoJsProxyImpl32.C(videoJsProxyImpl32.f347589b, str, null, str2 + e.getMessage());
                        this.f347621a.removeActivityResultListener(this);
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
                    jSONObject3.put("tempFilePath", ((IMiniAppFileManager) VideoJsProxyImpl.this.f347592e.getManager(IMiniAppFileManager.class)).getWxFilePath(stringExtra));
                    jSONObject3.put("type", "image");
                    jSONObject3.put("size", length2);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("tempFile", jSONObject3);
                    VideoJsProxyImpl videoJsProxyImpl4 = VideoJsProxyImpl.this;
                    videoJsProxyImpl4.D(videoJsProxyImpl4.f347589b, "makeMedia", jSONObject4);
                } catch (Exception e27) {
                    QLog.e(VideoJsPlugin.TAG, 1, "camera for image parse failed", e27);
                    VideoJsProxyImpl videoJsProxyImpl5 = VideoJsProxyImpl.this;
                    videoJsProxyImpl5.C(videoJsProxyImpl5.f347589b, "makeMedia", null, "chooseMedia exception:" + e27.getMessage());
                }
            }
            this.f347621a.removeActivityResultListener(this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements RequestPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f347617a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f347618b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f347619c;

        b(File file, int i3, String str) {
            this.f347617a = file;
            this.f347618b = i3;
            this.f347619c = str;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onFail() {
            VideoJsProxyImpl.this.C(this.f347618b, this.f347619c, null, "fail no permission");
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onSuccess() {
            if (com.tencent.qqmini.sdk.core.utils.FileUtils.saveToSharedStorageCompat(VideoJsProxyImpl.this.f347592e.getContext(), this.f347617a, UUID.randomUUID() + ".mp4", FileUtils.MediaType.VIDEO)) {
                VideoJsProxyImpl.this.D(this.f347618b, this.f347619c, null);
            } else {
                VideoJsProxyImpl.this.C(this.f347618b, this.f347619c, null, "fail to save file");
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onPartialGrant() {
        }
    }
}
