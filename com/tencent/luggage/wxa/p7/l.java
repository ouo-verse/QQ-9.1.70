package com.tencent.luggage.wxa.p7;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hn.e1;
import com.tencent.luggage.wxa.hn.f1;
import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements com.tencent.luggage.wxa.sc.b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f137406b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final l f137407c = new l();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.tencent.luggage.wxa.sc.b f137408a = (com.tencent.luggage.wxa.sc.b) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.sc.b.class);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p7.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6591a extends com.tencent.luggage.wxa.n3.e {
            @Override // com.tencent.luggage.wxa.n3.e
            public String a() {
                return "/cgi-bin/mmbiz-bin/wxabusiness/checkuserstarrecord";
            }

            public final com.tencent.luggage.wxa.xo.d a(String appId, int i3) {
                Intrinsics.checkNotNullParameter(appId, "appId");
                e1 e1Var = new e1();
                e1Var.f127535e = appId;
                e1Var.f127536f = i3;
                Unit unit = Unit.INSTANCE;
                return a("", e1Var, f1.class);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/wxa/p7/l$a$b;", "Lcom/tencent/luggage/wxa/ka/r;", "Lcom/tencent/luggage/wxa/p7/l$a$b$a;", "Lcom/tencent/luggage/wxa/va/e;", "data", "a", "<init>", "()V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes8.dex */
        public static final class b implements r {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.p7.l$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6592a implements Parcelable {

                @NotNull
                public static final Parcelable.Creator<C6592a> CREATOR = new C6593a();

                /* renamed from: a, reason: collision with root package name */
                public final String f137409a;

                /* renamed from: b, reason: collision with root package name */
                public final String f137410b;

                /* renamed from: c, reason: collision with root package name */
                public final int f137411c;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.p7.l$a$b$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6593a implements Parcelable.Creator {
                    @Override // android.os.Parcelable.Creator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final C6592a createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        return new C6592a(parcel.readString(), parcel.readString(), parcel.readInt());
                    }

                    @Override // android.os.Parcelable.Creator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final C6592a[] newArray(int i3) {
                        return new C6592a[i3];
                    }
                }

                public C6592a(String appId, String userName, int i3) {
                    Intrinsics.checkNotNullParameter(appId, "appId");
                    Intrinsics.checkNotNullParameter(userName, "userName");
                    this.f137409a = appId;
                    this.f137410b = userName;
                    this.f137411c = i3;
                }

                public final String a() {
                    return this.f137409a;
                }

                public final String b() {
                    return this.f137410b;
                }

                public final int c() {
                    return this.f137411c;
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C6592a)) {
                        return false;
                    }
                    C6592a c6592a = (C6592a) obj;
                    if (Intrinsics.areEqual(this.f137409a, c6592a.f137409a) && Intrinsics.areEqual(this.f137410b, c6592a.f137410b) && this.f137411c == c6592a.f137411c) {
                        return true;
                    }
                    return false;
                }

                public int hashCode() {
                    return (((this.f137409a.hashCode() * 31) + this.f137410b.hashCode()) * 31) + this.f137411c;
                }

                public String toString() {
                    return "Parameter(appId=" + this.f137409a + ", userName=" + this.f137410b + ", versionType=" + this.f137411c + ')';
                }

                @Override // android.os.Parcelable
                public void writeToParcel(Parcel out, int i3) {
                    Intrinsics.checkNotNullParameter(out, "out");
                    out.writeString(this.f137409a);
                    out.writeString(this.f137410b);
                    out.writeInt(this.f137411c);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.p7.l$a$b$b, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6594b implements e.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ C6592a f137412a;

                public C6594b(C6592a c6592a) {
                    this.f137412a = c6592a;
                }

                @Override // com.tencent.luggage.wxa.xo.e.c
                public final void a(f1 f1Var) {
                    if (f1Var == null) {
                        return;
                    }
                    if (f1Var.f128743d.f127731d != 0) {
                        w.d("MicroMsg.WxaCollectionStorage", "[syncCollectionStatusToLocal] CGI FAIL");
                        return;
                    }
                    w.d("MicroMsg.WxaCollectionStorage", "[syncCollectionStatusToLocal] RESULT: appId=" + this.f137412a.a() + " status=" + f1Var.f127592e + "  count=" + f1Var.f127593f);
                    k kVar = k.f137393c;
                    kVar.l().invoke(Integer.valueOf(f1Var.f127593f));
                    if (f1Var.f127592e == 1) {
                        kVar.d().invoke(this.f137412a.b(), Integer.valueOf(this.f137412a.c()));
                    } else {
                        kVar.h().invoke(this.f137412a.b(), Integer.valueOf(this.f137412a.c()));
                    }
                }
            }

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class c implements e.a {

                /* renamed from: a, reason: collision with root package name */
                public static final c f137413a = new c();

                @Override // com.tencent.luggage.wxa.xo.e.a
                public final void a(Object obj) {
                    w.d("MicroMsg.WxaCollectionStorage", "[syncCollectionStatusToLocal] onInterrupt: error =" + obj);
                }
            }

            @Override // com.tencent.luggage.wxa.ka.r
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.tencent.luggage.wxa.va.e invoke(C6592a data) {
                if (data == null) {
                    com.tencent.luggage.wxa.va.e VOID = com.tencent.luggage.wxa.va.e.f143316a;
                    Intrinsics.checkNotNullExpressionValue(VOID, "VOID");
                    return VOID;
                }
                new C6591a().a(data.a(), data.c()).a(new C6594b(data)).a(c.f137413a);
                com.tencent.luggage.wxa.va.e VOID2 = com.tencent.luggage.wxa.va.e.f143316a;
                Intrinsics.checkNotNullExpressionValue(VOID2, "VOID");
                return VOID2;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l a() {
            return l.f137407c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f137414a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f137415b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f137416c;

        public b(String str, String str2, int i3) {
            this.f137414a = str;
            this.f137415b = str2;
            this.f137416c = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o.a(z.g(), new a.b.C6592a(this.f137414a, this.f137415b, this.f137416c), a.b.class);
            } catch (Exception e16) {
                w.a("MicroMsg.WxaCollectionStorage", e16, "caught crash", new Object[0]);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.sc.b
    public int C() {
        return this.f137408a.C();
    }

    @Override // com.tencent.luggage.wxa.sc.b
    public boolean a(String str, int i3) {
        return this.f137408a.a(str, i3);
    }

    @Override // com.tencent.luggage.wxa.sc.b
    public int b(String str, int i3) {
        return this.f137408a.b(str, i3);
    }

    @Override // com.tencent.luggage.wxa.sc.b
    public boolean d(String str, int i3) {
        return this.f137408a.d(str, i3);
    }

    public final void a(String appId, String userName, int i3) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        com.tencent.luggage.wxa.zp.h.f146825d.d(new b(appId, userName, i3));
    }
}
