package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.adapter.d;
import com.tencent.mobileqq.guild.feed.block.GuildFeedListSortBlock;
import com.tencent.mobileqq.guild.feed.event.GuildEmptyPartEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedListFirstLoadingEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedMoveEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedPublishPartEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShowBubbleEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSortModeChangeEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedPublishSuccessEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager;
import com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel;
import com.tencent.mobileqq.guild.feed.widget.GuildBlockContainer;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedStatusView;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowHandler;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCustomManageTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedListContainer extends BlockPart implements SimpleEventReceiver, GuildFeedStatusView.a {
    protected GuildFeedListViewModel C;
    private com.tencent.mobileqq.guild.feed.viewmodel.j D;
    private GuildFeedStatusView E;
    protected Observer<UIStateData<List<ij1.g>>> F;
    private String G;
    private GPServiceObserver H;

    /* renamed from: d, reason: collision with root package name */
    private GuildFeedMainInitBean f222443d;

    /* renamed from: e, reason: collision with root package name */
    protected cj1.d f222444e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.mobileqq.guild.feed.adapter.e f222445f;

    /* renamed from: h, reason: collision with root package name */
    protected GuildFeedListSortBlock f222446h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.guild.feed.adapter.h f222447i;

    /* renamed from: m, reason: collision with root package name */
    private int f222448m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.part.GuildFeedListContainer$7, reason: invalid class name */
    /* loaded from: classes13.dex */
    class AnonymousClass7 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f222454d;
        final /* synthetic */ GuildFeedListContainer this$0;

        @Override // java.lang.Runnable
        public void run() {
            GuildEventFlowHandler guildEventFlowHandler = (GuildEventFlowHandler) ((BaseQQAppInterface) this.f222454d).getBusinessHandler(GuildEventFlowHandler.class.getName());
            guildEventFlowHandler.F2(this.this$0.f222443d.getGuildId(), this.this$0.f222443d.getChannelId(), false);
            guildEventFlowHandler.G2(this.this$0.f222443d.getGuildId(), this.this$0.f222443d.getChannelId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState()) {
                GuildFeedListContainer.this.X9();
            } else if (loadInfo.isRefreshState()) {
                GuildFeedListContainer guildFeedListContainer = GuildFeedListContainer.this;
                guildFeedListContainer.la(false, guildFeedListContainer.H9(), true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            f12.d.f397604d.i("article_list", i3);
            if (i3 == 0) {
                d.Companion companion = com.tencent.mobileqq.guild.feed.adapter.d.INSTANCE;
                companion.c(GuildFeedListContainer.this.f222447i.getPositionOffsetStart());
                companion.e(GuildFeedListContainer.this.f222445f.getViewTypeOffsetStart());
                companion.d(GuildFeedListContainer.this.f222447i.getViewTypeOffsetStart());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            MultiViewBlock multiViewBlock;
            int i17 = 0;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
            if (GuildFeedListContainer.this.f222447i.getMIsBlockVisible()) {
                multiViewBlock = GuildFeedListContainer.this.f222447i;
            } else {
                multiViewBlock = GuildFeedListContainer.this.f222445f;
            }
            if (childAdapterPosition < multiViewBlock.getPositionOffsetStart() - 1) {
                i17 = 8;
            }
            GuildFeedListContainer.this.broadcastMessage("action_set_sticker_sort_tools", Integer.valueOf(i17));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(String str, String str2) {
            super.onMemberTopRoleChanged(str, str2);
            GuildFeedListContainer.this.ra(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f222458d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f222459e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f222460f;

        d(RecyclerView recyclerView, int i3, int i16) {
            this.f222458d = recyclerView;
            this.f222459e = i3;
            this.f222460f = i16;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f222458d.getChildCount() > 0) {
                this.f222458d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                GuildFeedListContainer.this.oa(this.f222458d, this.f222459e, this.f222460f);
            }
        }
    }

    public GuildFeedListContainer(int i3) {
        super(i3);
        this.f222448m = 0;
        this.F = new Observer() { // from class: com.tencent.mobileqq.guild.feed.part.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedListContainer.this.W9((UIStateData) obj);
            }
        };
    }

    private void D9() {
        if (this.H == null) {
            this.H = E9();
            ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.H);
        }
    }

    private GPServiceObserver E9() {
        return new c();
    }

    private void I9(UIStateData<List<ij1.g>> uIStateData) {
        if (this.f222445f == null) {
            QLog.e(getTAG(), 1, "handleEmptyRsp feed adapter is null!");
            return;
        }
        aa();
        this.f222445f.notifyLoadingComplete(true, uIStateData.getIsFinish());
        boolean isLoadMore = uIStateData.getIsLoadMore();
        QLog.e(getTAG(), 1, "handleEmpty isLoadMore: " + isLoadMore);
        if (!isLoadMore) {
            Y9(true);
            ca(false);
            this.f222445f.u0(new ArrayList(), true, null);
        } else if (R9()) {
            this.f222445f.getLoadInfo().setFinish(uIStateData.getIsFinish());
        }
    }

    private void K9(final UIStateData<List<ij1.g>> uIStateData) {
        if (uIStateData.getState() == 8) {
            Y9(false);
            getBlockContainer().getRecyclerView().scrollToPosition(0);
        } else if (uIStateData.getState() == 6 && bl.b(uIStateData.getData())) {
            Y9(true);
        }
        this.f222445f.u0(uIStateData.getData(), true, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedListContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (uIStateData.getState() == 8) {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedListContainer.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GuildFeedListContainer.this.scrollToTop();
                        }
                    }, 10L);
                }
            }
        });
    }

    private void M9(UIStateData<List<ij1.g>> uIStateData) {
        com.tencent.mobileqq.guild.feed.adapter.e eVar = this.f222445f;
        if (eVar == null) {
            QLog.e(getTAG(), 1, "handlePageCacheRsp feed adapter is null!");
            return;
        }
        eVar.notifyLoadingComplete(true, uIStateData.getIsFinish());
        this.f222445f.u0((ArrayList) uIStateData.getData(), true, null);
        this.f222445f.B0();
        this.f222445f.getLoadInfo().setFinish(uIStateData.getIsFinish());
        na(uIStateData.getPos(), uIStateData.getTop());
    }

    private void N9(int i3) {
        la(false, i3, true);
    }

    private void O9(UIStateData<List<ij1.g>> uIStateData) {
        if (!uIStateData.getIsLoadMore() && uIStateData.getState() == 3) {
            ma();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P9, reason: merged with bridge method [inline-methods] */
    public void W9(UIStateData<List<ij1.g>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int x16 = GuildInfoManager.q().x(G9());
        if (uIStateData.getType() != x16) {
            QLog.d("Guild_Feed_GuildFeedListContainer", 1, "handlerUiStatus: is not valid data, newType: " + uIStateData.getType() + ", currentType: " + x16);
            return;
        }
        if (uIStateData.isCacheData() && this.f222447i.getMIsBlockVisible()) {
            QLog.d("Guild_Feed_GuildFeedListContainer", 1, "handlerUiStatus: cache data already show!");
            return;
        }
        if (uIStateData.getState() != 1) {
            this.f222447i.S0(false);
        }
        int state = uIStateData.getState();
        if (state != 0) {
            switch (state) {
                case 2:
                case 3:
                    L9(uIStateData);
                    return;
                case 4:
                    J9(uIStateData);
                    return;
                case 5:
                    M9(uIStateData);
                    return;
                case 6:
                case 7:
                case 8:
                    K9(uIStateData);
                    return;
                default:
                    return;
            }
        }
        I9(uIStateData);
    }

    private boolean Q9() {
        com.tencent.mobileqq.guild.feed.adapter.e eVar = this.f222445f;
        if (eVar != null && eVar.x0()) {
            return true;
        }
        return false;
    }

    private boolean R9() {
        com.tencent.mobileqq.guild.feed.adapter.e eVar = this.f222445f;
        if (eVar != null && eVar.getNUM_BACKGOURND_ICON() > 0) {
            return true;
        }
        return false;
    }

    private boolean S9(String str, String str2) {
        GuildFeedMainInitBean guildFeedMainInitBean = this.f222443d;
        if (guildFeedMainInitBean == null || TextUtils.isEmpty(guildFeedMainInitBean.getGuildId()) || TextUtils.isEmpty(this.f222443d.getChannelId()) || !this.f222443d.getGuildId().equals(str) || !this.f222443d.getChannelId().equals(str2)) {
            return false;
        }
        return true;
    }

    private void U9(List<ij1.g> list) {
        Iterator<ij1.g> it = list.iterator();
        while (it.hasNext()) {
            GProStFeed b16 = it.next().b();
            if (this.G.contains(b16.idd)) {
                QLog.d("Guild_Feed_GuildFeedListContainer", 1, "feedDetailParam mJumpId =" + this.G);
                GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(b16);
                initFeedDetailInitBeanFromFeed.setIsMember(ch.j0(initFeedDetailInitBeanFromFeed.getGuildId()) ^ true);
                String[] split = this.G.split(",");
                if (split.length > 2) {
                    initFeedDetailInitBeanFromFeed.setCommentId(split[1]);
                    initFeedDetailInitBeanFromFeed.setReplyId(split[2]);
                } else if (split.length > 1) {
                    initFeedDetailInitBeanFromFeed.setCommentId(split[1]);
                }
                initFeedDetailInitBeanFromFeed.setImmersiveSource(mk1.e.f(this.f222443d, GuildInfoManager.q().x(this.f222443d)));
                GuildFeedLauncher.w(getActivity(), initFeedDetailInitBeanFromFeed);
                this.G = null;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V9(Integer num) {
        int x16 = GuildInfoManager.q().x(this.f222443d);
        QLog.d("Guild_Feed_GuildFeedListContainer", 1, "[onSortModeChanged] cur: " + x16 + ", newMode: " + num);
        if (x16 != num.intValue()) {
            GuildInfoManager.q().f0(this.f222443d, num.intValue());
            N9(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9() {
        this.C.n(H9());
        QLog.d("Guild_Feed_GuildFeedListContainer", 1, "trigger loader more");
    }

    private void Y9(boolean z16) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildEmptyPartEvent(z16));
        com.tencent.mobileqq.guild.feed.adapter.e eVar = this.f222445f;
        if (eVar != null) {
            eVar.D0(!z16);
        }
    }

    private void Z9(long j3, String str) {
        if (ax.F(j3)) {
            Y9(false);
            ca(false);
        } else if (!R9() && !Q9()) {
            Y9(false);
            ca(false);
        } else {
            bn.k(str);
        }
    }

    private void aa() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedListFirstLoadingEvent(true));
    }

    private void ca(boolean z16) {
        GuildFeedMainInitBean G9 = G9();
        if (G9 != null) {
            da(z16, sz1.d.k(G9.getGuildId(), G9.getChannelId()));
        }
    }

    private void da(boolean z16, boolean z17) {
        GuildFeedMainInitBean G9 = G9();
        if (G9 != null) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedPublishPartEvent(G9.getChannelId(), z16, z17));
        }
    }

    private void ea(String str) {
        if (com.tencent.mobileqq.text.TextUtils.isAllSystemEmotcation(str)) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedShowBubbleEvent(str));
    }

    private void ga() {
        ia();
        ha();
        ja();
    }

    private void ha() {
        GuildFeedListSortBlock guildFeedListSortBlock = new GuildFeedListSortBlock(this.f222443d);
        this.f222446h = guildFeedListSortBlock;
        this.mPeerBlocks.add(guildFeedListSortBlock);
    }

    private void ia() {
        cj1.d dVar = new cj1.d(this.f222443d);
        this.f222444e = dVar;
        this.mPeerBlocks.add(dVar);
    }

    private void initPageBean() {
        GuildFeedBaseInitBean o16 = ax.o(getHostFragment());
        if (o16 instanceof GuildFeedMainInitBean) {
            this.f222443d = (GuildFeedMainInitBean) o16;
            QLog.d(getTAG(), 1, "getInitBeanSuccess:" + this.f222443d);
        }
    }

    private void initViewModel() {
        GuildFeedListViewModel guildFeedListViewModel = (GuildFeedListViewModel) getViewModel(GuildFeedListViewModel.class);
        this.C = guildFeedListViewModel;
        if (guildFeedListViewModel == null) {
            return;
        }
        guildFeedListViewModel.r2(G9());
        jj1.b.c().registerDisplaySurface(jj1.b.d(G9().getGuildId(), G9().getChannelId()), this.C);
        this.C.j().observe(getHostFragment(), this.F);
        com.tencent.mobileqq.guild.feed.viewmodel.j jVar = (com.tencent.mobileqq.guild.feed.viewmodel.j) getViewModel(com.tencent.mobileqq.guild.feed.viewmodel.j.class);
        this.D = jVar;
        jVar.L1().observeForever(new Observer() { // from class: com.tencent.mobileqq.guild.feed.part.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedListContainer.this.V9((Integer) obj);
            }
        });
    }

    private void ja() {
        com.tencent.mobileqq.guild.feed.adapter.h hVar = new com.tencent.mobileqq.guild.feed.adapter.h(this.f222443d);
        this.f222447i = hVar;
        this.mPeerBlocks.add(hVar);
        GuildFeedMainInitBean guildFeedMainInitBean = this.f222443d;
        com.tencent.mobileqq.guild.feed.adapter.e eVar = new com.tencent.mobileqq.guild.feed.adapter.e(guildFeedMainInitBean, guildFeedMainInitBean.getBusinessType());
        this.f222445f = eVar;
        eVar.setOnLoadDataDelegate(new a());
        this.mPeerBlocks.add(this.f222445f);
    }

    private void ma() {
        if (this.f222443d == null) {
            QLog.d("Guild_Feed_GuildFeedListContainer", 1, "reportFeedRead mInitBean is null return");
            return;
        }
        AppRuntime m3 = ax.m(getContext());
        if (!(m3 instanceof BaseQQAppInterface)) {
            QLog.d("Guild_Feed_GuildFeedListContainer", 1, "reportFeedRead appRuntime is null return");
        } else {
            ((IGuildUnreadService) m3.getRuntimeService(IGuildUnreadService.class, "")).setChannelRead(this.f222443d.getGuildId(), new ArrayList(Collections.singletonList(this.f222443d.getChannelId())), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(this.f222443d.getGuildId())) {
            IGProGuildRoleInfo memberTopRole = ((IGPSService) ch.R0(IGPSService.class)).getMemberTopRole(str, this.f222443d.getChannelId(), str2, "0", 1);
            Iterator<ij1.g> it = this.f222445f.getDataList().iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                GProStFeed b16 = it.next().b();
                if (b16.poster.idd.equals(str2)) {
                    GProCustomManageTag gProCustomManageTag = b16.poster.manageTag;
                    String str3 = gProCustomManageTag.tagName;
                    int i3 = gProCustomManageTag.color;
                    if (memberTopRole != null && str3.equals(memberTopRole.getDisplayTagName()) && i3 == memberTopRole.getColor()) {
                        break;
                    }
                    if (memberTopRole == null) {
                        gProCustomManageTag.tagName = "";
                        gProCustomManageTag.color = 0;
                    } else {
                        if (TextUtils.isEmpty(memberTopRole.getDisplayTagName())) {
                            gProCustomManageTag.tagName = "";
                        } else {
                            gProCustomManageTag.tagName = memberTopRole.getDisplayTagName();
                        }
                        gProCustomManageTag.color = memberTopRole.getColor();
                    }
                    z16 = true;
                }
            }
            if (z16) {
                this.f222445f.notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart
    /* renamed from: F9, reason: merged with bridge method [inline-methods] */
    public GuildBlockContainer getBlockContainer() {
        return (GuildBlockContainer) super.getBlockContainer();
    }

    GuildFeedMainInitBean G9() {
        if (this.f222443d == null) {
            initPageBean();
        }
        return this.f222443d;
    }

    public int H9() {
        return GuildInfoManager.q().x(this.f222443d);
    }

    protected void J9(UIStateData<List<ij1.g>> uIStateData) {
        String msg2;
        if (uIStateData.getMsg() == null) {
            msg2 = HardCodeUtil.qqStr(R.string.f144610p9);
        } else {
            msg2 = uIStateData.getMsg();
        }
        QLog.e(getTAG(), 1, "handleFeedDataRsp() return error\uff01errMsg:" + msg2);
        com.tencent.mobileqq.guild.feed.adapter.e eVar = this.f222445f;
        if (eVar == null) {
            QLog.e(getTAG(), 1, "handleErrorRsp feed adapter is null!");
            return;
        }
        eVar.notifyLoadingComplete(true, uIStateData.getIsFinish());
        aa();
        Z9(uIStateData.getRetCode(), msg2);
    }

    protected void L9(UIStateData<List<ij1.g>> uIStateData) {
        if (this.f222445f == null) {
            QLog.e(getTAG(), 1, "handleNetSuccessRsp: feed adapter is null!");
            return;
        }
        if (uIStateData.getState() == 2) {
            QLog.d(getTAG(), 1, "handleNetSuccessRsp: load data from cache");
            uIStateData.setMsg("");
        }
        GuildFeedStatusView guildFeedStatusView = this.E;
        if (guildFeedStatusView != null) {
            guildFeedStatusView.setVisibility(8);
            this.E.l0();
        }
        if (uIStateData.getData() == null) {
            uIStateData.setDataList(Collections.emptyList());
        }
        QLog.e(getTAG(), 1, "handleNetSuccessRsp: uiStateData.getData()" + uIStateData.getData().size());
        if (uIStateData.getIsLoadMore()) {
            this.f222445f.u0(uIStateData.getData(), false, null);
        } else {
            Y9(false);
            ca(true);
            ea(uIStateData.getMsg());
        }
        if (uIStateData.getState() == 3) {
            QLog.d(getTAG(), 1, "handleNetSuccessRsp: finish[" + uIStateData.getIsFinish() + "]");
            if (this.f222443d.getBusinessType() != 7) {
                O9(uIStateData);
            }
        }
        pa(uIStateData);
    }

    protected boolean T9() {
        return com.tencent.mobileqq.guild.feed.util.f.b(this.f222443d.getBusinessType());
    }

    public void ba(boolean z16) {
        com.tencent.mobileqq.guild.feed.adapter.e eVar = this.f222445f;
        if (eVar != null) {
            eVar.l0(z16);
        }
        com.tencent.mobileqq.guild.feed.adapter.h hVar = this.f222447i;
        if (hVar != null) {
            hVar.l0(z16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedSortModeChangeEvent.class);
        arrayList.add(GuildFeedPublishSuccessEvent.class);
        arrayList.add(GuildFeedMoveEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "Guild_Feed_GuildFeedListContainer";
    }

    public void la(boolean z16, int i3, boolean z17) {
        com.tencent.mobileqq.guild.feed.viewmodel.j jVar;
        if (this.C != null && this.f222445f != null) {
            GuildFeedVideoPlayParamManager.f223979d.a();
            if (z17) {
                qa();
            }
            if (!TextUtils.isEmpty(this.G) && (jVar = this.D) != null) {
                i3 = ax.f223858e;
                jVar.L1().postValue(Integer.valueOf(i3));
            }
            this.C.p2(z16, i3);
            this.f222445f.o0();
            QLog.d("Guild_Feed_GuildFeedListContainer", 1, "trigger refresh enableCache:" + z16 + " " + i3 + ", showHeadRefresh: " + z17);
        }
    }

    protected void na(int i3, int i16) {
        QLog.d(getTAG(), 1, "resumePageCachePosition pos:", Integer.valueOf(i3), ",top:", Integer.valueOf(i16));
        NestScrollRecyclerView recyclerView = getBlockContainer().getRecyclerView();
        if (recyclerView != null) {
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new d(recyclerView, i3, i16));
        }
    }

    public void oa(RecyclerView recyclerView, int i3, int i16) {
        try {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof SafeStaggeredGridLayoutManager) {
                ((SafeStaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i16);
            }
        } catch (Exception e16) {
            QLog.e(getTAG(), 1, "scrollToPosWithOffset exception:" + e16.toString());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f222445f.notifyDataSetChanged();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        getBlockContainer().setEnableRefresh(true);
        getBlockContainer().setEnableLoadMore(true);
        getBlockContainer().setLayoutManagerType(1, 1);
        getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        getBlockContainer().getBlockMerger().setNoMoreHint(getContext().getResources().getString(R.string.f144670pe));
        ai.c(this);
        GuildFeedStatusView guildFeedStatusView = new GuildFeedStatusView(getContext());
        this.E = guildFeedStatusView;
        guildFeedStatusView.setRefreshListener(this);
        getBlockContainer().setStatusViewInterface(this.E);
        NestScrollRecyclerView recyclerView = getBlockContainer().getRecyclerView();
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new b());
        if (!T9()) {
            D9();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f222448m = DisplayUtil.getScreenHeight();
        initPageBean();
        initViewModel();
        ga();
        GuildFeedMainInitBean guildFeedMainInitBean = this.f222443d;
        if (guildFeedMainInitBean != null && !TextUtils.isEmpty(guildFeedMainInitBean.getChannelId())) {
            GuildInfoManager.q().m(this.f222443d.getChannelId());
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.C.j().removeObserver(this.F);
        this.E.setRefreshListener(null);
        this.mParentView = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (!T9() && this.H != null) {
            ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.H);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QLog.i("Guild_Feed_GuildFeedListContainer", 4, "onReceiveEvent: event[" + simpleBaseEvent.getClass().getSimpleName() + "]");
        if (simpleBaseEvent instanceof GuildFeedSortModeChangeEvent) {
            int geSortMode = ((GuildFeedSortModeChangeEvent) simpleBaseEvent).geSortMode();
            if (geSortMode != 3 && geSortMode != 2) {
                return;
            }
            if (GuildInfoManager.q().x(this.f222443d) != geSortMode) {
                this.D.O1(geSortMode);
                return;
            } else {
                N9(geSortMode);
                return;
            }
        }
        if (simpleBaseEvent instanceof GuildFeedPublishSuccessEvent) {
            GuildFeedPublishSuccessEvent guildFeedPublishSuccessEvent = (GuildFeedPublishSuccessEvent) simpleBaseEvent;
            if (S9(guildFeedPublishSuccessEvent.getGuildId(), guildFeedPublishSuccessEvent.getChannelId())) {
                N9(GuildInfoManager.q().x(this.f222443d));
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedMoveEvent) {
            GuildFeedMoveEvent guildFeedMoveEvent = (GuildFeedMoveEvent) simpleBaseEvent;
            if (S9(guildFeedMoveEvent.getGuildId(), guildFeedMoveEvent.getChannelId())) {
                N9(H9());
            }
        }
    }

    protected void pa(final UIStateData<List<ij1.g>> uIStateData) {
        if (uIStateData.getState() == 3) {
            QLog.e(getTAG(), 1, "[setDataList] handleNetSuccessRsp: isEnd[" + uIStateData.getIsFinish() + "]");
            final boolean isFinish = uIStateData.getIsFinish();
            if (!TextUtils.isEmpty(this.G)) {
                U9(uIStateData.getData());
                this.G = null;
            }
            this.f222445f.u0(uIStateData.getData(), true, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedListContainer.6
                @Override // java.lang.Runnable
                public void run() {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedListContainer.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.e(GuildFeedListContainer.this.getTAG(), 1, "[setDataList] notifyLoadingComplete: isEnd[" + uIStateData.getIsFinish() + "]");
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            GuildFeedListContainer.this.f222445f.notifyLoadingComplete(true, isFinish);
                        }
                    });
                }
            });
            return;
        }
        if (uIStateData.getState() == 2) {
            this.f222445f.u0(uIStateData.getData(), false, null);
            if (!TextUtils.isEmpty(this.G)) {
                U9(uIStateData.getData());
            }
        }
    }

    public void qa() {
        QLog.d(getTAG(), 1, "showRefreshAnimation");
        try {
            getBlockContainer().getBlockMerger().k0();
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, "showRefreshAnimation exception:" + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildFeedStatusView.a
    public void refresh() {
        la(false, H9(), true);
    }

    public void scrollToTop() {
        try {
            getBlockContainer().getRecyclerView().scrollToPosition(0);
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, "scrollToTop exception:" + e16.toString());
        }
    }
}
