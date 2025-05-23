package com.tencent.mobileqq.guild.feed.manager;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.feed.event.GuildBeKickedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildChannelDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildChannelListUpdatedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildChannelVisibleChangedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedMuteStateChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildSpeakThresholdStateChangeEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.manager.info.GuildInfoField;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildInfoManager {

    /* renamed from: p, reason: collision with root package name */
    private static volatile GuildInfoManager f220137p;

    /* renamed from: q, reason: collision with root package name */
    private static a f220138q;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f220139a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Integer> f220140b;

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f220141c;

    /* renamed from: d, reason: collision with root package name */
    private c f220142d;

    /* renamed from: e, reason: collision with root package name */
    private b f220143e;

    /* renamed from: f, reason: collision with root package name */
    private e f220144f;

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, IGProChannelInfo> f220145g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f220146h;

    /* renamed from: i, reason: collision with root package name */
    private ScheduledExecutorService f220147i;

    /* renamed from: j, reason: collision with root package name */
    private Set<String> f220148j;

    /* renamed from: k, reason: collision with root package name */
    private IGPSService f220149k;

    /* renamed from: l, reason: collision with root package name */
    private IGProGlobalService f220150l;

    /* renamed from: m, reason: collision with root package name */
    private f f220151m;

    /* renamed from: n, reason: collision with root package name */
    private ScheduledFuture<?> f220152n = null;

    /* renamed from: o, reason: collision with root package name */
    private Runnable f220153o = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.manager.GuildInfoManager.1
        @Override // java.lang.Runnable
        public void run() {
            GuildInfoManager.q().m0(GuildInfoManager.q().p());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onAddGuildWithInfo: guildId = " + iGProGuildInfo.getGuildID());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onBeKickFromGuild: guildId[" + str + "] black[" + i3 + "]");
            SimpleEventBus.getInstance().dispatchEvent(new GuildBeKickedEvent(str, i3), true);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChangeRoleMember(String str, List<IGProRoleMemberChange> list) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onChangeRoleMember: guildId[" + str + "]");
            onGuildInfoUpdated(str);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelAdminChange(String str, String str2, int i3, List<String> list) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onChannelAdminChange: guildId[" + str + "] channelId[" + str2 + "] changeType[" + i3 + "]");
            onGuildInfoUpdated(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onChannelInfoUpdated: channelId[" + str + "]");
            IGProChannelInfo m3 = GuildInfoManager.this.m(str);
            if (m3 != null) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildChannelListUpdatedEvent(m3.getGuildId()));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onChannelListUpdated: guildId = " + str);
            SimpleEventBus.getInstance().dispatchEvent(new GuildChannelListUpdatedEvent(str));
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelSpeakPermissionChange(String str, String str2, boolean z16) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onChannelSpeakPermissionChange: guildId[" + str + "] channelId[" + str2 + "] canSpeak[" + z16 + "]");
            onGuildInfoUpdated(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(String str, String str2, int i3, int i16) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onChannelVisibleChanged: guildId[" + str + "] channelId[" + str2 + "] oldVisibleType[" + i3 + "], newVisibleType[" + i16 + "]");
            SimpleEventBus.getInstance().dispatchEvent(new GuildChannelVisibleChangedEvent(str, str2));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(String str) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onDeleteGuild: guildId[" + str + "]");
            SimpleEventBus.getInstance().dispatchEvent(new GuildDeleteEvent(str), true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onDestoryGuild: guildId[" + str + "]");
            SimpleEventBus.getInstance().dispatchEvent(new GuildDeleteEvent(str), true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            GuildInfoManager.this.i0(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(String str, List<String> list) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onPushChannelDestroy: guildId[" + str + "]");
            GuildInfoManager.this.f220141c.addAll(list);
            SimpleEventBus.getInstance().dispatchEvent(new GuildChannelDeleteEvent(str, list), true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onSecurityResult(IGProSecurityResult iGProSecurityResult) {
            super.onSecurityResult(iGProSecurityResult);
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onSecurityResult: ");
            ch.c1(iGProSecurityResult);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(String str, long j3) {
            hj1.b.b("Guild_Feed_GuildInfoManager", "GuildInfoObserver#onShutUpStateChanged: guildId[" + str + "] expireTime[" + j3 + "]");
            onGuildInfoUpdated(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b extends d implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (GuildInfoManager.O(this.f220156e, this.f220155d)) {
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(GuildInfoManager.n(this.f220156e, this.f220155d), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class c extends d implements Observer<Long> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            if (GuildInfoManager.O(this.f220156e, this.f220155d)) {
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(GuildInfoManager.n(this.f220156e, this.f220155d), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class d {

        /* renamed from: d, reason: collision with root package name */
        public String f220155d;

        /* renamed from: e, reason: collision with root package name */
        public String f220156e;

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class e extends d implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (GuildInfoManager.O(this.f220156e, this.f220155d)) {
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(GuildInfoManager.o(this.f220156e, this.f220155d, bool.booleanValue()), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class f extends d implements IGuildSpeakThresholdApi.a {
        f() {
        }

        private void a() {
            IGuildSpeakableThresholdPermission f16 = sz1.d.f(this.f220156e);
            boolean isChannelLevelAdmin = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isChannelLevelAdmin(this.f220155d);
            boolean z16 = true;
            SimpleEventBus.getInstance().dispatchEvent(new GuildSpeakThresholdStateChangeEvent(this.f220156e, this.f220155d, isChannelLevelAdmin, f16), true);
            if (TextUtils.isEmpty(this.f220155d)) {
                jj1.b c16 = jj1.b.c();
                String str = this.f220156e;
                c16.f(str, GuildInfoField.SPEAK_THRESHOLD_LIMITING, Boolean.valueOf(sz1.d.j(str)));
                return;
            }
            boolean k3 = sz1.d.k(this.f220156e, this.f220155d);
            jj1.b c17 = jj1.b.c();
            String str2 = this.f220155d;
            GuildInfoField guildInfoField = GuildInfoField.SPEAK_THRESHOLD_LIMITING;
            if (!k3 || isChannelLevelAdmin) {
                z16 = false;
            }
            c17.f(str2, guildInfoField, Boolean.valueOf(z16));
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(String str, HashSet<String> hashSet) {
            if (!TextUtils.equals(str, this.f220156e) || !hashSet.contains(this.f220155d)) {
                return;
            }
            a();
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NonNull List<String> list) {
            if (!list.contains(this.f220156e)) {
                return;
            }
            a();
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NonNull String str) {
            if (!TextUtils.equals(str, this.f220156e)) {
                return;
            }
            a();
        }
    }

    GuildInfoManager() {
        f220138q = new a();
        this.f220141c = Collections.synchronizedSet(new HashSet());
        k().addObserver(f220138q);
        this.f220140b = new ConcurrentHashMap();
        this.f220139a = new ConcurrentHashMap();
        this.f220142d = new c();
        this.f220143e = new b();
        this.f220144f = new e();
        this.f220151m = new f();
        this.f220145g = new ConcurrentHashMap<>();
        this.f220148j = new HashSet();
        this.f220146h = new HashMap();
        this.f220147i = new BaseScheduledThreadPoolExecutor(1);
    }

    private int C(String str) {
        Integer num = this.f220139a.get(str);
        if (num != null) {
            return num.intValue();
        }
        int a16 = y02.b.a();
        this.f220139a.put(str, Integer.valueOf(a16));
        return a16;
    }

    private boolean J(d dVar, String str, String str2) {
        if (!TextUtils.isEmpty(dVar.f220155d) && !TextUtils.isEmpty(dVar.f220156e) && dVar.f220155d.equals(str2) && dVar.f220156e.equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean L(String str, String str2) {
        String str3;
        if (q().P(str2) && (str3 = q().f220146h.get(str2)) != null) {
            if (t().isMute(str3) && !q().K(str, str2)) {
                return true;
            }
            return false;
        }
        return GuildSpeakLimitStatus.INSTANCE.x(p02.a.b(str, str2), str);
    }

    private boolean N(String str, String str2) {
        boolean k3 = sz1.d.k(str, str2);
        boolean isChannelLevelAdmin = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isChannelLevelAdmin(str2);
        if (k3 && !isChannelLevelAdmin) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O(String str, String str2) {
        return ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).isLimitingInChannel(str, str2);
    }

    private void W(final String str, final String str2) {
        if (MobileQQ.sProcessId == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Q(str, str2);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.manager.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildInfoManager.this.Q(str, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void Q(String str, String str2) {
        q().U(str, str2);
        q().Y(str, str2);
        q().V(str, str2);
        q().Z(str, str2);
    }

    public static synchronized void a0() {
        synchronized (GuildInfoManager.class) {
            d0();
            f220137p = null;
            f220138q = null;
        }
    }

    private static void d0() {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && !TextUtils.isEmpty(peekAppRuntime.getAccount())) {
                q().k().deleteObserver(f220138q);
            }
        } catch (Throwable th5) {
            QLog.e("Guild_Feed_GuildInfoManager", 1, "removeObserver e :" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        j0(str);
        ConcurrentHashMap<String, IGProChannelInfo> concurrentHashMap = this.f220145g;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            for (IGProChannelInfo iGProChannelInfo : this.f220145g.values()) {
                if (iGProChannelInfo != null && iGProChannelInfo.getGuildId().equals(str) && m(iGProChannelInfo.getChannelUin()) != null) {
                    this.f220141c.remove(iGProChannelInfo.getChannelUin());
                }
            }
        }
    }

    private void k0(GuildInfoField guildInfoField, String str, Long l3) {
        jj1.b.c().b(guildInfoField, Long.class, str).postValue(l3);
    }

    private void l0(String str) {
        IGProGuildInfo l3;
        if (TextUtils.isEmpty(str) || (l3 = l(str)) == null) {
            return;
        }
        k0(GuildInfoField.USER_MUTE_TIME, str, Long.valueOf(l3.getMyShutUpExpireTime()));
        k0(GuildInfoField.ALL_MUTE_TIME, str, Long.valueOf(l3.getShutUpExpireTime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            l0(it.next());
        }
        for (String str : this.f220146h.keySet()) {
            IGProChannelInfo j3 = j(str);
            if (j3 != null) {
                n0(j3.getGuildId(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GuildFeedMuteStateChangeEvent n(String str, String str2) {
        return o(str, str2, q().M(str2));
    }

    private void n0(String str, String str2) {
        String str3 = this.f220146h.get(str2);
        if (str3 != null) {
            long muteSelfTime = t().getMuteSelfTime(str3);
            long muteAllTime = t().getMuteAllTime(str3);
            k0(GuildInfoField.USER_MUTE_TIME, str, Long.valueOf(muteSelfTime));
            if (muteAllTime != 0) {
                k0(GuildInfoField.ALL_MUTE_TIME, str, Long.MAX_VALUE);
            } else {
                k0(GuildInfoField.ALL_MUTE_TIME, str, Long.valueOf(muteAllTime));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GuildFeedMuteStateChangeEvent o(String str, String str2, boolean z16) {
        long j3;
        GuildFeedMuteStateChangeEvent guildFeedMuteStateChangeEvent = new GuildFeedMuteStateChangeEvent(str, str2, L(str, str2), z16, q().K(str, str2), q().r(str, str2), q().w(str, str2));
        GuildInfoManager q16 = q();
        boolean z17 = true;
        if (q16.P(str2)) {
            guildFeedMuteStateChangeEvent.myShutUpExpireTime = q16.G(str2);
            long E = q16.E(str2);
            guildFeedMuteStateChangeEvent.globalShutUpExpireTime = E;
            if (!com.tencent.mobileqq.guild.setting.mute.c.O(Long.valueOf(Math.max(guildFeedMuteStateChangeEvent.myShutUpExpireTime, E))) || guildFeedMuteStateChangeEvent.isManager) {
                z17 = false;
            }
            guildFeedMuteStateChangeEvent.isAtomicMute = z17;
        } else {
            Long value = com.tencent.mobileqq.guild.setting.mute.c.C(str).getValue();
            long j16 = -1;
            if (value != null) {
                j3 = value.longValue();
            } else {
                j3 = -1;
            }
            guildFeedMuteStateChangeEvent.myShutUpExpireTime = j3;
            Long value2 = com.tencent.mobileqq.guild.setting.mute.c.s(str).getValue();
            if (value2 != null) {
                j16 = value2.longValue();
            }
            guildFeedMuteStateChangeEvent.globalShutUpExpireTime = j16;
            if (!com.tencent.mobileqq.guild.setting.mute.c.T(str) || com.tencent.mobileqq.guild.setting.mute.c.M(str)) {
                z17 = false;
            }
            guildFeedMuteStateChangeEvent.isAtomicMute = z17;
        }
        return guildFeedMuteStateChangeEvent;
    }

    public static GuildInfoManager q() {
        if (f220137p == null) {
            synchronized (GuildInfoManager.class) {
                if (f220137p == null) {
                    f220137p = new GuildInfoManager();
                }
            }
        }
        return f220137p;
    }

    private static ITroopGuildPermissionService t() {
        return (ITroopGuildPermissionService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopGuildPermissionService.class, "");
    }

    public String A(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str + "|" + str2;
        }
        QLog.d("Guild_Feed_GuildInfoManager", 1, "getSquareSaveKey: params is empty.");
        return "";
    }

    public int B(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        return C(z(guildFeedBaseInitBean));
    }

    public int D(String str, String str2) {
        return C(A(str, str2));
    }

    public long E(String str) {
        String str2 = this.f220146h.get(str);
        if (TextUtils.isEmpty(str2)) {
            return -1L;
        }
        return t().getMuteAllTime(str2);
    }

    public String F(String str, String str2) {
        boolean z16;
        boolean z17;
        String str3 = this.f220146h.get(str2);
        if (str3 != null) {
            long serverTime = NetConnInfoCenter.getServerTime();
            long muteSelfTime = t().getMuteSelfTime(str3);
            if (t().getMuteAllTime(str3) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (muteSelfTime > serverTime) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16) {
                return HardCodeUtil.qqStr(R.string.f143790n1);
            }
            if (z17) {
                return String.format(HardCodeUtil.qqStr(R.string.f143800n2), com.tencent.mobileqq.guild.setting.mute.c.B(Long.valueOf(muteSelfTime)));
            }
            return "";
        }
        return "";
    }

    public long G(String str) {
        String str2 = this.f220146h.get(str);
        if (TextUtils.isEmpty(str2)) {
            return -1L;
        }
        return t().getMuteSelfTime(str2);
    }

    public void H(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!ch.j0(str) && O(str, str2)) {
                return;
            }
            GuildFeedMuteStateChangeEvent n3 = n(str, str2);
            QLog.i("Guild_Feed_GuildInfoManager", 1, "handlerUpdateMuteState: event[" + n3.toString() + "]");
            SimpleEventBus.getInstance().dispatchEvent(n3, true);
            W(str, str2);
            R();
            m(str2);
        }
    }

    public void I(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QLog.i("Guild_Feed_GuildInfoManager", 2, "handlerUpdateSpeakThresholdState guildId=" + str);
            SimpleEventBus.getInstance().dispatchEvent(new GuildSpeakThresholdStateChangeEvent(str, str2, ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isChannelLevelAdmin(str2), sz1.d.f(str)), true);
            W(str, str2);
        }
    }

    public boolean K(String str, String str2) {
        String str3;
        if (P(str2) && (str3 = this.f220146h.get(str2)) != null) {
            return t().isAdmin(str3);
        }
        return com.tencent.mobileqq.guild.setting.mute.c.V(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (K(r0.getGuildId(), r6) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (r6.getMyGuildGlobalAuth() != 1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean M(String str) {
        boolean z16;
        IGProChannelInfo j3 = j(str);
        if (j3 != null) {
            z16 = false;
            if (P(str)) {
                if (1 != j3.getTalkPermission()) {
                    if (2 == j3.getTalkPermission()) {
                    }
                }
            } else if (j3.isHiddenPostChannel()) {
                IGProGuildInfo L = ch.L(j3.getGuildId());
                if (L != null) {
                }
            } else {
                z16 = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).canSpeakInChannel(j3);
            }
            return !z16;
        }
        z16 = true;
        return !z16;
    }

    public boolean P(String str) {
        if (this.f220146h.containsKey(str)) {
            return true;
        }
        return false;
    }

    public void R() {
        if (this.f220152n == null) {
            this.f220152n = this.f220147i.scheduleWithFixedDelay(this.f220153o, 30000L, 30000L, TimeUnit.MILLISECONDS);
        }
    }

    public void S(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild_Feed_GuildInfoManager", 4, str);
        }
    }

    public void T(String str) {
        this.f220148j.add(str);
    }

    public void U(String str, String str2) {
        if (J(this.f220143e, str, str2)) {
            return;
        }
        b bVar = this.f220143e;
        bVar.f220156e = str;
        bVar.f220155d = str2;
        jj1.b.c().e(GuildInfoField.IS_MANAGER, Boolean.class, str2, this.f220143e);
    }

    public void V(String str, String str2) {
        T(str);
        c cVar = this.f220142d;
        cVar.f220156e = str;
        cVar.f220155d = str2;
        jj1.b.c().e(GuildInfoField.USER_MUTE_TIME, Long.class, str, this.f220142d);
    }

    public void Y(String str, String str2) {
        if (J(this.f220144f, str, str2)) {
            return;
        }
        e eVar = this.f220144f;
        eVar.f220156e = str;
        eVar.f220155d = str2;
        jj1.b.c().e(GuildInfoField.IS_RESTRICT_POST, Boolean.class, str2, this.f220144f);
    }

    public void Z(String str, String str2) {
        if (J(this.f220151m, str, str2)) {
            return;
        }
        S("registerSpeakThresholdObserve gId:" + str + " cId:" + str2);
        sz1.d.p(this.f220151m);
        f fVar = this.f220151m;
        fVar.f220156e = str;
        fVar.f220155d = str2;
        sz1.d.e(fVar);
    }

    public void b0(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        if (guildFeedBaseInitBean instanceof GuildFeedSquareInitBean) {
            c0(guildFeedBaseInitBean);
            return;
        }
        String u16 = u(guildFeedBaseInitBean);
        Map<String, Integer> map = this.f220140b;
        if (map != null) {
            map.remove(u16);
            QLog.d("Guild_Feed_GuildInfoManager", 1, "removeChannelSortModeRecord| " + u16 + " remove success");
        }
    }

    public void c0(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        String z16 = z(guildFeedBaseInitBean);
        Map<String, Integer> map = this.f220139a;
        if (map != null) {
            map.remove(z16);
        }
    }

    public void e0() {
        ScheduledFuture<?> scheduledFuture = this.f220152n;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f220152n = null;
        }
    }

    public void f0(GuildFeedBaseInitBean guildFeedBaseInitBean, int i3) {
        if (guildFeedBaseInitBean instanceof GuildFeedSquareInitBean) {
            g0(guildFeedBaseInitBean, i3);
        } else {
            this.f220140b.put(u(guildFeedBaseInitBean), Integer.valueOf(i3));
        }
    }

    public void g0(GuildFeedBaseInitBean guildFeedBaseInitBean, int i3) {
        this.f220139a.put(z(guildFeedBaseInitBean), Integer.valueOf(i3));
    }

    public void h(String str, String str2) {
        this.f220146h.put(str, str2);
    }

    public void h0() {
        sz1.d.p(this.f220151m);
        f fVar = this.f220151m;
        fVar.f220156e = "";
        fVar.f220155d = "";
    }

    public IGPSService i() {
        IGPSService iGPSService = this.f220149k;
        if (iGPSService != null) {
            return iGPSService;
        }
        IGPSService iGPSService2 = (IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface().getRuntimeService(IGPSService.class, "");
        this.f220149k = iGPSService2;
        return iGPSService2;
    }

    @Nullable
    public IGProChannelInfo j(String str) {
        return i().getChannelInfo(str);
    }

    public void j0(String str) {
        boolean z16;
        IGProGuildInfo L = ch.L(str);
        boolean j3 = sz1.d.j(str);
        boolean K = K(str, "");
        if (L != null && L.getMyGuildGlobalAuth() != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        jj1.b.c().f(str, GuildInfoField.SPEAK_THRESHOLD_LIMITING, Boolean.valueOf(j3));
        l0(str);
        QLog.d("Guild_Feed_GuildInfoManager", 1, "update updateGuildInfo :  isSpeakThresholdLimiting :" + j3 + " manager :" + K);
        jj1.b.c().f(str, GuildInfoField.IS_MANAGER, Boolean.valueOf(K));
        jj1.b.c().f(str, GuildInfoField.IS_MEMBER, Boolean.valueOf(true ^ ch.j0(str)));
        jj1.b.c().f(str, GuildInfoField.IS_RESTRICT_POST, Boolean.valueOf(z16));
    }

    public IGProGlobalService k() {
        IGProGlobalService iGProGlobalService = this.f220150l;
        if (iGProGlobalService != null) {
            return iGProGlobalService;
        }
        IGProGlobalService iGProGlobalService2 = (IGProGlobalService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface().getRuntimeService(IGProGlobalService.class, "");
        this.f220150l = iGProGlobalService2;
        return iGProGlobalService2;
    }

    public IGProGuildInfo l(String str) {
        return i().getGuildInfo(str);
    }

    public IGProChannelInfo m(String str) {
        boolean z16;
        IGProChannelInfo j3 = j(str);
        if (j3 == null) {
            QLog.e("Guild_Feed_GuildInfoManager", 1, "queryProGuildInfo is null, id:" + str);
            return null;
        }
        this.f220145g.put(j3.getChannelUin(), j3);
        boolean z17 = false;
        if (j3.getVisibleType() != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (j3.getFinalMsgNotify() == 2) {
            z17 = true;
        }
        String channelName = j3.getChannelName();
        boolean L = L(j3.getGuildId(), j3.getChannelUin());
        boolean N = N(j3.getGuildId(), j3.getChannelUin());
        boolean M = M(j3.getChannelUin());
        boolean K = K(j3.getGuildId(), j3.getChannelUin());
        S("update ChannelInfo : " + j3.getChannelUin() + " private :" + z16 + " name :" + channelName + " disturb :" + z17 + " mute :" + L + " isSpeakThresholdLimiting: " + N + " restrictPost :" + M + " manager :" + K);
        jj1.b.c().f(str, GuildInfoField.SPEAK_THRESHOLD_LIMITING, Boolean.valueOf(N));
        if (P(str)) {
            n0(j3.getGuildId(), str);
        } else {
            l0(j3.getGuildId());
        }
        jj1.b.c().f(str, GuildInfoField.IS_PRIVATE_CHANNEL, Boolean.valueOf(z16));
        jj1.b.c().f(str, GuildInfoField.CHANNEL_NAME, channelName);
        jj1.b.c().f(str, GuildInfoField.IS_DISTURB, Boolean.valueOf(z17));
        jj1.b.c().f(str, GuildInfoField.IS_RESTRICT_POST, Boolean.valueOf(M));
        jj1.b.c().f(str, GuildInfoField.IS_MANAGER, Boolean.valueOf(K));
        jj1.b.c().f(j3.getGuildId(), GuildInfoField.IS_MEMBER, Boolean.valueOf(!ch.j0(j3.getGuildId())));
        jj1.b.c().initOrUpdateGlobalState((jj1.b) com.tencent.mobileqq.guild.feed.manager.info.a.a(j3), true);
        return j3;
    }

    public Set<String> p() {
        return this.f220148j;
    }

    public String r(String str, String str2) {
        if (P(str2)) {
            return F(str, str2);
        }
        return com.tencent.mobileqq.guild.setting.mute.c.u(str, str2);
    }

    @NonNull
    public Pair<Long, Long> s(String str, String str2) {
        if (P(str2)) {
            return new Pair<>(Long.valueOf(E(str2)), Long.valueOf(G(str2)));
        }
        com.tencent.mobileqq.guild.setting.mute.c.u(str, str2);
        return new Pair<>(com.tencent.mobileqq.guild.setting.mute.c.s(str).getValue(), com.tencent.mobileqq.guild.setting.mute.c.C(str).getValue());
    }

    public String u(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        if (guildFeedBaseInitBean == null) {
            QLog.d("Guild_Feed_GuildInfoManager", 1, "getShareKey initBeanEmpty");
            return "";
        }
        String u16 = ax.u();
        if (TextUtils.isEmpty(u16)) {
            QLog.d("Guild_Feed_GuildInfoManager", 1, "getShareKey tinyId empty");
            return "";
        }
        return v(u16, guildFeedBaseInitBean.getGuildId(), guildFeedBaseInitBean.getChannelId());
    }

    public String v(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return str + "|" + str2 + "|" + str3 + "|";
        }
        QLog.d("Guild_Feed_GuildInfoManager", 1, "getShareKey: params is empty.");
        return "";
    }

    public String w(String str, String str2) {
        boolean z16;
        String str3;
        if (P(str2)) {
            String str4 = this.f220146h.get(str2);
            if (str4 != null && t().getMuteAllTime(str4) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str3 = "\u5168\u5458";
            } else {
                str3 = "";
            }
            return String.format(HardCodeUtil.qqStr(R.string.f1506615l), str3);
        }
        return com.tencent.mobileqq.guild.setting.mute.c.z(str);
    }

    public int x(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        if (guildFeedBaseInitBean == null) {
            QLog.d("Guild_Feed_GuildInfoManager", 1, "getShareKey initBeanEmpty");
            return ax.f223858e;
        }
        if (guildFeedBaseInitBean instanceof GuildFeedSquareInitBean) {
            return B(guildFeedBaseInitBean);
        }
        return y(ax.u(), guildFeedBaseInitBean.getGuildId(), guildFeedBaseInitBean.getChannelId());
    }

    public int y(String str, String str2, String str3) {
        String v3 = v(str, str2, str3);
        Integer num = this.f220140b.get(v3);
        if (num != null) {
            return num.intValue();
        }
        IGProChannelInfo j3 = j(str3);
        if (j3 == null) {
            S("getSortMode| channelInfo is null, return default");
            return ax.f223858e;
        }
        int forumSortMode = j3.getForumSortMode();
        if (forumSortMode == 0) {
            forumSortMode = ax.f223858e;
            S("getSortMode| gprSortConfig is INVALID, set SORT_MODE_DEFAULT");
        }
        this.f220140b.put(v3, Integer.valueOf(forumSortMode));
        S("getSortMode| save channelSortMode, key = " + v3 + ", mode = " + forumSortMode);
        return forumSortMode;
    }

    public String z(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        if (guildFeedBaseInitBean == null) {
            QLog.d("Guild_Feed_GuildInfoManager", 1, "getSquareSaveKey initBeanEmpty");
            return "";
        }
        String u16 = ax.u();
        if (!TextUtils.isEmpty(u16) && !TextUtils.isEmpty(guildFeedBaseInitBean.getGuildId())) {
            return u16 + "|" + guildFeedBaseInitBean.getGuildId();
        }
        QLog.d("Guild_Feed_GuildInfoManager", 1, "getSquareSaveKey empty");
        return "";
    }
}
