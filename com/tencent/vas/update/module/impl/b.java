package com.tencent.vas.update.module.impl;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b implements uw4.b {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Long, IBusinessCallback> f384044a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private IBusinessCallback f384045b;

    @Override // uw4.b
    public IBusinessCallback a(long j3) {
        if (this.f384044a.get(Long.valueOf(j3)) != null) {
            return this.f384044a.get(Long.valueOf(j3));
        }
        return this.f384045b;
    }

    @Override // uw4.b
    public void b(@NonNull BusinessUpdateParams businessUpdateParams) {
        IBusinessCallback a16 = a(businessUpdateParams.mBid);
        if (a16 == null) {
            return;
        }
        UpdateListenerParams updateListenerParams = new UpdateListenerParams();
        updateListenerParams.mBusinessUpdateParams = businessUpdateParams;
        a16.onLoadSuccess(updateListenerParams);
    }

    @Override // uw4.b
    public void c(@NonNull BusinessUpdateParams businessUpdateParams, int i3, int i16, String str) {
        IBusinessCallback a16 = a(businessUpdateParams.mBid);
        if (a16 == null) {
            return;
        }
        UpdateListenerParams updateListenerParams = new UpdateListenerParams();
        updateListenerParams.mBusinessUpdateParams = businessUpdateParams;
        updateListenerParams.mErrorCode = i3;
        updateListenerParams.mErrorMessage = str;
        updateListenerParams.mHttpCode = i16;
        a16.onLoadFail(updateListenerParams);
    }

    @Override // uw4.b
    public void d(@NonNull BusinessUpdateParams businessUpdateParams, long j3, long j16, int i3) {
        IBusinessCallback a16 = a(businessUpdateParams.mBid);
        if (a16 == null) {
            return;
        }
        UpdateListenerParams updateListenerParams = new UpdateListenerParams();
        updateListenerParams.mBusinessUpdateParams = businessUpdateParams;
        updateListenerParams.mProgress = j3;
        updateListenerParams.mProgressMax = j16;
        updateListenerParams.mProgressRate = i3;
        a16.onProgress(updateListenerParams);
    }

    public void e(long j3, IBusinessCallback iBusinessCallback) {
        iBusinessCallback.getClass();
        this.f384044a.put(Long.valueOf(j3), iBusinessCallback);
    }

    public List<IBusinessCallback> f() {
        ArrayList arrayList = new ArrayList(this.f384044a.size());
        arrayList.addAll(this.f384044a.values());
        return arrayList;
    }

    public <T extends IBusinessCallback> T g(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        IBusinessCallback iBusinessCallback = this.f384045b;
        if (iBusinessCallback != null && iBusinessCallback.getClass() == cls) {
            return (T) this.f384045b;
        }
        for (Map.Entry<Long, IBusinessCallback> entry : this.f384044a.entrySet()) {
            if (entry.getValue() != null) {
                T t16 = (T) entry.getValue();
                if (t16.getClass() == cls) {
                    return t16;
                }
            }
        }
        return null;
    }

    public synchronized void h(IBusinessCallback iBusinessCallback) {
        this.f384045b = iBusinessCallback;
    }
}
