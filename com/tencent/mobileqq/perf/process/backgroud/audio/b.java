package com.tencent.mobileqq.perf.process.backgroud.audio;

import android.app.ActivityManager;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.cq;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0002J\u001e\u0010\u0010\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0016\u001a\u00020\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\"\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u0016\u0010)\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010+R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/audio/b;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "j", "i", "a", "", "processName", "Lcom/tencent/mobileqq/perf/process/backgroud/audio/e;", "g", "", "statInfos", h.F, "Lcom/tencent/mobileqq/perf/process/backgroud/report/a;", "reportData", "d", "Lcom/tencent/mobileqq/perf/process/backgroud/audio/d;", "info", "c", "Lcom/tencent/mobileqq/perf/process/backgroud/audio/c;", "infos", "b", "f", "e", "Landroid/os/Message;", "msg", "", "handleMessage", TPDownloadProxyEnum.USER_SSID, "onNetNone2Wifi", "onNetMobile2Wifi", "apn", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetMobile2None", "onNetWifi2None", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Z", "isBackground", "Lcom/tencent/mobileqq/perf/process/config/a;", "Lcom/tencent/mobileqq/perf/process/config/a;", DownloadInfo.spKey_Config, "Ljava/lang/String;", "traceId", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements Handler.Callback, INetInfoHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f257817d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isBackground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.mobileqq.perf.process.config.a config;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String traceId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        b bVar = new b();
        f257817d = bVar;
        handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), bVar);
        config = new com.tencent.mobileqq.perf.process.config.a(0, 0, 0, 0, 0, 31, null);
        traceId = "";
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        Object obj;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean startsWith$default;
        QLog.i("AudioStatManager", 1, "[collectAudioStatData]");
        ArrayList arrayList = new ArrayList();
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            obj = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } else {
            obj = null;
        }
        if (obj instanceof ActivityManager) {
            activityManager = (ActivityManager) obj;
        } else {
            activityManager = null;
        }
        if (activityManager != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            ArrayList<ActivityManager.RunningAppProcessInfo> arrayList2 = new ArrayList();
            for (Object obj2 : runningAppProcesses) {
                String str = ((ActivityManager.RunningAppProcessInfo) obj2).processName;
                Intrinsics.checkNotNullExpressionValue(str, "it.processName");
                String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
                Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, PACKAGE_NAME, false, 2, null);
                if (startsWith$default) {
                    arrayList2.add(obj2);
                }
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList2) {
                b bVar = f257817d;
                String str2 = runningAppProcessInfo.processName;
                Intrinsics.checkNotNullExpressionValue(str2, "it.processName");
                e g16 = bVar.g(str2);
                if (g16 != null) {
                    if (!Intrinsics.areEqual(g16.c(), traceId)) {
                        QLog.d("AudioStatManager", 1, "[collectAudioStatData] different traceId, " + runningAppProcessInfo.processName);
                        return;
                    }
                    if (g16.b().isEmpty()) {
                        QLog.d("AudioStatManager", 1, "[report] empty playing infos");
                        return;
                    }
                    arrayList.add(g16);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h(arrayList);
    }

    private final void b(List<c> infos, com.tencent.mobileqq.perf.process.backgroud.report.a reportData) {
        Object obj;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (infos != null) {
            for (c cVar : infos) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((c) obj).b(), cVar.b())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    arrayList.add(cVar);
                }
            }
        }
        try {
            String jsonString = new Gson().toJson(arrayList);
            Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
            reportData.b(jsonString);
            if (QLog.isDebugVersion()) {
                QLog.d("AudioStatManager", 4, "[fillFloatWindowInfo] " + jsonString);
            }
        } catch (Exception e16) {
            QLog.e("AudioStatManager", 1, "[fillFloatWindowInfo] error, ", e16);
        }
    }

    private final void c(d info, com.tencent.mobileqq.perf.process.backgroud.report.a reportData) {
        int c16 = info.c();
        if (c16 != 1) {
            if (c16 != 2) {
                if (c16 != 4) {
                    if (c16 == 8) {
                        reportData.k(info.a());
                        reportData.l(info.b());
                        return;
                    }
                    return;
                }
                reportData.i(info.a());
                reportData.j(info.b());
                return;
            }
            reportData.g(info.a());
            reportData.h(info.b());
            return;
        }
        reportData.e(info.a());
        reportData.f(info.b());
    }

    private final void d(List<e> statInfos, com.tencent.mobileqq.perf.process.backgroud.report.a reportData) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (e eVar : statInfos) {
            for (d dVar : eVar.b()) {
                i3 |= dVar.c();
                f257817d.c(dVar, reportData);
            }
            ArrayList<c> a16 = eVar.a();
            if (a16 != null) {
                arrayList.addAll(a16);
            }
        }
        reportData.d(String.valueOf(i3));
        b(arrayList, reportData);
    }

    private final e g(String processName) {
        e eVar;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String h16 = a.f257816a.h(processName);
        try {
            eVar = (e) new Gson().fromJson(from.decodeString(h16, ""), e.class);
        } catch (Exception e16) {
            QLog.e("AudioStatManager", 1, "[parseStatInfo] error, ", e16);
            eVar = null;
        }
        from.removeKey(h16);
        return eVar;
    }

    private final void h(List<e> statInfos) {
        com.tencent.mobileqq.perf.process.backgroud.report.a aVar = new com.tencent.mobileqq.perf.process.backgroud.report.a(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        aVar.m(traceId);
        aVar.c("AUDIO_BACKGROUND_STAT");
        d(statInfos, aVar);
        if (QLog.isDebugVersion()) {
            QLog.d("AudioStatManager", 4, "[report] " + aVar);
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).qualityReport(11014, aVar.n());
    }

    private final void i() {
        QLog.i("AudioStatManager", 1, "[sendBroadcastToAudioStat]");
        traceId = String.valueOf(System.currentTimeMillis());
        Intent intent = new Intent("com.tencent.process.audio.stat");
        intent.putExtra("AudioStat_trace_id", traceId);
        intent.putExtra("process_verify", cq.c(null, false));
        BaseApplication.context.sendBroadcast(intent);
    }

    private final void j() {
        Object obj;
        if (!isBackground) {
            QLog.i("AudioStatManager", 1, "[tryStartCheck] not in background");
            return;
        }
        if (!config.d()) {
            QLog.i("AudioStatManager", 1, "[tryStartCheck] switch not open");
            return;
        }
        if (!config.e()) {
            QLog.i("AudioStatManager", 1, "[tryStartCheck] version not OK");
            return;
        }
        BaseApplication baseApplication = BaseApplication.context;
        AudioManager audioManager = null;
        if (baseApplication != null) {
            obj = baseApplication.getSystemService("audio");
        } else {
            obj = null;
        }
        if (obj instanceof AudioManager) {
            audioManager = (AudioManager) obj;
        }
        if (audioManager != null && audioManager.isMusicActive()) {
            i();
            if (config.a() == 1) {
                AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.context, this);
            }
            handler.sendEmptyMessageDelayed(72351, config.b());
            return;
        }
        QLog.i("AudioStatManager", 1, "[tryStartCheck] no active audio");
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i("AudioStatManager", 1, "[onApplicationBackground]");
        isBackground = true;
        Handler handler2 = handler;
        handler2.removeMessages(72350);
        config = com.tencent.mobileqq.perf.process.config.a.INSTANCE.a();
        handler2.sendEmptyMessageDelayed(72350, r2.c());
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Handler handler2 = handler;
        QLog.i("AudioStatManager", 1, "[onApplicationForeground] hasMsg=" + handler2.hasMessages(72350));
        isBackground = false;
        handler2.removeMessages(72350);
        AppNetConnInfo.unregisterNetInfoHandler(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        switch (msg2.what) {
            case 72350:
                j();
                return true;
            case 72351:
                a();
                return true;
            default:
                return true;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(@Nullable String ssid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) ssid);
        } else if (config.a() == 1) {
            j();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(@Nullable String apn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) apn);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(@Nullable String ssid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) ssid);
        } else if (config.a() == 1) {
            j();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(@Nullable String apn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) apn);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }
}
