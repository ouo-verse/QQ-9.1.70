package com.tencent.thumbplayer.core.hdr.capability;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes26.dex */
public abstract class TPHdrCapabilityBase implements ITPHdrCapability {
    protected Set<Integer> mSupportedMappingTypes = new HashSet();
    protected boolean mSupported = false;

    @Override // com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public Set<Integer> getSupportedMappingTypes() {
        return this.mSupportedMappingTypes;
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public boolean isSupported() {
        return this.mSupported;
    }
}
