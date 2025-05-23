package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bk1.a;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.richframework.data.base.UIStateData;
import ij1.GuildFeedsHeaderData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareHeaderAdapterWorker;", "Lbk1/a$a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/i;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "j", "Lvi1/e;", "listUIOperationApi", "", tl.h.F, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSquareHeaderAdapterWorker extends a.AbstractC0131a<com.tencent.mobileqq.guild.feed.feedsquare.adapter.i, Object> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // bk1.a.AbstractC0131a
    public void h(@NotNull vi1.e listUIOperationApi) {
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        super.h(listUIOperationApi);
        MutableLiveData<UIStateData<GuildFeedsHeaderData>> X = d().getVmApi().X();
        if (X != null) {
            LifecycleOwner lifecycleOwner = d().getLifecycleOwner();
            final Function1<UIStateData<GuildFeedsHeaderData>, Unit> function1 = new Function1<UIStateData<GuildFeedsHeaderData>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareHeaderAdapterWorker$work$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<GuildFeedsHeaderData> uIStateData) {
                    invoke2(uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<GuildFeedsHeaderData> uIStateData) {
                    com.tencent.mobileqq.guild.feed.feedsquare.adapter.i b16 = FeedSquareHeaderAdapterWorker.this.b();
                    MutableLiveData<UIStateData<GuildFeedsHeaderData>> X2 = FeedSquareHeaderAdapterWorker.this.d().getVmApi().X();
                    Intrinsics.checkNotNull(X2);
                    b16.l0(X2);
                }
            };
            X.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeedSquareHeaderAdapterWorker.k(Function1.this, obj);
                }
            });
        }
    }

    @Override // bk1.a.AbstractC0131a
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.guild.feed.feedsquare.adapter.i f(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(config, "config");
        FragmentManager childFragmentManager = d().getFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "context.fragment.childFragmentManager");
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.i iVar = new com.tencent.mobileqq.guild.feed.feedsquare.adapter.i(childFragmentManager, d().getFragment().getArguments());
        iVar.setHasStableIds(true);
        return iVar;
    }
}
