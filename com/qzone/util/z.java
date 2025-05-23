package com.qzone.util;

import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private int f59850a = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_PICTURE_LIMIT_WIDTH, 500);

    public int[] c(int i3, int i16, int i17, int i18) {
        int i19 = this.f59850a;
        if (i19 > 0 && i16 < i19) {
            float f16 = i16;
            float f17 = i3;
            float min = Math.min((i18 / 2.0f) / f16, i17 / f17);
            return new int[]{(int) (f16 * min), (int) (f17 * min)};
        }
        return a(i3, i16, i17, i18);
    }

    public static boolean b(PhotoInfo photoInfo) {
        return (photoInfo == null || photoInfo.videoflag != 1 || photoInfo.videodata == null) ? false : true;
    }

    public int[] a(int i3, int i16, int i17, int i18) {
        double d16 = i16;
        double d17 = i3;
        double d18 = d16 / d17;
        double d19 = i18;
        double d26 = i17;
        if (d18 > d19 / d26) {
            i17 = (int) (d19 * (d17 / d16));
        } else {
            i18 = (int) (d26 * d18);
        }
        return new int[]{i18, i17};
    }
}
