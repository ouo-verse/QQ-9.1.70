package com.tencent.mobileqq.timiqqid.net;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/timiqqid/net/c;", "T", "", "data", "", "onSuccess", "(Ljava/lang/Object;)V", "", "code", "", "msg", "onFail", "timi-qqid-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface c<T> {
    void onFail(int code, @Nullable String msg2);

    void onSuccess(T data);
}
