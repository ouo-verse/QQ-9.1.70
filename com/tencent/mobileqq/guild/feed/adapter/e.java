package com.tencent.mobileqq.guild.feed.adapter;

import NS_COMM.COMM;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker;
import com.tencent.mobileqq.guild.feed.event.GuildFeedListFirstLoadingEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedBaseItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedLongContentItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedMessageCapsule;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedProgressItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedSingleImageItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedSingleVideoItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedTencentDocItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedThirdVideoItemView;
import com.tencent.mobileqq.guild.feed.widget.GuildSimpleFeedImageItemView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends c {
    private int H;
    private View I;
    private boolean J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
            super(view);
        }

        public void l(ij1.g gVar, int i3) {
            View view = this.itemView;
            if (!(view instanceof BaseWidgetView)) {
                QLog.e("GuildFeedListAdapter", 1, "setData  itemView != BaseItemView");
            } else {
                ((BaseWidgetView) view).setData(gVar, i3);
            }
        }

        public void m(ij1.g gVar, int i3, @NonNull List<Object> list) {
            View view = this.itemView;
            if (!(view instanceof GuildFeedBaseItemView)) {
                QLog.e("GuildFeedListAdapter", 1, "setData  itemView != BaseItemView");
            } else {
                ((GuildFeedBaseItemView) view).setData(gVar, i3, list);
            }
        }

        public void n(int i3) {
            View view = this.itemView;
            if (view instanceof GuildFeedBaseItemView) {
                ((GuildFeedBaseItemView) view).setSortMode(i3);
            }
        }
    }

    public e(GuildFeedMainInitBean guildFeedMainInitBean, int i3) {
        super(guildFeedMainInitBean);
        this.J = false;
        this.H = i3;
    }

    private void A0() {
        NestScrollRecyclerView parentRecyclerView = getParentRecyclerView();
        if (parentRecyclerView == null) {
            QLog.w("GuildFeedListAdapter", 1, "initRecycleView recyclerView=null");
            return;
        }
        parentRecyclerView.setClipToPadding(false);
        parentRecyclerView.setClipChildren(false);
        parentRecyclerView.addOnScrollListener(new a());
        z0();
    }

    private void C0() {
        if (!this.J) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildFeedListAdapter", 2, "notifyFirstLoadPartShowViewDismiss! ");
            }
            this.J = true;
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedListFirstLoadingEvent(true));
        }
    }

    private int w0() {
        if (this.F != null && jj1.b.c().getDataWorker(GuildFeedWorker.class) != null) {
            return ((GuildFeedWorker) jj1.b.c().getDataWorker(GuildFeedWorker.class)).v(this.F.getGuildId(), this.F.getChannelId()).size();
        }
        return 0;
    }

    private GuildFeedDefaultInitBean y0() {
        GuildFeedDefaultInitBean guildFeedDefaultInitBean = new GuildFeedDefaultInitBean();
        guildFeedDefaultInitBean.setBusinessType(this.H);
        GuildFeedMainInitBean guildFeedMainInitBean = this.F;
        if (guildFeedMainInitBean != null) {
            if (this.H == 7) {
                guildFeedDefaultInitBean.setTroopRole(guildFeedMainInitBean.getTroopRole());
                guildFeedDefaultInitBean.setTroopUin(this.F.getTroopUin());
                guildFeedDefaultInitBean.setGuildId(this.F.getGuildId());
                guildFeedDefaultInitBean.setChannelId(this.F.getChannelId());
            } else {
                guildFeedDefaultInitBean.setGuildId(guildFeedMainInitBean.getGuildId());
                guildFeedDefaultInitBean.setChannelId(this.F.getChannelId());
            }
            if (this.F.getJoinInfoParam() != null && this.F.getJoinInfoParam().isValid()) {
                guildFeedDefaultInitBean.setJoinInfoParam(this.F.getJoinInfoParam());
            }
            guildFeedDefaultInitBean.setShareSource(this.F.getShareSource());
        }
        return guildFeedDefaultInitBean;
    }

    private void z0() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.epa, (ViewGroup) null, false);
        this.I = inflate;
        View findViewById = inflate.findViewById(R.id.zel);
        if (QQTheme.isNowThemeIsNight()) {
            findViewById.setBackgroundColor(context.getResources().getColor(R.color.bnk));
        } else {
            findViewById.setBackgroundColor(context.getResources().getColor(R.color.bnl));
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(this.I);
        getBlockMerger().setCustomNoMoreDataView(frameLayout);
    }

    public void D0(boolean z16) {
        int i3;
        View view = this.I;
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

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void addAll(List<ij1.g> list) {
        super.addAll(list);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public List<ij1.g> getDataList() {
        return super.getDataList();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (getDataList() == null) {
            return 0;
        }
        return getDataList().size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    @SuppressLint({"ResourceAsColor"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int dip2px;
        super.getItemOffsets(rect, view, recyclerView, state);
        if (!(view instanceof GuildFeedBaseItemView)) {
            return;
        }
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        int w06 = w0();
        if (childViewHolder != null && childViewHolder.getItemViewType() == 9999) {
            if (childLayoutPosition == w06) {
                dip2px = 0;
            } else {
                dip2px = ViewUtils.dip2px(12.0f);
            }
            rect.bottom = dip2px;
        }
        if (w06 > 0 && childLayoutPosition == w06 + 1) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dip2px(-8.0f);
            view.setLayoutParams(layoutParams);
        }
        QLog.d("GuildFeedListAdapter", 4, "getItemOffsets, position offset " + getPositionOffsetStart() + ", globalPosition " + childLayoutPosition + ", rect: " + rect);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (getDataList() != null && i3 >= 0 && i3 < getDataList().size()) {
            ij1.g gVar = getDataList().get(i3);
            if (gVar.p() != null) {
                return 9999;
            }
            if (gVar.n() != null) {
                return COMM.hexlog;
            }
            int i16 = gVar.b().feedType;
            if (i16 != 2) {
                int i17 = gVar.b().summary.layoutType;
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 != 5) {
                            if (i17 == 7) {
                                return 1004;
                            }
                        } else {
                            return 1003;
                        }
                    } else {
                        return 1002;
                    }
                } else {
                    return 1001;
                }
            }
            return i16;
        }
        return 0;
    }

    @Override // cj1.b
    protected String getLogTag() {
        return "GuildFeedListAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public String getUniqueKey() {
        return "GUILD_ADAPTER_UNIQUE_KEY";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (ArrayUtils.isOutOfArrayIndex(i3, getDataList())) {
            return;
        }
        ij1.g gVar = getDataList().get(i3);
        b bVar = (b) viewHolder;
        bVar.n(GuildInfoManager.q().x(this.F));
        bVar.l(gVar, i3);
        QLog.d("GuildFeedListAdapter", 1, "onBindViewHolder() position:" + i3 + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        QLog.d("GuildFeedListAdapter", 1, "onCreateViewHolder() viewType:" + i3);
        return new b(v0(viewGroup, i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onDrawItemDecoration(Canvas canvas, RecyclerView recyclerView, View view, RecyclerView.State state) {
        super.onDrawItemDecoration(canvas, recyclerView, view, state);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        A0();
    }

    @Override // cj1.a, com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedListAdapter", 2, "onViewAttachedToWindow:" + viewHolder.getAdapterPosition());
        }
        C0();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void setGlobalPositionOffset(int i3) {
        super.setGlobalPositionOffset(i3);
    }

    protected View v0(ViewGroup viewGroup, int i3) {
        QLog.d("GuildFeedListAdapter", 1, "createFeedItem viewType:" + i3);
        GuildFeedDefaultInitBean y06 = y0();
        if (i3 != 2) {
            if (i3 != 9999) {
                if (i3 != 11111) {
                    switch (i3) {
                        case 1001:
                            return new GuildFeedSingleImageItemView(viewGroup.getContext(), i3, y06);
                        case 1002:
                            return new GuildFeedSingleVideoItemView(viewGroup.getContext(), i3, y06);
                        case 1003:
                            return new GuildFeedThirdVideoItemView(viewGroup.getContext(), i3, y06);
                        case 1004:
                            return new GuildFeedTencentDocItemView(viewGroup.getContext(), i3, y06);
                        default:
                            return new GuildSimpleFeedImageItemView(viewGroup.getContext(), i3, y06);
                    }
                }
                return new GuildFeedMessageCapsule(viewGroup.getContext(), i3, y06);
            }
            return new GuildFeedProgressItemView(viewGroup.getContext(), Integer.valueOf(i3));
        }
        return new GuildFeedLongContentItemView(viewGroup.getContext(), Integer.valueOf(i3), y06);
    }

    public boolean x0() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List list) {
        long currentTimeMillis = System.currentTimeMillis();
        if (ArrayUtils.isOutOfArrayIndex(i3, getDataList())) {
            return;
        }
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i3);
            return;
        }
        ((b) viewHolder).m(getDataList().get(i3), i3, list);
        QLog.d("GuildFeedListAdapter", 1, "onBindViewHolderWithPayloads() position:" + i3 + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void B0() {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
