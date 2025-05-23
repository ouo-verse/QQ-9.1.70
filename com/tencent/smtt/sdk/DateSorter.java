package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DateSorter {
    public static int DAY_COUNT;

    /* renamed from: a, reason: collision with root package name */
    private android.webkit.DateSorter f368960a;

    /* renamed from: b, reason: collision with root package name */
    private IX5DateSorter f368961b;

    static {
        a();
        DAY_COUNT = 5;
    }

    public DateSorter(Context context) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            this.f368961b = a16.c().h(context);
        } else {
            this.f368960a = new android.webkit.DateSorter(context);
        }
    }

    private static boolean a() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return true;
        }
        return false;
    }

    public long getBoundary(int i3) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return this.f368961b.getBoundary(i3);
        }
        return this.f368960a.getBoundary(i3);
    }

    public int getIndex(long j3) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return this.f368961b.getIndex(j3);
        }
        return this.f368960a.getIndex(j3);
    }

    public String getLabel(int i3) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return this.f368961b.getLabel(i3);
        }
        return this.f368960a.getLabel(i3);
    }
}
