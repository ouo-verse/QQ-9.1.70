package com.tencent.ad.tangram.lbs;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.biz.common.util.WebViewConstants;
import java.io.Serializable;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdLocation implements Serializable {
    private static final String TAG = "AdLocation";
    public double latitude = -2.147483648E9d;
    public double longitude = -2.147483648E9d;
    public long timeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    @Nullable
    public static AdLocation merge(@Nullable AdLocation adLocation, @Nullable AdLocation adLocation2) {
        if (adLocation == null || !adLocation.isValid()) {
            adLocation = null;
        }
        if (adLocation2 != null && adLocation2.isValid()) {
            if (adLocation != null) {
                long j3 = adLocation.timeMillis;
                if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH || adLocation2.timeMillis == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                    if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                        long j16 = adLocation2.timeMillis;
                        if (j16 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 < j16) {
                            return adLocation2;
                        }
                    }
                } else {
                    return adLocation2;
                }
            } else {
                return adLocation2;
            }
        }
        return adLocation;
    }

    public boolean isValid() {
        if (this.latitude != -2.147483648E9d && this.longitude != -2.147483648E9d) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("latitude:%f longitude:%f timeMillis:%d", Double.valueOf(this.latitude), Double.valueOf(this.longitude), Long.valueOf(this.timeMillis));
    }
}
