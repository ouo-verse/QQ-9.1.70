package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.writer.MethodHandleSection;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public class BuilderMethodHandlePool extends BaseBuilderPool implements MethodHandleSection<BuilderMethodHandleReference, BuilderFieldReference, BuilderMethodReference> {

    @Nonnull
    private final ConcurrentMap<MethodHandleReference, BuilderMethodHandleReference> internedItems;

    public BuilderMethodHandlePool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderMethodHandleReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderMethodHandleReference>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderMethodHandlePool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderMethodHandleReference builderMethodHandleReference) {
                return builderMethodHandleReference.index;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderMethodHandleReference builderMethodHandleReference, int i3) {
                int i16 = builderMethodHandleReference.index;
                builderMethodHandleReference.index = i3;
                return i16;
            }
        };
    }

    public BuilderMethodHandleReference internMethodHandle(MethodHandleReference methodHandleReference) {
        BuilderReference internFieldReference;
        BuilderMethodHandleReference builderMethodHandleReference = this.internedItems.get(methodHandleReference);
        if (builderMethodHandleReference != null) {
            return builderMethodHandleReference;
        }
        switch (methodHandleReference.getMethodHandleType()) {
            case 0:
            case 1:
            case 2:
            case 3:
                internFieldReference = this.dexBuilder.internFieldReference((FieldReference) methodHandleReference.getMemberReference());
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                internFieldReference = this.dexBuilder.internMethodReference((MethodReference) methodHandleReference.getMemberReference());
                break;
            default:
                throw new ExceptionWithContext("Invalid method handle type: %d", Integer.valueOf(methodHandleReference.getMethodHandleType()));
        }
        BuilderMethodHandleReference builderMethodHandleReference2 = new BuilderMethodHandleReference(methodHandleReference.getMethodHandleType(), internFieldReference);
        BuilderMethodHandleReference putIfAbsent = this.internedItems.putIfAbsent(builderMethodHandleReference2, builderMethodHandleReference2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return builderMethodHandleReference2;
    }

    @Override // org.jf.dexlib2.writer.MethodHandleSection
    public BuilderFieldReference getFieldReference(BuilderMethodHandleReference builderMethodHandleReference) {
        return (BuilderFieldReference) builderMethodHandleReference.getMemberReference();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemIndex(@Nonnull BuilderMethodHandleReference builderMethodHandleReference) {
        return builderMethodHandleReference.index;
    }

    @Override // org.jf.dexlib2.writer.MethodHandleSection
    public BuilderMethodReference getMethodReference(BuilderMethodHandleReference builderMethodHandleReference) {
        return (BuilderMethodReference) builderMethodHandleReference.getMemberReference();
    }
}
