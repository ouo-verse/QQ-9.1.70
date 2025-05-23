package com.tencent.mobileqq.qqecommerce.base.share;

import android.app.Activity;
import com.tencent.ecommerce.base.share.api.IECAddShortCutCallback;
import com.tencent.ecommerce.base.share.api.ShortCutInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqecommerce.base.ECommerceDispatchers;
import com.tencent.mobileqq.utils.ec;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.base.share.ECShortCutUtil$addShortCutForBelowO$1", f = "ECShortCutUtil.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ECShortCutUtil$addShortCutForBelowO$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ IECAddShortCutCallback $callback;
    final /* synthetic */ ShortCutInfo $shortCutInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.base.share.ECShortCutUtil$addShortCutForBelowO$1$1", f = "ECShortCutUtil.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.qqecommerce.base.share.ECShortCutUtil$addShortCutForBelowO$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShortCutUtil$addShortCutForBelowO$1(Activity activity, ShortCutInfo shortCutInfo, IECAddShortCutCallback iECAddShortCutCallback, Continuation<? super ECShortCutUtil$addShortCutForBelowO$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$shortCutInfo = shortCutInfo;
        this.$callback = iECAddShortCutCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShortCutUtil$addShortCutForBelowO$1(this.$activity, this.$shortCutInfo, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b16 = ECommerceDispatchers.f262385a.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (BuildersKt.withContext(b16, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (ec.k(this.$activity, new String[]{this.$shortCutInfo.getShotLabel()})) {
            ToastUtil.a().e("\u5df2\u521b\u5efa" + this.$shortCutInfo.getShotLabel() + "\u5feb\u6377\u65b9\u5f0f\u5230\u684c\u9762");
            IECAddShortCutCallback iECAddShortCutCallback = this.$callback;
            if (iECAddShortCutCallback != null) {
                iECAddShortCutCallback.onCallback(0, "add short cut successfully");
            }
        } else {
            QLog.e("ECShortCutUtil", 1, "can not add short cut");
            ECShortCutUtil eCShortCutUtil = ECShortCutUtil.f262463a;
            Activity activity = this.$activity;
            String qqStr = HardCodeUtil.qqStr(R.string.tg7);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_shortcut_a5ef09f9)");
            eCShortCutUtil.n(activity, qqStr);
            IECAddShortCutCallback iECAddShortCutCallback2 = this.$callback;
            if (iECAddShortCutCallback2 != null) {
                iECAddShortCutCallback2.onCallback(1, "can not add short cut");
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShortCutUtil$addShortCutForBelowO$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
