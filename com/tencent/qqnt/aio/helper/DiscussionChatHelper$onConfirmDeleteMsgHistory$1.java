package com.tencent.qqnt.aio.helper;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.troop.UpdateTroopListEvent;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.helper.DiscussionChatHelper$onConfirmDeleteMsgHistory$1", f = "DiscussionChatHelper.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class DiscussionChatHelper$onConfirmDeleteMsgHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiscussionChatHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.aio.helper.DiscussionChatHelper$onConfirmDeleteMsgHistory$1$1", f = "DiscussionChatHelper.kt", i = {}, l = {272, 291}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.aio.helper.DiscussionChatHelper$onConfirmDeleteMsgHistory$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DiscussionChatHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DiscussionChatHelper discussionChatHelper, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = discussionChatHelper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x009e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            com.tencent.aio.api.runtime.a aVar;
            FragmentActivity q16;
            FragmentActivity q17;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                DiscussionChatHelper discussionChatHelper = this.this$0;
                this.label = 1;
                obj = discussionChatHelper.p(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                            SimpleEventBus.getInstance().dispatchEvent(new UpdateTroopListEvent());
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                q16 = this.this$0.q();
                q17 = this.this$0.q();
                QQToast.makeText(q16, 2, q17.getString(R.string.a3m), 0).show();
            }
            aVar = this.this$0.aioContext;
            Contact contact = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            aVar.e().h(new ExternalCommIntent("close_aio", new Bundle()));
            DiscussionChatHelper discussionChatHelper2 = this.this$0;
            Contact contact2 = discussionChatHelper2.contact;
            if (contact2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contact");
            } else {
                contact = contact2;
            }
            String str = contact.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
            this.label = 2;
            obj = discussionChatHelper2.o(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscussionChatHelper$onConfirmDeleteMsgHistory$1(DiscussionChatHelper discussionChatHelper, Continuation<? super DiscussionChatHelper$onConfirmDeleteMsgHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = discussionChatHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiscussionChatHelper$onConfirmDeleteMsgHistory$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            i.e eVar = i.e.f261783e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (CorountineFunKt.i(eVar, null, null, anonymousClass1, this, 6, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiscussionChatHelper$onConfirmDeleteMsgHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
