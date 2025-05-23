package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send;

import com.tencent.qphone.base.util.QLog;
import ij1.GuildMediaUploadTaskInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u0002`\u0004*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qqnt/msg/api/c;", "", "Lij1/m;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/UploadResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask$uploadPic$job$1", f = "ICommentTask.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class ICommentTask$uploadPic$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.tencent.qqnt.msg.api.c<Collection<? extends GuildMediaUploadTaskInfo>>>, Object> {
    int label;
    final /* synthetic */ ICommentTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ICommentTask$uploadPic$job$1(ICommentTask iCommentTask, Continuation<? super ICommentTask$uploadPic$job$1> continuation) {
        super(2, continuation);
        this.this$0 = iCommentTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ICommentTask$uploadPic$job$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super com.tencent.qqnt.msg.api.c<Collection<? extends GuildMediaUploadTaskInfo>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super com.tencent.qqnt.msg.api.c<Collection<GuildMediaUploadTaskInfo>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        in1.c j3;
        List emptyList;
        GuildMediaUploadTaskInfo guildMediaUploadTaskInfo;
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
            j3 = this.this$0.j();
            this.label = 1;
            obj = j3.k(true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h hVar = (com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h) obj;
        Collection<com.tencent.mobileqq.guild.data.o> values = hVar.f().values();
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.guild.data.o oVar : values) {
            if (oVar instanceof GuildMediaUploadTaskInfo) {
                guildMediaUploadTaskInfo = (GuildMediaUploadTaskInfo) oVar;
            } else {
                guildMediaUploadTaskInfo = null;
            }
            if (guildMediaUploadTaskInfo != null) {
                arrayList.add(guildMediaUploadTaskInfo);
            }
        }
        if (hVar.g() && (!arrayList.isEmpty())) {
            QLog.i(this.this$0.getLogTag(), 1, "[uploadPic]: upload pic success, taskInfoMap.size=" + arrayList.size());
            return new com.tencent.qqnt.msg.api.c(arrayList, 0, "uploadPic success");
        }
        QLog.e(this.this$0.getLogTag(), 1, "[uploadPic]: upload pic failed, taskInfoMap.size=" + arrayList.size() + ", errorMsg=" + hVar.getErrMsg());
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new com.tencent.qqnt.msg.api.c(emptyList, hVar.getResult(), hVar.getErrMsg());
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super com.tencent.qqnt.msg.api.c<Collection<GuildMediaUploadTaskInfo>>> continuation) {
        return ((ICommentTask$uploadPic$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
