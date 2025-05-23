package com.tencent.mobileqq.imcore.config.extension;

import com.tencent.mobileqq.activity.troop.config.f;
import com.tencent.mobileqq.activity.troop.config.g;
import com.tencent.mobileqq.activity.troop.config.i;
import com.tencent.mobileqq.activity.troop.config.p;
import com.tencent.mobileqq.activity.troop.config.u;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.troop.api.config.b;
import com.tencent.mobileqq.troop.api.config.d;
import com.tencent.mobileqq.troop.api.config.e;
import com.tencent.mobileqq.troop.api.config.j;
import com.tencent.mobileqq.troop.api.config.l;
import com.tencent.mobileqq.troop.api.config.m;
import com.tencent.mobileqq.troop.api.config.n;
import com.tencent.mobileqq.troop.api.config.o;
import com.tencent.mobileqq.troop.api.config.q;
import com.tencent.mobileqq.troop.api.config.t;
import com.tencent.troopguild.TroopGuildInfoListProcessor;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 7)
    public static ArrayList<Class<? extends j>> f238008a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends q>> f238009b;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends o>> f238010c;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends b>> f238011d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends m>> f238012e;

    /* renamed from: f, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 2)
    public static ArrayList<Class<? extends n>> f238013f;

    /* renamed from: g, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends l>> f238014g;

    /* renamed from: h, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends d>> f238015h;

    /* renamed from: i, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends e>> f238016i;

    /* renamed from: j, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_TroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends t>> f238017j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41753);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends j>> arrayList = new ArrayList<>();
        f238008a = arrayList;
        arrayList.add(com.tencent.mobileqq.activity.troop.config.n.class);
        f238008a.add(com.tencent.mobileqq.activity.troop.config.l.class);
        f238008a.add(TroopGuildInfoListProcessor.class);
        ArrayList<Class<? extends q>> arrayList2 = new ArrayList<>();
        f238009b = arrayList2;
        arrayList2.add(com.tencent.mobileqq.activity.troop.config.b.class);
        f238009b.add(com.tencent.mobileqq.activity.troop.config.j.class);
        ArrayList<Class<? extends o>> arrayList3 = new ArrayList<>();
        f238010c = arrayList3;
        arrayList3.add(i.class);
        f238010c.add(com.tencent.mobileqq.activity.troop.config.a.class);
        ArrayList<Class<? extends b>> arrayList4 = new ArrayList<>();
        f238011d = arrayList4;
        arrayList4.add(com.tencent.mobileqq.activity.troop.config.d.class);
        ArrayList<Class<? extends m>> arrayList5 = new ArrayList<>();
        f238012e = arrayList5;
        arrayList5.add(p.class);
        ArrayList<Class<? extends n>> arrayList6 = new ArrayList<>();
        f238013f = arrayList6;
        arrayList6.add(com.tencent.mobileqq.activity.troop.config.q.class);
        ArrayList<Class<? extends l>> arrayList7 = new ArrayList<>();
        f238014g = arrayList7;
        arrayList7.add(com.tencent.mobileqq.activity.troop.config.o.class);
        ArrayList<Class<? extends d>> arrayList8 = new ArrayList<>();
        f238015h = arrayList8;
        arrayList8.add(f.class);
        ArrayList<Class<? extends e>> arrayList9 = new ArrayList<>();
        f238016i = arrayList9;
        arrayList9.add(g.class);
        ArrayList<Class<? extends t>> arrayList10 = new ArrayList<>();
        f238017j = arrayList10;
        arrayList10.add(u.class);
    }
}
