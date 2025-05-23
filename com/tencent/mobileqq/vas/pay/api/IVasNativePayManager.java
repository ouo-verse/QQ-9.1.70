package com.tencent.mobileqq.vas.pay.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.Map;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasNativePayManager extends QRouteApi {
    public static final String TITLE_GOLD_NOT_ENOUGH = "\u4f59\u989d\u4e0d\u8db3\uff0c\u8bf7\u5145\u503c";
    public static final String TITLE_RECHARGE = "\u5145\u503c";

    /* loaded from: classes20.dex */
    public interface PayObserver {
        void onOpenPayViewFail();

        void onOpenPayViewSuccess();

        void onPayError(int i3);

        void onPaySuccess();

        void onPayViewClose();
    }

    /* loaded from: classes20.dex */
    public static class ReportData {
        public String mBusinessId;
        public Map<String, String> mDtData = new HashMap();
        public String mExt;
        public String mSource;
        public String mSubBusinessId;

        public ReportData(String str, String str2, String str3, String str4) {
            this.mBusinessId = str;
            this.mSubBusinessId = str2;
            this.mSource = str3;
            this.mExt = str4;
        }

        public String toString() {
            return "ReportData{mBusinessId='" + this.mBusinessId + "', mSubBusinessId='" + this.mSubBusinessId + "', mSource='" + this.mSource + "', mExt='" + this.mExt + "', mDtData=" + this.mDtData + '}';
        }
    }

    void directdPay(Activity activity, int i3, ReportData reportData, PayObserver payObserver);

    void hidePayPanel();

    IVasNativePayManager initAndShowPayPanel(Activity activity, String str, String str2, ReportData reportData, PayObserver payObserver);

    boolean isSwitchEnable();
}
