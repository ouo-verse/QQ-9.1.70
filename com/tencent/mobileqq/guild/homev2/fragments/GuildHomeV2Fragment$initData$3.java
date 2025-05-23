package com.tencent.mobileqq.guild.homev2.fragments;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wo1.ImageColorInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment$initData$3", f = "GuildHomeV2Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeV2Fragment$initData$3 extends SuspendLambda implements Function2<GuildHomeViewModel.GuildHomeUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildHomeV2Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeV2Fragment$initData$3(GuildHomeV2Fragment guildHomeV2Fragment, Continuation<? super GuildHomeV2Fragment$initData$3> continuation) {
        super(2, continuation);
        this.this$0 = guildHomeV2Fragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildHomeV2Fragment$initData$3 guildHomeV2Fragment$initData$3 = new GuildHomeV2Fragment$initData$3(this.this$0, continuation);
        guildHomeV2Fragment$initData$3.L$0 = obj;
        return guildHomeV2Fragment$initData$3;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull GuildHomeViewModel.GuildHomeUiState guildHomeUiState, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeV2Fragment$initData$3) create(guildHomeUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ImageColorInfo imageColorInfo;
        wo1.a aVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GuildHomeViewModel.GuildHomeUiState guildHomeUiState = (GuildHomeViewModel.GuildHomeUiState) this.L$0;
            Logger.f235387a.d().i("Guild.NewHome.GuildHomeV2Fragment", 1, "guildHomeUiState: " + guildHomeUiState);
            if (guildHomeUiState.getGuildInfo() == null && guildHomeUiState.getGuildInfoSourceType() != 0) {
                this.this$0.Kh();
            }
            IGProGuildInfo guildInfo = guildHomeUiState.getGuildInfo();
            if (guildInfo == null) {
                return Unit.INSTANCE;
            }
            int color = this.this$0.getResources().getColor(R.color.qui_common_bg_bottom_light);
            String coverUrl = guildInfo.getCoverUrl(0, 0);
            Intrinsics.checkNotNullExpressionValue(coverUrl, "guildInfo.getCoverUrl(0, 0)");
            ImageColorInfo imageColorInfo2 = new ImageColorInfo(coverUrl, color, true);
            imageColorInfo = this.this$0.imageCoverInfo;
            if (!Intrinsics.areEqual(imageColorInfo, imageColorInfo2)) {
                this.this$0.imageCoverInfo = imageColorInfo2;
                aVar = this.this$0.coverInfoListener;
                if (aVar != null) {
                    aVar.a(this.this$0.getGuildId(), imageColorInfo2);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
