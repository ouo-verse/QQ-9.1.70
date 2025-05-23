package com.getkeepsafe.relinker;

import android.content.Context;
import android.util.Log;
import com.getkeepsafe.relinker.b;
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
import t0.i;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ReLinkerInstance {

    /* renamed from: a, reason: collision with root package name */
    protected final Set<String> f32843a;

    /* renamed from: b, reason: collision with root package name */
    protected final b.InterfaceC0224b f32844b;

    /* renamed from: c, reason: collision with root package name */
    protected final b.a f32845c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f32846d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f32847e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements FilenameFilter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f32851d;

        a(String str) {
            this.f32851d = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f32851d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReLinkerInstance() {
        this(new c(), new com.getkeepsafe.relinker.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context, String str, String str2) {
        i iVar;
        if (this.f32843a.contains(str) && !this.f32846d) {
            i("%s already loaded previously!", str);
            return;
        }
        try {
            this.f32844b.loadLibrary(str);
            this.f32843a.add(str);
            i("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e16) {
            i("Loading the library normally failed: %s", Log.getStackTraceString(e16));
            i("%s (%s) was not loaded normally, re-linking...", str, str2);
            File d16 = d(context, str, str2);
            if (!d16.exists() || this.f32846d) {
                if (this.f32846d) {
                    i("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.f32845c.a(context, this.f32844b.supportedAbis(), this.f32844b.mapLibraryName(str), d16, this);
            }
            try {
                if (this.f32847e) {
                    i iVar2 = null;
                    try {
                        iVar = new i(d16);
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    try {
                        List<String> e17 = iVar.e();
                        iVar.close();
                        Iterator<String> it = e17.iterator();
                        while (it.hasNext()) {
                            e(context, this.f32844b.unmapLibraryName(it.next()));
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        iVar2 = iVar;
                        iVar2.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f32844b.loadPath(d16.getAbsolutePath());
            this.f32843a.add(str);
            i("%s (%s) was re-linked!", str, str2);
        }
    }

    protected void b(Context context, String str, String str2) {
        File c16 = c(context);
        File d16 = d(context, str, str2);
        File[] listFiles = c16.listFiles(new a(this.f32844b.mapLibraryName(str)));
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.f32846d || !file.getAbsolutePath().equals(d16.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    protected File c(Context context) {
        return context.getDir(RFixConstants.SO_PATH, 0);
    }

    protected File d(Context context, String str, String str2) {
        String mapLibraryName = this.f32844b.mapLibraryName(str);
        if (d.a(str2)) {
            return new File(c(context), mapLibraryName);
        }
        return new File(c(context), mapLibraryName + "." + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, b.c cVar) {
        if (context != null) {
            if (!d.a(str)) {
                i("Beginning load of %s...", str);
                if (cVar == null) {
                    g(context, str, str2);
                    return;
                } else {
                    new BaseThread(new Runnable(context, str, str2, cVar) { // from class: com.getkeepsafe.relinker.ReLinkerInstance.1

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Context f32848d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f32849e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ String f32850f;

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
                                ReLinkerInstance.this.g(this.f32848d, this.f32849e, this.f32850f);
                                throw null;
                            } catch (MissingLibraryException unused) {
                                throw null;
                            } catch (UnsatisfiedLinkError unused2) {
                                throw null;
                            }
                        }
                    }).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    public void i(String str, Object... objArr) {
        h(String.format(Locale.US, str, objArr));
    }

    protected ReLinkerInstance(b.InterfaceC0224b interfaceC0224b, b.a aVar) {
        this.f32843a = new HashSet();
        if (interfaceC0224b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar != null) {
            this.f32844b = interfaceC0224b;
            this.f32845c = aVar;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null library installer");
    }

    public void h(String str) {
    }
}
