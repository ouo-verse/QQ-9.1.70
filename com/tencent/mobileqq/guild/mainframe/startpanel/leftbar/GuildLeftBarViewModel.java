package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.config.subconfig.parser.f;
import com.tencent.mobileqq.guild.config.y;
import com.tencent.mobileqq.guild.inbox.GuildInboxUnreadCntRepository;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.helper.d;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager;
import com.tencent.mobileqq.guild.mainframe.startpanel.GuildPicProLoaderManager;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarRepo;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.profile.me.ak;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.security.GuildChannelSwitchManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import vh2.bt;
import wh2.eh;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLeftBarViewModel extends ef1.b implements com.tencent.mobileqq.guild.theme.d {
    private final GuildLeftBarRepo C;
    private i D;
    private boolean L;
    private cs1.d M;
    private final MutableLiveData<d.a> E = new cn();
    private final MutableLiveData<d.a> F = new cn();
    private final MutableLiveData<Boolean> G = new cn();
    private final MutableLiveData<Boolean> H = new MutableLiveData<>();
    private final MutableLiveData<Boolean> I = new MutableLiveData<>();
    private final MutableLiveData<Boolean> J = new MutableLiveData<>();
    private final MutableLiveData<Boolean> K = new MutableLiveData<>();
    private boolean N = false;
    private boolean P = false;
    private Runnable Q = null;
    private boolean R = false;
    private RuntimeServiceHolder S = new RuntimeServiceHolder();
    private WeakReference<AppInterface> T = new WeakReference<>(ch.l());
    private boolean U = false;
    private int V = 0;
    private long W = 0;
    private boolean X = false;
    private final MqqHandler Y = new MqqHandler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.n
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean H2;
            H2 = GuildLeftBarViewModel.this.H2(message);
            return H2;
        }
    });
    private final IQQGuildService.b Z = new a();

    /* renamed from: a0, reason: collision with root package name */
    private final oo1.a f227544a0 = new b();

    /* renamed from: b0, reason: collision with root package name */
    private final GPServiceObserver f227545b0 = new c();

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.unread.api.d f227546c0 = new d();

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.unread.api.e f227547d0 = new InnerGuildUnreadCallback(this);

    /* renamed from: e0, reason: collision with root package name */
    private bt f227548e0 = new h(this);

    /* renamed from: f0, reason: collision with root package name */
    private final SimpleEventReceiver<GuildChannelSwitchManager.ChannelSwitchChangeEvent> f227549f0 = new e();

    /* renamed from: g0, reason: collision with root package name */
    private rr1.i f227550g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    private final ak f227551h0 = new f();

    /* renamed from: i0, reason: collision with root package name */
    private boolean f227552i0 = false;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private static class InnerGuildUnreadCallback implements com.tencent.mobileqq.guild.message.unread.api.e {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<GuildLeftBarViewModel> f227558a;

        public InnerGuildUnreadCallback(GuildLeftBarViewModel guildLeftBarViewModel) {
            this.f227558a = new WeakReference<>(guildLeftBarViewModel);
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.e
        public void a(final List<Pair<String, UnreadInfo.a>> list) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarViewModel.InnerGuildUnreadCallback.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (InnerGuildUnreadCallback.this.f227558a.get() == 0) {
                        return;
                    }
                    GuildLeftBarViewModel guildLeftBarViewModel = (GuildLeftBarViewModel) InnerGuildUnreadCallback.this.f227558a.get();
                    StringBuilder sb5 = new StringBuilder("guildUnreadCallback ");
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = list.iterator();
                    while (true) {
                        int i3 = 2;
                        if (!it.hasNext()) {
                            break;
                        }
                        Pair pair = (Pair) it.next();
                        long count = ((UnreadInfo.a) pair.getSecond()).getCount();
                        if (((UnreadInfo.a) pair.getSecond()).getIsStrongUnread()) {
                            i3 = 1;
                        }
                        guildLeftBarViewModel.C.D(1, (String) pair.getFirst(), new IGuildUnreadCntService.b(count, i3));
                        sb5.append((String) pair.getFirst());
                        sb5.append(" ");
                        sb5.append(pair.getSecond());
                        sb5.append("\n");
                    }
                    if (QLog.isDebugVersion()) {
                        QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 2, "guildUnreadObserver unreadInfoList. total cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    guildLeftBarViewModel.K2(2, null);
                    if (QLog.isColorLevel()) {
                        QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 2, sb5.toString());
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements IQQGuildService.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.api.IQQGuildService.b
        public void endDrag() {
            QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, "endDrag dragging=" + GuildLeftBarViewModel.this.U);
            if (GuildLeftBarViewModel.this.U) {
                GuildLeftBarViewModel.this.U = false;
                GuildLeftBarViewModel.this.i2();
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IQQGuildService.b
        public void startDrag() {
            QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, "startDrag");
            GuildLeftBarViewModel.this.U = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends oo1.a {
        b() {
        }

        @Override // oo1.a
        public void h() {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "onGuildConfigUpdate");
            GuildLeftBarViewModel.this.N2(2, "onGuildConfigUpdate");
        }

        @Override // oo1.a
        public void q(Object obj, int i3) {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "onUserTypeUpdate: " + obj);
            GuildLeftBarViewModel.this.N2(2, "onUserTypeUpdate");
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onBeKickFromGuild: guild: ", str, ", black: ", Integer.valueOf(i3));
            }
            GuildLeftBarViewModel.this.Q2(1, str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("guildId", str);
            hashMap.put("black", i3 + "");
            com.tencent.mobileqq.guild.performance.report.m.j().e("Guild.MF.Lt.GuildLeftBarViewModelonBeKickFromGuild", hashMap);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "onDestroy Guild:" + str);
            GuildLeftBarViewModel.this.Q2(1, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            super.onGuildInfoUpdated(str);
            if (QLog.isColorLevel()) {
                QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onGuildInfoUpdated: guild: ", str);
            }
            if (GuildLeftBarViewModel.this.C.l(1, str)) {
                GuildLeftBarViewModel.this.W2(1, str, "onGuildInfoUpdated");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildListRefreshed(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onGuildListRefreshed: result: ", Integer.valueOf(i3), ", errMsg: ", str);
            }
            if (!((IGPSService) ch.R0(IGPSService.class)).getIsGuildListFirstLoadingCallbacked()) {
                TraceUtils.h("Guild.MainUi.LeftBarDataArrived.");
                QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "onGuildListRefreshed");
                com.tencent.mobileqq.guild.performance.report.m.j().e("Guild.MF.Lt.GuildLeftBarViewModelonGuildListRefreshed", new HashMap<>());
                if (GuildLeftBarViewModel.this.Y.hasMessages(2)) {
                    GuildLeftBarViewModel.this.Y.removeMessages(2);
                    GuildLeftBarViewModel.this.N2(1, "onGuildListRefreshed");
                }
                TraceUtils.k();
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildListSortUpdated() {
            boolean isGuildListFirstLoadingCallbacked = ((IGPSService) ch.R0(IGPSService.class)).getIsGuildListFirstLoadingCallbacked();
            if (QLog.isColorLevel()) {
                QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onGuildListSortUpdated");
            }
            if (isGuildListFirstLoadingCallbacked) {
                TraceUtils.h("Guild.MainUi.Guild.Sdk.LeftBarSortedDataArrived.");
                QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "onGuildListSortUpdated");
                bi2.a.d("load_guild_list_task", "sdk_on_guild_list_update_event");
                if (GuildLeftBarViewModel.this.Y.hasMessages(2)) {
                    GuildLeftBarViewModel.this.Y.removeMessages(2);
                    GuildLeftBarViewModel.this.N2(1, "onGuildListSortUpdated");
                } else {
                    GuildLeftBarViewModel.this.N2(2, "onGuildListSortUpdated");
                }
                TraceUtils.k();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            if (QLog.isColorLevel()) {
                QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onRemoveGuild: guild: ", str);
            }
            GuildLeftBarViewModel.this.Q2(1, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onSecurityResult(IGProSecurityResult iGProSecurityResult) {
            ch.c1(iGProSecurityResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e implements SimpleEventReceiver<GuildChannelSwitchManager.ChannelSwitchChangeEvent> {
        e() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<GuildChannelSwitchManager.ChannelSwitchChangeEvent>> getEventClass() {
            ArrayList<Class<GuildChannelSwitchManager.ChannelSwitchChangeEvent>> arrayList = new ArrayList<>();
            arrayList.add(GuildChannelSwitchManager.ChannelSwitchChangeEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            if (!(simpleBaseEvent instanceof GuildChannelSwitchManager.ChannelSwitchChangeEvent)) {
                return;
            }
            QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, "onReceiveEvent " + simpleBaseEvent);
            GuildLeftBarViewModel.this.W2(1, ((GuildChannelSwitchManager.ChannelSwitchChangeEvent) simpleBaseEvent).getGuildId(), "receive ChannelSwitchEvent");
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class f implements ak {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.profile.me.ak
        public void a(@NonNull ev evVar) {
            GuildLeftBarViewModel.this.J.setValue(Boolean.TRUE);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class g implements eh {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f227566a;

        g(String str) {
            this.f227566a = str;
        }

        @Override // wh2.eh
        public void a(int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
            if (i3 == 0) {
                QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 2, "setGuildListTop succ. guildId=" + this.f227566a);
                return;
            }
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "setGuildListTop failed code=" + i3 + " errorMsg=" + str);
            if (i3 == 320003) {
                QQToastUtil.showQQToast(0, str);
            } else {
                com.tencent.mobileqq.guild.util.security.b.c(ch.i(), i3, str, "");
            }
            GuildLeftBarViewModel.this.N2(2, "onSetGuildListTop");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("result", i3 + "");
            hashMap.put("errMsg", str);
            com.tencent.mobileqq.guild.performance.report.m.j().e("Guild.MF.Lt.GuildLeftBarViewModelsetGuildListTop", hashMap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface i {
        void a(int i3, List<cs1.b> list, Runnable runnable);
    }

    GuildLeftBarViewModel(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.L = true;
        this.C = new GuildLeftBarRepo(iVar);
        y yVar = (y) am.s().x(733);
        if (yVar != null) {
            this.L = yVar.J;
        }
    }

    public static GuildLeftBarViewModel A2(ViewModelStoreOwner viewModelStoreOwner, final com.tencent.mobileqq.guild.mainframe.i iVar) {
        return (GuildLeftBarViewModel) ef1.c.a(viewModelStoreOwner, GuildLeftBarViewModel.class, new Function0() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                GuildLeftBarViewModel G2;
                G2 = GuildLeftBarViewModel.G2(com.tencent.mobileqq.guild.mainframe.i.this);
                return G2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C2(List<cs1.b> list, int i3) {
        com.tencent.mobileqq.guild.mainframe.helper.d f16 = com.tencent.mobileqq.guild.mainframe.helper.d.f();
        List<cs1.b> M2 = M2(list);
        d.a b16 = f16.b();
        boolean l3 = f16.l(M2);
        d.a b17 = f16.b();
        QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, "jump2SelectItem from=" + i3 + " needJump=" + l3 + " oldItem=" + b16 + " curSelItem=" + b17);
        if (!b16.equals(b17)) {
            this.F.setValue(b16);
        }
        if (i3 == 1 || l3) {
            this.E.setValue(b17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E2(cs1.b bVar) {
        f2((cs1.e) bVar);
        q2(2, null);
        this.Y.postDelayed(new q(this), com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.e() + 500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(cs1.b bVar, int i3) {
        g2(bVar, i3);
        this.Y.postDelayed(new q(this), com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.e() + 500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ GuildLeftBarViewModel G2(com.tencent.mobileqq.guild.mainframe.i iVar) {
        return new GuildLeftBarViewModel(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean H2(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    q2(2, null);
                    this.W = System.currentTimeMillis();
                    QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 4, "handle msg. doOnDataUpdate");
                    return false;
                }
                return false;
            }
            N2(1, "handle MESSAGE_TYPE_INIT_REFRESH");
            return false;
        }
        r2(((Integer) message.obj).intValue(), "handle MESSAGE_TYPE_REFRESH_DATA");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I2(final int i3, final List list, List list2) {
        if (list.isEmpty()) {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "loadGuildList error");
            return;
        }
        final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarViewModel.8
            @Override // java.lang.Runnable
            public void run() {
                GuildLeftBarViewModel.this.C2(list, i3);
            }
        };
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 2, "refreshGuildListData from: ", Integer.valueOf(i3), " data size=" + list.size() + " block=" + runnable.hashCode());
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 4, "refreshGuildListData data=" + list);
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            K2(i3, runnable);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarViewModel.9
                @Override // java.lang.Runnable
                public void run() {
                    GuildLeftBarViewModel.this.K2(i3, runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(int i3, Runnable runnable) {
        Object valueOf;
        if (!this.N && !this.U) {
            if (i3 != 1 && runnable == null) {
                if (!this.Y.hasMessages(3)) {
                    if (System.currentTimeMillis() - this.W > 500) {
                        q2(i3, null);
                        this.W = System.currentTimeMillis();
                        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 4, "notifyDataSetChanged doOnDataUpdate");
                        return;
                    } else {
                        Message obtainMessage = this.Y.obtainMessage(3);
                        obtainMessage.obj = Integer.valueOf(i3);
                        this.Y.sendMessageDelayed(obtainMessage, 500L);
                        return;
                    }
                }
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("notifyDataSetChanged  from=");
            sb5.append(i3);
            sb5.append(" block=");
            if (runnable == null) {
                valueOf = "";
            } else {
                valueOf = Integer.valueOf(runnable.hashCode());
            }
            sb5.append(valueOf);
            QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, sb5.toString());
            q2(i3, runnable);
            return;
        }
        this.P = true;
        this.Q = runnable;
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "notifyDataSetChanged user moving hold on!");
    }

    private List<cs1.b> M2(List<cs1.b> list) {
        if (this.M != null) {
            ArrayList arrayList = new ArrayList(list);
            arrayList.add(this.M);
            return arrayList;
        }
        return list;
    }

    private void O2(long j3) {
        boolean isGuildListFirstLoadingCallbacked = ((IGPSService) ch.R0(IGPSService.class)).getIsGuildListFirstLoadingCallbacked();
        QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "refreshDataFirstTime isGuildListReady=" + isGuildListFirstLoadingCallbacked);
        if (isGuildListFirstLoadingCallbacked) {
            N2(1, "refreshDataFirstTime");
        } else {
            this.Y.sendEmptyMessageDelayed(2, j3);
        }
    }

    private void P2(final int i3) {
        if (!this.f227552i0 && i3 != 1) {
            QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 1, "from error " + QLog.getStackTraceString(new RuntimeException("refreshGuildListData")));
            return;
        }
        this.f227552i0 = true;
        this.C.w(new GuildLeftBarRepo.b() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.p
            @Override // com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarRepo.b
            public final void a(List list, List list2) {
                GuildLeftBarViewModel.this.I2(i3, list, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(int i3, String str) {
        if (!this.C.x(i3, str)) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            wr1.d.e().c(str);
        }
        final com.tencent.mobileqq.guild.mainframe.helper.d f16 = com.tencent.mobileqq.guild.mainframe.helper.d.f();
        if (f16.b().equals(new d.a(i3, str))) {
            QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, "removeData type=" + i3 + " key=" + str);
            K2(2, new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarViewModel.10
                @Override // java.lang.Runnable
                public void run() {
                    f16.l(GuildLeftBarViewModel.this.C.p());
                    d.a b16 = f16.b();
                    GuildLeftBarViewModel.this.E.setValue(b16);
                    QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, " jump2 new=" + b16.toString());
                }
            });
            return;
        }
        K2(2, null);
    }

    private void R2() {
        if (this.T.get() != null) {
            this.T.get().removeObserver(this.f227544a0);
        }
        ((IGPSService) this.S.d(IGPSService.class)).deleteObserver(this.f227545b0);
        ((IGuildSummaryUnreadLimitService) this.S.d(IGuildSummaryUnreadLimitService.class)).unRegisterGuildUnreadCallback(this.f227547d0);
        ((IGPSService) this.S.d(IGPSService.class)).removeGuildStateListener(this.f227548e0);
        ((IGuildTotalUnreadService) this.S.d(IGuildTotalUnreadService.class)).unRegisterGuildTabUnreadCallback(this.f227546c0);
        this.C.y();
        GuildMainFrameRedDragManager.i().l(this.Z);
        SimpleEventBus.getInstance().unRegisterReceiver(this.f227549f0);
        aj.q(this.f227551h0);
        this.X = false;
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "removeObservers app=" + ch.l().hashCode() + " " + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2(int i3, String str, String str2) {
        if (this.C.C(i3, str)) {
            K2(2, null);
            if (QLog.isColorLevel()) {
                QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 2, "updateData " + i3 + " key=" + str + " source=" + str2);
                return;
            }
            return;
        }
        QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, "updateData failed. type=" + i3 + " key=" + str + " source=" + str2);
    }

    private void Y2() {
        this.G.setValue(Boolean.valueOf(GuildThemeManager.f235286a.b()));
    }

    private void f2(cs1.e eVar) {
        eVar.H = false;
        GuildLeftBarRepo guildLeftBarRepo = this.C;
        guildLeftBarRepo.g(eVar, guildLeftBarRepo.q());
    }

    private void g2(cs1.b bVar, int i3) {
        ((cs1.e) bVar).H = true;
        this.C.g(bVar, i3);
        q2(2, null);
    }

    private void h2() {
        this.X = true;
        if (this.T.get() != null) {
            this.T.get().addObserver(this.f227544a0);
        }
        ((IGPSService) this.S.d(IGPSService.class)).addObserver(this.f227545b0);
        ((IGuildSummaryUnreadLimitService) this.S.d(IGuildSummaryUnreadLimitService.class)).registerGuildUnreadCallback(this.f227547d0);
        ((IGPSService) this.S.d(IGPSService.class)).addGuildStateListener(this.f227548e0);
        ((IGuildTotalUnreadService) this.S.d(IGuildTotalUnreadService.class)).registerGuildTabUnreadCallback(this.f227546c0);
        this.C.h();
        GuildMainFrameRedDragManager.i().e(this.Z);
        SimpleEventBus.getInstance().registerReceiver(this.f227549f0);
        aj.g(this.f227551h0);
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "addObservers app=" + ch.l().hashCode() + " " + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2() {
        if (!this.N && !this.U) {
            if (this.R) {
                this.R = false;
                N2(2, "afterMove");
            } else if (this.P) {
                K2(2, this.Q);
            }
            this.P = false;
            this.Q = null;
            return;
        }
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "afterMove " + this.N + " mDragging=" + this.U);
    }

    private boolean j2() {
        int i3;
        List<String> topGuildList;
        if (ch.E() != null) {
            tg1.a a16 = ch.E().a(100);
            if (a16 instanceof f.GuildRecentConfigBean) {
                i3 = ((f.GuildRecentConfigBean) a16).getTopGuildLimit();
                topGuildList = ((IGPSService) ch.R0(IGPSService.class)).getTopGuildList();
                if (topGuildList == null && topGuildList.size() >= i3) {
                    QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "already has ", Integer.valueOf(i3), " top guild");
                    return true;
                }
            }
        }
        i3 = 5;
        topGuildList = ((IGPSService) ch.R0(IGPSService.class)).getTopGuildList();
        return topGuildList == null ? false : false;
    }

    private void o2() {
        this.F.setValue(com.tencent.mobileqq.guild.mainframe.helper.d.f().b());
        com.tencent.mobileqq.guild.mainframe.helper.d.f().a();
    }

    private void p2(String str) {
        int n3 = this.C.n(1, str);
        cs1.b s16 = this.C.s(n3);
        if (!(s16 instanceof cs1.e)) {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "doCancelTopGuild error guildId=" + str);
            J2();
            return;
        }
        final cs1.b d16 = s16.d();
        if (n3 == this.C.q() - 1) {
            QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 1, "doCancelTopGuild no need anim guildId=" + str);
            this.C.x(1, str);
            f2((cs1.e) d16);
            q2(2, null);
            this.Y.postDelayed(new q(this), 500L);
            return;
        }
        this.C.x(1, str);
        q2(2, null);
        this.Y.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.r
            @Override // java.lang.Runnable
            public final void run() {
                GuildLeftBarViewModel.this.E2(d16);
            }
        }, com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.e());
    }

    private void q2(int i3, Runnable runnable) {
        i iVar = this.D;
        if (iVar != null) {
            iVar.a(i3, this.C.p(), runnable);
        } else {
            QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 1, "notifyDataSetChanged but listener is null!!");
        }
    }

    private void r2(int i3, String str) {
        if (!this.N && !this.U) {
            boolean a16 = ca.a();
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 2, str + "refreshData from: ", Integer.valueOf(i3), " tabShow = ", Boolean.valueOf(a16));
            }
            if (!a16) {
                return;
            }
            P2(i3);
            return;
        }
        this.R = true;
        QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, str + "moving doRefreshData hold on from=" + i3);
    }

    private void s2(String str) {
        int n3 = this.C.n(1, str);
        cs1.b s16 = this.C.s(n3);
        if (!(s16 instanceof cs1.e)) {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "doTopGuild error guildId=" + str);
            J2();
            return;
        }
        final cs1.b d16 = s16.d();
        this.C.x(1, str);
        final int o16 = this.C.o();
        if (o16 == n3) {
            QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 1, "doTopGuild no need anim guildId=" + str);
            g2(d16, o16);
            this.Y.postDelayed(new q(this), 500L);
            return;
        }
        q2(2, null);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 2, "doTopGuild do anim guildId=" + str + " curPos=" + n3 + " newPos=" + o16);
        }
        this.Y.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.s
            @Override // java.lang.Runnable
            public final void run() {
                GuildLeftBarViewModel.this.F2(d16, o16);
            }
        }, com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.e());
    }

    public boolean B2(rr1.i iVar, GuildCenterPanelController.b bVar) {
        if (iVar.f() != 3) {
            return false;
        }
        if (iVar.c() == 1) {
            this.f227550g0 = iVar;
            if (QLog.isColorLevel()) {
                QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onNotify open = " + iVar);
            }
            return false;
        }
        if (this.f227550g0 == null || iVar.c() != 3) {
            return false;
        }
        this.f227550g0 = null;
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onNotify close = " + iVar);
        }
        this.H.setValue(Boolean.TRUE);
        if (bVar.f227299a == 0) {
            return false;
        }
        d.a b16 = com.tencent.mobileqq.guild.mainframe.helper.d.f().b();
        d.a y26 = y2(bVar);
        if (!b16.equals(y26)) {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 2, "need adjust item to " + y26);
            k2(y26, this.C.p());
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 2, "jump2TargetItem " + y26 + " selInfo=" + bVar);
        }
        return true;
    }

    public void D2() {
        d.a b16 = com.tencent.mobileqq.guild.mainframe.helper.d.f().b();
        List<cs1.b> p16 = this.C.p();
        d.a b17 = com.tencent.mobileqq.guild.mainframe.util.i.b(b16, p16);
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "double_jump jumpNextUnreadNode newSelItem: ", b17);
        if (b17 != null) {
            k2(b17, p16);
        }
    }

    public void J2() {
        QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "moveFinish mHasRefreshDataEvent=" + this.R + " mHasNewListToSubmit=" + this.P);
        this.N = false;
        i2();
    }

    public void L2(int i3) {
        if (i3 < this.V) {
            return;
        }
        this.V = i3;
        List<cs1.b> p16 = this.C.p();
        int size = p16.size() - 1;
        int min = Math.min(i3 + 6, size);
        for (int min2 = Math.min(i3 + 1, size); min2 < min; min2++) {
            cs1.b bVar = p16.get(min2);
            if (bVar.f391795d == 1) {
                GuildPicProLoaderManager.g().k(bVar.f391796e);
            }
        }
    }

    @MainThread
    public void N2(int i3, String str) {
        if (i3 == 1) {
            r2(i3, str);
            return;
        }
        if (i3 == 2 && !this.f227552i0) {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 2, str + " guild list not ready from=" + i3);
            return;
        }
        if (!this.Y.hasMessages(1)) {
            Message obtainMessage = this.Y.obtainMessage(1);
            obtainMessage.obj = Integer.valueOf(i3);
            this.Y.sendMessageDelayed(obtainMessage, 200L);
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 2, str + "refresh data delay 200ms from=" + i3);
            }
        }
    }

    public void S2(boolean z16, String str) {
        int i3;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "setGuildListTop failed no network");
            QQToastUtil.showQQToast(1, R.string.f1510616o);
            return;
        }
        if (z16 && j2()) {
            QQToastUtil.showQQToast(0, R.string.f157871o3);
            return;
        }
        V2();
        if (z16) {
            s2(str);
        } else {
            p2(str);
        }
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        iGPSService.setGuildListTop(str, i3, 1, new g(str));
    }

    public void T2(i iVar) {
        this.D = iVar;
    }

    public void U2(cs1.d dVar) {
        this.M = dVar;
    }

    public void V2() {
        this.N = true;
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "startMove");
    }

    public MutableLiveData<Boolean> getSelfInfoUpdateLiveData() {
        return this.J;
    }

    public void k2(d.a aVar, List<cs1.b> list) {
        d.a b16 = com.tencent.mobileqq.guild.mainframe.helper.d.f().b();
        QLog.w("Guild.MF.Lt.GuildLeftBarViewModel", 1, "need adjust item to " + aVar + " from=" + b16);
        com.tencent.mobileqq.guild.mainframe.helper.d.f().j(aVar);
        com.tencent.mobileqq.guild.mainframe.helper.d f16 = com.tencent.mobileqq.guild.mainframe.helper.d.f();
        f16.l(M2(list));
        d.a b17 = f16.b();
        if (!b16.equals(b17)) {
            this.F.setValue(b16);
        }
        this.E.setValue(b17);
    }

    public void l2(LinkedHashSet<String> linkedHashSet) {
        boolean i3 = this.C.i(linkedHashSet);
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "clearGuildUnreadDot guildId:", linkedHashSet, " changed:", Boolean.valueOf(i3));
        if (i3) {
            K2(2, null);
        }
    }

    public void m2(String str) {
        boolean j3 = this.C.j(str);
        ((IGuildUnreadService) ch.R0(IGuildUnreadService.class)).setGuildRead(str);
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "clearGuildUnreadDot guildId:", str, " changed:", Boolean.valueOf(j3));
        if (j3) {
            K2(2, null);
        }
    }

    public void n2() {
        boolean k3 = this.C.k();
        GuildInboxUnreadCntRepository.f226100d.i();
        if (k3) {
            K2(2, null);
        }
    }

    public void onAfterAccountChanged(boolean z16) {
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "onAfterAccountChanged " + z16);
        this.S = new RuntimeServiceHolder();
        this.T = new WeakReference<>(ch.l());
        h2();
        o2();
        O2(2000L);
    }

    public void onBeforeAccountChanged() {
        R2();
        this.f227552i0 = false;
        this.Y.removeMessages(1);
        this.Y.removeMessages(2);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onBeforeAccountChanged");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        onDestroy();
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 4, "onCleared");
    }

    public void onCreate() {
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 2, "onCreate");
        h2();
        GuildThemeManager.g(this);
        O2(2000L);
        wp1.c.k();
        Y2();
    }

    public void onDestroy() {
        this.N = false;
        this.U = false;
        this.f227552i0 = false;
        if (this.X) {
            R2();
        }
        GuildThemeManager.j(this);
        this.Y.removeCallbacksAndMessages(null);
        QLog.d("Guild.MF.Lt.GuildLeftBarViewModel", 1, "onDestroy " + hashCode());
        com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.a.a();
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        Y2();
    }

    public LiveData<Boolean> t2() {
        return this.H;
    }

    public MutableLiveData<d.a> u2() {
        return this.F;
    }

    public LiveData<d.a> v2() {
        return this.E;
    }

    public LiveData<Boolean> w2() {
        return this.G;
    }

    public MutableLiveData<Boolean> x2() {
        return this.I;
    }

    public d.a y2(GuildCenterPanelController.b bVar) {
        String str;
        int i3;
        int i16 = bVar.f227299a;
        int i17 = 1;
        if (i16 != 1) {
            i3 = 4;
            str = "";
            if (i16 != 4) {
                if (i16 != 5) {
                    if (i16 != 6 && i16 != 7 && i16 != 9 && i16 != 10) {
                        i3 = -1;
                    }
                }
            }
            return new d.a(i3, str);
        }
        if (((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(bVar.f227300b) == null) {
            i17 = 0;
        }
        str = bVar.f227300b;
        i3 = i17;
        return new d.a(i3, str);
    }

    public boolean z2() {
        if (Build.VERSION.SDK_INT <= 24) {
            QLog.e("Guild.MF.Lt.GuildLeftBarViewModel", 1, "getShowGuildSelectAnim false");
            return false;
        }
        return this.L;
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements com.tencent.mobileqq.guild.message.unread.api.d {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.d
        public void a(UnreadInfo.a aVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private static class h implements bt {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<GuildLeftBarViewModel> f227568a;

        public h(GuildLeftBarViewModel guildLeftBarViewModel) {
            this.f227568a = new WeakReference<>(guildLeftBarViewModel);
        }

        @Override // vh2.bt
        public void a(dt dtVar) {
        }
    }
}
