package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import android.widget.Toast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/widget/Toast;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$toastErrorMsg$2", f = "BaseWinkAlbumClickDelegator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class BaseWinkAlbumClickDelegator$toastErrorMsg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Toast>, Object> {
    int label;
    final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWinkAlbumClickDelegator$toastErrorMsg$2(BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, Continuation<? super BaseWinkAlbumClickDelegator$toastErrorMsg$2> continuation) {
        super(2, continuation);
        this.this$0 = baseWinkAlbumClickDelegator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BaseWinkAlbumClickDelegator$toastErrorMsg$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return QQToast.makeText(this.this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getBaseContext(), this.this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getString(R.string.f239877nn), 0).show();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Toast> continuation) {
        return ((BaseWinkAlbumClickDelegator$toastErrorMsg$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
