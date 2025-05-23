package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.guild.event.GuildFeedUpdateEvent;
import com.tencent.mobileqq.guild.event.GuildNoticeClearRedPointEvent;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.event.GuildInboxEmptyPartEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService;
import com.tencent.mobileqq.guild.feed.util.GuildFeedNoticeEvent;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedNoticeListViewModel;
import com.tencent.mobileqq.guild.feed.widget.GuildBlockContainer;
import com.tencent.mobileqq.guild.feed.widget.GuildBlockMerger;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeFragment;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTotalLike;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import zm1.a;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ap extends BlockPart implements SimpleEventReceiver {
    private int C;
    private GuildFeedBaseInitBean D;
    List<ij1.v<?>> E;

    /* renamed from: d, reason: collision with root package name */
    private GuildFeedNoticeListViewModel f222518d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.guild.feed.adapter.i f222519e;

    /* renamed from: f, reason: collision with root package name */
    private IPerformanceReportTask f222520f;

    /* renamed from: h, reason: collision with root package name */
    private final f f222521h;

    /* renamed from: i, reason: collision with root package name */
    private int f222522i;

    /* renamed from: m, reason: collision with root package name */
    private String f222523m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState()) {
                ap.this.Z9();
            } else if (loadInfo.isRefreshState()) {
                ap.this.ga(false, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements com.tencent.mobileqq.guild.inbox.centerpanel.notice.x {
        b() {
        }

        private boolean c() {
            if (!NetworkUtil.isNetworkAvailable()) {
                bn.k(ap.this.getActivity().getString(R.string.zxt));
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.x
        public void a(int i3) {
            if (!c() && ap.this.f222518d != null) {
                QLog.d("GuildFeedNoticeListBlockPart", 2, "GuildFeedNoticeListBlockPart onGuildFeedNoticeDeleted position = " + i3);
                ap.this.f222518d.b2(i3);
            }
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.x
        public void b(int i3, boolean z16) {
            if (!c() && ap.this.f222518d != null) {
                QLog.d("GuildFeedNoticeListBlockPart", 2, "[onGuildFeedNoticeSwitchReceiveNotification]--position = " + i3);
                ap.this.f222518d.H2(i3, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (ap.this.getActivity() instanceof QBaseActivity) {
                com.tencent.mobileqq.guild.feed.util.u.a(ap.this.f222521h);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ap.this.getActivity() instanceof FragmentActivity) {
                com.tencent.mobileqq.guild.feed.util.u.c(ap.this.f222521h);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (ap.this.C == 0) {
                f12.d.f397604d.i("feed_inbox_message_list", i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            int i17;
            super.onScrolled(recyclerView, i3, i16);
            GuildBlockContainer blockContainer = ap.this.getBlockContainer();
            if (i3 == 0 && i16 == 0 && blockContainer != null) {
                GuildBlockMerger blockMerger = blockContainer.getBlockMerger();
                if (blockMerger != null) {
                    i17 = blockMerger.getCount();
                } else {
                    i17 = 0;
                }
                if (i17 != 0 && ap.this.C == 0) {
                    com.tencent.mobileqq.guild.feed.performance.report.g.a("feed_notice_show");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("GuildFeedNoticeListBlockPart", 1, "GuildInboxMessageListBlockPart show list count: " + i17);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f222528d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f222529e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f222530f;

        e(RecyclerView recyclerView, int i3, int i16) {
            this.f222528d = recyclerView;
            this.f222529e = i3;
            this.f222530f = i16;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f222528d.getChildCount() > 0) {
                this.f222528d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ap.this.ia(this.f222528d, this.f222529e, this.f222530f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    private class f extends rr1.a {
        f() {
        }

        @Override // rr1.a
        public void c(rr1.i iVar) {
            if (ap.this.H9() && iVar.f() == 3 && iVar.c() == 1) {
                ap.this.R9();
            }
        }
    }

    public ap(int i3, int i16, @Nullable IPerformanceReportTask iPerformanceReportTask) {
        super(i3);
        this.f222521h = new f();
        this.f222522i = 0;
        this.f222523m = "";
        this.E = new ArrayList();
        this.C = i16;
        this.f222520f = iPerformanceReportTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H9() {
        if (!(getActivity() instanceof QBaseActivity) || 9 != ax.r((QBaseActivity) getActivity())) {
            return false;
        }
        return true;
    }

    private void I9() {
        if (getPartHost() != null) {
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            Bundle h16 = guildSplitViewUtils.h(getPartHost());
            int i3 = h16.getInt("extra_key_jump_type", 0);
            if (i3 == 1) {
                this.f222523m = h16.getString("detailId");
            } else if (i3 == 2) {
                String string = h16.getString("extra_guild_id");
                Bundle bundle = new Bundle();
                bundle.putInt(IFileBrowserService.FILE_BROWSER_PAGE_FROM, K9());
                GuildNoticeFragment.Nh(getContext(), string, 0, false, bundle);
            }
            if (guildSplitViewUtils.n(getActivity())) {
                h16.remove("extra_key_jump_type");
                h16.remove("detailId");
            }
        }
    }

    private int K9() {
        if (getPartHost() != null) {
            return GuildSplitViewUtils.f235370a.h(getPartHost()).getInt(IFileBrowserService.FILE_BROWSER_PAGE_FROM);
        }
        return 0;
    }

    private void L9(List<ij1.v<?>> list) {
        if (!TextUtils.isEmpty(this.f222523m) && !list.isEmpty()) {
            Iterator<ij1.v<?>> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ij1.v<?> next = it.next();
                if (next.b() instanceof GProStNotice) {
                    GProStNotice gProStNotice = (GProStNotice) next.b();
                    GProStFeed gProStFeed = gProStNotice.origineFeed;
                    if (this.f222523m.equals(gProStNotice.psvFeed.idd)) {
                        IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi = (IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class);
                        String str = gProStNotice.pattonInfo.plainTxt.operation.schema;
                        if (iGuildFeedNativeDetailApi.needOpenNativeDetailPage(gProStFeed)) {
                            Uri parse = Uri.parse(str);
                            Intent intent = new Intent();
                            String queryParameter = parse.getQueryParameter("comment_id");
                            String queryParameter2 = parse.getQueryParameter("comment_id");
                            if (!TextUtils.isEmpty(queryParameter) || !TextUtils.isEmpty(queryParameter2)) {
                                intent.putExtra("comment_id", parse.getQueryParameter("comment_id"));
                                intent.putExtra("reply_id", parse.getQueryParameter("reply_id"));
                                intent.putExtra("start_intent_interact_action", 2);
                            }
                            iGuildFeedNativeDetailApi.openFeedNativeDetailPage(getContext(), gProStFeed, this.D, intent);
                        } else {
                            GuildFeedBaseInitBean guildFeedBaseInitBean = this.D;
                            if (guildFeedBaseInitBean != null && guildFeedBaseInitBean.getBusinessType() == 7) {
                                str = ma(str);
                            }
                            GuildFeedLauncher.t(str);
                        }
                    }
                }
            }
            this.f222523m = "";
        }
    }

    private void M9(UIStateData<List<ij1.v<?>>> uIStateData) {
        if (this.f222519e == null) {
            QLog.e(getTAG(), 1, "[handleDataDelete] inbox message adapter is null]");
            return;
        }
        int pos = uIStateData.getPos();
        if (this.f222519e.getDataList() != null && this.f222519e.getDataList().size() > pos) {
            this.f222519e.u0(pos);
        }
    }

    private void N9(UIStateData<List<ij1.v<?>>> uIStateData) {
        if (this.f222519e == null) {
            QLog.e(getTAG(), 1, "handleDataModify inbox message adapter is null!");
            return;
        }
        int pos = uIStateData.getPos();
        if (pos == -1) {
            com.tencent.mobileqq.guild.feed.adapter.i iVar = this.f222519e;
            iVar.notifyItemRangeChanged(0, iVar.getItemCount(), a.C11698a.f452777a);
        } else if (this.f222519e.getDataList() != null && this.f222519e.getDataList().size() > pos) {
            this.f222519e.notifyItemChanged(pos);
        }
        this.f222519e.notifyLoadingComplete(true, uIStateData.getIsFinish());
    }

    private void O9(UIStateData<List<ij1.v<?>>> uIStateData) {
        ea(uIStateData.getData());
        com.tencent.mobileqq.guild.feed.adapter.i iVar = this.f222519e;
        if (iVar == null) {
            ca(true, HardCodeUtil.qqStr(R.string.f1513717i));
            QLog.e(getTAG(), 1, "handleEmptyRsp message adapter is null!");
            return;
        }
        iVar.notifyLoadingComplete(true, uIStateData.getIsFinish());
        this.f222519e.t0(false);
        if (V9() && uIStateData.getIsLoadMore()) {
            QLog.e(getTAG(), 1, "hasInboxMessageContents do nothing");
            this.f222519e.getLoadInfo().setFinish(uIStateData.getIsFinish());
            return;
        }
        ca(true, uIStateData.getMsg());
        this.f222519e.setDatas(uIStateData.getData());
        List<ij1.v<?>> list = this.E;
        if (list != null) {
            list.clear();
        } else {
            this.E = new ArrayList();
        }
        this.E.addAll(uIStateData.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9() {
        T9();
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
    }

    private void S9(UIStateData<List<ij1.v<?>>> uIStateData) {
        com.tencent.mobileqq.guild.feed.adapter.i iVar = this.f222519e;
        if (iVar == null) {
            ca(true, HardCodeUtil.qqStr(R.string.f1513717i));
            QLog.e(getTAG(), 1, "handlePageCacheRsp inbox message adapter is null!");
            return;
        }
        iVar.notifyLoadingComplete(true, uIStateData.getIsFinish());
        this.f222519e.setDatas(uIStateData.getData());
        ArrayList arrayList = new ArrayList();
        this.E = arrayList;
        arrayList.addAll(uIStateData.getData());
        this.f222519e.getLoadInfo().setFinish(uIStateData.getIsFinish());
        ha(uIStateData.getPos(), uIStateData.getTop());
        if (!V9() && !uIStateData.getIsLoadMore()) {
            ca(true, uIStateData.getMsg());
        }
    }

    private void T9() {
        IGuildUnreadCntService.b bVar;
        if (this.C != 0 || !H9()) {
            return;
        }
        AppRuntime m3 = ax.m(getContext());
        if (m3 == null) {
            QLog.d("GuildFeedNoticeListBlockPart", 1, "handleUnReadRefresh appRuntime is null return");
            return;
        }
        IGuildFeedPersonalBoxUnreadService.a guildFeedPersonalBoxLastMsg = ((IGuildFeedPersonalBoxUnreadService) m3.getRuntimeService(IGuildFeedPersonalBoxUnreadService.class, "")).getGuildFeedPersonalBoxLastMsg();
        if (guildFeedPersonalBoxLastMsg != null && (bVar = guildFeedPersonalBoxLastMsg.f222745a) != null && bVar.f230840d > 0) {
            QLog.d("GuildFeedNoticeListBlockPart", 1, "handleUnReadRefresh has unread cnt, execute refresh data");
            ga(false, true);
        } else {
            QLog.d("GuildFeedNoticeListBlockPart", 1, "handleUnReadRefresh no unread info or cnt is zero");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U9, reason: merged with bridge method [inline-methods] */
    public void W9(UIStateData<List<ij1.v<?>>> uIStateData) {
        if (uIStateData == null) {
            ca(true, HardCodeUtil.qqStr(R.string.f1513717i));
            return;
        }
        int state = uIStateData.getState();
        this.f222522i = state;
        if (state != 0) {
            switch (state) {
                case 2:
                case 3:
                    Q9(uIStateData);
                    return;
                case 4:
                    P9(uIStateData);
                    return;
                case 5:
                    S9(uIStateData);
                    return;
                case 6:
                    M9(uIStateData);
                    return;
                case 7:
                    N9(uIStateData);
                    return;
                default:
                    return;
            }
        }
        O9(uIStateData);
    }

    private boolean V9() {
        com.tencent.mobileqq.guild.feed.adapter.i iVar = this.f222519e;
        if (iVar != null && iVar.getItemCount() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X9(AppRuntime appRuntime, long j3) {
        ((ITroopGuildUnreadCntService) appRuntime.getRuntimeService(ITroopGuildUnreadCntService.class, "")).setTroopGuildMsgRead(String.valueOf(j3), GuildGroupSceneType.KFEEDNUMERIC, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9() {
        ga(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z9() {
        this.f222518d.loadMore();
        QLog.d("GuildFeedNoticeListBlockPart", 1, "trigger loader more");
    }

    private void aa(List<ij1.v<?>> list) {
        GProStNotice gProStNotice;
        if (list != null && !list.isEmpty()) {
            final AppRuntime m3 = ax.m(getContext());
            if (m3 == null) {
                return;
            }
            Iterator<ij1.v<?>> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    ij1.v<?> next = it.next();
                    if (next.b() instanceof GProStNotice) {
                        gProStNotice = (GProStNotice) next.b();
                        break;
                    }
                } else {
                    gProStNotice = null;
                    break;
                }
            }
            if (gProStNotice != null) {
                final long j3 = gProStNotice.origineFeed.groupCode;
                if (j3 == 0) {
                    QLog.e("GuildFeedNoticeListBlockPart", 1, "markTroopMsgRead troopUin = 0");
                    return;
                } else {
                    RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.ao
                        @Override // java.lang.Runnable
                        public final void run() {
                            ap.X9(AppRuntime.this, j3);
                        }
                    });
                    return;
                }
            }
            return;
        }
        QLog.d("GuildFeedNoticeListBlockPart", 1, "messageBlockData list is null");
    }

    private boolean ba() {
        int i3;
        RecyclerView.LayoutManager layoutManager = getBlockContainer().getLayoutManager();
        if (!(layoutManager instanceof SafeStaggeredGridLayoutManager)) {
            return true;
        }
        int[] iArr = null;
        try {
            iArr = ((SafeStaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions(null);
        } catch (IllegalArgumentException e16) {
            QLog.d(getTAG(), 1, "needScrollToTop IllegalArgumentException ", e16);
        }
        if (iArr != null && iArr.length >= 0) {
            i3 = iArr[0];
            QLog.d(getTAG(), 1, "firstVisibleItem " + i3);
        } else {
            i3 = -1;
        }
        if (i3 > 1) {
            return true;
        }
        return false;
    }

    private void ca(boolean z16, String str) {
        GuildInboxEmptyPartEvent guildInboxEmptyPartEvent = new GuildInboxEmptyPartEvent(z16);
        guildInboxEmptyPartEvent.setErrorMsg(str);
        SimpleEventBus.getInstance().dispatchEvent(guildInboxEmptyPartEvent);
    }

    private void da() {
        com.tencent.mobileqq.guild.feed.adapter.i iVar = new com.tencent.mobileqq.guild.feed.adapter.i(this.D);
        this.f222519e = iVar;
        iVar.setOnLoadDataDelegate(new a());
        this.f222519e.v0(new b());
        this.mPeerBlocks.add(this.f222519e);
    }

    private void initViewModel() {
        GuildFeedNoticeListViewModel guildFeedNoticeListViewModel = (GuildFeedNoticeListViewModel) getViewModel(GuildFeedNoticeListViewModel.class);
        this.f222518d = guildFeedNoticeListViewModel;
        guildFeedNoticeListViewModel.h2().observeForever(new Observer() { // from class: com.tencent.mobileqq.guild.feed.part.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ap.this.W9((UIStateData) obj);
            }
        });
        this.f222518d.G2(this.D);
        this.f222518d.onCreate();
    }

    private String ma(String str) {
        return str + ContainerUtils.FIELD_DELIMITER + "businessType" + ContainerUtils.KEY_VALUE_DELIMITER + this.D.getBusinessType() + ContainerUtils.FIELD_DELIMITER + "troopUin" + ContainerUtils.KEY_VALUE_DELIMITER + this.D.getTroopUin() + ContainerUtils.FIELD_DELIMITER + "troopRole" + ContainerUtils.KEY_VALUE_DELIMITER + this.D.getTroopRole();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart
    /* renamed from: J9, reason: merged with bridge method [inline-methods] */
    public GuildBlockContainer getBlockContainer() {
        return (GuildBlockContainer) super.getBlockContainer();
    }

    protected void P9(UIStateData<List<ij1.v<?>>> uIStateData) {
        String qqStr = HardCodeUtil.qqStr(R.string.f144620p_);
        QLog.e(getTAG(), 1, "handleInboxMessageDataRsp() return error\uff01errCode[" + uIStateData.getRetCode() + "errMsg:" + uIStateData.getMsg());
        this.f222523m = "";
        com.tencent.mobileqq.guild.feed.adapter.i iVar = this.f222519e;
        if (iVar == null) {
            ca(true, HardCodeUtil.qqStr(R.string.f1513717i));
            QLog.e(getTAG(), 1, "handleErrorRsp inbox message adapter is null!");
            return;
        }
        iVar.notifyLoadingComplete(true, uIStateData.getIsFinish());
        QQToast.makeText(getContext(), 1, qqStr, 0).show();
        if (!V9()) {
            ca(true, HardCodeUtil.qqStr(R.string.f1513717i));
        }
    }

    protected void Q9(UIStateData<List<ij1.v<?>>> uIStateData) {
        List<ij1.v<?>> data = uIStateData.getData();
        if (data == null) {
            QLog.e(getTAG(), 1, "handleNetSuccRsp uiStateData.getData() is null! state: " + uIStateData.getState());
            data = new ArrayList<>();
        }
        if (!uIStateData.getIsLoadMore() && uIStateData.getState() == 3) {
            ea(data);
        }
        com.tencent.mobileqq.guild.feed.adapter.i iVar = this.f222519e;
        if (iVar == null) {
            ca(true, HardCodeUtil.qqStr(R.string.f1513717i));
            QLog.e(getTAG(), 1, "handleNetSuccessRsp inbox message adapter is null!");
            return;
        }
        iVar.getLoadInfo().setFinish(uIStateData.getIsFinish());
        this.f222519e.notifyLoadingComplete(true, uIStateData.getIsFinish());
        this.f222519e.t0(uIStateData.getIsFinish());
        QLog.d(getTAG(), 1, "handleNetSuccRsp uiStateData.getData()" + data.size() + ", state: " + uIStateData.getState());
        if (uIStateData.getIsLoadMore()) {
            this.f222519e.addAll((ArrayList) data);
            return;
        }
        if (data.isEmpty()) {
            ca(true, HardCodeUtil.qqStr(R.string.f1513717i));
            QLog.d(getTAG(), 1, "handleNetSuccessRsp data is null!");
            return;
        }
        ca(false, uIStateData.getMsg());
        scrollToTop();
        this.f222519e.setDatas(data);
        ArrayList arrayList = new ArrayList();
        this.E = arrayList;
        arrayList.addAll(uIStateData.getData());
        if (3 == uIStateData.getState()) {
            L9(data);
        }
    }

    public void ea(List<ij1.v<?>> list) {
        if (this.C == 1) {
            aa(list);
        }
    }

    public void ga(boolean z16, boolean z17) {
        if (this.f222518d == null || this.f222522i == 1) {
            return;
        }
        this.f222522i = 1;
        if (z17) {
            la();
        }
        this.f222518d.C2(z16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedUpdateEvent.class);
        arrayList.add(GuildNoticeClearRedPointEvent.class);
        arrayList.add(GuildFeedNoticeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedNoticeListBlockPart";
    }

    protected void ha(int i3, int i16) {
        QLog.d(getTAG(), 1, "resumePageCachePosition pos:", Integer.valueOf(i3), ",top:", Integer.valueOf(i16));
        NestScrollRecyclerView recyclerView = getBlockContainer().getRecyclerView();
        if (recyclerView != null) {
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new e(recyclerView, i3, i16));
        }
    }

    public void ia(RecyclerView recyclerView, int i3, int i16) {
        try {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof SafeStaggeredGridLayoutManager) {
                ((SafeStaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i16);
            }
        } catch (Exception e16) {
            QLog.e(getTAG(), 1, "scrollToPosWithOffset exception:" + e16.toString());
        }
    }

    public void ja(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        this.D = guildFeedBaseInitBean;
    }

    public void la() {
        QLog.d(getTAG(), 1, "showRefreshAnimation");
        try {
            getBlockContainer().getBlockMerger().k0();
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, "showRefreshAnimation exception:" + e16.toString());
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        String string;
        super.onInitView(view);
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.D;
        if (guildFeedBaseInitBean != null && guildFeedBaseInitBean.getBusinessType() == 7) {
            string = getContext().getResources().getString(R.string.f158051ok);
        } else {
            string = getContext().getResources().getString(R.string.f144680pf);
        }
        getBlockContainer().setEnableRefresh(true);
        getBlockContainer().setEnableLoadMore(true);
        getBlockContainer().getBlockMerger().setNoMoreHint(string);
        getBlockContainer().getRecyclerView().addOnAttachStateChangeListener(new c());
        getBlockContainer().getRecyclerView().addOnScrollListener(new d());
        ga(true, false);
        IPerformanceReportTask iPerformanceReportTask = this.f222520f;
        if (iPerformanceReportTask != null) {
            qw1.b.o(iPerformanceReportTask, getBlockContainer().getRecyclerView());
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        da();
        initViewModel();
        I9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f222518d.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedUpdateEvent) {
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.am
                @Override // java.lang.Runnable
                public final void run() {
                    ap.this.Y9();
                }
            }, 1000L);
            return;
        }
        if (simpleBaseEvent instanceof GuildNoticeClearRedPointEvent) {
            GuildFeedNoticeListViewModel guildFeedNoticeListViewModel = this.f222518d;
            if (guildFeedNoticeListViewModel != null) {
                guildFeedNoticeListViewModel.w2();
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedNoticeEvent) {
            for (ij1.v<?> vVar : this.E) {
                if (vVar instanceof ij1.a) {
                    ij1.a aVar = (ij1.a) vVar;
                    Uri parse = Uri.parse(aVar.b().getPattonInfo().getPlainTxt().getOperation().getSchema());
                    String queryParameter = parse.getQueryParameter("comment_id");
                    String queryParameter2 = parse.getQueryParameter("reply_id");
                    GuildFeedNoticeEvent guildFeedNoticeEvent = (GuildFeedNoticeEvent) simpleBaseEvent;
                    String commentId = guildFeedNoticeEvent.getCommentId();
                    String replyId = guildFeedNoticeEvent.getReplyId();
                    if (!TextUtils.isEmpty(commentId) && !TextUtils.isEmpty(queryParameter) && ((TextUtils.isEmpty(replyId) && queryParameter.equals(commentId) && TextUtils.isEmpty(queryParameter2)) || (!TextUtils.isEmpty(replyId) && !TextUtils.isEmpty(queryParameter2) && queryParameter.equals(commentId) && queryParameter2.equals(replyId)))) {
                        GProTotalLike gProTotalLike = aVar.b().psvFeed.totalLike;
                        boolean z16 = true;
                        if (guildFeedNoticeEvent.getStatus() != 1) {
                            z16 = false;
                        }
                        gProTotalLike.isClicked = z16;
                        this.f222519e.setDatas(this.E);
                        return;
                    }
                }
            }
        }
    }

    public void scrollToTop() {
        try {
            boolean ba5 = ba();
            QLog.d(getTAG(), 1, "scrollToTop " + ba5);
            if (ba5) {
                getBlockContainer().getRecyclerView().scrollToPosition(0);
            }
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, "scrollToTop exception:" + e16.toString());
        }
    }
}
