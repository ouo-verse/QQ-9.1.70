package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f265718a;

    /* renamed from: b, reason: collision with root package name */
    private long f265719b;

    /* renamed from: c, reason: collision with root package name */
    private List<String> f265720c;

    /* renamed from: d, reason: collision with root package name */
    int f265721d;

    public b(String str, long j3) {
        this.f265718a = str;
        this.f265719b = j3;
        this.f265720c = new ArrayList();
    }

    private boolean i() {
        if (this.f265718a != null) {
            return true;
        }
        return false;
    }

    public void a(String str) {
        this.f265720c.add(str);
    }

    public long b() {
        return this.f265719b;
    }

    public String c() {
        return this.f265718a;
    }

    public int d() {
        return this.f265721d;
    }

    @NonNull
    public List<String> e() {
        return this.f265720c;
    }

    public boolean f() {
        List<String> list = this.f265720c;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean g(boolean z16) {
        if (!z16 && !i()) {
            return false;
        }
        if (z16 && !h()) {
            return false;
        }
        return true;
    }

    public boolean h() {
        if (!TextUtils.isEmpty(this.f265718a) && this.f265719b != 0) {
            return true;
        }
        return false;
    }

    public void j(int i3) {
        this.f265721d = i3;
    }

    public b(String str, long j3, List<String> list) {
        this.f265718a = str;
        this.f265719b = j3;
        this.f265720c = list;
    }
}
