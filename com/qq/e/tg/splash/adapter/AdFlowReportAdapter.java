package com.qq.e.tg.splash.adapter;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface AdFlowReportAdapter {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Params {
        public long costTime;
        public String entrancePath;
        public String flowAmount;
        public int netType;
        public String url;
    }

    void report(Params params);
}
