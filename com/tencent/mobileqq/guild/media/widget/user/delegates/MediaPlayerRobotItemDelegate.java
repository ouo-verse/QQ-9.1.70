package com.tencent.mobileqq.guild.media.widget.user.delegates;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.widget.holder.GuildRobotFaceViewHolder;
import com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt1.MediaPlayerRobotUserItem;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0014H\u0014R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaPlayerRobotItemDelegate;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate;", "Lrt1/g;", "Lcom/tencent/mobileqq/guild/media/widget/holder/GuildRobotFaceViewHolder;", "Lrt1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "r", "holder", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", h.F, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "e", "Ljava/lang/ref/WeakReference;", "weakAdapterRef", "adapter", "<init>", "(Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaPlayerRobotItemDelegate extends BaseMediaItemDelegate<MediaPlayerRobotUserItem, GuildRobotFaceViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<BaseMediaUserDelegateAdapter> weakAdapterRef;

    public MediaPlayerRobotItemDelegate(@NotNull BaseMediaUserDelegateAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.weakAdapterRef = new WeakReference<>(adapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        GuildRobotFaceViewHolder guildRobotFaceViewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.g(holder);
        if (holder instanceof GuildRobotFaceViewHolder) {
            guildRobotFaceViewHolder = (GuildRobotFaceViewHolder) holder;
        } else {
            guildRobotFaceViewHolder = null;
        }
        if (guildRobotFaceViewHolder != null) {
            guildRobotFaceViewHolder.onViewAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        GuildRobotFaceViewHolder guildRobotFaceViewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        if (holder instanceof GuildRobotFaceViewHolder) {
            guildRobotFaceViewHolder = (GuildRobotFaceViewHolder) holder;
        } else {
            guildRobotFaceViewHolder = null;
        }
        if (guildRobotFaceViewHolder != null) {
            guildRobotFaceViewHolder.resetStatusAndAnim();
            guildRobotFaceViewHolder.onViewDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull rt1.a item, @NotNull List<rt1.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MediaPlayerRobotUserItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull MediaPlayerRobotUserItem item, @NotNull GuildRobotFaceViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        w.c("MediaPlayerRobotItemDelegate_onBindViewHolder");
        BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter = this.weakAdapterRef.get();
        if (baseMediaUserDelegateAdapter != null) {
            holder.bindColumn(baseMediaUserDelegateAdapter.r0());
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "holder.itemView.layoutParams");
            int l06 = baseMediaUserDelegateAdapter.l0();
            if (baseMediaUserDelegateAdapter.r0() == 1) {
                layoutParams.width = -1;
                layoutParams.height = l06;
                holder.itemView.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = l06;
                layoutParams.height = l06;
                holder.itemView.setLayoutParams(layoutParams);
            }
            String str = item.getUserInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "item.userInfo.id");
            holder.bindData(item.getUserInfo(), baseMediaUserDelegateAdapter.o0(Long.parseLong(str)), j.a().getChannelInfo(), j.a().getGuildInfo(), j.c().getSelfUserInfo());
            holder.itemView.setTag(item.getUserInfo());
        }
        w.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public GuildRobotFaceViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new GuildRobotFaceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.egg, parent, false));
    }
}
