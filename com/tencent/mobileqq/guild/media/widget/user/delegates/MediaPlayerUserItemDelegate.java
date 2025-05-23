package com.tencent.mobileqq.guild.media.widget.user.delegates;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.widget.audiofaceview.ColumnLayout;
import com.tencent.mobileqq.guild.media.widget.audiofaceview.FaceViewHolder;
import com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt1.MediaPlayerUserItem;
import tl.h;
import vs1.e;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0014H\u0014R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaPlayerUserItemDelegate;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate;", "Lrt1/h;", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/FaceViewHolder;", "Lrt1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "t", "holder", "", "payloads", "", "r", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", h.F, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "e", "Ljava/lang/ref/WeakReference;", "weakAdapterRef", "adapter", "<init>", "(Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaPlayerUserItemDelegate extends BaseMediaItemDelegate<MediaPlayerUserItem, FaceViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<BaseMediaUserDelegateAdapter> weakAdapterRef;

    public MediaPlayerUserItemDelegate(@NotNull BaseMediaUserDelegateAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.weakAdapterRef = new WeakReference<>(adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MediaPlayerUserItem item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        com.tencent.mobileqq.guild.media.widget.user.a.f229990a.d(view, item.getUserInfo());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.g(holder);
        if (holder instanceof FaceViewHolder) {
            ((FaceViewHolder) holder).onViewAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        FaceViewHolder faceViewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        boolean z16 = holder instanceof FaceViewHolder;
        if (z16) {
            faceViewHolder = (FaceViewHolder) holder;
        } else {
            faceViewHolder = null;
        }
        if (faceViewHolder != null) {
            faceViewHolder.resetStatusAndAnim();
        }
        if (z16) {
            ((FaceViewHolder) holder).onViewDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull rt1.a item, @NotNull List<rt1.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MediaPlayerUserItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull final MediaPlayerUserItem item, @NotNull FaceViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        w.c("MediaPlayerUserItemDelegate_onBindViewHolder");
        BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter = this.weakAdapterRef.get();
        if (baseMediaUserDelegateAdapter != null) {
            int r06 = baseMediaUserDelegateAdapter.r0();
            holder.bindColumn(r06);
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "holder.itemView.layoutParams");
            int l06 = baseMediaUserDelegateAdapter.l0();
            if (r06 == 1) {
                layoutParams.width = -1;
                layoutParams.height = l06;
                holder.itemView.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = l06;
                layoutParams.height = l06;
                holder.itemView.setLayoutParams(layoutParams);
            }
        }
        holder.bindData(item.getUserInfo(), j.c().getSelfUserInfo());
        holder.itemView.setTag(item.getUserInfo());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.user.delegates.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaPlayerUserItemDelegate.s(MediaPlayerUserItem.this, view);
            }
        });
        w.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public FaceViewHolder d(@NotNull ViewGroup parent) {
        int i3;
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPoolEngine viewPoolEngine = ViewPoolEngine.f228744a;
        e.a aVar = e.a.f443289a;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        View i16 = viewPoolEngine.i(aVar, context);
        Intrinsics.checkNotNull(i16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.audiofaceview.ColumnLayout");
        FaceViewHolder faceViewHolder = new FaceViewHolder((ColumnLayout) i16);
        BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter = this.weakAdapterRef.get();
        if (baseMediaUserDelegateAdapter != null && baseMediaUserDelegateAdapter.r0() != 1) {
            int random = (int) ((Math.random() * 2) + 1);
            faceViewHolder.getColumnLayout().setTag(R.id.wqo, Integer.valueOf(random));
            if (GuildMediaUtils.f227771a.n()) {
                i3 = R.drawable.guild_media_channel_user_item_bg;
            } else if (random == 1) {
                i3 = R.drawable.guild_media_channel_user_small_item_bg1;
            } else {
                i3 = R.drawable.guild_media_channel_user_small_item_bg2;
            }
            faceViewHolder.getColumnLayout().setBackgroundResource(i3);
        }
        return faceViewHolder;
    }
}
