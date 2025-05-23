package com.tencent.richframework.sender.call;

import android.os.Bundle;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.chain.SenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class BaseCall<T> implements Call<T> {
    protected Call.OnRspCallBack mCallback;
    protected List<ReqInterceptor<T, BaseSenderChain>> mCustomReqInterceptor = new ArrayList();
    protected List<RspInterceptor> mCustomRspInterceptor = new ArrayList();
    protected Bundle mExtraData = new Bundle();
    protected List<T> mReqObjectList = new ArrayList();
    protected List<SenderChain> mOutputSenderChains = new ArrayList();

    public BaseCall<T> addExtraData(Bundle bundle) {
        this.mExtraData.putAll(bundle);
        return this;
    }

    public BaseCall<T> addInterceptor(Object obj) {
        if (obj instanceof ReqInterceptor) {
            addReqInterceptor((ReqInterceptor) obj);
        }
        if (obj instanceof RspInterceptor) {
            addRspInterceptor((RspInterceptor) obj);
        }
        return this;
    }

    public BaseCall<T> addReqInterceptor(ReqInterceptor reqInterceptor) {
        if (reqInterceptor != null) {
            this.mCustomReqInterceptor.add(reqInterceptor);
        }
        return this;
    }

    public BaseCall<T> addRequest(T t16) {
        if (t16 != null) {
            this.mReqObjectList.add(t16);
        }
        return this;
    }

    public BaseCall<T> addRspInterceptor(RspInterceptor rspInterceptor) {
        if (rspInterceptor != null) {
            this.mCustomRspInterceptor.add(rspInterceptor);
        }
        return this;
    }

    /* renamed from: setRspOnCallBack, reason: merged with bridge method [inline-methods] */
    public BaseCall<T> m250setRspOnCallBack(Call.OnRspCallBack onRspCallBack) {
        this.mCallback = onRspCallBack;
        return this;
    }
}
