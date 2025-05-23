package fk1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewHelper;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryBaseItemView;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildGalleryMixMediaItemView;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kk1.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002>?B\u000f\u0012\u0006\u00102\u001a\u00020/\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0005J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020$2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010*\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0+H\u0016J\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0007R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u001506j\b\u0012\u0004\u0012\u00020\u0015`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lfk1/b;", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "Ljk1/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "position", "", "i0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Landroid/view/View;", "k0", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "n0", "Lkk1/e;", "m0", "Llk1/a;", "scroller", "s0", c.G, "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildGalleryMixMediaItemView;", "l0", "", "action", "", "args", "j0", "onAttachedToRecyclerView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onDetachedFromRecyclerView", "Lfk1/b$b;", "o0", "getItemViewType", "getItemCount", "", "getItemId", "onBindViewHolder", "", "payloads", "q0", "p0", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", BdhLogUtil.LogTag.Tag_Conn, "Lkk1/e;", "mScrollManager", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "registerFeedScrollerList", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;)V", "E", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends BaseListViewAdapter<jk1.a> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private e mScrollManager;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<lk1.a> registerFeedScrollerList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedGalleryInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J*\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u00a8\u0006\u0010"}, d2 = {"Lfk1/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljk1/a;", "feedBlockData", "", "position", "", "l", "", "", "payloads", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fk1.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C10321b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10321b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(@NotNull jk1.a feedBlockData, int position) {
            Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
            View view = this.itemView;
            if (!(view instanceof GuildFeedGalleryBaseItemView)) {
                QLog.e("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 1, "setData  itemView != BaseItemView");
            } else {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryBaseItemView");
                ((GuildFeedGalleryBaseItemView) view).setData(feedBlockData, position);
            }
        }

        public final void m(@NotNull jk1.a feedBlockData, int position, @Nullable List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
            View view = this.itemView;
            if (!(view instanceof GuildFeedGalleryBaseItemView)) {
                QLog.e("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 1, "setData  itemView != BaseItemView");
                return;
            }
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryBaseItemView");
            GuildFeedGalleryBaseItemView guildFeedGalleryBaseItemView = (GuildFeedGalleryBaseItemView) view;
            if (payloads == null) {
                payloads = CollectionsKt__CollectionsKt.emptyList();
            }
            guildFeedGalleryBaseItemView.setData(feedBlockData, position, payloads);
        }
    }

    public b(@NotNull GuildFeedGalleryInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        this.registerFeedScrollerList = new ArrayList<>();
    }

    private final void i0(RecyclerView.ViewHolder holder, int position) {
        GProStChannelInfo gProStChannelInfo;
        GProStChannelSign gProStChannelSign;
        if (ArrayUtils.isOutOfArrayIndex(position, getDataList())) {
            Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 1, "[onBindViewHolderWithPayload] position " + position + " isOutOfArrayIndex");
            return;
        }
        jk1.a aVar = getDataList().get(position);
        HashMap<String, Object> e16 = mk1.e.e(aVar.getInitBean());
        e16.put("sgrp_rank", Integer.valueOf(position));
        e16.put("sgrp_forum_hold_expend_type", Integer.valueOf(aVar.getExtType()));
        GProStFeed b16 = aVar.b();
        if (b16 != null && (gProStChannelInfo = b16.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
            e16.put("sgrp_channel_id", String.valueOf(gProStChannelSign.guildId));
            e16.put("sgrp_sub_channel_id", String.valueOf(gProStChannelSign.channelId));
        }
        ch.T0(holder.itemView, "em_sgrp_forum_item", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE, e16);
    }

    private final View k0(ViewGroup parent, int viewType) {
        GuildFeedDefaultInitBean n06 = n0();
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        GuildGalleryMixMediaItemView guildGalleryMixMediaItemView = new GuildGalleryMixMediaItemView(context, 1000, n06);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
        ((ViewGroup.LayoutParams) layoutParams).width = -1;
        ((ViewGroup.LayoutParams) layoutParams).height = -1;
        guildGalleryMixMediaItemView.setLayoutParams(layoutParams);
        return guildGalleryMixMediaItemView;
    }

    private final GuildFeedDefaultInitBean n0() {
        GuildFeedDefaultInitBean guildFeedDefaultInitBean = new GuildFeedDefaultInitBean();
        guildFeedDefaultInitBean.setGuildId(this.initBean.getGuildId());
        guildFeedDefaultInitBean.setChannelId(this.initBean.getChannelId());
        guildFeedDefaultInitBean.setBusinessType(this.initBean.getBusinessType());
        guildFeedDefaultInitBean.setJoinInfoParam(this.initBean.getJoinInfoParam());
        guildFeedDefaultInitBean.setJumpExtraInfo(this.initBean.getJumpExtraInfo());
        guildFeedDefaultInitBean.setFeedReportSourceInfo(this.initBean.getFeedReportSourceInfo());
        guildFeedDefaultInitBean.setImmersiveSource(this.initBean.getImmersiveSource());
        guildFeedDefaultInitBean.setAttrs(this.initBean.getAttrs());
        guildFeedDefaultInitBean.setFeedId(this.initBean.getFeedId());
        return guildFeedDefaultInitBean;
    }

    private final void r0(RecyclerView recyclerView) {
        e eVar = new e(recyclerView.getContext(), recyclerView, this);
        Iterator<lk1.a> it = this.registerFeedScrollerList.iterator();
        while (it.hasNext()) {
            eVar.d(it.next());
        }
        eVar.m(0);
        recyclerView.addOnScrollListener(eVar);
        eVar.i(recyclerView);
        this.mScrollManager = eVar;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (getDataList() == null) {
            return 0;
        }
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1000;
    }

    public final void j0(@NotNull String action, @Nullable Object args) {
        GuildFeedGalleryBaseItemView guildFeedGalleryBaseItemView;
        Intrinsics.checkNotNullParameter(action, "action");
        RecyclerView mRecyclerView = this.mRecyclerView;
        Intrinsics.checkNotNullExpressionValue(mRecyclerView, "mRecyclerView");
        for (View view : ViewGroupKt.getChildren(mRecyclerView)) {
            if (view instanceof GuildFeedGalleryBaseItemView) {
                guildFeedGalleryBaseItemView = (GuildFeedGalleryBaseItemView) view;
            } else {
                guildFeedGalleryBaseItemView = null;
            }
            if (guildFeedGalleryBaseItemView != null) {
                guildFeedGalleryBaseItemView.l0(action, args);
            }
        }
    }

    @Nullable
    public final GuildGalleryMixMediaItemView l0(int pos) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.mRecyclerView.findViewHolderForAdapterPosition(pos);
        if (findViewHolderForAdapterPosition instanceof C10321b) {
            View view = ((C10321b) findViewHolderForAdapterPosition).itemView;
            if (view instanceof GuildGalleryMixMediaItemView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.gallery.widget.GuildGalleryMixMediaItemView");
                return (GuildGalleryMixMediaItemView) view;
            }
            return null;
        }
        return null;
    }

    @Nullable
    /* renamed from: m0, reason: from getter */
    public final e getMScrollManager() {
        return this.mScrollManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public C10321b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new C10321b(k0(parent, viewType));
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        r0(recyclerView);
        recyclerView.setRecycledViewPool(mk1.b.f416885a.b(recyclerView.getContext().hashCode()));
        recyclerView.setItemViewCacheSize(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        long currentTimeMillis = System.currentTimeMillis();
        if (ArrayUtils.isOutOfArrayIndex(position, getDataList())) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[onBindViewHolder] position " + position + " isOutOfArrayIndex";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 1, (String) it.next(), null);
            }
            return;
        }
        RecyclerViewHelper recyclerViewHelper = RecyclerViewHelper.INSTANCE;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        recyclerViewHelper.bindViewHolderToItemView(view, holder);
        jk1.a guildFeedBlockData = getDataList().get(position);
        C10321b c10321b = holder instanceof C10321b ? (C10321b) holder : null;
        if (c10321b != null) {
            Intrinsics.checkNotNullExpressionValue(guildFeedBlockData, "guildFeedBlockData");
            c10321b.l(guildFeedBlockData, position);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 1, "onBindViewHolder() position:" + position + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        i0(holder, position);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        e eVar = this.mScrollManager;
        if (eVar != null) {
            recyclerView.removeOnScrollListener(eVar);
            eVar.onDestroy();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        e eVar = this.mScrollManager;
        if (eVar != null) {
            eVar.k(holder);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 4, "onViewAttachedToWindow:" + holder.getAdapterPosition() + "  " + holder + "  " + this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        e eVar = this.mScrollManager;
        if (eVar != null) {
            eVar.l(holder);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 4, "onViewDetachedFromWindow:" + holder.getAdapterPosition() + "  " + holder + "  " + this);
        }
    }

    public final void p0() {
        RecyclerView.LayoutManager layoutManager;
        LinearLayoutManager linearLayoutManager;
        Integer num;
        RecyclerView.LayoutManager layoutManager2;
        LinearLayoutManager linearLayoutManager2;
        Integer num2;
        View view;
        GuildFeedGalleryBaseItemView guildFeedGalleryBaseItemView;
        RecyclerView.LayoutManager layoutManager3;
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            num = Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition());
        } else {
            num = null;
        }
        RecyclerView recyclerView2 = getRecyclerView();
        if (recyclerView2 != null) {
            layoutManager2 = recyclerView2.getLayoutManager();
        } else {
            layoutManager2 = null;
        }
        if (layoutManager2 instanceof LinearLayoutManager) {
            linearLayoutManager2 = (LinearLayoutManager) layoutManager2;
        } else {
            linearLayoutManager2 = null;
        }
        if (linearLayoutManager2 != null) {
            num2 = Integer.valueOf(linearLayoutManager2.findLastVisibleItemPosition());
        } else {
            num2 = null;
        }
        if (num != null && num.intValue() >= 0 && num2 != null && num2.intValue() >= 0) {
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            if (intValue <= intValue2) {
                while (true) {
                    RecyclerView recyclerView3 = getRecyclerView();
                    if (recyclerView3 != null && (layoutManager3 = recyclerView3.getLayoutManager()) != null) {
                        view = layoutManager3.findViewByPosition(intValue);
                    } else {
                        view = null;
                    }
                    if (view instanceof GuildFeedGalleryBaseItemView) {
                        guildFeedGalleryBaseItemView = (GuildFeedGalleryBaseItemView) view;
                    } else {
                        guildFeedGalleryBaseItemView = null;
                    }
                    if (guildFeedGalleryBaseItemView != null) {
                        guildFeedGalleryBaseItemView.y0();
                    }
                    if (intValue == intValue2) {
                        break;
                    } else {
                        intValue++;
                    }
                }
            }
            e eVar = this.mScrollManager;
            if (eVar != null) {
                eVar.onPause();
            }
        }
    }

    public final void q0() {
        RecyclerView.LayoutManager layoutManager;
        LinearLayoutManager linearLayoutManager;
        Integer num;
        RecyclerView.LayoutManager layoutManager2;
        LinearLayoutManager linearLayoutManager2;
        Integer num2;
        View view;
        GuildFeedGalleryBaseItemView guildFeedGalleryBaseItemView;
        RecyclerView.LayoutManager layoutManager3;
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            num = Integer.valueOf(linearLayoutManager.findFirstCompletelyVisibleItemPosition());
        } else {
            num = null;
        }
        RecyclerView recyclerView2 = getRecyclerView();
        if (recyclerView2 != null) {
            layoutManager2 = recyclerView2.getLayoutManager();
        } else {
            layoutManager2 = null;
        }
        if (layoutManager2 instanceof LinearLayoutManager) {
            linearLayoutManager2 = (LinearLayoutManager) layoutManager2;
        } else {
            linearLayoutManager2 = null;
        }
        if (linearLayoutManager2 != null) {
            num2 = Integer.valueOf(linearLayoutManager2.findLastCompletelyVisibleItemPosition());
        } else {
            num2 = null;
        }
        if (num != null && num.intValue() >= 0 && num2 != null && num2.intValue() >= 0) {
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            if (intValue <= intValue2) {
                while (true) {
                    RecyclerView recyclerView3 = getRecyclerView();
                    if (recyclerView3 != null && (layoutManager3 = recyclerView3.getLayoutManager()) != null) {
                        view = layoutManager3.findViewByPosition(intValue);
                    } else {
                        view = null;
                    }
                    if (view instanceof GuildFeedGalleryBaseItemView) {
                        guildFeedGalleryBaseItemView = (GuildFeedGalleryBaseItemView) view;
                    } else {
                        guildFeedGalleryBaseItemView = null;
                    }
                    if (guildFeedGalleryBaseItemView != null) {
                        guildFeedGalleryBaseItemView.z0();
                    }
                    if (intValue == intValue2) {
                        break;
                    } else {
                        intValue++;
                    }
                }
            }
            e eVar = this.mScrollManager;
            if (eVar != null) {
                eVar.onResume();
            }
        }
    }

    public final void s0(@NotNull lk1.a scroller) {
        Intrinsics.checkNotNullParameter(scroller, "scroller");
        this.registerFeedScrollerList.add(scroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<Object> payloads) {
        C10321b c10321b;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        long currentTimeMillis = System.currentTimeMillis();
        if (ArrayUtils.isOutOfArrayIndex(position, getDataList())) {
            Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 1, "[onBindViewHolderWithPayload] position " + position + " isOutOfArrayIndex");
            return;
        }
        RecyclerViewHelper recyclerViewHelper = RecyclerViewHelper.INSTANCE;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        recyclerViewHelper.bindViewHolderToItemView(view, holder);
        jk1.a guildFeedBlockData = getDataList().get(position);
        if (payloads.isEmpty()) {
            c10321b = holder instanceof C10321b ? (C10321b) holder : null;
            if (c10321b != null) {
                Intrinsics.checkNotNullExpressionValue(guildFeedBlockData, "guildFeedBlockData");
                c10321b.l(guildFeedBlockData, position);
            }
        } else {
            c10321b = holder instanceof C10321b ? (C10321b) holder : null;
            if (c10321b != null) {
                Intrinsics.checkNotNullExpressionValue(guildFeedBlockData, "guildFeedBlockData");
                c10321b.m(guildFeedBlockData, position, payloads);
            }
        }
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryVerticalAdapter", 1, "onBindViewHolderWithPayload position:" + position + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
        i0(holder, position);
    }
}
