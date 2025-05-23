package org.jf.dexlib2.rewriter;

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FieldRewriter implements Rewriter<Field> {

    @Nonnull
    protected final Rewriters rewriters;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenField extends BaseFieldReference implements Field {

        @Nonnull
        protected Field field;

        public RewrittenField(@Nonnull Field field) {
            this.field = field;
        }

        @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
        public int getAccessFlags() {
            return this.field.getAccessFlags();
        }

        @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Annotatable
        @Nonnull
        public Set<? extends Annotation> getAnnotations() {
            return RewriterUtils.rewriteSet(FieldRewriter.this.rewriters.getAnnotationRewriter(), this.field.getAnnotations());
        }

        @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
        @Nonnull
        public String getDefiningClass() {
            return FieldRewriter.this.rewriters.getFieldReferenceRewriter().rewrite(this.field).getDefiningClass();
        }

        @Override // org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
        @Nonnull
        public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
            return this.field.getHiddenApiRestrictions();
        }

        @Override // org.jf.dexlib2.iface.Field
        @Nullable
        public EncodedValue getInitialValue() {
            return (EncodedValue) RewriterUtils.rewriteNullable(FieldRewriter.this.rewriters.getEncodedValueRewriter(), this.field.getInitialValue());
        }

        @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
        @Nonnull
        public String getName() {
            return FieldRewriter.this.rewriters.getFieldReferenceRewriter().rewrite(this.field).getName();
        }

        @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field
        @Nonnull
        public String getType() {
            return FieldRewriter.this.rewriters.getFieldReferenceRewriter().rewrite(this.field).getType();
        }
    }

    public FieldRewriter(@Nonnull Rewriters rewriters) {
        this.rewriters = rewriters;
    }

    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public Field rewrite(@Nonnull Field field) {
        return new RewrittenField(field);
    }
}
