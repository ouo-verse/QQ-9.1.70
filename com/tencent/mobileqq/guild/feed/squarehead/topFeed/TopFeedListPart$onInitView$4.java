package com.tencent.mobileqq.guild.feed.squarehead.topFeed;

import com.tencent.richframework.data.base.UIStateData;
import ij1.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class TopFeedListPart$onInitView$4 extends FunctionReferenceImpl implements Function1<UIStateData<List<h>>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TopFeedListPart$onInitView$4(Object obj) {
        super(1, obj, TopFeedListPart.class, "handleTopFeedUiStatus", "handleTopFeedUiStatus(Lcom/tencent/richframework/data/base/UIStateData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<h>> uIStateData) {
        invoke2(uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull UIStateData<List<h>> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((TopFeedListPart) this.receiver).K9(p06);
    }
}
