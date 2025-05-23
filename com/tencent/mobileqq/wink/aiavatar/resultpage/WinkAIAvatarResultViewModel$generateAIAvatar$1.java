package com.tencent.mobileqq.wink.aiavatar.resultpage;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wink.aigc.utils.WinkAIGCRequestUtils;
import com.tencent.mobileqq.wink.aigc.utils.WinkMakeAIImageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultViewModel$generateAIAvatar$1", f = "WinkAIAvatarResultViewModel.kt", i = {2}, l = {409, 410, 418}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkAIAvatarResultViewModel$generateAIAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRegenerate;
    final /* synthetic */ List<Bitmap> $originBimapList;
    Object L$0;
    int label;
    final /* synthetic */ WinkAIAvatarResultViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIAvatarResultViewModel$generateAIAvatar$1(WinkAIAvatarResultViewModel winkAIAvatarResultViewModel, List<Bitmap> list, boolean z16, Continuation<? super WinkAIAvatarResultViewModel$generateAIAvatar$1> continuation) {
        super(2, continuation);
        this.this$0 = winkAIAvatarResultViewModel;
        this.$originBimapList = list;
        this.$isRegenerate = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAIAvatarResultViewModel$generateAIAvatar$1(this.this$0, this.$originBimapList, this.$isRegenerate, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object W2;
        List<Pair<String, String>> list;
        Object L2;
        WinkMakeAIImageResponse winkMakeAIImageResponse;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        winkMakeAIImageResponse = (WinkMakeAIImageResponse) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.this$0._onAIAvatarGenerated.postValue(winkMakeAIImageResponse);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                WinkMakeAIImageResponse winkMakeAIImageResponse2 = (WinkMakeAIImageResponse) obj;
                WinkAIAvatarResultViewModel winkAIAvatarResultViewModel = this.this$0;
                this.L$0 = winkMakeAIImageResponse2;
                this.label = 3;
                L2 = winkAIAvatarResultViewModel.L2(winkMakeAIImageResponse2, this);
                if (L2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                winkMakeAIImageResponse = winkMakeAIImageResponse2;
                this.this$0._onAIAvatarGenerated.postValue(winkMakeAIImageResponse);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            WinkAIAvatarResultViewModel winkAIAvatarResultViewModel2 = this.this$0;
            List<Bitmap> list2 = this.$originBimapList;
            this.label = 1;
            W2 = winkAIAvatarResultViewModel2.W2(list2, this);
            if (W2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        WinkAIGCRequestUtils winkAIGCRequestUtils = WinkAIGCRequestUtils.f317926a;
        list = this.this$0.croppedImageList;
        boolean z16 = this.$isRegenerate;
        String y06 = com.tencent.mobileqq.wink.editor.c.y0(this.this$0.selectedStyleMaterial);
        boolean Z0 = com.tencent.mobileqq.wink.editor.c.Z0(this.this$0.selectedStyleMaterial);
        String str = this.this$0.selectedStyleMaterial.f30533id;
        Intrinsics.checkNotNullExpressionValue(str, "selectedStyleMaterial.id");
        this.label = 2;
        obj = winkAIGCRequestUtils.h("qzone_ai_avatar", list, z16, y06, Z0, str, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        WinkMakeAIImageResponse winkMakeAIImageResponse22 = (WinkMakeAIImageResponse) obj;
        WinkAIAvatarResultViewModel winkAIAvatarResultViewModel3 = this.this$0;
        this.L$0 = winkMakeAIImageResponse22;
        this.label = 3;
        L2 = winkAIAvatarResultViewModel3.L2(winkMakeAIImageResponse22, this);
        if (L2 != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIAvatarResultViewModel$generateAIAvatar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
