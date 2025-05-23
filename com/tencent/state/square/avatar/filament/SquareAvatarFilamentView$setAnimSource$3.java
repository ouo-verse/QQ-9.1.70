package com.tencent.state.square.avatar.filament;

import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.view.FilterEnum;
import com.tencent.zplan.zplantracing.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.square.avatar.filament.SquareAvatarFilamentView$setAnimSource$3", f = "SquareAvatarFilamentView.kt", i = {}, l = {FilterEnum.MIC_PTU_TRANS_XINXIAN}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes38.dex */
public final class SquareAvatarFilamentView$setAnimSource$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $guestUin;
    final /* synthetic */ Function2 $handleException;
    final /* synthetic */ long $hostUin;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ SquareAvatarFilamentView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarFilamentView$setAnimSource$3(SquareAvatarFilamentView squareAvatarFilamentView, long j3, Long l3, String str, Function2 function2, Continuation continuation) {
        super(1, continuation);
        this.this$0 = squareAvatarFilamentView;
        this.$hostUin = j3;
        this.$guestUin = l3;
        this.$url = str;
        this.$handleException = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SquareAvatarFilamentView$setAnimSource$3(this.this$0, this.$hostUin, this.$guestUin, this.$url, this.$handleException, completion);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SquareAvatarFilamentView$setAnimSource$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IActionHelper iActionHelper;
        MapPlayableSource mapPlayableSource;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305;
        b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                iActionHelper = this.this$0.actionHelper;
                long j3 = this.$hostUin;
                Long l3 = this.$guestUin;
                String str = this.$url;
                this.label = 1;
                obj = iActionHelper.loadPlayParams(j3, l3, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Triple triple = (Triple) obj;
            MoodConfig moodConfig = (MoodConfig) triple.component1();
            SquareAvatarData squareAvatarData = (SquareAvatarData) triple.component2();
            LoadFilamentAssetsStatistics loadFilamentAssetsStatistics = (LoadFilamentAssetsStatistics) triple.component3();
            SquareBaseKt.getSquareLog().i("SquareAvatarFilamentView", "loadPlayParams: mcCost=" + loadFilamentAssetsStatistics.getLoadMoodConfigCost() + ", mcFromNet:" + loadFilamentAssetsStatistics.getLoadMoodConfigFromNet() + ", hostInfoCost:" + loadFilamentAssetsStatistics.getLoadHostAvatarInfoCost() + ", guestInfoCost:" + loadFilamentAssetsStatistics.getLoadGuestAvatarInfoCost());
            mapPlayableSource = this.this$0.currentSource;
            if (moodConfig.isCurrentSelect(mapPlayableSource != null ? mapPlayableSource.getRemoteUrl() : null)) {
                this.this$0.currentPlayData = squareAvatarData;
                this.this$0.currentMoodConfig = moodConfig;
                iFilamentNativeAppV2305 = this.this$0.filamentApp;
                if (iFilamentNativeAppV2305 != null) {
                    bVar = this.this$0.filamentSpan;
                    iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, "SquareAvatarScene.ON_LOAD", squareAvatarData.toJson());
                }
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.filament.SquareAvatarFilamentView$setAnimSource$3.1
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
                        SquareAvatarFilamentView$setAnimSource$3.this.this$0.resume();
                    }
                });
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } catch (Exception e16) {
            this.$handleException.invoke(null, e16);
            return Unit.INSTANCE;
        }
    }
}
