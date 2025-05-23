package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import com.tencent.luggage.wxa.fd.l0;
import com.tencent.luggage.wxa.q9.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mm.sdk.event.IListener;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes9.dex */
public final class WxaSyncCmdPersistentStorage {

    /* renamed from: d, reason: collision with root package name */
    public static final a f151870d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f151871e = {com.tencent.luggage.wxa.xn.c.a(com.tencent.luggage.wxa.pc.a.f137485n, "PersistentWxaSyncInvalidCodeCmd"), com.tencent.luggage.wxa.xn.c.a(com.tencent.luggage.wxa.pc.b.f137486t, "PersistentWxaSyncInvalidContactCmd")};

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xn.b f151872a;

    /* renamed from: b, reason: collision with root package name */
    public final b f151873b;

    /* renamed from: c, reason: collision with root package name */
    public final c f151874c;

    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends com.tencent.luggage.wxa.xn.c {
        public b(com.tencent.luggage.wxa.xn.b bVar, a.C6921a c6921a, String[] strArr) {
            super(bVar, c6921a, "PersistentWxaSyncInvalidCodeCmd", strArr);
        }
    }

    /* loaded from: classes9.dex */
    public static final class c extends com.tencent.luggage.wxa.xn.c {
        public c(com.tencent.luggage.wxa.xn.b bVar, a.C6921a c6921a, String[] strArr) {
            super(bVar, c6921a, "PersistentWxaSyncInvalidContactCmd", strArr);
        }
    }

    public WxaSyncCmdPersistentStorage(com.tencent.luggage.wxa.xn.b db5) {
        Intrinsics.checkNotNullParameter(db5, "db");
        this.f151872a = db5;
        new IListener<l0>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.mm.plugin.appbrand.appcache.predownload.storage.WxaSyncCmdPersistentStorage.1

            /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.storage.WxaSyncCmdPersistentStorage$1$a */
            /* loaded from: classes9.dex */
            public static final class a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ WxaSyncCmdPersistentStorage f151876a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f151877b;

                public a(WxaSyncCmdPersistentStorage wxaSyncCmdPersistentStorage, String str) {
                    this.f151876a = wxaSyncCmdPersistentStorage;
                    this.f151877b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f151876a.a(this.f151877b);
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.storage.WxaSyncCmdPersistentStorage$1$b */
            /* loaded from: classes9.dex */
            public static final class b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ List f151878a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ WxaSyncCmdPersistentStorage f151879b;

                public b(List list, WxaSyncCmdPersistentStorage wxaSyncCmdPersistentStorage) {
                    this.f151878a = list;
                    this.f151879b = wxaSyncCmdPersistentStorage;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    boolean z16;
                    List<String> list = this.f151878a;
                    WxaSyncCmdPersistentStorage wxaSyncCmdPersistentStorage = this.f151879b;
                    for (String str : list) {
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            wxaSyncCmdPersistentStorage.a(str);
                        }
                    }
                }
            }

            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(l0 event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (WxaSyncCmdPersistentStorage.this.f151872a.a()) {
                    dead();
                } else {
                    boolean z16 = true;
                    List list = null;
                    String str = null;
                    if (Intrinsics.areEqual("single", event.d())) {
                        Object e16 = event.e();
                        if (e16 != null) {
                            str = e16.toString();
                        }
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        }
                        if (z16) {
                            return false;
                        }
                        h.f146825d.b(new a(WxaSyncCmdPersistentStorage.this, str), "MicroMsg.WxaSyncCmdPersistentStorage");
                    } else if (Intrinsics.areEqual("batch", event.d())) {
                        Object e17 = event.e();
                        if (e17 instanceof List) {
                            list = (List) e17;
                        }
                        if (list != null && !list.isEmpty()) {
                            z16 = false;
                        }
                        if (z16) {
                            return false;
                        }
                        h.f146825d.b(new b(list, WxaSyncCmdPersistentStorage.this), "MicroMsg.WxaSyncCmdPersistentStorage");
                    }
                }
                return false;
            }
        }.alive();
        this.f151873b = new b(db5, com.tencent.luggage.wxa.pc.a.f137485n, com.tencent.luggage.wxa.q9.h.f138378g);
        this.f151874c = new c(db5, com.tencent.luggage.wxa.pc.b.f137486t, i.f138390m);
    }

    public boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        com.tencent.luggage.wxa.pc.b bVar = new com.tencent.luggage.wxa.pc.b();
        bVar.f138397b = str;
        try {
            if (this.f151874c.b(bVar, new String[0])) {
                return this.f151874c.a(bVar, new String[0]);
            }
            return true;
        } catch (Exception e16) {
            w.b("MicroMsg.WxaSyncCmdPersistentStorage", "removeInvalidContactTimestampForUsername username:" + str + ", exception:" + e16);
            return false;
        }
    }
}
