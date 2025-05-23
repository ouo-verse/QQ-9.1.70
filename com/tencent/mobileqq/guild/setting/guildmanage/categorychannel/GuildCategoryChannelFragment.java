package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014J&\u0010!\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010\"\u001a\u00020\u0004H\u0014J\"\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010%H\u0016J\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\b\u0010)\u001a\u00020\u0004H\u0016R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/l;", "data", "", "bi", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Xh", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "Th", "ci", "Vh", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/f;", "Wh", "Oh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "ai", "Landroidx/recyclerview/widget/ItemTouchHelper;", "Qh", "Rh", "", "qh", "ph", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "doResume", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "initData", "initView", "rh", "", "T", "J", "guildId", "Landroidx/recyclerview/widget/RecyclerView;", "U", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/a;", "V", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/a;", "adapter", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelViewModel;", "W", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelViewModel;", "viewModel", "X", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "", "Y", "Z", "isEditing", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCategoryChannelFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private long guildId;

    /* renamed from: U, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: V, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: W, reason: from kotlin metadata */
    private GuildCategoryChannelViewModel viewModel;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final ItemTouchHelper itemTouchHelper = Qh();

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isEditing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "a", "", "REQ_CODE_OPEN_CATEGORY_CHOICE", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            QPublicFragmentActivity.start(context, intent, GuildCategoryChannelFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelFragment$b", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "isDragStart", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "getMovementFlags", "target", "onMove", "direction", "onSwiped", "actionState", "onSelectedChanged", "clearView", "isLongPressDragEnabled", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ItemTouchHelper.Callback {
        b() {
        }

        private final void a(RecyclerView.ViewHolder viewHolder, boolean isDragStart) {
            View view;
            float f16;
            if (viewHolder != null) {
                view = viewHolder.itemView;
            } else {
                view = null;
            }
            if (view != null) {
                try {
                    viewHolder.itemView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                    View view2 = viewHolder.itemView;
                    if (isDragStart) {
                        f16 = 20.0f;
                    } else {
                        f16 = 0.0f;
                    }
                    view2.setTranslationZ(f16);
                } catch (Exception e16) {
                    Logger.f235387a.d().w("GuildCategoryChannelFragment", 1, "setItemShadow " + e16);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            a(viewHolder, false);
            a aVar = GuildCategoryChannelFragment.this.adapter;
            GuildCategoryChannelViewModel guildCategoryChannelViewModel = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            GuildCategoryChannelViewModel guildCategoryChannelViewModel2 = GuildCategoryChannelFragment.this.viewModel;
            if (guildCategoryChannelViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildCategoryChannelViewModel = guildCategoryChannelViewModel2;
            }
            aVar.submitList(guildCategoryChannelViewModel.X1());
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            Object tag = viewHolder.itemView.getTag();
            Object tag2 = target.itemView.getTag();
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            if ((tag instanceof GuildCategoryChannelItemData) && (tag2 instanceof GuildCategoryChannelItemData)) {
                GuildCategoryChannelViewModel guildCategoryChannelViewModel = GuildCategoryChannelFragment.this.viewModel;
                a aVar = null;
                if (guildCategoryChannelViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildCategoryChannelViewModel = null;
                }
                guildCategoryChannelViewModel.b2((GuildCategoryChannelItemData) tag, (GuildCategoryChannelItemData) tag2);
                a aVar2 = GuildCategoryChannelFragment.this.adapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    aVar2 = null;
                }
                List<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b> currentList = aVar2.getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
                ArrayList arrayList = new ArrayList(currentList);
                Collections.swap(arrayList, adapterPosition, adapterPosition2);
                a aVar3 = GuildCategoryChannelFragment.this.adapter;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    aVar = aVar3;
                }
                aVar.submitList(arrayList);
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            View view;
            super.onSelectedChanged(viewHolder, actionState);
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                view.setBackgroundResource(R.drawable.guild_token_setting_rect_8_selector);
            }
            a(viewHolder, true);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ArrayList arrayList = (ArrayList) t16;
            a aVar = GuildCategoryChannelFragment.this.adapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            aVar.submitList(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Pair pair = (Pair) t16;
            if (((Boolean) pair.getFirst()).booleanValue()) {
                GuildCategoryChannelFragment.this.Xh((GuildCategoryChannelItemData) pair.getSecond());
            }
        }
    }

    private final void Oh(View view) {
        Map mapOf;
        GuildCategoryChannelViewModel guildCategoryChannelViewModel = null;
        if (this.isEditing) {
            setLeftButton(getResources().getString(R.string.f140850f3), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildCategoryChannelFragment.Ph(GuildCategoryChannelFragment.this, view2);
                }
            });
            ChannelSettingUtils.j(view, "em_sgrp_edit_button", null, 4, null);
            return;
        }
        GuildCategoryChannelViewModel guildCategoryChannelViewModel2 = this.viewModel;
        if (guildCategoryChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildCategoryChannelViewModel2 = null;
        }
        guildCategoryChannelViewModel2.d2();
        resetLeftButton();
        GuildCategoryChannelViewModel guildCategoryChannelViewModel3 = this.viewModel;
        if (guildCategoryChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildCategoryChannelViewModel = guildCategoryChannelViewModel3;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_show_zone_type", guildCategoryChannelViewModel.U1()));
        ChannelSettingUtils.i(view, "em_sgrp_complete_btn", mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(GuildCategoryChannelFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.resetLeftButton();
        TextView rightViewText = this$0.F;
        Intrinsics.checkNotNullExpressionValue(rightViewText, "rightViewText");
        rightViewText.setVisibility(8);
        this$0.isEditing = false;
        GuildCategoryChannelViewModel guildCategoryChannelViewModel = this$0.viewModel;
        GuildCategoryChannelViewModel guildCategoryChannelViewModel2 = null;
        if (guildCategoryChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildCategoryChannelViewModel = null;
        }
        guildCategoryChannelViewModel.f2(false);
        GuildCategoryChannelViewModel guildCategoryChannelViewModel3 = this$0.viewModel;
        if (guildCategoryChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildCategoryChannelViewModel2 = guildCategoryChannelViewModel3;
        }
        guildCategoryChannelViewModel2.S1(this$0.guildId);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final ItemTouchHelper Qh() {
        return new ItemTouchHelper(new b());
    }

    private final void Rh() {
        int i3;
        Map<String, Object> mapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_tab_zone_manage");
        if (ch.n0(String.valueOf(this.guildId))) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        RelativeLayout relativeLayout = this.N;
        String valueOf = String.valueOf(this.guildId);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", Long.valueOf(this.guildId)), TuplesKt.to("sgrp_user_type", Integer.valueOf(i3)));
        iGuildDTReportApi.setGuildPageParams(relativeLayout, valueOf, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(GuildCategoryChannelFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isEditing = false;
        GuildCategoryChannelViewModel guildCategoryChannelViewModel = this$0.viewModel;
        if (guildCategoryChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildCategoryChannelViewModel = null;
        }
        guildCategoryChannelViewModel.f2(false);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Oh(it);
        TextView rightViewText = this$0.F;
        Intrinsics.checkNotNullExpressionValue(rightViewText, "rightViewText");
        rightViewText.setVisibility(8);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(View view, com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b data) {
        if (data instanceof GuildCategoryChannelItemData) {
            Vh((GuildCategoryChannelItemData) data, view);
        } else if (data instanceof GuildCategoryChannelDefaultSettingItemData) {
            Wh((GuildCategoryChannelDefaultSettingItemData) data, view);
        }
    }

    @JvmStatic
    public static final void Uh(@NotNull Context context, @NotNull String str) {
        INSTANCE.a(context, str);
    }

    private final void Vh(GuildCategoryChannelItemData data, View view) {
        Map mapOf;
        int categoryType = data.getCategoryChannel().getCategoryType();
        if (categoryType != 1) {
            if (categoryType != 2) {
                if (categoryType != 3) {
                    if (categoryType == 6) {
                        QQToast.makeText(getContext(), R.string.f1518618u, 0).show();
                    }
                } else {
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelManage(getContext(), String.valueOf(this.guildId), 3);
                }
            } else if (getContext() != null) {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelManage(getContext(), String.valueOf(this.guildId), 2);
            }
        } else {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelManage(getContext(), String.valueOf(this.guildId), 1);
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_tab_zone_name", data.getCategoryChannel().getCategoryAlias()));
        ChannelSettingUtils.i(view, "em_sgrp_tab_zone", mapOf);
    }

    private final void Wh(GuildCategoryChannelDefaultSettingItemData data, View view) {
        Map mapOf;
        Logger.f235387a.d().d("GuildCategoryChannelFragment", 1, "[openDefaultSettingPage] click");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GuildCategoryChannelChoiceFragment.INSTANCE.a(activity, String.valueOf(this.guildId), data.getCategoryChannel().getCategoryId(), 1);
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_tab_zone_type", Integer.valueOf(data.getCategoryChannel().getCategoryType())));
        ChannelSettingUtils.i(view, "em_sgrp_user_default_jump_zone", mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(final GuildCategoryChannelItemData item) {
        DialogUtil.createNoTitleDialog(requireActivity(), getString(R.string.f142630jw, item.getCategoryChannel().getCategoryAlias()), R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildCategoryChannelFragment.Yh(GuildCategoryChannelFragment.this, item, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildCategoryChannelFragment.Zh(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(GuildCategoryChannelFragment this$0, GuildCategoryChannelItemData item, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        GuildCategoryChannelViewModel guildCategoryChannelViewModel = this$0.viewModel;
        if (guildCategoryChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildCategoryChannelViewModel = null;
        }
        guildCategoryChannelViewModel.i2(item, true);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(RecyclerView.ViewHolder it) {
        this.itemTouchHelper.startDrag(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(GuildCategoryChannelItemData data) {
        if (data.getCategoryChannel().getCategoryType() != 1) {
            GuildCategoryChannelViewModel guildCategoryChannelViewModel = this.viewModel;
            if (guildCategoryChannelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildCategoryChannelViewModel = null;
            }
            guildCategoryChannelViewModel.a2(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci(View view, com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b data) {
        if (data instanceof GuildCategoryChannelTitleHolderData) {
            this.isEditing = true;
            GuildCategoryChannelViewModel guildCategoryChannelViewModel = this.viewModel;
            if (guildCategoryChannelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildCategoryChannelViewModel = null;
            }
            guildCategoryChannelViewModel.f2(true);
            Oh(view);
            view.setVisibility(8);
            TextView rightViewText = this.F;
            Intrinsics.checkNotNullExpressionValue(rightViewText, "rightViewText");
            rightViewText.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        rh();
        setTitle(getResources().getString(R.string.f140900f8));
        initData();
        initView();
        Rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void doResume() {
        super.doResume();
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        aVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ehg;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initData() {
        long j3;
        Intent intent;
        Long longOrNull;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (r0 = intent.getStringExtra("extra_guild_id")) != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.guildId = j3;
        GuildCategoryChannelViewModel.Companion companion = GuildCategoryChannelViewModel.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = companion.a(requireActivity, this.guildId);
        setRightButtonText(getResources().getString(R.string.f143340lt), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildCategoryChannelFragment.Sh(GuildCategoryChannelFragment.this, view);
            }
        });
        TextView rightViewText = this.F;
        Intrinsics.checkNotNullExpressionValue(rightViewText, "rightViewText");
        rightViewText.setVisibility(8);
    }

    public final void initView() {
        this.adapter = new a(new g(new GuildCategoryChannelFragment$initView$1(this), new GuildCategoryChannelFragment$initView$2(this), new GuildCategoryChannelFragment$initView$3(this), new GuildCategoryChannelFragment$initView$4(this)));
        View findViewById = this.P.findViewById(R.id.zd9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.module_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        GuildCategoryChannelViewModel guildCategoryChannelViewModel = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        recyclerView2.setAdapter(aVar);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(defaultItemAnimator);
        com.tencent.mobileqq.guild.channel.manage.c cVar = new com.tencent.mobileqq.guild.channel.manage.c(getContext(), 0, 1, getResources().getColor(R.color.qui_common_border_standard));
        cVar.b(QQGuildUIUtil.f(16.0f), QQGuildUIUtil.f(16.0f));
        cVar.c(false);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addItemDecoration(cVar);
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        itemTouchHelper.attachToRecyclerView(recyclerView5);
        GuildCategoryChannelViewModel guildCategoryChannelViewModel2 = this.viewModel;
        if (guildCategoryChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildCategoryChannelViewModel2 = null;
        }
        LiveData<ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b>> T1 = guildCategoryChannelViewModel2.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        T1.observe(viewLifecycleOwner, new c());
        GuildCategoryChannelViewModel guildCategoryChannelViewModel3 = this.viewModel;
        if (guildCategoryChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildCategoryChannelViewModel3 = null;
        }
        LiveData<Pair<Boolean, GuildCategoryChannelItemData>> Z1 = guildCategoryChannelViewModel3.Z1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        Z1.observe(viewLifecycleOwner2, new d());
        GuildCategoryChannelViewModel guildCategoryChannelViewModel4 = this.viewModel;
        if (guildCategoryChannelViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildCategoryChannelViewModel = guildCategoryChannelViewModel4;
        }
        guildCategoryChannelViewModel.S1(this.guildId);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.f235387a.d().d("GuildCategoryChannelFragment", 1, "[onActivityResult] reqCode:" + requestCode + ", resultCode: " + resultCode);
        if (1 == requestCode && -1 == resultCode) {
            GuildCategoryChannelViewModel guildCategoryChannelViewModel = this.viewModel;
            if (guildCategoryChannelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildCategoryChannelViewModel = null;
            }
            guildCategoryChannelViewModel.c2();
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.guild_color_ffffff_1d1d20;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.guild_titlebar_bg;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
    }
}
