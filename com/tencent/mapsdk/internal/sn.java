package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sn {

    /* renamed from: a, reason: collision with root package name */
    public final int f150344a;

    /* renamed from: b, reason: collision with root package name */
    public final int f150345b;

    /* renamed from: c, reason: collision with root package name */
    private final String f150346c = "_night";

    /* renamed from: d, reason: collision with root package name */
    private final List<st> f150347d;

    public sn(int i3, int i16, List<st> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f150347d = copyOnWriteArrayList;
        this.f150344a = i3;
        this.f150345b = i16;
        copyOnWriteArrayList.addAll(list);
        Collections.sort(list, new Comparator<st>() { // from class: com.tencent.mapsdk.internal.sn.1
            private static int a(st stVar, st stVar2) {
                return stVar2.a() - stVar.a();
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(st stVar, st stVar2) {
                return stVar2.a() - stVar.a();
            }
        });
    }

    private int b() {
        return this.f150345b;
    }

    public final Object[] a(gd gdVar, boolean z16) {
        String str;
        for (st stVar : this.f150347d) {
            if (stVar.a(gdVar)) {
                Bitmap a16 = stVar.a(z16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(stVar.f150392c);
                sb5.append(z16 ? "_night" : "");
                String sb6 = sb5.toString();
                return (!z16 || (str = stVar.f150394e) == null || str.length() <= 0) ? new Object[]{sb6, stVar.f150393d, a16} : new Object[]{sb6, stVar.f150394e, a16};
            }
        }
        return null;
    }

    private int a() {
        return this.f150344a;
    }
}
