package com.tencent.mobileqq.zootopia.view;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/a;", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "", "response", "", "onSuccess", "", "errorCode", "errorMessage", "onFailed", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class a implements com.tencent.mobileqq.zootopia.ipc.ah {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "DefaultZootopiaRemoteCallback";

    @Override // com.tencent.mobileqq.zootopia.ipc.ah
    public void onFailed(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        QLog.d(this.TAG, 1, "onSuccess, errorCode: " + errorCode + ", errorMessage: " + errorMessage);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ah
    public void onSuccess(String response) {
        Intrinsics.checkNotNullParameter(response, "response");
        QLog.d(this.TAG, 1, "onSuccess, response: " + response);
    }
}
