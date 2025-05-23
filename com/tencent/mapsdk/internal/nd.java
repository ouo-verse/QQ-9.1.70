package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.tk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nd {

    /* renamed from: a, reason: collision with root package name */
    public final bf f149380a;

    /* renamed from: b, reason: collision with root package name */
    public final tk f149381b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, pi> f149382c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<Integer, pi> f149383d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet<String> f149384e = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public nd(bf bfVar, tk tkVar) {
        this.f149380a = bfVar;
        this.f149381b = tkVar;
    }

    private static Bitmap a(String str) {
        return hn.f148686b.a(str);
    }

    private void b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, pi> entry : this.f149382c.entrySet()) {
            Integer key = entry.getKey();
            entry.getValue();
            if (!this.f149383d.containsKey(key)) {
                arrayList.add(Integer.valueOf(key.intValue()));
            }
        }
        Iterator<String> it = this.f149384e.iterator();
        while (it.hasNext()) {
            hn.f148686b.b(it.next());
        }
        this.f149384e.clear();
        int size = arrayList.size();
        if (size <= 0) {
            return;
        }
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        LogUtil.b("Marker", "deleteIcons GIcon [" + Arrays.toString(iArr) + "]");
        this.f149381b.a(iArr, size);
    }

    private void c() {
        this.f149382c.clear();
        this.f149382c.putAll(this.f149383d);
        this.f149383d.clear();
    }

    private bf d() {
        return this.f149380a;
    }

    private float e() {
        return this.f149380a.a().A.f151253b.f151290p;
    }

    private void a(pi piVar) {
        int a16 = piVar.I.a();
        if (a16 > 0 && this.f149382c.containsKey(Integer.valueOf(a16))) {
            if (piVar.f149502q.get() > 0) {
                piVar.f149501p = true;
                piVar.f149502q.set(0);
            }
            if (piVar.f149501p) {
                tk tkVar = this.f149381b;
                if (0 != tkVar.f150515e) {
                    tkVar.a(new tk.AnonymousClass145(piVar));
                }
                if (piVar.B.get() > 0) {
                    piVar.A = true;
                    piVar.B.set(0);
                }
                if (piVar.A) {
                    if (!piVar.H) {
                        this.f149384e.add(piVar.f149492g);
                    }
                    hn.f148686b.a(piVar.f149491f, piVar.d());
                    piVar.b(false);
                }
            }
            piVar.a(false);
            this.f149383d.put(Integer.valueOf(a16), piVar);
            return;
        }
        LogUtil.b("Marker", "addMarker GIcon before [" + a16 + "]");
        tk tkVar2 = this.f149381b;
        int intValue = ((Integer) tkVar2.a((CallbackRunnable<tk.AnonymousClass144>) new tk.AnonymousClass144(piVar), (tk.AnonymousClass144) 0)).intValue();
        piVar.I.f149561m = intValue;
        LogUtil.b("Marker", "addMarker GIcon after [" + intValue + "]");
        if (intValue > 0) {
            hn.f148686b.a(piVar.f149491f, piVar.d());
            piVar.b(false);
            piVar.a(false);
            this.f149383d.put(Integer.valueOf(intValue), piVar);
            LogUtil.b("Marker", "mCurFrameDisplayMap: " + this.f149383d.keySet());
        }
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, pi> entry : this.f149382c.entrySet()) {
            Integer key = entry.getKey();
            entry.getValue();
            if (!this.f149383d.containsKey(key)) {
                arrayList.add(Integer.valueOf(key.intValue()));
            }
        }
        Iterator<String> it = this.f149384e.iterator();
        while (it.hasNext()) {
            hn.f148686b.b(it.next());
        }
        this.f149384e.clear();
        int size = arrayList.size();
        if (size > 0) {
            int[] iArr = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
            }
            LogUtil.b("Marker", "deleteIcons GIcon [" + Arrays.toString(iArr) + "]");
            this.f149381b.a(iArr, size);
        }
        this.f149382c.clear();
        this.f149382c.putAll(this.f149383d);
        this.f149383d.clear();
    }
}
