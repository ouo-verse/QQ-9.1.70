package com.tencent.mobileqq.qqguildsdk.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import vh2.v;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f268453a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<v>> f268454b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f268455c = new ConcurrentSkipListSet();

    /* renamed from: d, reason: collision with root package name */
    private boolean f268456d = true;

    /* renamed from: e, reason: collision with root package name */
    private final Set<String> f268457e = new ConcurrentSkipListSet();

    public d(GPSManagerEngine gPSManagerEngine) {
        this.f268453a = gPSManagerEngine;
    }

    public void a(String str, v vVar) {
        if (!TextUtils.isEmpty(str) && vVar != null) {
            synchronized (this.f268454b) {
                List<v> list = this.f268454b.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(vVar);
                this.f268454b.put(str, list);
            }
        }
    }

    public void b(int i3, String str) {
        if (this.f268455c.contains(str)) {
            this.f268455c.remove(str);
            if (i3 == 0) {
                this.f268453a.ej(4, "deleteChangeWithChannel", str);
            }
        }
    }

    public void c(String str) {
        if (this.f268456d) {
            this.f268457e.remove(str);
            if (this.f268457e.size() == 0) {
                if (g().size() > 0) {
                    this.f268453a.ej(1, "deleteFirstLoadGuildId", new Object[0]);
                }
                this.f268456d = false;
            }
        }
    }

    public void d(int i3, String str) {
        e(i3, str);
        c(str);
        b(i3, str);
    }

    public void e(int i3, String str) {
        o(i3, str);
    }

    public void f(ArrayList<String> arrayList, ArrayList<GProGuildInfo> arrayList2) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f268453a.Al(it.next(), false);
        }
        m(arrayList2);
    }

    public List<String> g() {
        return com.tencent.mobileqq.qqguildsdk.util.g.Y0(this.f268453a.bf());
    }

    public List<IGProGuildInfo> h() {
        return this.f268453a.hf();
    }

    public IGProGuildInfo i(String str) {
        IGProGuildInfo m217if = this.f268453a.m217if(com.tencent.mobileqq.qqguildsdk.util.g.O0(str));
        if (m217if != null && !"0".equals(m217if.getGuildID())) {
            return m217if;
        }
        h.u("GuildListMgr", false, "sdk interface", "getGuildInfo with error guildId\uff1a" + str);
        return null;
    }

    public List<IGProGuildInfo> j() {
        return this.f268453a.jf();
    }

    public boolean k() {
        return this.f268456d;
    }

    public void l(String str, GProGuildInfo gProGuildInfo) {
        h.e("GuildListMgr", false, "cache", "fetchGuildInfo ", "cache\u6ca1\u6709\u8be5\u7ad9\u70b9\u4fe1\u606f\uff0c\u5b58\u5165 \u6216 \u66f4\u65b0", "guildId \uff1a" + str);
    }

    public void m(ArrayList<GProGuildInfo> arrayList) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<GProGuildInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().getGuildID());
            sb5.append(", ");
        }
        h.e("GuildListMgr", false, "cache", "fetchGuildList ", "cache\u6ca1\u6709\u8be5\u7ad9\u70b9\u4fe1\u606f\uff0c\u5b58\u5165 \u6216 \u66f4\u65b0", "guildId \uff1a" + ((Object) sb5));
    }

    public void n(List<GProGuildInfo> list) {
        Iterator<GProGuildInfo> it = list.iterator();
        while (it.hasNext()) {
            this.f268457e.add(it.next().getGuildID());
        }
    }

    public void o(int i3, String str) {
        List<v> remove;
        synchronized (this.f268454b) {
            remove = this.f268454b.remove(str);
        }
        if (remove == null) {
            h.p("GuildListMgr", true, "sdk callback", "removeFetchCallback", "callback list is return null", "guildId: " + str + " result:" + i3);
            return;
        }
        IGProGuildInfo i16 = i(str);
        Iterator<v> it = remove.iterator();
        while (it.hasNext()) {
            it.next().a(i3, "", i16);
        }
    }

    public void p(String str) {
        this.f268455c.add(str);
    }
}
