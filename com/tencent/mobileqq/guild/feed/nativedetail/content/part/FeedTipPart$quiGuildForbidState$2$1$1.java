package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart$quiGuildForbidState$2$1$1", f = "FeedTipPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedTipPart$quiGuildForbidState$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuildHomeBanLayout $this_apply;
    int label;
    final /* synthetic */ FeedTipPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTipPart$quiGuildForbidState$2$1$1(FeedTipPart feedTipPart, GuildHomeBanLayout guildHomeBanLayout, Continuation<? super FeedTipPart$quiGuildForbidState$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = feedTipPart;
        this.$this_apply = guildHomeBanLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedTipPart feedTipPart, GuildHomeBanLayout guildHomeBanLayout, int i3, String str, IGProGuildInfo iGProGuildInfo, List list) {
        if (i3 == 0 && iGProGuildInfo != null) {
            LifecycleCoroutineScope e16 = com.tencent.mobileqq.guild.feed.part.a.e(feedTipPart);
            if (e16 != null) {
                BuildersKt__Builders_commonKt.launch$default(e16, com.tencent.mobileqq.guild.feed.util.ae.a().e(), null, new FeedTipPart$quiGuildForbidState$2$1$1$1$1(guildHomeBanLayout, iGProGuildInfo, null), 2, null);
                return;
            }
            return;
        }
        QLog.e("FeedTipPart", 1, "fetchGuestGuild fail. errMsg:" + str);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedTipPart$quiGuildForbidState$2$1$1(this.this$0, this.$this_apply, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String string = GuildSplitViewUtils.f235370a.h(this.this$0.getPartHost()).getString("guild_id", "");
            if (string == null) {
                string = "";
            }
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            final FeedTipPart feedTipPart = this.this$0;
            final GuildHomeBanLayout guildHomeBanLayout = this.$this_apply;
            ((IGPSService) S0).fetchGuestGuild(string, false, new vh2.s() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.x
                @Override // vh2.s
                public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo, List list) {
                    FeedTipPart$quiGuildForbidState$2$1$1.b(FeedTipPart.this, guildHomeBanLayout, i3, str, iGProGuildInfo, list);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedTipPart$quiGuildForbidState$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
