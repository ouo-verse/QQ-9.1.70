package com.tencent.mobileqq.troop.troopapps;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static void b(ObjectOutputStream objectOutputStream) {
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0045: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:70), block:B:25:0x0045 */
    @Nullable
    public static Object c(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e16) {
                e = e16;
                objectInputStream = null;
            } catch (ClassNotFoundException e17) {
                e = e17;
                objectInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                a(closeable2);
                a(byteArrayInputStream);
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                a(objectInputStream);
                a(byteArrayInputStream);
                return readObject;
            } catch (IOException e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e("GroupUtil", 2, "deserialize: failed. ", e);
                }
                a(objectInputStream);
                a(byteArrayInputStream);
                return null;
            } catch (ClassNotFoundException e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.e("GroupUtil", 2, "deserialize: failed. ", e);
                }
                a(objectInputStream);
                a(byteArrayInputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            a(closeable2);
            a(byteArrayInputStream);
            throw th;
        }
    }

    public static boolean d(Collection collection) {
        if (collection != null && collection.size() > 0) {
            return false;
        }
        return true;
    }

    public static long e(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static void f(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.executeOnSubThread(runnable);
        } else {
            runnable.run();
        }
    }

    public static void g(Runnable runnable, long j3) {
        new Handler(ThreadManagerV2.getSubThreadLooper()).postDelayed(runnable, j3);
    }

    @Nullable
    public static byte[] h(Object obj) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException e16) {
            e = e16;
            objectOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            b(objectOutputStream2);
            a(byteArrayOutputStream);
            throw th;
        }
        try {
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                b(objectOutputStream);
                a(byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th6) {
                th = th6;
                objectOutputStream2 = objectOutputStream;
                b(objectOutputStream2);
                a(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e17) {
            e = e17;
            if (QLog.isColorLevel()) {
                QLog.e("GroupUtil", 2, "serialize: failed. ", e);
            }
            b(objectOutputStream);
            a(byteArrayOutputStream);
            return null;
        }
    }
}
