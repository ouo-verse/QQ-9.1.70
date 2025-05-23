package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import com.tencent.richframework.data.base.UIStateData;
import ij1.GuildFeedsHeaderData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class GuildFeedSquareNoticeViewModel$init$1 extends FunctionReferenceImpl implements Function1<UIStateData<GuildFeedsHeaderData>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedSquareNoticeViewModel$init$1(Object obj) {
        super(1, obj, GuildFeedSquareNoticeViewModel.class, "updateNoticeBubbleFromHeaderData", "updateNoticeBubbleFromHeaderData(Lcom/tencent/richframework/data/base/UIStateData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<GuildFeedsHeaderData> uIStateData) {
        invoke2(uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull UIStateData<GuildFeedsHeaderData> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildFeedSquareNoticeViewModel) this.receiver).d2(p06);
    }
}
