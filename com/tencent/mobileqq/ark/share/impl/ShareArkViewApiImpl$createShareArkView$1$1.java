package com.tencent.mobileqq.ark.share.impl;

import android.os.Bundle;
import com.tencent.mobileqq.aio.msg.template.a;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.qqnt.aio.utils.ViewUtils;
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
@DebugMetadata(c = "com.tencent.mobileqq.ark.share.impl.ShareArkViewApiImpl$createShareArkView$1$1", f = "ShareArkViewApiImpl.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class ShareArkViewApiImpl$createShareArkView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ a $it;
    int label;
    final /* synthetic */ ShareArkViewApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.ark.share.impl.ShareArkViewApiImpl$createShareArkView$1$1$1", f = "ShareArkViewApiImpl.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.ark.share.impl.ShareArkViewApiImpl$createShareArkView$1$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $it;
        final /* synthetic */ d $templateInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(a aVar, d dVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$it = aVar;
            this.$templateInfo = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$it, this.$templateInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ViewUtils viewUtils = ViewUtils.f352270a;
                int min = Math.min(viewUtils.b(263), viewUtils.e() - viewUtils.b(72));
                a aVar = this.$it;
                d dVar = this.$templateInfo;
                Integer boxInt = Boxing.boxInt(min);
                this.label = 1;
                if (aVar.Q(dVar, boxInt, this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareArkViewApiImpl$createShareArkView$1$1(ShareArkViewApiImpl shareArkViewApiImpl, Bundle bundle, a aVar, Continuation<? super ShareArkViewApiImpl$createShareArkView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = shareArkViewApiImpl;
        this.$bundle = bundle;
        this.$it = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareArkViewApiImpl$createShareArkView$1$1(this.this$0, this.$bundle, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            d templateInfoByBundle = this.this$0.getTemplateInfoByBundle(this.$bundle);
            if (!(templateInfoByBundle instanceof d)) {
                templateInfoByBundle = null;
            }
            if (templateInfoByBundle == null) {
                return Unit.INSTANCE;
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$it, templateInfoByBundle, null);
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
        return ((ShareArkViewApiImpl$createShareArkView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
