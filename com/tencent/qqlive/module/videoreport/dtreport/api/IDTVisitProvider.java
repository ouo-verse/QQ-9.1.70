package com.tencent.qqlive.module.videoreport.dtreport.api;

/* loaded from: classes22.dex */
interface IDTVisitProvider {

    /* loaded from: classes22.dex */
    public @interface StartType {
        public static final int ICON = 0;
        public static final int NONE = -1;
        public static final int PUSH = 1;
    }

    String getActiveInfo();

    String getCallFrom();

    String getCallScheme();

    @StartType
    int getStartType();
}
