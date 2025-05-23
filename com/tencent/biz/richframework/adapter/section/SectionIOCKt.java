package com.tencent.biz.richframework.adapter.section;

import android.view.View;
import androidx.recyclerview.widget.RecyclerViewHelper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.section.Section;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"getIocInterface", "T", "", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "iocClass", "Ljava/lang/Class;", "(Lcom/tencent/biz/richframework/part/adapter/section/Section;Ljava/lang/Class;)Ljava/lang/Object;", "part-ioc-ktx_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class SectionIOCKt {
    @Nullable
    public static final <T> T getIocInterface(@NotNull Section<?> getIocInterface, @NotNull Class<T> iocClass) {
        Intrinsics.checkNotNullParameter(getIocInterface, "$this$getIocInterface");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        RecyclerViewHelper recyclerViewHelper = RecyclerViewHelper.INSTANCE;
        View rootView = getIocInterface.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return (T) RFWIocAbilityProvider.g().getIocInterface(iocClass, getIocInterface.getRootView(), recyclerViewHelper.getOwnerRecyclerView(rootView));
    }
}
