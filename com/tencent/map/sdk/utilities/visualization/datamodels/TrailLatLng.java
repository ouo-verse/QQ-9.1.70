package com.tencent.map.sdk.utilities.visualization.datamodels;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TrailLatLng {
    private TimeLatLng[] trailData;

    public TrailLatLng(TimeLatLng[] timeLatLngArr) {
        boolean z16;
        if (timeLatLngArr != null && timeLatLngArr.length >= 2) {
            int i3 = 0;
            while (true) {
                z16 = true;
                if (i3 >= timeLatLngArr.length - 1) {
                    break;
                }
                int time = timeLatLngArr[i3].getTime();
                i3++;
                if (time >= timeLatLngArr[i3].getTime()) {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                this.trailData = timeLatLngArr;
                return;
            } else {
                this.trailData = new TimeLatLng[0];
                return;
            }
        }
        this.trailData = new TimeLatLng[0];
    }

    public TimeLatLng[] getTrailData() {
        return this.trailData;
    }
}
