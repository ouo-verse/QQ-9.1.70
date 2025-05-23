package com.tencent.luggage.wxa.l3;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.z4.j implements Parcelable {
    public static final b C = new b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.d6.b f133002e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.j4.d f133003f;

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.bk.e f133004g;

    /* renamed from: h, reason: collision with root package name */
    public final n f133005h;

    /* renamed from: i, reason: collision with root package name */
    public final String f133006i;

    /* renamed from: j, reason: collision with root package name */
    public final String f133007j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f133008k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f133009l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f133010m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i3) {
            return new j[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(String appId) {
            n0.b f16;
            Intrinsics.checkNotNullParameter(appId, "appId");
            try {
                n0 a16 = o0.a().a(appId, "appInfo");
                if (a16 == null || (f16 = a16.f()) == null) {
                    return false;
                }
                if (!f16.a()) {
                    return false;
                }
                return true;
            } catch (IllegalStateException e16) {
                w.a("Luggage.LaunchLogic", e16, "checkIsGame(" + appId + ')', new Object[0]);
                return false;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ j(com.tencent.luggage.wxa.d6.b bVar, com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar, n nVar, String str, String str2, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, dVar, r5, r6, r7, r8, (i3 & 64) != 0 ? false : z16, (i3 & 128) != 0 ? false : z17);
        n nVar2;
        String str3;
        String str4;
        com.tencent.luggage.wxa.bk.e i16 = (i3 & 4) != 0 ? dVar.i() : eVar;
        if ((i3 & 8) != 0) {
            n nVar3 = dVar.N;
            Intrinsics.checkNotNullExpressionValue(nVar3, "cfg.referrer");
            nVar2 = nVar3;
        } else {
            nVar2 = nVar;
        }
        if ((i3 & 16) != 0) {
            String str5 = bVar.f124086d;
            Intrinsics.checkNotNullExpressionValue(str5, "action.appId");
            str3 = str5;
        } else {
            str3 = str;
        }
        if ((i3 & 32) != 0) {
            String k3 = dVar.k();
            Intrinsics.checkNotNullExpressionValue(k3, "cfg.wxaLaunchInstanceId");
            str4 = k3;
        } else {
            str4 = str2;
        }
    }

    @Override // com.tencent.luggage.wxa.z4.j
    public String a() {
        return this.f133006i;
    }

    @Override // com.tencent.luggage.wxa.z4.j
    public String c() {
        return this.f133007j;
    }

    @Override // com.tencent.luggage.wxa.z4.j
    public int d() {
        return this.f133002e.f124090h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.z4.j
    public final boolean e() {
        return this.f133010m;
    }

    public final com.tencent.luggage.wxa.d6.b f() {
        return this.f133002e;
    }

    @Override // com.tencent.luggage.wxa.z4.j
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.j4.d b() {
        return this.f133003f;
    }

    public final boolean h() {
        return this.f133008k;
    }

    public final n i() {
        return this.f133005h;
    }

    public final com.tencent.luggage.wxa.bk.e j() {
        return this.f133004g;
    }

    public final boolean k() {
        return this.f133009l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByteArray(this.f133002e.b());
        parcel.writeParcelable(b(), i3);
        parcel.writeParcelable(this.f133004g, i3);
        parcel.writeParcelable(this.f133005h, i3);
        parcel.writeByte(this.f133008k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f133009l ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(com.tencent.luggage.wxa.d6.b action, com.tencent.luggage.wxa.j4.d cfg, com.tencent.luggage.wxa.bk.e eVar, n referrer, String appId, String instanceId, boolean z16, boolean z17) {
        super(cfg, r0, cfg.l(), action.f124090h);
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        Intrinsics.checkNotNullParameter(referrer, "referrer");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        String str = action.f124086d;
        Intrinsics.checkNotNullExpressionValue(str, "action.appId");
        this.f133002e = action;
        this.f133003f = cfg;
        this.f133004g = eVar;
        this.f133005h = referrer;
        this.f133006i = appId;
        this.f133007j = instanceId;
        this.f133008k = z16;
        this.f133009l = z17;
        b bVar = C;
        String str2 = action.f124086d;
        Intrinsics.checkNotNullExpressionValue(str2, "action.appId");
        this.f133010m = bVar.a(str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(Parcel parcel) {
        this(r2, r3, r4, (n) r0, null, null, parcel.readByte() > 0, parcel.readByte() > 0, 48, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
        bVar.a(parcel.createByteArray());
        Parcelable readParcelable = parcel.readParcelable(com.tencent.luggage.wxa.j4.d.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable);
        com.tencent.luggage.wxa.j4.d dVar = (com.tencent.luggage.wxa.j4.d) readParcelable;
        com.tencent.luggage.wxa.bk.e eVar = (com.tencent.luggage.wxa.bk.e) parcel.readParcelable(com.tencent.luggage.wxa.bk.e.class.getClassLoader());
        Parcelable readParcelable2 = parcel.readParcelable(n.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable2);
    }
}
