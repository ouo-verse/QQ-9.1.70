package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bk1.a;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedOperateData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.richframework.data.base.UIStateData;
import ij1.GuildFeedsHeaderData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareInviteAdapterWorker;", "Lbk1/a$a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/c;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "k", "Lvi1/e;", "listUIOperationApi", "", tl.h.F, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSquareInviteAdapterWorker extends a.AbstractC0131a<com.tencent.mobileqq.guild.feed.feedsquare.adapter.c, Object> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
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
            final Function1<UIStateData<GuildFeedsHeaderData>, Unit> function1 = new Function1<UIStateData<GuildFeedsHeaderData>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareInviteAdapterWorker$work$1
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
                    List<GuildFeedOperateData> emptyList;
                    List<GuildFeedOperateData> mutableListOf;
                    if (uIStateData.getData().getInviteFriend()) {
                        com.tencent.mobileqq.guild.feed.feedsquare.adapter.c b16 = FeedSquareInviteAdapterWorker.this.b();
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GuildFeedOperateData(GuildFeedOperateData.Operate.INIT));
                        b16.setItems(mutableListOf);
                    } else {
                        com.tencent.mobileqq.guild.feed.feedsquare.adapter.c b17 = FeedSquareInviteAdapterWorker.this.b();
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        b17.setItems(emptyList);
                    }
                }
            };
            X.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeedSquareInviteAdapterWorker.l(Function1.this, obj);
                }
            });
        }
        MutableLiveData<UIStateData<List<ij1.g>>> j3 = d().getVmApi().j();
        LifecycleOwner lifecycleOwner2 = d().getLifecycleOwner();
        final Function1<UIStateData<List<ij1.g>>, Unit> function12 = new Function1<UIStateData<List<ij1.g>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareInviteAdapterWorker$work$2
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
                List<GuildFeedOperateData> emptyList;
                if (uIStateData.getState() == 8) {
                    List<ij1.g> data = uIStateData.getData();
                    Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
                    List<ij1.g> list = data;
                    boolean z16 = false;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (new com.tencent.mobileqq.guild.feed.feedsquare.data.h((ij1.g) it.next()).b() != 19) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    if (z16) {
                        com.tencent.mobileqq.guild.feed.feedsquare.adapter.c b16 = FeedSquareInviteAdapterWorker.this.b();
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        b16.setItems(emptyList);
                    }
                }
            }
        };
        j3.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSquareInviteAdapterWorker.m(Function1.this, obj);
            }
        });
    }

    @Override // bk1.a.AbstractC0131a
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.guild.feed.feedsquare.adapter.c f(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(config, "config");
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.c cVar = new com.tencent.mobileqq.guild.feed.feedsquare.adapter.c();
        cVar.setHasStableIds(true);
        return cVar;
    }
}
