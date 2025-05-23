package org.jf.dexlib2.writer.pool;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.writer.MethodSection;

/* loaded from: classes29.dex */
public class MethodPool extends BaseIndexPool<MethodReference> implements MethodSection<CharSequence, CharSequence, MethodProtoReference, MethodReference, PoolMethod> {
    public MethodPool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public MethodReference getMethodReference(@Nonnull PoolMethod poolMethod) {
        return poolMethod;
    }

    public void intern(@Nonnull MethodReference methodReference) {
        if (((Integer) this.internedItems.put(methodReference, 0)) == null) {
            ((TypePool) this.dexPool.typeSection).intern(methodReference.getDefiningClass());
            ((ProtoPool) this.dexPool.protoSection).intern(new PoolMethodProto(methodReference));
            ((StringPool) this.dexPool.stringSection).intern(methodReference.getName());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public CharSequence getDefiningClass(@Nonnull MethodReference methodReference) {
        return methodReference.getDefiningClass();
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    public int getMethodIndex(@Nonnull PoolMethod poolMethod) {
        return getItemIndex(poolMethod);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public CharSequence getName(@Nonnull MethodReference methodReference) {
        return methodReference.getName();
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public MethodProtoReference getPrototype(@Nonnull MethodReference methodReference) {
        return new PoolMethodProto(methodReference);
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public MethodProtoReference getPrototype(@Nonnull PoolMethod poolMethod) {
        return new PoolMethodProto(poolMethod);
    }
}
