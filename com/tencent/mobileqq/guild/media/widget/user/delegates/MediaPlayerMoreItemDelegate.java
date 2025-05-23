package com.tencent.mobileqq.guild.media.widget.user.delegates;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.widget.GuildMemberMoreUserView;
import com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseMediaItemDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt1.MediaPlayerMoreItem;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaPlayerMoreItemDelegate;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate;", "Lrt1/f;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaPlayerMoreItemDelegate$ViewHolder;", "Lrt1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "r", "holder", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "e", "Ljava/lang/ref/WeakReference;", "weakAdapterRef", "adapter", "<init>", "(Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;)V", "f", "a", "ViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaPlayerMoreItemDelegate extends BaseMediaItemDelegate<MediaPlayerMoreItem, ViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<BaseMediaUserDelegateAdapter> weakAdapterRef;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaPlayerMoreItemDelegate$ViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate$BaseMediaViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class ViewHolder extends BaseMediaItemDelegate.BaseMediaViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public MediaPlayerMoreItemDelegate(@NotNull BaseMediaUserDelegateAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.weakAdapterRef = new WeakReference<>(adapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull rt1.a item, @NotNull List<rt1.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MediaPlayerMoreItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull MediaPlayerMoreItem item, @NotNull ViewHolder holder, @NotNull List<Object> payloads) {
        boolean z16;
        GuildMemberMoreUserView guildMemberMoreUserView;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        w.c("MediaPlayerMoreItemDelegate_onBindViewHolder");
        super.o(item, holder, payloads);
        List<p> b16 = item.b();
        if (b16 != null && !b16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("QGMC.MediaPlayerMoreItemDelegate", 1, "[onBindViewHolder] empty list");
            return;
        }
        View view = holder.itemView;
        if (view instanceof GuildMemberMoreUserView) {
            guildMemberMoreUserView = (GuildMemberMoreUserView) view;
        } else {
            guildMemberMoreUserView = null;
        }
        if (guildMemberMoreUserView != null) {
            guildMemberMoreUserView.a(item.b());
        }
        BaseMediaUserDelegateAdapter baseMediaUserDelegateAdapter = this.weakAdapterRef.get();
        if (baseMediaUserDelegateAdapter != null) {
            int l06 = baseMediaUserDelegateAdapter.l0();
            holder.itemView.setLayoutParams(new ViewGroup.LayoutParams(l06, l06));
        }
        w.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(new GuildMemberMoreUserView(context, null, 2, null));
    }
}
