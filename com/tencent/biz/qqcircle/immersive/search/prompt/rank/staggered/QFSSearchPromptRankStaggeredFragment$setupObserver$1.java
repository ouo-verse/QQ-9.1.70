package com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered;

import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankDataModel;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/a;", "Lfeedcloud/FeedCloudMeta$StFeed;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankStaggeredFragment$setupObserver$1 extends Lambda implements Function1<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>, Unit> {
    final /* synthetic */ QFSSearchPromptRankStaggeredFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSearchPromptRankStaggeredFragment$setupObserver$1(QFSSearchPromptRankStaggeredFragment qFSSearchPromptRankStaggeredFragment) {
        super(1);
        this.this$0 = qFSSearchPromptRankStaggeredFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QFSSearchPromptRankStaggeredFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        recyclerView = this$0.recyclerView;
        this$0.Dh(recyclerView);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed> qFSSearchPromptRankDataModel) {
        invoke2(qFSSearchPromptRankDataModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed> qFSSearchPromptRankDataModel) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        QLog.d(this.this$0.getTAG(), 1, "[initChanged] success=" + qFSSearchPromptRankDataModel.getIsSuccess() + ", hasMore=" + qFSSearchPromptRankDataModel.getHasMore() + ", size=" + qFSSearchPromptRankDataModel.b().size());
        if (!qFSSearchPromptRankDataModel.getIsSuccess()) {
            eVar = this.this$0.staggeredAdapter;
            eVar.onLoadMoreCompleted(false, true);
            return;
        }
        if (qFSSearchPromptRankDataModel.b().isEmpty()) {
            eVar4 = this.this$0.staggeredAdapter;
            eVar4.onLoadMoreCompleted(true, true);
            return;
        }
        eVar2 = this.this$0.staggeredAdapter;
        eVar2.onLoadMoreCompleted(true, !qFSSearchPromptRankDataModel.getHasMore(), false);
        eVar3 = this.this$0.staggeredAdapter;
        eVar3.setDatas(qFSSearchPromptRankDataModel.b());
        Handler mainHandler = this.this$0.getMainHandler();
        final QFSSearchPromptRankStaggeredFragment qFSSearchPromptRankStaggeredFragment = this.this$0;
        mainHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.d
            @Override // java.lang.Runnable
            public final void run() {
                QFSSearchPromptRankStaggeredFragment$setupObserver$1.b(QFSSearchPromptRankStaggeredFragment.this);
            }
        });
    }
}
