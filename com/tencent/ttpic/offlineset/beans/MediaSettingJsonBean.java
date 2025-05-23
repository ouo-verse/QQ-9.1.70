package com.tencent.ttpic.offlineset.beans;

import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MediaSettingJsonBean {
    public List<HardDecodeDevice> hardDecode;
    public List<HardEncodeDevice> hardEncode;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class HardDecodeDevice {
        public String brand;
        public int decodetype;
        public String model;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class HardEncodeDevice {
        public String brand;
        public int encodetype;
        public String model;
    }
}
