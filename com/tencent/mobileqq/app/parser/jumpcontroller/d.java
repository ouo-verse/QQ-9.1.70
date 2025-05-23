package com.tencent.mobileqq.app.parser.jumpcontroller;

import com.tencent.mobileqq.app.parser.jumpcontroller.business.ShortCutJumpQFileResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.f;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.g;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.h;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.i;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.j;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.k;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.l;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.m;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.n;
import com.tencent.mobileqq.jumpcontroller.JumpControllerInject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqjump-api/src/main/resources/Inject_jump_activity_config.yml", version = 1)
    public static ArrayList<Class<? extends b>> f196484a;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqjump-api/src/main/resources/Inject_jump_activity_config.yml", version = 1)
    public static HashMap<String, Class<? extends a>> f196485b;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqjump-api/src/main/resources/Inject_jump_activity_config.yml", version = 1)
    public static ArrayList<Class<? extends c>> f196486c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        f196484a = arrayList;
        arrayList.add(JumpControllerInject.class);
        HashMap<String, Class<? extends a>> hashMap = new HashMap<>();
        f196485b = hashMap;
        hashMap.put("570", ShortCutJumpQFileResultPlugin.class);
        f196485b.put("25", n.class);
        f196485b.put("572", g.class);
        f196485b.put("2", h.class);
        f196485b.put("1", com.tencent.mobileqq.app.parser.jumpcontroller.business.d.class);
        f196485b.put("24", com.tencent.mobileqq.app.parser.jumpcontroller.business.c.class);
        f196485b.put("27", i.class);
        f196485b.put("26", j.class);
        f196485b.put("22", l.class);
        f196485b.put("21", m.class);
        f196485b.put("20", k.class);
        f196485b.put("19", f.class);
        f196485b.put("18", com.tencent.mobileqq.app.parser.jumpcontroller.business.b.class);
        f196485b.put("880", com.tencent.mobileqq.app.parser.jumpcontroller.business.e.class);
        f196485b.put(IndividuationPlugin.Business_Suit, com.tencent.mobileqq.app.parser.jumpcontroller.business.e.class);
        ArrayList<Class<? extends c>> arrayList2 = new ArrayList<>();
        f196486c = arrayList2;
        arrayList2.add(e.class);
    }
}
