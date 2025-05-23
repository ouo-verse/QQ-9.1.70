package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.recommend.WinkMusicRecommender;
import com.tencent.mobileqq.wink.picker.core.viewmodel.b;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.interceptor.FetchMusicRecommendInterceptor$intercept$1", f = "FetchMusicRecommendInterceptor.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class FetchMusicRecommendInterceptor$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c.a $chain;
    final /* synthetic */ Ref.ObjectRef<WinkMusicRecommender.a> $musicRecommendData;
    Object L$0;
    int label;
    final /* synthetic */ FetchMusicRecommendInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchMusicRecommendInterceptor$intercept$1(Ref.ObjectRef<WinkMusicRecommender.a> objectRef, c.a aVar, FetchMusicRecommendInterceptor fetchMusicRecommendInterceptor, Continuation<? super FetchMusicRecommendInterceptor$intercept$1> continuation) {
        super(2, continuation);
        this.$musicRecommendData = objectRef;
        this.$chain = aVar;
        this.this$0 = fetchMusicRecommendInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FetchMusicRecommendInterceptor$intercept$1(this.$musicRecommendData, this.$chain, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef<WinkMusicRecommender.a> objectRef;
        T t16;
        CountDownLatch countDownLatch;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                t16 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<WinkMusicRecommender.a> objectRef2 = this.$musicRecommendData;
            WinkMusicRecommender winkMusicRecommender = WinkMusicRecommender.f321453a;
            List<LocalMediaInfo> e16 = this.$chain.e();
            final c.a aVar = this.$chain;
            Function1<WinkMusicRecommender.ProgressState, Unit> function1 = new Function1<WinkMusicRecommender.ProgressState, Unit>() { // from class: com.tencent.mobileqq.wink.picker.interceptor.FetchMusicRecommendInterceptor$intercept$1.1

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.wink.picker.interceptor.FetchMusicRecommendInterceptor$intercept$1$1$a */
                /* loaded from: classes21.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f324873a;

                    static {
                        int[] iArr = new int[WinkMusicRecommender.ProgressState.values().length];
                        try {
                            iArr[WinkMusicRecommender.ProgressState.EXTRA_DONE.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[WinkMusicRecommender.ProgressState.FETCH_MUSIC_DONE.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[WinkMusicRecommender.ProgressState.FETCH_MUSIC_STUCK_DONE.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f324873a = iArr;
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WinkMusicRecommender.ProgressState progressState) {
                    invoke2(progressState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull WinkMusicRecommender.ProgressState it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    int i16 = a.f324873a[it.ordinal()];
                    if (i16 == 1) {
                        b.a.c(c.a.this.b(), PhotoListLogicPreDealDialog.PreDealStep.STEP_EXTRACT, false, 2, null);
                    } else if (i16 == 2) {
                        b.a.c(c.a.this.b(), PhotoListLogicPreDealDialog.PreDealStep.STEP_FETCH_MUSIC, false, 2, null);
                    } else {
                        if (i16 != 3) {
                            return;
                        }
                        b.a.c(c.a.this.b(), PhotoListLogicPreDealDialog.PreDealStep.STEP_FETCH_MUSIC_STUCK, false, 2, null);
                    }
                }
            };
            this.L$0 = objectRef2;
            this.label = 1;
            Object e17 = winkMusicRecommender.e(e16, function1, this);
            if (e17 == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            t16 = e17;
        }
        objectRef.element = t16;
        countDownLatch = this.this$0.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FetchMusicRecommendInterceptor$intercept$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
