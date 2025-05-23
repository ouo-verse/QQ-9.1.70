package com.tencent.mobileqq.colornote;

import com.tencent.mobileqq.colornote.launcher.WebLauncher;
import com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceLauncher;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import fa1.h;
import fa1.i;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Business/ColorNote-impl/src/main/resources/Inject_ColorNoteLauncherConfig.yml", version = 1)
    public static ArrayList<Class<? extends fa1.b>> f201388a;

    static {
        ArrayList<Class<? extends fa1.b>> arrayList = new ArrayList<>();
        f201388a = arrayList;
        arrayList.add(fa1.a.class);
        f201388a.add(fa1.c.class);
        f201388a.add(fa1.d.class);
        f201388a.add(fa1.e.class);
        f201388a.add(fa1.f.class);
        f201388a.add(QQVoiceLauncher.class);
        f201388a.add(fa1.g.class);
        f201388a.add(h.class);
        f201388a.add(i.class);
        f201388a.add(WebLauncher.class);
        f201388a.add(b23.a.class);
    }
}
