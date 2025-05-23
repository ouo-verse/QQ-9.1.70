package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadResConfigPrinter;", "", "", "Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadModuleImpl;", "configList", "", "a", "Lcom/tencent/mobileqq/vip/g;", "downloadTask", "Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadResourceImpl;", "resourceImpl", "b", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PreloadResConfigPrinter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PreloadResConfigPrinter f279031a = new PreloadResConfigPrinter();

    PreloadResConfigPrinter() {
    }

    public final void a(@NotNull List<? extends PreloadModuleImpl> configList) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(configList, "configList");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(configList, null, null, null, 0, null, new Function1<PreloadModuleImpl, CharSequence>() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadResConfigPrinter$print$str$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull PreloadModuleImpl module) {
                String joinToString$default2;
                Intrinsics.checkNotNullParameter(module, "module");
                String str = module.mid;
                List<PreloadResourceImpl> resList = module.getResList();
                Intrinsics.checkNotNullExpressionValue(resList, "module.resList");
                joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(resList, null, null, null, 0, null, new Function1<PreloadResourceImpl, CharSequence>() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadResConfigPrinter$print$str$1.1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(PreloadResourceImpl preloadResourceImpl) {
                        String stringEx = preloadResourceImpl.toStringEx();
                        Intrinsics.checkNotNullExpressionValue(stringEx, "it.toStringEx()");
                        return stringEx;
                    }
                }, 31, null);
                return "\u3010moduleId=" + str + joinToString$default2 + "\u3011";
            }
        }, 31, null);
        QLog.i("PreloadResConfigPrinter", 1, String.valueOf(joinToString$default));
    }

    public final void b(@NotNull g downloadTask, @NotNull PreloadResourceImpl resourceImpl) {
        Intrinsics.checkNotNullParameter(downloadTask, "downloadTask");
        Intrinsics.checkNotNullParameter(resourceImpl, "resourceImpl");
        QLog.i("PreloadResConfigPrinter", 1, String.valueOf("resId=" + resourceImpl.getResId() + " Code=" + downloadTask.f313006d + " errMsg=" + downloadTask.f313007e));
    }
}
