package com.tenpay.sdk.net.callback;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.utils.ThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001d\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tenpay/sdk/net/callback/ThreadCallback;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tenpay/sdk/net/core/result/NetResult;", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "threadType", "Lcom/tenpay/sdk/net/callback/CallbackThreadEnum;", "callback", "(Lcom/tenpay/sdk/net/callback/CallbackThreadEnum;Lcom/tenpay/sdk/net/core/callback/NetCallback;)V", "callOnThread", "", "runnable", "Ljava/lang/Runnable;", "onNetFailed", "url", "", "result", "(Ljava/lang/String;Lcom/tenpay/sdk/net/core/result/NetResult;)V", "onNetSucceed", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ThreadCallback<R extends NetResult> implements NetCallback<R> {

    @Nullable
    private final NetCallback<R> callback;

    @NotNull
    private final CallbackThreadEnum threadType;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallbackThreadEnum.values().length];
            try {
                iArr[CallbackThreadEnum.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CallbackThreadEnum.SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ThreadCallback(@NotNull CallbackThreadEnum threadType, @Nullable NetCallback<R> netCallback) {
        Intrinsics.checkNotNullParameter(threadType, "threadType");
        this.threadType = threadType;
        this.callback = netCallback;
    }

    private final void callOnThread(CallbackThreadEnum threadType, Runnable runnable) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[threadType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                ThreadUtils.INSTANCE.runOnSubThread(runnable);
                return;
            }
            return;
        }
        ThreadUtils.INSTANCE.runOnUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNetFailed$lambda$1(ThreadCallback this$0, String url, NetResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.callback.onNetFailed(url, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNetSucceed$lambda$0(ThreadCallback this$0, String url, NetResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.callback.onNetSucceed(url, result);
    }

    @Override // com.tenpay.sdk.net.core.callback.NetCallback
    public void onNetFailed(@NotNull final String url, @NotNull final R result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.callback == null) {
            return;
        }
        callOnThread(this.threadType, new Runnable() { // from class: com.tenpay.sdk.net.callback.b
            @Override // java.lang.Runnable
            public final void run() {
                ThreadCallback.onNetFailed$lambda$1(ThreadCallback.this, url, result);
            }
        });
    }

    @Override // com.tenpay.sdk.net.core.callback.NetCallback
    public void onNetSucceed(@NotNull final String url, @NotNull final R result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.callback == null) {
            return;
        }
        callOnThread(this.threadType, new Runnable() { // from class: com.tenpay.sdk.net.callback.a
            @Override // java.lang.Runnable
            public final void run() {
                ThreadCallback.onNetSucceed$lambda$0(ThreadCallback.this, url, result);
            }
        });
    }
}
