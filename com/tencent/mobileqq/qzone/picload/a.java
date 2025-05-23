package com.tencent.mobileqq.qzone.picload;

import com.tencent.libra.request.IpPortMappingConfig;
import com.tencent.qqnt.kernel.nativeinterface.ServerAddress;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0000j\b\u0012\u0004\u0012\u00020\u0003`\u0002*\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0002\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ServerAddress;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/libra/request/c;", "a", "b", "qzone-picload-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    @NotNull
    public static final ArrayList<IpPortMappingConfig> a(@Nullable ArrayList<ServerAddress> arrayList) {
        boolean z16;
        ArrayList<IpPortMappingConfig> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return arrayList2;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(b((ServerAddress) it.next()));
        }
        return arrayList2;
    }

    @NotNull
    public static final IpPortMappingConfig b(@NotNull ServerAddress serverAddress) {
        Intrinsics.checkNotNullParameter(serverAddress, "<this>");
        String str = serverAddress.f359217ip;
        Intrinsics.checkNotNullExpressionValue(str, "this.ip");
        return new IpPortMappingConfig(str, serverAddress.port);
    }
}
