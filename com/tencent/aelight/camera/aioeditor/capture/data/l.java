package com.tencent.aelight.camera.aioeditor.capture.data;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l implements Cloneable {
    public boolean C;

    /* renamed from: d, reason: collision with root package name */
    public List<qs.f> f66745d;

    /* renamed from: e, reason: collision with root package name */
    public int f66746e;

    /* renamed from: f, reason: collision with root package name */
    public String f66747f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f66748h;

    /* renamed from: i, reason: collision with root package name */
    public String f66749i;

    /* renamed from: m, reason: collision with root package name */
    public int f66750m;

    public l() {
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l clone() {
        l lVar = new l();
        lVar.f66747f = this.f66747f;
        lVar.f66746e = this.f66746e;
        lVar.f66748h = this.f66748h;
        lVar.f66749i = this.f66749i;
        lVar.f66750m = this.f66750m;
        lVar.C = this.C;
        ArrayList arrayList = new ArrayList();
        lVar.f66745d = arrayList;
        arrayList.addAll(this.f66745d);
        return lVar;
    }

    public l(String str) {
        this.f66747f = str;
    }
}
