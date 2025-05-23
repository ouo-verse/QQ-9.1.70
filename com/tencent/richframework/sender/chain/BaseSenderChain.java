package com.tencent.richframework.sender.chain;

import android.os.Bundle;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BaseSenderChain<Q> implements SenderChain<Q> {
    private Bundle mExtraData;
    private int mHandleReqIndex;
    private int mHandleRspIndex;
    private List<SenderChain> mOutputSenderChains;
    private List<ReqInterceptor> mReqInterceptors;
    private List<RspInterceptor> mRspInterceptors;
    private WeakReference<Call.OnRspCallBack> mWRFListener;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class BaseSenderChainBuilder {
        private Bundle mExtraData;
        private int mHandleReqIndex;
        private int mHandleRspIndex;
        private List<SenderChain> mOutputSenderChains;
        private List<ReqInterceptor> mReqInterceptors;
        private List<RspInterceptor> mRspInterceptors;
        private WeakReference<Call.OnRspCallBack> mWRFListener;

        BaseSenderChainBuilder() {
        }

        public static BaseSenderChainBuilder newBuilder() {
            return new BaseSenderChainBuilder();
        }

        public BaseSenderChain build() {
            BaseSenderChain baseSenderChain = new BaseSenderChain();
            baseSenderChain.mHandleRspIndex = this.mHandleRspIndex;
            baseSenderChain.mHandleReqIndex = this.mHandleReqIndex;
            baseSenderChain.mWRFListener = this.mWRFListener;
            baseSenderChain.mExtraData = this.mExtraData;
            baseSenderChain.mReqInterceptors = this.mReqInterceptors;
            baseSenderChain.mRspInterceptors = this.mRspInterceptors;
            baseSenderChain.mOutputSenderChains = this.mOutputSenderChains;
            return baseSenderChain;
        }

        public BaseSenderChainBuilder withExtraData(Bundle bundle) {
            this.mExtraData = bundle;
            return this;
        }

        public BaseSenderChainBuilder withHandleReqIndex(int i3) {
            this.mHandleReqIndex = i3;
            return this;
        }

        public BaseSenderChainBuilder withHandleRspIndex(int i3) {
            this.mHandleRspIndex = i3;
            return this;
        }

        public BaseSenderChainBuilder withOutputSenderChain(List<SenderChain> list) {
            this.mOutputSenderChains = list;
            return this;
        }

        public BaseSenderChainBuilder withReqInterceptors(List<ReqInterceptor> list) {
            this.mReqInterceptors = list;
            return this;
        }

        public BaseSenderChainBuilder withRspInterceptors(List<RspInterceptor> list) {
            this.mRspInterceptors = list;
            return this;
        }

        public BaseSenderChainBuilder withWRFListener(WeakReference<Call.OnRspCallBack> weakReference) {
            this.mWRFListener = weakReference;
            return this;
        }
    }

    protected BaseSenderChain() {
    }

    @Override // com.tencent.richframework.sender.chain.SenderChain
    public void addRequest(Q q16) {
        if (q16 == null) {
            return;
        }
        if (this.mHandleReqIndex >= this.mReqInterceptors.size()) {
            RFWLog.e("QCircleSendChain", RFWLog.USR, "addRequest: errorIndex");
            return;
        }
        ReqInterceptor reqInterceptor = this.mReqInterceptors.get(this.mHandleReqIndex);
        BaseSenderChainBuilder withWRFListener = BaseSenderChainBuilder.newBuilder().withReqInterceptors(this.mReqInterceptors).withRspInterceptors(this.mRspInterceptors).withWRFListener(this.mWRFListener);
        int i3 = this.mHandleReqIndex + 1;
        this.mHandleReqIndex = i3;
        reqInterceptor.interceptAddReq(q16, withWRFListener.withHandleReqIndex(i3).withHandleRspIndex(this.mHandleRspIndex).withExtraData(this.mExtraData).withOutputSenderChain(this.mOutputSenderChains).build());
    }

    public void callBackRsp(final boolean z16, final long j3, final String str, final Q q16, final Object obj) {
        WeakReference<Call.OnRspCallBack> weakReference = this.mWRFListener;
        if (weakReference != null) {
            final Call.OnRspCallBack onRspCallBack = weakReference.get();
            if (onRspCallBack != null) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.richframework.sender.chain.BaseSenderChain.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onRspCallBack.onReceive(z16, j3, str, q16, obj, BaseSenderChain.this.mExtraData);
                    }
                });
            } else {
                RFWLog.d("QCircleSendChain", RFWLog.USR, "callBack is null");
            }
        }
        List<SenderChain> list = this.mOutputSenderChains;
        if (list != null) {
            Iterator<SenderChain> it = list.iterator();
            while (it.hasNext()) {
                it.next().handleRsp(z16, j3, str, q16, obj);
            }
        }
    }

    public Bundle getExtraData() {
        return this.mExtraData;
    }

    public Call.OnRspCallBack getListener() {
        WeakReference<Call.OnRspCallBack> weakReference = this.mWRFListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tencent.richframework.sender.chain.SenderChain
    public void handleRsp(boolean z16, long j3, String str, Q q16, Object obj) {
        if (this.mHandleRspIndex > this.mRspInterceptors.size()) {
            RFWLog.e("QCircleSendChain", RFWLog.USR, "handleRspAsync: errorIndex");
        } else if (this.mHandleRspIndex == this.mRspInterceptors.size()) {
            callBackRsp(z16, j3, str, q16, obj);
        } else {
            this.mRspInterceptors.get(this.mHandleRspIndex).interceptReturnRsp(z16, j3, str, q16, obj, BaseSenderChainBuilder.newBuilder().withReqInterceptors(this.mReqInterceptors).withRspInterceptors(this.mRspInterceptors).withWRFListener(this.mWRFListener).withHandleReqIndex(this.mHandleReqIndex).withHandleRspIndex(this.mHandleRspIndex + 1).withExtraData(this.mExtraData).withOutputSenderChain(this.mOutputSenderChains).build());
        }
    }
}
