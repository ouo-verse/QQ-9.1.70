package com.tencent.mobileqq.qqecommerce.base.share;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qqecommerce.base.ECommerceDispatchers;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.base.share.ECShareUtil$shareMsgToWeChat$1", f = "ECShareUtil.kt", i = {}, l = {com.tencent.luggage.wxa.yd.a.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ECShareUtil$shareMsgToWeChat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $desc;
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ QQProgressDialog $loadingDialog;
    final /* synthetic */ int $scene;
    final /* synthetic */ String $shareUrl;
    final /* synthetic */ String $title;
    final /* synthetic */ String $transaction;
    final /* synthetic */ boolean $useQCircleShare;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.base.share.ECShareUtil$shareMsgToWeChat$1$1", f = "ECShareUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.qqecommerce.base.share.ECShareUtil$shareMsgToWeChat$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $desc;
        final /* synthetic */ Bitmap $image;
        final /* synthetic */ QQProgressDialog $loadingDialog;
        final /* synthetic */ int $scene;
        final /* synthetic */ String $shareUrl;
        final /* synthetic */ String $title;
        final /* synthetic */ String $transaction;
        final /* synthetic */ boolean $useQCircleShare;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QQProgressDialog qQProgressDialog, boolean z16, String str, String str2, Bitmap bitmap, String str3, String str4, int i3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$loadingDialog = qQProgressDialog;
            this.$useQCircleShare = z16;
            this.$transaction = str;
            this.$title = str2;
            this.$image = bitmap;
            this.$desc = str3;
            this.$shareUrl = str4;
            this.$scene = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$loadingDialog, this.$useQCircleShare, this.$transaction, this.$title, this.$image, this.$desc, this.$shareUrl, this.$scene, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$loadingDialog.dismiss();
                if (this.$useQCircleShare) {
                    WXShareHelper.b0().E0(this.$transaction, this.$title, this.$image, this.$desc, this.$shareUrl, this.$scene);
                } else {
                    WXShareHelper.b0().L0(this.$transaction, this.$title, this.$image, this.$desc, this.$shareUrl, this.$scene);
                }
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
    public ECShareUtil$shareMsgToWeChat$1(String str, QQProgressDialog qQProgressDialog, boolean z16, String str2, String str3, String str4, String str5, int i3, Continuation<? super ECShareUtil$shareMsgToWeChat$1> continuation) {
        super(2, continuation);
        this.$imageUrl = str;
        this.$loadingDialog = qQProgressDialog;
        this.$useQCircleShare = z16;
        this.$transaction = str2;
        this.$title = str3;
        this.$desc = str4;
        this.$shareUrl = str5;
        this.$scene = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShareUtil$shareMsgToWeChat$1(this.$imageUrl, this.$loadingDialog, this.$useQCircleShare, this.$transaction, this.$title, this.$desc, this.$shareUrl, this.$scene, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Bitmap h16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            h16 = ECShareUtil.f262459a.h(this.$imageUrl);
            CoroutineDispatcher c16 = ECommerceDispatchers.f262385a.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$loadingDialog, this.$useQCircleShare, this.$transaction, this.$title, h16, this.$desc, this.$shareUrl, this.$scene, null);
            this.label = 1;
            if (BuildersKt.withContext(c16, anonymousClass1, this) == coroutine_suspended) {
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
        return ((ECShareUtil$shareMsgToWeChat$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
