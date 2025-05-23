package com.pay.http;

import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class APBaseHttpAns implements IAPHttpAns {
    private APBaseHttpReq httpClient;
    private APHttpHandle httpHandler;
    public String httpReqKey;
    private HashMap<String, APBaseHttpReq> httpReqMap;
    private IAPHttpAnsObserver observer;
    private final int REQUESTMAX = 1;
    public int resultCode = -1;
    public String resultMsg = "";
    public String errorMsg = "";
    private int requestAgainCount = 0;

    public APBaseHttpAns(APHttpHandle aPHttpHandle, IAPHttpAnsObserver iAPHttpAnsObserver, HashMap<String, APBaseHttpReq> hashMap, String str) {
        this.httpHandler = aPHttpHandle;
        this.httpReqMap = hashMap;
        this.httpReqKey = str;
        this.observer = iAPHttpAnsObserver;
        aPHttpHandle.register(str, iAPHttpAnsObserver);
    }

    private void register(APBaseHttpReq aPBaseHttpReq) {
        this.httpReqMap.put(this.httpReqKey, aPBaseHttpReq);
    }

    private void sendErrorMessage() {
        Message message = new Message();
        message.what = 4;
        message.obj = this;
        this.httpHandler.sendMessage(message);
    }

    private void sendFinishMessage(byte[] bArr) {
        Message message = new Message();
        message.what = 3;
        message.obj = this;
        this.httpHandler.sendMessage(message);
    }

    private void sendStopMessage() {
        Message message = new Message();
        message.what = 5;
        message.obj = this;
        this.httpHandler.sendMessage(message);
    }

    private void unRegister() {
        this.httpReqMap.remove(this.httpReqKey);
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getHttpReqKey() {
        return this.httpReqKey;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMessage() {
        return this.resultMsg;
    }

    @Override // com.pay.http.IAPHttpAns
    public void onError(APBaseHttpReq aPBaseHttpReq, int i3, String str) {
        this.errorMsg = str;
        this.resultMsg = str;
        this.resultCode = i3;
        unRegister();
        onErrorAns(aPBaseHttpReq);
        sendErrorMessage();
    }

    @Override // com.pay.http.IAPHttpAns
    public void onFinish(APBaseHttpReq aPBaseHttpReq) {
        unRegister();
        if (aPBaseHttpReq.getContent() == null) {
            this.resultCode = -1;
            this.resultMsg = "";
            sendErrorMessage();
        } else {
            this.httpClient = aPBaseHttpReq;
            onFinishAns(aPBaseHttpReq.getContent(), aPBaseHttpReq);
            sendFinishMessage(aPBaseHttpReq.getContent());
        }
    }

    @Override // com.pay.http.IAPHttpAns
    public void onReceive(byte[] bArr, int i3, long j3, APBaseHttpReq aPBaseHttpReq) {
        onReceiveAns(bArr, i3, j3, aPBaseHttpReq);
    }

    @Override // com.pay.http.IAPHttpAns
    public void onStart(APBaseHttpReq aPBaseHttpReq) {
        register(aPBaseHttpReq);
        onStartAns(aPBaseHttpReq);
    }

    @Override // com.pay.http.IAPHttpAns
    public void onStop(APBaseHttpReq aPBaseHttpReq) {
        unRegister();
        onStopAns(aPBaseHttpReq);
        sendStopMessage();
    }

    public void reRegister() {
        this.httpHandler.register(this.httpReqKey, this.observer);
    }

    public void requestAgain() {
        int i3;
        if (this.httpClient != null && (i3 = this.requestAgainCount) <= 1) {
            this.requestAgainCount = i3 + 1;
            reRegister();
            new BaseThread(new Runnable() { // from class: com.pay.http.APBaseHttpAns.1
                @Override // java.lang.Runnable
                public void run() {
                    APBaseHttpAns.this.httpClient.requestAgain();
                }
            }).start();
        } else {
            reRegister();
            onError(this.httpClient, -1, "");
        }
    }

    public void onErrorAns(APBaseHttpReq aPBaseHttpReq) {
    }

    public void onStartAns(APBaseHttpReq aPBaseHttpReq) {
    }

    public void onStopAns(APBaseHttpReq aPBaseHttpReq) {
    }

    public void onFinishAns(byte[] bArr, APBaseHttpReq aPBaseHttpReq) {
    }

    public void onReceiveAns(byte[] bArr, int i3, long j3, APBaseHttpReq aPBaseHttpReq) {
    }
}
