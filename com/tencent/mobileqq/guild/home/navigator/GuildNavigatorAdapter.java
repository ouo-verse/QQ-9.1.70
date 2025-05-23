package com.tencent.mobileqq.guild.home.navigator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.navigator.GuildNavigatorAdapter;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mz1.AdditionAppItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0018j\b\u0012\u0004\u0012\u00020\t`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/home/navigator/GuildNavigatorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "", "Lcom/tencent/mobileqq/guild/home/navigator/d;", "data", "", "setDataList", "getItemCount", "position", "getItemViewType", "holder", "onBindViewHolder", "Lcom/tencent/mobileqq/guild/home/navigator/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/home/navigator/c;", "getEventHandler", "()Lcom/tencent/mobileqq/guild/home/navigator/c;", "eventHandler", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "dataList", "<init>", "(Lcom/tencent/mobileqq/guild/home/navigator/c;)V", "a", "NavigatorViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNavigatorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<NavigatorData> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/home/navigator/GuildNavigatorAdapter$NavigatorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/home/navigator/d;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mobileqq/guild/home/navigator/c;", "E", "Lcom/tencent/mobileqq/guild/home/navigator/c;", "getEventHandler", "()Lcom/tencent/mobileqq/guild/home/navigator/c;", "eventHandler", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "navigatorIcon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "navigatorText", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/home/navigator/c;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class NavigatorViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final c eventHandler;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private ImageView navigatorIcon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView navigatorText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigatorViewHolder(@NotNull View itemView, @NotNull c eventHandler) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
            this.eventHandler = eventHandler;
            View findViewById = itemView.findViewById(R.id.zn8);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.navigator_icon)");
            this.navigatorIcon = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.zn_);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.navigator_text)");
            this.navigatorText = (TextView) findViewById2;
        }

        private final void n(NavigatorData data) {
            VideoReport.setElementId(this.itemView, "em_sgrp_apply_category");
            VideoReport.setElementReuseIdentifier(this.itemView, String.valueOf(data.getCategoryId()));
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_apply_category_name", data.getIconName());
            hashMap.put("sgrp_navigation_url", data.getNavigationJumpUrl());
            hashMap.put("sgrp_apply_category_type", String.valueOf(data.getCategoryType()));
            VideoReport.setElementParams(this.itemView, hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(NavigatorViewHolder this$0, NavigatorData data, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.eventHandler.b().invoke(data);
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void q(NavigatorData data) {
            boolean isBlank;
            isBlank = StringsKt__StringsJVMKt.isBlank(data.getNavigationIconUrl());
            if (!isBlank) {
                v.g(data.getNavigationIconUrl(), this.navigatorIcon, R.color.qui_common_icon_primary, new Function1<SkinnableBitmapDrawable, Unit>() { // from class: com.tencent.mobileqq.guild.home.navigator.GuildNavigatorAdapter$NavigatorViewHolder$updateNavigatorIcon$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SkinnableBitmapDrawable skinnableBitmapDrawable) {
                        invoke2(skinnableBitmapDrawable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull SkinnableBitmapDrawable it) {
                        ImageView imageView;
                        Intrinsics.checkNotNullParameter(it, "it");
                        imageView = GuildNavigatorAdapter.NavigatorViewHolder.this.navigatorIcon;
                        imageView.setImageDrawable(it);
                    }
                });
                return;
            }
            Integer c16 = AdditionAppItem.INSTANCE.c(data.getCategoryType());
            if (c16 != null) {
                int intValue = c16.intValue();
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                this.navigatorIcon.setImageDrawable(GuildUIUtils.w(context, intValue, Integer.valueOf(R.color.qui_common_icon_primary)));
            }
        }

        public final void o(@NotNull final NavigatorData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            q(data);
            this.navigatorText.setText(data.getIconName());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.navigator.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildNavigatorAdapter.NavigatorViewHolder.p(GuildNavigatorAdapter.NavigatorViewHolder.this, data, view);
                }
            });
            n(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/navigator/GuildNavigatorAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/guild/home/navigator/c;", "eventHandler", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/home/navigator/c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView, @NotNull final c eventHandler) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.navigator.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildNavigatorAdapter.a.m(c.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(c eventHandler, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(eventHandler, "$eventHandler");
            eventHandler.a().invoke();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GuildNavigatorAdapter(@NotNull c eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
        this.dataList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.dataList.get(position).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof NavigatorViewHolder) {
            NavigatorData navigatorData = this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(navigatorData, "dataList[position]");
            ((NavigatorViewHolder) holder).o(navigatorData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.etv, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new NavigatorViewHolder(view, this.eventHandler);
        }
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f19, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        return new a(view2, this.eventHandler);
    }

    public final void setDataList(@NotNull List<NavigatorData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }
}
