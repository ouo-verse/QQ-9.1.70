package com.tencent.mobileqq.wink.downloader;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/downloader/b;", "", "", "e", "", "a", "c", "d", WadlProxyConsts.RES_URL, "fileLocalPath", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "resDownLoadListener", "b", "Ljava/lang/String;", "DOWNLOAD_ROOT_DIR", "QZONE_MEDIA_DOWNLOAD_ROOT_DIR", "SHARE_MEDIA_DOWNLOAD_ROOT_DIR", "DAILY_SIGN_DOWNLOAD_ROOT_DIR", "f", "MAGIC_STUDIO_DOWNLOAD_ROOT_DIR", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f318210a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String DOWNLOAD_ROOT_DIR;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String QZONE_MEDIA_DOWNLOAD_ROOT_DIR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String SHARE_MEDIA_DOWNLOAD_ROOT_DIR;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String DAILY_SIGN_DOWNLOAD_ROOT_DIR;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String MAGIC_STUDIO_DOWNLOAD_ROOT_DIR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/downloader/b$a", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f318216d;

        a(ResDownLoadListener resDownLoadListener) {
            this.f318216d = resDownLoadListener;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(@NotNull NetResp resp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(resp, "resp");
            int i3 = resp.mResult;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            w53.b.f("WinkDownloaderManager", "download onResp isSuccess: " + z16 + ", resultCode: " + i3);
            this.f318216d.onDownloadFinish(z16);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(@NotNull NetReq req, long curOffset, long totalLen) {
            int i3;
            Intrinsics.checkNotNullParameter(req, "req");
            if (totalLen > 0) {
                i3 = (int) ((curOffset * 100) / totalLen);
            } else {
                i3 = 0;
            }
            w53.b.a("WinkDownloaderManager", "download progress " + i3);
            this.f318216d.onProgressUpdate(i3);
        }
    }

    static {
        String str = u53.b.f438370a + "/download";
        DOWNLOAD_ROOT_DIR = str;
        QZONE_MEDIA_DOWNLOAD_ROOT_DIR = str + "/qzone/";
        SHARE_MEDIA_DOWNLOAD_ROOT_DIR = str + "/share/";
        DAILY_SIGN_DOWNLOAD_ROOT_DIR = str + "/dailysign/";
        MAGIC_STUDIO_DOWNLOAD_ROOT_DIR = str + "/magicstudio/";
    }

    b() {
    }

    private final String e() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.CHINESE).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(inputCal.time)");
        return format;
    }

    public final void a() {
        File[] listFiles;
        String e16 = e();
        File file = new File(QZONE_MEDIA_DOWNLOAD_ROOT_DIR);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null && file2.exists() && file2.isDirectory() && !Intrinsics.areEqual(file2.getName(), e16)) {
                FileUtils.deleteDirectory(file2.getAbsolutePath());
            }
        }
    }

    public final void b(@NotNull String resUrl, @NotNull String fileLocalPath, @NotNull ResDownLoadListener resDownLoadListener) {
        Intrinsics.checkNotNullParameter(resUrl, "resUrl");
        Intrinsics.checkNotNullParameter(fileLocalPath, "fileLocalPath");
        Intrinsics.checkNotNullParameter(resDownLoadListener, "resDownLoadListener");
        w53.b.f("WinkDownloaderManager", "begin download " + resUrl);
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = resUrl;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = fileLocalPath;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 30000L;
        httpNetReq.mCallback = new a(resDownLoadListener);
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            ((IHttpEngineService) peekAppRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            ms.a.c("WinkDownloaderManager", "downloadRes, error=" + e16);
        }
    }

    @NotNull
    public final String c() {
        String str = QZONE_MEDIA_DOWNLOAD_ROOT_DIR + e();
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    @NotNull
    public final String d() {
        String str = SHARE_MEDIA_DOWNLOAD_ROOT_DIR + e();
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }
}
