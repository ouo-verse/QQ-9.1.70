package com.tencent.mobileqq.guild.message.lastmsg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f230647a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f230648b;

    /* renamed from: c, reason: collision with root package name */
    public int f230649c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f230650d;

    /* renamed from: e, reason: collision with root package name */
    public Object f230651e;

    public c(String str, boolean z16, boolean z17, int i3, Object obj) {
        this.f230647a = str;
        this.f230648b = z16;
        this.f230650d = z17;
        this.f230649c = i3;
        this.f230651e = obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.f230647a;
        if (str == null) {
            if (cVar.f230647a == null && this.f230649c == cVar.f230649c) {
                return true;
            }
            return false;
        }
        if (str.equals(cVar.f230647a) && this.f230649c == cVar.f230649c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        String str = this.f230647a;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (i3 * 31) + this.f230649c;
    }
}
