package io4;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\b"}, d2 = {"Lio4/m;", "", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "srcUserList", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f408122a = new m();

    m() {
    }

    @NotNull
    public final List<CommonOuterClass$QQUserId> a(@NotNull List<CommonOuterClass$QQUserId> srcUserList) {
        Intrinsics.checkNotNullParameter(srcUserList, "srcUserList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (CommonOuterClass$QQUserId commonOuterClass$QQUserId : srcUserList) {
            long f16 = n.f408123a.f(commonOuterClass$QQUserId);
            if (!arrayList.contains(Long.valueOf(f16))) {
                arrayList.add(Long.valueOf(f16));
                arrayList2.add(commonOuterClass$QQUserId);
            }
        }
        return arrayList2;
    }
}
