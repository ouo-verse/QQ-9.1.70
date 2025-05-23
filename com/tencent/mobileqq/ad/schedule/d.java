package com.tencent.mobileqq.ad.schedule;

import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.IAdConfigApi;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.downloader.p;
import com.tencent.gdtad.downloader.t;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.mobileqq.ad.schedule.d;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.e;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.adSchedule$App;
import tencent.gdt.adSchedule$QueryAllRsp;
import tencent.gdt.adSchedule$ReportReq;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/ad/schedule/d;", "", "", "j", "time", "", "o", "k", "p", "Ltencent/gdt/adSchedule$App;", "app", "Lorg/json/JSONObject;", "i", "", "source", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "eventId", "Lcom/tencent/open/downloadnew/DownloadInfo;", "downloadInfo", DomainData.DOMAIN_NAME, h.F, "b", "J", "mRequestInternal", "c", "mLastRefreshTime", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f186939a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mRequestInternal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mLastRefreshTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/ad/schedule/d$a", "Lcom/tencent/gdtad/downloader/t;", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "", "f", "Lcom/tencent/halley/downloader/DownloaderTask;", "task", "onTaskCompletedMainloop", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends t {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n() {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).refreshAdDownloadTipBanner();
        }

        @Override // com.tencent.gdtad.downloader.t
        public void f(@Nullable DownloadInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
            }
        }

        @Override // com.tencent.gdtad.downloader.t, com.tencent.halley.downloader.DownloaderTaskListener
        public void onTaskCompletedMainloop(@Nullable DownloaderTask task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task);
                return;
            }
            super.onTaskCompletedMainloop(task);
            BannerManager.l().O(com.tencent.mobileqq.ad.schedule.b.f186936a.b(), 0, null);
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.ad.schedule.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.n();
                }
            }, 16, null, false, 5000L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/ad/schedule/d$b", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "Ltencent/gdt/adSchedule$QueryAllRsp;", "result", "", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements VasResultCallback<adSchedule$QueryAllRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f186942a;

        b(int i3) {
            this.f186942a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(@Nullable adSchedule$QueryAllRsp result) {
            Integer num;
            PBRepeatMessageField<adSchedule$App> pBRepeatMessageField;
            List<adSchedule$App> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            if (result != null && (pBRepeatMessageField = result.apps) != null && (list = pBRepeatMessageField.get()) != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            QLog.e("AdScheduleDownloadServlet", 1, "result size" + num);
            if (result != null) {
                int i3 = this.f186942a;
                for (adSchedule$App item : result.apps.get()) {
                    d dVar = d.f186939a;
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    dVar.h(item);
                }
                long j3 = result.next_req_gap.get();
                if (j3 != 0) {
                    d.mRequestInternal = j3 * 1000;
                    d.f186939a.o(d.mRequestInternal);
                }
                d dVar2 = d.f186939a;
                d.mLastRefreshTime = System.currentTimeMillis();
                d dVar3 = d.f186939a;
                dVar3.p(d.mLastRefreshTime);
                if (result.apps.get().isEmpty()) {
                    dVar3.l(i3);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28308);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        d dVar = new d();
        f186939a = dVar;
        mRequestInternal = dVar.j();
        mLastRefreshTime = dVar.k();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final JSONObject i(adSchedule$App app) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isAutoInstall", 1);
        jSONObject.put(e.f341501j, app.download_link.get());
        jSONObject.put("packageName", app.pkg_name.get());
        jSONObject.put(e.f341503l, app.name.get());
        jSONObject.put("appId", app.f435896id.get());
        jSONObject.put(e.f341502k, 2);
        return jSONObject;
    }

    private final long j() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        return from.decodeLong("schedule_internal_time", 6000L);
    }

    private final long k() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        return from.decodeLong("schedule_last_request_time", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int source) {
        if (source == 1) {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).refreshAdDownloadTipBanner();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(long time) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        from.encodeLong("schedule_internal_time", time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(long time) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        from.encodeLong("schedule_last_request_time", time);
    }

    public final void h(@NotNull adSchedule$App app) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        String str = app.download_link.get();
        Intrinsics.checkNotNullExpressionValue(str, "app.download_link.get()");
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("AdScheduleDownloadServlet", 1, "app downloadLink empty, cancel download");
            return;
        }
        if (PackageUtil.isPackageInstalled(MobileQQ.sMobileQQ.getApplicationContext(), app.pkg_name.get())) {
            QLog.e("AdScheduleDownloadServlet", 1, "app has installed, cancel download");
            BannerManager.l().O(com.tencent.mobileqq.ad.schedule.b.f186936a.b(), 0, null);
            return;
        }
        if (!AppNetConnInfo.isWifiConn()) {
            QLog.e("AdScheduleDownloadServlet", 1, "not wifi, cancel download");
            return;
        }
        com.tencent.mobileqq.ad.schedule.b bVar = com.tencent.mobileqq.ad.schedule.b.f186936a;
        String str2 = app.name.get();
        if (str2.length() == 0) {
            z17 = true;
        }
        if (z17) {
            str2 = "\u5e94\u7528";
        }
        bVar.c(str2);
        p.f109191a.i(i(app), new a());
    }

    public final void m(int source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, source);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            if (!((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getCanRefreshScheduleData()) {
                QLog.e("AdScheduleDownloadServlet", 1, "switch return");
                l(source);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = mLastRefreshTime;
            long j16 = currentTimeMillis - j3;
            long j17 = mRequestInternal;
            if (j16 < j17) {
                QLog.e("AdScheduleDownloadServlet", 1, "timeInternal return " + j17 + " last " + j3);
                l(source);
                return;
            }
            ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).reqScheduleAd(new b(source));
            return;
        }
        QLog.e("AdScheduleDownloadServlet", 1, "not login return");
    }

    public final void n(int eventId, @NotNull DownloadInfo downloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, eventId, (Object) downloadInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        adSchedule$ReportReq adschedule_reportreq = new adSchedule$ReportReq();
        adschedule_reportreq.action_type.set(eventId);
        adschedule_reportreq.download_link.set(downloadInfo.f341186f);
        adschedule_reportreq.app_id.set(downloadInfo.f341184e);
        adschedule_reportreq.os_type.set(2);
        adschedule_reportreq.qq_ver.set(AppSetting.f99551k);
        adschedule_reportreq.phone_model.set(DeviceInfoMonitor.getModel());
        adschedule_reportreq.os_version.set(String.valueOf(ah.K()));
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).reportAdDownloadEvent(adschedule_reportreq);
    }
}
