package com.tencent.mobileqq.zplan.aigc.helper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1$onRecordFrame$1", f = "ZplanUgcDyeingDialogHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1$onRecordFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ Ref.ObjectRef<Bitmap> $iconBitmap;
    final /* synthetic */ byte[] $pixels;
    final /* synthetic */ int $width;
    int label;
    final /* synthetic */ ZplanUgcDyeingDialogHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1$onRecordFrame$1(ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper, int i3, int i16, byte[] bArr, Ref.ObjectRef<Bitmap> objectRef, Continuation<? super ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1$onRecordFrame$1> continuation) {
        super(2, continuation);
        this.this$0 = zplanUgcDyeingDialogHelper;
        this.$width = i3;
        this.$height = i16;
        this.$pixels = bArr;
        this.$iconBitmap = objectRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper) {
        zplanUgcDyeingDialogHelper.vm.w3(false, zplanUgcDyeingDialogHelper.filamentRender);
        AigcPreviewBusinessScene scene = zplanUgcDyeingDialogHelper.filamentRender.getScene();
        if (scene != null) {
            scene.rotateAvatar(new AigcPreviewBusinessScene.RotateAngle(0.0f, 0.0f, 0.0f, 7, null));
        }
        Function1 function1 = (Function1) zplanUgcDyeingDialogHelper.callback.get();
        if (function1 != null) {
            function1.invoke(1);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1$onRecordFrame$1(this.this$0, this.$width, this.$height, this.$pixels, this.$iconBitmap, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i(this.this$0.TAG, 1, "onRecordFrame width: " + this.$width + ", height: " + this.$height);
            byte[] bArr = this.$pixels;
            boolean z16 = false;
            if (bArr != null && this.$width * this.$height * 4 == bArr.length) {
                z16 = true;
            }
            if (!z16) {
                QLog.w(this.this$0.TAG, 1, "recordAndExportImage onRecordFrame pixels size error");
                return Unit.INSTANCE;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.helper.m
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1$onRecordFrame$1.b(ZplanUgcDyeingDialogHelper.this);
                }
            });
            AIGCHelper aIGCHelper = AIGCHelper.f330685a;
            byte[] bArr2 = this.$pixels;
            int i3 = this.$width;
            int i16 = this.$height;
            Bitmap iconBitmap = this.$iconBitmap.element;
            Intrinsics.checkNotNullExpressionValue(iconBitmap, "iconBitmap");
            aIGCHelper.k(bArr2, i3, i16, iconBitmap, new Rect(12, 12, 500, 500));
            String F2 = this.this$0.vm.F2(String.valueOf(this.this$0.vm.getUgcId()), this.$iconBitmap.element);
            if (F2 != null) {
                this.this$0.R(F2);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZplanUgcDyeingDialogHelper$generateAndPublishUgcRewource$recordListener$1$onRecordFrame$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
