package org.jf.dexlib2.writer.pool;

import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.util.MethodUtil;
import org.jf.dexlib2.writer.ProtoSection;
import org.jf.dexlib2.writer.pool.TypeListPool;

/* loaded from: classes29.dex */
public class ProtoPool extends BaseIndexPool<MethodProtoReference> implements ProtoSection<CharSequence, CharSequence, MethodProtoReference, TypeListPool.Key<? extends Collection<? extends CharSequence>>> {
    public ProtoPool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    public void intern(@Nonnull MethodProtoReference methodProtoReference) {
        if (((Integer) this.internedItems.put(methodProtoReference, 0)) == null) {
            ((StringPool) this.dexPool.stringSection).intern(getShorty(methodProtoReference));
            ((TypePool) this.dexPool.typeSection).intern(methodProtoReference.getReturnType());
            ((TypeListPool) this.dexPool.typeListSection).intern(methodProtoReference.getParameterTypes());
        }
    }

    @Override // org.jf.dexlib2.writer.ProtoSection
    @Nullable
    public TypeListPool.Key<List<? extends CharSequence>> getParameters(@Nonnull MethodProtoReference methodProtoReference) {
        return new TypeListPool.Key<>(methodProtoReference.getParameterTypes());
    }

    @Override // org.jf.dexlib2.writer.ProtoSection
    @Nonnull
    public CharSequence getReturnType(@Nonnull MethodProtoReference methodProtoReference) {
        return methodProtoReference.getReturnType();
    }

    @Override // org.jf.dexlib2.writer.ProtoSection
    @Nonnull
    public CharSequence getShorty(@Nonnull MethodProtoReference methodProtoReference) {
        return MethodUtil.getShorty(methodProtoReference.getParameterTypes(), methodProtoReference.getReturnType());
    }
}
