package org.aspectj.runtime.reflect;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.AdviceSignature;
import org.aspectj.lang.reflect.CatchClauseSignature;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.FieldSignature;
import org.aspectj.lang.reflect.InitializerSignature;
import org.aspectj.lang.reflect.LockSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.lang.reflect.UnlockSignature;
import org.aspectj.runtime.reflect.JoinPointImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Factory {
    private static Object[] NO_ARGS;
    static Hashtable prims;
    int count = 0;
    String filename;
    Class lexicalClass;
    ClassLoader lookupClassLoader;
    private static final Class[] NO_TYPES = new Class[0];
    private static final String[] NO_STRINGS = new String[0];

    static {
        Hashtable hashtable = new Hashtable();
        prims = hashtable;
        hashtable.put("void", Void.TYPE);
        prims.put(HippyControllerProps.BOOLEAN, Boolean.TYPE);
        prims.put("byte", Byte.TYPE);
        prims.put(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR, Character.TYPE);
        prims.put(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, Short.TYPE);
        prims.put(PoiListCacheRecord.WEIGHT_TYPE, Integer.TYPE);
        prims.put(PoiListCacheRecord.TIMESTAMP_TYPE, Long.TYPE);
        prims.put("float", Float.TYPE);
        prims.put("double", Double.TYPE);
        NO_ARGS = new Object[0];
    }

    public Factory(String str, Class cls) {
        this.filename = str;
        this.lexicalClass = cls;
        this.lookupClassLoader = cls.getClassLoader();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class makeClass(String str, ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Class cls = (Class) prims.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            if (classLoader == null) {
                return Class.forName(str);
            }
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return ClassNotFoundException.class;
        }
    }

    public static JoinPoint.StaticPart makeEncSJP(Member member) {
        Signature constructorSignatureImpl;
        String str;
        if (member instanceof Method) {
            Method method = (Method) member;
            constructorSignatureImpl = new MethodSignatureImpl(method.getModifiers(), method.getName(), method.getDeclaringClass(), method.getParameterTypes(), new String[method.getParameterTypes().length], method.getExceptionTypes(), method.getReturnType());
            str = JoinPoint.METHOD_EXECUTION;
        } else if (member instanceof Constructor) {
            Constructor constructor = (Constructor) member;
            constructorSignatureImpl = new ConstructorSignatureImpl(constructor.getModifiers(), constructor.getDeclaringClass(), constructor.getParameterTypes(), new String[constructor.getParameterTypes().length], constructor.getExceptionTypes());
            str = JoinPoint.CONSTRUCTOR_EXECUTION;
        } else {
            throw new IllegalArgumentException("member must be either a method or constructor");
        }
        return new JoinPointImpl.EnclosingStaticPartImpl(-1, str, constructorSignatureImpl, null);
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2) {
        return new JoinPointImpl(staticPart, obj, obj2, NO_ARGS);
    }

    public JoinPoint.EnclosingStaticPart makeAdviceESJP(String str, int i3, String str2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2, int i16) {
        Class[] clsArr3;
        String[] strArr2;
        Class[] clsArr4;
        Class cls3;
        if (clsArr == null) {
            clsArr3 = NO_TYPES;
        } else {
            clsArr3 = clsArr;
        }
        if (strArr == null) {
            strArr2 = NO_STRINGS;
        } else {
            strArr2 = strArr;
        }
        if (clsArr2 == null) {
            clsArr4 = NO_TYPES;
        } else {
            clsArr4 = clsArr2;
        }
        if (cls2 == null) {
            cls3 = Void.TYPE;
        } else {
            cls3 = cls2;
        }
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(i3, str2, cls, clsArr3, strArr2, clsArr4, cls3);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i17, str, adviceSignatureImpl, makeSourceLoc(i16, -1));
    }

    public JoinPoint.StaticPart makeAdviceSJP(String str, int i3, String str2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2, int i16) {
        Class[] clsArr3;
        String[] strArr2;
        Class[] clsArr4;
        Class cls3;
        if (clsArr == null) {
            clsArr3 = NO_TYPES;
        } else {
            clsArr3 = clsArr;
        }
        if (strArr == null) {
            strArr2 = NO_STRINGS;
        } else {
            strArr2 = strArr;
        }
        if (clsArr2 == null) {
            clsArr4 = NO_TYPES;
        } else {
            clsArr4 = clsArr2;
        }
        if (cls2 == null) {
            cls3 = Void.TYPE;
        } else {
            cls3 = cls2;
        }
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(i3, str2, cls, clsArr3, strArr2, clsArr4, cls3);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.StaticPartImpl(i17, str, adviceSignatureImpl, makeSourceLoc(i16, -1));
    }

    public AdviceSignature makeAdviceSig(String str) {
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(str);
        adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return adviceSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeCatchClauseESJP(String str, Class cls, Class cls2, String str2, int i3) {
        if (str2 == null) {
            str2 = "";
        }
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(cls, cls2, str2);
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i16, str, catchClauseSignatureImpl, makeSourceLoc(i3, -1));
    }

    public JoinPoint.StaticPart makeCatchClauseSJP(String str, Class cls, Class cls2, String str2, int i3) {
        if (str2 == null) {
            str2 = "";
        }
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(cls, cls2, str2);
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.StaticPartImpl(i16, str, catchClauseSignatureImpl, makeSourceLoc(i3, -1));
    }

    public CatchClauseSignature makeCatchClauseSig(String str) {
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(str);
        catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return catchClauseSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeConstructorESJP(String str, int i3, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, int i16) {
        if (clsArr == null) {
            clsArr = NO_TYPES;
        }
        Class[] clsArr3 = clsArr;
        if (strArr == null) {
            strArr = NO_STRINGS;
        }
        String[] strArr2 = strArr;
        if (clsArr2 == null) {
            clsArr2 = NO_TYPES;
        }
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(i3, cls, clsArr3, strArr2, clsArr2);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i17, str, constructorSignatureImpl, makeSourceLoc(i16, -1));
    }

    public JoinPoint.StaticPart makeConstructorSJP(String str, int i3, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, int i16) {
        if (clsArr == null) {
            clsArr = NO_TYPES;
        }
        Class[] clsArr3 = clsArr;
        if (strArr == null) {
            strArr = NO_STRINGS;
        }
        String[] strArr2 = strArr;
        if (clsArr2 == null) {
            clsArr2 = NO_TYPES;
        }
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(i3, cls, clsArr3, strArr2, clsArr2);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.StaticPartImpl(i17, str, constructorSignatureImpl, makeSourceLoc(i16, -1));
    }

    public ConstructorSignature makeConstructorSig(String str) {
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(str);
        constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return constructorSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, SourceLocation sourceLocation) {
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i3, str, signature, sourceLocation);
    }

    public JoinPoint.EnclosingStaticPart makeFieldESJP(String str, int i3, String str2, Class cls, Class cls2, int i16) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(i3, str2, cls, cls2);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i17, str, fieldSignatureImpl, makeSourceLoc(i16, -1));
    }

    public JoinPoint.StaticPart makeFieldSJP(String str, int i3, String str2, Class cls, Class cls2, int i16) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(i3, str2, cls, cls2);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.StaticPartImpl(i17, str, fieldSignatureImpl, makeSourceLoc(i16, -1));
    }

    public FieldSignature makeFieldSig(String str) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(str);
        fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return fieldSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeInitializerESJP(String str, int i3, Class cls, int i16) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(i3, cls);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i17, str, initializerSignatureImpl, makeSourceLoc(i16, -1));
    }

    public JoinPoint.StaticPart makeInitializerSJP(String str, int i3, Class cls, int i16) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(i3, cls);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.StaticPartImpl(i17, str, initializerSignatureImpl, makeSourceLoc(i16, -1));
    }

    public InitializerSignature makeInitializerSig(String str) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(str);
        initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return initializerSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeLockESJP(String str, Class cls, int i3) {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(cls);
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i16, str, lockSignatureImpl, makeSourceLoc(i3, -1));
    }

    public JoinPoint.StaticPart makeLockSJP(String str, Class cls, int i3) {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(cls);
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.StaticPartImpl(i16, str, lockSignatureImpl, makeSourceLoc(i3, -1));
    }

    public LockSignature makeLockSig(String str) {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(str);
        lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return lockSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeMethodESJP(String str, int i3, String str2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2, int i16) {
        Class[] clsArr3;
        String[] strArr2;
        Class[] clsArr4;
        Class cls3;
        if (clsArr == null) {
            clsArr3 = NO_TYPES;
        } else {
            clsArr3 = clsArr;
        }
        if (strArr == null) {
            strArr2 = NO_STRINGS;
        } else {
            strArr2 = strArr;
        }
        if (clsArr2 == null) {
            clsArr4 = NO_TYPES;
        } else {
            clsArr4 = clsArr2;
        }
        if (cls2 == null) {
            cls3 = Void.TYPE;
        } else {
            cls3 = cls2;
        }
        MethodSignature makeMethodSig = makeMethodSig(i3, str2, cls, clsArr3, strArr2, clsArr4, cls3);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i17, str, makeMethodSig, makeSourceLoc(i16, -1));
    }

    public JoinPoint.StaticPart makeMethodSJP(String str, int i3, String str2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2, int i16) {
        Class[] clsArr3;
        String[] strArr2;
        Class[] clsArr4;
        Class cls3;
        if (clsArr == null) {
            clsArr3 = NO_TYPES;
        } else {
            clsArr3 = clsArr;
        }
        if (strArr == null) {
            strArr2 = NO_STRINGS;
        } else {
            strArr2 = strArr;
        }
        if (clsArr2 == null) {
            clsArr4 = NO_TYPES;
        } else {
            clsArr4 = clsArr2;
        }
        if (cls2 == null) {
            cls3 = Void.TYPE;
        } else {
            cls3 = cls2;
        }
        MethodSignature makeMethodSig = makeMethodSig(i3, str2, cls, clsArr3, strArr2, clsArr4, cls3);
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.StaticPartImpl(i17, str, makeMethodSig, makeSourceLoc(i16, -1));
    }

    public MethodSignature makeMethodSig(String str) {
        MethodSignatureImpl methodSignatureImpl = new MethodSignatureImpl(str);
        methodSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return methodSignatureImpl;
    }

    public JoinPoint.StaticPart makeSJP(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3) {
        MethodSignature makeMethodSig = makeMethodSig(str2, str3, str4, str5, str6, str7, str8);
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.StaticPartImpl(i16, str, makeMethodSig, makeSourceLoc(i3, -1));
    }

    public SourceLocation makeSourceLoc(int i3, int i16) {
        return new SourceLocationImpl(this.lexicalClass, this.filename, i3);
    }

    public JoinPoint.EnclosingStaticPart makeUnlockESJP(String str, Class cls, int i3) {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(cls);
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i16, str, unlockSignatureImpl, makeSourceLoc(i3, -1));
    }

    public JoinPoint.StaticPart makeUnlockSJP(String str, Class cls, int i3) {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(cls);
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.StaticPartImpl(i16, str, unlockSignatureImpl, makeSourceLoc(i3, -1));
    }

    public UnlockSignature makeUnlockSig(String str) {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(str);
        unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return unlockSignatureImpl;
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object obj3) {
        return new JoinPointImpl(staticPart, obj, obj2, new Object[]{obj3});
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, int i3, int i16) {
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i17, str, signature, makeSourceLoc(i3, i16));
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object obj3, Object obj4) {
        return new JoinPointImpl(staticPart, obj, obj2, new Object[]{obj3, obj4});
    }

    public AdviceSignature makeAdviceSig(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class makeClass = makeClass(str3, this.lookupClassLoader);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i3 = 0; i3 < countTokens; i3++) {
            clsArr[i3] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i16 = 0; i16 < countTokens2; i16++) {
            strArr[i16] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i17 = 0; i17 < countTokens3; i17++) {
            clsArr2[i17] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
        }
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(parseInt, str2, makeClass, clsArr, strArr, clsArr2, makeClass(str7, this.lookupClassLoader));
        adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return adviceSignatureImpl;
    }

    public CatchClauseSignature makeCatchClauseSig(String str, String str2, String str3) {
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(makeClass(str, this.lookupClassLoader), makeClass(new StringTokenizer(str2, ":").nextToken(), this.lookupClassLoader), new StringTokenizer(str3, ":").nextToken());
        catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return catchClauseSignatureImpl;
    }

    public ConstructorSignature makeConstructorSig(String str, String str2, String str3, String str4, String str5) {
        int parseInt = Integer.parseInt(str, 16);
        Class makeClass = makeClass(str2, this.lookupClassLoader);
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i3 = 0; i3 < countTokens; i3++) {
            clsArr[i3] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str4, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i16 = 0; i16 < countTokens2; i16++) {
            strArr[i16] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str5, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i17 = 0; i17 < countTokens3; i17++) {
            clsArr2[i17] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
        }
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(parseInt, makeClass, clsArr, strArr, clsArr2);
        constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return constructorSignatureImpl;
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, int i3) {
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.EnclosingStaticPartImpl(i16, str, signature, makeSourceLoc(i3, -1));
    }

    public FieldSignature makeFieldSig(String str, String str2, String str3, String str4) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(Integer.parseInt(str, 16), str2, makeClass(str3, this.lookupClassLoader), makeClass(str4, this.lookupClassLoader));
        fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return fieldSignatureImpl;
    }

    public InitializerSignature makeInitializerSig(String str, String str2) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(Integer.parseInt(str, 16), makeClass(str2, this.lookupClassLoader));
        initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return initializerSignatureImpl;
    }

    public LockSignature makeLockSig() {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(makeClass("Ljava/lang/Object;", this.lookupClassLoader));
        lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return lockSignatureImpl;
    }

    public MethodSignature makeMethodSig(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return makeMethodSig(str, str2, makeClass(str3, this.lookupClassLoader), str4, str5, str6, str7);
    }

    public JoinPoint.StaticPart makeSJP(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3) {
        MethodSignature makeMethodSig = makeMethodSig(str2, str3, str4, str5, str6, "", str7);
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.StaticPartImpl(i16, str, makeMethodSig, makeSourceLoc(i3, -1));
    }

    public UnlockSignature makeUnlockSig() {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(makeClass("Ljava/lang/Object;", this.lookupClassLoader));
        unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return unlockSignatureImpl;
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        return new JoinPointImpl(staticPart, obj, obj2, objArr);
    }

    public MethodSignature makeMethodSig(String str, String str2, Class cls, String str3, String str4, String str5, String str6) {
        int parseInt = Integer.parseInt(str, 16);
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i3 = 0; i3 < countTokens; i3++) {
            clsArr[i3] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str4, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i16 = 0; i16 < countTokens2; i16++) {
            strArr[i16] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str5, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i17 = 0; i17 < countTokens3; i17++) {
            clsArr2[i17] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
        }
        return new MethodSignatureImpl(parseInt, str2, cls, clsArr, strArr, clsArr2, makeClass(str6, this.lookupClassLoader));
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, SourceLocation sourceLocation) {
        int i3 = this.count;
        this.count = i3 + 1;
        return new JoinPointImpl.StaticPartImpl(i3, str, signature, sourceLocation);
    }

    public LockSignature makeLockSig(Class cls) {
        LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(cls);
        lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return lockSignatureImpl;
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, int i3, int i16) {
        int i17 = this.count;
        this.count = i17 + 1;
        return new JoinPointImpl.StaticPartImpl(i17, str, signature, makeSourceLoc(i3, i16));
    }

    public UnlockSignature makeUnlockSig(Class cls) {
        UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(cls);
        unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return unlockSignatureImpl;
    }

    public InitializerSignature makeInitializerSig(int i3, Class cls) {
        InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(i3, cls);
        initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return initializerSignatureImpl;
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, int i3) {
        int i16 = this.count;
        this.count = i16 + 1;
        return new JoinPointImpl.StaticPartImpl(i16, str, signature, makeSourceLoc(i3, -1));
    }

    public FieldSignature makeFieldSig(int i3, String str, Class cls, Class cls2) {
        FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(i3, str, cls, cls2);
        fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return fieldSignatureImpl;
    }

    public CatchClauseSignature makeCatchClauseSig(Class cls, Class cls2, String str) {
        CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(cls, cls2, str);
        catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return catchClauseSignatureImpl;
    }

    public ConstructorSignature makeConstructorSig(int i3, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(i3, cls, clsArr, strArr, clsArr2);
        constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return constructorSignatureImpl;
    }

    public AdviceSignature makeAdviceSig(int i3, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(i3, str, cls, clsArr, strArr, clsArr2, cls2);
        adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return adviceSignatureImpl;
    }

    public MethodSignature makeMethodSig(int i3, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        MethodSignatureImpl methodSignatureImpl = new MethodSignatureImpl(i3, str, cls, clsArr == null ? NO_TYPES : clsArr, strArr, clsArr2 == null ? NO_TYPES : clsArr2, cls2);
        methodSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
        return methodSignatureImpl;
    }
}
