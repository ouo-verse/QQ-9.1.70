package com.tencent.mobileqq.guild.message.api.impl.onlinepush;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService;
import com.tencent.mobileqq.guild.message.n;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e {
    private static int A = 8;
    public static long B = 0;

    /* renamed from: t, reason: collision with root package name */
    public static int f230262t = 0;

    /* renamed from: u, reason: collision with root package name */
    public static int f230263u = 1;

    /* renamed from: v, reason: collision with root package name */
    public static int f230264v = 2;

    /* renamed from: w, reason: collision with root package name */
    public static int f230265w = 3;

    /* renamed from: x, reason: collision with root package name */
    public static int f230266x = 4;

    /* renamed from: y, reason: collision with root package name */
    private static int f230267y = 10;

    /* renamed from: z, reason: collision with root package name */
    private static int f230268z = 6;

    /* renamed from: a, reason: collision with root package name */
    private final AppInterface f230269a;

    /* renamed from: b, reason: collision with root package name */
    private st1.g f230270b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f230271c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f230272d = false;

    /* renamed from: e, reason: collision with root package name */
    private Map<Long, i> f230273e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Set<g> f230274f = new LinkedHashSet();

    /* renamed from: g, reason: collision with root package name */
    private Set<g> f230275g = new LinkedHashSet();

    /* renamed from: h, reason: collision with root package name */
    private Set<g> f230276h = new LinkedHashSet();

    /* renamed from: i, reason: collision with root package name */
    public d f230277i = new d();

    /* renamed from: j, reason: collision with root package name */
    public C7848e f230278j = new C7848e();

    /* renamed from: k, reason: collision with root package name */
    public f f230279k = new f();

    /* renamed from: l, reason: collision with root package name */
    private boolean f230280l = false;

    /* renamed from: m, reason: collision with root package name */
    private Random f230281m = new Random();

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.api.impl.onlinepush.f f230282n = new com.tencent.mobileqq.guild.message.api.impl.onlinepush.f(5000);

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.mobileqq.guild.message.api.impl.onlinepush.d f230283o = new com.tencent.mobileqq.guild.message.api.impl.onlinepush.d();

    /* renamed from: p, reason: collision with root package name */
    private IGuildFocusChannelService f230284p;

    /* renamed from: q, reason: collision with root package name */
    private IGuildLocalFocusService f230285q;

    /* renamed from: r, reason: collision with root package name */
    private IGPSService f230286r;

    /* renamed from: s, reason: collision with root package name */
    Observer f230287s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements Observer {
        a() {
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (!(obj instanceof IGuildLocalFocusService.a)) {
                return;
            }
            IGuildLocalFocusService.a aVar = (IGuildLocalFocusService.a) obj;
            int i3 = aVar.f230117a;
            if (i3 == 2) {
                e.this.A(((Long) aVar.f230118b).longValue());
                return;
            }
            if (i3 == 1) {
                e.this.z(((Long) aVar.f230118b).longValue());
            } else if (i3 == 3) {
                e.this.D(((Boolean) aVar.f230118b).booleanValue());
            } else if (i3 == 4) {
                e.this.F(((Integer) aVar.f230118b).intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f230289a = e.B;

        /* renamed from: b, reason: collision with root package name */
        public int f230290b = e.f230262t;

        public String toString() {
            return "channelId:" + this.f230289a + " type:" + this.f230290b + " ";
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public long f230291a = e.B;

        /* renamed from: b, reason: collision with root package name */
        public List<byte[]> f230292b = new ArrayList();

        public String toString() {
            return "channelId:" + this.f230291a + " msgs.size:" + this.f230292b.size() + " ";
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public long f230293a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f230294b = 1;

        /* renamed from: c, reason: collision with root package name */
        public HashSet<Long> f230295c = new HashSet<>();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.message.api.impl.onlinepush.e$e, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C7848e {

        /* renamed from: a, reason: collision with root package name */
        public long f230296a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f230297b = 4;

        /* renamed from: c, reason: collision with root package name */
        public HashSet<Long> f230298c = new HashSet<>();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public long f230299a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f230300b = 30;

        /* renamed from: c, reason: collision with root package name */
        public HashSet<Long> f230301c = new HashSet<>();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public long f230302a;

        /* renamed from: b, reason: collision with root package name */
        public long f230303b;

        /* renamed from: c, reason: collision with root package name */
        public int f230304c;

        public g(long j3, long j16) {
            int i3 = e.f230262t;
            this.f230304c = 0;
            this.f230302a = j3;
            this.f230303b = j16;
        }

        public boolean equals(@Nullable Object obj) {
            if (this.f230303b == ((g) obj).f230303b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Long.valueOf(this.f230303b).hashCode();
        }

        public String toString() {
            return "guildId:" + this.f230302a + " channelId:" + this.f230303b + " type:" + this.f230304c + " ";
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public long f230305a;

        /* renamed from: b, reason: collision with root package name */
        public long f230306b = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f230307c = 0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f230308d = false;

        /* renamed from: e, reason: collision with root package name */
        public long f230309e = 0;

        /* renamed from: f, reason: collision with root package name */
        public byte[] f230310f;

        public String toString() {
            return "msgSeq:" + this.f230307c + " isRoamMsg:" + this.f230308d + " msgType:" + this.f230305a + " msgRecvTime:" + this.f230309e + " ";
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public List<h> f230311a = new LinkedList();
    }

    public e(AppInterface appInterface, st1.g gVar) {
        this.f230269a = appInterface;
        this.f230270b = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A(long j3) {
        this.f230271c = true;
        i(0);
        this.f230270b.notifyUI(n.D, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void D(boolean z16) {
        if (z16) {
            this.f230271c = true;
        }
        i(0);
        m().reportGuildFocusInfo();
    }

    private void E(long j3, List<h> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().f230307c));
        }
        this.f230283o.p(Long.valueOf(j3), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void F(int i3) {
        if (i3 == 1 || i3 == 2) {
            this.f230271c = true;
        }
        i(0);
    }

    private b H(Set<g> set, int i3, boolean z16) {
        g gVar;
        b bVar;
        Iterator<g> it = set.iterator();
        if (it.hasNext()) {
            gVar = it.next();
            long j3 = gVar.f230303b;
            bVar = new b();
            bVar.f230289a = j3;
            bVar.f230290b = i3;
        } else {
            gVar = null;
            bVar = null;
        }
        if (bVar != null && gVar != null && z16 && !x(bVar) && set.size() > 1) {
            set.remove(gVar);
            set.add(gVar);
        }
        return bVar;
    }

    private b I() {
        i iVar;
        List<h> list;
        boolean appOnForeground = o().getAppOnForeground();
        long l3 = l();
        if (!appOnForeground) {
            l3 = B;
        }
        if (l3 != B && (iVar = this.f230273e.get(Long.valueOf(l()))) != null && (list = iVar.f230311a) != null && list.size() > 0) {
            b bVar = new b();
            bVar.f230289a = l3;
            bVar.f230290b = f230263u;
            return bVar;
        }
        return null;
    }

    private b J() {
        b I = I();
        if (!x(I)) {
            ArrayList arrayList = new ArrayList();
            int nextInt = this.f230281m.nextInt(f230267y);
            if (nextInt <= f230268z) {
                arrayList.add(new Pair(this.f230274f, Integer.valueOf(f230264v)));
                arrayList.add(new Pair(this.f230275g, Integer.valueOf(f230265w)));
                arrayList.add(new Pair(this.f230276h, Integer.valueOf(f230266x)));
            } else if (nextInt <= A) {
                arrayList.add(new Pair(this.f230275g, Integer.valueOf(f230265w)));
                arrayList.add(new Pair(this.f230276h, Integer.valueOf(f230266x)));
                arrayList.add(new Pair(this.f230274f, Integer.valueOf(f230264v)));
            } else {
                arrayList.add(new Pair(this.f230276h, Integer.valueOf(f230266x)));
                arrayList.add(new Pair(this.f230274f, Integer.valueOf(f230264v)));
                arrayList.add(new Pair(this.f230275g, Integer.valueOf(f230265w)));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                I = H((Set) pair.first, ((Integer) pair.second).intValue(), true);
                if (x(I)) {
                    break;
                }
            }
        }
        if (!x(I)) {
            return null;
        }
        return I;
    }

    private boolean L(List<h> list, h hVar) {
        if (!hVar.f230308d) {
            list.add(hVar);
        } else {
            ListIterator<h> listIterator = list.listIterator(list.size());
            h hVar2 = null;
            while (listIterator.hasPrevious()) {
                h previous = listIterator.previous();
                if (previous.f230308d) {
                    long j3 = previous.f230307c;
                    long j16 = hVar.f230307c;
                    if (j3 < j16) {
                        break;
                    }
                    if (j3 > j16) {
                        hVar2 = previous;
                    }
                }
            }
            if (hVar2 == null) {
                list.add(hVar);
            } else {
                list.add(list.indexOf(hVar2), hVar);
                return true;
            }
        }
        return false;
    }

    private void M(List<h> list, List<h> list2) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        Iterator<h> it = list2.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (L(list, it.next())) {
                z16 = true;
            }
        }
        if (z16 && this.f230282n.a("reSortMsgs")) {
            QLog.i("GuildPendingPushMsgStore", 1, "reSortMsgs originalMsgs before:" + linkedList.toString() + " newMsgs:" + list2.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reSortMsgs originalMsgs after:");
            sb5.append(list.toString());
            QLog.i("GuildPendingPushMsgStore", 1, sb5.toString());
        }
    }

    private Set<g> N(Set<g> set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<g> it = set.iterator();
        long activeGuildId = o().getActiveGuildId();
        while (it.hasNext()) {
            g next = it.next();
            if (next.f230302a == activeGuildId) {
                linkedHashSet.add(next);
                it.remove();
            }
        }
        return linkedHashSet;
    }

    private void O(long j3) {
        g gVar = new g(B, j3);
        this.f230274f.remove(gVar);
        this.f230275g.remove(gVar);
        this.f230276h.remove(gVar);
    }

    private Set<g> P(Set<g> set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<g> it = set.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (h(next.f230303b, next.f230302a)) {
                linkedHashSet.add(next);
                it.remove();
            }
        }
        return linkedHashSet;
    }

    private void Q() {
        if (this.f230287s != null) {
            o().deleteObserver(this.f230287s);
        }
    }

    private void R(long j3) {
        List<h> list;
        this.f230277i.f230295c.remove(Long.valueOf(j3));
        this.f230278j.f230298c.remove(Long.valueOf(j3));
        this.f230279k.f230301c.remove(Long.valueOf(j3));
        i iVar = this.f230273e.get(Long.valueOf(j3));
        if (iVar != null && (list = iVar.f230311a) != null && list.size() > 0) {
            Iterator<h> it = iVar.f230311a.iterator();
            while (it.hasNext()) {
                it.next().f230309e = 0L;
            }
        }
    }

    private void S() {
        if (this.f230271c) {
            int selTab = o().getSelTab();
            if (selTab == 1 && o().getActiveGuildId() != B) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.addAll(N(this.f230274f));
                linkedHashSet.addAll(N(this.f230275g));
                linkedHashSet.addAll(N(this.f230276h));
                if (linkedHashSet.size() > 0) {
                    linkedHashSet.addAll(this.f230274f);
                    this.f230274f = linkedHashSet;
                }
            }
            if (selTab == 2) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.addAll(P(this.f230274f));
                linkedHashSet2.addAll(P(this.f230275g));
                linkedHashSet2.addAll(P(this.f230276h));
                if (linkedHashSet2.size() > 0) {
                    linkedHashSet2.addAll(this.f230274f);
                    this.f230274f = linkedHashSet2;
                }
            }
            this.f230271c = false;
        }
    }

    private void W(long j3, List<h> list, int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        ListIterator<h> listIterator = list.listIterator(list.size());
        if (j3 == l()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isHugeChannel = m().isHugeChannel(String.valueOf(j3));
        ArrayList arrayList = new ArrayList();
        long j16 = 0;
        long j17 = 0;
        while (listIterator.hasPrevious()) {
            h previous = listIterator.previous();
            if (previous.f230305a == 3840 && previous.f230306b == 0 && previous.f230308d) {
                if (z16 && j17 >= i3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z16 && !isHugeChannel && j17 >= 15) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                boolean z26 = z17 | z18;
                if (!z16 && isHugeChannel && j17 >= 1) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z26 | z19) {
                    arrayList.add(Long.valueOf(previous.f230307c));
                    listIterator.remove();
                    j16++;
                }
                j17++;
            }
        }
        if (j16 > 0) {
            this.f230283o.j(isHugeChannel, j16);
            this.f230283o.k(Long.valueOf(j3), arrayList);
        }
    }

    private void e() {
        if (this.f230287s == null) {
            this.f230287s = new a();
            o().addObserver(this.f230287s);
        }
    }

    private void i(int i3) {
        if (!this.f230280l && v()) {
            this.f230280l = true;
            this.f230270b.B(i3);
        }
    }

    private void k() {
        long uptimeMillis = SystemClock.uptimeMillis() / 1000;
        d dVar = this.f230277i;
        if (uptimeMillis - dVar.f230293a >= dVar.f230294b) {
            dVar.f230293a = uptimeMillis;
            dVar.f230295c.clear();
        }
        C7848e c7848e = this.f230278j;
        if (uptimeMillis - c7848e.f230296a >= c7848e.f230297b) {
            c7848e.f230296a = uptimeMillis;
            c7848e.f230298c.clear();
        }
        f fVar = this.f230279k;
        if (uptimeMillis - fVar.f230299a >= fVar.f230300b) {
            fVar.f230299a = uptimeMillis;
            fVar.f230301c.clear();
        }
    }

    private long l() {
        return o().getActiveChannelId();
    }

    private IGuildFocusChannelService m() {
        if (this.f230284p == null) {
            this.f230284p = (IGuildFocusChannelService) this.f230269a.getRuntimeService(IGuildFocusChannelService.class, "");
        }
        return this.f230284p;
    }

    private synchronized IGPSService n() {
        if (this.f230286r == null) {
            this.f230286r = (IGPSService) this.f230269a.getRuntimeService(IGPSService.class, "");
        }
        return this.f230286r;
    }

    private synchronized IGuildLocalFocusService o() {
        if (this.f230285q == null) {
            this.f230285q = (IGuildLocalFocusService) this.f230269a.getRuntimeService(IGuildLocalFocusService.class, "");
        }
        return this.f230285q;
    }

    private synchronized String p() {
        return this.f230283o.e() + "\n" + this.f230283o.d();
    }

    private long q(Set<g> set) {
        List<h> list;
        Iterator<g> it = set.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i iVar = this.f230273e.get(Long.valueOf(it.next().f230303b));
            if (iVar != null && (list = iVar.f230311a) != null) {
                i3 += list.size();
            }
        }
        return i3;
    }

    private boolean w(b bVar) {
        if (bVar == null) {
            return false;
        }
        int i3 = bVar.f230290b;
        if (i3 != f230263u && i3 != f230264v) {
            if (i3 == f230265w) {
                return this.f230278j.f230298c.contains(Long.valueOf(bVar.f230289a));
            }
            return this.f230279k.f230301c.contains(Long.valueOf(bVar.f230289a));
        }
        return this.f230277i.f230295c.contains(Long.valueOf(bVar.f230289a));
    }

    private boolean x(b bVar) {
        if (bVar != null && !w(bVar)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(long j3) {
        if (j3 != B) {
            T();
        }
        i(0);
        this.f230270b.notifyUI(n.D, true, null);
    }

    public void C() {
        Q();
    }

    public synchronized void G() {
        i(0);
    }

    public synchronized c K(long j3) {
        c cVar;
        List<h> list;
        List<h> list2;
        cVar = new c();
        cVar.f230291a = j3;
        i iVar = this.f230273e.get(Long.valueOf(j3));
        if (j3 == l()) {
            if (iVar != null && (list2 = iVar.f230311a) != null && list2.size() > 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                ArrayList arrayList = new ArrayList();
                Iterator<h> it = iVar.f230311a.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (uptimeMillis - next.f230309e < 1000) {
                        break;
                    }
                    arrayList.add(next);
                    it.remove();
                }
                W(j3, arrayList, 15);
                ArrayList arrayList2 = new ArrayList();
                Iterator<h> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(it5.next().f230310f);
                }
                cVar.f230292b = arrayList2;
                if (iVar.f230311a.size() == 0) {
                    O(j3);
                }
            } else {
                O(j3);
            }
        } else {
            O(j3);
            if (iVar != null && (list = iVar.f230311a) != null && list.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                if (iVar.f230311a.size() > 30) {
                    int size = iVar.f230311a.size();
                    W(j3, iVar.f230311a, 15);
                    QLog.i("GuildPendingPushMsgStore", 1, "queryExtMsgInfoAndClear before msgList.size():" + size + " after msgList.size()" + iVar.f230311a.size());
                }
                Iterator<h> it6 = iVar.f230311a.iterator();
                while (it6.hasNext()) {
                    arrayList3.add(it6.next().f230310f);
                }
                iVar.f230311a.clear();
                cVar.f230292b = arrayList3;
            }
        }
        return cVar;
    }

    public synchronized void T() {
        long l3 = l();
        if (l3 != B) {
            R(l3);
            this.f230272d = true;
        }
    }

    public synchronized void U() {
        this.f230280l = false;
        i(200);
    }

    public synchronized void V(@NonNull Map<Long, i> map, @NonNull Set<g> set, @NonNull Set<g> set2, @NonNull Set<g> set3) {
        e();
        long l3 = l();
        for (Map.Entry<Long, i> entry : map.entrySet()) {
            if (this.f230273e.containsKey(entry.getKey())) {
                if (entry.getKey().longValue() == l3) {
                    M(this.f230273e.get(entry.getKey()).f230311a, entry.getValue().f230311a);
                } else {
                    this.f230273e.get(entry.getKey()).f230311a.addAll(entry.getValue().f230311a);
                }
            } else if (entry.getKey().longValue() == l3) {
                LinkedList linkedList = new LinkedList();
                M(linkedList, entry.getValue().f230311a);
                entry.getValue().f230311a = linkedList;
                this.f230273e.put(entry.getKey(), entry.getValue());
            } else {
                this.f230273e.put(entry.getKey(), entry.getValue());
            }
            this.f230283o.m(m().isHugeChannel(String.valueOf(entry.getKey())), entry.getValue().f230311a);
            E(entry.getKey().longValue(), entry.getValue().f230311a);
            W(entry.getKey().longValue(), this.f230273e.get(entry.getKey()).f230311a, 1000);
        }
        this.f230274f.addAll(set);
        this.f230275g.addAll(set2);
        this.f230276h.addAll(set3);
        i(0);
    }

    public synchronized void f(b bVar) {
        int i3 = bVar.f230290b;
        if (i3 != f230263u && i3 != f230264v) {
            if (i3 == f230265w) {
                this.f230278j.f230298c.add(Long.valueOf(bVar.f230289a));
            } else {
                this.f230279k.f230301c.add(Long.valueOf(bVar.f230289a));
            }
        }
        this.f230277i.f230295c.add(Long.valueOf(bVar.f230289a));
    }

    public synchronized b g() {
        k();
        S();
        return J();
    }

    public boolean h(long j3, long j16) {
        return n().isQQMsgListChannel(String.valueOf(j16), String.valueOf(j3));
    }

    public synchronized boolean j() {
        if (!this.f230272d) {
            return false;
        }
        this.f230272d = false;
        return true;
    }

    public synchronized String r() {
        return "norqueue: " + this.f230275g.size() + "/" + q(this.f230275g);
    }

    public com.tencent.mobileqq.guild.message.api.impl.onlinepush.d s() {
        return this.f230283o;
    }

    public synchronized String t() {
        return "priorqueue: " + this.f230274f.size() + "/" + q(this.f230274f);
    }

    public synchronized String u() {
        return "slowqueue: " + this.f230276h.size() + "/" + q(this.f230276h);
    }

    public synchronized boolean v() {
        boolean z16;
        b I = I();
        z16 = false;
        if (I == null) {
            I = H(this.f230274f, f230264v, false);
        }
        if (I == null) {
            I = H(this.f230275g, f230265w, false);
        }
        if (I == null) {
            I = H(this.f230276h, f230266x, false);
        }
        if (I != null) {
            z16 = true;
        }
        return z16;
    }

    public void y() {
        if (this.f230282n.a("logDebugInfoIfNeed")) {
            QLog.i("GuildPendingPushMsgStore", 1, "debug log, " + this.f230283o.h());
            QLog.i("GuildPendingPushMsgStore", 1, "debug log, " + this.f230283o.c() + " " + this.f230283o.f() + " " + this.f230283o.a());
            QLog.i("GuildPendingPushMsgStore", 1, "debug log, " + t() + " " + r() + " " + u());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("debug log, ");
            sb5.append(this.f230283o.b());
            QLog.i("GuildPendingPushMsgStore", 1, sb5.toString());
            QLog.i("GuildPendingPushMsgStore", 1, "debug log, " + this.f230283o.g());
            QLog.i("GuildPendingPushMsgStore", 1, "debug log, " + p());
            this.f230270b.notifyUI(n.D, true, null);
        }
    }

    public void B() {
    }
}
