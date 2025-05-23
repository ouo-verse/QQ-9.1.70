package com.tencent.mobileqq.wink.dailysign;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.dailysign.DailySignViewModel$recoveryFromMissionId$1", f = "DailySignViewModel.kt", i = {}, l = {482, 483}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class DailySignViewModel$recoveryFromMissionId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ dr.WinkTavCutParams $winkTavCutParams;
    final /* synthetic */ WinkEditDataWrapper $wrapper;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DailySignViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailySignViewModel$recoveryFromMissionId$1(DailySignViewModel dailySignViewModel, WinkEditDataWrapper winkEditDataWrapper, dr.WinkTavCutParams winkTavCutParams, Continuation<? super DailySignViewModel$recoveryFromMissionId$1> continuation) {
        super(2, continuation);
        this.this$0 = dailySignViewModel;
        this.$wrapper = winkEditDataWrapper;
        this.$winkTavCutParams = winkTavCutParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DailySignViewModel$recoveryFromMissionId$1 dailySignViewModel$recoveryFromMissionId$1 = new DailySignViewModel$recoveryFromMissionId$1(this.this$0, this.$wrapper, this.$winkTavCutParams, continuation);
        dailySignViewModel$recoveryFromMissionId$1.L$0 = obj;
        return dailySignViewModel$recoveryFromMissionId$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        DailyDataSource i26;
        DailySignConfig dailySignConfig;
        DailySignConfig dailySignConfig2;
        DailySignConfig dailySignConfig3;
        MutableLiveData mutableLiveData;
        Map<String, MetaMaterial> templateMaterialMap;
        Collection<MetaMaterial> values;
        Object elementAtOrNull;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        MetaMaterial metaMaterial = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    DailySignViewModel dailySignViewModel = this.this$0;
                    dailySignConfig2 = dailySignViewModel.dailySignConfig;
                    if (dailySignConfig2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                        dailySignConfig2 = null;
                    }
                    dailySignViewModel.backPicPathRandomIndex = dailySignConfig2.getBackGroundPicIndex();
                    dailySignConfig3 = dailySignViewModel.dailySignConfig;
                    if (dailySignConfig3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                        dailySignConfig3 = null;
                    }
                    dailySignViewModel.allBackgroundPic = dailySignConfig3.getBackGroundPic();
                    mutableLiveData = this.this$0._previewDataPrepared;
                    Result.Companion companion = Result.INSTANCE;
                    templateMaterialMap = this.$wrapper.getEditDatas().get(0).getTemplateMaterialMap();
                    if (templateMaterialMap != null && (values = templateMaterialMap.values()) != null) {
                        elementAtOrNull = CollectionsKt___CollectionsKt.elementAtOrNull(values, 0);
                        metaMaterial = (MetaMaterial) elementAtOrNull;
                    }
                    MetaMaterial metaMaterial2 = metaMaterial;
                    Intrinsics.checkNotNull(metaMaterial2);
                    HashMap<String, String> assetData = this.$wrapper.getEditDatas().get(0).getAssetData();
                    WinkEditDataWrapper wrapper = this.$wrapper;
                    Intrinsics.checkNotNullExpressionValue(wrapper, "wrapper");
                    mutableLiveData.setValue(Result.m475boximpl(Result.m476constructorimpl(new al(null, metaMaterial2, assetData, wrapper, this.$winkTavCutParams))));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            i26 = this.this$0.i2();
            dailySignConfig = this.this$0.dailySignConfig;
            if (dailySignConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dailySignConfig");
                dailySignConfig = null;
            }
            this.label = 1;
            obj = i26.d(coroutineScope, dailySignConfig, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.label = 2;
        if (((Deferred) obj).await(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Unit unit2 = Unit.INSTANCE;
        DailySignViewModel dailySignViewModel2 = this.this$0;
        dailySignConfig2 = dailySignViewModel2.dailySignConfig;
        if (dailySignConfig2 == null) {
        }
        dailySignViewModel2.backPicPathRandomIndex = dailySignConfig2.getBackGroundPicIndex();
        dailySignConfig3 = dailySignViewModel2.dailySignConfig;
        if (dailySignConfig3 == null) {
        }
        dailySignViewModel2.allBackgroundPic = dailySignConfig3.getBackGroundPic();
        mutableLiveData = this.this$0._previewDataPrepared;
        Result.Companion companion2 = Result.INSTANCE;
        templateMaterialMap = this.$wrapper.getEditDatas().get(0).getTemplateMaterialMap();
        if (templateMaterialMap != null) {
            elementAtOrNull = CollectionsKt___CollectionsKt.elementAtOrNull(values, 0);
            metaMaterial = (MetaMaterial) elementAtOrNull;
        }
        MetaMaterial metaMaterial22 = metaMaterial;
        Intrinsics.checkNotNull(metaMaterial22);
        HashMap<String, String> assetData2 = this.$wrapper.getEditDatas().get(0).getAssetData();
        WinkEditDataWrapper wrapper2 = this.$wrapper;
        Intrinsics.checkNotNullExpressionValue(wrapper2, "wrapper");
        mutableLiveData.setValue(Result.m475boximpl(Result.m476constructorimpl(new al(null, metaMaterial22, assetData2, wrapper2, this.$winkTavCutParams))));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DailySignViewModel$recoveryFromMissionId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
