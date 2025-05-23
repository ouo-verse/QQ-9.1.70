package com.tencent.biz;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_authorize_config_business.yml", version = 1)
    public static ArrayList<Class<? extends s43.b>> f78563a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_authorize_config_business.yml", version = 1)
    public static ArrayList<Class<? extends s43.a>> f78564b;

    static {
        ArrayList<Class<? extends s43.b>> arrayList = new ArrayList<>();
        f78563a = arrayList;
        arrayList.add(lx.a.class);
        f78563a.add(lx.c.class);
        f78563a.add(lx.g.class);
        f78563a.add(lx.f.class);
        ArrayList<Class<? extends s43.a>> arrayList2 = new ArrayList<>();
        f78564b = arrayList2;
        arrayList2.add(lx.d.class);
    }
}
