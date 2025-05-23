package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import com.tencent.mobileqq.mini.server.RequestCallback;
import com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$VacGetGoodsReq;
import com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$VacGetGoodsRsp;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes33.dex */
public class EcommerceRequest {
    private static final String TAG = "EcommerceRequest";
    private static volatile EcommerceRequest mInstance;
    private ConcurrentHashMap<Integer, RequestCallback<VacAdvGet$VacGetGoodsRsp>> mEcommerceGoodsCallbackHashMap = new ConcurrentHashMap<>();

    public static EcommerceRequest getInstance() {
        if (mInstance == null) {
            synchronized (EcommerceRequest.class) {
                if (mInstance == null) {
                    mInstance = new EcommerceRequest();
                }
            }
        }
        return mInstance;
    }

    public void requestEcommerceGoods(VacAdvGet$VacGetGoodsReq vacAdvGet$VacGetGoodsReq, RequestCallback<VacAdvGet$VacGetGoodsRsp> requestCallback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "requestEcommerceGoods , get null appRuntime , requestEcommerceGoods cancel");
                return;
            }
            return;
        }
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), EcommerceServlet.class);
        newIntent.putExtra("data", fh.b(vacAdvGet$VacGetGoodsReq.toByteArray()));
        newIntent.putExtra("cmd", EcommerceServlet.CMD_SSO_GET_GOODS);
        if (requestCallback != null) {
            int hashCode = requestCallback.hashCode();
            this.mEcommerceGoodsCallbackHashMap.put(Integer.valueOf(hashCode), requestCallback);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "requestEcommerceGoods , key = " + hashCode + " map =  " + this.mEcommerceGoodsCallbackHashMap.toString());
            }
            newIntent.putExtra("requestKey", hashCode);
        }
        peekAppRuntime.startServlet(newIntent);
    }

    private boolean isRspValid(VacAdvGet$VacGetGoodsRsp vacAdvGet$VacGetGoodsRsp) {
        if (vacAdvGet$VacGetGoodsRsp == null) {
            QLog.e(TAG, 1, "vacGetGoodsRsp is null");
            return false;
        }
        if (vacAdvGet$VacGetGoodsRsp.total_num.get() != 0 && vacAdvGet$VacGetGoodsRsp.good_infos.size() != 0) {
            return true;
        }
        QLog.e(TAG, 1, "vacGetGoodsRsp.good_infos is null");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGetGoodsRsp(Intent intent, FromServiceMsg fromServiceMsg) {
        RequestCallback<VacAdvGet$VacGetGoodsRsp> requestCallback;
        byte[] bArr = null;
        if (intent != null) {
            int intExtra = intent.getIntExtra("requestKey", -1);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "onGetGoodsRsp , callbackKey = " + intExtra + " map = " + this.mEcommerceGoodsCallbackHashMap.toString());
            }
            if (this.mEcommerceGoodsCallbackHashMap.get(Integer.valueOf(intExtra)) != null) {
                requestCallback = this.mEcommerceGoodsCallbackHashMap.get(Integer.valueOf(intExtra));
                if (requestCallback == null) {
                    requestCallback = null;
                }
                this.mEcommerceGoodsCallbackHashMap.remove(Integer.valueOf(intExtra));
                if (fromServiceMsg.isSuccess()) {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr2 = new byte[length];
                    PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    bArr = bArr2;
                }
                VacAdvGet$VacGetGoodsRsp vacAdvGet$VacGetGoodsRsp = new VacAdvGet$VacGetGoodsRsp();
                int resultCode = fromServiceMsg.getResultCode();
                if (bArr != null) {
                    QLog.e(TAG, 1, "onGetGoodsRsp error: unpack bytes is null");
                    return;
                }
                if (resultCode == 1000) {
                    try {
                        vacAdvGet$VacGetGoodsRsp.mergeFrom(bArr);
                        if (requestCallback != null) {
                            if (isRspValid(vacAdvGet$VacGetGoodsRsp)) {
                                requestCallback.onReqSucceed(vacAdvGet$VacGetGoodsRsp);
                                QLog.d(TAG, 1, "onGetGoodsRsp success");
                            } else {
                                String str = "onGetGoodsRsp fail: vacGetGoodsRsp is inValid, err_msg:" + vacAdvGet$VacGetGoodsRsp.err_msg.get();
                                requestCallback.onReqFailed(resultCode, str);
                                QLog.e(TAG, 1, str);
                            }
                        } else {
                            QLog.e(TAG, 1, "onGetGoodsRsp fail: callback is null");
                        }
                        return;
                    } catch (Exception e16) {
                        if (requestCallback != null) {
                            requestCallback.onReqFailed(resultCode, "onGetGoodsRsp fail: merge from bytes exception");
                        }
                        QLog.e(TAG, 1, "onGetGoodsRsp fail: merge from bytes exception" + e16);
                        return;
                    }
                }
                String str2 = "onGetGoodsRsp fail: result: " + resultCode;
                if (requestCallback != null) {
                    requestCallback.onReqFailed(resultCode, str2);
                }
                QLog.e(TAG, 1, str2);
                return;
            }
        }
        requestCallback = null;
        if (fromServiceMsg.isSuccess()) {
        }
        VacAdvGet$VacGetGoodsRsp vacAdvGet$VacGetGoodsRsp2 = new VacAdvGet$VacGetGoodsRsp();
        int resultCode2 = fromServiceMsg.getResultCode();
        if (bArr != null) {
        }
    }
}
