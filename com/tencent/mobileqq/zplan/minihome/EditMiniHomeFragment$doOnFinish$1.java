package com.tencent.mobileqq.zplan.minihome;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.util.QQToastUtil;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doOnFinish$1", f = "EditMiniHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class EditMiniHomeFragment$doOnFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EditMiniHomeFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$doOnFinish$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditMiniHomeFragment f334254d;

        a(EditMiniHomeFragment editMiniHomeFragment) {
            this.f334254d = editMiniHomeFragment;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(com.tencent.sqshow.zootopia.data.f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f334254d.vj(result);
            this.f334254d.aj();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            int i3;
            QQToastUtil.showQQToastInUiThread(1, "\u83b7\u53d6\u91d1\u5e01\u4f59\u989d\u5931\u8d25");
            EditMiniHomeFragment editMiniHomeFragment = this.f334254d;
            i3 = editMiniHomeFragment.curTotalPrice;
            editMiniHomeFragment.hj("clck", "", i3 > 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditMiniHomeFragment$doOnFinish$1(EditMiniHomeFragment editMiniHomeFragment, Continuation<? super EditMiniHomeFragment$doOnFinish$1> continuation) {
        super(2, continuation);
        this.this$0 = editMiniHomeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditMiniHomeFragment$doOnFinish$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i3;
        com.tencent.sqshow.zootopia.data.f fVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (NetworkUtil.isNetworkAvailable()) {
                i3 = this.this$0.curTotalPrice;
                if (i3 > 0) {
                    fVar = this.this$0.currencyData;
                    if (fVar.getGoldCoin() > 0) {
                        this.this$0.aj();
                    } else {
                        yb4.e.h(yb4.e.f450058a, "request_immediately", new a(this.this$0), 0, 4, null);
                    }
                    return Unit.INSTANCE;
                }
                EditMiniHomeFragment.mj(this.this$0, false, 1, null);
                return Unit.INSTANCE;
            }
            QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5\u3002");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditMiniHomeFragment$doOnFinish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
