package com.tencent.mobileqq.guild.feed.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.event.GuildNoticeClearRedPointEvent;
import com.tencent.mobileqq.guild.feed.adapter.i;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedMessageItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildManageNoticeItemView;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.x;
import com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator;
import com.tencent.mobileqq.guild.widget.menu.BaseMenuEntry;
import com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.widget.ActionSheet;
import ij1.p;
import ij1.v;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import ui1.b;
import zm1.a;

/* compiled from: P */
/* loaded from: classes13.dex */
public class i extends cj1.b<v<?>> {
    private GuildFeedBaseInitBean C;
    private View D;
    private x E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d extends RecyclerView.ViewHolder {
        public d(@NonNull View view) {
            super(view);
        }

        public void l(v vVar, int i3, @Nullable zm1.a aVar) {
            View view = this.itemView;
            if (view instanceof GuildBaseWidgetView) {
                if (aVar != null && (view instanceof GuildFeedMessageItemView)) {
                    ((GuildFeedMessageItemView) view).setDataWithPayload((ij1.a) vVar, i3, aVar);
                    return;
                } else {
                    ((GuildBaseWidgetView) view).setData(vVar, i3);
                    return;
                }
            }
            QLog.e("GuildFeedNoticeListAdapter", 1, "setData  itemView != GuildBaseWidgetView");
        }
    }

    public i(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        super(new Bundle());
        this.C = guildFeedBaseInitBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Unit m0(int i3, boolean z16, GuildSwipeMenuItemHelper guildSwipeMenuItemHelper) {
        x xVar = this.E;
        if (xVar != null) {
            xVar.b(i3, z16);
        }
        return Unit.INSTANCE;
    }

    private FrameLayout n0(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setBackgroundColor(viewGroup.getContext().getResources().getColor(R.color.qui_common_bg_bottom_brand));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(12.0f)));
        frameLayout.setPadding(0, ViewUtils.dip2px(12.0f), 0, 0);
        return frameLayout;
    }

    private GuildSwipeMenuItemHelper.b o0() {
        return new b();
    }

    @NonNull
    private FrameLayout p0(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        FrameLayout frameLayout = new FrameLayout(context);
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(context).s(4).u(HardCodeUtil.qqStr(R.string.f1514017l)).r(true).o(0).a();
        a16.setGravity(17);
        frameLayout.addView(a16, new FrameLayout.LayoutParams(-1, ScreenUtils.getScreenHeight(context) - ScreenUtil.dip2px(180.0f)));
        return frameLayout;
    }

    private View q0(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f_e, viewGroup, false);
        inflate.setPadding(0, ViewUtils.dip2px(16.0f), 0, 0);
        return inflate;
    }

    private void r0() {
        Context context = getParentRecyclerView().getContext();
        if (context == null) {
            return;
        }
        this.D = LayoutInflater.from(context).inflate(R.layout.f1k, (ViewGroup) null, false);
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.C;
        if (guildFeedBaseInitBean != null && guildFeedBaseInitBean.getBusinessType() == 7) {
            ((TextView) this.D.findViewById(R.id.kbr)).setText(R.string.f158051ok);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(this.D);
        getBlockMerger().setCustomNoMoreDataView(frameLayout);
    }

    private void s0() {
        getParentRecyclerView().setClipToPadding(false);
        getParentRecyclerView().setClipChildren(false);
        getParentRecyclerView().setItemAnimator(new GuildScaleInItemAnimator());
        getParentRecyclerView().setHasFixedSize(false);
        getParentRecyclerView().addOnScrollListener(new c());
        r0();
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void addAll(List<v<?>> list) {
        super.addAll(list);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    @SuppressLint({"ResourceAsColor"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            return ((v) this.mDataList.get(i3)).h();
        }
        QLog.d("GuildFeedNoticeListAdapter", 1, "getItemViewType()  return 0");
        return 0;
    }

    @Override // cj1.b
    protected String getLogTag() {
        return "GuildFeedNoticeListAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public String getUniqueKey() {
        return "GUILD_ADAPTER_UNIQUE_KEY";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (ArrayUtils.isOutOfArrayIndex(i3, getDataList())) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        v<?> vVar = getDataList().get(i3);
        ((d) viewHolder).l(vVar, i3, null);
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedNoticeListAdapter", 2, "onBindViewHolder, pos: " + i3 + ", cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (vVar instanceof p) {
            t0(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        FrameLayout frameLayout;
        String guildId;
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 == 1) {
            if (TextUtils.isEmpty(this.C.getGuildId())) {
                guildId = "";
            } else {
                guildId = this.C.getGuildId();
            }
            frameLayout = new GuildManageNoticeItemView(viewGroup.getContext(), i3, guildId, new ui1.b(new a()));
        } else if (i3 == 3) {
            frameLayout = p0(viewGroup);
        } else if (i3 == 5) {
            frameLayout = q0(viewGroup);
        } else if (i3 == 6) {
            frameLayout = n0(viewGroup);
        } else {
            GuildFeedMessageItemView guildFeedMessageItemView = new GuildFeedMessageItemView(viewGroup.getContext(), Integer.valueOf(i3), this.C);
            guildFeedMessageItemView.A0((com.tencent.mobileqq.guild.feed.part.notice.f) yl1.n.s(viewGroup, com.tencent.mobileqq.guild.feed.part.notice.f.class));
            guildFeedMessageItemView.y0(o0());
            guildFeedMessageItemView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            frameLayout = guildFeedMessageItemView;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedNoticeListAdapter", 2, "onCreateViewHolder, cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return new d(frameLayout);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        s0();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedNoticeListAdapter", 2, "onViewAttachedToWindow:" + viewHolder.getAdapterPosition());
        }
        com.tencent.mobileqq.guild.feed.performance.report.g.a("feed_notice_first_item_visible");
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<v<?>> list) {
        this.mDataList.clear();
        if (list == null) {
            notifyDataSetChanged();
        } else {
            this.mDataList.addAll(list);
            notifyItemRangeChanged(0, list.size());
        }
    }

    public void t0(boolean z16) {
        int i3;
        View view = this.D;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public void u0(int i3) {
        if (ArrayUtils.isOutOfArrayIndex(i3, this.mDataList)) {
            return;
        }
        this.mDataList.remove(i3);
        notifyItemRemoved(i3);
    }

    public void v0(x xVar) {
        this.E = xVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List list) {
        a.C11698a c11698a = a.C11698a.f452777a;
        if (list.contains(c11698a)) {
            if (ArrayUtils.isOutOfArrayIndex(i3, getDataList())) {
                return;
            }
            ((d) viewHolder).l(getDataList().get(i3), i3, c11698a);
            return;
        }
        onBindViewHolder(viewHolder, i3);
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements b.InterfaceC11351b {
        a() {
        }

        @Override // ui1.b.InterfaceC11351b
        public void c() {
            SimpleEventBus.getInstance().dispatchEvent(new GuildNoticeClearRedPointEvent(), false);
        }

        @Override // ui1.b.InterfaceC11351b
        public void a() {
        }

        @Override // ui1.b.InterfaceC11351b
        public void b() {
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements GuildSwipeMenuItemHelper.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(int i3) {
            if (i.this.E != null) {
                i.this.E.a(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit g(int i3, boolean z16, GuildSwipeMenuItemHelper guildSwipeMenuItemHelper, View view, ActionSheet actionSheet) {
            return i.this.m0(i3, z16, guildSwipeMenuItemHelper);
        }

        @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
        public void b(@NonNull final GuildSwipeMenuItemHelper guildSwipeMenuItemHelper, @NonNull View view, @NonNull BaseMenuEntry baseMenuEntry, @NonNull View view2, final int i3) {
            if (baseMenuEntry instanceof BaseMenuEntry.b) {
                guildSwipeMenuItemHelper.q();
                i.this.getParentRecyclerView().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.adapter.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.this.f(i3);
                    }
                }, 200L);
            } else if (baseMenuEntry instanceof BaseMenuEntry.c) {
                guildSwipeMenuItemHelper.q();
                final boolean receiveNotification = ((BaseMenuEntry.c) baseMenuEntry).getReceiveNotification();
                if (receiveNotification) {
                    i.this.m0(i3, receiveNotification, guildSwipeMenuItemHelper);
                } else {
                    ui1.e.f439033a.d(i.this.getParentFragment(), baseMenuEntry.g(), new Function2() { // from class: com.tencent.mobileqq.guild.feed.adapter.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit g16;
                            g16 = i.b.this.g(i3, receiveNotification, guildSwipeMenuItemHelper, (View) obj, (ActionSheet) obj2);
                            return g16;
                        }
                    });
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
        public void a(@NonNull GuildSwipeMenuItemHelper guildSwipeMenuItemHelper, @NotNull View view, int i3) {
        }

        @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
        public void c(@NonNull GuildSwipeMenuItemHelper guildSwipeMenuItemHelper, @NotNull View view, int i3) {
        }
    }
}
