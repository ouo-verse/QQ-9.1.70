package com.tencent.tbs.one.impl.c;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneConfigurationKeys;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a.c;
import com.tencent.tbs.one.impl.a.a.d;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.e.h;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b implements d.a {

    /* renamed from: a, reason: collision with root package name */
    protected final String f374731a;

    /* renamed from: b, reason: collision with root package name */
    protected final h f374732b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f374734d;

    /* renamed from: e, reason: collision with root package name */
    boolean f374735e;

    /* renamed from: f, reason: collision with root package name */
    protected d.a f374736f;

    /* renamed from: g, reason: collision with root package name */
    int f374737g;

    /* renamed from: h, reason: collision with root package name */
    String f374738h;

    /* renamed from: i, reason: collision with root package name */
    public File f374739i;

    /* renamed from: j, reason: collision with root package name */
    public a f374740j;

    /* renamed from: k, reason: collision with root package name */
    WeakReference<com.tencent.tbs.one.impl.a.b> f374741k;

    /* renamed from: m, reason: collision with root package name */
    private e f374743m;

    /* renamed from: n, reason: collision with root package name */
    private Map<String, ClassLoader> f374744n;

    /* renamed from: o, reason: collision with root package name */
    private int f374745o;

    /* renamed from: p, reason: collision with root package name */
    private int f374746p;

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<TBSOneCallback<File>> f374742l = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    protected final ArrayList<TBSOneCallback<TBSOneComponent>> f374733c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.c.b$2, reason: invalid class name */
    /* loaded from: classes26.dex */
    public final class AnonymousClass2 extends com.tencent.tbs.one.impl.a.a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f374749d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.a f374750e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f374751f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f374752g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f374753h;

        AnonymousClass2(Bundle bundle, d.a aVar, float f16, String str, String str2) {
            this.f374749d = bundle;
            this.f374750e = aVar;
            this.f374751f = f16;
            this.f374752g = str;
            this.f374753h = str2;
        }

        @Override // com.tencent.tbs.one.impl.a.a.b
        public final void a(final c cVar) {
            o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.c.b.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    b bVar = b.this;
                    if (bVar.f374735e) {
                        cVar.a(104, "Aborted", null);
                        return;
                    }
                    com.tencent.tbs.one.impl.a.b<com.tencent.tbs.one.impl.e.e<File>> a16 = bVar.f374732b.a(anonymousClass2.f374749d, anonymousClass2.f374750e, new m<com.tencent.tbs.one.impl.e.e<File>>() { // from class: com.tencent.tbs.one.impl.c.b.2.1.1
                        @Override // com.tencent.tbs.one.impl.a.m
                        public final /* synthetic */ void a(com.tencent.tbs.one.impl.e.e<File> eVar) {
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            g.a("[%s] {%s} Finished installing component itself from source %s", anonymousClass22.f374752g, anonymousClass22.f374753h, eVar.f375020a);
                            cVar.c();
                        }

                        @Override // com.tencent.tbs.one.impl.a.m
                        public final void a(int i3, int i16) {
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            b.a(b.this, i3, i16, anonymousClass22.f374751f);
                        }

                        @Override // com.tencent.tbs.one.impl.a.m
                        public final void a(int i3, String str, Throwable th5) {
                            cVar.a(i3, str, th5);
                        }
                    });
                    b.this.f374741k = new WeakReference<>(a16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.c.b$3, reason: invalid class name */
    /* loaded from: classes26.dex */
    public final class AnonymousClass3 extends com.tencent.tbs.one.impl.a.a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f374758d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f374759e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f374760f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f374761g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f374762h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f374763i;

        AnonymousClass3(h hVar, Bundle bundle, String str, float f16, String str2, String str3) {
            this.f374758d = hVar;
            this.f374759e = bundle;
            this.f374760f = str;
            this.f374761g = f16;
            this.f374762h = str2;
            this.f374763i = str3;
        }

        @Override // com.tencent.tbs.one.impl.a.a.b
        public final void a(final c cVar) {
            o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.c.b.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    if (b.this.f374735e) {
                        cVar.a(104, "Aborted", null);
                    } else {
                        anonymousClass3.f374758d.a(anonymousClass3.f374759e, anonymousClass3.f374760f, new TBSOneCallback<File>() { // from class: com.tencent.tbs.one.impl.c.b.3.1.1
                            @Override // com.tencent.tbs.one.TBSOneCallback
                            public final /* synthetic */ void onCompleted(File file) {
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                g.a("[%s] {%s} Finished installing dependency %s", anonymousClass32.f374762h, anonymousClass32.f374763i, anonymousClass32.f374760f);
                                cVar.c();
                            }

                            @Override // com.tencent.tbs.one.TBSOneCallback
                            public final void onError(int i3, String str) {
                                cVar.a(i3, "Failed to install dependency " + AnonymousClass3.this.f374760f + ", error: " + str, null);
                            }

                            @Override // com.tencent.tbs.one.TBSOneCallback
                            public final void onProgressChanged(int i3, int i16) {
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                b.a(b.this, i3, i16, anonymousClass32.f374761g);
                            }
                        });
                    }
                }
            });
        }
    }

    public b(h hVar, String str) {
        this.f374731a = str;
        this.f374732b = hVar;
    }

    private Set<String> d() {
        String[] strArr;
        HashSet hashSet = new HashSet();
        File file = this.f374739i;
        if (file != null) {
            hashSet.add(file.getAbsolutePath());
        }
        d.a aVar = this.f374736f;
        if (aVar != null && (strArr = aVar.f374831f) != null) {
            for (String str : strArr) {
                hashSet.addAll(this.f374732b.e(str).d());
            }
        }
        return hashSet;
    }

    public final void b(Bundle bundle, TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        a aVar = this.f374740j;
        if (aVar != null) {
            g.a("[%s] {%s} [ComponentLoader] Loaded component %s", this.f374732b.f375049b, this.f374731a, aVar);
            if (tBSOneCallback != null) {
                tBSOneCallback.onProgressChanged(0, 100);
                tBSOneCallback.onCompleted(this.f374740j);
                return;
            }
            return;
        }
        if (tBSOneCallback != null) {
            tBSOneCallback.onProgressChanged(0, this.f374745o);
            this.f374733c.add(tBSOneCallback);
        }
        if (this.f374739i != null) {
            c();
        } else {
            a(bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x030d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void c() {
        String str;
        int i3;
        char c16;
        char c17;
        char c18;
        char c19;
        com.tencent.tbs.one.impl.c.b.b bVar;
        if (this.f374732b.h(this.f374731a)) {
            b(501, "[ComponentLoader].initializeComponent The component has disabled", new Throwable("component disabled"));
            return;
        }
        com.tencent.tbs.one.b.c(this.f374732b.f375049b).d(this.f374731a).c("initialize");
        String str2 = this.f374732b.f375049b;
        String str3 = this.f374731a;
        int i16 = this.f374736f.f374828c;
        g.a("[%s] {%s} [ComponentLoader].initializeComponent Initializing component", str2, str3);
        a aVar = new a(str3, this.f374736f.f374827b, i16, this.f374739i);
        File a16 = a("MANIFEST");
        if (a16.exists()) {
            g.a("[%s] {%s} [ComponentLoader].initializeComponent Initializing component according to MANIFEST file %s", str2, str3, a16.getAbsolutePath());
            try {
                e a17 = e.a(a16);
                this.f374743m = a17;
                Pair<String, String>[] pairArr = a17.f374837f;
                if (pairArr != null) {
                    g.a("[%s] {%s} [ComponentLoader].initializeComponent Registering event receivers", str2, str3, pairArr);
                    int length = pairArr.length;
                    int i17 = 0;
                    while (i17 < length) {
                        Pair<String, String> pair = pairArr[i17];
                        h hVar = this.f374732b;
                        Pair<String, String>[] pairArr2 = pairArr;
                        com.tencent.tbs.one.impl.common.g gVar = new com.tencent.tbs.one.impl.common.g(str3, (String) pair.second, (String) pair.first);
                        String str4 = gVar.f374850c;
                        List<com.tencent.tbs.one.impl.common.g> list = hVar.f375054g.get(str4);
                        if (list == null) {
                            list = new ArrayList<>();
                            hVar.f375054g.put(str4, list);
                        }
                        list.add(gVar);
                        i17++;
                        pairArr = pairArr2;
                    }
                } else {
                    g.a("[%s] {%s} [ComponentLoader].initializeComponent No event receivers", str2, str3);
                }
                Context context = this.f374732b.f375048a;
                String str5 = this.f374743m.f374833b;
                if (!TextUtils.isEmpty(str5)) {
                    File a18 = a(str5);
                    g.a("[%s] {%s} [ComponentLoader].initializeComponent Creating resource context %s from %s", str2, str3, str5, a18.getAbsolutePath());
                    if (!a18.exists()) {
                        b(105, "[ComponentLoader].initializeComponent Failed to find resource file " + a18.getAbsolutePath(), null);
                        return;
                    } else {
                        com.tencent.tbs.one.impl.c.b.b bVar2 = new com.tencent.tbs.one.impl.c.b.b(context, a18.getAbsolutePath());
                        aVar.f374632a = bVar2;
                        bVar = bVar2;
                        c19 = 0;
                    }
                } else {
                    c19 = 0;
                    g.b("[%s] {%s} [ComponentLoader].initializeComponent No resource file", str2, str3);
                    bVar = null;
                }
                String[] strArr = this.f374743m.f374834c;
                if (strArr != null && strArr.length > 0 && !TextUtils.isEmpty(strArr[c19])) {
                    try {
                        ClassLoader a19 = a(context, strArr);
                        aVar.f374633b = a19;
                        String str6 = this.f374743m.f374835d;
                        if (!TextUtils.isEmpty(str6)) {
                            str = "initialize";
                            g.a("[%s] {%s} [ComponentLoader].initializeComponent Constructing entry object %s", str2, str3, str6);
                            HashMap hashMap = new HashMap();
                            hashMap.put("callerContext", context);
                            if (bVar != null) {
                                bVar.f374787a.f374780a = a19;
                                hashMap.put("resourcesContext", bVar);
                            }
                            hashMap.put("classLoader", a19);
                            hashMap.put("installationDirectory", this.f374739i);
                            hashMap.put("optimizedDirectory", this.f374739i);
                            hashMap.put("librarySearchPath", b(strArr[0]));
                            hashMap.put("versionName", this.f374736f.f374827b);
                            hashMap.put("versionCode", Integer.valueOf(i16));
                            hashMap.put("eventEmitter", this.f374732b.f375051d);
                            try {
                                g.a("[%s] {%s} [ComponentLoader].initializeComponent try to loadclass %s", str2, str3, str6);
                                aVar.f374634c = a19.loadClass(str6).getConstructor(Map.class).newInstance(hashMap);
                                i3 = 2;
                                c17 = 1;
                                c16 = 0;
                                c18 = 1;
                                if (c18 == 0) {
                                    Object[] objArr = new Object[i3];
                                    objArr[c16] = str2;
                                    objArr[c17] = str3;
                                    g.b("[%s] {%s} [ComponentLoader].initializeComponent Failed to load class to entry object", objArr);
                                }
                                com.tencent.tbs.one.b.c(this.f374732b.f375049b).d(this.f374731a).b(str);
                                a(aVar);
                            } catch (ClassNotFoundException e16) {
                                b(405, "[" + str2 + "] {" + str3 + "} [ComponentLoader].initializeComponent Failed to load entry class " + str6 + " in " + strArr[0] + "\n" + Log.getStackTraceString(e16), null);
                                return;
                            } catch (NoSuchMethodException e17) {
                                b(406, "[" + str2 + "] {" + str3 + "} [ComponentLoader].initializeComponent Failed to find entry class " + str6 + " constructor in " + strArr[0] + "\n" + Log.getStackTraceString(e17), null);
                                return;
                            } catch (Exception e18) {
                                b(407, "[" + str2 + "] {" + str3 + "} [ComponentLoader].initializeComponent Failed to construct the entry object with " + str6 + " in " + strArr[0] + "\n" + Log.getStackTraceString(e18), null);
                                return;
                            }
                        }
                        str = "initialize";
                        g.b("[%s] {%s} [ComponentLoader].initializeComponent No entry class", str2, str3);
                    } catch (TBSOneException e19) {
                        b(e19.getErrorCode(), e19.getMessage(), e19.getCause());
                        return;
                    }
                } else {
                    str = "initialize";
                    g.b("[%s] {%s} [ComponentLoader].initializeComponent No entry dex file", str2, str3);
                }
                i3 = 2;
                c17 = 1;
                c16 = 0;
            } catch (TBSOneException e26) {
                b(e26.getErrorCode(), e26.getMessage(), e26.getCause());
                return;
            }
        } else {
            str = "initialize";
            i3 = 2;
            c16 = 0;
            c17 = 1;
            g.b("[%s] {%s} [ComponentLoader].initializeComponent No MANIFEST file", str2, str3);
        }
        c18 = c16;
        if (c18 == 0) {
        }
        com.tencent.tbs.one.b.c(this.f374732b.f375049b).d(this.f374731a).b(str);
        a(aVar);
    }

    public final void a(Bundle bundle, TBSOneCallback<File> tBSOneCallback) {
        File file = this.f374739i;
        if (file != null) {
            g.a("[%s] {%s} [ComponentLoader] Installed component at %s", this.f374732b.f375049b, this.f374731a, file);
            if (tBSOneCallback != null) {
                tBSOneCallback.onProgressChanged(0, 100);
                tBSOneCallback.onCompleted(this.f374739i);
                return;
            }
            return;
        }
        if (tBSOneCallback != null) {
            tBSOneCallback.onProgressChanged(0, this.f374745o);
            this.f374742l.add(tBSOneCallback);
        }
        a(bundle);
    }

    private void a(final Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        String str = this.f374732b.f375049b;
        String str2 = this.f374731a;
        if (this.f374734d) {
            g.a("[%s] {%s} [ComponentLoader].start Have started loading component", str, str2);
            return;
        }
        g.a("[%s] {%s} [ComponentLoader].start Loading DEPS", str, str2);
        this.f374734d = true;
        this.f374735e = false;
        if (bundle.containsKey("deps")) {
            g.a("[%s] {%s} [ComponentLoader] Options contains DEPS_CONFIG", str, str2);
            com.tencent.tbs.one.impl.common.d dVar = (com.tencent.tbs.one.impl.common.d) bundle.getSerializable("deps");
            if (dVar != null) {
                a(bundle, dVar);
                return;
            }
            return;
        }
        final h hVar = this.f374732b;
        com.tencent.tbs.one.impl.common.c<com.tencent.tbs.one.impl.common.d> cVar = new com.tencent.tbs.one.impl.common.c<com.tencent.tbs.one.impl.common.d>() { // from class: com.tencent.tbs.one.impl.c.b.1
            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
            public final /* bridge */ /* synthetic */ void a(Object obj) {
                b.this.a(bundle, (com.tencent.tbs.one.impl.common.d) obj);
            }

            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
            public final void a(int i3, int i16) {
                b.this.a(i16, 0, 20);
            }

            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
            public final void a(int i3, String str3, Throwable th5) {
                b.this.b(i3, str3, th5);
            }
        };
        String str3 = hVar.f375049b;
        g.a("[%s] [PolicyManager] Loading DEPS", str3);
        com.tencent.tbs.one.impl.common.d dVar2 = hVar.f375062o;
        if (dVar2 != null) {
            g.a("[%s] [PolicyManager] DEPS has been loaded %d", str3, Integer.valueOf(dVar2.f374824b));
            cVar.a(hVar.f375062o);
        } else {
            if (hVar.f375063p == null) {
                hVar.f375063p = new com.tencent.tbs.one.impl.a.b<com.tencent.tbs.one.impl.common.d>() { // from class: com.tencent.tbs.one.impl.e.h.1

                    /* renamed from: b */
                    final /* synthetic */ Bundle f375064b;

                    public AnonymousClass1(final Bundle bundle2) {
                        r2 = bundle2;
                    }

                    @Override // com.tencent.tbs.one.impl.a.b
                    public final void a() {
                        h.this.a(r2, new com.tencent.tbs.one.impl.common.c<e<com.tencent.tbs.one.impl.common.d>>() { // from class: com.tencent.tbs.one.impl.e.h.1.1
                            C98941() {
                            }

                            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                            public final /* bridge */ /* synthetic */ void a(Object obj) {
                                e<com.tencent.tbs.one.impl.common.d> eVar = (e) obj;
                                h hVar2 = h.this;
                                hVar2.f375063p = null;
                                hVar2.a(eVar);
                                AnonymousClass1.this.a((AnonymousClass1) eVar.f375021b);
                            }

                            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                            public final void a(int i3, int i16) {
                                AnonymousClass1.this.a(i16);
                            }

                            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                            public final void a(int i3, String str4, Throwable th5) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                h.this.f375063p = null;
                                anonymousClass1.a(i3, str4, th5);
                            }
                        });
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.tbs.one.impl.e.h$1$1 */
                    /* loaded from: classes26.dex */
                    final class C98941 extends com.tencent.tbs.one.impl.common.c<e<com.tencent.tbs.one.impl.common.d>> {
                        C98941() {
                        }

                        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                        public final /* bridge */ /* synthetic */ void a(Object obj) {
                            e<com.tencent.tbs.one.impl.common.d> eVar = (e) obj;
                            h hVar2 = h.this;
                            hVar2.f375063p = null;
                            hVar2.a(eVar);
                            AnonymousClass1.this.a((AnonymousClass1) eVar.f375021b);
                        }

                        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                        public final void a(int i3, int i16) {
                            AnonymousClass1.this.a(i16);
                        }

                        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                        public final void a(int i3, String str4, Throwable th5) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            h.this.f375063p = null;
                            anonymousClass1.a(i3, str4, th5);
                        }
                    }
                };
            }
            g.a("[%s] [PolicyManager] Start DEPS Installation Job", str3);
            hVar.f375063p.a(cVar);
        }
    }

    public final void b() {
        String[] strArr;
        com.tencent.tbs.one.impl.a.b bVar;
        this.f374735e = true;
        WeakReference<com.tencent.tbs.one.impl.a.b> weakReference = this.f374741k;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.b();
        }
        d.a aVar = this.f374736f;
        if (aVar == null || (strArr = aVar.f374831f) == null) {
            return;
        }
        for (String str : strArr) {
            this.f374732b.d(str);
        }
    }

    private String b(String str) {
        String shouldOverrideLibrarySearchPath;
        String join = TextUtils.join(File.pathSeparator, d());
        g.a("[%s] {%s} [ComponentLoader].getLibrarySearchPath Collected librarySearchPath %s", this.f374732b.f375049b, this.f374731a, join);
        h hVar = this.f374732b;
        TBSOneDelegate tBSOneDelegate = hVar.f375061n;
        return (tBSOneDelegate == null || (shouldOverrideLibrarySearchPath = tBSOneDelegate.shouldOverrideLibrarySearchPath(hVar.f375049b, this.f374731a, this.f374736f.f374828c, str, join)) == null) ? join : shouldOverrideLibrarySearchPath;
    }

    protected final void b(int i3, String str, Throwable th5) {
        boolean z16 = this.f374732b.f375056i;
        g.c("[%s] {%s} [ComponentLoader].failImpl Failed to install or load component, error: [%d] %s, needUpdate: " + z16, this.f374732b.f375049b, this.f374731a, Integer.valueOf(i3), str, th5);
        if (z16) {
            com.tencent.tbs.one.impl.common.d dVar = this.f374732b.f375062o;
            int i16 = dVar != null ? dVar.f374824b : -1;
            d.a aVar = this.f374736f;
            h.a d16 = com.tencent.tbs.one.impl.common.h.b("TBSOneError", i3).g(i16).c(this.f374731a).d(aVar != null ? aVar.f374828c : -1);
            com.tencent.tbs.one.impl.e.h hVar = this.f374732b;
            h.a b16 = d16.b(f.a(hVar.f375048a, hVar.f375049b, this.f374731a));
            com.tencent.tbs.one.impl.e.h hVar2 = this.f374732b;
            b16.g(f.a(hVar2.f375048a, hVar2.f375049b)).a();
            com.tencent.tbs.one.impl.e.h hVar3 = this.f374732b;
            hVar3.f375059l = true;
            hVar3.f375060m = true;
            hVar3.e();
        }
        this.f374737g = i3;
        this.f374738h = str;
        this.f374736f = null;
        this.f374743m = null;
        this.f374739i = null;
        this.f374740j = null;
        this.f374745o = 0;
        this.f374734d = false;
        TBSOneCallback[] tBSOneCallbackArr = (TBSOneCallback[]) this.f374742l.toArray(new TBSOneCallback[0]);
        this.f374742l.clear();
        TBSOneCallback[] tBSOneCallbackArr2 = (TBSOneCallback[]) this.f374733c.toArray(new TBSOneCallback[0]);
        this.f374733c.clear();
        for (TBSOneCallback tBSOneCallback : tBSOneCallbackArr) {
            tBSOneCallback.onError(i3, str);
        }
        for (TBSOneCallback tBSOneCallback2 : tBSOneCallbackArr2) {
            tBSOneCallback2.onError(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle, com.tencent.tbs.one.impl.common.d dVar) {
        int i3 = 0;
        g.a("[ComponentLoader].onDEPSLoaded start", new Object[0]);
        if (this.f374735e) {
            b(104, "Aborted", null);
            return;
        }
        a(20);
        String str = this.f374732b.f375049b;
        int i16 = dVar.f374824b;
        String str2 = this.f374731a;
        d.a b16 = dVar.b(str2);
        if (b16 == null) {
            b(309, "Failed to get info for component " + str2, null);
            return;
        }
        String[] strArr = b16.f374831f;
        float f16 = 1.0f;
        if (strArr != null) {
            for (String str3 : strArr) {
                if (dVar.b(str3) == null) {
                    b(310, "Failed to get info for dependency " + str3, null);
                    return;
                }
            }
            f16 = 1.0f / (strArr.length + 1);
        }
        float f17 = f16;
        this.f374736f = b16;
        this.f374746p = 0;
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = strArr == null ? "" : TextUtils.join(", ", strArr);
        g.a("[%s] {%s} [ComponentLoader].onDEPSLoaded Installing component and dependencies [%s]", objArr);
        com.tencent.tbs.one.impl.a.a.a aVar = new com.tencent.tbs.one.impl.a.a.a();
        aVar.b(new AnonymousClass2(bundle, b16, f17, str, str2));
        com.tencent.tbs.one.impl.e.h hVar = this.f374732b;
        if (strArr != null) {
            int length = strArr.length;
            while (i3 < length) {
                aVar.b(new AnonymousClass3(hVar, bundle, strArr[i3], f17, str, str2));
                i3++;
                strArr = strArr;
            }
        }
        com.tencent.tbs.one.impl.a.a.e eVar = new com.tencent.tbs.one.impl.a.a.e(AsyncTask.THREAD_POOL_EXECUTOR);
        eVar.f374545a = this;
        eVar.a(aVar);
    }

    @Override // com.tencent.tbs.one.impl.a.a.d.a
    public final void a(final int i3, final String str, final Throwable th5) {
        g.c("[ComponentLoader].onError errorCode is " + i3, new Object[0]);
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.c.b.4
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b(i3, str, th5);
            }
        });
    }

    @Override // com.tencent.tbs.one.impl.a.a.d.a
    public final void a() {
        final String str = this.f374731a;
        g.a("[%s] {%s} [ComponentLoader].onFinished Finished installing component and dependencies", this.f374732b.f375049b, str);
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.c.b.5
            @Override // java.lang.Runnable
            public final void run() {
                int i3;
                b bVar = b.this;
                if (bVar.f374736f != null) {
                    bVar.a(90);
                    b bVar2 = b.this;
                    b.this.a(bVar2.f374732b.a(str, bVar2.f374736f.f374828c));
                    if (b.this.f374733c.size() > 0) {
                        b.this.c();
                        return;
                    }
                    return;
                }
                g.c("[%s] {%s} Unknown error, finished installing component and dependencies but config is null, last error: [%d] %s", bVar.f374732b.f375049b, bVar.f374731a, Integer.valueOf(bVar.f374737g), b.this.f374738h);
                com.tencent.tbs.one.impl.common.d dVar = b.this.f374732b.f375062o;
                if (dVar != null) {
                    i3 = dVar.f374824b;
                } else {
                    i3 = -1;
                }
                com.tencent.tbs.one.impl.common.h.b("TBSOneError", 101).g(i3).c(b.this.f374731a).a();
                g.c("ComponentConfig is null, last error: [" + b.this.f374737g + "] " + b.this.f374738h, new Object[0]);
            }
        });
    }

    private File a(String str) {
        String shouldOverrideFilePath;
        com.tencent.tbs.one.impl.e.h hVar = this.f374732b;
        TBSOneDelegate tBSOneDelegate = hVar.f375061n;
        if (tBSOneDelegate != null && (shouldOverrideFilePath = tBSOneDelegate.shouldOverrideFilePath(hVar.f375049b, this.f374731a, this.f374736f.f374828c, str)) != null) {
            return new File(shouldOverrideFilePath);
        }
        File file = new File(this.f374739i, str);
        if (!file.exists()) {
            g.b("Failed to find component file %s in installation directory", file.getAbsolutePath());
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ClassLoader a(Context context, String[] strArr) throws TBSOneException {
        Object obj;
        ClassLoader classLoader;
        boolean z16;
        boolean z17;
        TBSOneDelegate tBSOneDelegate;
        ClassLoader classLoader2;
        String str = this.f374732b.f375049b;
        String str2 = this.f374731a;
        Map<String, ClassLoader> map = this.f374744n;
        if (map != null && (classLoader2 = map.get(strArr[0])) != null) {
            g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader Reusing class loader %s %s", str, str2, strArr, classLoader2);
            return classLoader2;
        }
        File[] fileArr = new File[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            fileArr[i3] = a(strArr[i3]);
        }
        File file = fileArr[0];
        if (!file.exists()) {
            com.tencent.tbs.one.impl.c.a.d.a(fileArr, false);
            if (!fileArr[0].exists()) {
                throw new TBSOneException(105, "[ComponentLoader].getOrCreateClassLoader Failed to find dex file " + file.getAbsolutePath());
            }
        }
        g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader Creating class loader %s from %s", str, str2, strArr, file.getAbsolutePath());
        if (this.f374743m == null) {
            File a16 = a("MANIFEST");
            if (a16.exists()) {
                g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader Initializing component according to MANIFEST file %s", str, str2, a16.getAbsolutePath());
                try {
                    this.f374743m = e.a(a16);
                } catch (TBSOneException e16) {
                    b(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                    return null;
                }
            }
        }
        e eVar = this.f374743m;
        e.a a17 = eVar == null ? null : eVar.a(strArr[0]);
        com.tencent.tbs.one.impl.e.h hVar = this.f374732b;
        String str3 = this.f374731a + "." + TBSOneConfigurationKeys.PARENT_CLASSLOADER;
        if (hVar.f375052e.containsKey(str3)) {
            obj = hVar.f375052e.get(str3);
        } else {
            obj = hVar.f375052e.containsKey(TBSOneConfigurationKeys.PARENT_CLASSLOADER) ? hVar.f375052e.get(TBSOneConfigurationKeys.PARENT_CLASSLOADER) : null;
        }
        if (obj instanceof ClassLoader) {
            classLoader = (ClassLoader) obj;
        } else {
            e.b bVar = a17 == null ? null : a17.f374844d;
            if (bVar != null) {
                String str4 = bVar.f374846a;
                String[] strArr2 = {bVar.f374847b};
                if (TextUtils.isEmpty(str4)) {
                    classLoader = a(context, strArr2);
                } else {
                    b e17 = this.f374732b.e(str4);
                    if (e17 != null) {
                        classLoader = e17.a(context, strArr2);
                    } else {
                        throw new TBSOneException(404, "[ComponentLoader].getOrCreateClassLoader Failed to get loaded dependency " + str4);
                    }
                }
            } else {
                classLoader = this.f374732b.f375048a.getClassLoader();
            }
        }
        ClassLoader classLoader3 = classLoader;
        String b16 = b(file.getAbsolutePath());
        boolean a18 = this.f374732b.a(str2, TBSOneConfigurationKeys.DISABLE_SEALED_CLASSLOADER, false);
        g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader isSealedClassLoaderDisabled [%s] by Configuration", str, str2, Boolean.valueOf(a18));
        boolean a19 = this.f374732b.a(str2, TBSOneConfigurationKeys.ENABLE_DEX_SOFT_LINK, true);
        g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader isDexSoftLinkEnabled [%s] by Configuration", str, str2, Boolean.valueOf(a19));
        e eVar2 = this.f374743m;
        if (eVar2 != null) {
            if (eVar2.f374839h && Build.VERSION.SDK_INT >= 29) {
                g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader isSealedClassLoaderDisabled set true by manifest", str, str2);
                a18 = true;
            }
            int i16 = Build.VERSION.SDK_INT;
            if ((i16 == 31 || i16 == 32) && a19 && this.f374743m.f374840i) {
                g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader isDexSoftLinkEnabled set false by manifest", str, str2);
                z17 = a18;
                z16 = false;
                boolean a26 = this.f374732b.a(str2, TBSOneConfigurationKeys.ENABLE_ASYNC_DEX_OPTIMIZATION, false);
                long currentTimeMillis = System.currentTimeMillis();
                ClassLoader a27 = com.tencent.tbs.one.impl.c.a.d.a(context, fileArr, this.f374739i.getAbsolutePath(), b16, classLoader3, z17, a17 != null ? null : a17.f374843c, a26, z16);
                g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader Created dex class loader %s %s cost %dms", str, str2, strArr, a27, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (this.f374744n == null) {
                    this.f374744n = new HashMap();
                }
                this.f374744n.put(strArr[0], a27);
                tBSOneDelegate = this.f374732b.f375061n;
                if (tBSOneDelegate != null) {
                    tBSOneDelegate.onDexLoaded(str, str2, this.f374736f.f374828c, file.getAbsolutePath(), a27);
                }
                return a27;
            }
        }
        z16 = a19;
        z17 = a18;
        boolean a262 = this.f374732b.a(str2, TBSOneConfigurationKeys.ENABLE_ASYNC_DEX_OPTIMIZATION, false);
        long currentTimeMillis2 = System.currentTimeMillis();
        ClassLoader a272 = com.tencent.tbs.one.impl.c.a.d.a(context, fileArr, this.f374739i.getAbsolutePath(), b16, classLoader3, z17, a17 != null ? null : a17.f374843c, a262, z16);
        g.a("[%s] {%s} [ComponentLoader].getOrCreateClassLoader Created dex class loader %s %s cost %dms", str, str2, strArr, a272, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        if (this.f374744n == null) {
        }
        this.f374744n.put(strArr[0], a272);
        tBSOneDelegate = this.f374732b.f375061n;
        if (tBSOneDelegate != null) {
        }
        return a272;
    }

    public final void a(int i3, int i16, int i17) {
        a((int) (i16 + ((Math.min(Math.max(0, i3), 100) / 100.0f) * (i17 - i16))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        g.a("[%s] {%s} Updating progress %d to %d", this.f374732b.f375049b, this.f374731a, Integer.valueOf(this.f374745o), Integer.valueOf(i3));
        int i16 = this.f374745o;
        if (i3 - i16 > 2) {
            this.f374745o = i3;
            TBSOneCallback[] tBSOneCallbackArr = (TBSOneCallback[]) this.f374742l.toArray(new TBSOneCallback[0]);
            TBSOneCallback[] tBSOneCallbackArr2 = (TBSOneCallback[]) this.f374733c.toArray(new TBSOneCallback[0]);
            for (TBSOneCallback tBSOneCallback : tBSOneCallbackArr) {
                tBSOneCallback.onProgressChanged(i16, i3);
            }
            for (TBSOneCallback tBSOneCallback2 : tBSOneCallbackArr2) {
                tBSOneCallback2.onProgressChanged(i16, i3);
            }
        }
    }

    protected final void a(File file) {
        g.a("[%s] {%s} [ComponentLoader].finishInstallation Finished installing component at %s", this.f374732b.f375049b, this.f374731a, file.getAbsolutePath());
        this.f374739i = file;
        TBSOneCallback[] tBSOneCallbackArr = (TBSOneCallback[]) this.f374742l.toArray(new TBSOneCallback[0]);
        this.f374742l.clear();
        for (TBSOneCallback tBSOneCallback : tBSOneCallbackArr) {
            tBSOneCallback.onProgressChanged(this.f374745o, 100);
            tBSOneCallback.onCompleted(file);
        }
    }

    private void a(a aVar) {
        g.a("[%s] {%s} [ComponentLoader].finishLoading Finished loading component %s", this.f374732b.f375049b, this.f374731a, aVar);
        this.f374740j = aVar;
        int i3 = this.f374745o;
        this.f374745o = 100;
        TBSOneCallback[] tBSOneCallbackArr = (TBSOneCallback[]) this.f374733c.toArray(new TBSOneCallback[0]);
        this.f374733c.clear();
        for (TBSOneCallback tBSOneCallback : tBSOneCallbackArr) {
            tBSOneCallback.onProgressChanged(i3, 100);
            tBSOneCallback.onCompleted(aVar);
        }
    }

    static /* synthetic */ void a(b bVar, final int i3, final int i16, final float f16) {
        if (!o.e()) {
            o.d(new Runnable() { // from class: com.tencent.tbs.one.impl.c.b.6
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(b.this, i3, i16, f16);
                }
            });
            return;
        }
        int min = Math.min(Math.max(0, i3), 100);
        int min2 = (int) (bVar.f374746p + ((Math.min(Math.max(0, i16), 100) - min) * f16));
        String str = bVar.f374732b.f375049b;
        bVar.f374746p = min2;
        bVar.a(min2, 20, 90);
    }
}
