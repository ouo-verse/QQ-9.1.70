package com.tencent.biz.richframework.part;

import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a6\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006\u001a&\u0010\n\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006\u001a5\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"", "T", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "Landroid/view/View;", "view", "ioc", "Ljava/lang/Class;", "iocClass", "", "registerIoc", "unregisterIoc", "E", "getIocInterface", "(Lcom/tencent/biz/richframework/widget/BaseWidgetView;Ljava/lang/Class;)Ljava/lang/Object;", "part-ioc-ktx_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class BaseWidgetIOCKt {
    public static final <E, T> E getIocInterface(@NotNull BaseWidgetView<T> getIocInterface, @NotNull Class<E> iocClass) {
        Intrinsics.checkNotNullParameter(getIocInterface, "$this$getIocInterface");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        return (E) RFWIocAbilityProvider.g().getIocInterface(iocClass, getIocInterface, getIocInterface.getParentView());
    }

    public static final <T> void registerIoc(@NotNull BaseWidgetView<T> registerIoc, @NotNull View view, @NotNull Object ioc, @NotNull Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(registerIoc, "$this$registerIoc");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        RFWLog.i("qioc-BaseWidgetView", RFWLog.USR, "registerIoc  | this = " + registerIoc + " | ioc = " + ioc + " | iocClass = " + iocClass.getSimpleName() + " | viewHash = " + registerIoc.hashCode());
        RFWIocAbilityProvider.g().registerIoc(view, ioc, iocClass);
    }

    public static final <T> void unregisterIoc(@NotNull BaseWidgetView<T> unregisterIoc, @NotNull Class<?> iocClass) {
        Intrinsics.checkNotNullParameter(unregisterIoc, "$this$unregisterIoc");
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        RFWIocAbilityProvider.g().unregisterSingleIoc(unregisterIoc, iocClass);
    }
}
