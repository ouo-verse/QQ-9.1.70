package com.tencent.mobileqq.guild.discoveryv2.content.recommend;

import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$install$1", f = "PlayableManager.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class PlayableManager$install$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ RecyclerView $recyclerView;
    int label;
    final /* synthetic */ PlayableManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayableManager$install$1(Lifecycle lifecycle, PlayableManager playableManager, RecyclerView recyclerView, Continuation<? super PlayableManager$install$1> continuation) {
        super(2, continuation);
        this.$lifecycle = lifecycle;
        this.this$0 = playableManager;
        this.$recyclerView = recyclerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PlayableManager$install$1(this.$lifecycle, this.this$0, this.$recyclerView, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                Logger.f235387a.d().i("PlayableManager", 1, VRReportDefine$ReportKey.INSTALL);
                this.$lifecycle.addObserver(this.this$0.g());
                this.$recyclerView.addOnScrollListener(this.this$0.h());
                this.label = 1;
                if (DelayKt.awaitCancellation(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            throw new KotlinNothingValueException();
        } catch (Throwable th5) {
            Logger.f235387a.d().i("PlayableManager", 1, "uninstall");
            this.$lifecycle.removeObserver(this.this$0.g());
            this.$recyclerView.removeOnScrollListener(this.this$0.h());
            throw th5;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PlayableManager$install$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
