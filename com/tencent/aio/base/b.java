package com.tencent.aio.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.AIORecycleView;
import com.tencent.aio.api.list.f;
import com.tencent.aio.api.list.h;
import com.tencent.aio.api.list.i;
import com.tencent.aio.data.msglist.a;
import com.tencent.aio.exception.AIOException;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0002\b\u0003H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a$\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0000\u00a8\u0006\u0011"}, d2 = {"Landroidx/recyclerview/widget/AIORecycleView;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "function", "b", "Lcom/tencent/aio/data/msglist/a$a;", "", "viewHolderType", "d", "c", "Lcom/tencent/aio/api/list/f;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Lcom/tencent/aio/api/list/a;", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    @NotNull
    public static final com.tencent.aio.api.list.a<?, ?> a(@NotNull f buildCellVB, @NotNull ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(buildCellVB, "$this$buildCellVB");
        Intrinsics.checkNotNullParameter(parent, "parent");
        a.Companion companion = com.tencent.aio.data.msglist.a.INSTANCE;
        int d16 = d(companion, i3);
        if (buildCellVB instanceof i) {
            return ((i) buildCellVB).a(parent, d16, c(companion, i3));
        }
        if (buildCellVB instanceof h) {
            return ((h) buildCellVB).d(parent, d16);
        }
        throw new AIOException("business side must implement " + i.class.getSimpleName());
    }

    public static final void b(@NotNull AIORecycleView call, @NotNull Function1<? super AIORecycleView, Unit> function) {
        Intrinsics.checkNotNullParameter(call, "$this$call");
        Intrinsics.checkNotNullParameter(function, "function");
        call.setCoreOperationFlag$sdk_debug(true);
        function.invoke(call);
        call.setCoreOperationFlag$sdk_debug(false);
    }

    public static final int c(@NotNull a.Companion getViewHolderSubType, int i3) {
        Intrinsics.checkNotNullParameter(getViewHolderSubType, "$this$getViewHolderSubType");
        return ((-65536) & i3) >> 16;
    }

    public static final int d(@NotNull a.Companion getViewHolderViewType, int i3) {
        Intrinsics.checkNotNullParameter(getViewHolderViewType, "$this$getViewHolderViewType");
        return 65535 & i3;
    }
}
