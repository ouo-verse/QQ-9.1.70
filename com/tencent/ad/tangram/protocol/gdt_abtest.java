package com.tencent.ad.tangram.protocol;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class gdt_abtest {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ABTest {
        public static final int ALL = 1;
        public static final int NONE = 0;
        public static final int UV_BY_UIN = 2;
        public int mode = 0;
        public LimitByUIN limitByUIN = new LimitByUIN();

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class LimitByUIN {
            public String[] blackList;
            public String lower;
            public String upper;
            public String[] whiteList;
        }
    }

    gdt_abtest() {
    }
}
