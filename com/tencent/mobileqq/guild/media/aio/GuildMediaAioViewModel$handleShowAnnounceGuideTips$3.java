package com.tencent.mobileqq.guild.media.aio;

import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig;
import com.tencent.mobileqq.guild.util.bw;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel$handleShowAnnounceGuideTips$3", f = "GuildMediaAioViewModel.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildMediaAioViewModel$handleShowAnnounceGuideTips$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaGuidanceConfig.NavConfigData $navConfigData;
    final /* synthetic */ int $times;
    int label;
    final /* synthetic */ GuildMediaAioViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaAioViewModel$handleShowAnnounceGuideTips$3(MediaGuidanceConfig.NavConfigData navConfigData, GuildMediaAioViewModel guildMediaAioViewModel, int i3, Continuation<? super GuildMediaAioViewModel$handleShowAnnounceGuideTips$3> continuation) {
        super(2, continuation);
        this.$navConfigData = navConfigData;
        this.this$0 = guildMediaAioViewModel;
        this.$times = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaAioViewModel$handleShowAnnounceGuideTips$3(this.$navConfigData, this.this$0, this.$times, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            JSONArray userEnterTime = this.$navConfigData.getUserEnterTime();
            if (userEnterTime != null) {
                i3 = userEnterTime.getInt(0);
            } else {
                i3 = 2;
            }
            this.label = 1;
            if (DelayKt.delay(i3 * 1000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildMediaLocalCombineStyleItemManager combineTipsManager = this.this$0.getCombineTipsManager();
        if (combineTipsManager != null) {
            Integer boxInt = Boxing.boxInt(R.drawable.guild_media_announce_msg_tips_icon);
            String qqStr = HardCodeUtil.qqStr(R.string.f1492311q);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_media_announce_msg_tip)");
            GuildMediaLocalCombineStyleItemManager.l(combineTipsManager, boxInt, qqStr, null, Boxing.boxInt(R.drawable.guild_media_announce_guide_msg_item_bg), UIUtil.f112434a.x().getColor(R.color.f157130bn1), 4, null);
        }
        bw.f235485a.u1(this.$times + 1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaAioViewModel$handleShowAnnounceGuideTips$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
