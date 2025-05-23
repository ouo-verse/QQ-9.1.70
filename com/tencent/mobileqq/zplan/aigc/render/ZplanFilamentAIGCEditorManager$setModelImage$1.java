package com.tencent.mobileqq.zplan.aigc.render;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager$setModelImage$1", f = "ZplanFilamentAIGCEditorManager.kt", i = {0, 0}, l = {263}, m = "invokeSuspend", n = {"extraInfo", "style"}, s = {"L$0", "L$1"})
/* loaded from: classes35.dex */
public final class ZplanFilamentAIGCEditorManager$setModelImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $bUpdateTexture;
    final /* synthetic */ String $color;
    final /* synthetic */ int $height;
    final /* synthetic */ int $index;
    final /* synthetic */ g $listener;
    final /* synthetic */ AIGCWhiteModel $model;
    final /* synthetic */ Bitmap $pattern;
    final /* synthetic */ int $width;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ZplanFilamentAIGCEditorManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanFilamentAIGCEditorManager$setModelImage$1(AIGCWhiteModel aIGCWhiteModel, int i3, ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager, Bitmap bitmap, String str, int i16, int i17, boolean z16, g gVar, Continuation<? super ZplanFilamentAIGCEditorManager$setModelImage$1> continuation) {
        super(2, continuation);
        this.$model = aIGCWhiteModel;
        this.$index = i3;
        this.this$0 = zplanFilamentAIGCEditorManager;
        this.$pattern = bitmap;
        this.$color = str;
        this.$width = i16;
        this.$height = i17;
        this.$bUpdateTexture = z16;
        this.$listener = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZplanFilamentAIGCEditorManager$setModelImage$1(this.$model, this.$index, this.this$0, this.$pattern, this.$color, this.$width, this.$height, this.$bUpdateTexture, this.$listener, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZplanFilamentAIGCEditorManager$setModelImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00b2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Bitmap bitmap;
        ModelExtraInfo modelExtraInfo;
        ModelStyle modelStyle;
        Object G;
        ModelExtraInfo modelExtraInfo2;
        EditTexture N;
        Bitmap c16;
        boolean z16;
        String str;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i16 = 0;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AIGCWhiteModel aIGCWhiteModel = this.$model;
            bitmap = null;
            modelExtraInfo = aIGCWhiteModel != null ? aIGCWhiteModel.getModelExtraInfo() : null;
            List<ModelStyle> modelStyles = modelExtraInfo != null ? modelExtraInfo.getModelStyles() : null;
            List<ModelStyle> list = modelStyles;
            if (list == null || list.isEmpty()) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final g gVar = this.$listener;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZplanFilamentAIGCEditorManager$setModelImage$1.d(g.this);
                    }
                });
                return Unit.INSTANCE;
            }
            int size = modelStyles.size();
            int i17 = this.$index;
            if (size > i17 && i17 >= 0) {
                modelStyle = modelStyles.get(i17);
                this.this$0.materialTextureMap.clear();
                Bitmap bitmap2 = this.$pattern;
                if (bitmap2 != null) {
                    ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = this.this$0;
                    this.L$0 = modelExtraInfo;
                    this.L$1 = modelStyle;
                    this.label = 1;
                    G = zplanFilamentAIGCEditorManager.G(bitmap2, 1.7d, 0.5d, 2.2d, this);
                    if (G == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    modelExtraInfo2 = modelExtraInfo;
                }
                for (Material material : modelExtraInfo.getMaterials()) {
                    N = this.this$0.N(material.getName(), modelStyle.getEditTextures());
                    if (N == null || bitmap == null) {
                        c16 = com.tencent.mobileqq.zplan.utils.l.f335829a.c(this.$color, this.$width, this.$height, (r20 & 8) != 0 ? null : null, (r20 & 16) != 0 ? 0 : 0, (r20 & 32) != 0 ? 0 : 0, (r20 & 64) != 0 ? 0 : 0, (r20 & 128) != 0 ? 0 : 0);
                        this.this$0.currentPureColorImage = c16;
                    } else {
                        if (N.getPositions() != null && (!N.getPositions().isEmpty()) && N.getPositions().get(i16).getPosition() != null && N.getPositions().get(i16).getPosition().size() == 4) {
                            ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager2 = this.this$0;
                            String str3 = this.$color;
                            Integer width = N.getWidth();
                            Intrinsics.checkNotNull(width);
                            int intValue = width.intValue();
                            Integer height = N.getHeight();
                            Intrinsics.checkNotNull(height);
                            c16 = zplanFilamentAIGCEditorManager2.J(str3, intValue, height.intValue(), bitmap, N.getPositions());
                        } else {
                            List<Double> position = N.getPosition();
                            if (position != null && position.size() >= 4) {
                                c16 = this.this$0.I(this.$color, this.$width, this.$height, bitmap, position);
                            }
                        }
                        this.this$0.currentPatternImage = c16;
                    }
                    QLog.d("ZplanFilamentAIGCManager", 1, "aatest setModelImage: " + this.$model.getSlotID() + ", " + material.getName() + ", " + material.getTextureKey() + ", " + this.$color + ", " + this.$index);
                    GYFZPlanController gYFZPlanController = this.this$0.filamentController;
                    if (gYFZPlanController != null) {
                        gYFZPlanController.e0(String.valueOf(this.$model.getSlotID()), material.getName(), material.getTextureKey(), c16);
                    }
                    this.this$0.materialTextureMap.put(material.getMatSlotName(), c16);
                    z16 = this.this$0.isDebug;
                    if (z16) {
                        com.tencent.mobileqq.zplan.utils.l lVar = com.tencent.mobileqq.zplan.utils.l.f335829a;
                        str = this.this$0.cacheDirPath;
                        lVar.f(str + "/debug", material.getName(), c16);
                        FLog fLog = FLog.INSTANCE;
                        str2 = this.this$0.cacheDirPath;
                        fLog.d("ZplanFilamentAIGCManager", " setModelImage saveBitmapToFile " + str2);
                    }
                    if (this.$bUpdateTexture) {
                        GYFZPlanController gYFZPlanController2 = this.this$0.offScreenController;
                        if (gYFZPlanController2 != null) {
                            gYFZPlanController2.e0(String.valueOf(this.$model.getSlotID()), material.getName(), material.getTextureKey(), c16);
                        }
                        boolean z17 = this.this$0.offScreenController == null ? 1 : i16;
                        QLog.d("ZplanFilamentAIGCManager", 1, " offScreenController setModelImage: " + z17 + ", " + this.$model.getSlotID() + ", " + material.getName() + ", " + material.getTextureKey() + ", " + this.$color + ", " + this.$index);
                        i16 = 0;
                    }
                }
                Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                final g gVar2 = this.$listener;
                uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZplanFilamentAIGCEditorManager$setModelImage$1.f(g.this);
                    }
                });
                return Unit.INSTANCE;
            }
            Handler uIHandlerV23 = ThreadManagerV2.getUIHandlerV2();
            final g gVar3 = this.$listener;
            uIHandlerV23.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.k
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanFilamentAIGCEditorManager$setModelImage$1.e(g.this);
                }
            });
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            ModelStyle modelStyle2 = (ModelStyle) this.L$1;
            modelExtraInfo2 = (ModelExtraInfo) this.L$0;
            ResultKt.throwOnFailure(obj);
            modelStyle = modelStyle2;
            G = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        modelExtraInfo = modelExtraInfo2;
        bitmap = (Bitmap) G;
        while (r0.hasNext()) {
        }
        Handler uIHandlerV222 = ThreadManagerV2.getUIHandlerV2();
        final g gVar22 = this.$listener;
        uIHandlerV222.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.l
            @Override // java.lang.Runnable
            public final void run() {
                ZplanFilamentAIGCEditorManager$setModelImage$1.f(g.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(g gVar) {
        if (gVar != null) {
            gVar.b(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(g gVar) {
        if (gVar != null) {
            gVar.b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(g gVar) {
        if (gVar != null) {
            gVar.b(0);
        }
    }
}
