package com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.BindGuildInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001)B!\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b'\u0010(J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSettingListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/qqnt/kernel/nativeinterface/BindGuildInfo;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "guildInfo", "", "", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "", "getItemId", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lht2/g;", BdhLogUtil.LogTag.Tag_Conn, "Lht2/g;", "vm", "Landroidx/lifecycle/LifecycleOwner;", "D", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lkotlin/Function1;", "E", "Lkotlin/jvm/functions/Function1;", "manageBtnClickListener", UserInfo.SEX_FEMALE, "itemClickListener", "<init>", "(Landroid/content/Context;Lht2/g;Landroidx/lifecycle/LifecycleOwner;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGuildSettingListAdapter extends ListAdapter<BindGuildInfo, RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ht2.g vm;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function1<AIOBindGuildInfo, Unit> manageBtnClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function1<AIOBindGuildInfo, Unit> itemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSettingListAdapter$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/BindGuildInfo;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends DiffUtil.ItemCallback<BindGuildInfo> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull BindGuildInfo oldItem, @NotNull BindGuildInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull BindGuildInfo oldItem, @NotNull BindGuildInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.guildId == newItem.guildId) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopBindGuildSettingListAdapter(@Nullable Context context, @NotNull ht2.g vm5, @NotNull LifecycleOwner viewLifecycleOwner) {
        super(new a());
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.context = context;
        this.vm = vm5;
        this.viewLifecycleOwner = viewLifecycleOwner;
        this.manageBtnClickListener = new TroopBindGuildSettingListAdapter$manageBtnClickListener$1(this);
        this.itemClickListener = new Function1<AIOBindGuildInfo, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.TroopBindGuildSettingListAdapter$itemClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIOBindGuildInfo aIOBindGuildInfo) {
                invoke2(aIOBindGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AIOBindGuildInfo guildInfo) {
                Context context2;
                Context context3;
                ht2.g gVar;
                Map<String, ? extends Object> m06;
                Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
                context2 = TroopBindGuildSettingListAdapter.this.context;
                if (context2 != null) {
                    TroopBindGuildSettingListAdapter troopBindGuildSettingListAdapter = TroopBindGuildSettingListAdapter.this;
                    com.tencent.mobileqq.guild.report.b.g("qq_group_pindao_management", "troop_bind_guild");
                    IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                    context3 = troopBindGuildSettingListAdapter.context;
                    iQQGuildRouterApi.jumpGuildByBusinessType(context3, String.valueOf(guildInfo.guildId), "qq_group", "pindao_management", 16, new Bundle());
                    gVar = troopBindGuildSettingListAdapter.vm;
                    m06 = troopBindGuildSettingListAdapter.m0(guildInfo);
                    gVar.c2("em_group_channel_link", "dt_clck", m06);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> m0(AIOBindGuildInfo guildInfo) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_channel_id", Long.valueOf(guildInfo.guildId)));
        return mutableMapOf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        QUIListItemBackgroundType qUIListItemBackgroundType;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof it2.e) {
            BindGuildInfo item = getItem(position);
            it2.e eVar = (it2.e) holder;
            AIOBindGuildInfo aIOBindGuildInfo = new AIOBindGuildInfo();
            aIOBindGuildInfo.guildId = item.guildId;
            aIOBindGuildInfo.guildName = item.guildName;
            aIOBindGuildInfo.guildNumber = item.guildNumber;
            aIOBindGuildInfo.faceSeq = item.faceSeq;
            aIOBindGuildInfo.isOwner = false;
            if (position == getItemCount() - 1) {
                qUIListItemBackgroundType = QUIListItemBackgroundType.BottomRound;
            } else {
                qUIListItemBackgroundType = QUIListItemBackgroundType.NoneRound;
            }
            eVar.n(aIOBindGuildInfo, qUIListItemBackgroundType, it2.a.f408711a.d(), this.itemClickListener, this.manageBtnClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fzr, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026rent, false\n            )");
        return new it2.e(inflate);
    }
}
