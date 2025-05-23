package com.tencent.mobileqq.guild.message;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public int f230363b;

    /* renamed from: a, reason: collision with root package name */
    public a f230362a = new a();

    /* renamed from: c, reason: collision with root package name */
    public boolean f230364c = false;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f230365a = com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B;

        /* renamed from: b, reason: collision with root package name */
        public String f230366b = "";

        public boolean a() {
            if (this.f230365a == com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B) {
                return true;
            }
            return false;
        }

        public void b() {
            this.f230365a = com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B;
            this.f230366b = "";
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f230365a != aVar.f230365a || !this.f230366b.equals(aVar.f230366b)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "id:" + this.f230365a + " key:" + this.f230366b + " ";
        }
    }

    public d(int i3) {
        this.f230363b = i3;
    }

    public boolean a() {
        a aVar = this.f230362a;
        if (aVar != null && !aVar.a() && this.f230363b != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("uniqueKey:");
        a aVar = this.f230362a;
        if (aVar != null) {
            str = aVar.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append(" ");
        sb5.append("type:");
        sb5.append(this.f230363b);
        sb5.append(" ");
        sb5.append("bActive:");
        sb5.append(this.f230364c);
        sb5.append(" ");
        return sb5.toString();
    }
}
