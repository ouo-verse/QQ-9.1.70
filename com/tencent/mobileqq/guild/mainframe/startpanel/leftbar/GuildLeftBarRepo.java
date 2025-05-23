package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLeftBarRepo {

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.guild.mainframe.i> f227539c;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<cs1.b> f227537a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, cs1.b> f227538b = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private int f227540d = 0;

    /* renamed from: e, reason: collision with root package name */
    private final GPServiceObserver f227541e = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class LoadGuildListTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private b f227542d;

        public LoadGuildListTask(@NonNull b bVar) {
            this.f227542d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            bi2.a.d("load_guild_list_task", "app_load_guild_list_start_event");
            com.tencent.mobileqq.guild.mainframe.util.c.b("guild_loadGuildListTask" + System.currentTimeMillis());
            TraceUtils.h("Guild.Async.LoadGuildListTask.");
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i("Guild.MF.Lt.GuildLeftBarRepo", 2, "start loadGuildList");
            }
            com.tencent.mobileqq.guild.mainframe.i iVar = (com.tencent.mobileqq.guild.mainframe.i) GuildLeftBarRepo.this.f227539c.get();
            if (iVar != null) {
                ArrayList r16 = GuildLeftBarRepo.this.r();
                IGPSService iGPSService = (IGPSService) iVar.getApp().getRuntimeService(IGPSService.class, "");
                List<IGProGuildInfo> sortedGuildList = iGPSService.getSortedGuildList();
                if (sortedGuildList == null) {
                    sortedGuildList = new ArrayList<>();
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("Guild.MF.Lt.GuildLeftBarRepo", 4, "loadGuildList sortedGuildList =" + sortedGuildList);
                }
                List<String> topGuildList = iGPSService.getTopGuildList();
                if (topGuildList == null) {
                    topGuildList = new ArrayList<>();
                }
                bi2.a.d("load_guild_list_task", "app_load_guild_list_task_convert_data_start_event");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (IGProGuildInfo iGProGuildInfo : sortedGuildList) {
                    cs1.e eVar = new cs1.e(iGProGuildInfo, topGuildList);
                    eVar.q(topGuildList);
                    r16.add(eVar);
                    arrayList.add(eVar);
                    arrayList2.add(iGProGuildInfo.getGuildID());
                }
                bi2.a.d("load_guild_list_task", "app_load_guild_list_task_convert_data_end_event");
                Collections.sort(r16, cs1.b.D);
                QLog.i("Guild.MF.Lt.GuildLeftBarRepo", 1, "loadGuildList finish. cost=" + (System.currentTimeMillis() - currentTimeMillis) + " sortedGuildIdList =" + arrayList2);
                GuildLeftBarRepo.this.u(r16);
                this.f227542d.a(r16, arrayList);
                bi2.a.d("load_guild_list_task", "app_load_guild_list_end_event");
                GuildLeftBarRepo.this.A();
                com.tencent.mobileqq.guild.mainframe.util.c.c();
                TraceUtils.k();
                return;
            }
            QLog.w("Guild.MF.Lt.GuildLeftBarRepo", 1, "context is null");
            this.f227542d.a(new ArrayList(), new ArrayList());
            com.tencent.mobileqq.guild.mainframe.util.c.c();
            TraceUtils.k();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onBannedStatusChanged(String str, boolean z16, boolean z17, boolean z18, long j3) {
            QLog.d("Guild.MF.Lt.GuildLeftBarRepo", 1, "onBannedStatusChanged guildId=", str, " isValid=", Boolean.valueOf(z16), " isBanned=", Boolean.valueOf(z17), " isFrozen=", Boolean.valueOf(z18), " guildBannedTimeLimit=", Long.valueOf(j3));
            cs1.b bVar = (cs1.b) GuildLeftBarRepo.this.f227538b.get(GuildLeftBarRepo.t(1, str));
            if (bVar != null) {
                cs1.b d16 = bVar.d();
                d16.f391797f = z17;
                GuildLeftBarRepo.this.z(bVar, d16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void a(List<cs1.b> list, List<cs1.e> list2);
    }

    public GuildLeftBarRepo(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f227539c = new WeakReference<>(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (bi2.a.c("load_guild_list_task", "sdk_init_guild_list_start_event") == 0) {
            bi2.a.a("load_guild_list_task");
            return;
        }
        B("app_load_guild_list_end_event", "sdk_init_guild_list_start_event", "metric_load_all_duration");
        B("sdk_init_guild_list_end_event", "sdk_init_guild_list_start_event", "metric_sdk_load_duration");
        B("sdk_on_guild_list_update_event", "sdk_init_guild_list_end_event", "metric_sdk_event_notify_duration");
        B("app_load_guild_list_start_event", "switch_thread_start_event", "metric_app_switch_thread_duration");
        B("app_load_guild_list_task_convert_data_end_event", "app_load_guild_list_task_convert_data_start_event", "metric_app_convert_data_duration");
        B("app_load_guild_list_end_event", "app_load_guild_list_start_event", "metric_app_load_task_duration");
        bi2.a.a("load_guild_list_task");
    }

    private void B(String str, String str2, String str3) {
        long b16 = bi2.a.b("load_guild_list_task", str, "load_guild_list_task", str2);
        HashMap hashMap = new HashMap();
        hashMap.put("cost_event", str3);
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildHistogramScene.GUILD_LOAD_GUILD_LIST_DURATION, hashMap, b16);
    }

    private boolean m(int i3, String str) {
        String t16 = t(i3, str);
        cs1.b bVar = this.f227538b.get(t16);
        if (bVar == null) {
            QLog.w("Guild.MF.Lt.GuildLeftBarRepo", 1, "deleteItem can't find " + t16);
            return false;
        }
        this.f227537a.remove(bVar);
        this.f227538b.remove(t16);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<cs1.b> r() {
        ArrayList<cs1.b> arrayList = new ArrayList<>();
        arrayList.add(new cs1.f());
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarRepo", 2, "getSpecialItems " + arrayList.size());
        }
        return arrayList;
    }

    public static String t(int i3, String str) {
        return i3 + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(ArrayList<cs1.b> arrayList) {
        this.f227537a.clear();
        this.f227537a.addAll(arrayList);
        this.f227538b.clear();
        Iterator<cs1.b> it = this.f227537a.iterator();
        while (it.hasNext()) {
            cs1.b next = it.next();
            this.f227538b.put(next.i(), next);
        }
    }

    private boolean v(cs1.b bVar) {
        if (bVar.f391795d == 1 && (bVar instanceof cs1.e) && !((cs1.e) bVar).H) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(cs1.b bVar, cs1.b bVar2) {
        int indexOf = this.f227537a.indexOf(bVar);
        if (indexOf >= 0 && indexOf < this.f227537a.size()) {
            try {
                this.f227537a.set(indexOf, bVar2);
                this.f227538b.remove(bVar.i());
                this.f227538b.put(bVar2.i(), bVar2);
                return true;
            } catch (ArrayIndexOutOfBoundsException e16) {
                QLog.e("Guild.MF.Lt.GuildLeftBarRepo", 1, "mDataList.set can't find oldItem " + e16);
                return false;
            }
        }
        QLog.w("Guild.MF.Lt.GuildLeftBarRepo", 1, "replace can't find oldItem=" + bVar.i());
        return false;
    }

    public boolean C(int i3, String str) {
        cs1.b bVar = this.f227538b.get(t(i3, str));
        if (bVar != null) {
            cs1.b d16 = bVar.d();
            d16.m();
            z(bVar, d16);
            return true;
        }
        return false;
    }

    public boolean D(int i3, String str, IGuildUnreadCntService.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Lt.GuildLeftBarRepo", 2, "updateUnreadInfo " + i3 + " key=" + str);
        }
        cs1.b bVar2 = this.f227538b.get(t(i3, str));
        if (bVar2 != null) {
            cs1.b d16 = bVar2.d();
            if (d16.h() == 1) {
                cs1.e eVar = (cs1.e) d16;
                if (!eVar.E.equals(bVar)) {
                    eVar.E = bVar;
                    z(bVar2, d16);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void g(cs1.b bVar, int i3) {
        this.f227537a.add(i3, bVar);
        this.f227538b.put(bVar.i(), bVar);
    }

    public void h() {
        com.tencent.mobileqq.guild.mainframe.i iVar = this.f227539c.get();
        if (iVar != null) {
            ((IGPSService) iVar.getApp().getRuntimeService(IGPSService.class, "")).addObserver(this.f227541e);
        } else {
            QLog.w("Guild.MF.Lt.GuildLeftBarRepo", 1, "addObservers find context is destroy");
        }
    }

    public boolean i(Set<String> set) {
        Iterator<String> it = set.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (D(1, it.next(), new IGuildUnreadCntService.b())) {
                z16 = true;
            }
        }
        return z16;
    }

    public boolean j(String str) {
        return D(1, str, new IGuildUnreadCntService.b());
    }

    public boolean k() {
        return D(4, "", new IGuildUnreadCntService.b());
    }

    public boolean l(int i3, String str) {
        return this.f227538b.containsKey(t(i3, str));
    }

    public int n(int i3, String str) {
        for (int i16 = 0; i16 < this.f227537a.size(); i16++) {
            cs1.b bVar = this.f227537a.get(i16);
            if (i3 == 0 && bVar.f391795d == i3) {
                return i16;
            }
            if (bVar.f391795d == i3 && TextUtils.equals(bVar.f391796e, str)) {
                return i16;
            }
        }
        return -1;
    }

    public int o() {
        int i3 = 0;
        while (true) {
            if (i3 < this.f227537a.size()) {
                if (this.f227537a.get(i3).f391795d == 1) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            return this.f227537a.size();
        }
        return i3;
    }

    public List<cs1.b> p() {
        return this.f227537a;
    }

    public int q() {
        int i3 = 0;
        while (true) {
            if (i3 < this.f227537a.size()) {
                if (v(this.f227537a.get(i3))) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            return this.f227537a.size();
        }
        return i3;
    }

    public cs1.b s(int i3) {
        if (i3 >= 0 && i3 < this.f227537a.size()) {
            return this.f227537a.get(i3);
        }
        QLog.w("Guild.MF.Lt.GuildLeftBarRepo", 1, "getTargetData error " + i3);
        return null;
    }

    public void w(b bVar) {
        QLog.i("Guild.MF.Lt.GuildLeftBarRepo", 1, "start loadGuildListAsync");
        bi2.a.d("load_guild_list_task", "switch_thread_start_event");
        ThreadManagerV2.excute(new LoadGuildListTask(bVar), 16, null, true);
    }

    public boolean x(int i3, String str) {
        return m(i3, str);
    }

    public void y() {
        com.tencent.mobileqq.guild.mainframe.i iVar = this.f227539c.get();
        if (iVar != null) {
            ((IGPSService) iVar.getApp().getRuntimeService(IGPSService.class, "")).deleteObserver(this.f227541e);
        } else {
            QLog.w("Guild.MF.Lt.GuildLeftBarRepo", 1, "removeObservers find context is destroy");
        }
    }
}
