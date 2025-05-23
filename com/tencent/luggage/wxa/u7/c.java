package com.tencent.luggage.wxa.u7;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.i3.o;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements x.a, x.b {

    /* renamed from: a, reason: collision with root package name */
    public static final c f142142a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f142143b = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6788a();

        /* renamed from: a, reason: collision with root package name */
        public final long f142144a;

        /* renamed from: b, reason: collision with root package name */
        public final int f142145b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.u7.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6788a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new a(parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(long j3, int i3) {
            this.f142144a = j3;
            this.f142145b = i3;
        }

        public final long a() {
            return this.f142144a;
        }

        public final int b() {
            return this.f142145b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f142144a == aVar.f142144a && this.f142145b == aVar.f142145b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.f142144a) * 31) + this.f142145b;
        }

        public String toString() {
            return "CallbackArgs(timestampNs=" + this.f142144a + ", resultOrdinal=" + this.f142145b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeLong(this.f142144a);
            out.writeInt(this.f142145b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "<anonymous parameter 1>", "", "a", "(Landroid/os/Bundle;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.wxa.u7.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6789c<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final C6789c f142151a = new C6789c();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(Bundle bundle, i iVar) {
            long j3 = bundle.getLong("timestamp", 0L);
            String string = bundle.getString("appId", "");
            String string2 = bundle.getString("username", "");
            if (j3 > 0) {
                com.tencent.luggage.wxa.u7.b.f142127a.a(j3, string, string2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/u7/c$a;", "data", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "a", "(Lcom/tencent/luggage/wxa/u7/c$a;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class d<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final d f142152a = new d();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(a aVar, i iVar) {
            if (aVar != null) {
                com.tencent.luggage.wxa.u7.b.f142127a.a(aVar.a(), LaunchWxaAppResult.values()[aVar.b()]);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/u7/c$b;", "data", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "a", "(Lcom/tencent/luggage/wxa/u7/c$b;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class e<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final e f142153a = new e();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(b bVar, i iVar) {
            if (bVar != null) {
                com.tencent.luggage.wxa.u7.b.f142127a.a(bVar.d(), bVar.b(), bVar.a(), bVar.c());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/u7/a;", "kotlin.jvm.PlatformType", "metrics", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "<anonymous parameter 1>", "", "a", "(Lcom/tencent/luggage/wxa/u7/a;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class f<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final f f142154a = new f();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.u7.a aVar, i iVar) {
            if (aVar != null) {
                com.tencent.luggage.wxa.u7.b.f142127a.a(aVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/va/c;", "kotlin.jvm.PlatformType", "pTimestampNs", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "<anonymous parameter 1>", "", "a", "(Lcom/tencent/luggage/wxa/va/c;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class g<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final g f142155a = new g();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.va.c cVar, i iVar) {
            if (cVar != null) {
                com.tencent.luggage.wxa.u7.b.f142127a.d(cVar.f143314a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/va/c;", "kotlin.jvm.PlatformType", "pTimestampNs", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "<anonymous parameter 1>", "", "a", "(Lcom/tencent/luggage/wxa/va/c;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class h<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final h f142156a = new h();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.va.c cVar, i iVar) {
            if (cVar != null) {
                com.tencent.luggage.wxa.u7.b.f142127a.b(cVar.f143314a);
            }
        }
    }

    public final void a() {
        x.f129431a.a(this);
    }

    @Override // com.tencent.luggage.wxa.i3.x.a
    public void a(String instanceId, x.e eventGroup, x.d event, String str) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        Intrinsics.checkNotNullParameter(event, "event");
        w.d("Luggage.WxaAppLaunchTraceEventDispatcher", "onEvent instanceId[" + instanceId + "] group[" + eventGroup + "] event[" + event + "] message[" + str + ']');
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        Long l3 = (Long) f142143b.get(instanceId);
        if (l3 == null) {
            l3 = 0L;
        }
        com.tencent.luggage.wxa.ka.b.a(g16, new b(l3.longValue(), instanceId, eventGroup, event, str), e.f142153a, null);
    }

    @Override // com.tencent.luggage.wxa.i3.x.b
    public void a(String instanceId, x.e eventGroup, x.d event, Object obj) {
        LaunchWxaAppResult launchWxaAppResult;
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        Intrinsics.checkNotNullParameter(event, "event");
        if ((obj instanceof com.tencent.luggage.wxa.bj.a) && (((com.tencent.luggage.wxa.bj.a) obj).f122899b == -10002 || x.e.GET_ATTRS == eventGroup)) {
            Long l3 = (Long) f142143b.get(instanceId);
            a((l3 != null ? l3 : 0L).longValue(), LaunchWxaAppResult.FailUpdateContact);
            return;
        }
        if (obj instanceof o) {
            int a16 = ((o) obj).a();
            if (a16 == 1) {
                launchWxaAppResult = LaunchWxaAppResult.FailPubLibNotSupport;
            } else if (a16 == 2) {
                launchWxaAppResult = LaunchWxaAppResult.FailForbidRunIn3rdApp;
            } else if (a16 == 3) {
                launchWxaAppResult = LaunchWxaAppResult.FailWxaAppOffline;
            } else if (a16 != 4) {
                launchWxaAppResult = LaunchWxaAppResult.Fail;
            } else {
                launchWxaAppResult = LaunchWxaAppResult.FailWxaAppForbidden;
            }
            Long l16 = (Long) f142143b.get(instanceId);
            a((l16 != null ? l16 : 0L).longValue(), launchWxaAppResult);
            return;
        }
        a(instanceId, eventGroup, event, obj != null ? obj.toString() : null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {

        @NotNull
        public static final a CREATOR = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final long f142146a;

        /* renamed from: b, reason: collision with root package name */
        public final String f142147b;

        /* renamed from: c, reason: collision with root package name */
        public final x.e f142148c;

        /* renamed from: d, reason: collision with root package name */
        public final x.d f142149d;

        /* renamed from: e, reason: collision with root package name */
        public final String f142150e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Parcelable.Creator {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

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

        public b(long j3, String instanceId, x.e eventGroup, x.d event, String str) {
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
            Intrinsics.checkNotNullParameter(event, "event");
            this.f142146a = j3;
            this.f142147b = instanceId;
            this.f142148c = eventGroup;
            this.f142149d = event;
            this.f142150e = str;
        }

        public final x.d a() {
            return this.f142149d;
        }

        public final x.e b() {
            return this.f142148c;
        }

        public final String c() {
            return this.f142150e;
        }

        public final long d() {
            return this.f142146a;
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
            if (this.f142146a == bVar.f142146a && Intrinsics.areEqual(this.f142147b, bVar.f142147b) && this.f142148c == bVar.f142148c && this.f142149d == bVar.f142149d && Intrinsics.areEqual(this.f142150e, bVar.f142150e)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int a16 = ((((((androidx.fragment.app.a.a(this.f142146a) * 31) + this.f142147b.hashCode()) * 31) + this.f142148c.hashCode()) * 31) + this.f142149d.hashCode()) * 31;
            String str = this.f142150e;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return a16 + hashCode;
        }

        public String toString() {
            return "TraceEvent(timestampNs=" + this.f142146a + ", instanceId=" + this.f142147b + ", eventGroup=" + this.f142148c + ", event=" + this.f142149d + ", message=" + this.f142150e + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeLong(this.f142146a);
            dest.writeString(this.f142147b);
            dest.writeInt(this.f142148c.ordinal());
            dest.writeInt(this.f142149d.ordinal());
            dest.writeString(this.f142150e);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(Parcel parcel) {
            this(r2, r4, r5, r6, parcel.readString());
            x.e eVar;
            x.d dVar;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String str = readString == null ? "" : readString;
            int readInt = parcel.readInt();
            x.e[] values = x.e.values();
            int length = values.length;
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 < length) {
                    x.e eVar2 = values[i16];
                    if (eVar2.ordinal() == readInt) {
                        eVar = eVar2;
                        break;
                    }
                    i16++;
                } else {
                    eVar = x.e.NONE;
                    break;
                }
            }
            int readInt2 = parcel.readInt();
            x.d[] values2 = x.d.values();
            int length2 = values2.length;
            while (true) {
                if (i3 < length2) {
                    x.d dVar2 = values2[i3];
                    if (dVar2.ordinal() == readInt2) {
                        dVar = dVar2;
                        break;
                    }
                    i3++;
                } else {
                    dVar = x.d.NONE;
                    break;
                }
            }
        }
    }

    public final void a(String instanceId, long j3, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        w.d("Luggage.WxaAppLaunchTraceEventDispatcher", "onInstanceColdLaunchInitReady instanceId:" + instanceId + " timestampNs:" + j3);
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.ka.b.a(g16, new com.tencent.luggage.wxa.u7.a(j3, z16, z17), f.f142154a, null, 8, null);
    }

    public final void a(String instanceId, long j3, String str, String str2) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        w.d("Luggage.WxaAppLaunchTraceEventDispatcher", "onInstanceWarmStartCompleted instanceId:" + instanceId + " timestampNs:" + j3 + " appId:" + str + " username:" + str2);
        a(j3, str, str2);
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.ka.b.a(g16, new com.tencent.luggage.wxa.va.c(j3), g.f142155a, null, 8, null);
    }

    public final void a(String instanceId, long j3) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        w.d("Luggage.WxaAppLaunchTraceEventDispatcher", "onMiniGameUnsupported instanceId:" + instanceId + " timestampNs:" + j3);
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.ka.b.a(g16, new com.tencent.luggage.wxa.va.c(j3), h.f142156a, null, 8, null);
    }

    @Override // com.tencent.luggage.wxa.i3.x.a
    public void a(String instanceId, com.tencent.luggage.wxa.ki.a params) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(params, "params");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onNewInstanceStart instanceId[");
        sb5.append(instanceId);
        sb5.append("] appId[");
        sb5.append(params.f132018b);
        sb5.append("] versionType[");
        sb5.append(params.f132022d);
        sb5.append("] scene[");
        com.tencent.luggage.wxa.bk.e eVar = params.f132032i;
        sb5.append(eVar != null ? eVar.f122984c : 0);
        sb5.append(']');
        w.d("Luggage.WxaAppLaunchTraceEventDispatcher", sb5.toString());
        f142143b.put(instanceId, Long.valueOf(params.f132040m));
        a(params.f132040m, params.f132018b, params.f132016a);
    }

    public final void a(long j3, String str, String str2) {
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        Bundle bundle = new Bundle();
        bundle.putLong("timestamp", j3);
        bundle.putString("appId", str);
        bundle.putString("username", str2);
        com.tencent.luggage.wxa.ka.b.a(g16, bundle, C6789c.f142151a, null, 8, null);
    }

    public final void a(long j3, LaunchWxaAppResult launchWxaAppResult) {
        String g16 = z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.ka.b.a(g16, new a(j3, launchWxaAppResult.ordinal()), d.f142152a, null, 8, null);
    }
}
