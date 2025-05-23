package com.tencent.ecommerce.biz.hr.module;

import android.graphics.Bitmap;
import com.tencent.ecommerce.base.share.api.IECShareProxy;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.hr.module.ECHRShare$saveBitmapToSdcard$1", f = "ECHRShare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECHRShare$saveBitmapToSdcard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ String $filePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECHRShare$saveBitmapToSdcard$1(Bitmap bitmap, String str, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.$bitmap = bitmap;
        this.$filePath = str;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECHRShare$saveBitmapToSdcard$1(this.$bitmap, this.$filePath, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECHRShare$saveBitmapToSdcard$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IECShareProxy iECShareProxy;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            boolean c16 = gh0.a.f402039c.c(this.$bitmap, this.$filePath);
            booleanRef.element = c16;
            if (c16) {
                ECHRShare eCHRShare = ECHRShare.f102572h;
                iECShareProxy = ECHRShare.shareProxy;
                String copyImageFileToMediaStorage = iECShareProxy.copyImageFileToMediaStorage(this.$filePath);
                if (copyImageFileToMediaStorage == null) {
                    copyImageFileToMediaStorage = "";
                }
                booleanRef.element = copyImageFileToMediaStorage.length() > 0;
                ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.ECHRShare$saveBitmapToSdcard$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (Ref.BooleanRef.this.element) {
                            com.tencent.ecommerce.base.ui.i.f101155b.b("\u5df2\u4fdd\u5b58\u5230\u624b\u673a\u76f8\u518c", 1);
                        } else {
                            com.tencent.ecommerce.base.ui.i.f101155b.b("\u4fdd\u5b58\u5931\u8d25", 2);
                        }
                    }
                });
                cg0.a.b("ECHRShare", "save path: " + copyImageFileToMediaStorage);
            }
            ECHRShare.f102572h.g(booleanRef.element ? 0 : -1, "", this.$callback);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
