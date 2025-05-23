package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.config.g;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class b {

    /* renamed from: e, reason: collision with root package name */
    public short f202972e;

    /* renamed from: m, reason: collision with root package name */
    public byte f202976m;

    /* renamed from: d, reason: collision with root package name */
    private final int f202971d = g.h();

    /* renamed from: f, reason: collision with root package name */
    public long f202973f = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f202974h = -1;

    /* renamed from: i, reason: collision with root package name */
    public long f202975i = -1;
    protected ArrayList C = new ArrayList();
    private boolean D = false;

    public b(short s16, byte b16) {
        this.f202972e = (short) 0;
        this.f202976m = (byte) -1;
        this.f202972e = s16;
        this.f202976m = b16;
    }

    public void a(Object obj) {
        this.C.add(obj);
    }

    public abstract void b();

    public final int c() {
        return this.C.size();
    }

    public final boolean d() {
        if (this.f202974h > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        long j3 = this.f202975i;
        if (j3 > 0 && j3 <= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public abstract void f(DataInputStream dataInputStream) throws Exception;

    public void g() {
        this.C.clear();
    }

    public void h(String str) {
        if (str != null && !str.trim().equals("")) {
            int i3 = 0;
            while (true) {
                if (i3 < this.C.size()) {
                    String str2 = ((PicAndAdConf.a) this.C.get(i3)).f202955f;
                    if (str2 != null && str2.contains(str)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                this.C.remove(i3);
            }
        }
    }

    public abstract void i(DataOutputStream dataOutputStream) throws Exception;

    public final void j(boolean z16) {
        this.D = z16;
    }
}
