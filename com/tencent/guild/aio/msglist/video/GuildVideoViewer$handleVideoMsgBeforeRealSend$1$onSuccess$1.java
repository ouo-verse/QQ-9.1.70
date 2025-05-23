package com.tencent.guild.aio.msglist.video;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.view.FilterEnum;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.msglist.video.GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1", f = "GuildVideoViewer.kt", i = {}, l = {FilterEnum.MIC_PTU_TRANS_XINXIAN}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MsgRecord $msgRecord;
    final /* synthetic */ String $videoPath;
    int label;
    final /* synthetic */ GuildVideoViewer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.guild.aio.msglist.video.GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1$1", f = "GuildVideoViewer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.guild.aio.msglist.video.GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MsgRecord $msgRecord;
        int label;
        final /* synthetic */ GuildVideoViewer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GuildVideoViewer guildVideoViewer, MsgRecord msgRecord, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = guildVideoViewer;
            this.$msgRecord = msgRecord;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$msgRecord, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IGuildVideoApi m06;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildVideoViewer guildVideoViewer = this.this$0;
                GuildMsgItem guildMsgItem = guildVideoViewer.currentMsgItem;
                if (guildMsgItem == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    guildMsgItem = null;
                }
                guildVideoViewer.h0(guildMsgItem, this.this$0.getContentView());
                this.this$0.v();
                m06 = this.this$0.m0();
                m06.removeEncodeTask(this.$msgRecord);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1(GuildVideoViewer guildVideoViewer, String str, MsgRecord msgRecord, Continuation<? super GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = guildVideoViewer;
        this.$videoPath = str;
        this.$msgRecord = msgRecord;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1(this.this$0, this.$videoPath, this.$msgRecord, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MsgElement msgElement;
        IGuildVideoApi m06;
        MsgElement msgElement2;
        IGuildVideoApi m07;
        MsgElement msgElement3;
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
            msgElement = this.this$0.com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants.TAG.ELEMENT java.lang.String;
            Intrinsics.checkNotNull(msgElement);
            msgElement.videoElement.filePath = this.$videoPath;
            m06 = this.this$0.m0();
            msgElement2 = this.this$0.com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants.TAG.ELEMENT java.lang.String;
            m06.copyVideoToNTDIR(msgElement2);
            m07 = this.this$0.m0();
            msgElement3 = this.this$0.com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants.TAG.ELEMENT java.lang.String;
            m07.copyThumbPicToNTDIR(msgElement3);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$msgRecord, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
