package com.tencent.mobileqq.perf.thread.proxy;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.perf.memory.util.ZipUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.perf.upload.cos.PerfCosUploader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtException;
import com.tencent.thread.monitor.plugin.api.IThreadInfo;
import com.tencent.thread.monitor.plugin.api.IThreadPoolInfo;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.api.ReportResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0007H\u0002J4\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00072\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0011j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0002R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/perf/thread/proxy/ThreadProxyMonitor;", "", "", "g", "e", "Lcom/tencent/thread/monitor/plugin/api/ReportResult;", "result", "", "dumpDir", h.F, WadlProxyConsts.PARAM_FILENAME, "data", "i", "stackStr", "Lcom/tencent/mobileqq/perf/thread/proxy/ThreadProxyMonitor$ThreadProxyException;", "d", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "f", "b", "", "J", "lastReportTime", "<init>", "()V", "ThreadProxyException", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ThreadProxyMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ThreadProxyMonitor f258150a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastReportTime;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/perf/thread/proxy/ThreadProxyMonitor$ThreadProxyException;", "Lcom/tencent/qqperf/monitor/crash/catchedexception/CaughtException;", "message", "", "(Ljava/lang/String;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class ThreadProxyException extends CaughtException {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThreadProxyException(@NotNull String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) message);
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues((Long) ((Map.Entry) t16).getKey(), (Long) ((Map.Entry) t17).getKey());
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues((String) ((Map.Entry) t16).getKey(), (String) ((Map.Entry) t17).getKey());
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class c<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues((Long) ((Map.Entry) t16).getKey(), (Long) ((Map.Entry) t17).getKey());
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f258150a = new ThreadProxyMonitor();
        }
    }

    ThreadProxyMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        try {
            ThreadProxyMonitor threadProxyMonitor = f258150a;
            threadProxyMonitor.e();
            threadProxyMonitor.g();
        } catch (Exception e16) {
            QLog.e("ThreadProxy_monitor", 1, "checkThread fail", e16);
        }
    }

    private final ThreadProxyException d(String stackStr) {
        List split$default;
        int collectionSizeOrDefault;
        List split$default2;
        int lastIndex;
        Object obj;
        int lastIndex2;
        Object obj2;
        int lastIndex3;
        Object obj3;
        Integer intOrNull;
        split$default = StringsKt__StringsKt.split$default((CharSequence) stackStr, new String[]{"\n"}, false, 0, 6, (Object) null);
        List list = split$default;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (true) {
            int i3 = 0;
            if (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"(", ")", ":"}, false, 0, 6, (Object) null);
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(split$default2);
                if (lastIndex < 0) {
                    obj = "";
                } else {
                    obj = split$default2.get(0);
                }
                String str = (String) obj;
                lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(split$default2);
                if (1 > lastIndex2) {
                    obj2 = "";
                } else {
                    obj2 = split$default2.get(1);
                }
                String str2 = (String) obj2;
                lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(split$default2);
                if (2 <= lastIndex3) {
                    obj3 = split$default2.get(2);
                } else {
                    obj3 = "0";
                }
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) obj3);
                if (intOrNull != null) {
                    i3 = intOrNull.intValue();
                }
                arrayList.add(new StackTraceElement(str, "", str2, i3));
            } else {
                Object[] array = arrayList.toArray(new StackTraceElement[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                ThreadProxyException threadProxyException = new ThreadProxyException("ThreadProxy exception");
                threadProxyException.setStackTrace((StackTraceElement[]) array);
                return threadProxyException;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02dd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e() {
        String str;
        boolean startsWith$default;
        Object next;
        int mapCapacity;
        Object next2;
        Object next3;
        Integer num;
        String str2;
        Integer num2;
        List list;
        IThreadPoolInfo iThreadPoolInfo;
        ArrayList<Long> threadIds;
        boolean startsWith$default2;
        boolean z16;
        boolean contains$default;
        boolean z17;
        ProxyController proxyController = ProxyController.INSTANCE;
        if (!proxyController.getNeedRecordStack()) {
            return;
        }
        File externalFilesDir = BaseApplication.context.getExternalFilesDir("perf/threadProxy");
        String str3 = null;
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        FileUtils.delete(str, true);
        new File(str).mkdirs();
        ReportResult reportResult = proxyController.getReportResult();
        ConcurrentHashMap<Long, ? extends IThreadInfo> threadInfo = proxyController.getThreadInfo();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, ? extends IThreadInfo> entry : threadInfo.entrySet()) {
            if (!Intrinsics.areEqual(entry.getValue().getCallStack(), "")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        QLog.i("ThreadProxy_monitor", 1, "checkThread, allSize: " + reportResult.getAllThreadSize() + ", allActiveSize\uff1a" + reportResult.getAllActiveThreadSize() + ", recordSize: " + reportResult.getRecordThreadSize() + ", recordRunnableSize: " + linkedHashMap.size());
        h(reportResult, str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("threadProxy_");
        sb5.append(com.tencent.mobileqq.perf.memory.dump.a.f257721a.b().format(new Date()));
        sb5.append(".zip");
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        String parent = new File(str).getParent();
        Intrinsics.checkNotNull(parent);
        sb7.append(parent);
        sb7.append(File.separator);
        sb7.append(sb6);
        String sb8 = sb7.toString();
        ZipUtil.f257789a.c(str, sb8);
        FileUtils.delete(str, true);
        PerfCosUploader perfCosUploader = PerfCosUploader.f258269a;
        PerfCosUploader.BucketType bucketType = PerfCosUploader.BucketType.MEM;
        String d16 = PerfCosUploader.d(perfCosUploader, bucketType, sb8, sb6, false, 8, null);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(d16, "https://" + bucketType.getBucketName() + "-70657.njc.vod.tencent-cloud.com", false, 2, null);
        QLog.i("ThreadProxy_monitor", 1, "upload file complete, " + startsWith$default + ", " + d16);
        if (!startsWith$default) {
            return;
        }
        Iterator<T> it = reportResult.getResultPoolInfo().entrySet().iterator();
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                int size = ((IThreadPoolInfo) ((Map.Entry) next).getValue()).getThreadIds().size();
                do {
                    Object next4 = it.next();
                    int size2 = ((IThreadPoolInfo) ((Map.Entry) next4).getValue()).getThreadIds().size();
                    if (size < size2) {
                        next = next4;
                        size = size2;
                    }
                } while (it.hasNext());
            }
        }
        Map.Entry entry2 = (Map.Entry) next;
        Set<Map.Entry<String, IThreadPoolInfo>> entrySet = reportResult.getResultPoolInfo().entrySet();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj : entrySet) {
            String createStack = ((IThreadPoolInfo) ((Map.Entry) obj).getValue()).getCreateStack();
            Object obj2 = linkedHashMap2.get(createStack);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap2.put(createStack, obj2);
            }
            ((List) obj2).add(obj);
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap2.size());
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            Object key = entry3.getKey();
            Iterator it5 = ((Iterable) entry3.getValue()).iterator();
            int i3 = 0;
            while (it5.hasNext()) {
                i3 += ((IThreadPoolInfo) ((Map.Entry) it5.next()).getValue()).getThreadIds().size();
            }
            linkedHashMap3.put(key, Integer.valueOf(i3));
        }
        Iterator it6 = linkedHashMap3.entrySet().iterator();
        if (!it6.hasNext()) {
            next2 = null;
        } else {
            next2 = it6.next();
            if (it6.hasNext()) {
                int intValue = ((Number) ((Map.Entry) next2).getValue()).intValue();
                do {
                    Object next5 = it6.next();
                    int intValue2 = ((Number) ((Map.Entry) next5).getValue()).intValue();
                    if (intValue < intValue2) {
                        next2 = next5;
                        intValue = intValue2;
                    }
                } while (it6.hasNext());
            }
        }
        Map.Entry entry4 = (Map.Entry) next2;
        Set<Map.Entry<Long, IThreadInfo>> entrySet2 = reportResult.getResultThreadInfo().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : entrySet2) {
            Map.Entry entry5 = (Map.Entry) obj3;
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(((IThreadInfo) entry5.getValue()).getName(), "DefaultDispatcher-worker", false, 2, null);
            if (!startsWith$default2) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) ((IThreadInfo) entry5.getValue()).getCallStack(), (CharSequence) "ThreadSmartPool", false, 2, (Object) null);
                if (!contains$default) {
                    if (((IThreadInfo) entry5.getValue()).getCallStack().length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        z16 = true;
                        if (!z16) {
                            arrayList.add(obj3);
                        }
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Object obj4 : arrayList) {
            String callStack = ((IThreadInfo) ((Map.Entry) obj4).getValue()).getCallStack();
            Object obj5 = linkedHashMap4.get(callStack);
            if (obj5 == null) {
                obj5 = new ArrayList();
                linkedHashMap4.put(callStack, obj5);
            }
            ((List) obj5).add(obj4);
        }
        Iterator it7 = linkedHashMap4.entrySet().iterator();
        if (!it7.hasNext()) {
            next3 = null;
        } else {
            next3 = it7.next();
            if (it7.hasNext()) {
                int size3 = ((List) ((Map.Entry) next3).getValue()).size();
                do {
                    Object next6 = it7.next();
                    int size4 = ((List) ((Map.Entry) next6).getValue()).size();
                    if (size3 < size4) {
                        next3 = next6;
                        size3 = size4;
                    }
                } while (it7.hasNext());
            }
        }
        Map.Entry entry6 = (Map.Entry) next3;
        StringBuilder sb9 = new StringBuilder();
        sb9.append("maxPool:");
        if (entry2 != null && (iThreadPoolInfo = (IThreadPoolInfo) entry2.getValue()) != null && (threadIds = iThreadPoolInfo.getThreadIds()) != null) {
            num = Integer.valueOf(threadIds.size());
        } else {
            num = null;
        }
        sb9.append(num);
        sb9.append(", ");
        if (entry2 != null) {
            str2 = (String) entry2.getKey();
        } else {
            str2 = null;
        }
        sb9.append(str2);
        sb9.append(", maxCallStack: ");
        if (entry6 != null && (list = (List) entry6.getValue()) != null) {
            num2 = Integer.valueOf(list.size());
        } else {
            num2 = null;
        }
        sb9.append(num2);
        sb9.append(", ");
        if (entry6 != null) {
            str3 = (String) entry6.getKey();
        }
        sb9.append(str3);
        String sb10 = sb9.toString();
        QLog.i("ThreadProxy_monitor", 1, "report, " + sb10);
        HashMap hashMap = new HashMap();
        hashMap.put("uin", com.tencent.mobileqq.perf.process.util.b.f257946a.k());
        hashMap.put("scene", SceneTracker.f());
        hashMap.put("url", d16);
        if (entry2 != null) {
            hashMap.put("maxPoolName", entry2.getKey());
        }
        if (entry4 != null) {
            hashMap.put("poolCrtSta", entry4.getKey());
        }
        if (entry6 != null && ((List) entry6.getValue()).size() > com.tencent.mobileqq.perf.thread.proxy.b.INSTANCE.b().c()) {
            hashMap.put("maxCallStack", entry6.getKey());
            hashMap.put("maxCallStackSize", String.valueOf(((List) entry6.getValue()).size()));
        }
        f258150a.f("threadProxyMonitor", hashMap);
        if (entry6 != null && ((List) entry6.getValue()).size() >= com.tencent.mobileqq.perf.thread.proxy.b.INSTANCE.b().c()) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(d((String) entry6.getKey()), "ThreadProxy, url: " + sb6 + ", " + sb10);
        }
    }

    private final void f(String eventName, HashMap<String, String> params) {
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, eventName, true, 0L, 0L, params, "");
    }

    private final void g() {
        if (!GuardManager.sInstance.isApplicationForeground()) {
            ProxyController.INSTANCE.trimThreads(false);
        }
    }

    private final void h(ReportResult result, String dumpDir) {
        List sortedWith;
        String joinToString$default;
        List sortedWith2;
        String joinToString$default2;
        List sortedWith3;
        String joinToString$default3;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(result.getResultThreadInfo().entrySet(), new a());
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(sortedWith, "\n\n\n", null, null, 0, null, ThreadProxyMonitor$writeReportResult$2.INSTANCE, 30, null);
        i(dumpDir, "recordThreads.txt", joinToString$default);
        sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(result.getResultPoolInfo().entrySet(), new b());
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(sortedWith2, "\n\n\n", null, null, 0, null, ThreadProxyMonitor$writeReportResult$4.INSTANCE, 30, null);
        i(dumpDir, "recordThreadPools.txt", joinToString$default2);
        String str = (("\u771f\u5b9e\u7ebf\u7a0b\u6570, all:" + result.getAllThreadSize() + ", active:" + result.getAllActiveThreadSize() + '\n') + "\u8bb0\u5f55\u7684\u7ebf\u7a0b\u6570, thread:" + result.getRecordThreadSize() + ", pool:" + result.getRecordPoolSize() + '\n') + "\u5408\u5e76\u540e\u7684\u7ebf\u7a0b\u6570, thread:" + result.getResultThreadSize() + ", pool:" + result.getResultPoolSize() + "\n\n\n";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sortedWith3 = CollectionsKt___CollectionsKt.sortedWith(result.getAllThreadInfo().entrySet(), new c());
        joinToString$default3 = CollectionsKt___CollectionsKt.joinToString$default(sortedWith3, "\n\n\n", null, null, 0, null, ThreadProxyMonitor$writeReportResult$6.INSTANCE, 30, null);
        sb5.append(joinToString$default3);
        i(dumpDir, "allThreads.txt", sb5.toString());
    }

    private final void i(String dumpDir, String fileName, String data) {
        File file = new File(dumpDir, fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                try {
                    bufferedWriter.write(data);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedWriter, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    Log.i("ThreadProxy_monitor", "File written successfully: " + file.getAbsolutePath());
                } finally {
                }
            } finally {
            }
        } catch (IOException e16) {
            Log.e("ThreadProxy_monitor", "File written fail", e16);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!ProxyController.INSTANCE.getEnabled()) {
            return;
        }
        if (Thread.activeCount() < com.tencent.mobileqq.perf.thread.proxy.b.INSTANCE.b().e().d()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - lastReportTime > r1.b().i() * 60000) {
            lastReportTime = elapsedRealtime;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.thread.proxy.e
                @Override // java.lang.Runnable
                public final void run() {
                    ThreadProxyMonitor.c();
                }
            }, 64, null, false);
        } else {
            g();
        }
    }
}
