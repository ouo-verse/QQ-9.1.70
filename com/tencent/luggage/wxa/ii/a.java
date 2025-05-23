package com.tencent.luggage.wxa.ii;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.a5.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f130416b;

    /* renamed from: c, reason: collision with root package name */
    public final String f130417c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.lg.b f130418d;

    /* renamed from: e, reason: collision with root package name */
    public final String f130419e;

    /* renamed from: f, reason: collision with root package name */
    public final int f130420f;

    /* renamed from: g, reason: collision with root package name */
    public final String f130421g;

    /* renamed from: h, reason: collision with root package name */
    public static final C6306a f130415h = new C6306a(null);

    @NotNull
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ii.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6306a {
        public C6306a() {
        }

        public /* synthetic */ C6306a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        public final boolean a(String instanceId, com.tencent.luggage.wxa.lg.b state, String pluginAppId, int i3, String str) {
            String str2;
            int i16;
            Object obj;
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(pluginAppId, "pluginAppId");
            com.tencent.luggage.wxa.p5.f a16 = com.tencent.luggage.wxa.p6.h.f137365a.a(instanceId);
            if (a16 != null) {
                String appId = a16.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId, "runtime.appId");
                new a(appId, instanceId, state, pluginAppId, i3, str).a(a16);
                return true;
            }
            if (com.tencent.luggage.wxa.tn.z.m()) {
                try {
                    com.tencent.luggage.wxa.z4.f a17 = com.tencent.luggage.wxa.z4.f.f146283b.a();
                    try {
                        Iterator it = a17.e().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                try {
                                    obj = it.next();
                                    if (Intrinsics.areEqual(instanceId, ((com.tencent.luggage.wxa.z4.g) obj).d())) {
                                        break;
                                    }
                                } catch (com.tencent.luggage.wxa.z4.l e16) {
                                    e = e16;
                                    i16 = 0;
                                    str2 = "MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage";
                                    com.tencent.luggage.wxa.tn.w.a(str2, e, "caught exception", new Object[i16]);
                                    return i16;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        com.tencent.luggage.wxa.z4.g gVar = (com.tencent.luggage.wxa.z4.g) obj;
                        if (gVar != null) {
                            try {
                                com.tencent.luggage.wxa.z4.e.a(a17.a(gVar), new a(gVar.a(), instanceId, state, pluginAppId, i3, str), (Function0) null, 2, (Object) null);
                                str2 = "MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage";
                            } catch (com.tencent.luggage.wxa.z4.l e17) {
                                e = e17;
                                str2 = "MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage";
                            }
                            try {
                                com.tencent.luggage.wxa.tn.w.d(str2, "dispatch onPluginUpdateStatusChange(state:" + state + ", pluginAppId:" + pluginAppId + "), instanceId:" + instanceId + ", by ProcessesManager");
                                return true;
                            } catch (com.tencent.luggage.wxa.z4.l e18) {
                                e = e18;
                                i16 = 0;
                                com.tencent.luggage.wxa.tn.w.a(str2, e, "caught exception", new Object[i16]);
                                return i16;
                            }
                        }
                    } catch (com.tencent.luggage.wxa.z4.l e19) {
                        e = e19;
                        str2 = "MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage";
                        i16 = 0;
                    }
                } catch (Exception e26) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage", "dispatch onPluginUpdateStatusChange(state:" + state + ", pluginAppId:" + pluginAppId + "), instanceId:" + instanceId + ", get exception:" + e26);
                    return false;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new a(parcel.readString(), parcel.readString(), x.f130597a.create(parcel), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a[] newArray(int i3) {
            return new a[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f130422a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f130423b;

        public c(com.tencent.luggage.wxa.c5.e eVar, a aVar) {
            this.f130422a = eVar;
            this.f130423b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.lg.a.a(this.f130422a.h0(), this.f130423b.f(), this.f130423b.c(), this.f130423b.d(), this.f130423b.e());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String appId, String instanceId, com.tencent.luggage.wxa.lg.b state, String pluginAppId, int i3, String str) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pluginAppId, "pluginAppId");
        this.f130416b = appId;
        this.f130417c = instanceId;
        this.f130418d = state;
        this.f130419e = pluginAppId;
        this.f130420f = i3;
        this.f130421g = str;
    }

    @Override // com.tencent.luggage.wxa.a5.b
    public void a(com.tencent.luggage.wxa.c5.e runtime) {
        String str;
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        String str2 = this.f130417c;
        com.tencent.luggage.wxa.j4.d S = runtime.S();
        String str3 = null;
        if (S != null) {
            str = S.k();
        } else {
            str = null;
        }
        boolean equals = StringUtils.equals(str2, str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("runInLuggageProcess, appId:");
        sb5.append(runtime.getAppId());
        sb5.append(", this.instanceId:");
        sb5.append(this.f130417c);
        sb5.append(", runtime.instanceId:");
        com.tencent.luggage.wxa.j4.d S2 = runtime.S();
        if (S2 != null) {
            str3 = S2.k();
        }
        sb5.append(str3);
        sb5.append(", proceed:");
        sb5.append(equals);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPluginUpdateStatusChangeIPCMessage", sb5.toString());
        if (equals) {
            runtime.c(new c(runtime, this));
        }
    }

    @Override // com.tencent.luggage.wxa.a5.b
    public String b() {
        return this.f130416b;
    }

    public final String c() {
        return this.f130419e;
    }

    public final int d() {
        return this.f130420f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f130421g;
    }

    public final com.tencent.luggage.wxa.lg.b f() {
        return this.f130418d;
    }

    public String toString() {
        return "AppBrandPluginUpdateStatusChangeIPCMessage(appId='" + b() + "', instanceId='" + this.f130417c + "', state=" + this.f130418d + ", pluginAppId='" + this.f130419e + "', pluginIntVersion=" + this.f130420f + ", pluginStringVersion=" + this.f130421g + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f130416b);
        out.writeString(this.f130417c);
        x.f130597a.write(this.f130418d, out, i3);
        out.writeString(this.f130419e);
        out.writeInt(this.f130420f);
        out.writeString(this.f130421g);
    }
}
