package com.tencent.mobileqq.guild.home.parts;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
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
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.home.parts.GuildHomeSubFeedPart$updateGuild$2", f = "GuildHomeSubFeedPart.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildHomeSubFeedPart$updateGuild$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $extras;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GuildHomeSubFeedPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeSubFeedPart$updateGuild$2(GuildHomeSubFeedPart guildHomeSubFeedPart, Bundle bundle, Continuation<? super GuildHomeSubFeedPart$updateGuild$2> continuation) {
        super(2, continuation);
        this.this$0 = guildHomeSubFeedPart;
        this.$extras = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildHomeSubFeedPart$updateGuild$2 guildHomeSubFeedPart$updateGuild$2 = new GuildHomeSubFeedPart$updateGuild$2(this.this$0, this.$extras, continuation);
        guildHomeSubFeedPart$updateGuild$2.L$0 = obj;
        return guildHomeSubFeedPart$updateGuild$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        JumpGuildParam jumpGuildParam;
        GuildHomeSubFeedPart guildHomeSubFeedPart;
        Fragment fragment;
        Fragment fragment2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                guildHomeSubFeedPart = (GuildHomeSubFeedPart) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            GuildHomeSubFeedPart guildHomeSubFeedPart2 = this.this$0;
            IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            jumpGuildParam = this.this$0.jumpGuildParam;
            String str = jumpGuildParam.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            Bundle bundle = this.$extras;
            this.L$0 = coroutineScope;
            this.L$1 = guildHomeSubFeedPart2;
            this.label = 1;
            Object createNewSquareFragment = iGuildFeedLauncherApi.createNewSquareFragment(context, str, bundle, this);
            if (createNewSquareFragment == coroutine_suspended) {
                return coroutine_suspended;
            }
            guildHomeSubFeedPart = guildHomeSubFeedPart2;
            obj = createNewSquareFragment;
        }
        guildHomeSubFeedPart.fragment = (Fragment) obj;
        fragment = this.this$0.fragment;
        if (fragment == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onInitView fragment == null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.content.GuildHomeContentFeedPart", 1, (String) it.next(), null);
            }
            return Unit.INSTANCE;
        }
        if (CoroutineScopeKt.isActive(coroutineScope) && this.this$0.getHostFragment().isAdded()) {
            this.this$0.C9();
            FragmentTransaction beginTransaction = this.this$0.getHostFragment().getChildFragmentManager().beginTransaction();
            fragment2 = this.this$0.fragment;
            Intrinsics.checkNotNull(fragment2);
            beginTransaction.replace(R.id.wi5, fragment2).commitAllowingStateLoss();
            return Unit.INSTANCE;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("Fragment or hostFragment is not attached");
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("Guild.NewHome.content.GuildHomeContentFeedPart", 1, (String) it5.next(), null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeSubFeedPart$updateGuild$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
