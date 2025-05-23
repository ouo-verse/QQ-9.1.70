package com.tencent.mobileqq.zootopia.download;

import ac3.ZPlanDownloadDnsConfig;
import ac3.ZPlanDownloadHttpDnsKey;
import ac3.ZPlanDownloadMultiThreadConfig;
import ac3.b;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.api.GmCgKingsHonorMidGameErrorCode;
import com.tencent.halley.c;
import com.tencent.halley.d;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskCategory;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zootopia.download.multidownloader.ZPlanMultiDownloader;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J4\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002JN\u0010\"\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020 J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010%\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\u0002R\u0016\u0010*\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010)R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010)R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/HalleyDownloader;", "", "", "b", "c", "Lcom/tencent/halley/downloader/DownloaderTask;", "downloaderTask", "Lcom/tencent/halley/downloader/DownloaderTaskListener;", "listener", "", "errCode", "", "errMsg", "", "errStack", "j", "url", "f", tl.h.F, "", "g", "i", "useNew", "reason", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "p", "useEasyDownload", "filePath", WadlProxyConsts.PARAM_FILENAME, "", "header", "", "threadSwitchCostTime", "e", "l", "deleteFile", "d", "speedLimit", DomainData.DOMAIN_NAME, "a", "Z", "mUseMultiDownloaderSdk", "mEnableCrcCheck", "Lcom/tencent/halley/b;", "Lcom/tencent/halley/b;", "mHalleyDownloader", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class HalleyDownloader {

    /* renamed from: a, reason: collision with root package name */
    public static final HalleyDownloader f327980a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean mUseMultiDownloaderSdk;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean mEnableCrcCheck;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.halley.b mHalleyDownloader;

    static {
        HalleyDownloader halleyDownloader = new HalleyDownloader();
        f327980a = halleyDownloader;
        b.Companion companion = ac3.b.INSTANCE;
        ZPlanDownloadHttpDnsKey d16 = companion.d();
        com.tencent.halley.d dVar = new com.tencent.halley.d(BaseApplication.getContext(), 888, halleyDownloader.h(), "zplan_native", new d.a(d16.getAppKey(), d16.getDnsId(), d16.getDnsKey()));
        com.tencent.halley.b f16 = com.tencent.halley.b.f();
        f16.h(dVar);
        Intrinsics.checkNotNullExpressionValue(f16, "getInstance().apply {\n  \u2026init(initParam)\n        }");
        mHalleyDownloader = f16;
        mEnableCrcCheck = companion.a().getEnableCrcCheck();
        c.a a16 = com.tencent.halley.c.a();
        boolean isColorLevel = QLog.isColorLevel();
        a16.k(new fc3.a()).f(false, false).m(DownloaderTaskCategory.Cate_DefaultMass, 15).m(DownloaderTaskCategory.Cate_DefaultEase, 15).i(5000).j(200);
        ZPlanDownloadMultiThreadConfig e16 = companion.e();
        QLog.i("ZPlan_HalleyDownloader", 1, "initConfigs# enableMultiThread=" + e16.getEnableMultiThread() + ", multiThreadFileSizeMB=" + e16.getMultiThreadFileSize() + ", enhanceThreadNum=" + e16.getEnhanceThreadNum() + ", enableDualDownload=" + e16.getEnableDualDownload() + ", mEnableCrcCheck=" + mEnableCrcCheck + ", isColorLevel=" + isColorLevel);
        if (e16.getEnableMultiThread()) {
            a16.g(true).l(true).h(e16.getMultiThreadFileSize() * 1024 * 1024).e(e16.getEnhanceThreadNum());
        } else {
            a16.g(false).l(false);
        }
        halleyDownloader.b();
        halleyDownloader.c();
        boolean g16 = halleyDownloader.g();
        mUseMultiDownloaderSdk = g16;
        QLog.i("ZPlan_HalleyDownloader", 1, "initConfigs# usingZPlanMultiDownloaderSdk= " + g16);
        if (mUseMultiDownloaderSdk) {
            ZPlanMultiDownloader zPlanMultiDownloader = ZPlanMultiDownloader.f328105a;
        }
    }

    HalleyDownloader() {
    }

    private final void b() {
        if (ac3.b.INSTANCE.e().getEnableDualDownload()) {
            boolean z16 = com.tencent.mobileqq.vip.d.d() == 1;
            QLog.i("ZPlan_HalleyDownloader", 1, "checkEnableDualDownload# isKingCard= " + z16);
            if (z16) {
                try {
                    com.tencent.halley.c.a().d(true);
                    return;
                } catch (Exception e16) {
                    QLog.e("ZPlan_HalleyDownloader", 1, "setDualDownloadSwitch error ", e16);
                    return;
                }
            }
            return;
        }
        QLog.i("ZPlan_HalleyDownloader", 1, "checkEnableDualDownload# false ");
    }

    private final void c() {
        ZPlanDownloadDnsConfig b16 = ac3.b.INSTANCE.b();
        QLog.i("ZPlan_HalleyDownloader", 1, "initConfigs# checkEnableHttpDns, " + b16);
        com.tencent.halley.c.a().n(b16.a()).o(b16.getEnableHttpDns());
    }

    private final DownloaderTask f(String url) {
        List<DownloaderTask> e16 = mHalleyDownloader.e();
        Object obj = null;
        if (e16 == null) {
            return null;
        }
        Iterator<T> it = e16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((DownloaderTask) next).getFileUrl(), url)) {
                obj = next;
                break;
            }
        }
        return (DownloaderTask) obj;
    }

    private final boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("zplan_use_new_multidownloader", false);
    }

    private final String h() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        String uin = firstSimpleAccount != null ? firstSimpleAccount.getUin() : null;
        return uin == null ? "" : uin;
    }

    private final void j(final DownloaderTask downloaderTask, final DownloaderTaskListener listener, final int errCode, String errMsg, Throwable errStack) {
        QLog.e("ZPlan_HalleyDownloader", 1, "!notifyStartError - " + errCode + ", " + errMsg, errStack);
        String localizedMessage = errStack != null ? errStack.getLocalizedMessage() : null;
        if (localizedMessage == null) {
            localizedMessage = "";
        }
        final String str = errMsg + " - " + localizedMessage;
        downloaderTask.removeListener(listener);
        v.f328299a.o(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.HalleyDownloader$notifyStartError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DownloaderTask.this.manualSetFailInfo(errCode, str);
                listener.onTaskFailedSubloop(DownloaderTask.this);
            }
        });
    }

    public final void a() {
        if (mUseMultiDownloaderSdk) {
            ZPlanMultiDownloader.f328105a.n();
        } else {
            QLog.i("ZPlan_HalleyDownloader", 1, "cancelDownloadSpeedLimit");
            com.tencent.halley.c.a().a();
        }
    }

    public final boolean d(String url, boolean deleteFile) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (mUseMultiDownloaderSdk) {
            ZPlanMultiDownloader.f328105a.r(url);
            return true;
        }
        DownloaderTask f16 = f(url);
        if (f16 != null) {
            mHalleyDownloader.d(f16, deleteFile);
            QLog.i("ZPlan_HalleyDownloader", 1, "delete task " + url);
            return true;
        }
        QLog.e("ZPlan_HalleyDownloader", 1, "delete inExistent task " + url);
        return false;
    }

    public final boolean i() {
        return mUseMultiDownloaderSdk;
    }

    public final boolean l(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (mUseMultiDownloaderSdk) {
            ZPlanMultiDownloader.f328105a.t(url);
            return true;
        }
        DownloaderTask f16 = f(url);
        if (f16 != null) {
            f16.pause();
            QLog.i("ZPlan_HalleyDownloader", 1, "pause task curStatus " + f16.getStatus() + " " + url);
            return true;
        }
        QLog.e("ZPlan_HalleyDownloader", 1, "pause inExistent task " + url);
        return false;
    }

    public final void m(boolean useNew, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        QLog.e("ZPlan_HalleyDownloader", 1, "resetUsingZPlanMultiDownloaderSdk - " + useNew + ", oldValue = " + mUseMultiDownloaderSdk + ", reason= " + reason);
        mUseMultiDownloaderSdk = useNew;
    }

    public final void n(int speedLimit) {
        if (mUseMultiDownloaderSdk) {
            ZPlanMultiDownloader.f328105a.u(speedLimit);
            return;
        }
        QLog.i("ZPlan_HalleyDownloader", 1, "setDownloadSpeedLimit - " + speedLimit);
        com.tencent.halley.c.a().c(speedLimit);
    }

    public final void o() {
        ZPlanDownloadDnsConfig b16 = ac3.b.INSTANCE.b();
        QLog.i("ZPlan_HalleyDownloader", 1, "startDnsPrepareIfNecessary - " + b16);
        if (b16.getEnablePreDnsParse()) {
            com.tencent.halley.c.a().b(true, b16.getDnsParseType(), b16.a());
        }
    }

    public final void p() {
        ZPlanDownloadDnsConfig b16 = ac3.b.INSTANCE.b();
        QLog.i("ZPlan_HalleyDownloader", 1, "stopDnsPrepare - " + b16);
        if (b16.getEnablePreDnsParse()) {
            com.tencent.halley.c.a().b(false, null, new ArrayList());
        }
    }

    static /* synthetic */ void k(HalleyDownloader halleyDownloader, DownloaderTask downloaderTask, DownloaderTaskListener downloaderTaskListener, int i3, String str, Throwable th5, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            th5 = null;
        }
        halleyDownloader.j(downloaderTask, downloaderTaskListener, i3, str, th5);
    }

    public final void e(boolean useEasyDownload, String url, String filePath, String fileName, Map<String, String> header, DownloaderTaskListener listener, long threadSwitchCostTime) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (mUseMultiDownloaderSdk) {
            ZPlanMultiDownloader.f328105a.v(url, filePath, fileName, header, listener, threadSwitchCostTime);
            return;
        }
        DownloaderTask f16 = f(url);
        if (f16 == null) {
            str = "task";
        } else {
            StringBuilder sb5 = new StringBuilder();
            DownloaderTaskStatus status = f16.getStatus();
            StringBuilder sb6 = new StringBuilder();
            str = "task";
            sb6.append("download - resume exit task: ");
            sb6.append(url);
            sb6.append(" status ");
            sb6.append(status);
            sb6.append(", startThreadSwitchCostTime= ");
            sb6.append(threadSwitchCostTime);
            sb6.append("\n");
            sb5.append(sb6.toString());
            sb5.append("NF.HalleyDownloader-resume exit task: " + url + " status " + f16.getStatus());
            QLog.i("ZPlan_HalleyDownloader", 1, sb5.toString());
            if (f16.getStatus() == DownloaderTaskStatus.COMPLETE) {
                QLog.e("ZPlan_HalleyDownloader", 1, "download - deleteTask, retry download--- " + url);
                mHalleyDownloader.d(f16, false);
            } else {
                try {
                    f16.addListener(listener);
                    f16.resume();
                    return;
                } catch (Exception e16) {
                    f327980a.j(f16, listener, GmCgKingsHonorMidGameErrorCode.InitializerGameNotFront, "download resume exception", e16);
                    return;
                } catch (OutOfMemoryError e17) {
                    f327980a.j(f16, listener, -8002, "download resume OOM", e17);
                    return;
                }
            }
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append("download - create new task: " + useEasyDownload + " -- " + url + ", header= " + header + ", startThreadSwitchCostTime= " + threadSwitchCostTime + "\n");
        StringBuilder sb8 = new StringBuilder();
        sb8.append("NF.HalleyDownloader-zplan downloadUrl=");
        sb8.append(url);
        sb7.append(sb8.toString());
        QLog.i("ZPlan_HalleyDownloader", 1, sb7.toString());
        DownloaderTask b16 = mHalleyDownloader.b(url, filePath, fileName, listener);
        b16.addHeader(ISchemeApi.KEY_REFERER, "https://h5.cmshow.qq.com/");
        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                b16.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (useEasyDownload) {
            b16.setCategory(DownloaderTaskCategory.Cate_DefaultEase);
        }
        b16.setEnableCrcCheck(mEnableCrcCheck);
        try {
            String k3 = mHalleyDownloader.k(b16);
            if (TextUtils.isEmpty(k3)) {
                return;
            }
            str2 = str;
            try {
                Intrinsics.checkNotNullExpressionValue(b16, str2);
                k(this, b16, listener, -8003, "download start error - " + k3, null, 16, null);
            } catch (Exception e18) {
                e = e18;
                Intrinsics.checkNotNullExpressionValue(b16, str2);
                j(b16, listener, -8004, "download start exception", e);
            } catch (OutOfMemoryError e19) {
                e = e19;
                Intrinsics.checkNotNullExpressionValue(b16, str2);
                j(b16, listener, -8005, "download start OOM", e);
            }
        } catch (Exception e26) {
            e = e26;
            str2 = str;
        } catch (OutOfMemoryError e27) {
            e = e27;
            str2 = str;
        }
    }
}
