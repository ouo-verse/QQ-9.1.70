package com.tencent.mobileqq.guild.discoveryv2.myguild;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildEmptyDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/v;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildEmptyDelegate$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyGuildEmptyDelegate extends AbsListItemAdapterDelegate<MyGuildNoJoinedData, h, a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildEmptyDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull h item, @NotNull List<h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MyGuildNoJoinedData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull MyGuildNoJoinedData item, @NotNull a holder, @NotNull List<Object> payloads) {
        int d16;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        if (item.getIsFullScreen()) {
            d16 = -1;
        } else {
            d16 = (int) cw.d(250);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = d16;
        } else {
            layoutParams = new ViewGroup.LayoutParams(-1, d16);
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        boolean z16;
        String str;
        String str2;
        int i3;
        List<IGProGuildInfo> sortedGuildList;
        Intrinsics.checkNotNullParameter(parent, "parent");
        IGPSService d16 = at.d();
        if (d16 != null && (sortedGuildList = d16.getSortedGuildList()) != null && !sortedGuildList.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        GuildQUIEmptyState.a o16 = new GuildQUIEmptyState.a(parent.getContext()).o(0);
        if (z16) {
            str = "\u6682\u65e0\u9891\u9053\u66f4\u65b0";
        } else {
            str = "\u6682\u65e0\u52a0\u5165\u7684\u9891\u9053";
        }
        GuildQUIEmptyState a16 = o16.u(str).s(3).q("\u53bb\u63a2\u7d22\u53d1\u73b0\u65b0\u9891\u9053\u5427").n(false).a();
        ImageView imageView = (ImageView) a16.findViewById(R.id.uuj);
        if (imageView != null) {
            if (z16) {
                i3 = R.drawable.guild_empty_feeds;
            } else {
                i3 = R.drawable.guild_no_joined;
            }
            imageView.setImageResource(i3);
        }
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(a16, layoutParams);
        if (z16) {
            str2 = "em_sgrp_no_channel_update";
        } else {
            str2 = "em_sgrp_no_channel_join";
        }
        VideoReport.setElementId(frameLayout, str2);
        return new a(frameLayout);
    }
}
