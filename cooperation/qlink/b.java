package cooperation.qlink;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f390493a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f390494b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f390495c = null;

        /* renamed from: d, reason: collision with root package name */
        public String f390496d = null;

        /* renamed from: e, reason: collision with root package name */
        public String f390497e = null;

        /* renamed from: f, reason: collision with root package name */
        public String f390498f = null;
    }

    public static AppInterface a(BaseApplicationImpl baseApplicationImpl, String str) {
        Class<?> cls;
        Object newInstance;
        if (baseApplicationImpl != null && str != null) {
            try {
                try {
                    try {
                        cls = Class.forName("com.tencent.qlink.app.QlinkAppInterface");
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                    } catch (IllegalArgumentException e17) {
                        e17.printStackTrace();
                    } catch (InstantiationException e18) {
                        e18.printStackTrace();
                    } catch (NoSuchMethodException e19) {
                        e19.printStackTrace();
                    } catch (InvocationTargetException e26) {
                        e26.printStackTrace();
                    } catch (Exception e27) {
                        e27.printStackTrace();
                    }
                } catch (ClassNotFoundException e28) {
                    e28.printStackTrace();
                }
            } catch (ClassNotFoundException unused) {
                ClassLoader G2 = QlinkPluginProxyActivity.G2(baseApplicationImpl);
                Class<?> loadClass = G2.loadClass("com.tencent.qlink.app.QlinkAppInterface");
                BasicClassTypeUtil.setClassLoader(true, G2);
                cls = loadClass;
            }
            if (cls != null && (newInstance = cls.getDeclaredConstructor(baseApplicationImpl.getClass(), str.getClass()).newInstance(baseApplicationImpl, str)) != null && (newInstance instanceof AppInterface)) {
                return (AppInterface) newInstance;
            }
        }
        return null;
    }

    public static a b(String str) {
        int indexOf;
        if (str == null) {
            return null;
        }
        a aVar = new a();
        try {
            if (!str.startsWith("qqf2f://qf/?")) {
                return null;
            }
            String[] split = str.substring(12, str.length()).split(ContainerUtils.FIELD_DELIMITER);
            Bundle bundle = new Bundle();
            for (String str2 : split) {
                if (str2 != null && -1 != (indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER))) {
                    int i3 = indexOf + 1;
                    String substring = str2.substring(0, i3);
                    String substring2 = str2.substring(i3, str2.length());
                    if (substring != null && substring2 != null) {
                        bundle.putString(substring, substring2);
                    }
                }
            }
            aVar.f390493a = bundle.getString("k=");
            aVar.f390494b = c(bundle.getString("u="));
            String g16 = g(bundle.getString("n="));
            if (g16 != null) {
                String decode = URLDecoder.decode(g16, "UTF-8");
                aVar.f390495c = decode;
                if (decode == null) {
                    aVar.f390495c = aVar.f390494b;
                }
            } else {
                aVar.f390495c = aVar.f390494b;
            }
            aVar.f390496d = bundle.getString("o=");
            aVar.f390497e = bundle.getString("p=");
            aVar.f390498f = bundle.getString("d=");
            if (aVar.f390493a != null && aVar.f390494b != null) {
                if (aVar.f390496d != null) {
                    return aVar;
                }
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        try {
            return String.valueOf(((Long.valueOf(str).longValue() ^ 789454421545L) ^ 456752456285L) ^ 662347895234L);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(String str) {
        try {
            return String.valueOf(((Long.valueOf(str).longValue() ^ 662347895234L) ^ 456752456285L) ^ 789454421545L);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Intent e() {
        Intent intent = new Intent();
        QlinkPluginProxyActivity.setActivityNameToIntent(intent, "com.tencent.qlink.activity.QlinkProxyActivity");
        return intent;
    }

    @SuppressLint({"WifiManagerLeak"})
    public static boolean f() {
        try {
            WifiManager wifiManager = (WifiManager) BaseApplication.getContext().getSystemService("wifi");
            Method method = wifiManager.getClass().getMethod("isWifiApEnabled", new Class[0]);
            method.setAccessible(true);
            return ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
        } catch (NoSuchMethodException e16) {
            e16.printStackTrace();
            return false;
        } catch (Exception e17) {
            e17.printStackTrace();
            return false;
        }
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            try {
                bArr[i3] = Integer.valueOf(str.substring(i16, i16 + 2), 16).byteValue();
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        byte[] bArr2 = new byte[length];
        for (int i17 = 0; i17 < length; i17++) {
            bArr2[i17] = (byte) (((byte) (((byte) (bArr[i17] ^ 27)) ^ 104)) ^ (-94));
        }
        try {
            return new String(bArr2, "UTF-8");
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static String h(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < bytes.length; i3++) {
            bArr[i3] = (byte) (((byte) (((byte) (bytes[i3] ^ (-94))) ^ 104)) ^ 27);
        }
        StringBuilder sb5 = new StringBuilder(length * 2);
        for (int i16 = 0; i16 < length; i16++) {
            sb5.append(Integer.toHexString((bArr[i16] & 240) >> 4));
            sb5.append(Integer.toHexString(bArr[i16] & RegisterType.DOUBLE_HI));
        }
        return sb5.toString();
    }
}
