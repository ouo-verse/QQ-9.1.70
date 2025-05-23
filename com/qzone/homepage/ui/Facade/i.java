package com.qzone.homepage.ui.Facade;

import android.view.View;
import com.qzone.homepage.ui.Facade.model.ConfigArea;
import com.qzone.homepage.ui.Facade.ui.FacadeView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public int f47609a;

    /* renamed from: b, reason: collision with root package name */
    public int f47610b;

    /* renamed from: c, reason: collision with root package name */
    public String f47611c;

    /* renamed from: d, reason: collision with root package name */
    public double f47612d;

    /* renamed from: e, reason: collision with root package name */
    public double f47613e;

    /* renamed from: f, reason: collision with root package name */
    public double f47614f;

    /* renamed from: g, reason: collision with root package name */
    public double f47615g;

    /* renamed from: h, reason: collision with root package name */
    public int f47616h;

    /* renamed from: i, reason: collision with root package name */
    public int f47617i;

    /* renamed from: j, reason: collision with root package name */
    public int f47618j;

    /* renamed from: k, reason: collision with root package name */
    public int f47619k;

    public void b(ConfigArea configArea) {
        this.f47609a = configArea.indexId;
        this.f47610b = configArea.type;
        this.f47611c = configArea.schema;
        this.f47612d = configArea.f47630xp / 1000.0d;
        this.f47613e = configArea.f47631yp / 1000.0d;
        this.f47614f = configArea.f47628hp / 1000.0d;
        this.f47615g = configArea.f47629wp / 1000.0d;
    }

    public abstract View c(FacadeView facadeView);

    public static List<i> a(List<ConfigArea> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ConfigArea configArea : list) {
            int i3 = configArea.type;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        arrayList.add(com.qzone.homepage.ui.Facade.model.a.d(configArea));
                    } else if (i3 != 11) {
                        arrayList.add(j.d(configArea));
                    }
                }
                arrayList.add(e.d(configArea));
            } else {
                arrayList.add(j.d(configArea));
            }
        }
        return arrayList;
    }
}
