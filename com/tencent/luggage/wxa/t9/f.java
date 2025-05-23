package com.tencent.luggage.wxa.t9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    public static f f141047e;

    /* renamed from: a, reason: collision with root package name */
    public Map f141048a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f141049b;

    /* renamed from: c, reason: collision with root package name */
    public String f141050c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f141051d = false;

    public f(String str) {
        this.f141049b = false;
        this.f141050c = str;
        c();
        this.f141049b = false;
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f141047e == null) {
                f141047e = new f(com.tencent.luggage.wxa.db.a.a() + "CompatibleInfo.cfg");
            }
            fVar = f141047e;
        }
        return fVar;
    }

    public boolean b() {
        return this.f141051d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        ObjectInputStream objectInputStream;
        ?? r56;
        ObjectInputStream objectInputStream2;
        ObjectInputStream objectInputStream3;
        ObjectInputStream objectInputStream4 = null;
        try {
            File file = new File(this.f141050c);
            if (!file.exists()) {
                this.f141051d = true;
                file.createNewFile();
            }
            if (file.length() == 0) {
                this.f141051d = true;
                this.f141048a = new HashMap();
                return;
            }
            r56 = new BufferedInputStream(new FileInputStream(file));
            try {
                objectInputStream3 = new ObjectInputStream(r56);
            } catch (Exception e16) {
                e = e16;
                objectInputStream = null;
                objectInputStream4 = r56;
            } catch (Throwable th5) {
                th = th5;
                if (r56 != 0) {
                }
                if (objectInputStream4 == null) {
                }
            }
            try {
                this.f141048a = (Map) objectInputStream3.readObject();
                objectInputStream3.close();
                r56.close();
                try {
                    r56.close();
                } catch (IOException e17) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e17, "", new Object[0]);
                }
                try {
                    objectInputStream3.close();
                } catch (IOException e18) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e18, "", new Object[0]);
                }
            } catch (Exception e19) {
                e = e19;
                objectInputStream4 = r56;
                objectInputStream = objectInputStream3;
                try {
                    this.f141048a = new HashMap();
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e, "", new Object[0]);
                    if (objectInputStream4 != null) {
                        try {
                            objectInputStream4.close();
                        } catch (IOException e26) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e26, "", new Object[0]);
                        }
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e27) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e27, "", new Object[0]);
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    objectInputStream2 = objectInputStream;
                    r56 = objectInputStream4;
                    objectInputStream4 = objectInputStream2;
                    if (r56 != 0) {
                        try {
                            r56.close();
                        } catch (IOException e28) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e28, "", new Object[0]);
                        }
                    }
                    if (objectInputStream4 == null) {
                        try {
                            objectInputStream4.close();
                            throw th;
                        } catch (IOException e29) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e29, "", new Object[0]);
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                objectInputStream2 = objectInputStream3;
                th = th7;
                r56 = r56;
                objectInputStream4 = objectInputStream2;
                if (r56 != 0) {
                }
                if (objectInputStream4 == null) {
                }
            }
        } catch (Exception e36) {
            e = e36;
            objectInputStream = null;
        } catch (Throwable th8) {
            th = th8;
            objectInputStream = null;
            objectInputStream2 = objectInputStream;
            r56 = objectInputStream4;
            objectInputStream4 = objectInputStream2;
            if (r56 != 0) {
            }
            if (objectInputStream4 == null) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[Catch: all -> 0x0097, SYNTHETIC, TRY_LEAVE, TryCatch #12 {, blocks: (B:11:0x0022, B:13:0x0032, B:19:0x0037, B:22:0x0027, B:55:0x0093, B:47:0x00a7, B:52:0x00b7, B:51:0x00ac, B:58:0x009a, B:36:0x0066, B:31:0x0078, B:34:0x007d, B:39:0x006b), top: B:3:0x0003, inners: #0, #3, #6, #8, #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void d() {
        ObjectOutputStream objectOutputStream;
        Throwable th5;
        ?? r26;
        Throwable th6;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            r26 = new BufferedOutputStream(new FileOutputStream(this.f141050c));
            try {
                objectOutputStream = new ObjectOutputStream(r26);
            } catch (IOException e16) {
                objectOutputStream = null;
                objectOutputStream2 = r26;
                e = e16;
            } catch (Throwable th7) {
                th6 = th7;
                if (r26 != 0) {
                }
                if (objectOutputStream2 != null) {
                }
            }
            try {
                objectOutputStream.writeObject(this.f141048a);
                objectOutputStream.close();
                r26.flush();
                r26.close();
                try {
                    r26.close();
                } catch (IOException e17) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e17, "", new Object[0]);
                }
                try {
                    objectOutputStream.close();
                } catch (IOException e18) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e18, "", new Object[0]);
                }
            } catch (IOException e19) {
                e = e19;
                objectOutputStream2 = r26;
                try {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e, "", new Object[0]);
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e26) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e26, "", new Object[0]);
                        }
                    }
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e27) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e27, "", new Object[0]);
                        }
                    }
                } catch (Throwable th8) {
                    r26 = objectOutputStream2;
                    th5 = th8;
                    ObjectOutputStream objectOutputStream3 = objectOutputStream;
                    th6 = th5;
                    objectOutputStream2 = objectOutputStream3;
                    if (r26 != 0) {
                        try {
                            r26.close();
                        } catch (IOException e28) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e28, "", new Object[0]);
                        }
                    }
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                            throw th6;
                        } catch (IOException e29) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.CompatibleFileStorage", e29, "", new Object[0]);
                            throw th6;
                        }
                    }
                    throw th6;
                }
            } catch (Throwable th9) {
                th5 = th9;
                ObjectOutputStream objectOutputStream32 = objectOutputStream;
                th6 = th5;
                objectOutputStream2 = objectOutputStream32;
                if (r26 != 0) {
                }
                if (objectOutputStream2 != null) {
                }
            }
        } catch (IOException e36) {
            e = e36;
            objectOutputStream = null;
        } catch (Throwable th10) {
            objectOutputStream = null;
            th5 = th10;
            r26 = 0;
        }
    }

    public synchronized void a(int i3, Object obj) {
        this.f141048a.put(Integer.valueOf(i3), obj);
        if (!this.f141049b) {
            d();
        }
    }

    public Object a(int i3) {
        return this.f141048a.get(Integer.valueOf(i3));
    }
}
