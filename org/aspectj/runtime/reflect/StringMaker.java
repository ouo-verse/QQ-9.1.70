package org.aspectj.runtime.reflect;

import java.lang.reflect.Modifier;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes29.dex */
class StringMaker {
    static StringMaker longStringMaker;
    static StringMaker middleStringMaker;
    static StringMaker shortStringMaker;
    int cacheOffset;
    boolean shortTypeNames = true;
    boolean includeArgs = true;
    boolean includeThrows = false;
    boolean includeModifiers = false;
    boolean shortPrimaryTypeNames = false;
    boolean includeJoinPointTypeName = true;
    boolean includeEnclosingPoint = true;
    boolean shortKindName = true;

    static {
        StringMaker stringMaker = new StringMaker();
        shortStringMaker = stringMaker;
        stringMaker.shortTypeNames = true;
        stringMaker.includeArgs = false;
        stringMaker.includeThrows = false;
        stringMaker.includeModifiers = false;
        stringMaker.shortPrimaryTypeNames = true;
        stringMaker.includeJoinPointTypeName = false;
        stringMaker.includeEnclosingPoint = false;
        stringMaker.cacheOffset = 0;
        StringMaker stringMaker2 = new StringMaker();
        middleStringMaker = stringMaker2;
        stringMaker2.shortTypeNames = true;
        stringMaker2.includeArgs = true;
        stringMaker2.includeThrows = false;
        stringMaker2.includeModifiers = false;
        stringMaker2.shortPrimaryTypeNames = false;
        shortStringMaker.cacheOffset = 1;
        StringMaker stringMaker3 = new StringMaker();
        longStringMaker = stringMaker3;
        stringMaker3.shortTypeNames = false;
        stringMaker3.includeArgs = true;
        stringMaker3.includeThrows = false;
        stringMaker3.includeModifiers = true;
        stringMaker3.shortPrimaryTypeNames = false;
        stringMaker3.shortKindName = false;
        stringMaker3.cacheOffset = 2;
    }

    StringMaker() {
    }

    public void addSignature(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.includeArgs) {
            if (clsArr.length == 0) {
                stringBuffer.append("()");
                return;
            } else {
                stringBuffer.append("(..)");
                return;
            }
        }
        stringBuffer.append("(");
        addTypeNames(stringBuffer, clsArr);
        stringBuffer.append(")");
    }

    public void addThrows(StringBuffer stringBuffer, Class[] clsArr) {
        if (this.includeThrows && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            addTypeNames(stringBuffer, clsArr);
        }
    }

    public void addTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(makeTypeName(clsArr[i3]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String makeKindName(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String makeModifiersString(int i3) {
        if (!this.includeModifiers) {
            return "";
        }
        String modifier = Modifier.toString(i3);
        if (modifier.length() == 0) {
            return "";
        }
        return modifier + " ";
    }

    public String makePrimaryTypeName(Class cls, String str) {
        return makeTypeName(cls, str, this.shortPrimaryTypeNames);
    }

    String makeTypeName(Class cls, String str, boolean z16) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            if (z16) {
                return stripPackageName(str).replace('$', '.');
            }
            return str.replace('$', '.');
        }
        Class<?> componentType = cls.getComponentType();
        return makeTypeName(componentType, componentType.getName(), z16) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    String stripPackageName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    public String makeTypeName(Class cls) {
        return makeTypeName(cls, cls.getName(), this.shortTypeNames);
    }
}
