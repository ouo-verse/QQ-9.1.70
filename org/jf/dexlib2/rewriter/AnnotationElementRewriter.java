package org.jf.dexlib2.rewriter;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseAnnotationElement;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnnotationElementRewriter implements Rewriter<AnnotationElement> {

    @Nonnull
    protected final Rewriters rewriters;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenAnnotationElement extends BaseAnnotationElement {

        @Nonnull
        protected AnnotationElement annotationElement;

        public RewrittenAnnotationElement(@Nonnull AnnotationElement annotationElement) {
            this.annotationElement = annotationElement;
        }

        @Override // org.jf.dexlib2.iface.AnnotationElement
        @Nonnull
        public String getName() {
            return this.annotationElement.getName();
        }

        @Override // org.jf.dexlib2.iface.AnnotationElement
        @Nonnull
        public EncodedValue getValue() {
            return AnnotationElementRewriter.this.rewriters.getEncodedValueRewriter().rewrite(this.annotationElement.getValue());
        }
    }

    public AnnotationElementRewriter(@Nonnull Rewriters rewriters) {
        this.rewriters = rewriters;
    }

    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public AnnotationElement rewrite(@Nonnull AnnotationElement annotationElement) {
        return new RewrittenAnnotationElement(annotationElement);
    }
}
