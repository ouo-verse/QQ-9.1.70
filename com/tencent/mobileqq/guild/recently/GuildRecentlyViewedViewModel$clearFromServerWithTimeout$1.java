package com.tencent.mobileqq.guild.recently;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGproFeedOperateCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.recently.GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1", f = "GuildRecentlyViewedViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "msg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    static final class a implements IGproFeedOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        public static final a f231971a = new a();

        a() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGproFeedOperateCallback
        public final void onResult(int i3, String str) {
            QLog.d("GuildRecentlyViewedViewModel", 4, "clearFeedsRecentViewHistory result=" + i3 + " msg =" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1(Continuation<? super GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 guildRecentlyViewedViewModel$clearFromServerWithTimeout$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(18000L, guildRecentlyViewedViewModel$clearFromServerWithTimeout$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (obj == null) {
            QLog.e("GuildRecentlyViewedViewModel", 1, "clearFromServerWithTimeout timeOut");
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildRecentlyViewedViewModel$clearFromServerWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
