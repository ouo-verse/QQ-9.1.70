package com.tencent.mobileqq.guild.feed.topic.part;

import android.content.ComponentCallbacks2;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel;
import com.tencent.mobileqq.guild.util.Logger;
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

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicBasePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/feed/topic/e;", "d", "Lkotlin/Lazy;", "z9", "()Lcom/tencent/mobileqq/guild/feed/topic/e;", "topicSession", "Lcom/tencent/mobileqq/guild/feed/topic/a;", "e", "x9", "()Lcom/tencent/mobileqq/guild/feed/topic/a;", "topicDepends", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicViewModel;", "f", "A9", "()Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicViewModel;", "topicVM", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class TopicBasePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topicSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topicDepends;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy topicVM;

    public TopicBasePart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.feed.topic.e>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicBasePart$topicSession$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.topic.e invoke() {
                Object iocInterface = PartIOCKt.getIocInterface(TopicBasePart.this, com.tencent.mobileqq.guild.feed.topic.e.class);
                Intrinsics.checkNotNull(iocInterface);
                return (com.tencent.mobileqq.guild.feed.topic.e) iocInterface;
            }
        });
        this.topicSession = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.feed.topic.a>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicBasePart$topicDepends$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.topic.a invoke() {
                Object iocInterface = PartIOCKt.getIocInterface(TopicBasePart.this, com.tencent.mobileqq.guild.feed.topic.a.class);
                Intrinsics.checkNotNull(iocInterface);
                return (com.tencent.mobileqq.guild.feed.topic.a) iocInterface;
            }
        });
        this.topicDepends = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TopicViewModel>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicBasePart$topicVM$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f223670a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ TopicBasePart f223671b;

                public a(ViewModelStoreOwner viewModelStoreOwner, TopicBasePart topicBasePart) {
                    this.f223670a = viewModelStoreOwner;
                    this.f223671b = topicBasePart;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new TopicViewModel(this.f223671b.z9()), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
            public final TopicViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                ComponentCallbacks2 activity = TopicBasePart.this.getActivity();
                ViewModelStoreOwner viewModelStoreOwner = activity instanceof ViewModelStoreOwner ? (ViewModelStoreOwner) activity : null;
                if (viewModelStoreOwner == null) {
                    viewModelStoreOwner = TopicBasePart.this.getPartHost();
                }
                Intrinsics.checkNotNullExpressionValue(viewModelStoreOwner, "activity as? ViewModelStoreOwner ?: partHost");
                ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, new a(viewModelStoreOwner, TopicBasePart.this)).get(TopicBasePart.this.z9().toString(), TopicViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026).get(key, T::class.java)");
                return (TopicViewModel) viewModel;
            }
        });
        this.topicVM = lazy3;
    }

    @NotNull
    public final TopicViewModel A9() {
        return (TopicViewModel) this.topicVM.getValue();
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.topic.a x9() {
        return (com.tencent.mobileqq.guild.feed.topic.a) this.topicDepends.getValue();
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.topic.e z9() {
        return (com.tencent.mobileqq.guild.feed.topic.e) this.topicSession.getValue();
    }
}
