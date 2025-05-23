package com.tencent.thumbplayer.core.hdr.capability;

import android.os.Build;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPHdrDolbyVisionSystemRenderCapability extends TPHdrCapabilityBase {
    @Override // com.tencent.thumbplayer.core.hdr.capability.TPHdrCapabilityBase, com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public Set<Integer> getSupportedMappingTypes() {
        this.mSupportedMappingTypes.clear();
        if (isSupported()) {
            this.mSupportedMappingTypes.add(1);
        }
        return this.mSupportedMappingTypes;
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.TPHdrCapabilityBase, com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public boolean isSupported() {
        if (TPHdrSystemRenderBlackWhiteList.isCurrentDeviceInHdrWhiteList(2) || TPHdrSystemRenderBlackWhiteList.isManufacturerInHdrWhiteList(2)) {
            return true;
        }
        if (TPHdrSystemRenderBlackWhiteList.isCurrentDeviceInHdrBlackList(2) || TPHdrSystemRenderBlackWhiteList.isManufacturerInHdrBlackList(2)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24 && TPDisplayHdrCapability.isHdrSupported(1)) {
            return true;
        }
        return false;
    }
}
