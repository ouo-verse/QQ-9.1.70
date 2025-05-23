package org.jf.dexlib2.iface;

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Field extends FieldReference, Member {
    @Override // org.jf.dexlib2.iface.Member
    int getAccessFlags();

    @Override // org.jf.dexlib2.iface.Annotatable
    @Nonnull
    Set<? extends Annotation> getAnnotations();

    @Override // org.jf.dexlib2.iface.Member
    @Nonnull
    String getDefiningClass();

    @Override // org.jf.dexlib2.iface.Member
    @Nonnull
    Set<HiddenApiRestriction> getHiddenApiRestrictions();

    @Nullable
    EncodedValue getInitialValue();

    @Override // org.jf.dexlib2.iface.Member
    @Nonnull
    String getName();

    @Nonnull
    String getType();
}
