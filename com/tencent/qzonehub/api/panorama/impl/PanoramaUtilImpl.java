package com.tencent.qzonehub.api.panorama.impl;

import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.util.PanoramaUtil;
import java.util.ArrayList;

/* loaded from: classes34.dex */
public class PanoramaUtilImpl implements IPanoramaUtil {
    @Override // com.tencent.qzonehub.api.panorama.IPanoramaUtil
    public int computeSampleSize(Object obj, int i3, int i16) {
        return PanoramaUtil.getInstance().computeSampleSize((ImageLoader.Options) obj, i3, i16);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaUtil
    public ArrayList<float[]> getCylinderCoordinate(float f16, boolean z16) {
        return PanoramaUtil.getInstance().getCylinderCoordinate(f16, z16);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaUtil
    public ArrayList<float[]> getSphereCoordinate() {
        return PanoramaUtil.getInstance().getSphereCoordinate();
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaUtil
    public boolean isHighDevice() {
        return PanoramaUtil.getInstance().isHighDevice();
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaUtil
    public boolean isNeedShowPanorama() {
        return PanoramaUtil.getInstance().isNeedShowPanorama();
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaUtil
    public boolean isPanoramaPhoto(int i3) {
        return PanoramaUtil.isPanoramaPhoto(i3);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaUtil
    public void setPanoramaType(LocalMediaInfo localMediaInfo) {
        PanoramaUtil.setPanoramaType(localMediaInfo);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaUtil
    public void reportMta(String str, String str2, int i3) {
    }
}
