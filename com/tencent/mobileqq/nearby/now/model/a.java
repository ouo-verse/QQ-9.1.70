package com.tencent.mobileqq.nearby.now.model;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f252707a;

    /* renamed from: c, reason: collision with root package name */
    public AppInterface f252709c;

    /* renamed from: e, reason: collision with root package name */
    protected InterfaceC8140a f252711e;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f252708b = false;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<VideoData> f252710d = new ArrayList<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.nearby.now.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public interface InterfaceC8140a {
        void a(VideoData videoData);

        void b(int i3, int i16);

        @Deprecated
        void onError();
    }

    public ArrayList<VideoData> c() {
        return this.f252710d;
    }

    public int d() {
        return this.f252707a;
    }

    public abstract void e(Bundle bundle);

    public boolean f() {
        return this.f252708b;
    }

    public void g(InterfaceC8140a interfaceC8140a) {
        this.f252711e = interfaceC8140a;
    }

    public void h(boolean z16) {
        this.f252708b = z16;
    }

    public void a() {
    }

    public void b() {
    }

    public void i(String str, String str2) {
    }
}
