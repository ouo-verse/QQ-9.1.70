package com.tencent.qqnt.chathistory.util;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.service.GroupMemberInfoService;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.util.MsgRecordExKt$setDisplayNickByMsgRecord$2", f = "MsgRecordEx.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class MsgRecordExKt$setDisplayNickByMsgRecord$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Ref.ObjectRef<String> $displayUid;
    final /* synthetic */ int $emoSize;
    final /* synthetic */ MsgRecord $msgRecord;
    final /* synthetic */ TextView $this_setDisplayNickByMsgRecord;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.chathistory.util.MsgRecordExKt$setDisplayNickByMsgRecord$2$1", f = "MsgRecordEx.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.chathistory.util.MsgRecordExKt$setDisplayNickByMsgRecord$2$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<MemberInfo, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ int $emoSize;
        final /* synthetic */ TextView $this_setDisplayNickByMsgRecord;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextView textView, int i3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_setDisplayNickByMsgRecord = textView;
            this.$emoSize = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, textView, Integer.valueOf(i3), continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_setDisplayNickByMsgRecord, this.$emoSize, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull MemberInfo memberInfo, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(memberInfo, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) memberInfo, (Object) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MemberInfo memberInfo = (MemberInfo) this.L$0;
                    Object tag = this.$this_setDisplayNickByMsgRecord.getTag(R.id.tt5);
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.service.MemberNickScopeWrapper");
                    if (Intrinsics.areEqual(((com.tencent.qqnt.chathistory.service.e) tag).b(), memberInfo.uid)) {
                        MsgRecordExKt.c(memberInfo, this.$this_setDisplayNickByMsgRecord, this.$emoSize);
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgRecordExKt$setDisplayNickByMsgRecord$2(MsgRecord msgRecord, Ref.ObjectRef<String> objectRef, TextView textView, int i3, Continuation<? super MsgRecordExKt$setDisplayNickByMsgRecord$2> continuation) {
        super(2, continuation);
        this.$msgRecord = msgRecord;
        this.$displayUid = objectRef;
        this.$this_setDisplayNickByMsgRecord = textView;
        this.$emoSize = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRecord, objectRef, textView, Integer.valueOf(i3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        MsgRecordExKt$setDisplayNickByMsgRecord$2 msgRecordExKt$setDisplayNickByMsgRecord$2 = new MsgRecordExKt$setDisplayNickByMsgRecord$2(this.$msgRecord, this.$displayUid, this.$this_setDisplayNickByMsgRecord, this.$emoSize, continuation);
        msgRecordExKt$setDisplayNickByMsgRecord$2.L$0 = obj;
        return msgRecordExKt$setDisplayNickByMsgRecord$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                GroupMemberInfoService groupMemberInfoService = GroupMemberInfoService.f353323a;
                String str = this.$msgRecord.peerUid;
                Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
                long parseLong = Long.parseLong(str);
                String displayUid = this.$displayUid.element;
                Intrinsics.checkNotNullExpressionValue(displayUid, "displayUid");
                FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(groupMemberInfoService.a(parseLong, displayUid), new AnonymousClass1(this.$this_setDisplayNickByMsgRecord, this.$emoSize, null)), Dispatchers.getMain()), coroutineScope);
                TextView textView = this.$this_setDisplayNickByMsgRecord;
                String displayUid2 = this.$displayUid.element;
                Intrinsics.checkNotNullExpressionValue(displayUid2, "displayUid");
                textView.setTag(R.id.tt5, new com.tencent.qqnt.chathistory.service.e(displayUid2, coroutineScope));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgRecordExKt$setDisplayNickByMsgRecord$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
