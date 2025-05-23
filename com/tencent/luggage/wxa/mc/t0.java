package com.tencent.luggage.wxa.mc;

import android.util.ArrayMap;
import android.util.Log;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.mc.m;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t0 implements com.tencent.luggage.wxa.mc.m {

    /* renamed from: k, reason: collision with root package name */
    public static final a f134367k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final c f134368a;

    /* renamed from: b, reason: collision with root package name */
    public final String f134369b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.mm.plugin.appbrand.appcache.a f134370c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.fd.p f134371d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayMap f134372e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f134373f;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f134374g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f134375h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f134376i;

    /* renamed from: j, reason: collision with root package name */
    public final ReentrantReadWriteLock f134377j;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t0 a(com.tencent.luggage.wxa.ic.g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "<this>");
            com.tencent.luggage.wxa.mc.n b16 = k0.b(gVar);
            k0 k0Var = b16 instanceof k0 ? (k0) b16 : null;
            com.tencent.luggage.wxa.mc.m f16 = k0Var != null ? k0Var.f() : null;
            if (f16 instanceof t0) {
                return (t0) f16;
            }
            return null;
        }

        public final String a(WxaPluginPkgInfo wxaPluginPkgInfo) {
            String str = wxaPluginPkgInfo.prefixPath;
            if (!(str == null || str.length() == 0)) {
                String str2 = wxaPluginPkgInfo.prefixPath;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n                this.prefixPath\n            }");
                return str2;
            }
            return WxaPluginPkgInfo.PREFIX_EXTENDED + wxaPluginPkgInfo.provider;
        }

        public final String a(String hostModule, WxaPluginPkgInfo plugin) {
            boolean endsWith$default;
            Intrinsics.checkNotNullParameter(hostModule, "hostModule");
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            if (Intrinsics.areEqual(hostModule, ModulePkgInfo.MAIN_MODULE_NAME)) {
                return a(plugin);
            }
            endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) hostModule, '/', false, 2, (Object) null);
            if (endsWith$default) {
                return hostModule + a(plugin);
            }
            return hostModule + '/' + a(plugin);
        }

        public final String a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(com.tencent.luggage.wxa.fd.p pVar);

        boolean a();

        com.tencent.mm.plugin.appbrand.appcache.a b();

        String getAppId();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(String str, a0 a0Var);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function0 {
        public d() {
            super(0);
        }

        public final void a() {
            Set<Map.Entry> entrySet = t0.this.f134373f.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "pkgsMap.entries");
            for (Map.Entry entry : entrySet) {
                Intrinsics.checkNotNullExpressionValue(entry, "(_, pkg)");
                ((a0) entry.getValue()).close();
            }
            t0.this.f134373f.clear();
            t0.this.f134374g.clear();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f134380b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f134380b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a0 invoke() {
            a0 a0Var;
            boolean startsWith$default;
            m.a aVar = (m.a) t0.this.f134374g.get(this.f134380b);
            if (aVar != null) {
                a0Var = aVar.f134338d;
            } else {
                a0Var = null;
            }
            if (a0Var == null) {
                ConcurrentHashMap concurrentHashMap = t0.this.f134374g;
                String str = this.f134380b;
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    m.a aVar2 = (m.a) entry.getValue();
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, str, false, 2, null);
                    if (startsWith$default) {
                        return aVar2.f134338d;
                    }
                }
                return null;
            }
            return a0Var;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke() {
            a0 a0Var;
            m.a aVar = (m.a) t0.this.f134374g.get(ModulePkgInfo.MAIN_MODULE_NAME);
            if (aVar != null && (a0Var = aVar.f134338d) != null) {
                return a0Var.h();
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ModulePkgInfo f134383b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ModulePkgInfo modulePkgInfo) {
            super(1);
            this.f134383b = modulePkgInfo;
        }

        public final void a(m.a it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.f134335a = t0.this.f134369b;
            it.f134336b = t0.this.f134370c.pkgVersion();
            it.f134337c = this.f134383b.checksumMd5();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((m.a) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ModulePkgInfo f134384a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ModulePkgInfo modulePkgInfo) {
            super(0);
            this.f134384a = modulePkgInfo;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a0 invoke() {
            return new a0(this.f134384a.pkgPath);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WxaPluginPkgInfo f134385a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(WxaPluginPkgInfo wxaPluginPkgInfo) {
            super(1);
            this.f134385a = wxaPluginPkgInfo;
        }

        public final void a(m.a it) {
            Intrinsics.checkNotNullParameter(it, "it");
            WxaPluginPkgInfo wxaPluginPkgInfo = this.f134385a;
            it.f134335a = wxaPluginPkgInfo.provider;
            it.f134336b = wxaPluginPkgInfo.pkgVersion();
            it.f134337c = this.f134385a.checksumMd5();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((m.a) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WxaPluginPkgInfo f134386a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(WxaPluginPkgInfo wxaPluginPkgInfo) {
            super(0);
            this.f134386a = wxaPluginPkgInfo;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a0 invoke() {
            return new a0(this.f134386a.pkgPath);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends Lambda implements Function0 {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LinkedList invoke() {
            LinkedList linkedList = new LinkedList();
            for (Map.Entry entry : t0.this.f134374g.entrySet()) {
                String str = (String) entry.getKey();
                if (((m.a) entry.getValue()).f134340f != null) {
                    linkedList.add(str);
                }
            }
            return linkedList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedList f134388a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t0 f134389b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(LinkedList linkedList, t0 t0Var) {
            super(0);
            this.f134388a = linkedList;
            this.f134389b = t0Var;
        }

        public final void a() {
            Object obj;
            Iterator it = this.f134388a.iterator();
            t0 t0Var = this.f134389b;
            while (it.hasNext()) {
                com.tencent.luggage.wxa.mc.j jVar = (com.tencent.luggage.wxa.mc.j) it.next();
                if (!(jVar instanceof ModulePkgInfo) && (jVar instanceof WxaPluginPkgInfo)) {
                    q0 q0Var = t0Var.f134370c.f151866f;
                    Intrinsics.checkNotNull(q0Var);
                    q0Var.a((WxaPluginPkgInfo) jVar);
                    it.remove();
                }
            }
            LinkedList<com.tencent.luggage.wxa.mc.j> linkedList = this.f134388a;
            t0 t0Var2 = this.f134389b;
            for (com.tencent.luggage.wxa.mc.j jVar2 : linkedList) {
                Intrinsics.checkNotNull(jVar2, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo");
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) jVar2;
                Iterator it5 = t0Var2.f134370c.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (Intrinsics.areEqual(((ModulePkgInfo) obj).name, modulePkgInfo.name)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Intrinsics.checkNotNull(obj);
                ModulePkgInfo modulePkgInfo2 = (ModulePkgInfo) obj;
                modulePkgInfo2.pkgPath = modulePkgInfo.pkgPath;
                modulePkgInfo2.md5 = modulePkgInfo.md5;
                t0Var2.a(modulePkgInfo);
                q0 q0Var2 = t0Var2.f134370c.f151866f;
                if (q0Var2 != null) {
                    String str = modulePkgInfo.name;
                    Intrinsics.checkNotNullExpressionValue(str, "module.name");
                    List<WxaPluginPkgInfo> b16 = q0Var2.b(str);
                    if (b16 != null) {
                        for (WxaPluginPkgInfo wxaPluginPkgInfo : b16) {
                            String str2 = modulePkgInfo.name;
                            Intrinsics.checkNotNullExpressionValue(str2, "module.name");
                            t0Var2.a(str2, wxaPluginPkgInfo);
                        }
                    }
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f134391b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(String str) {
            super(0);
            this.f134391b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m.a invoke() {
            m.a aVar = (m.a) t0.this.f134374g.get(this.f134391b);
            if (aVar == null) {
                String str = this.f134391b;
                t0 t0Var = t0.this;
                String[] strArr = {com.tencent.luggage.wxa.rc.m.a(str), com.tencent.luggage.wxa.rc.m.c(str)};
                m.a aVar2 = null;
                for (int i3 = 0; i3 < 2; i3++) {
                    String str2 = strArr[i3];
                    if (!Intrinsics.areEqual(str2, str) && (aVar2 = (m.a) t0Var.f134374g.get(str2)) != null) {
                        break;
                    }
                }
                return aVar2;
            }
            return aVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n extends Lambda implements Function0 {
        public n() {
            super(0);
        }

        public final void a() {
            List<WxaPluginPkgInfo> list;
            t0.this.f134370c.c(t0.this.f134369b);
            q0 q0Var = t0.this.f134370c.f151866f;
            if (q0Var != null) {
                q0Var.c();
            }
            t0 t0Var = t0.this;
            ArrayMap arrayMap = new ArrayMap(t0.this.f134370c.f151864d.size() + 1);
            Iterator it = t0.this.f134370c.iterator();
            while (it.hasNext()) {
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                arrayMap.put(modulePkgInfo.name, modulePkgInfo);
            }
            t0Var.f134372e = arrayMap;
            Iterator it5 = t0.this.f134370c.iterator();
            while (it5.hasNext()) {
                ModulePkgInfo module = (ModulePkgInfo) it5.next();
                if (com.tencent.luggage.wxa.cp.x.d(module.pkgPath)) {
                    t0 t0Var2 = t0.this;
                    Intrinsics.checkNotNullExpressionValue(module, "module");
                    t0Var2.a(module);
                    q0 q0Var2 = t0.this.f134370c.f151866f;
                    if (q0Var2 != null) {
                        String str = module.name;
                        Intrinsics.checkNotNullExpressionValue(str, "module.name");
                        list = q0Var2.b(str);
                    } else {
                        list = null;
                    }
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    }
                    for (WxaPluginPkgInfo wxaPluginPkgInfo : list) {
                        t0 t0Var3 = t0.this;
                        String str2 = module.name;
                        Intrinsics.checkNotNullExpressionValue(str2, "module.name");
                        t0Var3.a(str2, wxaPluginPkgInfo);
                    }
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public t0(b rt5, c cVar) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        this.f134368a = cVar;
        this.f134369b = rt5.getAppId();
        com.tencent.mm.plugin.appbrand.appcache.a b16 = rt5.b();
        this.f134370c = b16;
        this.f134373f = new ConcurrentHashMap();
        this.f134374g = new ConcurrentHashMap(100);
        com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", "<init> appId:" + rt5.getAppId() + ", pkg:" + b16 + ", hash:" + hashCode());
        if (rt5.a()) {
            com.tencent.luggage.wxa.fd.p pVar = new com.tencent.luggage.wxa.fd.p();
            rt5.a(pVar);
            this.f134371d = pVar;
        } else {
            this.f134371d = null;
        }
        this.f134377j = new ReentrantReadWriteLock();
    }

    public static final t0 a(com.tencent.luggage.wxa.ic.g gVar) {
        return f134367k.a(gVar);
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public void close() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", "close, appId:" + this.f134369b + ", hash:" + hashCode());
        b(new d());
        this.f134376i = true;
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public a0 e(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        return (a0) a(new e(str));
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public m.a openReadPartialInfo(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        return (m.a) a(new m(str));
    }

    public final Object b(Function0 function0) {
        ReentrantReadWriteLock reentrantReadWriteLock = this.f134377j;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i3 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i16 = 0; i16 < readHoldCount; i16++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return function0.invoke();
        } finally {
            while (i3 < readHoldCount) {
                readLock.lock();
                i3++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public List c() {
        return (List) a(new k());
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public boolean d(String str) {
        return openReadPartialInfo(str) != null;
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public void b() {
        if (this.f134375h) {
            return;
        }
        b(new n());
        this.f134375h = true;
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public List d() {
        return (List) a(new f());
    }

    public final Object a(Function0 function0) {
        ReentrantReadWriteLock.ReadLock readLock = this.f134377j.readLock();
        readLock.lock();
        try {
            return function0.invoke();
        } finally {
            readLock.unlock();
        }
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public InputStream b(String str) {
        m.a openReadPartialInfo = openReadPartialInfo(str);
        if (openReadPartialInfo != null) {
            return a(openReadPartialInfo);
        }
        return null;
    }

    public final a0 a(String str, Function0 function0) {
        c cVar;
        a0 a0Var = (a0) this.f134373f.get(str);
        if (a0Var != null) {
            return a0Var;
        }
        a0 a0Var2 = (a0) function0.invoke();
        if (a0Var2 == null) {
            return null;
        }
        boolean m3 = a0Var2.m();
        com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedObtainPkgInstance, appId:" + this.f134369b + ", name:" + str + ", pkgInnerVersion:" + a0Var2.r() + ", ok:" + m3);
        if (!m3 && (cVar = this.f134368a) != null) {
            cVar.a(str, a0Var2);
        }
        this.f134373f.put(str, a0Var2);
        return a0Var2;
    }

    public final void a(List _pkgList) {
        Intrinsics.checkNotNullParameter(_pkgList, "_pkgList");
        if (this.f134376i) {
            return;
        }
        b(new l(new LinkedList(_pkgList), this));
    }

    public final void a(ModulePkgInfo modulePkgInfo) {
        String str = modulePkgInfo.name;
        Intrinsics.checkNotNullExpressionValue(str, "module.name");
        a0 a16 = a(str, new h(modulePkgInfo));
        Intrinsics.checkNotNull(a16);
        g gVar = new g(modulePkgInfo);
        ConcurrentHashMap concurrentHashMap = this.f134374g;
        String str2 = modulePkgInfo.name;
        Intrinsics.checkNotNullExpressionValue(str2, "module.name");
        m.a aVar = new m.a();
        aVar.f134338d = a16;
        aVar.f134339e = a16.d();
        aVar.f134340f = modulePkgInfo.name;
        gVar.invoke(aVar);
        concurrentHashMap.put(str2, aVar);
        for (a0.a info : a16.h()) {
            ConcurrentHashMap concurrentHashMap2 = this.f134374g;
            String str3 = info.f134263b;
            Intrinsics.checkNotNullExpressionValue(str3, "info.fileName");
            Intrinsics.checkNotNullExpressionValue(info, "info");
            m.a a17 = a(info, a16);
            gVar.invoke(a17);
            concurrentHashMap2.put(str3, a17);
        }
    }

    public final void a(String str, WxaPluginPkgInfo wxaPluginPkgInfo) {
        String joinToString$default;
        String str2;
        boolean endsWith$default;
        a aVar = f134367k;
        String a16 = aVar.a(str, wxaPluginPkgInfo);
        if (this.f134374g.get(a16) != null) {
            return;
        }
        String str3 = wxaPluginPkgInfo.provider;
        Intrinsics.checkNotNullExpressionValue(str3, "plugin.provider");
        a0 a17 = a(str3, new j(wxaPluginPkgInfo));
        Intrinsics.checkNotNull(a17);
        if (com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g || com.tencent.luggage.wxa.tn.e.f141566h || com.tencent.luggage.wxa.tn.w.d() <= 1) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("guardedMergePlugin hostModule:");
            sb5.append(str);
            sb5.append(", accessPrefix:");
            sb5.append(a16);
            sb5.append(", files:");
            List g16 = a17.g();
            if (g16 == null) {
                g16 = CollectionsKt__CollectionsKt.emptyList();
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(g16, " , ", "{", "}", 0, null, null, 56, null);
            sb5.append(joinToString$default);
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", sb5.toString());
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedMergePlugin hostModule:" + str + ", accessPrefix:" + a16 + ", json:" + aVar.a(a17.b("/plugin.json")));
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedMergePlugin hostModule:" + str + ", accessPrefix:" + a16 + ", darkmode-json:" + aVar.a(a17.b("/plugin-darkmode.json")));
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedMergePlugin hostModule:" + str + ", accessPrefix:" + a16 + ", stack:" + Log.getStackTraceString(new Throwable()));
        }
        i iVar = new i(wxaPluginPkgInfo);
        ConcurrentHashMap concurrentHashMap = this.f134374g;
        m.a aVar2 = new m.a();
        aVar2.f134338d = a17;
        aVar2.f134339e = a17.d();
        iVar.invoke(aVar2);
        concurrentHashMap.put(a16, aVar2);
        String str4 = wxaPluginPkgInfo.prefixPath;
        if (str4 == null || str4.length() == 0) {
            str2 = a16.substring(0, a16.length() - aVar.a(wxaPluginPkgInfo).length());
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        } else {
            str2 = a16;
        }
        endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) str2, '/', false, 2, (Object) null);
        if (endsWith$default) {
            str2 = str2.substring(0, str2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        for (a0.a info : a17.h()) {
            String str5 = str2 + com.tencent.luggage.wxa.rc.m.a(info.f134263b, false);
            ConcurrentHashMap concurrentHashMap2 = this.f134374g;
            Intrinsics.checkNotNullExpressionValue(info, "info");
            m.a a18 = a(info, a17);
            iVar.invoke(a18);
            concurrentHashMap2.put(str5, a18);
        }
        com.tencent.luggage.wxa.fd.p pVar = this.f134371d;
        if (pVar != null) {
            pVar.a(a16);
        }
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public boolean a(String str, boolean z16) {
        boolean z17 = openReadPartialInfo(str) != null;
        if (z16) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.WxaRuntimePkgMergeDirReader", "canAccessFile appId:" + this.f134369b + ", url:" + str + ", ret:" + z17 + ", hash:" + hashCode());
        }
        return z17;
    }

    @Override // com.tencent.luggage.wxa.mc.m
    public List a() {
        LinkedList linkedList = this.f134370c.f151864d;
        Intrinsics.checkNotNullExpressionValue(linkedList, "pkgWrappingInfo.moduleList");
        return linkedList;
    }

    public final InputStream a(m.a aVar) {
        return aVar.f134338d.b(aVar.f134340f);
    }

    public final m.a a(a0.a aVar, a0 a0Var) {
        m.a aVar2 = new m.a();
        aVar2.f134338d = a0Var;
        aVar2.f134339e = a0Var.d();
        aVar2.f134340f = aVar.f134263b;
        aVar2.f134341g = aVar.f134264c;
        aVar2.f134342h = aVar.f134265d;
        return aVar2;
    }
}
