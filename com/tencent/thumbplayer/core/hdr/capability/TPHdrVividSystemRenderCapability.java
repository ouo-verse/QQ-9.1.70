package com.tencent.thumbplayer.core.hdr.capability;

import com.tencent.thumbplayer.core.hdr.capability.device.ITPManufactureHDRCapabilityInterface;
import com.tencent.thumbplayer.core.hdr.capability.device.TPManufacturerHDRCapabilityManager;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPHdrVividSystemRenderCapability extends TPHdrCapabilityBase {
    private static final String TAG = "TPHdrVividCapability";
    private TPHdr10SystemRenderCapability hdr10SystemRenderCapability = new TPHdr10SystemRenderCapability();

    private boolean isCanDownwardToHdr10StaticMetadataMapping() {
        return this.hdr10SystemRenderCapability.isSupported();
    }

    private boolean isSupportVividDynamicMetadataMapping() {
        if (!TPHDRCapabilityConfig.getHdrVividHardDynamicMappingEnable()) {
            return false;
        }
        if (TPHdrSystemRenderBlackWhiteList.isCurrentDeviceInHdrWhiteList(4) || TPHdrSystemRenderBlackWhiteList.isManufacturerInHdrWhiteList(4)) {
            return true;
        }
        if (TPHdrSystemRenderBlackWhiteList.isCurrentDeviceInHdrBlackList(4) || TPHdrSystemRenderBlackWhiteList.isManufacturerInHdrBlackList(4)) {
            return false;
        }
        ITPManufactureHDRCapabilityInterface manufactureHDRCapability = TPManufacturerHDRCapabilityManager.getManufactureHDRCapability();
        if (manufactureHDRCapability != null && manufactureHDRCapability.isHDRSupport(4)) {
            TPNativeLog.printLog(2, TAG, "manufacture support:true hdrType:4");
            return true;
        }
        return TPHdrVividBlackWhiteListForHuaWei.isDeviceInHdrVividMediaCodecWhiteList();
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.TPHdrCapabilityBase, com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public Set<Integer> getSupportedMappingTypes() {
        this.mSupportedMappingTypes.clear();
        if (isSupportVividDynamicMetadataMapping()) {
            this.mSupportedMappingTypes.add(1);
        }
        if (TPHDRCapabilityConfig.getHdrVividDownwardHDR10CompatibilityEnable() && isCanDownwardToHdr10StaticMetadataMapping()) {
            this.mSupportedMappingTypes.add(3);
        }
        return this.mSupportedMappingTypes;
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.TPHdrCapabilityBase, com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public boolean isSupported() {
        if (isSupportVividDynamicMetadataMapping()) {
            return true;
        }
        if (TPHDRCapabilityConfig.getHdrVividDownwardHDR10CompatibilityEnable() && isCanDownwardToHdr10StaticMetadataMapping()) {
            return true;
        }
        return false;
    }
}
