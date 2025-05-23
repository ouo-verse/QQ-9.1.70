package com.tencent.mobileqq.zplan.aigc;

import android.graphics.Bitmap;
import com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.encoder.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1$onRecordFrame$1", f = "SuitOutfitPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1$onRecordFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SuitOutfitPreviewFragment.b $callback;
    final /* synthetic */ int $height;
    final /* synthetic */ byte[] $pixels;
    final /* synthetic */ int $width;
    int label;
    final /* synthetic */ SuitOutfitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1$onRecordFrame$1(int i3, int i16, byte[] bArr, SuitOutfitPreviewFragment.b bVar, SuitOutfitPreviewFragment suitOutfitPreviewFragment, Continuation<? super SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1$onRecordFrame$1> continuation) {
        super(2, continuation);
        this.$width = i3;
        this.$height = i16;
        this.$pixels = bArr;
        this.$callback = bVar;
        this.this$0 = suitOutfitPreviewFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1$onRecordFrame$1(this.$width, this.$height, this.$pixels, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bitmap tj5;
        Bitmap bitmap;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("SuitOutfitPreviewFragment", 1, "onRecordFrame width: " + this.$width + ", height: " + this.$height);
            byte[] bArr = this.$pixels;
            if (!(bArr != null && (this.$width * this.$height) * 4 == bArr.length)) {
                QLog.w("SuitOutfitPreviewFragment", 1, "recordAndExportImage onRecordFrame pixels size error");
                this.$callback.a(null);
                return Unit.INSTANCE;
            }
            SuitOutfitPreviewFragment suitOutfitPreviewFragment = this.this$0;
            tj5 = suitOutfitPreviewFragment.tj(bArr != null ? a.Companion.b(com.tencent.zplan.meme.encoder.a.INSTANCE, bArr, this.$width, this.$height, null, 4, null) : null);
            suitOutfitPreviewFragment.outfitAvatarImage = tj5;
            SuitOutfitPreviewFragment suitOutfitPreviewFragment2 = this.this$0;
            bitmap = suitOutfitPreviewFragment2.outfitAvatarImage;
            suitOutfitPreviewFragment2.Fk(bitmap, "outfitAvatar.png", false, this.$callback);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1$onRecordFrame$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
