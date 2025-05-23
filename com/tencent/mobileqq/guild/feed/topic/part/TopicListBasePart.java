package com.tencent.mobileqq.guild.feed.topic.part;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicListBasePart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicBasePart;", "Lcom/tencent/mobileqq/guild/feed/topic/d;", tl.h.F, "Lkotlin/Lazy;", "D9", "()Lcom/tencent/mobileqq/guild/feed/topic/d;", "topicListSession", "Lcom/tencent/mobileqq/guild/feed/topic/c;", "i", "C9", "()Lcom/tencent/mobileqq/guild/feed/topic/c;", "topicListDepends", "Lcom/tencent/mobileqq/guild/feed/topic/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B9", "()Lcom/tencent/mobileqq/guild/feed/topic/b;", "topicGlobalDepends", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicListViewModel;", BdhLogUtil.LogTag.Tag_Conn, "E9", "()Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicListViewModel;", "topicListVM", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class TopicListBasePart extends TopicBasePart {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy topicListVM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topicListSession;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topicListDepends;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topicGlobalDepends;

    public TopicListBasePart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.feed.topic.d>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListBasePart$topicListSession$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.topic.d invoke() {
                Object iocInterface = PartIOCKt.getIocInterface(TopicListBasePart.this, com.tencent.mobileqq.guild.feed.topic.d.class);
                Intrinsics.checkNotNull(iocInterface);
                return (com.tencent.mobileqq.guild.feed.topic.d) iocInterface;
            }
        });
        this.topicListSession = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.feed.topic.c>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListBasePart$topicListDepends$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.topic.c invoke() {
                Object iocInterface = PartIOCKt.getIocInterface(TopicListBasePart.this, com.tencent.mobileqq.guild.feed.topic.c.class);
                Intrinsics.checkNotNull(iocInterface);
                return (com.tencent.mobileqq.guild.feed.topic.c) iocInterface;
            }
        });
        this.topicListDepends = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.feed.topic.b>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListBasePart$topicGlobalDepends$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.topic.b invoke() {
                Object iocInterface = PartIOCKt.getIocInterface(TopicListBasePart.this, com.tencent.mobileqq.guild.feed.topic.b.class);
                Intrinsics.checkNotNull(iocInterface);
                return (com.tencent.mobileqq.guild.feed.topic.b) iocInterface;
            }
        });
        this.topicGlobalDepends = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TopicListViewModel>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListBasePart$topicListVM$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f223676a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ TopicListBasePart f223677b;

                public a(ViewModelStoreOwner viewModelStoreOwner, TopicListBasePart topicListBasePart) {
                    this.f223676a = viewModelStoreOwner;
                    this.f223677b = topicListBasePart;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new TopicListViewModel(this.f223677b.D9()), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TopicListViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                IPartHost partHost = TopicListBasePart.this.getPartHost();
                Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
                ViewModel viewModel = new ViewModelProvider(partHost, new a(partHost, TopicListBasePart.this)).get(TopicListViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (TopicListViewModel) viewModel;
            }
        });
        this.topicListVM = lazy4;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.topic.b B9() {
        return (com.tencent.mobileqq.guild.feed.topic.b) this.topicGlobalDepends.getValue();
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.topic.c C9() {
        return (com.tencent.mobileqq.guild.feed.topic.c) this.topicListDepends.getValue();
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.topic.d D9() {
        return (com.tencent.mobileqq.guild.feed.topic.d) this.topicListSession.getValue();
    }

    @NotNull
    public final TopicListViewModel E9() {
        return (TopicListViewModel) this.topicListVM.getValue();
    }
}
