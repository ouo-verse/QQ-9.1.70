package com.tencent.rdelivery.reshub.util;

import com.tencent.rdelivery.reshub.api.o;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J!\u0010\u0011\u001a\u00020\n2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\r\u00a2\u0006\u0002\b\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/ResRefreshManager;", "", "Ljz3/e;", "oldConfig", "newConfig", "", "a", "", "resId", "resConfig", "", "c", "d", "Lkotlin/Function1;", "Lcom/tencent/rdelivery/reshub/api/o;", "Lkotlin/ExtensionFunctionType;", "action", "b", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "currentResMap", "Lcom/tencent/rdelivery/reshub/api/o;", "refreshListener", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ResRefreshManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, jz3.e> currentResMap = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile o refreshListener;

    private final boolean a(jz3.e oldConfig, jz3.e newConfig) {
        if (newConfig.f411261b != oldConfig.f411261b || (!Intrinsics.areEqual(newConfig.G, oldConfig.G)) || (!Intrinsics.areEqual(newConfig.f411272m, oldConfig.f411272m)) || (!Intrinsics.areEqual(newConfig.f411277r, oldConfig.f411277r)) || newConfig.f411278s != oldConfig.f411278s) {
            return true;
        }
        return false;
    }

    private final void b(final Function1<? super o, Unit> action) {
        final o oVar = this.refreshListener;
        if (oVar != null) {
            ResLoadCallbackUtilKt.m(com.tencent.rdelivery.reshub.core.j.L.P(), new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResRefreshManager$doCallback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ResLoadCallbackUtilKt.n("onResRefreshed", new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResRefreshManager$doCallback$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ResRefreshManager$doCallback$1 resRefreshManager$doCallback$1 = ResRefreshManager$doCallback$1.this;
                            Function1.this.invoke(oVar);
                        }
                    });
                }
            });
        }
    }

    private final void c(final String resId, final jz3.e resConfig) {
        b(new Function1<o, Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResRefreshManager$doResFirstLoaded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(o oVar) {
                invoke2(oVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull o receiver) {
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                receiver.b(resId, resConfig);
            }
        });
    }

    private final void d(final String resId, final jz3.e resConfig) {
        b(new Function1<o, Unit>() { // from class: com.tencent.rdelivery.reshub.util.ResRefreshManager$doResRefreshed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(o oVar) {
                invoke2(oVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull o receiver) {
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                receiver.a(resId, resConfig);
            }
        });
    }

    public final void e(@Nullable jz3.e resConfig) {
        String str;
        if (resConfig != null && (str = resConfig.f411260a) != null) {
            jz3.e eVar = this.currentResMap.get(str);
            if (eVar == null) {
                this.currentResMap.put(str, resConfig);
                c(str, resConfig);
            } else if (a(eVar, resConfig)) {
                this.currentResMap.put(str, resConfig);
                d(str, resConfig);
            }
        }
    }
}
