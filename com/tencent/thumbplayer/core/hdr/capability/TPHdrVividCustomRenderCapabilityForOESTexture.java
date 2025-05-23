package com.tencent.thumbplayer.core.hdr.capability;

import com.tencent.thumbplayer.core.utils.TPSurfaceTexture;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPHdrVividCustomRenderCapabilityForOESTexture extends TPHdrCapabilityBase {
    private static final String TAG = "TPHdrVividCustomRenderCapabilityForOESTexture";

    private boolean isSupportHdrVividSoftDynamicMapping() {
        if (!isSupportOnFrameAvailableOnNonMainThread() || !TPHDRCapabilityConfig.getHdrVividSoftDynamicMappingEnable() || !TPHdrVividCustomRenderBlackWhiteListForOESTexture.isCurrentDeviceInHdrMappingTypeWhiteList(2)) {
            return false;
        }
        return true;
    }

    private boolean isSupportHdrVividSoftSdrDynamicMapping() {
        if (!isSupportOnFrameAvailableOnNonMainThread() || !TPHDRCapabilityConfig.getHdrVividSoftSdrDynamicMappingEnable() || !TPHdrVividCustomRenderBlackWhiteListForOESTexture.isCurrentDeviceInHdrMappingTypeWhiteList(5)) {
            return false;
        }
        return true;
    }

    private boolean isSupportOnFrameAvailableOnNonMainThread() {
        return TPSurfaceTexture.isSupportOnFrameAvailableOnNonMainThread();
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.TPHdrCapabilityBase, com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public Set<Integer> getSupportedMappingTypes() {
        HashSet hashSet = new HashSet();
        if (isSupportHdrVividSoftDynamicMapping()) {
            hashSet.add(2);
        }
        if (isSupportHdrVividSoftSdrDynamicMapping()) {
            hashSet.add(5);
        }
        return hashSet;
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.TPHdrCapabilityBase, com.tencent.thumbplayer.core.hdr.capability.ITPHdrCapability
    public boolean isSupported() {
        if (!isSupportHdrVividSoftDynamicMapping() && !isSupportHdrVividSoftSdrDynamicMapping()) {
            return false;
        }
        return true;
    }
}
