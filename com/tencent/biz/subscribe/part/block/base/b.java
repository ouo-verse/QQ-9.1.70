package com.tencent.biz.subscribe.part.block.base;

import NS_COMM.COMM;
import android.text.TextUtils;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f96198a = true;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f96199b = 4;

    /* renamed from: c, reason: collision with root package name */
    private String f96200c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f96201d = null;

    /* renamed from: e, reason: collision with root package name */
    private COMM.StCommonExt f96202e;

    /* renamed from: f, reason: collision with root package name */
    private String f96203f;

    public String a() {
        if (this.f96203f == null) {
            this.f96203f = cl.d(BaseApplication.getContext(), "subscribe_ad_attachinfo_cache");
        }
        return this.f96203f;
    }

    public COMM.StCommonExt b() {
        return this.f96202e;
    }

    public COMM.StCommonExt c() {
        return this.f96202e;
    }

    public String d() {
        if (this.f96201d == null) {
            this.f96201d = cl.d(BaseApplication.getContext(), "subscribe_ad_livePageInfo_cache");
        }
        return this.f96201d;
    }

    public boolean e() {
        return this.f96198a;
    }

    public boolean f() {
        if (this.f96199b == 1) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f96199b == 3) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f96199b != 4) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f96199b == 2) {
            return true;
        }
        return false;
    }

    public void j(String str) {
        if (str != null) {
            cl.j(BaseApplication.getContext(), "subscribe_ad_attachinfo_cache", str);
        }
        this.f96203f = str;
    }

    public void k(COMM.StCommonExt stCommonExt) {
        this.f96202e = stCommonExt;
    }

    public void l(int i3) {
        this.f96199b = i3;
    }

    public void m(boolean z16) {
        this.f96198a = z16;
    }

    public void n(String str) {
        if (str != null) {
            cl.j(BaseApplication.getContext(), "subscribe_ad_attachinfo_cache", str);
        }
        this.f96201d = str;
        if (TextUtils.isEmpty(str)) {
            this.f96198a = true;
        } else {
            this.f96198a = false;
        }
    }
}
