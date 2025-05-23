package org.jf.dexlib2.writer;

import org.jf.dexlib2.iface.reference.CallSiteReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface CallSiteSection<CallSiteKey extends CallSiteReference, EncodedArrayKey> extends IndexSection<CallSiteKey> {
    EncodedArrayKey getEncodedCallSite(CallSiteKey callsitekey);
}
