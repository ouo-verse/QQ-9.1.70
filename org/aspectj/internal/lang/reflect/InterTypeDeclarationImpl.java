package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.InterTypeDeclaration;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InterTypeDeclarationImpl implements InterTypeDeclaration {
    private AjType<?> declaringType;
    private int modifiers;
    private AjType<?> targetType;
    protected String targetTypeName;

    public InterTypeDeclarationImpl(AjType<?> ajType, String str, int i3) {
        this.declaringType = ajType;
        this.targetTypeName = str;
        this.modifiers = i3;
        try {
            this.targetType = (AjType) StringToType.stringToType(str, ajType.getJavaClass());
        } catch (ClassNotFoundException unused) {
        }
    }

    @Override // org.aspectj.lang.reflect.InterTypeDeclaration
    public AjType<?> getDeclaringType() {
        return this.declaringType;
    }

    @Override // org.aspectj.lang.reflect.InterTypeDeclaration
    public int getModifiers() {
        return this.modifiers;
    }

    @Override // org.aspectj.lang.reflect.InterTypeDeclaration
    public AjType<?> getTargetType() throws ClassNotFoundException {
        AjType<?> ajType = this.targetType;
        if (ajType != null) {
            return ajType;
        }
        throw new ClassNotFoundException(this.targetTypeName);
    }

    public InterTypeDeclarationImpl(AjType<?> ajType, AjType<?> ajType2, int i3) {
        this.declaringType = ajType;
        this.targetType = ajType2;
        this.targetTypeName = ajType2.getName();
        this.modifiers = i3;
    }
}
