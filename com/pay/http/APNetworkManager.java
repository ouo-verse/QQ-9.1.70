package com.pay.http;

import android.text.TextUtils;
import com.pay.network.model.APDataReportAns;
import com.pay.network.model.APDataReportReq;
import com.tencent.midas.data.APPluginDataInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class APNetworkManager {
    public static final String HTTP_KEY_DATAREPORT = "datareport";
    public static final String HTTP_KEY_INITREPORT = "initreport";
    private static APNetworkManager gInstance;
    private HashMap<String, APBaseHttpReq> httpReqMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class APNetworkManagerHolder {
        private static final APNetworkManager INSTANCE = new APNetworkManager();

        APNetworkManagerHolder() {
        }
    }

    public static void cancelRequest(String str) {
        APBaseHttpReq aPBaseHttpReq = gInstance.httpReqMap.get(str);
        if (aPBaseHttpReq != null) {
            aPBaseHttpReq.stopRequest();
            gInstance.httpReqMap.remove(str);
        }
    }

    public static APNetworkManager getInstance() {
        if (gInstance == null) {
            gInstance = APNetworkManagerHolder.INSTANCE;
        }
        return gInstance;
    }

    public static void release() {
        gInstance = null;
    }

    public void cancelPreRequest() {
        if (gInstance.httpReqMap != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, APBaseHttpReq> entry : gInstance.httpReqMap.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue());
                }
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                APBaseHttpReq aPBaseHttpReq = (APBaseHttpReq) arrayList.get(i3);
                if (aPBaseHttpReq != null) {
                    aPBaseHttpReq.stopRequest();
                }
            }
            gInstance.httpReqMap.clear();
        }
    }

    public void dataReport(String str, IAPHttpAnsObserver iAPHttpAnsObserver) {
        if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId())) {
            return;
        }
        APDataReportReq aPDataReportReq = new APDataReportReq();
        aPDataReportReq.setHttpAns(new APDataReportAns(APHttpHandle.getIntanceHandel(), iAPHttpAnsObserver, this.httpReqMap, HTTP_KEY_DATAREPORT));
        aPDataReportReq.startService(str);
    }
}
