package com.tencent.timi.game.teamlist.presenter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.teamlist.view.TeamListView;
import com.tencent.timi.game.utils.l;
import dn4.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mqq.util.WeakReference;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;

/* loaded from: classes26.dex */
public class TeamListPresenter implements d.a, TeamInfoAutoUpdateService.b, SimpleEventReceiver {
    private int D;
    private int E;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<TeamListView> f379802h;

    /* renamed from: d, reason: collision with root package name */
    private d f379799d = new d();

    /* renamed from: e, reason: collision with root package name */
    private a f379800e = new a();

    /* renamed from: f, reason: collision with root package name */
    private TimerHelper f379801f = new TimerHelper(this);

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f379803i = true;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f379804m = false;
    private String C = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class TimerHelper {

        /* renamed from: a, reason: collision with root package name */
        TimerTask f379805a;

        /* renamed from: b, reason: collision with root package name */
        private int f379806b = 5000;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f379807c = false;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<TeamListPresenter> f379808d;

        /* renamed from: e, reason: collision with root package name */
        private Timer f379809e;

        public TimerHelper(TeamListPresenter teamListPresenter) {
            this.f379808d = new WeakReference<>(teamListPresenter);
        }

        public void c(int i3) {
            if (i3 > 0 && i3 != this.f379806b) {
                this.f379806b = i3;
                e();
                d();
            }
        }

        void d() {
            l.i("TeamListPresenter", "startTimer limit:" + this.f379806b);
            e();
            this.f379809e = new BaseTimer();
            TimerTask timerTask = new TimerTask() { // from class: com.tencent.timi.game.teamlist.presenter.TeamListPresenter.TimerHelper.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    TeamListPresenter teamListPresenter;
                    l.i("TeamListPresenter", "onAutoUpdate limit:" + TimerHelper.this.f379806b);
                    if (TimerHelper.this.f379808d != null && (teamListPresenter = (TeamListPresenter) TimerHelper.this.f379808d.get()) != null) {
                        teamListPresenter.g();
                    }
                }
            };
            this.f379805a = timerTask;
            this.f379809e.schedule(timerTask, 0L, this.f379806b);
            this.f379807c = true;
        }

        void e() {
            try {
                TimerTask timerTask = this.f379805a;
                if (timerTask == null && this.f379809e == null) {
                    return;
                }
                if (timerTask != null) {
                    timerTask.cancel();
                }
                Timer timer = this.f379809e;
                if (timer != null) {
                    timer.cancel();
                }
                this.f379805a = null;
                this.f379809e = null;
                this.f379807c = false;
            } catch (Exception unused) {
                l.e("TeamListPresenter", "AutoUpdateCancelErr");
            }
        }
    }

    public TeamListPresenter() {
        d.f394322f = toString();
    }

    @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
    public void a(String str, List<PremadesTeamServerOuterClass$ShareYoloRoomMsg> list, List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list2, List<Long> list3) {
        this.f379799d.b(list2, this);
    }

    @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
    public List<Long> b() {
        ArrayList arrayList = new ArrayList();
        try {
            TeamListView teamListView = this.f379802h.get();
            if (teamListView != null) {
                int k3 = teamListView.k();
                int j3 = teamListView.j();
                l.i("TeamListPresenter", "onGetTeamIds start" + k3);
                l.i("TeamListPresenter", "onGetTeamIds end" + j3);
                if (k3 != -1 && j3 != -1 && this.f379799d.f394325c.size() != 0) {
                    if (j3 != 0 && j3 >= this.f379799d.f394325c.size()) {
                        j3 = this.f379799d.f394325c.size() - 1;
                    }
                    while (k3 < j3 + 1) {
                        arrayList.add(Long.valueOf(this.f379799d.f394325c.get(k3).f437250id.get()));
                        k3++;
                    }
                }
            }
        } catch (Exception e16) {
            l.e("TeamListPresenter", "onGetTeamIds err" + e16);
        }
        return arrayList;
    }

    @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
    public List<CommonOuterClass$QQUserId> d() {
        return new ArrayList();
    }

    public void e(RecyclerView recyclerView) {
        recyclerView.setAdapter(this.f379800e);
    }

    public void f() {
        m();
    }

    public void g() {
        this.f379799d.c(this.C, this.D, this.E, this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AppBecomeForegroundEvent.class);
        arrayList.add(AppBecomeBackgroundEvent.class);
        return arrayList;
    }

    public void h() {
        l.i("TeamListPresenter", "openTeamCreatePage");
        gn4.a.a();
    }

    public void i(View.OnClickListener onClickListener) {
        this.f379800e.n0(onClickListener);
    }

    public void j(String str, int i3, int i16) {
        l.i("TeamListPresenter", "Set originID:" + str);
        this.C = str;
        this.D = i3;
        this.E = i16;
    }

    public void k(TeamListView teamListView) {
        this.f379802h = new WeakReference<>(teamListView);
    }

    public void l() {
        l.i("TeamListPresenter", "startAutoUpdate");
        if (this.f379804m) {
            l.i("TeamListPresenter", "AutoUpdate already start");
            return;
        }
        this.f379804m = true;
        this.f379801f.d();
        TeamInfoAutoUpdateService.h().l("frontpage", this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void m() {
        l.i("TeamListPresenter", "stopAutoUpdate");
        this.f379804m = false;
        this.f379801f.e();
        dn4.b.f394317a = null;
        TeamInfoAutoUpdateService.h().o("frontpage");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // dn4.d.a
    public void onDataSetChange() {
        TeamListView teamListView = this.f379802h.get();
        if (teamListView != null) {
            d dVar = this.f379799d;
            teamListView.q(dVar.f394323a, dVar.f394325c.size());
        }
        a aVar = this.f379800e;
        d dVar2 = this.f379799d;
        aVar.m0(dVar2.f394325c, dVar2.f394323a, dVar2.f394326d, this.E);
        d dVar3 = this.f379799d;
        dn4.b.f394317a = dVar3.f394325c;
        this.f379801f.c(dVar3.f394324b * 1000);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AppBecomeForegroundEvent) {
            l.i("TeamListPresenter", "AppBecomeForegroundEvent called");
            this.f379803i = true;
            this.f379801f.d();
        } else if (simpleBaseEvent instanceof AppBecomeBackgroundEvent) {
            l.i("TeamListPresenter", "AppBecomeBackgroundEvent called");
            this.f379803i = false;
            this.f379801f.e();
        }
    }

    @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
    public void c() {
    }
}
