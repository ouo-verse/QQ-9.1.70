package com.tencent.mobileqq.openpay.constants;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface OpenConstants {
    public static final int API_MARK_PAY = 1;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface ApiName {
        public static final String PAY = "pay";
        public static final String PAY_V2 = "pay_v2";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface PayApi {
        public static final String OPEN_PAY_CALLBACK_EXTRA_KEY = "com_tencent_mobileqq_open_pay";
        public static final String OPEN_PAY_CALLBACK_EXTRA_TAG = "com.tencent.mobileqq.open.pay";
        public static final String OPEN_QQ_PAY_SCHEMA = "mqqwallet://open_pay/";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface PayChannel {
        public static final String CHANNEL_TENPAY = "0";
        public static final String CHANNEL_WX = "1";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface QQApp {
        public static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
        public static final String SDK_TAG = "mqqopenpay";
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface QQWalletErrCode {
        public static final int AUTH_FAIL = -1012;
        public static final int CANCEL = -11001;
        public static final int COMM_FAIL = -1;
        public static final int OK = 0;
        public static final int UNSUPPORT = -2;
    }
}
