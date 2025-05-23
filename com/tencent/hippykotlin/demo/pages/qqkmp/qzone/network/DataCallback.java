package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J-\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH&\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "T", "", "onFailure", "", "errorCode", "", "errorMsg", "", "onSuccess", "t", "retCode", "msg", "isFinish", "", "(Ljava/lang/Object;JLjava/lang/String;Z)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public interface DataCallback<T> {
    void onFailure(long errorCode, String errorMsg);

    void onSuccess(T t16, long retCode, String msg2, boolean isFinish);
}
