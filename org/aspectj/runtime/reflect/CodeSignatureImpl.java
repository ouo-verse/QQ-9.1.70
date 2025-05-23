package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.CodeSignature;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class CodeSignatureImpl extends MemberSignatureImpl implements CodeSignature {
    Class[] exceptionTypes;
    String[] parameterNames;
    Class[] parameterTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CodeSignatureImpl(int i3, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i3, str, cls);
        this.parameterTypes = clsArr;
        this.parameterNames = strArr;
        this.exceptionTypes = clsArr2;
    }

    @Override // org.aspectj.lang.reflect.CodeSignature
    public Class[] getExceptionTypes() {
        if (this.exceptionTypes == null) {
            this.exceptionTypes = extractTypes(5);
        }
        return this.exceptionTypes;
    }

    @Override // org.aspectj.lang.reflect.CodeSignature
    public String[] getParameterNames() {
        if (this.parameterNames == null) {
            this.parameterNames = extractStrings(4);
        }
        return this.parameterNames;
    }

    @Override // org.aspectj.lang.reflect.CodeSignature
    public Class[] getParameterTypes() {
        if (this.parameterTypes == null) {
            this.parameterTypes = extractTypes(3);
        }
        return this.parameterTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CodeSignatureImpl(String str) {
        super(str);
    }
}
