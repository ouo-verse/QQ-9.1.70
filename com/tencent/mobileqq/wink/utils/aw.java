package com.tencent.mobileqq.wink.utils;

import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class aw {

    /* renamed from: c, reason: collision with root package name */
    private static aw f326690c;

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f326691a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f326692b;

    aw() {
    }

    private void c() {
        if (!this.f326692b) {
            g();
        }
    }

    public static aw e() {
        if (f326690c == null) {
            synchronized (aw.class) {
                if (f326690c == null) {
                    f326690c = new aw();
                }
            }
        }
        return f326690c;
    }

    private void g() {
        String g16 = AECameraPrefsUtil.c().g("wink_template_favourite_id", "", 0);
        if (g16 != null) {
            this.f326691a.addAll(Arrays.asList(g16.split(";")));
        }
        this.f326692b = true;
    }

    public void a(String str) {
        c();
        this.f326691a.add(0, str);
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = this.f326691a.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(";");
        }
        AECameraPrefsUtil.c().k("wink_template_favourite_id", sb5.toString(), 0);
    }

    public void b(String str) {
        c();
        this.f326691a.remove(str);
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = this.f326691a.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(";");
        }
        AECameraPrefsUtil.c().k("wink_template_favourite_id", sb5.toString(), 0);
    }

    public List<String> d() {
        c();
        return new ArrayList(this.f326691a);
    }

    public boolean f(String str) {
        c();
        return this.f326691a.contains(str);
    }
}
