package com.tencent.aio.main.businesshelper.p000new;

import com.tencent.aio.helper.c;
import com.tencent.aio.main.businesshelper.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/main/businesshelper/e;", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    public static final void a(@NotNull e handleOnCreate, @NotNull com.tencent.aio.main.businesshelper.b helperParam) {
        Intrinsics.checkNotNullParameter(handleOnCreate, "$this$handleOnCreate");
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        if (handleOnCreate instanceof c) {
            helperParam.b(((c) handleOnCreate).d());
            Unit unit = Unit.INSTANCE;
            handleOnCreate.onCreate(helperParam);
            return;
        }
        handleOnCreate.onCreate(helperParam);
    }
}
