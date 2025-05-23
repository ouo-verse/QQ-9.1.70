package com.tencent.qqnt.aio.msg;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a&\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "other", "", "a", "b", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f {
    public static final boolean a(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Integer num = aIOMsgItem.o0().get(1);
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Integer num2 = other.o0().get(1);
        Intrinsics.checkNotNull(num2);
        if (num2.intValue() == intValue) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull AIOMsgItem aIOMsgItem, @NotNull AIOMsgItem other) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Integer num = aIOMsgItem.o0().get(2);
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Integer num2 = other.o0().get(2);
        Intrinsics.checkNotNull(num2);
        if (intValue == num2.intValue()) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final HashMap<Integer, Integer> c(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 0);
        hashMap.put(2, 0);
        return hashMap;
    }
}
