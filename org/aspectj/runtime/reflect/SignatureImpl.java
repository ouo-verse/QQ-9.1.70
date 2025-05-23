package org.aspectj.runtime.reflect;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
import okhttp3.HttpUrl;
import org.aspectj.lang.Signature;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class SignatureImpl implements Signature {
    static final String INNER_SEP = ":";
    static final char SEP = '-';
    private static boolean useCache = true;
    Class declaringType;
    String declaringTypeName;
    ClassLoader lookupClassLoader;
    int modifiers;
    String name;
    Cache stringCache;
    private String stringRep;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Cache {
        String get(int i3);

        void set(int i3, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CacheImpl implements Cache {
        private SoftReference toStringCacheRef;

        public CacheImpl() {
            makeCache();
        }

        private String[] array() {
            return (String[]) this.toStringCacheRef.get();
        }

        private String[] makeCache() {
            String[] strArr = new String[3];
            this.toStringCacheRef = new SoftReference(strArr);
            return strArr;
        }

        @Override // org.aspectj.runtime.reflect.SignatureImpl.Cache
        public String get(int i3) {
            String[] array = array();
            if (array == null) {
                return null;
            }
            return array[i3];
        }

        @Override // org.aspectj.runtime.reflect.SignatureImpl.Cache
        public void set(int i3, String str) {
            String[] array = array();
            if (array == null) {
                array = makeCache();
            }
            array[i3] = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignatureImpl(int i3, String str, Class cls) {
        this.lookupClassLoader = null;
        this.modifiers = i3;
        this.name = str;
        this.declaringType = cls;
    }

    private ClassLoader getLookupClassLoader() {
        if (this.lookupClassLoader == null) {
            this.lookupClassLoader = getClass().getClassLoader();
        }
        return this.lookupClassLoader;
    }

    static boolean getUseCache() {
        return useCache;
    }

    static void setUseCache(boolean z16) {
        useCache = z16;
    }

    void addFullTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(fullTypeName(clsArr[i3]));
        }
    }

    void addShortTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(shortTypeName(clsArr[i3]));
        }
    }

    void addTypeArray(StringBuffer stringBuffer, Class[] clsArr) {
        addFullTypeNames(stringBuffer, clsArr);
    }

    protected abstract String createToString(StringMaker stringMaker);

    int extractInt(int i3) {
        return Integer.parseInt(extractString(i3), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String extractString(int i3) {
        int indexOf = this.stringRep.indexOf(45);
        int i16 = 0;
        while (true) {
            int i17 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            i16 = indexOf + 1;
            indexOf = this.stringRep.indexOf(45, i16);
            i3 = i17;
        }
        if (indexOf == -1) {
            indexOf = this.stringRep.length();
        }
        return this.stringRep.substring(i16, indexOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] extractStrings(int i3) {
        StringTokenizer stringTokenizer = new StringTokenizer(extractString(i3), ":");
        int countTokens = stringTokenizer.countTokens();
        String[] strArr = new String[countTokens];
        for (int i16 = 0; i16 < countTokens; i16++) {
            strArr[i16] = stringTokenizer.nextToken();
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class extractType(int i3) {
        return Factory.makeClass(extractString(i3), getLookupClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] extractTypes(int i3) {
        StringTokenizer stringTokenizer = new StringTokenizer(extractString(i3), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i16 = 0; i16 < countTokens; i16++) {
            clsArr[i16] = Factory.makeClass(stringTokenizer.nextToken(), getLookupClassLoader());
        }
        return clsArr;
    }

    String fullTypeName(Class cls) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            return fullTypeName(cls.getComponentType()) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return cls.getName().replace('$', '.');
    }

    @Override // org.aspectj.lang.Signature
    public Class getDeclaringType() {
        if (this.declaringType == null) {
            this.declaringType = extractType(2);
        }
        return this.declaringType;
    }

    @Override // org.aspectj.lang.Signature
    public String getDeclaringTypeName() {
        if (this.declaringTypeName == null) {
            this.declaringTypeName = getDeclaringType().getName();
        }
        return this.declaringTypeName;
    }

    @Override // org.aspectj.lang.Signature
    public int getModifiers() {
        if (this.modifiers == -1) {
            this.modifiers = extractInt(0);
        }
        return this.modifiers;
    }

    @Override // org.aspectj.lang.Signature
    public String getName() {
        if (this.name == null) {
            this.name = extractString(1);
        }
        return this.name;
    }

    public void setLookupClassLoader(ClassLoader classLoader) {
        this.lookupClassLoader = classLoader;
    }

    String shortTypeName(Class cls) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            return shortTypeName(cls.getComponentType()) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return stripPackageName(cls.getName()).replace('$', '.');
    }

    String stripPackageName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    @Override // org.aspectj.lang.Signature
    public final String toLongString() {
        return toString(StringMaker.longStringMaker);
    }

    @Override // org.aspectj.lang.Signature
    public final String toShortString() {
        return toString(StringMaker.shortStringMaker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString(StringMaker stringMaker) {
        String str;
        if (useCache) {
            Cache cache = this.stringCache;
            if (cache == null) {
                try {
                    this.stringCache = new CacheImpl();
                } catch (Throwable unused) {
                    useCache = false;
                }
            } else {
                str = cache.get(stringMaker.cacheOffset);
                if (str == null) {
                    str = createToString(stringMaker);
                }
                if (useCache) {
                    this.stringCache.set(stringMaker.cacheOffset, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (useCache) {
        }
        return str;
    }

    public SignatureImpl(String str) {
        this.modifiers = -1;
        this.lookupClassLoader = null;
        this.stringRep = str;
    }

    @Override // org.aspectj.lang.Signature
    public final String toString() {
        return toString(StringMaker.middleStringMaker);
    }
}
