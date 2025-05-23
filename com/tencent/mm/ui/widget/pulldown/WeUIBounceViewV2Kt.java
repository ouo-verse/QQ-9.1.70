package com.tencent.mm.ui.widget.pulldown;

import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0000\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"removeFirstCompat", "T", "", "(Ljava/util/List;)Ljava/lang/Object;", "weui-native-android-lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class WeUIBounceViewV2Kt {
    public static final <T> T removeFirstCompat(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        throw new NoSuchElementException("List is empty.");
    }
}
