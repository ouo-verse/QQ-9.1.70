package com.tencent.mobileqq.qqguildsdk.state;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qqguildsdk.data.GProUserChannelStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.aw;
import com.tencent.mobileqq.qqguildsdk.data.cz;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.util.h;
import com.tencent.mobileqq.qqguildsdk.util.j;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildStateReqInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildStateRspInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListStateCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.MobileQQ;
import vh2.bt;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f268483a;

    /* renamed from: e, reason: collision with root package name */
    private GProUserChannelStateInfo f268487e;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, aw> f268484b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Set<bt> f268485c = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    private final e f268486d = new e(this);

    /* renamed from: f, reason: collision with root package name */
    private final GProUserChannelStateInfo f268488f = new GProUserChannelStateInfo(new GProUserChannelState(0, 0, 0, 0, 2, 1));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements IGProFetchChannelListStateCallback {
        a() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListStateCallback
        public void onFetchChannelListState(int i3, String str, GProGuildStateRspInfo gProGuildStateRspInfo) {
            if (i3 != 0) {
                h.p("StateMgr", true, "cache", "refreshGuildState", "error", "result=" + i3 + " errMsg=" + str);
                return;
            }
            f.this.h(gProGuildStateRspInfo, false);
        }
    }

    public f(GPSManagerEngine gPSManagerEngine) {
        this.f268483a = gPSManagerEngine;
    }

    private void c(String str) {
        for (aw awVar : this.f268484b.values()) {
            if (!awVar.getGuildId().equals(str)) {
                awVar.g(this.f268488f);
            }
        }
    }

    private void i(ArrayList<GProGuildStateReqInfo> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f268483a.Nd(arrayList, new a());
        }
    }

    private void j(List<dt> list) {
        if (list != null && !list.isEmpty()) {
            this.f268483a.ej(9200, "notifyGuildStateListeners", list);
            for (bt btVar : this.f268485c) {
                Iterator<dt> it = list.iterator();
                while (it.hasNext()) {
                    btVar.a(it.next());
                }
            }
            return;
        }
        h.k("StateMgr", 1, "notifyGuildStateListener", "guildStates is null or empty!");
    }

    private void u(String str) {
        if (this.f268487e == null) {
            this.f268487e = this.f268488f;
        }
        aw awVar = this.f268484b.get(str);
        if (awVar == null) {
            awVar = new aw(str, null);
            this.f268484b.put(str, awVar);
        }
        if (awVar.getGuildId().equals(String.valueOf(this.f268487e.getGuildId()))) {
            awVar.g(this.f268487e);
            c(awVar.getGuildId());
        }
    }

    public void a(@NonNull bt btVar) {
        this.f268485c.add(btVar);
    }

    public boolean b(int i3) {
        if (i3 != 2 && i3 != 5 && i3 != 8) {
            return false;
        }
        return true;
    }

    public void d() {
        this.f268486d.a();
        this.f268485c.clear();
    }

    public void e(String str, String str2) {
        boolean z16;
        if (!j.i(str) && !j.i(str2)) {
            IGProChannelInfo cl5 = this.f268483a.cl(str2);
            if (cl5 != null && b(cl5.getType())) {
                ArrayList<GProGuildStateReqInfo> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Long.valueOf(com.tencent.mobileqq.qqguildsdk.util.g.O0(str2)));
                arrayList.add(new GProGuildStateReqInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), arrayList2, 0L));
                i(arrayList);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("channelInfo == null:");
            if (cl5 == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" or channel has no state!");
            h.p("StateMgr", true, "cache", "fetchGuildStateByChannelVisibleChanged", "", sb5.toString());
        }
    }

    public int f() {
        if (PadUtil.a(MobileQQ.sMobileQQ) == DeviceType.TABLET) {
            return 2;
        }
        return 1;
    }

    @Nullable
    public aw g(String str) {
        aw awVar = this.f268484b.get(str);
        if (awVar == null) {
            aw awVar2 = new aw(str, null);
            this.f268484b.put(str, awVar2);
            return awVar2;
        }
        return awVar;
    }

    public void h(GProGuildStateRspInfo gProGuildStateRspInfo, boolean z16) {
        if (gProGuildStateRspInfo == null) {
            h.k("StateMgr", 1, "handleGuildStateRsp", "proGuildStateRspInfo is null, fromPush=" + z16);
            return;
        }
        long nextTs = gProGuildStateRspInfo.getNextTs();
        this.f268486d.c(1000 * nextTs);
        t(ChannelStateUtil.d(gProGuildStateRspInfo.getUserStateInfo()));
        ArrayList arrayList = new ArrayList();
        Iterator<GProGuildState> it = gProGuildStateRspInfo.getGuildStatusList().iterator();
        while (it.hasNext()) {
            GProGuildState next = it.next();
            String valueOf = String.valueOf(next.getGuildId());
            s(new aw(valueOf, next));
            aw awVar = this.f268484b.get(valueOf);
            if (awVar != null) {
                arrayList.add(awVar);
            }
        }
        j(arrayList);
        h.p("StateMgr", true, "cache", "handleGuildStateRsp", "success", "nextTs=" + nextTs + " count=" + gProGuildStateRspInfo.getGuildStatusList().size() + " fromPush=" + z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        ArrayList arrayList = new ArrayList();
        Iterator<IGProGuildInfo> it = this.f268483a.kl().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getGuildID());
        }
        h.u("StateMgr", false, "cache", "refreshAllGuildState");
        l(arrayList);
    }

    public void l(@NonNull List<String> list) {
        long j3;
        if (list.isEmpty()) {
            return;
        }
        h.p("StateMgr", true, "cache", "refreshGuildState", "", "size=" + list.size() + ", guildIdList=[" + list + "]");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(5);
        HashMap<Long, ArrayList<Long>> Ve = this.f268483a.Ve(com.tencent.mobileqq.qqguildsdk.util.g.P0(list), arrayList);
        h.p("StateMgr", true, "cache", "refreshGuildState", "", "channelIdMap.size=" + Ve.size());
        ArrayList<GProGuildStateReqInfo> arrayList2 = new ArrayList<>();
        for (Map.Entry<Long, ArrayList<Long>> entry : Ve.entrySet()) {
            Long key = entry.getKey();
            ArrayList<Long> value = entry.getValue();
            aw awVar = this.f268484b.get(com.tencent.mobileqq.qqguildsdk.util.g.X0(key.longValue()));
            if (awVar != null) {
                j3 = awVar.d();
            } else {
                j3 = 0;
            }
            arrayList2.add(new GProGuildStateReqInfo(key.longValue(), value, j3));
        }
        i(arrayList2);
    }

    public void m(String str, String str2) {
        aw awVar = this.f268484b.get(str);
        if (awVar == null) {
            return;
        }
        h.p("StateMgr", false, "cache", "removeChannelState", "", "guildId=" + str + " channelId=[" + str2);
        awVar.e(str2);
        List<dt> arrayList = new ArrayList<>();
        arrayList.add(awVar);
        j(arrayList);
    }

    public void n(String str) {
        aw remove = this.f268484b.remove(str);
        if (remove == null) {
            return;
        }
        h.p("StateMgr", false, "cache", "removeGuildState", "", str);
        remove.f();
        List<dt> arrayList = new ArrayList<>();
        arrayList.add(remove);
        j(arrayList);
    }

    public void o(@NonNull bt btVar) {
        this.f268485c.remove(btVar);
    }

    public void p(List<com.tencent.mobileqq.qqguildsdk.state.a> list) {
        h.p("StateMgr", false, "cache", "updateChannelState", "", "channelState size=" + list.size());
        HashSet hashSet = new HashSet();
        for (com.tencent.mobileqq.qqguildsdk.state.a aVar : list) {
            String guildId = aVar.getGuildId();
            u(guildId);
            aw awVar = this.f268484b.get(guildId);
            if (awVar != null) {
                awVar.i(aVar);
                hashSet.add(awVar);
            }
        }
        j(new ArrayList(hashSet));
    }

    public void q(GProUserChannelStateInfo gProUserChannelStateInfo) {
        if (gProUserChannelStateInfo == null) {
            return;
        }
        t(gProUserChannelStateInfo);
        String valueOf = String.valueOf(gProUserChannelStateInfo.getGuildId());
        aw awVar = this.f268484b.get(valueOf);
        if (awVar == null) {
            awVar = new aw(valueOf, null);
            this.f268484b.put(valueOf, awVar);
        }
        s(awVar);
        aw awVar2 = this.f268484b.get(valueOf);
        if (awVar2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(awVar2);
            j(arrayList);
        }
    }

    public void r(List<com.tencent.mobileqq.qqguildsdk.state.a> list) {
        p(list);
    }

    public void s(aw awVar) {
        if (awVar == null) {
            return;
        }
        String valueOf = String.valueOf(awVar.getGuildId());
        u(valueOf);
        aw awVar2 = this.f268484b.get(valueOf);
        if (awVar2.d() <= awVar.d()) {
            awVar2.h(awVar.d());
        }
        List<cz> channelStateList = awVar2.getChannelStateList();
        for (cz czVar : awVar.getChannelStateList()) {
            if (czVar != null && b(czVar.getChannelType())) {
                awVar2.i((com.tencent.mobileqq.qqguildsdk.state.a) czVar);
                int i3 = 0;
                while (true) {
                    if (i3 >= channelStateList.size()) {
                        break;
                    }
                    if (channelStateList.get(i3).getChannelId().equals(czVar.getChannelId())) {
                        channelStateList.remove(i3);
                        break;
                    }
                    i3++;
                }
            }
        }
        Iterator<cz> it = channelStateList.iterator();
        while (it.hasNext()) {
            awVar2.e(it.next().getChannelId());
        }
    }

    public void t(GProUserChannelStateInfo gProUserChannelStateInfo) {
        if (gProUserChannelStateInfo == null) {
            return;
        }
        if (this.f268487e == null) {
            this.f268487e = this.f268488f;
        }
        if (this.f268487e.getUserStateSeq() < gProUserChannelStateInfo.getUserStateSeq()) {
            this.f268487e = gProUserChannelStateInfo;
        }
        int f16 = f();
        if (this.f268487e.getPlatform() != f16) {
            this.f268487e.setUserState(2);
        }
        h.p("StateMgr", true, "cache", "updateMyUserChannelStateIfNeed", "", "myUserChannelState:" + this.f268487e + ", currPlatformType=" + f16 + ", userPlatformType=" + this.f268487e.getPlatform());
    }
}
