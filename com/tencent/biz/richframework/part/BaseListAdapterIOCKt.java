package com.tencent.biz.richframework.part;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a.\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a6\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a&\u0010\n\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a5\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"", "E", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "ioc", "Ljava/lang/Class;", "iocClass", "", "registerIoc", "Landroid/view/View;", "view", "unregisterIoc", "T", "getIocInterface", "(Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;Ljava/lang/Class;)Ljava/lang/Object;", "part-ioc-ktx_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class BaseListAdapterIOCKt {
    public static final <T, E> T getIocInterface(@NotNull BaseListViewAdapter<E> getIocInterface, @NotNull Class<T> iocClass) {
        Intrinsics.checkNotNullParameter(getIocInterface, "$this$getIocInterface");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        return (T) RFWIocAbilityProvider.g().getIocInterface(iocClass, getIocInterface.getRecyclerView(), null);
    }

    public static final <E> void registerIoc(@NotNull BaseListViewAdapter<E> registerIoc, @NotNull Object ioc, @NotNull Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(registerIoc, "$this$registerIoc");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        RecyclerView recyclerView = registerIoc.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        registerIoc(registerIoc, recyclerView, ioc, iocClass);
    }

    public static final <E> void unregisterIoc(@NotNull BaseListViewAdapter<E> unregisterIoc, @NotNull Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(unregisterIoc, "$this$unregisterIoc");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        RFWIocAbilityProvider.g().unregisterSingleIoc(unregisterIoc.getRecyclerView(), iocClass);
    }

    public static final <E> void registerIoc(@NotNull BaseListViewAdapter<E> registerIoc, @NotNull View view, @NotNull Object ioc, @NotNull Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(registerIoc, "$this$registerIoc");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        int i3 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerIoc  | this = ");
        sb5.append(registerIoc);
        sb5.append(" | ioc = ");
        sb5.append(ioc);
        sb5.append(" | iocClass = ");
        sb5.append(iocClass.getSimpleName());
        sb5.append(" | viewHash = ");
        sb5.append(registerIoc.getRecyclerView() != null ? Integer.valueOf(registerIoc.getRecyclerView().hashCode()) : null);
        RFWLog.i("qioc-BaseListViewAdapter", i3, sb5.toString());
        RFWIocAbilityProvider.g().registerIoc(view, ioc, iocClass);
    }
}
