package com.tencent.mobileqq.zplan.emoticon.panel.repository;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import com.tencent.mobileqq.zplan.meme.animation2D.Anim2DFileCacheUtil;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import nx4.a;
import t74.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J:\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J<\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\u0013H\u0016J\u001e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015R\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/Emoticon2DRemoteRepository;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/AbsRepository;", "", "url", "downloadPath", WadlProxyConsts.PARAM_FILENAME, "Lkotlin/Function2;", "", "", "callback", "k", "zipPath", "unZipPath", "l", "path", "g", "Lcom/tencent/mobileqq/zplan/model/e;", "info", "uin", "Lkotlin/Function3;", "i", "", "downloadCostTime", "unZipPrepareTime", "unZipCostTime", "j", "c", "I", h.F, "()I", "setDownloadTryCount", "(I)V", "downloadTryCount", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class Emoticon2DRemoteRepository extends AbsRepository {

    /* renamed from: b, reason: collision with root package name */
    public static final Emoticon2DRemoteRepository f333153b = new Emoticon2DRemoteRepository();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int downloadTryCount = 3;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/repository/Emoticon2DRemoteRepository$a", "Lnx4/a;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "", "onDownloadFailed", "filePath", "Lnx4/a$b;", "result", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements nx4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f333155a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f333156b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f333157c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f333158d;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, String str2, String str3, Function2<? super Integer, ? super String, Unit> function2) {
            this.f333155a = str;
            this.f333156b = str2;
            this.f333157c = str3;
            this.f333158d = function2;
        }

        @Override // nx4.a
        public void a(int statusCode, String filePath, a.b result) {
            QLog.i("Emoticon2DRemoteRepository", 1, "download success, filePath=" + filePath);
            Function2<Integer, String, Unit> function2 = this.f333158d;
            Intrinsics.checkNotNull(filePath);
            function2.invoke(0, filePath);
        }

        @Override // nx4.a
        public void onDownloadFailed(int statusCode, String errorMsg) {
            Emoticon2DRemoteRepository emoticon2DRemoteRepository = Emoticon2DRemoteRepository.f333153b;
            if (emoticon2DRemoteRepository.h() > 0) {
                QLog.e("Emoticon2DRemoteRepository", 1, "download retry=" + emoticon2DRemoteRepository.h());
                emoticon2DRemoteRepository.k(this.f333155a, this.f333156b, this.f333157c, this.f333158d);
                return;
            }
            this.f333158d.invoke(Integer.valueOf(statusCode == 0 ? -3 : statusCode), String.valueOf(errorMsg));
            QLog.e("Emoticon2DRemoteRepository", 1, "download failed code=" + statusCode + ", msg=" + errorMsg);
        }

        @Override // nx4.a
        public void onDownloadProgress(float f16, long j3, long j16) {
            a.C10870a.a(this, f16, j3, j16);
        }
    }

    Emoticon2DRemoteRepository() {
    }

    private final void g(String path) {
        FileUtils.createFileIfNotExits(path + "/.nomedia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String url, String downloadPath, String fileName, Function2<? super Integer, ? super String, Unit> callback) {
        downloadTryCount--;
        ZPlanFileDownloadUtil zPlanFileDownloadUtil = ZPlanFileDownloadUtil.f328039a;
        Intrinsics.checkNotNull(url);
        zPlanFileDownloadUtil.e(url, downloadPath, fileName, new a(url, downloadPath, fileName, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l(String zipPath, String unZipPath) {
        File file = new File(unZipPath);
        if (file.exists() && file.isDirectory()) {
            QLog.w("Emoticon2DRemoteRepository", 1, "unZipRes already exists, path=" + unZipPath);
            return unZipPath;
        }
        File file2 = new File(zipPath);
        QLog.i("Emoticon2DRemoteRepository", 1, "unZipRes zipPath:" + zipPath);
        if (file2.exists()) {
            try {
                ZipUtils.unZipFile(file2, unZipPath);
                return unZipPath;
            } catch (Throwable th5) {
                file2.delete();
                FileUtils.deleteDirectory(unZipPath);
                QLog.e("Emoticon2DRemoteRepository", 1, "unZipRes file error", th5);
                return "";
            }
        }
        QLog.w("Emoticon2DRemoteRepository", 1, "unZipRes failed, file not exist:" + zipPath);
        return "";
    }

    public final int h() {
        return downloadTryCount;
    }

    public void i(ZPlanActionInfo info, String uin, Function3<? super Integer, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String f16 = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.f(info, uin);
        if (!HttpUtil.isValidUrl(f16)) {
            QLog.e("Emoticon2DRemoteRepository", 1, "url is invalid, url=" + f16);
            callback.invoke(-2, "", "");
            return;
        }
        String c16 = com.tencent.zplan.common.utils.d.c(f16);
        Intrinsics.checkNotNullExpressionValue(c16, "toMD5(url)");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = c16.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String d16 = Anim2DFileCacheUtil.f333892a.d();
        QLog.i("Emoticon2DRemoteRepository", 1, "start download info=" + info);
        g(d16);
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNull(f16);
        k(f16, d16, lowerCase + ".zip", new Emoticon2DRemoteRepository$query$1(callback, currentTimeMillis, info, f16));
    }

    public final void j(long downloadCostTime, long unZipPrepareTime, long unZipCostTime) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("download_cost_time", String.valueOf(downloadCostTime)), TuplesKt.to("unzip_prepare_time", String.valueOf(unZipPrepareTime)), TuplesKt.to("unzip_cost_time", String.valueOf(unZipCostTime)));
        r.e(null, "zplan_emoticon_2D_download_unzip_cost", mapOf, 1, null);
    }
}
