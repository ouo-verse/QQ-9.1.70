package org.jf.dexlib2.rewriter;

import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MethodRewriter implements Rewriter<Method> {

    @Nonnull
    protected final Rewriters rewriters;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenMethod extends BaseMethodReference implements Method {

        @Nonnull
        protected Method method;

        public RewrittenMethod(@Nonnull Method method) {
            this.method = method;
        }

        @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        public int getAccessFlags() {
            return this.method.getAccessFlags();
        }

        @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Annotatable
        @Nonnull
        public Set<? extends Annotation> getAnnotations() {
            return RewriterUtils.rewriteSet(MethodRewriter.this.rewriters.getAnnotationRewriter(), this.method.getAnnotations());
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        @Nonnull
        public String getDefiningClass() {
            return MethodRewriter.this.rewriters.getMethodReferenceRewriter().rewrite(this.method).getDefiningClass();
        }

        @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        @Nonnull
        public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
            return this.method.getHiddenApiRestrictions();
        }

        @Override // org.jf.dexlib2.iface.Method
        @Nullable
        public MethodImplementation getImplementation() {
            return (MethodImplementation) RewriterUtils.rewriteNullable(MethodRewriter.this.rewriters.getMethodImplementationRewriter(), this.method.getImplementation());
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        @Nonnull
        public String getName() {
            return MethodRewriter.this.rewriters.getMethodReferenceRewriter().rewrite(this.method).getName();
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference
        @Nonnull
        public List<? extends CharSequence> getParameterTypes() {
            return MethodRewriter.this.rewriters.getMethodReferenceRewriter().rewrite(this.method).getParameterTypes();
        }

        @Override // org.jf.dexlib2.iface.Method
        @Nonnull
        public List<? extends MethodParameter> getParameters() {
            return RewriterUtils.rewriteList(MethodRewriter.this.rewriters.getMethodParameterRewriter(), this.method.getParameters());
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
        @Nonnull
        public String getReturnType() {
            return MethodRewriter.this.rewriters.getMethodReferenceRewriter().rewrite(this.method).getReturnType();
        }
    }

    public MethodRewriter(@Nonnull Rewriters rewriters) {
        this.rewriters = rewriters;
    }

    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public Method rewrite(@Nonnull Method method) {
        return new RewrittenMethod(method);
    }
}
