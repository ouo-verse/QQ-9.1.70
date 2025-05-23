package org.jf.dexlib2.writer.pool;

import com.google.common.base.d;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class PoolMethod extends BaseMethodReference implements Method {
    public static final d<Method, PoolMethod> TRANSFORM = new d<Method, PoolMethod>() { // from class: org.jf.dexlib2.writer.pool.PoolMethod.1
        @Override // com.google.common.base.d
        public PoolMethod apply(Method method) {
            return new PoolMethod(method);
        }
    };
    protected int annotationSetRefListOffset = 0;
    protected int codeItemOffset = 0;

    @Nonnull
    private final Method method;

    PoolMethod(@Nonnull Method method) {
        this.method = method;
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.method.getAccessFlags();
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public Set<? extends Annotation> getAnnotations() {
        return this.method.getAnnotations();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.method.getDefiningClass();
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.method.getHiddenApiRestrictions();
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nullable
    public MethodImplementation getImplementation() {
        return this.method.getImplementation();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.method.getName();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    @Nonnull
    public List<? extends CharSequence> getParameterTypes() {
        return this.method.getParameterTypes();
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nonnull
    public List<? extends MethodParameter> getParameters() {
        return this.method.getParameters();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
    @Nonnull
    public String getReturnType() {
        return this.method.getReturnType();
    }
}
