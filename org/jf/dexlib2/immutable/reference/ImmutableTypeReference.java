package org.jf.dexlib2.immutable.reference;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.util.ImmutableConverter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableTypeReference extends BaseTypeReference implements ImmutableReference {
    private static final ImmutableConverter<ImmutableTypeReference, TypeReference> CONVERTER = new ImmutableConverter<ImmutableTypeReference, TypeReference>() { // from class: org.jf.dexlib2.immutable.reference.ImmutableTypeReference.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull TypeReference typeReference) {
            return typeReference instanceof ImmutableTypeReference;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableTypeReference makeImmutable(@Nonnull TypeReference typeReference) {
            return ImmutableTypeReference.of(typeReference);
        }
    };

    @Nonnull
    protected final String type;

    public ImmutableTypeReference(String str) {
        this.type = str;
    }

    @Nonnull
    public static ImmutableList<ImmutableTypeReference> immutableListOf(@Nullable List<? extends TypeReference> list) {
        return CONVERTER.toList(list);
    }

    @Nonnull
    public static ImmutableTypeReference of(@Nonnull TypeReference typeReference) {
        if (typeReference instanceof ImmutableTypeReference) {
            return (ImmutableTypeReference) typeReference;
        }
        return new ImmutableTypeReference(typeReference.getType());
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return this.type;
    }
}
