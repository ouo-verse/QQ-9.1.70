package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private static f f318425c;

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f318426a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f318427b;

    f() {
    }

    private void c() {
        if (!this.f318427b) {
            g();
        }
    }

    public static f e() {
        if (f318425c == null) {
            synchronized (f.class) {
                if (f318425c == null) {
                    f318425c = new f();
                }
            }
        }
        return f318425c;
    }

    private void g() {
        this.f318426a.addAll(Arrays.asList(AECameraPrefsUtil.c().g("wink_edit_template_favourite_id", "", 0).split(";")));
        this.f318427b = true;
    }

    public void a(String str) {
        c();
        this.f318426a.add(0, str);
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = this.f318426a.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(";");
        }
        AECameraPrefsUtil.c().k("wink_edit_template_favourite_id", sb5.toString(), 0);
    }

    public void b(String str) {
        c();
        this.f318426a.remove(str);
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = this.f318426a.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(";");
        }
        AECameraPrefsUtil.c().k("wink_edit_template_favourite_id", sb5.toString(), 0);
    }

    public List<String> d() {
        c();
        return new ArrayList(this.f318426a);
    }

    public boolean f(String str) {
        return this.f318426a.contains(str);
    }
}
