package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.view.View;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class FeedTipPart$underReviewState$2 extends Lambda implements Function0<GuildQUIEmptyState> {
    final /* synthetic */ FeedTipPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTipPart$underReviewState$2(FeedTipPart feedTipPart) {
        super(0);
        this.this$0 = feedTipPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedTipPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GuildQUIEmptyState invoke() {
        String E9;
        GuildQUIEmptyState.a aVar = new GuildQUIEmptyState.a(this.this$0.getContext());
        final FeedTipPart feedTipPart = this.this$0;
        aVar.s(2);
        aVar.u("\u5e16\u5b50\u5ba1\u6838\u4e2d");
        aVar.q("\u5ba1\u67e5\u901a\u8fc7\u540e\u53ef\u67e5\u770b");
        E9 = feedTipPart.E9();
        aVar.p(E9, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedTipPart$underReviewState$2.b(FeedTipPart.this, view);
            }
        });
        aVar.n(true);
        GuildQUIEmptyState a16 = aVar.a();
        bt.d(a16.getButton(), "em_sgrp_already_delete", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
        return a16;
    }
}
