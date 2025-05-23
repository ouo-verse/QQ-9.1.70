package com.tencent.gamecenter.wadl.sdk.common.b.k;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f107048a;

    /* renamed from: b, reason: collision with root package name */
    private String f107049b;

    /* renamed from: c, reason: collision with root package name */
    private String f107050c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.gamecenter.wadl.sdk.common.b.a> f107051d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Integer> f107052e;

    public int a() {
        return this.f107048a;
    }

    public String b() {
        return this.f107049b;
    }

    public List<com.tencent.gamecenter.wadl.sdk.common.b.a> c() {
        return this.f107051d;
    }

    public String d() {
        return a(this.f107051d);
    }

    public String e() {
        return this.f107050c;
    }

    public String toString() {
        return "[appid:" + this.f107048a + ",ckip:" + this.f107049b + ",rule:" + this.f107050c + ",iplist:" + d() + ",httpPorts:" + this.f107052e + "]";
    }

    public static String a(List<com.tencent.gamecenter.wadl.sdk.common.b.a> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<com.tencent.gamecenter.wadl.sdk.common.b.a> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().d());
            sb5.append(",");
        }
        sb5.deleteCharAt(sb5.length() - 1);
        return sb5.toString();
    }
}
