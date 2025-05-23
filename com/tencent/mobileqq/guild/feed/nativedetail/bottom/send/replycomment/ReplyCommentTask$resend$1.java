package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.STATE;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.ReplyCommentTask$resend$1", f = "ReplyCommentTask.kt", i = {}, l = {69, 103}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class ReplyCommentTask$resend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReplyCommentTask this$0;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220835a;

        static {
            int[] iArr = new int[STATE.values().length];
            try {
                iArr[STATE.COMMENT_SEND_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f220835a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyCommentTask$resend$1(ReplyCommentTask replyCommentTask, Continuation<? super ReplyCommentTask$resend$1> continuation) {
        super(2, continuation);
        this.this$0 = replyCommentTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ReplyCommentTask replyCommentTask, int i3, String errMsg, boolean z16, GProStDoReplyRsp rsp) {
        GProStDoReplyReq gProStDoReplyReq;
        STATE state;
        RequestSenderCallback D;
        GProStDoReplyReq gProStDoReplyReq2;
        QLog.i("ReplyCommentTask", 1, "resend handleCommentRsp result = " + i3 + " errorMsg = " + errMsg);
        gProStDoReplyReq = replyCommentTask.req;
        com.tencent.mobileqq.guild.feed.report.c.f223280a.F(replyCommentTask.getPerfStageReportTask(), "stage_finish", (long) i3, errMsg, gProStDoReplyReq, rsp);
        if (i3 == 0) {
            replyCommentTask.b();
            state = STATE.SUCCESS;
        } else {
            state = STATE.COMMENT_SEND_FAILED;
        }
        replyCommentTask.r(state);
        D = replyCommentTask.D();
        if (D != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            gProStDoReplyReq2 = replyCommentTask.req;
            Intrinsics.checkNotNull(gProStDoReplyReq2);
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            D.b(replyCommentTask, i3, errMsg, gProStDoReplyReq2, rsp);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReplyCommentTask$resend$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        STATE state;
        boolean B;
        Object H;
        GProStDoReplyReq gProStDoReplyReq;
        GProStDoReplyReq gProStDoReplyReq2;
        boolean B2;
        Object H2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        state = this.this$0.getState();
        if (a.f220835a[state.ordinal()] == 1) {
            gProStDoReplyReq = this.this$0.req;
            if (gProStDoReplyReq == null) {
                QLog.e("ReplyCommentTask", 1, "resend req == null");
                B2 = this.this$0.B();
                if (B2) {
                    QLog.i("ReplyCommentTask", 1, "checkParamsValid sendInner");
                    ReplyCommentTask replyCommentTask = this.this$0;
                    String commentTxt = replyCommentTask.getCommentTxt();
                    ArrayList<LocalMediaInfo> f16 = this.this$0.f();
                    boolean mediaOriginal = this.this$0.getMediaOriginal();
                    a.CommentMainFeedData E = this.this$0.E();
                    ReplyCommentArgs G = this.this$0.G();
                    this.label = 1;
                    H2 = replyCommentTask.H(commentTxt, f16, mediaOriginal, E, G, this);
                    if (H2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            com.tencent.mobileqq.guild.feed.report.c.f223280a.p(this.this$0.getPerfStageReportTask(), "stage_send_comment_start");
            o c16 = l.c();
            if (c16 != null) {
                gProStDoReplyReq2 = this.this$0.req;
                final ReplyCommentTask replyCommentTask2 = this.this$0;
                c16.doReply(gProStDoReplyReq2, new IGProDoReplyCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.d
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback
                    public final void onResult(int i16, String str, boolean z16, GProStDoReplyRsp gProStDoReplyRsp) {
                        ReplyCommentTask$resend$1.b(ReplyCommentTask.this, i16, str, z16, gProStDoReplyRsp);
                    }
                });
            }
        } else {
            B = this.this$0.B();
            if (!B) {
                QLog.e("ReplyCommentTask", 1, "resend Params invalid, resend failed");
                return Unit.INSTANCE;
            }
            ReplyCommentTask replyCommentTask3 = this.this$0;
            String commentTxt2 = replyCommentTask3.getCommentTxt();
            ArrayList<LocalMediaInfo> f17 = this.this$0.f();
            boolean mediaOriginal2 = this.this$0.getMediaOriginal();
            a.CommentMainFeedData E2 = this.this$0.E();
            ReplyCommentArgs G2 = this.this$0.G();
            this.label = 2;
            H = replyCommentTask3.H(commentTxt2, f17, mediaOriginal2, E2, G2, this);
            if (H == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReplyCommentTask$resend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
