package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesUserRankingOuterClass$UserRanking;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001a\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00040\u00040\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserViewHolder;", "", "Ltrpc/yes/common/YesUserRankingOuterClass$UserRanking;", "list", "", "submitList", "Lkotlin/Function1;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "cb", "l0", "Landroid/view/ViewGroup;", "p0", "", "p1", "k0", "j0", "getItemCount", "com/tencent/timi/game/expand/hall/impl/view/OnlineUserAdapter$a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserAdapter$a;", "diffCallback", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/AsyncListDiffer;", "diff", "D", "Lkotlin/jvm/functions/Function1;", "userClickCb", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class OnlineUserAdapter extends RecyclerView.Adapter<OnlineUserViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AsyncListDiffer<YesUserRankingOuterClass$UserRanking> diff;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<? super CommonOuterClass$QQUserId, Unit> userClickCb;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a diffCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/OnlineUserAdapter$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Ltrpc/yes/common/YesUserRankingOuterClass$UserRanking;", "p0", "p1", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends DiffUtil.ItemCallback<YesUserRankingOuterClass$UserRanking> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull YesUserRankingOuterClass$UserRanking p06, @NotNull YesUserRankingOuterClass$UserRanking p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            if (p06.UInfo.uid.get() == p16.UInfo.uid.get() && p06.RIdx.get() == p16.RIdx.get() && Intrinsics.areEqual(p06.Score.get(), p16.Score.get())) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull YesUserRankingOuterClass$UserRanking p06, @NotNull YesUserRankingOuterClass$UserRanking p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return true;
        }
    }

    public OnlineUserAdapter() {
        a aVar = new a();
        this.diffCallback = aVar;
        this.diff = new AsyncListDiffer<>(this, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.diff.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull OnlineUserViewHolder p06, int p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        YesUserRankingOuterClass$UserRanking yesUserRankingOuterClass$UserRanking = this.diff.getCurrentList().get(p16);
        if (yesUserRankingOuterClass$UserRanking != null) {
            p06.m(yesUserRankingOuterClass$UserRanking, p16, new Function1<CommonOuterClass$QQUserId, Unit>() { // from class: com.tencent.timi.game.expand.hall.impl.view.OnlineUserAdapter$onBindViewHolder$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Function1 function1;
                    Intrinsics.checkNotNullParameter(it, "it");
                    function1 = OnlineUserAdapter.this.userClickCb;
                    if (function1 != null) {
                        function1.invoke(it);
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public OnlineUserViewHolder onCreateViewHolder(@NotNull ViewGroup p06, int p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Context context = p06.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "p0.context");
        OnlineUserItemView onlineUserItemView = new OnlineUserItemView(context, null, 0, 6, null);
        onlineUserItemView.setLayoutParams(new RecyclerView.LayoutParams(-1, fh4.b.b(64)));
        return new OnlineUserViewHolder(onlineUserItemView);
    }

    public final void l0(@NotNull Function1<? super CommonOuterClass$QQUserId, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.userClickCb = cb5;
    }

    public final void submitList(@NotNull List<YesUserRankingOuterClass$UserRanking> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.diff.submitList(list);
    }
}
