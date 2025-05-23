package org.aspectj.runtime.reflect;

import java.lang.reflect.Field;
import org.aspectj.lang.reflect.FieldSignature;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FieldSignatureImpl extends MemberSignatureImpl implements FieldSignature {
    private Field field;
    Class fieldType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldSignatureImpl(int i3, String str, Class cls, Class cls2) {
        super(i3, str, cls);
        this.fieldType = cls2;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    protected String createToString(StringMaker stringMaker) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(stringMaker.makeModifiersString(getModifiers()));
        if (stringMaker.includeArgs) {
            stringBuffer.append(stringMaker.makeTypeName(getFieldType()));
        }
        if (stringMaker.includeArgs) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
        stringBuffer.append(".");
        stringBuffer.append(getName());
        return stringBuffer.toString();
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl, org.aspectj.lang.Signature
    public /* bridge */ /* synthetic */ Class getDeclaringType() {
        return super.getDeclaringType();
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl, org.aspectj.lang.Signature
    public /* bridge */ /* synthetic */ String getDeclaringTypeName() {
        return super.getDeclaringTypeName();
    }

    @Override // org.aspectj.lang.reflect.FieldSignature
    public Field getField() {
        if (this.field == null) {
            try {
                this.field = getDeclaringType().getDeclaredField(getName());
            } catch (Exception unused) {
            }
        }
        return this.field;
    }

    @Override // org.aspectj.lang.reflect.FieldSignature
    public Class getFieldType() {
        if (this.fieldType == null) {
            this.fieldType = extractType(3);
        }
        return this.fieldType;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl, org.aspectj.lang.Signature
    public /* bridge */ /* synthetic */ int getModifiers() {
        return super.getModifiers();
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl, org.aspectj.lang.Signature
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    public /* bridge */ /* synthetic */ void setLookupClassLoader(ClassLoader classLoader) {
        super.setLookupClassLoader(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldSignatureImpl(String str) {
        super(str);
    }
}
