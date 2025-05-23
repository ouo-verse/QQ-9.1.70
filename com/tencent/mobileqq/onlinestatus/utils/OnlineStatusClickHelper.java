package com.tencent.mobileqq.onlinestatus.utils;

import android.content.Context;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/OnlineStatusClickHelper;", "", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime$Status;", "status", "", "extStatus", "", "b", "", "Lcom/tencent/mobileqq/onlinestatus/utils/i;", "a", "Lkotlin/Lazy;", "()Ljava/util/List;", "mProcessList", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusClickHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mProcessList;

    public OnlineStatusClickHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends i>>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusClickHelper$mProcessList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends i> invoke() {
                List<? extends i> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new i[]{new t(), new c()});
                return listOf;
            }
        });
        this.mProcessList = lazy;
    }

    private final List<i> a() {
        return (List) this.mProcessList.getValue();
    }

    public final boolean b(@NotNull Context context, @NotNull AppRuntime.Status status, long extStatus) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(status, "status");
        for (i iVar : a()) {
            if (iVar.a(status, extStatus)) {
                return iVar.b(context, status, extStatus);
            }
        }
        return false;
    }
}
