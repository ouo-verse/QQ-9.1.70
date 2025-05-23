package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qqguildsdk.data.type.IGuildNoticeType;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes17.dex */
public class co {

    /* renamed from: a, reason: collision with root package name */
    public String f265885a;

    /* renamed from: b, reason: collision with root package name */
    public int f265886b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f265887c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f265888d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f265889e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f265890f;

    /* renamed from: g, reason: collision with root package name */
    public b f265891g;

    /* renamed from: h, reason: collision with root package name */
    public List<h> f265892h;

    /* renamed from: i, reason: collision with root package name */
    public List<h> f265893i;

    /* renamed from: j, reason: collision with root package name */
    public List<h> f265894j;

    /* renamed from: k, reason: collision with root package name */
    public List<a> f265895k;

    /* renamed from: l, reason: collision with root package name */
    public String f265896l;

    /* renamed from: m, reason: collision with root package name */
    public int f265897m;

    /* renamed from: n, reason: collision with root package name */
    public List<c> f265898n;

    /* renamed from: o, reason: collision with root package name */
    @IGuildNoticeType
    public int f265899o;

    /* renamed from: p, reason: collision with root package name */
    public long f265900p;

    /* renamed from: q, reason: collision with root package name */
    public String f265901q;

    /* renamed from: r, reason: collision with root package name */
    public long f265902r;

    /* renamed from: s, reason: collision with root package name */
    public String f265903s;

    /* renamed from: t, reason: collision with root package name */
    public List<d> f265904t;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f265905a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f265906b;

        /* renamed from: c, reason: collision with root package name */
        public String f265907c;

        @NonNull
        public String toString() {
            return "{type:" + this.f265905a + " actionId:" + this.f265907c + " title:" + this.f265906b + "}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f265908a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f265909b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f265910c;

        @NonNull
        public String toString() {
            return "{type:" + this.f265908a + " id:" + this.f265909b + " url:" + this.f265910c + "}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f265911a;

        /* renamed from: b, reason: collision with root package name */
        public String f265912b;

        /* renamed from: c, reason: collision with root package name */
        public int f265913c;

        /* renamed from: d, reason: collision with root package name */
        public String f265914d = "";

        /* renamed from: e, reason: collision with root package name */
        public int f265915e;

        @NonNull
        public String toString() {
            return "{text:" + this.f265911a + " url:" + this.f265912b + "}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public e f265916a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public g f265917b;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public String f265918a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f265919b = 0;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public String f265920a = "";
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public int f265921a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public f f265922b;

        /* renamed from: c, reason: collision with root package name */
        public String f265923c;
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f265924a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f265925b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f265926c;

        @NonNull
        public String toString() {
            return "{type:" + this.f265924a + " id:" + this.f265925b + " content:" + this.f265926c + "}";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        co coVar = (co) obj;
        if (this.f265886b == coVar.f265886b && this.f265887c == coVar.f265887c && this.f265888d == coVar.f265888d && this.f265885a.equals(coVar.f265885a) && this.f265890f.equals(coVar.f265890f)) {
            return true;
        }
        return false;
    }

    @RequiresApi(api = 19)
    public int hashCode() {
        return Objects.hash(this.f265885a, Integer.valueOf(this.f265886b), Long.valueOf(this.f265887c), Long.valueOf(this.f265888d), this.f265890f);
    }

    @NonNull
    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        List<h> list = this.f265892h;
        String str5 = "";
        if (list == null || list.size() <= 0) {
            str = "";
        } else {
            Iterator<h> it = this.f265892h.iterator();
            str = "";
            while (it.hasNext()) {
                str = str + it.next().toString();
            }
        }
        List<h> list2 = this.f265893i;
        if (list2 == null || list2.size() <= 0) {
            str2 = "";
        } else {
            Iterator<h> it5 = this.f265893i.iterator();
            str2 = "";
            while (it5.hasNext()) {
                str2 = str2 + it5.next().toString();
            }
        }
        List<h> list3 = this.f265894j;
        if (list3 == null || list3.size() <= 0) {
            str3 = "";
        } else {
            Iterator<h> it6 = this.f265894j.iterator();
            str3 = "";
            while (it6.hasNext()) {
                str3 = str3 + it6.next().toString();
            }
        }
        List<a> list4 = this.f265895k;
        if (list4 != null && list4.size() > 0) {
            Iterator<a> it7 = this.f265895k.iterator();
            while (it7.hasNext()) {
                str5 = str5 + it7.next().toString();
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("noticeId:");
        sb5.append(this.f265885a);
        sb5.append(" templateId:");
        sb5.append(this.f265886b);
        sb5.append(" createTs:");
        sb5.append(this.f265888d);
        sb5.append(" expireTs:");
        sb5.append(this.f265887c);
        sb5.append(" handleTs:");
        sb5.append(this.f265889e);
        sb5.append(" guildId:");
        sb5.append(this.f265890f);
        sb5.append(" cover:");
        b bVar = this.f265891g;
        if (bVar != null) {
            str4 = bVar.toString();
        } else {
            str4 = "null";
        }
        sb5.append(str4);
        sb5.append(" strTitle:");
        sb5.append(str);
        sb5.append(" strSubTitle:");
        sb5.append(str2);
        sb5.append(" strCommentTitle:");
        sb5.append(str3);
        sb5.append(" strAction:");
        sb5.append(str5);
        sb5.append(" joinSign:");
        sb5.append(this.f265896l);
        sb5.append(" msgType:");
        sb5.append(this.f265897m);
        sb5.append("jumpLink:");
        sb5.append(this.f265898n);
        sb5.append(" noticeType:");
        sb5.append(this.f265899o);
        sb5.append("handlerUin");
        sb5.append(this.f265900p);
        sb5.append("handleResult");
        sb5.append(this.f265901q);
        sb5.append("handlerTinyId");
        sb5.append(this.f265902r);
        sb5.append("handlerNickName");
        sb5.append(this.f265903s);
        return sb5.toString();
    }
}
