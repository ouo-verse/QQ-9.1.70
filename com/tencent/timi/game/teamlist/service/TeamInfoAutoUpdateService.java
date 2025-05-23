package com.tencent.timi.game.teamlist.service;

import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.utils.l;
import gh4.e;
import gh4.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import pl4.d;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass$UserOnlineRouteInfoList;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamInfoAutoUpdateService implements SimpleEventReceiver {

    /* renamed from: m, reason: collision with root package name */
    private static TeamInfoAutoUpdateService f379823m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f379824d = false;

    /* renamed from: e, reason: collision with root package name */
    private final TimerHelper f379825e = new TimerHelper();

    /* renamed from: f, reason: collision with root package name */
    private boolean f379826f = true;

    /* renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f379827h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private final HashMap<c, PremadesTeamServerOuterClass$UserOnlineRouteInfoList> f379828i = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class TimerHelper {

        /* renamed from: a, reason: collision with root package name */
        TimerTask f379829a;

        /* renamed from: b, reason: collision with root package name */
        private int f379830b = 1000;

        /* renamed from: c, reason: collision with root package name */
        private boolean f379831c = false;

        /* renamed from: d, reason: collision with root package name */
        private Timer f379832d;

        TimerHelper() {
        }

        public int b() {
            return this.f379830b;
        }

        public void c(int i3) {
            l.b("TeamInfoAutoUpdateService", "setAutoRefreshLimit" + i3);
            if (i3 < 1000) {
                e();
            } else if (i3 != this.f379830b) {
                this.f379830b = i3;
                e();
                d();
            }
        }

        void d() {
            l.b("TeamInfoAutoUpdateService", "startTimer limit:" + this.f379830b);
            e();
            this.f379832d = new BaseTimer();
            TimerTask timerTask = new TimerTask() { // from class: com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.TimerHelper.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    l.b("TeamInfoAutoUpdateService", "onAutoUpdate:" + TimerHelper.this.f379830b);
                    TeamInfoAutoUpdateService.this.f();
                }
            };
            this.f379829a = timerTask;
            this.f379832d.schedule(timerTask, 0L, this.f379830b);
            this.f379831c = true;
        }

        void e() {
            try {
                if (this.f379832d == null && this.f379829a == null) {
                    return;
                }
                TimerTask timerTask = this.f379829a;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                Timer timer = this.f379832d;
                if (timer != null) {
                    timer.cancel();
                }
                this.f379829a = null;
                this.f379832d = null;
                this.f379831c = false;
                TeamInfoAutoUpdateService.this.f379824d = false;
            } catch (Exception unused) {
                l.e("TeamInfoAutoUpdateService", "AutoUpdateCancelErr");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements d<PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f379835a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f379836b;

        a(List list, List list2) {
            this.f379835a = list;
            this.f379836b = list2;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp premadesTeamServerOuterClass$RefreshGameRoomInfoRsp, @Nullable FromServiceMsg fromServiceMsg) {
            TeamInfoAutoUpdateService.this.j(z16, i3, i16, i17, str, str2, premadesTeamServerOuterClass$RefreshGameRoomInfoRsp, fromServiceMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp premadesTeamServerOuterClass$RefreshGameRoomInfoRsp, FromServiceMsg fromServiceMsg) {
            TeamInfoAutoUpdateService.this.k(premadesTeamServerOuterClass$RefreshGameRoomInfoRsp, fromServiceMsg, this.f379835a, this.f379836b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void a(String str, List<PremadesTeamServerOuterClass$ShareYoloRoomMsg> list, List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list2, List<Long> list3);

        List<Long> b();

        void c();

        List<CommonOuterClass$QQUserId> d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private CommonOuterClass$QQUserId f379838a;

        /* renamed from: b, reason: collision with root package name */
        private int f379839b;

        c(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f379838a = commonOuterClass$QQUserId;
            this.f379839b = Long.valueOf(commonOuterClass$QQUserId.yes_uid.get()).hashCode();
        }

        public CommonOuterClass$QQUserId a() {
            return this.f379838a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return ll4.b.a(a(), ((c) obj).a());
            }
            return false;
        }

        public int hashCode() {
            return this.f379839b;
        }
    }

    TeamInfoAutoUpdateService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (this.f379824d) {
            l.e("TeamInfoAutoUpdateService", "doUpdate\u9891\u6b21\u63a7\u5236\u5f53\u524d\u8bf7\u6c42\u672a\u5b8c\u6210");
            return;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Map.Entry<String, b> entry : this.f379827h.entrySet()) {
            hashSet.addAll(entry.getValue().b());
            hashSet2.addAll(entry.getValue().d());
        }
        List<Long> arrayList = new ArrayList<>();
        arrayList.addAll(hashSet);
        List<CommonOuterClass$QQUserId> arrayList2 = new ArrayList<>();
        arrayList2.addAll(hashSet2);
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            l.b("TeamInfoAutoUpdateService", "\u65e0\u53ef\u89c1Team");
        } else {
            g(arrayList, arrayList2);
        }
    }

    private synchronized void g(List<Long> list, List<CommonOuterClass$QQUserId> list2) {
        int i3;
        l.b("TeamInfoAutoUpdateService", "\u53d1\u8d77\u8bf7\u6c42, teamIdList.size:" + list.size() + ", uidList.size:" + list2.size());
        this.f379824d = true;
        e I0 = ((f) mm4.b.b(f.class)).I0();
        pl4.c cVar = (pl4.c) mm4.b.b(pl4.c.class);
        if (I0 != null) {
            i3 = I0.o1();
        } else {
            i3 = 0;
        }
        cVar.F1(dn4.a.d(list, list2, i3), PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp.class, new a(list, list2));
    }

    public static synchronized TeamInfoAutoUpdateService h() {
        TeamInfoAutoUpdateService teamInfoAutoUpdateService;
        synchronized (TeamInfoAutoUpdateService.class) {
            if (f379823m == null) {
                f379823m = new TeamInfoAutoUpdateService();
            }
            teamInfoAutoUpdateService = f379823m;
        }
        return teamInfoAutoUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp premadesTeamServerOuterClass$RefreshGameRoomInfoRsp, @Nullable FromServiceMsg fromServiceMsg) {
        l.e("TeamInfoAutoUpdateService", "onError");
        int b16 = this.f379825e.b() * 2;
        if (b16 > 60000) {
            b16 = 60000;
        }
        this.f379825e.c(b16);
        this.f379824d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k(PremadesTeamServerOuterClass$RefreshGameRoomInfoRsp premadesTeamServerOuterClass$RefreshGameRoomInfoRsp, FromServiceMsg fromServiceMsg, List<Long> list, List<CommonOuterClass$QQUserId> list2) {
        l.b("TeamInfoAutoUpdateService", "onSuccess");
        this.f379824d = false;
        if (premadesTeamServerOuterClass$RefreshGameRoomInfoRsp == null) {
            return;
        }
        this.f379825e.c(premadesTeamServerOuterClass$RefreshGameRoomInfoRsp.refresh_interval.get() * 1000);
        Iterator<CommonOuterClass$QQUserId> it = list2.iterator();
        while (it.hasNext()) {
            this.f379828i.remove(new c(it.next()));
        }
        for (PremadesTeamServerOuterClass$UserOnlineRouteInfoList premadesTeamServerOuterClass$UserOnlineRouteInfoList : premadesTeamServerOuterClass$RefreshGameRoomInfoRsp.user_route_list.get()) {
            if (!premadesTeamServerOuterClass$UserOnlineRouteInfoList.list.route_list.isEmpty()) {
                this.f379828i.put(new c(premadesTeamServerOuterClass$UserOnlineRouteInfoList.user_id.get()), premadesTeamServerOuterClass$UserOnlineRouteInfoList);
            }
        }
        for (Map.Entry<String, b> entry : this.f379827h.entrySet()) {
            String key = entry.getKey();
            b value = entry.getValue();
            if (value != null) {
                try {
                    value.a(key, premadesTeamServerOuterClass$RefreshGameRoomInfoRsp.share_yolo_room_msg.get(), premadesTeamServerOuterClass$RefreshGameRoomInfoRsp.team_list.get(), list);
                    value.c();
                } catch (Exception e16) {
                    l.e("TeamInfoAutoUpdateService", "\u4e1a\u52a1Crash\uff1a" + e16);
                }
            }
        }
    }

    private synchronized void m() {
        l.b("TeamInfoAutoUpdateService", "startUpdate");
        if (!this.f379826f) {
            l.b("TeamInfoAutoUpdateService", "AppNotForeGroundExit");
        } else if (this.f379827h.size() == 0) {
            l.b("TeamInfoAutoUpdateService", "NoListenerExit");
        } else {
            this.f379825e.d();
        }
    }

    public void e() {
        this.f379828i.clear();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AppBecomeForegroundEvent.class);
        arrayList.add(AppBecomeBackgroundEvent.class);
        return arrayList;
    }

    public PremadesTeamServerOuterClass$UserOnlineRouteInfoList i(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        return this.f379828i.get(new c(commonOuterClass$QQUserId));
    }

    public synchronized void l(String str, b bVar) {
        l.b("TeamInfoAutoUpdateService", "regTeamInfoAutoUpdate requestScene = " + str);
        this.f379827h.put(str, bVar);
        if (this.f379827h.size() == 1) {
            SimpleEventBus.getInstance().registerReceiver(this);
            m();
        }
    }

    public synchronized void n() {
        l.b("TeamInfoAutoUpdateService", "stopUpdate");
        this.f379825e.e();
    }

    public synchronized void o(String str) {
        l.b("TeamInfoAutoUpdateService", "unregTeamInfoAutoUpdate requestScene = " + str);
        this.f379827h.remove(str);
        if (this.f379827h.size() == 0) {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            n();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AppBecomeForegroundEvent) {
            l.i("TeamInfoAutoUpdateService", "AppBecomeForegroundEvent called");
            this.f379826f = true;
            m();
        } else if (simpleBaseEvent instanceof AppBecomeBackgroundEvent) {
            l.i("TeamInfoAutoUpdateService", "AppBecomeBackgroundEvent called");
            this.f379826f = false;
            n();
        }
    }
}
