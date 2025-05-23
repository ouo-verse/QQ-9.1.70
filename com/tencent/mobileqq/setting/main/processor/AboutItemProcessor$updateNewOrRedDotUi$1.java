package com.tencent.mobileqq.setting.main.processor;

import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.setting.main.processor.AboutItemProcessor$updateNewOrRedDotUi$1", f = "AboutItemProcessor.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class AboutItemProcessor$updateNewOrRedDotUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AboutItemProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.setting.main.processor.AboutItemProcessor$updateNewOrRedDotUi$1$1", f = "AboutItemProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.setting.main.processor.AboutItemProcessor$updateNewOrRedDotUi$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imageUrl;
        final /* synthetic */ boolean $showRedPoint;
        int label;
        final /* synthetic */ AboutItemProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AboutItemProcessor aboutItemProcessor, String str, boolean z16, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = aboutItemProcessor;
            this.$imageUrl = str;
            this.$showRedPoint = z16;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$imageUrl, this.$showRedPoint, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            x C;
            x C2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                C = this.this$0.C();
                ((x.c.d) C.O()).j(this.$imageUrl);
                C2 = this.this$0.C();
                ((x.c.d) C2.O()).g(this.$showRedPoint);
                this.this$0.l();
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
    public AboutItemProcessor$updateNewOrRedDotUi$1(AboutItemProcessor aboutItemProcessor, Continuation<? super AboutItemProcessor$updateNewOrRedDotUi$1> continuation) {
        super(2, continuation);
        this.this$0 = aboutItemProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AboutItemProcessor$updateNewOrRedDotUi$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean D;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            D = this.this$0.D();
            if (D) {
                str = "upgrade_new";
            } else {
                r1 = PrivacyPolicyHelper.needShowPrivacyPolicyOrUserAgreement(1);
                str = "";
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, str, r1, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
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
        return ((AboutItemProcessor$updateNewOrRedDotUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
