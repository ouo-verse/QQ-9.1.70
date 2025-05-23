package com.huya.statistics.bean;

import android.util.ArrayMap;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SDKReport {

    @SerializedName("tHeader")
    public DataInfo tHeader;

    @SerializedName("vBody")
    public List<DataInfo> vBody;

    public void setvBody(List<DataInfo> list) {
        this.vBody = list;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DataInfo {

        @SerializedName("mPair")
        public Map<String, String> mPair;

        public DataInfo() {
            this.mPair = new ArrayMap();
        }

        public DataInfo(Map<String, String> map) {
            this.mPair = map;
        }
    }
}
