package com.qzone.reborn.base;

import com.tencent.biz.richframework.part.BaseViewModel;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/qzone/reborn/base/n;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "L1", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class n extends BaseViewModel {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/base/n$a;", "T", "", "t", "", "retCode", "", "msg", "", "isFinish", "", "onSuccess", "(Ljava/lang/Object;JLjava/lang/String;Z)V", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface a<T> {
        void onFailure(long errorCode, String errorMsg);

        void onSuccess(T t16, long retCode, String msg2, boolean isFinish);
    }

    public void L1() {
    }
}
