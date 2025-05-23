package com.tencent.qqlive.module.videoreport.sample.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleConfig {

    @SerializedName("check_sum")
    public String checkSum;

    @SerializedName("duration_hour")
    public int interval = -1;

    @SerializedName("switches")
    public Rule[] rules;

    @SerializedName("scene_code")
    public int sceneCode;
    public String version;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Param {

        @SerializedName("k")
        public String key;

        @SerializedName("v")
        public String[] values;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Param param = (Param) obj;
            if (Objects.equals(this.key, param.key) && Arrays.equals(this.values, param.values)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (Objects.hash(this.key) * 31) + Arrays.hashCode(this.values);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Rule implements Serializable {
        public Param[] params;
        public String event = "";
        public String page = "";
        public String element = "";

        @SerializedName(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE)
        public double sampleRate = 1.0d;
    }
}
