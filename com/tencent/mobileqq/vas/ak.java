package com.tencent.mobileqq.vas;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/ak;", "Lcom/tencent/qqnt/aio/msg/c;", "", "Lcom/tencent/qqnt/aio/msg/b;", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ak implements com.tencent.qqnt.aio.msg.c {
    @Override // com.tencent.qqnt.aio.msg.c
    @NotNull
    public List<com.tencent.qqnt.aio.msg.b> a() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new VasAIODataProcessor());
        return arrayListOf;
    }
}
