package com.tencent.midas.data;

/* loaded from: classes9.dex */
public class APDataId {
    private static APDataId gInstance;
    private static int paydataCount;
    private final String TENCENTUNIPAY_DATAID_FLAG = APPluginDataInterface.SHARE_PREFERENCE_NAME;
    private final String DATA_DISCOUNT_INIT = "initdataCount";
    private final String DATA_DISCOUNT_PAY = "dataCount";

    APDataId() {
    }

    public static int getDataId() {
        int i3 = paydataCount;
        paydataCount = i3 + 1;
        return i3;
    }

    public static void initDataId() {
        paydataCount = 0;
    }
}
