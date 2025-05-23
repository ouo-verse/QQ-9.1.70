package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class an implements al {

    /* renamed from: j, reason: collision with root package name */
    public static final String f75362j = "an";

    /* renamed from: h, reason: collision with root package name */
    private VideoLayerUI f75370h;

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f75363a = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    private boolean f75364b = false;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<com.tencent.av.e> f75365c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f75366d = new Object[0];

    /* renamed from: e, reason: collision with root package name */
    private boolean f75367e = true;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<am> f75368f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private final Object[] f75369g = new Object[0];

    /* renamed from: i, reason: collision with root package name */
    private boolean f75371i = false;

    public an(VideoLayerUI videoLayerUI) {
        this.f75370h = videoLayerUI;
    }

    private String c(long j3, int i3) {
        return String.valueOf(j3) + String.valueOf(i3);
    }

    @Override // com.tencent.av.ui.al
    public void a() {
        if (this.f75371i) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(f75362j, 1, "onMemmbersInOrOutChange");
        }
        synchronized (this.f75366d) {
            this.f75367e = true;
        }
    }

    public void b() {
        synchronized (this.f75363a) {
            this.f75364b = false;
            this.f75365c.clear();
        }
        synchronized (this.f75369g) {
            this.f75368f.clear();
        }
        this.f75371i = true;
    }

    public ArrayList<am> d(boolean z16) {
        boolean z17;
        ArrayList<am> arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f75363a) {
            if (this.f75364b) {
                this.f75364b = false;
                z17 = true;
            } else {
                z17 = false;
            }
        }
        synchronized (this.f75366d) {
            if (this.f75367e) {
                this.f75367e = false;
                z17 = true;
            }
        }
        if (z17 || z16) {
            synchronized (this.f75369g) {
                this.f75368f.clear();
                HashMap hashMap = new HashMap();
                synchronized (com.tencent.av.n.e().f().f73053m1) {
                    Iterator<com.tencent.av.gaudio.c> it = com.tencent.av.n.e().f().f73053m1.iterator();
                    while (it.hasNext()) {
                        com.tencent.av.gaudio.c next = it.next();
                        am amVar = new am();
                        amVar.f75350b = next.f73827a;
                        amVar.f75360l = next.f73828b;
                        amVar.f75361m = next.f73835i;
                        amVar.f75359k = next.f73829c;
                        amVar.f75358j = true;
                        amVar.f75352d = true;
                        this.f75368f.add(amVar);
                        String c16 = c(amVar.f75350b, amVar.f75360l);
                        am amVar2 = (am) hashMap.put(c16, amVar);
                        if (amVar2 != null) {
                            if (amVar.e()) {
                                hashMap.put(c16, amVar2);
                            }
                            QLog.w(f75362j, 1, "getVideoViewList oldInfo:=" + amVar2.toString());
                        }
                    }
                }
                synchronized (this.f75363a) {
                    Iterator<com.tencent.av.e> it5 = this.f75365c.iterator();
                    while (it5.hasNext()) {
                        com.tencent.av.e next2 = it5.next();
                        am amVar3 = (am) hashMap.get(c(next2.f73701a, 1));
                        if (amVar3 == null) {
                            amVar3 = (am) hashMap.get(c(next2.f73701a, 2));
                        }
                        if (amVar3 != null) {
                            if (amVar3.b() != 2) {
                                amVar3.f75351c = next2.f73702b;
                                amVar3.f75353e = next2.f73703c;
                                amVar3.f75349a = next2.f73715o;
                                amVar3.f75354f = next2.f73716p;
                                amVar3.f75355g = next2.f73717q;
                                amVar3.f75356h = next2.f73718r;
                            } else {
                                amVar3.f75353e = false;
                            }
                        } else {
                            am amVar4 = new am();
                            amVar4.f75350b = next2.f73701a;
                            amVar4.f75351c = next2.f73702b;
                            amVar4.f75360l = 0;
                            amVar4.f75358j = false;
                            amVar4.f75352d = next2.f73724x;
                            amVar4.f75354f = next2.f73716p;
                            amVar4.f75353e = next2.f73703c;
                            amVar4.f75349a = next2.f73715o;
                            amVar4.f75355g = next2.f73717q;
                            amVar4.f75356h = next2.f73718r;
                            this.f75368f.add(amVar4);
                        }
                    }
                }
                Iterator<am> it6 = this.f75368f.iterator();
                while (it6.hasNext()) {
                    am next3 = it6.next();
                    am n26 = this.f75370h.n2(next3.f75350b);
                    if (n26 != null) {
                        next3.f75353e = n26.f75353e;
                        next3.f75355g = n26.f75355g;
                    }
                }
            }
        }
        synchronized (this.f75369g) {
            arrayList = (ArrayList) this.f75368f.clone();
        }
        if (QLog.isColorLevel()) {
            QLog.d(f75362j, 1, "getVideoViewList listSort exceedMaxNumber cost" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    public ArrayList<am> e() {
        ArrayList<am> arrayList;
        synchronized (this.f75369g) {
            arrayList = (ArrayList) this.f75368f.clone();
        }
        return arrayList;
    }

    public boolean f() {
        if (this.f75371i) {
            return false;
        }
        synchronized (this.f75363a) {
            this.f75364b = true;
        }
        return true;
    }

    public void g(ArrayList<com.tencent.av.e> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.w(f75362j, 1, "updateAudioMemberListInfo");
        }
        if (this.f75371i) {
            return;
        }
        synchronized (this.f75363a) {
            this.f75364b = true;
            this.f75365c.clear();
            this.f75365c.addAll(arrayList);
        }
    }

    public boolean h(long j3, boolean z16) {
        if (this.f75371i) {
            return false;
        }
        synchronized (this.f75363a) {
            this.f75364b = true;
        }
        return true;
    }
}
