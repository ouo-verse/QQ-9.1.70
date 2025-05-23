package org.jf.dexlib2.iface.debug;

import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface StartLocal extends DebugItem, LocalInfo {
    @Nullable
    StringReference getNameReference();

    int getRegister();

    @Nullable
    StringReference getSignatureReference();

    @Nullable
    TypeReference getTypeReference();
}
