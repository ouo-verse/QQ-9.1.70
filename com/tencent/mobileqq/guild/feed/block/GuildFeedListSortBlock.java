package com.tencent.mobileqq.guild.feed.block;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import cj1.e;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.viewmodel.j;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.guild.feed.widget.sort.GuildFeedListSortViewController;
import com.tencent.mobileqq.guild.feed.widget.sort.f;
import com.tencent.mobileqq.guild.feed.widget.sort.g;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedListSortBlock extends e {
    private GuildFeedListInnerSortWidget E;
    private j F;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class GuildFeedListInnerSortWidget extends GuildBaseWidgetView {

        /* renamed from: d, reason: collision with root package name */
        private g f218325d;

        /* renamed from: e, reason: collision with root package name */
        private GuildFeedMainInitBean f218326e;

        /* renamed from: f, reason: collision with root package name */
        private int f218327f;

        public GuildFeedListInnerSortWidget(@NonNull Context context, @NonNull BasePartFragment basePartFragment, j jVar) {
            super(context);
            o0(basePartFragment);
            k0(context, basePartFragment, jVar);
        }

        private void k0(@NonNull Context context, @NonNull BasePartFragment basePartFragment, j jVar) {
            m0();
            l0(context);
            n0(basePartFragment, jVar);
        }

        private void l0(Context context) {
            View view;
            if (getLayoutPreLoader() != null) {
                view = getLayoutPreLoader().getPreloadView(context, this.f218327f, false);
            } else {
                view = null;
            }
            if (view != null) {
                QLog.d("BaseWidgetView", 1, "get preInflate view success layoutId:" + getClass().getSimpleName() + " hashCode:" + hashCode());
                addView(view, getPreLoadLayoutParams());
            } else {
                LayoutInflater.from(context).inflate(this.f218327f, (ViewGroup) this, true);
            }
            setLayoutParams(getPreLoadLayoutParams());
        }

        private void m0() {
            GuildFeedMainInitBean guildFeedMainInitBean = this.f218326e;
            if (guildFeedMainInitBean != null && guildFeedMainInitBean.getBusinessType() == 7) {
                this.f218325d = new f();
                this.f218327f = R.layout.err;
            } else {
                this.f218325d = new GuildFeedListSortViewController();
                this.f218327f = R.layout.epe;
            }
        }

        private void o0(Fragment fragment) {
            GuildFeedBaseInitBean o16 = ax.o(fragment);
            if (o16 instanceof GuildFeedMainInitBean) {
                this.f218326e = (GuildFeedMainInitBean) o16;
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
        public int getLayoutId() {
            return 0;
        }

        public void n0(@NonNull BasePartFragment basePartFragment, j jVar) {
            this.f218325d.b2(jVar);
            this.f218325d.N7(this, this.f218326e);
        }

        @Override // com.tencent.biz.richframework.widget.BaseWidgetView
        public void release() {
            super.release();
            setParentView(null);
            this.f218325d.destroy();
        }

        public void updateView() {
            this.f218325d.updateView();
        }
    }

    public GuildFeedListSortBlock(GuildFeedMainInitBean guildFeedMainInitBean) {
        super(guildFeedMainInitBean);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cj1.e
    /* renamed from: createBlockRootView, reason: merged with bridge method [inline-methods] */
    public BaseWidgetView k0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QLog.e("Guild_Feed_GuildFeedListSortBlock", 1, "[createBlockRootView]");
        BasePartFragment basePartFragment = (BasePartFragment) getParentFragment();
        this.F = (j) basePartFragment.getViewModel(j.class);
        GuildFeedListInnerSortWidget guildFeedListInnerSortWidget = new GuildFeedListInnerSortWidget(viewGroup.getContext(), basePartFragment, this.F);
        this.E = guildFeedListInnerSortWidget;
        guildFeedListInnerSortWidget.setParentView(viewGroup);
        return this.E;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return 8000;
    }

    @Override // cj1.b
    protected String getLogTag() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        QLog.e("Guild_Feed_GuildFeedListSortBlock", 1, "[onBindViewHolder] position " + i3 + ", mFeedTopHeaderView: " + this.E);
        if (this.E == null && (viewHolder.itemView instanceof GuildFeedListInnerSortWidget) && (getParentFragment() instanceof GuildBasePartFragment)) {
            GuildFeedListInnerSortWidget guildFeedListInnerSortWidget = (GuildFeedListInnerSortWidget) viewHolder.itemView;
            this.E = guildFeedListInnerSortWidget;
            guildFeedListInnerSortWidget.setParentView(getRecyclerView());
        } else {
            GuildFeedListInnerSortWidget guildFeedListInnerSortWidget2 = this.E;
            if (guildFeedListInnerSortWidget2 != null) {
                guildFeedListInnerSortWidget2.updateView();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
