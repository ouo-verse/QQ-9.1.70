package org.jf.dexlib2.builder.debug;

import javax.annotation.Nullable;
import org.jf.dexlib2.builder.BuilderDebugItem;
import org.jf.dexlib2.iface.debug.StartLocal;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderStartLocal extends BuilderDebugItem implements StartLocal {

    @Nullable
    private final StringReference name;
    private final int register;

    @Nullable
    private final StringReference signature;

    @Nullable
    private final TypeReference type;

    public BuilderStartLocal(int i3, @Nullable StringReference stringReference, @Nullable TypeReference typeReference, @Nullable StringReference stringReference2) {
        this.register = i3;
        this.name = stringReference;
        this.type = typeReference;
        this.signature = stringReference2;
    }

    @Override // org.jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 3;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getName() {
        StringReference stringReference = this.name;
        if (stringReference == null) {
            return null;
        }
        return stringReference.getString();
    }

    @Override // org.jf.dexlib2.iface.debug.StartLocal
    @Nullable
    public StringReference getNameReference() {
        return this.name;
    }

    @Override // org.jf.dexlib2.iface.debug.StartLocal
    public int getRegister() {
        return this.register;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getSignature() {
        StringReference stringReference = this.signature;
        if (stringReference == null) {
            return null;
        }
        return stringReference.getString();
    }

    @Override // org.jf.dexlib2.iface.debug.StartLocal
    @Nullable
    public StringReference getSignatureReference() {
        return this.signature;
    }

    @Override // org.jf.dexlib2.iface.debug.LocalInfo
    @Nullable
    public String getType() {
        TypeReference typeReference = this.type;
        if (typeReference == null) {
            return null;
        }
        return typeReference.getType();
    }

    @Override // org.jf.dexlib2.iface.debug.StartLocal
    @Nullable
    public TypeReference getTypeReference() {
        return this.type;
    }
}
