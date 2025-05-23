package org.aspectj.internal.lang.reflect;

import com.tencent.component.media.image.ProgressTracer;
import java.lang.annotation.Annotation;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareAnnotation;
import org.aspectj.lang.reflect.SignaturePattern;
import org.aspectj.lang.reflect.TypePattern;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DeclareAnnotationImpl implements DeclareAnnotation {
    private String annText;
    private AjType<?> declaringType;
    private DeclareAnnotation.Kind kind;
    private SignaturePattern signaturePattern;
    private Annotation theAnnotation;
    private TypePattern typePattern;

    /* compiled from: P */
    /* renamed from: org.aspectj.internal.lang.reflect.DeclareAnnotationImpl$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind;

        static {
            int[] iArr = new int[DeclareAnnotation.Kind.values().length];
            $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind = iArr;
            try {
                iArr[DeclareAnnotation.Kind.Type.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[DeclareAnnotation.Kind.Method.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[DeclareAnnotation.Kind.Field.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[DeclareAnnotation.Kind.Constructor.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DeclareAnnotationImpl(AjType<?> ajType, String str, String str2, Annotation annotation, String str3) {
        this.declaringType = ajType;
        if (str.equals("at_type")) {
            this.kind = DeclareAnnotation.Kind.Type;
        } else if (str.equals("at_field")) {
            this.kind = DeclareAnnotation.Kind.Field;
        } else if (str.equals("at_method")) {
            this.kind = DeclareAnnotation.Kind.Method;
        } else if (str.equals("at_constructor")) {
            this.kind = DeclareAnnotation.Kind.Constructor;
        } else {
            throw new IllegalStateException("Unknown declare annotation kind: " + str);
        }
        if (this.kind == DeclareAnnotation.Kind.Type) {
            this.typePattern = new TypePatternImpl(str2);
        } else {
            this.signaturePattern = new SignaturePatternImpl(str2);
        }
        this.theAnnotation = annotation;
        this.annText = str3;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public Annotation getAnnotation() {
        return this.theAnnotation;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public String getAnnotationAsText() {
        return this.annText;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public AjType<?> getDeclaringType() {
        return this.declaringType;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public DeclareAnnotation.Kind getKind() {
        return this.kind;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public SignaturePattern getSignaturePattern() {
        return this.signaturePattern;
    }

    @Override // org.aspectj.lang.reflect.DeclareAnnotation
    public TypePattern getTypePattern() {
        return this.typePattern;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare @");
        int i3 = AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$DeclareAnnotation$Kind[getKind().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        stringBuffer.append("constructor : ");
                        stringBuffer.append(getSignaturePattern().asString());
                    }
                } else {
                    stringBuffer.append("field : ");
                    stringBuffer.append(getSignaturePattern().asString());
                }
            } else {
                stringBuffer.append("method : ");
                stringBuffer.append(getSignaturePattern().asString());
            }
        } else {
            stringBuffer.append("type : ");
            stringBuffer.append(getTypePattern().asString());
        }
        stringBuffer.append(ProgressTracer.SEPARATOR);
        stringBuffer.append(getAnnotationAsText());
        return stringBuffer.toString();
    }
}
