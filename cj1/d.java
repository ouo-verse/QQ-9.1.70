package cj1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedTopView;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import ij1.h;
import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d extends e implements GuildFeedTopView.a, j, IDataDisplaySurface<h> {
    private GuildFeedListViewModel E;
    private List<h> F;
    private GuildFeedTopView G;
    private long H;

    public d(GuildFeedMainInitBean guildFeedMainInitBean) {
        super(guildFeedMainInitBean);
        this.F = new ArrayList();
        this.H = 0L;
    }

    private void m0(@NonNull h hVar) {
        GuildFeedDetailInitBean initFeedDetailInitBeanFromFeedTop = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeedTop(this.C.getGuildId(), this.C.getChannelId(), hVar);
        s0(initFeedDetailInitBeanFromFeedTop);
        initFeedDetailInitBeanFromFeedTop.setImmersiveSource(mk1.e.f(this.C, GuildInfoManager.q().x(this.C)));
        GuildFeedLauncher.w(this.G.getContext(), initFeedDetailInitBeanFromFeedTop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void p0(UIStateData<List<h>> uIStateData) {
        if (uIStateData.isLoading()) {
            return;
        }
        q0(System.currentTimeMillis());
        List<h> data = uIStateData.getData();
        if (data == null) {
            QLog.e("GuildFeedTopBlock", 1, "handlerUiStatus: feedTopDataList is null!");
            data = new ArrayList<>();
        }
        QLog.d("GuildFeedTopBlock", 1, "handlerUiStatus: size[" + data.size() + "]");
        this.F.clear();
        this.F.addAll(data);
        GuildFeedTopView guildFeedTopView = this.G;
        if (guildFeedTopView != null) {
            guildFeedTopView.setFeedTopListData(this.F);
            return;
        }
        QLog.e("GuildFeedTopBlock", 1, "setTopDataList: size[" + this.F.size() + "], but mFeedTopHeaderView is null! ");
    }

    private void o0() {
        GuildFeedListViewModel guildFeedListViewModel = (GuildFeedListViewModel) getViewModel(GuildFeedListViewModel.class);
        this.E = guildFeedListViewModel;
        guildFeedListViewModel.r2(this.C);
        this.E.Z1().observeForever(new Observer() { // from class: cj1.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.p0((UIStateData) obj);
            }
        });
        jj1.b.c().registerDisplaySurface(jj1.b.d(this.C.getGuildId(), ""), this);
    }

    private void s0(GuildFeedDetailInitBean guildFeedDetailInitBean) {
        guildFeedDetailInitBean.setFromPage(1);
        guildFeedDetailInitBean.setBusinessType(this.C.getBusinessType());
        guildFeedDetailInitBean.setIsMember(true ^ ch.j0(guildFeedDetailInitBean.getGuildId()));
        if (this.C.getJoinInfoParam() != null) {
            guildFeedDetailInitBean.setJoinInfoParam(this.C.getJoinInfoParam());
        }
        guildFeedDetailInitBean.setTroopUin(this.C.getTroopUin());
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j
    /* renamed from: G0 */
    public long getLastUpdatedTime() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j
    public void Y(@NonNull String str, @NonNull String str2, long j3) {
        if (str.equals(this.C.getGuildId())) {
            this.H = j3;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildFeedTopView.a
    public void b0(h hVar) {
        if (hVar == null) {
            return;
        }
        QLog.d("GuildFeedTopBlock", 4, "onFeedTopItemClicked: feedId[" + hVar.f407814h + "]");
        m0(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cj1.e
    /* renamed from: createBlockRootView, reason: merged with bridge method [inline-methods] */
    public BaseWidgetView k0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QLog.e("GuildFeedTopBlock", 4, "[createBlockRootView] cacheTopList " + this.F.size());
        GuildFeedTopView guildFeedTopView = new GuildFeedTopView(viewGroup.getContext());
        this.G = guildFeedTopView;
        guildFeedTopView.setOnFeedTopItemClickListener(this);
        this.G.setFeedTopListData(this.F);
        return this.G;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<h>>> getDisplaySurfaceData(Object... objArr) {
        if (objArr != null && objArr.length > 0 && !this.C.getGuildId().equals(objArr[0])) {
            return null;
        }
        return this.E.Z1();
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // cj1.e, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedThemeChangeEvent.class);
        return arrayList;
    }

    @Override // co1.h
    @NonNull
    /* renamed from: getIdentifier */
    public String getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String() {
        return this.C.getGuildId() + util.base64_pad_url + hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return 7000;
    }

    @Override // cj1.b
    protected String getLogTag() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        QLog.d("GuildFeedTopBlock", 4, "[onBindViewHolder] position " + i3 + ", size: " + this.F.size() + ", mFeedTopHeaderView: " + this.G);
        View view = viewHolder.itemView;
        if (!(view instanceof GuildFeedTopView)) {
            QLog.e("GuildFeedTopBlock", 1, "itemView is not GuildFeedTopView: " + view);
            return;
        }
        GuildFeedTopView guildFeedTopView = this.G;
        if (guildFeedTopView == null) {
            QLog.e("GuildFeedTopBlock", 1, "onBindViewHolder: size[" + this.F.size() + "], but mFeedTopHeaderView is null! " + view);
            GuildFeedTopView guildFeedTopView2 = (GuildFeedTopView) view;
            this.G = guildFeedTopView2;
            guildFeedTopView2.setParentView(getRecyclerView());
            this.G.setOnFeedTopItemClickListener(this);
            this.G.setFeedTopListData(this.F);
            return;
        }
        guildFeedTopView.setParentView(getRecyclerView());
        this.G.setOnFeedTopItemClickListener(this);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        o0();
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.d("GuildFeedTopBlock", 4, "onPartResume: ");
    }

    @Override // cj1.e, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedThemeChangeEvent) {
            r0();
        }
    }

    public void q0(long j3) {
        this.H = j3;
    }

    private void r0() {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
    }
}
