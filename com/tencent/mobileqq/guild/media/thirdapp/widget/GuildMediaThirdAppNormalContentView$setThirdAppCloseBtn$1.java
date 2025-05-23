package com.tencent.mobileqq.guild.media.thirdapp.widget;

import android.widget.ImageView;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppNormalContentView$setThirdAppCloseBtn$1", f = "GuildMediaThirdAppNormalContentView.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildMediaThirdAppNormalContentView$setThirdAppCloseBtn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGProChannelInfo $channelInfo;
    final /* synthetic */ IGProGuildInfo $guildInfo;
    int label;
    final /* synthetic */ GuildMediaThirdAppNormalContentView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppNormalContentView$setThirdAppCloseBtn$1(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, GuildMediaThirdAppNormalContentView guildMediaThirdAppNormalContentView, Continuation<? super GuildMediaThirdAppNormalContentView$setThirdAppCloseBtn$1> continuation) {
        super(2, continuation);
        this.$guildInfo = iGProGuildInfo;
        this.$channelInfo = iGProChannelInfo;
        this.this$0 = guildMediaThirdAppNormalContentView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaThirdAppNormalContentView$setThirdAppCloseBtn$1(this.$guildInfo, this.$channelInfo, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ImageView imageView;
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
            GuildMediaUtils guildMediaUtils = GuildMediaUtils.f227771a;
            String guildID = this.$guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
            String channelUin = this.$channelInfo.getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
            this.label = 1;
            obj = guildMediaUtils.p(guildID, channelUin, 102, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Logger.f235387a.d().d("GuildMediaThirdAppNormalSubView", 1, "[setThirdAppCloseBtn] not admin visible " + booleanValue);
        imageView = this.this$0.mThirdAppCloseBtn;
        if (booleanValue) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaThirdAppNormalContentView$setThirdAppCloseBtn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
