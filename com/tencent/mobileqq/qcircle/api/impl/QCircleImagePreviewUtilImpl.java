package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleImagePreviewUtil;
import com.tencent.mobileqq.utils.m;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;

/* loaded from: classes16.dex */
public class QCircleImagePreviewUtilImpl implements IQCircleImagePreviewUtil {
    private static final long mobileMemoryThreshold = 3500;

    private int[] getTargetWidthAndHeightWithHighMemory(int i3, int i16, int i17, int i18) {
        int i19 = i18 * 2;
        if (i16 >= i19 || i3 >= i17 * 2) {
            int i26 = i17 * 2;
            if ((i3 >= i26 && i16 < i19) || ((i16 < i19 || i3 >= i26) && i16 <= i3)) {
                i16 = (int) ((i26 / i3) * i16);
                i3 = i26;
            } else {
                i3 = (int) ((i19 / i16) * i3);
                i16 = i19;
            }
        }
        return new int[]{i3, i16};
    }

    private int[] getTargetWidthAndHeightWithLowMemory(int i3, int i16, int i17, int i18) {
        if (i16 >= i18 || i3 >= i17) {
            if ((i3 >= i17 && i16 < i18) || ((i16 < i18 || i3 >= i17) && i16 <= i3)) {
                i16 = (int) ((i17 / i3) * i16);
                i3 = i17;
            } else {
                i3 = (int) ((i18 / i16) * i3);
                i16 = i18;
            }
        }
        return new int[]{i3, i16};
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleImagePreviewUtil
    public int[] getTargetWidthAndHeight(int i3, int i16) {
        long c16 = m.c() / 1048576;
        int screenWidth = ImmersiveUtils.getScreenWidth();
        int screenHeight = ImmersiveUtils.getScreenHeight();
        if (screenHeight > 0 && screenWidth > 0 && i16 > 0 && i3 > 0) {
            if (QzoneConfig.isQQCircleShowHighQualityImagePreview()) {
                if (c16 > mobileMemoryThreshold) {
                    return getTargetWidthAndHeightWithHighMemory(i3, i16, screenWidth, screenHeight);
                }
                return getTargetWidthAndHeightWithLowMemory(i3, i16, screenWidth, screenHeight);
            }
            int screenWidth2 = ImmersiveUtils.getScreenWidth();
            return new int[]{screenWidth2, (int) ((screenWidth2 / i3) * i16)};
        }
        return null;
    }
}
