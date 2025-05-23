package org.jf.dexlib2.rewriter;

import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseAnnotation;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnnotationRewriter implements Rewriter<Annotation> {

    @Nonnull
    protected final Rewriters rewriters;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenAnnotation extends BaseAnnotation {

        @Nonnull
        protected Annotation annotation;

        public RewrittenAnnotation(@Nonnull Annotation annotation) {
            this.annotation = annotation;
        }

        @Override // org.jf.dexlib2.iface.Annotation, org.jf.dexlib2.iface.BasicAnnotation
        @Nonnull
        public Set<? extends AnnotationElement> getElements() {
            return RewriterUtils.rewriteSet(AnnotationRewriter.this.rewriters.getAnnotationElementRewriter(), this.annotation.getElements());
        }

        @Override // org.jf.dexlib2.iface.Annotation, org.jf.dexlib2.iface.BasicAnnotation
        @Nonnull
        public String getType() {
            return AnnotationRewriter.this.rewriters.getTypeRewriter().rewrite(this.annotation.getType());
        }

        @Override // org.jf.dexlib2.iface.Annotation
        public int getVisibility() {
            return this.annotation.getVisibility();
        }
    }

    public AnnotationRewriter(@Nonnull Rewriters rewriters) {
        this.rewriters = rewriters;
    }

    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public Annotation rewrite(@Nonnull Annotation annotation) {
        return new RewrittenAnnotation(annotation);
    }
}
