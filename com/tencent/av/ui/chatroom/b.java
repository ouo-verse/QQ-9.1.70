package com.tencent.av.ui.chatroom;

import com.tencent.mobileqq.text.QQText;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f75510k = new Object();

    /* renamed from: l, reason: collision with root package name */
    private static b f75511l;

    /* renamed from: m, reason: collision with root package name */
    private static int f75512m;

    /* renamed from: a, reason: collision with root package name */
    private int f75513a;

    /* renamed from: b, reason: collision with root package name */
    private QQText f75514b;

    /* renamed from: c, reason: collision with root package name */
    private String f75515c;

    /* renamed from: d, reason: collision with root package name */
    private int f75516d;

    /* renamed from: e, reason: collision with root package name */
    private String f75517e;

    /* renamed from: f, reason: collision with root package name */
    private String f75518f;

    /* renamed from: g, reason: collision with root package name */
    private String f75519g;

    /* renamed from: h, reason: collision with root package name */
    private long f75520h;

    /* renamed from: i, reason: collision with root package name */
    private String f75521i;

    /* renamed from: j, reason: collision with root package name */
    private b f75522j = null;

    b() {
    }

    public static b d() {
        synchronized (f75510k) {
            b bVar = f75511l;
            if (bVar != null) {
                f75511l = bVar.f75522j;
                bVar.f75522j = null;
                f75512m--;
                return bVar;
            }
            return new b();
        }
    }

    public static void f(List<b> list) {
        if (list != null && list.size() != 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                b remove = list.remove(size);
                if (remove != null) {
                    remove.e();
                }
            }
        }
    }

    public CharSequence a() {
        return this.f75514b;
    }

    public String b() {
        return this.f75518f;
    }

    public String c() {
        return this.f75521i;
    }

    public void e() {
        this.f75513a = 0;
        this.f75514b = null;
        this.f75515c = null;
        this.f75516d = 0;
        this.f75518f = null;
        this.f75519g = null;
        this.f75520h = 0L;
        this.f75517e = null;
        this.f75521i = null;
        synchronized (f75510k) {
            int i3 = f75512m;
            if (i3 < 200) {
                this.f75522j = f75511l;
                f75511l = this;
                f75512m = i3 + 1;
            }
        }
    }

    public void g(String str) {
        this.f75514b = com.tencent.av.chatroom.c.c(str, 16);
    }

    public void h(String str) {
        this.f75518f = str;
    }

    public void i(String str) {
        this.f75521i = str;
    }

    public void j(int i3) {
        this.f75513a = i3;
    }

    public String toString() {
        return "VideoChatMessage{type=" + this.f75513a + ", content='" + ((Object) this.f75514b) + "', filepath='" + this.f75515c + "', sendState=" + this.f75516d + ", time='" + this.f75517e + "', header='" + this.f75518f + "', imageUrl='" + this.f75519g + "', voiceTime=" + this.f75520h + ", msgId='" + this.f75521i + "'}";
    }
}
