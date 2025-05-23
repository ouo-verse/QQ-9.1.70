package com.tencent.mobileqq.app.message.cleanup;

import android.text.TextUtils;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mobileqq.app.message.cleanup.tool.ZPlanCleanUpThoroughCacheTool;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJL\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000bJ&\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bR\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR&\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001cj\b\u0012\u0004\u0012\u00020\u0002`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/h;", "", "", "path", "", "c", "", "d", "", "b", "a", "", "size", "isFile", "isWhiteListFile", "isPublicFile", "name", "totalSize", "cantClearSize", "e", "accessTime", "g", "Ljava/lang/String;", "mReportTag", "J", "mCurrentScanTime", "Z", "mNeedReport", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mCustomClearPathList", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f195951a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mReportTag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mCurrentScanTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean mNeedReport;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<String> mCustomClearPathList;

    static {
        boolean z16;
        IFeatureRuntimeService iFeatureRuntimeService;
        boolean z17;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f195951a = new h();
        mReportTag = "qqStorageReportCI";
        mCustomClearPathList = new ArrayList<>();
        mReportTag = "qqStorageReport";
        if (0.001d >= Math.random()) {
            z16 = true;
        } else {
            z16 = false;
        }
        mNeedReport = z16;
        if (!z16) {
            QLog.d("CleanupFileReporter", 1, "init CleanupFileReporter sampling rate not report");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        if (iFeatureRuntimeService != null) {
            z17 = iFeatureRuntimeService.isFeatureSwitchEnable("storage_report", true);
        } else {
            z17 = true;
        }
        mNeedReport = z17;
        QLog.d("CleanupFileReporter", 1, "init CleanupFileReporter feature mNeedReport:" + mNeedReport);
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c(String path) {
        List plus;
        boolean startsWith$default;
        String str = path + '/';
        plus = CollectionsKt___CollectionsKt.plus((Collection) mCustomClearPathList, (Iterable) com.tencent.mobileqq.app.message.filescan.d.f195978a.m());
        Iterator it = plus.iterator();
        while (it.hasNext()) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, ((String) it.next()) + '/', false, 2, null);
            if (startsWith$default) {
                return true;
            }
        }
        return false;
    }

    private final List<String> d() {
        ArrayList arrayListOf;
        boolean z16;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("PluginCleanUpThoroughCacheTool", "QLogCleanUpThoroughCacheTool", "VASCleanUpThoroughCacheTool", ZPlanCleanUpThoroughCacheTool.TAG, "ChatFileCleanUpThoroughCacheTool");
        Collection<y> values = CleanUpThoroughManager.INSTANCE.b().values();
        Intrinsics.checkNotNullExpressionValue(values, "CleanUpThoroughManager.cacheToolMap.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            y yVar = (y) obj;
            Iterator it = arrayListOf.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals((String) it.next(), yVar.getClass().getSimpleName())) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, ((y) it5.next()).getWhiteList());
        }
        return arrayList2;
    }

    public static /* synthetic */ void f(h hVar, String str, long j3, boolean z16, boolean z17, boolean z18, String str2, long j16, long j17, int i3, Object obj) {
        String str3;
        long j18;
        long j19;
        if ((i3 & 32) != 0) {
            str3 = "";
        } else {
            str3 = str2;
        }
        if ((i3 & 64) != 0) {
            j18 = 0;
        } else {
            j18 = j16;
        }
        if ((i3 & 128) != 0) {
            j19 = 0;
        } else {
            j19 = j17;
        }
        hVar.e(str, j3, z16, z17, z18, str3, j18, j19);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        mCustomClearPathList.clear();
        if (mNeedReport) {
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
            from.encodeLong("mmkv_key_storage_report_time", mCurrentScanTime);
            QLog.d("CleanupFileReporter", 1, "afterScan record scan time: " + mCurrentScanTime);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        mCustomClearPathList = new ArrayList<>(d());
        QLog.d("CleanupFileReporter", 1, "beforeScan mCustomClearPathList: " + mCustomClearPathList);
        mCurrentScanTime = System.currentTimeMillis() / ((long) 1000);
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("mmkv_key_storage_report_time", 0L);
        QLog.d("CleanupFileReporter", 1, "beforeScan lastReportTime: " + decodeLong);
        if (mNeedReport && decodeLong > 0 && Math.abs(mCurrentScanTime - decodeLong) < 86400) {
            mNeedReport = false;
            QLog.d("CleanupFileReporter", 1, "beforeScan report in one day set mNeedReport = false");
        }
    }

    public final void e(@NotNull String path, long size, boolean isFile, boolean isWhiteListFile, boolean isPublicFile, @NotNull String name, long totalSize, long cantClearSize) {
        String str;
        String str2;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, path, Long.valueOf(size), Boolean.valueOf(isFile), Boolean.valueOf(isWhiteListFile), Boolean.valueOf(isPublicFile), name, Long.valueOf(totalSize), Long.valueOf(cantClearSize));
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!mNeedReport) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        hashMap.put("account", str);
        hashMap.put("path", path);
        hashMap.put("name", name);
        hashMap.put("size", String.valueOf(size));
        String str5 = "0";
        if (!isFile) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        hashMap.put("is_file", str2);
        hashMap.put("is_cleanup", "1");
        if (!isWhiteListFile) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        hashMap.put("is_whitelist_file", str3);
        if (!isPublicFile) {
            str4 = "0";
        } else {
            str4 = "1";
        }
        hashMap.put("is_public_file", str4);
        if (isWhiteListFile) {
            z16 = c(path);
        }
        if (z16) {
            str5 = "1";
        }
        hashMap.put("can_clear_file", str5);
        hashMap.put("tool_total_size", String.valueOf(totalSize));
        hashMap.put("tool_cant_clear_size", String.valueOf(cantClearSize));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, mReportTag, true, 0L, 0L, hashMap, null);
    }

    public final void g(@NotNull String path, long size, @NotNull String name, long accessTime) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, path, Long.valueOf(size), name, Long.valueOf(accessTime));
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!mNeedReport) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        hashMap.put("account", str);
        hashMap.put("report_key", str + util.base64_pad_url + mCurrentScanTime);
        hashMap.put("path", path);
        hashMap.put("name", name);
        hashMap.put("size", String.valueOf(size));
        hashMap.put("accessTime", String.valueOf(accessTime));
        hashMap.put("isFile", "true");
        hashMap.put(QuotaFileSystem.STAT_FILE_COUNT, "1");
        hashMap.put(QuotaFileSystem.STAT_DIR_COUNT, "0");
        hashMap.put("dirScanCost", "0");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, mReportTag, true, 0L, 0L, hashMap, null);
    }
}
