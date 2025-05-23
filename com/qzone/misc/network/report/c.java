package com.qzone.misc.network.report;

import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final c f48496a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static HashSet<String> f48497b;

    static {
        HashSet<String> hashSet = new HashSet<>();
        f48497b = hashSet;
        hashSet.add("feedsFilter20130201");
        f48497b.add("cancelBtns20130201");
        f48497b.add("sendGift20130311");
    }

    public static void a(int i3, int i16, int i17) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(i3, i16, i17), false, false);
    }

    public static void b(String str, String str2) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(str, str2), false, false);
    }
}
