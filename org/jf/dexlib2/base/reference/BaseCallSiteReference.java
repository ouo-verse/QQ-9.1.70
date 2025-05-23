package org.jf.dexlib2.base.reference;

import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.reference.CallSiteReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseCallSiteReference extends BaseReference implements CallSiteReference {
    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CallSiteReference)) {
            return false;
        }
        CallSiteReference callSiteReference = (CallSiteReference) obj;
        if (!getMethodHandle().equals(callSiteReference.getMethodHandle()) || !getMethodName().equals(callSiteReference.getMethodName()) || !getMethodProto().equals(callSiteReference.getMethodProto()) || !getExtraArguments().equals(callSiteReference.getExtraArguments())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    public int hashCode() {
        return (((((((getName().hashCode() * 31) + getMethodHandle().hashCode()) * 31) + getMethodName().hashCode()) * 31) + getMethodProto().hashCode()) * 31) + getExtraArguments().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getCallSite(this);
    }
}
