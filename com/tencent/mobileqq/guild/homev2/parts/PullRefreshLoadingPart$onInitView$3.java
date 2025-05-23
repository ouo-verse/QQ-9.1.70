package com.tencent.mobileqq.guild.homev2.parts;

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
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"", "topInsets", "", "coverUrl", "Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart$onInitView$3", f = "PullRefreshLoadingPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class PullRefreshLoadingPart$onInitView$3 extends SuspendLambda implements Function3<Integer, String, Continuation<? super Pair<? extends Integer, ? extends String>>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PullRefreshLoadingPart$onInitView$3(Continuation<? super PullRefreshLoadingPart$onInitView$3> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(int i3, @Nullable String str, @Nullable Continuation<? super Pair<Integer, String>> continuation) {
        PullRefreshLoadingPart$onInitView$3 pullRefreshLoadingPart$onInitView$3 = new PullRefreshLoadingPart$onInitView$3(continuation);
        pullRefreshLoadingPart$onInitView$3.I$0 = i3;
        pullRefreshLoadingPart$onInitView$3.L$0 = str;
        return pullRefreshLoadingPart$onInitView$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i3 = this.I$0;
            return TuplesKt.to(Boxing.boxInt(i3), (String) this.L$0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, Continuation<? super Pair<? extends Integer, ? extends String>> continuation) {
        return invoke(num.intValue(), str, (Continuation<? super Pair<Integer, String>>) continuation);
    }
}
