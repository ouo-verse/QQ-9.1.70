package com.tencent.mobileqq.nearbypro.map.marker.multitype;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/marker/multitype/ItemDelegateNotFoundException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "clz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ItemDelegateNotFoundException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemDelegateNotFoundException(@NotNull Class<?> clz) {
        super("please confirm whether " + clz.getSimpleName() + " has been configured");
        Intrinsics.checkNotNullParameter(clz, "clz");
    }
}
