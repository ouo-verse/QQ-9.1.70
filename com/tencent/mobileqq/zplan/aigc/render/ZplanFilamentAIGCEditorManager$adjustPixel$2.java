package com.tencent.mobileqq.zplan.aigc.render;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager$adjustPixel$2", f = "ZplanFilamentAIGCEditorManager.kt", i = {0}, l = {TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR}, m = "invokeSuspend", n = {"adjustedBitmap"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class ZplanFilamentAIGCEditorManager$adjustPixel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ double $gamma;
    final /* synthetic */ double $highlightGamma;
    final /* synthetic */ Bitmap $originalBitmap;
    final /* synthetic */ double $shadowGamma;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZplanFilamentAIGCEditorManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanFilamentAIGCEditorManager$adjustPixel$2(Bitmap bitmap, ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager, double d16, double d17, double d18, Continuation<? super ZplanFilamentAIGCEditorManager$adjustPixel$2> continuation) {
        super(2, continuation);
        this.$originalBitmap = bitmap;
        this.this$0 = zplanFilamentAIGCEditorManager;
        this.$gamma = d16;
        this.$shadowGamma = d17;
        this.$highlightGamma = d18;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZplanFilamentAIGCEditorManager$adjustPixel$2 zplanFilamentAIGCEditorManager$adjustPixel$2 = new ZplanFilamentAIGCEditorManager$adjustPixel$2(this.$originalBitmap, this.this$0, this.$gamma, this.$shadowGamma, this.$highlightGamma, continuation);
        zplanFilamentAIGCEditorManager$adjustPixel$2.L$0 = obj;
        return zplanFilamentAIGCEditorManager$adjustPixel$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((ZplanFilamentAIGCEditorManager$adjustPixel$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                Bitmap bitmap = (Bitmap) this.L$0;
                ResultKt.throwOnFailure(obj);
                return bitmap;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        int width = this.$originalBitmap.getWidth();
        int height = this.$originalBitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        ArrayList arrayList = new ArrayList();
        int i16 = (height + 127) / 128;
        int i17 = 0;
        while (i17 < i16) {
            int i18 = i17 + 1;
            int i19 = width;
            Bitmap bitmap2 = createBitmap;
            ArrayList arrayList2 = arrayList;
            CoroutineScope coroutineScope2 = coroutineScope;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new ZplanFilamentAIGCEditorManager$adjustPixel$2$deferredBlock$1(i17 * 128, Math.min(i18 * 128, height), i19, this.$originalBitmap, this.this$0, this.$gamma, this.$shadowGamma, this.$highlightGamma, bitmap2, null), 3, null);
            arrayList2.add(async$default);
            width = i19;
            arrayList = arrayList2;
            createBitmap = bitmap2;
            coroutine_suspended = coroutine_suspended;
            coroutineScope = coroutineScope2;
            i16 = i16;
            i17 = i18;
            height = height;
        }
        Object obj2 = coroutine_suspended;
        Bitmap bitmap3 = createBitmap;
        this.L$0 = bitmap3;
        this.label = 1;
        return AwaitKt.awaitAll(arrayList, this) == obj2 ? obj2 : bitmap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i3, Bitmap bitmap, ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager, double d16, double d17, double d18, Bitmap bitmap2, int i16, int i17) {
        int F;
        int F2;
        int F3;
        for (int i18 = i16; i18 < i17; i18++) {
            for (int i19 = 0; i19 < i3; i19++) {
                int pixel = bitmap.getPixel(i19, i18);
                int alpha = Color.alpha(pixel);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                F = zplanFilamentAIGCEditorManager.F(red, d16, d17, d18);
                F2 = zplanFilamentAIGCEditorManager.F(green, d16, d17, d18);
                F3 = zplanFilamentAIGCEditorManager.F(blue, d16, d17, d18);
                bitmap2.setPixel(i19, i18, Color.argb(alpha, F, F2, F3));
            }
        }
    }
}
