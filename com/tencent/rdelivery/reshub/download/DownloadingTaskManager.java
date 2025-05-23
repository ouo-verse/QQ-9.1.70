package com.tencent.rdelivery.reshub.download;

import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/reshub/download/DownloadingTaskManager;", "", "Lcom/tencent/rdelivery/reshub/download/b;", "task", "", "a", "d", "", "resId", "", "c", "", "b", "f", "(Lcom/tencent/rdelivery/reshub/download/b;)V", "e", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", Constants.Raft.TASKS, "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class DownloadingTaskManager {

    /* renamed from: b, reason: collision with root package name */
    public static final DownloadingTaskManager f364485b = new DownloadingTaskManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<b> tasks = new ArrayList<>();

    DownloadingTaskManager() {
    }

    private final synchronized void a(b task) {
        tasks.add(task);
    }

    private final synchronized List<b> c(String resId) {
        ArrayList arrayList;
        ArrayList<b> arrayList2 = tasks;
        arrayList = new ArrayList();
        for (Object obj : arrayList2) {
            if (Intrinsics.areEqual(((b) obj).getResId(), resId)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final synchronized void d(final b task) {
        CollectionsKt__MutableCollectionsKt.removeAll((List) tasks, (Function1) new Function1<b, Boolean>() { // from class: com.tencent.rdelivery.reshub.download.DownloadingTaskManager$removeTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(b bVar) {
                return Boolean.valueOf(invoke2(bVar));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(@NotNull b it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it == b.this;
            }
        });
    }

    public final boolean b(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        List<b> c16 = c(resId);
        if (c16.isEmpty()) {
            return false;
        }
        while (true) {
            boolean z16 = true;
            for (b bVar : c16) {
                if (!z16 || !bVar.a()) {
                    z16 = false;
                }
            }
            return z16;
        }
    }

    public final void e(@NotNull b task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        d(task);
    }

    public final void f(@NotNull b task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        a(task);
    }
}
