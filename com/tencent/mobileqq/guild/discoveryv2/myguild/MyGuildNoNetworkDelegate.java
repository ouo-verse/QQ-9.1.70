package com.tencent.mobileqq.guild.discoveryv2.myguild;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildNoNetworkDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/w;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildNoNetworkDelegate$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "t", "holder", "", "payloads", "", "r", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyGuildNoNetworkDelegate extends AbsListItemAdapterDelegate<MyGuildNoNetworkData, h, a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildNoNetworkDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "E", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "l", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "state", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QUIEmptyState state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView, @NotNull QUIEmptyState state) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QUIEmptyState getState() {
            return this.state;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MyGuildNoNetworkData item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        item.a().invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull h item, @NotNull List<h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MyGuildNoNetworkData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull final MyGuildNoNetworkData item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        QUIButton button = holder.getState().getButton();
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyGuildNoNetworkDelegate.s(MyGuildNoNetworkData.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(context).setBackgroundColorType(0);
        String string = context.getString(R.string.f1511116t);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ild_network_disconnected)");
        QUIEmptyState.Builder title = backgroundColorType.setTitle(string).setImageType(5).setHalfScreenState(false).setAutoCenter(true).setTitle("\u7f51\u7edc\u5f02\u5e38");
        String string2 = context.getString(R.string.f2070459y);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026qq_video_play_error_hint)");
        QUIEmptyState.Builder desc = title.setDesc(string2);
        String string3 = context.getString(R.string.f143170lc);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026ld_dicovery_mine_refresh)");
        QUIEmptyState build = desc.setButton(string3, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyGuildNoNetworkDelegate.u(view);
            }
        }).build();
        ImageView imageView = (ImageView) build.findViewById(R.id.uuj);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.guild_net_error);
        }
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(build, layoutParams);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new a(frameLayout, build);
    }
}
