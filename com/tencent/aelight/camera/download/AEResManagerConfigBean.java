package com.tencent.aelight.camera.download;

import com.google.gson.annotations.SerializedName;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.freesia.IConfigData;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEResManagerConfigBean implements Serializable, IConfigData {
    public static final String BUNDLE_SPECIAL = "1";
    public static final String DEFAULT_VERSION = "0.0.0";

    @SerializedName(AECameraConstants.BUNDLE_LIST)
    private List<AEResBean> bundleList;
    private String version = DEFAULT_VERSION;

    @SerializedName(AECameraConstants.BUNDLE_PAGVERSION)
    private String pagVersion = DEFAULT_VERSION;

    @SerializedName(AECameraConstants.BUNDLE_FILAMENTVERSION)
    private String filamentVersion = DEFAULT_VERSION;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AEResBean implements Serializable {

        @SerializedName("agent_type")
        String agentType;

        @SerializedName("bundle_name")
        String bundleName;

        @SerializedName("bundle_special")
        String bundleSpecial;
        PhoneLevelConfig high;

        @SerializedName("high-gzip")
        PhoneLevelConfig highGzip;

        @SerializedName("high_hexagon")
        PhoneLevelConfig highHexagon;
        PhoneLevelConfig low;

        @SerializedName("low-gzip")
        PhoneLevelConfig lowGzip;
        PhoneLevelConfig middle;

        @SerializedName("middle-gzip")
        PhoneLevelConfig middleGzip;

        @SerializedName("veryhigh")
        PhoneLevelConfig veryHigh;

        @SerializedName("veryhigh-gzip")
        PhoneLevelConfig veryHighGzip;

        @SerializedName("veryhigh_hexagon")
        PhoneLevelConfig veryHighHexagon;

        @SerializedName("verylow")
        PhoneLevelConfig veryLow;

        @SerializedName("verylow-gzip")
        PhoneLevelConfig veryLowGzip;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static class PhoneLevelConfig implements Serializable {
            String md5;
            String url;

            public String getMd5() {
                return this.md5;
            }

            public String getUrl() {
                return this.url;
            }

            public void setMd5(String str) {
                this.md5 = str;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public String getAgentType() {
            return this.agentType;
        }

        public String getBundleName() {
            return this.bundleName;
        }

        public PhoneLevelConfig getHigh() {
            return this.high;
        }

        public PhoneLevelConfig getHighGzip() {
            return this.highGzip;
        }

        public PhoneLevelConfig getHighHexagon() {
            return this.highHexagon;
        }

        public PhoneLevelConfig getLow() {
            return this.low;
        }

        public PhoneLevelConfig getLowGzip() {
            return this.lowGzip;
        }

        public PhoneLevelConfig getMiddle() {
            return this.middle;
        }

        public PhoneLevelConfig getMiddleGzip() {
            return this.middleGzip;
        }

        public PhoneLevelConfig getVeryHigh() {
            return this.veryHigh;
        }

        public PhoneLevelConfig getVeryHighGzip() {
            return this.veryHighGzip;
        }

        public PhoneLevelConfig getVeryHighHexagon() {
            return this.veryHighHexagon;
        }

        public PhoneLevelConfig getVeryLow() {
            return this.veryLow;
        }

        public PhoneLevelConfig getVeryLowGzip() {
            return this.veryLowGzip;
        }

        public boolean isBundleSpecial() {
            String str = this.bundleSpecial;
            if (str != null && "1".equals(str)) {
                return true;
            }
            return false;
        }

        public void setAgentType(String str) {
            this.agentType = str;
        }

        public void setBundleName(String str) {
            this.bundleName = str;
        }

        public void setHigh(PhoneLevelConfig phoneLevelConfig) {
            this.high = phoneLevelConfig;
        }

        public void setLow(PhoneLevelConfig phoneLevelConfig) {
            this.low = phoneLevelConfig;
        }

        public void setMiddle(PhoneLevelConfig phoneLevelConfig) {
            this.middle = phoneLevelConfig;
        }

        public void setVeryHigh(PhoneLevelConfig phoneLevelConfig) {
            this.veryHigh = phoneLevelConfig;
        }

        public void setVeryLow(PhoneLevelConfig phoneLevelConfig) {
            this.veryLow = phoneLevelConfig;
        }
    }

    public List<AEResBean> getBundleList() {
        return this.bundleList;
    }

    public String getFilamentVersion() {
        return this.filamentVersion;
    }

    public String getPagVersion() {
        return this.pagVersion;
    }

    public String getVersion() {
        return this.version;
    }

    public void setBundleList(List<AEResBean> list) {
        this.bundleList = list;
    }

    public void setFilamentVersion(String str) {
        this.filamentVersion = str;
    }

    public void setPagVersion(String str) {
        this.pagVersion = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{version='" + this.version + "'}";
    }
}
