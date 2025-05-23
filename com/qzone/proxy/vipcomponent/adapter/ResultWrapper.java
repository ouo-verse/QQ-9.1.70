package com.qzone.proxy.vipcomponent.adapter;

import com.qzone.common.business.result.QZoneResult;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ResultWrapper {

    /* renamed from: a, reason: collision with root package name */
    private QZoneResult f51001a;

    /* renamed from: b, reason: collision with root package name */
    private ServiceCallbackWrapper f51002b;

    ResultWrapper() {
    }

    public static ResultWrapper obtain(QZoneResult qZoneResult) {
        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.f51001a = qZoneResult;
        return resultWrapper;
    }

    public Object getData() {
        return this.f51001a.getData();
    }

    public String getFailedMsg() {
        return this.f51001a.getMessage();
    }

    public QZoneResult getResult() {
        return this.f51001a;
    }

    public int getReturnCode() {
        return this.f51001a.getReturnCode();
    }

    public boolean getSucceed() {
        return this.f51001a.getSucceed();
    }

    public int getWhat() {
        return this.f51001a.what;
    }

    public void serviceCallback() {
        ServiceCallbackWrapper serviceCallbackWrapper = this.f51002b;
        if (serviceCallbackWrapper != null) {
            serviceCallbackWrapper.onResult(this);
        }
    }

    public void setData(Object obj) {
        this.f51001a.setData(obj);
    }

    public void setFailReason(String str) {
        this.f51001a.setMessage(str);
    }

    public void setReturnCode(int i3) {
        this.f51001a.setReturnCode(i3);
    }

    public void setServiceCallbackWrapper(ServiceCallbackWrapper serviceCallbackWrapper) {
        this.f51002b = serviceCallbackWrapper;
    }

    public void setSucceed(boolean z16) {
        this.f51001a.setSucceed(z16);
    }

    public static ResultWrapper obtain(int i3) {
        QZoneResult qZoneResult = new QZoneResult(i3);
        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.f51001a = qZoneResult;
        return resultWrapper;
    }
}
