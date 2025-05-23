package org.light;

import android.text.TextUtils;
import com.huawei.hms.hihealth.HiHealthActivities;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightBundleInfo {
    public String agent_type;
    public String bundle_name;
    public String bundle_special;
    public LightBundleDownloadInfo high;
    public boolean isSuccess = false;
    public LightBundleDownloadInfo low;
    public LightBundleDownloadInfo middle;
    public LightBundleDownloadInfo still;
    public LightBundleDownloadInfo veryhigh;
    public LightBundleDownloadInfo verylow;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class LightBundleDownloadInfo {
        public String md5;
        public String url;
    }

    public String getDownloadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1979547688:
                if (str.equals("veryhigh")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c16 = 1;
                    break;
                }
                break;
            case 107348:
                if (str.equals(HippyImageInfo.QUALITY_LOW)) {
                    c16 = 2;
                    break;
                }
                break;
            case 3202466:
                if (str.equals("high")) {
                    c16 = 3;
                    break;
                }
                break;
            case 109765032:
                if (str.equals(HiHealthActivities.STILL)) {
                    c16 = 4;
                    break;
                }
                break;
            case 351789662:
                if (str.equals("verylow")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                LightBundleDownloadInfo lightBundleDownloadInfo = this.veryhigh;
                if (lightBundleDownloadInfo == null) {
                    return null;
                }
                return lightBundleDownloadInfo.url;
            case 1:
                LightBundleDownloadInfo lightBundleDownloadInfo2 = this.middle;
                if (lightBundleDownloadInfo2 == null) {
                    return null;
                }
                return lightBundleDownloadInfo2.url;
            case 2:
                LightBundleDownloadInfo lightBundleDownloadInfo3 = this.low;
                if (lightBundleDownloadInfo3 == null) {
                    return null;
                }
                return lightBundleDownloadInfo3.url;
            case 3:
                LightBundleDownloadInfo lightBundleDownloadInfo4 = this.high;
                if (lightBundleDownloadInfo4 == null) {
                    return null;
                }
                return lightBundleDownloadInfo4.url;
            case 4:
                LightBundleDownloadInfo lightBundleDownloadInfo5 = this.still;
                if (lightBundleDownloadInfo5 == null) {
                    return null;
                }
                return lightBundleDownloadInfo5.url;
            case 5:
                LightBundleDownloadInfo lightBundleDownloadInfo6 = this.verylow;
                if (lightBundleDownloadInfo6 == null) {
                    return null;
                }
                return lightBundleDownloadInfo6.url;
            default:
                return null;
        }
    }
}
