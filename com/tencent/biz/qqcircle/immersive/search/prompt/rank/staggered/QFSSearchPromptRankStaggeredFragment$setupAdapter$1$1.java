package com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered;

import com.qzone.module.feedcomponent.manage.FeedManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class QFSSearchPromptRankStaggeredFragment$setupAdapter$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QFSSearchPromptRankStaggeredFragment$setupAdapter$1$1(Object obj) {
        super(0, obj, QFSSearchPromptRankStaggeredFragment.class, FeedManager.LOAD_MORE, "loadMore()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((QFSSearchPromptRankStaggeredFragment) this.receiver).Bh();
    }
}
