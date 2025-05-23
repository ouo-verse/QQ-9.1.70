package com.tencent.kuikly.core.render.android.core;

import com.tencent.kuikly.core.render.android.context.KuiklyRenderContextMethod;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/kuikly/core/render/android/core/KuiklyRenderCore$setViewProp$1", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderCore$setViewProp$1 implements Function1<Object, Unit> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ KuiklyRenderCore f117573d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f117574e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f117575f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ List f117576h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KuiklyRenderCore$setViewProp$1(KuiklyRenderCore kuiklyRenderCore, boolean z16, int i3, List list) {
        this.f117573d = kuiklyRenderCore;
        this.f117574e = z16;
        this.f117575f = i3;
        this.f117576h = list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        if (r1 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable final Object result) {
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler;
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler2;
        boolean z16;
        boolean o06;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean z17 = this.f117574e;
        booleanRef.element = z17;
        if (!z17) {
            o06 = this.f117573d.o0(result);
            if (o06) {
                booleanRef.element = true;
            }
        }
        if (booleanRef.element) {
            kuiklyRenderCoreUIScheduler2 = this.f117573d.uiScheduler;
            if (kuiklyRenderCoreUIScheduler2 == null || !kuiklyRenderCoreUIScheduler2.getIsPerformingMainQueueTask()) {
                z16 = this.f117573d.syncingPerformTaskMainThreadToContextThread;
            }
            booleanRef.element = false;
        }
        if (booleanRef.element) {
            this.f117573d.syncingPerformTaskMainThreadToContextThread = true;
        }
        KuiklyRenderCore.d0(this.f117573d, 0.0f, booleanRef.element, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.core.KuiklyRenderCore$setViewProp$1$invoke$1
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

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0042, code lost:
            
                r0 = r8.this$0.f117573d.uiScheduler;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler3;
                List<? extends Object> listOf;
                com.tencent.kuikly.core.render.android.context.b contextHandler = KuiklyRenderCore$setViewProp$1.this.f117573d.getContextHandler();
                if (contextHandler != null) {
                    KuiklyRenderContextMethod kuiklyRenderContextMethod = KuiklyRenderContextMethod.KuiklyRenderContextMethodFireViewEvent;
                    listOf = CollectionsKt__CollectionsKt.listOf(KuiklyRenderCore$setViewProp$1.this.f117573d.getInstanceId(), Integer.valueOf(KuiklyRenderCore$setViewProp$1.this.f117575f), com.tencent.kuikly.core.render.android.css.ktx.b.v(KuiklyRenderCore$setViewProp$1.this.f117576h), result);
                    contextHandler.call(kuiklyRenderContextMethod, listOf);
                }
                if (!booleanRef.element || kuiklyRenderCoreUIScheduler3 == null) {
                    return;
                }
                KuiklyRenderCoreUIScheduler.q(kuiklyRenderCoreUIScheduler3, true, false, 2, null);
            }
        }, 1, null);
        if (booleanRef.element) {
            kuiklyRenderCoreUIScheduler = this.f117573d.uiScheduler;
            if (kuiklyRenderCoreUIScheduler != null) {
                kuiklyRenderCoreUIScheduler.n();
            }
            this.f117573d.syncingPerformTaskMainThreadToContextThread = false;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        a(obj);
        return Unit.INSTANCE;
    }
}
