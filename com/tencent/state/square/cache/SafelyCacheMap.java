package com.tencent.state.square.cache;

import java.io.File;
import java.util.Comparator;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0010\u001a\u00020\fR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00020\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/cache/SafelyCacheMap;", "Ljava/util/Comparator;", "Ljava/io/File;", "Lkotlin/Comparator;", "()V", "map", "Ljava/util/TreeSet;", "kotlin.jvm.PlatformType", "add", "", "file", "compare", "", "o1", "o2", "removeFirstOrNull", "size", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SafelyCacheMap implements Comparator<File> {
    private final TreeSet<File> map = new TreeSet<>(this);

    public final void add(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        synchronized (this.map) {
            this.map.add(file);
        }
    }

    @Nullable
    public final File removeFirstOrNull() {
        File pollFirst;
        synchronized (this.map) {
            pollFirst = this.map.pollFirst();
        }
        return pollFirst;
    }

    public final int size() {
        return this.map.size();
    }

    @Override // java.util.Comparator
    public int compare(@Nullable File o16, @Nullable File o26) {
        return (int) ((o16 != null ? o16.lastModified() : 0L) - (o26 != null ? o26.lastModified() : 0L));
    }
}
