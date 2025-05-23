package com.tencent.mobileqq.zootopia.portal.aigc.preview;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.AvatarResourceModel;
import com.tencent.filament.zplan.avatar.model.ZPlanDressUpFAsset;
import com.tencent.filament.zplan.avatar.model.ZPlanFAsset;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import uv4.az;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$requestAvatarSlotRes$1", f = "AigcPreviewBusinessScene.kt", i = {}, l = {528}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class AigcPreviewBusinessScene$requestAvatarSlotRes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AigcPreviewBusinessScene.a $listener;
    final /* synthetic */ String $slotId;
    final /* synthetic */ az $storeItem;
    int label;
    final /* synthetic */ AigcPreviewBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcPreviewBusinessScene$requestAvatarSlotRes$1(az azVar, String str, AigcPreviewBusinessScene.a aVar, AigcPreviewBusinessScene aigcPreviewBusinessScene, Continuation<? super AigcPreviewBusinessScene$requestAvatarSlotRes$1> continuation) {
        super(2, continuation);
        this.$storeItem = azVar;
        this.$slotId = str;
        this.$listener = aVar;
        this.this$0 = aigcPreviewBusinessScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AigcPreviewBusinessScene$requestAvatarSlotRes$1(this.$storeItem, this.$slotId, this.$listener, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        AvatarResourceModel avatarResourceModel;
        Map<String, ZPlanFAsset> j3;
        qu4.a b16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Throwable th5) {
            QLog.e(AbsBusinessScene.TAG, 1, "fetchAvatarResource exception", th5);
        }
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            az azVar = this.$storeItem;
            JSONObject h16 = (azVar == null || (b16 = bj3.a.b(azVar)) == null) ? null : r94.c.h(b16);
            if (h16 != null) {
                AigcPreviewBusinessScene aigcPreviewBusinessScene = this.this$0;
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                FilamentUrlTemplate urlTemplate = aigcPreviewBusinessScene.getUrlTemplate();
                this.label = 1;
                obj = zPlanAvatarResourceHelper.D(null, h16, urlTemplate, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            avatarResourceModel = null;
            ZPlanFAsset zPlanFAsset = (avatarResourceModel != null || (j3 = avatarResourceModel.j()) == null) ? null : j3.get(this.$slotId);
            ZPlanDressUpFAsset zPlanDressUpFAsset = !(zPlanFAsset instanceof ZPlanDressUpFAsset) ? (ZPlanDressUpFAsset) zPlanFAsset : null;
            this.$listener.onSuccess(this.$slotId, zPlanDressUpFAsset != null ? zPlanDressUpFAsset.getGltfFilePath() : null);
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        avatarResourceModel = (AvatarResourceModel) obj;
        if (avatarResourceModel != null) {
        }
        if (!(zPlanFAsset instanceof ZPlanDressUpFAsset)) {
        }
        this.$listener.onSuccess(this.$slotId, zPlanDressUpFAsset != null ? zPlanDressUpFAsset.getGltfFilePath() : null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AigcPreviewBusinessScene$requestAvatarSlotRes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
