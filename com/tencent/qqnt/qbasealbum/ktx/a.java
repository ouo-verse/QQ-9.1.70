package com.tencent.qqnt.qbasealbum.ktx;

import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "T", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "Ljava/lang/Class;", "o", "a", "(Lcom/tencent/biz/richframework/part/BasePartFragment;Ljava/lang/Class;)Lcom/tencent/biz/richframework/part/Part;", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    @Nullable
    public static final <T extends Part> T a(@NotNull BasePartFragment basePartFragment, @NotNull Class<T> o16) {
        Intrinsics.checkNotNullParameter(basePartFragment, "<this>");
        Intrinsics.checkNotNullParameter(o16, "o");
        T t16 = (T) basePartFragment.getPartManager().getPart(o16.getName());
        if (!(t16 instanceof Part)) {
            return null;
        }
        return t16;
    }
}
