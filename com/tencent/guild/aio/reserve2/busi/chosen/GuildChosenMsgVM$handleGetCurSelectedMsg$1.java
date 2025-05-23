package com.tencent.guild.aio.reserve2.busi.chosen;

import android.os.Handler;
import android.os.Looper;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.util.y;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Collection;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM$handleGetCurSelectedMsg$1", f = "GuildChosenMsgVM.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildChosenMsgVM$handleGetCurSelectedMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Contact $contact;
    final /* synthetic */ boolean $isGuest;
    final /* synthetic */ long $msgSeq;
    final /* synthetic */ int $topMsgType;
    int label;
    final /* synthetic */ GuildChosenMsgVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChosenMsgVM$handleGetCurSelectedMsg$1(Contact contact, long j3, boolean z16, GuildChosenMsgVM guildChosenMsgVM, int i3, Continuation<? super GuildChosenMsgVM$handleGetCurSelectedMsg$1> continuation) {
        super(2, continuation);
        this.$contact = contact;
        this.$msgSeq = j3;
        this.$isGuest = z16;
        this.this$0 = guildChosenMsgVM;
        this.$topMsgType = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildChosenMsgVM guildChosenMsgVM, com.tencent.qqnt.msg.api.c cVar, int i3) {
        guildChosenMsgVM.D((ArrayList) cVar.a(), i3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildChosenMsgVM$handleGetCurSelectedMsg$1(this.$contact, this.$msgSeq, this.$isGuest, this.this$0, this.$topMsgType, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            Contact contact = this.$contact;
            long j3 = this.$msgSeq;
            boolean z16 = this.$isGuest;
            this.label = 1;
            obj = iMsgService.getMsgsBySeqsSuspend(contact, j3, z16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        final com.tencent.qqnt.msg.api.c cVar = (com.tencent.qqnt.msg.api.c) obj;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        QLog.i("GuildChosenMsgVM", 1, "channelUin=" + com.tencent.guild.aio.util.a.b(g16) + " code=" + cVar.c() + " msg=" + cVar.b() + " dataSize=" + ((ArrayList) cVar.a()).size());
        if (!y.b(cVar.c()) || !(!((Collection) cVar.a()).isEmpty())) {
            this.this$0.L(new ArrayList());
        } else if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            this.this$0.D((ArrayList) cVar.a(), this.$topMsgType);
        } else {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GuildChosenMsgVM guildChosenMsgVM = this.this$0;
            final int i16 = this.$topMsgType;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildChosenMsgVM$handleGetCurSelectedMsg$1.b(GuildChosenMsgVM.this, cVar, i16);
                }
            });
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildChosenMsgVM$handleGetCurSelectedMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
