package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseMethodParameter;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

/* loaded from: classes29.dex */
public class ImmutableMethodParameter extends BaseMethodParameter {
    private static final ImmutableConverter<ImmutableMethodParameter, MethodParameter> CONVERTER = new ImmutableConverter<ImmutableMethodParameter, MethodParameter>() { // from class: org.jf.dexlib2.immutable.ImmutableMethodParameter.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull MethodParameter methodParameter) {
            return methodParameter instanceof ImmutableMethodParameter;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableMethodParameter makeImmutable(@Nonnull MethodParameter methodParameter) {
            return ImmutableMethodParameter.of(methodParameter);
        }
    };

    @Nonnull
    protected final ImmutableSet<? extends ImmutableAnnotation> annotations;

    @Nullable
    protected final String name;

    @Nonnull
    protected final String type;

    public ImmutableMethodParameter(@Nonnull String str, @Nullable Set<? extends Annotation> set, @Nullable String str2) {
        this.type = str;
        this.annotations = ImmutableAnnotation.immutableSetOf(set);
        this.name = str2;
    }

    @Nonnull
    public static ImmutableList<ImmutableMethodParameter> immutableListOf(@Nullable Iterable<? extends MethodParameter> iterable) {
        return CONVERTER.toList(iterable);
    }

    public static ImmutableMethodParameter of(MethodParameter methodParameter) {
        if (methodParameter instanceof ImmutableMethodParameter) {
            return (ImmutableMethodParameter) methodParameter;
        }
        return new ImmutableMethodParameter(methodParameter.getType(), methodParameter.getAnnotations(), methodParameter.getName());
    }

    @Override // org.jf.dexlib2.iface.MethodParameter
    @Nonnull
    public Set<? extends Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // org.jf.dexlib2.iface.MethodParameter, org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getName() {
        return this.name;
    }

    @Override // org.jf.dexlib2.base.BaseMethodParameter, org.jf.dexlib2.iface.MethodParameter, org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getSignature() {
        return null;
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return this.type;
    }

    public ImmutableMethodParameter(@Nonnull String str, @Nullable ImmutableSet<? extends ImmutableAnnotation> immutableSet, @Nullable String str2) {
        this.type = str;
        this.annotations = ImmutableUtils.nullToEmptySet(immutableSet);
        this.name = str2;
    }
}
