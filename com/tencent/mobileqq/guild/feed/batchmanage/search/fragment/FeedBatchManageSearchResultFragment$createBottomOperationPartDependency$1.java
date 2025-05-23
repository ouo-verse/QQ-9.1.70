package com.tencent.mobileqq.guild.feed.batchmanage.search.fragment;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart;
import com.tencent.mobileqq.guild.feed.batchmanage.search.event.FeedBatchManageSearchResultFragmentEvent;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchViewModel;
import do1.a;
import java.io.Serializable;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR5\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00100\u000f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/fragment/FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart$a;", "", "channelId", "", "a", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "operationType", "", "d", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchViewModel;", "kotlin.jvm.PlatformType", "b", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchViewModel;", "viewModel", "Landroidx/lifecycle/MutableLiveData;", "Ldo1/a;", "", "c", "Lkotlin/Lazy;", "g", "()Landroidx/lifecycle/MutableLiveData;", "feedCollectionViewState", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1 extends GuildFeedBatchManageBottomOperationPart.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FeedBatchManageSearchViewModel viewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedCollectionViewState;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FeedBatchManageSearchResultFragment f218236d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1(FeedBatchManageSearchResultFragment feedBatchManageSearchResultFragment) {
        Lazy lazy;
        this.f218236d = feedBatchManageSearchResultFragment;
        this.viewModel = (FeedBatchManageSearchViewModel) feedBatchManageSearchResultFragment.getViewModel(FeedBatchManageSearchViewModel.class);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<MutableLiveData<a<? extends Collection<?>, Integer>>>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.fragment.FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<a<? extends Collection<?>, Integer>> invoke() {
                FeedBatchManageSearchViewModel feedBatchManageSearchViewModel;
                FeedBatchManageSearchViewModel viewModel;
                MutableLiveData<a<? extends Collection<?>, Integer>> mutableLiveData = new MutableLiveData<>();
                FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1 feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1 = FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1.this;
                feedBatchManageSearchViewModel = feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1.viewModel;
                Flow onEach = FlowKt.onEach(feedBatchManageSearchViewModel.X1(), new FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1(feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1, mutableLiveData, null));
                viewModel = feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1.viewModel;
                Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
                FlowKt.launchIn(onEach, ViewModelKt.getViewModelScope(viewModel));
                return mutableLiveData;
            }
        });
        this.feedCollectionViewState = lazy;
    }

    @Override // com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart.a
    @Nullable
    public Object a(long j3, @NotNull Continuation<? super Integer> continuation) {
        return null;
    }

    @Override // com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart.a
    public void d(int operationType) {
        Serializable serializable;
        int i3;
        this.f218236d.hasDispatchResult = true;
        Bundle arguments = this.f218236d.getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("source");
        } else {
            serializable = null;
        }
        if (!Intrinsics.areEqual(serializable, "source_from_feed_square")) {
            this.f218236d.yh();
        } else {
            Activity hostActivity = this.f218236d.getHostActivity();
            if (hostActivity != null) {
                hostActivity.finish();
            }
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Bundle arguments2 = this.f218236d.getArguments();
        if (arguments2 != null) {
            i3 = arguments2.getInt("source_page_hashcode");
        } else {
            i3 = 0;
        }
        simpleEventBus.dispatchEvent(new FeedBatchManageSearchResultFragmentEvent(i3, -1, operationType));
    }

    @Override // com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart.a
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public MutableLiveData<a<? extends Collection<?>, Integer>> b() {
        return (MutableLiveData) this.feedCollectionViewState.getValue();
    }
}
