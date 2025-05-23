package com.tencent.mobileqq.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class as {

    /* renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, as> f202323e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f202324f = {"flashchat"};

    /* renamed from: a, reason: collision with root package name */
    String f202325a;

    /* renamed from: b, reason: collision with root package name */
    Context f202326b;

    /* renamed from: c, reason: collision with root package name */
    String f202327c;

    /* renamed from: d, reason: collision with root package name */
    File f202328d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a<T> implements m<String, T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f202329a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Serializable f202330b;

        a(String str, Serializable serializable) {
            this.f202329a = str;
            this.f202330b = serializable;
        }

        /* JADX WARN: Incorrect types in method signature: (Ljava/io/File;TT;)Ljava/lang/String; */
        @Override // com.tencent.mobileqq.config.m
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(File file, Serializable serializable) {
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(as.this.b(this.f202329a, ".serial"))));
                        try {
                            objectOutputStream2.writeObject(this.f202330b);
                            objectOutputStream2.flush();
                            objectOutputStream2.close();
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            objectOutputStream = objectOutputStream2;
                            QLog.d("QStorage", 1, "writeSerializable " + this.f202329a, e);
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                                return "";
                            }
                            return "";
                        } catch (NotSerializableException e17) {
                            e = e17;
                            objectOutputStream = objectOutputStream2;
                            QLog.d("QStorage", 1, "writeSerializable " + this.f202329a, e);
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                                return "";
                            }
                            return "";
                        } catch (IOException e18) {
                            e = e18;
                            objectOutputStream = objectOutputStream2;
                            QLog.d("QStorage", 1, "writeSerializable " + this.f202329a, e);
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                                return "";
                            }
                            return "";
                        } catch (Throwable th5) {
                            th = th5;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e19) {
                                    QLog.e("QStorage", 1, "QStorage#writeSerializable, ", e19);
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e26) {
                        e = e26;
                    } catch (NotSerializableException e27) {
                        e = e27;
                    } catch (IOException e28) {
                        e = e28;
                    }
                    return "";
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e29) {
                QLog.e("QStorage", 1, "QStorage#writeSerializable, ", e29);
                return "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b<T> implements m<T, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f202332a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f202333b;

        b(File file, String str) {
            this.f202332a = file;
            this.f202333b = str;
        }

        /* JADX WARN: Incorrect return type in method signature: (Ljava/io/File;Ljava/lang/String;)TT; */
        @Override // com.tencent.mobileqq.config.m
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Serializable a(File file, String str) {
            ObjectInputStream objectInputStream;
            ObjectInputStream objectInputStream2 = null;
            r2 = null;
            r2 = null;
            r2 = null;
            r2 = null;
            Serializable serializable = null;
            try {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.f202332a)));
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        objectInputStream = null;
                    } catch (IOException e17) {
                        e = e17;
                        objectInputStream = null;
                    } catch (ClassNotFoundException e18) {
                        e = e18;
                        objectInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e19) {
                                QLog.e("QStorage", 1, "QStorage#readSerializable, ", e19);
                            }
                        }
                        throw th;
                    }
                    try {
                        Serializable serializable2 = (Serializable) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e26) {
                            QLog.e("QStorage", 1, "QStorage#readSerializable, ", e26);
                        }
                        serializable = serializable2;
                    } catch (FileNotFoundException e27) {
                        e = e27;
                        QLog.d("QStorage", 1, "readSerializable " + this.f202333b, e);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return serializable;
                    } catch (IOException e28) {
                        e = e28;
                        QLog.d("QStorage", 1, "readSerializable " + this.f202333b, e);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return serializable;
                    } catch (ClassNotFoundException e29) {
                        e = e29;
                        QLog.d("QStorage", 1, "readSerializable " + this.f202333b, e);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return serializable;
                    }
                } catch (IOException e36) {
                    QLog.e("QStorage", 1, "QStorage#readSerializable, ", e36);
                }
                return serializable;
            } catch (Throwable th6) {
                th = th6;
                objectInputStream2 = objectInputStream;
            }
        }
    }

    as(Context context, String str, String str2) {
        this.f202325a = str;
        this.f202326b = context;
        this.f202327c = str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f202326b.getFilesDir().getAbsolutePath());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(this.f202327c);
        sb5.append(str3);
        sb5.append("qstorage");
        sb5.append(str3);
        sb5.append("objs");
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f202328d = file;
    }

    public static as a(String str) {
        if (!c(str) && QLog.isColorLevel()) {
            QLog.d("QStorage", 1, "buildQStorage notRegister " + str);
        }
        as asVar = f202323e.get(str);
        if (asVar != null) {
            return asVar;
        }
        synchronized (f202323e) {
            as asVar2 = f202323e.get(str);
            if (asVar2 != null) {
                return asVar2;
            }
            as asVar3 = new as(BaseApplication.getContext(), str, MobileQQ.sMobileQQ.waitAppRuntime().getAccount());
            f202323e.put(str, asVar3);
            return asVar3;
        }
    }

    private static boolean c(String str) {
        for (String str2 : f202324f) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends n<Y>, Y> T e(Y y16, Class<T> cls) throws QStorageInstantiateException {
        T t16 = (T) aj.f(cls);
        if (t16 != null) {
            try {
                t16.onParse(y16);
            } catch (Exception e16) {
                an.b().e(cls, e16);
                throw new QStorageInstantiateException("readJsonOrXml exception too much", e16);
            }
        }
        return t16;
    }

    public File b(String str, String str2) {
        return new File(this.f202328d, str + str2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(4:35|36|4|(5:14|15|16|(1:18)(1:(1:27))|(4:20|(1:22)|23|24)(1:25))(2:11|12))|3|4|(0)|14|15|16|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0032, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0033, code lost:
    
        com.tencent.mobileqq.config.an.b().d(r11, r7, r8);
        r11 = new java.lang.Object[3];
        r11[0] = "readFile, ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0043, code lost:
    
        if (r7 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0045, code lost:
    
        r7 = "null";
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        r11[1] = r7;
        r11[2] = r8;
        com.tencent.qphone.base.util.QLog.d("QStorage", 1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0049, code lost:
    
        r7 = r7.getAbsolutePath();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <JavaBean, Param> JavaBean d(File file, Param param, Class<JavaBean> cls, int i3, m<JavaBean, Param> mVar) throws QStorageInstantiateException, QStorageSafeDeleteException {
        String canonicalPath;
        JavaBean javabean = null;
        if (file != null) {
            try {
                canonicalPath = file.getCanonicalPath();
            } catch (IOException unused) {
            }
            if (i3 == 1 && canonicalPath != null && ak.b().f(this.f202325a, this.f202327c, canonicalPath) && !file.exists()) {
                throw new QStorageSafeDeleteException();
            }
            javabean = mVar.a(file, param);
            if (javabean != null) {
                javabean = (JavaBean) aj.f(cls);
            } else if (canonicalPath != null) {
                ak.b().h(this.f202325a, this.f202327c, canonicalPath);
            }
            if (javabean == null) {
                return javabean;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QStorage", 2, "readFile ");
            }
            throw new QStorageInstantiateException("readSerializable exception too much", new NullPointerException());
        }
        canonicalPath = null;
        if (i3 == 1) {
        }
        javabean = mVar.a(file, param);
        if (javabean != null) {
        }
        if (javabean == null) {
        }
    }

    public <T extends Serializable> T f(String str, Class<T> cls, int i3) throws QStorageInstantiateException, QStorageSafeDeleteException {
        File b16 = b(str, ".serial");
        return (T) d(b16, "", cls, i3, new b(b16, str));
    }

    public <DATA> void g(File file, DATA data, m<String, DATA> mVar) {
        try {
            mVar.a(file, data);
            if (file != null && file.exists()) {
                try {
                    String canonicalPath = file.getCanonicalPath();
                    ak.b().j(this.f202325a, this.f202327c, canonicalPath);
                    ak.b().h(this.f202325a, this.f202327c, canonicalPath);
                } catch (IOException unused) {
                }
            }
        } catch (Exception e16) {
            QLog.d("QStorage", 1, "writeFile " + file.getAbsolutePath(), e16);
            an.b().d(mVar, file, e16);
        }
    }

    public <T extends Serializable> void h(String str, T t16) {
        g(b(str, ".serial"), t16, new a(str, t16));
    }
}
