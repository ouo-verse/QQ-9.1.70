package com.tencent.mobileqq.vas.novelspecies.impl;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.image.Utils;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.novelspecies.INovelSpaciesWidgetApi;
import com.tencent.mobileqq.vas.novelspecies.VasNovelSpeciesLarge;
import com.tencent.mobileqq.vas.novelspecies.VasNovelSpeciesMini;
import com.tencent.mobileqq.vas.novelspecies.data.WidgetPB$SsoGetWidgetNotifyInfoReq;
import com.tencent.mobileqq.vas.novelspecies.data.WidgetPB$SsoGetWidgetNotifyInfoRsp;
import com.tencent.mobileqq.vas.novelspecies.data.a;
import com.tencent.mobileqq.vas.novelspecies.impl.NovelSpaciesWidgetApiImpl;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001%\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0014\u0010\u0014\u001a\u00020\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/novelspecies/impl/NovelSpaciesWidgetApiImpl;", "Lcom/tencent/mobileqq/vas/novelspecies/INovelSpaciesWidgetApi;", "", "generateImageCacheDir", "Lcom/tencent/mobileqq/vas/novelspecies/data/a;", "data", "downloadFile", "", "url", "cacheData", "", "type", "handleImgDownload", "imgPath", "onImgDownloaded", "cacheAndSendUpdateBroadcast", "doSendUpdateBroadcast", "Ljava/lang/Class;", "clazz", "", "isWidgetAdded", "fetchAndCacheWidgetData", "widgetStoreData", "cacheWidgetInfoAndNotifyUpdate", "cacheWidgetInfo", "getWidgetCachedData", "isAddedWidget", "cleanImageCache", "cleanCachedData", "Ljava/io/File;", "mImageCacheDir", "Ljava/io/File;", "mWidgetCacheData", "Lcom/tencent/mobileqq/vas/novelspecies/data/a;", "Ljava/lang/Runnable;", "mUpdateRunnable", "Ljava/lang/Runnable;", "com/tencent/mobileqq/vas/novelspecies/impl/NovelSpaciesWidgetApiImpl$kuiklyReceiver$1", "kuiklyReceiver", "Lcom/tencent/mobileqq/vas/novelspecies/impl/NovelSpaciesWidgetApiImpl$kuiklyReceiver$1;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NovelSpaciesWidgetApiImpl implements INovelSpaciesWidgetApi {

    @NotNull
    public static final String ACTION_UPDATE_VAS_NOVEL_SPECIES = "tencent.notify.appwidget.VAS_NOVEL_SPECIES_UPDATE";

    @NotNull
    public static final String CMD = "trpc.qqva.freshelement_home.Widget.SsoGetWidgetNotifyInfo";

    @NotNull
    public static final String KUIKLY_EVENT_NAME = "vas_novel_species_widget_refresh";

    @NotNull
    public static final String MMKV_KEY_WIDGET_INFO = "novelSpaciesWidgetConfig";

    @NotNull
    public static final String TAG = "NovelSpaciesImpl";
    public static final long UPDATE_DELAY = 500;

    @NotNull
    public static final String WIDGET_DIR = "novelSpaciesWidgetImg";

    @NotNull
    private final NovelSpaciesWidgetApiImpl$kuiklyReceiver$1 kuiklyReceiver;

    @Nullable
    private File mImageCacheDir;

    @NotNull
    private final Runnable mUpdateRunnable = new Runnable() { // from class: c23.b
        @Override // java.lang.Runnable
        public final void run() {
            NovelSpaciesWidgetApiImpl.mUpdateRunnable$lambda$0(NovelSpaciesWidgetApiImpl.this);
        }
    };

    @Nullable
    private a mWidgetCacheData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/novelspecies/impl/NovelSpaciesWidgetApiImpl$b", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDone", "", "onStart", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f310096a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NovelSpaciesWidgetApiImpl f310097b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f310098c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f310099d;

        b(File file, NovelSpaciesWidgetApiImpl novelSpaciesWidgetApiImpl, a aVar, int i3) {
            this.f310096a = file;
            this.f310097b = novelSpaciesWidgetApiImpl;
            this.f310098c = aVar;
            this.f310099d = i3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(@NotNull g task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.onDone(task);
            if (3 == task.i()) {
                QLog.i(NovelSpaciesWidgetApiImpl.TAG, 1, "file path:" + this.f310096a.getAbsolutePath());
                NovelSpaciesWidgetApiImpl novelSpaciesWidgetApiImpl = this.f310097b;
                String absolutePath = this.f310096a.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "imgFile.absolutePath");
                novelSpaciesWidgetApiImpl.onImgDownloaded(absolutePath, this.f310098c, this.f310099d);
                return;
            }
            QLog.w(NovelSpaciesWidgetApiImpl.TAG, 1, "download img failed~ type:" + this.f310099d);
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(@NotNull g task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return super.onStart(task);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.vas.novelspecies.impl.NovelSpaciesWidgetApiImpl$kuiklyReceiver$1, android.content.BroadcastReceiver] */
    public NovelSpaciesWidgetApiImpl() {
        ?? r06 = new BroadcastReceiver() { // from class: com.tencent.mobileqq.vas.novelspecies.impl.NovelSpaciesWidgetApiImpl$kuiklyReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String a16 = l.a(intent);
                if (!TextUtils.isEmpty(a16) && Intrinsics.areEqual(NovelSpaciesWidgetApiImpl.KUIKLY_EVENT_NAME, a16)) {
                    QLog.d(NovelSpaciesWidgetApiImpl.TAG, 1, "[kuiklyReceiver] receive kuikly event refresh!");
                    NovelSpaciesWidgetApiImpl.this.fetchAndCacheWidgetData();
                }
            }
        };
        this.kuiklyReceiver = r06;
        generateImageCacheDir();
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        l.c(context, r06);
    }

    private final void cacheAndSendUpdateBroadcast() {
        if (!cacheWidgetInfo(this.mWidgetCacheData)) {
            QLog.i(TAG, 1, "[cacheAndSendUpdateBroadcast] cache widget info error");
            return;
        }
        QLog.i(TAG, 1, "[cacheAndSendUpdateBroadcast] start sending broadcast,process:" + MobileQQ.sMobileQQ.getQQProcessName());
        doSendUpdateBroadcast();
    }

    private final void doSendUpdateBroadcast() {
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        Intent intent = new Intent();
        intent.setAction(ACTION_UPDATE_VAS_NOVEL_SPECIES);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        applicationContext.sendBroadcast(intent);
        QLog.i(TAG, 1, "doSendUpdateBroadcast");
    }

    private final void downloadFile(a data) {
        if (!TextUtils.isEmpty(data.getLastWidgetData().getLargeBgUrl())) {
            handleImgDownload(data.getLastWidgetData().getLargeBgUrl(), data, 0);
        }
        if (!TextUtils.isEmpty(data.getLastWidgetData().getMiniBgUrl())) {
            handleImgDownload(data.getLastWidgetData().getMiniBgUrl(), data, 1);
        }
        if (!TextUtils.isEmpty(data.getLastWidgetData().getElementUrl())) {
            handleImgDownload(data.getLastWidgetData().getElementUrl(), data, 2);
        }
        if (!TextUtils.isEmpty(data.getDefaultWidgetData().getLargeBgUrl())) {
            handleImgDownload(data.getDefaultWidgetData().getLargeBgUrl(), data, 3);
        }
        if (!TextUtils.isEmpty(data.getDefaultWidgetData().getMiniBgUrl())) {
            handleImgDownload(data.getDefaultWidgetData().getMiniBgUrl(), data, 4);
        }
        if (!TextUtils.isEmpty(data.getDefaultWidgetData().getElementUrl())) {
            handleImgDownload(data.getDefaultWidgetData().getElementUrl(), data, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchAndCacheWidgetData$lambda$1(NovelSpaciesWidgetApiImpl this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            try {
                WidgetPB$SsoGetWidgetNotifyInfoRsp widgetPB$SsoGetWidgetNotifyInfoRsp = new WidgetPB$SsoGetWidgetNotifyInfoRsp();
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                widgetPB$SsoGetWidgetNotifyInfoRsp.mergeFrom((byte[]) obj);
                QLog.d(TAG, 2, "fetch success!");
                this$0.downloadFile(new a(widgetPB$SsoGetWidgetNotifyInfoRsp));
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "onUpdate mergeFrom bytes failed:" + e16);
            }
        }
    }

    private final void generateImageCacheDir() {
        File cacheDir;
        if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = MobileQQ.sMobileQQ.getCacheDir();
        }
        File file = new File(cacheDir, WIDGET_DIR);
        this.mImageCacheDir = file;
        Intrinsics.checkNotNull(file);
        if (file.exists()) {
            File file2 = this.mImageCacheDir;
            Intrinsics.checkNotNull(file2);
            if (file2.isDirectory()) {
                return;
            }
        }
        File file3 = this.mImageCacheDir;
        Intrinsics.checkNotNull(file3);
        file3.mkdirs();
    }

    private final void handleImgDownload(String url, a cacheData, int type) {
        if (!TextUtils.isEmpty(url) && cacheData != null) {
            String Crc64String = Utils.Crc64String(url);
            QLog.i(TAG, 1, "[handleImgDownload] fileName:" + Crc64String + ",url:" + url + ",type:" + type);
            File file = new File(this.mImageCacheDir, Crc64String);
            if (file.exists()) {
                QLog.i(TAG, 1, "file Exists~" + file.getAbsolutePath());
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "imgFile.absolutePath");
                onImgDownloaded(absolutePath, cacheData, type);
                return;
            }
            b bVar = new b(file, this, cacheData, type);
            g gVar = new g(url, file);
            h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
            if (downloader != null) {
                downloader.startDownload(gVar, bVar, null);
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "[handleImgDownload]] url is empty,type:" + type);
    }

    private final boolean isWidgetAdded(Class<?> clazz) {
        boolean z16;
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        int[] appWidgetIds = AppWidgetManager.getInstance(applicationContext).getAppWidgetIds(new ComponentName(applicationContext, clazz));
        if (appWidgetIds == null) {
            return false;
        }
        if (appWidgetIds.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mUpdateRunnable$lambda$0(NovelSpaciesWidgetApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cacheAndSendUpdateBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onImgDownloaded(String imgPath, a cacheData, int type) {
        try {
            QLog.d(TAG, 1, "[onImgDownloaded], type:" + type);
            if (type != 0) {
                if (type != 1) {
                    if (type != 2) {
                        if (type != 3) {
                            if (type != 4) {
                                if (type == 5) {
                                    cacheData.getDefaultWidgetData().i(imgPath);
                                }
                            } else {
                                cacheData.getDefaultWidgetData().k(imgPath);
                            }
                        } else {
                            cacheData.getDefaultWidgetData().j(imgPath);
                        }
                    } else {
                        cacheData.getLastWidgetData().i(imgPath);
                    }
                } else {
                    cacheData.getLastWidgetData().k(imgPath);
                }
            } else {
                cacheData.getLastWidgetData().j(imgPath);
            }
            cacheWidgetInfoAndNotifyUpdate(cacheData);
        } finally {
        }
    }

    public final synchronized boolean cacheWidgetInfo(@Nullable a data) {
        String json;
        if (data != null) {
            try {
                json = new Gson().toJson(data);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return false;
            }
        } else {
            json = "";
        }
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString(MMKV_KEY_WIDGET_INFO, json);
        return true;
    }

    public final synchronized void cacheWidgetInfoAndNotifyUpdate(@NotNull a widgetStoreData) {
        Intrinsics.checkNotNullParameter(widgetStoreData, "widgetStoreData");
        if (!isAddedWidget()) {
            QLog.i(TAG, 1, "[cacheWidgetInfoAndNotifyUpdate] not has widget");
            return;
        }
        this.mWidgetCacheData = widgetStoreData;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mUpdateRunnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mUpdateRunnable, 500L);
    }

    @Override // com.tencent.mobileqq.vas.novelspecies.INovelSpaciesWidgetApi
    public void cleanCachedData() {
        try {
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString(MMKV_KEY_WIDGET_INFO, "");
            QLog.d(TAG, 1, "cleanCachedData");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.vas.novelspecies.INovelSpaciesWidgetApi
    public void cleanImageCache() {
        try {
            File file = this.mImageCacheDir;
            Intrinsics.checkNotNull(file);
            if (file.exists()) {
                File file2 = this.mImageCacheDir;
                Intrinsics.checkNotNull(file2);
                FileUtils.deleteFilesInDirectory(file2.getAbsolutePath());
                QLog.d(TAG, 1, "cleanImageCache");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "clearCache error:", th5);
        }
    }

    @Override // com.tencent.mobileqq.vas.novelspecies.INovelSpaciesWidgetApi
    public void fetchAndCacheWidgetData() {
        if (!isAddedWidget()) {
            return;
        }
        try {
            IPbProtocol pbRequest = VasUtil.getService().getPbRequest();
            byte[] byteArray = new MessageMicro<WidgetPB$SsoGetWidgetNotifyInfoReq>() { // from class: com.tencent.mobileqq.vas.novelspecies.data.WidgetPB$SsoGetWidgetNotifyInfoReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"encrypted_uin"}, new Object[]{""}, WidgetPB$SsoGetWidgetNotifyInfoReq.class);
                public final PBStringField encrypted_uin = PBField.initString("");
            }.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "SsoGetWidgetNotifyInfoReq().toByteArray()");
            Charset forName = Charset.forName("ISO8859_1");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"ISO8859_1\")");
            pbRequest.request(CMD, new String(byteArray, forName), new BusinessObserver() { // from class: c23.a
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    NovelSpaciesWidgetApiImpl.fetchAndCacheWidgetData$lambda$1(NovelSpaciesWidgetApiImpl.this, i3, z16, obj);
                }
            });
            QLog.d(TAG, 1, "fetchWidgetDataAndCached");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.vas.novelspecies.INovelSpaciesWidgetApi
    @Nullable
    public a getWidgetCachedData() {
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString(MMKV_KEY_WIDGET_INFO, "");
        if (TextUtils.isEmpty(decodeString)) {
            return null;
        }
        try {
            return (a) new Gson().fromJson(decodeString, a.class);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.vas.novelspecies.INovelSpaciesWidgetApi
    public boolean isAddedWidget() {
        if (!isWidgetAdded(VasNovelSpeciesLarge.class) && !isWidgetAdded(VasNovelSpeciesMini.class)) {
            return false;
        }
        return true;
    }
}
