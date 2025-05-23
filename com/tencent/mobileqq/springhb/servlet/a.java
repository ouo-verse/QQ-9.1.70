package com.tencent.mobileqq.springhb.servlet;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/springhb/servlet/a;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Rsp", "", "rsp", "", "onSuccess", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "", "errMsg", "onFail", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@MainThread
/* loaded from: classes18.dex */
public interface a<Rsp extends MessageMicro<Rsp>> {
    void onFail(@NotNull String errMsg);

    void onSuccess(@NotNull Rsp rsp);
}
