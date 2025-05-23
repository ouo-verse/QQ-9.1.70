package org.jf.dexlib2.immutable.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.iface.reference.FieldReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableFieldReference extends BaseFieldReference implements ImmutableReference {

    @Nonnull
    protected final String definingClass;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final String type;

    public ImmutableFieldReference(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        this.definingClass = str;
        this.name = str2;
        this.type = str3;
    }

    @Nonnull
    public static ImmutableFieldReference of(@Nonnull FieldReference fieldReference) {
        if (fieldReference instanceof ImmutableFieldReference) {
            return (ImmutableFieldReference) fieldReference;
        }
        return new ImmutableFieldReference(fieldReference.getDefiningClass(), fieldReference.getName(), fieldReference.getType());
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.definingClass;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field
    @Nonnull
    public String getType() {
        return this.type;
    }
}
