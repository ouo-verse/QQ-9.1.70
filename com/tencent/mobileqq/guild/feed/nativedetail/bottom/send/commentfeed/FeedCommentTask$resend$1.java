package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.STATE;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.FeedCommentTask$resend$1", f = "FeedCommentTask.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedCommentTask$resend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedCommentTask this$0;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220762a;

        static {
            int[] iArr = new int[STATE.values().length];
            try {
                iArr[STATE.COMMENT_SEND_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f220762a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentTask$resend$1(FeedCommentTask feedCommentTask, Continuation<? super FeedCommentTask$resend$1> continuation) {
        super(2, continuation);
        this.this$0 = feedCommentTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedCommentTask feedCommentTask, int i3, String errMsg, boolean z16, GProStDoCommentRsp rsp) {
        STATE state;
        RequestSenderCallback E;
        GProStDoCommentReq gProStDoCommentReq;
        QLog.i("FeedCommentTask", 1, "resend handleCommentRsp result = " + i3 + " errorMsg = " + errMsg);
        com.tencent.mobileqq.guild.feed.report.c.f223280a.o(feedCommentTask.getPerfStageReportTask(), "stage_finish", (long) i3, errMsg, rsp);
        if (i3 == 0) {
            feedCommentTask.b();
            state = STATE.SUCCESS;
        } else {
            state = STATE.COMMENT_SEND_FAILED;
        }
        feedCommentTask.r(state);
        E = feedCommentTask.E();
        if (E != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            gProStDoCommentReq = feedCommentTask.req;
            Intrinsics.checkNotNull(gProStDoCommentReq);
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            E.b(feedCommentTask, i3, errMsg, gProStDoCommentReq, rsp);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedCommentTask$resend$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        STATE state;
        boolean C;
        Object H;
        GProStDoCommentReq gProStDoCommentReq;
        GProStDoCommentReq gProStDoCommentReq2;
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
            QLog.i("FeedCommentTask", 1, "resend start===");
            state = this.this$0.getState();
            if (a.f220762a[state.ordinal()] == 1) {
                gProStDoCommentReq = this.this$0.req;
                if (gProStDoCommentReq == null) {
                    QLog.e("FeedCommentTask", 1, "resend req == null");
                    return Unit.INSTANCE;
                }
                com.tencent.mobileqq.guild.feed.report.c.f223280a.p(this.this$0.getPerfStageReportTask(), "stage_send_comment_start");
                o c16 = l.c();
                if (c16 != null) {
                    gProStDoCommentReq2 = this.this$0.req;
                    final FeedCommentTask feedCommentTask = this.this$0;
                    c16.doComment(gProStDoCommentReq2, new IGProDoCommentCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.e
                        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback
                        public final void onResult(int i16, String str, boolean z16, GProStDoCommentRsp gProStDoCommentRsp) {
                            FeedCommentTask$resend$1.b(FeedCommentTask.this, i16, str, z16, gProStDoCommentRsp);
                        }
                    });
                }
            } else {
                C = this.this$0.C();
                if (!C) {
                    return Unit.INSTANCE;
                }
                FeedCommentTask feedCommentTask2 = this.this$0;
                String commentTxt = feedCommentTask2.getCommentTxt();
                ArrayList<LocalMediaInfo> f16 = this.this$0.f();
                boolean mediaOriginal = this.this$0.getMediaOriginal();
                CommentFeedRequestArgs G = this.this$0.G();
                this.label = 1;
                H = feedCommentTask2.H(commentTxt, f16, mediaOriginal, G, this);
                if (H == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedCommentTask$resend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
