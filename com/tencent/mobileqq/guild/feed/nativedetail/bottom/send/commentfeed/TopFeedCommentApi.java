package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetTopCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetTopCommentReqExtInfoEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetTopCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetTopCommentCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.i;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/TopFeedCommentApi;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "feed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "comment", "", "topOrUntop", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSetTopCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSetTopCommentRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/TopFeedRequestCallback;", "callback", "", "a", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;ZLcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopFeedCommentApi {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "code", "", NotificationCompat.CATEGORY_ERROR, "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSetTopCommentRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements IGProSetTopCommentCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Triple<Integer, String, GProSetTopCommentRsp>> f220764a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Continuation<? super Triple<Integer, String, GProSetTopCommentRsp>> continuation) {
            this.f220764a = continuation;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetTopCommentCallback
        public final void onResult(int i3, String str, GProSetTopCommentRsp gProSetTopCommentRsp) {
            Continuation<Triple<Integer, String, GProSetTopCommentRsp>> continuation = this.f220764a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new Triple(Integer.valueOf(i3), str, gProSetTopCommentRsp)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(@NotNull a.CommentMainFeedData commentMainFeedData, @NotNull GProStComment gProStComment, boolean z16, @NotNull RequestSenderCallback<GProSetTopCommentReq, GProSetTopCommentRsp> requestSenderCallback, @NotNull Continuation<? super Unit> continuation) {
        TopFeedCommentApi$setTopComment$1 topFeedCommentApi$setTopComment$1;
        Object coroutine_suspended;
        int i3;
        Long longOrNull;
        long j3;
        Long longOrNull2;
        int i16;
        int collectionSizeOrDefault;
        RequestSenderCallback<GProSetTopCommentReq, GProSetTopCommentRsp> requestSenderCallback2;
        GProSetTopCommentReq gProSetTopCommentReq;
        Triple triple;
        if (continuation instanceof TopFeedCommentApi$setTopComment$1) {
            topFeedCommentApi$setTopComment$1 = (TopFeedCommentApi$setTopComment$1) continuation;
            int i17 = topFeedCommentApi$setTopComment$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                topFeedCommentApi$setTopComment$1.label = i17 - Integer.MIN_VALUE;
                Object obj = topFeedCommentApi$setTopComment$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = topFeedCommentApi$setTopComment$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        GProSetTopCommentReq gProSetTopCommentReq2 = (GProSetTopCommentReq) topFeedCommentApi$setTopComment$1.L$1;
                        RequestSenderCallback<GProSetTopCommentReq, GProSetTopCommentRsp> requestSenderCallback3 = (RequestSenderCallback) topFeedCommentApi$setTopComment$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        gProSetTopCommentReq = gProSetTopCommentReq2;
                        requestSenderCallback2 = requestSenderCallback3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    GProSetTopCommentReq gProSetTopCommentReq3 = new GProSetTopCommentReq();
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(commentMainFeedData.getGuildId());
                    long j16 = 0;
                    if (longOrNull != null) {
                        j3 = longOrNull.longValue();
                    } else {
                        j3 = 0;
                    }
                    gProSetTopCommentReq3.guildId = j3;
                    gProSetTopCommentReq3.feedId = commentMainFeedData.getFeedId();
                    longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(commentMainFeedData.getChannelId());
                    if (longOrNull2 != null) {
                        j16 = longOrNull2.longValue();
                    }
                    gProSetTopCommentReq3.channelId = j16;
                    gProSetTopCommentReq3.commentId = gProStComment.idd;
                    if (z16) {
                        i16 = 1;
                    } else {
                        i16 = 2;
                    }
                    gProSetTopCommentReq3.setType = i16;
                    ArrayList<GProSetTopCommentReqExtInfoEntry> arrayList = gProSetTopCommentReq3.extInfoList;
                    List<GProFeedEntry> f16 = i.f450608a.f();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(f16, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    for (GProFeedEntry gProFeedEntry : f16) {
                        GProSetTopCommentReqExtInfoEntry gProSetTopCommentReqExtInfoEntry = new GProSetTopCommentReqExtInfoEntry();
                        gProSetTopCommentReqExtInfoEntry.key = gProFeedEntry.key;
                        gProSetTopCommentReqExtInfoEntry.value = gProFeedEntry.value;
                        arrayList2.add(gProSetTopCommentReqExtInfoEntry);
                    }
                    arrayList.addAll(arrayList2);
                    TopFeedCommentApi$setTopComment$$inlined$suspendCoroutineWithTimeout$default$1 topFeedCommentApi$setTopComment$$inlined$suspendCoroutineWithTimeout$default$1 = new TopFeedCommentApi$setTopComment$$inlined$suspendCoroutineWithTimeout$default$1(null, gProSetTopCommentReq3);
                    topFeedCommentApi$setTopComment$1.L$0 = requestSenderCallback;
                    topFeedCommentApi$setTopComment$1.L$1 = gProSetTopCommentReq3;
                    topFeedCommentApi$setTopComment$1.label = 1;
                    Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(15000L, topFeedCommentApi$setTopComment$$inlined$suspendCoroutineWithTimeout$default$1, topFeedCommentApi$setTopComment$1);
                    if (withTimeoutOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestSenderCallback2 = requestSenderCallback;
                    gProSetTopCommentReq = gProSetTopCommentReq3;
                    obj = withTimeoutOrNull;
                }
                triple = (Triple) obj;
                if (triple == null) {
                    triple = new Triple(Boxing.boxInt(1002), "\u7f51\u7edc\u8d85\u65f6", new GProSetTopCommentRsp());
                }
                int intValue = ((Number) triple.component1()).intValue();
                String str = (String) triple.component2();
                GProSetTopCommentRsp gProSetTopCommentRsp = (GProSetTopCommentRsp) triple.component3();
                QLog.i("CommentFeedTopApi", 1, "setTopComment code: " + intValue + ", err: " + str);
                requestSenderCallback2.b(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a(), intValue, str, gProSetTopCommentReq, gProSetTopCommentRsp);
                return Unit.INSTANCE;
            }
        }
        topFeedCommentApi$setTopComment$1 = new TopFeedCommentApi$setTopComment$1(this, continuation);
        Object obj2 = topFeedCommentApi$setTopComment$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = topFeedCommentApi$setTopComment$1.label;
        if (i3 == 0) {
        }
        triple = (Triple) obj2;
        if (triple == null) {
        }
        int intValue2 = ((Number) triple.component1()).intValue();
        String str2 = (String) triple.component2();
        GProSetTopCommentRsp gProSetTopCommentRsp2 = (GProSetTopCommentRsp) triple.component3();
        QLog.i("CommentFeedTopApi", 1, "setTopComment code: " + intValue2 + ", err: " + str2);
        requestSenderCallback2.b(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a(), intValue2, str2, gProSetTopCommentReq, gProSetTopCommentRsp2);
        return Unit.INSTANCE;
    }
}
