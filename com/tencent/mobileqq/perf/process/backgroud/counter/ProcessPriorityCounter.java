package com.tencent.mobileqq.perf.process.backgroud.counter;

import android.app.ActivityManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.process.backgroud.counter.a;
import com.tencent.mobileqq.perf.process.config.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'Jx\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00110\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\u001a\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\u001a\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002JN\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002JF\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u001a2\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0002JT\u0010 \u001a\u00020\u001f2\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b2\u001e\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000f0\u001c2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0003H\u0002J:\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00112\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bJ:\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00112\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/perf/process/backgroud/counter/ProcessPriorityCounter;", "", "", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "processList", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/perf/process/backgroud/counter/a$a;", "Lkotlin/collections/HashMap;", "processToMemInfo", "", "remainingProcessMemory", "Lkotlin/Function2;", "", "filter", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "i", "appProcessList", "originAppProcessList", "e", "", "", "g", "", "priorityIndexMap", "hostProcessName", "", "c", "processInfo", "j", "k", h.F, "f", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProcessPriorityCounter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ProcessPriorityCounter f257834a;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/perf/process/backgroud/counter/ProcessPriorityCounter$a", "Ljava/util/Comparator;", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "left", "right", "", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements Comparator<ActivityManager.RunningAppProcessInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map<String, Integer> f257835d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<String, a.C8206a> f257836e;

        a(Map<String, Integer> map, HashMap<String, a.C8206a> hashMap) {
            this.f257835d = map;
            this.f257836e = hashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) map, (Object) hashMap);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@Nullable ActivityManager.RunningAppProcessInfo left, @Nullable ActivityManager.RunningAppProcessInfo right) {
            String str;
            int i3;
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) left, (Object) right)).intValue();
            }
            Map<String, Integer> map = this.f257835d;
            String str4 = null;
            if (left != null) {
                str = left.processName;
            } else {
                str = null;
            }
            Integer num = map.get(str);
            int i16 = 0;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            Map<String, Integer> map2 = this.f257835d;
            if (right != null) {
                str2 = right.processName;
            } else {
                str2 = null;
            }
            Integer num2 = map2.get(str2);
            if (num2 != null) {
                i16 = num2.intValue();
            }
            if (i3 != i16) {
                return i3 - i16;
            }
            HashMap<String, a.C8206a> hashMap = this.f257836e;
            if (left != null) {
                str3 = left.processName;
            } else {
                str3 = null;
            }
            a.C8206a c8206a = hashMap.get(str3);
            if (c8206a == null) {
                return 1;
            }
            HashMap<String, a.C8206a> hashMap2 = this.f257836e;
            if (right != null) {
                str4 = right.processName;
            }
            a.C8206a c8206a2 = hashMap2.get(str4);
            if (c8206a2 == null) {
                return -1;
            }
            return Intrinsics.compare(c8206a2.d(), c8206a.d());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31791);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257834a = new ProcessPriorityCounter();
        }
    }

    ProcessPriorityCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(HashMap<String, a.C8206a> processToMemInfo, Map<String, Pair<Integer, Integer>> priorityIndexMap, String hostProcessName) {
        int i3;
        int i16;
        ArrayList<String> c16;
        int i17;
        Pair<Integer, Integer> pair = priorityIndexMap.get(hostProcessName);
        if (pair != null) {
            i3 = pair.getFirst().intValue();
        } else {
            i3 = 0;
        }
        if (pair != null) {
            i16 = pair.getSecond().intValue();
        } else {
            i16 = 0;
        }
        a.C8206a c8206a = processToMemInfo.get(hostProcessName);
        if (c8206a != null && (c16 = c8206a.c()) != null) {
            for (String str : c16) {
                if (priorityIndexMap.containsKey(str)) {
                    Pair<Integer, Integer> pair2 = priorityIndexMap.get(str);
                    if (pair2 != null) {
                        i17 = pair2.getSecond().intValue();
                    } else {
                        i17 = 0;
                    }
                    if ((i17 & i16) != 0) {
                        QLog.e("ProcessGuard", 1, "there is circular dependency,processName:" + str + ",hostProcessName:" + hostProcessName);
                    } else {
                        priorityIndexMap.put(str, new Pair<>(Integer.valueOf(i3 - 1), Integer.valueOf(i17 | i16)));
                        f257834a.c(processToMemInfo, priorityIndexMap, str);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if (r2.b() == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Integer, ArrayList<String>> d(List<? extends ActivityManager.RunningAppProcessInfo> processList, HashMap<String, a.C8206a> processToMemInfo, int remainingProcessMemory, Function2<? super ActivityManager.RunningAppProcessInfo, ? super Boolean, Boolean> filter) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (remainingProcessMemory / 1024 > b.INSTANCE.b().d()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : processList) {
                a.C8206a c8206a = processToMemInfo.get(runningAppProcessInfo.processName);
                int i3 = 0;
                if (c8206a != null) {
                    z16 = true;
                }
                z16 = false;
                if (filter.invoke(runningAppProcessInfo, Boolean.valueOf(z16)).booleanValue()) {
                    arrayList.add(runningAppProcessInfo.processName);
                    a.C8206a c8206a2 = processToMemInfo.get(runningAppProcessInfo.processName);
                    if (c8206a2 != null) {
                        i3 = c8206a2.d();
                    }
                    remainingProcessMemory -= i3;
                    if (remainingProcessMemory / 1024 <= b.INSTANCE.b().d()) {
                        break;
                    }
                }
            }
        }
        return new Pair<>(Integer.valueOf(remainingProcessMemory), arrayList);
    }

    private final List<ActivityManager.RunningAppProcessInfo> e(HashMap<String, a.C8206a> processToMemInfo, List<? extends ActivityManager.RunningAppProcessInfo> appProcessList, List<? extends ActivityManager.RunningAppProcessInfo> originAppProcessList) {
        ArrayList<String> c16;
        boolean z16;
        Object obj;
        ArrayList arrayList = new ArrayList();
        List<? extends ActivityManager.RunningAppProcessInfo> list = appProcessList;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            a.C8206a c8206a = processToMemInfo.get(runningAppProcessInfo.processName);
            if (c8206a != null && (c16 = c8206a.c()) != null) {
                for (String str : c16) {
                    boolean z17 = true;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((ActivityManager.RunningAppProcessInfo) it.next()).processName, str)) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                        if (!arrayList.isEmpty()) {
                            Iterator it5 = arrayList.iterator();
                            while (it5.hasNext()) {
                                if (Intrinsics.areEqual(((ActivityManager.RunningAppProcessInfo) it5.next()).processName, str)) {
                                    break;
                                }
                            }
                        }
                        z17 = false;
                        if (z17) {
                            Iterator<T> it6 = originAppProcessList.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    obj = it6.next();
                                    if (Intrinsics.areEqual(((ActivityManager.RunningAppProcessInfo) obj).processName, str)) {
                                        break;
                                    }
                                } else {
                                    obj = null;
                                    break;
                                }
                            }
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 = (ActivityManager.RunningAppProcessInfo) obj;
                            if (runningAppProcessInfo2 != null) {
                                arrayList.add(runningAppProcessInfo2);
                                if (QLog.isColorLevel()) {
                                    QLog.d("ProcessGuard", 2, "getCeilingKillProcessList, add " + runningAppProcessInfo2.processName + " to additionProcessList,configured by process " + runningAppProcessInfo.processName);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private final Map<String, Integer> g(HashMap<String, a.C8206a> processToMemInfo, List<ActivityManager.RunningAppProcessInfo> appProcessList) {
        int mapCapacity;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<ActivityManager.RunningAppProcessInfo> list = appProcessList;
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = ((ActivityManager.RunningAppProcessInfo) obj).processName;
            Intrinsics.checkNotNullExpressionValue(str, "processInfo.processName");
            linkedHashMap.put(str, new Pair(0, Integer.valueOf(1 << i3)));
            i3 = i16;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            ProcessPriorityCounter processPriorityCounter = f257834a;
            String str2 = runningAppProcessInfo.processName;
            Intrinsics.checkNotNullExpressionValue(str2, "it.processName");
            processPriorityCounter.c(processToMemInfo, linkedHashMap, str2);
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), Integer.valueOf(((Number) ((Pair) entry.getValue()).getFirst()).intValue()));
        }
        if (QLog.isColorLevel()) {
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                QLog.d("ProcessGuard", 2, "getConfiguredProcessPriorityMap, processName: " + ((String) entry2.getKey()) + ", configured priority: " + ((Number) entry2.getValue()).intValue());
            }
        }
        return linkedHashMap2;
    }

    private final Function2<ActivityManager.RunningAppProcessInfo, Boolean, Boolean> i() {
        return ProcessPriorityCounter$highPriorityProcessRule$1.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(ActivityManager.RunningAppProcessInfo processInfo) {
        if (processInfo.importance == 125) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(ActivityManager.RunningAppProcessInfo processInfo) {
        if (processInfo.importance == 200 && processInfo.importanceReasonCode != 0) {
            return true;
        }
        return false;
    }

    private final Function2<ActivityManager.RunningAppProcessInfo, Boolean, Boolean> l() {
        return ProcessPriorityCounter$lessImportantProcessRule$1.INSTANCE;
    }

    private final Function2<ActivityManager.RunningAppProcessInfo, Boolean, Boolean> m() {
        return ProcessPriorityCounter$noImportantProcessRule$1.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00be, code lost:
    
        if (r1.contains(r5.a(r6, r9.pid)) == false) goto L34;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<String> f(@NotNull HashMap<String, a.C8206a> processToMemInfo) {
        Set<String> set;
        List<String> list;
        int i3;
        List<? extends ActivityManager.RunningAppProcessInfo> mutableList;
        List<? extends ActivityManager.RunningAppProcessInfo> sortedWith;
        boolean startsWith$default;
        boolean z16;
        List<String> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) processToMemInfo);
        }
        Intrinsics.checkNotNullParameter(processToMemInfo, "processToMemInfo");
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses != null) {
            set = CollectionsKt___CollectionsKt.toSet(b.INSTANCE.b().f());
            Set<String> d16 = com.tencent.mobileqq.perf.process.state.floating.a.f257938a.d(set);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = runningAppProcesses.iterator();
            while (true) {
                list = null;
                boolean z17 = true;
                i3 = 0;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                String str = runningAppProcessInfo.processName;
                Intrinsics.checkNotNullExpressionValue(str, "it.processName");
                String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
                Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, PACKAGE_NAME, false, 2, null);
                if (startsWith$default && processToMemInfo.containsKey(runningAppProcessInfo.processName) && !b.INSTANCE.b().j().contains(runningAppProcessInfo.processName)) {
                    GuardManager guardManager = GuardManager.sInstance;
                    if (guardManager != null && (list2 = guardManager.mLastFgProcess) != null && !list2.contains(runningAppProcessInfo.processName)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        com.tencent.mobileqq.perf.process.state.floating.b bVar = com.tencent.mobileqq.perf.process.state.floating.b.f257940a;
                        String str2 = runningAppProcessInfo.processName;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.processName");
                    }
                }
                z17 = false;
                if (z17) {
                    arrayList.add(next);
                }
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            List<ActivityManager.RunningAppProcessInfo> e16 = e(processToMemInfo, mutableList, runningAppProcesses);
            if (!e16.isEmpty()) {
                mutableList.addAll(e16);
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getCeilingKillProcessList, lastFgProcessName: ");
                GuardManager guardManager2 = GuardManager.sInstance;
                if (guardManager2 != null) {
                    list = guardManager2.mLastFgProcess;
                }
                sb5.append(list);
                QLog.d("ProcessGuard", 2, sb5.toString());
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : mutableList) {
                    QLog.d("ProcessGuard", 2, "getCeilingKillProcessList, processName: " + runningAppProcessInfo2.processName + ", importance: " + runningAppProcessInfo2.importance);
                }
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(mutableList, new a(g(processToMemInfo, mutableList), processToMemInfo));
            ArrayList<String> arrayList2 = new ArrayList<>();
            Collection<a.C8206a> values = processToMemInfo.values();
            Intrinsics.checkNotNullExpressionValue(values, "processToMemInfo.values");
            Iterator<T> it5 = values.iterator();
            while (it5.hasNext()) {
                i3 += ((a.C8206a) it5.next()).d();
            }
            Pair<Integer, ArrayList<String>> d17 = d(sortedWith, processToMemInfo, i3, m());
            int intValue = d17.getFirst().intValue();
            arrayList2.addAll(d17.getSecond());
            Pair<Integer, ArrayList<String>> d18 = d(sortedWith, processToMemInfo, intValue, l());
            int intValue2 = d18.getFirst().intValue();
            arrayList2.addAll(d18.getSecond());
            arrayList2.addAll(d(sortedWith, processToMemInfo, intValue2, i()).getSecond());
            Iterator<T> it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                QLog.d("ProcessGuard", 1, "getCeilingKillProcessList, process: " + ((String) it6.next()));
            }
            return arrayList2;
        }
        return new ArrayList<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a0, code lost:
    
        if (r5 == false) goto L37;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<String> h(@NotNull HashMap<String, a.C8206a> processToMemInfo) {
        int collectionSizeOrDefault;
        boolean startsWith$default;
        boolean z16;
        boolean z17;
        List<String> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) processToMemInfo);
        }
        Intrinsics.checkNotNullParameter(processToMemInfo, "processToMemInfo");
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses == null) {
            return new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = runningAppProcesses.iterator();
        while (true) {
            boolean z18 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
            String str = runningAppProcessInfo.processName;
            Intrinsics.checkNotNullExpressionValue(str, "it.processName");
            String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
            Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, PACKAGE_NAME, false, 2, null);
            if (startsWith$default && !b.INSTANCE.b().j().contains(runningAppProcessInfo.processName)) {
                GuardManager guardManager = GuardManager.sInstance;
                if (guardManager != null && (list = guardManager.mLastFgProcess) != null && !list.contains(runningAppProcessInfo.processName)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    a.C8206a c8206a = processToMemInfo.get(runningAppProcessInfo.processName);
                    if (c8206a != null && c8206a.b()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
            }
            z18 = false;
            if (z18) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((ActivityManager.RunningAppProcessInfo) it5.next()).processName);
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            QLog.d("ProcessGuard", 1, "getNoImportantProcessList, process: " + ((String) it6.next()));
        }
        return new ArrayList<>(arrayList2);
    }
}
