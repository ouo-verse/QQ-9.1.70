package com.tencent.mobileqq.zplan.aigc;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$changeUIofComplete$3$2;
import com.tencent.mobileqq.zplan.aigc.data.AIGCModelRenderTask;
import com.tencent.mobileqq.zplan.aigc.data.PatternImage;
import com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem;
import com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.os.MqqHandler;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$changeUIofComplete$3$2", f = "SuitPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitPreviewFragment$changeUIofComplete$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SuitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitPreviewFragment$changeUIofComplete$3$2(SuitPreviewFragment suitPreviewFragment, Continuation<? super SuitPreviewFragment$changeUIofComplete$3$2> continuation) {
        super(2, continuation);
        this.this$0 = suitPreviewFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitPreviewFragment$changeUIofComplete$3$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AigcPreviewBusinessScene aigcPreviewBusinessScene = this.this$0.scene;
            if (aigcPreviewBusinessScene != null) {
                aigcPreviewBusinessScene.recordFrame(new a(this.this$0));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitPreviewFragment$changeUIofComplete$3$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitPreviewFragment$changeUIofComplete$3$2$a", "Lcom/tencent/filament/zplan/d;", "", "pixels", "", "width", "height", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.filament.zplan.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SuitPreviewFragment f330051a;

        a(SuitPreviewFragment suitPreviewFragment) {
            this.f330051a = suitPreviewFragment;
        }

        @Override // com.tencent.filament.zplan.d
        public void a(final byte[] pixels, final int width, final int height) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final SuitPreviewFragment suitPreviewFragment = this.f330051a;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.ce
                @Override // java.lang.Runnable
                public final void run() {
                    SuitPreviewFragment$changeUIofComplete$3$2.a.c(SuitPreviewFragment.this, width, height, pixels);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009a, code lost:
        
            r1 = r14.suitShareDialog;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void c(SuitPreviewFragment this$0, int i3, int i16, byte[] bArr) {
            com.tencent.mobileqq.zplan.aigc.share.bl blVar;
            Bitmap createBitmap;
            uv4.bn data;
            uv4.az azVar;
            com.tencent.mobileqq.zplan.aigc.share.bl blVar2;
            Drawable drawable;
            int i17;
            String str;
            AIGCModelRenderTask selectedPatternTask;
            PatternImage patternImage;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.i("SuitPreviewFragment", 1, "onRecordFrame");
            blVar = this$0.suitShareDialog;
            boolean z16 = false;
            if (blVar != null && blVar.b()) {
                QLog.i("SuitPreviewFragment", 1, "dialog is showing");
                return;
            }
            if (bArr != null && i3 * i16 * 4 == bArr.length) {
                z16 = true;
            }
            if (z16) {
                AIGCHelper aIGCHelper = AIGCHelper.f330685a;
                a.Companion companion = com.tencent.zplan.meme.encoder.a.INSTANCE;
                Intrinsics.checkNotNull(bArr);
                createBitmap = AIGCHelper.f(aIGCHelper, a.Companion.b(companion, bArr, i3, i16, null, 4, null), bArr, i3, i16, false, 16, null);
            } else {
                QLog.w("SuitPreviewFragment", 1, "onRecordFrame pixels size != width * height * 4");
                createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            }
            Bitmap bitmap = createBitmap;
            if (bitmap != null) {
                CreatedClothShowLogic createdClothLogic = this$0.getCreatedClothLogic();
                Bitmap bitmap2 = (createdClothLogic == null || (selectedPatternTask = createdClothLogic.getSelectedPatternTask()) == null || (patternImage = selectedPatternTask.getPatternImage()) == null) ? null : patternImage.getBitmap();
                SuitWhiteModelItem selectedWhiteModelItem = this$0.Aj().getSelectedWhiteModelItem();
                if (selectedWhiteModelItem == null || (data = selectedWhiteModelItem.getData()) == null || (azVar = data.f440382g) == null || blVar2 == null) {
                    return;
                }
                String description = this$0.Aj().getDescription();
                String str2 = azVar.f440277d;
                Intrinsics.checkNotNullExpressionValue(str2, "it1.name");
                long L2 = this$0.Aj().L2();
                Bitmap clothBitmap = this$0.getClothBitmap();
                drawable = this$0.qqHeadDrawable;
                zd3.a aVar = this$0.dtReporter;
                i17 = this$0.gender;
                str = this$0.source;
                blVar2.c(description, str2, L2, "1", bitmap2, clothBitmap, bitmap, drawable, aVar, i17, str);
            }
        }
    }
}
