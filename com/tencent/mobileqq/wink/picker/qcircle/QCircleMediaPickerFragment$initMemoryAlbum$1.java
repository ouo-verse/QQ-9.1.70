package com.tencent.mobileqq.wink.picker.qcircle;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment$initMemoryAlbum$1", f = "QCircleMediaPickerFragment.kt", i = {0}, l = {211}, m = "invokeSuspend", n = {"isHitShowMemoryAlbum"}, s = {"Z$0"})
/* loaded from: classes21.dex */
final class QCircleMediaPickerFragment$initMemoryAlbum$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QCircleMediaPickerFragment$initMemoryAlbum$1(Continuation<? super QCircleMediaPickerFragment$initMemoryAlbum$1> continuation) {
        super(2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        v83.b.f441239a.i();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QCircleMediaPickerFragment$initMemoryAlbum$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z17 = true;
        if (i3 != 0) {
            if (i3 == 1) {
                z16 = this.Z$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            com.tencent.mobileqq.wink.newalbum.collector.j.INSTANCE.m(1, "exp_xsj_memoryalbum_3");
            boolean Q = w83.b.f445025a.Q();
            v83.e eVar = v83.e.f441245a;
            this.Z$0 = Q;
            this.label = 1;
            Object g16 = eVar.g(this);
            if (g16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            z16 = Q;
            obj = g16;
        }
        w53.b.f("[QCircleMediaPickerFragment]MemoryAlbum", "initMemoryAlbum, isHitShowMemoryAlbum:" + z16 + ", isAuthorized:" + ((Boolean) obj).booleanValue());
        com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
        if (!z16) {
            z17 = false;
        }
        cVar.l(z17);
        com.tencent.mobileqq.wink.newalbum.collector.j.INSTANCE.m(2, "exp_xsj_memoryalbum_3");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.l
            @Override // java.lang.Runnable
            public final void run() {
                QCircleMediaPickerFragment$initMemoryAlbum$1.b();
            }
        }, 128, null, false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QCircleMediaPickerFragment$initMemoryAlbum$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
