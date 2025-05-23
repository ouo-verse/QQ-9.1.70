package com.tencent.qqnt.aio.emoReply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a$\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a8\u0006\u0006"}, d2 = {"T", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/Comparator;", "comparator", "", "a", "aio_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {
    public static final <T> void a(@NotNull CopyOnWriteArrayList<T> copyOnWriteArrayList, @NotNull Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (copyOnWriteArrayList.size() > 1) {
            ArrayList arrayList = new ArrayList(copyOnWriteArrayList);
            Collections.sort(arrayList, comparator);
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(arrayList);
        }
    }
}
