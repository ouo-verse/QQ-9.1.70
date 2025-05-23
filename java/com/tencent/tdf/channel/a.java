package java.com.tencent.tdf.channel;

import com.heytap.databaseengine.model.UserInfo;
import java.com.tencent.tdf.channel.annotation.ChannelMethod;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Class, String> f409686a = new HashMap<>();

    private static String a(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder("(");
        for (Class<?> cls : parameterTypes) {
            sb5.append(c(cls));
        }
        sb5.append(")");
        sb5.append(c(method.getReturnType()));
        return sb5.toString();
    }

    public static String b(Object obj) {
        String str = null;
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        HashMap<Class, String> hashMap = f409686a;
        if (hashMap.containsKey(cls)) {
            return hashMap.get(cls);
        }
        Method[] methods = cls.getMethods();
        if (methods != null && methods.length != 0) {
            HashMap hashMap2 = new HashMap();
            for (int i3 = 0; i3 < methods.length; i3++) {
                ChannelMethod channelMethod = (ChannelMethod) methods[i3].getAnnotation(ChannelMethod.class);
                if (channelMethod != null) {
                    String a16 = a(methods[i3]);
                    String name = channelMethod.name();
                    if (name == null || name.isEmpty()) {
                        name = methods[i3].getName();
                    }
                    hashMap2.put(name, a16);
                }
            }
            if (hashMap2.size() != 0) {
                str = hashMap2.toString();
            }
            f409686a.put(cls, str);
        }
        return str;
    }

    public static String c(Class cls) {
        if (cls == Boolean.TYPE) {
            return "Z";
        }
        if (cls == Double.TYPE) {
            return "D";
        }
        if (cls == Integer.TYPE) {
            return "I";
        }
        if (cls == Float.TYPE) {
            return UserInfo.SEX_FEMALE;
        }
        if (cls == Long.TYPE) {
            return "J";
        }
        if (cls == Void.TYPE) {
            return "V";
        }
        if ("[B".equals(cls.getName())) {
            return cls.getName();
        }
        if (d(cls)) {
            return "L" + cls.getCanonicalName().replace(".", "/") + ";";
        }
        return "Lcom/invalid;";
    }

    private static boolean d(Class cls) {
        if (cls != Boolean.class && cls != Integer.class && cls != Double.class && cls != Float.class && cls != Long.class && cls != String.class) {
            return false;
        }
        return true;
    }
}
