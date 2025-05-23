package com.tencent.ad.tangram.protocol;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class gdt_experiment_settings {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class SettingsForJointExperiment {
        public String layerName = "";
        public ExpItem[] itemList = new ExpItem[0];

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class ExpItem {
            public String expId = "";
            public Range[] rangeList = new Range[0];
            public String[] expParamKey = new String[0];
            public String[] whiteList = new String[0];
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class Range {
            public int lower = 0;
            public int upper = 0;
        }
    }

    gdt_experiment_settings() {
    }
}
