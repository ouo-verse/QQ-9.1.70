package com.tencent.gamematrix.gmcg.base.pxlw;

/* loaded from: classes6.dex */
public class PxlwSrConfig {
    public final SrConfig[] sr_config;

    /* loaded from: classes6.dex */
    public static class SrConfig {
        public final int cmd;
        public int hsize;
        public final String name;
        public final String owner;
        public final int type;
        public final int value1 = 8;
        public final int value2 = 12;
        public final int value3 = 7;
        public final int value4 = 9;
        public int vsize;

        public SrConfig(String str, String str2, int i3, int i16) {
            this.name = str;
            this.owner = str2;
            this.cmd = i3;
            this.type = i16;
        }
    }

    public PxlwSrConfig(String str) {
        this.sr_config = r1;
        SrConfig[] srConfigArr = {new SrConfig("pt-sr-on", str, 192, 1), new SrConfig("frc-sr-on", str, 196, 2)};
    }

    public void setSize(int i3, int i16) {
        SrConfig[] srConfigArr = this.sr_config;
        SrConfig srConfig = srConfigArr[0];
        srConfig.hsize = i3;
        srConfig.vsize = i16;
        SrConfig srConfig2 = srConfigArr[1];
        srConfig2.hsize = i3;
        srConfig2.vsize = i16;
    }
}
