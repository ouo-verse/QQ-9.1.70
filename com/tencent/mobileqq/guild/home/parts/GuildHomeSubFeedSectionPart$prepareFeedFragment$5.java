package com.tencent.mobileqq.guild.home.parts;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import defpackage.FeedSectionTabLaunchParam;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.home.parts.GuildHomeSubFeedSectionPart$prepareFeedFragment$5", f = "GuildHomeSubFeedSectionPart.kt", i = {0}, l = {96}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildHomeSubFeedSectionPart$prepareFeedFragment$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedSectionTabLaunchParam $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GuildHomeSubFeedSectionPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeSubFeedSectionPart$prepareFeedFragment$5(GuildHomeSubFeedSectionPart guildHomeSubFeedSectionPart, FeedSectionTabLaunchParam feedSectionTabLaunchParam, Continuation<? super GuildHomeSubFeedSectionPart$prepareFeedFragment$5> continuation) {
        super(2, continuation);
        this.this$0 = guildHomeSubFeedSectionPart;
        this.$params = feedSectionTabLaunchParam;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildHomeSubFeedSectionPart$prepareFeedFragment$5 guildHomeSubFeedSectionPart$prepareFeedFragment$5 = new GuildHomeSubFeedSectionPart$prepareFeedFragment$5(this.this$0, this.$params, continuation);
        guildHomeSubFeedSectionPart$prepareFeedFragment$5.L$0 = obj;
        return guildHomeSubFeedSectionPart$prepareFeedFragment$5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        GuildHomeSubFeedSectionPart guildHomeSubFeedSectionPart;
        Fragment fragment;
        Fragment fragment2;
        Fragment fragment3;
        Bundle arguments;
        IPerformanceReportTask iPerformanceReportTask;
        Bundle arguments2;
        IPerformanceReportTask iPerformanceReportTask2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                guildHomeSubFeedSectionPart = (GuildHomeSubFeedSectionPart) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            GuildHomeSubFeedSectionPart guildHomeSubFeedSectionPart2 = this.this$0;
            IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FeedSectionTabLaunchParam feedSectionTabLaunchParam = this.$params;
            this.L$0 = coroutineScope;
            this.L$1 = guildHomeSubFeedSectionPart2;
            this.label = 1;
            Object createFeedSectionFragment = iGuildFeedLauncherApi.createFeedSectionFragment(context, feedSectionTabLaunchParam, this);
            if (createFeedSectionFragment == coroutine_suspended) {
                return coroutine_suspended;
            }
            guildHomeSubFeedSectionPart = guildHomeSubFeedSectionPart2;
            obj = createFeedSectionFragment;
        }
        guildHomeSubFeedSectionPart.fragment = (Fragment) obj;
        fragment = this.this$0.fragment;
        if (fragment != null && (arguments2 = fragment.getArguments()) != null) {
            iPerformanceReportTask2 = this.this$0.reportTask;
            qw1.b.u(arguments2, iPerformanceReportTask2, null, 2, null);
        }
        fragment2 = this.this$0.fragment;
        if (fragment2 != null && (arguments = fragment2.getArguments()) != null) {
            iPerformanceReportTask = this.this$0.loadTabTimeCostReportTask;
            qw1.b.t(arguments, iPerformanceReportTask, "_extra_param_report_task_view_pager_tab");
        }
        Object partHost = this.this$0.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment fragment4 = (Fragment) partHost;
        if (CoroutineScopeKt.isActive(coroutineScope) && fragment4.isAdded()) {
            FragmentTransaction beginTransaction = fragment4.getChildFragmentManager().beginTransaction();
            fragment3 = this.this$0.fragment;
            Intrinsics.checkNotNull(fragment3);
            beginTransaction.replace(R.id.wi5, fragment3).commitAllowingStateLoss();
            return Unit.INSTANCE;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("Fragment or hostFragment is not attached");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.NewHome.content.GuildHomeContentFeedPart", 1, (String) it.next(), null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeSubFeedSectionPart$prepareFeedFragment$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
