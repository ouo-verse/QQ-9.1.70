package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PostFeedMainTaskFacadeImpl$taskListener$1$onCancel$1", f = "PostFeedMainTaskFacadeImpl.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class PostFeedMainTaskFacadeImpl$taskListener$1$onCancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mediumId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedMainTaskFacadeImpl$taskListener$1$onCancel$1(String str, Continuation<? super PostFeedMainTaskFacadeImpl$taskListener$1$onCancel$1> continuation) {
        super(2, continuation);
        this.$mediumId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostFeedMainTaskFacadeImpl$taskListener$1$onCancel$1(this.$mediumId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Set<String> of5;
        Object firstOrNull;
        String str;
        List<String> listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            in1.a a16 = in1.b.a();
            of5 = SetsKt__SetsJVMKt.setOf(this.$mediumId);
            this.label = 1;
            obj = a16.a(of5, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) obj);
        GuildMediaProgressState guildMediaProgressState = (GuildMediaProgressState) firstOrNull;
        if (guildMediaProgressState != null) {
            str = guildMediaProgressState.getMainTaskId();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            in1.a a17 = in1.b.a();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(this.$mediumId);
            a17.delete(listOf);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PostFeedMainTaskFacadeImpl$taskListener$1$onCancel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
