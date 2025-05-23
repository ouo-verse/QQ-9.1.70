package com.tencent.qqnt.startup.utils;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.startup.execption.StartupException;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002JJ\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0014j\b\u0012\u0004\u0012\u00020\u0002`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/startup/utils/c;", "", "Lcom/tencent/qqnt/startup/task/NtTask;", "lTask", "rTask", "", "b", "", "sortTasks", "", "", "", "childMap", "allTaskMap", "d", "result", "", "e", "startupList", "f", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "Ljava/util/Comparator;", "mTaskComparator", "<init>", "()V", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f362283a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Comparator<NtTask> mTaskComparator;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f362283a = new c();
            mTaskComparator = new Comparator() { // from class: com.tencent.qqnt.startup.utils.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int c16;
                    c16 = c.c((NtTask) obj, (NtTask) obj2);
                    return c16;
                }
            };
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b(NtTask lTask, NtTask rTask) {
        int i3;
        int childSizeRunOnMain$nt_startup_kit_release = lTask.childSizeRunOnMain$nt_startup_kit_release();
        int childSizeRunOnMain$nt_startup_kit_release2 = rTask.childSizeRunOnMain$nt_startup_kit_release();
        List<NtTask> childNodes$nt_startup_kit_release = lTask.getChildNodes$nt_startup_kit_release();
        int i16 = 0;
        if (childNodes$nt_startup_kit_release != null) {
            i3 = childNodes$nt_startup_kit_release.size();
        } else {
            i3 = 0;
        }
        List<NtTask> childNodes$nt_startup_kit_release2 = rTask.getChildNodes$nt_startup_kit_release();
        if (childNodes$nt_startup_kit_release2 != null) {
            i16 = childNodes$nt_startup_kit_release2.size();
        }
        if (lTask.getPriority() != rTask.getPriority()) {
            return rTask.getPriority() - lTask.getPriority();
        }
        if (childSizeRunOnMain$nt_startup_kit_release != childSizeRunOnMain$nt_startup_kit_release2) {
            return childSizeRunOnMain$nt_startup_kit_release2 - childSizeRunOnMain$nt_startup_kit_release;
        }
        if (i3 != i16) {
            return i16 - i3;
        }
        return lTask.getDependencies().size() - rTask.getDependencies().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(NtTask lhs, NtTask rhs) {
        c cVar = f362283a;
        Intrinsics.checkNotNullExpressionValue(lhs, "lhs");
        Intrinsics.checkNotNullExpressionValue(rhs, "rhs");
        return cVar.b(lhs, rhs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<NtTask> d(List<? extends NtTask> sortTasks, Map<String, ? extends List<String>> childMap, Map<String, ? extends NtTask> allTaskMap) {
        e(sortTasks);
        return sortTasks;
    }

    private final void e(List<? extends NtTask> result) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TopologySort result: ");
        sb5.append("\n");
        sb5.append("|================================================================");
        int i3 = 0;
        for (Object obj : result) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            sb5.append("\n");
            sb5.append("|  " + i3 + ". " + ((NtTask) obj));
            sb5.append("\n");
            sb5.append("|----------------------------------------------------------------");
            i3 = i16;
        }
        sb5.append("\n|================================================================");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        a.a("TopologySort", sb6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, com.tencent.qqnt.startup.utils.c] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.PriorityQueue] */
    @NotNull
    public final List<NtTask> f(@NotNull List<? extends NtTask> startupList) {
        ArrayDeque arrayDeque;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) startupList);
        }
        Intrinsics.checkNotNullParameter(startupList, "startupList");
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        if (Build.VERSION.SDK_INT >= 24) {
            arrayDeque = new PriorityQueue(mTaskComparator);
        } else {
            arrayDeque = new ArrayDeque();
        }
        for (NtTask ntTask : startupList) {
            String taskId = ntTask.getTaskId();
            if (!hashMap.containsKey(taskId)) {
                hashMap.put(taskId, ntTask);
                int size = ntTask.getDependencies().size();
                hashMap3.put(taskId, Integer.valueOf(size));
                if (size == 0) {
                    arrayDeque.offer(ntTask);
                } else {
                    for (String str : ntTask.getDependencies()) {
                        if (hashMap2.get(str) == null) {
                            hashMap2.put(str, new ArrayList());
                        }
                        List list = (List) hashMap2.get(str);
                        if (list != null) {
                            list.add(taskId);
                        }
                    }
                }
            } else {
                throw new StartupException("Repeat to add task: " + ntTask);
            }
        }
        if (!arrayDeque.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                NtTask ntTask2 = (NtTask) entry.getValue();
                List childList = (List) hashMap2.get(entry.getKey());
                if (childList != null) {
                    Intrinsics.checkNotNullExpressionValue(childList, "childList");
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = childList.iterator();
                    while (it.hasNext()) {
                        NtTask ntTask3 = (NtTask) hashMap.get((String) it.next());
                        if (ntTask3 != null) {
                            arrayList2.add(ntTask3);
                        }
                    }
                    ntTask2.setChildNodes$nt_startup_kit_release(arrayList2);
                }
            }
            while (!arrayDeque.isEmpty()) {
                NtTask ntTask4 = (NtTask) arrayDeque.poll();
                if (ntTask4 != null) {
                    NtTask ntTask5 = (NtTask) hashMap.get(ntTask4.getTaskId());
                    if (ntTask5 != null) {
                        arrayList.add(ntTask5);
                    }
                    List<String> list2 = (List) hashMap2.get(ntTask4.getTaskId());
                    if (list2 != null) {
                        Intrinsics.checkNotNullExpressionValue(list2, "dependencyMap[it.taskId]");
                        for (String str2 : list2) {
                            Integer num = (Integer) hashMap3.get(str2);
                            hashMap3.put(str2, Integer.valueOf(num != null ? num.intValue() - 1 : 0));
                            Integer num2 = (Integer) hashMap3.get(str2);
                            if (num2 != null && num2.intValue() == 0) {
                                arrayDeque.offer(hashMap.get(str2));
                            }
                        }
                    }
                }
            }
            if (arrayList.size() == startupList.size()) {
                return d(arrayList, hashMap2, hashMap);
            }
            throw new StartupException("Startup dependencies must be cycle or leak.");
        }
        throw new StartupException("Startup dependencies may be cycle.");
    }
}
