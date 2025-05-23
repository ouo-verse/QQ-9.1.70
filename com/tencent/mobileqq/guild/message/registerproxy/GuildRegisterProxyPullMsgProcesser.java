package com.tencent.mobileqq.guild.message.registerproxy;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyPullMsgProcesser;
import com.tencent.mobileqq.guild.message.registerproxy.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelParam;

/* loaded from: classes14.dex */
public class GuildRegisterProxyPullMsgProcesser implements h, f {

    /* renamed from: a, reason: collision with root package name */
    private int f230737a;

    /* renamed from: c, reason: collision with root package name */
    GuildRegisterProxyMsgHandler f230739c;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f230740d;

    /* renamed from: b, reason: collision with root package name */
    private int f230738b = 0;

    /* renamed from: e, reason: collision with root package name */
    private List<c> f230741e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    private List<c> f230742f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    private int f230743g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f230744h = false;

    /* renamed from: i, reason: collision with root package name */
    private long f230745i = 0;

    /* renamed from: j, reason: collision with root package name */
    private final ConcurrentHashMap<Long, Long> f230746j = new ConcurrentHashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private final ConcurrentHashMap<Long, Long> f230747k = new ConcurrentHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    boolean f230748l = false;

    /* renamed from: m, reason: collision with root package name */
    private long f230749m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f230750n = 0;

    /* renamed from: o, reason: collision with root package name */
    private Handler f230751o = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), new a());

    /* renamed from: p, reason: collision with root package name */
    private final Comparator<c> f230752p = new b();

    /* renamed from: q, reason: collision with root package name */
    private final Comparator<c> f230753q = new Comparator() { // from class: com.tencent.mobileqq.guild.message.registerproxy.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int v3;
            v3 = GuildRegisterProxyPullMsgProcesser.v((GuildRegisterProxyPullMsgProcesser.c) obj, (GuildRegisterProxyPullMsgProcesser.c) obj2);
            return v3;
        }
    };

    /* loaded from: classes14.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what == 10) {
                GuildRegisterProxyPullMsgProcesser.this.z();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes14.dex */
    class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null || obj2 == null) {
                return 0;
            }
            long j3 = ((c) obj).f230757a;
            long j16 = ((c) obj2).f230757a;
            if (j3 == j16) {
                return 0;
            }
            if (j3 > j16) {
                return -1;
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public long f230757a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f230758b = 0;

        /* renamed from: c, reason: collision with root package name */
        public boolean f230759c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f230760d = false;

        /* renamed from: e, reason: collision with root package name */
        public synclogic$ChannelParam f230761e = new synclogic$ChannelParam();
    }

    public GuildRegisterProxyPullMsgProcesser(AppInterface appInterface, GuildRegisterProxyMsgHandler guildRegisterProxyMsgHandler, int i3) {
        this.f230737a = 0;
        this.f230739c = guildRegisterProxyMsgHandler;
        this.f230740d = appInterface;
        guildRegisterProxyMsgHandler.H2().a(this);
        this.f230737a = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A(ArrayList<synclogic$ChannelParam> arrayList, int i3, boolean z16) {
        u(z16, i3);
        B(arrayList);
    }

    private boolean C() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f230749m < r()) {
            this.f230750n++;
        } else {
            this.f230750n = 0;
        }
        this.f230749m = currentTimeMillis;
        if (this.f230750n < j()) {
            return false;
        }
        QLog.i("RP_improve_tag", 1, "shouldDelayPullMsg. frequentlyPullMsgCount: " + this.f230750n);
        return true;
    }

    private void g() {
        QLog.e("GuildRegisterProxyPullMsgProcesser", 1, "checkEndResult pushFlagEnd:" + this.f230744h + " taskSeqList.size():" + this.f230746j.size());
        if (this.f230744h && this.f230746j.size() == 0) {
            w(ou1.a.f424094m, true, new Object[]{Integer.valueOf(this.f230743g), null});
            QLog.i("GuildRegisterProxyPullMsgProcesser", 1, "handlePushChannelMsg once success");
            final ArrayList<synclogic$ChannelParam> q16 = q();
            if (q16.size() <= 0) {
                QLog.i("GuildRegisterProxyPullMsgProcesser", 1, "handlePushChannelMsg all success");
                this.f230748l = false;
                w(ou1.a.C, true, new Object[]{Integer.valueOf(this.f230743g), null});
            } else {
                int n3 = n();
                if (QLog.isColorLevel()) {
                    QLog.d("RP_improve_tag", 2, "checkEndResult, reqChannelCnt=", Integer.valueOf(this.f230738b), ", pullInterval=", Integer.valueOf(n3));
                }
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyPullMsgProcesser.5
                    @Override // java.lang.Runnable
                    public void run() {
                        GuildRegisterProxyPullMsgProcesser guildRegisterProxyPullMsgProcesser = GuildRegisterProxyPullMsgProcesser.this;
                        guildRegisterProxyPullMsgProcesser.A(q16, guildRegisterProxyPullMsgProcesser.f230738b, false);
                    }
                }, 16, null, true, n3);
            }
        }
    }

    private synclogic$ChannelParam h(c cVar) {
        long I2 = this.f230739c.I2();
        if ((cVar.f230760d || (cVar.f230759c && cVar.f230758b != 1)) && cVar.f230761e.channel_id.get() != I2) {
            long j3 = cVar.f230761e.end_seq.get();
            long j16 = cVar.f230761e.begin_seq.get();
            long p16 = p();
            long j17 = 1;
            if (j3 >= p16) {
                j17 = 1 + (j3 - p16);
            }
            if (j17 > j16) {
                cVar.f230761e.begin_seq.set(j17);
            }
        }
        return cVar.f230761e;
    }

    private boolean i(ArrayList<com.tencent.mobileqq.guild.message.registerproxy.b> arrayList) {
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService;
        ArrayList arrayList2;
        Iterator<com.tencent.mobileqq.guild.message.registerproxy.b> it;
        ArrayList arrayList3;
        HashMap hashMap;
        ArrayList arrayList4;
        long j3;
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService2 = (IGuildMsgSeqTimeService) this.f230740d.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList<c> arrayList7 = new ArrayList<>();
        HashMap hashMap2 = new HashMap();
        Iterator<com.tencent.mobileqq.guild.message.registerproxy.b> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.guild.message.registerproxy.b next = it5.next();
            int o16 = o(next.f230766b);
            Iterator<b.a> it6 = next.f230767c.iterator();
            while (it6.hasNext()) {
                b.a next2 = it6.next();
                IGuildMsgSeqTimeService.a lastLocallMsgSeq = iGuildMsgSeqTimeService2.getLastLocallMsgSeq(String.valueOf(next2.f230768a));
                long j16 = next2.f230769b;
                if (j16 > 0) {
                    iGuildMsgSeqTimeService = iGuildMsgSeqTimeService2;
                    arrayList2 = arrayList5;
                    if (j16 > lastLocallMsgSeq.f230119d || !lastLocallMsgSeq.d()) {
                        c cVar = new c();
                        cVar.f230757a = next2.f230770c;
                        cVar.f230758b = next2.f230771d;
                        cVar.f230761e.guild_id.set(next.f230765a);
                        cVar.f230761e.channel_id.set(next2.f230768a);
                        if (!lastLocallMsgSeq.d()) {
                            long j17 = next2.f230769b;
                            HashMap hashMap3 = hashMap2;
                            it = it5;
                            long j18 = o16;
                            if (j17 >= j18) {
                                j3 = (j17 - j18) + 1;
                            } else {
                                j3 = 1;
                            }
                            hashMap = hashMap3;
                            arrayList4 = arrayList6;
                        } else {
                            HashMap hashMap4 = hashMap2;
                            it = it5;
                            long j19 = next2.f230769b;
                            long j26 = lastLocallMsgSeq.f230119d;
                            hashMap = hashMap4;
                            arrayList4 = arrayList6;
                            long j27 = o16;
                            if (j19 - j26 >= j27) {
                                j3 = (j19 - j27) + 1;
                            } else {
                                j3 = j26 + 1;
                            }
                        }
                        cVar.f230761e.begin_seq.set(j3);
                        cVar.f230761e.end_seq.set(next2.f230769b);
                        if (lastLocallMsgSeq.d()) {
                            cVar.f230761e.max_seq_local.set(lastLocallMsgSeq.f230119d);
                        }
                        QLog.d("GuildRegisterProxyPullMsgProcesser", 1, "fillPullMsgList beginSeq: " + j3 + ", endSeq: " + next2.f230769b + ", maxSeqLocal: " + lastLocallMsgSeq.f230119d + ", channelId: " + next2.f230768a + ", isHugeGuild: " + next.f230766b);
                        if (next2.f230772e) {
                            cVar.f230760d = true;
                            arrayList7.add(cVar);
                            arrayList3 = arrayList4;
                        } else if (next.f230766b) {
                            cVar.f230759c = true;
                            arrayList3 = arrayList4;
                            arrayList3.add(cVar);
                        } else {
                            arrayList3 = arrayList4;
                            hashMap2 = hashMap;
                            if (!hashMap2.containsKey(Long.valueOf(next.f230765a))) {
                                hashMap2.put(Long.valueOf(next.f230765a), new ArrayList(Collections.singletonList(cVar)));
                            } else {
                                ((ArrayList) hashMap2.get(Long.valueOf(next.f230765a))).add(cVar);
                            }
                            arrayList6 = arrayList3;
                            iGuildMsgSeqTimeService2 = iGuildMsgSeqTimeService;
                            arrayList5 = arrayList2;
                            it5 = it;
                        }
                        hashMap2 = hashMap;
                        arrayList6 = arrayList3;
                        iGuildMsgSeqTimeService2 = iGuildMsgSeqTimeService;
                        arrayList5 = arrayList2;
                        it5 = it;
                    }
                } else {
                    iGuildMsgSeqTimeService = iGuildMsgSeqTimeService2;
                    arrayList2 = arrayList5;
                }
                arrayList3 = arrayList6;
                it = it5;
                if (lastLocallMsgSeq.d()) {
                    QLog.d("GuildRegisterProxyPullMsgProcesser", 1, "not fillPullMsgList channelId:" + next2.f230768a + ", localMsgSeqTimeItem: " + lastLocallMsgSeq.toString());
                }
                arrayList6 = arrayList3;
                iGuildMsgSeqTimeService2 = iGuildMsgSeqTimeService;
                arrayList5 = arrayList2;
                it5 = it;
            }
        }
        ArrayList arrayList8 = arrayList5;
        ArrayList arrayList9 = arrayList6;
        ArrayList arrayList10 = new ArrayList();
        for (ArrayList arrayList11 : hashMap2.values()) {
            c cVar2 = (c) Collections.min(arrayList11, this.f230752p);
            arrayList10.add(cVar2);
            arrayList11.remove(cVar2);
        }
        Collections.sort(arrayList10, this.f230752p);
        arrayList8.addAll(arrayList10);
        ArrayList arrayList12 = new ArrayList();
        for (ArrayList arrayList13 : hashMap2.values()) {
            if (arrayList13.size() > 0) {
                arrayList12.addAll(arrayList13);
            }
        }
        Collections.sort(arrayList12, this.f230752p);
        arrayList8.addAll(arrayList12);
        this.f230742f = arrayList9;
        if (arrayList8.size() > 0 || arrayList9.size() > 0 || arrayList7.size() > 0) {
            this.f230741e = arrayList8;
            t();
            s(arrayList7);
            if (this.f230741e.size() > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    private int j() {
        return ((nu1.a) am.s().x(com.tencent.luggage.wxa.uf.i.CTRL_INDEX)).f421298j;
    }

    private int k() {
        if (this.f230737a == 1) {
            return ((nu1.a) am.s().x(com.tencent.luggage.wxa.uf.i.CTRL_INDEX)).f421290b;
        }
        return 15;
    }

    private int l() {
        if (this.f230737a == 1) {
            return ((nu1.a) am.s().x(com.tencent.luggage.wxa.uf.i.CTRL_INDEX)).f421291c;
        }
        return this.f230741e.size();
    }

    private int m() {
        return ((nu1.a) am.s().x(com.tencent.luggage.wxa.uf.i.CTRL_INDEX)).f421296h;
    }

    private int n() {
        return ((nu1.a) am.s().x(com.tencent.luggage.wxa.uf.i.CTRL_INDEX)).f421289a;
    }

    private int o(boolean z16) {
        if (this.f230737a == 1) {
            nu1.a aVar = (nu1.a) am.s().x(com.tencent.luggage.wxa.uf.i.CTRL_INDEX);
            if (z16) {
                return aVar.f421294f;
            }
            return aVar.f421293e;
        }
        return 15;
    }

    private int p() {
        if (this.f230737a == 1) {
            return ((nu1.a) am.s().x(com.tencent.luggage.wxa.uf.i.CTRL_INDEX)).f421295g;
        }
        return 15;
    }

    private ArrayList<synclogic$ChannelParam> q() {
        int i3;
        int k3 = k();
        if (QLog.isColorLevel()) {
            QLog.d("RP_improve_tag", 2, "getPullMsgReqNext start, maxOncePullSize=", Integer.valueOf(k3), ", reqChannelCnt=", Integer.valueOf(this.f230738b), ", pullMsgOrderedList size=", Integer.valueOf(this.f230741e.size()));
        }
        ArrayList<synclogic$ChannelParam> arrayList = new ArrayList<>();
        if (this.f230741e.size() > 0) {
            if (this.f230741e.get(0).f230760d) {
                i3 = 0;
                while (i3 < this.f230741e.size() && this.f230741e.get(i3).f230760d) {
                    arrayList.add(h(this.f230741e.get(i3)));
                    i3++;
                }
            } else {
                int i16 = 0;
                while (i16 < this.f230741e.size() && i16 < k3 && this.f230738b > i16) {
                    arrayList.add(h(this.f230741e.get(i16)));
                    i16++;
                }
                i3 = i16;
            }
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildRegisterProxyPullMsgProcesser", 2, "getPullMsgReqNext index:" + i3);
        }
        if (i3 > 0) {
            this.f230741e.subList(0, i3).clear();
            this.f230738b -= i3;
        }
        this.f230747k.clear();
        Iterator<synclogic$ChannelParam> it = arrayList.iterator();
        while (it.hasNext()) {
            synclogic$ChannelParam next = it.next();
            this.f230747k.put(Long.valueOf(next.channel_id.get()), Long.valueOf(next.guild_id.get()));
        }
        return arrayList;
    }

    private int r() {
        return ((nu1.a) am.s().x(com.tencent.luggage.wxa.uf.i.CTRL_INDEX)).f421297i;
    }

    private void s(ArrayList<c> arrayList) {
        if (arrayList.isEmpty()) {
            QLog.i("GuildRegisterProxyPullMsgProcesser", 1, "handleChannelInRecentList. recentChannelList is empty.");
            return;
        }
        this.f230741e.addAll(0, arrayList);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                sb5.append("(");
                sb5.append(next.f230761e.channel_id.get());
                sb5.append(", ");
                sb5.append(next.f230761e.guild_id.get());
                sb5.append(")");
            }
            StringBuilder sb6 = new StringBuilder();
            for (c cVar : this.f230741e) {
                sb6.append("(");
                sb6.append(cVar.f230761e.channel_id.get());
                sb6.append(", ");
                sb6.append(cVar.f230761e.guild_id.get());
                sb6.append(", ");
                sb6.append(cVar.f230758b);
                sb6.append(")");
            }
            QLog.i("GuildRegisterProxyPullMsgProcesser", 2, "handleChannelInRecentList. recentChannelList: " + sb5.toString() + ", pullMsgOrderedList: " + sb6.toString());
        }
    }

    private ArrayList<c> t() {
        long J2 = this.f230739c.J2();
        long I2 = this.f230739c.I2();
        ArrayList<c> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        if (J2 == 0 && I2 == 0) {
            return arrayList;
        }
        for (c cVar : this.f230741e) {
            if (cVar.f230761e.channel_id.get() == I2) {
                arrayList.add(0, cVar);
            } else if (cVar.f230761e.guild_id.get() == J2) {
                arrayList.add(cVar);
            } else if (cVar.f230759c) {
                arrayList2.add(cVar);
            }
        }
        if (arrayList.size() == 0) {
            ArrayList arrayList3 = new ArrayList();
            for (c cVar2 : this.f230742f) {
                if (cVar2.f230761e.channel_id.get() == I2) {
                    arrayList.add(0, cVar2);
                } else if (cVar2.f230761e.guild_id.get() == J2) {
                    arrayList3.add(cVar2);
                }
            }
            if (!arrayList3.isEmpty()) {
                Collections.sort(arrayList3, this.f230753q);
                arrayList.addAll(arrayList3);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.i("RP_improve_tag", 1, "pullGuildRegProxyMsgHighPriority, need pull size: 0");
            return arrayList;
        }
        Iterator<c> it = arrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            this.f230741e.remove(next);
            this.f230742f.remove(next);
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            c cVar3 = (c) it5.next();
            this.f230741e.remove(cVar3);
            this.f230742f.add(cVar3);
        }
        this.f230741e.addAll(0, arrayList);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            for (c cVar4 : this.f230741e) {
                sb5.append("(");
                sb5.append(cVar4.f230761e.channel_id.get());
                sb5.append(", ");
                sb5.append(cVar4.f230761e.guild_id.get());
                sb5.append(", ");
                sb5.append(cVar4.f230758b);
                sb5.append(")");
            }
            StringBuilder sb6 = new StringBuilder();
            for (Iterator<c> it6 = this.f230742f.iterator(); it6.hasNext(); it6 = it6) {
                c next2 = it6.next();
                sb6.append("(");
                sb6.append(next2.f230761e.channel_id.get());
                sb6.append(", ");
                sb6.append(next2.f230761e.guild_id.get());
                sb6.append(", ");
                sb6.append(next2.f230758b);
                sb6.append(")");
            }
            QLog.i("RP_improve_tag", 2, "handleHighPriority. highPriorityGuild: " + J2 + ", highPriorityChannel: " + I2 + ", pullMsgOrderedList: " + sb5.toString() + ", hugeChannelList: " + sb6.toString());
        }
        QLog.i("RP_improve_tag", 1, "pullGuildRegProxyMsgHighPriority, need pull size: " + arrayList.size());
        return arrayList;
    }

    private void u(boolean z16, int i3) {
        this.f230748l = true;
        if (z16) {
            this.f230743g = i.a();
        }
        this.f230745i = System.currentTimeMillis();
        this.f230744h = false;
        this.f230738b = i3;
        this.f230746j.clear();
        this.f230747k.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int v(c cVar, c cVar2) {
        int i3;
        int i16;
        if (cVar == null || cVar2 == null || (i3 = cVar.f230758b) == (i16 = cVar2.f230758b)) {
            return 0;
        }
        if (i3 < i16) {
            return -1;
        }
        return 1;
    }

    private void w(int i3, boolean z16, Object obj) {
        if (!z16) {
            this.f230747k.clear();
            this.f230746j.clear();
            this.f230744h = true;
            g();
        }
        this.f230739c.notifyUI(i3, z16, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z() {
        ArrayList<c> t16 = t();
        if (t16.size() == 0) {
            return;
        }
        if (this.f230748l) {
            this.f230738b = Math.max(this.f230738b, t16.size());
        } else {
            u(false, t16.size());
            B(q());
        }
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.h
    public synchronized int a() {
        return this.f230743g;
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.h
    public synchronized boolean b(Object obj) {
        if ((obj instanceof ArrayList) && ((ArrayList) obj).size() != 0) {
            if (!i((ArrayList) obj)) {
                return false;
            }
            u(true, l());
            B(q());
            w(ou1.a.f424092h, true, new Object[]{Integer.valueOf(this.f230743g), null});
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.h
    public void onDestory() {
        if (this.f230739c.H2() != null) {
            this.f230739c.H2().b(this);
        }
    }

    public void x() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyPullMsgProcesser.3
            @Override // java.lang.Runnable
            public void run() {
                GuildRegisterProxyPullMsgProcesser.this.z();
            }
        }, 16, null, true);
    }

    public void y() {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyPullMsgProcesser.2
            @Override // java.lang.Runnable
            public void run() {
                GuildRegisterProxyPullMsgProcesser.this.z();
            }
        };
        if (C()) {
            if (this.f230751o.hasMessages(10)) {
                return;
            }
            Message message = new Message();
            message.what = 10;
            this.f230751o.sendMessageDelayed(message, m());
            return;
        }
        ThreadManagerV2.excute(runnable, 16, null, true);
    }

    private void B(ArrayList<synclogic$ChannelParam> arrayList) {
    }
}
