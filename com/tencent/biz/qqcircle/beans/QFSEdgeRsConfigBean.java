package com.tencent.biz.qqcircle.beans;

import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSEdgeRsConfigBean {

    @SerializedName("exp_layer_list")
    public String expLayerList;

    @SerializedName("sdk_version")
    public SdkVersionBean sdkVersion;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class SdkVersionBean {
        public String max;
        public String min;

        public String toString() {
            return "SdkVersionBean{min='" + this.min + "', max='" + this.max + "'}";
        }
    }

    public String toString() {
        return "EdgeRsConfigBean{sdk_version=" + this.sdkVersion + ", exp_layer_list='" + this.expLayerList + "'}";
    }
}
