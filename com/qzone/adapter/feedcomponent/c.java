package com.qzone.adapter.feedcomponent;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f41880a;

    /* renamed from: b, reason: collision with root package name */
    protected JceStruct f41881b;

    /* renamed from: c, reason: collision with root package name */
    protected Object f41882c;

    public abstract int a();

    public abstract ArrayList<single_feed> b();

    public abstract String c();

    public JceStruct d() {
        return this.f41881b;
    }

    public abstract Map<String, String> e();

    public Object f() {
        return this.f41882c;
    }

    public abstract int g();

    public int h() {
        return 0;
    }

    public abstract int i();

    public abstract int j();

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public abstract int m();

    public abstract String n();

    public abstract int o();

    public abstract String p();
}
