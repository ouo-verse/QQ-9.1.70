package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    public static final long f97942a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    private static ac f97943b;

    /* renamed from: c, reason: collision with root package name */
    private Context f97944c;

    /* renamed from: f, reason: collision with root package name */
    private SharedPreferences f97947f;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Map<String, ab>> f97946e = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private String f97945d = ai.c().f98016d;

    ac(Context context) {
        this.f97944c = context;
        this.f97947f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends List<?>> T d(int i3) {
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.f97944c.getDir("crashrecord", 0), String.valueOf(i3));
            ?? exists = file.exists();
            try {
                if (exists == 0) {
                    return null;
                }
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                } catch (IOException unused) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused2) {
                    objectInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    exists = 0;
                    if (exists != 0) {
                        exists.close();
                    }
                    throw th;
                }
                try {
                    T t16 = (T) objectInputStream.readObject();
                    objectInputStream.close();
                    return t16;
                } catch (IOException unused3) {
                    av.a("open record file error", new Object[0]);
                } catch (ClassNotFoundException unused4) {
                    av.a("get object error", new Object[0]);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception unused5) {
            av.e("readCrashRecord error", new Object[0]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean c(int i3) {
        try {
            List<ab> d16 = d(i3);
            if (d16 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (ab abVar : d16) {
                String str = abVar.f97936b;
                if (str != null && str.equalsIgnoreCase(this.f97945d) && abVar.f97938d > 0) {
                    arrayList.add(abVar);
                }
                if (abVar.f97937c + 86400000 < currentTimeMillis) {
                    arrayList2.add(abVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((ab) arrayList.get(arrayList.size() - 1)).f97937c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                d16.clear();
                a(i3, (int) d16);
                return false;
            }
            d16.removeAll(arrayList2);
            a(i3, (int) d16);
            return false;
        } catch (Exception unused) {
            av.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final synchronized boolean b(final int i3) {
        boolean z16;
        z16 = true;
        try {
            z16 = this.f97947f.getBoolean(i3 + "_" + this.f97945d, true);
            at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.ac.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean c16 = ac.this.c(i3);
                    ac.this.f97947f.edit().putBoolean(i3 + "_" + ac.this.f97945d, !c16).commit();
                }
            });
        } catch (Exception unused) {
            av.e("canInit error", new Object[0]);
            return z16;
        }
        return z16;
    }

    public static synchronized ac a(Context context) {
        ac acVar;
        synchronized (ac.class) {
            if (f97943b == null) {
                f97943b = new ac(context);
            }
            acVar = f97943b;
        }
        return acVar;
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            acVar = f97943b;
        }
        return acVar;
    }

    static /* synthetic */ boolean b(ab abVar, ab abVar2) {
        String str = abVar.f97939e;
        if (str != null && !str.equalsIgnoreCase(abVar2.f97939e)) {
            return true;
        }
        String str2 = abVar.f97940f;
        return !(str2 == null || str2.equalsIgnoreCase(abVar2.f97940f)) || abVar.f97938d <= 0;
    }

    public final void a(final int i3) {
        at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.ac.1

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f97948a = 1004;

            @Override // java.lang.Runnable
            public final void run() {
                ab abVar;
                try {
                    if (!TextUtils.isEmpty(ac.this.f97945d)) {
                        List<ab> d16 = ac.this.d(this.f97948a);
                        if (d16 == null) {
                            d16 = new ArrayList();
                        }
                        if (ac.this.f97946e.get(Integer.valueOf(this.f97948a)) == null) {
                            ac.this.f97946e.put(Integer.valueOf(this.f97948a), new HashMap());
                        }
                        if (((Map) ac.this.f97946e.get(Integer.valueOf(this.f97948a))).get(ac.this.f97945d) == null) {
                            abVar = new ab();
                            abVar.f97935a = this.f97948a;
                            abVar.f97941g = ac.f97942a;
                            abVar.f97936b = ac.this.f97945d;
                            abVar.f97940f = ai.c().f98032t;
                            abVar.f97939e = ai.c().f98020h;
                            abVar.f97937c = System.currentTimeMillis();
                            abVar.f97938d = i3;
                            ((Map) ac.this.f97946e.get(Integer.valueOf(this.f97948a))).put(ac.this.f97945d, abVar);
                        } else {
                            abVar = (ab) ((Map) ac.this.f97946e.get(Integer.valueOf(this.f97948a))).get(ac.this.f97945d);
                            abVar.f97938d = i3;
                        }
                        ArrayList arrayList = new ArrayList();
                        boolean z16 = false;
                        for (ab abVar2 : d16) {
                            if (ac.a(abVar2, abVar)) {
                                abVar2.f97938d = abVar.f97938d;
                                z16 = true;
                            }
                            if (ac.b(abVar2, abVar)) {
                                arrayList.add(abVar2);
                            }
                        }
                        d16.removeAll(arrayList);
                        if (!z16) {
                            d16.add(abVar);
                        }
                        ac.this.a(this.f97948a, (int) d16);
                    }
                } catch (Exception unused) {
                    av.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004b A[Catch: all -> 0x004f, Exception -> 0x0051, TRY_ENTER, TryCatch #4 {Exception -> 0x0051, blocks: (B:9:0x0006, B:15:0x0026, B:22:0x0041, B:30:0x004b, B:31:0x004e), top: B:8:0x0006, outer: #5 }] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends List<?>> void a(int i3, T t16) {
        Throwable th5;
        ObjectOutputStream objectOutputStream;
        IOException e16;
        if (t16 == null) {
            return;
        }
        try {
            ObjectOutputStream dir = this.f97944c.getDir("crashrecord", 0);
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File((File) dir, String.valueOf(i3))));
                } catch (IOException e17) {
                    objectOutputStream = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    dir = 0;
                    th5 = th6;
                    if (dir != 0) {
                    }
                    throw th5;
                }
                try {
                    objectOutputStream.writeObject(t16);
                    objectOutputStream.close();
                } catch (IOException e18) {
                    e16 = e18;
                    e16.printStackTrace();
                    av.a("open record file error", new Object[0]);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (dir != 0) {
                    dir.close();
                }
                throw th5;
            }
        } catch (Exception unused) {
            av.e("writeCrashRecord error", new Object[0]);
        }
    }

    static /* synthetic */ boolean a(ab abVar, ab abVar2) {
        String str;
        return abVar.f97941g == abVar2.f97941g && (str = abVar.f97936b) != null && str.equalsIgnoreCase(abVar2.f97936b);
    }
}
