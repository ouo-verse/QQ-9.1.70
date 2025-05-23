package com.tencent.thumbplayer.core.hdr.capability;

/* loaded from: classes26.dex */
public class TPHdrVividCustomRenderCapability extends TPHdrCapabilityBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TPHdrVividCustomRenderCapability() {
        if (isSupportVividSoftDynamicMetadataMapping()) {
            this.mSupported = true;
            this.mSupportedMappingTypes.add(2);
        }
    }

    private boolean isSupportVividSoftDynamicMetadataMapping() {
        if (TPHDRCapabilityConfig.getHdrVividSoftDynamicMappingEnable() && TPHdrVividCustomRenderBlackWhiteList.isDeviceInHdrVividSoftDynamicMetadataRenderWhiteList()) {
            return true;
        }
        return false;
    }
}
