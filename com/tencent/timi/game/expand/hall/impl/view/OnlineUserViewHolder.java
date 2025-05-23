package com.tencent.timi.game.expand.hall.impl.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesUserRankingOuterClass$UserRanking;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J*\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ltrpc/yes/common/YesUserRankingOuterClass$UserRanking;", "userRanking", "", com.tencent.luggage.wxa.c8.c.G, "Lkotlin/Function1;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserItemView;", "E", "Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserItemView;", "view", "<init>", "(Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserItemView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class OnlineUserViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final OnlineUserItemView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineUserViewHolder(@NotNull OnlineUserItemView view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 cb5, YesUserRankingOuterClass$UserRanking userRanking, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(userRanking, "$userRanking");
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = userRanking.UInfo.get();
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "userRanking.UInfo.get()");
        cb5.invoke(commonOuterClass$QQUserId);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void m(@NotNull final YesUserRankingOuterClass$UserRanking userRanking, int pos, @NotNull final Function1<? super CommonOuterClass$QQUserId, Unit> cb5) {
        Intrinsics.checkNotNullParameter(userRanking, "userRanking");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.view.g(userRanking, pos, new Function1<CommonOuterClass$QQUserId, Unit>() { // from class: com.tencent.timi.game.expand.hall.impl.view.OnlineUserViewHolder$bindView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
                invoke2(commonOuterClass$QQUserId);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CommonOuterClass$QQUserId it) {
                Intrinsics.checkNotNullParameter(it, "it");
                cb5.invoke(it);
            }
        });
        this.view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineUserViewHolder.n(Function1.this, userRanking, view);
            }
        });
    }
}
