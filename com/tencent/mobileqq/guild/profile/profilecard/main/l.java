package com.tencent.mobileqq.guild.profile.profilecard.main;

import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private int f231535a;

    /* renamed from: b, reason: collision with root package name */
    private String f231536b;

    /* renamed from: c, reason: collision with root package name */
    private IGProSecurityResult f231537c;

    public l() {
    }

    public static l e(int i3, String str) {
        l lVar = new l();
        lVar.f(i3);
        lVar.h(str);
        return lVar;
    }

    public int a() {
        return this.f231535a;
    }

    public IGProSecurityResult b() {
        return this.f231537c;
    }

    public String c() {
        return this.f231536b;
    }

    public boolean d() {
        if (this.f231535a == 0 && ch.p(this.f231537c)) {
            return true;
        }
        return false;
    }

    public void f(int i3) {
        this.f231535a = i3;
    }

    public void g(IGProSecurityResult iGProSecurityResult) {
        this.f231537c = iGProSecurityResult;
    }

    public void h(String str) {
        this.f231536b = str;
    }

    public l(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        this.f231535a = i3;
        this.f231536b = str;
        this.f231537c = iGProSecurityResult;
    }
}
