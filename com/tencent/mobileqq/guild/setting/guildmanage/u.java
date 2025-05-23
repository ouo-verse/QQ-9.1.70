package com.tencent.mobileqq.guild.setting.guildmanage;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.PermissionSwitchStatus;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.event.GuildApplicationShowNumberEvent;
import com.tencent.mobileqq.guild.setting.guildmanage.navigation.GuildNavigationStatus;
import com.tencent.mobileqq.guild.setting.guildmanage.navigation.GuildNavigationStatusChangeEvent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildNumRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNumInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.mobileqq.qqguildsdk.data.genc.bn;
import com.tencent.mobileqq.qqguildsdk.data.genc.bs;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import wh2.br;
import wh2.cg;
import wh2.cj;
import wh2.cq;

/* compiled from: P */
/* loaded from: classes14.dex */
public class u extends com.tencent.mobileqq.mvvm.c<wy1.a> implements SimpleEventReceiver<SimpleBaseEvent> {
    static ViewModelProvider.Factory P = new d();
    private final MutableLiveData<Pair<String, Integer>> C;
    private String D;
    private final MutableLiveData<GuildNavigationStatus> E;
    private MediatorLiveData<Boolean> F;
    private MutableLiveData<Boolean> G;
    private MutableLiveData<Boolean> H;
    private MutableLiveData<Boolean> I;
    private MutableLiveData<Boolean> J;
    private MutableLiveData<PermissionSwitchStatus> K;
    private final MutableLiveData<Integer> L;
    private final MutableLiveData<Integer> M;
    private final GPServiceObserver N;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<IGProGuildInfo> f234380i;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<IGProGuildNumInfo> f234381m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChangeGuildNumber(long j3, String str, int i3) {
            if (String.valueOf(j3).equals(u.this.D)) {
                u.this.C.postValue(new Pair(str, Integer.valueOf(i3)));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            if (TextUtils.equals(str, u.this.D)) {
                u.this.p2("onChannelListUpdated");
            }
            u.this.q2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(String str, HashSet<String> hashSet) {
            u.this.q2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            if (TextUtils.equals(str, u.this.D)) {
                IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
                if (iGPSService == null) {
                    QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "onGuildInfoUpdated igpsService is null");
                    return;
                }
                IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str);
                if (guildInfo == null) {
                    QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "onGuildInfoUpdated guildInfo is null");
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Guild.mnr.QQGuidInfoViewModel", 2, "onGuildInfoUpdated paramGuildId: " + str + " mGuildId: " + u.this.D);
                }
                u.this.f234380i.postValue(guildInfo);
                u.this.q2();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(String str, dx dxVar) {
            u.this.q2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements cg {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bn f234383a;

        b(bn bnVar) {
            this.f234383a = bnVar;
        }

        @Override // wh2.cg
        public void onGetGuildHomeCategories(ArrayList<IGProCategoryChannelInfoList> arrayList) {
            Iterator<IGProCategoryChannelInfoList> it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (!it.next().getCloseSwitch()) {
                    i3++;
                }
            }
            QLog.w("Guild.mnr.QQGuidInfoViewModel", 1, "loadAdditionApplicationNumber  inputGuildId:" + this.f234383a.b() + "  showItemNumber:" + i3);
            u.this.L.postValue(Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements br {
        c() {
        }

        @Override // wh2.br
        public void onGetCategoryChannelInfoListV2(ArrayList<IGProCategoryChannelInfoList> arrayList) {
            Iterator<IGProCategoryChannelInfoList> it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                IGProCategoryChannelInfoList next = it.next();
                if (next.getCategoryType() == 1) {
                    i3 += next.getChannelInfoList().size();
                }
            }
            u.this.M.postValue(Integer.valueOf(i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements ViewModelProvider.Factory {
        d() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new u(new wy1.a());
        }
    }

    public u(wy1.a aVar) {
        super(aVar);
        this.f234380i = new MutableLiveData<>();
        this.f234381m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MediatorLiveData<>();
        Boolean bool = Boolean.FALSE;
        this.G = new MutableLiveData<>(bool);
        this.H = new MutableLiveData<>(bool);
        this.I = new MutableLiveData<>(bool);
        this.J = new MutableLiveData<>(bool);
        this.K = new MutableLiveData<>();
        this.L = new MutableLiveData<>(0);
        this.M = new MutableLiveData<>(0);
        this.N = new a();
    }

    private boolean X1() {
        GuildNavigationStatus value;
        IGProGuildInfo value2 = this.f234380i.getValue();
        if (value2 == null || (value = this.E.getValue()) == null || !value.getEnableShowNavBar()) {
            return false;
        }
        QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "[checkShowNavigationEnter] guildId:" + value2.getGuildID() + " userType:" + value2.getUserType());
        return true;
    }

    private PermissionSwitchStatus b2() {
        PermissionSwitchStatus permissionSwitchStatus;
        IGProGuildInfo L = ch.L(this.D);
        PermissionSwitchStatus permissionSwitchStatus2 = PermissionSwitchStatus.TYPE_ALL;
        Iterator<GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry> it = L.getGuildGlobalAuthInfo().getAuthControlSwitchInfoList().iterator();
        while (it.hasNext()) {
            GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry next = it.next();
            if (next.key == 2) {
                if (next.value.getGlobalAuthScopeType() == 1) {
                    permissionSwitchStatus = PermissionSwitchStatus.TYPE_PART;
                } else {
                    permissionSwitchStatus = PermissionSwitchStatus.TYPE_ALL;
                }
                return permissionSwitchStatus;
            }
        }
        return permissionSwitchStatus2;
    }

    private void c2(IGPSService iGPSService, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bs bsVar = new bs();
        bsVar.b(Long.parseLong(str));
        iGPSService.getNavigationStatus(bsVar, new cq() { // from class: cz1.bk
            @Override // wh2.cq
            public final void a(int i3, String str2, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
                com.tencent.mobileqq.guild.setting.guildmanage.u.this.k2(str, i3, str2, iGProGetNavigationStatusRsp);
            }
        });
    }

    private void f2(IGPSService iGPSService, String str) {
        QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "[initGuildIdInfo] guildId:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        iGPSService.getGuildNum(Long.parseLong(str), new cj() { // from class: cz1.bj
            @Override // wh2.cj
            public final void a(int i3, String str2, IGProGetGuildNumRsp iGProGetGuildNumRsp) {
                com.tencent.mobileqq.guild.setting.guildmanage.u.this.n2(i3, str2, iGProGetGuildNumRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(String str, int i3, String str2, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
        boolean z16;
        boolean z17 = true;
        QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "[initData]onGetNavigationStatus result:" + i3 + ", errMsg:" + str2 + ", rsp:" + iGProGetNavigationStatusRsp);
        if (i3 == 0 && iGProGetNavigationStatusRsp != null) {
            MutableLiveData<GuildNavigationStatus> mutableLiveData = this.E;
            if (iGProGetNavigationStatusRsp.getEnableSetting() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (iGProGetNavigationStatusRsp.getExistNavigation() != 1) {
                z17 = false;
            }
            mutableLiveData.setValue(new GuildNavigationStatus(str, z16, z17, iGProGetNavigationStatusRsp.getAuditStatus()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(IGProGuildInfo iGProGuildInfo) {
        this.F.setValue(Boolean.valueOf(X1()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(GuildNavigationStatus guildNavigationStatus) {
        this.F.setValue(Boolean.valueOf(X1()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(int i3, String str, IGProGetGuildNumRsp iGProGetGuildNumRsp) {
        QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "[initData]onGetGuildNumCallback result:" + i3 + ", errMsg:" + str + ", rsp:" + iGProGetGuildNumRsp);
        if (iGProGetGuildNumRsp != null) {
            this.f234381m.postValue(iGProGetGuildNumRsp.getGuildNumInfo());
        }
    }

    private void o2(IGPSService iGPSService) {
        long j3;
        if (!TextUtils.isEmpty(this.D)) {
            j3 = MiscKt.l(this.D);
        } else {
            j3 = 0;
        }
        bn bnVar = new bn();
        bnVar.e(j3);
        bnVar.f(false);
        bnVar.d(true);
        iGPSService.getGuildHomeCategories(bnVar, new b(bnVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(String str) {
        long j3;
        QLog.w("Guild.mnr.QQGuidInfoViewModel", 1, "loadManageFeedBlockNumber  invokeTag: " + str);
        bd bdVar = new bd();
        if (!TextUtils.isEmpty(this.D)) {
            j3 = MiscKt.l(this.D);
        } else {
            j3 = 0;
        }
        bdVar.k(j3);
        bdVar.h(false);
        bdVar.j(false);
        bdVar.i(true);
        ((IGPSService) ch.R0(IGPSService.class)).getCategoryChannelInfoListV2(bdVar, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        Boolean valueOf = Boolean.valueOf(com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().getGuildPermission(this.D).e());
        if (this.G.getValue() != valueOf) {
            this.G.setValue(valueOf);
        }
    }

    public void Z1() {
        this.K.postValue(b2());
    }

    public MutableLiveData<IGProGuildInfo> a2() {
        return this.f234380i;
    }

    public MutableLiveData<Integer> d2() {
        return this.L;
    }

    @MainThread
    public void e2(String str) {
        this.F.addSource(this.f234380i, new Observer() { // from class: cz1.bh
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                com.tencent.mobileqq.guild.setting.guildmanage.u.this.l2((IGProGuildInfo) obj);
            }
        });
        this.F.addSource(this.E, new Observer() { // from class: cz1.bi
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                com.tencent.mobileqq.guild.setting.guildmanage.u.this.m2((GuildNavigationStatus) obj);
            }
        });
        this.D = str;
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (iGPSService == null) {
            QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "initData igpsService is null");
            return;
        }
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str);
        if (guildInfo != null) {
            this.f234380i.setValue(guildInfo);
        }
        iGPSService.addObserver(this.N);
        SimpleEventBus.getInstance().registerReceiver(this);
        f2(iGPSService, str);
        c2(iGPSService, str);
        q2();
        o2(iGPSService);
        p2("initData");
        this.H.postValue(Boolean.valueOf(ch.l0(guildInfo)));
        this.I.postValue(Boolean.valueOf(ch.l0(guildInfo)));
        this.J.postValue(Boolean.valueOf(ch.l0(guildInfo)));
        Z1();
    }

    public MutableLiveData<Boolean> g2() {
        return this.I;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>(Arrays.asList(GuildNavigationStatusChangeEvent.class, GuildApplicationShowNumberEvent.class));
    }

    public MutableLiveData<Boolean> h2() {
        return this.H;
    }

    public MutableLiveData<Boolean> i2() {
        return this.J;
    }

    public LiveData<PermissionSwitchStatus> j2() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (iGPSService == null) {
            QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "onCleared igpsService is null");
        } else {
            iGPSService.deleteObserver(this.N);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildNavigationStatusChangeEvent) {
            GuildNavigationStatusChangeEvent guildNavigationStatusChangeEvent = (GuildNavigationStatusChangeEvent) simpleBaseEvent;
            QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "handle GuildNavigationStatusChangeEvent " + guildNavigationStatusChangeEvent.getNavigationStatus());
            this.E.setValue(guildNavigationStatusChangeEvent.getNavigationStatus());
        }
        if (simpleBaseEvent instanceof GuildApplicationShowNumberEvent) {
            GuildApplicationShowNumberEvent guildApplicationShowNumberEvent = (GuildApplicationShowNumberEvent) simpleBaseEvent;
            QLog.i("Guild.mnr.QQGuidInfoViewModel", 1, "handle GuildApplicationShowNumberEvent " + guildApplicationShowNumberEvent.getShowApplicationNumber());
            this.L.postValue(Integer.valueOf(guildApplicationShowNumberEvent.getShowApplicationNumber()));
        }
    }
}
