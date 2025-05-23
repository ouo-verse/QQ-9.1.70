package com.tencent.ad.tangram.protocol;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class click {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Response implements Serializable {
        public Data data;
        public int ret = Integer.MIN_VALUE;

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class Data implements Serializable {
            public String clickid;
            public String dstlink;
        }
    }
}
