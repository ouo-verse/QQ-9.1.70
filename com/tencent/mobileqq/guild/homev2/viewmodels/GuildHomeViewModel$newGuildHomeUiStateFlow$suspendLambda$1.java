package com.tencent.mobileqq.guild.homev2.viewmodels;

import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import lp1.SubTabData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\n\u001a\u00020\t2\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u008a@"}, d2 = {"Lkotlin/Pair;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "", "guildInfoPair", "", "Llp1/c;", "tabs", "", "reconnectTime", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1", f = "GuildHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1 extends SuspendLambda implements Function4<Pair<? extends IGProGuildInfo, ? extends Integer>, List<? extends SubTabData>, Long, Continuation<? super GuildHomeViewModel.GuildHomeUiState>, Object> {
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1(Continuation<? super GuildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1> continuation) {
        super(4, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends IGProGuildInfo, ? extends Integer> pair, List<? extends SubTabData> list, Long l3, Continuation<? super GuildHomeViewModel.GuildHomeUiState> continuation) {
        return invoke((Pair<? extends IGProGuildInfo, Integer>) pair, (List<SubTabData>) list, l3.longValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            List list = (List) this.L$1;
            long j3 = this.J$0;
            IGProGuildInfo iGProGuildInfo = (IGProGuildInfo) pair.getFirst();
            boolean z19 = false;
            GuildHomeViewModel.GuildHomeUiState guildHomeUiState = new GuildHomeViewModel.GuildHomeUiState(false, false, false, false, null, 0, 0L, 127, null);
            guildHomeUiState.h(iGProGuildInfo);
            if (iGProGuildInfo != null && (!list.isEmpty() || ((!iGProGuildInfo.isMember() && !iGProGuildInfo.isVisibleForVisitor()) || iGProGuildInfo.getIsBanned()))) {
                z16 = false;
            } else {
                z16 = true;
            }
            guildHomeUiState.k(z16);
            if (iGProGuildInfo != null && iGProGuildInfo.getIsBanned()) {
                z17 = true;
            } else {
                z17 = false;
            }
            guildHomeUiState.g(z17);
            if (iGProGuildInfo != null && !guildHomeUiState.getIsBanedGuild() && iGProGuildInfo.isMember()) {
                z18 = true;
            } else {
                z18 = false;
            }
            guildHomeUiState.l(z18);
            guildHomeUiState.j(j3);
            if (iGProGuildInfo != null && !iGProGuildInfo.isMember() && !iGProGuildInfo.getIsBanned() && iGProGuildInfo.isVisibleForVisitor()) {
                z19 = true;
            }
            guildHomeUiState.m(z19);
            guildHomeUiState.i(((Number) pair.getSecond()).intValue());
            return guildHomeUiState;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull Pair<? extends IGProGuildInfo, Integer> pair, @NotNull List<SubTabData> list, long j3, @Nullable Continuation<? super GuildHomeViewModel.GuildHomeUiState> continuation) {
        GuildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1 guildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1 = new GuildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1(continuation);
        guildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1.L$0 = pair;
        guildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1.L$1 = list;
        guildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1.J$0 = j3;
        return guildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1.invokeSuspend(Unit.INSTANCE);
    }
}
