package com.tencent.mobileqq.guild.feed.topic.mvi;

import com.tencent.mobileqq.guild.feed.topic.PageData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopicFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopicFeedsRsp;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/feed/topic/g;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository$innerGetFeeds$rsp$1", f = "TopicFeedsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class TopicFeedsRepository$innerGetFeeds$rsp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.tencent.mobileqq.guild.feed.topic.g>, Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ String $msg;
    final /* synthetic */ GProGetTopicFeedsRsp $rawRsp;
    final /* synthetic */ GProGetTopicFeedsReq $req;
    int label;
    final /* synthetic */ TopicFeedsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicFeedsRepository$innerGetFeeds$rsp$1(TopicFeedsRepository topicFeedsRepository, GProGetTopicFeedsRsp gProGetTopicFeedsRsp, GProGetTopicFeedsReq gProGetTopicFeedsReq, int i3, String str, Continuation<? super TopicFeedsRepository$innerGetFeeds$rsp$1> continuation) {
        super(2, continuation);
        this.this$0 = topicFeedsRepository;
        this.$rawRsp = gProGetTopicFeedsRsp;
        this.$req = gProGetTopicFeedsReq;
        this.$code = i3;
        this.$msg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TopicFeedsRepository$innerGetFeeds$rsp$1(this.this$0, this.$rawRsp, this.$req, this.$code, this.$msg, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List j3;
        List mutableList;
        com.tencent.mobileqq.guild.feed.feedsquare.utils.k kVar;
        long j16;
        boolean z16;
        boolean z17;
        PageData pageData;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            j3 = this.this$0.j(this.$rawRsp);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) j3);
            kVar = this.this$0.helper;
            j16 = this.this$0.mGuildId;
            String valueOf = String.valueOf(j16);
            byte[] bArr = this.$req.attachInfo;
            Intrinsics.checkNotNullExpressionValue(bArr, "req.attachInfo");
            if (bArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z18 = !z16;
            if (this.$rawRsp.isFinish == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            xn1.e eVar = xn1.e.f448187a;
            pageData = this.this$0.mPageData;
            kVar.j(new com.tencent.mobileqq.guild.feed.feedsquare.utils.d(valueOf, "", false, mutableList, z17, z18, eVar.q(pageData.getType()), false));
            ri1.a b16 = ri1.a.b(this.$code, this.$msg);
            Intrinsics.checkNotNullExpressionValue(b16, "error(code, msg)");
            return new com.tencent.mobileqq.guild.feed.topic.g(b16, mutableList, this.$rawRsp);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super com.tencent.mobileqq.guild.feed.topic.g> continuation) {
        return ((TopicFeedsRepository$innerGetFeeds$rsp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
