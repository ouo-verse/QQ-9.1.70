package com.heytap.mcssdk.c;

import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends BaseMode {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36141a = "&";

    /* renamed from: b, reason: collision with root package name */
    private String f36142b;

    /* renamed from: c, reason: collision with root package name */
    private String f36143c;

    /* renamed from: d, reason: collision with root package name */
    private String f36144d;

    /* renamed from: e, reason: collision with root package name */
    private String f36145e;

    /* renamed from: f, reason: collision with root package name */
    private int f36146f;

    /* renamed from: g, reason: collision with root package name */
    private String f36147g;

    /* renamed from: h, reason: collision with root package name */
    private int f36148h = -2;

    /* renamed from: i, reason: collision with root package name */
    private String f36149i;

    public String a() {
        return this.f36142b;
    }

    public String b() {
        return this.f36143c;
    }

    public String c() {
        return this.f36144d;
    }

    public String d() {
        return this.f36145e;
    }

    public int e() {
        return this.f36146f;
    }

    public String f() {
        return this.f36147g;
    }

    public int g() {
        return this.f36148h;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4105;
    }

    public String h() {
        return this.f36149i;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.f36144d + "', mSdkVersion='" + this.f36145e + "', mCommand=" + this.f36146f + "', mContent='" + this.f36147g + "', mAppPackage=" + this.f36149i + "', mResponseCode=" + this.f36148h + '}';
    }

    public static <T> String a(List<T> list) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append("&");
        }
        return sb5.toString();
    }

    public void b(int i3) {
        this.f36148h = i3;
    }

    public void c(String str) {
        this.f36144d = str;
    }

    public void d(String str) {
        this.f36145e = str;
    }

    public void e(String str) {
        this.f36147g = str;
    }

    public void f(String str) {
        this.f36149i = str;
    }

    public void a(int i3) {
        this.f36146f = i3;
    }

    public void b(String str) {
        this.f36143c = str;
    }

    public void a(String str) {
        this.f36142b = str;
    }
}
