package com.tencent.kuikly.core.render.android.core;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderContextMethod;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/render/android/core/e;", "Lkotlin/Function0;", "", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/kuikly/core/render/android/core/KuiklyRenderCore;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "weakRef", "", "e", "Ljava/lang/Object;", "thirdArg", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "(Lcom/tencent/kuikly/core/render/android/core/KuiklyRenderCore;Ljava/lang/Object;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
final class e implements Function0<Unit> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<KuiklyRenderCore> weakRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object thirdArg;

    public e(@NotNull KuiklyRenderCore instance, @NotNull Object thirdArg) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(thirdArg, "thirdArg");
        this.thirdArg = thirdArg;
        this.weakRef = new WeakReference<>(instance);
    }

    public void a() {
        List<? extends Object> listOf;
        KuiklyRenderCore kuiklyRenderCore = this.weakRef.get();
        if (kuiklyRenderCore != null) {
            Intrinsics.checkNotNullExpressionValue(kuiklyRenderCore, "weakRef.get() ?: return");
            com.tencent.kuikly.core.render.android.context.b contextHandler = kuiklyRenderCore.getContextHandler();
            if (contextHandler != null) {
                KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodFireCallback;
                listOf = CollectionsKt__CollectionsKt.listOf(kuiklyRenderCore.getInstanceId(), this.thirdArg);
                contextHandler.call(kuiklyRenderContextMethod, listOf);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        a();
        return Unit.INSTANCE;
    }
}
