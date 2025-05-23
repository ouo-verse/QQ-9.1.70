package com.tencent.mtt.supportui.adapters.image;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface IImageRequestListener<T> {
    void onRequestFail(Throwable th5, String str);

    void onRequestStart(T t16);

    void onRequestSuccess(T t16);
}
