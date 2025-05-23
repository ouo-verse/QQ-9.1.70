package org.extra.relinker;

import android.content.Context;
import android.util.Log;
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
import org.extra.relinker.c;
import org.extra.relinker.elf.i;

/* compiled from: P */
/* loaded from: classes29.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    protected final Set f423558a;

    /* renamed from: b, reason: collision with root package name */
    protected final c.b f423559b;

    /* renamed from: c, reason: collision with root package name */
    protected final c.a f423560c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f423561d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f423562e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f423563a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f423564b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f423565c;

        a(Context context, String str, String str2, c.InterfaceC10938c interfaceC10938c) {
            this.f423563a = context;
            this.f423564b = str;
            this.f423565c = str2;
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
                d.this.c(this.f423563a, this.f423564b, this.f423565c);
                throw null;
            } catch (UnsatisfiedLinkError unused) {
                throw null;
            } catch (org.extra.relinker.b unused2) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class b implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f423567a;

        b(String str) {
            this.f423567a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f423567a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this(new e(), new org.extra.relinker.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, String str2) {
        i iVar;
        if (this.f423558a.contains(str) && !this.f423561d) {
            a("%s already loaded previously!", str);
            return;
        }
        try {
            this.f423559b.a(str);
            this.f423558a.add(str);
            a("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e16) {
            a("Loading the library normally failed: %s", Log.getStackTraceString(e16));
            a("%s (%s) was not loaded normally, re-linking...", str, str2);
            File b16 = b(context, str, str2);
            if (!b16.exists() || this.f423561d) {
                if (this.f423561d) {
                    a("Forcing a re-link of %s (%s)...", str, str2);
                }
                a(context, str, str2);
                this.f423560c.a(context, this.f423559b.a(), this.f423559b.d(str), b16, this);
            }
            try {
                if (this.f423562e) {
                    try {
                        iVar = new i(b16);
                    } catch (Throwable th5) {
                        th = th5;
                        iVar = null;
                    }
                    try {
                        List b17 = iVar.b();
                        iVar.close();
                        Iterator it = b17.iterator();
                        while (it.hasNext()) {
                            a(context, this.f423559b.b((String) it.next()));
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        iVar.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f423559b.c(b16.getAbsolutePath());
            this.f423558a.add(str);
            a("%s (%s) was re-linked!", str, str2);
        }
    }

    public void a(String str) {
    }

    protected File b(Context context, String str, String str2) {
        String d16 = this.f423559b.d(str);
        if (f.a(str2)) {
            return new File(a(context), d16);
        }
        return new File(a(context), d16 + "." + str2);
    }

    protected d(c.b bVar, c.a aVar) {
        this.f423558a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar != null) {
            this.f423559b = bVar;
            this.f423560c = aVar;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null library installer");
    }

    public void a(Context context, String str) {
        a(context, str, (String) null, (c.InterfaceC10938c) null);
    }

    public void a(Context context, String str, String str2, c.InterfaceC10938c interfaceC10938c) {
        if (context != null) {
            if (!f.a(str)) {
                a("Beginning load of %s...", str);
                if (interfaceC10938c == null) {
                    c(context, str, str2);
                    return;
                }
                try {
                    new BaseThread(new a(context, str, str2, interfaceC10938c)).start();
                    return;
                } catch (Error | Exception e16) {
                    interfaceC10938c.a(e16);
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    protected File a(Context context) {
        return context.getDir(RFixConstants.SO_PATH, 0);
    }

    protected void a(Context context, String str, String str2) {
        File a16 = a(context);
        File b16 = b(context, str, str2);
        File[] listFiles = a16.listFiles(new b(this.f423559b.d(str)));
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.f423561d || !file.getAbsolutePath().equals(b16.getAbsolutePath())) {
                try {
                    file.delete();
                } catch (SecurityException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void a(String str, Object... objArr) {
        a(String.format(Locale.US, str, objArr));
    }
}
