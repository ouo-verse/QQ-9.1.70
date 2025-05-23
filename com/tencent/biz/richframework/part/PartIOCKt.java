package com.tencent.biz.richframework.part;

import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005\u00a2\u0006\u0002\u0010\u0006\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u001a\u001e\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u001a\u0016\u0010\f\u001a\u00020\b*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a8\u0006\r"}, d2 = {"getIocInterface", "T", "", "Lcom/tencent/biz/richframework/part/Part;", "iocClass", "Ljava/lang/Class;", "(Lcom/tencent/biz/richframework/part/Part;Ljava/lang/Class;)Ljava/lang/Object;", "registerIoc", "", "view", "Landroid/view/View;", "ioc", "unregisterIoc", "part-ioc-ktx_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class PartIOCKt {
    @Nullable
    public static final <T> T getIocInterface(@NotNull Part getIocInterface, @NotNull Class<T> iocClass) {
        Intrinsics.checkNotNullParameter(getIocInterface, "$this$getIocInterface");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        return (T) RFWIocAbilityProvider.g().getIocInterface(iocClass, getIocInterface.getPartRootView(), getIocInterface.mParentView);
    }

    public static final void registerIoc(@NotNull Part registerIoc, @NotNull Object ioc, @NotNull Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(registerIoc, "$this$registerIoc");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        View rootView = registerIoc.getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        registerIoc(registerIoc, rootView, ioc, iocClass);
    }

    public static final void unregisterIoc(@NotNull Part unregisterIoc, @NotNull Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(unregisterIoc, "$this$unregisterIoc");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        RFWIocAbilityProvider.g().unregisterSingleIoc(unregisterIoc.getPartRootView(), iocClass);
    }

    public static final void registerIoc(@NotNull Part registerIoc, @NotNull View view, @NotNull Object ioc, @NotNull Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(registerIoc, "$this$registerIoc");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        String str = "qioc-" + registerIoc.getLogTag();
        int i3 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerIoc  | this = ");
        sb5.append(registerIoc);
        sb5.append(" | ioc = ");
        sb5.append(ioc);
        sb5.append(" | iocClass = ");
        sb5.append(iocClass.getSimpleName());
        sb5.append(" | viewHash = ");
        sb5.append(registerIoc.getPartRootView() != null ? Integer.valueOf(registerIoc.getPartRootView().hashCode()) : null);
        RFWLog.i(str, i3, sb5.toString());
        RFWIocAbilityProvider.g().registerIoc(view, ioc, iocClass);
    }
}
