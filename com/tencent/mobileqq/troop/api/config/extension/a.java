package com.tencent.mobileqq.troop.api.config.extension;

import com.tencent.mobileqq.activity.troop.config.TroopConfigProcessor;
import com.tencent.mobileqq.activity.troop.config.e;
import com.tencent.mobileqq.activity.troop.config.m;
import com.tencent.mobileqq.activity.troop.config.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.troop.api.config.c;
import com.tencent.mobileqq.troop.api.config.g;
import com.tencent.mobileqq.troop.api.config.h;
import com.tencent.mobileqq.troop.api.config.k;
import com.tencent.mobileqq.troop.api.config.p;
import com.tencent.mobileqq.troop.api.config.r;
import com.tencent.mobileqq.troop.api.config.s;
import com.tencent.mobileqq.utils.cb;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends com.tencent.mobileqq.troop.api.config.a>> f293977a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends r>> f293978b;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends s>> f293979c;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends h>> f293980d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends c>> f293981e;

    /* renamed from: f, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends p>> f293982f;

    /* renamed from: g, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends k>> f293983g;

    /* renamed from: h, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends g>> f293984h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63883);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends com.tencent.mobileqq.troop.api.config.a>> arrayList = new ArrayList<>();
        f293977a = arrayList;
        arrayList.add(com.tencent.mobileqq.troop.roamsetting.c.class);
        f293977a.add(cb.class);
        ArrayList<Class<? extends r>> arrayList2 = new ArrayList<>();
        f293978b = arrayList2;
        arrayList2.add(com.tencent.mobileqq.activity.troop.config.s.class);
        ArrayList<Class<? extends s>> arrayList3 = new ArrayList<>();
        f293979c = arrayList3;
        arrayList3.add(t.class);
        ArrayList<Class<? extends h>> arrayList4 = new ArrayList<>();
        f293980d = arrayList4;
        arrayList4.add(m.class);
        ArrayList<Class<? extends c>> arrayList5 = new ArrayList<>();
        f293981e = arrayList5;
        arrayList5.add(e.class);
        ArrayList<Class<? extends p>> arrayList6 = new ArrayList<>();
        f293982f = arrayList6;
        arrayList6.add(com.tencent.mobileqq.activity.troop.config.r.class);
        ArrayList<Class<? extends k>> arrayList7 = new ArrayList<>();
        f293983g = arrayList7;
        arrayList7.add(com.tencent.mobileqq.activity.troop.config.c.class);
        ArrayList<Class<? extends g>> arrayList8 = new ArrayList<>();
        f293984h = arrayList8;
        arrayList8.add(TroopConfigProcessor.class);
    }
}
