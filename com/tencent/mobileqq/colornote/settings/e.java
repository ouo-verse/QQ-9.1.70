package com.tencent.mobileqq.colornote.settings;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Business/ColorNote-impl/src/main/resources/Inject_ColorNoteSettingConfig.yml", version = 1)
    public static ArrayList<Class<? extends g>> f201553a;

    /* renamed from: b, reason: collision with root package name */
    static List<g> f201554b;

    static {
        ArrayList<Class<? extends g>> arrayList = new ArrayList<>();
        f201553a = arrayList;
        arrayList.add(ka1.a.class);
        f201554b = new ArrayList();
        try {
            Iterator<Class<? extends g>> it = f201553a.iterator();
            while (it.hasNext()) {
                f201554b.add(it.next().newInstance());
            }
        } catch (Exception e16) {
            QLog.e("ColorNoteSettingUtil", 1, "[static]", e16);
        }
    }

    public static void a(boolean z16) {
        Iterator<g> it = f201554b.iterator();
        while (it.hasNext()) {
            it.next().a(z16);
        }
    }
}
