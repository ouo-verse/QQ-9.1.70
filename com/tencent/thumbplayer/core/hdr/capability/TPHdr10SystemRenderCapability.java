package com.tencent.thumbplayer.core.hdr.capability;

import android.os.Build;
import com.tencent.thumbplayer.core.hdr.capability.device.ITPManufactureHDRCapabilityInterface;
import com.tencent.thumbplayer.core.hdr.capability.device.TPManufacturerHDRCapabilityManager;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPHdr10SystemRenderCapability extends TPHdrCapabilityBase {
    private static final String TAG = "TPHdr10SystemRenderCapability";

    @Override // com.tencent.thumbplayer.core.hdr.capability.TPHdrCapabilityBase, com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public Set<Integer> getSupportedMappingTypes() {
        this.mSupportedMappingTypes.clear();
        if (isSupported()) {
            this.mSupportedMappingTypes.add(3);
        }
        return this.mSupportedMappingTypes;
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.TPHdrCapabilityBase, com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public boolean isSupported() {
        if (TPHdrSystemRenderBlackWhiteList.isCurrentDeviceInHdrWhiteList(0) || TPHdrSystemRenderBlackWhiteList.isManufacturerInHdrWhiteList(0)) {
            return true;
        }
        if (TPHdrSystemRenderBlackWhiteList.isCurrentDeviceInHdrBlackList(0) || TPHdrSystemRenderBlackWhiteList.isManufacturerInHdrBlackList(0)) {
            return false;
        }
        ITPManufactureHDRCapabilityInterface manufactureHDRCapability = TPManufacturerHDRCapabilityManager.getManufactureHDRCapability();
        if (manufactureHDRCapability != null) {
            return manufactureHDRCapability.isHDRSupport(0);
        }
        if (Build.VERSION.SDK_INT < 24 || !TPDisplayHdrCapability.isHdrSupported(2)) {
            return false;
        }
        return true;
    }
}
