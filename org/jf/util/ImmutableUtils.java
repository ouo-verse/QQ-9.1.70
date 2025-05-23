package org.jf.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableUtils {
    @Nonnull
    public static <T> ImmutableList<T> nullToEmptyList(@Nullable ImmutableList<T> immutableList) {
        if (immutableList == null) {
            return ImmutableList.of();
        }
        return immutableList;
    }

    @Nonnull
    public static <T> ImmutableSet<T> nullToEmptySet(@Nullable ImmutableSet<T> immutableSet) {
        if (immutableSet == null) {
            return ImmutableSet.of();
        }
        return immutableSet;
    }

    @Nonnull
    public static <T> ImmutableSortedSet<T> nullToEmptySortedSet(@Nullable ImmutableSortedSet<T> immutableSortedSet) {
        if (immutableSortedSet == null) {
            return ImmutableSortedSet.of();
        }
        return immutableSortedSet;
    }
}
