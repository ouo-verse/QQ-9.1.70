package com.tencent.kuikly.core.manager;

import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004J\u0006\u0010\u0007\u001a\u00020\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR8\u0010\u0011\u001a&\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u000ej\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/manager/TaskManager;", "", "Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/manager/Task;", "task", "c", "b", "", "a", "Ljava/lang/String;", "getPagerId", "()Ljava/lang/String;", "pagerId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "taskQueue", "<init>", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TaskManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String pagerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Function0<Unit>> taskQueue;

    public TaskManager(String pagerId) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        this.pagerId = pagerId;
        this.taskQueue = new ArrayList<>();
    }

    public final void b() {
        this.taskQueue.clear();
    }

    public final void c(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.taskQueue.isEmpty()) {
            TimerKt.f(this.pagerId, new Function0<Unit>() { // from class: com.tencent.kuikly.core.manager.TaskManager$nextTick$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    ArrayList arrayList;
                    List list;
                    ArrayList arrayList2;
                    arrayList = TaskManager.this.taskQueue;
                    list = CollectionsKt___CollectionsKt.toList(arrayList);
                    arrayList2 = TaskManager.this.taskQueue;
                    arrayList2.clear();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((Function0) it.next()).invoke();
                    }
                }
            }, 0);
        }
        this.taskQueue.add(task);
    }
}
