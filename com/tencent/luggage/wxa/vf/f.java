package com.tencent.luggage.wxa.vf;

import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.TagTechnology;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uf.n;
import com.tencent.luggage.wxa.uk.r;
import com.tencent.luggage.wxa.vf.b;
import com.tencent.luggage.wxa.vf.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joor.Reflect;
import org.joor.ReflectException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final b f143434c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    public static final Map f143435d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static b.a f143436e = new c();

    /* renamed from: a, reason: collision with root package name */
    public final String f143437a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.vf.b f143438b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends e.c {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            super.onDestroy();
            w.a("MicroMsg.AppBrand.NFCReadWriteManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            f.f143435d.remove(f.this.f143437a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public interface a {
            f a(String str, r rVar);
        }

        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return f.f143436e;
        }

        public final f a(com.tencent.luggage.wxa.xd.d component) {
            Intrinsics.checkNotNullParameter(component, "component");
            f fVar = (f) f.f143435d.get(component.getAppId());
            if (fVar != null) {
                return fVar;
            }
            r a16 = com.tencent.luggage.wxa.uk.d.a(component);
            a a17 = f.f143434c.a();
            String appId = component.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
            f a18 = a17.a(appId, a16);
            Map map = f.f143435d;
            String appId2 = component.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId2, "component.appId");
            map.put(appId2, a18);
            return a18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements b.a {
        @Override // com.tencent.luggage.wxa.vf.f.b.a
        public f a(String appId, r activityProvider) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
            return new f(appId, new com.tencent.luggage.wxa.vf.e(appId, activityProvider));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143441b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143442c;

        public d(Function1 function1, String str) {
            this.f143441b = function1;
            this.f143442c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TagTechnology tagTechnology;
            Object obj;
            f fVar = f.this;
            Function1 function1 = this.f143441b;
            Tag d16 = fVar.d();
            if (d16 == null) {
                function1.invoke(new g.a(13013, "NFC tag has not been discovered"));
            }
            if (d16 == null) {
                return;
            }
            String str = this.f143442c;
            Function1 function12 = this.f143441b;
            com.tencent.luggage.wxa.wf.b bVar = (com.tencent.luggage.wxa.wf.b) com.tencent.luggage.wxa.wf.b.f144216e.b().get(str);
            if (bVar == null) {
                function12.invoke(new g.a(13014, "invalid tech"));
            }
            if (bVar == null) {
                return;
            }
            if (!f.this.c().contains(bVar)) {
                this.f143441b.invoke(new g.a(13023, "Tech has not connected"));
                return;
            }
            try {
                obj = Reflect.on(bVar.d()).call("get", d16).get();
            } catch (Exception unused) {
                this.f143441b.invoke(new g.a(13015, "unavailable tech"));
                tagTechnology = null;
            }
            if (obj != null) {
                tagTechnology = (TagTechnology) obj;
                if (tagTechnology == null) {
                    return;
                }
                try {
                    tagTechnology.close();
                } catch (Exception e16) {
                    w.d("MicroMsg.AppBrand.NFCReadWriteManager", "close failed since " + e16);
                }
                f.this.c().remove(bVar);
                this.f143441b.invoke(new g.b(Unit.INSTANCE));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143444b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143445c;

        public e(Function1 function1, String str) {
            this.f143444b = function1;
            this.f143445c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TagTechnology tagTechnology;
            Object obj;
            f fVar = f.this;
            Function1 function1 = this.f143444b;
            Tag d16 = fVar.d();
            if (d16 == null) {
                function1.invoke(new g.a(13013, "NFC tag has not been discovered"));
            }
            if (d16 == null) {
                return;
            }
            String str = this.f143445c;
            Function1 function12 = this.f143444b;
            com.tencent.luggage.wxa.wf.b bVar = (com.tencent.luggage.wxa.wf.b) com.tencent.luggage.wxa.wf.b.f144216e.b().get(str);
            if (bVar == null) {
                function12.invoke(new g.a(13014, "invalid tech"));
            }
            if (bVar == null) {
                return;
            }
            if (f.this.c().contains(bVar)) {
                this.f143444b.invoke(new g.a(13022, "Tech already connected"));
                return;
            }
            try {
                obj = Reflect.on(bVar.d()).call("get", d16).get();
            } catch (Exception unused) {
                this.f143444b.invoke(new g.a(13015, "unavailable tech"));
                tagTechnology = null;
            }
            if (obj != null) {
                tagTechnology = (TagTechnology) obj;
                if (tagTechnology == null) {
                    return;
                }
                try {
                    tagTechnology.connect();
                    f.this.c().add(bVar);
                    this.f143444b.invoke(new g.b(Unit.INSTANCE));
                    return;
                } catch (Exception e16) {
                    w.f("MicroMsg.AppBrand.NFCReadWriteManager", "connect failed since " + e16);
                    this.f143444b.invoke(new g.a(13017, "system internal error: " + e16.getMessage()));
                    return;
                }
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vf.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6846f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143447b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143448c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f143449d;

        public RunnableC6846f(Function1 function1, String str, String str2, com.tencent.luggage.wxa.wf.a aVar) {
            this.f143447b = function1;
            this.f143448c = str;
            this.f143449d = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f fVar = f.this;
            Function1 function1 = this.f143447b;
            Tag d16 = fVar.d();
            if (d16 == null) {
                function1.invoke(new g.a(13013, "NFC tag has not been discovered"));
            }
            if (d16 == null) {
                return;
            }
            String str = this.f143448c;
            Function1 function12 = this.f143447b;
            com.tencent.luggage.wxa.wf.b bVar = (com.tencent.luggage.wxa.wf.b) com.tencent.luggage.wxa.wf.b.f144216e.b().get(str);
            if (bVar == null) {
                function12.invoke(new g.a(13014, "invalid tech"));
            }
            if (bVar == null) {
                return;
            }
            com.tencent.luggage.wxa.vf.c e16 = bVar.e();
            if (e16 == null) {
                this.f143447b.invoke(new g.a(13024, "function not support"));
            } else {
                e16.a(d16, this.f143449d, null, this.f143447b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143451b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143452c;

        public g(Function1 function1, String str) {
            this.f143451b = function1;
            this.f143452c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TagTechnology tagTechnology;
            Object obj;
            f fVar = f.this;
            Function1 function1 = this.f143451b;
            Tag d16 = fVar.d();
            if (d16 == null) {
                function1.invoke(new g.a(13013, "NFC tag has not been discovered"));
            }
            if (d16 == null) {
                return;
            }
            String str = this.f143452c;
            Function1 function12 = this.f143451b;
            com.tencent.luggage.wxa.wf.b bVar = (com.tencent.luggage.wxa.wf.b) com.tencent.luggage.wxa.wf.b.f144216e.b().get(str);
            if (bVar == null) {
                function12.invoke(new g.a(13014, "invalid tech"));
            }
            if (bVar == null) {
                return;
            }
            if (com.tencent.luggage.wxa.wf.b.D == bVar) {
                this.f143451b.invoke(new g.a(13024, "function not support"));
                return;
            }
            String str2 = null;
            try {
                obj = Reflect.on(bVar.d()).call("get", d16).get();
            } catch (Exception unused) {
                this.f143451b.invoke(new g.a(13015, "unavailable tech"));
                tagTechnology = null;
            }
            if (obj != null) {
                tagTechnology = (TagTechnology) obj;
                if (tagTechnology == null) {
                    return;
                }
                try {
                    Integer length = (Integer) Reflect.on(tagTechnology).call("getMaxTransceiveLength").get();
                    Function1 function13 = this.f143451b;
                    Intrinsics.checkNotNullExpressionValue(length, "length");
                    function13.invoke(new g.b(length));
                    return;
                } catch (Exception e16) {
                    Throwable a16 = f.this.a(e16);
                    w.f("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength failed since " + a16);
                    Function1 function14 = this.f143451b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("system internal error: ");
                    if (a16 != null) {
                        str2 = a16.getMessage();
                    }
                    sb5.append(str2);
                    function14.invoke(new g.a(13017, sb5.toString()));
                    return;
                }
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143454b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143455c;

        public h(Function1 function1, String str) {
            this.f143454b = function1;
            this.f143455c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TagTechnology tagTechnology;
            Object obj;
            f fVar = f.this;
            Function1 function1 = this.f143454b;
            Tag d16 = fVar.d();
            if (d16 == null) {
                function1.invoke(new g.a(13013, "NFC tag has not been discovered"));
            }
            if (d16 == null) {
                return;
            }
            String str = this.f143455c;
            Function1 function12 = this.f143454b;
            com.tencent.luggage.wxa.wf.b bVar = (com.tencent.luggage.wxa.wf.b) com.tencent.luggage.wxa.wf.b.f144216e.b().get(str);
            if (bVar == null) {
                function12.invoke(new g.a(13014, "invalid tech"));
            }
            if (bVar == null) {
                return;
            }
            try {
                obj = Reflect.on(bVar.d()).call("get", d16).get();
            } catch (Exception unused) {
                this.f143454b.invoke(new g.a(13015, "unavailable tech"));
                tagTechnology = null;
            }
            if (obj != null) {
                tagTechnology = (TagTechnology) obj;
                if (tagTechnology == null) {
                    return;
                }
                try {
                    this.f143454b.invoke(new g.b(Boolean.valueOf(tagTechnology.isConnected())));
                    return;
                } catch (Exception e16) {
                    w.d("MicroMsg.AppBrand.NFCReadWriteManager", "check isConnected failed since " + e16);
                    this.f143454b.invoke(new g.a(13017, "system internal error: " + e16.getMessage()));
                    return;
                }
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143457b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143458c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f143459d;

        public i(Function1 function1, String str, int i3) {
            this.f143457b = function1;
            this.f143458c = str;
            this.f143459d = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TagTechnology tagTechnology;
            Object obj;
            f fVar = f.this;
            Function1 function1 = this.f143457b;
            Tag d16 = fVar.d();
            if (d16 == null) {
                function1.invoke(new g.a(13013, "NFC tag has not been discovered"));
            }
            if (d16 == null) {
                return;
            }
            String str = this.f143458c;
            Function1 function12 = this.f143457b;
            com.tencent.luggage.wxa.wf.b bVar = (com.tencent.luggage.wxa.wf.b) com.tencent.luggage.wxa.wf.b.f144216e.b().get(str);
            if (bVar == null) {
                function12.invoke(new g.a(13014, "invalid tech"));
            }
            if (bVar == null) {
                return;
            }
            if (!bVar.a("setTimeout", Integer.TYPE)) {
                w.d("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, " + bVar.f() + ".setTimeout is not supported");
                this.f143457b.invoke(new g.a(13024, "function not support"));
                return;
            }
            String str2 = null;
            try {
                obj = Reflect.on(bVar.d()).call("get", d16).get();
            } catch (Exception unused) {
                this.f143457b.invoke(new g.a(13015, "unavailable tech"));
                tagTechnology = null;
            }
            if (obj != null) {
                tagTechnology = (TagTechnology) obj;
                if (tagTechnology == null) {
                    return;
                }
                try {
                    Reflect.on(tagTechnology).call("setTimeout", Integer.valueOf(this.f143459d));
                    this.f143457b.invoke(new g.b(Unit.INSTANCE));
                    return;
                } catch (Exception e16) {
                    Throwable a16 = f.this.a(e16);
                    w.f("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout failed since " + a16);
                    Function1 function13 = this.f143457b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("system internal error: ");
                    if (a16 != null) {
                        str2 = a16.getMessage();
                    }
                    sb5.append(str2);
                    function13.invoke(new g.a(13017, sb5.toString()));
                    return;
                }
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143461b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f143462a;

            static {
                int[] iArr = new int[b.a.values().length];
                iArr[b.a.SUCCESS.ordinal()] = 1;
                iArr[b.a.FAIL_ALREADY_STARTED.ordinal()] = 2;
                f143462a = iArr;
            }
        }

        public j(Function1 function1) {
            this.f143461b = function1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i3 = a.f143462a[f.this.f143438b.b().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    this.f143461b.invoke(new g.a(13017, "system internal error"));
                    return;
                } else {
                    this.f143461b.invoke(new g.a(13021, "NFC discovery already started"));
                    return;
                }
            }
            this.f143461b.invoke(new g.b(Unit.INSTANCE));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143464b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f143465a;

            static {
                int[] iArr = new int[b.a.values().length];
                iArr[b.a.SUCCESS.ordinal()] = 1;
                iArr[b.a.FAIL_NOT_STARTED.ordinal()] = 2;
                f143465a = iArr;
            }
        }

        public k(Function1 function1) {
            this.f143464b = function1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i3 = a.f143465a[f.this.f143438b.a().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    this.f143464b.invoke(new g.a(13017, "system internal error"));
                    return;
                } else {
                    this.f143464b.invoke(new g.a(13018, "NFC discovery has not started"));
                    return;
                }
            }
            this.f143464b.invoke(new g.b(Unit.INSTANCE));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143467b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143468c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ byte[] f143469d;

        public l(Function1 function1, String str, byte[] bArr) {
            this.f143467b = function1;
            this.f143468c = str;
            this.f143469d = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TagTechnology tagTechnology;
            String str;
            Object obj;
            f fVar = f.this;
            Function1 function1 = this.f143467b;
            Tag d16 = fVar.d();
            if (d16 == null) {
                function1.invoke(new g.a(13013, "NFC tag has not been discovered"));
            }
            if (d16 == null) {
                return;
            }
            String str2 = this.f143468c;
            Function1 function12 = this.f143467b;
            com.tencent.luggage.wxa.wf.b bVar = (com.tencent.luggage.wxa.wf.b) com.tencent.luggage.wxa.wf.b.f144216e.b().get(str2);
            if (bVar == null) {
                function12.invoke(new g.a(13014, "invalid tech"));
            }
            if (bVar == null) {
                return;
            }
            if (com.tencent.luggage.wxa.wf.b.D == bVar) {
                this.f143467b.invoke(new g.a(13024, "function not support"));
                return;
            }
            String str3 = null;
            try {
                obj = Reflect.on(bVar.d()).call("get", d16).get();
            } catch (Exception unused) {
                this.f143467b.invoke(new g.a(13015, "unavailable tech"));
                tagTechnology = null;
            }
            if (obj != null) {
                tagTechnology = (TagTechnology) obj;
                if (tagTechnology == null) {
                    return;
                }
                try {
                    byte[] rspData = (byte[]) Reflect.on(tagTechnology).call("transceive", this.f143469d).get();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("transceive, rspData: ");
                    if (rspData != null) {
                        str = Arrays.toString(rspData);
                        Intrinsics.checkNotNullExpressionValue(str, "toString(this)");
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    w.a("MicroMsg.AppBrand.NFCReadWriteManager", sb5.toString());
                    Function1 function13 = this.f143467b;
                    Intrinsics.checkNotNullExpressionValue(rspData, "rspData");
                    function13.invoke(new g.b(rspData));
                    return;
                } catch (Exception e16) {
                    Throwable a16 = f.this.a(e16);
                    w.f("MicroMsg.AppBrand.NFCReadWriteManager", "transceive failed since " + a16);
                    Function1 function14 = this.f143467b;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("system internal error: ");
                    if (a16 != null) {
                        str3 = a16.getMessage();
                    }
                    sb6.append(str3);
                    function14.invoke(new g.a(13017, sb6.toString()));
                    return;
                }
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f143471b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NdefMessage f143472c;

        public m(Function1 function1, NdefMessage ndefMessage) {
            this.f143471b = function1;
            this.f143472c = ndefMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f fVar = f.this;
            Function1 function1 = this.f143471b;
            Tag d16 = fVar.d();
            if (d16 == null) {
                function1.invoke(new g.a(13013, "NFC tag has not been discovered"));
            }
            if (d16 == null) {
                return;
            }
            Ndef ndef = Ndef.get(d16);
            if (ndef == null) {
                this.f143471b.invoke(new g.a(13015, "unavailable tech"));
                return;
            }
            try {
                ndef.writeNdefMessage(this.f143472c);
                this.f143471b.invoke(new g.b(Unit.INSTANCE));
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage failed since " + e16);
                this.f143471b.invoke(new g.a(13017, "system internal error: " + e16.getMessage()));
            }
        }
    }

    public f(String appId, com.tencent.luggage.wxa.vf.b nfcDiscoverable) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(nfcDiscoverable, "nfcDiscoverable");
        this.f143437a = appId;
        this.f143438b = nfcDiscoverable;
        com.tencent.luggage.wxa.ic.e.a(appId, new a());
    }

    public final Set c() {
        return this.f143438b.c();
    }

    public final Tag d() {
        return this.f143438b.getTag();
    }

    public final void b(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", n.NAME);
        com.tencent.luggage.wxa.zp.h.f146825d.a(new k(callback));
    }

    public final void c(String techName, Function1 callback) {
        Intrinsics.checkNotNullParameter(techName, "techName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength, techName: " + techName);
        com.tencent.luggage.wxa.zp.h.f146825d.b(new g(callback, techName), "NFC-IO");
    }

    public final void d(String techName, Function1 callback) {
        Intrinsics.checkNotNullParameter(techName, "techName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", "isConnected, techName: " + techName);
        com.tencent.luggage.wxa.zp.h.f146825d.b(new h(callback, techName), "NFC-IO");
    }

    public final void a(Function3 function3) {
        this.f143438b.a(function3);
    }

    public final void a(ArrayList filters) {
        Intrinsics.checkNotNullParameter(filters, "filters");
        this.f143438b.a(filters);
    }

    public final void b(String techName, Function1 callback) {
        Intrinsics.checkNotNullParameter(techName, "techName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", "connect, techName: " + techName);
        com.tencent.luggage.wxa.zp.h.f146825d.b(new e(callback, techName), "NFC-IO");
    }

    public final void a(boolean z16) {
        this.f143438b.a(z16);
    }

    public final void a(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", com.tencent.luggage.wxa.uf.m.NAME);
        com.tencent.luggage.wxa.zp.h.f146825d.a(new j(callback));
    }

    public final void a(String techName, Function1 callback) {
        Intrinsics.checkNotNullParameter(techName, "techName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", "close, techName: " + techName);
        com.tencent.luggage.wxa.zp.h.f146825d.b(new d(callback, techName), "NFC-IO");
    }

    public final void a(NdefMessage message, Function1 callback) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", "writeNdefMessage, message: " + message);
        com.tencent.luggage.wxa.zp.h.f146825d.b(new m(callback, message), "NFC-IO");
    }

    public final void a(String techName, int i3, Function1 callback) {
        Intrinsics.checkNotNullParameter(techName, "techName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", "setTimeout, techName: " + techName + ", timeoutMs: " + i3);
        com.tencent.luggage.wxa.zp.h.f146825d.b(new i(callback, techName, i3), "NFC-IO");
    }

    public final void a(String techName, byte[] reqData, Function1 callback) {
        Intrinsics.checkNotNullParameter(techName, "techName");
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("transceive, techName: ");
        sb5.append(techName);
        sb5.append(", reqData: ");
        String arrays = Arrays.toString(reqData);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb5.append(arrays);
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", sb5.toString());
        com.tencent.luggage.wxa.zp.h.f146825d.b(new l(callback, techName, reqData), "NFC-IO");
    }

    public final void a(String techName, String function, com.tencent.luggage.wxa.wf.a aVar, Function1 callback) {
        Intrinsics.checkNotNullParameter(techName, "techName");
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(callback, "callback");
        w.a("MicroMsg.AppBrand.NFCReadWriteManager", "execTechLogicAsync, techName: " + techName + ", function: " + function + ", params: " + aVar);
        com.tencent.luggage.wxa.zp.h.f146825d.b(new RunnableC6846f(callback, techName, function, aVar), "NFC-IO");
    }

    public final Throwable a(Throwable th5) {
        if (!(th5 instanceof ReflectException)) {
            return th5;
        }
        Throwable cause = th5.getCause();
        if (cause != null) {
            return cause.getCause();
        }
        return null;
    }
}
