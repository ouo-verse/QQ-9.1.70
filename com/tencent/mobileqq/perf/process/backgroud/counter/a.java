package com.tencent.mobileqq.perf.process.backgroud.counter;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.tencent.ark.ark;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005J\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/counter/a;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/perf/process/backgroud/counter/a$a;", "Lkotlin/collections/HashMap;", "a", "", "b", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257838a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257838a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final HashMap<String, C8206a> a() {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HashMap<String, C8206a> hashMap = new HashMap<>();
        Object systemService = BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses != null) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String str = runningAppProcessInfo.processName;
                Intrinsics.checkNotNullExpressionValue(str, "process.processName");
                String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
                Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, PACKAGE_NAME, false, 2, null);
                if (startsWith$default) {
                    String str2 = "process_memInfo_" + runningAppProcessInfo.processName;
                    String memInfoJson = from.decodeString(str2, "");
                    if (!TextUtils.isEmpty(memInfoJson)) {
                        String str3 = runningAppProcessInfo.processName;
                        Intrinsics.checkNotNullExpressionValue(str3, "process.processName");
                        Intrinsics.checkNotNullExpressionValue(memInfoJson, "memInfoJson");
                        hashMap.put(str3, new C8206a(memInfoJson));
                    }
                    from.encodeString(str2, "");
                }
            }
        }
        QLog.i("AppMemoryCounter", 1, "readAppMemoryInfoFromMMKV : " + hashMap);
        return hashMap;
    }

    public final void b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.highPriorityWhenBackground()) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList<String> arrayList = null;
        Debug.MemoryInfo m3 = MemoryUtil.m(0, 1, null);
        if (peekAppRuntime != null) {
            arrayList = peekAppRuntime.getLowerPriorityProcessList();
        }
        C8206a c8206a = new C8206a(m3, z16, arrayList);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("process_memInfo_" + MobileQQ.processName, c8206a.e());
        if (QLog.isColorLevel()) {
            QLog.i("AppMemoryCounter", 2, "writeMemoryToMMKV, processName : " + MobileQQ.processName + " memInfo : " + c8206a + " pid : " + Process.myPid());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010*B5\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020\u001a\u0012\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010 j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`!\u00a2\u0006\u0004\b)\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\"\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\t\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\"\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u000f\u0010\u001c\"\u0004\b\u001d\u0010\u001eR6\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010 j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u0013\u0010$\"\u0004\b%\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/counter/a$a;", "", "", "e", "memInfoJson", "", "a", "toString", "", "I", "d", "()I", "setTotalPss", "(I)V", MiniGameMemoryLimitReport.BeaconKey.TOTALPSS, "b", "getDalvikPss", "setDalvikPss", MiniGameMemoryLimitReport.BeaconKey.DALVIKPSS, "c", "getNativePss", "setNativePss", MiniGameMemoryLimitReport.BeaconKey.NATIVEPSS, "getOtherPss", "setOtherPss", MiniGameMemoryLimitReport.BeaconKey.OTHERPSS, "", "Z", "()Z", "setHighPriority", "(Z)V", "highPriority", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setLowerPriorityProcessList", "(Ljava/util/ArrayList;)V", "lowerPriorityProcessList", ark.ARKMETADATA_JSON, "<init>", "(Ljava/lang/String;)V", "Landroid/os/Debug$MemoryInfo;", "memInfo", "priority", "(Landroid/os/Debug$MemoryInfo;ZLjava/util/ArrayList;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.process.backgroud.counter.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8206a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int totalPss;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int dalvikPss;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int nativePss;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int otherPss;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean highPriority;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ArrayList<String> lowerPriorityProcessList;

        public C8206a(@NotNull String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                a(json);
            } else {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) json);
            }
        }

        public final void a(@NotNull String memInfoJson) {
            C8206a c8206a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) memInfoJson);
                return;
            }
            Intrinsics.checkNotNullParameter(memInfoJson, "memInfoJson");
            try {
                c8206a = (C8206a) new Gson().fromJson(memInfoJson, C8206a.class);
            } catch (JsonParseException unused) {
                c8206a = null;
            }
            if (c8206a != null) {
                this.totalPss = c8206a.totalPss;
                this.dalvikPss = c8206a.dalvikPss;
                this.nativePss = c8206a.nativePss;
                this.otherPss = c8206a.otherPss;
                this.highPriority = c8206a.highPriority;
                this.lowerPriorityProcessList = c8206a.lowerPriorityProcessList;
            }
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return this.highPriority;
        }

        @Nullable
        public final ArrayList<String> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.lowerPriorityProcessList;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            return this.totalPss;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        }

        @NotNull
        public String toString() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MemInfo(totalPss=");
            sb5.append(this.totalPss);
            sb5.append(", dalvikPss=");
            sb5.append(this.dalvikPss);
            sb5.append(", nativePss=");
            sb5.append(this.nativePss);
            sb5.append(", otherPss=");
            sb5.append(this.otherPss);
            sb5.append(", highPriority=");
            sb5.append(this.highPriority);
            sb5.append(", lowerPriorityProcessList=");
            ArrayList<String> arrayList = this.lowerPriorityProcessList;
            if (arrayList != null) {
                str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(')');
            return sb5.toString();
        }

        public C8206a(@NotNull Debug.MemoryInfo memInfo, boolean z16, @Nullable ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(memInfo, "memInfo");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, memInfo, Boolean.valueOf(z16), arrayList);
                return;
            }
            this.totalPss = memInfo.getTotalPss();
            this.dalvikPss = memInfo.dalvikPss;
            this.nativePss = memInfo.nativePss;
            this.otherPss = memInfo.otherPss;
            this.highPriority = z16;
            this.lowerPriorityProcessList = arrayList;
        }
    }
}
