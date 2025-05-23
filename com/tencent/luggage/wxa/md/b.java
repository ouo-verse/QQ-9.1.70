package com.tencent.luggage.wxa.md;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f134421a;

    /* renamed from: b, reason: collision with root package name */
    public String f134422b;

    /* renamed from: c, reason: collision with root package name */
    public int f134423c;

    /* renamed from: d, reason: collision with root package name */
    public int f134424d;

    /* renamed from: e, reason: collision with root package name */
    public int f134425e;

    /* renamed from: f, reason: collision with root package name */
    public String f134426f;

    /* renamed from: g, reason: collision with root package name */
    public String f134427g;

    /* renamed from: h, reason: collision with root package name */
    public String f134428h;

    /* renamed from: i, reason: collision with root package name */
    public String f134429i;

    /* renamed from: j, reason: collision with root package name */
    public String f134430j;

    /* renamed from: k, reason: collision with root package name */
    public String f134431k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f134432l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f134433m = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f134422b.equals(bVar.f134422b) && this.f134423c == bVar.f134423c && this.f134430j.equals(bVar.f134430j)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        Iterator it = this.f134432l.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            sb5.append("[");
            sb5.append(fVar.toString());
            sb5.append("]\n");
        }
        return "host=" + this.f134422b + "\nport=" + this.f134423c + "\nmajor=" + this.f134424d + "\nminor=" + this.f134425e + "\ndeviceType=" + this.f134426f + "\nfriendlyName=" + this.f134427g + "\nmanufacturer=" + this.f134428h + "\nmodeName=" + this.f134429i + "\nserviceCount=" + this.f134432l.size() + "\nserviceList=\n" + sb5.toString();
    }
}
