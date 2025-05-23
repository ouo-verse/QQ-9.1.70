package com.tencent.mobileqq.guild.media.core.data;

import androidx.core.util.Pools;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class p {
    private static final Pools.SynchronizedPool<p> O = new Pools.SynchronizedPool<>(200);
    public IGProRobotStateInfo K;
    public eu L;
    public IGProRoleManagementTag M;

    /* renamed from: n, reason: collision with root package name */
    public int f228106n;

    /* renamed from: o, reason: collision with root package name */
    public int f228107o;

    /* renamed from: a, reason: collision with root package name */
    public String f228093a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f228094b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f228095c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f228096d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f228097e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f228098f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f228099g = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f228100h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f228101i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f228102j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f228103k = false;

    /* renamed from: l, reason: collision with root package name */
    public String f228104l = "";

    /* renamed from: m, reason: collision with root package name */
    @Deprecated
    public int f228105m = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f228108p = false;

    /* renamed from: q, reason: collision with root package name */
    public int f228109q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f228110r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f228111s = 100;

    /* renamed from: t, reason: collision with root package name */
    public boolean f228112t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f228113u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f228114v = false;

    /* renamed from: w, reason: collision with root package name */
    public String f228115w = "";

    /* renamed from: x, reason: collision with root package name */
    public int f228116x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f228117y = 0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f228118z = false;
    public int A = 0;
    public boolean B = false;
    public UserBusinessInfo C = new UserBusinessInfo();
    public int D = 0;
    public boolean E = false;
    public long F = 0;
    public long G = 0;
    public long H = 0;
    public List<Integer> I = new ArrayList();
    public String J = "";
    public MutableLiveData<Integer> N = new MutableLiveData<>(0);

    public static void a(List<IGProUserInfo> list, List<p> list2) {
        ArrayList arrayList = new ArrayList();
        for (IGProUserInfo iGProUserInfo : list) {
            p j3 = j();
            Iterator<p> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    p next = it.next();
                    if (iGProUserInfo.getTinyId().equals(next.f228093a)) {
                        j3.e(next);
                        break;
                    }
                }
            }
            j3.f(iGProUserInfo);
            arrayList.add(j3);
        }
        list2.addAll(arrayList);
    }

    public static void h(List<IGProUserInfo> list, List<p> list2) {
        ArrayList arrayList = new ArrayList();
        for (IGProUserInfo iGProUserInfo : list) {
            p j3 = j();
            Iterator<p> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    p next = it.next();
                    if (iGProUserInfo.getTinyId().equals(next.f228093a)) {
                        j3.e(next);
                        break;
                    }
                }
            }
            j3.f(iGProUserInfo);
            arrayList.add(j3);
        }
        list2.clear();
        list2.addAll(arrayList);
    }

    public static void i(List<IGProUserInfo> list, List<IGProUserInfo> list2, List<p> list3) {
        m(list3);
        list3.clear();
        a(list, list3);
        a(list2, list3);
    }

    public static p j() {
        p acquire = O.acquire();
        if (acquire != null) {
            return acquire;
        }
        return new p();
    }

    public static void m(List<p> list) {
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.get(i3).l();
        }
    }

    public static void n(List<IGProUserInfo> list, p pVar) {
        for (IGProUserInfo iGProUserInfo : list) {
            if (iGProUserInfo.getTinyId().equals(pVar.f228093a)) {
                pVar.f(iGProUserInfo);
                return;
            }
        }
    }

    public static void o(List<IGProUserInfo> list, List<p> list2) {
        for (p pVar : list2) {
            Iterator<IGProUserInfo> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    IGProUserInfo next = it.next();
                    if (next.getTinyId().equals(pVar.f228093a)) {
                        pVar.f(next);
                        break;
                    }
                }
            }
        }
    }

    public void b() {
        this.f228093a = "";
        this.f228094b = "";
        this.f228095c = "";
        this.f228096d = "";
        this.f228097e = 0;
        this.f228098f = 0;
        this.f228099g = 0;
        this.f228100h = false;
        this.f228101i = false;
        this.f228102j = false;
        this.f228103k = false;
        this.f228104l = "";
        this.f228105m = 0;
        this.f228106n = 0;
        this.f228107o = 0;
        this.f228108p = false;
        this.f228109q = 0;
        this.f228110r = 0;
        this.f228111s = 100;
        this.f228112t = false;
        this.f228113u = false;
        this.f228114v = false;
        this.f228115w = "";
        this.f228117y = 0;
        this.f228118z = false;
        this.A = 0;
        this.B = false;
        this.C.a();
        this.E = false;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = new ArrayList();
        this.J = "";
        this.K = null;
        this.M = null;
        this.L = null;
    }

    public p c() {
        p j3 = j();
        j3.f228093a = this.f228093a;
        j3.f228094b = this.f228094b;
        j3.f228095c = this.f228095c;
        j3.f228096d = this.f228096d;
        j3.f228097e = this.f228097e;
        j3.f228099g = this.f228099g;
        j3.f228100h = this.f228100h;
        j3.f228101i = this.f228101i;
        j3.f228102j = this.f228102j;
        j3.f228103k = this.f228103k;
        j3.f228104l = this.f228104l;
        j3.f228105m = this.f228105m;
        j3.f228106n = this.f228106n;
        j3.f228107o = this.f228107o;
        j3.f228108p = this.f228108p;
        j3.f228109q = this.f228109q;
        j3.f228110r = this.f228110r;
        j3.f228111s = this.f228111s;
        j3.f228112t = this.f228112t;
        j3.f228113u = this.f228113u;
        j3.f228114v = this.f228114v;
        j3.f228098f = this.f228098f;
        j3.f228115w = this.f228115w;
        j3.f228118z = this.f228118z;
        j3.f228116x = this.f228116x;
        j3.f228117y = this.f228117y;
        j3.A = this.A;
        j3.B = this.B;
        j3.C.c(this.C);
        j3.E = this.E;
        j3.F = this.F;
        j3.G = this.G;
        j3.H = this.H;
        j3.I.clear();
        j3.I.addAll(this.I);
        j3.J = this.J;
        j3.K = this.K;
        j3.M = this.M;
        j3.L = this.L;
        return j3;
    }

    public void d(k kVar) {
        this.f228093a = kVar.f228074a;
        this.f228103k = kVar.f228076c;
        this.f228106n = kVar.f228077d;
        this.f228107o = kVar.f228078e;
    }

    public void e(p pVar) {
        int i3;
        this.f228093a = String.copyValueOf(pVar.f228093a.toCharArray());
        this.f228094b = pVar.f228094b;
        this.f228095c = pVar.f228095c;
        this.f228096d = pVar.f228096d;
        this.f228097e = pVar.f228097e;
        this.f228098f = pVar.f228098f;
        this.f228099g = pVar.f228099g;
        this.f228100h = pVar.f228100h;
        this.f228101i = pVar.f228101i;
        this.f228102j = pVar.f228102j;
        this.f228103k = pVar.f228103k;
        this.f228104l = pVar.f228104l;
        this.f228106n = pVar.f228106n;
        this.f228107o = pVar.f228107o;
        this.f228108p = pVar.f228108p;
        this.f228109q = pVar.f228109q;
        this.f228110r = pVar.f228110r;
        this.f228112t = pVar.f228112t;
        this.f228113u = pVar.f228113u;
        this.f228114v = pVar.f228114v;
        this.f228116x = pVar.f228116x;
        this.f228117y = pVar.f228117y;
        this.f228118z = pVar.f228118z;
        this.A = pVar.A;
        this.B = pVar.B;
        this.C.c(pVar.C);
        if (this.f228113u) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.f228105m = i3;
        this.E = pVar.E;
        this.F = pVar.F;
        this.G = pVar.G;
        this.H = pVar.H;
        this.I.clear();
        this.I.addAll(pVar.I);
        this.J = pVar.J;
        this.K = pVar.K;
        this.M = pVar.M;
        this.L = pVar.L;
    }

    public void f(IGProUserInfo iGProUserInfo) {
        boolean z16;
        boolean z17;
        int i3;
        this.f228093a = iGProUserInfo.getTinyId();
        this.f228094b = ch.d0(iGProUserInfo);
        String avatarMeta = iGProUserInfo.getAvatarMeta();
        this.f228096d = avatarMeta;
        if (avatarMeta == null) {
            this.f228096d = "";
        }
        this.f228095c = ch.z(iGProUserInfo);
        this.f228097e = iGProUserInfo.getUserType();
        int groupType = iGProUserInfo.getBusinessInfo().getUserListGroupInfo().getGroupType();
        boolean z18 = true;
        if (groupType == -1) {
            groupType = 1;
        }
        this.f228099g = groupType;
        this.f228100h = iGProUserInfo.getBusinessInfo().getLobbyMemberInfo().getPlaying();
        this.f228114v = iGProUserInfo.isMuteSeat();
        this.f228113u = iGProUserInfo.isMuteSeat();
        IGProUserDevStateData userDevState = iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserDevState();
        if (userDevState.getMicState() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f228101i = z16;
        if (userDevState.getScreenState() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f228102j = z17;
        this.f228110r = bw.k0(this.f228093a);
        this.f228098f = iGProUserInfo.getRobotType();
        this.f228116x = iGProUserInfo.getPlatform();
        this.f228117y = iGProUserInfo.getGender();
        if (iGProUserInfo.getMyRoles() != null && !iGProUserInfo.getMyRoles().isEmpty()) {
            this.f228118z = iGProUserInfo.getMyRoles().contains(6);
        } else {
            this.f228118z = false;
        }
        if (this.f228113u) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.f228105m = i3;
        long sortKey = this.C.getSortKey();
        UserBusinessInfo.h(iGProUserInfo.getBusinessInfo(), this.C);
        if (this.C.getSortKey() == 0) {
            this.C.i(sortKey);
        }
        int sysMicBusy = iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserDevState().getSysMicBusy();
        if (sysMicBusy != 0) {
            if (sysMicBusy != 2) {
                z18 = false;
            }
            this.B = z18;
        }
        this.E = iGProUserInfo.getBusinessInfo().getUserAVInfo().isUserInSpeakQueue();
        this.F = iGProUserInfo.getBusinessInfo().getUserAVInfo().getSpeakTimeCtl().getStopSpeakMs();
        this.G = iGProUserInfo.getBusinessInfo().getUserAVInfo().getSpeakTimeCtl().getStartSpeakMs();
        this.H = iGProUserInfo.getBusinessInfo().getUserAVInfo().getSpeakTimeCtl().getQueueSpeakS();
        this.I.clear();
        this.I.addAll(iGProUserInfo.getMyRoles());
        this.J = iGProUserInfo.getAvatarPendant();
        this.K = iGProUserInfo.getBusinessInfo().getRobotStateInfo();
        this.M = iGProUserInfo.getRoleManagementTag();
        this.L = iGProUserInfo.getPersonalMedal();
    }

    public void g(List<IGProUserInfo> list) {
        for (IGProUserInfo iGProUserInfo : list) {
            if (iGProUserInfo.getTinyId().equals(this.f228093a)) {
                f(iGProUserInfo);
                return;
            }
        }
    }

    public int k() {
        return (int) ((this.f228110r * this.f228111s) / 100.0d);
    }

    public void l() {
        b();
        O.release(this);
    }

    public String toString() {
        return "UserInfo{id='" + this.f228093a + "', name='" + this.f228094b + "', avatarMeta='" + this.f228096d + "', avatarUrl='" + this.f228095c + "', userType=" + this.f228097e + ", robotType=" + this.f228098f + ", groupType=" + this.f228099g + ", isInLobbyRoom=" + this.f228100h + ", isMicOn=" + this.f228101i + ", isVideoOn=" + this.f228103k + ", videoCover='" + this.f228104l + "', allowScreenShare=" + this.f228105m + ", videoWidth=" + this.f228106n + ", videoHeight=" + this.f228107o + ", hasMicStatusAdjust=" + this.f228108p + ", volume=" + this.f228109q + ", volumeToMe=" + this.f228110r + ", volumeToMePercent=" + this.f228111s + ", muteToMe=" + this.f228112t + ", globalMute=" + this.f228113u + ", isBanned=" + this.f228114v + ", uin='" + this.f228115w + "', platformType=" + this.f228116x + ", gender=" + this.f228117y + ", isGuildVisitor=" + this.f228118z + ", networkQuality=" + this.A + ", isPhoneBusy=" + this.B + ", userBizInfo=" + this.C + ", roleList=" + this.I + ", speakTimeEnd" + this.F + ", speakTimeStart" + this.G + ", speakTotalTime" + this.H + ", customManageTag" + this.M + '}';
    }
}
