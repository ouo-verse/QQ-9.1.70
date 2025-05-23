package com.tencent.biz.richframework.delegate;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ISoLoadDelegate {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnLoadListener {
        void onLoadResult(boolean z16);
    }

    void load(String str, OnLoadListener onLoadListener);
}
