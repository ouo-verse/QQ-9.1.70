package org.jf.dexlib2.rewriter;

import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseAnnotationEncodedValue;
import org.jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.jf.dexlib2.base.value.BaseEnumEncodedValue;
import org.jf.dexlib2.base.value.BaseFieldEncodedValue;
import org.jf.dexlib2.base.value.BaseMethodEncodedValue;
import org.jf.dexlib2.base.value.BaseTypeEncodedValue;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.EnumEncodedValue;
import org.jf.dexlib2.iface.value.FieldEncodedValue;
import org.jf.dexlib2.iface.value.MethodEncodedValue;
import org.jf.dexlib2.iface.value.TypeEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EncodedValueRewriter implements Rewriter<EncodedValue> {

    @Nonnull
    protected final Rewriters rewriters;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenAnnotationEncodedValue extends BaseAnnotationEncodedValue {

        @Nonnull
        protected AnnotationEncodedValue annotationEncodedValue;

        public RewrittenAnnotationEncodedValue(@Nonnull AnnotationEncodedValue annotationEncodedValue) {
            this.annotationEncodedValue = annotationEncodedValue;
        }

        @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, org.jf.dexlib2.iface.BasicAnnotation
        @Nonnull
        public Set<? extends AnnotationElement> getElements() {
            return RewriterUtils.rewriteSet(EncodedValueRewriter.this.rewriters.getAnnotationElementRewriter(), this.annotationEncodedValue.getElements());
        }

        @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, org.jf.dexlib2.iface.BasicAnnotation
        @Nonnull
        public String getType() {
            return EncodedValueRewriter.this.rewriters.getTypeRewriter().rewrite(this.annotationEncodedValue.getType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenArrayEncodedValue extends BaseArrayEncodedValue {

        @Nonnull
        protected ArrayEncodedValue arrayEncodedValue;

        public RewrittenArrayEncodedValue(@Nonnull ArrayEncodedValue arrayEncodedValue) {
            this.arrayEncodedValue = arrayEncodedValue;
        }

        @Override // org.jf.dexlib2.iface.value.ArrayEncodedValue
        @Nonnull
        public List<? extends EncodedValue> getValue() {
            return RewriterUtils.rewriteList(EncodedValueRewriter.this.rewriters.getEncodedValueRewriter(), this.arrayEncodedValue.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenEnumEncodedValue extends BaseEnumEncodedValue {

        @Nonnull
        protected EnumEncodedValue enumEncodedValue;

        public RewrittenEnumEncodedValue(@Nonnull EnumEncodedValue enumEncodedValue) {
            this.enumEncodedValue = enumEncodedValue;
        }

        @Override // org.jf.dexlib2.iface.value.EnumEncodedValue
        @Nonnull
        public FieldReference getValue() {
            return EncodedValueRewriter.this.rewriters.getFieldReferenceRewriter().rewrite(this.enumEncodedValue.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenFieldEncodedValue extends BaseFieldEncodedValue {

        @Nonnull
        protected FieldEncodedValue fieldEncodedValue;

        public RewrittenFieldEncodedValue(@Nonnull FieldEncodedValue fieldEncodedValue) {
            this.fieldEncodedValue = fieldEncodedValue;
        }

        @Override // org.jf.dexlib2.iface.value.FieldEncodedValue
        @Nonnull
        public FieldReference getValue() {
            return EncodedValueRewriter.this.rewriters.getFieldReferenceRewriter().rewrite(this.fieldEncodedValue.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenMethodEncodedValue extends BaseMethodEncodedValue {

        @Nonnull
        protected MethodEncodedValue methodEncodedValue;

        public RewrittenMethodEncodedValue(@Nonnull MethodEncodedValue methodEncodedValue) {
            this.methodEncodedValue = methodEncodedValue;
        }

        @Override // org.jf.dexlib2.iface.value.MethodEncodedValue
        @Nonnull
        public MethodReference getValue() {
            return EncodedValueRewriter.this.rewriters.getMethodReferenceRewriter().rewrite(this.methodEncodedValue.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenTypeEncodedValue extends BaseTypeEncodedValue {

        @Nonnull
        protected TypeEncodedValue typeEncodedValue;

        public RewrittenTypeEncodedValue(@Nonnull TypeEncodedValue typeEncodedValue) {
            this.typeEncodedValue = typeEncodedValue;
        }

        @Override // org.jf.dexlib2.iface.value.TypeEncodedValue
        @Nonnull
        public String getValue() {
            return EncodedValueRewriter.this.rewriters.getTypeRewriter().rewrite(this.typeEncodedValue.getValue());
        }
    }

    public EncodedValueRewriter(@Nonnull Rewriters rewriters) {
        this.rewriters = rewriters;
    }

    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public EncodedValue rewrite(@Nonnull EncodedValue encodedValue) {
        switch (encodedValue.getValueType()) {
            case 24:
                return new RewrittenTypeEncodedValue((TypeEncodedValue) encodedValue);
            case 25:
                return new RewrittenFieldEncodedValue((FieldEncodedValue) encodedValue);
            case 26:
                return new RewrittenMethodEncodedValue((MethodEncodedValue) encodedValue);
            case 27:
                return new RewrittenEnumEncodedValue((EnumEncodedValue) encodedValue);
            case 28:
                return new RewrittenArrayEncodedValue((ArrayEncodedValue) encodedValue);
            case 29:
                return new RewrittenAnnotationEncodedValue((AnnotationEncodedValue) encodedValue);
            default:
                return encodedValue;
        }
    }
}
