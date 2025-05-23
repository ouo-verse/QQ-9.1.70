package com.tenpay.sdk.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tenpay/sdk/util/OnGetResultOnMainThread;", "Lcom/tenpay/sdk/util/OnGetResult;", "()V", "getResult", "", "obj", "", "getResultOnMainThread", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public abstract class OnGetResultOnMainThread implements OnGetResult {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void getResult$lambda$0(OnGetResultOnMainThread this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getResultOnMainThread(obj);
    }

    @Override // com.tenpay.sdk.util.OnGetResult
    public void getResult(@Nullable final Object obj) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tenpay.sdk.util.h
            @Override // java.lang.Runnable
            public final void run() {
                OnGetResultOnMainThread.getResult$lambda$0(OnGetResultOnMainThread.this, obj);
            }
        });
    }

    public abstract void getResultOnMainThread(@Nullable Object obj);
}
