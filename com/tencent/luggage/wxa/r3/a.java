package com.tencent.luggage.wxa.r3;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.luggage.wxa.ka.f;
import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.n3.ai;
import com.tencent.luggage.wxa.n3.aj;
import com.tencent.luggage.wxa.n3.l;
import com.tencent.luggage.wxa.n3.o;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.n3.y;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f139058a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6660a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<C6660a> CREATOR = new C6661a();

        /* renamed from: a, reason: collision with root package name */
        public final int f139059a;

        /* renamed from: b, reason: collision with root package name */
        public final int f139060b;

        /* renamed from: c, reason: collision with root package name */
        public final String f139061c;

        /* renamed from: d, reason: collision with root package name */
        public final String f139062d;

        /* renamed from: e, reason: collision with root package name */
        public final String f139063e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f139064f;

        /* renamed from: g, reason: collision with root package name */
        public final int f139065g;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6661a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C6660a createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new C6660a(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C6660a[] newArray(int i3) {
                return new C6660a[i3];
            }
        }

        public C6660a(int i3, int i16, String str, String str2, String str3, boolean z16, int i17) {
            this.f139059a = i3;
            this.f139060b = i16;
            this.f139061c = str;
            this.f139062d = str2;
            this.f139063e = str3;
            this.f139064f = z16;
            this.f139065g = i17;
        }

        public final int a() {
            return this.f139059a;
        }

        public final String b() {
            return this.f139061c;
        }

        public final String c() {
            return this.f139062d;
        }

        public final int d() {
            return this.f139060b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final int e() {
            return this.f139065g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C6660a)) {
                return false;
            }
            C6660a c6660a = (C6660a) obj;
            if (this.f139059a == c6660a.f139059a && this.f139060b == c6660a.f139060b && Intrinsics.areEqual(this.f139061c, c6660a.f139061c) && Intrinsics.areEqual(this.f139062d, c6660a.f139062d) && Intrinsics.areEqual(this.f139063e, c6660a.f139063e) && this.f139064f == c6660a.f139064f && this.f139065g == c6660a.f139065g) {
                return true;
            }
            return false;
        }

        public final String f() {
            return this.f139063e;
        }

        public final boolean g() {
            return this.f139064f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i3 = ((this.f139059a * 31) + this.f139060b) * 31;
            String str = this.f139061c;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.f139062d;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            String str3 = this.f139063e;
            if (str3 != null) {
                i16 = str3.hashCode();
            }
            int i19 = (i18 + i16) * 31;
            boolean z16 = this.f139064f;
            int i26 = z16;
            if (z16 != 0) {
                i26 = 1;
            }
            return ((i19 + i26) * 31) + this.f139065g;
        }

        public String toString() {
            return "CdnUploadRequest(appType=" + this.f139059a + ", fileType=" + this.f139060b + ", fileKey=" + this.f139061c + ", filePath=" + this.f139062d + ", thumbFilePath=" + this.f139063e + ", isStorageMode=" + this.f139064f + ", snsUploadVersion=" + this.f139065g + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.f139059a);
            out.writeInt(this.f139060b);
            out.writeString(this.f139061c);
            out.writeString(this.f139062d);
            out.writeString(this.f139063e);
            out.writeInt(this.f139064f ? 1 : 0);
            out.writeInt(this.f139065g);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        public static final c f139069a = new c();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r3.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6663a implements t.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f139070a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.s3.c f139071b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1 f139072c;

            public C6663a(int i3, com.tencent.luggage.wxa.s3.c cVar, Function1 function1) {
                this.f139070a = i3;
                this.f139071b = cVar;
                this.f139072c = function1;
            }

            @Override // com.tencent.luggage.wxa.n3.t.a
            public /* synthetic */ void a(int i3, int i16, com.tencent.luggage.wxa.n3.a aVar) {
                ai.a(this, i3, i16, aVar);
            }

            @Override // com.tencent.luggage.wxa.n3.t.a
            public /* synthetic */ void onLoginComplete(int i3) {
                ai.g(this, i3);
            }

            @Override // com.tencent.luggage.wxa.n3.t.a
            public /* synthetic */ void onLogoutComplete(int i3) {
                ai.h(this, i3);
            }

            @Override // com.tencent.luggage.wxa.n3.u.a
            public /* synthetic */ void a(int i3, int i16, byte[] bArr) {
                aj.a(this, i3, i16, bArr);
            }

            @Override // com.tencent.luggage.wxa.n3.t.a
            public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.c cVar) {
                ai.b(this, i3, cVar);
            }

            @Override // com.tencent.luggage.wxa.n3.t.a
            public /* synthetic */ void a(int i3, l lVar) {
                ai.d(this, i3, lVar);
            }

            @Override // com.tencent.luggage.wxa.n3.t.a
            public /* synthetic */ void a(int i3, o oVar) {
                ai.e(this, i3, oVar);
            }

            @Override // com.tencent.luggage.wxa.n3.t.a
            public /* synthetic */ void a(y yVar) {
                ai.f(this, yVar);
            }

            @Override // com.tencent.luggage.wxa.n3.u.a
            public /* synthetic */ void a(byte[] bArr) {
                aj.b(this, bArr);
            }

            @Override // com.tencent.luggage.wxa.n3.t.a
            public void a(int i3, com.tencent.luggage.wxa.n3.d dVar) {
                b bVar;
                if (i3 == this.f139070a) {
                    this.f139071b.b(this);
                }
                if (dVar == null) {
                    bVar = new b(10003, null, null, 6, null);
                } else {
                    bVar = new b(dVar.a(), dVar.b(), dVar.d());
                }
                this.f139072c.invoke(bVar);
            }
        }

        @Override // com.tencent.luggage.wxa.r3.a.d
        public void a(C6660a request, Function1 onCdnUploadCompleted) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(onCdnUploadCompleted, "onCdnUploadCompleted");
            com.tencent.luggage.wxa.s3.c cVar = (com.tencent.luggage.wxa.s3.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.s3.c.class);
            if (cVar == null) {
                onCdnUploadCompleted.invoke(new b(10001, null, null, 6, null));
                return;
            }
            t k3 = cVar.k();
            if (k3 == null) {
                onCdnUploadCompleted.invoke(new b(10002, null, null, 6, null));
            } else {
                cVar.a(new C6663a(k3.a(request.a(), request.d(), request.b(), request.c(), request.f(), request.g(), request.e()), cVar, onCdnUploadCompleted));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a(C6660a c6660a, Function1 function1);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        public static final e f139073a = new e();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/r3/a$a;", "kotlin.jvm.PlatformType", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/r3/a$b;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/r3/a$a;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
        /* renamed from: com.tencent.luggage.wxa.r3.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6664a<InputType, ResultType> implements f {

            /* renamed from: a, reason: collision with root package name */
            public static final C6664a f139074a = new C6664a();

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.r3.a$e$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6665a extends Lambda implements Function1 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ i f139075a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6665a(i iVar) {
                    super(1);
                    this.f139075a = iVar;
                }

                public final void a(b it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    i iVar = this.f139075a;
                    if (iVar != null) {
                        iVar.a(it);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((b) obj);
                    return Unit.INSTANCE;
                }
            }

            @Override // com.tencent.luggage.wxa.ka.f
            public final void a(C6660a request, i iVar) {
                c cVar = c.f139069a;
                Intrinsics.checkNotNullExpressionValue(request, "request");
                cVar.a(request, new C6665a(iVar));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1 f139076a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Function1 function1) {
                super(1);
                this.f139076a = function1;
            }

            public final void a(b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.f139076a.invoke(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((b) obj);
                return Unit.INSTANCE;
            }
        }

        @Override // com.tencent.luggage.wxa.r3.a.d
        public void a(C6660a request, Function1 onCdnUploadCompleted) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(onCdnUploadCompleted, "onCdnUploadCompleted");
            String g16 = z.g();
            Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
            com.tencent.luggage.wxa.ka.b.a(g16, request, C6664a.f139074a, new b(onCdnUploadCompleted));
        }
    }

    public final void a(C6660a request, Function1 onCdnUploadCompleted) {
        d dVar;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(onCdnUploadCompleted, "onCdnUploadCompleted");
        if (com.tencent.luggage.wxa.o3.l.f136139a.d()) {
            dVar = e.f139073a;
        } else {
            dVar = c.f139069a;
        }
        dVar.a(request, onCdnUploadCompleted);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<b> CREATOR = new C6662a();

        /* renamed from: a, reason: collision with root package name */
        public final int f139066a;

        /* renamed from: b, reason: collision with root package name */
        public final String f139067b;

        /* renamed from: c, reason: collision with root package name */
        public final String f139068c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r3.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6662a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new b(parcel.readInt(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(int i3, String str, String str2) {
            this.f139066a = i3;
            this.f139067b = str;
            this.f139068c = str2;
        }

        public final int a() {
            return this.f139066a;
        }

        public final String b() {
            return this.f139067b;
        }

        public final String c() {
            return this.f139068c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f139066a == bVar.f139066a && Intrinsics.areEqual(this.f139067b, bVar.f139067b) && Intrinsics.areEqual(this.f139068c, bVar.f139068c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.f139066a * 31;
            String str = this.f139067b;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.f139068c;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return i17 + i16;
        }

        public String toString() {
            return "CdnUploadResult(errCode=" + this.f139066a + ", fileUrl=" + this.f139067b + ", thumbUrl=" + this.f139068c + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.f139066a);
            out.writeString(this.f139067b);
            out.writeString(this.f139068c);
        }

        public /* synthetic */ b(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2);
        }
    }
}
