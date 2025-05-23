package com.tencent.mobileqq.wink.preview.viewmodel;

import android.os.SystemClock;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.preview.WinkSharePreviewException;
import com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$requestAndProcessData$1$1$downloadDeferred$1", f = "WinkBasePreviewShareViewModel.kt", i = {}, l = {145, 143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkBasePreviewShareViewModel$requestAndProcessData$1$1$downloadDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends String>, ? extends Long>>, Object> {
    final /* synthetic */ Deferred<Pair<MetaMaterial, Long>> $mateDeferred;
    final /* synthetic */ List<String> $urls;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WinkBasePreviewShareViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkBasePreviewShareViewModel$requestAndProcessData$1$1$downloadDeferred$1(WinkBasePreviewShareViewModel winkBasePreviewShareViewModel, List<String> list, Deferred<Pair<MetaMaterial, Long>> deferred, Continuation<? super WinkBasePreviewShareViewModel$requestAndProcessData$1$1$downloadDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkBasePreviewShareViewModel;
        this.$urls = list;
        this.$mateDeferred = deferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkBasePreviewShareViewModel$requestAndProcessData$1$1$downloadDeferred$1(this.this$0, this.$urls, this.$mateDeferred, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<? extends String>, ? extends Long>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<? extends List<String>, Long>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkBasePreviewShareDataSource S1;
        WinkBasePreviewShareViewModel winkBasePreviewShareViewModel;
        List<String> list;
        int T1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return TuplesKt.to((List) obj, Boxing.boxLong(SystemClock.elapsedRealtime()));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                winkBasePreviewShareViewModel = (WinkBasePreviewShareViewModel) this.L$2;
                list = (List) this.L$1;
                S1 = (WinkBasePreviewShareDataSource) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                S1 = this.this$0.S1();
                List<String> list2 = this.$urls;
                winkBasePreviewShareViewModel = this.this$0;
                Deferred<Pair<MetaMaterial, Long>> deferred = this.$mateDeferred;
                this.L$0 = S1;
                this.L$1 = list2;
                this.L$2 = winkBasePreviewShareViewModel;
                this.label = 1;
                Object await = deferred.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = await;
            }
            T1 = winkBasePreviewShareViewModel.T1((MetaMaterial) ((Pair) obj).getFirst());
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            obj = S1.e(list, T1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return TuplesKt.to((List) obj, Boxing.boxLong(SystemClock.elapsedRealtime()));
        } catch (Exception e16) {
            throw new WinkSharePreviewException(4, e16);
        }
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<? extends List<String>, Long>> continuation) {
        return ((WinkBasePreviewShareViewModel$requestAndProcessData$1$1$downloadDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
