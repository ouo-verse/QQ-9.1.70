package com.tencent.mobileqq.perf.receiver;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.memory.dump.MemoryFile;
import com.tencent.mobileqq.perf.memory.util.ZipUtil;
import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.mobileqq.perf.upload.cos.PerfCosUploader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.AppSetting;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007J2\u0010\u0010\u001a\u00020\n2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\r2\u0006\u0010\u000f\u001a\u00020\bR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/perf/receiver/f;", "", "", "c", "", "d", "e", "Lkotlin/Pair;", "", "receiverAndCount", "", h.F, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "countReceivers", "total", "f", "b", "Ljava/lang/String;", "hprofZipPath", "I", "currentReportNum", "Z", "hasReportTotal", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "reportedReceiverNames", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f257970a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String hprofZipPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int currentReportNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean hasReportTotal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<String> reportedReceiverNames;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34882);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f257970a = new f();
        StringBuilder sb5 = new StringBuilder();
        File externalFilesDir = BaseApplication.context.getExternalFilesDir("perf");
        Intrinsics.checkNotNull(externalFilesDir);
        sb5.append(externalFilesDir.getAbsolutePath());
        sb5.append(File.separator);
        sb5.append("receiverLeak.zip");
        hprofZipPath = sb5.toString();
        reportedReceiverNames = new ArrayList<>();
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c() {
        if (!d()) {
            return "dump failed.";
        }
        return PerfCosUploader.d(PerfCosUploader.f258269a, PerfCosUploader.BucketType.MEM, hprofZipPath, AppSetting.getBuildNum() + "_receiverLeak_" + QQRMonitorSDKManager.uin + util.base64_pad_url + System.currentTimeMillis(), false, 8, null);
    }

    private final boolean d() {
        try {
            BaseApplication baseApplication = BaseApplication.context;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("perf");
            String str = File.separator;
            sb5.append(str);
            sb5.append("receiver");
            File externalFilesDir = baseApplication.getExternalFilesDir(sb5.toString());
            Intrinsics.checkNotNull(externalFilesDir);
            String hprofDirPath = externalFilesDir.getAbsolutePath();
            String str2 = hprofDirPath + str + "receiverLeak.hprof";
            MemoryFile.a aVar = new MemoryFile.a();
            aVar.p(true);
            boolean g16 = MemoryFile.f257700a.g(aVar, str2);
            if (g16) {
                ZipUtil zipUtil = ZipUtil.f257789a;
                Intrinsics.checkNotNullExpressionValue(hprofDirPath, "hprofDirPath");
                zipUtil.c(hprofDirPath, hprofZipPath);
            }
            FileUtils.delete(hprofDirPath, true);
            return g16;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final boolean e() {
        int i3 = currentReportNum;
        QQPerfConfigLoader qQPerfConfigLoader = QQPerfConfigLoader.f257603a;
        if (i3 > qQPerfConfigLoader.b().f().c() || Math.random() > qQPerfConfigLoader.b().f().d()) {
            return false;
        }
        currentReportNum++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(HashMap countReceivers, int i3) {
        Intrinsics.checkNotNullParameter(countReceivers, "$countReceivers");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("realUin", String.valueOf(QQRMonitorSDKManager.uin));
        hashMap.put("content", "ReceiverTotal_" + countReceivers + util.base64_pad_url + f257970a.c());
        hashMap.put("count", String.valueOf(i3));
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        hashMap.put("processName", processName);
        hashMap.put("branchName", AppSetting.getBranchName());
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "perf_high_frequency_log_alert", true, 0L, 0L, hashMap, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String receiverName, Pair receiverAndCount) {
        Intrinsics.checkNotNullParameter(receiverName, "$receiverName");
        Intrinsics.checkNotNullParameter(receiverAndCount, "$receiverAndCount");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("realUin", String.valueOf(QQRMonitorSDKManager.uin));
        hashMap.put("content", "ReceiverTotal_" + receiverName + util.base64_pad_url + f257970a.c());
        hashMap.put("count", String.valueOf(((Number) receiverAndCount.getSecond()).intValue()));
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        hashMap.put("processName", processName);
        hashMap.put("branchName", AppSetting.getBranchName());
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "perf_high_frequency_log_alert", true, 0L, 0L, hashMap, "");
    }

    public final void f(@NotNull final HashMap<String, Integer> countReceivers, final int total) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) countReceivers, total);
            return;
        }
        Intrinsics.checkNotNullParameter(countReceivers, "countReceivers");
        if (hasReportTotal || !e()) {
            return;
        }
        hasReportTotal = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.receiver.d
            @Override // java.lang.Runnable
            public final void run() {
                f.g(countReceivers, total);
            }
        }, 128, null, false);
    }

    public final void h(@NotNull final Pair<String, Integer> receiverAndCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) receiverAndCount);
            return;
        }
        Intrinsics.checkNotNullParameter(receiverAndCount, "receiverAndCount");
        final String first = receiverAndCount.getFirst();
        if (reportedReceiverNames.contains(first) || !e()) {
            return;
        }
        reportedReceiverNames.add(first);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.receiver.e
            @Override // java.lang.Runnable
            public final void run() {
                f.i(first, receiverAndCount);
            }
        }, 128, null, false);
    }
}
