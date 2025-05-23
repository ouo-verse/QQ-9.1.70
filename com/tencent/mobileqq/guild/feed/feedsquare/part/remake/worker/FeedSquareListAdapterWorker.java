package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bk1.a;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareListAdapter;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareListAdapterWorker;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultFeedListAdapterWorker;", "Lvi1/e;", "listUIOperationApi", "", tl.h.F, "Lbk1/a$b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "", "c", "", "prefixLogTag", "<init>", "(Ljava/lang/String;)V", "j", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSquareListAdapterWorker extends DefaultFeedListAdapterWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSquareListAdapterWorker(@NotNull String prefixLogTag) {
        super(prefixLogTag);
        Intrinsics.checkNotNullParameter(prefixLogTag, "prefixLogTag");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListAdapterWorker, bk1.a.AbstractC0131a
    @NotNull
    public a.b<GuildFeedSquareListAdapter, Object> c() {
        return new FeedSquareListWorkerDelegate();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListAdapterWorker, bk1.a.AbstractC0131a
    public void h(@NotNull vi1.e listUIOperationApi) {
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        super.h(listUIOperationApi);
        MutableLiveData<UIStateData<List<ij1.g>>> j3 = d().getVmApi().j();
        LifecycleOwner lifecycleOwner = d().getLifecycleOwner();
        final Function1<UIStateData<List<ij1.g>>, Unit> function1 = new Function1<UIStateData<List<ij1.g>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListAdapterWorker$work$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<ij1.g>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<ij1.g>> uIStateData) {
                int state = uIStateData.getState();
                if ((state == 0 || state == 3) && !uIStateData.getIsLoadMore()) {
                    com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(FeedSquareListAdapterWorker.this.d().getVmApi()).o().setValue(Boolean.FALSE);
                    Logger.f235387a.d().i("FeedSquareListAdapterWorker", 1, "onUiStateDataObserve hiddenNavBar state:" + uIStateData.getState());
                }
            }
        };
        j3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSquareListAdapterWorker.K(Function1.this, obj);
            }
        });
    }
}
