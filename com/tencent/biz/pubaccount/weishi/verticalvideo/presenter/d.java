package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/d;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/presenter/WSVerticalForCLinkPresenter;", "", "isRefresh", "isFirst", "", "from", "y0", "", "k2", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;", "view", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d extends WSVerticalForCLinkPresenter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.tencent.biz.pubaccount.weishi.verticalvideo.h view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(d this$0, boolean z16, boolean z17, com.tencent.biz.pubaccount.weishi.verticalvideo.h view) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.k kVar = new com.tencent.biz.pubaccount.weishi.verticalvideo.data.k(this$0.k2(), z16, z17);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(view.getIntentFeedId());
        WSVerticalDataManager.j().g(kVar.k(arrayListOf), this$0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForCLinkPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter
    protected int k2() {
        return 15;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForCLinkPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(final boolean isRefresh, final boolean isFirst, String from) {
        final com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.c
            @Override // java.lang.Runnable
            public final void run() {
                d.q2(d.this, isRefresh, isFirst, O0);
            }
        }, 128, null, true);
        return true;
    }
}
