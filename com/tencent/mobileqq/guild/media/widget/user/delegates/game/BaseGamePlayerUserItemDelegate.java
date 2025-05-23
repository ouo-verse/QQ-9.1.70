package com.tencent.mobileqq.guild.media.widget.user.delegates.game;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.game.memberlist.MemberRvBaseItemViewHolder;
import com.tencent.mobileqq.guild.media.widget.user.a;
import com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseMediaItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.game.BaseGamePlayerUserItemDelegate;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt1.GameNormalItem;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u000bH\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u000bH\u0014R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/game/BaseGamePlayerUserItemDelegate;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate;", "Lrt1/b;", "Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "", "payloads", "", "r", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", h.F, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "e", "Ljava/lang/ref/WeakReference;", "weakAdapterRef", "adapter", "<init>", "(Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class BaseGamePlayerUserItemDelegate extends BaseMediaItemDelegate<GameNormalItem, MemberRvBaseItemViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<BaseMediaUserDelegateAdapter> weakAdapterRef;

    public BaseGamePlayerUserItemDelegate(@NotNull BaseMediaUserDelegateAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.weakAdapterRef = new WeakReference<>(adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(GameNormalItem item, MemberRvBaseItemViewHolder holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (item.getUserInfo().f228098f == 0) {
            a.f229990a.d(holder.itemView, item.getUserInfo());
        } else {
            a.f229990a.c(holder.itemView, item.getUserInfo());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(View view) {
        a.f229990a.a(view);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.g(holder);
        if (holder instanceof MemberRvBaseItemViewHolder) {
            ((MemberRvBaseItemViewHolder) holder).onViewAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        if (holder instanceof MemberRvBaseItemViewHolder) {
            ((MemberRvBaseItemViewHolder) holder).onViewDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull final GameNormalItem item, @NotNull final MemberRvBaseItemViewHolder holder, @NotNull List<Object> payloads) {
        int i3;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        w.c("GamePlayerUserItemDelegate_onBindViewHolder");
        super.o(item, holder, payloads);
        BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter = this.weakAdapterRef.get();
        if (baseMediaUserDelegateAdapter != null) {
            int r06 = baseMediaUserDelegateAdapter.r0();
            holder.bindColumn(r06);
            int l06 = baseMediaUserDelegateAdapter.l0();
            if (AppSetting.t(holder.itemView.getContext())) {
                i3 = ViewUtils.dpToPx(200.0f);
            } else {
                i3 = l06;
            }
            if (r06 == 1) {
                layoutParams = new ViewGroup.LayoutParams(-1, i3);
            } else {
                layoutParams = new ViewGroup.LayoutParams(l06, i3);
            }
            holder.itemView.setLayoutParams(layoutParams);
        }
        holder.bindData(item.getUserInfo(), j.c().getSelfUserInfo());
        holder.itemView.setTag(item.getUserInfo());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: qt1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseGamePlayerUserItemDelegate.s(GameNormalItem.this, holder, view);
            }
        });
        if (!com.tencent.util.AppSetting.isPublicVersion()) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: qt1.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean t16;
                    t16 = BaseGamePlayerUserItemDelegate.t(view);
                    return t16;
                }
            });
        }
        w.d();
    }
}
