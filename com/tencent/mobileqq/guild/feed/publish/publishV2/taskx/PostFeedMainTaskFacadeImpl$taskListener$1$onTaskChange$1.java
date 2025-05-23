package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import ij1.GuildMediaUploadTaskInfo;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PostFeedMainTaskFacadeImpl$taskListener$1$onTaskChange$1", f = "PostFeedMainTaskFacadeImpl.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class PostFeedMainTaskFacadeImpl$taskListener$1$onTaskChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o $info;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedMainTaskFacadeImpl$taskListener$1$onTaskChange$1(o oVar, Continuation<? super PostFeedMainTaskFacadeImpl$taskListener$1$onTaskChange$1> continuation) {
        super(2, continuation);
        this.$info = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostFeedMainTaskFacadeImpl$taskListener$1$onTaskChange$1(this.$info, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Set<String> of5;
        Object firstOrNull;
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
            in1.a a16 = in1.b.a();
            of5 = SetsKt__SetsJVMKt.setOf(this.$info.getFileId());
            this.label = 1;
            obj = a16.a(of5, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) obj);
        GuildMediaProgressState guildMediaProgressState = (GuildMediaProgressState) firstOrNull;
        o oVar = this.$info;
        String str = null;
        if (!(oVar instanceof GuildMediaUploadTaskInfo)) {
            oVar = null;
        }
        GuildMediaUploadTaskInfo guildMediaUploadTaskInfo = (GuildMediaUploadTaskInfo) oVar;
        if (guildMediaUploadTaskInfo != null) {
            if (guildMediaProgressState != null) {
                str = guildMediaProgressState.getMainTaskId();
            }
            if (str == null) {
                str = "";
            }
            GuildMediaProgressState E = guildMediaUploadTaskInfo.E(str);
            if (E != null) {
                in1.b.a().b(E);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PostFeedMainTaskFacadeImpl$taskListener$1$onTaskChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
