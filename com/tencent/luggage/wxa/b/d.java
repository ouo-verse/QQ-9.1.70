package com.tencent.luggage.wxa.b;

import android.content.Context;
import android.util.Log;
import com.tencent.luggage.wxa.b.c;
import com.tencent.luggage.wxa.c.i;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Set f121802a;

    /* renamed from: b, reason: collision with root package name */
    public final c.b f121803b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a f121804c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f121805d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f121806e;

    /* renamed from: f, reason: collision with root package name */
    public c.d f121807f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f121808a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f121809b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f121810c;

        public a(Context context, String str, String str2, c.InterfaceC6025c interfaceC6025c) {
            this.f121808a = context;
            this.f121809b = str;
            this.f121810c = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                d.this.c(this.f121808a, this.f121809b, this.f121810c);
                throw null;
            } catch (com.tencent.luggage.wxa.b.b unused) {
                throw null;
            } catch (UnsatisfiedLinkError unused2) {
                throw null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f121812a;

        public b(String str) {
            this.f121812a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f121812a);
        }
    }

    public d() {
        this(new e(), new com.tencent.luggage.wxa.b.a());
    }

    public File b(Context context, String str, String str2) {
        String a16 = this.f121803b.a(str);
        if (f.a(str2)) {
            return new File(a(context), a16);
        }
        return new File(a(context), a16 + "." + str2);
    }

    public final void c(Context context, String str, String str2) {
        i iVar;
        if (this.f121802a.contains(str) && !this.f121805d) {
            a("%s already loaded previously!", str);
            return;
        }
        try {
            this.f121803b.loadLibrary(str);
            this.f121802a.add(str);
            a("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e16) {
            a("Loading the library normally failed: %s", Log.getStackTraceString(e16));
            a("%s (%s) was not loaded normally, re-linking...", str, str2);
            File b16 = b(context, str, str2);
            if (!b16.exists() || this.f121805d) {
                if (this.f121805d) {
                    a("Forcing a re-link of %s (%s)...", str, str2);
                }
                a(context, str, str2);
                this.f121804c.a(context, this.f121803b.a(), this.f121803b.a(str), b16, this);
            }
            try {
                if (this.f121806e) {
                    try {
                        iVar = new i(b16);
                    } catch (Throwable th5) {
                        th = th5;
                        iVar = null;
                    }
                    try {
                        List d16 = iVar.d();
                        iVar.close();
                        Iterator it = d16.iterator();
                        while (it.hasNext()) {
                            a(context, this.f121803b.b((String) it.next()));
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        iVar.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f121803b.c(b16.getAbsolutePath());
            this.f121802a.add(str);
            a("%s (%s) was re-linked!", str, str2);
        }
    }

    public d(c.b bVar, c.a aVar) {
        this.f121802a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar != null) {
            this.f121803b = bVar;
            this.f121804c = aVar;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null library installer");
    }

    public d a(c.d dVar) {
        this.f121807f = dVar;
        return this;
    }

    public void a(Context context, String str) {
        a(context, str, (String) null, (c.InterfaceC6025c) null);
    }

    public void a(Context context, String str, String str2, c.InterfaceC6025c interfaceC6025c) {
        if (context != null) {
            if (!f.a(str)) {
                a("Beginning load of %s...", str);
                if (interfaceC6025c == null) {
                    c(context, str, str2);
                    return;
                } else {
                    new BaseThread(new a(context, str, str2, interfaceC6025c)).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    public File a(Context context) {
        return context.getDir(RFixConstants.SO_PATH, 0);
    }

    public void a(Context context, String str, String str2) {
        File a16 = a(context);
        File b16 = b(context, str, str2);
        File[] listFiles = a16.listFiles(new b(this.f121803b.a(str)));
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.f121805d || !file.getAbsolutePath().equals(b16.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public void a(String str, Object... objArr) {
        a(String.format(Locale.US, str, objArr));
    }

    public void a(String str) {
        c.d dVar = this.f121807f;
        if (dVar != null) {
            dVar.a(str);
        }
    }
}
