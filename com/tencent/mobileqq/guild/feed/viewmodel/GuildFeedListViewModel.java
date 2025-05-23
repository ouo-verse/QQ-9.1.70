package com.tencent.mobileqq.guild.feed.viewmodel;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker;
import com.tencent.mobileqq.guild.feed.event.GuildChannelLabelEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCapsule;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsRsp;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedListViewModel extends BaseViewModel implements l, IDataDisplaySurface<ij1.g>, co1.j {
    protected GuildFeedMainInitBean F;

    /* renamed from: i, reason: collision with root package name */
    protected final MutableLiveData<UIStateData<List<ij1.g>>> f224012i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    protected final MutableLiveData<UIStateData<List<ij1.h>>> f224013m = new MutableLiveData<>();
    protected List<ij1.g> C = new CopyOnWriteArrayList();
    protected List<ij1.h> D = new CopyOnWriteArrayList();
    protected HashMap<Integer, String> E = new HashMap<>();
    protected List<Object> G = new CopyOnWriteArrayList();
    private String H = "";
    private GuildFeedListDataRepo I = new GuildFeedListDataRepo("GuildFeedListViewModel", -1);

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements uo4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f224018a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f224019b;

        a(boolean z16, int i3) {
            this.f224018a = z16;
            this.f224019b = i3;
        }

        @Override // uo4.a
        public void onResult(int i3, String str, HashMap<Integer, byte[]> hashMap) {
            ArrayList arrayList = new ArrayList();
            Iterator<byte[]> it = hashMap.values().iterator();
            while (it.hasNext()) {
                arrayList.add(ByteStringMicro.copyFrom(it.next()));
            }
            GuildFeedListViewModel.this.q2(false, this.f224018a, this.f224019b, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b extends qx1.a<com.tencent.mobileqq.guild.feed.feedsquare.data.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedListDataRepo.b f224021a;

        b(GuildFeedListDataRepo.b bVar) {
            this.f224021a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(int i3, String str, com.tencent.mobileqq.guild.feed.feedsquare.data.a aVar) {
            List<ij1.g> arrayList = new ArrayList<>();
            if (GuildFeedListViewModel.this.f224012i.getValue() != null && GuildFeedListViewModel.this.f224012i.getValue().getData() != null) {
                arrayList = GuildFeedListViewModel.this.f224012i.getValue().getData();
            }
            GuildFeedListViewModel.this.f224012i.setValue(UIStateData.obtainError(str).setRetCode(i3).setType(this.f224021a.getSortMode()).setLoadMore(this.f224021a.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()).setDataList(arrayList));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(@NonNull com.tencent.mobileqq.guild.feed.feedsquare.data.a aVar) {
            GuildFeedListViewModel.this.a2(this.f224021a.getSortMode(), aVar.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String(), aVar.getGProGetChannelFeedsRsp(), this.f224021a.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String());
        }
    }

    public GuildFeedListViewModel() {
        hj1.b.b("Guild_Feed_GuildFeedListViewModel", "new GuildFeedListViewModel");
    }

    private boolean U1(boolean z16, int i3) {
        int x16 = GuildInfoManager.q().x(this.F);
        if (i3 != x16) {
            QLog.d("Guild_Feed_GuildFeedListViewModel", 1, "requestNet mode not match:" + i3 + ",currentMode:" + x16);
            return true;
        }
        if (this.f224012i.getValue() != null && this.f224012i.getValue().isLoading() && this.f224012i.getValue().getType() == i3) {
            QLog.d("Guild_Feed_GuildFeedListViewModel", 1, "requestNet is loading");
            return true;
        }
        QLog.d("Guild_Feed_GuildFeedListViewModel", 1, "requestNet net isLoadMore:" + z16 + "|" + i3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1() {
        GuildFeedMainInitBean guildFeedMainInitBean = this.F;
        if (guildFeedMainInitBean != null && (guildFeedMainInitBean instanceof GuildFeedTroopInitBean)) {
            ((ITroopGuildUnreadCntService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopGuildUnreadCntService.class, "")).setTroopGuildMsgRead(((GuildFeedTroopInitBean) this.F).getTroopUin(), GuildGroupSceneType.KFEEDBASE, false);
        }
    }

    private void X1(List<ij1.g> list) {
        if (!list.isEmpty()) {
            GProStChannelInfo gProStChannelInfo = list.get(0).b().channelInfo;
            String valueOf = String.valueOf(gProStChannelInfo.sign.guildId);
            String str = gProStChannelInfo.hotIcon;
            int i3 = gProStChannelInfo.hotIndex;
            QLog.d("Guild_Feed_GuildFeedListViewModel", 1, "guildId:" + valueOf + ", hotIcon: " + str + ", index:" + i3);
            if (!TextUtils.isEmpty(str)) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildChannelLabelEvent(valueOf, str, i3), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2(final int i3, final boolean z16, final GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp, final boolean z17) {
        if (b2(z16, i3)) {
            return;
        }
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedWorker guildFeedWorker;
                GuildFeedListViewModel.this.o2(z17);
                GuildFeedListViewModel.this.h2(i3, gProStGetChannelFeedsRsp);
                GuildFeedListViewModel.this.j2(gProStGetChannelFeedsRsp, z17);
                GuildFeedListViewModel.this.k2(gProStGetChannelFeedsRsp, z17, z16, GuildFeedListViewModel.this.i2(gProStGetChannelFeedsRsp), i3);
                GuildFeedListViewModel.this.W1();
                if (!z17 && (guildFeedWorker = (GuildFeedWorker) jj1.b.c().getDataWorker(GuildFeedWorker.class)) != null) {
                    guildFeedWorker.e0(GuildFeedListViewModel.this.F.getGuildId(), GuildFeedListViewModel.this.F.getChannelId());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit c2(UIStateData uIStateData) {
        this.f224012i.setValue(uIStateData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit d2(boolean z16, List list, UIStateData uIStateData) {
        f2(z16, list, uIStateData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit e2(UIStateData uIStateData) {
        g2(uIStateData);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i2(GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp) {
        if (gProStGetChannelFeedsRsp == null || gProStGetChannelFeedsRsp.isFinish > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2(GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp, boolean z16) {
        if (z16) {
            return;
        }
        ArrayList<ij1.h> d16 = ij1.c.d(gProStGetChannelFeedsRsp.topFeeds);
        this.D.clear();
        this.D.addAll(d16);
        QLog.d("Guild_Feed_GuildFeedListViewModel", 1, "parseTopFeedBlockInfo: top size[" + d16.size() + "]");
        n2(UIStateData.obtainModify().setData(false, d16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp, boolean z16, boolean z17, boolean z18, int i3) {
        ArrayList<ij1.g> c16 = ij1.c.c(gProStGetChannelFeedsRsp.vecFeedList, gProStGetChannelFeedsRsp.traceId);
        if (c16 == null) {
            c16 = new ArrayList<>();
        }
        QLog.d("Guild_Feed_GuildFeedListViewModel", 1, "[postFeedData] transForm size:" + c16.size() + ", isLoadMore: " + z16, ", trace_id=" + gProStGetChannelFeedsRsp.traceId);
        if (!z16) {
            X1(c16);
        }
        jj1.b.c().initOrUpdateGlobalState((List) gProStGetChannelFeedsRsp.vecFeedList, true);
        GProCapsule gProCapsule = gProStGetChannelFeedsRsp.capsule;
        if (gProCapsule != null && gProCapsule.avatarMetaList.size() > 0) {
            ij1.g gVar = new ij1.g(new GProStFeed());
            gVar.w(gProStGetChannelFeedsRsp.capsule);
            c16.add(0, gVar);
        }
        this.C.addAll(c16);
        this.G.addAll(gProStGetChannelFeedsRsp.vecFeedList);
        List<ij1.g> v3 = ((GuildFeedWorker) jj1.b.c().getDataWorker(GuildFeedWorker.class)).v(this.F.getGuildId(), this.F.getChannelId());
        if (this.C.isEmpty() && !z16 && (v3 == null || v3.size() == 0)) {
            l2(UIStateData.obtainEmpty().setType(i3).setFinish(z18));
        } else {
            m2(UIStateData.obtainSuccess(z17).setData(z16, this.C).setType(i3).setFinish(z18).setMsg(gProStGetChannelFeedsRsp.refreshToast.text), z16, c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(boolean z16, boolean z17, int i3, ArrayList<ByteStringMicro> arrayList) {
        String str;
        String str2;
        String str3;
        String str4;
        if (U1(z16, i3)) {
            return;
        }
        String guildId = this.F.getGuildId();
        if (TextUtils.isEmpty(guildId)) {
            str = "";
        } else {
            str = guildId;
        }
        String channelId = this.F.getChannelId();
        if (TextUtils.isEmpty(channelId)) {
            str2 = "";
        } else {
            str2 = channelId;
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<ByteStringMicro> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().toByteArray());
            }
        }
        if (!z16) {
            str3 = "";
        } else {
            str3 = this.E.get(Integer.valueOf(i3));
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> bVar = new GuildFeedListDataRepo.b<>(str, str2, "", i3, z16, z17, str4, "", arrayList2, 0, "", GuildFeedListDataRepo.INSTANCE.a().getAndIncrement(), null);
        m2(UIStateData.obtainLoading().setType(i3), z16, null);
        this.I.k(bVar, new b(bVar));
    }

    public MutableLiveData<UIStateData<List<ij1.h>>> Z1() {
        return this.f224013m;
    }

    protected boolean b2(boolean z16, int i3) {
        if (i3 != GuildInfoManager.q().x(this.F) || !z16 || this.C.size() <= 0) {
            return false;
        }
        return true;
    }

    protected void f2(boolean z16, List<ij1.g> list, UIStateData<List<ij1.g>> uIStateData) {
        if (this.f224012i.getValue() != null) {
            List<ij1.g> data = this.f224012i.getValue().getData();
            List<ij1.g> arrayList = new ArrayList<>();
            if (z16) {
                if (data != null && data.size() > 0) {
                    arrayList.addAll(data);
                }
            } else {
                List<ij1.g> v3 = ((GuildFeedWorker) jj1.b.c().getDataWorker(GuildFeedWorker.class)).v(this.F.getGuildId(), this.F.getChannelId());
                if (v3 != null && v3.size() > 0) {
                    arrayList.addAll(v3);
                }
            }
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            uIStateData.setDataList(arrayList);
            if (list != null && arrayList.size() == 0) {
                uIStateData.setState(0);
            }
        }
        this.f224012i.setValue(uIStateData);
    }

    protected void g2(UIStateData<List<ij1.h>> uIStateData) {
        this.f224013m.setValue(uIStateData);
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<ij1.g>>> getDisplaySurfaceData(Object... objArr) {
        return this.f224012i;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        if (GuildInfoManager.q().x(this.F) != 2) {
            return 2;
        }
        return 1;
    }

    @Override // co1.h
    /* renamed from: getIdentifier */
    public String getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String() {
        return this.H;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "Guild_Feed_GuildFeedListViewModel";
    }

    void h2(int i3, GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp) {
        if (gProStGetChannelFeedsRsp == null) {
            return;
        }
        this.E.put(Integer.valueOf(i3), gProStGetChannelFeedsRsp.feedAttchInfo);
    }

    @Override // com.tencent.mobileqq.guild.feed.viewmodel.l
    public MutableLiveData<UIStateData<List<ij1.g>>> j() {
        return this.f224012i;
    }

    protected void l2(final UIStateData<List<ij1.g>> uIStateData) {
        ThreadUtils.f235400a.e(new Function0() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit c26;
                c26 = GuildFeedListViewModel.this.c2(uIStateData);
                return c26;
            }
        });
    }

    protected void m2(final UIStateData<List<ij1.g>> uIStateData, final boolean z16, final List<ij1.g> list) {
        ThreadUtils.f235400a.e(new Function0() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit d26;
                d26 = GuildFeedListViewModel.this.d2(z16, list, uIStateData);
                return d26;
            }
        });
    }

    public void n(int i3) {
        if (this.F == null) {
            QLog.d("Guild_Feed_GuildFeedListViewModel", 1, "no init bean for loadMore");
        } else {
            q2(true, false, i3, null);
        }
    }

    protected void n2(final UIStateData<List<ij1.h>> uIStateData) {
        ThreadUtils.f235400a.e(new Function0() { // from class: com.tencent.mobileqq.guild.feed.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e26;
                e26 = GuildFeedListViewModel.this.e2(uIStateData);
                return e26;
            }
        });
    }

    protected void o2(boolean z16) {
        hj1.b.b("Guild_Feed_GuildFeedListViewModel", "preProcessByLoadMore: isLoadMore[" + z16 + "]");
        if (!z16) {
            this.C.clear();
            this.G.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        hj1.b.b("Guild_Feed_GuildFeedListViewModel", "onCleared: feeds[" + this.G.size() + "]");
    }

    public void p2(boolean z16, int i3) {
        GuildFeedMainInitBean guildFeedMainInitBean = this.F;
        if (guildFeedMainInitBean == null) {
            QLog.d("Guild_Feed_GuildFeedListViewModel", 1, "no init bean for refresh");
        } else {
            if (guildFeedMainInitBean instanceof GuildFeedTroopInitBean) {
                ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getGuildGroupTransData(((GuildFeedTroopInitBean) guildFeedMainInitBean).getTroopUin(), ((GuildFeedTroopInitBean) this.F).getGuildId(), new a(z16, i3));
                return;
            }
            q2(false, z16, i3, null);
        }
    }

    public void r2(GuildFeedMainInitBean guildFeedMainInitBean) {
        this.F = guildFeedMainInitBean;
    }

    @Override // co1.j
    public void setIdentifier(String str) {
        this.H = str;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
    }
}
