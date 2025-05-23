package org.jf.dexlib2.iface;

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.debug.LocalInfo;
import org.jf.dexlib2.iface.reference.TypeReference;

/* loaded from: classes29.dex */
public interface MethodParameter extends TypeReference, LocalInfo {
    @Nonnull
    Set<? extends Annotation> getAnnotations();

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    String getName();

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    String getSignature();

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    String getType();
}
