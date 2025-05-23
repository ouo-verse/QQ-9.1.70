package com.tencent.mobileqq.wink.dailysign;

import android.os.SystemClock;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.dailysign.DailyDataSource$downloadDailySignTemplateAsync$mateDeferred$1", f = "DailyDataSource.kt", i = {0}, l = {138}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
/* loaded from: classes21.dex */
public final class DailyDataSource$downloadDailySignTemplateAsync$mateDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DailySignConfig $dailySignConfig;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyDataSource$downloadDailySignTemplateAsync$mateDeferred$1(DailySignConfig dailySignConfig, Continuation<? super DailyDataSource$downloadDailySignTemplateAsync$mateDeferred$1> continuation) {
        super(2, continuation);
        this.$dailySignConfig = dailySignConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DailyDataSource$downloadDailySignTemplateAsync$mateDeferred$1(this.$dailySignConfig, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    j3 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                DailyDataSource dailyDataSource = DailyDataSource.f318060a;
                DailySignConfig dailySignConfig = this.$dailySignConfig;
                this.J$0 = elapsedRealtime;
                this.label = 1;
                obj = dailyDataSource.g(dailySignConfig, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = elapsedRealtime;
            }
            Triple triple = (Triple) obj;
            if (triple.getFirst() != null) {
                this.$dailySignConfig.setMetaMaterial((MetaMaterial) triple.getFirst());
                this.$dailySignConfig.setNeedDownLoadTemplate(((Boolean) triple.getSecond()).booleanValue());
                this.$dailySignConfig.setLoadMateTime(SystemClock.elapsedRealtime() - j3);
                Object first = triple.getFirst();
                Intrinsics.checkNotNull(first);
                String m3 = WinkEditorResourceManager.a1().m((MetaMaterial) triple.getFirst());
                Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(mate.first)");
                com.tencent.mobileqq.wink.editor.c.D1((MetaMaterial) first, m3);
                WinkEditorResourceManager.a1().i0(this.$dailySignConfig.getMetaMaterial());
                return Unit.INSTANCE;
            }
            throw new ResLoadException(3, new Exception("findAndDownloadMaterial error"));
        } catch (IllegalStateException e16) {
            throw new ResLoadException(3, e16);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DailyDataSource$downloadDailySignTemplateAsync$mateDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
