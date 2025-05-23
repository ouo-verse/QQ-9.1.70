package com.tencent.mobileqq.fts.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import com.tencent.mobileqq.fts.v2.entity.index;
import com.tencent.mobileqq.fts.v2.entity.notColumn;
import com.tencent.mobileqq.fts.v2.entity.notIndex;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, String> f211785a;

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<Class, LinkedHashMap<String, Field>> f211786b;

    /* renamed from: c, reason: collision with root package name */
    public static ConcurrentHashMap<Class, LinkedHashSet<Field>> f211787c;

    /* renamed from: d, reason: collision with root package name */
    public static ConcurrentHashMap<Class, LinkedHashSet<Field>> f211788d;

    /* renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<Class, FTSEntityV2> f211789e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f211785a = new HashMap();
        f211786b = new ConcurrentHashMap<>();
        f211787c = new ConcurrentHashMap<>();
        f211788d = new ConcurrentHashMap<>();
        f211789e = new ConcurrentHashMap<>();
    }

    public static Map<String, Field> a(Class<? extends FTSEntityV2> cls) {
        LinkedHashMap<String, Field> linkedHashMap = f211786b.get(cls);
        if (linkedHashMap == null) {
            Field[] fields = cls.getFields();
            LinkedHashMap<String, Field> linkedHashMap2 = new LinkedHashMap<>();
            LinkedHashSet<Field> linkedHashSet = f211787c.get(cls);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                f211787c.put(cls, linkedHashSet);
            }
            LinkedHashSet<Field> linkedHashSet2 = f211788d.get(cls);
            if (linkedHashSet2 == null) {
                linkedHashSet2 = new LinkedHashSet<>();
                f211788d.put(cls, linkedHashSet2);
            }
            for (Field field : fields) {
                if (!field.isAnnotationPresent(notColumn.class)) {
                    if (!field.getDeclaringClass().equals(FTSEntityV2.class)) {
                        String name = field.getName();
                        if (name.equals("ext1") || name.equals("ext2") || name.equals("ext3") || name.equals("exts")) {
                            throw new RuntimeException("Field '" + name + "' cannot be declared in subclass. It is a reserved field in FTSEntity.");
                        }
                    }
                    if (field.isAnnotationPresent(index.class)) {
                        if (field.getType().equals(String.class)) {
                            linkedHashSet.add(field);
                        } else {
                            throw new RuntimeException(cls.getSimpleName() + "The type of Filed declared with @index must be String. Field is " + field.getName());
                        }
                    }
                    if (field.isAnnotationPresent(notIndex.class)) {
                        linkedHashSet2.add(field);
                    }
                    field.getName();
                    if (f211785a.get(field.getType()) != null) {
                        linkedHashMap2.put(field.getName(), field);
                    }
                }
            }
            f211786b.put(cls, linkedHashMap2);
            return linkedHashMap2;
        }
        return linkedHashMap;
    }

    public static Set<Field> b(Class<? extends FTSEntityV2> cls) {
        LinkedHashSet<Field> linkedHashSet = f211787c.get(cls);
        if (linkedHashSet == null) {
            a(cls);
            return f211787c.get(cls);
        }
        return linkedHashSet;
    }

    public static int c(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(" ")) == null) {
            return 0;
        }
        return split.length;
    }

    public static String d(String str) {
        try {
            StringBuilder sb5 = new StringBuilder(64);
            com.tencent.mobileqq.fts.v2.tokenizer.cjk.a aVar = new com.tencent.mobileqq.fts.v2.tokenizer.cjk.a(new StringReader(str), str.length());
            com.tencent.mobileqq.fts.v2.tokenizer.a aVar2 = null;
            while (true) {
                try {
                    com.tencent.mobileqq.fts.v2.tokenizer.a a16 = aVar.a();
                    if (a16 == null) {
                        break;
                    }
                    if (aVar2 != null && TextUtils.equals(aVar2.d(), "double") && ((!TextUtils.equals(a16.d(), "double") || aVar2.a() < a16.b()) && !TextUtils.isEmpty(aVar2.c()))) {
                        sb5.append(aVar2.c().charAt(aVar2.c().length() - 1));
                        sb5.append("*");
                        sb5.append(TokenParser.SP);
                    }
                    if (!TextUtils.isEmpty(a16.c()) && (!TextUtils.equals(a16.d(), "double") || a16.c().length() != 1)) {
                        sb5.append(a16.c());
                        sb5.append(TokenParser.SP);
                    }
                    aVar2 = a16;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.fts.utils", 2, "tokenSegment: failure", e16);
                    }
                }
            }
            if (aVar2 != null && TextUtils.equals(aVar2.d(), "double") && !TextUtils.isEmpty(aVar2.c())) {
                sb5.append(aVar2.c().charAt(aVar2.c().length() - 1));
                sb5.append("*");
            }
            return sb5.toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("Q.fts.utils", 2, "tokenSegment: failure", th5);
            }
            return null;
        }
    }

    public static String e(String str) {
        try {
            StringBuilder sb5 = new StringBuilder(64);
            com.tencent.mobileqq.fts.v2.tokenizer.cjk.a aVar = new com.tencent.mobileqq.fts.v2.tokenizer.cjk.a(new StringReader(str), str.length());
            com.tencent.mobileqq.fts.v2.tokenizer.a aVar2 = null;
            while (true) {
                try {
                    com.tencent.mobileqq.fts.v2.tokenizer.a a16 = aVar.a();
                    if (a16 == null) {
                        break;
                    }
                    if (aVar2 != null && TextUtils.equals(aVar2.d(), "double") && ((!TextUtils.equals(a16.d(), "double") || aVar2.a() < a16.b()) && !TextUtils.isEmpty(aVar2.c()))) {
                        sb5.append(aVar2.c().charAt(aVar2.c().length() - 1));
                        sb5.append("*");
                        sb5.append(TokenParser.SP);
                    }
                    if (!TextUtils.isEmpty(a16.c()) && (!TextUtils.equals(a16.d(), "double") || a16.c().length() != 1)) {
                        sb5.append(a16.c());
                        sb5.append(TokenParser.SP);
                    }
                    aVar2 = a16;
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            if (aVar2 != null && TextUtils.equals(aVar2.d(), "double") && !TextUtils.isEmpty(aVar2.c())) {
                sb5.append(aVar2.c().charAt(aVar2.c().length() - 1));
                sb5.append("*");
            }
            return sb5.toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
