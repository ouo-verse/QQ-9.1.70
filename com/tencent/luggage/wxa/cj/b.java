package com.tencent.luggage.wxa.cj;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f123565a;

    /* renamed from: b, reason: collision with root package name */
    public final c f123566b;

    /* renamed from: c, reason: collision with root package name */
    public static final C6115b f123563c = new C6115b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final b f123564d = new b(false, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new b(source);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.cj.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6115b {
        public C6115b() {
        }

        public /* synthetic */ C6115b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum c {
        Offline(0),
        Guest(1);


        /* renamed from: b, reason: collision with root package name */
        public static final a f123567b = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final int f123571a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final c a(int i3) {
                c cVar;
                boolean z16;
                c[] values = c.values();
                int length = values.length;
                int i16 = 0;
                while (true) {
                    if (i16 < length) {
                        cVar = values[i16];
                        if (cVar.b() == i3) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i16++;
                    } else {
                        cVar = null;
                        break;
                    }
                }
                if (cVar == null) {
                    return c.Guest;
                }
                return cVar;
            }
        }

        c(int i3) {
            this.f123571a = i3;
        }

        public final int b() {
            return this.f123571a;
        }
    }

    public b(boolean z16, c reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.f123565a = z16;
        this.f123566b = reason;
    }

    public final boolean a() {
        return this.f123565a;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, this.f123565a);
        jSONObject.put("reason", this.f123566b.b());
        return jSONObject;
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
        if (this.f123565a == bVar.f123565a && this.f123566b == bVar.f123566b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.f123565a;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.f123566b.hashCode();
    }

    public String toString() {
        return "WxAppLibServerMode(switch:" + this.f123565a + ", reason:" + this.f123566b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeByte(this.f123565a ? (byte) 1 : (byte) 0);
        dest.writeInt(this.f123566b.b());
    }

    public /* synthetic */ b(boolean z16, c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? c.Offline : cVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Parcel parcel) {
        this(parcel.readByte() > 0, c.f123567b.a(parcel.readInt()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
