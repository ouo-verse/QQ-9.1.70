package com.tencent.richframework.sender.interceptor;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.sender.chain.SenderChain;
import com.tencent.richframework.sender.util.EventControlUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class MergeReqInterceptor<T, E extends SenderChain> implements ReqInterceptor<T, E> {
    private static final Map<String, Object> sPreRequest = new ConcurrentHashMap();

    public abstract long getMergeInterval(T t16);

    public abstract String getMergeKey(T t16);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.richframework.sender.interceptor.ReqInterceptor
    public synchronized void interceptAddReq(T t16, final E e16) {
        if (t16 != null && e16 != null) {
            final String mergeKey = getMergeKey(t16);
            if (!TextUtils.isEmpty(mergeKey)) {
                Map<String, Object> map = sPreRequest;
                Object obj = map.get(mergeKey);
                if (obj == null) {
                    RFWLog.d(getMergeKey(t16), RFWLog.USR, "preReq is null");
                    map.put(mergeKey, t16);
                } else {
                    Object mergeReq = mergeReq(obj, t16);
                    if (mergeReq == null) {
                        map.remove(mergeKey);
                    } else {
                        map.put(mergeKey, mergeReq);
                    }
                }
                EventControlUtils.debounceDelay(mergeKey, getMergeInterval(t16), new EventControlUtils.OnDebounceListener() { // from class: com.tencent.richframework.sender.interceptor.MergeReqInterceptor.1
                    @Override // com.tencent.richframework.sender.util.EventControlUtils.OnDebounceListener
                    public void onExecute() {
                        Object obj2 = MergeReqInterceptor.sPreRequest.get(mergeKey);
                        if (obj2 != null) {
                            e16.addRequest(obj2);
                            MergeReqInterceptor.sPreRequest.remove(mergeKey);
                        }
                    }
                });
            } else {
                e16.addRequest(t16);
            }
        }
    }

    public abstract T mergeReq(T t16, T t17);
}
