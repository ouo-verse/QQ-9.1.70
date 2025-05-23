package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.feed.adapter.GuildFeedCacheRecycleViewPool;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.event.GuildBeKickedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildChannelDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSortModeChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedTroopLifeCycleEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedTroopRefreshEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.SectionInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.data.l;
import com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareV2PublishPart;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.part.GuildFeedEmptyListPart;
import com.tencent.mobileqq.guild.feed.part.GuildFeedListContainer;
import com.tencent.mobileqq.guild.feed.part.GuildFeedRefreshBubblePart;
import com.tencent.mobileqq.guild.feed.part.af;
import com.tencent.mobileqq.guild.feed.part.aj;
import com.tencent.mobileqq.guild.feed.part.ak;
import com.tencent.mobileqq.guild.feed.part.ar;
import com.tencent.mobileqq.guild.feed.part.as;
import com.tencent.mobileqq.guild.feed.publish.event.GuildUpdateCapsuleCntEvent;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.u;
import com.tencent.mobileqq.guild.feed.webbundle.GuildFeedDetailIdleTaskHelper;
import com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager;
import com.tencent.mobileqq.guild.feed.widget.GuildBlockContainer;
import com.tencent.mobileqq.guild.heartbeatreport.IFragmentStatusReportApi;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedTroopFragment extends QPublicBaseFragment implements SimpleEventReceiver {
    private GuildFeedTroopInitBean C;
    private GuildFeedListContainer D;
    private AppInterface E;
    GuildFeedSquareV2PublishPart G;
    private boolean F = true;
    private final Observer H = new Observer() { // from class: com.tencent.mobileqq.guild.feed.fragment.d
        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            GuildFeedTroopFragment.this.Ih(observable, obj);
        }
    };
    private com.tencent.mobileqq.troop.troopgag.api.b I = new a();
    private com.tencent.mobileqq.troop.api.observer.e J = new b();
    private GPServiceObserver K = new c();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a extends com.tencent.mobileqq.troop.troopgag.api.b {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.troopgag.api.b
        public void a(com.tencent.mobileqq.troop.troopgag.data.a aVar) {
            if (aVar != null && aVar.f300223c == 2) {
                GuildFeedTroopFragment.this.zh(aVar.f300221a, "onTroopGagStatusChange");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b extends com.tencent.mobileqq.troop.api.observer.e {
        b() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        public void onAdminUpdate(String str) {
            QLog.i("GuildFeedTroopFragment", 1, "[onAdminUpdate] troopUin = " + str);
            GuildFeedTroopFragment.this.zh(str, "onAdminUpdate");
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(String str, String str2) {
            super.onGuildUserAvatarUrlUpdate(str, str2);
        }
    }

    private void Ah(GuildFeedTroopRefreshEvent guildFeedTroopRefreshEvent) {
        if (this.D != null) {
            if (guildFeedTroopRefreshEvent.getForceSortByHot()) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedSortModeChangeEvent(2));
            } else if (guildFeedTroopRefreshEvent.getForceRefresh()) {
                GuildFeedListContainer guildFeedListContainer = this.D;
                guildFeedListContainer.la(false, guildFeedListContainer.H9(), false);
            }
        }
    }

    private void Bh() {
        Nh();
        if (this.C != null) {
            hj1.b.b("GuildFeedTroopFragment", "onDestroy: removeChannelSortModeRecord [" + this.C.getChannelId() + "]");
            GuildInfoManager.q().b0(this.C);
        }
        GuildInfoManager.q().e0();
        GuildFeedCacheRecycleViewPool.INSTANCE.a().e();
        GuildChannelReportManager.f231987a.g(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST);
        f12.f.f397616a.g("troop_feed", false);
    }

    private void Ch(int i3) {
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 6) {
                    if (i3 == 7) {
                        this.F = false;
                        Ph();
                        Lh(false);
                        return;
                    }
                    return;
                }
                this.F = true;
                Oh();
                Lh(true);
                return;
            }
            Dh();
            return;
        }
        Eh();
    }

    private void Dh() {
        if (this.F) {
            ((IFragmentStatusReportApi) QRoute.api(IFragmentStatusReportApi.class)).pause();
            Ph();
        }
    }

    private void Eh() {
        String str;
        int i3;
        if (this.F) {
            GuildFeedTroopInitBean guildFeedTroopInitBean = this.C;
            if (guildFeedTroopInitBean != null) {
                if (guildFeedTroopInitBean.getJumpExtraInfo() != null) {
                    str = this.C.getJumpExtraInfo().getPageInSourceName();
                    i3 = this.C.getJumpExtraInfo().extraInfo.channelOpenSourceForOnlineReport;
                } else {
                    str = "";
                    i3 = 0;
                }
                ((IFragmentStatusReportApi) QRoute.api(IFragmentStatusReportApi.class)).reportResume(this.C.getGuildId(), this.C.getChannelId(), Integer.valueOf(i3), str, false);
            }
            Oh();
        }
    }

    private void Fh() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.E = appInterface;
        if (appInterface == null) {
            QLog.i("GuildFeedTroopFragment", 1, "[initApp] app init fail");
        }
    }

    private void Gh(Fragment fragment) {
        GuildBlockContainer blockContainer = this.D.getBlockContainer();
        if (blockContainer != null) {
            blockContainer.setParentFragment(fragment);
        }
    }

    private void Hh() {
        GuildFeedBaseInitBean o16 = ax.o(this);
        if (o16 instanceof GuildFeedTroopInitBean) {
            this.C = (GuildFeedTroopInitBean) o16;
            QLog.d(getTAG(), 1, "getInitBeanSuccess:" + this.C);
            GuildInfoManager.q().h(this.C.getChannelId(), this.C.getTroopUin());
        }
        QLog.d(getTAG(), 1, "initPageBean, guildId: " + this.C.getGuildId() + ", channelId: " + this.C.getChannelId());
        ax.K(getActivity(), o16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(Observable observable, Object obj) {
        if (obj instanceof uo4.f) {
            uo4.f fVar = (uo4.f) obj;
            String peerUid = fVar.getUnreadCntInfo().getPeer().getPeerUid();
            GuildFeedTroopInitBean guildFeedTroopInitBean = this.C;
            if (guildFeedTroopInitBean != null && peerUid != null && peerUid.equals(guildFeedTroopInitBean.getTroopUin())) {
                int cnt = fVar.getUnreadCntInfo().getAtmeUnreadCnt().getCnt();
                QLog.i("GuildFeedTroopFragment", 1, "onTroopGuildUnreadCntInfo, troopUin = " + peerUid + ", cnt = " + cnt);
                SimpleEventBus.getInstance().dispatchEvent(new GuildUpdateCapsuleCntEvent(cnt));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ GuildFeedBaseInitBean Kh() {
        return this.C;
    }

    private void Lh(boolean z16) {
        GuildFeedListContainer guildFeedListContainer = this.D;
        if (guildFeedListContainer != null) {
            guildFeedListContainer.ba(z16);
        }
    }

    private void Mh(int i3) {
        QQToast.makeText(getContext(), 1, i3, 1).show();
        u.b(getActivity(), 2);
    }

    private void Nh() {
        AppInterface appInterface = this.E;
        if (appInterface == null) {
            QLog.i("GuildFeedTroopFragment", 1, "[removeObserver] mainViewContext is null");
            return;
        }
        ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).deleteObserver(this.K);
        this.E.removeObserver(this.J);
        this.E.removeObserver(this.I);
        ((ITroopGuildUnreadCntService) this.E.getRuntimeService(ITroopGuildUnreadCntService.class, "")).deleteUnreadCntInfoObserver(this.H);
    }

    private void Oh() {
        GuildChannelReportManager.f231987a.e(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
    }

    private void Ph() {
        GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
    }

    private void pageDtReport() {
        if (this.C != null && getFragmentContentView() != null) {
            GuildChannelReportManager.f231987a.c(getActivity(), getFragmentContentView(), GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, "pg_group_sgrp_forum", uh(), new com.tencent.mobileqq.guild.report.a(this.C.getGuildId(), this.C.getChannelId()));
        }
    }

    private void th() {
        AppInterface appInterface = this.E;
        if (appInterface == null) {
            QLog.i("GuildFeedTroopFragment", 1, "[addObserver] app is null");
            return;
        }
        ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).addObserver(this.K);
        this.E.addObserver(this.J);
        this.E.addObserver(this.I);
        ((ITroopGuildUnreadCntService) this.E.getRuntimeService(ITroopGuildUnreadCntService.class, "")).addUnreadCntInfoObserver(this.H);
    }

    private Map<String, Object> uh() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("sgrp_pg_forum_type", "1");
        hashMap.put("sgrp_channel_id", this.C.getGuildId());
        hashMap.put("sgrp_sub_channel_id", this.C.getChannelId());
        hashMap.put("group_id", this.C.getTroopUin());
        hashMap.put("group_uin_type", Integer.valueOf(((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildRole(this.C.getTroopUin())));
        hashMap.put("sgrp_subchannel_type", String.valueOf(7));
        hashMap.put("sgrp_user_type", this.C.getUserType());
        hashMap.put("Platform", "Android");
        hashMap.put("aio_disappear_type", "0");
        w.b(hashMap);
        if (this.C.getJumpExtraInfo() != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("GuildAppReportSourceInfo", this.C.getJumpExtraInfo());
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setOpenGuildSourceParams(bundle, hashMap);
        }
        return hashMap;
    }

    private String vh() {
        if (ax.o(this) instanceof GuildFeedTroopInitBean) {
            return this.C.getTroopUin();
        }
        return "";
    }

    private void wh(GuildChannelDeleteEvent guildChannelDeleteEvent) {
        if (ax.f(this.C, getActivity()) && this.C.getGuildId().equals(guildChannelDeleteEvent.getGuildId()) && guildChannelDeleteEvent.getChannelIds().contains(this.C.getChannelId())) {
            Mh(R.string.f143840n6);
        }
    }

    private void xh(GuildBeKickedEvent guildBeKickedEvent) {
        if (ax.f(this.C, getActivity()) && this.C.getGuildId().equals(guildBeKickedEvent.getGuildId())) {
            Mh(R.string.f144300oe);
        }
    }

    private void yh(GuildDeleteEvent guildDeleteEvent) {
        if (ax.f(this.C, getActivity()) && this.C.getGuildId().equals(guildDeleteEvent.getGuildId())) {
            Mh(R.string.f144240o9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(String str, String str2) {
        if (str != null && TextUtils.equals(str, vh())) {
            QLog.i("GuildFeedTroopFragment", 1, "handleMuteStateChanged: troopUin[" + str + "], channelId[" + this.C.getChannelId() + "] source: " + str2);
            IGProChannelInfo m3 = GuildInfoManager.q().m(this.C.getChannelId());
            if (m3 != null) {
                GuildInfoManager.q().H(m3.getGuildId(), m3.getChannelUin());
            }
        }
    }

    protected void Qh() {
        if (getFragmentContentView() == null) {
            return;
        }
        getFragmentContentView().setBackgroundColor(0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        this.D = new GuildFeedListContainer(R.id.wbs);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.guild.feed.part.g());
        arrayList.add(new xm1.d());
        arrayList.add(new com.tencent.mobileqq.guild.feed.part.e());
        arrayList.add(new ar());
        arrayList.add(this.D);
        arrayList.add(new aj());
        arrayList.add(new GuildFeedEmptyListPart());
        arrayList.add(new GuildFeedRefreshBubblePart());
        arrayList.add(new as());
        arrayList.add(new af());
        GuildFeedSquareV2PublishPart guildFeedSquareV2PublishPart = new GuildFeedSquareV2PublishPart(0, 2);
        this.G = guildFeedSquareV2PublishPart;
        arrayList.add(guildFeedSquareV2PublishPart);
        arrayList.add(new ak());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.epg;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedThemeChangeEvent.class);
        arrayList.add(GuildChannelDeleteEvent.class);
        arrayList.add(GuildDeleteEvent.class);
        arrayList.add(GuildBeKickedEvent.class);
        arrayList.add(GuildFeedTroopRefreshEvent.class);
        arrayList.add(GuildFeedTroopLifeCycleEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedTroopFragment";
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Hh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i("GuildFeedTroopFragment", 1, "[onCreate] this: " + hashCode());
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).initGuildTaskQueueManager();
        com.tencent.mobileqq.guild.feed.performance.report.i.e().f();
        Fh();
        th();
        f12.f.f397616a.g("troop_feed", true);
        GuildInfoManager.q().R();
        Qh();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        GuildFeedBaseInitBean o16 = ax.o(this);
        String guildId = o16.getGuildId();
        String channelId = o16.getChannelId();
        if (TextUtils.isEmpty(guildId)) {
            guildId = "0";
        }
        if (TextUtils.isEmpty(channelId)) {
            channelId = "0";
        }
        View c16 = gn1.a.c(guildId, channelId);
        if (c16 == null || AppSetting.o(getContext())) {
            QLog.w(getTAG(), 1, "onCreateView, now inflate new content view!");
            c16 = layoutInflater.inflate(getContentLayoutId(), viewGroup, false);
        }
        if (GuildSplitViewUtils.f235370a.g(this).getBoolean("key_show_title", false)) {
            if (needImmersive() && needStatusTrans()) {
                int statusBarHeight = ImmersiveUtils.getStatusBarHeight(c16.getContext());
                View findViewById = c16.findViewById(R.id.xl7);
                if (findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = statusBarHeight;
                }
            }
            c16.findViewById(R.id.wbt).setVisibility(8);
            c16.findViewById(R.id.jo5).setVisibility(0);
            ImageView imageView = (ImageView) c16.findViewById(R.id.a47);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.fragment.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFeedTroopFragment.this.Jh(view);
                }
            });
        } else {
            c16.findViewById(R.id.wfa).setVisibility(8);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, c16);
        return c16;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("GuildFeedTroopFragment", 1, "onDestroy: channelId[" + this.C.getChannelId() + "], this: " + hashCode());
        ej1.d.f396347a.a();
        Lh(false);
        Bh();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.mobileqq.guild.feed.widget.comment.d.f224303h.d();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        ((IGuildFeedContainerLifeCycleApi) QRoute.api(IGuildFeedContainerLifeCycleApi.class)).onTroopFeedPause();
        super.onPause();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildChannelDeleteEvent) {
            wh((GuildChannelDeleteEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildDeleteEvent) {
            yh((GuildDeleteEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildBeKickedEvent) {
            xh((GuildBeKickedEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedTroopRefreshEvent) {
            Ah((GuildFeedTroopRefreshEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedTroopLifeCycleEvent) {
            Ch(((GuildFeedTroopLifeCycleEvent) simpleBaseEvent).getTroopContainerLifeCycle());
        } else if (simpleBaseEvent instanceof GuildFeedThemeChangeEvent) {
            Qh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((IGuildFeedContainerLifeCycleApi) QRoute.api(IGuildFeedContainerLifeCycleApi.class)).onTroopFeedResume();
        ImmersiveUtils.setStatusTextColorNew(!QQTheme.isNowThemeIsNight(), getHostActivity().getWindow());
        GuildFeedDetailIdleTaskHelper.j().f(new GuildWebBundleManager.c());
        GuildFeedListContainer guildFeedListContainer = this.D;
        if (guildFeedListContainer != null && guildFeedListContainer.getBlockContainer() != null) {
            this.D.getBlockContainer().setRefreshing(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        ((IGuildFeedContainerLifeCycleApi) QRoute.api(IGuildFeedContainerLifeCycleApi.class)).onTroopFeedStop();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        Gh(this);
        this.G.O5(new l(new SectionInfo(this.C.getChannelId(), this.C.getGuildId(), this.C.getChannelName(), 2)));
        this.G.x8(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.fragment.f
            @Override // androidx.core.util.Supplier
            public final Object get() {
                GuildFeedBaseInitBean Kh;
                Kh = GuildFeedTroopFragment.this.Kh();
                return Kh;
            }
        });
        pageDtReport();
    }
}
