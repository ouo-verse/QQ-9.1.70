package com.tencent.qqlive.module.videoreport.report.bizready;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseBizReadyImp<T> implements IBizReady<T> {
    private static final String TAG = "BaseBizReadyImp";
    private IBizReadyListener<T> mBizReadyListener;
    private final SparseBooleanArray mNotBizReadyMap = new SparseBooleanArray();
    private final SparseArray<T> mExposureInfoMap = new SparseArray<>();

    private void cacheExposureInfo(T t16) {
        if (t16 != null && getTargetObj(t16) != null) {
            this.mExposureInfoMap.put(getTargetObj(t16).hashCode(), t16);
            Log.d(TAG, "cacheExposureInfo() -> exposureInfo=" + t16);
        }
    }

    private void deleteElementFromMap(Object obj) {
        if (obj == null) {
            return;
        }
        this.mNotBizReadyMap.delete(obj.hashCode());
        this.mExposureInfoMap.delete(obj.hashCode());
    }

    private boolean isBizReady(T t16) {
        Object targetObj;
        if (t16 == null || (targetObj = getTargetObj(t16)) == null || this.mNotBizReadyMap.size() == 0 || this.mNotBizReadyMap.indexOfKey(targetObj.hashCode()) < 0) {
            return true;
        }
        return this.mNotBizReadyMap.get(targetObj.hashCode());
    }

    public SparseArray<T> getExposureInfoMap() {
        return this.mExposureInfoMap;
    }

    public List<T> getNotBizReadyList() {
        if (this.mExposureInfoMap.size() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mNotBizReadyMap.size(); i3++) {
            if (!this.mNotBizReadyMap.valueAt(i3)) {
                arrayList.add(Integer.valueOf(this.mNotBizReadyMap.keyAt(i3)));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            T t16 = this.mExposureInfoMap.get(((Integer) arrayList.get(i16)).intValue());
            if (t16 != null) {
                arrayList2.add(t16);
            }
        }
        return arrayList2;
    }

    public SparseBooleanArray getNotBizReadyMap() {
        return this.mNotBizReadyMap;
    }

    protected abstract Object getTargetObj(T t16);

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public T handleExposureInfo(T t16) {
        if (isBizReady(t16)) {
            return t16;
        }
        cacheExposureInfo(t16);
        return null;
    }

    protected abstract boolean isTargetObject(Object obj);

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public synchronized void setBizReady(Object obj, boolean z16) {
        if (!isTargetObject(obj)) {
            return;
        }
        if (this.mNotBizReadyMap.indexOfKey(obj.hashCode()) < 0 && z16) {
            return;
        }
        if (this.mNotBizReadyMap.indexOfKey(obj.hashCode()) >= 0 && !this.mNotBizReadyMap.get(obj.hashCode()) && z16) {
            this.mNotBizReadyMap.put(obj.hashCode(), true);
            T t16 = this.mExposureInfoMap.get(obj.hashCode());
            IBizReadyListener<T> iBizReadyListener = this.mBizReadyListener;
            if (iBizReadyListener != null && t16 != null) {
                iBizReadyListener.onBizReady(t16);
            }
            deleteElementFromMap(obj);
            return;
        }
        this.mNotBizReadyMap.put(obj.hashCode(), z16);
        Log.d(TAG, "setBizReady() -> isBizReady=" + z16 + ",obj=" + obj);
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public void setOnBizReadyListener(IBizReadyListener<T> iBizReadyListener) {
        this.mBizReadyListener = iBizReadyListener;
    }
}
