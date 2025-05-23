package com.qzone.module.personalitycomponent.coverWidget;

import com.qzone.proxy.personalitycomponent.model.WidgetVisitorsData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    private static volatile k f49001b;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<WidgetVisitorsData.WidgetVistor> f49002a = new ArrayList<>();

    k() {
    }

    public static k e() {
        if (f49001b == null) {
            synchronized (k.class) {
                if (f49001b == null) {
                    f49001b = new k();
                }
            }
        }
        return f49001b;
    }

    public void b() {
        this.f49002a.clear();
    }

    public ArrayList f() {
        return this.f49002a;
    }

    public boolean g() {
        ArrayList<WidgetVisitorsData.WidgetVistor> arrayList = this.f49002a;
        return arrayList != null && arrayList.size() > 0;
    }

    public void a(ArrayList<WidgetVisitorsData.WidgetVistor> arrayList) {
        if (arrayList == null) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            WidgetVisitorsData.WidgetVistor widgetVistor = arrayList.get(i3);
            if (widgetVistor != null && !c(widgetVistor)) {
                this.f49002a.add(widgetVistor);
            }
        }
    }

    public ArrayList<WidgetVisitorsData.WidgetVistor> d(ArrayList<WidgetVisitorsData.WidgetVistor> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<WidgetVisitorsData.WidgetVistor> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            WidgetVisitorsData.WidgetVistor widgetVistor = arrayList.get(i3);
            if (widgetVistor != null && !c(widgetVistor)) {
                arrayList2.add(widgetVistor);
            }
        }
        return arrayList2;
    }

    private boolean c(WidgetVisitorsData.WidgetVistor widgetVistor) {
        if (widgetVistor == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.f49002a.size(); i3++) {
            WidgetVisitorsData.WidgetVistor widgetVistor2 = this.f49002a.get(i3);
            if (widgetVistor2 != null && widgetVistor2.uin == widgetVistor.uin) {
                return true;
            }
        }
        return false;
    }
}
