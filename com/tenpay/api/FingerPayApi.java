package com.tenpay.api;

import android.content.Context;
import android.os.ResultReceiver;
import java.util.HashMap;

/* loaded from: classes27.dex */
public class FingerPayApi extends EnterBase<IApiFinger> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class Ins {
        public static FingerPayApi mins = new FingerPayApi();

        Ins() {
        }
    }

    FingerPayApi() {
    }

    public static void closeFingerPay(Context context, String str) {
        IApiFinger logic = instance().getLogic(context);
        if (logic != null) {
            logic.closeFingerPay(context, str);
        }
    }

    public static void initFingerASK(Context context, HashMap<String, String> hashMap, ResultReceiver resultReceiver) {
        IApiFinger logic = instance().getLogic(context);
        if (logic != null) {
            logic.initFingerASK(context, hashMap, resultReceiver);
        }
    }

    public static FingerPayApi instance() {
        return Ins.mins;
    }

    @Override // com.tenpay.api.EnterBase
    protected String enterApi() {
        return IApiFinger.LOGIC;
    }
}
