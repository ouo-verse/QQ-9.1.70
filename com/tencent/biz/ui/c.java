package com.tencent.biz.ui;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f97018a;

    /* renamed from: b, reason: collision with root package name */
    private String f97019b;

    /* renamed from: c, reason: collision with root package name */
    private String f97020c;

    /* renamed from: d, reason: collision with root package name */
    private int f97021d;

    /* renamed from: e, reason: collision with root package name */
    private List<c> f97022e = null;

    /* renamed from: f, reason: collision with root package name */
    String f97023f;

    /* renamed from: g, reason: collision with root package name */
    String f97024g;

    /* renamed from: h, reason: collision with root package name */
    String f97025h;

    /* renamed from: i, reason: collision with root package name */
    String f97026i;

    public c(String str, String str2, Drawable drawable, int i3) {
        this.f97018a = drawable;
        this.f97019b = str2;
        this.f97020c = str;
        this.f97021d = i3;
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f97022e == null) {
            this.f97022e = new ArrayList();
        }
        this.f97022e.add(cVar);
    }

    public Drawable b() {
        return this.f97018a;
    }

    public String c() {
        return this.f97023f;
    }

    public String d() {
        return this.f97020c;
    }

    public int e() {
        return this.f97021d;
    }

    public c f(int i3) {
        List<c> list = this.f97022e;
        if (list == null) {
            return null;
        }
        return list.get(i3);
    }

    public int g() {
        List<c> list = this.f97022e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<c> h() {
        return this.f97022e;
    }

    public String i() {
        return this.f97019b;
    }

    public boolean j() {
        if (this.f97022e != null) {
            return true;
        }
        return false;
    }

    public void k(mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo) {
        if (mobileqq_mp_buttoninfo.logo_url.has()) {
            this.f97023f = mobileqq_mp_buttoninfo.logo_url.get();
        }
        if (mobileqq_mp_buttoninfo.texture_url.has()) {
            this.f97026i = mobileqq_mp_buttoninfo.texture_url.get();
        }
        if (mobileqq_mp_buttoninfo.bg_colors.has()) {
            String[] split = mobileqq_mp_buttoninfo.bg_colors.get().split("\\|");
            if (split.length > 0) {
                this.f97024g = split[0];
            }
            if (split.length > 1) {
                this.f97025h = split[1];
            }
        }
    }
}
