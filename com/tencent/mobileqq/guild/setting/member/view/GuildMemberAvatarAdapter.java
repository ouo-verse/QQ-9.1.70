package com.tencent.mobileqq.guild.setting.member.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.setting.member.view.GuildMemberAvatarAdapter;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002'(B2\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0017\u00a2\u0006\u0004\b$\u0010%J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R2\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/GuildMemberAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/setting/member/view/GuildMemberAvatarAdapter$GuildMemberViewHolder;", "", "Lcom/tencent/mobileqq/guild/setting/member/view/a;", "list", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "i0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tinyId", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "getOnAvatarClick", "()Lkotlin/jvm/functions/Function1;", "onAvatarClick", "", "D", "Ljava/util/List;", "mData", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "E", "a", "GuildMemberViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberAvatarAdapter extends RecyclerView.Adapter<GuildMemberViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<String, Unit> onAvatarClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<GuildMemberAvatarInfo> mData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R2\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\n \u001d*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u000f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/GuildMemberAvatarAdapter$GuildMemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/setting/member/view/a;", "info", "", DomainData.DOMAIN_NAME, "l", "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tinyId", "G", "Lkotlin/jvm/functions/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lkotlin/jvm/functions/Function1;", "onAvatarClick", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "kotlin.jvm.PlatformType", "H", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mAvatar", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mNickName", "J", "<init>", "(Landroid/view/View;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class GuildMemberViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final Function1<String, Unit> onAvatarClick;

        /* renamed from: H, reason: from kotlin metadata */
        private final GuildUserAvatarView mAvatar;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView mNickName;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private String tinyId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildMemberViewHolder(@NotNull View itemView, @NotNull String guildId, @NotNull Function1<? super String, Unit> onAvatarClick) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(onAvatarClick, "onAvatarClick");
            this.itemView = itemView;
            this.guildId = guildId;
            this.onAvatarClick = onAvatarClick;
            this.mAvatar = (GuildUserAvatarView) this.itemView.findViewById(R.id.a2o);
            this.mNickName = (TextView) this.itemView.findViewById(R.id.f98);
            this.tinyId = "";
        }

        private final void n(final GuildMemberAvatarInfo info) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementReport(this.itemView, "em_sgrp_sub_channel_online", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementParams(this.itemView, new HashMap());
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            jt1.b.b(itemView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.view.GuildMemberAvatarAdapter$GuildMemberViewHolder$initDT$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Map emptyMap;
                    Intrinsics.checkNotNullParameter(it, "it");
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    VideoReport.reportEvent("clck", it, emptyMap);
                    GuildMemberAvatarAdapter.GuildMemberViewHolder.this.m().invoke(info.getTinyId());
                }
            });
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            jt1.b.b(itemView2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.view.GuildMemberAvatarAdapter$GuildMemberViewHolder$initDT$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Map emptyMap;
                    Intrinsics.checkNotNullParameter(it, "it");
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    VideoReport.reportEvent("clck", it, emptyMap);
                    GuildMemberAvatarAdapter.GuildMemberViewHolder.this.m().invoke(info.getTinyId());
                }
            });
        }

        public final void l(@NotNull GuildMemberAvatarInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.mAvatar.setAvatarMeta(this.guildId, "0", info.getAvatarMeta());
            this.mNickName.setText(info.getNickName());
            this.tinyId = info.getTinyId();
            n(info);
        }

        @NotNull
        public final Function1<String, Unit> m() {
            return this.onAvatarClick;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberAvatarAdapter(@NotNull String guildId, @NotNull Function1<? super String, Unit> onAvatarClick) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(onAvatarClick, "onAvatarClick");
        this.guildId = guildId;
        this.onAvatarClick = onAvatarClick;
        this.mData = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull GuildMemberViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(this.mData.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public GuildMemberViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f1q, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026view_item, parent, false)");
        return new GuildMemberViewHolder(inflate, this.guildId, this.onAvatarClick);
    }

    public final void k0(@NotNull List<GuildMemberAvatarInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
    }
}
