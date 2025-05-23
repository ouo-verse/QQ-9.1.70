package com.heytap.databaseengine.apiv2.health.business;

/* loaded from: classes2.dex */
public class ParamPack<T> {
    private boolean mSingleData = false;
    private T mUserParams;

    public ParamPack(T t16) {
        this.mUserParams = t16;
    }

    public T getUserParams() {
        return this.mUserParams;
    }

    public boolean isSingleData() {
        return this.mSingleData;
    }

    public void setSingleData(boolean z16) {
        this.mSingleData = z16;
    }
}
