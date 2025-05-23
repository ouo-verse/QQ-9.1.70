package com.tencent.mobileqq.ark;

import android.os.Bundle;
import com.tencent.mobileqq.ark.share.IShareArkViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.ark.QQCustomTemplateMsgDialog$init$1", f = "QQCustomTemplateMsgDialog.kt", i = {}, l = {54, 55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class QQCustomTemplateMsgDialog$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ int $targetWidth;
    int label;
    final /* synthetic */ QQCustomTemplateMsgDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.ark.QQCustomTemplateMsgDialog$init$1$1", f = "QQCustomTemplateMsgDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.ark.QQCustomTemplateMsgDialog$init$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $bundle;
        int label;
        final /* synthetic */ QQCustomTemplateMsgDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QQCustomTemplateMsgDialog qQCustomTemplateMsgDialog, Bundle bundle, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = qQCustomTemplateMsgDialog;
            this.$bundle = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$bundle, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.z0(this.$bundle);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQCustomTemplateMsgDialog$init$1(Bundle bundle, QQCustomTemplateMsgDialog qQCustomTemplateMsgDialog, int i3, Continuation<? super QQCustomTemplateMsgDialog$init$1> continuation) {
        super(2, continuation);
        this.$bundle = bundle;
        this.this$0 = qQCustomTemplateMsgDialog;
        this.$targetWidth = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQCustomTemplateMsgDialog$init$1(this.$bundle, this.this$0, this.$targetWidth, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.aio.msg.template.a aVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Object templateInfoByBundle = ((IShareArkViewApi) QRoute.api(IShareArkViewApi.class)).getTemplateInfoByBundle(this.$bundle);
            com.tencent.mobileqq.aio.msg.template.d dVar = templateInfoByBundle instanceof com.tencent.mobileqq.aio.msg.template.d ? (com.tencent.mobileqq.aio.msg.template.d) templateInfoByBundle : null;
            aVar = this.this$0.contentView;
            if (aVar != null) {
                Integer boxInt = Boxing.boxInt(this.$targetWidth);
                this.label = 1;
                if (aVar.Q(dVar, boxInt, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$bundle, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQCustomTemplateMsgDialog$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
