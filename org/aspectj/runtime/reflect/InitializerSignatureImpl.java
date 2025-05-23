package org.aspectj.runtime.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.aspectj.lang.reflect.InitializerSignature;

/* compiled from: P */
/* loaded from: classes29.dex */
class InitializerSignatureImpl extends CodeSignatureImpl implements InitializerSignature {
    private Constructor constructor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InitializerSignatureImpl(int i3, Class cls) {
        super(i3, r0, cls, r7, SignatureImpl.EMPTY_STRING_ARRAY, r7);
        String str = Modifier.isStatic(i3) ? "<clinit>" : "<init>";
        Class[] clsArr = SignatureImpl.EMPTY_CLASS_ARRAY;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    protected String createToString(StringMaker stringMaker) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(stringMaker.makeModifiersString(getModifiers()));
        stringBuffer.append(stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        return stringBuffer.toString();
    }

    @Override // org.aspectj.lang.reflect.InitializerSignature
    public Constructor getInitializer() {
        if (this.constructor == null) {
            try {
                this.constructor = getDeclaringType().getDeclaredConstructor(getParameterTypes());
            } catch (Exception unused) {
            }
        }
        return this.constructor;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl, org.aspectj.lang.Signature
    public String getName() {
        if (Modifier.isStatic(getModifiers())) {
            return "<clinit>";
        }
        return "<init>";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InitializerSignatureImpl(String str) {
        super(str);
    }
}
