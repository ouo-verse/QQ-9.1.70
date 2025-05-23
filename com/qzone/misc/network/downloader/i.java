package com.qzone.misc.network.downloader;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.activities.QzoneDialogActivity;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.reborn.QZoneDownloadSharedPreferencesProvider;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class i {

    /* renamed from: l, reason: collision with root package name */
    private static final Object f48412l = new Object();

    /* renamed from: m, reason: collision with root package name */
    private static i f48413m = null;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f48414n = true;

    /* renamed from: a, reason: collision with root package name */
    private Downloader f48415a;

    /* renamed from: b, reason: collision with root package name */
    private List<HashMap<String, String>> f48416b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, f> f48417c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private List<g> f48418d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<String> f48419e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f48420f = -1;

    /* renamed from: g, reason: collision with root package name */
    private Handler f48421g = new a(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    private NetworkState.NetworkStateListener f48422h = new b();

    /* renamed from: i, reason: collision with root package name */
    private DialogInterface.OnClickListener f48423i = new c();

    /* renamed from: j, reason: collision with root package name */
    private d f48424j = new d();

    /* renamed from: k, reason: collision with root package name */
    private f f48425k = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DownloadResult downloadResult;
            String str;
            int i3 = message.what;
            if (i3 == 1) {
                if (i.this.f48425k != null) {
                    Object obj = message.obj;
                    if (obj == null || !(obj instanceof DownloadResult)) {
                        downloadResult = null;
                    } else {
                        downloadResult = (DownloadResult) obj;
                        QZLog.i("[PhotoAlbum]downloadPhotoAndVideo", "MSG_DOWNLOAD_ERROR result.getUrl():" + downloadResult.getUrl());
                    }
                    if (downloadResult != null) {
                        i.this.f48425k.A(downloadResult.getUrl(), downloadResult.getStatus().getFailReason(), downloadResult.getStatus().getErrorMessage());
                    } else {
                        i.this.f48425k.A("", 1, "");
                    }
                    i.this.A();
                    return;
                }
                ToastUtil.o(R.string.gkh, 4);
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                String str2 = (String) message.obj;
                if (i.this.f48425k != null) {
                    i.this.f48425k.x(str2);
                }
                i.this.A();
                return;
            }
            String str3 = (String) message.obj;
            if (!TextUtils.isEmpty(str3)) {
                File file = new File(str3);
                if (file.exists() && file.isFile() && file.length() > 0) {
                    QZLog.i("VideoDownloaderManager", "MSG_DOWNLOAD_SUCCESS: add to media library, savedFilePath=" + str3);
                    BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                    if (i.this.f48425k != null) {
                        i.this.f48419e.add(str3);
                        if (i.this.f48419e.size() == i.this.f48420f) {
                            i.this.f48425k.y(i.this.f48419e);
                            i.this.A();
                            return;
                        }
                        return;
                    }
                    String str4 = AppConstants.SDCARD_ROOT;
                    int length = str3.contains(str4) ? str4.length() : 0;
                    int lastIndexOf = str3.lastIndexOf(File.separator);
                    if (lastIndexOf != -1) {
                        lastIndexOf++;
                    }
                    String substring = str3.substring(length, lastIndexOf);
                    if (!TextUtils.isEmpty(substring) && substring.contains(Environment.DIRECTORY_DCIM)) {
                        str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSaveToPhone", "\u89c6\u9891\u5df2\u4fdd\u5b58\u81f3\u624b\u673a\u76f8\u518c");
                    } else {
                        str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSaveToSDCard", "\u89c6\u9891\u5df2\u4fdd\u5b58\u81f3SD\u5361") + substring + l.a(R.string.v0h);
                    }
                    ToastUtil.s(str, 5);
                    return;
                }
                if (file.exists()) {
                    file.delete();
                }
                ToastUtil.o(R.string.gkh, 4);
                return;
            }
            ToastUtil.o(R.string.gkh, 4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i("VideoDownloaderManager", "mOnCancelDownloadClickListener click");
            i.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private String f48429d;

        /* renamed from: e, reason: collision with root package name */
        private String f48430e;

        /* renamed from: f, reason: collision with root package name */
        f f48431f;

        d() {
        }

        public void a(String str, String str2, f fVar) {
            this.f48429d = str;
            this.f48430e = str2;
            this.f48431f = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i("VideoDownloaderManager", "OnContinueDownloadClickListener click");
            i.this.z(this.f48429d, this.f48430e, this.f48431f);
            i.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e extends g {

        /* renamed from: e, reason: collision with root package name */
        f f48433e;

        public e(String str, String str2, f fVar) {
            super(str, str2);
            this.f48433e = fVar;
        }

        private void b(String str) {
            if (!TextUtils.isEmpty(this.f48436b)) {
                File file = new File(this.f48436b);
                if (file.exists() && file.isFile() && file.length() > 0) {
                    QZLog.i("[PhotoAlbum]downloadPhotoAndVideo", "MSG_DOWNLOAD_SUCCESS: add to media library, mSavedFilePath=" + this.f48436b);
                    BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                    ArrayList<String> arrayList = new ArrayList<>(1);
                    arrayList.add(str);
                    f fVar = this.f48433e;
                    if (fVar != null) {
                        fVar.z(this.f48436b);
                        this.f48433e.y(arrayList);
                        return;
                    }
                    return;
                }
                this.f48433e.A(str, 2, "file error");
                return;
            }
            this.f48433e.A(str, 2, "file path is empty");
        }

        @Override // com.qzone.misc.network.downloader.i.g, com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo", "OneVideoDownloadListener onDownloadCanceled: url=" + str);
            this.f48433e.x(str);
            i.this.t(this);
        }

        @Override // com.qzone.misc.network.downloader.i.g, com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            QZLog.e("[PhotoAlbum]downloadPhotoAndVideo", "OneVideoDownloadListener onDownloadFailed: url=" + str + "\nexception2Code:" + downloadResult.getStatus().exception2Code);
            this.f48433e.A(str, downloadResult.getStatus().getFailReason(), downloadResult.getStatus().getErrorMessage());
            i.this.t(this);
        }

        @Override // com.qzone.misc.network.downloader.i.g, com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            if (f16 - this.f48437c > 0.3f) {
                this.f48437c = f16;
                QZLog.i("VideoDownloaderManager", "OneVideoDownloadListener onDownloadProgress: url=" + str + ", totalSize=" + j3 + ", progress=" + f16);
            }
        }

        @Override // com.qzone.misc.network.downloader.i.g, com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            QZLog.i("[PhotoAlbum]downloadPhotoAndVideo", "OneVideoDownloadListener onDownloadSucceed: url=" + str);
            b(str);
            i.this.t(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface f {
        void A(String str, int i3, String str2);

        void x(String str);

        void y(ArrayList<String> arrayList);

        void z(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        protected String f48435a;

        /* renamed from: b, reason: collision with root package name */
        protected String f48436b;

        /* renamed from: c, reason: collision with root package name */
        protected float f48437c = 0.0f;

        public g(String str, String str2) {
            this.f48435a = str;
            this.f48436b = str2;
        }

        public String a() {
            return this.f48435a;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            QZLog.i("VideoDownloaderManager", "onDownloadCanceled: url=" + str);
            Message.obtain(i.this.f48421g, 3, str).sendToTarget();
            i.this.t(this);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            QZLog.e("VideoDownloaderManager", "onDownloadFailed: url=" + str);
            Message.obtain(i.this.f48421g, 1, downloadResult).sendToTarget();
            i.this.t(this);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            if (f16 - this.f48437c > 0.3f) {
                this.f48437c = f16;
                QZLog.i("VideoDownloaderManager", "onDownloadProgress: url=" + str + ", totalSize=" + j3 + ", progress=" + f16);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            QZLog.i("VideoDownloaderManager", "onDownloadSucceed: url=" + str);
            Message.obtain(i.this.f48421g, 2, this.f48436b).sendToTarget();
            i.this.t(this);
        }
    }

    i() {
        DownloaderFactory.getInstance(BaseApplication.getContext());
        DownloaderFactory.init(new com.qzone.misc.network.downloader.f(), new com.qzone.misc.network.downloader.c(), QZoneDownloadSharedPreferencesProvider.INSTANCE);
        Downloader createDownloader = DownloaderFactory.createDownloader("VideoFile");
        this.f48415a = createDownloader;
        if (createDownloader == null) {
            return;
        }
        if (f48414n) {
            createDownloader.setNetworkFlowStatistics(new com.qzone.misc.network.downloader.g());
        }
        this.f48415a.enableResumeTransfer();
        this.f48415a.setPortConfigStrategy(new QzoneDownloadPortConfig());
        this.f48415a.setDirectIPConfigStrategy(new h());
        this.f48415a.setBackupIPConfigStrategy(new com.qzone.misc.network.downloader.d());
        this.f48415a.setKeepAliveStrategy(new com.qzone.misc.network.downloader.e());
        NetworkState.addListener(this.f48422h);
    }

    private void B() {
        u5.b.v0("VideoDownloaderManager_date_key", v());
    }

    private boolean C() {
        return !v().equals(x());
    }

    private g n(String str, String str2, f fVar) {
        g gVar;
        if (TextUtils.isEmpty(str2)) {
            str2 = y();
        }
        if (fVar != null) {
            gVar = new e(str, str2, fVar);
        } else {
            gVar = new g(str, str2);
        }
        QZLog.i("VideoDownloaderManager", "doDownload: url=" + str + ", saveTo=" + str2);
        DownloadRequest downloadRequest = new DownloadRequest(str, new String[]{str2}, false, gVar);
        downloadRequest.mode = Downloader.DownloadMode.FastMode;
        if (this.f48415a.download(downloadRequest, true)) {
            return gVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(g gVar) {
        synchronized (f48412l) {
            this.f48418d.remove(gVar);
            if (this.f48418d.size() < w()) {
                while (true) {
                    if (this.f48416b.isEmpty()) {
                        break;
                    }
                    HashMap<String, String> remove = this.f48416b.remove(0);
                    if (remove != null) {
                        String str = remove.get(AppConstants.Key.KEY_QZONE_VIDEO_URL);
                        g n3 = n(str, remove.get("videoPath"), this.f48417c.get(str));
                        if (n3 != null) {
                            this.f48418d.add(n3);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static i u() {
        if (f48413m == null) {
            synchronized (f48412l) {
                if (f48413m == null) {
                    f48413m = new i();
                }
            }
        }
        return f48413m;
    }

    private String v() {
        String valueOf;
        String valueOf2;
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(1);
        int i16 = calendar.get(2) + 1;
        int i17 = calendar.get(5);
        if (i16 < 10) {
            valueOf = "0" + i16;
        } else {
            valueOf = String.valueOf(i16);
        }
        if (i17 < 10) {
            valueOf2 = "0" + i17;
        } else {
            valueOf2 = String.valueOf(i17);
        }
        return "VideoDownloaderManager" + String.valueOf(i3) + valueOf + valueOf2;
    }

    private int w() {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MAX_DOWNLOADING_VIDEO_COUNT, 1);
        if (config < 1) {
            return 1;
        }
        return config;
    }

    private String x() {
        return u5.b.h0("VideoDownloaderManager_date_key", "");
    }

    private String y() {
        return VFSAssistantUtils.getSDKPrivatePath(PhotoUtils.getCameraPath(AppConstants.SDCARD_ROOT + "/Tencent/QQ_Video/", "QQ\u7a7a\u95f4\u89c6\u9891_", ".mp4"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(String str, String str2, f fVar) {
        synchronized (f48412l) {
            boolean z16 = true;
            if (this.f48418d.size() < w()) {
                g n3 = n(str, str2, fVar);
                if (n3 != null) {
                    this.f48418d.add(n3);
                }
                if (n3 == null) {
                    z16 = false;
                }
                return z16;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, str);
            hashMap.put("videoPath", str2);
            this.f48417c.put(str, fVar);
            this.f48416b.add(hashMap);
            return true;
        }
    }

    public void k() {
        QZLog.i("VideoDownloaderManager", "abortDownload");
        if (this.f48415a == null) {
            QZLog.e("VideoDownloaderManager", "abortDownload: downloader is null");
            return;
        }
        synchronized (f48412l) {
            this.f48416b.clear();
            this.f48417c.clear();
            for (g gVar : this.f48418d) {
                QZLog.i("VideoDownloaderManager", "abortDownload: url=" + gVar.a());
                this.f48415a.abort(gVar.a(), gVar);
            }
            this.f48418d.clear();
        }
    }

    public void m() {
        QZLog.i("VideoDownloaderManager", "cancelDownload");
        if (this.f48415a == null) {
            QZLog.e("VideoDownloaderManager", "cancelDownload: downloader is null");
            return;
        }
        synchronized (f48412l) {
            this.f48416b.clear();
            this.f48417c.clear();
            for (g gVar : this.f48418d) {
                QZLog.i("VideoDownloaderManager", "cancelDownload: url=" + gVar.a());
                this.f48415a.cancel(gVar.a(), gVar);
            }
            this.f48418d.clear();
        }
    }

    public boolean s(String str, String str2, f fVar, DialogInterface.OnClickListener onClickListener) {
        if (!NetworkUtils.isNetworkUrl(str)) {
            QZLog.e("VideoDownloaderManager", "download: not network url");
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastLocateVideo", "\u672c\u5730\u89c6\u9891\uff0c\u65e0\u9700\u4e0b\u8f7d"), 4);
            return false;
        }
        if (!NetworkState.isNetSupport()) {
            QZLog.e("VideoDownloaderManager", "download: no network");
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotConnect", "\u65e0\u6cd5\u8fde\u63a5\u5230\u7f51\u7edc\uff0c\u8bf7\u786e\u5b9a\u8fde\u63a5\u540e\u518d\u91cd\u8bd5"), 4);
            return false;
        }
        QZLog.i("VideoDownloaderManager", "download: url=" + str);
        if (TextUtils.isEmpty(str)) {
            QZLog.e("VideoDownloaderManager", "download: url is empty");
            return false;
        }
        if (this.f48415a == null) {
            QZLog.e("VideoDownloaderManager", "download: downloader is null");
            return false;
        }
        String o16 = QZoneVideoLoader.l().o(str);
        QZoneVideoLoader.l().f(str);
        long unCachedSize = VideoManager.getInstance().getUnCachedSize(str);
        QZLog.i("VideoDownloaderManager", "download: proxyUrl=" + o16 + ", remainSize: " + unCachedSize);
        if (!TextUtils.isEmpty(o16)) {
            str = o16;
        }
        if (!NetworkState.isWifiConn() && onClickListener != null) {
            QZLog.i("VideoDownloaderManager", "download: not wifi");
            if (C() && unCachedSize > 0) {
                QZLog.i("VideoDownloaderManager", "download: continue?");
                synchronized (f48412l) {
                    this.f48424j.a(str, str2, fVar);
                    QzoneDialogActivity.xh(null, onClickListener, this.f48424j, null);
                }
                return true;
            }
        }
        return z(str, str2, fVar);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements NetworkState.NetworkStateListener {
        b() {
        }

        @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
        public void onNetworkConnect(boolean z16) {
            if (z16 && NetworkState.isMobile()) {
                QZLog.i("VideoDownloaderManager", "onNetworkConnect: mobile connected");
                synchronized (i.f48412l) {
                    if (!i.this.f48418d.isEmpty()) {
                        QZLog.i("VideoDownloaderManager", "onNetworkConnect: cancel?");
                        QzoneDialogActivity.xh(null, i.this.f48423i, null, null);
                    }
                }
            }
        }
    }

    public void A() {
        this.f48420f = -1;
        this.f48419e.clear();
        this.f48425k = null;
    }

    public boolean q(String str) {
        return r(str, null, null);
    }

    public boolean r(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        return s(str, str2, null, onClickListener);
    }

    public void l(String str, f fVar, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            NetworkState.removeListener(this.f48422h);
        } else {
            NetworkState.addListener(this.f48422h);
        }
        if (s(str, null, fVar, onClickListener) || fVar == null) {
            return;
        }
        fVar.A(str, 1, "");
    }

    public void p(ArrayList<String> arrayList, f fVar, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            NetworkState.removeListener(this.f48422h);
        } else {
            NetworkState.addListener(this.f48422h);
        }
        this.f48420f = arrayList.size();
        this.f48425k = fVar;
        this.f48419e.clear();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (!r(arrayList.get(i3), null, onClickListener)) {
                if (fVar != null) {
                    fVar.A(arrayList.get(i3), 1, "");
                    return;
                }
                return;
            }
        }
    }
}
