package com.tencent.mobileqq.guild.media.widget.user.delegates;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.widget.onlooker.GuildOnLookerViewHolder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt1.MediaViewerUserItem;
import vs1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerUserItemDelegate;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate;", "Lrt1/l;", "Lcom/tencent/mobileqq/guild/media/widget/onlooker/GuildOnLookerViewHolder;", "Lrt1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "t", "holder", "", "payloads", "", "r", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaViewerUserItemDelegate extends BaseMediaItemDelegate<MediaViewerUserItem, GuildOnLookerViewHolder> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MediaViewerUserItem item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        if (item.getUserInfo().f228098f == 1) {
            com.tencent.mobileqq.guild.media.widget.user.a.f229990a.c(view, item.getUserInfo());
        } else {
            com.tencent.mobileqq.guild.media.widget.user.a.f229990a.d(view, item.getUserInfo());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull rt1.a item, @NotNull List<rt1.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MediaViewerUserItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull final MediaViewerUserItem item, @NotNull GuildOnLookerViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        w.c("MediaViewerUserItemDelegate.onBindViewHolder");
        super.o(item, holder, payloads);
        holder.bindData(item.getUserInfo());
        holder.itemView.setTag(item.getUserInfo());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.user.delegates.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaViewerUserItemDelegate.s(MediaViewerUserItem.this, view);
            }
        });
        w.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public GuildOnLookerViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPoolEngine viewPoolEngine = ViewPoolEngine.f228744a;
        e.C11439e c11439e = e.C11439e.f443293a;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new GuildOnLookerViewHolder(viewPoolEngine.i(c11439e, context));
    }
}
